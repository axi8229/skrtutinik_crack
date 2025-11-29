package com.huawei.wisesecurity.ucs.credential.outer;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.report.ReportOption;
import com.huawei.wisesecurity.ucs.credential.outer.impl.QuietHACapabilityImpl;
import com.huawei.wisesecurity.ucs_credential.f;
import com.huawei.wisesecurity.ucs_credential.h0;
import com.huawei.wisesecurity.ucs_credential.j0;
import com.huawei.wisesecurity.ucs_credential.p;
import com.huawei.wisesecurity.ucs_credential.q0;
import com.huawei.wisesecurity.ucs_credential.r;

/* loaded from: classes3.dex */
public class Selector {
    private static final String GRS_FEATURE_CLASS = "com.huawei.hms.framework.network.grs.GrsClient";
    private static final String HA_FEATURE_CLASS = "com.huawei.hianalytics.process.HiAnalyticsInstance";
    private static final String NETWORK_FEATURE_CLASS = "com.huawei.hms.network.restclient.RestClient";
    private static final int NETWORK_RETRY_TIME_MAX = 5;
    private static final int NETWORK_RETRY_TIME_MIN = 1;
    private static final int NETWORK_TIME_OUT_MAX = 20000;
    private static final int NETWORK_TIME_OUT_MIN = 10000;
    private static final int SER_COUNTRY_LENGTH_MAX = 7;
    private static final int SER_COUNTRY_LENGTH_MIN = 2;
    private static final String TAG = "Selector";

    public static p selectGrsCapability(GrsCapability grsCapability, Context context, String str) throws UcsException {
        if (grsCapability != null) {
            return new h0(grsCapability);
        }
        try {
            if (!TextUtils.isEmpty(str) && (str.length() < 2 || str.length() > 7)) {
                throw new UcsException(1001L, "serCountry param error");
            }
            LogUcs.i(TAG, "outer GRS capability is null, use inner capability", new Object[0]);
            return new r(context, str);
        } catch (ClassNotFoundException e) {
            StringBuilder sbA = f.a("GRS capability not found : ");
            sbA.append(e.getMessage());
            throw new UcsException(1025L, sbA.toString());
        }
    }

    public static HACapability selectHACapability(HACapability hACapability, p pVar, ReportOption reportOption) throws ClassNotFoundException, UcsException {
        if (hACapability != null) {
            return hACapability;
        }
        if (ReportOption.REPORT_CLOSE == reportOption) {
            return new QuietHACapabilityImpl();
        }
        try {
            Class.forName(HA_FEATURE_CLASS);
            LogUcs.i(TAG, "outer HA capability is null, use inner capability", new Object[0]);
            return new q0(pVar, reportOption);
        } catch (ClassNotFoundException e) {
            StringBuilder sbA = f.a("HA capability not found : ");
            sbA.append(e.getMessage());
            throw new UcsException(1025L, sbA.toString());
        }
    }

    public static NetworkCapability selectNetWorkCapability(NetworkCapability networkCapability, Context context, int i, int i2) throws UcsException, ClassNotFoundException {
        if (networkCapability != null) {
            networkCapability.initConfig(i, i2);
            return networkCapability;
        }
        try {
            Class.forName(NETWORK_FEATURE_CLASS);
            if (i < 10000 || i > NETWORK_TIME_OUT_MAX || i2 < 1 || i2 > 5) {
                throw new UcsException(1001L, "networkTimeOut or networkRetryTime param error");
            }
            j0 j0Var = new j0(context);
            j0Var.initConfig(i, i2);
            LogUcs.i(TAG, "outer Network capability is null, use inner capability", new Object[0]);
            return j0Var;
        } catch (ClassNotFoundException e) {
            StringBuilder sbA = f.a("Network capability not found : ");
            sbA.append(e.getMessage());
            throw new UcsException(1025L, sbA.toString());
        }
    }
}
