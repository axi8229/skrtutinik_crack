package sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;

/* loaded from: classes5.dex */
public final class IntercomSettingsFragment_MembersInjector implements MembersInjector<IntercomSettingsFragment> {
    public static void injectFactory(IntercomSettingsFragment intercomSettingsFragment, MultiViewModelFactory multiViewModelFactory) {
        intercomSettingsFragment.factory = multiViewModelFactory;
    }

    public static void injectManageCameraViewModelFactory(IntercomSettingsFragment intercomSettingsFragment, ManageCamerasViewModel.Factory.AssistFactory assistFactory) {
        intercomSettingsFragment.manageCameraViewModelFactory = assistFactory;
    }

    public static void injectPrefManager(IntercomSettingsFragment intercomSettingsFragment, PrefManager prefManager) {
        intercomSettingsFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(IntercomSettingsFragment intercomSettingsFragment, Analytics analytics) {
        intercomSettingsFragment.analytics = analytics;
    }

    public static void injectLocalizationScreen(IntercomSettingsFragment intercomSettingsFragment, LocalizationStorage localizationStorage) {
        intercomSettingsFragment.localizationScreen = localizationStorage;
    }
}
