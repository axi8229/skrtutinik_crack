package sputnik.axmor.com.sputnik.ui.block;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BlockedFragment_MembersInjector implements MembersInjector<BlockedFragment> {
    public static void injectLocalizationScreen(BlockedFragment blockedFragment, LocalizationStorage localizationStorage) {
        blockedFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(BlockedFragment blockedFragment, Analytics analytics) {
        blockedFragment.analytics = analytics;
    }

    public static void injectFactory(BlockedFragment blockedFragment, MultiViewModelFactory multiViewModelFactory) {
        blockedFragment.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelBuilder(BlockedFragment blockedFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        blockedFragment.cameraViewModelBuilder = assistFactory;
    }
}
