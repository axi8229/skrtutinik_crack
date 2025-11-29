package sputnik.axmor.com.sputnik.ui.main.profile.multi_address;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class DeleteAddressDialog_MembersInjector implements MembersInjector<DeleteAddressDialog> {
    public static void injectLocalizationStorage(DeleteAddressDialog deleteAddressDialog, LocalizationStorage localizationStorage) {
        deleteAddressDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(DeleteAddressDialog deleteAddressDialog, MultiViewModelFactory multiViewModelFactory) {
        deleteAddressDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(DeleteAddressDialog deleteAddressDialog, Analytics analytics) {
        deleteAddressDialog.analytics = analytics;
    }
}
