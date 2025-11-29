package sputnik.axmor.com.sputnik.ui.popups;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class PopupStoryFragment_MembersInjector implements MembersInjector<PopupStoryFragment> {
    public static void injectFactory(PopupStoryFragment popupStoryFragment, MultiViewModelFactory multiViewModelFactory) {
        popupStoryFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(PopupStoryFragment popupStoryFragment, Analytics analytics) {
        popupStoryFragment.analytics = analytics;
    }

    public static void injectPrefManager(PopupStoryFragment popupStoryFragment, PrefManager prefManager) {
        popupStoryFragment.prefManager = prefManager;
    }
}
