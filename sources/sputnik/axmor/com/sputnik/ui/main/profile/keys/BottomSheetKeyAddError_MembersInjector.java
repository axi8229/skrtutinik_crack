package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetKeyAddError_MembersInjector implements MembersInjector<BottomSheetKeyAddError> {
    public static void injectLocalizationStorage(BottomSheetKeyAddError bottomSheetKeyAddError, LocalizationStorage localizationStorage) {
        bottomSheetKeyAddError.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetKeyAddError bottomSheetKeyAddError, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetKeyAddError.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetKeyAddError bottomSheetKeyAddError, Analytics analytics) {
        bottomSheetKeyAddError.analytics = analytics;
    }
}
