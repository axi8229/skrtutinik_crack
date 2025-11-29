package sputnik.axmor.com.sputnik.ui.gorserv;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetGorservRequestSent_MembersInjector implements MembersInjector<BottomSheetGorservRequestSent> {
    public static void injectLocalizationStorage(BottomSheetGorservRequestSent bottomSheetGorservRequestSent, LocalizationStorage localizationStorage) {
        bottomSheetGorservRequestSent.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetGorservRequestSent bottomSheetGorservRequestSent, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetGorservRequestSent.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetGorservRequestSent bottomSheetGorservRequestSent, Analytics analytics) {
        bottomSheetGorservRequestSent.analytics = analytics;
    }
}
