package sputnik.axmor.com.sputnik.ui.splash;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class CustomSplashFragment_MembersInjector implements MembersInjector<CustomSplashFragment> {
    public static void injectLocalizationScreen(CustomSplashFragment customSplashFragment, LocalizationStorage localizationStorage) {
        customSplashFragment.localizationScreen = localizationStorage;
    }

    public static void injectCameraViewModelFactory(CustomSplashFragment customSplashFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        customSplashFragment.cameraViewModelFactory = assistFactory;
    }

    public static void injectFactory(CustomSplashFragment customSplashFragment, MultiViewModelFactory multiViewModelFactory) {
        customSplashFragment.factory = multiViewModelFactory;
    }

    public static void injectPrefManager(CustomSplashFragment customSplashFragment, PrefManager prefManager) {
        customSplashFragment.prefManager = prefManager;
    }

    public static void injectConfig(CustomSplashFragment customSplashFragment, IConfig iConfig) {
        customSplashFragment.config = iConfig;
    }

    public static void injectAnalytics(CustomSplashFragment customSplashFragment, Analytics analytics) {
        customSplashFragment.analytics = analytics;
    }
}
