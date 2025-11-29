package com.redmadrobot.inputmask;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy;
import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.helper.RTLMask;
import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Notation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaskedTextChangedListener.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0002bcBw\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b%\u0010&J1\u0010,\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001fH\u0016¢\u0006\u0004\b,\u0010-J/\u00100\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020'2\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001fH\u0016¢\u0006\u0004\b0\u0010-J!\u00104\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u000bH\u0016¢\u0006\u0004\b4\u00105R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010;\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010G\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR$\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010G\u001a\u0004\bX\u0010I\"\u0004\bY\u0010KR\u0016\u0010Z\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u00106R\u0016\u0010[\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010^R\u0014\u0010a\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`¨\u0006d"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "Landroid/text/TextWatcher;", "Landroid/view/View$OnFocusChangeListener;", "", "primaryFormat", "", "affineFormats", "Lcom/redmadrobot/inputmask/model/Notation;", "customNotations", "Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "affinityCalculationStrategy", "", "autocomplete", "autoskip", "Landroid/widget/EditText;", "field", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "valueListener", "rightToLeft", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;ZZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;Z)V", "Lcom/redmadrobot/inputmask/model/CaretString;", "text", "Lcom/redmadrobot/inputmask/helper/Mask;", "pickMask", "(Lcom/redmadrobot/inputmask/model/CaretString;)Lcom/redmadrobot/inputmask/helper/Mask;", "format", "maskGetOrCreate", "(Ljava/lang/String;Ljava/util/List;)Lcom/redmadrobot/inputmask/helper/Mask;", "mask", "", "calculateAffinity", "(Lcom/redmadrobot/inputmask/helper/Mask;Lcom/redmadrobot/inputmask/model/CaretString;)I", "Landroid/text/Editable;", "edit", "", "afterTextChanged", "(Landroid/text/Editable;)V", "", "s", "start", "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "cursorPosition", "before", "onTextChanged", "Landroid/view/View;", "view", "hasFocus", "onFocusChange", "(Landroid/view/View;Z)V", "Ljava/lang/String;", "getPrimaryFormat", "()Ljava/lang/String;", "setPrimaryFormat", "(Ljava/lang/String;)V", "Ljava/util/List;", "getAffineFormats", "()Ljava/util/List;", "setAffineFormats", "(Ljava/util/List;)V", "getCustomNotations", "setCustomNotations", "Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "getAffinityCalculationStrategy", "()Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "setAffinityCalculationStrategy", "(Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;)V", "Z", "getAutocomplete", "()Z", "setAutocomplete", "(Z)V", "getAutoskip", "setAutoskip", "Landroid/text/TextWatcher;", "getListener", "()Landroid/text/TextWatcher;", "setListener", "(Landroid/text/TextWatcher;)V", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "getValueListener", "()Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "setValueListener", "(Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "getRightToLeft", "setRightToLeft", "afterText", "caretPosition", "I", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getPrimaryMask", "()Lcom/redmadrobot/inputmask/helper/Mask;", "primaryMask", "Companion", "ValueListener", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class MaskedTextChangedListener implements TextWatcher, View.OnFocusChangeListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<String> affineFormats;
    private AffinityCalculationStrategy affinityCalculationStrategy;
    private String afterText;
    private boolean autocomplete;
    private boolean autoskip;
    private int caretPosition;
    private List<Notation> customNotations;
    private final WeakReference<EditText> field;
    private TextWatcher listener;
    private String primaryFormat;
    private boolean rightToLeft;
    private ValueListener valueListener;

    /* compiled from: MaskedTextChangedListener.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "", "onTextChanged", "", "maskFilled", "", "extractedValue", "", "formattedValue", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface ValueListener {
        void onTextChanged(boolean maskFilled, String extractedValue, String formattedValue);
    }

    public MaskedTextChangedListener(String primaryFormat, List<String> affineFormats, List<Notation> customNotations, AffinityCalculationStrategy affinityCalculationStrategy, boolean z, boolean z2, EditText field, TextWatcher textWatcher, ValueListener valueListener, boolean z3) {
        Intrinsics.checkNotNullParameter(primaryFormat, "primaryFormat");
        Intrinsics.checkNotNullParameter(affineFormats, "affineFormats");
        Intrinsics.checkNotNullParameter(customNotations, "customNotations");
        Intrinsics.checkNotNullParameter(affinityCalculationStrategy, "affinityCalculationStrategy");
        Intrinsics.checkNotNullParameter(field, "field");
        this.primaryFormat = primaryFormat;
        this.affineFormats = affineFormats;
        this.customNotations = customNotations;
        this.affinityCalculationStrategy = affinityCalculationStrategy;
        this.autocomplete = z;
        this.autoskip = z2;
        this.listener = textWatcher;
        this.valueListener = valueListener;
        this.rightToLeft = z3;
        this.afterText = "";
        this.field = new WeakReference<>(field);
    }

    public /* synthetic */ MaskedTextChangedListener(String str, List list, List list2, AffinityCalculationStrategy affinityCalculationStrategy, boolean z, boolean z2, EditText editText, TextWatcher textWatcher, ValueListener valueListener, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? AffinityCalculationStrategy.WHOLE_STRING : affinityCalculationStrategy, (i & 16) != 0 ? true : z, (i & 32) != 0 ? false : z2, editText, (i & 128) != 0 ? null : textWatcher, (i & 256) != 0 ? null : valueListener, (i & 512) != 0 ? false : z3);
    }

    private final Mask getPrimaryMask() {
        return maskGetOrCreate(this.primaryFormat, this.customNotations);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable edit) {
        EditText editText = this.field.get();
        if (editText != null) {
            editText.removeTextChangedListener(this);
        }
        if (edit != null) {
            edit.replace(0, edit.length(), this.afterText);
        }
        try {
            EditText editText2 = this.field.get();
            if (editText2 != null) {
                editText2.setSelection(this.caretPosition);
            }
        } catch (IndexOutOfBoundsException unused) {
            Log.e("input-mask-android", "\n                    \n                    WARNING! Your text field is not configured for the MaskedTextChangedListener! \n                    For more information please refer to \n                    \n                    InputMask vs. android:inputType and IndexOutOfBoundsException\n                    https://github.com/RedMadRobot/input-mask-android#inputmask-vs-androidinputtype-and-indexoutofboundsexception\n                    ");
        }
        EditText editText3 = this.field.get();
        if (editText3 != null) {
            editText3.addTextChangedListener(this);
        }
        TextWatcher textWatcher = this.listener;
        if (textWatcher == null) {
            return;
        }
        textWatcher.afterTextChanged(edit);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        TextWatcher textWatcher = this.listener;
        if (textWatcher == null) {
            return;
        }
        textWatcher.beforeTextChanged(s, start, count, after);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int cursorPosition, int before, int count) {
        Intrinsics.checkNotNullParameter(text, "text");
        boolean z = before > 0 && count == 0;
        CaretString.CaretGravity backward = z ? new CaretString.CaretGravity.BACKWARD(z ? this.autoskip : false) : new CaretString.CaretGravity.FORWARD(z ? false : this.autocomplete);
        if (!z) {
            cursorPosition += count;
        }
        CaretString caretString = new CaretString(text.toString(), cursorPosition, backward);
        Mask.Result resultApply = pickMask(caretString).apply(caretString);
        this.afterText = resultApply.getFormattedText().getString();
        this.caretPosition = resultApply.getFormattedText().getCaretPosition();
        ValueListener valueListener = this.valueListener;
        if (valueListener == null) {
            return;
        }
        valueListener.onTextChanged(resultApply.getComplete(), resultApply.getExtractedValue(), this.afterText);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean hasFocus) {
        String strValueOf;
        if (this.autocomplete && hasFocus) {
            EditText editText = this.field.get();
            Editable text = editText == null ? null : editText.getText();
            Intrinsics.checkNotNull(text);
            if (text.length() == 0) {
                strValueOf = "";
            } else {
                EditText editText2 = this.field.get();
                strValueOf = String.valueOf(editText2 != null ? editText2.getText() : null);
            }
            CaretString caretString = new CaretString(strValueOf, strValueOf.length(), new CaretString.CaretGravity.FORWARD(this.autocomplete));
            Mask.Result resultApply = pickMask(caretString).apply(caretString);
            this.afterText = resultApply.getFormattedText().getString();
            this.caretPosition = resultApply.getFormattedText().getCaretPosition();
            EditText editText3 = this.field.get();
            if (editText3 != null) {
                editText3.setText(this.afterText);
            }
            try {
                EditText editText4 = this.field.get();
                if (editText4 != null) {
                    editText4.setSelection(resultApply.getFormattedText().getCaretPosition());
                }
            } catch (IndexOutOfBoundsException unused) {
                Log.e("input-mask-android", "\n                        \n                    WARNING! Your text field is not configured for the MaskedTextChangedListener! \n                    For more information please refer to \n                    \n                    InputMask vs. android:inputType and IndexOutOfBoundsException\n                    https://github.com/RedMadRobot/input-mask-android#inputmask-vs-androidinputtype-and-indexoutofboundsexception\n                    ");
            }
            ValueListener valueListener = this.valueListener;
            if (valueListener == null) {
                return;
            }
            valueListener.onTextChanged(resultApply.getComplete(), resultApply.getExtractedValue(), this.afterText);
        }
    }

    private final Mask pickMask(CaretString text) {
        if (this.affineFormats.isEmpty()) {
            return getPrimaryMask();
        }
        int iCalculateAffinity = calculateAffinity(getPrimaryMask(), text);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.affineFormats.iterator();
        while (it.hasNext()) {
            Mask maskMaskGetOrCreate = maskGetOrCreate(it.next(), this.customNotations);
            arrayList.add(new MaskAffinity(maskMaskGetOrCreate, calculateAffinity(maskMaskGetOrCreate, text)));
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator<T>() { // from class: com.redmadrobot.inputmask.MaskedTextChangedListener$pickMask$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((MaskedTextChangedListener.MaskAffinity) t2).getAffinity()), Integer.valueOf(((MaskedTextChangedListener.MaskAffinity) t).getAffinity()));
                }
            });
        }
        Iterator it2 = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            int i2 = i + 1;
            if (iCalculateAffinity >= ((MaskAffinity) it2.next()).getAffinity()) {
                break;
            }
            i = i2;
        }
        if (i >= 0) {
            arrayList.add(i, new MaskAffinity(getPrimaryMask(), iCalculateAffinity));
        } else {
            arrayList.add(new MaskAffinity(getPrimaryMask(), iCalculateAffinity));
        }
        return ((MaskAffinity) CollectionsKt.first((List) arrayList)).getMask();
    }

    /* compiled from: MaskedTextChangedListener.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"com/redmadrobot/inputmask/MaskedTextChangedListener$pickMask$MaskAffinity", "", "Lcom/redmadrobot/inputmask/helper/Mask;", "mask", "", "affinity", "<init>", "(Lcom/redmadrobot/inputmask/helper/Mask;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/redmadrobot/inputmask/helper/Mask;", "getMask", "()Lcom/redmadrobot/inputmask/helper/Mask;", "I", "getAffinity", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class MaskAffinity {
        private final int affinity;
        private final Mask mask;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MaskAffinity)) {
                return false;
            }
            MaskAffinity maskAffinity = (MaskAffinity) other;
            return Intrinsics.areEqual(this.mask, maskAffinity.mask) && this.affinity == maskAffinity.affinity;
        }

        public int hashCode() {
            return (this.mask.hashCode() * 31) + Integer.hashCode(this.affinity);
        }

        public String toString() {
            return "MaskAffinity(mask=" + this.mask + ", affinity=" + this.affinity + ')';
        }

        public MaskAffinity(Mask mask, int i) {
            Intrinsics.checkNotNullParameter(mask, "mask");
            this.mask = mask;
            this.affinity = i;
        }

        public final int getAffinity() {
            return this.affinity;
        }

        public final Mask getMask() {
            return this.mask;
        }
    }

    private final Mask maskGetOrCreate(String format, List<Notation> customNotations) {
        if (this.rightToLeft) {
            return RTLMask.INSTANCE.getOrCreate(format, customNotations);
        }
        return Mask.INSTANCE.getOrCreate(format, customNotations);
    }

    private final int calculateAffinity(Mask mask, CaretString text) {
        return this.affinityCalculationStrategy.calculateAffinityOfMask(mask, text);
    }

    /* compiled from: MaskedTextChangedListener.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Js\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener$Companion;", "", "<init>", "()V", "Landroid/widget/EditText;", "editText", "", "primaryFormat", "", "affineFormats", "Lcom/redmadrobot/inputmask/model/Notation;", "customNotations", "Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "affinityCalculationStrategy", "", "autocomplete", "autoskip", "Landroid/text/TextWatcher;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "valueListener", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "installOn", "(Landroid/widget/EditText;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;ZZLandroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MaskedTextChangedListener installOn(EditText editText, String primaryFormat, List<String> affineFormats, List<Notation> customNotations, AffinityCalculationStrategy affinityCalculationStrategy, boolean autocomplete, boolean autoskip, TextWatcher listener, ValueListener valueListener) {
            Intrinsics.checkNotNullParameter(editText, "editText");
            Intrinsics.checkNotNullParameter(primaryFormat, "primaryFormat");
            Intrinsics.checkNotNullParameter(affineFormats, "affineFormats");
            Intrinsics.checkNotNullParameter(customNotations, "customNotations");
            Intrinsics.checkNotNullParameter(affinityCalculationStrategy, "affinityCalculationStrategy");
            MaskedTextChangedListener maskedTextChangedListener = new MaskedTextChangedListener(primaryFormat, affineFormats, customNotations, affinityCalculationStrategy, autocomplete, autoskip, editText, listener, valueListener, false, 512, null);
            editText.addTextChangedListener(maskedTextChangedListener);
            editText.setOnFocusChangeListener(maskedTextChangedListener);
            return maskedTextChangedListener;
        }
    }
}
