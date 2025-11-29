package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0080\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0000¢\u0006\u0004\b\u001c\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0000¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\"\u001a\u00020\u0015H\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010'\u001a\u00020\u0002H\u0000¢\u0006\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R*\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00102\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R$\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b6\u0010-\u001a\u0004\b7\u0010/R$\u00108\u001a\u00020\f2\u0006\u00105\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b8\u0010-\u001a\u0004\b9\u0010/R\u001c\u0010<\u001a\u0004\u0018\u00010\u00048@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001a\u0010\u0005\u001a\u00020\u00048@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b=\u0010>R$\u0010?\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b@\u0010/\"\u0004\bA\u00101R\u0014\u0010C\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer;", "", "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/TextRange;", "selection", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "hasComposition$ui_text_release", "()Z", "hasComposition", "", "index", "", "get$ui_text_release", "(I)C", "get", "start", "end", "", "", "replace$ui_text_release", "(IILjava/lang/String;)V", "replace", "delete$ui_text_release", "(II)V", "delete", "setSelection$ui_text_release", "setSelection", "setComposition$ui_text_release", "setComposition", "commitComposition$ui_text_release", "()V", "commitComposition", "toString", "()Ljava/lang/String;", "toAnnotatedString$ui_text_release", "()Landroidx/compose/ui/text/AnnotatedString;", "toAnnotatedString", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "selectionStart", "I", "getSelectionStart$ui_text_release", "()I", "setSelectionStart", "(I)V", "selectionEnd", "getSelectionEnd$ui_text_release", "setSelectionEnd", "<set-?>", "compositionStart", "getCompositionStart$ui_text_release", "compositionEnd", "getCompositionEnd$ui_text_release", "getComposition-MzsxiRA$ui_text_release", "()Landroidx/compose/ui/text/TextRange;", "composition", "getSelection-d9O1mEE$ui_text_release", "()J", "cursor", "getCursor$ui_text_release", "setCursor$ui_text_release", "getLength$ui_text_release", "length", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditingBuffer {
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;
    public static final int $stable = 8;

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j);
    }

    private EditingBuffer(AnnotatedString annotatedString, long j) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.m1790getMinimpl(j);
        this.selectionEnd = TextRange.m1789getMaximpl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int iM1790getMinimpl = TextRange.m1790getMinimpl(j);
        int iM1789getMaximpl = TextRange.m1789getMaximpl(j);
        if (iM1790getMinimpl < 0 || iM1790getMinimpl > annotatedString.length()) {
            throw new IndexOutOfBoundsException("start (" + iM1790getMinimpl + ") offset is outside of text region " + annotatedString.length());
        }
        if (iM1789getMaximpl < 0 || iM1789getMaximpl > annotatedString.length()) {
            throw new IndexOutOfBoundsException("end (" + iM1789getMaximpl + ") offset is outside of text region " + annotatedString.length());
        }
        if (iM1790getMinimpl <= iM1789getMaximpl) {
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + iM1790getMinimpl + " > " + iM1789getMaximpl);
    }

    /* renamed from: getSelectionStart$ui_text_release, reason: from getter */
    public final int getSelectionStart() {
        return this.selectionStart;
    }

    private final void setSelectionStart(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("Cannot set selectionStart to a negative value: " + i).toString());
        }
        this.selectionStart = i;
    }

    /* renamed from: getSelectionEnd$ui_text_release, reason: from getter */
    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    private final void setSelectionEnd(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("Cannot set selectionEnd to a negative value: " + i).toString());
        }
        this.selectionEnd = i;
    }

    /* renamed from: getCompositionStart$ui_text_release, reason: from getter */
    public final int getCompositionStart() {
        return this.compositionStart;
    }

    /* renamed from: getCompositionEnd$ui_text_release, reason: from getter */
    public final int getCompositionEnd() {
        return this.compositionEnd;
    }

    public final boolean hasComposition$ui_text_release() {
        return this.compositionStart != -1;
    }

    /* renamed from: getComposition-MzsxiRA$ui_text_release, reason: not valid java name */
    public final TextRange m1880getCompositionMzsxiRA$ui_text_release() {
        if (hasComposition$ui_text_release()) {
            return TextRange.m1780boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    /* renamed from: getSelection-d9O1mEE$ui_text_release, reason: not valid java name */
    public final long m1881getSelectiond9O1mEE$ui_text_release() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getCursor$ui_text_release() {
        int i = this.selectionStart;
        int i2 = this.selectionEnd;
        if (i == i2) {
            return i2;
        }
        return -1;
    }

    public final void setCursor$ui_text_release(int i) {
        setSelection$ui_text_release(i, i);
    }

    public final char get$ui_text_release(int index) {
        return this.gapBuffer.get(index);
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    public final void replace$ui_text_release(int start, int end, String text) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + start + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + end + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (start > end) {
            throw new IllegalArgumentException("Do not set reversed range: " + start + " > " + end);
        }
        this.gapBuffer.replace(start, end, text);
        setSelectionStart(text.length() + start);
        setSelectionEnd(start + text.length());
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text_release(int start, int end) {
        long jTextRange = TextRangeKt.TextRange(start, end);
        this.gapBuffer.replace(start, end, "");
        long jM1882updateRangeAfterDeletepWDy79M = EditingBufferKt.m1882updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), jTextRange);
        setSelectionStart(TextRange.m1790getMinimpl(jM1882updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m1789getMaximpl(jM1882updateRangeAfterDeletepWDy79M));
        if (hasComposition$ui_text_release()) {
            long jM1882updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m1882updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), jTextRange);
            if (TextRange.m1786getCollapsedimpl(jM1882updateRangeAfterDeletepWDy79M2)) {
                commitComposition$ui_text_release();
            } else {
                this.compositionStart = TextRange.m1790getMinimpl(jM1882updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m1789getMaximpl(jM1882updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public final void setSelection$ui_text_release(int start, int end) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + start + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + end + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (start > end) {
            throw new IllegalArgumentException("Do not set reversed range: " + start + " > " + end);
        }
        setSelectionStart(start);
        setSelectionEnd(end);
    }

    public final void setComposition$ui_text_release(int start, int end) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + start + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + end + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (start >= end) {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + start + " > " + end);
        }
        this.compositionStart = start;
        this.compositionEnd = end;
    }

    public final void commitComposition$ui_text_release() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    public final AnnotatedString toAnnotatedString$ui_text_release() {
        return new AnnotatedString(toString(), null, null, 6, null);
    }
}
