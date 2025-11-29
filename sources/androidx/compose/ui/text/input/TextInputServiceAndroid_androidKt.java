package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroid/view/inputmethod/EditorInfo;", "", "updateWithEmojiCompat", "(Landroid/view/inputmethod/EditorInfo;)V", "Landroidx/compose/ui/text/input/ImeOptions;", "imeOptions", "Landroidx/compose/ui/text/input/TextFieldValue;", "textFieldValue", "update", "(Landroid/view/inputmethod/EditorInfo;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/ui/text/input/TextFieldValue;)V", "Landroid/view/Choreographer;", "Ljava/util/concurrent/Executor;", "asExecutor", "(Landroid/view/Choreographer;)Ljava/util/concurrent/Executor;", "", "bits", "flag", "", "hasFlag", "(II)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        int imeAction = imeOptions.getImeAction();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        int i = 6;
        if (ImeAction.m1886equalsimpl0(imeAction, companion.m1890getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1894getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1892getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1893getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1895getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1896getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1897getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m1886equalsimpl0(imeAction, companion.m1891getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i;
        imeOptions.getPlatformImeOptions();
        int keyboardType = imeOptions.getKeyboardType();
        KeyboardType.Companion companion2 = KeyboardType.INSTANCE;
        if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1929getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1922getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1925getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1928getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1931getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1924getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1927getPasswordPjHm6EE())) {
            editorInfo.inputType = pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1926getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1923getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type");
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m1886equalsimpl0(imeOptions.getImeAction(), companion.m1890getDefaulteUduSuo())) {
                editorInfo.imeOptions |= pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.INSTANCE;
            if (KeyboardCapitalization.m1906equalsimpl0(capitalization, companion3.m1910getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m1906equalsimpl0(capitalization, companion3.m1914getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m1906equalsimpl0(capitalization, companion3.m1912getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP;
            }
        }
        editorInfo.initialSelStart = TextRange.m1792getStartimpl(textFieldValue.getSelection());
        editorInfo.initialSelEnd = TextRange.m1787getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$2(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$2(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
