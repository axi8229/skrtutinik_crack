package com.huawei.wisesecurity.kfs.ha;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.wisesecurity.kfs.exception.ParamException;
import com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder;
import com.huawei.wisesecurity.kfs.log.ILogKfs;
import com.huawei.wisesecurity.ucs_credential.f;

/* loaded from: classes3.dex */
public class HaReporter {
    private HiAnalyticsInstance analyticsInstance;
    private final BIChecker biChecker;
    private final ILogKfs kfsLog;

    public HaReporter(Context context, String str, String str2, ILogKfs iLogKfs) throws ParamException {
        if (TextUtils.isEmpty(str2)) {
            throw new ParamException("hiAnalyticsUrl is empty");
        }
        this.kfsLog = iLogKfs;
        iLogKfs.i("HaReporter", "hiAnalyticsUrl is " + str2);
        this.biChecker = new BIChecker(iLogKfs);
        initHaInstance(str2, context, str);
    }

    private void initHaInstance(String str, Context context, String str2) {
        HiAnalyticsConfig hiAnalyticsConfigBuild = new HiAnalyticsConfig.Builder().setCollectURL(str).setEnableUUID(false).build();
        HiAnalyticsInstance hiAnalyticsInstanceRefresh = new HiAnalyticsInstance.Builder(context).setMaintConf(hiAnalyticsConfigBuild).setOperConf(hiAnalyticsConfigBuild).refresh(str2);
        this.analyticsInstance = hiAnalyticsInstanceRefresh;
        hiAnalyticsInstanceRefresh.setAppid("com.huawei.wisesecurity.common");
    }

    public void onEvent(Context context, ReportMsgBuilder reportMsgBuilder) {
        onEvent(context, reportMsgBuilder, HiAnalyticsType.HIANALYTICS_MAINTENANCE);
    }

    public void onEvent(Context context, ReportMsgBuilder reportMsgBuilder, HiAnalyticsType hiAnalyticsType) {
        ILogKfs iLogKfs;
        String str;
        if (this.analyticsInstance == null) {
            iLogKfs = this.kfsLog;
            str = "onEvent null == analyticsInstance";
        } else {
            if (!this.biChecker.hasError(context)) {
                try {
                    this.analyticsInstance.onEvent(hiAnalyticsType.getCode(), reportMsgBuilder.getEventId(), reportMsgBuilder.build());
                    this.kfsLog.i("HaReporter", "onEvent success");
                    return;
                } catch (Exception e) {
                    ILogKfs iLogKfs2 = this.kfsLog;
                    StringBuilder sbA = f.a("onEvent fail : ");
                    sbA.append(e.getMessage());
                    iLogKfs2.w("HaReporter", sbA.toString());
                    return;
                }
            }
            iLogKfs = this.kfsLog;
            str = "onEvent isEnabledUserExperience is false";
        }
        iLogKfs.i("HaReporter", str);
    }

    public void setOobeCheckOff() {
        this.biChecker.setOobeCheckOff();
    }
}
