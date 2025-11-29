package androidx.compose.ui.text.style;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LineBreak.android.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0005R\u0017\u0010\u000e\u001a\u00020\f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0017\u0010\u0011\u001a\u00020\u000f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0017\u0010\u0014\u001a\u00020\u00128Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", "", "mask", "constructor-impl", "(I)I", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "hashCode-impl", "hashCode", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getStrategy-fcGXIks", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getStrictness-usljTpc", "strictness", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getWordBreak-jp8hJ3c", "wordBreak", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class LineBreak {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private static final int Unspecified;

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m1984constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1985equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1989hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public static final int m1986getStrategyfcGXIks(int i) {
        return Strategy.m1993constructorimpl(LineBreak_androidKt.unpackByte1(i));
    }

    /* renamed from: getStrictness-usljTpc, reason: not valid java name */
    public static final int m1987getStrictnessusljTpc(int i) {
        return Strictness.m1999constructorimpl(LineBreak_androidKt.unpackByte2(i));
    }

    /* renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public static final int m1988getWordBreakjp8hJ3c(int i) {
        return WordBreak.m2006constructorimpl(LineBreak_androidKt.unpackByte3(i));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1990toStringimpl(int i) {
        return "LineBreak(strategy=" + ((Object) Strategy.m1995toStringimpl(m1986getStrategyfcGXIks(i))) + ", strictness=" + ((Object) Strictness.m2001toStringimpl(m1987getStrictnessusljTpc(i))) + ", wordBreak=" + ((Object) WordBreak.m2008toStringimpl(m1988getWordBreakjp8hJ3c(i))) + ')';
    }

    /* compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/text/style/LineBreak;", "Simple", "I", "getSimple-rAG3T2k", "()I", "getSimple-rAG3T2k$annotations", "Unspecified", "getUnspecified-rAG3T2k", "getUnspecified-rAG3T2k$annotations", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getSimple-rAG3T2k, reason: not valid java name */
        public final int m1991getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        /* renamed from: getUnspecified-rAG3T2k, reason: not valid java name */
        public final int m1992getUnspecifiedrAG3T2k() {
            return LineBreak.Unspecified;
        }
    }

    static {
        Strategy.Companion companion = Strategy.INSTANCE;
        int iM1998getSimplefcGXIks = companion.m1998getSimplefcGXIks();
        Strictness.Companion companion2 = Strictness.INSTANCE;
        int iM2004getNormalusljTpc = companion2.m2004getNormalusljTpc();
        WordBreak.Companion companion3 = WordBreak.INSTANCE;
        Simple = m1984constructorimpl(LineBreak_androidKt.packBytes(iM1998getSimplefcGXIks, iM2004getNormalusljTpc, companion3.m2009getDefaultjp8hJ3c()));
        Heading = m1984constructorimpl(LineBreak_androidKt.packBytes(companion.m1996getBalancedfcGXIks(), companion2.m2003getLooseusljTpc(), companion3.m2010getPhrasejp8hJ3c()));
        Paragraph = m1984constructorimpl(LineBreak_androidKt.packBytes(companion.m1997getHighQualityfcGXIks(), companion2.m2005getStrictusljTpc(), companion3.m2009getDefaultjp8hJ3c()));
        Unspecified = m1984constructorimpl(0);
    }

    /* compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(I)I", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Strategy {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Simple = m1993constructorimpl(1);
        private static final int HighQuality = m1993constructorimpl(2);
        private static final int Balanced = m1993constructorimpl(3);
        private static final int Unspecified = m1993constructorimpl(0);

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m1993constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1994equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "Simple", "I", "getSimple-fcGXIks", "()I", "HighQuality", "getHighQuality-fcGXIks", "Balanced", "getBalanced-fcGXIks", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m1998getSimplefcGXIks() {
                return Strategy.Simple;
            }

            /* renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m1997getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m1996getBalancedfcGXIks() {
                return Strategy.Balanced;
            }
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m1995toStringimpl(int i) {
            return m1994equalsimpl0(i, Simple) ? "Strategy.Simple" : m1994equalsimpl0(i, HighQuality) ? "Strategy.HighQuality" : m1994equalsimpl0(i, Balanced) ? "Strategy.Balanced" : m1994equalsimpl0(i, Unspecified) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    /* compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(I)I", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Strictness {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m1999constructorimpl(1);
        private static final int Loose = m1999constructorimpl(2);
        private static final int Normal = m1999constructorimpl(3);
        private static final int Strict = m1999constructorimpl(4);
        private static final int Unspecified = m1999constructorimpl(0);

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m1999constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2000equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001d\u0010\r\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "Default", "I", "getDefault-usljTpc", "()I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m2002getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m2003getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m2004getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m2005getStrictusljTpc() {
                return Strictness.Strict;
            }
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2001toStringimpl(int i) {
            return m2000equalsimpl0(i, Default) ? "Strictness.None" : m2000equalsimpl0(i, Loose) ? "Strictness.Loose" : m2000equalsimpl0(i, Normal) ? "Strictness.Normal" : m2000equalsimpl0(i, Strict) ? "Strictness.Strict" : m2000equalsimpl0(i, Unspecified) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    /* compiled from: LineBreak.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(I)I", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class WordBreak {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m2006constructorimpl(1);
        private static final int Phrase = m2006constructorimpl(2);
        private static final int Unspecified = m2006constructorimpl(0);

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m2006constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2007equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* compiled from: LineBreak.android.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "Default", "I", "getDefault-jp8hJ3c", "()I", "Phrase", "getPhrase-jp8hJ3c", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m2009getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m2010getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2008toStringimpl(int i) {
            return m2007equalsimpl0(i, Default) ? "WordBreak.None" : m2007equalsimpl0(i, Phrase) ? "WordBreak.Phrase" : m2007equalsimpl0(i, Unspecified) ? "WordBreak.Unspecified" : "Invalid";
        }
    }
}
