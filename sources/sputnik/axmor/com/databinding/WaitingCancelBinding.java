package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class WaitingCancelBinding implements ViewBinding {
    public final AppCompatButton buttonHelp;
    public final ProgressBar progressView;
    private final ScrollView rootView;
    public final View viewCenter;
    public final TextView waitingDescription;
    public final TextView waitingHeader;

    private WaitingCancelBinding(ScrollView scrollView, AppCompatButton appCompatButton, ProgressBar progressBar, View view, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.buttonHelp = appCompatButton;
        this.progressView = progressBar;
        this.viewCenter = view;
        this.waitingDescription = textView;
        this.waitingHeader = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static WaitingCancelBinding bind(View view) {
        int i = R.id.button_help;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.button_help);
        if (appCompatButton != null) {
            i = R.id.progress_view;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_view);
            if (progressBar != null) {
                i = R.id.view_center;
                View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view_center);
                if (viewFindChildViewById != null) {
                    i = R.id.waiting_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.waiting_description);
                    if (textView != null) {
                        i = R.id.waiting_header;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.waiting_header);
                        if (textView2 != null) {
                            return new WaitingCancelBinding((ScrollView) view, appCompatButton, progressBar, viewFindChildViewById, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
