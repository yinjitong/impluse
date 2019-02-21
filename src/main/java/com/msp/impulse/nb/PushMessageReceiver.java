package com.msp.impulse.nb;

import com.iotplatform.client.dto.*;
import com.iotplatform.utils.JsonUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class PushMessageReceiver {
    private final String callbackurl = "/v1.0.0/messageReceiver";
    private final String callbackurl_nbcmd = "/v1.0.0/messageReceiver/cmd";

    public PushMessageReceiver() {
    }

    @RequestMapping(
        value = {"/v1.0.0/messageReceiver"},
        method = {RequestMethod.POST}
    )
    @ResponseBody
    public String receive(@RequestBody String body) throws Exception {
        this.handleBody(body);
        System.out.println(body);
        if (body.contains("\"notifyType\":\"deviceAdded\"")) {
            this.handleDeviceAdded((NotifyDeviceAddedDTO) JsonUtil.jsonString2SimpleObj(body, NotifyDeviceAddedDTO.class));
        }

        if (body.contains("\"notifyType\":\"bindDevice\"")) {
            this.handleBindDevice((NotifyBindDeviceDTO)JsonUtil.jsonString2SimpleObj(body, NotifyBindDeviceDTO.class));
        }

        if (body.contains("\"notifyType\":\"deviceInfoChanged\"")) {
            this.handleDeviceInfoChanged((NotifyDeviceInfoChangedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyDeviceInfoChangedDTO.class));
        }

        if (body.contains("\"notifyType\":\"deviceDataChanged\"")) {
            this.handleDeviceDataChanged((NotifyDeviceDataChangedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyDeviceDataChangedDTO.class));
        }

        if (body.contains("\"notifyType\":\"deviceDatasChanged\"")) {
            this.handleDeviceDatasChanged((NotifyDeviceDatasChangedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyDeviceDatasChangedDTO.class));
        }

        if (body.contains("\"notifyType\":\"serviceInfoChanged\"")) {
            this.handleServiceInfoChanged((NotifyServiceInfoChangedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyServiceInfoChangedDTO.class));
        }

        if (body.contains("\"notifyType\":\"deviceDeleted\"")) {
            this.handleDeviceDeleted((NotifyDeviceDeletedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyDeviceDeletedDTO.class));
        }

        if (body.contains("\"notifyType\":\"messageConfirm\"")) {
            this.handleMessageConfirm((NotifyMessageConfirmDTO)JsonUtil.jsonString2SimpleObj(body, NotifyMessageConfirmDTO.class));
        }

        if (body.contains("\"notifyType\":\"commandRsp\"")) {
            this.handleCommandRsp((NotifyCommandRspDTO)JsonUtil.jsonString2SimpleObj(body, NotifyCommandRspDTO.class));
        }

        if (body.contains("\"notifyType\":\"deviceEvent\"")) {
            this.handleDeviceEvent((NotifyDeviceEventDTO)JsonUtil.jsonString2SimpleObj(body, NotifyDeviceEventDTO.class));
        }

        if (body.contains("\"notifyType\":\"deviceModelAdded\"")) {
            this.handleDeviceModelAdded((NotifyDeviceModelAddedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyDeviceModelAddedDTO.class));
        }

        if (body.contains("\"notifyType\":\"deviceModelDeleted\"")) {
            this.handleDeviceModelDeleted((NotifyDeviceModelDeletedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyDeviceModelDeletedDTO.class));
        }

        if (body.contains("\"notifyType\":\"ruleEvent\"")) {
            this.handleRuleEvent((NotifyRuleEventDTO)JsonUtil.jsonString2SimpleObj(body, NotifyRuleEventDTO.class));
        }

        if (body.contains("\"notifyType\":\"deviceDesiredPropertiesModifyStatusChanged\"")) {
            this.handleDeviceDesiredStatusChanged((NotifyDeviceDesiredStatusChangedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyDeviceDesiredStatusChangedDTO.class));
        }

        if (body.contains("\"notifyType\":\"swUpgradeStateChangeNotify\"")) {
            this.handleSwUpgradeStateChanged((NotifySwUpgradeStateChangedDTO)JsonUtil.jsonString2SimpleObj(body, NotifySwUpgradeStateChangedDTO.class));
        }

        if (body.contains("\"notifyType\":\"swUpgradeResultNotify\"")) {
            this.handleSwUpgradeResult((NotifySwUpgradeResultDTO)JsonUtil.jsonString2SimpleObj(body, NotifySwUpgradeResultDTO.class));
        }

        if (body.contains("\"notifyType\":\"fwUpgradeStateChangeNotify\"")) {
            this.handleFwUpgradeStateChanged((NotifyFwUpgradeStateChangedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyFwUpgradeStateChangedDTO.class));
        }

        if (body.contains("\"notifyType\":\"fwUpgradeResultNotify\"")) {
            this.handleFwUpgradeResult((NotifyFwUpgradeResultDTO)JsonUtil.jsonString2SimpleObj(body, NotifyFwUpgradeResultDTO.class));
        }

        return "ok";
    }

    @RequestMapping(
        value = {"/v1.0.0/messageReceiver/cmd"},
        method = {RequestMethod.POST}
    )
    @ResponseBody
    public String receiveCmdResult(@RequestBody String body) throws Exception {
        this.handleBody(body);
        this.handleNBCommandStateChanged((NotifyNBCommandStatusChangedDTO)JsonUtil.jsonString2SimpleObj(body, NotifyNBCommandStatusChangedDTO.class));
        return "ok";
    }

    public void handleBody(String body) {
    }

    public void handleDeviceAdded(NotifyDeviceAddedDTO body) {
        System.out.println("deviceAdded ==> " + body);
        //TODO deal with deviceAdded notification
    }

    public void handleBindDevice(NotifyBindDeviceDTO body) {
        System.out.println("bindDevice ==> " + body);
        //TODO deal with BindDevice notification
    }

    public void handleDeviceInfoChanged(NotifyDeviceInfoChangedDTO body) {
        System.out.println("deviceInfoChanged ==> " + body);
        //TODO deal with DeviceInfoChanged notification
    }

    public void handleDeviceDataChanged(NotifyDeviceDataChangedDTO body) {
        System.out.println("deviceDataChanged ==> " + body);
    }

    public void handleDeviceDatasChanged(NotifyDeviceDatasChangedDTO body) {
        System.out.println("deviceDatasChanged ==> " + body);
    }

    public void handleServiceInfoChanged(NotifyServiceInfoChangedDTO body) {
        System.out.println("serviceInfoChanged ==> " + body);
    }

    public void handleDeviceDeleted(NotifyDeviceDeletedDTO body) {
        System.out.println("deviceDeleted ==> " + body);
    }

    public void handleMessageConfirm(NotifyMessageConfirmDTO body) {
        System.out.println("messageConfirm ==> " + body);
    }

    public void handleCommandRsp(NotifyCommandRspDTO body) {
        System.out.println("commandRsp ==> " + body);
    }

    public void handleDeviceEvent(NotifyDeviceEventDTO body) {
        System.out.println("deviceEvent ==> " + body);
    }

    public void handleDeviceModelAdded(NotifyDeviceModelAddedDTO body) {
        System.out.println("deviceModelAdded ==> " + body);
    }

    public void handleDeviceModelDeleted(NotifyDeviceModelDeletedDTO body) {
        System.out.println("deviceModelDeleted ==> " + body);
    }

    public void handleRuleEvent(NotifyRuleEventDTO body) {
        System.out.println("ruleEvent ==> " + body);
    }

    public void handleDeviceDesiredStatusChanged(NotifyDeviceDesiredStatusChangedDTO body) {
        System.out.println("deviceDesiredStatusChanged ==> " + body);
    }

    public void handleSwUpgradeStateChanged(NotifySwUpgradeStateChangedDTO body) {
        System.out.println("swUpgradeStateChanged ==> " + body);
    }

    public void handleSwUpgradeResult(NotifySwUpgradeResultDTO body) {
        System.out.println("swUpgradeResult ==> " + body);
    }

    public void handleFwUpgradeStateChanged(NotifyFwUpgradeStateChangedDTO body) {
        System.out.println("fwUpgradeStateChanged ==> " + body);
    }


    public void handleFwUpgradeResult(NotifyFwUpgradeResultDTO body) {
        System.out.println("fwUpgradeResult ==> " + body);
    }

    public void handleNBCommandStateChanged(NotifyNBCommandStatusChangedDTO body) {
        System.out.println("NBCommandStateChanged ==> " + body);
    }

}
