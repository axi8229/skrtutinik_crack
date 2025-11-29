package sputnik.axmor.com.sputnik.ui.main.cameras.history;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class CallHistoryDetails_MembersInjector implements MembersInjector<CallHistoryDetails> {
    public static void injectAnalytics(CallHistoryDetails callHistoryDetails, Analytics analytics) {
        callHistoryDetails.analytics = analytics;
    }

    public static void injectLocalizationScreen(CallHistoryDetails callHistoryDetails, LocalizationStorage localizationStorage) {
        callHistoryDetails.localizationScreen = localizationStorage;
    }
}
