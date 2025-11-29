package androidx.compose.ui.text.input;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.TextRange;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: RecordingInputConnection.android.kt */
@Deprecated
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0010J\u000f\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\"\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0016¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b(\u0010#J\u001f\u0010+\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b+\u0010'J\u001f\u0010,\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b,\u0010'J\u001f\u0010-\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0016¢\u0006\u0004\b-\u0010'J\u000f\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010\u0010J\u0017\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00105\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H\u0016¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H\u0016¢\u0006\u0004\b7\u00106J\u0019\u00108\u001a\u0004\u0018\u00010\u001f2\u0006\u00104\u001a\u00020\u0012H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0012H\u0016¢\u0006\u0004\b;\u0010<J!\u0010@\u001a\u00020?2\b\u0010>\u001a\u0004\u0018\u00010=2\u0006\u00104\u001a\u00020\u0012H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0012H\u0016¢\u0006\u0004\bC\u0010<J\u0017\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0012H\u0016¢\u0006\u0004\bE\u0010<J\u0019\u0010G\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bG\u0010HJ\u0019\u0010K\u001a\u00020\u00062\b\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bK\u0010LJ\u0011\u0010N\u001a\u0004\u0018\u00010MH\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010Q\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0012H\u0016¢\u0006\u0004\bQ\u0010<J\u0017\u0010S\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0006H\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u0012H\u0016¢\u0006\u0004\bV\u0010WJ#\u0010\\\u001a\u00020\u00062\b\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\b\\\u0010]J)\u0010a\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^2\u0006\u00104\u001a\u00020\u00122\b\u0010`\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\ba\u0010bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010c\u001a\u0004\bd\u0010eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010f\u001a\u0004\bg\u0010\u0010R\u0016\u0010h\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR*\u0010k\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u00028\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010iR\u0016\u0010r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010fR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020\n0s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010f¨\u0006w"}, d2 = {"Landroidx/compose/ui/text/input/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "Landroidx/compose/ui/text/input/TextFieldValue;", "initState", "Landroidx/compose/ui/text/input/InputEventCallback2;", "eventCallback", "", "autoCorrect", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/InputEventCallback2;Z)V", "Landroidx/compose/ui/text/input/EditCommand;", "editCommand", "", "addEditCommandWithBatch", "(Landroidx/compose/ui/text/input/EditCommand;)V", "beginBatchEditInternal", "()Z", "endBatchEditInternal", "", "code", "sendSynthesizedKeyEvent", "(I)V", "state", "Landroidx/compose/ui/text/input/InputMethodManager;", "inputMethodManager", "updateInputState", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/InputMethodManager;)V", "beginBatchEdit", "endBatchEdit", "closeConnection", "()V", "", "text", "newCursorPosition", "commitText", "(Ljava/lang/CharSequence;I)Z", "start", "end", "setComposingRegion", "(II)Z", "setComposingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "deleteSurroundingText", "setSelection", "finishComposingText", "Landroid/view/KeyEvent;", "event", "sendKeyEvent", "(Landroid/view/KeyEvent;)Z", "maxChars", "flags", "getTextBeforeCursor", "(II)Ljava/lang/CharSequence;", "getTextAfterCursor", "getSelectedText", "(I)Ljava/lang/CharSequence;", "cursorUpdateMode", "requestCursorUpdates", "(I)Z", "Landroid/view/inputmethod/ExtractedTextRequest;", "request", "Landroid/view/inputmethod/ExtractedText;", "getExtractedText", "(Landroid/view/inputmethod/ExtractedTextRequest;I)Landroid/view/inputmethod/ExtractedText;", "id", "performContextMenuAction", "editorAction", "performEditorAction", "Landroid/view/inputmethod/CompletionInfo;", "commitCompletion", "(Landroid/view/inputmethod/CompletionInfo;)Z", "Landroid/view/inputmethod/CorrectionInfo;", "correctionInfo", "commitCorrection", "(Landroid/view/inputmethod/CorrectionInfo;)Z", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "states", "clearMetaKeyStates", "enabled", "reportFullscreenMode", "(Z)Z", "reqModes", "getCursorCapsMode", "(I)I", "", "action", "Landroid/os/Bundle;", RemoteMessageConst.DATA, "performPrivateCommand", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "Landroid/view/inputmethod/InputContentInfo;", "inputContentInfo", "opts", "commitContent", "(Landroid/view/inputmethod/InputContentInfo;ILandroid/os/Bundle;)Z", "Landroidx/compose/ui/text/input/InputEventCallback2;", "getEventCallback", "()Landroidx/compose/ui/text/input/InputEventCallback2;", "Z", "getAutoCorrect", "batchDepth", "I", AppMeasurementSdk.ConditionalUserProperty.VALUE, "mTextFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "getMTextFieldValue$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setMTextFieldValue$ui_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "currentExtractedTextRequestToken", "extractedTextMonitorMode", "", "editCommands", "Ljava/util/List;", "isActive", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecordingInputConnection implements InputConnection {
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private TextFieldValue mTextFieldValue;
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

    public RecordingInputConnection(TextFieldValue textFieldValue, InputEventCallback2 inputEventCallback2, boolean z) {
        this.eventCallback = inputEventCallback2;
        this.autoCorrect = z;
        this.mTextFieldValue = textFieldValue;
    }

    public final void setMTextFieldValue$ui_release(TextFieldValue textFieldValue) {
        this.mTextFieldValue = textFieldValue;
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
                    addEditCommandWithBatch(new SetSelectionCommand(0, this.mTextFieldValue.getText().length()));
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
        this.eventCallback.mo1902onImeActionKlQnJC8(iM1890getDefaulteUduSuo);
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
            setMTextFieldValue$ui_release(state);
            if (this.extractedTextMonitorMode) {
                inputMethodManager.updateExtractedText(this.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(state));
            }
            TextRange composition = state.getComposition();
            int iM1790getMinimpl = composition != null ? TextRange.m1790getMinimpl(composition.getPackedValue()) : -1;
            TextRange composition2 = state.getComposition();
            inputMethodManager.updateSelection(TextRange.m1790getMinimpl(state.getSelection()), TextRange.m1789getMaximpl(state.getSelection()), iM1790getMinimpl, composition2 != null ? TextRange.m1789getMaximpl(composition2.getPackedValue()) : -1);
        }
    }

    private final void addEditCommandWithBatch(EditCommand editCommand) {
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
        return TextFieldValueKt.getTextBeforeSelection(this.mTextFieldValue, maxChars).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int maxChars, int flags) {
        return TextFieldValueKt.getTextAfterSelection(this.mTextFieldValue, maxChars).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int flags) {
        if (TextRange.m1786getCollapsedimpl(this.mTextFieldValue.getSelection())) {
            return null;
        }
        return TextFieldValueKt.getSelectedText(this.mTextFieldValue).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        boolean z = (flags & 1) != 0;
        this.extractedTextMonitorMode = z;
        if (z) {
            this.currentExtractedTextRequestToken = request != null ? request.token : 0;
        }
        return InputState_androidKt.toExtractedText(this.mTextFieldValue);
    }

    private final void sendSynthesizedKeyEvent(int code) {
        sendKeyEvent(new KeyEvent(0, code));
        sendKeyEvent(new KeyEvent(1, code));
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        return TextUtils.getCapsMode(this.mTextFieldValue.getText(), TextRange.m1790getMinimpl(this.mTextFieldValue.getSelection()), reqModes);
    }
}
