package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.common.log.ILogUcs;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.report.ReportOption;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.Selector;
import com.huawei.wisesecurity.ucs_credential.c;
import com.huawei.wisesecurity.ucs_credential.f;
import com.huawei.wisesecurity.ucs_credential.h;
import com.huawei.wisesecurity.ucs_credential.i;
import com.huawei.wisesecurity.ucs_credential.k;
import com.huawei.wisesecurity.ucs_credential.p;
import java.util.UUID;

/* loaded from: classes3.dex */
public class CredentialClient {
    private static final String TAG = "CredentialClient";
    private String appId;
    private Context context;
    private k credentialManager;
    private HACapability haCapability;

    public static class Builder {
        private String appId;

        @KfsNotNull
        private Context context;
        private GrsCapability grsCapability;
        private HACapability haCapability;
        private NetworkCapability networkCapability;
        private String serCountry;
        private int networkTimeOut = 15000;
        private int networkRetryTime = 2;
        private ReportOption reportOption = ReportOption.REPORT_NORMAL;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public CredentialClient build() throws UcsException {
            try {
                String str = this.appId;
                if (str != null && str.length() > 30) {
                    throw new UcsParamException("appId length is too long");
                }
                KfsValidator.validate(this);
                p pVarSelectGrsCapability = Selector.selectGrsCapability(this.grsCapability, this.context, this.serCountry);
                return new CredentialClient(this.context, this.appId, pVarSelectGrsCapability, Selector.selectNetWorkCapability(this.networkCapability, this.context, this.networkTimeOut, this.networkRetryTime), Selector.selectHACapability(this.haCapability, pVarSelectGrsCapability, this.reportOption));
            } catch (KfsValidationException e) {
                StringBuilder sbA = f.a("CredentialClient check param error : ");
                sbA.append(e.getMessage());
                throw new UcsParamException(sbA.toString());
            } catch (UcsException e2) {
                LogUcs.e(CredentialClient.TAG, "CredentialClient build get UCS exception : errorCode : {0} errorMsg : {1}", Long.valueOf(e2.getErrorCode()), e2.getMessage());
                throw e2;
            } catch (Throwable th) {
                StringBuilder sbA2 = f.a("CredentialClient build get exception : ");
                sbA2.append(th.getMessage());
                String string = sbA2.toString();
                throw h.a(CredentialClient.TAG, string, new Object[0], 2001L, string);
            }
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder grsCapability(GrsCapability grsCapability) {
            this.grsCapability = grsCapability;
            return this;
        }

        public Builder haCapability(HACapability hACapability) {
            this.haCapability = hACapability;
            return this;
        }

        public Builder logInstance(ILogUcs iLogUcs) {
            LogUcs.init(iLogUcs);
            return this;
        }

        public Builder networkCapability(NetworkCapability networkCapability) {
            this.networkCapability = networkCapability;
            return this;
        }

        public Builder networkRetryTime(int i) {
            this.networkRetryTime = i;
            return this;
        }

        public Builder networkTimeOut(int i) {
            this.networkTimeOut = i;
            return this;
        }

        public Builder reportOption(ReportOption reportOption) {
            this.reportOption = reportOption;
            return this;
        }

        public Builder serCountry(String str) {
            this.serCountry = str;
            return this;
        }
    }

    private CredentialClient(Context context, String str, p pVar, NetworkCapability networkCapability, HACapability hACapability) throws UcsException {
        this.context = context;
        this.appId = str;
        this.haCapability = hACapability;
        this.credentialManager = new k(this, context, networkCapability, pVar, str);
        UcsLib.checkNativeLibrary();
    }

    private void checkParams(String str) throws UcsException {
        if (TextUtils.isEmpty(str)) {
            throw new UcsException(1001L, "serviceName illegal...");
        }
    }

