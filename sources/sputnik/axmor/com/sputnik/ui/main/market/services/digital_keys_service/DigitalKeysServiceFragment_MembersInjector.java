package sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class DigitalKeysServiceFragment_MembersInjector implements MembersInjector<DigitalKeysServiceFragment> {
    public static void injectAnalytics(DigitalKeysServiceFragment digitalKeysServiceFragment, Analytics analytics) {
        digitalKeysServiceFragment.analytics = analytics;
    }

    public static void injectSupportManager(DigitalKeysServiceFragment digitalKeysServiceFragment, ISupportManager iSupportManager) {
        digitalKeysServiceFragment.supportManager = iSupportManager;
    }

    public static void injectFactory(DigitalKeysServiceFragment digitalKeysServiceFragment, MultiViewModelFactory multiViewModelFactory) {
        digitalKeysServiceFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(DigitalKeysServiceFragment digitalKeysServiceFragment, LocalizationStorage localizationStorage) {
        digitalKeysServiceFragment.localizationScreen = localizationStorage;
    }
}
