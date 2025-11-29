package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.ConfirmationType;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2333q;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2486j extends Lambda implements Function0 {
    public final /* synthetic */ Iterator a;
    public final /* synthetic */ C2495m b;
    public final /* synthetic */ Amount c;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.model.A d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2486j(Iterator it, C2495m c2495m, Amount amount, ru.yoomoney.sdk.kassa.payments.model.A a) {
        super(0);
        this.a = it;
        this.b = c2495m;
        this.c = amount;
        this.d = a;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String strJoinToString$default = SequencesKt.joinToString$default(SequencesKt.take(SequencesKt.generateSequence(new C2483i(this.b)), 16), "", null, null, 0, null, null, 62, null);
        int iIntValue = ((Number) this.a.next()).intValue();
        C2495m c2495m = this.b;
        c2495m.getClass();
        return new LinkedCard(iIntValue, this.c, this.d, null, null, strJoinToString$default, EnumC2333q.values()[c2495m.d.nextInt(EnumC2333q.values().length)], StringsKt.replaceRange(strJoinToString$default, 4, 12, StringsKt.repeat("*", 8)).toString(), this.b.d.nextInt(10) < 5 ? "testCardName" : null, true, true, CollectionsKt.listOf(ConfirmationType.REDIRECT), false);
    }
}
