package sputnik.axmor.com.sputnik.ui.main.help;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class AboutAppFragment_MembersInjector implements MembersInjector<AboutAppFragment> {
    public static void injectLocalizationScreen(AboutAppFragment aboutAppFragment, LocalizationStorage localizationStorage) {
        aboutAppFragment.localizationScreen = localizationStorage;
    }
}
