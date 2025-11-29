package com.sputnik.service_payments.di;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment_MembersInjector;
import com.sputnik.common.di.mappers.DomainCommonListMapperModule;
import com.sputnik.common.di.mappers.DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory;
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
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.entities.stories.StoryButton;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.alerts.DomainAlertToAlertMapper_Factory;
import com.sputnik.common.mappers.archive.DomainFlussonicToFlussonicMapper_Factory;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper_Factory;
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
import com.sputnik.common.viewmodels.InstructionsViewModel;
import com.sputnik.common.viewmodels.InstructionsViewModel_Factory;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.InvitesViewModel_Factory;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.KeysViewModel_Factory;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewModel_Factory;
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
import com.sputnik.common.viewmodels.StateViewModel;
import com.sputnik.common.viewmodels.StateViewModel_Factory;
import com.sputnik.common.viewmodels.StoriesViewModel;
import com.sputnik.common.viewmodels.StoriesViewModel_Factory;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel_Factory;
import com.sputnik.data.IConfig;
import com.sputnik.data.api.AlertsApi;
import com.sputnik.data.api.CamerasApi;
import com.sputnik.data.api.InvitesApi;
import com.sputnik.data.api.LocalizationApi;
import com.sputnik.data.api.MarketApi;
import com.sputnik.data.api.PhysicalKeysApi;
import com.sputnik.data.api.PopupStoriesApi;
import com.sputnik.data.api.ProfileApi;
import com.sputnik.data.api.ServicePaymentsApi;
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
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataServiceToDomainServiceFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataStoryToDomainStoryFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory;
import com.sputnik.data.di.modules.NetworkModule;
import com.sputnik.data.di.modules.NetworkModule_ProvideAlertsApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideBaseOkHttpFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideBaseProdRetrofitFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideCamerasApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideInvitesApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideLocalizationApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideMarketApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideOkHttpFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideOkHttpNoJwtFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvidePhysicalKeysApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvidePopupStoriesApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideProdRetrofitFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideProfileApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideServicePaymentsApiFactory;
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
import com.sputnik.data.entities.service_payments.DataPaymentHistory;
import com.sputnik.data.entities.stories.DataStoriesButton;
import com.sputnik.data.entities.stories.DataStory;
import com.sputnik.data.entities.subscriptions.items.DataMarketItem;
import com.sputnik.data.entities.subscriptions.services.DataOuterService;
import com.sputnik.data.entities.subscriptions.subscriptions.DataBaseSubscription;
import com.sputnik.data.local.PrefManager;
import com.sputnik.data.mappers.alerts.DataAlertToDomainAlertMapper_Factory;
import com.sputnik.data.mappers.cameras.DataCameraToDomainCameraMapper_Factory;
import com.sputnik.data.mappers.country_code.DataCountryCodeToDomainCountryCodeMapper_Factory;
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
import com.sputnik.data.mappers.service_payments.DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper_Factory;
import com.sputnik.data.mappers.service_payments.DataPaymentHistoryToDomainPaymentHistoryMapper_Factory;
import com.sputnik.data.mappers.service_payments.DataPaymentItemToDomainPaymentItemMapper_Factory;
import com.sputnik.data.mappers.service_payments.DataPaymentReceiptToDomainPaymentReceiptMapper_Factory;
import com.sputnik.data.mappers.service_payments.DataPromisePaymentToDomainPromisePaymentMapper_Factory;
import com.sputnik.data.mappers.service_payments.DataServiceAccountInfoToDomainServiceAccountInfoMapper_Factory;
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
import com.sputnik.data.repositories.service_payments.ServicePaymentsRepository;
import com.sputnik.data.repositories.service_payments.ServicePaymentsRepository_Factory;
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
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import com.sputnik.domain.entities.stories.DomainStory;
import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import com.sputnik.domain.entities.subscriptions.services.DomainOuterService;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import com.sputnik.domain.usecases.alerts.GetAlertsUseCase;
import com.sputnik.domain.usecases.cameras.GetAllCamerasUseCase;
import com.sputnik.domain.usecases.cameras.GetCamerasDemoUseCase;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import com.sputnik.domain.usecases.cameras.OpenSecondDoorUseCase;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
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
import com.sputnik.domain.usecases.profile.VerifyAddressUseCase;
import com.sputnik.domain.usecases.service_payments.GetPaymentStatusUseCase;
import com.sputnik.domain.usecases.service_payments.GetReceiptByAccrualUseCase;
import com.sputnik.domain.usecases.service_payments.GetServiceAccountInfoUseCase;
import com.sputnik.domain.usecases.service_payments.GetServicePaymentsUseCase;
import com.sputnik.domain.usecases.service_payments.PayIntercomUseCase;
import com.sputnik.domain.usecases.service_payments.PromisePaymentUseCase;
import com.sputnik.domain.usecases.stories.GetOnBoardingStoriesUseCase;
import com.sputnik.domain.usecases.stories.GetStoriesUseCase;
import com.sputnik.service_payments.di.ServicePaymentComponent;
import com.sputnik.service_payments.di.use_cases.account.GetAccountInfoUseCaseModule;
import com.sputnik.service_payments.di.use_cases.account.GetAccountInfoUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvideGetReceiptByAccrualUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvideGetServicePaymentsUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvidePayIntercomUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvidePromisePaymentUseCaseFactory;
import com.sputnik.service_payments.mappers.DomainPaymentHistoryToPaymentHistoryMapper;
import com.sputnik.service_payments.mappers.DomainPaymentHistoryToPaymentHistoryMapper_Factory;
import com.sputnik.service_payments.mappers.DomainPromisedPaymentToPromisedPaymentMapper_Factory;
import com.sputnik.service_payments.mappers.DomainServiceAccountInfoToServiceAccountInfoMapper_Factory;
import com.sputnik.service_payments.ui.BottomSheetAboutCompany;
import com.sputnik.service_payments.ui.BottomSheetAboutCompany_MembersInjector;
import com.sputnik.service_payments.ui.BottomSheetPaymentInfo;
import com.sputnik.service_payments.ui.BottomSheetPaymentInfo_MembersInjector;
import com.sputnik.service_payments.ui.BottomSheetPaymentStop;
import com.sputnik.service_payments.ui.BottomSheetPaymentStop_MembersInjector;
import com.sputnik.service_payments.ui.DetailsPaymentFragment;
import com.sputnik.service_payments.ui.DetailsPaymentFragment_MembersInjector;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel_Factory;
import com.sputnik.service_payments.ui.SuccessPaymentFragment;
import com.sputnik.service_payments.ui.SuccessPaymentFragment_MembersInjector;
import com.sputnik.service_payments.ui.blocking.BlockingDialog;
import com.sputnik.service_payments.ui.blocking.BlockingDialog_MembersInjector;
import com.sputnik.service_payments.ui.blocking.BlockingPaymentFragment;
import com.sputnik.service_payments.ui.blocking.BlockingPaymentFragment_MembersInjector;
import com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment;
import com.sputnik.service_payments.ui.blocking.BlockingPromiseBlockFragment_MembersInjector;
import com.sputnik.service_payments.ui.blocking.BottomSheetArgueDebt;
import com.sputnik.service_payments.ui.blocking.BottomSheetArgueDebt_MembersInjector;
import com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment;
import com.sputnik.service_payments.ui.blocking.BottomSheetPromisePayment_MembersInjector;
import com.sputnik.service_payments.ui.blocking.DialogSuccessPromise;
import com.sputnik.service_payments.ui.blocking.DialogSuccessPromise_MembersInjector;
import com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment;
import com.sputnik.service_payments.ui.payment_info_list.IntercomPaymentFragment_MembersInjector;
import com.sputnik.service_payments.viewmodel.PaymentsViewModel;
import com.sputnik.service_payments.viewmodel.PaymentsViewModel_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class DaggerServicePaymentComponent {
    public static ServicePaymentComponent.Builder builder() {
        return new Builder();
    }

    private static final class Builder implements ServicePaymentComponent.Builder {
        private ServicePaymentDeps servicePaymentDeps;

        private Builder() {
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent.Builder
        public Builder deps(ServicePaymentDeps servicePaymentDeps) {
            this.servicePaymentDeps = (ServicePaymentDeps) Preconditions.checkNotNull(servicePaymentDeps);
            return this;
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent.Builder
        public ServicePaymentComponent build() {
            Preconditions.checkBuilderRequirement(this.servicePaymentDeps, ServicePaymentDeps.class);
            return new ServicePaymentComponentImpl(new PaymentsUseCaseModule(), new GetAccountInfoUseCaseModule(), new NetworkModule(), new ListMappersModule(), new DomainCommonListMapperModule(), new OnBoardingListMapperModule(), new LocalizationUseCaseModule(), new CountryCodeUseCaseModule(), new CamerasUseCaseModule(), new ProfileUseCaseModule(), new AlertsUseCaseModule(), new StoriesUseCaseModule(), new PopupStoriesUseCaseModule(), new InvitesUseCaseModule(), new SubscriptionsUseCaseModule(), new PhysicalKeysUseCaseModule(), this.servicePaymentDeps);
        }
    }

    private static final class ServicePaymentComponentImpl implements ServicePaymentComponent {
        private Provider<AlertsRepository> alertsRepositoryProvider;
        private Provider<AlertsViewModel> alertsViewModelProvider;
        private Provider<AllCamerasViewModel.Factory.AssistFactory> assistFactoryProvider;
        private Provider<CamerasRepository> camerasRepositoryProvider;
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
        private Provider<DomainPaymentHistoryToPaymentHistoryMapper> domainPaymentHistoryToPaymentHistoryMapperProvider;
        private Provider<DomainProfileToProfileMapper> domainProfileToProfileMapperProvider;
        private Provider<DomainStoryToStoryMapper> domainStoryToStoryMapperProvider;
        private AllCamerasViewModel_Factory_Factory factoryProvider;
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
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
        private Provider<MarketRepository> marketRepositoryProvider;
        private Provider<MultiViewModelFactory> multiViewModelFactoryProvider;
        private Provider<OnboardingViewModel> onboardingViewModelProvider;
        private Provider<PaymentsViewModel> paymentsViewModelProvider;
        private Provider<PhysicalKeysRepository> physicalKeysRepositoryProvider;
        private Provider<PopupStoriesRepository> popupStoriesRepositoryProvider;
        private Provider<PopupStoriesViewModel> popupStoriesViewModelProvider;
        private Provider<ProfileRepository> profileRepositoryProvider;
        private Provider<ProfileViewModel> profileViewModelProvider;
        private Provider<AcceptInviteUseCase> provideAcceptInviteUseCaseProvider;
        private Provider<AlertsApi> provideAlertsApiProvider;
        private Provider<OkHttpClient.Builder> provideBaseOkHttpProvider;
        private Provider<Retrofit> provideBaseProdRetrofitProvider;
        private Provider<BindToFlatUseCase> provideBindToFlatUseCaseProvider;
        private Provider<BlockPhysicalKeyUseCase> provideBlockPhysicalKeyUseCaseProvider;
        private Provider<CamerasApi> provideCamerasApiProvider;
        private Provider<ChangeAvatarUseCase> provideChangeAvatarUseCaseProvider;
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
        private Provider<ListMapper<DataPaymentHistory, DomainPaymentHistory>> provideDataPaymentHistoryToDomainPaymentHistoryProvider;
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
        private Provider<ListMapper<DomainLocalization, Localization>> provideDomainLocalizationToLocalizationProvider;
        private Provider<NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure>> provideDomainPopupStoriesToPopupStoriesProvider;
        private Provider<NullableInputListMapper<DomainStoriesButton, StoryButton>> provideDomainStoryButtonToStoryButtonProvider;
        private Provider<NullableInputListMapper<DomainStory, Story>> provideDomainStoryToStoryProvider;
        private Provider<GetAllCamerasUseCase> provideGetAllCamerasUseCaseProvider;
        private Provider<GetCamerasDemoUseCase> provideGetCamerasDemoUseCaseProvider;
        private Provider<GetAlertsUseCase> provideGetCamerasOrderUseCaseProvider;
        private Provider<GetCountryCodeUseCase> provideGetCountryCodeUseCaseProvider;
        private Provider<GetFamilyInvitesUseCase> provideGetFamilyInvitesUseCaseProvider;
        private Provider<GetServiceAccountInfoUseCase> provideGetIntercomCodeForRegUseCaseProvider;
        private Provider<GetInvitesUseCase> provideGetInvitesUseCaseProvider;
        private Provider<GetLocalizationUseCase> provideGetLocalizationUseCaseProvider;
        private Provider<GetMarketV2UseCase> provideGetMarketV2UseCaseProvider;
        private Provider<GetOnBoardingStoriesUseCase> provideGetOnboardingStoriesUseCaseProvider;
        private Provider<GetPaymentStatusUseCase> provideGetPaymentStatusUseCaseProvider;
        private Provider<GetPhysicalKeysUseCase> provideGetPhysicalKeysUseCaseProvider;
        private Provider<GetPopupStoriesUseCase> provideGetPopupStoriesUseCaseProvider;
        private Provider<GetProfileUseCase> provideGetProfileUseCaseProvider;
        private Provider<GetReceiptByAccrualUseCase> provideGetReceiptByAccrualUseCaseProvider;
        private Provider<GetServicePaymentsUseCase> provideGetServicePaymentsUseCaseProvider;
        private Provider<GetStoriesUseCase> provideGetStoriesUseCaseProvider;
        private Provider<InvitesApi> provideInvitesApiProvider;
        private Provider<LocalizationApi> provideLocalizationApiProvider;
        private Provider<LogoutUseCase> provideLogoutUseCaseProvider;
        private Provider<MarketApi> provideMarketApiProvider;
        private Provider<OkHttpClient> provideOkHttpNoJwtProvider;
        private Provider<OkHttpClient> provideOkHttpProvider;
        private Provider<OpenDoorUseCase> provideOpenDoorUseCaseProvider;
        private Provider<OpenSecondDoorUseCase> provideOpenSecondDoorUseCaseProvider;
        private Provider<PayIntercomUseCase> providePayIntercomUseCaseProvider;
        private Provider<PhysicalKeysApi> providePhysicalKeysApiProvider;
        private Provider<PopupStoriesApi> providePopupStoriesApiProvider;
        private Provider<Retrofit> provideProdRetrofitProvider;
        private Provider<ProfileApi> provideProfileApiProvider;
        private Provider<PromisePaymentUseCase> providePromisePaymentUseCaseProvider;
        private Provider<ResendFamilyInviteUseCase> provideResendFamilyInviteUseCaseProvider;
        private Provider<SendCallEnabledUseCase> provideSendCallEnabledUseCaseProvider;
        private Provider<SendFamilyInviteUseCase> provideSendFamilyInviteUseCaseProvider;
        private Provider<SendPopupStoriesActionUseCase> provideSendPopupStoriesUseCaseProvider;
        private Provider<SendPushTokenUseCase> provideSendPushTokenUseCaseProvider;
        private Provider<SendTimezoneUseCase> provideSendTimezoneUseCaseProvider;
        private Provider<ServicePaymentsApi> provideServicePaymentsApiProvider;
        private Provider<SetLocalizationUseCase> provideSetLocalizationUseCaseProvider;
        private Provider<StoriesApi> provideStoriesApiProvider;
        private Provider<UnblockPhysicalKeyUseCase> provideUnblockPhysicalKeyUseCaseProvider;
        private Provider<UnlinkAddressUseCase> provideUnlinkAddressUseCaseProvider;
        private Provider<UpdatePhysicalKeyCommentUseCase> provideUpdatePhysicalKeyCommentUseCaseProvider;
        private Provider<VerifyAddressUseCase> provideVerifyAddressUseCaseProvider;
        private final ServicePaymentComponentImpl servicePaymentComponentImpl;
        private final ServicePaymentDeps servicePaymentDeps;
        private Provider<ServicePaymentsRepository> servicePaymentsRepositoryProvider;
        private Provider<ServicePaymentsViewModel> servicePaymentsViewModelProvider;
        private Provider<StoriesRepository> storiesRepositoryProvider;
        private Provider<StoriesViewModel> storiesViewModelProvider;
        private Provider<SubscriptionsViewModel> subscriptionsViewModelProvider;

        private ServicePaymentComponentImpl(PaymentsUseCaseModule paymentsUseCaseModule, GetAccountInfoUseCaseModule getAccountInfoUseCaseModule, NetworkModule networkModule, ListMappersModule listMappersModule, DomainCommonListMapperModule domainCommonListMapperModule, OnBoardingListMapperModule onBoardingListMapperModule, LocalizationUseCaseModule localizationUseCaseModule, CountryCodeUseCaseModule countryCodeUseCaseModule, CamerasUseCaseModule camerasUseCaseModule, ProfileUseCaseModule profileUseCaseModule, AlertsUseCaseModule alertsUseCaseModule, StoriesUseCaseModule storiesUseCaseModule, PopupStoriesUseCaseModule popupStoriesUseCaseModule, InvitesUseCaseModule invitesUseCaseModule, SubscriptionsUseCaseModule subscriptionsUseCaseModule, PhysicalKeysUseCaseModule physicalKeysUseCaseModule, ServicePaymentDeps servicePaymentDeps) {
            this.servicePaymentComponentImpl = this;
            this.servicePaymentDeps = servicePaymentDeps;
            initialize(paymentsUseCaseModule, getAccountInfoUseCaseModule, networkModule, listMappersModule, domainCommonListMapperModule, onBoardingListMapperModule, localizationUseCaseModule, countryCodeUseCaseModule, camerasUseCaseModule, profileUseCaseModule, alertsUseCaseModule, storiesUseCaseModule, popupStoriesUseCaseModule, invitesUseCaseModule, subscriptionsUseCaseModule, physicalKeysUseCaseModule, servicePaymentDeps);
            initialize2(paymentsUseCaseModule, getAccountInfoUseCaseModule, networkModule, listMappersModule, domainCommonListMapperModule, onBoardingListMapperModule, localizationUseCaseModule, countryCodeUseCaseModule, camerasUseCaseModule, profileUseCaseModule, alertsUseCaseModule, storiesUseCaseModule, popupStoriesUseCaseModule, invitesUseCaseModule, subscriptionsUseCaseModule, physicalKeysUseCaseModule, servicePaymentDeps);
        }

        private SupportManager supportManager() {
            return new SupportManager((Application) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getApplication()));
        }

        private void initialize(PaymentsUseCaseModule paymentsUseCaseModule, GetAccountInfoUseCaseModule getAccountInfoUseCaseModule, NetworkModule networkModule, ListMappersModule listMappersModule, DomainCommonListMapperModule domainCommonListMapperModule, OnBoardingListMapperModule onBoardingListMapperModule, LocalizationUseCaseModule localizationUseCaseModule, CountryCodeUseCaseModule countryCodeUseCaseModule, CamerasUseCaseModule camerasUseCaseModule, ProfileUseCaseModule profileUseCaseModule, AlertsUseCaseModule alertsUseCaseModule, StoriesUseCaseModule storiesUseCaseModule, PopupStoriesUseCaseModule popupStoriesUseCaseModule, InvitesUseCaseModule invitesUseCaseModule, SubscriptionsUseCaseModule subscriptionsUseCaseModule, PhysicalKeysUseCaseModule physicalKeysUseCaseModule, ServicePaymentDeps servicePaymentDeps) {
            this.getPrefManagerProvider = new GetPrefManagerProvider(servicePaymentDeps);
            this.getConfigProvider = new GetConfigProvider(servicePaymentDeps);
            GetApplicationProvider getApplicationProvider = new GetApplicationProvider(servicePaymentDeps);
            this.getApplicationProvider = getApplicationProvider;
            dagger.internal.Provider provider = DoubleCheck.provider(NetworkModule_ProvideBaseOkHttpFactory.create(networkModule, getApplicationProvider, this.getPrefManagerProvider, this.getConfigProvider));
            this.provideBaseOkHttpProvider = provider;
            dagger.internal.Provider provider2 = DoubleCheck.provider(NetworkModule_ProvideOkHttpFactory.create(networkModule, provider, this.getPrefManagerProvider, this.getConfigProvider));
            this.provideOkHttpProvider = provider2;
            dagger.internal.Provider provider3 = DoubleCheck.provider(NetworkModule_ProvideProdRetrofitFactory.create(networkModule, this.getConfigProvider, provider2, this.getPrefManagerProvider));
            this.provideProdRetrofitProvider = provider3;
            this.provideServicePaymentsApiProvider = DoubleCheck.provider(NetworkModule_ProvideServicePaymentsApiFactory.create(networkModule, provider3));
            ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory listMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactoryCreate = ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory.create(listMappersModule, DataPaymentHistoryToDomainPaymentHistoryMapper_Factory.create());
            this.provideDataPaymentHistoryToDomainPaymentHistoryProvider = listMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactoryCreate;
            ServicePaymentsRepository_Factory servicePaymentsRepository_FactoryCreate = ServicePaymentsRepository_Factory.create(this.provideServicePaymentsApiProvider, listMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactoryCreate, DataPaymentHistoryToDomainPaymentHistoryMapper_Factory.create(), DataPaymentItemToDomainPaymentItemMapper_Factory.create(), DataPromisePaymentToDomainPromisePaymentMapper_Factory.create(), DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper_Factory.create(), DataServiceAccountInfoToDomainServiceAccountInfoMapper_Factory.create(), DataPaymentReceiptToDomainPaymentReceiptMapper_Factory.create());
            this.servicePaymentsRepositoryProvider = servicePaymentsRepository_FactoryCreate;
            this.provideGetServicePaymentsUseCaseProvider = PaymentsUseCaseModule_ProvideGetServicePaymentsUseCaseFactory.create(paymentsUseCaseModule, servicePaymentsRepository_FactoryCreate);
            this.provideGetIntercomCodeForRegUseCaseProvider = GetAccountInfoUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory.create(getAccountInfoUseCaseModule, this.servicePaymentsRepositoryProvider);
            this.provideGetReceiptByAccrualUseCaseProvider = PaymentsUseCaseModule_ProvideGetReceiptByAccrualUseCaseFactory.create(paymentsUseCaseModule, this.servicePaymentsRepositoryProvider);
            this.providePromisePaymentUseCaseProvider = PaymentsUseCaseModule_ProvidePromisePaymentUseCaseFactory.create(paymentsUseCaseModule, this.servicePaymentsRepositoryProvider);
            GetLocalizationStorageProvider getLocalizationStorageProvider = new GetLocalizationStorageProvider(servicePaymentDeps);
            this.getLocalizationStorageProvider = getLocalizationStorageProvider;
            DomainPaymentHistoryToPaymentHistoryMapper_Factory domainPaymentHistoryToPaymentHistoryMapper_FactoryCreate = DomainPaymentHistoryToPaymentHistoryMapper_Factory.create(getLocalizationStorageProvider);
            this.domainPaymentHistoryToPaymentHistoryMapperProvider = domainPaymentHistoryToPaymentHistoryMapper_FactoryCreate;
            this.servicePaymentsViewModelProvider = ServicePaymentsViewModel_Factory.create(this.getPrefManagerProvider, this.getConfigProvider, this.provideGetServicePaymentsUseCaseProvider, this.provideGetIntercomCodeForRegUseCaseProvider, this.provideGetReceiptByAccrualUseCaseProvider, this.providePromisePaymentUseCaseProvider, domainPaymentHistoryToPaymentHistoryMapper_FactoryCreate, DomainPromisedPaymentToPromisedPaymentMapper_Factory.create(), DomainServiceAccountInfoToServiceAccountInfoMapper_Factory.create());
            this.providePayIntercomUseCaseProvider = PaymentsUseCaseModule_ProvidePayIntercomUseCaseFactory.create(paymentsUseCaseModule, this.servicePaymentsRepositoryProvider);
            PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory paymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactoryCreate = PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory.create(paymentsUseCaseModule, this.servicePaymentsRepositoryProvider);
            this.provideGetPaymentStatusUseCaseProvider = paymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactoryCreate;
            this.paymentsViewModelProvider = PaymentsViewModel_Factory.create(this.getConfigProvider, this.getPrefManagerProvider, this.providePayIntercomUseCaseProvider, paymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactoryCreate);
            this.provideLocalizationApiProvider = DoubleCheck.provider(NetworkModule_ProvideLocalizationApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory listMappersModule_ProvideDataLocalizationToDomainLocalizationFactoryCreate = ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory.create(listMappersModule, DataLocalizationToDomainLocalizationMapper_Factory.create());
            this.provideDataLocalizationToDomainLocalizationProvider = listMappersModule_ProvideDataLocalizationToDomainLocalizationFactoryCreate;
            LocalizationRepository_Factory localizationRepository_FactoryCreate = LocalizationRepository_Factory.create(this.provideLocalizationApiProvider, listMappersModule_ProvideDataLocalizationToDomainLocalizationFactoryCreate);
            this.localizationRepositoryProvider = localizationRepository_FactoryCreate;
            this.provideGetLocalizationUseCaseProvider = LocalizationUseCaseModule_ProvideGetLocalizationUseCaseFactory.create(localizationUseCaseModule, localizationRepository_FactoryCreate);
            DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory domainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactoryCreate = DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory.create(domainCommonListMapperModule, DomainLocalizationToLocalizationMapper_Factory.create());
            this.provideDomainLocalizationToLocalizationProvider = domainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactoryCreate;
            this.localizationViewModelProvider = LocalizationViewModel_Factory.create(this.provideGetLocalizationUseCaseProvider, this.getPrefManagerProvider, this.getConfigProvider, domainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactoryCreate, this.getLocalizationStorageProvider);
            this.provideProfileApiProvider = DoubleCheck.provider(NetworkModule_ProvideProfileApiFactory.create(networkModule, this.provideProdRetrofitProvider));
            DataProfileToDomainProfileMapper_Factory dataProfileToDomainProfileMapper_FactoryCreate = DataProfileToDomainProfileMapper_Factory.create(DataProfileCardInfoToDomainProfileCardInfoMapper_Factory.create());
            this.dataProfileToDomainProfileMapperProvider = dataProfileToDomainProfileMapper_FactoryCreate;
            dagger.internal.Provider provider4 = DoubleCheck.provider(ProfileRepository_Factory.create(this.provideProfileApiProvider, dataProfileToDomainProfileMapper_FactoryCreate));
            this.profileRepositoryProvider = provider4;
            this.provideDeleteFrUseCaseProvider = ProfileUseCaseModule_ProvideDeleteFrUseCaseFactory.create(profileUseCaseModule, provider4);
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
            GetAnalyticsProvider getAnalyticsProvider = new GetAnalyticsProvider(servicePaymentDeps);
            this.getAnalyticsProvider = getAnalyticsProvider;
            this.profileViewModelProvider = ProfileViewModel_Factory.create(this.getApplicationProvider, this.provideDeleteFrUseCaseProvider, this.provideSetLocalizationUseCaseProvider, this.provideChangeAvatarUseCaseProvider, this.provideGetProfileUseCaseProvider, this.provideLogoutUseCaseProvider, this.provideDeleteAccountUseCaseProvider, this.provideVerifyAddressUseCaseProvider, this.provideDeactivateAddressUseCaseProvider, this.provideUnlinkAddressUseCaseProvider, this.provideDeactivateAccountUseCaseProvider, this.provideSendPushTokenUseCaseProvider, this.provideSendTimezoneUseCaseProvider, this.provideSendCallEnabledUseCaseProvider, this.provideBindToFlatUseCaseProvider, this.getPrefManagerProvider, this.domainProfileToProfileMapperProvider, this.getLocalizationStorageProvider, this.getConfigProvider, getAnalyticsProvider);
            dagger.internal.Provider provider5 = DoubleCheck.provider(NetworkModule_ProvideOkHttpNoJwtFactory.create(networkModule, this.provideBaseOkHttpProvider));
            this.provideOkHttpNoJwtProvider = provider5;
            dagger.internal.Provider provider6 = DoubleCheck.provider(NetworkModule_ProvideBaseProdRetrofitFactory.create(networkModule, this.getConfigProvider, provider5, this.getPrefManagerProvider));
            this.provideBaseProdRetrofitProvider = provider6;
            this.provideStoriesApiProvider = DoubleCheck.provider(NetworkModule_ProvideStoriesApiFactory.create(networkModule, provider6));
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
            this.provideDeclineInviteUseCaseProvider = InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory.create(invitesUseCaseModule, this.invitesRepositoryProvider);
            this.provideDataCountryCodeToDomainCountryCodeProvider = ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory.create(listMappersModule, DataCountryCodeToDomainCountryCodeMapper_Factory.create());
            CountryCodeRepository_Factory countryCodeRepository_FactoryCreate = CountryCodeRepository_Factory.create(CountryCodeSource_Factory.create(), this.provideDataCountryCodeToDomainCountryCodeProvider);
            this.countryCodeRepositoryProvider = countryCodeRepository_FactoryCreate;
            this.provideGetCountryCodeUseCaseProvider = CountryCodeUseCaseModule_ProvideGetCountryCodeUseCaseFactory.create(countryCodeUseCaseModule, countryCodeRepository_FactoryCreate);
            this.invitesViewModelProvider = InvitesViewModel_Factory.create(this.provideGetInvitesUseCaseProvider, this.provideGetFamilyInvitesUseCaseProvider, this.provideSendFamilyInviteUseCaseProvider, this.provideResendFamilyInviteUseCaseProvider, this.provideDeleteFamilyInviteUseCaseProvider, this.provideAcceptInviteUseCaseProvider, this.provideDeclineInviteUseCaseProvider, this.getConfigProvider, this.getPrefManagerProvider, DomainInviteToInviteMapper_Factory.create(), DomainFamilyInvitesToFamilyInvitesMapper_Factory.create(), this.provideGetCountryCodeUseCaseProvider, this.getLocalizationStorageProvider);
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
            DataMarketToDomainMarketMapper_Factory dataMarketToDomainMarketMapper_FactoryCreate = DataMarketToDomainMarketMapper_Factory.create(dataSubscriptionDetailsToDomainSubscriptionDetailsMapper_FactoryCreate, this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider);
            this.dataMarketToDomainMarketMapperProvider = dataMarketToDomainMarketMapper_FactoryCreate;
            this.provideDataMarketToDomainMarketProvider = ListMappersModule_ProvideDataMarketToDomainMarketFactory.create(listMappersModule, dataMarketToDomainMarketMapper_FactoryCreate);
            this.dataBaseSubscriptionToDomainBaseSubscriptionMapperProvider = DataBaseSubscriptionToDomainBaseSubscriptionMapper_Factory.create(DataBaseAppearanceToDomainAppearanceMapper_Factory.create());
        }

        private void initialize2(PaymentsUseCaseModule paymentsUseCaseModule, GetAccountInfoUseCaseModule getAccountInfoUseCaseModule, NetworkModule networkModule, ListMappersModule listMappersModule, DomainCommonListMapperModule domainCommonListMapperModule, OnBoardingListMapperModule onBoardingListMapperModule, LocalizationUseCaseModule localizationUseCaseModule, CountryCodeUseCaseModule countryCodeUseCaseModule, CamerasUseCaseModule camerasUseCaseModule, ProfileUseCaseModule profileUseCaseModule, AlertsUseCaseModule alertsUseCaseModule, StoriesUseCaseModule storiesUseCaseModule, PopupStoriesUseCaseModule popupStoriesUseCaseModule, InvitesUseCaseModule invitesUseCaseModule, SubscriptionsUseCaseModule subscriptionsUseCaseModule, PhysicalKeysUseCaseModule physicalKeysUseCaseModule, ServicePaymentDeps servicePaymentDeps) {
            this.provideDataMarketV2ToDomainMarketV2Provider = ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory.create(listMappersModule, this.dataBaseSubscriptionToDomainBaseSubscriptionMapperProvider);
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
            MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(14).put((MapProviderFactory.Builder) ServicePaymentsViewModel.class, (Provider) this.servicePaymentsViewModelProvider).put((MapProviderFactory.Builder) PaymentsViewModel.class, (Provider) this.paymentsViewModelProvider).put((MapProviderFactory.Builder) LocalizationViewModel.class, (Provider) this.localizationViewModelProvider).put((MapProviderFactory.Builder) ProfileViewModel.class, (Provider) this.profileViewModelProvider).put((MapProviderFactory.Builder) StoriesViewModel.class, (Provider) this.storiesViewModelProvider).put((MapProviderFactory.Builder) AlertsViewModel.class, (Provider) this.alertsViewModelProvider).put((MapProviderFactory.Builder) NavigationViewModel.class, (Provider) NavigationViewModel_Factory.create()).put((MapProviderFactory.Builder) StateViewModel.class, (Provider) StateViewModel_Factory.create()).put((MapProviderFactory.Builder) OnboardingViewModel.class, (Provider) this.onboardingViewModelProvider).put((MapProviderFactory.Builder) InvitesViewModel.class, (Provider) this.invitesViewModelProvider).put((MapProviderFactory.Builder) PopupStoriesViewModel.class, (Provider) this.popupStoriesViewModelProvider).put((MapProviderFactory.Builder) InstructionsViewModel.class, (Provider) this.instructionsViewModelProvider).put((MapProviderFactory.Builder) SubscriptionsViewModel.class, (Provider) this.subscriptionsViewModelProvider).put((MapProviderFactory.Builder) KeysViewModel.class, (Provider) this.keysViewModelProvider).build();
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
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(BlockingDialog blockingDialog) {
            injectBlockingDialog(blockingDialog);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(BlockingPaymentFragment blockingPaymentFragment) {
            injectBlockingPaymentFragment(blockingPaymentFragment);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(BlockingPromiseBlockFragment blockingPromiseBlockFragment) {
            injectBlockingPromiseBlockFragment(blockingPromiseBlockFragment);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(BottomSheetArgueDebt bottomSheetArgueDebt) {
            injectBottomSheetArgueDebt(bottomSheetArgueDebt);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(DetailsPaymentFragment detailsPaymentFragment) {
            injectDetailsPaymentFragment(detailsPaymentFragment);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(IntercomPaymentFragment intercomPaymentFragment) {
            injectIntercomPaymentFragment(intercomPaymentFragment);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(SuccessPaymentFragment successPaymentFragment) {
            injectSuccessPaymentFragment(successPaymentFragment);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(BottomSheetPaymentInfo bottomSheetPaymentInfo) {
            injectBottomSheetPaymentInfo(bottomSheetPaymentInfo);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(BottomSheetPaymentStop bottomSheetPaymentStop) {
            injectBottomSheetPaymentStop(bottomSheetPaymentStop);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(BottomSheetPromisePayment bottomSheetPromisePayment) {
            injectBottomSheetPromisePayment(bottomSheetPromisePayment);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(DialogSuccessPromise dialogSuccessPromise) {
            injectDialogSuccessPromise(dialogSuccessPromise);
        }

        @Override // com.sputnik.service_payments.di.ServicePaymentComponent
        public void inject(BottomSheetAboutCompany bottomSheetAboutCompany) {
            injectBottomSheetAboutCompany(bottomSheetAboutCompany);
        }

        private BlockingDialog injectBlockingDialog(BlockingDialog blockingDialog) {
            BlockingDialog_MembersInjector.injectLocalizationStorage(blockingDialog, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            BlockingDialog_MembersInjector.injectFactory(blockingDialog, this.multiViewModelFactoryProvider.get());
            BlockingDialog_MembersInjector.injectAnalytics(blockingDialog, (Analytics) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getAnalytics()));
            return blockingDialog;
        }

        private BlockingPaymentFragment injectBlockingPaymentFragment(BlockingPaymentFragment blockingPaymentFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(blockingPaymentFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(blockingPaymentFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getPrefManager()));
            BlockingPaymentFragment_MembersInjector.injectLocalizationStorage(blockingPaymentFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            BlockingPaymentFragment_MembersInjector.injectFactory(blockingPaymentFragment, this.multiViewModelFactoryProvider.get());
            BlockingPaymentFragment_MembersInjector.injectAnalytics(blockingPaymentFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getAnalytics()));
            return blockingPaymentFragment;
        }

        private BlockingPromiseBlockFragment injectBlockingPromiseBlockFragment(BlockingPromiseBlockFragment blockingPromiseBlockFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(blockingPromiseBlockFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(blockingPromiseBlockFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getPrefManager()));
            BlockingPromiseBlockFragment_MembersInjector.injectLocalizationStorage(blockingPromiseBlockFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            BlockingPromiseBlockFragment_MembersInjector.injectFactory(blockingPromiseBlockFragment, this.multiViewModelFactoryProvider.get());
            BlockingPromiseBlockFragment_MembersInjector.injectAnalytics(blockingPromiseBlockFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getAnalytics()));
            return blockingPromiseBlockFragment;
        }

        private BottomSheetArgueDebt injectBottomSheetArgueDebt(BottomSheetArgueDebt bottomSheetArgueDebt) {
            BottomSheetArgueDebt_MembersInjector.injectLocalizationStorage(bottomSheetArgueDebt, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            BottomSheetArgueDebt_MembersInjector.injectFactory(bottomSheetArgueDebt, this.multiViewModelFactoryProvider.get());
            BottomSheetArgueDebt_MembersInjector.injectSupportManager(bottomSheetArgueDebt, supportManager());
            return bottomSheetArgueDebt;
        }

        private DetailsPaymentFragment injectDetailsPaymentFragment(DetailsPaymentFragment detailsPaymentFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(detailsPaymentFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(detailsPaymentFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getPrefManager()));
            DetailsPaymentFragment_MembersInjector.injectLocalizationStorage(detailsPaymentFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            DetailsPaymentFragment_MembersInjector.injectFactory(detailsPaymentFragment, this.multiViewModelFactoryProvider.get());
            DetailsPaymentFragment_MembersInjector.injectAnalytics(detailsPaymentFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getAnalytics()));
            return detailsPaymentFragment;
        }

        private IntercomPaymentFragment injectIntercomPaymentFragment(IntercomPaymentFragment intercomPaymentFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(intercomPaymentFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(intercomPaymentFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getPrefManager()));
            IntercomPaymentFragment_MembersInjector.injectLocalizationStorage(intercomPaymentFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            IntercomPaymentFragment_MembersInjector.injectFactory(intercomPaymentFragment, this.multiViewModelFactoryProvider.get());
            IntercomPaymentFragment_MembersInjector.injectAnalytics(intercomPaymentFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getAnalytics()));
            return intercomPaymentFragment;
        }

        private SuccessPaymentFragment injectSuccessPaymentFragment(SuccessPaymentFragment successPaymentFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(successPaymentFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(successPaymentFragment, (PrefManager) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getPrefManager()));
            SuccessPaymentFragment_MembersInjector.injectFactory(successPaymentFragment, this.multiViewModelFactoryProvider.get());
            SuccessPaymentFragment_MembersInjector.injectLocalizationStorage(successPaymentFragment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            SuccessPaymentFragment_MembersInjector.injectAnalytics(successPaymentFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getAnalytics()));
            SuccessPaymentFragment_MembersInjector.injectCameraViewModelFactory(successPaymentFragment, this.assistFactoryProvider.get());
            return successPaymentFragment;
        }

        private BottomSheetPaymentInfo injectBottomSheetPaymentInfo(BottomSheetPaymentInfo bottomSheetPaymentInfo) {
            BottomSheetPaymentInfo_MembersInjector.injectLocalizationStorage(bottomSheetPaymentInfo, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            return bottomSheetPaymentInfo;
        }

        private BottomSheetPaymentStop injectBottomSheetPaymentStop(BottomSheetPaymentStop bottomSheetPaymentStop) {
            BottomSheetPaymentStop_MembersInjector.injectLocalizationStorage(bottomSheetPaymentStop, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            return bottomSheetPaymentStop;
        }

        private BottomSheetPromisePayment injectBottomSheetPromisePayment(BottomSheetPromisePayment bottomSheetPromisePayment) {
            BottomSheetPromisePayment_MembersInjector.injectFactory(bottomSheetPromisePayment, this.multiViewModelFactoryProvider.get());
            BottomSheetPromisePayment_MembersInjector.injectLocalizationStorage(bottomSheetPromisePayment, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            BottomSheetPromisePayment_MembersInjector.injectAnalytics(bottomSheetPromisePayment, (Analytics) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getAnalytics()));
            return bottomSheetPromisePayment;
        }

        private DialogSuccessPromise injectDialogSuccessPromise(DialogSuccessPromise dialogSuccessPromise) {
            DialogSuccessPromise_MembersInjector.injectLocalizationScreen(dialogSuccessPromise, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            DialogSuccessPromise_MembersInjector.injectFactory(dialogSuccessPromise, this.multiViewModelFactoryProvider.get());
            DialogSuccessPromise_MembersInjector.injectCameraViewModelFactory(dialogSuccessPromise, this.assistFactoryProvider.get());
            return dialogSuccessPromise;
        }

        private BottomSheetAboutCompany injectBottomSheetAboutCompany(BottomSheetAboutCompany bottomSheetAboutCompany) {
            BottomSheetAboutCompany_MembersInjector.injectLocalizationStorage(bottomSheetAboutCompany, (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage()));
            BottomSheetAboutCompany_MembersInjector.injectFactory(bottomSheetAboutCompany, this.multiViewModelFactoryProvider.get());
            return bottomSheetAboutCompany;
        }

        private static final class GetPrefManagerProvider implements Provider<PrefManager> {
            private final ServicePaymentDeps servicePaymentDeps;

            GetPrefManagerProvider(ServicePaymentDeps servicePaymentDeps) {
                this.servicePaymentDeps = servicePaymentDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public PrefManager get() {
                return (PrefManager) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getPrefManager());
            }
        }

        private static final class GetConfigProvider implements Provider<IConfig> {
            private final ServicePaymentDeps servicePaymentDeps;

            GetConfigProvider(ServicePaymentDeps servicePaymentDeps) {
                this.servicePaymentDeps = servicePaymentDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public IConfig get() {
                return (IConfig) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getConfig());
            }
        }

        private static final class GetApplicationProvider implements Provider<Application> {
            private final ServicePaymentDeps servicePaymentDeps;

            GetApplicationProvider(ServicePaymentDeps servicePaymentDeps) {
                this.servicePaymentDeps = servicePaymentDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public Application get() {
                return (Application) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getApplication());
            }
        }

        private static final class GetLocalizationStorageProvider implements Provider<LocalizationStorage> {
            private final ServicePaymentDeps servicePaymentDeps;

            GetLocalizationStorageProvider(ServicePaymentDeps servicePaymentDeps) {
                this.servicePaymentDeps = servicePaymentDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public LocalizationStorage get() {
                return (LocalizationStorage) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getLocalizationStorage());
            }
        }

        private static final class GetAnalyticsProvider implements Provider<Analytics> {
            private final ServicePaymentDeps servicePaymentDeps;

            GetAnalyticsProvider(ServicePaymentDeps servicePaymentDeps) {
                this.servicePaymentDeps = servicePaymentDeps;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public Analytics get() {
                return (Analytics) Preconditions.checkNotNullFromComponent(this.servicePaymentDeps.getAnalytics());
            }
        }
    }
}
