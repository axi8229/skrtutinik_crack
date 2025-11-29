package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import java.util.Comparator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2321e;

/* loaded from: classes5.dex */
public final class M1 implements Function2 {
    public final C2395a a = new C2395a();

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AbstractC2330n invoke(EnumC2321e defaultAuthType, AbstractC2330n[] authTypeStates) {
        Intrinsics.checkNotNullParameter(defaultAuthType, "defaultAuthType");
        Intrinsics.checkNotNullParameter(authTypeStates, "authTypeStates");
        AbstractC2330n abstractC2330n = null;
        AbstractC2330n[] abstractC2330nArr = ArraysKt.contains(this.a.a, defaultAuthType) ? authTypeStates : null;
        if (abstractC2330nArr != null) {
            int length = abstractC2330nArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AbstractC2330n abstractC2330n2 = abstractC2330nArr[i];
                if (abstractC2330n2.a() == defaultAuthType) {
                    abstractC2330n = abstractC2330n2;
                    break;
                }
                i++;
            }
            if (abstractC2330n != null) {
                return abstractC2330n;
            }
        }
        Sequence sequenceFilter = SequencesKt.filter(ArraysKt.asSequence(authTypeStates), new K1(this));
        final L1 l1 = new L1(this);
        return (AbstractC2330n) SequencesKt.first(SequencesKt.sortedWith(sequenceFilter, new Comparator() { // from class: ru.yoomoney.sdk.kassa.payments.paymentAuth.M1$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return M1.a(l1, obj, obj2);
            }
        }));
    }

    public static final int a(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }
}
