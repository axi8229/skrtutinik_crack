package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FrErrorFragment_MembersInjector implements MembersInjector<FrErrorFragment> {
    public static void injectLocalizationScreen(FrErrorFragment frErrorFragment, LocalizationStorage localizationStorage) {
        frErrorFragment.localizationScreen = localizationStorage;
    }
}
