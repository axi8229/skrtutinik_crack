package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: HandwritingGesture.android.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J>\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00162\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J8\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J&\u0010\u001e\u001a\u00020\n*\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J0\u0010#\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010#\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J0\u0010(\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010(\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J&\u0010*\u001a\u00020\n*\u00020\u001d2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-JA\u0010.\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0001¢\u0006\u0002\b2J+\u0010.\u001a\u00020\u0004*\u00020\u001d2\u0006\u00103\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0001¢\u0006\u0002\b2J2\u00104\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002052\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00104\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002052\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00106\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00106\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00108\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00108\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J2\u0010:\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010:\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J2\u0010<\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010<\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010>\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010>\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010?\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010?\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J-\u0010@\u001a\u00020\u0011*\u00020$2\u0006\u0010\u0005\u001a\u00020A2\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\bDJ+\u0010@\u001a\u00020\u0011*\u00020\u001d2\u0006\u00103\u001a\u00020A2\u0006\u0010&\u001a\u00020'2\b\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\bDJ\u001e\u0010E\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010E\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010F\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010F\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u0019\u0010G\u001a\u00020H*\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "()V", "fallbackOnLegacyTextField", "", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "", "performDeletionOnLegacyTextField", "range", "Landroidx/compose/ui/text/TextRange;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "adjustRange", "", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "performInsertionOnLegacyTextField", "offset", "", "performSelectionOnLegacyTextField", "textSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "fallback", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "highlightRange", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "performDeleteGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroid/view/inputmethod/DeleteGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "performDeletion", "rangeInTransformedText", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "performHandwritingGesture", "textFieldSelectionManager", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation_release", "handwritingGesture", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performSelectGesture", "Landroid/view/inputmethod/SelectGesture;", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewDeleteGesture", "previewDeleteRangeGesture", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation_release", "previewSelectGesture", "previewSelectRangeGesture", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HandwritingGestureApi34 {
    public static final HandwritingGestureApi34 INSTANCE = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    public final int performHandwritingGesture$foundation_release(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline8.m(handwritingGesture)) {
            return performSelectGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline9.m(handwritingGesture), textLayoutState);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline10.m(handwritingGesture)) {
            return performDeleteGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline11.m(handwritingGesture), textLayoutState);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline12.m(handwritingGesture)) {
            return performSelectRangeGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline13.m(handwritingGesture), textLayoutState);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline14.m(handwritingGesture)) {
            return performDeleteRangeGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline15.m(handwritingGesture), textLayoutState);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline22.m(handwritingGesture)) {
            return performJoinOrSplitGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline23.m(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline18.m(handwritingGesture)) {
            return performInsertGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline19.m(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline20.m(handwritingGesture)) {
            return performRemoveSpaceGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline21.m(handwritingGesture), textLayoutState, viewConfiguration);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation_release(final TransformedTextFieldState transformedTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextLayoutState textLayoutState, CancellationSignal cancellationSignal) {
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline8.m(previewableHandwritingGesture)) {
            previewSelectGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline9.m(previewableHandwritingGesture), textLayoutState);
        } else if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline10.m(previewableHandwritingGesture)) {
            previewDeleteGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline11.m(previewableHandwritingGesture), textLayoutState);
        } else if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline12.m(previewableHandwritingGesture)) {
            previewSelectRangeGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline13.m(previewableHandwritingGesture), textLayoutState);
        } else {
            if (!HandwritingGestureApi34$$ExternalSyntheticApiModelOutline14.m(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline15.m(previewableHandwritingGesture), textLayoutState);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener(transformedTextFieldState) { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda32
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.previewHandwritingGesture$lambda$1(null);
            }
        });
        return true;
    }

    private final int performSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        if (TextRange.m1786getCollapsedimpl(HandwritingGesture_androidKt.m523getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m505toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()))) {
            return INSTANCE.fallback(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(selectGesture));
        }
        throw null;
    }

    private final void previewSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        m501highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m523getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m505toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m495getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        int iM505toTextGranularityNUwxegE = m505toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long jM523getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m523getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), iM505toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m1786getCollapsedimpl(jM523getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(deleteGesture));
        }
        m502performDeletionSbBc2M(transformedTextFieldState, jM523getRangeForScreenRectOH9lIzo, TextGranularity.m1770equalsimpl0(iM505toTextGranularityNUwxegE, TextGranularity.INSTANCE.m1772getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        m501highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m523getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m505toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m494getHandwritingDeletePreviewsxJuwY());
    }

    private final int performSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        if (TextRange.m1786getCollapsedimpl(HandwritingGesture_androidKt.m525getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m505toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()))) {
            return INSTANCE.fallback(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(selectRangeGesture));
        }
        throw null;
    }

    private final void previewSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        m501highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m525getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m505toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m495getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        int iM505toTextGranularityNUwxegE = m505toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long jM525getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m525getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), iM505toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m1786getCollapsedimpl(jM525getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(deleteRangeGesture));
        }
        m502performDeletionSbBc2M(transformedTextFieldState, jM525getRangeForScreenRectsO048IG0, TextGranularity.m1770equalsimpl0(iM505toTextGranularityNUwxegE, TextGranularity.INSTANCE.m1772getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        m501highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m525getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m505toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m494getHandwritingDeletePreviewsxJuwY());
    }

    private final int performJoinOrSplitGesture(TransformedTextFieldState transformedTextFieldState, JoinOrSplitGesture joinOrSplitGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        throw null;
    }

    private final int performInsertGesture(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        int iM518getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m518getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
        if (iM518getOffsetForHandwritingGestured4ec7I == -1) {
            return fallback(transformedTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(insertGesture));
        }
        TransformedTextFieldState.m528replaceTextM8tDOmk$default(transformedTextFieldState, insertGesture.getTextToInsert(), TextRangeKt.TextRange(iM518getOffsetForHandwritingGestured4ec7I), null, false, 12, null);
        return 1;
    }

    private final int performRemoveSpaceGesture(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        throw null;
    }

    private final int fallback(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        TransformedTextFieldState.access$getTextFieldState$p(transformedTextFieldState);
        TransformedTextFieldState.access$getInputTransformation$p(transformedTextFieldState);
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$1(TransformedTextFieldState transformedTextFieldState) {
        TransformedTextFieldState.access$getTextFieldState$p(transformedTextFieldState);
        TransformedTextFieldState.access$getInputTransformation$p(transformedTextFieldState);
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        throw null;
    }

    /* renamed from: performDeletion-Sb-Bc2M, reason: not valid java name */
    private final void m502performDeletionSbBc2M(TransformedTextFieldState transformedTextFieldState, long j, boolean z) {
        if (z) {
            throw null;
        }
        TransformedTextFieldState.m528replaceTextM8tDOmk$default(transformedTextFieldState, "", j, null, false, 12, null);
    }

    /* renamed from: highlightRange-XJREzCE, reason: not valid java name */
    private final void m501highlightRangeXJREzCE(TransformedTextFieldState transformedTextFieldState, long j, int i) {
        if (TextRange.m1786getCollapsedimpl(j)) {
            TransformedTextFieldState.access$getTextFieldState$p(transformedTextFieldState);
            TransformedTextFieldState.access$getInputTransformation$p(transformedTextFieldState);
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            throw null;
        }
        throw null;
    }

    public final int performHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, HandwritingGesture handwritingGesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return 3;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return 3;
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline8.m(handwritingGesture)) {
            return performSelectGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline9.m(handwritingGesture), textFieldSelectionManager, function1);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline10.m(handwritingGesture)) {
            return performDeleteGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline11.m(handwritingGesture), untransformedText, function1);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline12.m(handwritingGesture)) {
            return performSelectRangeGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline13.m(handwritingGesture), textFieldSelectionManager, function1);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline14.m(handwritingGesture)) {
            return performDeleteRangeGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline15.m(handwritingGesture), untransformedText, function1);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline22.m(handwritingGesture)) {
            return performJoinOrSplitGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline23.m(handwritingGesture), untransformedText, viewConfiguration, function1);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline18.m(handwritingGesture)) {
            return performInsertGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline19.m(handwritingGesture), viewConfiguration, function1);
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline20.m(handwritingGesture)) {
            return performRemoveSpaceGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline21.m(handwritingGesture), untransformedText, viewConfiguration, function1);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, final TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return false;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return false;
        }
        if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline8.m(previewableHandwritingGesture)) {
            previewSelectGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline9.m(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline10.m(previewableHandwritingGesture)) {
            previewDeleteGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline11.m(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (HandwritingGestureApi34$$ExternalSyntheticApiModelOutline12.m(previewableHandwritingGesture)) {
            previewSelectRangeGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline13.m(previewableHandwritingGesture), textFieldSelectionManager);
        } else {
            if (!HandwritingGestureApi34$$ExternalSyntheticApiModelOutline14.m(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(legacyTextFieldState, HandwritingGestureApi34$$ExternalSyntheticApiModelOutline15.m(previewableHandwritingGesture), textFieldSelectionManager);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda31
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.previewHandwritingGesture$lambda$9(textFieldSelectionManager);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$9(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.clearPreviewHighlight$foundation_release();
        }
    }

    private final int performSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long jM522getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m522getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m505toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m1786getCollapsedimpl(jM522getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(selectGesture), function1);
        }
        m504performSelectionOnLegacyTextField8ffj60Q(jM522getRangeForScreenRectOH9lIzo, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m585setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m522getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m505toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    private final int performDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int iM505toTextGranularityNUwxegE = m505toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long jM522getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m522getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), iM505toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m1786getCollapsedimpl(jM522getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(deleteGesture), function1);
        }
        m503performDeletionOnLegacyTextFieldvJH6DeI(jM522getRangeForScreenRectOH9lIzo, annotatedString, TextGranularity.m1770equalsimpl0(iM505toTextGranularityNUwxegE, TextGranularity.INSTANCE.m1772getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m584setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m522getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m505toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    private final int performSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long jM524getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m524getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m505toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m1786getCollapsedimpl(jM524getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(selectRangeGesture), function1);
        }
        m504performSelectionOnLegacyTextField8ffj60Q(jM524getRangeForScreenRectsO048IG0, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m585setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m524getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m505toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int iM505toTextGranularityNUwxegE = m505toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long jM524getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m524getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), iM505toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m1786getCollapsedimpl(jM524getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(deleteRangeGesture), function1);
        }
        m503performDeletionOnLegacyTextFieldvJH6DeI(jM524getRangeForScreenRectsO048IG0, annotatedString, TextGranularity.m1770equalsimpl0(iM505toTextGranularityNUwxegE, TextGranularity.INSTANCE.m1772getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m584setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m524getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m505toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    private final int performJoinOrSplitGesture(LegacyTextFieldState legacyTextFieldState, JoinOrSplitGesture joinOrSplitGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration != null) {
            int iM517getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m517getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
            if (iM517getOffsetForHandwritingGestured4ec7I != -1 && ((layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null || !HandwritingGesture_androidKt.isBiDiBoundary(value, iM517getOffsetForHandwritingGestured4ec7I))) {
                long jRangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(annotatedString, iM517getOffsetForHandwritingGestured4ec7I);
                if (TextRange.m1786getCollapsedimpl(jRangeOfWhitespaces)) {
                    performInsertionOnLegacyTextField(TextRange.m1792getStartimpl(jRangeOfWhitespaces), " ", function1);
                } else {
                    m503performDeletionOnLegacyTextFieldvJH6DeI(jRangeOfWhitespaces, annotatedString, false, function1);
                }
                return 1;
            }
            return fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(joinOrSplitGesture), function1);
        }
        return fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(joinOrSplitGesture), function1);
    }

    private final int performInsertGesture(LegacyTextFieldState legacyTextFieldState, InsertGesture insertGesture, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration != null) {
            int iM517getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m517getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
            if (iM517getOffsetForHandwritingGestured4ec7I == -1 || ((layoutResult = legacyTextFieldState.getLayoutResult()) != null && (value = layoutResult.getValue()) != null && HandwritingGesture_androidKt.isBiDiBoundary(value, iM517getOffsetForHandwritingGestured4ec7I))) {
                return fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(insertGesture), function1);
            }
            performInsertionOnLegacyTextField(iM517getOffsetForHandwritingGestured4ec7I, insertGesture.getTextToInsert(), function1);
            return 1;
        }
        return fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(insertGesture), function1);
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        long jM520getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m520getRangeForRemoveSpaceGesture5iVPX68(layoutResult != null ? layoutResult.getValue() : null, HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
        if (TextRange.m1786getCollapsedimpl(jM520getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(removeSpaceGesture), function1);
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = -1;
        String strReplace = new Regex("\\s+").replace(TextRangeKt.m1799substringFDrldGo(annotatedString, jM520getRangeForRemoveSpaceGesture5iVPX68), new Function1<MatchResult, CharSequence>() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Ref$IntRef ref$IntRef3 = ref$IntRef;
                if (ref$IntRef3.element == -1) {
                    ref$IntRef3.element = matchResult.getRange().getFirst();
                }
                ref$IntRef2.element = matchResult.getRange().getLast() + 1;
                return "";
            }
        });
        if (ref$IntRef.element == -1 || ref$IntRef2.element == -1) {
            return fallbackOnLegacyTextField(HandwritingGestureApi34$$ExternalSyntheticApiModelOutline7.m(removeSpaceGesture), function1);
        }
        int iM1792getStartimpl = TextRange.m1792getStartimpl(jM520getRangeForRemoveSpaceGesture5iVPX68) + ref$IntRef.element;
        int iM1792getStartimpl2 = TextRange.m1792getStartimpl(jM520getRangeForRemoveSpaceGesture5iVPX68) + ref$IntRef2.element;
        String strSubstring = strReplace.substring(ref$IntRef.element, strReplace.length() - (TextRange.m1788getLengthimpl(jM520getRangeForRemoveSpaceGesture5iVPX68) - ref$IntRef2.element));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        function1.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(iM1792getStartimpl, iM1792getStartimpl2), new CommitTextCommand(strSubstring, 1)));
        return 1;
    }

    private final void performInsertionOnLegacyTextField(int offset, String text, Function1<? super EditCommand, Unit> editCommandConsumer) {
        editCommandConsumer.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(offset, offset), new CommitTextCommand(text, 1)));
    }

    /* renamed from: performSelectionOnLegacyTextField-8ffj60Q, reason: not valid java name */
    private final void m504performSelectionOnLegacyTextField8ffj60Q(long range, TextFieldSelectionManager textSelectionManager, Function1<? super EditCommand, Unit> editCommandConsumer) {
        editCommandConsumer.invoke(new SetSelectionCommand(TextRange.m1792getStartimpl(range), TextRange.m1787getEndimpl(range)));
        if (textSelectionManager != null) {
            textSelectionManager.enterSelectionMode$foundation_release(true);
        }
    }

    /* renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    private final void m503performDeletionOnLegacyTextFieldvJH6DeI(long range, AnnotatedString text, boolean adjustRange, Function1<? super EditCommand, Unit> editCommandConsumer) {
        if (adjustRange) {
            range = HandwritingGesture_androidKt.m514adjustHandwritingDeleteGestureRange72CqOWE(range, text);
        }
        editCommandConsumer.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(TextRange.m1787getEndimpl(range), TextRange.m1787getEndimpl(range)), new DeleteSurroundingTextCommand(TextRange.m1788getLengthimpl(range), 0)));
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture gesture, Function1<? super EditCommand, Unit> editCommandConsumer) {
        String fallbackText = gesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        editCommandConsumer.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* renamed from: toTextGranularity-NUwxegE, reason: not valid java name */
    private final int m505toTextGranularityNUwxegE(int i) {
        if (i == 1) {
            return TextGranularity.INSTANCE.m1772getWordDRrd7Zo();
        }
        if (i == 2) {
            return TextGranularity.INSTANCE.m1771getCharacterDRrd7Zo();
        }
        return TextGranularity.INSTANCE.m1771getCharacterDRrd7Zo();
    }
}
