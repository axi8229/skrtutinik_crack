package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentHelpBinding implements ViewBinding {
    public final ImageView imageView11;
    public final ImageView imageView111;
    public final ImageView ivAnnounce;
    public final ImageView ivCompanyContacts;
    public final LinearLayout lButtons;
    public final ConstraintLayout layoutAnnounce;
    public final ConstraintLayout layoutCompanyContacts;
    public final ConstraintLayout layoutFaq;
    public final LinearLayout layoutIntercomMessagesCount;
    public final ConstraintLayout layoutSupport;
    private final LinearLayout rootView;
    public final TextView settingsAbout;
    public final TextView settingsAboutCompany;
    public final LinearLayout settingsAboutCompanyLayout;
    public final TextView settingsFeedback;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;
    public final TextView tvAnnounce;
    public final TextView tvContactsAction;
    public final TextView tvContactsSubtitle;
    public final TextView tvContactsTitle;
    public final TextView tvExperimental;
    public final TextView tvFaqAction;
    public final TextView tvFaqSubtitle;
    public final TextView tvIntercomMessagesCount;
    public final TextView tvSupportAction;
    public final TextView tvSupportSubtitle;
    public final TextView tvTitleFaq;
    public final TextView tvTitleSupport;
    public final View viewAnnounceBackground;

    private FragmentHelpBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout3, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, LinearLayout linearLayout4, TextView textView3, Toolbar toolbar, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, View view) {
        this.rootView = linearLayout;
        this.imageView11 = imageView;
        this.imageView111 = imageView2;
        this.ivAnnounce = imageView3;
        this.ivCompanyContacts = imageView4;
        this.lButtons = linearLayout2;
        this.layoutAnnounce = constraintLayout;
        this.layoutCompanyContacts = constraintLayout2;
        this.layoutFaq = constraintLayout3;
        this.layoutIntercomMessagesCount = linearLayout3;
        this.layoutSupport = constraintLayout4;
        this.settingsAbout = textView;
        this.settingsAboutCompany = textView2;
        this.settingsAboutCompanyLayout = linearLayout4;
        this.settingsFeedback = textView3;
        this.toolbar = toolbar;
        this.toolbarTitle = textView4;
        this.tvAnnounce = textView5;
        this.tvContactsAction = textView6;
        this.tvContactsSubtitle = textView7;
        this.tvContactsTitle = textView8;
        this.tvExperimental = textView9;
        this.tvFaqAction = textView10;
        this.tvFaqSubtitle = textView11;
        this.tvIntercomMessagesCount = textView12;
        this.tvSupportAction = textView13;
        this.tvSupportSubtitle = textView14;
        this.tvTitleFaq = textView15;
        this.tvTitleSupport = textView16;
        this.viewAnnounceBackground = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHelpBinding bind(View view) {
        int i = R.id.imageView11;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView11);
        if (imageView != null) {
            i = R.id.imageView111;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView111);
            if (imageView2 != null) {
                i = R.id.iv_announce;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_announce);
                if (imageView3 != null) {
                    i = R.id.iv_company_contacts;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_company_contacts);
                    if (imageView4 != null) {
                        i = R.id.l_buttons;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.l_buttons);
                        if (linearLayout != null) {
                            i = R.id.layout_announce;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_announce);
                            if (constraintLayout != null) {
                                i = R.id.layout_company_contacts;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_company_contacts);
                                if (constraintLayout2 != null) {
                                    i = R.id.layout_faq;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_faq);
                                    if (constraintLayout3 != null) {
                                        i = R.id.layout_intercom_messages_count;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_intercom_messages_count);
                                        if (linearLayout2 != null) {
                                            i = R.id.layout_support;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_support);
                                            if (constraintLayout4 != null) {
                                                i = R.id.settings_about;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.settings_about);
                                                if (textView != null) {
                                                    i = R.id.settings_about_company;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.settings_about_company);
                                                    if (textView2 != null) {
                                                        i = R.id.settings_about_company_layout;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.settings_about_company_layout);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.settings_feedback;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.settings_feedback);
                                                            if (textView3 != null) {
                                                                i = R.id.toolbar;
                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                if (toolbar != null) {
                                                                    i = R.id.toolbar_title;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.toolbar_title);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_announce;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_announce);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tv_contacts_action;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_contacts_action);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tv_contacts_subtitle;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_contacts_subtitle);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.tv_contacts_title;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_contacts_title);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.tv_experimental;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_experimental);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.tv_faq_action;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_faq_action);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.tv_faq_subtitle;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_faq_subtitle);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.tv_intercom_messages_count;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_intercom_messages_count);
                                                                                                    if (textView12 != null) {
                                                                                                        i = R.id.tv_support_action;
                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_support_action);
                                                                                                        if (textView13 != null) {
                                                                                                            i = R.id.tv_support_subtitle;
                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_support_subtitle);
                                                                                                            if (textView14 != null) {
                                                                                                                i = R.id.tv_title_faq;
                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_faq);
                                                                                                                if (textView15 != null) {
                                                                                                                    i = R.id.tv_title_support;
                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_support);
                                                                                                                    if (textView16 != null) {
                                                                                                                        i = R.id.view_announce_background;
                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view_announce_background);
                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                            return new FragmentHelpBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, linearLayout, constraintLayout, constraintLayout2, constraintLayout3, linearLayout2, constraintLayout4, textView, textView2, linearLayout3, textView3, toolbar, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, viewFindChildViewById);
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
