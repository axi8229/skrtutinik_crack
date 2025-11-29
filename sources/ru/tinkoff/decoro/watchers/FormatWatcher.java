package ru.tinkoff.decoro.watchers;

import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import android.widget.TextView;
import ru.tinkoff.decoro.Mask;
import ru.tinkoff.decoro.MaskFactory;

/* loaded from: classes4.dex */
public abstract class FormatWatcher implements TextWatcher, MaskFactory {
    private boolean initWithMask;
    private Mask mask;
    private CharSequence textBeforeChange;
    private TextView textView;
    private DiffMeasures diffMeasures = new DiffMeasures();
    private boolean selfEdit = false;
    private boolean noChanges = false;
    private boolean formattingCancelled = false;

    protected FormatWatcher() {
    }

    public void installOn(TextView textView) {
        installOn(textView, false);
    }

    public boolean isInstalled() {
        return this.textView != null;
    }

    protected void installOn(TextView textView, boolean z) {
        if (textView == null) {
            throw new IllegalArgumentException("text view cannot be null");
        }
        this.textView = textView;
        this.initWithMask = z;
        textView.removeTextChangedListener(this);
        textView.addTextChangedListener(this);
        this.mask = null;
        refreshMask();
    }

    public void refreshMask() {
        refreshMask(null);
    }

    public void refreshMask(CharSequence charSequence) {
        boolean z = this.mask == null;
        this.mask = createMask();
        checkMask();
        boolean z2 = charSequence != null;
        DiffMeasures diffMeasures = new DiffMeasures();
        this.diffMeasures = diffMeasures;
        if (z2) {
            diffMeasures.setCursorPosition(this.mask.insertFront(charSequence));
        }
        if ((!z || this.initWithMask || z2) && isInstalled()) {
            this.selfEdit = true;
            String string = this.mask.toString();
            TextView textView = this.textView;
            if (textView instanceof EditText) {
                Editable editable = (Editable) textView.getText();
                editable.replace(0, editable.length(), string, 0, string.length());
            } else {
                textView.setText(string);
            }
            setSelection(this.mask.getInitialInputPosition());
            this.selfEdit = false;
        }
    }

    public String toString() {
        Mask mask = this.mask;
        return mask == null ? "" : mask.toString();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.selfEdit || this.mask == null) {
            return;
        }
        this.textBeforeChange = new String(charSequence.toString());
        this.diffMeasures.calculateBeforeTextChanged(i, i2, i3);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        CharSequence charSequenceSubSequence;
        if (this.selfEdit || this.mask == null) {
            return;
        }
        if (this.diffMeasures.isInsertingChars()) {
            charSequenceSubSequence = charSequence.subSequence(this.diffMeasures.getStartPosition(), this.diffMeasures.getInsertEndPosition());
            if (this.diffMeasures.isTrimmingSequence() && this.textBeforeChange.subSequence(this.diffMeasures.getStartPosition(), this.diffMeasures.getInsertEndPosition()).equals(charSequenceSubSequence)) {
                this.diffMeasures.recalculateOnModifyingWord(charSequenceSubSequence.length());
            }
        } else {
            charSequenceSubSequence = null;
        }
        boolean zEquals = this.textBeforeChange.equals(charSequence.toString());
        this.noChanges = zEquals;
        if (zEquals) {
            return;
        }
        if (this.diffMeasures.isRemovingChars()) {
            if (!this.diffMeasures.isInsertingChars()) {
                DiffMeasures diffMeasures = this.diffMeasures;
                diffMeasures.setCursorPosition(this.mask.removeBackwards(diffMeasures.getRemoveEndPosition(), this.diffMeasures.getRemoveLength()));
            } else {
                DiffMeasures diffMeasures2 = this.diffMeasures;
                diffMeasures2.setCursorPosition(this.mask.removeBackwardsWithoutHardcoded(diffMeasures2.getRemoveEndPosition(), this.diffMeasures.getRemoveLength()));
            }
        }
        if (this.diffMeasures.isInsertingChars()) {
            DiffMeasures diffMeasures3 = this.diffMeasures;
            diffMeasures3.setCursorPosition(this.mask.insertAt(diffMeasures3.getStartPosition(), charSequenceSubSequence));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Mask mask;
        String str;
        if (this.formattingCancelled || this.selfEdit || (mask = this.mask) == null || this.noChanges) {
            this.formattingCancelled = false;
            this.noChanges = false;
            return;
        }
        String string = mask.toString();
        int cursorPosition = this.diffMeasures.getCursorPosition();
        if (!string.equals(editable.toString())) {
            int composingSpanStart = BaseInputConnection.getComposingSpanStart(editable);
            int length = cursorPosition > editable.length() ? editable.length() : cursorPosition;
            if (composingSpanStart == -1 || length == -1) {
                str = string;
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) string.substring(0, composingSpanStart));
                SpannableString spannableString = new SpannableString(string.substring(composingSpanStart, length));
                BaseInputConnection.setComposingSpans(spannableString);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) string.substring(length, string.length()));
                str = spannableStringBuilder;
            }
            this.selfEdit = true;
            editable.replace(0, editable.length(), str, 0, string.length());
            this.selfEdit = false;
        }
        if (cursorPosition >= 0 && cursorPosition <= editable.length()) {
            setSelection(cursorPosition);
        }
        this.textBeforeChange = null;
    }

    private void checkMask() {
        if (this.mask == null) {
            throw new IllegalStateException("Mask cannot be null at this point. Check maybe you forgot to call refreshMask()");
        }
    }

    private void setSelection(int i) {
        TextView textView = this.textView;
        if (!(textView instanceof EditText) || i > textView.length()) {
            return;
        }
        ((EditText) this.textView).setSelection(i);
    }
}
