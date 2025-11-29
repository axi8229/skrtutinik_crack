package ru.yoomoney.sdk.kassa.payments.model.mapper;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.BankCardType;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2333q;

/* loaded from: classes5.dex */
public abstract class e {
    public static final EnumC2333q a(BankCardType bankCardType) {
        Intrinsics.checkNotNullParameter(bankCardType, "<this>");
        switch (d.a[bankCardType.ordinal()]) {
            case 1:
                return EnumC2333q.a;
            case 2:
                return EnumC2333q.b;
            case 3:
                return EnumC2333q.c;
            case 4:
                return EnumC2333q.d;
            case 5:
                return EnumC2333q.e;
            case 6:
                return EnumC2333q.f;
            case 7:
                return EnumC2333q.g;
            case 8:
                return EnumC2333q.h;
            case 9:
                return EnumC2333q.i;
            case 10:
                return EnumC2333q.j;
            case 11:
                return EnumC2333q.k;
            case 12:
                return EnumC2333q.l;
            case 13:
                return EnumC2333q.m;
            case 14:
                return EnumC2333q.n;
            case 15:
                return EnumC2333q.o;
            case 16:
                return EnumC2333q.p;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
