package com.sputnik.oboarding.di;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sputnik.oboarding.ui.invites.InviteFragment;
import com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment;
import com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment;
import com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet;
import com.sputnik.oboarding.ui.onboarding.OnBoardingFragment;
import com.sputnik.oboarding.ui.onboarding.StoryFragment;
import com.sputnik.oboarding.ui.registration.AboutCodeFragment;
import com.sputnik.oboarding.ui.registration.ConfirmAddressFragment;
import com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment;
import com.sputnik.oboarding.ui.registration.CountryPickerFragment;
import com.sputnik.oboarding.ui.registration.DeleteAccountBottomSheet;
import com.sputnik.oboarding.ui.registration.EnterCodeFragment;
import com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment;
import com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment;
import com.sputnik.oboarding.ui.registration.EnterNameFragment;
import com.sputnik.oboarding.ui.registration.EnterPhoneFragment;
import com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment;
import com.sputnik.oboarding.ui.registration.EnterTelegramCodeFragment;
import com.sputnik.oboarding.ui.registration.LimitExceededFragment;
import com.sputnik.oboarding.ui.registration.NotMyAddressFragment;
import com.sputnik.oboarding.ui.registration.ReadyToConnectBottomSheet;
import com.sputnik.oboarding.ui.registration.SelectAccountFragment;
import com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment;
import com.sputnik.oboarding.ui.registration.StartRegistrationFragment;
import com.sputnik.oboarding.ui.registration.dialog.NoIntercomDialog;
import com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment;
import com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment;
import com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment;
import com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment;
import com.sputnik.oboarding.ui.splash.FinishSplashFragment;
import kotlin.Metadata;

/* compiled from: OnBoardingComponent.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001%J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0010H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0011H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0012H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0013H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0014H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0015H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0016H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0017H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0018H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0019H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u001aH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001cH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001dH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020 H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020!H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\"H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020#H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020$H&¨\u0006&"}, d2 = {"Lcom/sputnik/oboarding/di/OnBoardingComponent;", "", "inject", "", "fragment", "Lcom/sputnik/oboarding/ui/invites/InviteFragment;", "Lcom/sputnik/oboarding/ui/localization/ChooseRegLanguageFragment;", "Lcom/sputnik/oboarding/ui/localization/LoadingLanguageSplashFragment;", "bottomSheet", "Lcom/sputnik/oboarding/ui/localization/LocalizationStartBottomSheet;", "Lcom/sputnik/oboarding/ui/onboarding/OnBoardingFragment;", "Lcom/sputnik/oboarding/ui/onboarding/StoryFragment;", "Lcom/sputnik/oboarding/ui/registration/AboutCodeFragment;", "Lcom/sputnik/oboarding/ui/registration/ConfirmAddressFragment;", "Lcom/sputnik/oboarding/ui/registration/ConnectToIntercomFragment;", "Lcom/sputnik/oboarding/ui/registration/CountryPickerFragment;", "Lcom/sputnik/oboarding/ui/registration/DeleteAccountBottomSheet;", "Lcom/sputnik/oboarding/ui/registration/EnterCodeFragment;", "Lcom/sputnik/oboarding/ui/registration/EnterFlatNumberFragment;", "Lcom/sputnik/oboarding/ui/registration/EnterListenedCodeFragment;", "Lcom/sputnik/oboarding/ui/registration/EnterNameFragment;", "Lcom/sputnik/oboarding/ui/registration/EnterPhoneFragment;", "Lcom/sputnik/oboarding/ui/registration/EnterSmsCodeFragment;", "Lcom/sputnik/oboarding/ui/registration/EnterTelegramCodeFragment;", "Lcom/sputnik/oboarding/ui/registration/LimitExceededFragment;", "Lcom/sputnik/oboarding/ui/registration/NotMyAddressFragment;", "Lcom/sputnik/oboarding/ui/registration/ReadyToConnectBottomSheet;", "Lcom/sputnik/oboarding/ui/registration/SelectAccountFragment;", "Lcom/sputnik/oboarding/ui/registration/SomethingWentWrongFragment;", "Lcom/sputnik/oboarding/ui/registration/StartRegistrationFragment;", "dialog", "Lcom/sputnik/oboarding/ui/registration/dialog/NoIntercomDialog;", "Lcom/sputnik/oboarding/ui/registration/ways/support/NeedHelpFragment;", "Lcom/sputnik/oboarding/ui/registration/ways/userSms/SendUserSmsFragment;", "Lcom/sputnik/oboarding/ui/registration/ways/userSms/SendUserSmsFromOtherDeviceFragment;", "Lcom/sputnik/oboarding/ui/registration/ways/userSms/WaitingUserSmsFragment;", "Lcom/sputnik/oboarding/ui/splash/FinishSplashFragment;", "Builder", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OnBoardingComponent {

    /* compiled from: OnBoardingComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/sputnik/oboarding/di/OnBoardingComponent$Builder;", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/sputnik/oboarding/di/OnBoardingComponent;", "deps", "onBoardingDeps", "Lcom/sputnik/oboarding/di/OnBoardingDeps;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        OnBoardingComponent build();

        Builder deps(OnBoardingDeps onBoardingDeps);
    }

    void inject(InviteFragment fragment);

    void inject(ChooseRegLanguageFragment fragment);

    void inject(LoadingLanguageSplashFragment fragment);

    void inject(LocalizationStartBottomSheet bottomSheet);

    void inject(OnBoardingFragment fragment);

    void inject(StoryFragment fragment);

    void inject(AboutCodeFragment fragment);

    void inject(ConfirmAddressFragment fragment);

    void inject(ConnectToIntercomFragment fragment);

    void inject(CountryPickerFragment fragment);

    void inject(DeleteAccountBottomSheet bottomSheet);

    void inject(EnterCodeFragment fragment);

    void inject(EnterFlatNumberFragment fragment);

    void inject(EnterListenedCodeFragment fragment);

    void inject(EnterNameFragment fragment);

    void inject(EnterPhoneFragment fragment);

    void inject(EnterSmsCodeFragment fragment);

    void inject(EnterTelegramCodeFragment fragment);

    void inject(LimitExceededFragment fragment);

    void inject(NotMyAddressFragment fragment);

    void inject(ReadyToConnectBottomSheet bottomSheet);

    void inject(SelectAccountFragment fragment);

    void inject(SomethingWentWrongFragment fragment);

    void inject(StartRegistrationFragment fragment);

    void inject(NoIntercomDialog dialog);

    void inject(NeedHelpFragment fragment);

    void inject(SendUserSmsFragment fragment);

    void inject(SendUserSmsFromOtherDeviceFragment fragment);

    void inject(WaitingUserSmsFragment fragment);

    void inject(FinishSplashFragment fragment);
}
