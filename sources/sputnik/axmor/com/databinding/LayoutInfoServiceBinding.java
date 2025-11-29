package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class LayoutInfoServiceBinding implements ViewBinding {
    public final TextView companyName;
    public final LinearLayout companyNameLayout;
    public final TextView companyPhone;
    public final LinearLayout companyPhoneLayout;
    public final TextView companySite;
    public final LinearLayout companySiteLayout;
    public final LinearLayout dateLayout;
    public final TextView dateService;
    public final LinearLayout lCompanyTitles;
    public final ConstraintLayout lInfoPrice;
    private final ConstraintLayout rootView;
    public final TextView tvCompanyName;
    public final TextView tvCompanyPhone;
    public final TextView tvCompanySite;
    public final TextView tvDateService;
    public final TextView tvHeaderServiceInfo;
    public final TextView tvTypeSub;
    public final LinearLayout typeLayout;
    public final TextView typeSub;

    private LayoutInfoServiceBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView4, LinearLayout linearLayout5, ConstraintLayout constraintLayout2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, LinearLayout linearLayout6, TextView textView11) {
        this.rootView = constraintLayout;
        this.companyName = textView;
        this.companyNameLayout = linearLayout;
        this.companyPhone = textView2;
        this.companyPhoneLayout = linearLayout2;
        this.companySite = textView3;
        this.companySiteLayout = linearLayout3;
        this.dateLayout = linearLayout4;
        this.dateService = textView4;
        this.lCompanyTitles = linearLayout5;
        this.lInfoPrice = constraintLayout2;
        this.tvCompanyName = textView5;
        this.tvCompanyPhone = textView6;
        this.tvCompanySite = textView7;
        this.tvDateService = textView8;
        this.tvHeaderServiceInfo = textView9;
        this.tvTypeSub = textView10;
        this.typeLayout = linearLayout6;
        this.typeSub = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutInfoServiceBinding bind(View view) {
        int i = R.id.companyName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.companyName);
        if (textView != null) {
            i = R.id.company_name_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.company_name_layout);
            if (linearLayout != null) {
                i = R.id.companyPhone;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.companyPhone);
                if (textView2 != null) {
                    i = R.id.company_phone_layout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.company_phone_layout);
                    if (linearLayout2 != null) {
                        i = R.id.companySite;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.companySite);
                        if (textView3 != null) {
                            i = R.id.company_site_layout;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.company_site_layout);
                            if (linearLayout3 != null) {
                                i = R.id.date_layout;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.date_layout);
                                if (linearLayout4 != null) {
                                    i = R.id.dateService;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.dateService);
                                    if (textView4 != null) {
                                        i = R.id.l_company_titles;
                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.l_company_titles);
                                        if (linearLayout5 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i = R.id.tvCompanyName;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tvCompanyName);
                                            if (textView5 != null) {
                                                i = R.id.tvCompanyPhone;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tvCompanyPhone);
                                                if (textView6 != null) {
                                                    i = R.id.tvCompanySite;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tvCompanySite);
                                                    if (textView7 != null) {
                                                        i = R.id.tvDateService;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tvDateService);
                                                        if (textView8 != null) {
                                                            i = R.id.tvHeaderServiceInfo;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.tvHeaderServiceInfo);
                                                            if (textView9 != null) {
                                                                i = R.id.tvTypeSub;
                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.tvTypeSub);
                                                                if (textView10 != null) {
                                                                    i = R.id.type_layout;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.type_layout);
                                                                    if (linearLayout6 != null) {
                                                                        i = R.id.typeSub;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.typeSub);
                                                                        if (textView11 != null) {
                                                                            return new LayoutInfoServiceBinding(constraintLayout, textView, linearLayout, textView2, linearLayout2, textView3, linearLayout3, linearLayout4, textView4, linearLayout5, constraintLayout, textView5, textView6, textView7, textView8, textView9, textView10, linearLayout6, textView11);
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
