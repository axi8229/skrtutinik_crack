package com.sputnik.service_payments.ui;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BottomSheetPaymentInfo_MembersInjector implements MembersInjector<BottomSheetPaymentInfo> {
    public static void injectLocalizationStorage(BottomSheetPaymentInfo bottomSheetPaymentInfo, LocalizationStorage localizationStorage) {
        bottomSheetPaymentInfo.localizationStorage = localizationStorage;
    }
}
