package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.databinding.LayoutCompleteRegistrationBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class FragmentProfileNoIntercomBinding extends ViewDataBinding {
    public final AppCompatButton btnServiceUpdate;
    public final ImageButton buttonExit;
    public final ConstraintLayout buttonNotifications;
    public final LinearLayout container;
    public final ImageButton imageButton;
    public final ImageView imageView8;
    public final LinearLayout lAddAddress;
    public final ConstraintLayout layoutAboutOurHome;
    public final LayoutCompleteRegistrationBinding layoutCompleteRegistration;
    public final LinearLayout linearLayout3;
    public final ScrollView profileScroll;
    public final TextView settingsAddress;
    public final TextView settingsFio;
    public final TextView settingsLabel;
    public final LinearLayout settingsLanguage;
    public final TextView settingsLanguageTitle;
    public final ImageView settingsPhoto;
    public final ConstraintLayout toolbar;
    public final TextView toolbarTitle;
    public final TextView tvCurrentAddress;
    public final TextView tvOurHomeDescription;
    public final TextView tvOurHomeTitle;
    public final LinearLayout userLayout;
    public final View viewOnboardingNotifications;

    protected FragmentProfileNoIntercomBinding(Object obj, View view, int i, AppCompatButton appCompatButton, ImageButton imageButton, ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageButton imageButton2, ImageView imageView, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, LayoutCompleteRegistrationBinding layoutCompleteRegistrationBinding, LinearLayout linearLayout3, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout4, TextView textView4, ImageView imageView2, ConstraintLayout constraintLayout3, TextView textView5, TextView textView6, TextView textView7, TextView textView8, LinearLayout linearLayout5, View view2) {
        super(obj, view, i);
        this.btnServiceUpdate = appCompatButton;
        this.buttonExit = imageButton;
        this.buttonNotifications = constraintLayout;
        this.container = linearLayout;
        this.imageButton = imageButton2;
        this.imageView8 = imageView;
        this.lAddAddress = linearLayout2;
        this.layoutAboutOurHome = constraintLayout2;
        this.layoutCompleteRegistration = layoutCompleteRegistrationBinding;
        this.linearLayout3 = linearLayout3;
        this.profileScroll = scrollView;
        this.settingsAddress = textView;
        this.settingsFio = textView2;
        this.settingsLabel = textView3;
        this.settingsLanguage = linearLayout4;
        this.settingsLanguageTitle = textView4;
        this.settingsPhoto = imageView2;
        this.toolbar = constraintLayout3;
        this.toolbarTitle = textView5;
        this.tvCurrentAddress = textView6;
        this.tvOurHomeDescription = textView7;
        this.tvOurHomeTitle = textView8;
        this.userLayout = linearLayout5;
        this.viewOnboardingNotifications = view2;
    }

    public static FragmentProfileNoIntercomBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProfileNoIntercomBinding bind(View view, Object obj) {
        return (FragmentProfileNoIntercomBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_profile_no_intercom);
    }
}
