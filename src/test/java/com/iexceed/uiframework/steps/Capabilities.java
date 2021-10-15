package com.iexceed.uiframework.steps;

import com.iexceed.uiframework.DomainObjects.ConnectionObjects;

import java.util.Map;

public class Capabilities {
    ConnectionObjects connectionObjects;
    public Capabilities(){
        connectionObjects = new ConnectionObjects();
    }

    public void setCapabilities(Map<String, String> deviceConfig) throws Exception {
        if (deviceConfig.get("mode").equalsIgnoreCase("pcloudy"))
            connectionObjects.setRemoteDeviceCapabilities(deviceConfig.get("pcloudy_Username"),deviceConfig.get("pcloudy_API"),deviceConfig.get("platform"),deviceConfig.get("version"),deviceConfig.get("deviceName"),deviceConfig.get("automationName"),deviceConfig.get("applicationName"),deviceConfig.get("androidActivity"),deviceConfig.get("androidPackage"),deviceConfig.get("bundleID"),deviceConfig.get("maxDuration"),deviceConfig.get("deviceURL"),deviceConfig.get("orientation"));
        else if (deviceConfig.get("mode").contains("real") || deviceConfig.get("mode").contains("Real") )
            connectionObjects.setRealDeviceCapabilities(deviceConfig.get("platform"),deviceConfig.get("deviceName"),deviceConfig.get("automationName"),deviceConfig.get("applicationName"),deviceConfig.get("androidActivity"),deviceConfig.get("androidPackage"),deviceConfig.get("deviceURL"),deviceConfig.get("noReset"),deviceConfig.get("orientation"));
    }

}
