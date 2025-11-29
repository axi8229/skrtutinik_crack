package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.slider.Slider;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class FragmentBleServiceBinding extends ViewDataBinding {
    public final AppCompatButton btnSetupPermissions;
    public final AppCompatButton btnSetupRssi;
    public final ConstraintLayout constraintLayout3;
    public final ImageView imageView15;
    public final ImageView imageView2;
    public final ImageView imageView8;
    public final ImageView imageView9;
    public final ConstraintLayout layoutBeta;
    public final ConstraintLayout layoutCard;
    public final LayoutInfoServiceBinding layoutInfo;
    public final LinearLayout layoutLoader;
    public final ConstraintLayout layoutPermissions;
    public final LinearLayout layoutSliderHints;
    public final LinearLayout linearLayout8;
    public final WaintingSubscriptionScreenBinding serviceWaiting;
    public final Slider slider;
    public final AppCompatButton subsSettingsButton;
    public final SwitchCompat switchBle;
    public final SwitchCompat switchBlePromo;
    public final Toolbar toolbar;
    public final TextView tvAttention;
    public final TextView tvBeta;
    public final TextView tvBleEnabledTitle;
    public final TextView tvBlePromoTitle;
    public final TextView tvDistanceDescription;
    public final TextView tvDistanceLong;
    public final TextView tvDistanceNear;
    public final TextView tvDistanceTitle;
    public final TextView tvRssiDescription;
    public final TextView tvRssiTitle;
    public final TextView tvTitle;
    public final ScrollView viewMain;

    protected FragmentBleServiceBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LayoutInfoServiceBinding layoutInfoServiceBinding, LinearLayout linearLayout, ConstraintLayout constraintLayout4, LinearLayout linearLayout2, LinearLayout linearLayout3, WaintingSubscriptionScreenBinding waintingSubscriptionScreenBinding, Slider slider, AppCompatButton appCompatButton3, SwitchCompat switchCompat, SwitchCompat switchCompat2, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ScrollView scrollView) {
        super(obj, view, i);
        this.btnSetupPermissions = appCompatButton;
        this.btnSetupRssi = appCompatButton2;
        this.constraintLayout3 = constraintLayout;
        this.imageView15 = imageView;
        this.imageView2 = imageView2;
        this.imageView8 = imageView3;
        this.imageView9 = imageView4;
        this.layoutBeta = constraintLayout2;
        this.layoutCard = constraintLayout3;
        this.layoutInfo = layoutInfoServiceBinding;
        this.layoutLoader = linearLayout;
        this.layoutPermissions = constraintLayout4;
        this.layoutSliderHints = linearLayout2;
        this.linearLayout8 = linearLayout3;
        this.serviceWaiting = waintingSubscriptionScreenBinding;
        this.slider = slider;
        this.subsSettingsButton = appCompatButton3;
        this.switchBle = switchCompat;
        this.switchBlePromo = switchCompat2;
        this.toolbar = toolbar;
        this.tvAttention = textView;
        this.tvBeta = textView2;
        this.tvBleEnabledTitle = textView3;
        this.tvBlePromoTitle = textView4;
        this.tvDistanceDescription = textView5;
        this.tvDistanceLong = textView6;
        this.tvDistanceNear = textView7;
        this.tvDistanceTitle = textView8;
        this.tvRssiDescription = textView9;
        this.tvRssiTitle = textView10;
        this.tvTitle = textView11;
        this.viewMain = scrollView;
    }

    public static FragmentBleServiceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBleServiceBinding bind(View view, Object obj) {
        return (FragmentBleServiceBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_ble_service);
    }
}
