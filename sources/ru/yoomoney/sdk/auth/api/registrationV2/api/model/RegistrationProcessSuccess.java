package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessSuccess;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "id", "", "addToBackStack", "", "step", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", YooMoneyAuth.KEY_ACCESS_TOKEN, "bindSocialAccountResult", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase;", "(Ljava/lang/String;ZLru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase;)V", "getAccessToken", "()Ljava/lang/String;", "getAddToBackStack", "()Z", "getBindSocialAccountResult", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase;", "getId", "getStep", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationProcessSuccess extends RegistrationProcessBase {
    private final String accessToken;
    private final boolean addToBackStack;
    private final BindSocialAccountResultBase bindSocialAccountResult;
    private final String id;
    private final RegistrationProcessBase.Step step;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationProcessSuccess(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean z, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty(YooMoneyAuth.KEY_ACCESS_TOKEN) String accessToken, @JsonProperty("bindSocialAccountResult") BindSocialAccountResultBase bindSocialAccountResultBase) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        this.id = id;
        this.addToBackStack = z;
        this.step = step;
        this.accessToken = accessToken;
        this.bindSocialAccountResult = bindSocialAccountResultBase;
    }

    public static /* synthetic */ RegistrationProcessSuccess copy$default(RegistrationProcessSuccess registrationProcessSuccess, String str, boolean z, RegistrationProcessBase.Step step, String str2, BindSocialAccountResultBase bindSocialAccountResultBase, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationProcessSuccess.id;
        }
        if ((i & 2) != 0) {
            z = registrationProcessSuccess.addToBackStack;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            step = registrationProcessSuccess.step;
        }
        RegistrationProcessBase.Step step2 = step;
        if ((i & 8) != 0) {
            str2 = registrationProcessSuccess.accessToken;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            bindSocialAccountResultBase = registrationProcessSuccess.bindSocialAccountResult;
        }
        return registrationProcessSuccess.copy(str, z2, step2, str3, bindSocialAccountResultBase);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    /* renamed from: component3, reason: from getter */
    public final RegistrationProcessBase.Step getStep() {
        return this.step;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component5, reason: from getter */
    public final BindSocialAccountResultBase getBindSocialAccountResult() {
        return this.bindSocialAccountResult;
    }

    public final RegistrationProcessSuccess copy(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean addToBackStack, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty(YooMoneyAuth.KEY_ACCESS_TOKEN) String accessToken, @JsonProperty("bindSocialAccountResult") BindSocialAccountResultBase bindSocialAccountResult) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return new RegistrationProcessSuccess(id, addToBackStack, step, accessToken, bindSocialAccountResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationProcessSuccess)) {
            return false;
        }
        RegistrationProcessSuccess registrationProcessSuccess = (RegistrationProcessSuccess) other;
        return Intrinsics.areEqual(this.id, registrationProcessSuccess.id) && this.addToBackStack == registrationProcessSuccess.addToBackStack && this.step == registrationProcessSuccess.step && Intrinsics.areEqual(this.accessToken, registrationProcessSuccess.accessToken) && Intrinsics.areEqual(this.bindSocialAccountResult, registrationProcessSuccess.bindSocialAccountResult);
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final BindSocialAccountResultBase getBindSocialAccountResult() {
        return this.bindSocialAccountResult;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public String getId() {
        return this.id;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public RegistrationProcessBase.Step getStep() {
        return this.step;
    }

    public int hashCode() {
        int iA = a.a(this.accessToken, (this.step.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31)) * 31, 31);
        BindSocialAccountResultBase bindSocialAccountResultBase = this.bindSocialAccountResult;
        return iA + (bindSocialAccountResultBase == null ? 0 : bindSocialAccountResultBase.hashCode());
    }

    public String toString() {
        return "RegistrationProcessSuccess(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", step=" + this.step + ", accessToken=" + this.accessToken + ", bindSocialAccountResult=" + this.bindSocialAccountResult + ")";
    }

    public /* synthetic */ RegistrationProcessSuccess(String str, boolean z, RegistrationProcessBase.Step step, String str2, BindSocialAccountResultBase bindSocialAccountResultBase, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, step, str2, (i & 16) != 0 ? null : bindSocialAccountResultBase);
    }
}
