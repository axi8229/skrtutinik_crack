package sputnik.axmor.com.sputnik.ui.main.help;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class HelpFragment_MembersInjector implements MembersInjector<HelpFragment> {
    public static void injectLocalizationScreen(HelpFragment helpFragment, LocalizationStorage localizationStorage) {
        helpFragment.localizationScreen = localizationStorage;
    }

    public static void injectPrefManager(HelpFragment helpFragment, PrefManager prefManager) {
        helpFragment.prefManager = prefManager;
    }

    public static void injectSupportManager(HelpFragment helpFragment, ISupportManager iSupportManager) {
        helpFragment.supportManager = iSupportManager;
    }

    public static void injectFactory(HelpFragment helpFragment, MultiViewModelFactory multiViewModelFactory) {
        helpFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(HelpFragment helpFragment, Analytics analytics) {
        helpFragment.analytics = analytics;
    }
}
