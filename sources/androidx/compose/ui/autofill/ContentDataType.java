package androidx.compose.ui.autofill;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ContentDataType.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0081@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/autofill/ContentDataType;", "", "", "dataType", "constructor-impl", "(I)I", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "hashCode-impl", "hashCode", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "equals", "I", "getDataType", "()I", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ContentDataType {
    private final int dataType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Text = m757constructorimpl(1);
    private static final int List = m757constructorimpl(3);
    private static final int Date = m757constructorimpl(4);
    private static final int Toggle = m757constructorimpl(2);
    private static final int None = m757constructorimpl(0);

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m757constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m758equalsimpl(int i, Object obj) {
        return (obj instanceof ContentDataType) && i == ((ContentDataType) obj).getDataType();
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m759hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m760toStringimpl(int i) {
        return "ContentDataType(dataType=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m758equalsimpl(this.dataType, obj);
    }

    public int hashCode() {
        return m759hashCodeimpl(this.dataType);
    }

    public String toString() {
        return m760toStringimpl(this.dataType);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getDataType() {
        return this.dataType;
    }

    /* compiled from: ContentDataType.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/autofill/ContentDataType$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/autofill/ContentDataType;", "Text", "I", "getText-A48pgw8", "()I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getText-A48pgw8, reason: not valid java name */
        public final int m762getTextA48pgw8() {
            return ContentDataType.Text;
        }
    }
}
