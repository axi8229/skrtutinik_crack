package sputnik.axmor.com;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.List;
import sputnik.axmor.com.databinding.CallHistoryFooterBindingImpl;
import sputnik.axmor.com.databinding.CallHistoryPromoBindingImpl;
import sputnik.axmor.com.databinding.CancelServiceItemBindingImpl;
import sputnik.axmor.com.databinding.FragmentBleServiceBindingImpl;
import sputnik.axmor.com.databinding.FragmentCancelAutoPaymentBindingImpl;
import sputnik.axmor.com.databinding.FragmentCommentSurveyBindingImpl;
import sputnik.axmor.com.databinding.FragmentDetailsFamilyBindingImpl;
import sputnik.axmor.com.databinding.FragmentFlussonicBindingImpl;
import sputnik.axmor.com.databinding.FragmentProfileBindingImpl;
import sputnik.axmor.com.databinding.FragmentProfileNoIntercomBindingImpl;
import sputnik.axmor.com.databinding.FragmentServicesArchiveActiveBindingImpl;
import sputnik.axmor.com.databinding.FragmentServicesAvailableItemBindingImpl;
import sputnik.axmor.com.databinding.FragmentServicesFrBindingImpl;
import sputnik.axmor.com.databinding.FragmentSettingsFamilyBindingImpl;
import sputnik.axmor.com.databinding.GlobalRequestCallCodeFragmentBindingImpl;
import sputnik.axmor.com.databinding.InsuranceServiceItemBindingImpl;
import sputnik.axmor.com.databinding.ItemAddressBindingImpl;
import sputnik.axmor.com.databinding.ItemCameraPreviewBindingImpl;
import sputnik.axmor.com.databinding.ItemFamilyInviteListBindingImpl;
import sputnik.axmor.com.databinding.ItemFamilyListBindingImpl;
import sputnik.axmor.com.databinding.ItemFaqBindingImpl;
import sputnik.axmor.com.databinding.ItemFaqCategoryBindingImpl;
import sputnik.axmor.com.databinding.ItemGorservCategoryBindingImpl;
import sputnik.axmor.com.databinding.ItemKeyBindingImpl;
import sputnik.axmor.com.databinding.ItemMarketElementBindingImpl;
import sputnik.axmor.com.databinding.ItemMarketKeyBindingImpl;
import sputnik.axmor.com.databinding.ItemNotificationBindingImpl;
import sputnik.axmor.com.databinding.ItemPaymentHistoryBindingImpl;
import sputnik.axmor.com.databinding.ItemPollReasonBindingImpl;
import sputnik.axmor.com.databinding.NewCallActivityBindingImpl;
import sputnik.axmor.com.databinding.NewSubscriptionItemBindingImpl;
import sputnik.axmor.com.databinding.RecyclerViewCameraItemBindingImpl;
import sputnik.axmor.com.databinding.RecyclerViewTitleCameraItemBindingImpl;
import sputnik.axmor.com.databinding.ServiceItemBindingImpl;
import sputnik.axmor.com.databinding.SubItemFeatureBindingImpl;
import sputnik.axmor.com.databinding.SubscriptionServiceItemBindingImpl;
import sputnik.axmor.com.databinding.ViewOpenDoorButtonBindingImpl;
import sputnik.axmor.com.databinding.ViewPhoneEditTextBindingImpl;
import sputnik.axmor.com.databinding.ViewSecondaryOpenDoorButtonBindingImpl;
import sputnik.axmor.com.databinding.VisitErrorItemBindingImpl;
import sputnik.axmor.com.databinding.VisitItemBindingImpl;
import sputnik.axmor.com.databinding.VisitLoadingItemBindingImpl;
import sputnik.axmor.com.databinding.VisitsDateItemBindingImpl;

