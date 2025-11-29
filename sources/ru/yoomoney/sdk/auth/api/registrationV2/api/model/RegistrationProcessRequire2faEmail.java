package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessRequire2faEmail;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "id", "", "addToBackStack", "", "step", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "authProcessId", "(Ljava/lang/String;ZLru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;Ljava/lang/String;)V", "getAddToBackStack", "()Z", "getAuthProcessId", "()Ljava/lang/String;", "getId", "getStep", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationProcessRequire2faEmail extends RegistrationProcessBase {
    private final boolean addToBackStack;
    private final String authProcessId;
    private final String id;
    private final RegistrationProcessBase.Step step;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationProcessRequire2faEmail(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean z, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty("authProcessId") String authProcessId) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        this.id = id;
        this.addToBackStack = z;
        this.step = step;
        this.authProcessId = authProcessId;
    }

    public static /* synthetic */ RegistrationProcessRequire2faEmail copy$default(RegistrationProcessRequire2faEmail registrationProcessRequire2faEmail, String str, boolean z, RegistrationProcessBase.Step step, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationProcessRequire2faEmail.id;
        }
        if ((i & 2) != 0) {
            z = registrationProcessRequire2faEmail.addToBackStack;
        }
        if ((i & 4) != 0) {
            step = registrationProcessRequire2faEmail.step;
        }
        if ((i & 8) != 0) {
            str2 = registrationProcessRequire2faEmail.authProcessId;
        }
        return registrationProcessRequire2faEmail.copy(str, z, step, str2);
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
    public final String getAuthProcessId() {
        return this.authProcessId;
    }

    public final RegistrationProcessRequire2faEmail copy(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean addToBackStack, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty("authProcessId") String authProcessId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
        return new RegistrationProcessRequire2faEmail(id, addToBackStack, step, authProcessId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationProcessRequire2faEmail)) {
            return false;
        }
        RegistrationProcessRequire2faEmail registrationProcessRequire2faEmail = (RegistrationProcessRequire2faEmail) other;
        return Intrinsics.areEqual(this.id, registrationProcessRequire2faEmail.id) && this.addToBackStack == registrationProcessRequire2faEmail.addToBackStack && this.step == registrationProcessRequire2faEmail.step && Intrinsics.areEqual(this.authProcessId, registrationProcessRequire2faEmail.authProcessId);
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final String getAuthProcessId() {
        return this.authProcessId;
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
        return this.authProcessId.hashCode() + ((this.step.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31)) * 31);
    }

    public String toString() {
        return "RegistrationProcessRequire2faEmail(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", step=" + this.step + ", authProcessId=" + this.authProcessId + ")";
    }
}
