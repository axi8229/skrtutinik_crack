package sputnik.axmor.com.sputnik.ui.main.permissions;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetNoBlePermissions_MembersInjector implements MembersInjector<BottomSheetNoBlePermissions> {
    public static void injectLocalizationStorage(BottomSheetNoBlePermissions bottomSheetNoBlePermissions, LocalizationStorage localizationStorage) {
        bottomSheetNoBlePermissions.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetNoBlePermissions bottomSheetNoBlePermissions, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetNoBlePermissions.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetNoBlePermissions bottomSheetNoBlePermissions, Analytics analytics) {
        bottomSheetNoBlePermissions.analytics = analytics;
    }
}
