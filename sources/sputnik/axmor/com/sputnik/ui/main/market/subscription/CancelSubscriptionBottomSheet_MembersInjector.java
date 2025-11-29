package sputnik.axmor.com.sputnik.ui.main.market.subscription;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class CancelSubscriptionBottomSheet_MembersInjector implements MembersInjector<CancelSubscriptionBottomSheet> {
    public static void injectFactory(CancelSubscriptionBottomSheet cancelSubscriptionBottomSheet, MultiViewModelFactory multiViewModelFactory) {
        cancelSubscriptionBottomSheet.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(CancelSubscriptionBottomSheet cancelSubscriptionBottomSheet, LocalizationStorage localizationStorage) {
        cancelSubscriptionBottomSheet.localizationScreen = localizationStorage;
    }
}
