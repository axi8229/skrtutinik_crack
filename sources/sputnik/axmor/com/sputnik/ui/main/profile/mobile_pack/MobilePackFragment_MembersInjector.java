package sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class MobilePackFragment_MembersInjector implements MembersInjector<MobilePackFragment> {
    public static void injectPrefManager(MobilePackFragment mobilePackFragment, PrefManager prefManager) {
        mobilePackFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(MobilePackFragment mobilePackFragment, Analytics analytics) {
        mobilePackFragment.analytics = analytics;
    }

    public static void injectLocalizationScreen(MobilePackFragment mobilePackFragment, LocalizationStorage localizationStorage) {
        mobilePackFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(MobilePackFragment mobilePackFragment, MultiViewModelFactory multiViewModelFactory) {
        mobilePackFragment.factory = multiViewModelFactory;
    }
}
