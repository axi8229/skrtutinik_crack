package sputnik.axmor.com.sputnik.ui.main.market.services.ble;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.Lazy;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BleServiceFragment_MembersInjector implements MembersInjector<BleServiceFragment> {
    public static void injectFactory(BleServiceFragment bleServiceFragment, Lazy<MultiViewModelFactory> lazy) {
        bleServiceFragment.factory = lazy;
    }

    public static void injectLocalizationScreen(BleServiceFragment bleServiceFragment, LocalizationStorage localizationStorage) {
        bleServiceFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(BleServiceFragment bleServiceFragment, Analytics analytics) {
        bleServiceFragment.analytics = analytics;
    }
}
