package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/Step;", "", "(Ljava/lang/String;I)V", "ENTER_OAUTH_CODE", "SUCCESS", "FAILURE", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Step {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Step[] $VALUES;

    @SerializedName("EnterOauthCode")
    public static final Step ENTER_OAUTH_CODE = new Step("ENTER_OAUTH_CODE", 0);

    @SerializedName("Success")
    public static final Step SUCCESS = new Step("SUCCESS", 1);

    @SerializedName("Failure")
    public static final Step FAILURE = new Step("FAILURE", 2);

    private static final /* synthetic */ Step[] $values() {
        return new Step[]{ENTER_OAUTH_CODE, SUCCESS, FAILURE};
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
