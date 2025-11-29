package sputnik.axmor.com.sputnik.ui.main.profile.family;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class RemoveFromFamilyDialog_MembersInjector implements MembersInjector<RemoveFromFamilyDialog> {
    public static void injectLocalizationStorage(RemoveFromFamilyDialog removeFromFamilyDialog, LocalizationStorage localizationStorage) {
        removeFromFamilyDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(RemoveFromFamilyDialog removeFromFamilyDialog, MultiViewModelFactory multiViewModelFactory) {
        removeFromFamilyDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(RemoveFromFamilyDialog removeFromFamilyDialog, Analytics analytics) {
        removeFromFamilyDialog.analytics = analytics;
    }
}
