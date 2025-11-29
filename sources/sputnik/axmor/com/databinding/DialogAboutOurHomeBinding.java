package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class DialogAboutOurHomeBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnDismiss;
    private final ScrollView rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private DialogAboutOurHomeBinding(ScrollView scrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnApply = appCompatButton;
        this.btnDismiss = appCompatButton2;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static DialogAboutOurHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_about_our_home, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogAboutOurHomeBinding bind(View view) {
        int i = R.id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_apply);
        if (appCompatButton != null) {
            i = R.id.btn_dismiss;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_dismiss);
            if (appCompatButton2 != null) {
                i = R.id.tv_subtitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                    if (textView2 != null) {
                        return new DialogAboutOurHomeBinding((ScrollView) view, appCompatButton, appCompatButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
