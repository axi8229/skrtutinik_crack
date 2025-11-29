package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class ConnectToIntercomFragment_MembersInjector implements MembersInjector<ConnectToIntercomFragment> {
    public static void injectLocalizationScreen(ConnectToIntercomFragment connectToIntercomFragment, LocalizationStorage localizationStorage) {
        connectToIntercomFragment.localizationScreen = localizationStorage;
    }

    public static void injectPrefManager(ConnectToIntercomFragment connectToIntercomFragment, PrefManager prefManager) {
        connectToIntercomFragment.prefManager = prefManager;
    }

    public static void injectFactory(ConnectToIntercomFragment connectToIntercomFragment, MultiViewModelFactory multiViewModelFactory) {
        connectToIntercomFragment.factory = multiViewModelFactory;
    }

    public static void injectCamerasFactory(ConnectToIntercomFragment connectToIntercomFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        connectToIntercomFragment.camerasFactory = assistFactory;
    }

    public static void injectAnalytics(ConnectToIntercomFragment connectToIntercomFragment, Analytics analytics) {
        connectToIntercomFragment.analytics = analytics;
    }
}
