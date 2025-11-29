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

/* loaded from: classes5.dex */
public final class DialogPartnerSubscriptionBinding implements ViewBinding {
    public final AppCompatButton btnContinue;
    public final TextView dialogNotice;
    public final TextView dialogTitle;
    public final TextView partherAbout;
    private final LinearLayout rootView;

    private DialogPartnerSubscriptionBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnContinue = appCompatButton;
        this.dialogNotice = textView;
        this.dialogTitle = textView2;
        this.partherAbout = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogPartnerSubscriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_partner_subscription, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogPartnerSubscriptionBinding bind(View view) {
        int i = R.id.btn_continue;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_continue);
        if (appCompatButton != null) {
            i = R.id.dialogNotice;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialogNotice);
            if (textView != null) {
                i = R.id.dialogTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dialogTitle);
                if (textView2 != null) {
                    i = R.id.parther_about;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.parther_about);
                    if (textView3 != null) {
                        return new DialogPartnerSubscriptionBinding((LinearLayout) view, appCompatButton, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
