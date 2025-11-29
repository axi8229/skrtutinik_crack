package sputnik.axmor.com.sputnik.ui.emergency_code;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class EmergencyCodeBottomSheet_MembersInjector implements MembersInjector<EmergencyCodeBottomSheet> {
    public static void injectLocalizationScreen(EmergencyCodeBottomSheet emergencyCodeBottomSheet, LocalizationStorage localizationStorage) {
        emergencyCodeBottomSheet.localizationScreen = localizationStorage;
    }

    public static void injectFactory(EmergencyCodeBottomSheet emergencyCodeBottomSheet, MultiViewModelFactory multiViewModelFactory) {
        emergencyCodeBottomSheet.factory = multiViewModelFactory;
    }
}
