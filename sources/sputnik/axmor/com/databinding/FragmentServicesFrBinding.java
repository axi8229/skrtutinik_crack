package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class FragmentServicesFrBinding extends ViewDataBinding {
    public final AppCompatButton btnServiceDelete;
    public final AppCompatButton btnServiceUpdate;
    public final LayoutInfoServiceBinding infoLayout;
    public final LinearLayout lMainInfoService;
    public final LinearLayout serviceLoader;
    public final WaintingSubscriptionScreenBinding serviceWaiting;
    public final AppCompatButton subsSettingsButton;
    public final Toolbar toolbar;
    public final TextView tvMainInfoService;
    public final ScrollView viewMain;

    protected FragmentServicesFrBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, LayoutInfoServiceBinding layoutInfoServiceBinding, LinearLayout linearLayout, LinearLayout linearLayout2, WaintingSubscriptionScreenBinding waintingSubscriptionScreenBinding, AppCompatButton appCompatButton3, Toolbar toolbar, TextView textView, ScrollView scrollView) {
        super(obj, view, i);
        this.btnServiceDelete = appCompatButton;
        this.btnServiceUpdate = appCompatButton2;
        this.infoLayout = layoutInfoServiceBinding;
        this.lMainInfoService = linearLayout;
        this.serviceLoader = linearLayout2;
        this.serviceWaiting = waintingSubscriptionScreenBinding;
        this.subsSettingsButton = appCompatButton3;
        this.toolbar = toolbar;
        this.tvMainInfoService = textView;
        this.viewMain = scrollView;
    }

    public static FragmentServicesFrBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServicesFrBinding bind(View view, Object obj) {
        return (FragmentServicesFrBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_services_fr);
    }
}
