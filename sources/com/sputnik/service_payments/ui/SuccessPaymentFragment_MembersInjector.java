package com.sputnik.service_payments.ui;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class SuccessPaymentFragment_MembersInjector implements MembersInjector<SuccessPaymentFragment> {
    public static void injectFactory(SuccessPaymentFragment successPaymentFragment, MultiViewModelFactory multiViewModelFactory) {
        successPaymentFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(SuccessPaymentFragment successPaymentFragment, LocalizationStorage localizationStorage) {
        successPaymentFragment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(SuccessPaymentFragment successPaymentFragment, Analytics analytics) {
        successPaymentFragment.analytics = analytics;
    }

    public static void injectCameraViewModelFactory(SuccessPaymentFragment successPaymentFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        successPaymentFragment.cameraViewModelFactory = assistFactory;
    }
}
