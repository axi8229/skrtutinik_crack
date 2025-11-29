package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;

/* loaded from: classes5.dex */
public final class ManageCamerasDetails_MembersInjector implements MembersInjector<ManageCamerasDetails> {
    public static void injectManageCameraViewModelFactory(ManageCamerasDetails manageCamerasDetails, ManageCamerasViewModel.Factory.AssistFactory assistFactory) {
        manageCamerasDetails.manageCameraViewModelFactory = assistFactory;
    }

    public static void injectLocalizationScreen(ManageCamerasDetails manageCamerasDetails, LocalizationStorage localizationStorage) {
        manageCamerasDetails.localizationScreen = localizationStorage;
    }
}
