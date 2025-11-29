package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ShotFragment_MembersInjector implements MembersInjector<ShotFragment> {
    public static void injectFactory(ShotFragment shotFragment, MultiViewModelFactory multiViewModelFactory) {
        shotFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(ShotFragment shotFragment, LocalizationStorage localizationStorage) {
        shotFragment.localizationScreen = localizationStorage;
    }
}
