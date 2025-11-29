package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;

/* loaded from: classes3.dex */
public class o extends BaseReportMsgBuilder {
    public o a() {
        this.linkedHashMap.put("flavor", "developers");
        return this;
    }

    @Override // com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder
    public String getEventId() {
        return "crypto";
    }
}
