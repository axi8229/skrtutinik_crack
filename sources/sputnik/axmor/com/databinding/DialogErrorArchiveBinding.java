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
public final class DialogErrorArchiveBinding implements ViewBinding {
    public final AppCompatButton btnComplete;
    public final TextView dialogNotice;
    public final TextView dialogTitle;
    private final FrameLayout rootView;

    private DialogErrorArchiveBinding(FrameLayout frameLayout, AppCompatButton appCompatButton, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.btnComplete = appCompatButton;
        this.dialogNotice = textView;
        this.dialogTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogErrorArchiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_error_archive, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogErrorArchiveBinding bind(View view) {
        int i = R.id.btn_complete;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_complete);
        if (appCompatButton != null) {
            i = R.id.dialog_notice;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_notice);
            if (textView != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_title);
                if (textView2 != null) {
                    return new DialogErrorArchiveBinding((FrameLayout) view, appCompatButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
