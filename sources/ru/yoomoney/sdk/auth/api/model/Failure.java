package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/Failure;", "Landroid/os/Parcelable;", "", "()V", "Lru/yoomoney/sdk/auth/api/model/FeatureFailure;", "Lru/yoomoney/sdk/auth/api/model/IllegalParametersFailure;", "Lru/yoomoney/sdk/auth/api/model/InvalidTokenFailure;", "Lru/yoomoney/sdk/auth/api/model/NetworkConnectionFailure;", "Lru/yoomoney/sdk/auth/api/model/ProcessingRequestFailure;", "Lru/yoomoney/sdk/auth/api/model/RegistrationRuleViolationFailure;", "Lru/yoomoney/sdk/auth/api/model/RequestParametersFailure;", "Lru/yoomoney/sdk/auth/api/model/RulesViolationFailure;", "Lru/yoomoney/sdk/auth/api/model/SocialAccountAuthFailure;", "Lru/yoomoney/sdk/auth/api/model/SocialAccountFailure;", "Lru/yoomoney/sdk/auth/api/model/TechnicalFailure;", "Lru/yoomoney/sdk/auth/api/model/UpdateRequireFailure;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Failure extends Throwable implements Parcelable {
    private Failure() {
    }

    public /* synthetic */ Failure(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
