package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class DialogInfoBinding implements ViewBinding {
    public final AppCompatButton btnOk;
    public final TextView dialogNotice;
    public final TextView dialogTitle;
    private final FrameLayout rootView;

    private DialogInfoBinding(FrameLayout frameLayout, AppCompatButton appCompatButton, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.btnOk = appCompatButton;
        this.dialogNotice = textView;
        this.dialogTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogInfoBinding bind(View view) {
        int i = R.id.btn_ok;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_ok);
        if (appCompatButton != null) {
            i = R.id.dialog_notice;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_notice);
            if (textView != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_title);
                if (textView2 != null) {
                    return new DialogInfoBinding((FrameLayout) view, appCompatButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
