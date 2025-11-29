package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import java.util.Comparator;
import kotlin.collections.ArraysKt;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2321e;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2395a implements Comparator {
    public final EnumC2321e[] a = {EnumC2321e.a, EnumC2321e.b, EnumC2321e.c, EnumC2321e.d, null};

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(EnumC2321e enumC2321e, EnumC2321e enumC2321e2) {
        if (!ArraysKt.contains(this.a, enumC2321e)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (!ArraysKt.contains(this.a, enumC2321e2)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (enumC2321e == enumC2321e2) {
            return 0;
        }
        if (enumC2321e == null) {
            return 1;
        }
        if (enumC2321e2 == null) {
            return -1;
        }
        return enumC2321e.compareTo(enumC2321e2);
    }
}
