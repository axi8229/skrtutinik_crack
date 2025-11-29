package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/GooglePayCardNetwork;", "", "(Ljava/lang/String;I)V", "AMEX", "DISCOVER", "JCB", "MASTERCARD", "VISA", "INTERAC", "OTHER", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GooglePayCardNetwork {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GooglePayCardNetwork[] $VALUES;

    @Keep
    public static final GooglePayCardNetwork AMEX = new GooglePayCardNetwork("AMEX", 0);

    @Keep
    public static final GooglePayCardNetwork DISCOVER = new GooglePayCardNetwork("DISCOVER", 1);

    @Keep
    public static final GooglePayCardNetwork JCB = new GooglePayCardNetwork("JCB", 2);

    @Keep
    public static final GooglePayCardNetwork MASTERCARD = new GooglePayCardNetwork("MASTERCARD", 3);

    @Keep
    public static final GooglePayCardNetwork VISA = new GooglePayCardNetwork("VISA", 4);

    @Keep
    public static final GooglePayCardNetwork INTERAC = new GooglePayCardNetwork("INTERAC", 5);

    @Keep
    public static final GooglePayCardNetwork OTHER = new GooglePayCardNetwork("OTHER", 6);

    private static final /* synthetic */ GooglePayCardNetwork[] $values() {
        return new GooglePayCardNetwork[]{AMEX, DISCOVER, JCB, MASTERCARD, VISA, INTERAC, OTHER};
    }

    static {
        GooglePayCardNetwork[] googlePayCardNetworkArr$values = $values();
        $VALUES = googlePayCardNetworkArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(googlePayCardNetworkArr$values);
    }

    private GooglePayCardNetwork(String str, int i) {
    }

    public static EnumEntries<GooglePayCardNetwork> getEntries() {
        return $ENTRIES;
    }

    public static GooglePayCardNetwork valueOf(String str) {
        return (GooglePayCardNetwork) Enum.valueOf(GooglePayCardNetwork.class, str);
    }

    public static GooglePayCardNetwork[] values() {
        return (GooglePayCardNetwork[]) $VALUES.clone();
    }
}
