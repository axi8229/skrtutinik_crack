package ru.yoomoney.sdk.auth.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"toFailure", "Lru/yoomoney/sdk/auth/api/model/FeatureFailure;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "toSocialAccountFailure", "Lru/yoomoney/sdk/auth/api/model/SocialAccountFailure;", "service", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProcessErrorExtensionsKt {
    public static final FeatureFailure toFailure(ProcessError processError) {
        Intrinsics.checkNotNullParameter(processError, "<this>");
        return new FeatureFailure(processError);
    }

    public static final SocialAccountFailure toSocialAccountFailure(ProcessError processError, OauthServiceProvider service) {
        Intrinsics.checkNotNullParameter(processError, "<this>");
        Intrinsics.checkNotNullParameter(service, "service");
        return new SocialAccountFailure(processError, service);
    }
}
