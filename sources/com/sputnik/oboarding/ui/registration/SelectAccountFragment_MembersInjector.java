package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class SelectAccountFragment_MembersInjector implements MembersInjector<SelectAccountFragment> {
    public static void injectLocalizationStorage(SelectAccountFragment selectAccountFragment, LocalizationStorage localizationStorage) {
        selectAccountFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(SelectAccountFragment selectAccountFragment, MultiViewModelFactory multiViewModelFactory) {
        selectAccountFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(SelectAccountFragment selectAccountFragment, Analytics analytics) {
        selectAccountFragment.analytics = analytics;
    }

    public static void injectPrefManager(SelectAccountFragment selectAccountFragment, PrefManager prefManager) {
        selectAccountFragment.prefManager = prefManager;
    }

    public static void injectCameraViewModelFactory(SelectAccountFragment selectAccountFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        selectAccountFragment.cameraViewModelFactory = assistFactory;
    }
}
