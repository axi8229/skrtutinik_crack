package ru.yoomoney.sdk.yooprofiler;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/yooprofiler/ProfileEventType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PAYMENT", "REGISTRATION", "DETAILS_CHANGE", "YACARD_3DS2", "PASSWORD_RESET", "LOGIN", "TRANSACTION_OTHER", "C2C", "RKO_CREATION", "RKO_PAYMENT", "RKO_LOGIN", "RKO_DETAILS_CHANGE", "MERCHANT_SHOP_REGISTRATION", "PARTNER_CARD", "yooprofiler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileEventType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProfileEventType[] $VALUES;
    private final String value;
    public static final ProfileEventType PAYMENT = new ProfileEventType("PAYMENT", 0, "payment");
    public static final ProfileEventType REGISTRATION = new ProfileEventType("REGISTRATION", 1, "registration");
    public static final ProfileEventType DETAILS_CHANGE = new ProfileEventType("DETAILS_CHANGE", 2, "details_change");
    public static final ProfileEventType YACARD_3DS2 = new ProfileEventType("YACARD_3DS2", 3, "yacard_3ds2");
    public static final ProfileEventType PASSWORD_RESET = new ProfileEventType("PASSWORD_RESET", 4, "password_reset");
    public static final ProfileEventType LOGIN = new ProfileEventType("LOGIN", 5, "login");
    public static final ProfileEventType TRANSACTION_OTHER = new ProfileEventType("TRANSACTION_OTHER", 6, "transaction_other");
    public static final ProfileEventType C2C = new ProfileEventType("C2C", 7, "c2c");
    public static final ProfileEventType RKO_CREATION = new ProfileEventType("RKO_CREATION", 8, "rko_creation");
    public static final ProfileEventType RKO_PAYMENT = new ProfileEventType("RKO_PAYMENT", 9, "rko_payment");
    public static final ProfileEventType RKO_LOGIN = new ProfileEventType("RKO_LOGIN", 10, "rko_login");
    public static final ProfileEventType RKO_DETAILS_CHANGE = new ProfileEventType("RKO_DETAILS_CHANGE", 11, "rko_details_change");
    public static final ProfileEventType MERCHANT_SHOP_REGISTRATION = new ProfileEventType("MERCHANT_SHOP_REGISTRATION", 12, "merchant_shop_registration");
    public static final ProfileEventType PARTNER_CARD = new ProfileEventType("PARTNER_CARD", 13, "partner_card");

    private static final /* synthetic */ ProfileEventType[] $values() {
        return new ProfileEventType[]{PAYMENT, REGISTRATION, DETAILS_CHANGE, YACARD_3DS2, PASSWORD_RESET, LOGIN, TRANSACTION_OTHER, C2C, RKO_CREATION, RKO_PAYMENT, RKO_LOGIN, RKO_DETAILS_CHANGE, MERCHANT_SHOP_REGISTRATION, PARTNER_CARD};
    }

    static {
        ProfileEventType[] profileEventTypeArr$values = $values();
        $VALUES = profileEventTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(profileEventTypeArr$values);
    }

    private ProfileEventType(String str, int i, String str2) {
        this.value = str2;
    }

    public static EnumEntries<ProfileEventType> getEntries() {
        return $ENTRIES;
    }

    public static ProfileEventType valueOf(String str) {
        return (ProfileEventType) Enum.valueOf(ProfileEventType.class, str);
    }

    public static ProfileEventType[] values() {
        return (ProfileEventType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
