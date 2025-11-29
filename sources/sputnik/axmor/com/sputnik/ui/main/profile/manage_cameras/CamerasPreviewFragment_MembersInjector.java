package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;

/* loaded from: classes5.dex */
public final class CamerasPreviewFragment_MembersInjector implements MembersInjector<CamerasPreviewFragment> {
    public static void injectLocalizationScreen(CamerasPreviewFragment camerasPreviewFragment, LocalizationStorage localizationStorage) {
        camerasPreviewFragment.localizationScreen = localizationStorage;
    }

    public static void injectManageCameraViewModelFactory(CamerasPreviewFragment camerasPreviewFragment, ManageCamerasViewModel.Factory.AssistFactory assistFactory) {
        camerasPreviewFragment.manageCameraViewModelFactory = assistFactory;
    }

    public static void injectAnalytics(CamerasPreviewFragment camerasPreviewFragment, Analytics analytics) {
        camerasPreviewFragment.analytics = analytics;
    }

    public static void injectFactory(CamerasPreviewFragment camerasPreviewFragment, MultiViewModelFactory multiViewModelFactory) {
        camerasPreviewFragment.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(CamerasPreviewFragment camerasPreviewFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        camerasPreviewFragment.cameraViewModelFactory = assistFactory;
    }
}
