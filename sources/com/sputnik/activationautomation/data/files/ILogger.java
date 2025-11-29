package com.sputnik.activationautomation.data.files;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* compiled from: ILogger.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/sputnik/activationautomation/data/files/ILogger;", "", "", RemoteMessageConst.MessageBody.MSG, "", "write", "(Ljava/lang/String;)V", "clear", "()V", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ILogger {
    void clear();

    void write(String msg);
}
