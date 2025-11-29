package com.huawei.location.sdm;

import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Config {
    private Configurations yn;

    private static class Configurations extends ConfigBaseResponse {

        @SerializedName("EPHEMERIS_VALID_TIME")
        private long ephemerisValidTime = 3600;

        @SerializedName("TILE_DAILY_MAX_NUM")
        private int tileDailyMaxNum = 25;

        @SerializedName("TILE_MAX_NUM")
        private int tileMaxNum = 30;

        @SerializedName("SMOOTH_COUNT_ENTER")
        private int smoothEnter = 3;

        @SerializedName("SMOOTH_COUNT_EXIT")
        private int smoothExit = 10;

        @SerializedName("AR_WALK_SPEED")
        private int arWalkSpeed = 3;

        @SerializedName("DEVICE_LIST")
        private List<String> deviceList = new ArrayList();

        private Configurations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean valid() {
            String str;
            long j = this.ephemerisValidTime;
            if (j > 7200 || j < 600) {
                str = "ephemerisValidTime error";
            } else {
                int i = this.tileDailyMaxNum;
                if (i <= 200 && i >= 0) {
                    return true;
                }
                str = "tileDailyMaxNum error";
            }
            LogLocation.d("Config", str);
            return false;
        }

        public String toString() {
            return "Configurations{ephemerisValidTime=" + this.ephemerisValidTime + ", tileDailyMaxNum=" + this.tileDailyMaxNum + '}';
        }
    }

    boolean E5() {
        String str;
        Configurations configurations = (Configurations) ConfigManager.getInstance().getConfig("sdm", Configurations.class);
        this.yn = configurations;
        if (configurations == null) {
            str = "failed to get config";
        } else {
            if (configurations.valid()) {
                LogLocation.d("Config", "configurations:" + this.yn.toString());
                long unused = this.yn.ephemerisValidTime;
                return true;
            }
            str = "config not valid";
        }
        LogLocation.e("Config", str);
        return false;
    }

    int FB() {
        return this.yn.tileDailyMaxNum;
    }

    int LW() {
        return this.yn.tileMaxNum;
    }

    public int Vw() {
        return this.yn.smoothExit;
    }

    public int dC() {
        return this.yn.arWalkSpeed;
    }

    public int yn() {
        return this.yn.smoothEnter;
    }

    boolean yn(String str, String str2) {
        String str3 = str + "_" + str2;
        Iterator it = this.yn.deviceList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str3)) {
                return true;
            }
        }
        return false;
    }
}
