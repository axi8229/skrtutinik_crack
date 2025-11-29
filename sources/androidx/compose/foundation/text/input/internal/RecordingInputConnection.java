package androidx.compose.foundation.text.input.internal;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextInCodePointsCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.SetComposingRegionCommand;
import androidx.compose.ui.text.input.SetComposingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: RecordingInputConnection.android.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010!\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0016J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0018H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0016¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0018H\u0016¢\u0006\u0004\b.\u0010)J\u001f\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0018H\u0016¢\u0006\u0004\b1\u0010-J\u001f\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0018H\u0016¢\u0006\u0004\b2\u0010-J\u001f\u00103\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0016¢\u0006\u0004\b3\u0010-J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\u0016J\u0017\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020%2\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0018H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u00020%2\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0018H\u0016¢\u0006\u0004\b=\u0010<J\u0019\u0010>\u001a\u0004\u0018\u00010%2\u0006\u0010:\u001a\u00020\u0018H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0018H\u0016¢\u0006\u0004\bA\u0010BJ!\u0010F\u001a\u00020E2\b\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010:\u001a\u00020\u0018H\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0018H\u0016¢\u0006\u0004\bI\u0010BJ\u0017\u0010K\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u0018H\u0016¢\u0006\u0004\bK\u0010BJ+\u0010R\u001a\u00020\u00122\u0006\u0010M\u001a\u00020L2\b\u0010O\u001a\u0004\u0018\u00010N2\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0004\bR\u0010SJ!\u0010W\u001a\u00020\u00062\u0006\u0010M\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bW\u0010XJ\u0019\u0010Z\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0004\bZ\u0010[J\u0019\u0010^\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016¢\u0006\u0004\b^\u0010_J\u0011\u0010a\u001a\u0004\u0018\u00010`H\u0016¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u0018H\u0016¢\u0006\u0004\bd\u0010BJ\u0017\u0010f\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\u0016¢\u0006\u0004\bf\u0010gJ\u0017\u0010i\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u0018H\u0016¢\u0006\u0004\bi\u0010jJ#\u0010o\u001a\u00020\u00062\b\u0010l\u001a\u0004\u0018\u00010k2\b\u0010n\u001a\u0004\u0018\u00010mH\u0016¢\u0006\u0004\bo\u0010pJ)\u0010t\u001a\u00020\u00062\u0006\u0010r\u001a\u00020q2\u0006\u0010:\u001a\u00020\u00182\b\u0010s\u001a\u0004\u0018\u00010mH\u0016¢\u0006\u0004\bt\u0010uR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010v\u001a\u0004\bw\u0010xR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010y\u001a\u0004\bz\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010{\u001a\u0004\b|\u0010}R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\r\n\u0004\b\u000b\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\u000f\n\u0005\b\r\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R2\u0010\u0087\u0001\u001a\u00020\u00022\u0007\u0010\u0086\u0001\u001a\u00020\u00028\u0000@@X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0085\u0001R\u0018\u0010\u008e\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010yR\u001e\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0092\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010y¨\u0006\u0093\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "Landroidx/compose/ui/text/input/TextFieldValue;", "initState", "Landroidx/compose/foundation/text/input/internal/InputEventCallback2;", "eventCallback", "", "autoCorrect", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "legacyTextFieldState", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "textFieldSelectionManager", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/input/internal/InputEventCallback2;ZLandroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/platform/ViewConfiguration;)V", "Landroidx/compose/ui/text/input/EditCommand;", "editCommand", "", "addEditCommandWithBatch", "(Landroidx/compose/ui/text/input/EditCommand;)V", "beginBatchEditInternal", "()Z", "endBatchEditInternal", "", "code", "sendSynthesizedKeyEvent", "(I)V", "state", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "inputMethodManager", "updateInputState", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "beginBatchEdit", "endBatchEdit", "closeConnection", "()V", "", "text", "newCursorPosition", "commitText", "(Ljava/lang/CharSequence;I)Z", "start", "end", "setComposingRegion", "(II)Z", "setComposingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "deleteSurroundingText", "setSelection", "finishComposingText", "Landroid/view/KeyEvent;", "event", "sendKeyEvent", "(Landroid/view/KeyEvent;)Z", "maxChars", "flags", "getTextBeforeCursor", "(II)Ljava/lang/CharSequence;", "getTextAfterCursor", "getSelectedText", "(I)Ljava/lang/CharSequence;", "cursorUpdateMode", "requestCursorUpdates", "(I)Z", "Landroid/view/inputmethod/ExtractedTextRequest;", "request", "Landroid/view/inputmethod/ExtractedText;", "getExtractedText", "(Landroid/view/inputmethod/ExtractedTextRequest;I)Landroid/view/inputmethod/ExtractedText;", "id", "performContextMenuAction", "editorAction", "performEditorAction", "Landroid/view/inputmethod/HandwritingGesture;", "gesture", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/function/IntConsumer;", "consumer", "performHandwritingGesture", "(Landroid/view/inputmethod/HandwritingGesture;Ljava/util/concurrent/Executor;Ljava/util/function/IntConsumer;)V", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "Landroid/os/CancellationSignal;", "cancellationSignal", "previewHandwritingGesture", "(Landroid/view/inputmethod/PreviewableHandwritingGesture;Landroid/os/CancellationSignal;)Z", "Landroid/view/inputmethod/CompletionInfo;", "commitCompletion", "(Landroid/view/inputmethod/CompletionInfo;)Z", "Landroid/view/inputmethod/CorrectionInfo;", "correctionInfo", "commitCorrection", "(Landroid/view/inputmethod/CorrectionInfo;)Z", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "states", "clearMetaKeyStates", "enabled", "reportFullscreenMode", "(Z)Z", "reqModes", "getCursorCapsMode", "(I)I", "", "action", "Landroid/os/Bundle;", RemoteMessageConst.DATA, "performPrivateCommand", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "Landroid/view/inputmethod/InputContentInfo;", "inputContentInfo", "opts", "commitContent", "(Landroid/view/inputmethod/InputContentInfo;ILandroid/os/Bundle;)Z", "Landroidx/compose/foundation/text/input/internal/InputEventCallback2;", "getEventCallback", "()Landroidx/compose/foundation/text/input/internal/InputEventCallback2;", "Z", "getAutoCorrect", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getLegacyTextFieldState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getTextFieldSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "batchDepth", "I", AppMeasurementSdk.ConditionalUserProperty.VALUE, "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "getTextFieldValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setTextFieldValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "currentExtractedTextRequestToken", "extractedTextMonitorMode", "", "editCommands", "Ljava/util/List;", "isActive", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecordingInputConnection implements InputConnection {
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private final LegacyTextFieldState legacyTextFieldState;
    private final TextFieldSelectionManager textFieldSelectionManager;
    private TextFieldValue textFieldValue;
    private final ViewConfiguration viewConfiguration;
    private final List<EditCommand> editCommands = new ArrayList();
    private boolean isActive = true;

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        return false;
    }

    public RecordingInputConnection(TextFieldValue textFieldValue, InputEventCallback2 inputEventCallback2, boolean z, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration) {
        this.eventCallback = inputEventCallback2;
        this.autoCorrect = z;
        this.legacyTextFieldState = legacyTextFieldState;
        this.textFieldSelectionManager = textFieldSelectionManager;
        this.viewConfiguration = viewConfiguration;
        this.textFieldValue = textFieldValue;
    }

    public final void setTextFieldValue$foundation_release(TextFieldValue textFieldValue) {
        this.textFieldValue = textFieldValue;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean z = this.isActive;
        return z ? beginBatchEditInternal() : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo text) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z = this.isActive;
        return z ? this.autoCorrect : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence text, int newCursorPosition) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new CommitTextCommand(String.valueOf(text), newCursorPosition));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextCommand(beforeLength, afterLength));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(beforeLength, afterLength));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new FinishComposingTextCommand());
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int id) {
        boolean z = this.isActive;
        if (z) {
            z = false;
            switch (id) {
                case R.id.selectAll:
                    addEditCommandWithBatch(new SetSelectionCommand(0, this.textFieldValue.getText().length()));
                    break;
                case R.id.cut:
                    sendSynthesizedKeyEvent(277);
                    break;
                case R.id.copy:
                    sendSynthesizedKeyEvent(278);
                    break;
                case R.id.paste:
                    sendSynthesizedKeyEvent(279);
                    break;
            }
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int editorAction) {
        int iM1890getDefaulteUduSuo;
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        if (editorAction == 0) {
            iM1890getDefaulteUduSuo = ImeAction.INSTANCE.m1890getDefaulteUduSuo();
        } else {
            switch (editorAction) {
                case 2:
                    iM1890getDefaulteUduSuo = ImeAction.INSTANCE.m1892getGoeUduSuo();
                    break;
                case 3:
                    iM1890getDefaulteUduSuo = ImeAction.INSTANCE.m1896getSearcheUduSuo();
                    break;
                case 4:
                    iM1890getDefaulteUduSuo = ImeAction.INSTANCE.m1897getSendeUduSuo();
                    break;
                case 5:
                    iM1890getDefaulteUduSuo = ImeAction.INSTANCE.m1893getNexteUduSuo();
                    break;
                case 6:
                    iM1890getDefaulteUduSuo = ImeAction.INSTANCE.m1891getDoneeUduSuo();
                    break;
                case 7:
                    iM1890getDefaulteUduSuo = ImeAction.INSTANCE.m1895getPreviouseUduSuo();
                    break;
                default:
                    Log.w("RecordingIC", "IME sends unsupported Editor Action: " + editorAction);
                    iM1890getDefaulteUduSuo = ImeAction.INSTANCE.m1890getDefaulteUduSuo();
                    break;
            }
        }
        this.eventCallback.mo526onImeActionKlQnJC8(iM1890getDefaulteUduSuo);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String action, Bundle data) {
        boolean z = this.isActive;
        if (z) {
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = this.isActive;
        if (!z5) {
            return z5;
        }
        boolean z6 = false;
        boolean z7 = (cursorUpdateMode & 1) != 0;
        boolean z8 = (cursorUpdateMode & 2) != 0;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            boolean z9 = (cursorUpdateMode & 16) != 0;
            boolean z10 = (cursorUpdateMode & 8) != 0;
            boolean z11 = (cursorUpdateMode & 4) != 0;
            if (i >= 34 && (cursorUpdateMode & 32) != 0) {
                z6 = true;
            }
            if (z9 || z10 || z11 || z6) {
                z2 = z6;
                z = z11;
                z4 = z10;
                z3 = z9;
            } else if (i >= 34) {
                z3 = true;
                z4 = true;
                z = true;
                z2 = true;
            } else {
                z2 = z6;
                z3 = true;
                z4 = true;
                z = true;
            }
        } else {
            z = false;
            z2 = false;
            z3 = true;
            z4 = true;
        }
        this.eventCallback.onRequestCursorAnchorInfo(z7, z8, z3, z4, z, z2);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent event) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        this.eventCallback.onKeyEvent(event);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int start, int end) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingRegionCommand(start, end));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(text), newCursorPosition));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int start, int end) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new SetSelectionCommand(start, end));
        return true;
    }

    public final void updateInputState(TextFieldValue state, InputMethodManager inputMethodManager) {
        if (this.isActive) {
            setTextFieldValue$foundation_release(state);
            if (this.extractedTextMonitorMode) {
                inputMethodManager.updateExtractedText(this.currentExtractedTextRequestToken, RecordingInputConnection_androidKt.toExtractedText(state));
            }
            TextRange composition = state.getComposition();
            int iM1790getMinimpl = composition != null ? TextRange.m1790getMinimpl(composition.getPackedValue()) : -1;
            TextRange composition2 = state.getComposition();
            inputMethodManager.updateSelection(TextRange.m1790getMinimpl(state.getSelection()), TextRange.m1789getMaximpl(state.getSelection()), iM1790getMinimpl, composition2 != null ? TextRange.m1789getMaximpl(composition2.getPackedValue()) : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addEditCommandWithBatch(EditCommand editCommand) {
        beginBatchEditInternal();
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0 && !this.editCommands.isEmpty()) {
            this.eventCallback.onEditCommands(CollectionsKt.toMutableList((Collection) this.editCommands));
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        this.eventCallback.onConnectionClosed(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int maxChars, int flags) {
        return TextFieldValueKt.getTextBeforeSelection(this.textFieldValue, maxChars).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int maxChars, int flags) {
        return TextFieldValueKt.getTextAfterSelection(this.textFieldValue, maxChars).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int flags) {
        if (TextRange.m1786getCollapsedimpl(this.textFieldValue.getSelection())) {
            return null;
        }
        return TextFieldValueKt.getSelectedText(this.textFieldValue).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        boolean z = (flags & 1) != 0;
        this.extractedTextMonitorMode = z;
        if (z) {
            this.currentExtractedTextRequestToken = request != null ? request.token : 0;
        }
        return RecordingInputConnection_androidKt.toExtractedText(this.textFieldValue);
    }

    private final void sendSynthesizedKeyEvent(int code) {
        sendKeyEvent(new KeyEvent(0, code));
        sendKeyEvent(new KeyEvent(1, code));
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture gesture, Executor executor, IntConsumer consumer) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34LegacyPerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.legacyTextFieldState, this.textFieldSelectionManager, gesture, this.viewConfiguration, executor, consumer, new Function1<EditCommand, Unit>() { // from class: androidx.compose.foundation.text.input.internal.RecordingInputConnection.performHandwritingGesture.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EditCommand editCommand) {
                    invoke2(editCommand);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(EditCommand editCommand) {
                    RecordingInputConnection.this.addEditCommandWithBatch(editCommand);
                }
            });
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture gesture, CancellationSignal cancellationSignal) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34LegacyPerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.legacyTextFieldState, this.textFieldSelectionManager, gesture, cancellationSignal);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        return TextUtils.getCapsMode(this.textFieldValue.getText(), TextRange.m1790getMinimpl(this.textFieldValue.getSelection()), reqModes);
    }
}
