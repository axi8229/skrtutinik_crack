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
public abstract class FragmentServicesArchiveActiveBinding extends ViewDataBinding {
    public final AppCompatButton btnServiceUpdate;
    public final LayoutInfoServiceBinding infoLayout;
    public final LinearLayout lMainInfoService;
    public final LinearLayout serviceLoader;
    public final WaintingSubscriptionScreenBinding serviceWaiting;
    public final AppCompatButton subsSettingsButton;
    public final Toolbar toolbar;
    public final TextView tvMainInfoService;
    public final ScrollView viewMain;

    protected FragmentServicesArchiveActiveBinding(Object obj, View view, int i, AppCompatButton appCompatButton, LayoutInfoServiceBinding layoutInfoServiceBinding, LinearLayout linearLayout, LinearLayout linearLayout2, WaintingSubscriptionScreenBinding waintingSubscriptionScreenBinding, AppCompatButton appCompatButton2, Toolbar toolbar, TextView textView, ScrollView scrollView) {
        super(obj, view, i);
        this.btnServiceUpdate = appCompatButton;
        this.infoLayout = layoutInfoServiceBinding;
        this.lMainInfoService = linearLayout;
        this.serviceLoader = linearLayout2;
        this.serviceWaiting = waintingSubscriptionScreenBinding;
        this.subsSettingsButton = appCompatButton2;
        this.toolbar = toolbar;
        this.tvMainInfoService = textView;
        this.viewMain = scrollView;
    }

    public static FragmentServicesArchiveActiveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentServicesArchiveActiveBinding bind(View view, Object obj) {
        return (FragmentServicesArchiveActiveBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_services_archive_active);
    }
}
