package com.sputnik.service_payments.ui.blocking;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class DialogSuccessPromise_MembersInjector implements MembersInjector<DialogSuccessPromise> {
    public static void injectLocalizationScreen(DialogSuccessPromise dialogSuccessPromise, LocalizationStorage localizationStorage) {
        dialogSuccessPromise.localizationScreen = localizationStorage;
    }

    public static void injectFactory(DialogSuccessPromise dialogSuccessPromise, MultiViewModelFactory multiViewModelFactory) {
        dialogSuccessPromise.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(DialogSuccessPromise dialogSuccessPromise, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        dialogSuccessPromise.cameraViewModelFactory = assistFactory;
    }
}
