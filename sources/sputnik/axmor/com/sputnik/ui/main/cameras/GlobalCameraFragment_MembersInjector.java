package sputnik.axmor.com.sputnik.ui.main.cameras;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class GlobalCameraFragment_MembersInjector implements MembersInjector<GlobalCameraFragment> {
    public static void injectFactory(GlobalCameraFragment globalCameraFragment, MultiViewModelFactory multiViewModelFactory) {
        globalCameraFragment.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(GlobalCameraFragment globalCameraFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        globalCameraFragment.cameraViewModelFactory = assistFactory;
    }

    public static void injectLocalizationScreen(GlobalCameraFragment globalCameraFragment, LocalizationStorage localizationStorage) {
        globalCameraFragment.localizationScreen = localizationStorage;
    }

    public static void injectPrefManager(GlobalCameraFragment globalCameraFragment, PrefManager prefManager) {
        globalCameraFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(GlobalCameraFragment globalCameraFragment, Analytics analytics) {
        globalCameraFragment.analytics = analytics;
    }
}
