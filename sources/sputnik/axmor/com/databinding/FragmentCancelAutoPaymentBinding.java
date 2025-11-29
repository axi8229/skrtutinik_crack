package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes5.dex */
public abstract class FragmentCancelAutoPaymentBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnNoCancel;
    public final EditText etReason;
    public final TextView header;
    public final LinearLayout lOtherReason;
    public final RadioGroup radioGroup;
    public final RadioButton rbNoConfident;
    public final RadioButton rbNoError;
    public final RadioButton rbNoOtherReason;
    public final RadioButton rbNoProps;

    protected FragmentCancelAutoPaymentBinding(Object obj, View view, int i, Button button, Button button2, EditText editText, TextView textView, LinearLayout linearLayout, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnNoCancel = button2;
        this.etReason = editText;
        this.header = textView;
        this.lOtherReason = linearLayout;
        this.radioGroup = radioGroup;
        this.rbNoConfident = radioButton;
        this.rbNoError = radioButton2;
        this.rbNoOtherReason = radioButton3;
        this.rbNoProps = radioButton4;
    }
}
