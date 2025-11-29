package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$color;

/* renamed from: npi.spay.s4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1906s4 {
    public final int a;
    public final Integer b;
    public final int c;
    public final Long d;
    public final boolean e;

    public C1906s4(int i, Integer num, int i2, Long l, boolean z) {
        this.a = i;
        this.b = num;
        this.c = i2;
        this.d = l;
        this.e = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1906s4)) {
            return false;
        }
        C1906s4 c1906s4 = (C1906s4) obj;
        return this.a == c1906s4.a && Intrinsics.areEqual(this.b, c1906s4.b) && this.c == c1906s4.c && Intrinsics.areEqual(this.d, c1906s4.d) && this.e == c1906s4.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        Integer num = this.b;
        int iHashCode2 = (Integer.hashCode(this.c) + ((iHashCode + (num == null ? 0 : num.hashCode())) * 31)) * 31;
        Long l = this.d;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z = this.e;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ResendCodeStatusBtn(textRes=");
        sb.append(this.a);
        sb.append(", pluralsRes=");
        sb.append(this.b);
        sb.append(", textColorRes=");
        sb.append(this.c);
        sb.append(", timerTick=");
        sb.append(this.d);
        sb.append(", isClickable=");
        return AbstractC1901s.a(sb, this.e, ')');
    }

    public /* synthetic */ C1906s4(int i, Integer num, int i2, Long l, boolean z, int i3) {
        this(i, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? R$color.spay_text_color_grey : i2, (i3 & 8) != 0 ? null : l, (i3 & 16) != 0 ? false : z);
    }
}
