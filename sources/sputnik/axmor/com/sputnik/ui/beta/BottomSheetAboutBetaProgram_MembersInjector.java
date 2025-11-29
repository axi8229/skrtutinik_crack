package sputnik.axmor.com.sputnik.ui.beta;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetAboutBetaProgram_MembersInjector implements MembersInjector<BottomSheetAboutBetaProgram> {
    public static void injectLocalizationStorage(BottomSheetAboutBetaProgram bottomSheetAboutBetaProgram, LocalizationStorage localizationStorage) {
        bottomSheetAboutBetaProgram.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetAboutBetaProgram bottomSheetAboutBetaProgram, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetAboutBetaProgram.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetAboutBetaProgram bottomSheetAboutBetaProgram, Analytics analytics) {
        bottomSheetAboutBetaProgram.analytics = analytics;
    }
}
