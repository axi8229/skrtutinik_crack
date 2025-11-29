package androidx.compose.ui.text.style;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LineHeightStyle.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle;", "", "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PIaL0Z0", "()F", "F", "getTrim-EVpEnUU", "()I", "I", "equals", "", "other", "hashCode", "", "toString", "", "Alignment", "Companion", "Trim", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LineHeightStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final LineHeightStyle Default;
    private final float alignment;
    private final int trim;

    public /* synthetic */ LineHeightStyle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i);
    }

    private LineHeightStyle(float f, int i) {
        this.alignment = f;
        this.trim = i;
    }

    /* renamed from: getAlignment-PIaL0Z0, reason: not valid java name and from getter */
    public final float getAlignment() {
        return this.alignment;
    }

    /* renamed from: getTrim-EVpEnUU, reason: not valid java name and from getter */
    public final int getTrim() {
        return this.trim;
    }

    /* compiled from: LineHeightStyle.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        Default = new LineHeightStyle(Alignment.INSTANCE.m2018getProportionalPIaL0Z0(), Trim.INSTANCE.m2025getBothEVpEnUU(), defaultConstructorMarker);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) other;
        return Alignment.m2014equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m2020equalsimpl0(this.trim, lineHeightStyle.trim);
    }

    public int hashCode() {
        return (Alignment.m2015hashCodeimpl(this.alignment) * 31) + Trim.m2021hashCodeimpl(this.trim);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.m2016toStringimpl(this.alignment)) + ", trim=" + ((Object) Trim.m2024toStringimpl(this.trim)) + ')';
    }

    /* compiled from: LineHeightStyle.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(I)I", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "", "isTrimFirstLineTop-impl$ui_text_release", "(I)Z", "isTrimFirstLineTop", "isTrimLastLineBottom-impl$ui_text_release", "isTrimLastLineBottom", "hashCode-impl", "hashCode", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Trim {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int FirstLineTop = m2019constructorimpl(1);
        private static final int LastLineBottom = m2019constructorimpl(16);
        private static final int Both = m2019constructorimpl(17);
        private static final int None = m2019constructorimpl(0);

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m2019constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2020equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2021hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* renamed from: isTrimFirstLineTop-impl$ui_text_release, reason: not valid java name */
        public static final boolean m2022isTrimFirstLineTopimpl$ui_text_release(int i) {
            return (i & 1) > 0;
        }

        /* renamed from: isTrimLastLineBottom-impl$ui_text_release, reason: not valid java name */
        public static final boolean m2023isTrimLastLineBottomimpl$ui_text_release(int i) {
            return (i & 16) > 0;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2024toStringimpl(int i) {
            return i == FirstLineTop ? "LineHeightStyle.Trim.FirstLineTop" : i == LastLineBottom ? "LineHeightStyle.Trim.LastLineBottom" : i == Both ? "LineHeightStyle.Trim.Both" : i == None ? "LineHeightStyle.Trim.None" : "Invalid";
        }

        /* compiled from: LineHeightStyle.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "Both", "I", "getBoth-EVpEnUU", "()I", "None", "getNone-EVpEnUU", "", "FlagTrimBottom", "FlagTrimTop", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getBoth-EVpEnUU, reason: not valid java name */
            public final int m2025getBothEVpEnUU() {
                return Trim.Both;
            }

            /* renamed from: getNone-EVpEnUU, reason: not valid java name */
            public final int m2026getNoneEVpEnUU() {
                return Trim.None;
            }
        }
    }

    /* compiled from: LineHeightStyle.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\f\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "", "", "topRatio", "constructor-impl", "(F)F", "", "toString-impl", "(F)Ljava/lang/String;", "toString", "", "hashCode-impl", "(F)I", "hashCode", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Alignment {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final float Top = m2013constructorimpl(0.0f);
        private static final float Center = m2013constructorimpl(0.5f);
        private static final float Proportional = m2013constructorimpl(-1.0f);
        private static final float Bottom = m2013constructorimpl(1.0f);

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2014equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2015hashCodeimpl(float f) {
            return Float.hashCode(f);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static float m2013constructorimpl(float f) {
            if ((0.0f > f || f > 1.0f) && f != -1.0f) {
                throw new IllegalStateException("topRatio should be in [0..1] range or -1");
            }
            return f;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2016toStringimpl(float f) {
            if (f == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f + ')';
        }

        /* compiled from: LineHeightStyle.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "Center", "F", "getCenter-PIaL0Z0", "()F", "Proportional", "getProportional-PIaL0Z0", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getCenter-PIaL0Z0, reason: not valid java name */
            public final float m2017getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* renamed from: getProportional-PIaL0Z0, reason: not valid java name */
            public final float m2018getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }
        }
    }
}
