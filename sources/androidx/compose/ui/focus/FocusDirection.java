package androidx.compose.ui.focus;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FocusDirection.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class FocusDirection {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Next = m778constructorimpl(1);
    private static final int Previous = m778constructorimpl(2);
    private static final int Left = m778constructorimpl(3);
    private static final int Right = m778constructorimpl(4);
    private static final int Up = m778constructorimpl(5);
    private static final int Down = m778constructorimpl(6);
    private static final int Enter = m778constructorimpl(7);
    private static final int Exit = m778constructorimpl(8);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FocusDirection m777boximpl(int i) {
        return new FocusDirection(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m778constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m779equalsimpl(int i, Object obj) {
        return (obj instanceof FocusDirection) && i == ((FocusDirection) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m780equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m781hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m779equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m781hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ FocusDirection(int i) {
        this.value = i;
    }

    public String toString() {
        return m782toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m782toStringimpl(int i) {
        if (m780equalsimpl0(i, Next)) {
            return "Next";
        }
        if (m780equalsimpl0(i, Previous)) {
            return "Previous";
        }
        if (m780equalsimpl0(i, Left)) {
            return "Left";
        }
        if (m780equalsimpl0(i, Right)) {
            return "Right";
        }
        if (m780equalsimpl0(i, Up)) {
            return "Up";
        }
        if (m780equalsimpl0(i, Down)) {
            return "Down";
        }
        if (m780equalsimpl0(i, Enter)) {
            return "Enter";
        }
        if (m780equalsimpl0(i, Exit)) {
            return "Exit";
        }
        return "Invalid FocusDirection";
    }

    /* compiled from: FocusDirection.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001d\u0010\r\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u001d\u0010\u0011\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR&\u0010\u0013\u001a\u00020\u00048GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\bR&\u0010\u0016\u001a\u00020\u00048GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/focus/FocusDirection;", "Next", "I", "getNext-dhqQ-8s", "()I", "Previous", "getPrevious-dhqQ-8s", "Left", "getLeft-dhqQ-8s", "Right", "getRight-dhqQ-8s", "Up", "getUp-dhqQ-8s", "Down", "getDown-dhqQ-8s", "Enter", "getEnter-dhqQ-8s", "getEnter-dhqQ-8s$annotations", "Exit", "getExit-dhqQ-8s", "getExit-dhqQ-8s$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNext-dhqQ-8s, reason: not valid java name */
        public final int m788getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        /* renamed from: getPrevious-dhqQ-8s, reason: not valid java name */
        public final int m789getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* renamed from: getLeft-dhqQ-8s, reason: not valid java name */
        public final int m787getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* renamed from: getRight-dhqQ-8s, reason: not valid java name */
        public final int m790getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* renamed from: getUp-dhqQ-8s, reason: not valid java name */
        public final int m791getUpdhqQ8s() {
            return FocusDirection.Up;
        }

        /* renamed from: getDown-dhqQ-8s, reason: not valid java name */
        public final int m784getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        /* renamed from: getEnter-dhqQ-8s, reason: not valid java name */
        public final int m785getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        /* renamed from: getExit-dhqQ-8s, reason: not valid java name */
        public final int m786getExitdhqQ8s() {
            return FocusDirection.Exit;
        }
    }
}
