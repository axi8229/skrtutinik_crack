package com.sputnik.common.viewmodels;

import android.app.Application;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.prefs.OnboardingSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: OnboardingViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\fJ\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\fJ\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/OnboardingViewState;", "", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Landroid/app/Application;", "application", "<init>", "(Lcom/sputnik/data/local/PrefManager;Landroid/app/Application;)V", "", "loadPreferences", "()V", "delayOnboardingToOurHome", "delayNoBlePermissions", "lockOnboardingToOurHome", "lockMoveHistory", "lockGalleryOnboarding", "delayBleFeedback", "disableBleFeedback", "dontShowGalleryOnboarding", "disableShowingArchiveInDevelopment", "Lcom/sputnik/data/local/PrefManager;", "Landroid/app/Application;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OnboardingViewModel extends BaseViewModel<OnboardingViewState> {
    private final Application application;
    private final PrefManager prefManager;

    public void lockGalleryOnboarding() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingViewModel(PrefManager prefManager, Application application) {
        super(new OnboardingViewState(null, null, null, null, null, null, false, 127, null), "javaClass");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(application, "application");
        this.prefManager = prefManager;
        this.application = application;
        loadPreferences();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadPreferences() {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.OnboardingViewModel.loadPreferences():void");
    }

    public void delayOnboardingToOurHome() {
        PrefManager prefManager = this.prefManager;
        OnboardingSettings onboardingSettings = prefManager.getOnboardingSettings();
        prefManager.setOnboardingSettings(onboardingSettings.copy((1019 & 1) != 0 ? onboardingSettings.lastShowingAboutOurAppDialogTimestamp : 0L, (1019 & 2) != 0 ? onboardingSettings.lastShowingAboutOurUpdatedAppDialogTimestamp : System.currentTimeMillis(), (1019 & 4) != 0 ? onboardingSettings.lastShowingNoBlePermissionsBottomSheetTimestamp : 0L, (1019 & 8) != 0 ? onboardingSettings.needToShowMoveHistory1 : false, (1019 & 16) != 0 ? onboardingSettings.needToShowMoveHistory2 : false, (1019 & 32) != 0 ? onboardingSettings.needToShowNotificationsSection : null, (1019 & 64) != 0 ? onboardingSettings.gorservOnboardingSettings : null, (1019 & 128) != 0 ? onboardingSettings.showBleFeedbackAt : null, (1019 & 256) != 0 ? onboardingSettings.needToShowGalleryOnboarding : false, (1019 & 512) != 0 ? onboardingSettings.needToShowArchiveInDevelopmentPopup : false));
        loadPreferences();
    }

    public void delayNoBlePermissions() {
        PrefManager prefManager = this.prefManager;
        OnboardingSettings onboardingSettings = prefManager.getOnboardingSettings();
        prefManager.setOnboardingSettings(onboardingSettings.copy((1019 & 1) != 0 ? onboardingSettings.lastShowingAboutOurAppDialogTimestamp : 0L, (1019 & 2) != 0 ? onboardingSettings.lastShowingAboutOurUpdatedAppDialogTimestamp : 0L, (1019 & 4) != 0 ? onboardingSettings.lastShowingNoBlePermissionsBottomSheetTimestamp : System.currentTimeMillis(), (1019 & 8) != 0 ? onboardingSettings.needToShowMoveHistory1 : false, (1019 & 16) != 0 ? onboardingSettings.needToShowMoveHistory2 : false, (1019 & 32) != 0 ? onboardingSettings.needToShowNotificationsSection : null, (1019 & 64) != 0 ? onboardingSettings.gorservOnboardingSettings : null, (1019 & 128) != 0 ? onboardingSettings.showBleFeedbackAt : null, (1019 & 256) != 0 ? onboardingSettings.needToShowGalleryOnboarding : false, (1019 & 512) != 0 ? onboardingSettings.needToShowArchiveInDevelopmentPopup : false));
    }

    public void lockOnboardingToOurHome() {
        PrefManager prefManager = this.prefManager;
        OnboardingSettings onboardingSettings = prefManager.getOnboardingSettings();
        prefManager.setOnboardingSettings(onboardingSettings.copy((1019 & 1) != 0 ? onboardingSettings.lastShowingAboutOurAppDialogTimestamp : 0L, (1019 & 2) != 0 ? onboardingSettings.lastShowingAboutOurUpdatedAppDialogTimestamp : -1L, (1019 & 4) != 0 ? onboardingSettings.lastShowingNoBlePermissionsBottomSheetTimestamp : 0L, (1019 & 8) != 0 ? onboardingSettings.needToShowMoveHistory1 : false, (1019 & 16) != 0 ? onboardingSettings.needToShowMoveHistory2 : false, (1019 & 32) != 0 ? onboardingSettings.needToShowNotificationsSection : null, (1019 & 64) != 0 ? onboardingSettings.gorservOnboardingSettings : null, (1019 & 128) != 0 ? onboardingSettings.showBleFeedbackAt : null, (1019 & 256) != 0 ? onboardingSettings.needToShowGalleryOnboarding : false, (1019 & 512) != 0 ? onboardingSettings.needToShowArchiveInDevelopmentPopup : false));
    }

    public void lockMoveHistory() {
        this.prefManager.setOnboardingSettings(new OnboardingSettings(0L, 0L, 0L, false, false, null, null, null, false, false, 999, null));
        OnboardingViewState currentState = getCurrentState();
        Boolean bool = Boolean.FALSE;
        OnboardingViewState onboardingViewStateCopy$default = OnboardingViewState.copy$default(currentState, null, new Event(bool), new Event(bool), null, null, null, false, 121, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(onboardingViewStateCopy$default, this, null), 3, null);
        getState().setValue(onboardingViewStateCopy$default);
    }

    public final void dontShowGalleryOnboarding() {
        OnboardingViewState onboardingViewStateCopy$default = OnboardingViewState.copy$default(getCurrentState(), null, null, null, null, null, new Event(Boolean.FALSE), true, 31, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(onboardingViewStateCopy$default, this, null), 3, null);
        getState().setValue(onboardingViewStateCopy$default);
    }

    public final void delayBleFeedback() {
        PrefManager prefManager = this.prefManager;
        OnboardingSettings onboardingSettings = prefManager.getOnboardingSettings();
        Long showBleFeedbackAt = onboardingSettings.getShowBleFeedbackAt();
        if (showBleFeedbackAt != null && showBleFeedbackAt.longValue() == 0) {
            onboardingSettings.setShowBleFeedbackAt(Long.valueOf(System.currentTimeMillis() + 432000000));
        }
        prefManager.setOnboardingSettings(onboardingSettings);
    }

    public final void disableBleFeedback() {
        PrefManager prefManager = this.prefManager;
        OnboardingSettings onboardingSettings = prefManager.getOnboardingSettings();
        onboardingSettings.setShowBleFeedbackAt(Long.MAX_VALUE);
        prefManager.setOnboardingSettings(onboardingSettings);
    }

    public final void disableShowingArchiveInDevelopment() {
        PrefManager prefManager = this.prefManager;
        OnboardingSettings onboardingSettings = prefManager.getOnboardingSettings();
        onboardingSettings.setNeedToShowArchiveInDevelopmentPopup(false);
        prefManager.setOnboardingSettings(onboardingSettings);
    }
}
