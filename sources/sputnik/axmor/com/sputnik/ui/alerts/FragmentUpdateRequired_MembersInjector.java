package sputnik.axmor.com.sputnik.ui.alerts;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FragmentUpdateRequired_MembersInjector implements MembersInjector<FragmentUpdateRequired> {
    public static void injectLocalizationScreen(FragmentUpdateRequired fragmentUpdateRequired, LocalizationStorage localizationStorage) {
        fragmentUpdateRequired.localizationScreen = localizationStorage;
    }

    public static void injectFactory(FragmentUpdateRequired fragmentUpdateRequired, MultiViewModelFactory multiViewModelFactory) {
        fragmentUpdateRequired.factory = multiViewModelFactory;
    }
}
