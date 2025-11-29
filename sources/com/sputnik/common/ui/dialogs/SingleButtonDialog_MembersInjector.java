package com.sputnik.common.ui.dialogs;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class SingleButtonDialog_MembersInjector implements MembersInjector<SingleButtonDialog> {
    public static void injectBaseFactory(SingleButtonDialog singleButtonDialog, MultiViewModelFactory multiViewModelFactory) {
        singleButtonDialog.baseFactory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(SingleButtonDialog singleButtonDialog, LocalizationStorage localizationStorage) {
        singleButtonDialog.localizationScreen = localizationStorage;
    }
}
