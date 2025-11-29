package sputnik.axmor.com.sputnik.ui.main.profile.card;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class CardFragment_MembersInjector implements MembersInjector<CardFragment> {
    public static void injectFactory(CardFragment cardFragment, MultiViewModelFactory multiViewModelFactory) {
        cardFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(CardFragment cardFragment, LocalizationStorage localizationStorage) {
        cardFragment.localizationScreen = localizationStorage;
    }
}
