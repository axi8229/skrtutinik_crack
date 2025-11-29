package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;

/* loaded from: classes3.dex */
public class i extends BaseReportMsgBuilder {
    @Override // com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder
    public String getEventId() {
        return "credentialFromString";
    }
}
