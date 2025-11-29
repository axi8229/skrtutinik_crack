package com.sputnik.subscriptions.ui.sheets;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BottomSheetSuccessPayment_MembersInjector implements MembersInjector<BottomSheetSuccessPayment> {
    public static void injectLocalizationStorage(BottomSheetSuccessPayment bottomSheetSuccessPayment, LocalizationStorage localizationStorage) {
        bottomSheetSuccessPayment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetSuccessPayment bottomSheetSuccessPayment, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetSuccessPayment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetSuccessPayment bottomSheetSuccessPayment, Analytics analytics) {
        bottomSheetSuccessPayment.analytics = analytics;
    }
}
