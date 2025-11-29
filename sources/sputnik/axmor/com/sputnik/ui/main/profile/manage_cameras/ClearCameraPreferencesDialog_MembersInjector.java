package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;

/* loaded from: classes5.dex */
public final class ClearCameraPreferencesDialog_MembersInjector implements MembersInjector<ClearCameraPreferencesDialog> {
    public static void injectLocalizationStorage(ClearCameraPreferencesDialog clearCameraPreferencesDialog, LocalizationStorage localizationStorage) {
        clearCameraPreferencesDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(ClearCameraPreferencesDialog clearCameraPreferencesDialog, MultiViewModelFactory multiViewModelFactory) {
        clearCameraPreferencesDialog.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(ClearCameraPreferencesDialog clearCameraPreferencesDialog, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        clearCameraPreferencesDialog.cameraViewModelFactory = assistFactory;
    }

    public static void injectManageCameraViewModelFactory(ClearCameraPreferencesDialog clearCameraPreferencesDialog, ManageCamerasViewModel.Factory.AssistFactory assistFactory) {
        clearCameraPreferencesDialog.manageCameraViewModelFactory = assistFactory;
    }

    public static void injectAnalytics(ClearCameraPreferencesDialog clearCameraPreferencesDialog, Analytics analytics) {
        clearCameraPreferencesDialog.analytics = analytics;
    }
}
