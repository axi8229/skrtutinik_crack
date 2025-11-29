package com.huawei.wisesecurity.ucs.common.report;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.exception.ParamException;
import com.huawei.wisesecurity.kfs.ha.HaReporter;
import com.huawei.wisesecurity.kfs.log.ILogKfs;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;

/* loaded from: classes3.dex */
public abstract class BaseReporter {
    public String haUrl;
    public ReportOption option;

    public static class UcsLog implements ILogKfs {
        private final String prefixTag;

        public UcsLog(String str) {
            this.prefixTag = str;
        }

        public String getTag(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.prefixTag;
            }
            return this.prefixTag + "-" + str;
        }

        @Override // com.huawei.wisesecurity.kfs.log.ILogKfs
        public void i(String str, String str2) {
            LogUcs.i(getTag(str), str2, new Object[0]);
        }

        @Override // com.huawei.wisesecurity.kfs.log.ILogKfs
        public void w(String str, String str2) {
            LogUcs.w(getTag(str), str2, new Object[0]);
        }
    }

    public BaseReporter(String str, ReportOption reportOption) {
        this.option = reportOption;
        this.haUrl = str;
    }

    public HaReporter getInstance(Context context, String str, String str2) {
        try {
            return new HaReporter(context, str, this.haUrl, new UcsLog(str2));
        } catch (ParamException e) {
            LogUcs.e("BaseReporter", "HaReporter instance exception: {0}", e.getMessage());
            return null;
        }
    }

    public void setOobeCheck(HaReporter haReporter) {
        if (ReportOption.REPORT_ALWAYS != this.option || haReporter == null) {
            return;
        }
        LogUcs.i("BaseReporter", "set OobeCheckOff.", new Object[0]);
        haReporter.setOobeCheckOff();
    }
}
