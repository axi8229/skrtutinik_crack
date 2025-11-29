package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class ActivityPushSettingsBinding implements ViewBinding {
    public final ImageButton btnClose;
    public final Button btnPushAboutApp;
    public final Button btnPushAboutCompany;
    public final Button btnPushAboutCompanyContacts;
    public final Button btnPushBack;
    public final Button btnPushCamerasGallery;
    public final Button btnPushEmergencyCode;
    public final Button btnPushFamily;
    public final Button btnPushFaq;
    public final Button btnPushFaqCategory;
    public final Button btnPushFaqQuestion;
    public final Button btnPushFaqSubcategory;
    public final Button btnPushLicensedKeys;
    public final Button btnPushMarket;
    public final Button btnPushMarketCard;
    public final Button btnPushMarketFeatureAcceleratedLoading;
    public final Button btnPushMarketFeatureAlice;
    public final Button btnPushMarketFeatureArchive;
    public final Button btnPushMarketFeatureBle;
    public final Button btnPushMarketFeatureDigitalKeys;
    public final Button btnPushMarketFeatureExtraCameras;
    public final Button btnPushMarketFeatureHistory;
    public final Button btnPushMarketFeatureLicensedKeys;
    public final Button btnPushMarketFeatureMultiAddress;
    public final Button btnPushMarketItems;
    public final Button btnPushMarketItemsLicensedKeys;
    public final Button btnPushMarketItemsYandexCatalog;
    public final Button btnPushMarketPremium;
    public final Button btnPushMarketServices;
    public final Button btnPushMarketStandard;
    public final Button btnPushMarketStandardPayment;
    public final Button btnPushMarketSubs;
    public final Button btnPushMarketToYooStandard;
    public final Button btnPushNotificationDetails;
    public final Button btnPushNotificationWithDeeplink;
    public final Button btnPushNotifications;
    public final Button btnPushProfile;
    public final Button btnPushServicePayments;
    public final Button btnPushServicesBle;
    public final Button btnPushSupportChat;
    public final Button btnPushVisits;
    public final Button btnPushYandexConnectAlice;
    public final AppCompatEditText etNotificationDeeplink;
    public final AppCompatEditText etNotificationId;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;

    private ActivityPushSettingsBinding(ConstraintLayout constraintLayout, ImageButton imageButton, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Button button13, Button button14, Button button15, Button button16, Button button17, Button button18, Button button19, Button button20, Button button21, Button button22, Button button23, Button button24, Button button25, Button button26, Button button27, Button button28, Button button29, Button button30, Button button31, Button button32, Button button33, Button button34, Button button35, Button button36, Button button37, Button button38, Button button39, Button button40, Button button41, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, TextView textView) {
        this.rootView = constraintLayout;
        this.btnClose = imageButton;
        this.btnPushAboutApp = button;
        this.btnPushAboutCompany = button2;
        this.btnPushAboutCompanyContacts = button3;
        this.btnPushBack = button4;
        this.btnPushCamerasGallery = button5;
        this.btnPushEmergencyCode = button6;
        this.btnPushFamily = button7;
        this.btnPushFaq = button8;
        this.btnPushFaqCategory = button9;
        this.btnPushFaqQuestion = button10;
        this.btnPushFaqSubcategory = button11;
        this.btnPushLicensedKeys = button12;
        this.btnPushMarket = button13;
        this.btnPushMarketCard = button14;
        this.btnPushMarketFeatureAcceleratedLoading = button15;
        this.btnPushMarketFeatureAlice = button16;
        this.btnPushMarketFeatureArchive = button17;
        this.btnPushMarketFeatureBle = button18;
        this.btnPushMarketFeatureDigitalKeys = button19;
        this.btnPushMarketFeatureExtraCameras = button20;
        this.btnPushMarketFeatureHistory = button21;
        this.btnPushMarketFeatureLicensedKeys = button22;
        this.btnPushMarketFeatureMultiAddress = button23;
        this.btnPushMarketItems = button24;
        this.btnPushMarketItemsLicensedKeys = button25;
        this.btnPushMarketItemsYandexCatalog = button26;
        this.btnPushMarketPremium = button27;
        this.btnPushMarketServices = button28;
        this.btnPushMarketStandard = button29;
        this.btnPushMarketStandardPayment = button30;
        this.btnPushMarketSubs = button31;
        this.btnPushMarketToYooStandard = button32;
        this.btnPushNotificationDetails = button33;
        this.btnPushNotificationWithDeeplink = button34;
        this.btnPushNotifications = button35;
        this.btnPushProfile = button36;
        this.btnPushServicePayments = button37;
        this.btnPushServicesBle = button38;
        this.btnPushSupportChat = button39;
        this.btnPushVisits = button40;
        this.btnPushYandexConnectAlice = button41;
        this.etNotificationDeeplink = appCompatEditText;
        this.etNotificationId = appCompatEditText2;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPushSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPushSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_push_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPushSettingsBinding bind(View view) {
        int i = R.id.btn_close;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_close);
        if (imageButton != null) {
            i = R.id.btn_push_about_app;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_about_app);
            if (button != null) {
                i = R.id.btn_push_about_company;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_about_company);
                if (button2 != null) {
                    i = R.id.btn_push_about_company_contacts;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_about_company_contacts);
                    if (button3 != null) {
                        i = R.id.btn_push_back;
                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_back);
                        if (button4 != null) {
                            i = R.id.btn_push_cameras_gallery;
                            Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_cameras_gallery);
                            if (button5 != null) {
                                i = R.id.btn_push_emergency_code;
                                Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_emergency_code);
                                if (button6 != null) {
                                    i = R.id.btn_push_family;
                                    Button button7 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_family);
                                    if (button7 != null) {
                                        i = R.id.btn_push_faq;
                                        Button button8 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_faq);
                                        if (button8 != null) {
                                            i = R.id.btn_push_faq_category;
                                            Button button9 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_faq_category);
                                            if (button9 != null) {
                                                i = R.id.btn_push_faq_question;
                                                Button button10 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_faq_question);
                                                if (button10 != null) {
                                                    i = R.id.btn_push_faq_subcategory;
                                                    Button button11 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_faq_subcategory);
                                                    if (button11 != null) {
                                                        i = R.id.btn_push_licensed_keys;
                                                        Button button12 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_licensed_keys);
                                                        if (button12 != null) {
                                                            i = R.id.btn_push_market;
                                                            Button button13 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market);
                                                            if (button13 != null) {
                                                                i = R.id.btn_push_market_card;
                                                                Button button14 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_card);
                                                                if (button14 != null) {
                                                                    i = R.id.btn_push_market_feature_accelerated_loading;
                                                                    Button button15 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_accelerated_loading);
                                                                    if (button15 != null) {
                                                                        i = R.id.btn_push_market_feature_alice;
                                                                        Button button16 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_alice);
                                                                        if (button16 != null) {
                                                                            i = R.id.btn_push_market_feature_archive;
                                                                            Button button17 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_archive);
                                                                            if (button17 != null) {
                                                                                i = R.id.btn_push_market_feature_ble;
                                                                                Button button18 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_ble);
                                                                                if (button18 != null) {
                                                                                    i = R.id.btn_push_market_feature_digital_keys;
                                                                                    Button button19 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_digital_keys);
                                                                                    if (button19 != null) {
                                                                                        i = R.id.btn_push_market_feature_extra_cameras;
                                                                                        Button button20 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_extra_cameras);
                                                                                        if (button20 != null) {
                                                                                            i = R.id.btn_push_market_feature_history;
                                                                                            Button button21 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_history);
                                                                                            if (button21 != null) {
                                                                                                i = R.id.btn_push_market_feature_licensed_keys;
                                                                                                Button button22 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_licensed_keys);
                                                                                                if (button22 != null) {
                                                                                                    i = R.id.btn_push_market_feature_multi_address;
                                                                                                    Button button23 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_feature_multi_address);
                                                                                                    if (button23 != null) {
                                                                                                        i = R.id.btn_push_market_items;
                                                                                                        Button button24 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_items);
                                                                                                        if (button24 != null) {
                                                                                                            i = R.id.btn_push_market_items_licensed_keys;
                                                                                                            Button button25 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_items_licensed_keys);
                                                                                                            if (button25 != null) {
                                                                                                                i = R.id.btn_push_market_items_yandex_catalog;
                                                                                                                Button button26 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_items_yandex_catalog);
                                                                                                                if (button26 != null) {
                                                                                                                    i = R.id.btn_push_market_premium;
                                                                                                                    Button button27 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_premium);
                                                                                                                    if (button27 != null) {
                                                                                                                        i = R.id.btn_push_market_services;
                                                                                                                        Button button28 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_services);
                                                                                                                        if (button28 != null) {
                                                                                                                            i = R.id.btn_push_market_standard;
                                                                                                                            Button button29 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_standard);
                                                                                                                            if (button29 != null) {
                                                                                                                                i = R.id.btn_push_market_standard_payment;
                                                                                                                                Button button30 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_standard_payment);
                                                                                                                                if (button30 != null) {
                                                                                                                                    i = R.id.btn_push_market_subs;
                                                                                                                                    Button button31 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_subs);
                                                                                                                                    if (button31 != null) {
                                                                                                                                        i = R.id.btn_push_market_to_yoo_standard;
                                                                                                                                        Button button32 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_market_to_yoo_standard);
                                                                                                                                        if (button32 != null) {
                                                                                                                                            i = R.id.btn_push_notification_details;
                                                                                                                                            Button button33 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_notification_details);
                                                                                                                                            if (button33 != null) {
                                                                                                                                                i = R.id.btn_push_notification_with_deeplink;
                                                                                                                                                Button button34 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_notification_with_deeplink);
                                                                                                                                                if (button34 != null) {
                                                                                                                                                    i = R.id.btn_push_notifications;
                                                                                                                                                    Button button35 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_notifications);
                                                                                                                                                    if (button35 != null) {
                                                                                                                                                        i = R.id.btn_push_profile;
                                                                                                                                                        Button button36 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_profile);
                                                                                                                                                        if (button36 != null) {
                                                                                                                                                            i = R.id.btn_push_service_payments;
                                                                                                                                                            Button button37 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_service_payments);
                                                                                                                                                            if (button37 != null) {
                                                                                                                                                                i = R.id.btn_push_services_ble;
                                                                                                                                                                Button button38 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_services_ble);
                                                                                                                                                                if (button38 != null) {
                                                                                                                                                                    i = R.id.btn_push_support_chat;
                                                                                                                                                                    Button button39 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_support_chat);
                                                                                                                                                                    if (button39 != null) {
                                                                                                                                                                        i = R.id.btn_push_visits;
                                                                                                                                                                        Button button40 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_visits);
                                                                                                                                                                        if (button40 != null) {
                                                                                                                                                                            i = R.id.btn_push_yandex_connect_alice;
                                                                                                                                                                            Button button41 = (Button) ViewBindings.findChildViewById(view, R.id.btn_push_yandex_connect_alice);
                                                                                                                                                                            if (button41 != null) {
                                                                                                                                                                                i = R.id.et_notification_deeplink;
                                                                                                                                                                                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.et_notification_deeplink);
                                                                                                                                                                                if (appCompatEditText != null) {
                                                                                                                                                                                    i = R.id.et_notification_id;
                                                                                                                                                                                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.et_notification_id);
                                                                                                                                                                                    if (appCompatEditText2 != null) {
                                                                                                                                                                                        i = R.id.tv_title;
                                                                                                                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                                                                                                                                                                        if (textView != null) {
                                                                                                                                                                                            return new ActivityPushSettingsBinding((ConstraintLayout) view, imageButton, button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25, button26, button27, button28, button29, button30, button31, button32, button33, button34, button35, button36, button37, button38, button39, button40, button41, appCompatEditText, appCompatEditText2, textView);
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
