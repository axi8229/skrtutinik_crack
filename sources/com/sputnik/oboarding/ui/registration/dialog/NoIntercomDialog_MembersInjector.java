package com.sputnik.oboarding.ui.registration.dialog;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class NoIntercomDialog_MembersInjector implements MembersInjector<NoIntercomDialog> {
    public static void injectLocalizationScreen(NoIntercomDialog noIntercomDialog, LocalizationStorage localizationStorage) {
        noIntercomDialog.localizationScreen = localizationStorage;
    }

    public static void injectFactory(NoIntercomDialog noIntercomDialog, MultiViewModelFactory multiViewModelFactory) {
        noIntercomDialog.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(NoIntercomDialog noIntercomDialog, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        noIntercomDialog.cameraViewModelFactory = assistFactory;
    }
}
