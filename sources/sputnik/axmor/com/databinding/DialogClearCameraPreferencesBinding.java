package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class DialogClearCameraPreferencesBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnBack;
    public final ProgressBar pbRequestApartments;
    private final ScrollView rootView;
    public final TextView tvBody;
    public final TextView tvTitle;

    private DialogClearCameraPreferencesBinding(ScrollView scrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnApply = appCompatButton;
        this.btnBack = appCompatButton2;
        this.pbRequestApartments = progressBar;
        this.tvBody = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static DialogClearCameraPreferencesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_clear_camera_preferences, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogClearCameraPreferencesBinding bind(View view) {
        int i = R.id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_apply);
        if (appCompatButton != null) {
            i = R.id.btn_back;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_back);
            if (appCompatButton2 != null) {
                i = R.id.pb_request_apartments;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_request_apartments);
                if (progressBar != null) {
                    i = R.id.tv_body;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_body);
                    if (textView != null) {
                        i = R.id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                        if (textView2 != null) {
                            return new DialogClearCameraPreferencesBinding((ScrollView) view, appCompatButton, appCompatButton2, progressBar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
