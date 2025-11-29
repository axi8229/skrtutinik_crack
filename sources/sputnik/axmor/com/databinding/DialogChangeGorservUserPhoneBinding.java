package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class DialogChangeGorservUserPhoneBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnBack;
    public final EditText etPhone;
    public final ProgressBar pbRequestApartments;
    private final ScrollView rootView;
    public final TextView title;

    private DialogChangeGorservUserPhoneBinding(ScrollView scrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, EditText editText, ProgressBar progressBar, TextView textView) {
        this.rootView = scrollView;
        this.btnApply = appCompatButton;
        this.btnBack = appCompatButton2;
        this.etPhone = editText;
        this.pbRequestApartments = progressBar;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static DialogChangeGorservUserPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_change_gorserv_user_phone, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogChangeGorservUserPhoneBinding bind(View view) {
        int i = R.id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_apply);
        if (appCompatButton != null) {
            i = R.id.btn_back;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_back);
            if (appCompatButton2 != null) {
                i = R.id.et_phone;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_phone);
                if (editText != null) {
                    i = R.id.pb_request_apartments;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_request_apartments);
                    if (progressBar != null) {
                        i = R.id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                        if (textView != null) {
                            return new DialogChangeGorservUserPhoneBinding((ScrollView) view, appCompatButton, appCompatButton2, editText, progressBar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
