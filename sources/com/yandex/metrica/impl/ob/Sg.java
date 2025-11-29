package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.AdRevenue;
import com.yandex.metrica.impl.ob.C0851cf;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class Sg {
    private final InterfaceC0934fn<String> a;
    private final InterfaceC0934fn<String> b;
    private final AdRevenue c;

    static final class a extends Lambda implements Function1<byte[], Unit> {
        final /* synthetic */ C0851cf a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C0851cf c0851cf) {
            super(1);
            this.a = c0851cf;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(byte[] bArr) {
            this.a.e = bArr;
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function1<byte[], Unit> {
        final /* synthetic */ C0851cf a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C0851cf c0851cf) {
            super(1);
            this.a = c0851cf;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(byte[] bArr) {
            this.a.h = bArr;
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1<byte[], Unit> {
        final /* synthetic */ C0851cf a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C0851cf c0851cf) {
            super(1);
            this.a = c0851cf;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(byte[] bArr) {
            this.a.i = bArr;
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function1<byte[], Unit> {
        final /* synthetic */ C0851cf a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C0851cf c0851cf) {
            super(1);
            this.a = c0851cf;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(byte[] bArr) {
            this.a.f = bArr;
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function1<byte[], Unit> {
        final /* synthetic */ C0851cf a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C0851cf c0851cf) {
            super(1);
            this.a = c0851cf;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(byte[] bArr) {
            this.a.g = bArr;
            return Unit.INSTANCE;
        }
    }

    static final class f extends Lambda implements Function1<byte[], Unit> {
        final /* synthetic */ C0851cf a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C0851cf c0851cf) {
            super(1);
            this.a = c0851cf;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(byte[] bArr) {
            this.a.j = bArr;
            return Unit.INSTANCE;
        }
    }

    static final class g extends Lambda implements Function1<byte[], Unit> {
        final /* synthetic */ C0851cf a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C0851cf c0851cf) {
            super(1);
            this.a = c0851cf;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(byte[] bArr) {
            this.a.c = bArr;
            return Unit.INSTANCE;
        }
    }

    public Sg(AdRevenue adRevenue, C0858cm c0858cm) {
        this.c = adRevenue;
        this.a = new C0884dn(100, "ad revenue strings", c0858cm);
        this.b = new C0859cn(30720, "ad revenue payload", c0858cm);
    }

    public final Pair<byte[], Integer> a() {
        C0851cf c0851cf = new C0851cf();
        Pair pair = TuplesKt.to(this.c.adNetwork, new a(c0851cf));
        Pair pair2 = TuplesKt.to(this.c.adPlacementId, new b(c0851cf));
        Pair pair3 = TuplesKt.to(this.c.adPlacementName, new c(c0851cf));
        Pair pair4 = TuplesKt.to(this.c.adUnitId, new d(c0851cf));
        Pair pair5 = TuplesKt.to(this.c.adUnitName, new e(c0851cf));
        Pair pair6 = TuplesKt.to(this.c.precision, new f(c0851cf));
        Currency currency = this.c.currency;
        Intrinsics.checkNotNullExpressionValue(currency, "revenue.currency");
        int length = 0;
        for (Pair pair7 : CollectionsKt.listOf((Object[]) new Pair[]{pair, pair2, pair3, pair4, pair5, pair6, TuplesKt.to(currency.getCurrencyCode(), new g(c0851cf))})) {
            String str = (String) pair7.getFirst();
            Function1 function1 = (Function1) pair7.getSecond();
            String strA = this.a.a(str);
            byte[] bArrE = C0810b.e(str);
            Intrinsics.checkNotNullExpressionValue(bArrE, "StringUtils.stringToBytesForProtobuf(value)");
            byte[] bArrE2 = C0810b.e(strA);
            Intrinsics.checkNotNullExpressionValue(bArrE2, "StringUtils.stringToBytesForProtobuf(result)");
            function1.invoke(bArrE2);
            length += bArrE.length - bArrE2.length;
        }
        Integer num = (Integer) Tg.a.get(this.c.adType);
        c0851cf.d = num != null ? num.intValue() : 0;
        C0851cf.a aVar = new C0851cf.a();
        BigDecimal bigDecimal = this.c.adRevenue;
        Intrinsics.checkNotNullExpressionValue(bigDecimal, "revenue.adRevenue");
        Pair pairA = Ol.a(bigDecimal);
        Nl nl = new Nl(((Number) pairA.getFirst()).longValue(), ((Number) pairA.getSecond()).intValue());
        aVar.a = nl.b();
        aVar.b = nl.a();
        c0851cf.b = aVar;
        Map<String, String> map = this.c.payload;
        if (map != null) {
            String strG = Tl.g(map);
            byte[] bArrE3 = C0810b.e(this.b.a(strG));
            Intrinsics.checkNotNullExpressionValue(bArrE3, "StringUtils.stringToByte…oadTrimmer.trim(payload))");
            c0851cf.k = bArrE3;
            length += C0810b.e(strG).length - bArrE3.length;
        }
        return TuplesKt.to(MessageNano.toByteArray(c0851cf), Integer.valueOf(length));
    }
}
