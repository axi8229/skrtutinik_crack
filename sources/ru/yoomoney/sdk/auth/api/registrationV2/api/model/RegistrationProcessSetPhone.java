package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\fHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessSetPhone;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "id", "", "addToBackStack", "", "step", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "countryCallingCodes", "", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/CountryCallingCode;", "prefilledPhone", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/PrefilledPhone;", "(Ljava/lang/String;ZLru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;Ljava/util/List;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/PrefilledPhone;)V", "getAddToBackStack", "()Z", "getCountryCallingCodes", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getPrefilledPhone", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/PrefilledPhone;", "getStep", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationProcessSetPhone extends RegistrationProcessBase {
    private final boolean addToBackStack;
    private final List<CountryCallingCode> countryCallingCodes;
    private final String id;
    private final PrefilledPhone prefilledPhone;
    private final RegistrationProcessBase.Step step;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationProcessSetPhone(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean z, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty("countryCallingCodes") List<CountryCallingCode> countryCallingCodes, @JsonProperty("prefilledPhone") PrefilledPhone prefilledPhone) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(countryCallingCodes, "countryCallingCodes");
        this.id = id;
        this.addToBackStack = z;
        this.step = step;
        this.countryCallingCodes = countryCallingCodes;
        this.prefilledPhone = prefilledPhone;
    }

    public static /* synthetic */ RegistrationProcessSetPhone copy$default(RegistrationProcessSetPhone registrationProcessSetPhone, String str, boolean z, RegistrationProcessBase.Step step, List list, PrefilledPhone prefilledPhone, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationProcessSetPhone.id;
        }
        if ((i & 2) != 0) {
            z = registrationProcessSetPhone.addToBackStack;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            step = registrationProcessSetPhone.step;
        }
        RegistrationProcessBase.Step step2 = step;
        if ((i & 8) != 0) {
            list = registrationProcessSetPhone.countryCallingCodes;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            prefilledPhone = registrationProcessSetPhone.prefilledPhone;
        }
        return registrationProcessSetPhone.copy(str, z2, step2, list2, prefilledPhone);
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

    public final List<CountryCallingCode> component4() {
        return this.countryCallingCodes;
    }

    /* renamed from: component5, reason: from getter */
    public final PrefilledPhone getPrefilledPhone() {
        return this.prefilledPhone;
    }

    public final RegistrationProcessSetPhone copy(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean addToBackStack, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty("countryCallingCodes") List<CountryCallingCode> countryCallingCodes, @JsonProperty("prefilledPhone") PrefilledPhone prefilledPhone) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(countryCallingCodes, "countryCallingCodes");
        return new RegistrationProcessSetPhone(id, addToBackStack, step, countryCallingCodes, prefilledPhone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationProcessSetPhone)) {
            return false;
        }
        RegistrationProcessSetPhone registrationProcessSetPhone = (RegistrationProcessSetPhone) other;
        return Intrinsics.areEqual(this.id, registrationProcessSetPhone.id) && this.addToBackStack == registrationProcessSetPhone.addToBackStack && this.step == registrationProcessSetPhone.step && Intrinsics.areEqual(this.countryCallingCodes, registrationProcessSetPhone.countryCallingCodes) && Intrinsics.areEqual(this.prefilledPhone, registrationProcessSetPhone.prefilledPhone);
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final List<CountryCallingCode> getCountryCallingCodes() {
        return this.countryCallingCodes;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public String getId() {
        return this.id;
    }

    public final PrefilledPhone getPrefilledPhone() {
        return this.prefilledPhone;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public RegistrationProcessBase.Step getStep() {
        return this.step;
    }

    public int hashCode() {
        int iHashCode = (this.countryCallingCodes.hashCode() + ((this.step.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31)) * 31)) * 31;
        PrefilledPhone prefilledPhone = this.prefilledPhone;
        return iHashCode + (prefilledPhone == null ? 0 : prefilledPhone.hashCode());
    }

    public String toString() {
        return "RegistrationProcessSetPhone(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", step=" + this.step + ", countryCallingCodes=" + this.countryCallingCodes + ", prefilledPhone=" + this.prefilledPhone + ")";
    }

    public /* synthetic */ RegistrationProcessSetPhone(String str, boolean z, RegistrationProcessBase.Step step, List list, PrefilledPhone prefilledPhone, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, step, list, (i & 16) != 0 ? null : prefilledPhone);
    }
}
