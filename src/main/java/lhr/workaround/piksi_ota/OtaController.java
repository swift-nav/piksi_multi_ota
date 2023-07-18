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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class OtaController {

    Logger logger = LoggerFactory.getLogger(OtaController.class);
    
    @RequestMapping("/ota")
    public OtaResource ota(@RequestHeader(value = "Device-Uid", required = false) String deviceUuid,
                           @RequestHeader(value = "Current-Version", required = false) String currentVersion)
    {
        logger.info("OTA request: Device-Uid = {}, Current-Version = {}",
                    deviceUuid, currentVersion);

        return new OtaResource();
    }
}
