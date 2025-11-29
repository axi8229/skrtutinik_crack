package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessSetEmail;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "id", "", "addToBackStack", "", "step", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "prefilledEmail", "accounts", "", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/Account;", "(Ljava/lang/String;ZLru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;Ljava/lang/String;Ljava/util/List;)V", "getAccounts", "()Ljava/util/List;", "getAddToBackStack", "()Z", "getId", "()Ljava/lang/String;", "getPrefilledEmail", "getStep", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationProcessSetEmail extends RegistrationProcessBase {
    private final List<Account> accounts;
    private final boolean addToBackStack;
    private final String id;
    private final String prefilledEmail;
    private final RegistrationProcessBase.Step step;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationProcessSetEmail(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean z, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty("prefilledEmail") String str, @JsonProperty("accounts") List<Account> list) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        this.id = id;
        this.addToBackStack = z;
        this.step = step;
        this.prefilledEmail = str;
        this.accounts = list;
    }

    public static /* synthetic */ RegistrationProcessSetEmail copy$default(RegistrationProcessSetEmail registrationProcessSetEmail, String str, boolean z, RegistrationProcessBase.Step step, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationProcessSetEmail.id;
        }
        if ((i & 2) != 0) {
            z = registrationProcessSetEmail.addToBackStack;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            step = registrationProcessSetEmail.step;
        }
        RegistrationProcessBase.Step step2 = step;
        if ((i & 8) != 0) {
            str2 = registrationProcessSetEmail.prefilledEmail;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            list = registrationProcessSetEmail.accounts;
        }
        return registrationProcessSetEmail.copy(str, z2, step2, str3, list);
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
    public final String getPrefilledEmail() {
        return this.prefilledEmail;
    }

    public final List<Account> component5() {
        return this.accounts;
    }

    public final RegistrationProcessSetEmail copy(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean addToBackStack, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty("prefilledEmail") String prefilledEmail, @JsonProperty("accounts") List<Account> accounts) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        return new RegistrationProcessSetEmail(id, addToBackStack, step, prefilledEmail, accounts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationProcessSetEmail)) {
            return false;
        }
        RegistrationProcessSetEmail registrationProcessSetEmail = (RegistrationProcessSetEmail) other;
        return Intrinsics.areEqual(this.id, registrationProcessSetEmail.id) && this.addToBackStack == registrationProcessSetEmail.addToBackStack && this.step == registrationProcessSetEmail.step && Intrinsics.areEqual(this.prefilledEmail, registrationProcessSetEmail.prefilledEmail) && Intrinsics.areEqual(this.accounts, registrationProcessSetEmail.accounts);
    }

    public final List<Account> getAccounts() {
        return this.accounts;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public String getId() {
        return this.id;
    }

    public final String getPrefilledEmail() {
        return this.prefilledEmail;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public RegistrationProcessBase.Step getStep() {
        return this.step;
    }

    public int hashCode() {
        int iHashCode = (this.step.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31)) * 31;
        String str = this.prefilledEmail;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Account> list = this.accounts;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "RegistrationProcessSetEmail(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", step=" + this.step + ", prefilledEmail=" + this.prefilledEmail + ", accounts=" + this.accounts + ")";
    }

    public /* synthetic */ RegistrationProcessSetEmail(String str, boolean z, RegistrationProcessBase.Step step, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, step, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : list);
    }
}
