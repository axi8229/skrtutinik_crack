package ru.yoomoney.sdk.two_fa.exception;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Failure.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0006\u0004\u0005\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/Failure;", "Landroid/os/Parcelable;", "", "()V", "Lru/yoomoney/sdk/two_fa/exception/FeatureFailure;", "Lru/yoomoney/sdk/two_fa/exception/InvalidTokenFailure;", "Lru/yoomoney/sdk/two_fa/exception/NetworkConnectionFailure;", "Lru/yoomoney/sdk/two_fa/exception/ProcessingRequestFailure;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure;", "Lru/yoomoney/sdk/two_fa/exception/TechnicalFailure;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Failure extends Throwable implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ Failure(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Failure() {
    }
}
