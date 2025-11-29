package sputnik.axmor.com.sputnik.ui.main.market.subscription.success_dialog;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SuccessSubscriptionDialog_MembersInjector implements MembersInjector<SuccessSubscriptionDialog> {
    public static void injectFactory(SuccessSubscriptionDialog successSubscriptionDialog, MultiViewModelFactory multiViewModelFactory) {
        successSubscriptionDialog.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(SuccessSubscriptionDialog successSubscriptionDialog, LocalizationStorage localizationStorage) {
        successSubscriptionDialog.localizationScreen = localizationStorage;
    }
}
