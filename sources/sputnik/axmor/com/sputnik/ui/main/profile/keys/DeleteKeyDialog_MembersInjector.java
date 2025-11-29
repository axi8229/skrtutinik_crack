package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class DeleteKeyDialog_MembersInjector implements MembersInjector<DeleteKeyDialog> {
    public static void injectLocalizationStorage(DeleteKeyDialog deleteKeyDialog, LocalizationStorage localizationStorage) {
        deleteKeyDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(DeleteKeyDialog deleteKeyDialog, MultiViewModelFactory multiViewModelFactory) {
        deleteKeyDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(DeleteKeyDialog deleteKeyDialog, Analytics analytics) {
        deleteKeyDialog.analytics = analytics;
    }
}
