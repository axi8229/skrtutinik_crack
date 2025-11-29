package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.ui.view.SettingsMenuView;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSettingsProfileBinding implements ViewBinding {
    public final TextView badgeSubscription;
    public final ImageView btnSelectAccount;
    public final TextView btnWantMore;
    public final ImageButton buttonExit;
    public final ConstraintLayout buttonNotifications;
    public final ConstraintLayout container;
    public final ImageButton imageButton;
    public final ImageView imageView8;
    public final ImageView imageView9;
    public final ImageView ivChooseAddress;
    public final ImageView ivIcon;
    public final ConstraintLayout lAddress;
    public final ConstraintLayout layoutAboutOurHome;
    public final ConstraintLayout layoutHistory;
    public final ConstraintLayout layoutPaymentItem;
    public final LinearLayout loader;
    public final TextView originImage;
    public final SettingsMenuView paymentItem;
    public final NestedScrollView profileScroll;
    private final ConstraintLayout rootView;
    public final RecyclerView rvServices;
    public final TextView servicesLabel;
    public final Group servicesLayout;
    public final TextView settingsAddress;
    public final SettingsMenuView settingsCameras;
    public final SettingsMenuView settingsCard;
    public final SettingsMenuView settingsDomofon;
    public final SettingsMenuView settingsFamily;
    public final TextView settingsFio;
    public final SettingsMenuView settingsKeys;
    public final TextView settingsLabel;
    public final SettingsMenuView settingsLanguage;
    public final SettingsMenuView settingsPermissions;
    public final ImageView settingsPhoto;
    public final NewSubscriptionItemBinding subsLayout;
    public final ConstraintLayout toolbar;
    public final TextView toolbarTitle;
    public final TextView tvCurrentAddress;
    public final TextView tvOurHomeDescription;
    public final TextView tvOurHomeTitle;
    public final TextView tvVisitsTitle;
    public final View viewOnboardingNotifications;

    private FragmentSettingsProfileBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, ImageButton imageButton, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageButton imageButton2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, LinearLayout linearLayout, TextView textView3, SettingsMenuView settingsMenuView, NestedScrollView nestedScrollView, RecyclerView recyclerView, TextView textView4, Group group, TextView textView5, SettingsMenuView settingsMenuView2, SettingsMenuView settingsMenuView3, SettingsMenuView settingsMenuView4, SettingsMenuView settingsMenuView5, TextView textView6, SettingsMenuView settingsMenuView6, TextView textView7, SettingsMenuView settingsMenuView7, SettingsMenuView settingsMenuView8, ImageView imageView6, NewSubscriptionItemBinding newSubscriptionItemBinding, ConstraintLayout constraintLayout8, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, View view) {
        this.rootView = constraintLayout;
        this.badgeSubscription = textView;
        this.btnSelectAccount = imageView;
        this.btnWantMore = textView2;
        this.buttonExit = imageButton;
        this.buttonNotifications = constraintLayout2;
        this.container = constraintLayout3;
        this.imageButton = imageButton2;
        this.imageView8 = imageView2;
        this.imageView9 = imageView3;
        this.ivChooseAddress = imageView4;
        this.ivIcon = imageView5;
        this.lAddress = constraintLayout4;
        this.layoutAboutOurHome = constraintLayout5;
        this.layoutHistory = constraintLayout6;
        this.layoutPaymentItem = constraintLayout7;
        this.loader = linearLayout;
        this.originImage = textView3;
        this.paymentItem = settingsMenuView;
        this.profileScroll = nestedScrollView;
        this.rvServices = recyclerView;
        this.servicesLabel = textView4;
        this.servicesLayout = group;
        this.settingsAddress = textView5;
        this.settingsCameras = settingsMenuView2;
        this.settingsCard = settingsMenuView3;
        this.settingsDomofon = settingsMenuView4;
        this.settingsFamily = settingsMenuView5;
        this.settingsFio = textView6;
        this.settingsKeys = settingsMenuView6;
        this.settingsLabel = textView7;
        this.settingsLanguage = settingsMenuView7;
        this.settingsPermissions = settingsMenuView8;
        this.settingsPhoto = imageView6;
        this.subsLayout = newSubscriptionItemBinding;
        this.toolbar = constraintLayout8;
        this.toolbarTitle = textView8;
        this.tvCurrentAddress = textView9;
        this.tvOurHomeDescription = textView10;
        this.tvOurHomeTitle = textView11;
        this.tvVisitsTitle = textView12;
        this.viewOnboardingNotifications = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingsProfileBinding bind(View view) {
        int i = R.id.badge_subscription;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.badge_subscription);
        if (textView != null) {
            i = R.id.btn_select_account;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_select_account);
            if (imageView != null) {
                i = R.id.btn_want_more;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.btn_want_more);
                if (textView2 != null) {
                    i = R.id.button_exit;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.button_exit);
                    if (imageButton != null) {
                        i = R.id.button_notifications;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.button_notifications);
                        if (constraintLayout != null) {
                            i = R.id.container;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.container);
                            if (constraintLayout2 != null) {
                                i = R.id.imageButton;
                                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.imageButton);
                                if (imageButton2 != null) {
                                    i = R.id.imageView8;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView8);
                                    if (imageView2 != null) {
                                        i = R.id.imageView9;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView9);
                                        if (imageView3 != null) {
                                            i = R.id.iv_choose_address;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_choose_address);
                                            if (imageView4 != null) {
                                                i = R.id.iv_icon;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon);
                                                if (imageView5 != null) {
                                                    i = R.id.l_address;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.l_address);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.layout_about_our_home;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_about_our_home);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.layout_history;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_history);
                                                            if (constraintLayout5 != null) {
                                                                i = R.id.layout_payment_item;
                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_payment_item);
                                                                if (constraintLayout6 != null) {
                                                                    i = R.id.loader;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.loader);
                                                                    if (linearLayout != null) {
                                                                        i = R.id.origin_image;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.origin_image);
                                                                        if (textView3 != null) {
                                                                            i = R.id.payment_item;
                                                                            SettingsMenuView settingsMenuView = (SettingsMenuView) ViewBindings.findChildViewById(view, R.id.payment_item);
                                                                            if (settingsMenuView != null) {
                                                                                i = R.id.profile_scroll;
                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.profile_scroll);
                                                                                if (nestedScrollView != null) {
                                                                                    i = R.id.rv_services;
                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_services);
                                                                                    if (recyclerView != null) {
                                                                                        i = R.id.services_label;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.services_label);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.services_layout;
                                                                                            Group group = (Group) ViewBindings.findChildViewById(view, R.id.services_layout);
                                                                                            if (group != null) {
                                                                                                i = R.id.settings_address;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.settings_address);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.settings_cameras;
                                                                                                    SettingsMenuView settingsMenuView2 = (SettingsMenuView) ViewBindings.findChildViewById(view, R.id.settings_cameras);
                                                                                                    if (settingsMenuView2 != null) {
                                                                                                        i = R.id.settings_card;
                                                                                                        SettingsMenuView settingsMenuView3 = (SettingsMenuView) ViewBindings.findChildViewById(view, R.id.settings_card);
                                                                                                        if (settingsMenuView3 != null) {
                                                                                                            i = R.id.settings_domofon;
                                                                                                            SettingsMenuView settingsMenuView4 = (SettingsMenuView) ViewBindings.findChildViewById(view, R.id.settings_domofon);
                                                                                                            if (settingsMenuView4 != null) {
                                                                                                                i = R.id.settings_family;
                                                                                                                SettingsMenuView settingsMenuView5 = (SettingsMenuView) ViewBindings.findChildViewById(view, R.id.settings_family);
                                                                                                                if (settingsMenuView5 != null) {
                                                                                                                    i = R.id.settings_fio;
                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.settings_fio);
                                                                                                                    if (textView6 != null) {
                                                                                                                        i = R.id.settings_keys;
                                                                                                                        SettingsMenuView settingsMenuView6 = (SettingsMenuView) ViewBindings.findChildViewById(view, R.id.settings_keys);
                                                                                                                        if (settingsMenuView6 != null) {
                                                                                                                            i = R.id.settings_label;
                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.settings_label);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i = R.id.settings_language;
                                                                                                                                SettingsMenuView settingsMenuView7 = (SettingsMenuView) ViewBindings.findChildViewById(view, R.id.settings_language);
                                                                                                                                if (settingsMenuView7 != null) {
                                                                                                                                    i = R.id.settings_permissions;
                                                                                                                                    SettingsMenuView settingsMenuView8 = (SettingsMenuView) ViewBindings.findChildViewById(view, R.id.settings_permissions);
                                                                                                                                    if (settingsMenuView8 != null) {
                                                                                                                                        i = R.id.settings_photo;
                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.settings_photo);
                                                                                                                                        if (imageView6 != null) {
                                                                                                                                            i = R.id.subs_layout;
                                                                                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.subs_layout);
                                                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                                                NewSubscriptionItemBinding newSubscriptionItemBindingBind = NewSubscriptionItemBinding.bind(viewFindChildViewById);
                                                                                                                                                i = R.id.toolbar;
                                                                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                                                                                if (constraintLayout7 != null) {
                                                                                                                                                    i = R.id.toolbar_title;
                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.toolbar_title);
                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                        i = R.id.tv_current_address;
                                                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_current_address);
                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                            i = R.id.tv_our_home_description;
                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_our_home_description);
                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                i = R.id.tv_our_home_title;
                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_our_home_title);
                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                    i = R.id.tv_visits_title;
                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_visits_title);
                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                        i = R.id.view_onboarding_notifications;
                                                                                                                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.view_onboarding_notifications);
                                                                                                                                                                        if (viewFindChildViewById2 != null) {
                                                                                                                                                                            return new FragmentSettingsProfileBinding((ConstraintLayout) view, textView, imageView, textView2, imageButton, constraintLayout, constraintLayout2, imageButton2, imageView2, imageView3, imageView4, imageView5, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, linearLayout, textView3, settingsMenuView, nestedScrollView, recyclerView, textView4, group, textView5, settingsMenuView2, settingsMenuView3, settingsMenuView4, settingsMenuView5, textView6, settingsMenuView6, textView7, settingsMenuView7, settingsMenuView8, imageView6, newSubscriptionItemBindingBind, constraintLayout7, textView8, textView9, textView10, textView11, textView12, viewFindChildViewById2);
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
