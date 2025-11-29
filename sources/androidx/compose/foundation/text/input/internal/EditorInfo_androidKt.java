package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* compiled from: EditorInfo.android.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a@\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"hasFlag", "", "bits", "", "flag", "update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: update-pLxbY9I$default, reason: not valid java name */
    public static /* synthetic */ void m499updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        m498updatepLxbY9I(editorInfo, charSequence, j, imeOptions, strArr);
    }

    /* renamed from: update-pLxbY9I, reason: not valid java name */
    public static final void m498updatepLxbY9I(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr) {
        int imeAction = imeOptions.getImeAction();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        int i = 3;
        int i2 = 6;
        if (ImeAction.m1886equalsimpl0(imeAction, companion.m1890getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i2 = 0;
            }
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1894getNoneeUduSuo())) {
            i2 = 1;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1892getGoeUduSuo())) {
            i2 = 2;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1893getNexteUduSuo())) {
            i2 = 5;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1895getPreviouseUduSuo())) {
            i2 = 7;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1896getSearcheUduSuo())) {
            i2 = 3;
        } else if (ImeAction.m1886equalsimpl0(imeAction, companion.m1897getSendeUduSuo())) {
            i2 = 4;
        } else if (!ImeAction.m1886equalsimpl0(imeAction, companion.m1891getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i2;
        imeOptions.getPlatformImeOptions();
        LocaleListHelper.INSTANCE.setHintLocales(editorInfo, imeOptions.getHintLocales());
        int keyboardType = imeOptions.getKeyboardType();
        KeyboardType.Companion companion2 = KeyboardType.INSTANCE;
        if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1929getTextPjHm6EE())) {
            i = 1;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1922getAsciiPjHm6EE())) {
            editorInfo.imeOptions |= Integer.MIN_VALUE;
            i = 1;
        } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1925getNumberPjHm6EE())) {
            i = 2;
        } else if (!KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1928getPhonePjHm6EE())) {
            if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1931getUriPjHm6EE())) {
                i = 17;
            } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1924getEmailPjHm6EE())) {
                i = 33;
            } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1927getPasswordPjHm6EE())) {
                i = pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6;
            } else if (KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1926getNumberPasswordPjHm6EE())) {
                i = 18;
            } else {
                if (!KeyboardType.m1918equalsimpl0(keyboardType, companion2.m1923getDecimalPjHm6EE())) {
                    throw new IllegalStateException("Invalid Keyboard Type");
                }
                i = 8194;
            }
        }
        editorInfo.inputType = i;
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
        editorInfo.initialSelStart = TextRange.m1792getStartimpl(j);
        editorInfo.initialSelEnd = TextRange.m1787getEndimpl(j);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
        if (strArr != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
        }
        editorInfo.imeOptions |= 33554432;
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() && !KeyboardType.m1918equalsimpl0(imeOptions.getKeyboardType(), companion2.m1927getPasswordPjHm6EE()) && !KeyboardType.m1918equalsimpl0(imeOptions.getKeyboardType(), companion2.m1926getNumberPasswordPjHm6EE())) {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
            EditorInfoApi34.INSTANCE.setHandwritingGestures(editorInfo);
        } else {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
        }
    }
}
