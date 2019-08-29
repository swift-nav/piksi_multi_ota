package lhr.workaround.piksi_ota;

public class OtaResource {

    private final String url;
    private final String version;
    private final String sha256;

    public OtaResource() {
        this.url = "https://www.swiftnav.com/resource-uploads/Piksi%20Multi/v2.3.19/Firmware/PiksiMulti-v2.3.19.bin";
        this.version = "v2.3.19";
        this.sha256 = "b3a70335971b5badb189a5b038bb785b18f5091642472244db6438398339f253";
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getSha256() {
        return sha256;
    }
}
