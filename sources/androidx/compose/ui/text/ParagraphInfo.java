package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: MultiParagraph.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\u0011\u0010\u0012\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u000fJ\u0011\u0010\u0013\u001a\u00020\t*\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\t*\u00020\t¢\u0006\u0004\b\u0015\u0010\u0014J\u0014\u0010\u0019\u001a\u00020\u0016*\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001b\u001a\u00020\u001a*\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u0019\u001a\u00020\u001a*\u00020\u001a¢\u0006\u0004\b\u0019\u0010\u001cJ\u0011\u0010\u001b\u001a\u00020\u001d*\u00020\u001d¢\u0006\u0004\b\u001b\u0010\u001eJ\u001e\u0010\u001b\u001a\u00020\u001f*\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u0010(R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b1\u0010(R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010/\u001a\u0004\b2\u0010(\"\u0004\b3\u00104R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010/\u001a\u0004\b5\u0010(\"\u0004\b6\u00104R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00107\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R\u0011\u0010?\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b>\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/compose/ui/text/ParagraphInfo;", "", "Landroidx/compose/ui/text/Paragraph;", "paragraph", "", "startIndex", "endIndex", "startLineIndex", "endLineIndex", "", "top", "bottom", "<init>", "(Landroidx/compose/ui/text/Paragraph;IIIIFF)V", "toLocalIndex", "(I)I", "toGlobalIndex", "toLocalLineIndex", "toGlobalLineIndex", "toGlobalYPosition", "(F)F", "toLocalYPosition", "Landroidx/compose/ui/geometry/Offset;", "toLocal-MK-Hz9U", "(J)J", "toLocal", "Landroidx/compose/ui/geometry/Rect;", "toGlobal", "(Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/TextRange;", "", "treatZeroAsNull", "toGlobal-xdX6-G0", "(JZ)J", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/text/Paragraph;", "getParagraph", "()Landroidx/compose/ui/text/Paragraph;", "I", "getStartIndex", "getEndIndex", "getStartLineIndex", "setStartLineIndex", "(I)V", "getEndLineIndex", "setEndLineIndex", "F", "getTop", "()F", "setTop", "(F)V", "getBottom", "setBottom", "getLength", "length", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ParagraphInfo {
    private float bottom;
    private final int endIndex;
    private int endLineIndex;
    private final Paragraph paragraph;
    private final int startIndex;
    private int startLineIndex;
    private float top;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParagraphInfo)) {
            return false;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) other;
        return Intrinsics.areEqual(this.paragraph, paragraphInfo.paragraph) && this.startIndex == paragraphInfo.startIndex && this.endIndex == paragraphInfo.endIndex && this.startLineIndex == paragraphInfo.startLineIndex && this.endLineIndex == paragraphInfo.endLineIndex && Float.compare(this.top, paragraphInfo.top) == 0 && Float.compare(this.bottom, paragraphInfo.bottom) == 0;
    }

    public int hashCode() {
        return (((((((((((this.paragraph.hashCode() * 31) + Integer.hashCode(this.startIndex)) * 31) + Integer.hashCode(this.endIndex)) * 31) + Integer.hashCode(this.startLineIndex)) * 31) + Integer.hashCode(this.endLineIndex)) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.bottom);
    }

    public String toString() {
        return "ParagraphInfo(paragraph=" + this.paragraph + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startLineIndex=" + this.startLineIndex + ", endLineIndex=" + this.endLineIndex + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }

    public ParagraphInfo(Paragraph paragraph, int i, int i2, int i3, int i4, float f, float f2) {
        this.paragraph = paragraph;
        this.startIndex = i;
        this.endIndex = i2;
        this.startLineIndex = i3;
        this.endLineIndex = i4;
        this.top = f;
        this.bottom = f2;
    }

    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getStartLineIndex() {
        return this.startLineIndex;
    }

    public final int getEndLineIndex() {
        return this.endLineIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final int getLength() {
        return this.endIndex - this.startIndex;
    }

    public final int toLocalIndex(int i) {
        return RangesKt.coerceIn(i, this.startIndex, this.endIndex) - this.startIndex;
    }

    public final int toGlobalIndex(int i) {
        return i + this.startIndex;
    }

    public final int toLocalLineIndex(int i) {
        return i - this.startLineIndex;
    }

    public final int toGlobalLineIndex(int i) {
        return i + this.startLineIndex;
    }

    public final float toGlobalYPosition(float f) {
        return f + this.top;
    }

    public final float toLocalYPosition(float f) {
        return f - this.top;
    }

    /* renamed from: toLocal-MK-Hz9U, reason: not valid java name */
    public final long m1722toLocalMKHz9U(long j) {
        return OffsetKt.Offset(Offset.m842getXimpl(j), Offset.m843getYimpl(j) - this.top);
    }

    public final Rect toGlobal(Rect rect) {
        return rect.m863translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
    }

    public final Rect toLocal(Rect rect) {
        return rect.m863translatek4lQ0M(OffsetKt.Offset(0.0f, -this.top));
    }

    public final Path toGlobal(Path path) {
        path.mo924translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
        return path;
    }

    /* renamed from: toGlobal-xdX6-G0$default, reason: not valid java name */
    public static /* synthetic */ long m1720toGlobalxdX6G0$default(ParagraphInfo paragraphInfo, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return paragraphInfo.m1721toGlobalxdX6G0(j, z);
    }

    /* renamed from: toGlobal-xdX6-G0, reason: not valid java name */
    public final long m1721toGlobalxdX6G0(long j, boolean z) {
        if (z) {
            TextRange.Companion companion = TextRange.INSTANCE;
            if (TextRange.m1785equalsimpl0(j, companion.m1797getZerod9O1mEE())) {
                return companion.m1797getZerod9O1mEE();
            }
        }
        return TextRangeKt.TextRange(toGlobalIndex(TextRange.m1792getStartimpl(j)), toGlobalIndex(TextRange.m1787getEndimpl(j)));
    }
}
