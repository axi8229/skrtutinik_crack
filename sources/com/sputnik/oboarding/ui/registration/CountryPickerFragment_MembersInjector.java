package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class CountryPickerFragment_MembersInjector implements MembersInjector<CountryPickerFragment> {
    public static void injectFactory(CountryPickerFragment countryPickerFragment, MultiViewModelFactory multiViewModelFactory) {
        countryPickerFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(CountryPickerFragment countryPickerFragment, LocalizationStorage localizationStorage) {
        countryPickerFragment.localizationScreen = localizationStorage;
    }
}
