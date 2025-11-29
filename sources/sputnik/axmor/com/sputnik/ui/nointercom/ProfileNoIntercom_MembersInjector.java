package sputnik.axmor.com.sputnik.ui.nointercom;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ProfileNoIntercom_MembersInjector implements MembersInjector<ProfileNoIntercom> {
    public static void injectLocalizationScreen(ProfileNoIntercom profileNoIntercom, LocalizationStorage localizationStorage) {
        profileNoIntercom.localizationScreen = localizationStorage;
    }

    public static void injectFactory(ProfileNoIntercom profileNoIntercom, MultiViewModelFactory multiViewModelFactory) {
        profileNoIntercom.factory = multiViewModelFactory;
    }

    public static void injectAllCameraFactory(ProfileNoIntercom profileNoIntercom, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        profileNoIntercom.allCameraFactory = assistFactory;
    }

    public static void injectPrefManager(ProfileNoIntercom profileNoIntercom, PrefManager prefManager) {
        profileNoIntercom.prefManager = prefManager;
    }

    public static void injectAnalytics(ProfileNoIntercom profileNoIntercom, Analytics analytics) {
        profileNoIntercom.analytics = analytics;
    }
}
