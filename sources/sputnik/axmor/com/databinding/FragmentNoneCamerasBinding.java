package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.ToggleStateButton;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentNoneCamerasBinding implements ViewBinding {
    public final TextView btnHelp;
    public final ToggleStateButton btnReport;
    private final ConstraintLayout rootView;
    public final TextView tvCompanyContactsInfo;
    public final TextView tvTitle;

    private FragmentNoneCamerasBinding(ConstraintLayout constraintLayout, TextView textView, ToggleStateButton toggleStateButton, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnHelp = textView;
        this.btnReport = toggleStateButton;
        this.tvCompanyContactsInfo = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNoneCamerasBinding bind(View view) {
        int i = R.id.btnHelp;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.btnHelp);
        if (textView != null) {
            i = R.id.btn_report;
            ToggleStateButton toggleStateButton = (ToggleStateButton) ViewBindings.findChildViewById(view, R.id.btn_report);
            if (toggleStateButton != null) {
                i = R.id.tv_company_contacts_info;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_contacts_info);
                if (textView2 != null) {
                    i = R.id.tv_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                    if (textView3 != null) {
                        return new FragmentNoneCamerasBinding((ConstraintLayout) view, textView, toggleStateButton, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
