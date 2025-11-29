package com.sputnik.oboarding.ui.invites;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class InviteFragment_MembersInjector implements MembersInjector<InviteFragment> {
    public static void injectLocalizationScreen(InviteFragment inviteFragment, LocalizationStorage localizationStorage) {
        inviteFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(InviteFragment inviteFragment, Analytics analytics) {
        inviteFragment.analytics = analytics;
    }

    public static void injectFactory(InviteFragment inviteFragment, MultiViewModelFactory multiViewModelFactory) {
        inviteFragment.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(InviteFragment inviteFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        inviteFragment.cameraViewModelFactory = assistFactory;
    }
}
