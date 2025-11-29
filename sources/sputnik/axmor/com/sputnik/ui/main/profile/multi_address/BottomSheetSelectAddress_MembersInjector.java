package sputnik.axmor.com.sputnik.ui.main.profile.multi_address;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetSelectAddress_MembersInjector implements MembersInjector<BottomSheetSelectAddress> {
    public static void injectLocalizationStorage(BottomSheetSelectAddress bottomSheetSelectAddress, LocalizationStorage localizationStorage) {
        bottomSheetSelectAddress.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetSelectAddress bottomSheetSelectAddress, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetSelectAddress.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(BottomSheetSelectAddress bottomSheetSelectAddress, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        bottomSheetSelectAddress.cameraViewModelFactory = assistFactory;
    }

    public static void injectAnalytics(BottomSheetSelectAddress bottomSheetSelectAddress, Analytics analytics) {
        bottomSheetSelectAddress.analytics = analytics;
    }
}
