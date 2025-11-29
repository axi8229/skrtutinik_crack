package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.TextViewWithPoint;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class ActivitySettingsBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final Button btnBle;
    public final Button btnClearAllAccounts;
    public final Button btnClearLogs;
    public final Button btnClearRedPoint;
    public final Button btnClearSelectedAccount;
    public final Button btnClearSessions;
    public final Button btnClearSplashData;
    public final Button btnClearVisitsPopup;
    public final ImageButton btnClose;
    public final Button btnCopyVarioqubId;
    public final Button btnGeneratePaymentToken;
    public final Button btnGetPushToken;
    public final Button btnKillApp;
    public final Button btnLog;
    public final Button btnNotifyError;
    public final Button btnNotifyText;
    public final Button btnOpenPushTools;
    public final ImageView btnSaveJwt;
    public final Button btnShareLogs;
    public final Button btnShareLogsAll;
    public final Button btnSharePrefs;
    public final ImageButton btnUpdateAccrual;
    public final CheckBox cbAccountLimitsEnabled;
    public final EditText etAppVersion;
    public final AppCompatEditText etBaseUrl;
    public final EditText etJwt;
    public final EditText etLastAccrualDate;
    public final AppCompatEditText etLog;
    public final EditText etPaymentTokenAmount;
    public final ImageView imageView;
    public final RadioGroup rbGroupBaseUrl;
    public final RadioGroup rbGroupPaymentsEnvironment;
    public final RadioButton rbOther;
    public final RadioButton rbPaymentsProd;
    public final RadioButton rbPaymentsStage;
    public final RadioButton rbProd;
    public final RadioButton rbStage;
    public final RadioButton rbStage2;
    private final ConstraintLayout rootView;
    public final TextViewWithPoint tvAppVersion;
    public final TextView tvBaseUrl;
    public final TextView tvGeneratePaymentToken;
    public final TextViewWithPoint tvJwt;
    public final TextViewWithPoint tvLastAccruedDate;
    public final TextView tvLastAccruedDateAttention;
    public final TextView tvTitle;

    private ActivitySettingsBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, ImageButton imageButton, Button button9, Button button10, Button button11, Button button12, Button button13, Button button14, Button button15, Button button16, ImageView imageView, Button button17, Button button18, Button button19, ImageButton imageButton2, CheckBox checkBox, EditText editText, AppCompatEditText appCompatEditText, EditText editText2, EditText editText3, AppCompatEditText appCompatEditText2, EditText editText4, ImageView imageView2, RadioGroup radioGroup, RadioGroup radioGroup2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, TextViewWithPoint textViewWithPoint, TextView textView, TextView textView2, TextViewWithPoint textViewWithPoint2, TextViewWithPoint textViewWithPoint3, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnApply = appCompatButton;
        this.btnBle = button;
        this.btnClearAllAccounts = button2;
        this.btnClearLogs = button3;
        this.btnClearRedPoint = button4;
        this.btnClearSelectedAccount = button5;
        this.btnClearSessions = button6;
        this.btnClearSplashData = button7;
        this.btnClearVisitsPopup = button8;
        this.btnClose = imageButton;
        this.btnCopyVarioqubId = button9;
        this.btnGeneratePaymentToken = button10;
        this.btnGetPushToken = button11;
        this.btnKillApp = button12;
        this.btnLog = button13;
        this.btnNotifyError = button14;
        this.btnNotifyText = button15;
        this.btnOpenPushTools = button16;
        this.btnSaveJwt = imageView;
        this.btnShareLogs = button17;
        this.btnShareLogsAll = button18;
        this.btnSharePrefs = button19;
        this.btnUpdateAccrual = imageButton2;
        this.cbAccountLimitsEnabled = checkBox;
        this.etAppVersion = editText;
        this.etBaseUrl = appCompatEditText;
        this.etJwt = editText2;
        this.etLastAccrualDate = editText3;
        this.etLog = appCompatEditText2;
        this.etPaymentTokenAmount = editText4;
        this.imageView = imageView2;
        this.rbGroupBaseUrl = radioGroup;
        this.rbGroupPaymentsEnvironment = radioGroup2;
        this.rbOther = radioButton;
        this.rbPaymentsProd = radioButton2;
        this.rbPaymentsStage = radioButton3;
        this.rbProd = radioButton4;
        this.rbStage = radioButton5;
        this.rbStage2 = radioButton6;
        this.tvAppVersion = textViewWithPoint;
        this.tvBaseUrl = textView;
        this.tvGeneratePaymentToken = textView2;
        this.tvJwt = textViewWithPoint2;
        this.tvLastAccruedDate = textViewWithPoint3;
        this.tvLastAccruedDateAttention = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySettingsBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.btn_ble;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_ble);
            if (button != null) {
                i = R.id.btn_clear_all_accounts;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.btn_clear_all_accounts);
                if (button2 != null) {
                    i = R.id.btn_clear_logs;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.btn_clear_logs);
                    if (button3 != null) {
                        i = R.id.btn_clear_red_point;
                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.btn_clear_red_point);
                        if (button4 != null) {
                            i = R.id.btn_clear_selected_account;
                            Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.btn_clear_selected_account);
                            if (button5 != null) {
                                i = R.id.btn_clear_sessions;
                                Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.btn_clear_sessions);
                                if (button6 != null) {
                                    i = R.id.btn_clear_splash_data;
                                    Button button7 = (Button) ViewBindings.findChildViewById(view, R.id.btn_clear_splash_data);
                                    if (button7 != null) {
                                        i = R.id.btn_clear_visits_popup;
                                        Button button8 = (Button) ViewBindings.findChildViewById(view, R.id.btn_clear_visits_popup);
                                        if (button8 != null) {
                                            i = R.id.btn_close;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_close);
                                            if (imageButton != null) {
                                                i = R.id.btn_copy_varioqub_id;
                                                Button button9 = (Button) ViewBindings.findChildViewById(view, R.id.btn_copy_varioqub_id);
                                                if (button9 != null) {
                                                    i = R.id.btn_generate_payment_token;
                                                    Button button10 = (Button) ViewBindings.findChildViewById(view, R.id.btn_generate_payment_token);
                                                    if (button10 != null) {
                                                        i = R.id.btn_get_push_token;
                                                        Button button11 = (Button) ViewBindings.findChildViewById(view, R.id.btn_get_push_token);
                                                        if (button11 != null) {
                                                            i = R.id.btn_kill_app;
                                                            Button button12 = (Button) ViewBindings.findChildViewById(view, R.id.btn_kill_app);
                                                            if (button12 != null) {
                                                                i = R.id.btn_log;
                                                                Button button13 = (Button) ViewBindings.findChildViewById(view, R.id.btn_log);
                                                                if (button13 != null) {
                                                                    i = R.id.btn_notify_error;
                                                                    Button button14 = (Button) ViewBindings.findChildViewById(view, R.id.btn_notify_error);
                                                                    if (button14 != null) {
                                                                        i = R.id.btn_notify_text;
                                                                        Button button15 = (Button) ViewBindings.findChildViewById(view, R.id.btn_notify_text);
                                                                        if (button15 != null) {
                                                                            i = R.id.btn_open_push_tools;
                                                                            Button button16 = (Button) ViewBindings.findChildViewById(view, R.id.btn_open_push_tools);
                                                                            if (button16 != null) {
                                                                                i = R.id.btn_save_jwt;
                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_save_jwt);
                                                                                if (imageView != null) {
                                                                                    i = R.id.btn_share_logs;
                                                                                    Button button17 = (Button) ViewBindings.findChildViewById(view, R.id.btn_share_logs);
                                                                                    if (button17 != null) {
                                                                                        i = R.id.btn_share_logsAll;
                                                                                        Button button18 = (Button) ViewBindings.findChildViewById(view, R.id.btn_share_logsAll);
                                                                                        if (button18 != null) {
                                                                                            i = R.id.btn_share_prefs;
                                                                                            Button button19 = (Button) ViewBindings.findChildViewById(view, R.id.btn_share_prefs);
                                                                                            if (button19 != null) {
                                                                                                i = R.id.btn_update_accrual;
                                                                                                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_update_accrual);
                                                                                                if (imageButton2 != null) {
                                                                                                    i = R.id.cb_account_limits_enabled;
                                                                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cb_account_limits_enabled);
                                                                                                    if (checkBox != null) {
                                                                                                        i = R.id.et_app_version;
                                                                                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_app_version);
                                                                                                        if (editText != null) {
                                                                                                            i = R.id.et_base_url;
                                                                                                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.et_base_url);
                                                                                                            if (appCompatEditText != null) {
                                                                                                                i = R.id.et_jwt;
                                                                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_jwt);
                                                                                                                if (editText2 != null) {
                                                                                                                    i = R.id.et_last_accrual_date;
                                                                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, R.id.et_last_accrual_date);
                                                                                                                    if (editText3 != null) {
                                                                                                                        i = R.id.et_log;
                                                                                                                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.et_log);
                                                                                                                        if (appCompatEditText2 != null) {
                                                                                                                            i = R.id.et_payment_token_amount;
                                                                                                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(view, R.id.et_payment_token_amount);
                                                                                                                            if (editText4 != null) {
                                                                                                                                i = R.id.imageView;
                                                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView);
                                                                                                                                if (imageView2 != null) {
                                                                                                                                    i = R.id.rb_group_base_url;
                                                                                                                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.rb_group_base_url);
                                                                                                                                    if (radioGroup != null) {
                                                                                                                                        i = R.id.rb_group_payments_environment;
                                                                                                                                        RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view, R.id.rb_group_payments_environment);
                                                                                                                                        if (radioGroup2 != null) {
                                                                                                                                            i = R.id.rb_other;
                                                                                                                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_other);
                                                                                                                                            if (radioButton != null) {
                                                                                                                                                i = R.id.rb_payments_prod;
                                                                                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_payments_prod);
                                                                                                                                                if (radioButton2 != null) {
                                                                                                                                                    i = R.id.rb_payments_stage;
                                                                                                                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_payments_stage);
                                                                                                                                                    if (radioButton3 != null) {
                                                                                                                                                        i = R.id.rb_prod;
                                                                                                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_prod);
                                                                                                                                                        if (radioButton4 != null) {
                                                                                                                                                            i = R.id.rb_stage;
                                                                                                                                                            RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_stage);
                                                                                                                                                            if (radioButton5 != null) {
                                                                                                                                                                i = R.id.rb_stage2;
                                                                                                                                                                RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_stage2);
                                                                                                                                                                if (radioButton6 != null) {
                                                                                                                                                                    i = R.id.tv_app_version;
                                                                                                                                                                    TextViewWithPoint textViewWithPoint = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_app_version);
                                                                                                                                                                    if (textViewWithPoint != null) {
                                                                                                                                                                        i = R.id.tv_base_url;
                                                                                                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_base_url);
                                                                                                                                                                        if (textView != null) {
                                                                                                                                                                            i = R.id.tv_generate_payment_token;
                                                                                                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_generate_payment_token);
                                                                                                                                                                            if (textView2 != null) {
                                                                                                                                                                                i = R.id.tv_jwt;
                                                                                                                                                                                TextViewWithPoint textViewWithPoint2 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_jwt);
                                                                                                                                                                                if (textViewWithPoint2 != null) {
                                                                                                                                                                                    i = R.id.tv_last_accrued_date;
                                                                                                                                                                                    TextViewWithPoint textViewWithPoint3 = (TextViewWithPoint) ViewBindings.findChildViewById(view, R.id.tv_last_accrued_date);
                                                                                                                                                                                    if (textViewWithPoint3 != null) {
                                                                                                                                                                                        i = R.id.tv_last_accrued_date_attention;
                                                                                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_accrued_date_attention);
                                                                                                                                                                                        if (textView3 != null) {
                                                                                                                                                                                            i = R.id.tv_title;
                                                                                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                                                                                                                                                                            if (textView4 != null) {
                                                                                                                                                                                                return new ActivitySettingsBinding((ConstraintLayout) view, appCompatButton, button, button2, button3, button4, button5, button6, button7, button8, imageButton, button9, button10, button11, button12, button13, button14, button15, button16, imageView, button17, button18, button19, imageButton2, checkBox, editText, appCompatEditText, editText2, editText3, appCompatEditText2, editText4, imageView2, radioGroup, radioGroup2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, textViewWithPoint, textView, textView2, textViewWithPoint2, textViewWithPoint3, textView3, textView4);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
