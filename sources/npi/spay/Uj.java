package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* loaded from: classes4.dex */
public final class Uj {
    public final String a = b();
    public final String b = a();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(Integer.toHexString(Random.INSTANCE.nextInt(16)));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(Integer.toHexString(Random.INSTANCE.nextInt(16)));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String toString() {
        return "B3HeaderBuilder(traceId='" + this.a + "', spanId='" + this.b + "')";
    }
}
