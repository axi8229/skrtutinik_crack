package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FrSuccessFragment_MembersInjector implements MembersInjector<FrSuccessFragment> {
    public static void injectFactory(FrSuccessFragment frSuccessFragment, MultiViewModelFactory multiViewModelFactory) {
        frSuccessFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(FrSuccessFragment frSuccessFragment, LocalizationStorage localizationStorage) {
        frSuccessFragment.localizationScreen = localizationStorage;
    }
}
