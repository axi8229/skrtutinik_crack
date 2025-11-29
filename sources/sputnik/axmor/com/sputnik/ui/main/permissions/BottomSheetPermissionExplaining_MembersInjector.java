package sputnik.axmor.com.sputnik.ui.main.permissions;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetPermissionExplaining_MembersInjector implements MembersInjector<BottomSheetPermissionExplaining> {
    public static void injectLocalizationStorage(BottomSheetPermissionExplaining bottomSheetPermissionExplaining, LocalizationStorage localizationStorage) {
        bottomSheetPermissionExplaining.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetPermissionExplaining bottomSheetPermissionExplaining, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetPermissionExplaining.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetPermissionExplaining bottomSheetPermissionExplaining, Analytics analytics) {
        bottomSheetPermissionExplaining.analytics = analytics;
    }
}
