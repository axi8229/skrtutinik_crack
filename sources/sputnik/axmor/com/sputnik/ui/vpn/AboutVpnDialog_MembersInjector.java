package sputnik.axmor.com.sputnik.ui.vpn;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class AboutVpnDialog_MembersInjector implements MembersInjector<AboutVpnDialog> {
    public static void injectLocalizationStorage(AboutVpnDialog aboutVpnDialog, LocalizationStorage localizationStorage) {
        aboutVpnDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(AboutVpnDialog aboutVpnDialog, MultiViewModelFactory multiViewModelFactory) {
        aboutVpnDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(AboutVpnDialog aboutVpnDialog, Analytics analytics) {
        aboutVpnDialog.analytics = analytics;
    }
}
