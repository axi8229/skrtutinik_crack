package sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class LogOutDialog_MembersInjector implements MembersInjector<LogOutDialog> {
    public static void injectFactory(LogOutDialog logOutDialog, MultiViewModelFactory multiViewModelFactory) {
        logOutDialog.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelBuilder(LogOutDialog logOutDialog, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        logOutDialog.cameraViewModelBuilder = assistFactory;
    }

    public static void injectLocalizationScreen(LogOutDialog logOutDialog, LocalizationStorage localizationStorage) {
        logOutDialog.localizationScreen = localizationStorage;
    }
}
