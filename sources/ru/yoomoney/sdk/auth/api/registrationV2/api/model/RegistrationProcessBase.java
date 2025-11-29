package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@JsonSubTypes({@JsonSubTypes.Type(name = "AcquireAuthorization", value = RegistrationProcessAcquireAuthorization.class), @JsonSubTypes.Type(name = "Failure", value = RegistrationProcessFailure.class), @JsonSubTypes.Type(name = "Require2faEmail", value = RegistrationProcessRequire2faEmail.class), @JsonSubTypes.Type(name = "Require2faPhone", value = RegistrationProcessRequire2faPhone.class), @JsonSubTypes.Type(name = "SetEmail", value = RegistrationProcessSetEmail.class), @JsonSubTypes.Type(name = "SetPassword", value = RegistrationProcessSetPassword.class), @JsonSubTypes.Type(name = "SetPhone", value = RegistrationProcessSetPhone.class), @JsonSubTypes.Type(name = "Success", value = RegistrationProcessSuccess.class)})
@JsonTypeInfo(defaultImpl = RegistrationProcessBaseDefaultType.class, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "step", use = JsonTypeInfo.Id.NAME, visible = true)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\t\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase;", "", "()V", "addToBackStack", "", "getAddToBackStack", "()Z", "id", "", "getId", "()Ljava/lang/String;", "step", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "getStep", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "Step", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessAcquireAuthorization;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBaseDefaultType;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessFailure;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessRequire2faEmail;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessRequire2faPhone;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessSetEmail;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessSetPassword;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessSetPhone;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RegistrationProcessBase {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationProcessBase$Step;", "", "(Ljava/lang/String;I)V", "SET_PHONE", "REQUIRE2FA_PHONE", "SET_PASSWORD", "SET_EMAIL", "REQUIRE2FA_EMAIL", "ACQUIRE_AUTHORIZATION", "SUCCESS", "FAILURE", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Step {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Step[] $VALUES;

        @JsonProperty("SetPhone")
        public static final Step SET_PHONE = new Step("SET_PHONE", 0);

        @JsonProperty("Require2faPhone")
        public static final Step REQUIRE2FA_PHONE = new Step("REQUIRE2FA_PHONE", 1);

        @JsonProperty("SetPassword")
        public static final Step SET_PASSWORD = new Step("SET_PASSWORD", 2);

        @JsonProperty("SetEmail")
        public static final Step SET_EMAIL = new Step("SET_EMAIL", 3);

        @JsonProperty("Require2faEmail")
        public static final Step REQUIRE2FA_EMAIL = new Step("REQUIRE2FA_EMAIL", 4);

        @JsonProperty("AcquireAuthorization")
        public static final Step ACQUIRE_AUTHORIZATION = new Step("ACQUIRE_AUTHORIZATION", 5);

        @JsonProperty("Success")
        public static final Step SUCCESS = new Step("SUCCESS", 6);

        @JsonProperty("Failure")
        public static final Step FAILURE = new Step("FAILURE", 7);

        @JsonEnumDefaultValue
        public static final Step UNKNOWN_ENUM = new Step("UNKNOWN_ENUM", 8);

        private static final /* synthetic */ Step[] $values() {
            return new Step[]{SET_PHONE, REQUIRE2FA_PHONE, SET_PASSWORD, SET_EMAIL, REQUIRE2FA_EMAIL, ACQUIRE_AUTHORIZATION, SUCCESS, FAILURE, UNKNOWN_ENUM};
        }

        static {
            Step[] stepArr$values = $values();
            $VALUES = stepArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stepArr$values);
        }

        private Step(String str, int i) {
        }

        public static EnumEntries<Step> getEntries() {
            return $ENTRIES;
        }

        public static Step valueOf(String str) {
            return (Step) Enum.valueOf(Step.class, str);
        }

        public static Step[] values() {
            return (Step[]) $VALUES.clone();
        }
    }

    private RegistrationProcessBase() {
    }

    public /* synthetic */ RegistrationProcessBase(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean getAddToBackStack();

    public abstract String getId();

    public abstract Step getStep();
}
