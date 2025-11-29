package sputnik.axmor.com.sputnik.ui.main.profile.family;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ResendFamilyInviteDialog_MembersInjector implements MembersInjector<ResendFamilyInviteDialog> {
    public static void injectLocalizationStorage(ResendFamilyInviteDialog resendFamilyInviteDialog, LocalizationStorage localizationStorage) {
        resendFamilyInviteDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(ResendFamilyInviteDialog resendFamilyInviteDialog, MultiViewModelFactory multiViewModelFactory) {
        resendFamilyInviteDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(ResendFamilyInviteDialog resendFamilyInviteDialog, Analytics analytics) {
        resendFamilyInviteDialog.analytics = analytics;
    }
}
