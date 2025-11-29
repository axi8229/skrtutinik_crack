package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class Pl {
    private final Context a;
    private final C1362xb b;
    private final Bb c;

    public Pl(Context context, C1362xb c1362xb, Bb bb) {
        this.a = context;
        this.b = c1362xb;
        this.c = bb;
    }

    private final String b() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        String strReplace$default = StringsKt.replace$default(string, "-", "", false, 4, (Object) null);
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
        if (strReplace$default == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strReplace$default.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final String a() {
        byte[] bArrDigest;
        C1410zb c1410zbA = this.b.a(this.a, new Hb(5, 500));
        Intrinsics.checkNotNullExpressionValue(c1410zbA, "advertisingIdGetter.getI…sedRetryStrategy(5, 500))");
        C1290ub c1290ubC = c1410zbA.c();
        Intrinsics.checkNotNullExpressionValue(c1290ubC, "advertisingIdGetter.getI…yStrategy(5, 500)).yandex");
        if (!c1290ubC.a()) {
            String strA = this.c.a().a();
            if (strA != null && strA.length() != 0) {
                try {
                    UUID.fromString(strA);
                    if (!Intrinsics.areEqual(strA, "00000000-0000-0000-0000-000000000000")) {
                        return StringsKt.replace$default(strA, "-", "", false, 4, (Object) null);
                    }
                } catch (Throwable unused) {
                }
            }
            return b();
        }
        C1266tb c1266tb = c1290ubC.a;
        Intrinsics.checkNotNull(c1266tb);
        String str = c1266tb.b;
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNullExpressionValue(str, "yandexAdvId.mAdTrackingInfo!!.advId!!");
        Charset charset = Charsets.UTF_8;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        try {
            bArrDigest = MessageDigest.getInstance("MD5").digest(bytes);
        } catch (NoSuchAlgorithmException unused2) {
            bArrDigest = new byte[0];
        }
        String strA2 = C0810b.a(bArrDigest);
        Intrinsics.checkNotNullExpressionValue(strA2, "StringUtils.toHexString(…!.advId!!.toByteArray()))");
        return strA2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Pl(Context context) {
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        C1362xb c1362xbR = f0G.r();
        Intrinsics.checkNotNullExpressionValue(c1362xbR, "GlobalServiceLocator.get…ternalAdvertisingIdGetter");
        F0 f0G2 = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G2, "GlobalServiceLocator.getInstance()");
        Bb bbA = f0G2.a();
        Intrinsics.checkNotNullExpressionValue(bbA, "GlobalServiceLocator.getInstance().appSetIdGetter");
        this(context, c1362xbR, bbA);
    }
}
