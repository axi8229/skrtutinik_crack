package com.huawei.location.crowdsourcing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.security.LocationSecurityManager;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes3.dex */
final class Config implements com.huawei.location.crowdsourcing.common.yn {
    private long E5;
    private long FB;
    private long G3;
    private long LW;
    private int Ot;
    private Vw Vw;
    private SharedPreferences.Editor Wf;
    private String Yx;
    private int d2;
    private int dC;
    private String dW;
    private boolean h1;
    private int oc;
    private long ut;
    private Configurations yn;
    private int zp;

    private static class Configurations extends ConfigBaseResponse {

        @SerializedName("GEO_LOCATION_COLLECT_TYPE")
        private int collectType = -1;

        @SerializedName("LOCATION_COLLECT_INTERVAL")
        private long collectInterval = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;

        @SerializedName("LOCATION_DISTANCE_INTERVAL")
        private int collectDistance = 5;

        @SerializedName("LOCATION_UPLOAD_TIME")
        private long uploadInterval = 1800;

        @SerializedName("LOCATION_UPLOAD_NUM")
        private int uploadNumThreshold = 5;

        @SerializedName("WIFI_COLLECT_MAX_NUM")
        private int wifiDailyLimit = 1000;

        @SerializedName("WIFI_AP_COLLCT_MAX_NUM")
        private int wifiApNumLimit = 200;

        @SerializedName("WIFI_SCANRESULT_VALID_INTERVAL")
        private long wifiValidInterval = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;

        @SerializedName("CELL_COLLECT_MAX_NUM")
        private int cellDailyLimit = 1000;

        @SerializedName("CELL_COLLECT_INTERVAL")
        private long cellCollectInterval = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;

        @SerializedName("CELL_SCANRESULT_VALID_INTERVAL")
        private long cellValidInterval = DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;

        @SerializedName("LOCAL_RECORD_FILE_MAX_SIZE")
        private int cacheSizeLimit = 50;

        @SerializedName("LOG_SERVER_KEY")
        private String logServerKey = "";

        @SerializedName("MCC_EXCLUDE_LIST")
        private List<String> excludeMccList = new ArrayList();

        @SerializedName("UPLOAD_PUBLIC_KEY")
        private String uploadPublicKey = "";

        private Configurations() {
        }

