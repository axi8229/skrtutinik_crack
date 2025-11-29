package com.sputnik.service_payments.ui.blocking;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BottomSheetArgueDebt_MembersInjector implements MembersInjector<BottomSheetArgueDebt> {
    public static void injectLocalizationStorage(BottomSheetArgueDebt bottomSheetArgueDebt, LocalizationStorage localizationStorage) {
        bottomSheetArgueDebt.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetArgueDebt bottomSheetArgueDebt, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetArgueDebt.factory = multiViewModelFactory;
    }

    public static void injectSupportManager(BottomSheetArgueDebt bottomSheetArgueDebt, ISupportManager iSupportManager) {
        bottomSheetArgueDebt.supportManager = iSupportManager;
    }
}
