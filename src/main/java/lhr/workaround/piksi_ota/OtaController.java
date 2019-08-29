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