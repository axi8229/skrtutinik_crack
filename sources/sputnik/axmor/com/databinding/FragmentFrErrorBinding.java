package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentFrErrorBinding implements ViewBinding {
    public final Guideline frGuideline;
    public final AppCompatButton frSettingsCheckButtonEnd;
    public final ImageView imgSuccessFr;
    private final ScrollView rootView;
    public final ScrollView scrollView;
    public final Toolbar title;
    public final TextView tvAllDone;
    public final TextView tvInfoResult;

    private FragmentFrErrorBinding(ScrollView scrollView, Guideline guideline, AppCompatButton appCompatButton, ImageView imageView, ScrollView scrollView2, Toolbar toolbar, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.frGuideline = guideline;
        this.frSettingsCheckButtonEnd = appCompatButton;
        this.imgSuccessFr = imageView;
        this.scrollView = scrollView2;
        this.title = toolbar;
        this.tvAllDone = textView;
        this.tvInfoResult = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentFrErrorBinding bind(View view) {
        int i = R.id.fr_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.fr_guideline);
        if (guideline != null) {
            i = R.id.fr_settings_check_button_end;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.fr_settings_check_button_end);
            if (appCompatButton != null) {
                i = R.id.img_success_fr;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.img_success_fr);
                if (imageView != null) {
                    ScrollView scrollView = (ScrollView) view;
                    i = R.id.title;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.title);
                    if (toolbar != null) {
                        i = R.id.tv_all_done;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_all_done);
                        if (textView != null) {
                            i = R.id.tv_info_result;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_info_result);
                            if (textView2 != null) {
                                return new FragmentFrErrorBinding(scrollView, guideline, appCompatButton, imageView, scrollView, toolbar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
