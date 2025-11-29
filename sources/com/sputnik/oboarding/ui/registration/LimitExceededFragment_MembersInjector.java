package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class LimitExceededFragment_MembersInjector implements MembersInjector<LimitExceededFragment> {
    public static void injectAnalytics(LimitExceededFragment limitExceededFragment, Analytics analytics) {
        limitExceededFragment.analytics = analytics;
    }

    public static void injectLocalizationStorage(LimitExceededFragment limitExceededFragment, LocalizationStorage localizationStorage) {
        limitExceededFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(LimitExceededFragment limitExceededFragment, MultiViewModelFactory multiViewModelFactory) {
        limitExceededFragment.factory = multiViewModelFactory;
    }
}
