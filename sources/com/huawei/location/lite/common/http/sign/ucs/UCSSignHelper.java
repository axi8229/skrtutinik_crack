package com.huawei.location.lite.common.http.sign.ucs;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.location.BuildConfig;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.http.exception.AuthException;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.sign.SignRequest;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.lite.common.util.country.CountryCodeUtil;
import com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.ILogUcs;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSignAlg;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSigner;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class UCSSignHelper {
    private Credential credential;
    private CredentialClient credentialClient;

    private static class GrsCapabilityImpl implements GrsCapability {
        private GrsCapabilityImpl() {
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.GrsCapability
        public String synGetGrsUrl(String str, String str2) {
            LogLocation.d("UCSSignHelper", "GrsCapabilityImpl synGetGrsUrl" + str);
            return LocationNlpGrsHelper.getGrsHostAddress(CountryCodeUtil.getLocationCountryCode(), str, str2);
        }
    }

    private static class HACapabilityImpl implements HACapability {
        private HACapabilityImpl() {
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.HACapability
        public void onEvent(Context context, String str, ReportMsgBuilder reportMsgBuilder) {
            Tracker.getInstance().onEvent(1, str, reportMsgBuilder.build());
        }
    }

    private static class LogUcsImpl implements ILogUcs {
        private LogUcsImpl() {
        }

        @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
        public void d(String str, String str2) {
            LogLocation.d(str, str2);
        }

        @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
        public void e(String str, String str2) {
            LogLocation.e(str, str2);
        }

        @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
        public void i(String str, String str2) {
            LogLocation.i(str, str2);
        }

        @Override // com.huawei.wisesecurity.ucs.common.log.ILogUcs
        public void w(String str, String str2) {
            LogLocation.w(str, str2);
        }
    }

    private static class NetworkCapabilityImpl implements NetworkCapability {
        private NetworkCapabilityImpl() {
        }

        private NetworkResponse execute(Request request) throws IOException {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            try {
                Response responseExecute = builder.callTimeout(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, timeUnit).connectTimeout(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, timeUnit).retryOnConnectionFailure(false).build().newCall(request).execute();
                NetworkResponse networkResponse = new NetworkResponse();
                networkResponse.setCode(responseExecute.code());
                networkResponse.setHeaders(responseExecute.headers().toMultimap());
                if (responseExecute.body() != null) {
                    networkResponse.setBody(responseExecute.body().string());
                }
                return networkResponse;
            } catch (IOException e) {
                LogLocation.e("UCSSignHelper", "UCS http failed by exception");
                throw e;
            }
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
        public NetworkResponse get(NetworkRequest networkRequest) throws IOException {
            LogLocation.d("UCSSignHelper", "NetworkCapabilityImpl ucs http getUrl：" + networkRequest.getUrl());
            return execute(new Request.Builder().url(networkRequest.getUrl()).headers(Headers.of(networkRequest.getHeaders())).build());
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
        public void initConfig(int i, int i2) {
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
        public NetworkResponse post(NetworkRequest networkRequest) throws IOException {
            LogLocation.d("UCSSignHelper", "NetworkCapabilityImpl ucs http postUrl：" + networkRequest.getUrl());
            return execute(new Request.Builder().url(networkRequest.getUrl()).headers(Headers.of(networkRequest.getHeaders())).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), networkRequest.getBody())).build());
        }
    }

    private static class UCSSignHelperHolder {
        private static final UCSSignHelper INSTANCE = new UCSSignHelper();
    }

    private UCSSignHelper() {
    }

    private boolean checkAndInitCredential(Context context) {
        Credential credential = this.credential;
        if (credential != null && !isNeedUpdate(Long.valueOf(credential.getExpireTime()))) {
            return true;
        }
        LogLocation.i("UCSSignHelper", "init credential from sp");
        PreferencesHelper preferencesHelper = new PreferencesHelper("location_credential");
        Credential credentialInitCredentialFromSp = initCredentialFromSp(context, preferencesHelper);
        this.credential = credentialInitCredentialFromSp;
        if (credentialInitCredentialFromSp != null) {
            return true;
        }
        LogLocation.i("UCSSignHelper", "init credential from network");
        Credential credentialInitCredentialFromNetwork = initCredentialFromNetwork(context);
        this.credential = credentialInitCredentialFromNetwork;
        if (credentialInitCredentialFromNetwork == null) {
            return false;
        }
        AGCManager.getInstance().notifyAkChange();
        preferencesHelper.saveLong("credentialExpiredTime", this.credential.getExpireTime());
        preferencesHelper.saveString("credentialCache", this.credential.toString());
        LogLocation.i("UCSSignHelper", "Credential init success, expire time is :" + this.credential.getExpireTime());
        return true;
    }

    public static UCSSignHelper getInstance() {
        return UCSSignHelperHolder.INSTANCE;
    }

    private synchronized Credential initCredentialFromNetwork(Context context) {
        CredentialClient credentialClientBuild;
        try {
            credentialClientBuild = new CredentialClient.Builder().context(context).serCountry(CountryCodeUtil.getLocationCountryCode()).networkRetryTime(1).networkTimeOut(10000).appId(AGCManager.getInstance().getAppId()).grsCapability(new GrsCapabilityImpl()).haCapability(new HACapabilityImpl()).networkCapability(new NetworkCapabilityImpl()).logInstance(new LogUcsImpl()).build();
            this.credentialClient = credentialClientBuild;
        } catch (UcsException e) {
            LogLocation.e("UCSSignHelper", "init credential form network failed :" + e.getErrorCode());
            return null;
        }
        return credentialClientBuild.applyCredential(BuildConfig.LIBRARY_PACKAGE_NAME);
    }

    private Credential initCredentialFromSp(Context context, PreferencesHelper preferencesHelper) {
        String str;
        long j = preferencesHelper.getLong("credentialExpiredTime");
        if (j <= 0 || isNeedUpdate(Long.valueOf(j))) {
            str = "sp credential is expired,credentialExpiredTime:" + j;
        } else {
            String string = preferencesHelper.getString("credentialCache");
            if (TextUtils.isEmpty(string)) {
                str = "sp credential is null";
            } else {
                try {
                    CredentialClient credentialClientBuild = new CredentialClient.Builder().context(context).build();
                    this.credentialClient = credentialClientBuild;
                    return credentialClientBuild.genCredentialFromString(string);
                } catch (UcsException e) {
                    str = "init credential form sp failed :" + e.getErrorCode();
                }
            }
        }
        LogLocation.e("UCSSignHelper", str);
        return null;
    }

    private boolean isNeedUpdate(Long l) {
        return System.currentTimeMillis() > l.longValue() || l.longValue() - System.currentTimeMillis() < 3600000;
    }

    private String realSign(SignRequest signRequest) throws UcsCryptoException, UcsException {
        Credential credential = this.credential;
        if (credential == null || isNeedUpdate(Long.valueOf(credential.getExpireTime()))) {
            LogLocation.e("UCSSignHelper", "credential is not ready");
            return "";
        }
        CredentialSigner credentialSignerBuild = new CredentialSigner.Builder().withCredential(this.credential).withAlg(CredentialSignAlg.HMAC_SHA256).withCredentialClient(this.credentialClient).build();
        String string = Long.toString(System.currentTimeMillis());
        Locale locale = Locale.ENGLISH;
        String str = String.format(locale, "%s&%s&%s&%s&ak=%s&timestamp=%s", signRequest.getMethod(), signRequest.getPath(), signRequest.getQuery(), signRequest.getPayload(), this.credential.getAccessKey(), string);
        if (!TextUtils.isEmpty(signRequest.getHeadSigned()[0])) {
            str = String.format(locale, "%s&%s", str, signRequest.getHeadSigned()[0]);
        }
        LogLocation.d("UCSSignHelper", "newStringToSign:" + str);
        String strSignBase64 = credentialSignerBuild.getSignHandler().from(str).signBase64();
        LogLocation.i("UCSSignHelper", "sign successful");
        String str2 = String.format(locale, "EXT-AUTH-CLOUDSOA-HMAC-SHA256 appid=%s,timestamp=%s,signature=%s,ak=%s", "hmslocation", string, strSignBase64, this.credential.getAccessKey());
        return !TextUtils.isEmpty(signRequest.getHeadSigned()[1]) ? String.format(locale, "%s,signedHeaders=%s", str2, signRequest.getHeadSigned()[1]) : str2;
    }

    public void reApplyCredential() {
        LogLocation.i("UCSSignHelper", "reApplyCredential");
        this.credential = null;
        PreferencesHelper preferencesHelper = new PreferencesHelper("location_credential");
        preferencesHelper.remove("credentialExpiredTime");
        preferencesHelper.remove("credentialCache");
        checkAndInitCredential(ContextUtil.getContext());
    }

    public String sign(Context context, SignRequest signRequest) throws UcsCryptoException, UcsException, AuthException {
        LogLocation.d("UCSSignHelper", "begin to sign");
        if (checkAndInitCredential(context)) {
            return realSign(signRequest);
        }
        LogLocation.e("UCSSignHelper", "Credential init fail,sign fail");
        throw new AuthException(ErrorCode.valueOf(10550));
    }
}
