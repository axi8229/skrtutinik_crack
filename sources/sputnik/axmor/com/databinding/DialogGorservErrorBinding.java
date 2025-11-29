package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class DialogGorservErrorBinding implements ViewBinding {
    public final AppCompatButton btnComplete;
    public final AppCompatButton btnHelp;
    public final ProgressBar pbRequestApartments;
    private final FrameLayout rootView;
    public final TextView subtitle;
    public final TextView title;

    private DialogGorservErrorBinding(FrameLayout frameLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.btnComplete = appCompatButton;
        this.btnHelp = appCompatButton2;
        this.pbRequestApartments = progressBar;
        this.subtitle = textView;
        this.title = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogGorservErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_gorserv_error, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogGorservErrorBinding bind(View view) {
        int i = R.id.btn_complete;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_complete);
        if (appCompatButton != null) {
            i = R.id.btn_help;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_help);
            if (appCompatButton2 != null) {
                i = R.id.pb_request_apartments;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_request_apartments);
                if (progressBar != null) {
                    i = R.id.subtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.subtitle);
                    if (textView != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                        if (textView2 != null) {
                            return new DialogGorservErrorBinding((FrameLayout) view, appCompatButton, appCompatButton2, progressBar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
