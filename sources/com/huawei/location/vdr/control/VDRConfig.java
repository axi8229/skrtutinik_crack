package com.huawei.location.vdr.control;

import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class VDRConfig {
    private ConfigEntity yn = null;

    private static class ConfigEntity extends ConfigBaseResponse {

        @SerializedName("VDR_SWITCH")
        private boolean vdrSwitch = false;

        @SerializedName("MIN_SPEED")
        private int minSpeed = 3;

        @SerializedName("PACKAGE_LIST")
        private List<String> packageList = new ArrayList();

        @SerializedName("DEVICE_LIST")
        private List<String> deviceList = new ArrayList();

        private ConfigEntity() {
        }

        public String toString() {
            return "ConfigEntity{vdrSwitch=" + this.vdrSwitch + ", PACKAGE_LIST=" + this.packageList.toString() + '}';
        }
    }

    void Vw() {
        LogLocation.i("VDRConfig", "init vdr config");
        this.yn = (ConfigEntity) ConfigManager.getInstance().getConfig("vdr", ConfigEntity.class);
    }

    boolean yn() {
        if (this.yn == null) {
            LogLocation.i("VDRConfig", "init vdr config");
            this.yn = (ConfigEntity) ConfigManager.getInstance().getConfig("vdr", ConfigEntity.class);
            StringBuilder sb = new StringBuilder();
            sb.append("get config failed, configEntity is Empty, get again not null:");
            sb.append(this.yn != null);
            LogLocation.w("VDRConfig", sb.toString());
        }
        return this.yn != null;
    }

    boolean yn(int i) {
        LogLocation.i("VDRConfig", "checkSpeed :" + i);
        return i > this.yn.minSpeed;
    }

    boolean yn(String str) {
        Iterator it = this.yn.packageList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return true;
            }
        }
        LogLocation.w("VDRConfig", "checkPackage not support:" + str);
        return false;
    }

    boolean yn(String str, String str2) {
        String str3 = str + "_" + str2;
        Iterator it = this.yn.deviceList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str3)) {
                return true;
            }
        }
        LogLocation.w("VDRConfig", "checkDevice not support :" + str3);
        return false;
    }
}
