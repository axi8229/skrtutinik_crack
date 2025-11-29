package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditingBuffer;
import kotlin.Metadata;

/* compiled from: HandwritingGesture.android.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001e\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\t\u001a\u0013\u0010\f\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\t\u001a\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a.\u0010\u001a\u001a\u00020\u0000*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a6\u0010\u001f\u001a\u00020\u0000*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a.\u0010\u001a\u001a\u00020\u0000*\u00020 2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010!\u001a6\u0010\u001f\u001a\u00020\u0000*\u00020 2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\"\u001a\u001b\u0010$\u001a\u00020\u0000*\u00020\u00012\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%\u001a(\u0010+\u001a\u00020\u0006*\u00020\u00112\u0006\u0010&\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010'H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a&\u0010+\u001a\u00020\u0006*\u00020 2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010,\u001a\u001b\u0010.\u001a\u00020\u0007*\u00020-2\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010/\u001a:\u0010\u001a\u001a\u00020\u0000*\u0004\u0018\u0001002\u0006\u0010\u0013\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a2\u0010+\u001a\u00020\u0006*\u0002002\u0006\u0010&\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u0001012\b\u0010(\u001a\u0004\u0018\u00010'H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a<\u0010;\u001a\u00020\u0000*\u0004\u0018\u00010-2\u0006\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u0001012\b\u0010(\u001a\u0004\u0018\u00010'H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a(\u0010?\u001a\u00020\u0006*\u0002002\u0006\u0010<\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010'H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a#\u0010C\u001a\u00020A2\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0@\"\u00020AH\u0002¢\u0006\u0004\bC\u0010D\u001a\"\u0010I\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"Landroidx/compose/ui/text/TextRange;", "", "text", "adjustHandwritingDeleteGestureRange-72CqOWE", "(JLjava/lang/CharSequence;)J", "adjustHandwritingDeleteGestureRange", "", "", "isNewline", "(I)Z", "isWhitespace", "isWhitespaceExceptNewline", "isPunctuation", "Landroid/graphics/PointF;", "Landroidx/compose/ui/geometry/Offset;", "toOffset", "(Landroid/graphics/PointF;)J", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "Landroidx/compose/ui/geometry/Rect;", "rectInScreen", "Landroidx/compose/ui/text/TextGranularity;", "granularity", "Landroidx/compose/ui/text/TextInclusionStrategy;", "inclusionStrategy", "getRangeForScreenRect-OH9lIzo", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRect", "startRectInScreen", "endRectInScreen", "getRangeForScreenRects-O048IG0", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRects", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "offset", "rangeOfWhitespaces", "(Ljava/lang/CharSequence;I)J", "pointInScreen", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getOffsetForHandwritingGesture-d-4ec7I", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "getOffsetForHandwritingGesture", "(Landroidx/compose/foundation/text/LegacyTextFieldState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "Landroidx/compose/ui/text/TextLayoutResult;", "isBiDiBoundary", "(Landroidx/compose/ui/text/TextLayoutResult;I)Z", "Landroidx/compose/ui/text/MultiParagraph;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getRangeForScreenRect-O048IG0", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/layout/LayoutCoordinates;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getOffsetForHandwritingGesture-ubNVwUQ", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)I", "startPointInScreen", "endPointerInScreen", "getRangeForRemoveSpaceGesture-5iVPX68", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)J", "getRangeForRemoveSpaceGesture", "localPoint", "getLineForHandwritingGesture-d-4ec7I", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "getLineForHandwritingGesture", "", "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", "compoundEditCommand", "([Landroidx/compose/ui/text/input/EditCommand;)Landroidx/compose/ui/text/input/EditCommand;", "a", "b", "enclosure-pWDy79M", "(JJ)J", "enclosure", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HandwritingGesture_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: adjustHandwritingDeleteGestureRange-72CqOWE, reason: not valid java name */
    public static final long m514adjustHandwritingDeleteGestureRange72CqOWE(long j, CharSequence charSequence) {
        int iM1792getStartimpl = TextRange.m1792getStartimpl(j);
        int iM1787getEndimpl = TextRange.m1787getEndimpl(j);
        int iCodePointBefore = iM1792getStartimpl > 0 ? Character.codePointBefore(charSequence, iM1792getStartimpl) : 10;
        int iCodePointAt = iM1787getEndimpl < charSequence.length() ? Character.codePointAt(charSequence, iM1787getEndimpl) : 10;
        if (isWhitespaceExceptNewline(iCodePointBefore) && (isWhitespace(iCodePointAt) || isPunctuation(iCodePointAt))) {
            do {
                iM1792getStartimpl -= Character.charCount(iCodePointBefore);
                if (iM1792getStartimpl == 0) {
                    break;
                }
                iCodePointBefore = Character.codePointBefore(charSequence, iM1792getStartimpl);
            } while (isWhitespaceExceptNewline(iCodePointBefore));
            return TextRangeKt.TextRange(iM1792getStartimpl, iM1787getEndimpl);
        }
        if (!isWhitespaceExceptNewline(iCodePointAt)) {
            return j;
        }
        if (!isWhitespace(iCodePointBefore) && !isPunctuation(iCodePointBefore)) {
            return j;
        }
        do {
            iM1787getEndimpl += Character.charCount(iCodePointAt);
            if (iM1787getEndimpl == charSequence.length()) {
                break;
            }
            iCodePointAt = Character.codePointAt(charSequence, iM1787getEndimpl);
        } while (isWhitespaceExceptNewline(iCodePointAt));
        return TextRangeKt.TextRange(iM1792getStartimpl, iM1787getEndimpl);
    }

    private static final boolean isNewline(int i) {
        int type = Character.getType(i);
        return type == 14 || type == 13 || i == 10;
    }

    private static final boolean isWhitespace(int i) {
        return Character.isWhitespace(i) || i == 160;
    }

    private static final boolean isWhitespaceExceptNewline(int i) {
        return isWhitespace(i) && !isNewline(i);
    }

    private static final boolean isPunctuation(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toOffset(PointF pointF) {
        return OffsetKt.Offset(pointF.x, pointF.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m523getRangeForScreenRectOH9lIzo(TextLayoutState textLayoutState, Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m525getRangeForScreenRectsO048IG0(TextLayoutState textLayoutState, Rect rect, Rect rect2, int i, TextInclusionStrategy textInclusionStrategy) {
        long jM523getRangeForScreenRectOH9lIzo = m523getRangeForScreenRectOH9lIzo(textLayoutState, rect, i, textInclusionStrategy);
        if (TextRange.m1786getCollapsedimpl(jM523getRangeForScreenRectOH9lIzo)) {
            return TextRange.INSTANCE.m1797getZerod9O1mEE();
        }
        long jM523getRangeForScreenRectOH9lIzo2 = m523getRangeForScreenRectOH9lIzo(textLayoutState, rect2, i, textInclusionStrategy);
        return TextRange.m1786getCollapsedimpl(jM523getRangeForScreenRectOH9lIzo2) ? TextRange.INSTANCE.m1797getZerod9O1mEE() : m515enclosurepWDy79M(jM523getRangeForScreenRectOH9lIzo, jM523getRangeForScreenRectOH9lIzo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m522getRangeForScreenRectOH9lIzo(LegacyTextFieldState legacyTextFieldState, Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        TextLayoutResult value;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        return m521getRangeForScreenRectO048IG0((layoutResult == null || (value = layoutResult.getValue()) == null) ? null : value.getMultiParagraph(), rect, legacyTextFieldState.getLayoutCoordinates(), i, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m524getRangeForScreenRectsO048IG0(LegacyTextFieldState legacyTextFieldState, Rect rect, Rect rect2, int i, TextInclusionStrategy textInclusionStrategy) {
        long jM522getRangeForScreenRectOH9lIzo = m522getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect, i, textInclusionStrategy);
        if (TextRange.m1786getCollapsedimpl(jM522getRangeForScreenRectOH9lIzo)) {
            return TextRange.INSTANCE.m1797getZerod9O1mEE();
        }
        long jM522getRangeForScreenRectOH9lIzo2 = m522getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect2, i, textInclusionStrategy);
        return TextRange.m1786getCollapsedimpl(jM522getRangeForScreenRectOH9lIzo2) ? TextRange.INSTANCE.m1797getZerod9O1mEE() : m515enclosurepWDy79M(jM522getRangeForScreenRectOH9lIzo, jM522getRangeForScreenRectOH9lIzo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long rangeOfWhitespaces(CharSequence charSequence, int i) {
        int iCharCount = i;
        while (iCharCount > 0) {
            int iCodePointBefore = CodepointHelpers_jvmKt.codePointBefore(charSequence, iCharCount);
            if (!isWhitespace(iCodePointBefore)) {
                break;
            }
            iCharCount -= Character.charCount(iCodePointBefore);
        }
        while (i < charSequence.length()) {
            int iCodePointAt = CodepointHelpers_jvmKt.codePointAt(charSequence, i);
            if (!isWhitespace(iCodePointAt)) {
                break;
            }
            i += CodepointHelpers_jvmKt.charCount(iCodePointAt);
        }
        return TextRangeKt.TextRange(iCharCount, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m518getOffsetForHandwritingGestured4ec7I(TextLayoutState textLayoutState, long j, ViewConfiguration viewConfiguration) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m517getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState legacyTextFieldState, long j, ViewConfiguration viewConfiguration) {
        TextLayoutResult value;
        MultiParagraph multiParagraph;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult == null || (value = layoutResult.getValue()) == null || (multiParagraph = value.getMultiParagraph()) == null) {
            return -1;
        }
        return m519getOffsetForHandwritingGestureubNVwUQ(multiParagraph, j, legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBiDiBoundary(TextLayoutResult textLayoutResult, int i) {
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        return (i == textLayoutResult.getLineStart(lineForOffset) || i == TextLayoutResult.getLineEnd$default(textLayoutResult, lineForOffset, false, 2, null)) ? textLayoutResult.getParagraphDirection(i) != textLayoutResult.getBidiRunDirection(i) : textLayoutResult.getBidiRunDirection(i) != textLayoutResult.getBidiRunDirection(i - 1);
    }

    /* renamed from: getRangeForScreenRect-O048IG0, reason: not valid java name */
    private static final long m521getRangeForScreenRectO048IG0(MultiParagraph multiParagraph, Rect rect, LayoutCoordinates layoutCoordinates, int i, TextInclusionStrategy textInclusionStrategy) {
        if (multiParagraph == null || layoutCoordinates == null) {
            return TextRange.INSTANCE.m1797getZerod9O1mEE();
        }
        return multiParagraph.m1713getRangeForRect86BmAI(rect.m863translatek4lQ0M(layoutCoordinates.mo1427screenToLocalMKHz9U(Offset.INSTANCE.m854getZeroF1C5BW0())), i, textInclusionStrategy);
    }

    /* renamed from: getOffsetForHandwritingGesture-ubNVwUQ, reason: not valid java name */
    private static final int m519getOffsetForHandwritingGestureubNVwUQ(MultiParagraph multiParagraph, long j, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        long jMo1427screenToLocalMKHz9U;
        int iM516getLineForHandwritingGestured4ec7I;
        if (layoutCoordinates == null || (iM516getLineForHandwritingGestured4ec7I = m516getLineForHandwritingGestured4ec7I(multiParagraph, (jMo1427screenToLocalMKHz9U = layoutCoordinates.mo1427screenToLocalMKHz9U(j)), viewConfiguration)) == -1) {
            return -1;
        }
        return multiParagraph.m1712getOffsetForPositionk4lQ0M(Offset.m836copydBAh8RU$default(jMo1427screenToLocalMKHz9U, 0.0f, (multiParagraph.getLineTop(iM516getLineForHandwritingGestured4ec7I) + multiParagraph.getLineBottom(iM516getLineForHandwritingGestured4ec7I)) / 2.0f, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForRemoveSpaceGesture-5iVPX68, reason: not valid java name */
    public static final long m520getRangeForRemoveSpaceGesture5iVPX68(TextLayoutResult textLayoutResult, long j, long j2, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        if (textLayoutResult == null || layoutCoordinates == null) {
            return TextRange.INSTANCE.m1797getZerod9O1mEE();
        }
        long jMo1427screenToLocalMKHz9U = layoutCoordinates.mo1427screenToLocalMKHz9U(j);
        long jMo1427screenToLocalMKHz9U2 = layoutCoordinates.mo1427screenToLocalMKHz9U(j2);
        int iM516getLineForHandwritingGestured4ec7I = m516getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), jMo1427screenToLocalMKHz9U, viewConfiguration);
        int iM516getLineForHandwritingGestured4ec7I2 = m516getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), jMo1427screenToLocalMKHz9U2, viewConfiguration);
        if (iM516getLineForHandwritingGestured4ec7I != -1) {
            if (iM516getLineForHandwritingGestured4ec7I2 != -1) {
                iM516getLineForHandwritingGestured4ec7I = Math.min(iM516getLineForHandwritingGestured4ec7I, iM516getLineForHandwritingGestured4ec7I2);
            }
            iM516getLineForHandwritingGestured4ec7I2 = iM516getLineForHandwritingGestured4ec7I;
        } else if (iM516getLineForHandwritingGestured4ec7I2 == -1) {
            return TextRange.INSTANCE.m1797getZerod9O1mEE();
        }
        float lineTop = (textLayoutResult.getLineTop(iM516getLineForHandwritingGestured4ec7I2) + textLayoutResult.getLineBottom(iM516getLineForHandwritingGestured4ec7I2)) / 2;
        return textLayoutResult.getMultiParagraph().m1713getRangeForRect86BmAI(new Rect(Math.min(Offset.m842getXimpl(jMo1427screenToLocalMKHz9U), Offset.m842getXimpl(jMo1427screenToLocalMKHz9U2)), lineTop - 0.1f, Math.max(Offset.m842getXimpl(jMo1427screenToLocalMKHz9U), Offset.m842getXimpl(jMo1427screenToLocalMKHz9U2)), lineTop + 0.1f), TextGranularity.INSTANCE.m1771getCharacterDRrd7Zo(), TextInclusionStrategy.INSTANCE.getAnyOverlap());
    }

    /* renamed from: getLineForHandwritingGesture-d-4ec7I, reason: not valid java name */
    private static final int m516getLineForHandwritingGestured4ec7I(MultiParagraph multiParagraph, long j, ViewConfiguration viewConfiguration) {
        float handwritingGestureLineMargin = viewConfiguration != null ? viewConfiguration.getHandwritingGestureLineMargin() : 0.0f;
        int lineForVerticalPosition = multiParagraph.getLineForVerticalPosition(Offset.m843getYimpl(j));
        if (Offset.m843getYimpl(j) < multiParagraph.getLineTop(lineForVerticalPosition) - handwritingGestureLineMargin || Offset.m843getYimpl(j) > multiParagraph.getLineBottom(lineForVerticalPosition) + handwritingGestureLineMargin || Offset.m842getXimpl(j) < (-handwritingGestureLineMargin) || Offset.m842getXimpl(j) > multiParagraph.getWidth() + handwritingGestureLineMargin) {
            return -1;
        }
        return lineForVerticalPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EditCommand compoundEditCommand(final EditCommand... editCommandArr) {
        return new EditCommand() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.compoundEditCommand.1
            @Override // androidx.compose.ui.text.input.EditCommand
            public void applyTo(EditingBuffer buffer) {
                for (EditCommand editCommand : editCommandArr) {
                    editCommand.applyTo(buffer);
                }
            }
        };
    }

    /* renamed from: enclosure-pWDy79M, reason: not valid java name */
    private static final long m515enclosurepWDy79M(long j, long j2) {
        return TextRangeKt.TextRange(Math.min(TextRange.m1792getStartimpl(j), TextRange.m1792getStartimpl(j)), Math.max(TextRange.m1787getEndimpl(j2), TextRange.m1787getEndimpl(j2)));
    }
}
