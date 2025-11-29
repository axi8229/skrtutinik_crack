package com.sputnik.service_payments.ui.blocking;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BlockingDialog_MembersInjector implements MembersInjector<BlockingDialog> {
    public static void injectLocalizationStorage(BlockingDialog blockingDialog, LocalizationStorage localizationStorage) {
        blockingDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BlockingDialog blockingDialog, MultiViewModelFactory multiViewModelFactory) {
        blockingDialog.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BlockingDialog blockingDialog, Analytics analytics) {
        blockingDialog.analytics = analytics;
    }
}
