package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.kfs.ha.HaReporter;
import com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder;
import com.huawei.wisesecurity.ucs.common.report.BaseReporter;
import com.huawei.wisesecurity.ucs.common.report.ReportOption;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;

/* loaded from: classes3.dex */
public class q0 extends BaseReporter implements HACapability {
    public static HaReporter a;

    public q0(p pVar, ReportOption reportOption) {
        super(pVar.a(), reportOption);
    }

    @Override // com.huawei.wisesecurity.ucs.credential.outer.HACapability
    public void onEvent(Context context, String str, ReportMsgBuilder reportMsgBuilder) {
        synchronized (q0.class) {
            try {
                if (a == null) {
                    a = getInstance(context, HACapability.UCS_CREDENTIAL_HA_SERVICE_TAG, "Credential");
                }
                HaReporter haReporter = a;
                if (haReporter != null) {
                    setOobeCheck(haReporter);
                    a.onEvent(context, reportMsgBuilder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
