package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;

/* loaded from: classes5.dex */
public final class ManageCamerasFragment_MembersInjector implements MembersInjector<ManageCamerasFragment> {
    public static void injectLocalizationScreen(ManageCamerasFragment manageCamerasFragment, LocalizationStorage localizationStorage) {
        manageCamerasFragment.localizationScreen = localizationStorage;
    }

    public static void injectManageCameraViewModelFactory(ManageCamerasFragment manageCamerasFragment, ManageCamerasViewModel.Factory.AssistFactory assistFactory) {
        manageCamerasFragment.manageCameraViewModelFactory = assistFactory;
    }

    public static void injectFactory(ManageCamerasFragment manageCamerasFragment, MultiViewModelFactory multiViewModelFactory) {
        manageCamerasFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(ManageCamerasFragment manageCamerasFragment, Analytics analytics) {
        manageCamerasFragment.analytics = analytics;
    }

    public static void injectCameraViewModelFactory(ManageCamerasFragment manageCamerasFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        manageCamerasFragment.cameraViewModelFactory = assistFactory;
    }
}
