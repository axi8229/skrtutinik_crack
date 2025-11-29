package com.sputnik.service_payments.ui.blocking;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BottomSheetPromisePayment_MembersInjector implements MembersInjector<BottomSheetPromisePayment> {
    public static void injectFactory(BottomSheetPromisePayment bottomSheetPromisePayment, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetPromisePayment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(BottomSheetPromisePayment bottomSheetPromisePayment, LocalizationStorage localizationStorage) {
        bottomSheetPromisePayment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(BottomSheetPromisePayment bottomSheetPromisePayment, Analytics analytics) {
        bottomSheetPromisePayment.analytics = analytics;
    }
}
