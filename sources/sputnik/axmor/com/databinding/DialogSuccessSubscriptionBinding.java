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
public final class DialogSuccessSubscriptionBinding implements ViewBinding {
    public final AppCompatButton btnSubscribe;
    public final TextView dialogNotice;
    public final TextView dialogTitle;
    private final LinearLayout rootView;

    private DialogSuccessSubscriptionBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnSubscribe = appCompatButton;
        this.dialogNotice = textView;
        this.dialogTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSuccessSubscriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_success_subscription, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSuccessSubscriptionBinding bind(View view) {
        int i = R.id.btn_subscribe;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
        if (appCompatButton != null) {
            i = R.id.dialogNotice;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialogNotice);
            if (textView != null) {
                i = R.id.dialogTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dialogTitle);
                if (textView2 != null) {
                    return new DialogSuccessSubscriptionBinding((LinearLayout) view, appCompatButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
