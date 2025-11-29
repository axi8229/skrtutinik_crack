package com.sputnik.oboarding.ui.onboarding;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class StoryFragment_MembersInjector implements MembersInjector<StoryFragment> {
    public static void injectFactory(StoryFragment storyFragment, MultiViewModelFactory multiViewModelFactory) {
        storyFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(StoryFragment storyFragment, Analytics analytics) {
        storyFragment.analytics = analytics;
    }

    public static void injectPrefManager(StoryFragment storyFragment, PrefManager prefManager) {
        storyFragment.prefManager = prefManager;
    }
}
