package sputnik.axmor.com.sputnik.ui.main.profile.family;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class LeaveFromFamilyDialog_MembersInjector implements MembersInjector<LeaveFromFamilyDialog> {
    public static void injectLocalizationStorage(LeaveFromFamilyDialog leaveFromFamilyDialog, LocalizationStorage localizationStorage) {
        leaveFromFamilyDialog.localizationStorage = localizationStorage;
    }

    public static void injectFactory(LeaveFromFamilyDialog leaveFromFamilyDialog, MultiViewModelFactory multiViewModelFactory) {
        leaveFromFamilyDialog.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(LeaveFromFamilyDialog leaveFromFamilyDialog, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        leaveFromFamilyDialog.cameraViewModelFactory = assistFactory;
    }

    public static void injectAnalytics(LeaveFromFamilyDialog leaveFromFamilyDialog, Analytics analytics) {
        leaveFromFamilyDialog.analytics = analytics;
    }
}
