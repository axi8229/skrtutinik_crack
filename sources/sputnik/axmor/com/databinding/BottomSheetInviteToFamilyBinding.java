package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView;

/* loaded from: classes5.dex */
public final class BottomSheetInviteToFamilyBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnBack;
    public final PhoneEditTextView etPhone;
    private final LinearLayout rootView;
    public final TextView tvPhoneLabel;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private BottomSheetInviteToFamilyBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, PhoneEditTextView phoneEditTextView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.btnBack = appCompatButton2;
        this.etPhone = phoneEditTextView;
        this.tvPhoneLabel = textView;
        this.tvSubtitle = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetInviteToFamilyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_invite_to_family, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetInviteToFamilyBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.btn_back;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_back);
            if (appCompatButton2 != null) {
                i = R.id.et_phone;
                PhoneEditTextView phoneEditTextView = (PhoneEditTextView) ViewBindings.findChildViewById(view, R.id.et_phone);
                if (phoneEditTextView != null) {
                    i = R.id.tv_phone_label;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_phone_label);
                    if (textView != null) {
                        i = R.id.tv_subtitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                        if (textView2 != null) {
                            i = R.id.tv_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                            if (textView3 != null) {
                                return new BottomSheetInviteToFamilyBinding((LinearLayout) view, appCompatButton, appCompatButton2, phoneEditTextView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
