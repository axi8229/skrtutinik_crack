package ru.yoomoney.sdk.yooprofiler;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/yooprofiler/YooProfilerHelper;", "", "()V", "create", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "context", "Landroid/content/Context;", "yooprofiler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YooProfilerHelper {
    public static final YooProfilerHelper INSTANCE = new YooProfilerHelper();

    private YooProfilerHelper() {
    }

    public final YooProfiler create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new YooProfilerImpl(context, null, 2, 0 == true ? 1 : 0);
    }
}
