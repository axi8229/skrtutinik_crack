package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class ReadyToConnectBottomSheet_MembersInjector implements MembersInjector<ReadyToConnectBottomSheet> {
    public static void injectLocalizationStorage(ReadyToConnectBottomSheet readyToConnectBottomSheet, LocalizationStorage localizationStorage) {
        readyToConnectBottomSheet.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(ReadyToConnectBottomSheet readyToConnectBottomSheet, Analytics analytics) {
        readyToConnectBottomSheet.analytics = analytics;
    }
}
