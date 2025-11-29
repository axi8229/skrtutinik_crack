package sputnik.axmor.com.sputnik.ui.main.cameras.rate_us;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class RateUsDialog_MembersInjector implements MembersInjector<RateUsDialog> {
    public static void injectLocalizationScreen(RateUsDialog rateUsDialog, LocalizationStorage localizationStorage) {
        rateUsDialog.localizationScreen = localizationStorage;
    }

    public static void injectFactory(RateUsDialog rateUsDialog, MultiViewModelFactory multiViewModelFactory) {
        rateUsDialog.factory = multiViewModelFactory;
    }
}
