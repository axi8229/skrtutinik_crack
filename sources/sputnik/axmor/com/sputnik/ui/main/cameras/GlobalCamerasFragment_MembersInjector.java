package sputnik.axmor.com.sputnik.ui.main.cameras;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class GlobalCamerasFragment_MembersInjector implements MembersInjector<GlobalCamerasFragment> {
    public static void injectFactory(GlobalCamerasFragment globalCamerasFragment, MultiViewModelFactory multiViewModelFactory) {
        globalCamerasFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(GlobalCamerasFragment globalCamerasFragment, LocalizationStorage localizationStorage) {
        globalCamerasFragment.localizationScreen = localizationStorage;
    }

    public static void injectCameraViewModelFactory(GlobalCamerasFragment globalCamerasFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        globalCamerasFragment.cameraViewModelFactory = assistFactory;
    }

    public static void injectPrefManager(GlobalCamerasFragment globalCamerasFragment, PrefManager prefManager) {
        globalCamerasFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(GlobalCamerasFragment globalCamerasFragment, Analytics analytics) {
        globalCamerasFragment.analytics = analytics;
    }
}
