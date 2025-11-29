package npi.spay;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* renamed from: npi.spay.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1603g {
    public static final Regex f = new Regex("\\r\\n|\\r|\\n|\\t");
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final LinkedHashMap e;

    public C1603g(String eventName) {
        EnumC1578f eventType = EnumC1578f.BUSINESS;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.a = eventType.a();
        this.b = a(eventName, "unknownAction");
        this.c = a(this);
        this.d = a(this);
        this.e = new LinkedHashMap();
    }

    public static String a(String str, String str2) {
        String strReplace;
        if (str == null || str.length() == 0) {
            strReplace = "";
        } else {
            strReplace = f.replace(StringsKt.replace$default(str, '=', '-', false, 4, (Object) null), " ");
            if (strReplace.length() > 256) {
                strReplace = strReplace.substring(0, 256);
                Intrinsics.checkNotNullExpressionValue(strReplace, "this as java.lang.String…ing(startIndex, endIndex)");
            }
        }
        return strReplace.length() == 0 ? str2 : strReplace;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(C1603g.class, obj != null ? obj.getClass() : null) || hashCode() != obj.hashCode()) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type ru.sber.platform.clickstream.clickstreamlite.ClickstreamEvent");
        C1603g c1603g = (C1603g) obj;
        return Intrinsics.areEqual(this.b, c1603g.b) && Intrinsics.areEqual(this.a, c1603g.a) && Intrinsics.areEqual(this.c, c1603g.c) && Intrinsics.areEqual(this.d, c1603g.d) && Intrinsics.areEqual(this.e, c1603g.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + AbstractC1553e.a(this.d, AbstractC1553e.a(this.c, AbstractC1553e.a(this.a, this.b.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        return "ClickstreamEvent(eventAction=" + this.b + ", internalEventType=" + this.a + ", internalEventCategory=" + this.c + ", internalValue=" + this.d + ", properties=" + this.e + ')';
    }

    public static /* synthetic */ String a(C1603g c1603g) {
        c1603g.getClass();
        return a(null, "");
    }
}
