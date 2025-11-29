package sputnik.axmor.com.sputnik.ui.main.profile.family;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SendFamilyInviteErrorDialog_MembersInjector implements MembersInjector<SendFamilyInviteErrorDialog> {
    public static void injectLocalizationScreen(SendFamilyInviteErrorDialog sendFamilyInviteErrorDialog, LocalizationStorage localizationStorage) {
        sendFamilyInviteErrorDialog.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(SendFamilyInviteErrorDialog sendFamilyInviteErrorDialog, Analytics analytics) {
        sendFamilyInviteErrorDialog.analytics = analytics;
    }
}
