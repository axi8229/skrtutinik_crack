package com.huawei.location.util;

import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.APKUtil;

/* loaded from: classes3.dex */
public class yn {
    private ReportBuilder yn;

    /* renamed from: com.huawei.location.util.yn$yn, reason: collision with other inner class name */
    public static class C0098yn {
        private ReportBuilder yn = new ReportBuilder();

        public C0098yn yn(BaseLocationReq baseLocationReq) {
            if (baseLocationReq != null) {
                this.yn.setTransactionID(baseLocationReq.getLocTransactionId());
                this.yn.setPackage(baseLocationReq.getPackageName());
                this.yn.setCpAppVersion(String.valueOf(APKUtil.getThirdAppVersionCode(baseLocationReq.getPackageName())));
            }
            return this;
        }

        public C0098yn yn(String str) {
            this.yn.setApiName(str);
            return this;
        }

        public yn yn() {
            return new yn(this.yn);
        }
    }

    public yn(ReportBuilder reportBuilder) {
        this.yn = reportBuilder;
    }

    public void Vw(String str) {
        this.yn.setResult(str);
        this.yn.setCostTime();
        Tracker.getInstance().onMaintEvent(this.yn);
        Tracker.getInstance().onOperationEvent(this.yn);
        this.yn.setCallTime();
    }

    public void yn(String str) {
        this.yn.setErrorCode(str);
        this.yn.setCostTime();
        Tracker.getInstance().onMaintEvent(this.yn);
        Tracker.getInstance().onOperationEvent(this.yn);
    }
}
