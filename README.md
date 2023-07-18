# Example Piksi OTA Server

**WARNING**: *The Piksi Multi OTA server is an unsupported feature, the code and
instructions within this repository are for informational purposes only.*

## Building and Running

### Installing Java and Maven

This example server uses the Java language and the Maven build tool.  To install these on Ubuntu Linux, run the following commands:

    sudo apt install default-jdk
    sudo apt install maven

### Bootstrapping Maven

To run the `./mvnw` command below you'll need to first bootstrap maven, this
should only be need once:

    mvn -N io.takari:maven:wrapper

For more info see https://stackoverflow.com/questions/50104172/could-not-find-or-load-main-class-org-apache-maven-wrapper-mavenwrappermain

### Building and running the server

First see "Bootstrapping Maven".  You'll then be able to run the following to verify that the build succeeds:

    ./mvnw compile

Then, run the following command to start the server (again, assuming Maven and Java are installed):

    ./mvnw spring-boot:run

Or, to build the jar file and run that:

    ./mvnw install
    java -jar target/piksi_ota-0.0.1-SNAPSHOT.jar

### Configuring the firmware that's sent

The firmware that's sent is hardcoded for now, to update what firmware the
device will upgrade to, see:

  - https://github.com/swift-nav/piksi_multi_ota/blob/master/src/main/java/lhr/workaround/piksi_ota/OtaResource.java#L10

## Piksi Multi OTA Client

The OTA client on the Piksi/Duro is very simple.  It sends an HTTP request via
cURL to the URL provided in the `ota.url` setting to determine if it should upgrade.

If the OTA feature was just enabled, it will check the URL in `ota.url` within
30 seconds.  Otherwise it will check every hour (plus or minus some jitter).

OTA server is an unrelesed feature... so in 2.3.17 there are some bugs with enabling
the feature.  In order to enable it, the following sequence should be respected.

- Configure `ota.enable` to false
- Configure `ota.url` to the desired server
  - For this example server the URL will be something like `http://192.168.0.11:8080/ota` where `192.168.0.11` is an IP address the Piksi can access
- Confiugre `ota.enable` to true and with 30s the OTA client will reach out to the configured server

The OTA client sends the following data to the server:

- A header: `Device-Uid` which contains the unique device ID of the Duro/Piksi
- Another header: `Current-Version` which contains the current firmware version of the device

The OTA server will provide back a JSON structure containing the following fields

- `url`: the URL of the firmware, which will be fetched with cURL
- `version`: the version of the firmware, corresponding to the `url` field
- `sha256`: a SHA256 hash of the firmware

The device will take the following actions to decide when to upgrade:

- Compare `version` from the received JSON blob with it's current version, if
  it's different, upgrade will procede

- Download file specified by `url`

- Compute the hash of the file, and compare against the `sha256` field, if it
  matches then the upgrade will procede

Once the file is downloaded and the hash matches, the usual Duro/Piksi upgrade
process takes place.  The device will reboot once the upgrade completes and the
upgrade server should receive another request within 30s (which should show the
new version in the `Current-Version` header).
