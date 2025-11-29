package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.account.socialAccount.deserializer.OauthCodeParametersDeserializer;

@JsonAdapter(OauthCodeParametersDeserializer.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthCodeParameters;", "Landroid/os/Parcelable;", "service", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "getService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/AppleOauthCodeParameters;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/EsiaOauthCodeParameters;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/SberOauthCodeParameters;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/VkOauthCodeParameters;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class OauthCodeParameters implements Parcelable {
    private final OauthServiceProvider service;

    private OauthCodeParameters(OauthServiceProvider oauthServiceProvider) {
        this.service = oauthServiceProvider;
    }

    public final OauthServiceProvider getService() {
        return this.service;
    }

    public /* synthetic */ OauthCodeParameters(OauthServiceProvider oauthServiceProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(oauthServiceProvider);
    }
}
