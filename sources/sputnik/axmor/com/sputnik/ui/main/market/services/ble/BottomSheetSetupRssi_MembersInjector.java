package sputnik.axmor.com.sputnik.ui.main.market.services.ble;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetSetupRssi_MembersInjector implements MembersInjector<BottomSheetSetupRssi> {
    public static void injectLocalizationStorage(BottomSheetSetupRssi bottomSheetSetupRssi, LocalizationStorage localizationStorage) {
        bottomSheetSetupRssi.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetSetupRssi bottomSheetSetupRssi, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetSetupRssi.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetSetupRssi bottomSheetSetupRssi, Analytics analytics) {
        bottomSheetSetupRssi.analytics = analytics;
    }
}
