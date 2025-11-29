package com.sputnik.oboarding.di;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment_MembersInjector;
import com.sputnik.common.di.mappers.DomainCommonListMapperModule;
import com.sputnik.common.di.mappers.DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory;
import com.sputnik.common.di.mappers.DomainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactory;
import com.sputnik.common.di.mappers.DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory;
import com.sputnik.common.di.mappers.DomainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactory;
import com.sputnik.common.di.mappers.OnBoardingListMapperModule;
import com.sputnik.common.di.mappers.OnBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactory;
import com.sputnik.common.di.mappers.OnBoardingListMapperModule_ProvideDomainStoryToStoryFactory;
import com.sputnik.common.di.use_cases.alerts.AlertsUseCaseModule;
import com.sputnik.common.di.use_cases.alerts.AlertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactory;
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule;
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule_ProvideGetAllCamerasUseCaseFactory;
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule_ProvideGetCamerasDemoUseCaseFactory;
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule_ProvideOpenDoorUseCaseFactory;
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule_ProvideOpenSecondDoorUseCaseFactory;
import com.sputnik.common.di.use_cases.invites.AcceptInviteUseCase;
import com.sputnik.common.di.use_cases.invites.DeclineInviteUseCase;
import com.sputnik.common.di.use_cases.invites.DeleteFamilyInviteUseCase;
import com.sputnik.common.di.use_cases.invites.GetFamilyInvitesUseCase;
import com.sputnik.common.di.use_cases.invites.GetInvitesUseCase;
import com.sputnik.common.di.use_cases.invites.InvitesUseCaseModule;
import com.sputnik.common.di.use_cases.invites.InvitesUseCaseModule_ProvideAcceptInviteUseCaseFactory;
import com.sputnik.common.di.use_cases.invites.InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory;
import com.sputnik.common.di.use_cases.invites.InvitesUseCaseModule_ProvideDeleteFamilyInviteUseCaseFactory;
import com.sputnik.common.di.use_cases.invites.InvitesUseCaseModule_ProvideGetFamilyInvitesUseCaseFactory;
import com.sputnik.common.di.use_cases.invites.InvitesUseCaseModule_ProvideGetInvitesUseCaseFactory;
import com.sputnik.common.di.use_cases.invites.InvitesUseCaseModule_ProvideResendFamilyInviteUseCaseFactory;
import com.sputnik.common.di.use_cases.invites.InvitesUseCaseModule_ProvideSendFamilyInviteUseCaseFactory;
import com.sputnik.common.di.use_cases.invites.ResendFamilyInviteUseCase;
import com.sputnik.common.di.use_cases.invites.SendFamilyInviteUseCase;
import com.sputnik.common.di.use_cases.keys.BlockPhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.CreatePhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.DeletePhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.GetPhysicalKeysUseCase;
import com.sputnik.common.di.use_cases.keys.PhysicalKeysUseCaseModule;
import com.sputnik.common.di.use_cases.keys.PhysicalKeysUseCaseModule_ProvideBlockPhysicalKeyUseCaseFactory;
import com.sputnik.common.di.use_cases.keys.PhysicalKeysUseCaseModule_ProvideCreatePhysicalKeyUseCaseFactory;
import com.sputnik.common.di.use_cases.keys.PhysicalKeysUseCaseModule_ProvideDeletePhysicalKeyUseCaseFactory;
import com.sputnik.common.di.use_cases.keys.PhysicalKeysUseCaseModule_ProvideGetPhysicalKeysUseCaseFactory;
import com.sputnik.common.di.use_cases.keys.PhysicalKeysUseCaseModule_ProvideUnblockPhysicalKeyUseCaseFactory;
import com.sputnik.common.di.use_cases.keys.PhysicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactory;
import com.sputnik.common.di.use_cases.keys.UnblockPhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.UpdatePhysicalKeyCommentUseCase;
import com.sputnik.common.di.use_cases.popups.PopupStoriesUseCaseModule;
import com.sputnik.common.di.use_cases.popups.PopupStoriesUseCaseModule_ProvideGetPopupStoriesUseCaseFactory;
import com.sputnik.common.di.use_cases.popups.PopupStoriesUseCaseModule_ProvideSendPopupStoriesUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideBindToFlatUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideChangeAvatarUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideDeactivateAccountUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideDeactivateAddressUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideDeleteAccountUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideDeleteFrUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideGetProfileUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideLogoutUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideSendCallEnabledUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideSendPushTokenUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideSendTimezoneUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideSetLocalizationUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideUnlinkAddressUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideUpdateUseNameUseCaseFactory;
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideVerifyAddressUseCaseFactory;
import com.sputnik.common.di.use_cases.single_use_cases.CountryCodeUseCaseModule;
import com.sputnik.common.di.use_cases.single_use_cases.CountryCodeUseCaseModule_ProvideGetCountryCodeUseCaseFactory;
import com.sputnik.common.di.use_cases.single_use_cases.LocalizationUseCaseModule;
import com.sputnik.common.di.use_cases.single_use_cases.LocalizationUseCaseModule_ProvideGetLocalizationUseCaseFactory;
import com.sputnik.common.di.use_cases.stories.StoriesUseCaseModule;
import com.sputnik.common.di.use_cases.stories.StoriesUseCaseModule_ProvideGetOnboardingStoriesUseCaseFactory;
import com.sputnik.common.di.use_cases.stories.StoriesUseCaseModule_ProvideGetStoriesUseCaseFactory;
import com.sputnik.common.di.use_cases.subscriptions.SubscriptionsUseCaseModule;
import com.sputnik.common.di.use_cases.subscriptions.SubscriptionsUseCaseModule_ProvideGetMarketV2UseCaseFactory;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.entities.stories.StoryButton;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.alerts.DomainAlertToAlertMapper_Factory;
import com.sputnik.common.mappers.archive.DomainFlussonicToFlussonicMapper_Factory;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper_Factory;
import com.sputnik.common.mappers.country_code.DomainCountryCodeToCountryCodeMapper_Factory;
import com.sputnik.common.mappers.invites.DomainFamilyInvitesToFamilyInvitesMapper_Factory;
import com.sputnik.common.mappers.invites.DomainInviteToInviteMapper_Factory;
import com.sputnik.common.mappers.keys.DomainPhysicalKeyToPhysicalKeyMapper_Factory;
import com.sputnik.common.mappers.localization.DomainLocalizationToLocalizationMapper_Factory;
import com.sputnik.common.mappers.popup.DomainPopupStoriesToPopupStoriesMapper_Factory;
import com.sputnik.common.mappers.profile.DomainProfileCardInfoToProfileCardInfoMapper_Factory;
import com.sputnik.common.mappers.profile.DomainProfileToProfileMapper;
import com.sputnik.common.mappers.profile.DomainProfileToProfileMapper_Factory;
import com.sputnik.common.mappers.stories.DomainStoryButtonToStoryButtonMapper_Factory;
import com.sputnik.common.mappers.stories.DomainStoryToStoryMapper;
import com.sputnik.common.mappers.stories.DomainStoryToStoryMapper_Factory;
import com.sputnik.common.mappers.subscriptions.DomainBaseAppearanceToBaseAppearanceMapper_Factory;
import com.sputnik.common.mappers.subscriptions.DomainBaseSubscriptionToBaseSubscriptionMapper;
import com.sputnik.common.mappers.subscriptions.DomainBaseSubscriptionToBaseSubscriptionMapper_Factory;
import com.sputnik.common.mappers.subscriptions.DomainMarketItemToMarketItemMapper_Factory;
import com.sputnik.common.mappers.subscriptions.DomainOuterServiceAppearanceToOuterServiceAppearanceMapper_Factory;
import com.sputnik.common.mappers.subscriptions.DomainOuterServiceToOuterServiceMapper;
import com.sputnik.common.mappers.subscriptions.DomainOuterServiceToOuterServiceMapper_Factory;
import com.sputnik.common.support.SupportManager;
import com.sputnik.common.viewmodels.AlertsViewModel;
import com.sputnik.common.viewmodels.AlertsViewModel_Factory;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewModel_Factory_AssistFactory_Impl;
import com.sputnik.common.viewmodels.AllCamerasViewModel_Factory_Factory;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.CallCodeViewModel_Factory_AssistFactory_Impl;
import com.sputnik.common.viewmodels.CallCodeViewModel_Factory_Factory;
import com.sputnik.common.viewmodels.InstructionsViewModel;
import com.sputnik.common.viewmodels.InstructionsViewModel_Factory;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.InvitesViewModel_Factory;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.KeysViewModel_Factory;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewModel_Factory;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.LoginViewModel_Factory;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.MultiViewModelFactory_Factory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NavigationViewModel_Factory;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.common.viewmodels.OnboardingViewModel_Factory;
import com.sputnik.common.viewmodels.PopupStoriesViewModel;
import com.sputnik.common.viewmodels.PopupStoriesViewModel_Factory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel_Factory;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.common.viewmodels.SettingsProfileViewModel_Factory_AssistFactory_Impl;
import com.sputnik.common.viewmodels.SettingsProfileViewModel_Factory_Factory;
import com.sputnik.common.viewmodels.StateViewModel;
import com.sputnik.common.viewmodels.StateViewModel_Factory;
import com.sputnik.common.viewmodels.StoriesViewModel;
import com.sputnik.common.viewmodels.StoriesViewModel_Factory;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel_Factory;
import com.sputnik.data.IConfig;
import com.sputnik.data.api.AlertsApi;
import com.sputnik.data.api.AuthApi;
import com.sputnik.data.api.CamerasApi;
import com.sputnik.data.api.ConnectIntercomApi;
import com.sputnik.data.api.InvitesApi;
import com.sputnik.data.api.LocalizationApi;
import com.sputnik.data.api.MarketApi;
import com.sputnik.data.api.PhysicalKeysApi;
import com.sputnik.data.api.PopupStoriesApi;
import com.sputnik.data.api.ProfileApi;
import com.sputnik.data.api.StoriesApi;
import com.sputnik.data.di.modules.ListMappersModule;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataAlertToDomainAlertFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataCameraToDomainCameraFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataInviteToDomainInviteFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataMarketItemToDomainMarketItemMapperFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataMarketToDomainMarketFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataOuterServiceToDomainOuterServiceMapperFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataServiceToDomainServiceFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataStoryToDomainStoryFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory;
import com.sputnik.data.di.modules.NetworkModule;
import com.sputnik.data.di.modules.NetworkModule_ProvideAlertsApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideAuthApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideBaseOkHttpFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideBaseProdRetrofitFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideCamerasApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideConnectIntercomApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideInvitesApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideLocalizationApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideMarketApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideOkHttpFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideOkHttpNoJwtFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvidePhysicalKeysApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvidePopupStoriesApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideProdRetrofitFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideProfileApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideStoriesApiFactory;
import com.sputnik.data.entities.alerts.DataAlert;
import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.data.entities.country_code.DataCountryCode;
import com.sputnik.data.entities.invites.DataInvite;
import com.sputnik.data.entities.localization.DataLocalization;
import com.sputnik.data.entities.market.DataMarket;
import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.data.entities.market.DataSubsPlans;
import com.sputnik.data.entities.market.service.DataService;
import com.sputnik.data.entities.market.subscription.DataSubscription;
import com.sputnik.data.entities.popups.DataPopupStoryStructure;
import com.sputnik.data.entities.stories.DataStoriesButton;
import com.sputnik.data.entities.stories.DataStory;
import com.sputnik.data.entities.subscriptions.items.DataMarketItem;
import com.sputnik.data.entities.subscriptions.services.DataOuterService;
import com.sputnik.data.entities.subscriptions.subscriptions.DataBaseSubscription;
import com.sputnik.data.local.PrefManager;
import com.sputnik.data.mappers.alerts.DataAlertToDomainAlertMapper_Factory;
import com.sputnik.data.mappers.auth.DataApplyRegistrationToDomainApplyRegistrationMapper_Factory;
import com.sputnik.data.mappers.auth.DataConfirmRegistrationToDomainConfirmRegistrationMapper_Factory;
import com.sputnik.data.mappers.auth.DataConfirmToDomainConfirmMapper_Factory;
import com.sputnik.data.mappers.auth.DataPhoneRequestToDomainPhoneRequestMapper_Factory;
import com.sputnik.data.mappers.auth.DataRequestInfoToDomainRequestInfoMapper_Factory;
import com.sputnik.data.mappers.cameras.DataCameraToDomainCameraMapper_Factory;
import com.sputnik.data.mappers.connect_intercom.DataActivationCodeToDomainActivationCodeMapper_Factory;
import com.sputnik.data.mappers.country_code.DataCountryCodeToDomainCountryCodeMapper_Factory;
import com.sputnik.data.mappers.entry.DataEntryToDomainEntryMapper_Factory;
import com.sputnik.data.mappers.invites.DataFamilyInvitesToDomainFamilyInvitesMapper_Factory;
import com.sputnik.data.mappers.invites.DataInviteToDomainInviteMapper_Factory;
import com.sputnik.data.mappers.keys.DataPhysicalKeyToDomainPhysicalKeyMapper_Factory;
import com.sputnik.data.mappers.localization.DataLocalizationToDomainLocalizationMapper_Factory;
import com.sputnik.data.mappers.market.DataAppearancePlansToDomainAppearancePlansMapper;
import com.sputnik.data.mappers.market.DataAppearancePlansToDomainAppearancePlansMapper_Factory;
import com.sputnik.data.mappers.market.DataDetailedLayoutToDomainDetailedLayoutMapper;
import com.sputnik.data.mappers.market.DataDetailedLayoutToDomainDetailedLayoutMapper_Factory;
import com.sputnik.data.mappers.market.DataIncludedServiceToDomainIncludedServiceMapper;
import com.sputnik.data.mappers.market.DataIncludedServiceToDomainIncludedServiceMapper_Factory;
import com.sputnik.data.mappers.market.DataMarketToDomainMarketMapper;
import com.sputnik.data.mappers.market.DataMarketToDomainMarketMapper_Factory;
import com.sputnik.data.mappers.market.DataOriginSubToDomainOriginSubMapper_Factory;
import com.sputnik.data.mappers.market.DataPlanAppearanceToDomainPlanAppearanceMapper_Factory;
import com.sputnik.data.mappers.market.DataPlansToDomainPlansMapper;
import com.sputnik.data.mappers.market.DataPlansToDomainPlansMapper_Factory;
import com.sputnik.data.mappers.market.DataServiceAppearanceToDomainServiceAppearanceMapper_Factory;
import com.sputnik.data.mappers.market.DataServiceToDomainServiceMapper;
import com.sputnik.data.mappers.market.DataServiceToDomainServiceMapper_Factory;
import com.sputnik.data.mappers.market.DataSmallServiceToDomainSmallServiceMapper_Factory;
import com.sputnik.data.mappers.market.DataSubsPlansToDomainSubsPlansMapper_Factory;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper_Factory;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionDetailsToDomainSubscriptionDetailsMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionDetailsToDomainSubscriptionDetailsMapper_Factory;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionToDomainSubscriptionMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionToDomainSubscriptionMapper_Factory;
import com.sputnik.data.mappers.popups.DataPopupStoryToDomainPopupStoryMapper_Factory;
import com.sputnik.data.mappers.profile.DataProfileCardInfoToDomainProfileCardInfoMapper_Factory;
import com.sputnik.data.mappers.profile.DataProfileToDomainProfileMapper;
import com.sputnik.data.mappers.profile.DataProfileToDomainProfileMapper_Factory;
import com.sputnik.data.mappers.stories.DataStoriesButtonToDomainStoriesButtonMapper_Factory;
import com.sputnik.data.mappers.stories.DataStoryToDomainStoryMapper;
import com.sputnik.data.mappers.stories.DataStoryToDomainStoryMapper_Factory;
import com.sputnik.data.mappers.subscriptions.DataBaseAppearanceToDomainAppearanceMapper_Factory;
import com.sputnik.data.mappers.subscriptions.DataBaseSubscriptionToDomainBaseSubscriptionMapper;
import com.sputnik.data.mappers.subscriptions.DataBaseSubscriptionToDomainBaseSubscriptionMapper_Factory;
import com.sputnik.data.mappers.subscriptions.DataMarketItemToDomainMarketItemMapper_Factory;
import com.sputnik.data.mappers.subscriptions.DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper_Factory;
import com.sputnik.data.mappers.subscriptions.DataOuterServiceToDomainOuterServiceMapper;
import com.sputnik.data.mappers.subscriptions.DataOuterServiceToDomainOuterServiceMapper_Factory;
import com.sputnik.data.repositories.alerts.AlertsRepository;
import com.sputnik.data.repositories.alerts.AlertsRepository_Factory;
import com.sputnik.data.repositories.auth.AuthRepository;
import com.sputnik.data.repositories.auth.AuthRepository_Factory;
import com.sputnik.data.repositories.cameras.CamerasRepository;
import com.sputnik.data.repositories.cameras.CamerasRepository_Factory;
import com.sputnik.data.repositories.country_code.CountryCodeRepository;
import com.sputnik.data.repositories.country_code.CountryCodeRepository_Factory;
import com.sputnik.data.repositories.country_code.CountryCodeSource_Factory;
import com.sputnik.data.repositories.invites.InvitesRepository;
import com.sputnik.data.repositories.invites.InvitesRepository_Factory;
import com.sputnik.data.repositories.keys.PhysicalKeysRepository;
import com.sputnik.data.repositories.keys.PhysicalKeysRepository_Factory;
import com.sputnik.data.repositories.localization.LocalizationRepository;
import com.sputnik.data.repositories.localization.LocalizationRepository_Factory;
import com.sputnik.data.repositories.market.MarketRepository;
import com.sputnik.data.repositories.market.MarketRepository_Factory;
import com.sputnik.data.repositories.popups.PopupStoriesRepository;
import com.sputnik.data.repositories.popups.PopupStoriesRepository_Factory;
import com.sputnik.data.repositories.profile.ProfileRepository;
import com.sputnik.data.repositories.profile.ProfileRepository_Factory;
import com.sputnik.data.repositories.registration.ConnectIntercomRepository;
import com.sputnik.data.repositories.registration.ConnectIntercomRepository_Factory;
import com.sputnik.data.repositories.stories.StoriesRepository;
import com.sputnik.data.repositories.stories.StoriesRepository_Factory;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.alers.DomainAlert;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import com.sputnik.domain.entities.invites.DomainInvite;
import com.sputnik.domain.entities.localization.DomainLocalization;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.DomainSubsPlans;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import com.sputnik.domain.entities.stories.DomainStory;
import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import com.sputnik.domain.entities.subscriptions.services.DomainOuterService;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import com.sputnik.domain.usecases.alerts.GetAlertsUseCase;
import com.sputnik.domain.usecases.auth.ApplyRegistrationUseCase;
import com.sputnik.domain.usecases.auth.ConfirmCodeUseCase;
import com.sputnik.domain.usecases.auth.ConfirmRegistrationUseCase;
import com.sputnik.domain.usecases.auth.GetRequestUseCase;
import com.sputnik.domain.usecases.auth.RegisterUserByPhoneUseCase;
import com.sputnik.domain.usecases.cameras.GetAllCamerasUseCase;
import com.sputnik.domain.usecases.cameras.GetCamerasDemoUseCase;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import com.sputnik.domain.usecases.cameras.OpenSecondDoorUseCase;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
import com.sputnik.domain.usecases.entry.GetEntryUseCase;
import com.sputnik.domain.usecases.localization.GetLocalizationUseCase;
import com.sputnik.domain.usecases.market.GetMarketV2UseCase;
import com.sputnik.domain.usecases.popups.GetPopupStoriesUseCase;
import com.sputnik.domain.usecases.popups.SendPopupStoriesActionUseCase;
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
import com.sputnik.domain.usecases.profile.UpdateUseNameUseCase;
import com.sputnik.domain.usecases.profile.VerifyAddressUseCase;
import com.sputnik.domain.usecases.registration.GetIntercomCodeForRegUseCase;
import com.sputnik.domain.usecases.stories.GetOnBoardingStoriesUseCase;
import com.sputnik.domain.usecases.stories.GetStoriesUseCase;
import com.sputnik.oboarding.di.OnBoardingComponent;
import com.sputnik.oboarding.di.use_cases.auth.AuthUseCaseModule;
import com.sputnik.oboarding.di.use_cases.auth.AuthUseCaseModule_ProvideApplyRegistrationUseCaseFactory;
import com.sputnik.oboarding.di.use_cases.auth.AuthUseCaseModule_ProvideConfirmCodeUseCaseFactory;
import com.sputnik.oboarding.di.use_cases.auth.AuthUseCaseModule_ProvideConfirmRegistrationUseCaseFactory;
import com.sputnik.oboarding.di.use_cases.auth.AuthUseCaseModule_ProvideGetRequestUseCaseFactory;
import com.sputnik.oboarding.di.use_cases.auth.AuthUseCaseModule_ProvideRegisterUserByPhoneUseCaseFactory;
import com.sputnik.oboarding.di.use_cases.connect_intercom.ConnectIntercomUseCaseModule;
import com.sputnik.oboarding.di.use_cases.connect_intercom.ConnectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory;
import com.sputnik.oboarding.di.use_cases.entry.EntryUseCaseModule;
import com.sputnik.oboarding.di.use_cases.entry.EntryUseCaseModule_ProvideGetEntryUseCaseFactory;
import com.sputnik.oboarding.mappers.connect_intercom.DomainActivationCodeToActivationCodeMapper_Factory;
import com.sputnik.oboarding.mappers.entry.DomainEntryToEntryMapper_Factory;
import com.sputnik.oboarding.ui.invites.InviteFragment;
import com.sputnik.oboarding.ui.invites.InviteFragment_MembersInjector;
import com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment;
import com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment_MembersInjector;
import com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment;
import com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment_MembersInjector;
import com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet;
import com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet_MembersInjector;
import com.sputnik.oboarding.ui.onboarding.OnBoardingFragment;
import com.sputnik.oboarding.ui.onboarding.OnBoardingFragment_MembersInjector;
import com.sputnik.oboarding.ui.onboarding.StoryFragment;
import com.sputnik.oboarding.ui.onboarding.StoryFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.AboutCodeFragment;
import com.sputnik.oboarding.ui.registration.AboutCodeFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.ConfirmAddressFragment;
import com.sputnik.oboarding.ui.registration.ConfirmAddressFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment;
import com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.CountryPickerFragment;
import com.sputnik.oboarding.ui.registration.CountryPickerFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.DeleteAccountBottomSheet;
import com.sputnik.oboarding.ui.registration.DeleteAccountBottomSheet_MembersInjector;
import com.sputnik.oboarding.ui.registration.EnterCodeFragment;
import com.sputnik.oboarding.ui.registration.EnterCodeFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment;
import com.sputnik.oboarding.ui.registration.EnterFlatNumberFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment;
import com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.EnterNameFragment;
import com.sputnik.oboarding.ui.registration.EnterNameFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.EnterPhoneFragment;
import com.sputnik.oboarding.ui.registration.EnterPhoneFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment;
import com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.EnterTelegramCodeFragment;
import com.sputnik.oboarding.ui.registration.EnterTelegramCodeFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.LimitExceededFragment;
import com.sputnik.oboarding.ui.registration.LimitExceededFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.NotMyAddressFragment;
import com.sputnik.oboarding.ui.registration.NotMyAddressFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.ReadyToConnectBottomSheet;
import com.sputnik.oboarding.ui.registration.ReadyToConnectBottomSheet_MembersInjector;
import com.sputnik.oboarding.ui.registration.SelectAccountFragment;
import com.sputnik.oboarding.ui.registration.SelectAccountFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment;
import com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.StartRegistrationFragment;
import com.sputnik.oboarding.ui.registration.StartRegistrationFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.dialog.NoIntercomDialog;
import com.sputnik.oboarding.ui.registration.dialog.NoIntercomDialog_MembersInjector;
import com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel;
import com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel_Factory;
import com.sputnik.oboarding.ui.registration.viewmodel.EntryViewModel;
import com.sputnik.oboarding.ui.registration.viewmodel.EntryViewModel_Factory;
import com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment;
import com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment;
import com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment;
import com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment_MembersInjector;
import com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment;
import com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment_MembersInjector;
import com.sputnik.oboarding.ui.splash.FinishSplashFragment;
import com.sputnik.oboarding.ui.splash.FinishSplashFragment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class DaggerOnBoardingComponent {
    public static OnBoardingComponent.Builder builder() {
        return new Builder();
    }

    private static final class Builder implements OnBoardingComponent.Builder {
        private OnBoardingDeps onBoardingDeps;

        private Builder() {
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent.Builder
        public Builder deps(OnBoardingDeps onBoardingDeps) {
            this.onBoardingDeps = (OnBoardingDeps) Preconditions.checkNotNull(onBoardingDeps);
            return this;
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent.Builder
        public OnBoardingComponent build() {
            Preconditions.checkBuilderRequirement(this.onBoardingDeps, OnBoardingDeps.class);
            return new OnBoardingComponentImpl(new ConnectIntercomUseCaseModule(), new AuthUseCaseModule(), new EntryUseCaseModule(), new NetworkModule(), new ListMappersModule(), new DomainCommonListMapperModule(), new OnBoardingListMapperModule(), new LocalizationUseCaseModule(), new CountryCodeUseCaseModule(), new CamerasUseCaseModule(), new ProfileUseCaseModule(), new AlertsUseCaseModule(), new StoriesUseCaseModule(), new PopupStoriesUseCaseModule(), new InvitesUseCaseModule(), new SubscriptionsUseCaseModule(), new PhysicalKeysUseCaseModule(), this.onBoardingDeps);
        }
    }

    private static final class OnBoardingComponentImpl implements OnBoardingComponent {
        private Provider<AlertsRepository> alertsRepositoryProvider;
        private Provider<AlertsViewModel> alertsViewModelProvider;
        private Provider<AllCamerasViewModel.Factory.AssistFactory> assistFactoryProvider;
        private Provider<CallCodeViewModel.Factory.AssistFactory> assistFactoryProvider2;
        private Provider<SettingsProfileViewModel.Factory.AssistFactory> assistFactoryProvider3;
        private Provider<AuthRepository> authRepositoryProvider;
        private Provider<CamerasRepository> camerasRepositoryProvider;
        private Provider<ConnectIntercomRepository> connectIntercomRepositoryProvider;
        private Provider<ConnectIntercomViewModel> connectIntercomViewModelProvider;
        private Provider<CountryCodeRepository> countryCodeRepositoryProvider;
        private Provider<DataAppearancePlansToDomainAppearancePlansMapper> dataAppearancePlansToDomainAppearancePlansMapperProvider;
        private Provider<DataBaseSubscriptionToDomainBaseSubscriptionMapper> dataBaseSubscriptionToDomainBaseSubscriptionMapperProvider;
        private Provider<DataDetailedLayoutToDomainDetailedLayoutMapper> dataDetailedLayoutToDomainDetailedLayoutMapperProvider;
        private Provider<DataIncludedServiceToDomainIncludedServiceMapper> dataIncludedServiceToDomainIncludedServiceMapperProvider;
        private Provider<DataMarketToDomainMarketMapper> dataMarketToDomainMarketMapperProvider;
        private Provider<DataOuterServiceToDomainOuterServiceMapper> dataOuterServiceToDomainOuterServiceMapperProvider;
        private Provider<DataPlansToDomainPlansMapper> dataPlansToDomainPlansMapperProvider;
        private Provider<DataProfileToDomainProfileMapper> dataProfileToDomainProfileMapperProvider;
        private Provider<DataServiceToDomainServiceMapper> dataServiceToDomainServiceMapperProvider;
        private Provider<DataStoryToDomainStoryMapper> dataStoryToDomainStoryMapperProvider;
        private Provider<DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper> dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider;
        private Provider<DataSubscriptionDetailsToDomainSubscriptionDetailsMapper> dataSubscriptionDetailsToDomainSubscriptionDetailsMapperProvider;
        private Provider<DataSubscriptionToDomainSubscriptionMapper> dataSubscriptionToDomainSubscriptionMapperProvider;
        private Provider<DomainBaseSubscriptionToBaseSubscriptionMapper> domainBaseSubscriptionToBaseSubscriptionMapperProvider;
        private Provider<DomainCameraToCameraMapper> domainCameraToCameraMapperProvider;
        private Provider<DomainOuterServiceToOuterServiceMapper> domainOuterServiceToOuterServiceMapperProvider;
        private Provider<DomainProfileToProfileMapper> domainProfileToProfileMapperProvider;
        private Provider<DomainStoryToStoryMapper> domainStoryToStoryMapperProvider;
        private Provider<EntryViewModel> entryViewModelProvider;
        private AllCamerasViewModel_Factory_Factory factoryProvider;
        private CallCodeViewModel_Factory_Factory factoryProvider2;
        private SettingsProfileViewModel_Factory_Factory factoryProvider3;
        private Provider<Analytics> getAnalyticsProvider;
        private Provider<Application> getApplicationProvider;
        private Provider<IConfig> getConfigProvider;
        private Provider<LocalizationStorage> getLocalizationStorageProvider;
        private Provider<PrefManager> getPrefManagerProvider;
        private Provider<InstructionsViewModel> instructionsViewModelProvider;
        private Provider<InvitesRepository> invitesRepositoryProvider;
        private Provider<InvitesViewModel> invitesViewModelProvider;
        private Provider<KeysViewModel> keysViewModelProvider;
        private Provider<LocalizationRepository> localizationRepositoryProvider;
        private Provider<LocalizationViewModel> localizationViewModelProvider;
        private Provider<LoginViewModel> loginViewModelProvider;
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
        private Provider<MarketRepository> marketRepositoryProvider;
        private Provider<MultiViewModelFactory> multiViewModelFactoryProvider;
        private final OnBoardingComponentImpl onBoardingComponentImpl;
        private final OnBoardingDeps onBoardingDeps;
        private Provider<OnboardingViewModel> onboardingViewModelProvider;
        private Provider<PhysicalKeysRepository> physicalKeysRepositoryProvider;
        private Provider<PopupStoriesRepository> popupStoriesRepositoryProvider;
        private Provider<PopupStoriesViewModel> popupStoriesViewModelProvider;
        private Provider<ProfileRepository> profileRepositoryProvider;
        private Provider<ProfileViewModel> profileViewModelProvider;
        private Provider<AcceptInviteUseCase> provideAcceptInviteUseCaseProvider;
        private Provider<AlertsApi> provideAlertsApiProvider;
        private Provider<ApplyRegistrationUseCase> provideApplyRegistrationUseCaseProvider;
        private Provider<AuthApi> provideAuthApiProvider;
        private Provider<OkHttpClient.Builder> provideBaseOkHttpProvider;
        private Provider<Retrofit> provideBaseProdRetrofitProvider;
        private Provider<BindToFlatUseCase> provideBindToFlatUseCaseProvider;
        private Provider<BlockPhysicalKeyUseCase> provideBlockPhysicalKeyUseCaseProvider;
        private Provider<CamerasApi> provideCamerasApiProvider;
        private Provider<ChangeAvatarUseCase> provideChangeAvatarUseCaseProvider;
        private Provider<ConfirmCodeUseCase> provideConfirmCodeUseCaseProvider;
        private Provider<ConfirmRegistrationUseCase> provideConfirmRegistrationUseCaseProvider;
        private Provider<ConnectIntercomApi> provideConnectIntercomApiProvider;
        private Provider<CreatePhysicalKeyUseCase> provideCreatePhysicalKeyUseCaseProvider;
        private Provider<ListMapper<DataAlert, DomainAlert>> provideDataAlertToDomainAlertProvider;
        private Provider<NullableInputListMapper<DataCamera, DomainCamera>> provideDataCameraToDomainCameraProvider;
        private Provider<ListMapper<DataCountryCode, DomainCountryCode>> provideDataCountryCodeToDomainCountryCodeProvider;
        private Provider<ListMapper<DataInvite, DomainInvite>> provideDataInviteToDomainInviteProvider;
        private Provider<ListMapper<DataLocalization, DomainLocalization>> provideDataLocalizationToDomainLocalizationProvider;
        private Provider<ListMapper<DataMarketItem, DomainMarketItem>> provideDataMarketItemToDomainMarketItemMapperProvider;
        private Provider<ListMapper<DataMarket, DomainMarket>> provideDataMarketToDomainMarketProvider;
        private Provider<ListMapper<DataBaseSubscription, DomainBaseSubscription>> provideDataMarketV2ToDomainMarketV2Provider;
        private Provider<ListMapper<DataOuterService, DomainOuterService>> provideDataOuterServiceToDomainOuterServiceMapperProvider;
        private Provider<NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure>> provideDataPopupStoriesToDomainPopupStoriesCatalogProvider;
        private Provider<ListMapper<DataService, DomainService>> provideDataServiceToDomainServiceProvider;
        private Provider<NullableInputListMapper<DataSmallService, DomainSmallServices>> provideDataSmallServiceToDomainSmallServicesProvider;
        private Provider<NullableInputListMapper<DataStoriesButton, DomainStoriesButton>> provideDataStoriesButtonToDomainStoriesProvider;
        private Provider<NullableInputListMapper<DataStory, DomainStory>> provideDataStoryToDomainStoryProvider;
        private Provider<NullableInputListMapper<DataSubsPlans, DomainSubsPlans>> provideDataSubsPlansToDomainSubsPlansProvider;
        private Provider<ListMapper<DataSubscription, DomainSubscription>> provideDataSubscriptionToDomainSubscriptionProvider;
        private Provider<DeactivateAccountUseCase> provideDeactivateAccountUseCaseProvider;
        private Provider<DeactivateAddressUseCase> provideDeactivateAddressUseCaseProvider;
        private Provider<DeclineInviteUseCase> provideDeclineInviteUseCaseProvider;
        private Provider<DeleteAccountUseCase> provideDeleteAccountUseCaseProvider;
        private Provider<DeleteFamilyInviteUseCase> provideDeleteFamilyInviteUseCaseProvider;
        private Provider<DeleteFrUseCase> provideDeleteFrUseCaseProvider;
        private Provider<DeletePhysicalKeyUseCase> provideDeletePhysicalKeyUseCaseProvider;
        private Provider<ListMapper<DomainCamera, Camera>> provideDomainCameraToCameraProvider;
        private Provider<ListMapper<DomainCountryCode, CountryCode>> provideDomainCountryCodeToCountryCodeProvider;
        private Provider<ListMapper<DomainLocalization, Localization>> provideDomainLocalizationToLocalizationProvider;
        private Provider<NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure>> provideDomainPopupStoriesToPopupStoriesProvider;
        private Provider<NullableInputListMapper<DomainStoriesButton, StoryButton>> provideDomainStoryButtonToStoryButtonProvider;
        private Provider<NullableInputListMapper<DomainStory, Story>> provideDomainStoryToStoryProvider;
        private Provider<GetAllCamerasUseCase> provideGetAllCamerasUseCaseProvider;
        private Provider<GetCamerasDemoUseCase> provideGetCamerasDemoUseCaseProvider;
        private Provider<GetAlertsUseCase> provideGetCamerasOrderUseCaseProvider;
        private Provider<GetCountryCodeUseCase> provideGetCountryCodeUseCaseProvider;
        private Provider<GetEntryUseCase> provideGetEntryUseCaseProvider;
        private Provider<GetFamilyInvitesUseCase> provideGetFamilyInvitesUseCaseProvider;
        private Provider<GetIntercomCodeForRegUseCase> provideGetIntercomCodeForRegUseCaseProvider;
        private Provider<GetInvitesUseCase> provideGetInvitesUseCaseProvider;
        private Provider<GetLocalizationUseCase> provideGetLocalizationUseCaseProvider;
        private Provider<GetMarketV2UseCase> provideGetMarketV2UseCaseProvider;
        private Provider<GetOnBoardingStoriesUseCase> provideGetOnboardingStoriesUseCaseProvider;
        private Provider<GetPhysicalKeysUseCase> provideGetPhysicalKeysUseCaseProvider;
        private Provider<GetPopupStoriesUseCase> provideGetPopupStoriesUseCaseProvider;
        private Provider<GetProfileUseCase> provideGetProfileUseCaseProvider;
        private Provider<GetRequestUseCase> provideGetRequestUseCaseProvider;
        private Provider<GetStoriesUseCase> provideGetStoriesUseCaseProvider;
        private Provider<InvitesApi> provideInvitesApiProvider;
        private Provider<LocalizationApi> provideLocalizationApiProvider;
        private Provider<LogoutUseCase> provideLogoutUseCaseProvider;
        private Provider<MarketApi> provideMarketApiProvider;
        private Provider<OkHttpClient> provideOkHttpNoJwtProvider;
        private Provider<OkHttpClient> provideOkHttpProvider;
        private Provider<OpenDoorUseCase> provideOpenDoorUseCaseProvider;
        private Provider<OpenSecondDoorUseCase> provideOpenSecondDoorUseCaseProvider;
        private Provider<PhysicalKeysApi> providePhysicalKeysApiProvider;
        private Provider<PopupStoriesApi> providePopupStoriesApiProvider;
        private Provider<Retrofit> provideProdRetrofitProvider;
        private Provider<ProfileApi> provideProfileApiProvider;
        private Provider<RegisterUserByPhoneUseCase> provideRegisterUserByPhoneUseCaseProvider;
        private Provider<ResendFamilyInviteUseCase> provideResendFamilyInviteUseCaseProvider;
        private Provider<SendCallEnabledUseCase> provideSendCallEnabledUseCaseProvider;
        private Provider<SendFamilyInviteUseCase> provideSendFamilyInviteUseCaseProvider;
        private Provider<SendPopupStoriesActionUseCase> provideSendPopupStoriesUseCaseProvider;
        private Provider<SendPushTokenUseCase> provideSendPushTokenUseCaseProvider;
        private Provider<SendTimezoneUseCase> provideSendTimezoneUseCaseProvider;
        private Provider<SetLocalizationUseCase> provideSetLocalizationUseCaseProvider;
        private Provider<StoriesApi> provideStoriesApiProvider;
        private Provider<UnblockPhysicalKeyUseCase> provideUnblockPhysicalKeyUseCaseProvider;
        private Provider<UnlinkAddressUseCase> provideUnlinkAddressUseCaseProvider;
        private Provider<UpdatePhysicalKeyCommentUseCase> provideUpdatePhysicalKeyCommentUseCaseProvider;
        private Provider<UpdateUseNameUseCase> provideUpdateUseNameUseCaseProvider;
        private Provider<VerifyAddressUseCase> provideVerifyAddressUseCaseProvider;
        private Provider<StoriesRepository> storiesRepositoryProvider;
        private Provider<StoriesViewModel> storiesViewModelProvider;
        private Provider<SubscriptionsViewModel> subscriptionsViewModelProvider;

        private OnBoardingComponentImpl(ConnectIntercomUseCaseModule connectIntercomUseCaseModule, AuthUseCaseModule authUseCaseModule, EntryUseCaseModule entryUseCaseModule, NetworkModule networkModule, ListMappersModule listMappersModule, DomainCommonListMapperModule domainCommonListMapperModule, OnBoardingListMapperModule onBoardingListMapperModule, LocalizationUseCaseModule localizationUseCaseModule, CountryCodeUseCaseModule countryCodeUseCaseModule, CamerasUseCaseModule camerasUseCaseModule, ProfileUseCaseModule profileUseCaseModule, AlertsUseCaseModule alertsUseCaseModule, StoriesUseCaseModule storiesUseCaseModule, PopupStoriesUseCaseModule popupStoriesUseCaseModule, InvitesUseCaseModule invitesUseCaseModule, SubscriptionsUseCaseModule subscriptionsUseCaseModule, PhysicalKeysUseCaseModule physicalKeysUseCaseModule, OnBoardingDeps onBoardingDeps) {
            this.onBoardingComponentImpl = this;
            this.onBoardingDeps = onBoardingDeps;
            initialize(connectIntercomUseCaseModule, authUseCaseModule, entryUseCaseModule, networkModule, listMappersModule, domainCommonListMapperModule, onBoardingListMapperModule, localizationUseCaseModule, countryCodeUseCaseModule, camerasUseCaseModule, profileUseCaseModule, alertsUseCaseModule, storiesUseCaseModule, popupStoriesUseCaseModule, invitesUseCaseModule, subscriptionsUseCaseModule, physicalKeysUseCaseModule, onBoardingDeps);
            initialize2(connectIntercomUseCaseModule, authUseCaseModule, entryUseCaseModule, networkModule, listMappersModule, domainCommonListMapperModule, onBoardingListMapperModule, localizationUseCaseModule, countryCodeUseCaseModule, camerasUseCaseModule, profileUseCaseModule, alertsUseCaseModule, storiesUseCaseModule, popupStoriesUseCaseModule, invitesUseCaseModule, subscriptionsUseCaseModule, physicalKeysUseCaseModule, onBoardingDeps);
        }

        private SupportManager supportManager() {
            return new SupportManager((Application) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getApplication()));
        }

        private void initialize(ConnectIntercomUseCaseModule connectIntercomUseCaseModule, AuthUseCaseModule authUseCaseModule, EntryUseCaseModule entryUseCaseModule, NetworkModule networkModule, ListMappersModule listMappersModule, DomainCommonListMapperModule domainCommonListMapperModule, OnBoardingListMapperModule onBoardingListMapperModule, LocalizationUseCaseModule localizationUseCaseModule, CountryCodeUseCaseModule countryCodeUseCaseModule, CamerasUseCaseModule camerasUseCaseModule, ProfileUseCaseModule profileUseCaseModule, AlertsUseCaseModule alertsUseCaseModule, StoriesUseCaseModule storiesUseCaseModule, PopupStoriesUseCaseModule popupStoriesUseCaseModule, InvitesUseCaseModule invitesUseCaseModule, SubscriptionsUseCaseModule subscriptionsUseCaseModule, PhysicalKeysUseCaseModule physicalKeysUseCaseModule, OnBoardingDeps onBoardingDeps) {
            this.getConfigProvider = new GetConfigProvider(onBoardingDeps);
            this.getApplicationProvider = new GetApplicationProvider(onBoardingDeps);
            GetPrefManagerProvider getPrefManagerProvider = new GetPrefManagerProvider(onBoardingDeps);
            this.getPrefManagerProvider = getPrefManagerProvider;
            dagger.internal.Provider provider = DoubleCheck.provider(NetworkModule_ProvideBaseOkHttpFactory.create(networkModule, this.getApplicationProvider, getPrefManagerProvider, this.getConfigProvider));
            this.provideBaseOkHttpProvider = provider;
            dagger.internal.Provider provider2 = DoubleCheck.provider(NetworkModule_ProvideOkHttpFactory.create(networkModule, provider, this.getPrefManagerProvider, this.getConfigProvider));
            this.provideOkHttpProvider = provider2;
            dagger.internal.Provider provider3 = DoubleCheck.provider(NetworkModule_ProvideProdRetrofitFactory.create(networkModule, this.getConfigProvider, provider2, this.getPrefManagerProvider));
            this.provideProdRetrofitProvider = provider3;
            dagger.internal.Provider provider4 = DoubleCheck.provider(NetworkModule_ProvideConnectIntercomApiFactory.create(networkModule, provider3));
            this.provideConnectIntercomApiProvider = provider4;
            ConnectIntercomRepository_Factory connectIntercomRepository_FactoryCreate = ConnectIntercomRepository_Factory.create(provider4, DataActivationCodeToDomainActivationCodeMapper_Factory.create(), DataEntryToDomainEntryMapper_Factory.create());
            this.connectIntercomRepositoryProvider = connectIntercomRepository_FactoryCreate;
            ConnectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory connectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactoryCreate = ConnectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory.create(connectIntercomUseCaseModule, connectIntercomRepository_FactoryCreate);
            this.provideGetIntercomCodeForRegUseCaseProvider = connectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactoryCreate;
            this.connectIntercomViewModelProvider = ConnectIntercomViewModel_Factory.create(connectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactoryCreate, DomainActivationCodeToActivationCodeMapper_Factory.create());
            dagger.internal.Provider provider5 = DoubleCheck.provider(NetworkModule_ProvideOkHttpNoJwtFactory.create(networkModule, this.provideBaseOkHttpProvider));
            this.provideOkHttpNoJwtProvider = provider5;
            dagger.internal.Provider provider6 = DoubleCheck.provider(NetworkModule_ProvideBaseProdRetrofitFactory.create(networkModule, this.getConfigProvider, provider5, this.getPrefManagerProvider));
            this.provideBaseProdRetrofitProvider = provider6;
            dagger.internal.Provider provider7 = DoubleCheck.provider(NetworkModule_ProvideAuthApiFactory.create(networkModule, provider6));
            this.provideAuthApiProvider = provider7;
            AuthRepository_Factory authRepository_FactoryCreate = AuthRepository_Factory.create(provider7, DataConfirmToDomainConfirmMapper_Factory.create(), DataPhoneRequestToDomainPhoneRequestMapper_Factory.create(), DataApplyRegistrationToDomainApplyRegistrationMapper_Factory.create(), DataConfirmRegistrationToDomainConfirmRegistrationMapper_Factory.create(), DataRequestInfoToDomainRequestInfoMapper_Factory.create());
            this.authRepositoryProvider = authRepository_FactoryCreate;
            this.provideRegisterUserByPhoneUseCaseProvider = AuthUseCaseModule_ProvideRegisterUserByPhoneUseCaseFactory.create(authUseCaseModule, authRepository_FactoryCreate);
            this.provideApplyRegistrationUseCaseProvider = AuthUseCaseModule_ProvideApplyRegistrationUseCaseFactory.create(authUseCaseModule, this.authRepositoryProvider);
            this.provideConfirmRegistrationUseCaseProvider = AuthUseCaseModule_ProvideConfirmRegistrationUseCaseFactory.create(authUseCaseModule, this.authRepositoryProvider);
            this.provideGetRequestUseCaseProvider = AuthUseCaseModule_ProvideGetRequestUseCaseFactory.create(authUseCaseModule, this.authRepositoryProvider);
            this.provideDataCountryCodeToDomainCountryCodeProvider = ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory.create(listMappersModule, DataCountryCodeToDomainCountryCodeMapper_Factory.create());
            CountryCodeRepository_Factory countryCodeRepository_FactoryCreate = CountryCodeRepository_Factory.create(CountryCodeSource_Factory.create(), this.provideDataCountryCodeToDomainCountryCodeProvider);
            this.countryCodeRepositoryProvider = countryCodeRepository_FactoryCreate;
            this.provideGetCountryCodeUseCaseProvider = CountryCodeUseCaseModule_ProvideGetCountryCodeUseCaseFactory.create(countryCodeUseCaseModule, countryCodeRepository_FactoryCreate);
            DomainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactory domainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactoryCreate = DomainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactory.create(domainCommonListMapperModule, DomainCountryCodeToCountryCodeMapper_Factory.create());
            this.provideDomainCountryCodeToCountryCodeProvider = domainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactoryCreate;
            this.loginViewModelProvider = LoginViewModel_Factory.create(this.provideRegisterUserByPhoneUseCaseProvider, this.provideApplyRegistrationUseCaseProvider, this.provideConfirmRegistrationUseCaseProvider, this.provideGetRequestUseCaseProvider, this.getPrefManagerProvider, this.provideGetCountryCodeUseCaseProvider, domainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactoryCreate, this.getConfigProvider);
            EntryUseCaseModule_ProvideGetEntryUseCaseFactory entryUseCaseModule_ProvideGetEntryUseCaseFactoryCreate = EntryUseCaseModule_ProvideGetEntryUseCaseFactory.create(entryUseCaseModule, this.connectIntercomRepositoryProvider);
            this.provideGetEntryUseCaseProvider = entryUseCaseModule_ProvideGetEntryUseCaseFactoryCreate;
            this.entryViewModelProvider = EntryViewModel_Factory.create(entryUseCaseModule_ProvideGetEntryUseCaseFactoryCreate, DomainEntryToEntryMapper_Factory.create());
            this.provideLocalizationApiProvider = DoubleCheck.provider(NetworkModule_ProvideLocalizationApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory listMappersModule_ProvideDataLocalizationToDomainLocalizationFactoryCreate = ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory.create(listMappersModule, DataLocalizationToDomainLocalizationMapper_Factory.create());
            this.provideDataLocalizationToDomainLocalizationProvider = listMappersModule_ProvideDataLocalizationToDomainLocalizationFactoryCreate;
            LocalizationRepository_Factory localizationRepository_FactoryCreate = LocalizationRepository_Factory.create(this.provideLocalizationApiProvider, listMappersModule_ProvideDataLocalizationToDomainLocalizationFactoryCreate);
            this.localizationRepositoryProvider = localizationRepository_FactoryCreate;
            this.provideGetLocalizationUseCaseProvider = LocalizationUseCaseModule_ProvideGetLocalizationUseCaseFactory.create(localizationUseCaseModule, localizationRepository_FactoryCreate);
            this.provideDomainLocalizationToLocalizationProvider = DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory.create(domainCommonListMapperModule, DomainLocalizationToLocalizationMapper_Factory.create());
            GetLocalizationStorageProvider getLocalizationStorageProvider = new GetLocalizationStorageProvider(onBoardingDeps);
            this.getLocalizationStorageProvider = getLocalizationStorageProvider;
            this.localizationViewModelProvider = LocalizationViewModel_Factory.create(this.provideGetLocalizationUseCaseProvider, this.getPrefManagerProvider, this.getConfigProvider, this.provideDomainLocalizationToLocalizationProvider, getLocalizationStorageProvider);
            this.provideProfileApiProvider = DoubleCheck.provider(NetworkModule_ProvideProfileApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            DataProfileToDomainProfileMapper_Factory dataProfileToDomainProfileMapper_FactoryCreate = DataProfileToDomainProfileMapper_Factory.create(DataProfileCardInfoToDomainProfileCardInfoMapper_Factory.create());
            this.dataProfileToDomainProfileMapperProvider = dataProfileToDomainProfileMapper_FactoryCreate;
            dagger.internal.Provider provider8 = DoubleCheck.provider(ProfileRepository_Factory.create(this.provideProfileApiProvider, dataProfileToDomainProfileMapper_FactoryCreate));
            this.profileRepositoryProvider = provider8;
            this.provideDeleteFrUseCaseProvider = ProfileUseCaseModule_ProvideDeleteFrUseCaseFactory.create(profileUseCaseModule, provider8);
            this.provideSetLocalizationUseCaseProvider = ProfileUseCaseModule_ProvideSetLocalizationUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideChangeAvatarUseCaseProvider = ProfileUseCaseModule_ProvideChangeAvatarUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideGetProfileUseCaseProvider = ProfileUseCaseModule_ProvideGetProfileUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideLogoutUseCaseProvider = ProfileUseCaseModule_ProvideLogoutUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideDeleteAccountUseCaseProvider = ProfileUseCaseModule_ProvideDeleteAccountUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideVerifyAddressUseCaseProvider = ProfileUseCaseModule_ProvideVerifyAddressUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideDeactivateAddressUseCaseProvider = ProfileUseCaseModule_ProvideDeactivateAddressUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideUnlinkAddressUseCaseProvider = ProfileUseCaseModule_ProvideUnlinkAddressUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideDeactivateAccountUseCaseProvider = ProfileUseCaseModule_ProvideDeactivateAccountUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideSendPushTokenUseCaseProvider = ProfileUseCaseModule_ProvideSendPushTokenUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideSendTimezoneUseCaseProvider = ProfileUseCaseModule_ProvideSendTimezoneUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideSendCallEnabledUseCaseProvider = ProfileUseCaseModule_ProvideSendCallEnabledUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideBindToFlatUseCaseProvider = ProfileUseCaseModule_ProvideBindToFlatUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.domainProfileToProfileMapperProvider = DomainProfileToProfileMapper_Factory.create(DomainProfileCardInfoToProfileCardInfoMapper_Factory.create(), this.getLocalizationStorageProvider, this.getPrefManagerProvider);
            GetAnalyticsProvider getAnalyticsProvider = new GetAnalyticsProvider(onBoardingDeps);
            this.getAnalyticsProvider = getAnalyticsProvider;
            this.profileViewModelProvider = ProfileViewModel_Factory.create(this.getApplicationProvider, this.provideDeleteFrUseCaseProvider, this.provideSetLocalizationUseCaseProvider, this.provideChangeAvatarUseCaseProvider, this.provideGetProfileUseCaseProvider, this.provideLogoutUseCaseProvider, this.provideDeleteAccountUseCaseProvider, this.provideVerifyAddressUseCaseProvider, this.provideDeactivateAddressUseCaseProvider, this.provideUnlinkAddressUseCaseProvider, this.provideDeactivateAccountUseCaseProvider, this.provideSendPushTokenUseCaseProvider, this.provideSendTimezoneUseCaseProvider, this.provideSendCallEnabledUseCaseProvider, this.provideBindToFlatUseCaseProvider, this.getPrefManagerProvider, this.domainProfileToProfileMapperProvider, this.getLocalizationStorageProvider, this.getConfigProvider, getAnalyticsProvider);
            this.provideStoriesApiProvider = DoubleCheck.provider(NetworkModule_ProvideStoriesApiFactory.create(networkModule, this.provideBaseProdRetrofitProvider));
            ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory listMappersModule_ProvideDataStoriesButtonToDomainStoriesFactoryCreate = ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory.create(listMappersModule, DataStoriesButtonToDomainStoriesButtonMapper_Factory.create());
            this.provideDataStoriesButtonToDomainStoriesProvider = listMappersModule_ProvideDataStoriesButtonToDomainStoriesFactoryCreate;
            DataStoryToDomainStoryMapper_Factory dataStoryToDomainStoryMapper_FactoryCreate = DataStoryToDomainStoryMapper_Factory.create(listMappersModule_ProvideDataStoriesButtonToDomainStoriesFactoryCreate);
            this.dataStoryToDomainStoryMapperProvider = dataStoryToDomainStoryMapper_FactoryCreate;
            ListMappersModule_ProvideDataStoryToDomainStoryFactory listMappersModule_ProvideDataStoryToDomainStoryFactoryCreate = ListMappersModule_ProvideDataStoryToDomainStoryFactory.create(listMappersModule, dataStoryToDomainStoryMapper_FactoryCreate);
            this.provideDataStoryToDomainStoryProvider = listMappersModule_ProvideDataStoryToDomainStoryFactoryCreate;
            StoriesRepository_Factory storiesRepository_FactoryCreate = StoriesRepository_Factory.create(this.provideStoriesApiProvider, listMappersModule_ProvideDataStoryToDomainStoryFactoryCreate);
            this.storiesRepositoryProvider = storiesRepository_FactoryCreate;
            this.provideGetOnboardingStoriesUseCaseProvider = StoriesUseCaseModule_ProvideGetOnboardingStoriesUseCaseFactory.create(storiesUseCaseModule, storiesRepository_FactoryCreate);
            this.provideGetStoriesUseCaseProvider = StoriesUseCaseModule_ProvideGetStoriesUseCaseFactory.create(storiesUseCaseModule, this.storiesRepositoryProvider);
            OnBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactory onBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactoryCreate = OnBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactory.create(onBoardingListMapperModule, DomainStoryButtonToStoryButtonMapper_Factory.create());
            this.provideDomainStoryButtonToStoryButtonProvider = onBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactoryCreate;
            DomainStoryToStoryMapper_Factory domainStoryToStoryMapper_FactoryCreate = DomainStoryToStoryMapper_Factory.create(onBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactoryCreate);
            this.domainStoryToStoryMapperProvider = domainStoryToStoryMapper_FactoryCreate;
            OnBoardingListMapperModule_ProvideDomainStoryToStoryFactory onBoardingListMapperModule_ProvideDomainStoryToStoryFactoryCreate = OnBoardingListMapperModule_ProvideDomainStoryToStoryFactory.create(onBoardingListMapperModule, domainStoryToStoryMapper_FactoryCreate);
            this.provideDomainStoryToStoryProvider = onBoardingListMapperModule_ProvideDomainStoryToStoryFactoryCreate;
            this.storiesViewModelProvider = StoriesViewModel_Factory.create(this.getPrefManagerProvider, this.getConfigProvider, this.provideGetOnboardingStoriesUseCaseProvider, this.provideGetStoriesUseCaseProvider, onBoardingListMapperModule_ProvideDomainStoryToStoryFactoryCreate);
            this.provideAlertsApiProvider = DoubleCheck.provider(NetworkModule_ProvideAlertsApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            ListMappersModule_ProvideDataAlertToDomainAlertFactory listMappersModule_ProvideDataAlertToDomainAlertFactoryCreate = ListMappersModule_ProvideDataAlertToDomainAlertFactory.create(listMappersModule, DataAlertToDomainAlertMapper_Factory.create());
            this.provideDataAlertToDomainAlertProvider = listMappersModule_ProvideDataAlertToDomainAlertFactoryCreate;
            AlertsRepository_Factory alertsRepository_FactoryCreate = AlertsRepository_Factory.create(this.provideAlertsApiProvider, listMappersModule_ProvideDataAlertToDomainAlertFactoryCreate);
            this.alertsRepositoryProvider = alertsRepository_FactoryCreate;
            AlertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactory alertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactoryCreate = AlertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactory.create(alertsUseCaseModule, alertsRepository_FactoryCreate);
            this.provideGetCamerasOrderUseCaseProvider = alertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactoryCreate;
            this.alertsViewModelProvider = AlertsViewModel_Factory.create(alertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactoryCreate, DomainAlertToAlertMapper_Factory.create(), this.getConfigProvider, this.getPrefManagerProvider);
            this.onboardingViewModelProvider = OnboardingViewModel_Factory.create(this.getPrefManagerProvider, this.getApplicationProvider);
            this.provideInvitesApiProvider = DoubleCheck.provider(NetworkModule_ProvideInvitesApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            ListMappersModule_ProvideDataInviteToDomainInviteFactory listMappersModule_ProvideDataInviteToDomainInviteFactoryCreate = ListMappersModule_ProvideDataInviteToDomainInviteFactory.create(listMappersModule, DataInviteToDomainInviteMapper_Factory.create());
            this.provideDataInviteToDomainInviteProvider = listMappersModule_ProvideDataInviteToDomainInviteFactoryCreate;
            InvitesRepository_Factory invitesRepository_FactoryCreate = InvitesRepository_Factory.create(this.provideInvitesApiProvider, listMappersModule_ProvideDataInviteToDomainInviteFactoryCreate, DataInviteToDomainInviteMapper_Factory.create(), DataFamilyInvitesToDomainFamilyInvitesMapper_Factory.create());
            this.invitesRepositoryProvider = invitesRepository_FactoryCreate;
            this.provideGetInvitesUseCaseProvider = InvitesUseCaseModule_ProvideGetInvitesUseCaseFactory.create(invitesUseCaseModule, invitesRepository_FactoryCreate);
            this.provideGetFamilyInvitesUseCaseProvider = InvitesUseCaseModule_ProvideGetFamilyInvitesUseCaseFactory.create(invitesUseCaseModule, this.invitesRepositoryProvider);
            this.provideSendFamilyInviteUseCaseProvider = InvitesUseCaseModule_ProvideSendFamilyInviteUseCaseFactory.create(invitesUseCaseModule, this.invitesRepositoryProvider);
            this.provideResendFamilyInviteUseCaseProvider = InvitesUseCaseModule_ProvideResendFamilyInviteUseCaseFactory.create(invitesUseCaseModule, this.invitesRepositoryProvider);
            this.provideDeleteFamilyInviteUseCaseProvider = InvitesUseCaseModule_ProvideDeleteFamilyInviteUseCaseFactory.create(invitesUseCaseModule, this.invitesRepositoryProvider);
            this.provideAcceptInviteUseCaseProvider = InvitesUseCaseModule_ProvideAcceptInviteUseCaseFactory.create(invitesUseCaseModule, this.invitesRepositoryProvider);
            InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory invitesUseCaseModule_ProvideDeclineInviteUseCaseFactoryCreate = InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory.create(invitesUseCaseModule, this.invitesRepositoryProvider);
            this.provideDeclineInviteUseCaseProvider = invitesUseCaseModule_ProvideDeclineInviteUseCaseFactoryCreate;
            this.invitesViewModelProvider = InvitesViewModel_Factory.create(this.provideGetInvitesUseCaseProvider, this.provideGetFamilyInvitesUseCaseProvider, this.provideSendFamilyInviteUseCaseProvider, this.provideResendFamilyInviteUseCaseProvider, this.provideDeleteFamilyInviteUseCaseProvider, this.provideAcceptInviteUseCaseProvider, invitesUseCaseModule_ProvideDeclineInviteUseCaseFactoryCreate, this.getConfigProvider, this.getPrefManagerProvider, DomainInviteToInviteMapper_Factory.create(), DomainFamilyInvitesToFamilyInvitesMapper_Factory.create(), this.provideGetCountryCodeUseCaseProvider, this.getLocalizationStorageProvider);
            this.providePopupStoriesApiProvider = DoubleCheck.provider(NetworkModule_ProvidePopupStoriesApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory listMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactoryCreate = ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory.create(listMappersModule, DataPopupStoryToDomainPopupStoryMapper_Factory.create());
            this.provideDataPopupStoriesToDomainPopupStoriesCatalogProvider = listMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactoryCreate;
            PopupStoriesRepository_Factory popupStoriesRepository_FactoryCreate = PopupStoriesRepository_Factory.create(this.providePopupStoriesApiProvider, listMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactoryCreate, DataPopupStoryToDomainPopupStoryMapper_Factory.create());
            this.popupStoriesRepositoryProvider = popupStoriesRepository_FactoryCreate;
            this.provideGetPopupStoriesUseCaseProvider = PopupStoriesUseCaseModule_ProvideGetPopupStoriesUseCaseFactory.create(popupStoriesUseCaseModule, popupStoriesRepository_FactoryCreate);
            this.provideSendPopupStoriesUseCaseProvider = PopupStoriesUseCaseModule_ProvideSendPopupStoriesUseCaseFactory.create(popupStoriesUseCaseModule, this.popupStoriesRepositoryProvider);
            DomainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactory domainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactoryCreate = DomainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactory.create(domainCommonListMapperModule, DomainPopupStoriesToPopupStoriesMapper_Factory.create());
            this.provideDomainPopupStoriesToPopupStoriesProvider = domainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactoryCreate;
            this.popupStoriesViewModelProvider = PopupStoriesViewModel_Factory.create(this.getPrefManagerProvider, this.getConfigProvider, this.provideGetPopupStoriesUseCaseProvider, this.provideSendPopupStoriesUseCaseProvider, domainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactoryCreate);
            this.instructionsViewModelProvider = InstructionsViewModel_Factory.create(this.getApplicationProvider);
            this.provideMarketApiProvider = DoubleCheck.provider(NetworkModule_ProvideMarketApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory listMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactoryCreate = ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory.create(listMappersModule, DataSubsPlansToDomainSubsPlansMapper_Factory.create());
            this.provideDataSubsPlansToDomainSubsPlansProvider = listMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactoryCreate;
            this.dataAppearancePlansToDomainAppearancePlansMapperProvider = DataAppearancePlansToDomainAppearancePlansMapper_Factory.create(listMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactoryCreate);
            ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory listMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactoryCreate = ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory.create(listMappersModule, DataSmallServiceToDomainSmallServiceMapper_Factory.create());
            this.provideDataSmallServiceToDomainSmallServicesProvider = listMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactoryCreate;
            DataIncludedServiceToDomainIncludedServiceMapper_Factory dataIncludedServiceToDomainIncludedServiceMapper_FactoryCreate = DataIncludedServiceToDomainIncludedServiceMapper_Factory.create(listMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactoryCreate);
            this.dataIncludedServiceToDomainIncludedServiceMapperProvider = dataIncludedServiceToDomainIncludedServiceMapper_FactoryCreate;
            DataDetailedLayoutToDomainDetailedLayoutMapper_Factory dataDetailedLayoutToDomainDetailedLayoutMapper_FactoryCreate = DataDetailedLayoutToDomainDetailedLayoutMapper_Factory.create(this.dataAppearancePlansToDomainAppearancePlansMapperProvider, dataIncludedServiceToDomainIncludedServiceMapper_FactoryCreate);
            this.dataDetailedLayoutToDomainDetailedLayoutMapperProvider = dataDetailedLayoutToDomainDetailedLayoutMapper_FactoryCreate;
            this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider = DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper_Factory.create(dataDetailedLayoutToDomainDetailedLayoutMapper_FactoryCreate);
            DataPlansToDomainPlansMapper_Factory dataPlansToDomainPlansMapper_FactoryCreate = DataPlansToDomainPlansMapper_Factory.create(DataPlanAppearanceToDomainPlanAppearanceMapper_Factory.create());
            this.dataPlansToDomainPlansMapperProvider = dataPlansToDomainPlansMapper_FactoryCreate;
            DataSubscriptionToDomainSubscriptionMapper_Factory dataSubscriptionToDomainSubscriptionMapper_FactoryCreate = DataSubscriptionToDomainSubscriptionMapper_Factory.create(this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider, this.provideDataSmallServiceToDomainSmallServicesProvider, dataPlansToDomainPlansMapper_FactoryCreate);
            this.dataSubscriptionToDomainSubscriptionMapperProvider = dataSubscriptionToDomainSubscriptionMapper_FactoryCreate;
            this.provideDataSubscriptionToDomainSubscriptionProvider = ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory.create(listMappersModule, dataSubscriptionToDomainSubscriptionMapper_FactoryCreate);
            DataSubscriptionDetailsToDomainSubscriptionDetailsMapper_Factory dataSubscriptionDetailsToDomainSubscriptionDetailsMapper_FactoryCreate = DataSubscriptionDetailsToDomainSubscriptionDetailsMapper_Factory.create(this.provideDataSubsPlansToDomainSubsPlansProvider);
            this.dataSubscriptionDetailsToDomainSubscriptionDetailsMapperProvider = dataSubscriptionDetailsToDomainSubscriptionDetailsMapper_FactoryCreate;
            this.dataMarketToDomainMarketMapperProvider = DataMarketToDomainMarketMapper_Factory.create(dataSubscriptionDetailsToDomainSubscriptionDetailsMapper_FactoryCreate, this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider);
        }

        private void initialize2(ConnectIntercomUseCaseModule connectIntercomUseCaseModule, AuthUseCaseModule authUseCaseModule, EntryUseCaseModule entryUseCaseModule, NetworkModule networkModule, ListMappersModule listMappersModule, DomainCommonListMapperModule domainCommonListMapperModule, OnBoardingListMapperModule onBoardingListMapperModule, LocalizationUseCaseModule localizationUseCaseModule, CountryCodeUseCaseModule countryCodeUseCaseModule, CamerasUseCaseModule camerasUseCaseModule, ProfileUseCaseModule profileUseCaseModule, AlertsUseCaseModule alertsUseCaseModule, StoriesUseCaseModule storiesUseCaseModule, PopupStoriesUseCaseModule popupStoriesUseCaseModule, InvitesUseCaseModule invitesUseCaseModule, SubscriptionsUseCaseModule subscriptionsUseCaseModule, PhysicalKeysUseCaseModule physicalKeysUseCaseModule, OnBoardingDeps onBoardingDeps) {
            this.provideDataMarketToDomainMarketProvider = ListMappersModule_ProvideDataMarketToDomainMarketFactory.create(listMappersModule, this.dataMarketToDomainMarketMapperProvider);
            DataBaseSubscriptionToDomainBaseSubscriptionMapper_Factory dataBaseSubscriptionToDomainBaseSubscriptionMapper_FactoryCreate = DataBaseSubscriptionToDomainBaseSubscriptionMapper_Factory.create(DataBaseAppearanceToDomainAppearanceMapper_Factory.create());
            this.dataBaseSubscriptionToDomainBaseSubscriptionMapperProvider = dataBaseSubscriptionToDomainBaseSubscriptionMapper_FactoryCreate;
            this.provideDataMarketV2ToDomainMarketV2Provider = ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory.create(listMappersModule, dataBaseSubscriptionToDomainBaseSubscriptionMapper_FactoryCreate);
            DataOuterServiceToDomainOuterServiceMapper_Factory dataOuterServiceToDomainOuterServiceMapper_FactoryCreate = DataOuterServiceToDomainOuterServiceMapper_Factory.create(DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper_Factory.create());
            this.dataOuterServiceToDomainOuterServiceMapperProvider = dataOuterServiceToDomainOuterServiceMapper_FactoryCreate;
            this.provideDataOuterServiceToDomainOuterServiceMapperProvider = ListMappersModule_ProvideDataOuterServiceToDomainOuterServiceMapperFactory.create(listMappersModule, dataOuterServiceToDomainOuterServiceMapper_FactoryCreate);
            this.provideDataMarketItemToDomainMarketItemMapperProvider = ListMappersModule_ProvideDataMarketItemToDomainMarketItemMapperFactory.create(listMappersModule, DataMarketItemToDomainMarketItemMapper_Factory.create());
            DataServiceToDomainServiceMapper_Factory dataServiceToDomainServiceMapper_FactoryCreate = DataServiceToDomainServiceMapper_Factory.create(DataServiceAppearanceToDomainServiceAppearanceMapper_Factory.create(), DataOriginSubToDomainOriginSubMapper_Factory.create());
            this.dataServiceToDomainServiceMapperProvider = dataServiceToDomainServiceMapper_FactoryCreate;
            ListMappersModule_ProvideDataServiceToDomainServiceFactory listMappersModule_ProvideDataServiceToDomainServiceFactoryCreate = ListMappersModule_ProvideDataServiceToDomainServiceFactory.create(listMappersModule, dataServiceToDomainServiceMapper_FactoryCreate);
            this.provideDataServiceToDomainServiceProvider = listMappersModule_ProvideDataServiceToDomainServiceFactoryCreate;
            MarketRepository_Factory marketRepository_FactoryCreate = MarketRepository_Factory.create(this.provideMarketApiProvider, this.provideDataSubscriptionToDomainSubscriptionProvider, this.provideDataMarketToDomainMarketProvider, this.provideDataMarketV2ToDomainMarketV2Provider, this.provideDataOuterServiceToDomainOuterServiceMapperProvider, this.provideDataMarketItemToDomainMarketItemMapperProvider, listMappersModule_ProvideDataServiceToDomainServiceFactoryCreate);
            this.marketRepositoryProvider = marketRepository_FactoryCreate;
            this.provideGetMarketV2UseCaseProvider = SubscriptionsUseCaseModule_ProvideGetMarketV2UseCaseFactory.create(subscriptionsUseCaseModule, marketRepository_FactoryCreate);
            this.domainBaseSubscriptionToBaseSubscriptionMapperProvider = DomainBaseSubscriptionToBaseSubscriptionMapper_Factory.create(DomainBaseAppearanceToBaseAppearanceMapper_Factory.create());
            DomainOuterServiceToOuterServiceMapper_Factory domainOuterServiceToOuterServiceMapper_FactoryCreate = DomainOuterServiceToOuterServiceMapper_Factory.create(DomainOuterServiceAppearanceToOuterServiceAppearanceMapper_Factory.create());
            this.domainOuterServiceToOuterServiceMapperProvider = domainOuterServiceToOuterServiceMapper_FactoryCreate;
            this.subscriptionsViewModelProvider = SubscriptionsViewModel_Factory.create(this.provideGetMarketV2UseCaseProvider, this.domainBaseSubscriptionToBaseSubscriptionMapperProvider, domainOuterServiceToOuterServiceMapper_FactoryCreate, DomainMarketItemToMarketItemMapper_Factory.create(), this.getPrefManagerProvider);
            dagger.internal.Provider provider = DoubleCheck.provider(NetworkModule_ProvidePhysicalKeysApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            this.providePhysicalKeysApiProvider = provider;
            PhysicalKeysRepository_Factory physicalKeysRepository_FactoryCreate = PhysicalKeysRepository_Factory.create(provider, DataPhysicalKeyToDomainPhysicalKeyMapper_Factory.create());
            this.physicalKeysRepositoryProvider = physicalKeysRepository_FactoryCreate;
            this.provideGetPhysicalKeysUseCaseProvider = PhysicalKeysUseCaseModule_ProvideGetPhysicalKeysUseCaseFactory.create(physicalKeysUseCaseModule, physicalKeysRepository_FactoryCreate);
            this.provideCreatePhysicalKeyUseCaseProvider = PhysicalKeysUseCaseModule_ProvideCreatePhysicalKeyUseCaseFactory.create(physicalKeysUseCaseModule, this.physicalKeysRepositoryProvider);
            this.provideBlockPhysicalKeyUseCaseProvider = PhysicalKeysUseCaseModule_ProvideBlockPhysicalKeyUseCaseFactory.create(physicalKeysUseCaseModule, this.physicalKeysRepositoryProvider);
            this.provideUnblockPhysicalKeyUseCaseProvider = PhysicalKeysUseCaseModule_ProvideUnblockPhysicalKeyUseCaseFactory.create(physicalKeysUseCaseModule, this.physicalKeysRepositoryProvider);
            this.provideDeletePhysicalKeyUseCaseProvider = PhysicalKeysUseCaseModule_ProvideDeletePhysicalKeyUseCaseFactory.create(physicalKeysUseCaseModule, this.physicalKeysRepositoryProvider);
            PhysicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactory physicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactoryCreate = PhysicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactory.create(physicalKeysUseCaseModule, this.physicalKeysRepositoryProvider);
            this.provideUpdatePhysicalKeyCommentUseCaseProvider = physicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactoryCreate;
            this.keysViewModelProvider = KeysViewModel_Factory.create(this.provideGetPhysicalKeysUseCaseProvider, this.provideCreatePhysicalKeyUseCaseProvider, this.provideBlockPhysicalKeyUseCaseProvider, this.provideUnblockPhysicalKeyUseCaseProvider, this.provideDeletePhysicalKeyUseCaseProvider, physicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactoryCreate, DomainPhysicalKeyToPhysicalKeyMapper_Factory.create(), this.getConfigProvider, this.getPrefManagerProvider, this.getLocalizationStorageProvider, this.getAnalyticsProvider);
            MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(15).put((MapProviderFactory.Builder) ConnectIntercomViewModel.class, (Provider) this.connectIntercomViewModelProvider).put((MapProviderFactory.Builder) LoginViewModel.class, (Provider) this.loginViewModelProvider).put((MapProviderFactory.Builder) EntryViewModel.class, (Provider) this.entryViewModelProvider).put((MapProviderFactory.Builder) LocalizationViewModel.class, (Provider) this.localizationViewModelProvider).put((MapProviderFactory.Builder) ProfileViewModel.class, (Provider) this.profileViewModelProvider).put((MapProviderFactory.Builder) StoriesViewModel.class, (Provider) this.storiesViewModelProvider).put((MapProviderFactory.Builder) AlertsViewModel.class, (Provider) this.alertsViewModelProvider).put((MapProviderFactory.Builder) NavigationViewModel.class, (Provider) NavigationViewModel_Factory.create()).put((MapProviderFactory.Builder) StateViewModel.class, (Provider) StateViewModel_Factory.create()).put((MapProviderFactory.Builder) OnboardingViewModel.class, (Provider) this.onboardingViewModelProvider).put((MapProviderFactory.Builder) InvitesViewModel.class, (Provider) this.invitesViewModelProvider).put((MapProviderFactory.Builder) PopupStoriesViewModel.class, (Provider) this.popupStoriesViewModelProvider).put((MapProviderFactory.Builder) InstructionsViewModel.class, (Provider) this.instructionsViewModelProvider).put((MapProviderFactory.Builder) SubscriptionsViewModel.class, (Provider) this.subscriptionsViewModelProvider).put((MapProviderFactory.Builder) KeysViewModel.class, (Provider) this.keysViewModelProvider).build();
            this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
            this.multiViewModelFactoryProvider = DoubleCheck.provider(MultiViewModelFactory_Factory.create(mapProviderFactoryBuild));
            this.provideCamerasApiProvider = DoubleCheck.provider(NetworkModule_ProvideCamerasApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            ListMappersModule_ProvideDataCameraToDomainCameraFactory listMappersModule_ProvideDataCameraToDomainCameraFactoryCreate = ListMappersModule_ProvideDataCameraToDomainCameraFactory.create(listMappersModule, DataCameraToDomainCameraMapper_Factory.create());
            this.provideDataCameraToDomainCameraProvider = listMappersModule_ProvideDataCameraToDomainCameraFactoryCreate;
            CamerasRepository_Factory camerasRepository_FactoryCreate = CamerasRepository_Factory.create(this.provideCamerasApiProvider, listMappersModule_ProvideDataCameraToDomainCameraFactoryCreate, DataCameraToDomainCameraMapper_Factory.create(), this.getPrefManagerProvider);
            this.camerasRepositoryProvider = camerasRepository_FactoryCreate;
            this.provideGetAllCamerasUseCaseProvider = CamerasUseCaseModule_ProvideGetAllCamerasUseCaseFactory.create(camerasUseCaseModule, camerasRepository_FactoryCreate);
            this.provideGetCamerasDemoUseCaseProvider = CamerasUseCaseModule_ProvideGetCamerasDemoUseCaseFactory.create(camerasUseCaseModule, this.camerasRepositoryProvider);
            this.provideOpenDoorUseCaseProvider = CamerasUseCaseModule_ProvideOpenDoorUseCaseFactory.create(camerasUseCaseModule, this.camerasRepositoryProvider);
            this.provideOpenSecondDoorUseCaseProvider = CamerasUseCaseModule_ProvideOpenSecondDoorUseCaseFactory.create(camerasUseCaseModule, this.camerasRepositoryProvider);
            DomainCameraToCameraMapper_Factory domainCameraToCameraMapper_FactoryCreate = DomainCameraToCameraMapper_Factory.create(DomainFlussonicToFlussonicMapper_Factory.create());
            this.domainCameraToCameraMapperProvider = domainCameraToCameraMapper_FactoryCreate;
            DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory domainCommonListMapperModule_ProvideDomainCameraToCameraFactoryCreate = DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory.create(domainCommonListMapperModule, domainCameraToCameraMapper_FactoryCreate);
            this.provideDomainCameraToCameraProvider = domainCommonListMapperModule_ProvideDomainCameraToCameraFactoryCreate;
            AllCamerasViewModel_Factory_Factory allCamerasViewModel_Factory_FactoryCreate = AllCamerasViewModel_Factory_Factory.create(this.provideGetAllCamerasUseCaseProvider, this.provideGetCamerasDemoUseCaseProvider, this.provideOpenDoorUseCaseProvider, this.provideOpenSecondDoorUseCaseProvider, this.domainCameraToCameraMapperProvider, domainCommonListMapperModule_ProvideDomainCameraToCameraFactoryCreate, this.getPrefManagerProvider);
            this.factoryProvider = allCamerasViewModel_Factory_FactoryCreate;
            this.assistFactoryProvider = AllCamerasViewModel_Factory_AssistFactory_Impl.create(allCamerasViewModel_Factory_FactoryCreate);
            AuthUseCaseModule_ProvideConfirmCodeUseCaseFactory authUseCaseModule_ProvideConfirmCodeUseCaseFactoryCreate = AuthUseCaseModule_ProvideConfirmCodeUseCaseFactory.create(authUseCaseModule, this.authRepositoryProvider);
            this.provideConfirmCodeUseCaseProvider = authUseCaseModule_ProvideConfirmCodeUseCaseFactoryCreate;
            CallCodeViewModel_Factory_Factory callCodeViewModel_Factory_FactoryCreate = CallCodeViewModel_Factory_Factory.create(authUseCaseModule_ProvideConfirmCodeUseCaseFactoryCreate, this.provideRegisterUserByPhoneUseCaseProvider, this.provideConfirmRegistrationUseCaseProvider, this.provideGetRequestUseCaseProvider, this.getPrefManagerProvider, this.getConfigProvider);
            this.factoryProvider2 = callCodeViewModel_Factory_FactoryCreate;
            this.assistFactoryProvider2 = CallCodeViewModel_Factory_AssistFactory_Impl.create(callCodeViewModel_Factory_FactoryCreate);
            ProfileUseCaseModule_ProvideUpdateUseNameUseCaseFactory profileUseCaseModule_ProvideUpdateUseNameUseCaseFactoryCreate = ProfileUseCaseModule_ProvideUpdateUseNameUseCaseFactory.create(profileUseCaseModule, this.profileRepositoryProvider);
            this.provideUpdateUseNameUseCaseProvider = profileUseCaseModule_ProvideUpdateUseNameUseCaseFactoryCreate;
            SettingsProfileViewModel_Factory_Factory settingsProfileViewModel_Factory_FactoryCreate = SettingsProfileViewModel_Factory_Factory.create(profileUseCaseModule_ProvideUpdateUseNameUseCaseFactoryCreate);
            this.factoryProvider3 = settingsProfileViewModel_Factory_FactoryCreate;
            this.assistFactoryProvider3 = SettingsProfileViewModel_Factory_AssistFactory_Impl.create(settingsProfileViewModel_Factory_FactoryCreate);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(ChooseRegLanguageFragment chooseRegLanguageFragment) {
            injectChooseRegLanguageFragment(chooseRegLanguageFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(LoadingLanguageSplashFragment loadingLanguageSplashFragment) {
            injectLoadingLanguageSplashFragment(loadingLanguageSplashFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(FinishSplashFragment finishSplashFragment) {
            injectFinishSplashFragment(finishSplashFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(OnBoardingFragment onBoardingFragment) {
            injectOnBoardingFragment(onBoardingFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(StoryFragment storyFragment) {
            injectStoryFragment(storyFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(StartRegistrationFragment startRegistrationFragment) {
            injectStartRegistrationFragment(startRegistrationFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(EnterPhoneFragment enterPhoneFragment) {
            injectEnterPhoneFragment(enterPhoneFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(EnterCodeFragment enterCodeFragment) {
            injectEnterCodeFragment(enterCodeFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(CountryPickerFragment countryPickerFragment) {
            injectCountryPickerFragment(countryPickerFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(AboutCodeFragment aboutCodeFragment) {
            injectAboutCodeFragment(aboutCodeFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(EnterSmsCodeFragment enterSmsCodeFragment) {
            injectEnterSmsCodeFragment(enterSmsCodeFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(EnterListenedCodeFragment enterListenedCodeFragment) {
            injectEnterListenedCodeFragment(enterListenedCodeFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(EnterNameFragment enterNameFragment) {
            injectEnterNameFragment(enterNameFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(ConnectToIntercomFragment connectToIntercomFragment) {
            injectConnectToIntercomFragment(connectToIntercomFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(ConfirmAddressFragment confirmAddressFragment) {
            injectConfirmAddressFragment(confirmAddressFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(EnterFlatNumberFragment enterFlatNumberFragment) {
            injectEnterFlatNumberFragment(enterFlatNumberFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(NotMyAddressFragment notMyAddressFragment) {
            injectNotMyAddressFragment(notMyAddressFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(SomethingWentWrongFragment somethingWentWrongFragment) {
            injectSomethingWentWrongFragment(somethingWentWrongFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(NoIntercomDialog noIntercomDialog) {
            injectNoIntercomDialog(noIntercomDialog);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(LocalizationStartBottomSheet localizationStartBottomSheet) {
            injectLocalizationStartBottomSheet(localizationStartBottomSheet);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(ReadyToConnectBottomSheet readyToConnectBottomSheet) {
            injectReadyToConnectBottomSheet(readyToConnectBottomSheet);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(LimitExceededFragment limitExceededFragment) {
            injectLimitExceededFragment(limitExceededFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(SelectAccountFragment selectAccountFragment) {
            injectSelectAccountFragment(selectAccountFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(DeleteAccountBottomSheet deleteAccountBottomSheet) {
            injectDeleteAccountBottomSheet(deleteAccountBottomSheet);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(SendUserSmsFragment sendUserSmsFragment) {
            injectSendUserSmsFragment(sendUserSmsFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment) {
            injectSendUserSmsFromOtherDeviceFragment(sendUserSmsFromOtherDeviceFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(WaitingUserSmsFragment waitingUserSmsFragment) {
            injectWaitingUserSmsFragment(waitingUserSmsFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(NeedHelpFragment needHelpFragment) {
            injectNeedHelpFragment(needHelpFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(InviteFragment inviteFragment) {
            injectInviteFragment(inviteFragment);
        }

        @Override // com.sputnik.oboarding.di.OnBoardingComponent
        public void inject(EnterTelegramCodeFragment enterTelegramCodeFragment) {
            injectEnterTelegramCodeFragment(enterTelegramCodeFragment);
        }

        private ChooseRegLanguageFragment injectChooseRegLanguageFragment(ChooseRegLanguageFragment chooseRegLanguageFragment) {
            ChooseRegLanguageFragment_MembersInjector.injectFactory(chooseRegLanguageFragment, this.multiViewModelFactoryProvider.get());
            ChooseRegLanguageFragment_MembersInjector.injectLocalizationStorage(chooseRegLanguageFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            ChooseRegLanguageFragment_MembersInjector.injectAnalytics(chooseRegLanguageFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            return chooseRegLanguageFragment;
        }

        private LoadingLanguageSplashFragment injectLoadingLanguageSplashFragment(LoadingLanguageSplashFragment loadingLanguageSplashFragment) {
            LoadingLanguageSplashFragment_MembersInjector.injectPrefManager(loadingLanguageSplashFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            LoadingLanguageSplashFragment_MembersInjector.injectLocalizationStorage(loadingLanguageSplashFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            LoadingLanguageSplashFragment_MembersInjector.injectFactory(loadingLanguageSplashFragment, this.multiViewModelFactoryProvider.get());
            return loadingLanguageSplashFragment;
        }

        private FinishSplashFragment injectFinishSplashFragment(FinishSplashFragment finishSplashFragment) {
            FinishSplashFragment_MembersInjector.injectLocalizationStorage(finishSplashFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            FinishSplashFragment_MembersInjector.injectPrefManager(finishSplashFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            FinishSplashFragment_MembersInjector.injectAnalytics(finishSplashFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            FinishSplashFragment_MembersInjector.injectFactory(finishSplashFragment, this.multiViewModelFactoryProvider.get());
            return finishSplashFragment;
        }

        private OnBoardingFragment injectOnBoardingFragment(OnBoardingFragment onBoardingFragment) {
            OnBoardingFragment_MembersInjector.injectLocalizationStorage(onBoardingFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            OnBoardingFragment_MembersInjector.injectFactory(onBoardingFragment, this.multiViewModelFactoryProvider.get());
            OnBoardingFragment_MembersInjector.injectPrefManager(onBoardingFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            OnBoardingFragment_MembersInjector.injectAnalytics(onBoardingFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            return onBoardingFragment;
        }

        private StoryFragment injectStoryFragment(StoryFragment storyFragment) {
            StoryFragment_MembersInjector.injectFactory(storyFragment, this.multiViewModelFactoryProvider.get());
            StoryFragment_MembersInjector.injectAnalytics(storyFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            StoryFragment_MembersInjector.injectPrefManager(storyFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            return storyFragment;
        }

        private StartRegistrationFragment injectStartRegistrationFragment(StartRegistrationFragment startRegistrationFragment) {
            StartRegistrationFragment_MembersInjector.injectLocalizationStorage(startRegistrationFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            StartRegistrationFragment_MembersInjector.injectFactory(startRegistrationFragment, this.multiViewModelFactoryProvider.get());
            StartRegistrationFragment_MembersInjector.injectAnalytics(startRegistrationFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            StartRegistrationFragment_MembersInjector.injectPrefManager(startRegistrationFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            StartRegistrationFragment_MembersInjector.injectCameraViewModelFactory(startRegistrationFragment, this.assistFactoryProvider.get());
            return startRegistrationFragment;
        }

        private EnterPhoneFragment injectEnterPhoneFragment(EnterPhoneFragment enterPhoneFragment) {
            EnterPhoneFragment_MembersInjector.injectAnalytics(enterPhoneFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            EnterPhoneFragment_MembersInjector.injectLocalizationStorage(enterPhoneFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            EnterPhoneFragment_MembersInjector.injectFactory(enterPhoneFragment, this.multiViewModelFactoryProvider.get());
            EnterPhoneFragment_MembersInjector.injectCameraViewModelFactory(enterPhoneFragment, this.assistFactoryProvider.get());
            return enterPhoneFragment;
        }

        private EnterCodeFragment injectEnterCodeFragment(EnterCodeFragment enterCodeFragment) {
            EnterCodeFragment_MembersInjector.injectLocalizationScreen(enterCodeFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            EnterCodeFragment_MembersInjector.injectFactory(enterCodeFragment, this.multiViewModelFactoryProvider.get());
            EnterCodeFragment_MembersInjector.injectCallCodeFactoryBuilder(enterCodeFragment, this.assistFactoryProvider2.get());
            EnterCodeFragment_MembersInjector.injectPrefManager(enterCodeFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            EnterCodeFragment_MembersInjector.injectAnalytics(enterCodeFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            EnterCodeFragment_MembersInjector.injectCameraViewModelFactory(enterCodeFragment, this.assistFactoryProvider.get());
            return enterCodeFragment;
        }

        private CountryPickerFragment injectCountryPickerFragment(CountryPickerFragment countryPickerFragment) {
            CountryPickerFragment_MembersInjector.injectFactory(countryPickerFragment, this.multiViewModelFactoryProvider.get());
            CountryPickerFragment_MembersInjector.injectLocalizationScreen(countryPickerFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            return countryPickerFragment;
        }

        private AboutCodeFragment injectAboutCodeFragment(AboutCodeFragment aboutCodeFragment) {
            AboutCodeFragment_MembersInjector.injectLocalizationStorage(aboutCodeFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            return aboutCodeFragment;
        }

        private EnterSmsCodeFragment injectEnterSmsCodeFragment(EnterSmsCodeFragment enterSmsCodeFragment) {
            EnterSmsCodeFragment_MembersInjector.injectCallCodeFactoryBuilder(enterSmsCodeFragment, this.assistFactoryProvider2.get());
            EnterSmsCodeFragment_MembersInjector.injectFactory(enterSmsCodeFragment, this.multiViewModelFactoryProvider.get());
            EnterSmsCodeFragment_MembersInjector.injectLocalizationStorage(enterSmsCodeFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            EnterSmsCodeFragment_MembersInjector.injectAnalytics(enterSmsCodeFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            EnterSmsCodeFragment_MembersInjector.injectCameraViewModelFactory(enterSmsCodeFragment, this.assistFactoryProvider.get());
            return enterSmsCodeFragment;
        }

        private EnterListenedCodeFragment injectEnterListenedCodeFragment(EnterListenedCodeFragment enterListenedCodeFragment) {
            EnterListenedCodeFragment_MembersInjector.injectLocalizationScreen(enterListenedCodeFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            EnterListenedCodeFragment_MembersInjector.injectFactory(enterListenedCodeFragment, this.multiViewModelFactoryProvider.get());
            EnterListenedCodeFragment_MembersInjector.injectCallCodeFactoryBuilder(enterListenedCodeFragment, this.assistFactoryProvider2.get());
            EnterListenedCodeFragment_MembersInjector.injectPrefManager(enterListenedCodeFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            EnterListenedCodeFragment_MembersInjector.injectAnalytics(enterListenedCodeFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            EnterListenedCodeFragment_MembersInjector.injectCameraViewModelFactory(enterListenedCodeFragment, this.assistFactoryProvider.get());
            return enterListenedCodeFragment;
        }

        private EnterNameFragment injectEnterNameFragment(EnterNameFragment enterNameFragment) {
            EnterNameFragment_MembersInjector.injectLocalizationScreen(enterNameFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            EnterNameFragment_MembersInjector.injectSettingsProfileViewModelFactory(enterNameFragment, this.assistFactoryProvider3.get());
            EnterNameFragment_MembersInjector.injectAnalytics(enterNameFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            EnterNameFragment_MembersInjector.injectFactory(enterNameFragment, this.multiViewModelFactoryProvider.get());
            return enterNameFragment;
        }

        private ConnectToIntercomFragment injectConnectToIntercomFragment(ConnectToIntercomFragment connectToIntercomFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(connectToIntercomFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(connectToIntercomFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            ConnectToIntercomFragment_MembersInjector.injectLocalizationScreen(connectToIntercomFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            ConnectToIntercomFragment_MembersInjector.injectPrefManager(connectToIntercomFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            ConnectToIntercomFragment_MembersInjector.injectFactory(connectToIntercomFragment, this.multiViewModelFactoryProvider.get());
            ConnectToIntercomFragment_MembersInjector.injectCamerasFactory(connectToIntercomFragment, this.assistFactoryProvider.get());
            ConnectToIntercomFragment_MembersInjector.injectAnalytics(connectToIntercomFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            return connectToIntercomFragment;
        }

        private ConfirmAddressFragment injectConfirmAddressFragment(ConfirmAddressFragment confirmAddressFragment) {
            ConfirmAddressFragment_MembersInjector.injectFactory(confirmAddressFragment, this.multiViewModelFactoryProvider.get());
            ConfirmAddressFragment_MembersInjector.injectLocalizationStorage(confirmAddressFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            ConfirmAddressFragment_MembersInjector.injectAnalytics(confirmAddressFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            ConfirmAddressFragment_MembersInjector.injectCamerasFactory(confirmAddressFragment, this.assistFactoryProvider.get());
            return confirmAddressFragment;
        }

        private EnterFlatNumberFragment injectEnterFlatNumberFragment(EnterFlatNumberFragment enterFlatNumberFragment) {
            EnterFlatNumberFragment_MembersInjector.injectLocalizationStorage(enterFlatNumberFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            EnterFlatNumberFragment_MembersInjector.injectFactory(enterFlatNumberFragment, this.multiViewModelFactoryProvider.get());
            EnterFlatNumberFragment_MembersInjector.injectAnalytics(enterFlatNumberFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            return enterFlatNumberFragment;
        }

        private NotMyAddressFragment injectNotMyAddressFragment(NotMyAddressFragment notMyAddressFragment) {
            NotMyAddressFragment_MembersInjector.injectLocalizationStorage(notMyAddressFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            NotMyAddressFragment_MembersInjector.injectFactory(notMyAddressFragment, this.multiViewModelFactoryProvider.get());
            NotMyAddressFragment_MembersInjector.injectAnalytics(notMyAddressFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            NotMyAddressFragment_MembersInjector.injectSupportManager(notMyAddressFragment, supportManager());
            return notMyAddressFragment;
        }

        private SomethingWentWrongFragment injectSomethingWentWrongFragment(SomethingWentWrongFragment somethingWentWrongFragment) {
            SomethingWentWrongFragment_MembersInjector.injectFactory(somethingWentWrongFragment, this.multiViewModelFactoryProvider.get());
            SomethingWentWrongFragment_MembersInjector.injectAnalytics(somethingWentWrongFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            SomethingWentWrongFragment_MembersInjector.injectLocalizationStorage(somethingWentWrongFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            SomethingWentWrongFragment_MembersInjector.injectSupportManager(somethingWentWrongFragment, supportManager());
            return somethingWentWrongFragment;
        }

        private NoIntercomDialog injectNoIntercomDialog(NoIntercomDialog noIntercomDialog) {
            NoIntercomDialog_MembersInjector.injectLocalizationScreen(noIntercomDialog, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            NoIntercomDialog_MembersInjector.injectFactory(noIntercomDialog, this.multiViewModelFactoryProvider.get());
            NoIntercomDialog_MembersInjector.injectCameraViewModelFactory(noIntercomDialog, this.assistFactoryProvider.get());
            return noIntercomDialog;
        }

        private LocalizationStartBottomSheet injectLocalizationStartBottomSheet(LocalizationStartBottomSheet localizationStartBottomSheet) {
            LocalizationStartBottomSheet_MembersInjector.injectLocalizationScreen(localizationStartBottomSheet, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            LocalizationStartBottomSheet_MembersInjector.injectFactory(localizationStartBottomSheet, this.multiViewModelFactoryProvider.get());
            return localizationStartBottomSheet;
        }

        private ReadyToConnectBottomSheet injectReadyToConnectBottomSheet(ReadyToConnectBottomSheet readyToConnectBottomSheet) {
            ReadyToConnectBottomSheet_MembersInjector.injectLocalizationStorage(readyToConnectBottomSheet, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            ReadyToConnectBottomSheet_MembersInjector.injectAnalytics(readyToConnectBottomSheet, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            return readyToConnectBottomSheet;
        }

        private LimitExceededFragment injectLimitExceededFragment(LimitExceededFragment limitExceededFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(limitExceededFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(limitExceededFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            LimitExceededFragment_MembersInjector.injectAnalytics(limitExceededFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            LimitExceededFragment_MembersInjector.injectLocalizationStorage(limitExceededFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            LimitExceededFragment_MembersInjector.injectFactory(limitExceededFragment, this.multiViewModelFactoryProvider.get());
            return limitExceededFragment;
        }

        private SelectAccountFragment injectSelectAccountFragment(SelectAccountFragment selectAccountFragment) {
            SelectAccountFragment_MembersInjector.injectLocalizationStorage(selectAccountFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            SelectAccountFragment_MembersInjector.injectFactory(selectAccountFragment, this.multiViewModelFactoryProvider.get());
            SelectAccountFragment_MembersInjector.injectAnalytics(selectAccountFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            SelectAccountFragment_MembersInjector.injectPrefManager(selectAccountFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            SelectAccountFragment_MembersInjector.injectCameraViewModelFactory(selectAccountFragment, this.assistFactoryProvider.get());
            return selectAccountFragment;
        }

        private DeleteAccountBottomSheet injectDeleteAccountBottomSheet(DeleteAccountBottomSheet deleteAccountBottomSheet) {
            DeleteAccountBottomSheet_MembersInjector.injectFactory(deleteAccountBottomSheet, this.multiViewModelFactoryProvider.get());
            DeleteAccountBottomSheet_MembersInjector.injectLocalizationScreen(deleteAccountBottomSheet, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            return deleteAccountBottomSheet;
        }

        private SendUserSmsFragment injectSendUserSmsFragment(SendUserSmsFragment sendUserSmsFragment) {
            SendUserSmsFragment_MembersInjector.injectCallCodeFactoryBuilder(sendUserSmsFragment, this.assistFactoryProvider2.get());
            SendUserSmsFragment_MembersInjector.injectFactory(sendUserSmsFragment, this.multiViewModelFactoryProvider.get());
            SendUserSmsFragment_MembersInjector.injectLocalizationStorage(sendUserSmsFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            SendUserSmsFragment_MembersInjector.injectAnalytics(sendUserSmsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            return sendUserSmsFragment;
        }

        private SendUserSmsFromOtherDeviceFragment injectSendUserSmsFromOtherDeviceFragment(SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment) {
            SendUserSmsFromOtherDeviceFragment_MembersInjector.injectCallCodeFactoryBuilder(sendUserSmsFromOtherDeviceFragment, this.assistFactoryProvider2.get());
            SendUserSmsFromOtherDeviceFragment_MembersInjector.injectFactory(sendUserSmsFromOtherDeviceFragment, this.multiViewModelFactoryProvider.get());
            SendUserSmsFromOtherDeviceFragment_MembersInjector.injectLocalizationStorage(sendUserSmsFromOtherDeviceFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            SendUserSmsFromOtherDeviceFragment_MembersInjector.injectAnalytics(sendUserSmsFromOtherDeviceFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            return sendUserSmsFromOtherDeviceFragment;
        }

        private WaitingUserSmsFragment injectWaitingUserSmsFragment(WaitingUserSmsFragment waitingUserSmsFragment) {
            WaitingUserSmsFragment_MembersInjector.injectCallCodeFactoryBuilder(waitingUserSmsFragment, this.assistFactoryProvider2.get());
            WaitingUserSmsFragment_MembersInjector.injectFactory(waitingUserSmsFragment, this.multiViewModelFactoryProvider.get());
            WaitingUserSmsFragment_MembersInjector.injectLocalizationStorage(waitingUserSmsFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            WaitingUserSmsFragment_MembersInjector.injectAnalytics(waitingUserSmsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            WaitingUserSmsFragment_MembersInjector.injectCameraViewModelFactory(waitingUserSmsFragment, this.assistFactoryProvider.get());
            return waitingUserSmsFragment;
        }

        private NeedHelpFragment injectNeedHelpFragment(NeedHelpFragment needHelpFragment) {
            NeedHelpFragment_MembersInjector.injectCallCodeFactoryBuilder(needHelpFragment, this.assistFactoryProvider2.get());
            NeedHelpFragment_MembersInjector.injectFactory(needHelpFragment, this.multiViewModelFactoryProvider.get());
            NeedHelpFragment_MembersInjector.injectLocalizationStorage(needHelpFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            NeedHelpFragment_MembersInjector.injectAnalytics(needHelpFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            NeedHelpFragment_MembersInjector.injectSupportManager(needHelpFragment, supportManager());
            return needHelpFragment;
        }

        private InviteFragment injectInviteFragment(InviteFragment inviteFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(inviteFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(inviteFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            InviteFragment_MembersInjector.injectLocalizationScreen(inviteFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            InviteFragment_MembersInjector.injectAnalytics(inviteFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            InviteFragment_MembersInjector.injectFactory(inviteFragment, this.multiViewModelFactoryProvider.get());
            InviteFragment_MembersInjector.injectCameraViewModelFactory(inviteFragment, this.assistFactoryProvider.get());
            return inviteFragment;
        }

        private EnterTelegramCodeFragment injectEnterTelegramCodeFragment(EnterTelegramCodeFragment enterTelegramCodeFragment) {
            EnterTelegramCodeFragment_MembersInjector.injectLocalizationScreen(enterTelegramCodeFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage()));
            EnterTelegramCodeFragment_MembersInjector.injectFactory(enterTelegramCodeFragment, this.multiViewModelFactoryProvider.get());
            EnterTelegramCodeFragment_MembersInjector.injectCallCodeFactoryBuilder(enterTelegramCodeFragment, this.assistFactoryProvider2.get());
            EnterTelegramCodeFragment_MembersInjector.injectPrefManager(enterTelegramCodeFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager()));
            EnterTelegramCodeFragment_MembersInjector.injectAnalytics(enterTelegramCodeFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics()));
            EnterTelegramCodeFragment_MembersInjector.injectCameraViewModelFactory(enterTelegramCodeFragment, this.assistFactoryProvider.get());
            return enterTelegramCodeFragment;
        }

        private static final class GetConfigProvider implements Provider<IConfig> {
            private final OnBoardingDeps onBoardingDeps;

            GetConfigProvider(OnBoardingDeps onBoardingDeps) {
                this.onBoardingDeps = onBoardingDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public IConfig get() {
                return (IConfig) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getConfig());
            }
        }

        private static final class GetApplicationProvider implements Provider<Application> {
            private final OnBoardingDeps onBoardingDeps;

            GetApplicationProvider(OnBoardingDeps onBoardingDeps) {
                this.onBoardingDeps = onBoardingDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public Application get() {
                return (Application) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getApplication());
            }
        }

        private static final class GetPrefManagerProvider implements Provider<PrefManager> {
            private final OnBoardingDeps onBoardingDeps;

            GetPrefManagerProvider(OnBoardingDeps onBoardingDeps) {
                this.onBoardingDeps = onBoardingDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public PrefManager get() {
                return (PrefManager) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getPrefManager());
            }
        }

        private static final class GetLocalizationStorageProvider implements Provider<LocalizationStorage> {
            private final OnBoardingDeps onBoardingDeps;

            GetLocalizationStorageProvider(OnBoardingDeps onBoardingDeps) {
                this.onBoardingDeps = onBoardingDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public LocalizationStorage get() {
                return (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getLocalizationStorage());
            }
        }

        private static final class GetAnalyticsProvider implements Provider<Analytics> {
            private final OnBoardingDeps onBoardingDeps;

            GetAnalyticsProvider(OnBoardingDeps onBoardingDeps) {
                this.onBoardingDeps = onBoardingDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public Analytics get() {
                return (Analytics) Preconditions.checkNotNullFromComponent(this.onBoardingDeps.getAnalytics());
            }
        }
    }
}
