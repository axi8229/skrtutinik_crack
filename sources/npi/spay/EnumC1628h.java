package npi.spay;

/* renamed from: npi.spay.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1628h {
    REFRESH_TOKEN("refreshToken"),
    BNPL("bnpl"),
    COMPOUND_WALLET("compoundWallet"),
    CARD_BALANCE("cardBalance"),
    CARD_HELPER_BNPL("bnpl"),
    CARD_HELPER_SBP("sbp"),
    CARD_HELPER_CREDIT("newCreditCard"),
    CARD_HELPER_DEBIT("newDebitCard"),
    RETRIES("retries"),
    S_BONUSES("spasiboBonuses"),
    CARD_LIST_SORT("sortListCards"),
    USE_CACHED_CARDS_LIST("useCachedCardsList"),
    SSL("ssl"),
    DYNATRACE_METRICS("dynatrace"),
    CLICKSTREAM_METRICS("clickStream"),
    LOCAL_SESSION_ID("localSessionId");

    public final String a;

    EnumC1628h(String str) {
        this.a = str;
    }
}
