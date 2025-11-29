package com.sputnik.common.viewmodels;

import android.app.Application;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.profile.DomainProfileToProfileMapper;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.profile.BindToFlatUseCase;
import com.sputnik.domain.usecases.profile.ChangeAvatarUseCase;
import com.sputnik.domain.usecases.profile.DeactivateAccountUseCase;
import com.sputnik.domain.usecases.profile.DeactivateAddressUseCase;
import com.sputnik.domain.usecases.profile.DeleteAccountUseCase;
import com.sputnik.domain.usecases.profile.DeleteFrUseCase;
import com.sputnik.domain.usecases.profile.GetProfileUseCase;
import com.sputnik.domain.usecases.profile.LogoutUseCase;
import com.sputnik.domain.usecases.profile.SendCallEnabledUseCase;
import com.sputnik.domain.usecases.profile.SendPushTokenUseCase;
import com.sputnik.domain.usecases.profile.SendTimezoneUseCase;
import com.sputnik.domain.usecases.profile.SetLocalizationUseCase;
import com.sputnik.domain.usecases.profile.UnlinkAddressUseCase;
import com.sputnik.domain.usecases.profile.VerifyAddressUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
    private final Provider<Analytics> analyticsProvider;
    private final Provider<Application> applicationProvider;
    private final Provider<BindToFlatUseCase> bindToFlatUseCaseProvider;
    private final Provider<ChangeAvatarUseCase> changeAvatarUseCaseProvider;
    private final Provider<IConfig> configProvider;
    private final Provider<DeactivateAccountUseCase> deactivateAccountUseCaseProvider;
    private final Provider<DeactivateAddressUseCase> deactivateAddressUseCaseProvider;
    private final Provider<DeleteAccountUseCase> deleteAccountUseCaseProvider;
    private final Provider<DeleteFrUseCase> deleteFrUseCaseProvider;
    private final Provider<DomainProfileToProfileMapper> domainProfileToProfileMapperProvider;
    private final Provider<GetProfileUseCase> getProfileUseCaseProvider;
    private final Provider<LocalizationStorage> localizationStorageProvider;
    private final Provider<LogoutUseCase> logoutUseCaseProvider;
    private final Provider<PrefManager> prefManagerProvider;
    private final Provider<SendCallEnabledUseCase> sendCallEnabledUseCaseProvider;
    private final Provider<SendPushTokenUseCase> sendPushTokenUseCaseProvider;
    private final Provider<SendTimezoneUseCase> sendTimezoneUseCaseProvider;
    private final Provider<SetLocalizationUseCase> setLocalizationUseCaseProvider;
    private final Provider<UnlinkAddressUseCase> unlinkAddressUseCaseProvider;
    private final Provider<VerifyAddressUseCase> verifyAddressUseCaseProvider;

    public ProfileViewModel_Factory(Provider<Application> provider, Provider<DeleteFrUseCase> provider2, Provider<SetLocalizationUseCase> provider3, Provider<ChangeAvatarUseCase> provider4, Provider<GetProfileUseCase> provider5, Provider<LogoutUseCase> provider6, Provider<DeleteAccountUseCase> provider7, Provider<VerifyAddressUseCase> provider8, Provider<DeactivateAddressUseCase> provider9, Provider<UnlinkAddressUseCase> provider10, Provider<DeactivateAccountUseCase> provider11, Provider<SendPushTokenUseCase> provider12, Provider<SendTimezoneUseCase> provider13, Provider<SendCallEnabledUseCase> provider14, Provider<BindToFlatUseCase> provider15, Provider<PrefManager> provider16, Provider<DomainProfileToProfileMapper> provider17, Provider<LocalizationStorage> provider18, Provider<IConfig> provider19, Provider<Analytics> provider20) {
        this.applicationProvider = provider;
        this.deleteFrUseCaseProvider = provider2;
        this.setLocalizationUseCaseProvider = provider3;
        this.changeAvatarUseCaseProvider = provider4;
        this.getProfileUseCaseProvider = provider5;
        this.logoutUseCaseProvider = provider6;
        this.deleteAccountUseCaseProvider = provider7;
        this.verifyAddressUseCaseProvider = provider8;
        this.deactivateAddressUseCaseProvider = provider9;
        this.unlinkAddressUseCaseProvider = provider10;
        this.deactivateAccountUseCaseProvider = provider11;
        this.sendPushTokenUseCaseProvider = provider12;
        this.sendTimezoneUseCaseProvider = provider13;
        this.sendCallEnabledUseCaseProvider = provider14;
        this.bindToFlatUseCaseProvider = provider15;
        this.prefManagerProvider = provider16;
        this.domainProfileToProfileMapperProvider = provider17;
        this.localizationStorageProvider = provider18;
        this.configProvider = provider19;
        this.analyticsProvider = provider20;
    }

    @Override // javax.inject.Provider
    public ProfileViewModel get() {
        return newInstance(this.applicationProvider.get(), this.deleteFrUseCaseProvider.get(), this.setLocalizationUseCaseProvider.get(), this.changeAvatarUseCaseProvider.get(), this.getProfileUseCaseProvider.get(), this.logoutUseCaseProvider.get(), this.deleteAccountUseCaseProvider.get(), this.verifyAddressUseCaseProvider.get(), this.deactivateAddressUseCaseProvider.get(), this.unlinkAddressUseCaseProvider.get(), this.deactivateAccountUseCaseProvider.get(), this.sendPushTokenUseCaseProvider.get(), this.sendTimezoneUseCaseProvider.get(), this.sendCallEnabledUseCaseProvider.get(), this.bindToFlatUseCaseProvider.get(), this.prefManagerProvider.get(), this.domainProfileToProfileMapperProvider.get(), this.localizationStorageProvider.get(), this.configProvider.get(), this.analyticsProvider.get());
    }

    public static ProfileViewModel_Factory create(Provider<Application> provider, Provider<DeleteFrUseCase> provider2, Provider<SetLocalizationUseCase> provider3, Provider<ChangeAvatarUseCase> provider4, Provider<GetProfileUseCase> provider5, Provider<LogoutUseCase> provider6, Provider<DeleteAccountUseCase> provider7, Provider<VerifyAddressUseCase> provider8, Provider<DeactivateAddressUseCase> provider9, Provider<UnlinkAddressUseCase> provider10, Provider<DeactivateAccountUseCase> provider11, Provider<SendPushTokenUseCase> provider12, Provider<SendTimezoneUseCase> provider13, Provider<SendCallEnabledUseCase> provider14, Provider<BindToFlatUseCase> provider15, Provider<PrefManager> provider16, Provider<DomainProfileToProfileMapper> provider17, Provider<LocalizationStorage> provider18, Provider<IConfig> provider19, Provider<Analytics> provider20) {
        return new ProfileViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20);
    }

    public static ProfileViewModel newInstance(Application application, DeleteFrUseCase deleteFrUseCase, SetLocalizationUseCase setLocalizationUseCase, ChangeAvatarUseCase changeAvatarUseCase, GetProfileUseCase getProfileUseCase, LogoutUseCase logoutUseCase, DeleteAccountUseCase deleteAccountUseCase, VerifyAddressUseCase verifyAddressUseCase, DeactivateAddressUseCase deactivateAddressUseCase, UnlinkAddressUseCase unlinkAddressUseCase, DeactivateAccountUseCase deactivateAccountUseCase, SendPushTokenUseCase sendPushTokenUseCase, SendTimezoneUseCase sendTimezoneUseCase, SendCallEnabledUseCase sendCallEnabledUseCase, BindToFlatUseCase bindToFlatUseCase, PrefManager prefManager, DomainProfileToProfileMapper domainProfileToProfileMapper, LocalizationStorage localizationStorage, IConfig iConfig, Analytics analytics) {
        return new ProfileViewModel(application, deleteFrUseCase, setLocalizationUseCase, changeAvatarUseCase, getProfileUseCase, logoutUseCase, deleteAccountUseCase, verifyAddressUseCase, deactivateAddressUseCase, unlinkAddressUseCase, deactivateAccountUseCase, sendPushTokenUseCase, sendTimezoneUseCase, sendCallEnabledUseCase, bindToFlatUseCase, prefManager, domainProfileToProfileMapper, localizationStorage, iConfig, analytics);
    }
}
