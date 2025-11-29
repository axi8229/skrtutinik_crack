package npi.spay;

/* renamed from: npi.spay.c1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC1505c1 implements InterfaceC1852q {
    MA_INIT("MAInit"),
    /* JADX INFO: Fake field, exist only in values array */
    MA_IS_READY_FOR_SPAY("MAIsReadyForSpay"),
    /* JADX INFO: Fake field, exist only in values array */
    MAC_IS_READY_FOR_SPAY("MACIsReadyForSpay"),
    /* JADX INFO: Fake field, exist only in values array */
    MA_GET_PAYMENT_TOKEN("MAGetPaymentToken"),
    MAC_GET_PAYMENT_TOKEN("MACGetPaymentToken"),
    MAPay("MAPay"),
    MACPay("MACPay"),
    MA_PAY_WITH_BANK_INVOICE_ID("MAPayWithBankInvoiceId"),
    /* JADX INFO: Fake field, exist only in values array */
    MAC_PAY_WITH_BANK_INVOICE_ID("MACPayWithBankInvoiceId"),
    /* JADX INFO: Fake field, exist only in values array */
    MA_COMPLETE_PAYMENT("MACompletePayment"),
    /* JADX INFO: Fake field, exist only in values array */
    MAC_COMPLETE_PAYMENT("MACCompletePayment");

    public final String a;

    EnumC1505c1(String str) {
        this.a = str;
    }

    @Override // npi.spay.InterfaceC1852q
    public final String a() {
        return this.a;
    }
}