    private void checkThread() throws UcsException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new UcsException(1015L, "can not apply in main looper...");
        }
    }

    private c createReportMsgBuilder(String str, String str2) {
        c cVar = new c();
        cVar.linkedHashMap.put("flavor", "developers");
        cVar.linkedHashMap.put("credentialPackageName", str);
        return (c) cVar.setTransId(str2).setApiName("appAuth.applyCredential").setCallTime();
    }

    public Credential applyCredential(String str) throws UcsException {
        return applyCredential(str, UUID.randomUUID().toString());
    }

    public Credential applyCredential(String str, String str2) throws UcsException {
        checkParams(str);
        checkThread();
        c cVarCreateReportMsgBuilder = createReportMsgBuilder(str, str2);
        LogUcs.i(TAG, "start apply credential for {0} , appId is {1},", str, this.appId);
        try {
            try {
                Credential credentialA = this.credentialManager.a(1, str, str2);
                LogUcs.i(TAG, "finish apply credential for {0} , appId is {1}", str, this.appId);
                cVarCreateReportMsgBuilder.linkedHashMap.put("cty", this.credentialManager.g);
                cVarCreateReportMsgBuilder.setStatusCode(0);
                return credentialA;
            } catch (UcsException e) {
                LogUcs.e(TAG, "get Credential get UcsException : " + e.getMessage(), new Object[0]);
                cVarCreateReportMsgBuilder.setStatusCode((int) e.getErrorCode()).setErrorMsg(e.getMessage());
                throw e;
            } catch (Exception e2) {
                String str3 = "get Credential get exception : " + e2.getMessage();
                LogUcs.e(TAG, str3, new Object[0]);
                cVarCreateReportMsgBuilder.setStatusCode(2001).setErrorMsg(str3);
                throw new UcsException(2001L, str3);
            }
        } finally {
            reportLogs(cVarCreateReportMsgBuilder);
        }
    }

    public Credential applyCredentialByEC(String str) throws UcsException {
        return applyCredentialByEC(str, UUID.randomUUID().toString());
    }

    public Credential applyCredentialByEC(String str, String str2) throws UcsException {
        checkParams(str);
        checkThread();
        c cVarCreateReportMsgBuilder = createReportMsgBuilder(str, str2);
        LogUcs.i(TAG, "start apply credential by EC for {0} , appId is {1}", str, this.appId);
        try {
            try {
                Credential credentialA = this.credentialManager.a(2, str, str2);
                LogUcs.i(TAG, "finish apply credential by EC for {0} , appId is {1}", str, this.appId);
                cVarCreateReportMsgBuilder.linkedHashMap.put("cty", this.credentialManager.g);
                cVarCreateReportMsgBuilder.setStatusCode(0);
                return credentialA;
            } catch (UcsException e) {
                LogUcs.e(TAG, "get Credential by EC get UcsException : " + e.getMessage(), new Object[0]);
                cVarCreateReportMsgBuilder.setStatusCode((int) e.getErrorCode()).setErrorMsg(e.getMessage());
                throw e;
            } catch (Exception e2) {
                String str3 = "get Credential by EC get exception : " + e2.getMessage();
                LogUcs.e(TAG, str3, new Object[0]);
                cVarCreateReportMsgBuilder.setStatusCode(2001).setErrorMsg(str3);
                throw new UcsException(2001L, str3);
            }
        } finally {
            reportLogs(cVarCreateReportMsgBuilder);
        }
    }

    public Credential genCredentialFromString(String str) throws UcsException {
        i iVar = new i();
        iVar.linkedHashMap.put("flavor", "developers");
        i iVar2 = (i) iVar.setApiName("appAuth.credentialFromString").setCallTime();
        try {
            try {
                Credential credentialFromString = Credential.fromString(this.context, str, iVar2);
                iVar2.setStatusCode(0);
                return credentialFromString;
            } catch (UcsException e) {
                LogUcs.e(TAG, "credential from string get UcsException : {0}", e.getMessage());
                iVar2.setStatusCode((int) e.getErrorCode()).setErrorMsg(e.getMessage());
                throw e;
            } catch (Exception e2) {
                String str2 = "credential from string get exception : " + e2.getMessage();
                LogUcs.e(TAG, "{0}", str2);
                iVar2.setStatusCode(2001).setErrorMsg(str2);
                throw new UcsException(2001L, str2);
            }
        } finally {
            reportLogs(iVar2);
        }
    }

    public void reportLogs(BaseReportMsgBuilder baseReportMsgBuilder) {
        baseReportMsgBuilder.setAppId(this.appId).setPackageName(this.context.getPackageName()).setVersion("1.0.4.312");
        Context context = this.context;
        try {
            this.haCapability.onEvent(context, baseReportMsgBuilder.getEventId(), baseReportMsgBuilder.setCostTime());
        } catch (Throwable th) {
            StringBuilder sbA = f.a("onEvent get exception : ");
            sbA.append(th.getMessage());
            LogUcs.i("ReportUtil", sbA.toString(), new Object[0]);
        }
    }
}
