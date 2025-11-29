package com.sputnik.service_payments.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.SettingsMenuView;
import com.sputnik.service_payments.R$id;

/* loaded from: classes3.dex */
public final class FragmentDetailsPaymentBinding implements ViewBinding {
    public final SettingsMenuView btnShareOrSave;
    public final EditText etAccountBill;
    public final EditText etAddress;
    public final EditText etCompany;
    public final EditText etPaymentDate;
    public final EditText etPaymentMethod;
    public final EditText etReason;
    public final EditText etSum;
    public final LinearLayout lAccountBill;
    public final LinearLayout lAddress;
    public final LinearLayout lCommission;
    public final LinearLayout lCompany;
    public final LinearLayout lDatePayment;
    public final LinearLayout lPaymentMethod;
    public final LinearLayout lSum;
    public final ProgressBar pbLoader;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvAccountNumber;
    public final TextView tvAddress;
    public final TextView tvAmount;
    public final TextView tvComission;
    public final TextView tvCompany;
    public final TextView tvPaymentDate;
    public final TextView tvPaymentMethod;
    public final ScrollView viewMain;

    private FragmentDetailsPaymentBinding(ConstraintLayout constraintLayout, SettingsMenuView settingsMenuView, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, ProgressBar progressBar, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ScrollView scrollView) {
        this.rootView = constraintLayout;
        this.btnShareOrSave = settingsMenuView;
        this.etAccountBill = editText;
        this.etAddress = editText2;
        this.etCompany = editText3;
        this.etPaymentDate = editText4;
        this.etPaymentMethod = editText5;
        this.etReason = editText6;
        this.etSum = editText7;
        this.lAccountBill = linearLayout;
        this.lAddress = linearLayout2;
        this.lCommission = linearLayout3;
        this.lCompany = linearLayout4;
        this.lDatePayment = linearLayout5;
        this.lPaymentMethod = linearLayout6;
        this.lSum = linearLayout7;
        this.pbLoader = progressBar;
        this.toolbar = toolbar;
        this.tvAccountNumber = textView;
        this.tvAddress = textView2;
        this.tvAmount = textView3;
        this.tvComission = textView4;
        this.tvCompany = textView5;
        this.tvPaymentDate = textView6;
        this.tvPaymentMethod = textView7;
        this.viewMain = scrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDetailsPaymentBinding bind(View view) {
        int i = R$id.btn_share_or_save;
        SettingsMenuView settingsMenuView = (SettingsMenuView) ViewBindings.findChildViewById(view, i);
        if (settingsMenuView != null) {
            i = R$id.et_account_bill;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R$id.et_address;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R$id.et_company;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R$id.et_payment_date;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            i = R$id.et_payment_method;
                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText5 != null) {
                                i = R$id.et_reason;
                                EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText6 != null) {
                                    i = R$id.et_sum;
                                    EditText editText7 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText7 != null) {
                                        i = R$id.l_account_bill;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            i = R$id.l_address;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = R$id.l_commission;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout3 != null) {
                                                    i = R$id.l_company;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout4 != null) {
                                                        i = R$id.l_date_payment;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout5 != null) {
                                                            i = R$id.l_payment_method;
                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout6 != null) {
                                                                i = R$id.l_sum;
                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout7 != null) {
                                                                    i = R$id.pb_loader;
                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                    if (progressBar != null) {
                                                                        i = R$id.toolbar;
                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                                                                        if (toolbar != null) {
                                                                            i = R$id.tv_account_number;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView != null) {
                                                                                i = R$id.tv_address;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView2 != null) {
                                                                                    i = R$id.tv_amount;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null) {
                                                                                        i = R$id.tv_comission;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView4 != null) {
                                                                                            i = R$id.tv_company;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView5 != null) {
                                                                                                i = R$id.tv_payment_date;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView6 != null) {
                                                                                                    i = R$id.tv_payment_method;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R$id.view_main;
                                                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (scrollView != null) {
                                                                                                            return new FragmentDetailsPaymentBinding((ConstraintLayout) view, settingsMenuView, editText, editText2, editText3, editText4, editText5, editText6, editText7, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, progressBar, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, scrollView);
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
