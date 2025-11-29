package sputnik.axmor.com.sputnik.ui.main.permissions;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BackgroundWorkFragment_MembersInjector implements MembersInjector<BackgroundWorkFragment> {
    public static void injectLocalizationStorage(BackgroundWorkFragment backgroundWorkFragment, LocalizationStorage localizationStorage) {
        backgroundWorkFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BackgroundWorkFragment backgroundWorkFragment, MultiViewModelFactory multiViewModelFactory) {
        backgroundWorkFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BackgroundWorkFragment backgroundWorkFragment, Analytics analytics) {
        backgroundWorkFragment.analytics = analytics;
    }
}