        private boolean checkWifiCell() {
            String str;
            if (this.wifiDailyLimit < 0) {
                str = "wifiDailyLimit error";
            } else if (this.wifiApNumLimit < 0) {
                str = "wifiApNumLimit error";
            } else if (this.wifiValidInterval < 0) {
                str = "wifiValidInterval error";
            } else if (this.cellDailyLimit < 0) {
                str = "cellDailyLimit error";
            } else if (this.cellCollectInterval < 0) {
                str = "cellCollectInterval error";
            } else {
                if (this.cellValidInterval >= 0) {
                    return true;
                }
                str = "cellValidInterval error";
            }
            LogLocation.d("Config", str);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean valid() {
            String str;
            int i = this.collectType;
            if (i < -1 || i > 2) {
                str = "collectType error";
            } else if (this.collectInterval < 0 || this.collectDistance < 0) {
                str = "collectInterval or collectDistance error";
            } else if (this.uploadInterval < 0 || this.uploadNumThreshold < 0) {
                str = "uploadInterval or uploadNumThreshold error";
            } else {
                if (!checkWifiCell()) {
                    return false;
                }
                if (this.cacheSizeLimit < 0) {
                    str = "cacheSizeLimit error";
                } else if (this.logServerKey.isEmpty()) {
                    str = "logServer error";
                } else {
                    if (!TextUtils.isEmpty(this.uploadPublicKey)) {
                        return true;
                    }
                    str = "public key config error";
                }
            }
            LogLocation.d("Config", str);
            return false;
        }

        public String toString() {
            return "Configurations{collectType=" + this.collectType + ", collectInterval=" + this.collectInterval + ", collectDistance=" + this.collectDistance + ", uploadInterval=" + this.uploadInterval + ", uploadNumThreshold=" + this.uploadNumThreshold + ", wifiDailyLimit=" + this.wifiDailyLimit + ", wifiApNumLimit=" + this.wifiApNumLimit + ", wifiValidInterval=" + this.wifiValidInterval + ", cellDailyLimit=" + this.cellDailyLimit + ", cellCollectInterval=" + this.cellCollectInterval + ", cellValidInterval=" + this.cellValidInterval + ", cacheSizeLimit=" + this.cacheSizeLimit + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class FB {
        private static final Config yn = new Config();
    }

    private class LW extends Handler {
        LW(Looper looper) {
            super(looper);
        }

        private void yn() {
            long jYn = Config.yn(Config.this) + DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
            LogLocation.i("Config", String.format(Locale.ENGLISH, "reset need wait %dms", Long.valueOf(jYn)));
            sendEmptyMessageDelayed(0, jYn);
        }

        void Vw() {
            yn();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                yn();
                return;
            }
            LogLocation.e("Config", "unknown msg:" + message.what);
        }
    }

    private enum Vw {
        CLOSE,
        OPEN,
        WIFI,
        CELL
    }

    private Config() {
        this.Vw = Vw.CLOSE;
        this.d2 = 0;
        this.zp = 0;
        this.ut = 0L;
        this.G3 = 0L;
        this.Yx = "";
        this.h1 = false;
        this.dW = "";
    }

    private static String LW() {
        LocationSecurityManager locationSecurityManager = new LocationSecurityManager(3);
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(32);
        String strEncrypt = locationSecurityManager.encrypt(strGenerateSecureRandomStr, "RECORD_CROWD");
        String strEncrypt2 = locationSecurityManager.encrypt(SHA.sha256Encrypt(strEncrypt), "RECORD_CROWD");
        new PreferencesHelper("crowdsourcing_config").saveString("sp_random_key", strEncrypt + ":" + strEncrypt2);
        return strGenerateSecureRandomStr;
    }

    static String oc() {
        LocationSecurityManager locationSecurityManager = new LocationSecurityManager(3);
        String string = new PreferencesHelper("crowdsourcing_config").getString("sp_random_key");
        if (string != null) {
            String[] strArrSplit = string.split(":");
            if (strArrSplit.length != 2) {
                return LW();
            }
            if (!TextUtils.isEmpty(strArrSplit[0]) && SHA.validateSHA256(strArrSplit[0], locationSecurityManager.decrypt(strArrSplit[1], "RECORD_CROWD"))) {
                return locationSecurityManager.decrypt(strArrSplit[0], "RECORD_CROWD");
            }
        }
        return LW();
    }

    static long yn(Config config) {
        config.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - config.ut) > 86400000) {
            LogLocation.i("Config", "checkReset reset");
            config.ut = jCurrentTimeMillis;
            config.Wf.putLong("RESET_TIMESTAMP", jCurrentTimeMillis).apply();
            LogLocation.i("Config", "reset Counters");
            config.d2 = 0;
            config.zp = 0;
            config.Wf.putInt("WIFI_NUM", 0).putInt("CELL_NUM", config.zp).apply();
        }
        return (config.ut + 86400000) - jCurrentTimeMillis;
    }

    long E5() {
        return this.yn.cellCollectInterval;
    }

    long EF() {
        return this.yn.wifiValidInterval;
    }

