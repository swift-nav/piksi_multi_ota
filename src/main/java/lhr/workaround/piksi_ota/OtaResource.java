/*
 * Copyright (C) 2019-2023 Swift Navigation Inc.
 * Contact: https://support.swiftnav.com
 *
 * This source is subject to the license found in the file 'LICENSE' which must
 * be be distributed together with this source. All other rights reserved.
 *
 * THIS CODE AND INFORMATION IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A PARTICULAR PURPOSE.
 */

package lhr.workaround.piksi_ota;

public class OtaResource {

    private final String url;
    private final String version;
    private final String sha256;

    public OtaResource() {
        this.url = "https://www.swiftnav.com/resource-files/Piksi%20Multi/v2.3.19/Firmware/PiksiMulti-v2.3.19.bin";
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
