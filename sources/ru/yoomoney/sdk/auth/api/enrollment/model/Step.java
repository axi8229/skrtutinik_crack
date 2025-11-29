package ru.yoomoney.sdk.auth.api.enrollment.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/model/Step;", "", "(Ljava/lang/String;I)V", "SET_PHONE", "CONFIRM_PHONE", "SET_PASSWORD", "SUGGEST_ACCOUNT", "SET_EMAIL", "CONFIRM_EMAIL", "ACQUIRE_AUTHORIZATION", "ENROLLMENT_FAILURE", "ENROLLMENT_SUCCESS", "FORCE_LOGIN", "ACCEPT_TERMS", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Step {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Step[] $VALUES;

    @SerializedName("SetPhone")
    public static final Step SET_PHONE = new Step("SET_PHONE", 0);

    @SerializedName("ConfirmPhone")
    public static final Step CONFIRM_PHONE = new Step("CONFIRM_PHONE", 1);

    @SerializedName("SetPassword")
    public static final Step SET_PASSWORD = new Step("SET_PASSWORD", 2);

    @SerializedName("SuggestAccount")
    public static final Step SUGGEST_ACCOUNT = new Step("SUGGEST_ACCOUNT", 3);

    @SerializedName("SetEmail")
    public static final Step SET_EMAIL = new Step("SET_EMAIL", 4);

    @SerializedName("ConfirmEmail")
    public static final Step CONFIRM_EMAIL = new Step("CONFIRM_EMAIL", 5);

    @SerializedName("AcquireAuthorization")
    public static final Step ACQUIRE_AUTHORIZATION = new Step("ACQUIRE_AUTHORIZATION", 6);

    @SerializedName("EnrollmentFailure")
    public static final Step ENROLLMENT_FAILURE = new Step("ENROLLMENT_FAILURE", 7);

    @SerializedName("EnrollmentSuccess")
    public static final Step ENROLLMENT_SUCCESS = new Step("ENROLLMENT_SUCCESS", 8);

    @SerializedName("ForceLogin")
    public static final Step FORCE_LOGIN = new Step("FORCE_LOGIN", 9);

    @SerializedName("AcceptTerms")
    public static final Step ACCEPT_TERMS = new Step("ACCEPT_TERMS", 10);

    private static final /* synthetic */ Step[] $values() {
        return new Step[]{SET_PHONE, CONFIRM_PHONE, SET_PASSWORD, SUGGEST_ACCOUNT, SET_EMAIL, CONFIRM_EMAIL, ACQUIRE_AUTHORIZATION, ENROLLMENT_FAILURE, ENROLLMENT_SUCCESS, FORCE_LOGIN, ACCEPT_TERMS};
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
