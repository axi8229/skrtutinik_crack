package sputnik.axmor.com.sputnik.ui.main.cameras;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class CameraStreamFragment_MembersInjector implements MembersInjector<CameraStreamFragment> {
    public static void injectLocalizationScreen(CameraStreamFragment cameraStreamFragment, LocalizationStorage localizationStorage) {
        cameraStreamFragment.localizationScreen = localizationStorage;
    }

    public static void injectCamerasFactory(CameraStreamFragment cameraStreamFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        cameraStreamFragment.camerasFactory = assistFactory;
    }

    public static void injectAnalytics(CameraStreamFragment cameraStreamFragment, Analytics analytics) {
        cameraStreamFragment.analytics = analytics;
    }

    public static void injectPrefManager(CameraStreamFragment cameraStreamFragment, PrefManager prefManager) {
        cameraStreamFragment.prefManager = prefManager;
    }

    public static void injectFactory(CameraStreamFragment cameraStreamFragment, MultiViewModelFactory multiViewModelFactory) {
        cameraStreamFragment.factory = multiViewModelFactory;
    }
}
