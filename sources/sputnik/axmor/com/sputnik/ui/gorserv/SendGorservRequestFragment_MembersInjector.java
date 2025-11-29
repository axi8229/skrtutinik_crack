package sputnik.axmor.com.sputnik.ui.gorserv;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SendGorservRequestFragment_MembersInjector implements MembersInjector<SendGorservRequestFragment> {
    public static void injectPrefManager(SendGorservRequestFragment sendGorservRequestFragment, PrefManager prefManager) {
        sendGorservRequestFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(SendGorservRequestFragment sendGorservRequestFragment, Analytics analytics) {
        sendGorservRequestFragment.analytics = analytics;
    }

    public static void injectLocalizationScreen(SendGorservRequestFragment sendGorservRequestFragment, LocalizationStorage localizationStorage) {
        sendGorservRequestFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(SendGorservRequestFragment sendGorservRequestFragment, MultiViewModelFactory multiViewModelFactory) {
        sendGorservRequestFragment.factory = multiViewModelFactory;
    }
}
