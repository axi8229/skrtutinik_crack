package sputnik.axmor.com.sputnik.ui.main.market.services;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ServicesInfoFragment_MembersInjector implements MembersInjector<ServicesInfoFragment> {
    public static void injectFactory(ServicesInfoFragment servicesInfoFragment, MultiViewModelFactory multiViewModelFactory) {
        servicesInfoFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(ServicesInfoFragment servicesInfoFragment, LocalizationStorage localizationStorage) {
        servicesInfoFragment.localizationScreen = localizationStorage;
    }
}
