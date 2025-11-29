package ru.yoomoney.sdk.auth.phone.enter.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.utils.PhoneUtilsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J*\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J \u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J*\u0010\u001d\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/utils/PhoneNumberDetectionWatcher;", "Landroid/text/TextWatcher;", "editText", "Landroid/widget/EditText;", "region", "", "(Landroid/widget/EditText;Ljava/lang/String;)V", "isFormatting", "", "previousFormattedString", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "changeCursorPositionIfNeed", "strFormatted", "str", "currentPosition", "getCursorPositionAfterFormat", "formattedString", "originalString", "originalPosition", "onTextChanged", "before", "replaceEditTextInput", "ed", "st", "en", "text", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public class PhoneNumberDetectionWatcher implements TextWatcher {
    private final EditText editText;
    private boolean isFormatting;
    private String previousFormattedString;
    private final String region;

    public PhoneNumberDetectionWatcher(EditText editText, String region) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(region, "region");
        this.editText = editText;
        this.region = region;
    }

    private final void changeCursorPositionIfNeed(String strFormatted, String str, int currentPosition) {
        int cursorPositionAfterFormat;
        if (!Intrinsics.areEqual(strFormatted, this.previousFormattedString) && (cursorPositionAfterFormat = getCursorPositionAfterFormat(strFormatted, str, currentPosition)) >= 0 && cursorPositionAfterFormat <= this.editText.getText().length()) {
            this.editText.setSelection(cursorPositionAfterFormat);
        }
        this.previousFormattedString = strFormatted;
    }

    private final int getCursorPositionAfterFormat(String formattedString, String originalString, int originalPosition) {
        int i;
        int i2 = 0;
        if (originalString.length() >= originalPosition) {
            CharSequence charSequenceSubSequence = originalString.subSequence(originalPosition, originalString.length());
            i = 0;
            for (int i3 = 0; i3 < charSequenceSubSequence.length(); i3++) {
                if (Character.isDigit(charSequenceSubSequence.charAt(i3))) {
                    i++;
                }
            }
        } else {
            i = 0;
        }
        int length = formattedString.length();
        while (i > i2 && length > 0) {
            length--;
            if (Character.isDigit(formattedString.charAt(length))) {
                i2++;
            }
        }
        return length;
    }

    private final void replaceEditTextInput(Editable ed, int st, int en, CharSequence text) {
        this.isFormatting = true;
        ed.replace(st, en, text);
        this.isFormatting = false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.isFormatting || editable == null) {
            return;
        }
        String string = editable.toString();
        String andMaskNumber = PhoneUtilsKt.formatAndMaskNumber(string, this.region);
        if (Intrinsics.areEqual(string, andMaskNumber)) {
            return;
        }
        int selectionEnd = this.editText.getSelectionEnd();
        replaceEditTextInput(editable, 0, editable.length(), andMaskNumber);
        changeCursorPositionIfNeed(andMaskNumber, string, selectionEnd);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
}
