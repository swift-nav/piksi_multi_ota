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
        this.url = "http://downloads.swiftnav.com/piksi_multi/firmware/2023-05-23-v3.0.17/PiksiMulti-v3.0.17.bin";
        this.version = "v3.0.17";
        this.sha256 = "8bcd745899710c05caf5ecede73bb6ec1d77c9e4bc8c20e2b86f7137055821f6";
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
