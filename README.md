# Simple Piksi OTA Server

The OTA client on the Piksi/Duro is very simple.  It sends an HTTP request via
cURL to the URL provided in the `ota.url` setting to determine if it should upgrade.

If the OTA feature was just enabled, it will check the URL in `ota.url` within
30 seconds.  Otherwise it will check every hour (plus or minus some jitter).

OTA server is an unrelesed feature... so in 2.3.17 there are some bugs with enabling
the feature.  In order to enable it, the following sequence should be respected.

- Configure `ota.enable` to false
- Configure `ota.url` to the desired server
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
