package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FrServiceFragment_MembersInjector implements MembersInjector<FrServiceFragment> {
    public static void injectFactory(FrServiceFragment frServiceFragment, MultiViewModelFactory multiViewModelFactory) {
        frServiceFragment.factory = multiViewModelFactory;
    }

    public static void injectSupportManager(FrServiceFragment frServiceFragment, ISupportManager iSupportManager) {
        frServiceFragment.supportManager = iSupportManager;
    }

    public static void injectLocalizationScreen(FrServiceFragment frServiceFragment, LocalizationStorage localizationStorage) {
        frServiceFragment.localizationScreen = localizationStorage;
    }
}
