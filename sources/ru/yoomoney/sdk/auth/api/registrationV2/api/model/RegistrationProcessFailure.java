package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u001eB-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessFailure;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "id", "", "addToBackStack", "", "step", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "error", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessFailure$Error;", "(Ljava/lang/String;ZLru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessFailure$Error;)V", "getAddToBackStack", "()Z", "getError", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessFailure$Error;", "getId", "()Ljava/lang/String;", "getStep", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "Error", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationProcessFailure extends RegistrationProcessBase {
    private final boolean addToBackStack;
    private final Error error;
    private final String id;
    private final RegistrationProcessBase.Step step;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessFailure$Error;", "", "(Ljava/lang/String;I)V", "REGISTRATION_FORBIDDEN", "PROCESS_EXPIRED", "EMAIL_ALREADY_TAKEN", "PHONE_NUMBER_LIMIT_REACHED", "AUTHORIZATION_ISSUE_LIMIT_EXCEEDED", "FATAL_ERROR", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Error {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Error[] $VALUES;

        @JsonProperty("RegistrationForbidden")
        public static final Error REGISTRATION_FORBIDDEN = new Error("REGISTRATION_FORBIDDEN", 0);

        @JsonProperty("ProcessExpired")
        public static final Error PROCESS_EXPIRED = new Error("PROCESS_EXPIRED", 1);

        @JsonProperty("EmailAlreadyTaken")
        public static final Error EMAIL_ALREADY_TAKEN = new Error("EMAIL_ALREADY_TAKEN", 2);

        @JsonProperty("PhoneNumberLimitReached")
        public static final Error PHONE_NUMBER_LIMIT_REACHED = new Error("PHONE_NUMBER_LIMIT_REACHED", 3);

        @JsonProperty("AuthorizationIssueLimitExceeded")
        public static final Error AUTHORIZATION_ISSUE_LIMIT_EXCEEDED = new Error("AUTHORIZATION_ISSUE_LIMIT_EXCEEDED", 4);

        @JsonProperty("FatalError")
        public static final Error FATAL_ERROR = new Error("FATAL_ERROR", 5);

        @JsonEnumDefaultValue
        public static final Error UNKNOWN_ENUM = new Error("UNKNOWN_ENUM", 6);

        private static final /* synthetic */ Error[] $values() {
            return new Error[]{REGISTRATION_FORBIDDEN, PROCESS_EXPIRED, EMAIL_ALREADY_TAKEN, PHONE_NUMBER_LIMIT_REACHED, AUTHORIZATION_ISSUE_LIMIT_EXCEEDED, FATAL_ERROR, UNKNOWN_ENUM};
        }

        static {
            Error[] errorArr$values = $values();
            $VALUES = errorArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(errorArr$values);
        }

        private Error(String str, int i) {
        }

        public static EnumEntries<Error> getEntries() {
            return $ENTRIES;
        }

        public static Error valueOf(String str) {
            return (Error) Enum.valueOf(Error.class, str);
        }

        public static Error[] values() {
            return (Error[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationProcessFailure(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean z, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty("error") Error error) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(error, "error");
        this.id = id;
        this.addToBackStack = z;
        this.step = step;
        this.error = error;
    }

    public static /* synthetic */ RegistrationProcessFailure copy$default(RegistrationProcessFailure registrationProcessFailure, String str, boolean z, RegistrationProcessBase.Step step, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationProcessFailure.id;
        }
        if ((i & 2) != 0) {
            z = registrationProcessFailure.addToBackStack;
        }
        if ((i & 4) != 0) {
            step = registrationProcessFailure.step;
        }
        if ((i & 8) != 0) {
            error = registrationProcessFailure.error;
        }
        return registrationProcessFailure.copy(str, z, step, error);
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
    public final Error getError() {
        return this.error;
    }

    public final RegistrationProcessFailure copy(@JsonProperty("id") String id, @JsonProperty("addToBackStack") boolean addToBackStack, @JsonProperty("step") RegistrationProcessBase.Step step, @JsonProperty("error") Error error) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(error, "error");
        return new RegistrationProcessFailure(id, addToBackStack, step, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationProcessFailure)) {
            return false;
        }
        RegistrationProcessFailure registrationProcessFailure = (RegistrationProcessFailure) other;
        return Intrinsics.areEqual(this.id, registrationProcessFailure.id) && this.addToBackStack == registrationProcessFailure.addToBackStack && this.step == registrationProcessFailure.step && this.error == registrationProcessFailure.error;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationProcessBase
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final Error getError() {
        return this.error;
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
        return this.error.hashCode() + ((this.step.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31)) * 31);
    }

    public String toString() {
        return "RegistrationProcessFailure(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", step=" + this.step + ", error=" + this.error + ")";
    }
}
