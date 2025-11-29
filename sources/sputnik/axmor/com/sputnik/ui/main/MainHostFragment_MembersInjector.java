package sputnik.axmor.com.sputnik.ui.main;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class MainHostFragment_MembersInjector implements MembersInjector<MainHostFragment> {
    public static void injectFactory(MainHostFragment mainHostFragment, MultiViewModelFactory multiViewModelFactory) {
        mainHostFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(MainHostFragment mainHostFragment, LocalizationStorage localizationStorage) {
        mainHostFragment.localizationScreen = localizationStorage;
    }

    public static void injectCameraViewModelBuilder(MainHostFragment mainHostFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        mainHostFragment.cameraViewModelBuilder = assistFactory;
    }

    public static void injectPrefManager(MainHostFragment mainHostFragment, PrefManager prefManager) {
        mainHostFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(MainHostFragment mainHostFragment, Analytics analytics) {
        mainHostFragment.analytics = analytics;
    }
}