/* loaded from: classes5.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(43);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.call_history_footer, 1);
        sparseIntArray.put(R.layout.call_history_promo, 2);
        sparseIntArray.put(R.layout.cancel_service_item, 3);
        sparseIntArray.put(R.layout.fragment_ble_service, 4);
        sparseIntArray.put(R.layout.fragment_cancel_auto_payment, 5);
        sparseIntArray.put(R.layout.fragment_comment_survey, 6);
        sparseIntArray.put(R.layout.fragment_details_family, 7);
        sparseIntArray.put(R.layout.fragment_flussonic, 8);
        sparseIntArray.put(R.layout.fragment_profile, 9);
        sparseIntArray.put(R.layout.fragment_profile_no_intercom, 10);
        sparseIntArray.put(R.layout.fragment_services_archive_active, 11);
        sparseIntArray.put(R.layout.fragment_services_available_item, 12);
        sparseIntArray.put(R.layout.fragment_services_fr, 13);
        sparseIntArray.put(R.layout.fragment_settings_family, 14);
        sparseIntArray.put(R.layout.global_request_call_code_fragment, 15);
        sparseIntArray.put(R.layout.insurance_service_item, 16);
        sparseIntArray.put(R.layout.item_address, 17);
        sparseIntArray.put(R.layout.item_camera_preview, 18);
        sparseIntArray.put(R.layout.item_family_invite_list, 19);
        sparseIntArray.put(R.layout.item_family_list, 20);
        sparseIntArray.put(R.layout.item_faq, 21);
        sparseIntArray.put(R.layout.item_faq_category, 22);
        sparseIntArray.put(R.layout.item_gorserv_category, 23);
        sparseIntArray.put(R.layout.item_key, 24);
        sparseIntArray.put(R.layout.item_market_element, 25);
        sparseIntArray.put(R.layout.item_market_key, 26);
        sparseIntArray.put(R.layout.item_notification, 27);
        sparseIntArray.put(R.layout.item_payment_history, 28);
        sparseIntArray.put(R.layout.item_poll_reason, 29);
        sparseIntArray.put(R.layout.new_call_activity, 30);
        sparseIntArray.put(R.layout.new_subscription_item, 31);
        sparseIntArray.put(R.layout.recycler_view_camera_item, 32);
        sparseIntArray.put(R.layout.recycler_view_title_camera_item, 33);
        sparseIntArray.put(R.layout.service_item, 34);
        sparseIntArray.put(R.layout.sub_item_feature, 35);
        sparseIntArray.put(R.layout.subscription_service_item, 36);
        sparseIntArray.put(R.layout.view_open_door_button, 37);
        sparseIntArray.put(R.layout.view_phone_edit_text, 38);
        sparseIntArray.put(R.layout.view_secondary_open_door_button, 39);
        sparseIntArray.put(R.layout.visit_error_item, 40);
        sparseIntArray.put(R.layout.visit_item, 41);
        sparseIntArray.put(R.layout.visit_loading_item, 42);
        sparseIntArray.put(R.layout.visits_date_item, 43);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/call_history_footer_0".equals(tag)) {
                    return new CallHistoryFooterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for call_history_footer is invalid. Received: " + tag);
            case 2:
                if ("layout/call_history_promo_0".equals(tag)) {
                    return new CallHistoryPromoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for call_history_promo is invalid. Received: " + tag);
            case 3:
                if ("layout/cancel_service_item_0".equals(tag)) {
                    return new CancelServiceItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for cancel_service_item is invalid. Received: " + tag);
            case 4:
                if ("layout/fragment_ble_service_0".equals(tag)) {
                    return new FragmentBleServiceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_ble_service is invalid. Received: " + tag);
            case 5:
                if ("layout/fragment_cancel_auto_payment_0".equals(tag)) {
                    return new FragmentCancelAutoPaymentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_cancel_auto_payment is invalid. Received: " + tag);
            case 6:
                if ("layout/fragment_comment_survey_0".equals(tag)) {
                    return new FragmentCommentSurveyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_comment_survey is invalid. Received: " + tag);
            case 7:
                if ("layout/fragment_details_family_0".equals(tag)) {
                    return new FragmentDetailsFamilyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_details_family is invalid. Received: " + tag);
            case 8:
                if ("layout/fragment_flussonic_0".equals(tag)) {
                    return new FragmentFlussonicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_flussonic is invalid. Received: " + tag);
            case 9:
                if ("layout/fragment_profile_0".equals(tag)) {
                    return new FragmentProfileBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
            case 10:
                if ("layout/fragment_profile_no_intercom_0".equals(tag)) {
                    return new FragmentProfileNoIntercomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_profile_no_intercom is invalid. Received: " + tag);
            case 11:
                if ("layout/fragment_services_archive_active_0".equals(tag)) {
                    return new FragmentServicesArchiveActiveBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_services_archive_active is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_services_available_item_0".equals(tag)) {
                    return new FragmentServicesAvailableItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_services_available_item is invalid. Received: " + tag);
            case 13:
                if ("layout/fragment_services_fr_0".equals(tag)) {
                    return new FragmentServicesFrBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_services_fr is invalid. Received: " + tag);
            case 14:
                if ("layout/fragment_settings_family_0".equals(tag)) {
                    return new FragmentSettingsFamilyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_settings_family is invalid. Received: " + tag);
            case 15:
                if ("layout/global_request_call_code_fragment_0".equals(tag)) {
                    return new GlobalRequestCallCodeFragmentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for global_request_call_code_fragment is invalid. Received: " + tag);
            case 16:
                if ("layout/insurance_service_item_0".equals(tag)) {
                    return new InsuranceServiceItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for insurance_service_item is invalid. Received: " + tag);
            case 17:
                if ("layout/item_address_0".equals(tag)) {
                    return new ItemAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_address is invalid. Received: " + tag);
            case 18:
                if ("layout/item_camera_preview_0".equals(tag)) {
                    return new ItemCameraPreviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_camera_preview is invalid. Received: " + tag);
            case 19:
                if ("layout/item_family_invite_list_0".equals(tag)) {
                    return new ItemFamilyInviteListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_family_invite_list is invalid. Received: " + tag);
            case 20:
                if ("layout/item_family_list_0".equals(tag)) {
                    return new ItemFamilyListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_family_list is invalid. Received: " + tag);
            case 21:
                if ("layout/item_faq_0".equals(tag)) {
                    return new ItemFaqBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_faq is invalid. Received: " + tag);
            case 22:
                if ("layout/item_faq_category_0".equals(tag)) {
                    return new ItemFaqCategoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_faq_category is invalid. Received: " + tag);
            case 23:
                if ("layout/item_gorserv_category_0".equals(tag)) {
                    return new ItemGorservCategoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_gorserv_category is invalid. Received: " + tag);
            case 24:
                if ("layout/item_key_0".equals(tag)) {
                    return new ItemKeyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_key is invalid. Received: " + tag);
            case 25:
                if ("layout/item_market_element_0".equals(tag)) {
                    return new ItemMarketElementBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_market_element is invalid. Received: " + tag);
            case 26:
                if ("layout/item_market_key_0".equals(tag)) {
                    return new ItemMarketKeyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_market_key is invalid. Received: " + tag);
            case 27:
                if ("layout/item_notification_0".equals(tag)) {
                    return new ItemNotificationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_notification is invalid. Received: " + tag);
            case 28:
                if ("layout/item_payment_history_0".equals(tag)) {
                    return new ItemPaymentHistoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_payment_history is invalid. Received: " + tag);
            case 29:
                if ("layout/item_poll_reason_0".equals(tag)) {
                    return new ItemPollReasonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_poll_reason is invalid. Received: " + tag);
            case 30:
                if ("layout/new_call_activity_0".equals(tag)) {
                    return new NewCallActivityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for new_call_activity is invalid. Received: " + tag);
            case 31:
                if ("layout/new_subscription_item_0".equals(tag)) {
                    return new NewSubscriptionItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for new_subscription_item is invalid. Received: " + tag);
            case 32:
                if ("layout/recycler_view_camera_item_0".equals(tag)) {
                    return new RecyclerViewCameraItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for recycler_view_camera_item is invalid. Received: " + tag);
            case 33:
                if ("layout/recycler_view_title_camera_item_0".equals(tag)) {
                    return new RecyclerViewTitleCameraItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for recycler_view_title_camera_item is invalid. Received: " + tag);
            case 34:
                if ("layout/service_item_0".equals(tag)) {
                    return new ServiceItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for service_item is invalid. Received: " + tag);
            case 35:
                if ("layout/sub_item_feature_0".equals(tag)) {
                    return new SubItemFeatureBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for sub_item_feature is invalid. Received: " + tag);
            case 36:
                if ("layout/subscription_service_item_0".equals(tag)) {
                    return new SubscriptionServiceItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for subscription_service_item is invalid. Received: " + tag);
            case 37:
                if ("layout/view_open_door_button_0".equals(tag)) {
                    return new ViewOpenDoorButtonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_open_door_button is invalid. Received: " + tag);
            case 38:
                if ("layout/view_phone_edit_text_0".equals(tag)) {
                    return new ViewPhoneEditTextBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_phone_edit_text is invalid. Received: " + tag);
            case 39:
                if ("layout/view_secondary_open_door_button_0".equals(tag)) {
                    return new ViewSecondaryOpenDoorButtonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_secondary_open_door_button is invalid. Received: " + tag);
            case 40:
                if ("layout/visit_error_item_0".equals(tag)) {
                    return new VisitErrorItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for visit_error_item is invalid. Received: " + tag);
            case 41:
                if ("layout/visit_item_0".equals(tag)) {
                    return new VisitItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for visit_item is invalid. Received: " + tag);
            case 42:
                if ("layout/visit_loading_item_0".equals(tag)) {
                    return new VisitLoadingItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for visit_loading_item is invalid. Received: " + tag);
            case 43:
                if ("layout/visits_date_item_0".equals(tag)) {
                    return new VisitsDateItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for visits_date_item is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.sputnik.common.DataBinderMapperImpl());
        arrayList.add(new com.sputnik.oboarding.DataBinderMapperImpl());
        arrayList.add(new com.sputnik.service_payments.DataBinderMapperImpl());
        arrayList.add(new com.sputnik.subscriptions.DataBinderMapperImpl());
        return arrayList;
    }
}
