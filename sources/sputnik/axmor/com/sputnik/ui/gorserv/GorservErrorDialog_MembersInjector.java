package sputnik.axmor.com.sputnik.ui.gorserv;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class GorservErrorDialog_MembersInjector implements MembersInjector<GorservErrorDialog> {
    public static void injectLocalizationStorage(GorservErrorDialog gorservErrorDialog, LocalizationStorage localizationStorage) {
        gorservErrorDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(GorservErrorDialog gorservErrorDialog, MultiViewModelFactory multiViewModelFactory) {
        gorservErrorDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(GorservErrorDialog gorservErrorDialog, Analytics analytics) {
        gorservErrorDialog.analytics = analytics;
    }
}
