package com.sputnik.common.ui.fragments;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class HDESupportActivity_MembersInjector implements MembersInjector<HDESupportActivity> {
    public static void injectPrefManager(HDESupportActivity hDESupportActivity, PrefManager prefManager) {
        hDESupportActivity.prefManager = prefManager;
    }

    public static void injectLocalizationScreen(HDESupportActivity hDESupportActivity, LocalizationStorage localizationStorage) {
        hDESupportActivity.localizationScreen = localizationStorage;
    }

    public static void injectFactory(HDESupportActivity hDESupportActivity, MultiViewModelFactory multiViewModelFactory) {
        hDESupportActivity.factory = multiViewModelFactory;
    }
}
