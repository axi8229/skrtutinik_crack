package sputnik.axmor.com.sputnik.ui.install_sputnik;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SendInstallSputnikRequestFragment_MembersInjector implements MembersInjector<SendInstallSputnikRequestFragment> {
    public static void injectFactory(SendInstallSputnikRequestFragment sendInstallSputnikRequestFragment, MultiViewModelFactory multiViewModelFactory) {
        sendInstallSputnikRequestFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(SendInstallSputnikRequestFragment sendInstallSputnikRequestFragment, LocalizationStorage localizationStorage) {
        sendInstallSputnikRequestFragment.localizationScreen = localizationStorage;
    }

    public static void injectPrefManager(SendInstallSputnikRequestFragment sendInstallSputnikRequestFragment, PrefManager prefManager) {
        sendInstallSputnikRequestFragment.prefManager = prefManager;
    }
}
