package ru.yoomoney.sdk.auth.passport.domain;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toOauthServiceProviderType", "Lru/yoomoney/sdk/auth/passport/domain/OauthServiceProviderType;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthServiceProviderTypeKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OauthServiceProvider.values().length];
            try {
                iArr[OauthServiceProvider.SBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OauthServiceProvider.VK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OauthServiceProvider.ESIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OauthServiceProvider.APPLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final OauthServiceProviderType toOauthServiceProviderType(OauthServiceProvider oauthServiceProvider) {
        Intrinsics.checkNotNullParameter(oauthServiceProvider, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[oauthServiceProvider.ordinal()];
        if (i == 1) {
            return OauthServiceProviderType.SBER;
        }
        if (i == 2) {
            return OauthServiceProviderType.VK;
        }
        if (i == 3) {
            return OauthServiceProviderType.ESIA;
        }
        if (i == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
