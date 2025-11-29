package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.ToggleStateButton;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetEmergencyCodeBinding implements ViewBinding {
    public final ToggleStateButton btnReport;
    public final CardView cardLayout;
    public final ImageView ivError;
    private final ScrollView rootView;
    public final ImageView shareButton;
    public final TextView subTitle;
    public final TextView tvCode;
    public final TextView tvCompanyContacts;
    public final TextView tvCompanyContactsInfo;
    public final TextView tvTitle;

    private BottomSheetEmergencyCodeBinding(ScrollView scrollView, ToggleStateButton toggleStateButton, CardView cardView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = scrollView;
        this.btnReport = toggleStateButton;
        this.cardLayout = cardView;
        this.ivError = imageView;
        this.shareButton = imageView2;
        this.subTitle = textView;
        this.tvCode = textView2;
        this.tvCompanyContacts = textView3;
        this.tvCompanyContactsInfo = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetEmergencyCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_emergency_code, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetEmergencyCodeBinding bind(View view) {
        int i = R.id.btn_report;
        ToggleStateButton toggleStateButton = (ToggleStateButton) ViewBindings.findChildViewById(view, R.id.btn_report);
        if (toggleStateButton != null) {
            i = R.id.card_layout;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_layout);
            if (cardView != null) {
                i = R.id.iv_error;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_error);
                if (imageView != null) {
                    i = R.id.share_button;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.share_button);
                    if (imageView2 != null) {
                        i = R.id.sub_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sub_title);
                        if (textView != null) {
                            i = R.id.tv_code;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_code);
                            if (textView2 != null) {
                                i = R.id.tv_company_contacts;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_contacts);
                                if (textView3 != null) {
                                    i = R.id.tv_company_contacts_info;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_contacts_info);
                                    if (textView4 != null) {
                                        i = R.id.tv_title;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                        if (textView5 != null) {
                                            return new BottomSheetEmergencyCodeBinding((ScrollView) view, toggleStateButton, cardView, imageView, imageView2, textView, textView2, textView3, textView4, textView5);
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