    boolean Eu() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = Math.abs(jCurrentTimeMillis - this.G3) >= (this.FB << this.oc);
        if (z) {
            this.G3 = jCurrentTimeMillis;
            this.Wf.putLong("UPLOAD_TIMESTAMP", jCurrentTimeMillis).apply();
        }
        return z;
    }

    void FB() {
        int i = this.d2 + 1;
        this.d2 = i;
        this.Wf.putInt("WIFI_NUM", i).apply();
    }

    String G3() {
        return this.dW;
    }

    long OB() {
        return this.E5;
    }

    String Ot() {
        return this.yn.logServerKey;
    }

    boolean SI() {
        return this.Vw == Vw.CLOSE;
    }

    void Vw() {
        int i = this.zp + 1;
        this.zp = i;
        this.Wf.putInt("CELL_NUM", i).apply();
    }

    void Vw(String str) {
        this.Wf.putString("PATCH_POLICY", str).apply();
    }

    int Wf() {
        return this.yn.wifiApNumLimit;
    }

    String Yx() {
        return this.Yx;
    }

    boolean a6() {
        Vw vw = this.Vw;
        return (vw == Vw.CLOSE || vw == Vw.CELL || this.d2 >= this.yn.wifiDailyLimit) ? false : true;
    }

    long d2() {
        return this.LW;
    }

    int dC() {
        return this.dC;
    }

    String dW() {
        return this.yn.uploadPublicKey;
    }

    int h1() {
        return this.yn.uploadNumThreshold;
    }

    void kN() {
        int i = this.oc;
        int i2 = this.Ot;
        if (i != i2) {
            if (i < i2) {
                this.oc = i + 1;
            } else {
                this.oc = i2;
            }
            this.Wf.putInt("CONTINUOUS_UPLOAD_FAIL_NUM", this.oc).apply();
        }
        LogLocation.i("Config", "continuous upload failed num:" + this.oc);
    }

    void lS() {
        if (this.oc == 0) {
            return;
        }
        this.oc = 0;
        this.Wf.putInt("CONTINUOUS_UPLOAD_FAIL_NUM", 0).apply();
    }

    boolean t6() {
        Vw vw = this.Vw;
        return (vw == Vw.CLOSE || vw == Vw.WIFI || this.zp >= this.yn.cellDailyLimit) ? false : true;
    }

    long ut() {
        return this.yn.collectInterval;
    }

    @Override // com.huawei.location.crowdsourcing.common.yn
    public void yn() {
        LogLocation.w("Config", "Stop");
    }

    boolean yn(String str) {
        boolean z;
        if (str.isEmpty()) {
            LogLocation.d("Config", "no mcc, use last mcc result:" + this.h1);
        } else {
            Iterator it = this.yn.excludeMccList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (str.equals((String) it.next())) {
                    z = false;
                    break;
                }
            }
            if (this.h1 != z) {
                this.h1 = z;
                this.Wf.putBoolean("MCC_CHECK_RESULT", z);
                this.Wf.apply();
            }
            LogLocation.i("Config", "got mcc, check result:" + this.h1);
        }
        return this.h1;
    }

    int zp() {
        return this.yn.collectDistance;
    }

    boolean yn(Context context, Looper looper) {
        Vw vw;
        Configurations configurations = (Configurations) ConfigManager.getInstance().getConfig("crowdsourcing", Configurations.class);
        this.yn = configurations;
        if (configurations == null) {
            LogLocation.e("Config", "failed to get config");
            return false;
        }
        if (!configurations.valid()) {
            LogLocation.e("Config", "config not valid");
            return false;
        }
        LogLocation.d("Config", "configurations:" + this.yn.toString());
        this.FB = this.yn.uploadInterval * 1000;
        this.dC = this.yn.cacheSizeLimit * 1048576;
        this.LW = this.yn.cellValidInterval * 1000000;
        this.E5 = this.yn.wifiValidInterval * 1000;
        int i = this.yn.collectType;
        if (i == 0) {
            vw = Vw.OPEN;
        } else {
            vw = i == 1 ? Vw.WIFI : i == 2 ? Vw.CELL : Vw.CLOSE;
        }
        this.Vw = vw;
        long j = this.FB;
        if (j == 0) {
            this.Ot = 0;
        } else {
            this.Ot = (int) (Math.log(1.728E8d / j) / Math.log(2.0d));
        }
        LogLocation.i("Config", "upload fail max num:" + this.Ot);
        SharedPreferences sharedPreferences = context.createDeviceProtectedStorageContext().getSharedPreferences("crowdsourcing_config", 0);
        if (sharedPreferences == null) {
            LogLocation.e("Config", "create sharedPreferences failed");
            return false;
        }
        this.d2 = sharedPreferences.getInt("WIFI_NUM", 0);
        this.zp = sharedPreferences.getInt("CELL_NUM", 0);
        this.ut = sharedPreferences.getLong("RESET_TIMESTAMP", 0L);
        this.G3 = sharedPreferences.getLong("UPLOAD_TIMESTAMP", 0L);
        this.oc = sharedPreferences.getInt("CONTINUOUS_UPLOAD_FAIL_NUM", 0);
        this.h1 = sharedPreferences.getBoolean("MCC_CHECK_RESULT", false);
        this.dW = sharedPreferences.getString("PATCH_POLICY", "");
        this.Yx = sharedPreferences.getString("SERIAL_NUMBER", "");
        LogLocation.i("Config", String.format(Locale.ENGLISH, "wifiNum:%d, cellNum:%d, resetTimeStamp:%d, uploadTimeStamp:%d, uploadContinuousFailNum:%d", Integer.valueOf(this.d2), Integer.valueOf(this.zp), Long.valueOf(this.ut), Long.valueOf(this.G3), Integer.valueOf(this.oc)));
        this.Wf = sharedPreferences.edit();
        if (this.Yx.isEmpty()) {
            this.Yx = UUID.randomUUID().toString();
            LogLocation.i("Config", "create serial number:" + this.Yx);
            this.Wf.putString("SERIAL_NUMBER", this.Yx);
        }
        this.Wf.apply();
        new LW(looper).Vw();
        return true;
    }
}
