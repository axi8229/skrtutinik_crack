package sputnik.axmor.com.sputnik.ui.main.profile.notifications;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class NotificationsFragment_MembersInjector implements MembersInjector<NotificationsFragment> {
    public static void injectAnalytics(NotificationsFragment notificationsFragment, Analytics analytics) {
        notificationsFragment.analytics = analytics;
    }

    public static void injectPrefManager(NotificationsFragment notificationsFragment, PrefManager prefManager) {
        notificationsFragment.prefManager = prefManager;
    }

    public static void injectLocalizationScreen(NotificationsFragment notificationsFragment, LocalizationStorage localizationStorage) {
        notificationsFragment.localizationScreen = localizationStorage;
    }

    public static void injectSettingsProfileFactoryBuilder(NotificationsFragment notificationsFragment, SettingsProfileViewModel.Factory.AssistFactory assistFactory) {
        notificationsFragment.settingsProfileFactoryBuilder = assistFactory;
    }

    public static void injectFactory(NotificationsFragment notificationsFragment, MultiViewModelFactory multiViewModelFactory) {
        notificationsFragment.factory = multiViewModelFactory;
    }
}
