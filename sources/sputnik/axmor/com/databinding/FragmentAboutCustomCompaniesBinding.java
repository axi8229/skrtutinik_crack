package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentAboutCustomCompaniesBinding implements ViewBinding {
    public final LinearLayout layoutAdditionalContacts;
    public final LinearLayout layoutContacts;
    public final LinearLayout layoutContent;
    public final LinearLayout layoutDays;
    public final LinearLayout layoutHours;
    public final LinearLayout layoutInfo;
    public final LinearLayout layoutSchedule;
    public final FrameLayout loader;
    private final NestedScrollView rootView;
    public final NestedScrollView scrollView;
    public final Toolbar toolbar;
    public final TextView tvCompanyAdditionalPhone;
    public final TextView tvCompanyAdditionalPhoneHeader;
    public final TextView tvCompanyAddress;
    public final TextView tvCompanyHours;
    public final TextView tvCompanyName;
    public final TextView tvCompanyPhone;
    public final TextView tvCompanyPhoneHeader;

    private FragmentAboutCustomCompaniesBinding(NestedScrollView nestedScrollView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, FrameLayout frameLayout, NestedScrollView nestedScrollView2, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = nestedScrollView;
        this.layoutAdditionalContacts = linearLayout;
        this.layoutContacts = linearLayout2;
        this.layoutContent = linearLayout3;
        this.layoutDays = linearLayout4;
        this.layoutHours = linearLayout5;
        this.layoutInfo = linearLayout6;
        this.layoutSchedule = linearLayout7;
        this.loader = frameLayout;
        this.scrollView = nestedScrollView2;
        this.toolbar = toolbar;
        this.tvCompanyAdditionalPhone = textView;
        this.tvCompanyAdditionalPhoneHeader = textView2;
        this.tvCompanyAddress = textView3;
        this.tvCompanyHours = textView4;
        this.tvCompanyName = textView5;
        this.tvCompanyPhone = textView6;
        this.tvCompanyPhoneHeader = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentAboutCustomCompaniesBinding bind(View view) {
        int i = R.id.layout_additional_contacts;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_additional_contacts);
        if (linearLayout != null) {
            i = R.id.layout_contacts;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_contacts);
            if (linearLayout2 != null) {
                i = R.id.layout_content;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_content);
                if (linearLayout3 != null) {
                    i = R.id.layout_days;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_days);
                    if (linearLayout4 != null) {
                        i = R.id.layout_hours;
                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_hours);
                        if (linearLayout5 != null) {
                            i = R.id.layout_info;
                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_info);
                            if (linearLayout6 != null) {
                                i = R.id.layout_schedule;
                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_schedule);
                                if (linearLayout7 != null) {
                                    i = R.id.loader;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loader);
                                    if (frameLayout != null) {
                                        NestedScrollView nestedScrollView = (NestedScrollView) view;
                                        i = R.id.toolbar;
                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                        if (toolbar != null) {
                                            i = R.id.tv_company_additional_phone;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_additional_phone);
                                            if (textView != null) {
                                                i = R.id.tv_company_additional_phone_header;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_additional_phone_header);
                                                if (textView2 != null) {
                                                    i = R.id.tv_company_address;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_address);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_company_hours;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_hours);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_company_name;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_name);
                                                            if (textView5 != null) {
                                                                i = R.id.tv_company_phone;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_phone);
                                                                if (textView6 != null) {
                                                                    i = R.id.tv_company_phone_header;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_phone_header);
                                                                    if (textView7 != null) {
                                                                        return new FragmentAboutCustomCompaniesBinding(nestedScrollView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, frameLayout, nestedScrollView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
