package sputnik.axmor.com.sputnik.ui.our_home;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class AboutOurHomeDialog_MembersInjector implements MembersInjector<AboutOurHomeDialog> {
    public static void injectLocalizationStorage(AboutOurHomeDialog aboutOurHomeDialog, LocalizationStorage localizationStorage) {
        aboutOurHomeDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(AboutOurHomeDialog aboutOurHomeDialog, MultiViewModelFactory multiViewModelFactory) {
        aboutOurHomeDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(AboutOurHomeDialog aboutOurHomeDialog, Analytics analytics) {
        aboutOurHomeDialog.analytics = analytics;
    }
}
