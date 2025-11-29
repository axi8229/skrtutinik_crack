package sputnik.axmor.com.sputnik.ui.main.permissions;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.Lazy;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class InstructionFragment_MembersInjector implements MembersInjector<InstructionFragment> {
    public static void injectFactory(InstructionFragment instructionFragment, Lazy<MultiViewModelFactory> lazy) {
        instructionFragment.factory = lazy;
    }

    public static void injectLocalizationScreen(InstructionFragment instructionFragment, LocalizationStorage localizationStorage) {
        instructionFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(InstructionFragment instructionFragment, Analytics analytics) {
        instructionFragment.analytics = analytics;
    }
}
