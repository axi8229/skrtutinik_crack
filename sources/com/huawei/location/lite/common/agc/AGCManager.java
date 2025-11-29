package com.huawei.location.lite.common.agc;

import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.security.LocationSecurityManager;
import com.huawei.location.lite.common.util.PreferencesHelper;

/* loaded from: classes3.dex */
public class AGCManager {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static volatile AGCManager instance;
    private volatile yn mAgcInfo;
    private com.huawei.location.lite.common.agc.net.yn mOnlineAgcService;
    private final PreferencesHelper preferencesHelper = new PreferencesHelper("AGCInfo");

    private AGCManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.location.lite.common.agc.yn asyncGetAgcInfo() {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.agc.AGCManager.asyncGetAgcInfo():com.huawei.location.lite.common.agc.yn");
    }

    public static AGCManager getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new AGCManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public synchronized boolean checkAgc() {
        return getInstance().getAgcInfo() != null;
    }

    public synchronized yn getAgcInfo() {
        if (this.mAgcInfo != null && System.currentTimeMillis() <= this.mAgcInfo.yn()) {
            LogLocation.i("AGCManager", "use cache agcInfo");
            return this.mAgcInfo;
        }
        this.mAgcInfo = asyncGetAgcInfo();
        if (this.mAgcInfo != null) {
            LogLocation.i("AGCManager", "use agcInfo from online");
            return this.mAgcInfo;
        }
        long j = this.preferencesHelper.getLong("ExpireTime");
        String string = this.preferencesHelper.getString("Token");
        if (System.currentTimeMillis() > j || TextUtils.isEmpty(string)) {
            return null;
        }
        LogLocation.i("AGCManager", "use agcInfo from sp");
        LocationSecurityManager locationSecurityManager = new LocationSecurityManager(3);
        this.mAgcInfo = new yn();
        this.mAgcInfo.yn(locationSecurityManager.decrypt(string, "AGC_INFO"));
        this.mAgcInfo.yn(j);
        return this.mAgcInfo;
    }

    public String getAppId() {
        try {
            AGConnectServicesConfig aGConnectServicesConfigFromContext = AGConnectServicesConfig.fromContext(ContextUtil.getContext());
            return TextUtils.isEmpty(aGConnectServicesConfigFromContext.getString("client/app_id")) ? "" : aGConnectServicesConfigFromContext.getString("client/app_id");
        } catch (Exception unused) {
            LogLocation.e("AGCManager", "get agc appId by exception");
            return "";
        }
    }

    public synchronized void notifyAkChange() {
        this.mAgcInfo = null;
    }

    public synchronized void setAgcCache(yn ynVar) {
        this.mAgcInfo = ynVar;
        this.preferencesHelper.saveString("Token", new LocationSecurityManager(3).encrypt(ynVar.Vw(), "AGC_INFO"));
        this.preferencesHelper.saveLong("ExpireTime", ynVar.yn());
    }
}
