package npi.spay;

import java.util.Locale;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: npi.spay.ui, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1970ui extends AbstractC1914sc {
    public final InterfaceC1495bg a;

    public C1970ui(InterfaceC1495bg reducer) {
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        this.a = reducer;
    }

    public final Object a() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char cCharAt = string.charAt(i);
            if (cCharAt != '-') {
                sb.append(cCharAt);
            }
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "filterNotTo(StringBuilder(), predicate).toString()");
        String upperCase = StringsKt.take(string2, 12).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        ((Jh) this.a).a(new Xn(upperCase));
        return Unit.INSTANCE;
    }
}
