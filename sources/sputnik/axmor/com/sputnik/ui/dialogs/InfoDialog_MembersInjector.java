package sputnik.axmor.com.sputnik.ui.dialogs;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class InfoDialog_MembersInjector implements MembersInjector<InfoDialog> {
    public static void injectLocalizationScreen(InfoDialog infoDialog, LocalizationStorage localizationStorage) {
        infoDialog.localizationScreen = localizationStorage;
    }

    public static void injectFactory(InfoDialog infoDialog, MultiViewModelFactory multiViewModelFactory) {
        infoDialog.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(InfoDialog infoDialog, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        infoDialog.cameraViewModelFactory = assistFactory;
    }
}
