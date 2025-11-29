package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessAcquireAuthorization;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "id", "", "addToBackStack", "", "step", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "(Ljava/lang/String;ZLru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;)V", "getAddToBackStack", "()Z", "getId", "()Ljava/lang/String;", "getStep", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationProcessAcquireAuthorization extends RegistrationProcessBase {
    private final boolean addToBackStack;
    private final String id;
    private final RegistrationProcessBase.Step step;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationProcessAcquireAuthorization(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean z, @JsonProperty("step") RegistrationProcessBase.Step step) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        this.id = id;
        this.addToBackStack = z;
        this.step = step;
    }

    public static /* synthetic */ RegistrationProcessAcquireAuthorization copy$default(RegistrationProcessAcquireAuthorization registrationProcessAcquireAuthorization, String str, boolean z, RegistrationProcessBase.Step step, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationProcessAcquireAuthorization.id;
        }
        if ((i & 2) != 0) {
            z = registrationProcessAcquireAuthorization.addToBackStack;
        }
        if ((i & 4) != 0) {
            step = registrationProcessAcquireAuthorization.step;
        }
        return registrationProcessAcquireAuthorization.copy(str, z, step);
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

    public final RegistrationProcessAcquireAuthorization copy(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean addToBackStack, @JsonProperty("step") RegistrationProcessBase.Step step) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        return new RegistrationProcessAcquireAuthorization(id, addToBackStack, step);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationProcessAcquireAuthorization)) {
            return false;
        }
        RegistrationProcessAcquireAuthorization registrationProcessAcquireAuthorization = (RegistrationProcessAcquireAuthorization) other;
        return Intrinsics.areEqual(this.id, registrationProcessAcquireAuthorization.id) && this.addToBackStack == registrationProcessAcquireAuthorization.addToBackStack && this.step == registrationProcessAcquireAuthorization.step;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public boolean getAddToBackStack() {
        return this.addToBackStack;
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
        return this.step.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31);
    }

    public String toString() {
        return "RegistrationProcessAcquireAuthorization(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", step=" + this.step + ")";
    }
}
