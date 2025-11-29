package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.slider.Slider;
import com.sputnik.common.ui.view.TextViewWithPoint;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class ActivityBleBinding implements ViewBinding {
    public final Button btnAnalyzeAll;
    public final Button btnAnalyzeMax;
    public final Button btnAnalyzeMin;
    public final AppCompatButton btnApply;
    public final Button btnBackgroundLocationPermission;
    public final Button btnBackgroundWork;
    public final Button btnBluetooth;
    public final Button btnGps;
    public final Button btnGpsPermission;
    public final Button btnNearbyDevicesPermission;
    public final Button btnNotificationsPermission;
    public final Button btnNotifyMain;
    public final Button btnNotifyNoPermissions;
    public final Button btnNotifyOpeningError;
    public final Button btnOpenSystemSettings;
    public final Button btnStartService;
    public final Button btnStopService;
    public final Button btnWhiteList;
    public final CheckBox cbBleServiceAvailable;
    public final EditText etIntercomsHash;
    public final EditText etMinRssi;
    public final LinearLayout layoutBackgroundLocationPermission;
    public final LinearLayout layoutLocationPermission;
    public final LinearLayout layoutNearbyDevicesPermission;
    public final LinearLayout layoutNotificationsPermission;
    public final ProgressBar pbAnalyzing;
    private final ConstraintLayout rootView;
    public final Slider slider;
    public final TextViewWithPoint tvBackgroundLocationPermission;
    public final TextViewWithPoint tvBackgroundWork;
    public final TextView tvBleTitle;
    public final TextViewWithPoint tvBluetooth;
    public final TextView tvCurrentRssi;
    public final TextViewWithPoint tvGps;
    public final TextViewWithPoint tvGpsPermission;
    public final TextViewWithPoint tvIntercomsHash;
    public final TextViewWithPoint tvNearbyDevicesPermission;
    public final TextViewWithPoint tvNotificationsPermission;
    public final TextView tvRssi;
    public final TextViewWithPoint tvSubtitle;
    public final TextViewWithPoint tvWhiteList;

    private ActivityBleBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, AppCompatButton appCompatButton, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Button button13, Button button14, Button button15, Button button16, Button button17, CheckBox checkBox, EditText editText, EditText editText2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, Slider slider, TextViewWithPoint textViewWithPoint, TextViewWithPoint textViewWithPoint2, TextView textView, TextViewWithPoint textViewWithPoint3, TextView textView2, TextViewWithPoint textViewWithPoint4, TextViewWithPoint textViewWithPoint5, TextViewWithPoint textViewWithPoint6, TextViewWithPoint textViewWithPoint7, TextViewWithPoint textViewWithPoint8, TextView textView3, TextViewWithPoint textViewWithPoint9, TextViewWithPoint textViewWithPoint10) {
        this.rootView = constraintLayout;
        this.btnAnalyzeAll = button;
        this.btnAnalyzeMax = button2;
        this.btnAnalyzeMin = button3;
        this.btnApply = appCompatButton;
        this.btnBackgroundLocationPermission = button4;
        this.btnBackgroundWork = button5;
        this.btnBluetooth = button6;
        this.btnGps = button7;
        this.btnGpsPermission = button8;
        this.btnNearbyDevicesPermission = button9;
        this.btnNotificationsPermission = button10;
        this.btnNotifyMain = button11;
        this.btnNotifyNoPermissions = button12;
        this.btnNotifyOpeningError = button13;
        this.btnOpenSystemSettings = button14;
        this.btnStartService = button15;
        this.btnStopService = button16;
        this.btnWhiteList = button17;
        this.cbBleServiceAvailable = checkBox;
        this.etIntercomsHash = editText;
        this.etMinRssi = editText2;
        this.layoutBackgroundLocationPermission = linearLayout;
        this.layoutLocationPermission = linearLayout2;
        this.layoutNearbyDevicesPermission = linearLayout3;
        this.layoutNotificationsPermission = linearLayout4;
        this.pbAnalyzing = progressBar;
        this.slider = slider;
        this.tvBackgroundLocationPermission = textViewWithPoint;
        this.tvBackgroundWork = textViewWithPoint2;
        this.tvBleTitle = textView;
        this.tvBluetooth = textViewWithPoint3;
        this.tvCurrentRssi = textView2;
        this.tvGps = textViewWithPoint4;
        this.tvGpsPermission = textViewWithPoint5;
        this.tvIntercomsHash = textViewWithPoint6;
        this.tvNearbyDevicesPermission = textViewWithPoint7;
        this.tvNotificationsPermission = textViewWithPoint8;
        this.tvRssi = textView3;
        this.tvSubtitle = textViewWithPoint9;
        this.tvWhiteList = textViewWithPoint10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ble, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBleBinding bind(View view) {
        int i = R.id.btn_analyze_all;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_analyze_all);
        if (button != null) {
            i = R.id.btn_analyze_max;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.btn_analyze_max);
            if (button2 != null) {
                i = R.id.btn_analyze_min;
                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.btn_analyze_min);
                if (button3 != null) {
                    i = R.id.btnApply;
                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
                    if (appCompatButton != null) {
                        i = R.id.btn_background_location_permission;
                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.btn_background_location_permission);
                        if (button4 != null) {
                            i = R.id.btn_background_work;
                            Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.btn_background_work);
                            if (button5 != null) {
                                i = R.id.btn_bluetooth;
                                Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.btn_bluetooth);
                                if (button6 != null) {
                                    i = R.id.btn_gps;
                                    Button button7 = (Button) ViewBindings.findChildViewById(view, R.id.btn_gps);
                                    if (button7 != null) {
                                        i = R.id.btn_gps_permission;
                                        Button button8 = (Button) ViewBindings.findChildViewById(view, R.id.btn_gps_permission);
                                        if (button8 != null) {
                                            i = R.id.btn_nearby_devices_permission;
                                            Button button9 = (Button) ViewBindings.findChildViewById(view, R.id.btn_nearby_devices_permission);
                                            if (button9 != null) {
                                                i = R.id.btn_notifications_permission;
                                                Button button10 = (Button) ViewBindings.findChildViewById(view, R.id.btn_notifications_permission);
                                                if (button10 != null) {
                                                    i = R.id.btn_notify_main;
                                                    Button button11 = (Button) ViewBindings.findChildViewById(view, R.id.btn_notify_main);
                                                    if (button11 != null) {
                                                        i = R.id.btn_notify_no_permissions;
                                                        Button button12 = (Button) ViewBindings.findChildViewById(view, R.id.btn_notify_no_permissions);
                                                        if (button12 != null) {
                                                            i = R.id.btn_notify_opening_error;
                                                            Button button13 = (Button) ViewBindings.findChildViewById(view, R.id.btn_notify_opening_error);
                                                            if (button13 != null) {
                                                                i = R.id.btn_open_system_settings;
                                                                Button button14 = (Button) ViewBindings.findChildViewById(view, R.id.btn_open_system_settings);
                                                                if (button14 != null) {
                                                                    i = R.id.btn_start_service;
                                                                    Button button15 = (Button) ViewBindings.findChildViewById(view, R.id.btn_start_service);
                                                                    if (button15 != null) {
                                                                        i = R.id.btn_stop_service;
                                                                        Button button16 = (Button) ViewBindings.findChildViewById(view, R.id.btn_stop_service);
                                                                        if (button16 != null) {
                                                                            i = R.id.btn_white_list;
                                                                            Button button17 = (Button) ViewBindings.findChildViewById(view, R.id.btn_white_list);
                                                                            if (button17 != null) {
                                                                                i = R.id.cb_ble_service_available;
                                                                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cb_ble_service_available);
                                                                                if (checkBox != null) {
                                                                                    i = R.id.et_intercoms_hash;
                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_intercoms_hash);
                                                                                    if (editText != null) {
                                                                                        i = R.id.et_min_rssi;
                                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_min_rssi);
                                                                                        if (editText2 != null) {
                                                                                            i = R.id.layout_background_location_permission;
                                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_background_location_permission);
                                                                                            if (linearLayout != null) {
                                                                                                i = R.id.layout_location_permission;
                                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_location_permission);
                                                                                                if (linearLayout2 != null) {
                                                                                                    i = R.id.layout_nearby_devices_permission;
                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_nearby_devices_permission);
                                                                                                    if (linearLayout3 != null) {
                                                                                                        i = R.id.layout_notifications_permission;
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_notifications_permission);
                                                                                                        if (linearLayout4 != null) {
                                                                                                            i = R.id.pb_analyzing;
                                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_analyzing);
                                                                                                            if (progressBar != null) {
                                                                                                                i = R.id.slider;
                                                                                                                Slider slider = (Slider) ViewBindings.findChildViewById(view, R.id.slider);
                                                                                                                if (slider != null) {
                                                                                                                    i = R.id.tv_background_location_permission;
                                                                                                                    TextViewWithPoint textViewWithPoint = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_background_location_permission);
                                                                                                                    if (textViewWithPoint != null) {
                                                                                                                        i = R.id.tv_background_work;
                                                                                                                        TextViewWithPoint textViewWithPoint2 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_background_work);
                                                                                                                        if (textViewWithPoint2 != null) {
                                                                                                                            i = R.id.tv_ble_title;
                                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ble_title);
                                                                                                                            if (textView != null) {
                                                                                                                                i = R.id.tv_bluetooth;
                                                                                                                                TextViewWithPoint textViewWithPoint3 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_bluetooth);
                                                                                                                                if (textViewWithPoint3 != null) {
                                                                                                                                    i = R.id.tv_current_rssi;
                                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_current_rssi);
                                                                                                                                    if (textView2 != null) {
                                                                                                                                        i = R.id.tv_gps;
                                                                                                                                        TextViewWithPoint textViewWithPoint4 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_gps);
                                                                                                                                        if (textViewWithPoint4 != null) {
                                                                                                                                            i = R.id.tv_gps_permission;
                                                                                                                                            TextViewWithPoint textViewWithPoint5 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_gps_permission);
                                                                                                                                            if (textViewWithPoint5 != null) {
                                                                                                                                                i = R.id.tv_intercoms_hash;
                                                                                                                                                TextViewWithPoint textViewWithPoint6 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_intercoms_hash);
                                                                                                                                                if (textViewWithPoint6 != null) {
                                                                                                                                                    i = R.id.tv_nearby_devices_permission;
                                                                                                                                                    TextViewWithPoint textViewWithPoint7 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_nearby_devices_permission);
                                                                                                                                                    if (textViewWithPoint7 != null) {
                                                                                                                                                        i = R.id.tv_notifications_permission;
                                                                                                                                                        TextViewWithPoint textViewWithPoint8 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_notifications_permission);
                                                                                                                                                        if (textViewWithPoint8 != null) {
                                                                                                                                                            i = R.id.tv_rssi;
                                                                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_rssi);
                                                                                                                                                            if (textView3 != null) {
                                                                                                                                                                i = R.id.tv_subtitle;
                                                                                                                                                                TextViewWithPoint textViewWithPoint9 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                                                                                                                                                                if (textViewWithPoint9 != null) {
                                                                                                                                                                    i = R.id.tv_white_list;
                                                                                                                                                                    TextViewWithPoint textViewWithPoint10 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_white_list);
                                                                                                                                                                    if (textViewWithPoint10 != null) {
                                                                                                                                                                        return new ActivityBleBinding((ConstraintLayout) view, button, button2, button3, appCompatButton, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, checkBox, editText, editText2, linearLayout, linearLayout2, linearLayout3, linearLayout4, progressBar, slider, textViewWithPoint, textViewWithPoint2, textView, textViewWithPoint3, textView2, textViewWithPoint4, textViewWithPoint5, textViewWithPoint6, textViewWithPoint7, textViewWithPoint8, textView3, textViewWithPoint9, textViewWithPoint10);
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
