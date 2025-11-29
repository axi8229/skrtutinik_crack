package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.CheckBoxPreferenceView;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentPermissionsBinding implements ViewBinding {
    public final AppCompatButton btnOpenSystemSettings;
    public final ConstraintLayout layoutBackgroundWork;
    public final CheckBoxPreferenceView prefBackgroundLocationPermission;
    public final CheckBoxPreferenceView prefBluetoothService;
    public final CheckBoxPreferenceView prefDisplayOverAppsPermission;
    public final CheckBoxPreferenceView prefGpsService;
    public final CheckBoxPreferenceView prefLocationPermission;
    public final CheckBoxPreferenceView prefNearbyDevicesPermission;
    public final CheckBoxPreferenceView prefNotificationsPermission;
    public final CheckBoxPreferenceView prefWhitelistPermission;
    private final LinearLayout rootView;
    public final LinearLayout serviceLoader;
    public final Toolbar toolbar;
    public final TextView tvBackgroundWorkSubtitle;
    public final TextView tvBackgroundWorkTitle;
    public final ScrollView viewMain;

    private FragmentPermissionsBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, ConstraintLayout constraintLayout, CheckBoxPreferenceView checkBoxPreferenceView, CheckBoxPreferenceView checkBoxPreferenceView2, CheckBoxPreferenceView checkBoxPreferenceView3, CheckBoxPreferenceView checkBoxPreferenceView4, CheckBoxPreferenceView checkBoxPreferenceView5, CheckBoxPreferenceView checkBoxPreferenceView6, CheckBoxPreferenceView checkBoxPreferenceView7, CheckBoxPreferenceView checkBoxPreferenceView8, LinearLayout linearLayout2, Toolbar toolbar, TextView textView, TextView textView2, ScrollView scrollView) {
        this.rootView = linearLayout;
        this.btnOpenSystemSettings = appCompatButton;
        this.layoutBackgroundWork = constraintLayout;
        this.prefBackgroundLocationPermission = checkBoxPreferenceView;
        this.prefBluetoothService = checkBoxPreferenceView2;
        this.prefDisplayOverAppsPermission = checkBoxPreferenceView3;
        this.prefGpsService = checkBoxPreferenceView4;
        this.prefLocationPermission = checkBoxPreferenceView5;
        this.prefNearbyDevicesPermission = checkBoxPreferenceView6;
        this.prefNotificationsPermission = checkBoxPreferenceView7;
        this.prefWhitelistPermission = checkBoxPreferenceView8;
        this.serviceLoader = linearLayout2;
        this.toolbar = toolbar;
        this.tvBackgroundWorkSubtitle = textView;
        this.tvBackgroundWorkTitle = textView2;
        this.viewMain = scrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPermissionsBinding bind(View view) {
        int i = R.id.btn_open_system_settings;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_open_system_settings);
        if (appCompatButton != null) {
            i = R.id.layout_background_work;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_background_work);
            if (constraintLayout != null) {
                i = R.id.pref_background_location_permission;
                CheckBoxPreferenceView checkBoxPreferenceView = (CheckBoxPreferenceView) ViewBindings.findChildViewById(view, R.id.pref_background_location_permission);
                if (checkBoxPreferenceView != null) {
                    i = R.id.pref_bluetooth_service;
                    CheckBoxPreferenceView checkBoxPreferenceView2 = (CheckBoxPreferenceView) ViewBindings.findChildViewById(view, R.id.pref_bluetooth_service);
                    if (checkBoxPreferenceView2 != null) {
                        i = R.id.pref_display_over_apps_permission;
                        CheckBoxPreferenceView checkBoxPreferenceView3 = (CheckBoxPreferenceView) ViewBindings.findChildViewById(view, R.id.pref_display_over_apps_permission);
                        if (checkBoxPreferenceView3 != null) {
                            i = R.id.pref_gps_service;
                            CheckBoxPreferenceView checkBoxPreferenceView4 = (CheckBoxPreferenceView) ViewBindings.findChildViewById(view, R.id.pref_gps_service);
                            if (checkBoxPreferenceView4 != null) {
                                i = R.id.pref_location_permission;
                                CheckBoxPreferenceView checkBoxPreferenceView5 = (CheckBoxPreferenceView) ViewBindings.findChildViewById(view, R.id.pref_location_permission);
                                if (checkBoxPreferenceView5 != null) {
                                    i = R.id.pref_nearby_devices_permission;
                                    CheckBoxPreferenceView checkBoxPreferenceView6 = (CheckBoxPreferenceView) ViewBindings.findChildViewById(view, R.id.pref_nearby_devices_permission);
                                    if (checkBoxPreferenceView6 != null) {
                                        i = R.id.pref_notifications_permission;
                                        CheckBoxPreferenceView checkBoxPreferenceView7 = (CheckBoxPreferenceView) ViewBindings.findChildViewById(view, R.id.pref_notifications_permission);
                                        if (checkBoxPreferenceView7 != null) {
                                            i = R.id.pref_whitelist_permission;
                                            CheckBoxPreferenceView checkBoxPreferenceView8 = (CheckBoxPreferenceView) ViewBindings.findChildViewById(view, R.id.pref_whitelist_permission);
                                            if (checkBoxPreferenceView8 != null) {
                                                i = R.id.serviceLoader;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.serviceLoader);
                                                if (linearLayout != null) {
                                                    i = R.id.toolbar;
                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                    if (toolbar != null) {
                                                        i = R.id.tv_background_work_subtitle;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_background_work_subtitle);
                                                        if (textView != null) {
                                                            i = R.id.tv_background_work_title;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_background_work_title);
                                                            if (textView2 != null) {
                                                                i = R.id.viewMain;
                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.viewMain);
                                                                if (scrollView != null) {
                                                                    return new FragmentPermissionsBinding((LinearLayout) view, appCompatButton, constraintLayout, checkBoxPreferenceView, checkBoxPreferenceView2, checkBoxPreferenceView3, checkBoxPreferenceView4, checkBoxPreferenceView5, checkBoxPreferenceView6, checkBoxPreferenceView7, checkBoxPreferenceView8, linearLayout, toolbar, textView, textView2, scrollView);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
