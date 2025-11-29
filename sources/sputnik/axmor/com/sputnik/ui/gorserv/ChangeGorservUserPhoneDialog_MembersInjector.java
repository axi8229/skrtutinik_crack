package sputnik.axmor.com.sputnik.ui.gorserv;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ChangeGorservUserPhoneDialog_MembersInjector implements MembersInjector<ChangeGorservUserPhoneDialog> {
    public static void injectLocalizationStorage(ChangeGorservUserPhoneDialog changeGorservUserPhoneDialog, LocalizationStorage localizationStorage) {
        changeGorservUserPhoneDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(ChangeGorservUserPhoneDialog changeGorservUserPhoneDialog, MultiViewModelFactory multiViewModelFactory) {
        changeGorservUserPhoneDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(ChangeGorservUserPhoneDialog changeGorservUserPhoneDialog, Analytics analytics) {
        changeGorservUserPhoneDialog.analytics = analytics;
    }
}
