package sputnik.axmor.com.sputnik.ui.main.market;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class NewMarketFragment_MembersInjector implements MembersInjector<NewMarketFragment> {
    public static void injectFactory(NewMarketFragment newMarketFragment, MultiViewModelFactory multiViewModelFactory) {
        newMarketFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(NewMarketFragment newMarketFragment, LocalizationStorage localizationStorage) {
        newMarketFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(NewMarketFragment newMarketFragment, Analytics analytics) {
        newMarketFragment.analytics = analytics;
    }

    public static void injectPrefManager(NewMarketFragment newMarketFragment, PrefManager prefManager) {
        newMarketFragment.prefManager = prefManager;
    }

    public static void injectSupportManager(NewMarketFragment newMarketFragment, ISupportManager iSupportManager) {
        newMarketFragment.supportManager = iSupportManager;
    }
}
