package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextStyle.android.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/PlatformTextStyle;", "", "Landroidx/compose/ui/text/PlatformSpanStyle;", "spanStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "paragraphStyle", "<init>", "(Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/text/PlatformParagraphStyle;)V", "", "includeFontPadding", "(Z)V", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "getParagraphStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "Landroidx/compose/ui/text/PlatformSpanStyle;", "getSpanStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformTextStyle {

    /* renamed from: paragraphStyle, reason: from kotlin metadata and from toString */
    private final PlatformParagraphStyle paragraphSyle;

    public final PlatformSpanStyle getSpanStyle() {
        return null;
    }

    /* renamed from: getParagraphStyle, reason: from getter */
    public final PlatformParagraphStyle getParagraphSyle() {
        return this.paragraphSyle;
    }

    public PlatformTextStyle(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        this.paragraphSyle = platformParagraphStyle;
    }

    public PlatformTextStyle(boolean z) {
        this(null, new PlatformParagraphStyle(z));
    }

    public int hashCode() {
        PlatformParagraphStyle platformParagraphStyle = this.paragraphSyle;
        if (platformParagraphStyle != null) {
            return platformParagraphStyle.hashCode();
        }
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformTextStyle)) {
            return false;
        }
        PlatformTextStyle platformTextStyle = (PlatformTextStyle) other;
        if (!Intrinsics.areEqual(this.paragraphSyle, platformTextStyle.paragraphSyle)) {
            return false;
        }
        platformTextStyle.getClass();
        return Intrinsics.areEqual(null, null);
    }

    public String toString() {
        return "PlatformTextStyle(spanStyle=" + ((Object) null) + ", paragraphSyle=" + this.paragraphSyle + ')';
    }
}
