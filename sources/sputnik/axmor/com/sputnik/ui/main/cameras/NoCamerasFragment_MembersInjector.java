package sputnik.axmor.com.sputnik.ui.main.cameras;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class NoCamerasFragment_MembersInjector implements MembersInjector<NoCamerasFragment> {
    public static void injectLocalizationScreen(NoCamerasFragment noCamerasFragment, LocalizationStorage localizationStorage) {
        noCamerasFragment.localizationScreen = localizationStorage;
    }

    public static void injectSupportManager(NoCamerasFragment noCamerasFragment, ISupportManager iSupportManager) {
        noCamerasFragment.supportManager = iSupportManager;
    }

    public static void injectFactory(NoCamerasFragment noCamerasFragment, MultiViewModelFactory multiViewModelFactory) {
        noCamerasFragment.factory = multiViewModelFactory;
    }
}
