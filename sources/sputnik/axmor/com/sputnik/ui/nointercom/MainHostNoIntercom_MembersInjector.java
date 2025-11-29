package sputnik.axmor.com.sputnik.ui.nointercom;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class MainHostNoIntercom_MembersInjector implements MembersInjector<MainHostNoIntercom> {
    public static void injectLocalizationStorage(MainHostNoIntercom mainHostNoIntercom, LocalizationStorage localizationStorage) {
        mainHostNoIntercom.localizationStorage = localizationStorage;
    }

    public static void injectFactory(MainHostNoIntercom mainHostNoIntercom, MultiViewModelFactory multiViewModelFactory) {
        mainHostNoIntercom.factory = multiViewModelFactory;
    }

    public static void injectPrefManager(MainHostNoIntercom mainHostNoIntercom, PrefManager prefManager) {
        mainHostNoIntercom.prefManager = prefManager;
    }

    public static void injectAnalytics(MainHostNoIntercom mainHostNoIntercom, Analytics analytics) {
        mainHostNoIntercom.analytics = analytics;
    }

    public static void injectCamerasViewModelFactory(MainHostNoIntercom mainHostNoIntercom, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        mainHostNoIntercom.camerasViewModelFactory = assistFactory;
    }
}
