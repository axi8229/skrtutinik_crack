package sputnik.axmor.com.sputnik.ui.main.profile.notifications;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class NotificationsDetailsFragment_MembersInjector implements MembersInjector<NotificationsDetailsFragment> {
    public static void injectAnalytics(NotificationsDetailsFragment notificationsDetailsFragment, Analytics analytics) {
        notificationsDetailsFragment.analytics = analytics;
    }

    public static void injectPrefManager(NotificationsDetailsFragment notificationsDetailsFragment, PrefManager prefManager) {
        notificationsDetailsFragment.prefManager = prefManager;
    }

    public static void injectLocalizationScreen(NotificationsDetailsFragment notificationsDetailsFragment, LocalizationStorage localizationStorage) {
        notificationsDetailsFragment.localizationScreen = localizationStorage;
    }

    public static void injectSettingsProfileFactoryBuilder(NotificationsDetailsFragment notificationsDetailsFragment, SettingsProfileViewModel.Factory.AssistFactory assistFactory) {
        notificationsDetailsFragment.settingsProfileFactoryBuilder = assistFactory;
    }

    public static void injectFactory(NotificationsDetailsFragment notificationsDetailsFragment, MultiViewModelFactory multiViewModelFactory) {
        notificationsDetailsFragment.factory = multiViewModelFactory;
    }
}
