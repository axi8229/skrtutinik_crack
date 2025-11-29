package sputnik.axmor.com.sputnik.ui.main.profile;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.Lazy;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ProfileFragment_MembersInjector implements MembersInjector<ProfileFragment> {
    public static void injectLocalizationScreen(ProfileFragment profileFragment, LocalizationStorage localizationStorage) {
        profileFragment.localizationScreen = localizationStorage;
    }

    public static void injectPrefManager(ProfileFragment profileFragment, Lazy<PrefManager> lazy) {
        profileFragment.prefManager = lazy;
    }

    public static void injectFactory(ProfileFragment profileFragment, Lazy<MultiViewModelFactory> lazy) {
        profileFragment.factory = lazy;
    }

    public static void injectCamerasFactoryBuilder(ProfileFragment profileFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        profileFragment.camerasFactoryBuilder = assistFactory;
    }

    public static void injectAnalytics(ProfileFragment profileFragment, Analytics analytics) {
        profileFragment.analytics = analytics;
    }
}
