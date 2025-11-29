package sputnik.axmor.com.sputnik.ui.main.profile.card;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class NewCardFragment_MembersInjector implements MembersInjector<NewCardFragment> {
    public static void injectFactory(NewCardFragment newCardFragment, MultiViewModelFactory multiViewModelFactory) {
        newCardFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(NewCardFragment newCardFragment, LocalizationStorage localizationStorage) {
        newCardFragment.localizationScreen = localizationStorage;
    }
}
