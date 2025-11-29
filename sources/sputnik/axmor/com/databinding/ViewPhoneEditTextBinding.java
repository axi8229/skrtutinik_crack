package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class ViewPhoneEditTextBinding extends ViewDataBinding {
    public final EditText etCountryCode;
    public final EditText etPhone;
    public final ConstraintLayout layoutPhone;
    public final TextView tvError;
    public final View view4;

    protected ViewPhoneEditTextBinding(Object obj, View view, int i, EditText editText, EditText editText2, ConstraintLayout constraintLayout, TextView textView, View view2) {
        super(obj, view, i);
        this.etCountryCode = editText;
        this.etPhone = editText2;
        this.layoutPhone = constraintLayout;
        this.tvError = textView;
        this.view4 = view2;
    }

    public static ViewPhoneEditTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewPhoneEditTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewPhoneEditTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_phone_edit_text, viewGroup, z, obj);
    }
}
