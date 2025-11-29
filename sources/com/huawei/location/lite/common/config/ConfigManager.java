package com.huawei.location.lite.common.config;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.security.LocationSecurityManager;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigManager {
    private HashMap<String, String> configCache;
    private long firstRequestFailedTime;
    private AtomicInteger requestFailedCount;

    private static class Vw {
        private static final ConfigManager yn = new ConfigManager(null);
    }

    class yn extends TypeToken<HashMap<String, String>> {
        yn(ConfigManager configManager) {
        }
    }

    private ConfigManager() {
        this.requestFailedCount = new AtomicInteger(0);
    }

    /* synthetic */ ConfigManager(yn ynVar) {
        this();
    }

    private boolean checkCacheExpired(PreferencesHelper preferencesHelper) {
        long j = preferencesHelper.getLong("KEY_CACHE_TIME");
        return j == -1 || System.currentTimeMillis() > j + 86400000;
    }

    private void checkConfigData() {
        PreferencesHelper preferencesHelper = new PreferencesHelper("com.huawei.hms.location.config");
        if (checkCacheExpired(preferencesHelper)) {
            this.configCache = null;
        } else {
            loadConfigCache(preferencesHelper);
            if (this.configCache != null) {
                return;
            } else {
                LogLocation.e("ConfigManager", "load cache config fail ,reload config from network");
            }
        }
        requestConfigSync();
    }

    public static ConfigManager getInstance() {
        return Vw.yn;
    }

    private void jsonArray2Map(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        this.configCache = new HashMap<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                ConfigResponseItem configResponseItem = (ConfigResponseItem) GsonUtil.getInstance().fromJson(jSONArray.getString(i), ConfigResponseItem.class);
                this.configCache.put(configResponseItem.getItemName(), configResponseItem.getItemValue());
            } catch (JsonSyntaxException unused) {
                LogLocation.e("ConfigManager", "jsonArray2Map failed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$requestConfig$0() throws Exception {
        StringBuilder sb;
        String apiMsg;
        try {
            RequestJsonBody.Builder builderAdd = new RequestJsonBody.Builder().add("groupName", "liteSDK");
            return GsonUtil.getInstance().toJson(((ConfigResponseData) new HttpClientEx().newSubmit(new BaseRequest.Builder("/networklocation/v1/configurations").setHeads(new HeadBuilder(String.valueOf(UUID.randomUUID()))).setBody(builderAdd.build()).build()).execute(ConfigResponseData.class)).getData());
        } catch (OnErrorException e) {
            sb = new StringBuilder();
            sb.append("OnErrorException:code:");
            sb.append(e.getErrorCode().code);
            sb.append(",apiCode:");
            sb.append(e.getApiCode());
            sb.append(",apiMsg:");
            apiMsg = e.getApiMsg();
            sb.append(apiMsg);
            LogLocation.e("ConfigManager", sb.toString());
            return null;
        } catch (OnFailureException e2) {
            sb = new StringBuilder();
            sb.append("OnFailureException:");
            sb.append(e2.getErrorCode().code);
            sb.append(",");
            apiMsg = e2.getErrorCode().msg;
            sb.append(apiMsg);
            LogLocation.e("ConfigManager", sb.toString());
            return null;
        }
    }

    private void loadConfigCache(PreferencesHelper preferencesHelper) {
        String str;
        if (this.configCache != null) {
            return;
        }
        String string = preferencesHelper.getString("KEY_CONFIG_DATA");
        if (TextUtils.isEmpty(string)) {
            str = "load cache config empty";
        } else {
            String strDecrypt = new LocationSecurityManager(3).decrypt(string, "LOCATION_LITE_SDK");
            if (!TextUtils.isEmpty(strDecrypt)) {
                try {
                    this.configCache = (HashMap) GsonUtil.getInstance().fromJson(strDecrypt, new yn(this).getType());
                    return;
                } catch (JsonSyntaxException unused) {
                    LogLocation.e("ConfigManager", "load config jsonSyntax failed");
                    return;
                }
            }
            str = "load config decrypt failed";
        }
        LogLocation.e("ConfigManager", str);
    }

    private String requestConfig() {
        String str;
        FutureTask futureTask = new FutureTask(new Callable() { // from class: com.huawei.location.lite.common.config.ConfigManager$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConfigManager.lambda$requestConfig$0();
            }
        });
        ExecutorUtil.getInstance().execute(futureTask);
        try {
            return (String) futureTask.get(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            str = "task get response failed by interrupt";
            LogLocation.e("ConfigManager", str);
            return null;
        } catch (ExecutionException unused2) {
            str = "task get response failed by execution";
            LogLocation.e("ConfigManager", str);
            return null;
        } catch (TimeoutException unused3) {
            futureTask.cancel(true);
            str = "task get response failed by timeOut";
            LogLocation.e("ConfigManager", str);
            return null;
        }
    }

    private void save2Storage(String str) {
        String strEncrypt = new LocationSecurityManager(3).encrypt(str, "LOCATION_LITE_SDK");
        if (TextUtils.isEmpty(strEncrypt)) {
            LogLocation.e("ConfigManager", "save config to storage fail");
            return;
        }
        PreferencesHelper preferencesHelper = new PreferencesHelper("com.huawei.hms.location.config");
        preferencesHelper.saveString("KEY_CONFIG_DATA", strEncrypt);
        preferencesHelper.saveLong("KEY_CACHE_TIME", System.currentTimeMillis());
        LogLocation.i("ConfigManager", "save config to storage end");
    }

    public synchronized <T extends ConfigBaseResponse> T getConfig(String str, Class<T> cls) {
        LogLocation.i("ConfigManager", Thread.currentThread().getName() + ",request itemName:" + str);
        checkConfigData();
        HashMap<String, String> map = this.configCache;
        if (map == null) {
            return null;
        }
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return (T) GsonUtil.getInstance().fromJson(str2, (Class) cls);
        } catch (JsonSyntaxException unused) {
            LogLocation.e("ConfigManager", "getConfig failed");
            return null;
        }
    }

    public synchronized String getConfig(String str) {
        LogLocation.i("ConfigManager", Thread.currentThread().getName() + ",request itemName:" + str);
        checkConfigData();
        HashMap<String, String> map = this.configCache;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized String getConfig(String str, String str2) {
        checkConfigData();
        HashMap<String, String> map = this.configCache;
        String strValueOf = null;
        if (map == null) {
            return null;
        }
        String str3 = map.get(str);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            strValueOf = String.valueOf(new JSONObject(str3).get(str2));
        } catch (JSONException unused) {
            LogLocation.e("ConfigManager", "json parse failed");
        }
        LogLocation.d("ConfigManager", "key=" + str2 + ",value=" + strValueOf);
        return strValueOf;
    }

    public synchronized void requestConfigSync() {
        LogLocation.d("ConfigManager", "requestConfigSync start");
        if (System.currentTimeMillis() - this.firstRequestFailedTime < 3600000 && this.requestFailedCount.get() >= 3) {
            LogLocation.d("ConfigManager", "requestConfigSync failed max count");
            return;
        }
        if (this.requestFailedCount.get() == 3) {
            this.requestFailedCount.set(0);
        }
        if (this.configCache != null) {
            LogLocation.e("ConfigManager", "configCache is init");
            return;
        }
        try {
            String strRequestConfig = requestConfig();
            if (!TextUtils.isEmpty(strRequestConfig)) {
                jsonArray2Map(strRequestConfig);
                save2Storage(GsonUtil.getInstance().toJson(this.configCache));
                this.requestFailedCount.set(0);
                this.firstRequestFailedTime = 0L;
            } else if (this.requestFailedCount.incrementAndGet() == 1) {
                this.firstRequestFailedTime = System.currentTimeMillis();
            }
        } catch (JSONException unused) {
            LogLocation.e("ConfigManager", "JSONException");
            this.requestFailedCount.incrementAndGet();
            if (this.firstRequestFailedTime == 0) {
                this.firstRequestFailedTime = System.currentTimeMillis();
            }
        }
    }
}
