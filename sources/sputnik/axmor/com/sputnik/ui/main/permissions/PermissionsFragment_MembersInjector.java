package sputnik.axmor.com.sputnik.ui.main.permissions;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.Lazy;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class PermissionsFragment_MembersInjector implements MembersInjector<PermissionsFragment> {
    public static void injectFactory(PermissionsFragment permissionsFragment, Lazy<MultiViewModelFactory> lazy) {
        permissionsFragment.factory = lazy;
    }

    public static void injectLocalizationScreen(PermissionsFragment permissionsFragment, LocalizationStorage localizationStorage) {
        permissionsFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(PermissionsFragment permissionsFragment, Analytics analytics) {
        permissionsFragment.analytics = analytics;
    }
}
