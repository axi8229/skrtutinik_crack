package com.sputnik.service_payments.ui;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BottomSheetAboutCompany_MembersInjector implements MembersInjector<BottomSheetAboutCompany> {
    public static void injectLocalizationStorage(BottomSheetAboutCompany bottomSheetAboutCompany, LocalizationStorage localizationStorage) {
        bottomSheetAboutCompany.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetAboutCompany bottomSheetAboutCompany, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetAboutCompany.factory = multiViewModelFactory;
    }
}
