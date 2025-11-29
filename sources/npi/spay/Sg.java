package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import spay.sdk.domain.model.PayPartsStatus;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Sg extends Lambda implements Function0 {
    public final /* synthetic */ Jh a;
    public final /* synthetic */ ListOfCardsResponseBody.PaymentToolInfo.Tool b;
    public final /* synthetic */ boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Sg(Jh jh, ListOfCardsResponseBody.PaymentToolInfo.Tool tool, boolean z) {
        super(0);
        this.a = jh;
        this.b = tool;
        this.c = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Jh jh = this.a;
        Ei ei = jh.a;
        ListOfCardsResponseBody.PaymentToolInfo.Tool tool = this.b;
        boolean z = this.c;
        PayPartsStatus payPartsStatus = ((Di) jh.b).y;
        ((C1822oj) ei).a((payPartsStatus == PayPartsStatus.ONLY_PARTS_PAY || payPartsStatus == PayPartsStatus.PARTS_START_PAY) ? new C1606g2(tool, z) : new C1631h2(tool, z));
        return Unit.INSTANCE;
    }
}
