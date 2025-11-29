package sputnik.axmor.com.sputnik.di;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.analytics.AppMetricaAnalyticsTracker;
import com.sputnik.common.analytics.FirebaseAnalyticsTracker;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.BaseFragment_MembersInjector;
import com.sputnik.common.di.localization_storage.LocalizationStorageModule;
import com.sputnik.common.di.localization_storage.LocalizationStorageModule_ProvideCoroutineScopeFactory;
import com.sputnik.common.di.localization_storage.LocalizationStorageModule_ProvideLocalizationStorageFactory;
import com.sputnik.common.di.localization_storage.LocalizationStorageModule_ProvidesErrorHandlerFactory;
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
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule_ProvideGetCameraByIntercomUUIDUseCaseFactory;
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule_ProvideGetCamerasDemoUseCaseFactory;
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule_ProvideOpenDoorUseCaseFactory;
import com.sputnik.common.di.use_cases.cameras.CamerasUseCaseModule_ProvideOpenSecondDoorUseCaseFactory;
import com.sputnik.common.di.use_cases.gorserv.GorservUseCaseModule;
import com.sputnik.common.di.use_cases.gorserv.GorservUseCaseModule_ProvideCreateGorservTicketUseCaseFactory;
import com.sputnik.common.di.use_cases.gorserv.GorservUseCaseModule_ProvideGetGorservCatalogsUseCaseFactory;
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
import com.sputnik.common.di.use_cases.notifications.NotificationsUseCaseModule;
import com.sputnik.common.di.use_cases.notifications.NotificationsUseCaseModule_ProvideGetNotificationUseCaseFactory;
import com.sputnik.common.di.use_cases.notifications.NotificationsUseCaseModule_ProvideGetNotificationsUseCaseFactory;
import com.sputnik.common.di.use_cases.notifications.NotificationsUseCaseModule_ProvideGetUnviewedNotificationsUseCaseFactory;
import com.sputnik.common.di.use_cases.notifications.NotificationsUseCaseModule_ProvideUpdateNotificationUseCaseFactory;
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
import com.sputnik.common.di.use_cases.profile.ProfileUseCaseModule_ProvideResetAddressUseCaseFactory;
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
import com.sputnik.common.di.use_cases.support.SupportUseCaseModule;
import com.sputnik.common.di.use_cases.support.SupportUseCaseModule_ProvideGetAnnounceUseCaseFactory;
import com.sputnik.common.di.use_cases.support.SupportUseCaseModule_ProvideGetCompanyContactsUseCaseFactory;
import com.sputnik.common.di.use_cases.support.SupportUseCaseModule_ProvideGetFaq2UseCaseFactory;
import com.sputnik.common.di.use_cases.support.SupportUseCaseModule_ProvideGetFaqUseCaseFactory;
import com.sputnik.common.di.use_cases.surveys.SurveysUseCaseModule;
import com.sputnik.common.di.use_cases.surveys.SurveysUseCaseModule_ProvideGetSurveyUseCaseFactory;
import com.sputnik.common.di.use_cases.surveys.SurveysUseCaseModule_ProvideGetSurveysUseCaseFactory;
import com.sputnik.common.di.use_cases.tiles.TilesUseCaseModule;
import com.sputnik.common.di.use_cases.tiles.TilesUseCaseModule_ProvideGetTilesUseCaseFactory;
import com.sputnik.common.entities.archive.Flussonic;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.entities.market.market.SmallServices;
import com.sputnik.common.entities.market.market.SubsPlans;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.entities.stories.StoryButton;
import com.sputnik.common.entities.surveys.Survey;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.alerts.DomainAlertToAlertMapper;
import com.sputnik.common.mappers.archive.DomainFlussonicToFlussonicMapper;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper;
import com.sputnik.common.mappers.faq.DomainFaqToFaqMapper;
import com.sputnik.common.mappers.gorserv.DomainGorservCatalogToGorservCatalogMapper;
import com.sputnik.common.mappers.gorserv.DomainGorservCreateTicketToGorservCreateTicketMapper;
import com.sputnik.common.mappers.invites.DomainFamilyInvitesToFamilyInvitesMapper;
import com.sputnik.common.mappers.invites.DomainInviteToInviteMapper;
import com.sputnik.common.mappers.keys.DomainPhysicalKeyToPhysicalKeyMapper;
import com.sputnik.common.mappers.localization.DomainLocalizationToLocalizationMapper;
import com.sputnik.common.mappers.notifications.DomainNotificationToNotificationMapper;
import com.sputnik.common.mappers.popup.DomainPopupStoriesToPopupStoriesMapper;
import com.sputnik.common.mappers.profile.DomainProfileCardInfoToProfileCardInfoMapper;
import com.sputnik.common.mappers.profile.DomainProfileToProfileMapper;
import com.sputnik.common.mappers.stories.DomainStoryButtonToStoryButtonMapper;
import com.sputnik.common.mappers.stories.DomainStoryToStoryMapper;
import com.sputnik.common.mappers.subscriptions.DomainBaseAppearanceToBaseAppearanceMapper;
import com.sputnik.common.mappers.subscriptions.DomainBaseSubscriptionToBaseSubscriptionMapper;
import com.sputnik.common.mappers.subscriptions.DomainMarketItemToMarketItemMapper;
import com.sputnik.common.mappers.subscriptions.DomainOuterServiceAppearanceToOuterServiceAppearanceMapper;
import com.sputnik.common.mappers.subscriptions.DomainOuterServiceToOuterServiceMapper;
import com.sputnik.common.mappers.surveys.DomainSurveyToSurveyMapper;
import com.sputnik.common.support.SupportManager;
import com.sputnik.common.viewmodels.AlertsViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.FaqViewModel;
import com.sputnik.common.viewmodels.GorservViewModel;
import com.sputnik.common.viewmodels.InstructionsViewModel;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NotificationsViewModel;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.common.viewmodels.PopupStoriesViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.common.viewmodels.StateViewModel;
import com.sputnik.common.viewmodels.StoriesViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SurveysViewModel;
import com.sputnik.common.viewmodels.TilesViewModel;
import com.sputnik.data.IConfig;
import com.sputnik.data.api.AddressApi;
import com.sputnik.data.api.AlertsApi;
import com.sputnik.data.api.CallApi;
import com.sputnik.data.api.CamerasApi;
import com.sputnik.data.api.CardApi;
import com.sputnik.data.api.DigitalKeysApi;
import com.sputnik.data.api.EventApi;
import com.sputnik.data.api.FamilyApi;
import com.sputnik.data.api.GorservApi;
import com.sputnik.data.api.HelpApi;
import com.sputnik.data.api.InvitesApi;
import com.sputnik.data.api.LocalizationApi;
import com.sputnik.data.api.MarketApi;
import com.sputnik.data.api.NotificationsApi;
import com.sputnik.data.api.PhysicalKeysApi;
import com.sputnik.data.api.PopupStoriesApi;
import com.sputnik.data.api.ProfileApi;
import com.sputnik.data.api.ServicePaymentsApi;
import com.sputnik.data.api.ServicesApi;
import com.sputnik.data.api.StoriesApi;
import com.sputnik.data.api.SubscriptionApi;
import com.sputnik.data.api.SupportApi;
import com.sputnik.data.api.SurveyApi;
import com.sputnik.data.api.TilesApi;
import com.sputnik.data.di.modules.ListMappersModule;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataAlertToDomainAlertFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataArchiveToDomainArchiveFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataCameraPreferencesToDomainCameraPreferencesFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataCameraToDomainCameraFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataCompanyToDomainCompanyFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataCustomAddressToDomainCustomAddressFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataDigitalKeyToDomainDigitalKeyFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataFamilyToDomainFamilyFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataFaqToDomainFaqFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataFlussonicToDomainFlussonicFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataGorservCatalogToDomainGorservCatalogFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataInviteToDomainInviteFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataMarketItemToDomainMarketItemMapperFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataMarketToDomainMarketFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataNotificationToDomainNotificationFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataOuterServiceToDomainOuterServiceMapperFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataServiceToDomainServiceFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataStoryToDomainStoryFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSubscriptionInfoToDomainSubscriptionInfoFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory;
import com.sputnik.data.di.modules.ListMappersModule_ProvideDataSurveyToDomainSurveyFactory;
import com.sputnik.data.di.modules.NetworkModule;
import com.sputnik.data.di.modules.NetworkModule_ProvideAddressApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideAlertsApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideBaseOkHttpFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideBaseProdRetrofitFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideCallApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideCamerasApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideCardApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideDigitalKeysApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideEventApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideFamilyApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideFaqApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideGorservApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideHelpApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideInvitesApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideLocalizationApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideMarketApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideNotificationsApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideOkHttpFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideOkHttpNoJwtFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvidePhysicalKeysApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvidePopupStoriesApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideProdRetrofitFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideProfileApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideServicePaymentsApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideServicesApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideStoriesApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideSubscriptionApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideSurveyApiFactory;
import com.sputnik.data.di.modules.NetworkModule_ProvideTilesApiFactory;
import com.sputnik.data.entities.address.DataCustomAddress;
import com.sputnik.data.entities.alerts.DataAlert;
import com.sputnik.data.entities.archive.DataArchiveResponse;
import com.sputnik.data.entities.archive.DataFlussonic;
import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.data.entities.cameras.DataCamerasOrder;
import com.sputnik.data.entities.company.DataCompany;
import com.sputnik.data.entities.country_code.DataCountryCode;
import com.sputnik.data.entities.digital_keys.DataDigitalKey;
import com.sputnik.data.entities.family.DataFamily;
import com.sputnik.data.entities.faq.DataFaq;
import com.sputnik.data.entities.gorserv.DataGorservCatalog;
import com.sputnik.data.entities.invites.DataInvite;
import com.sputnik.data.entities.localization.DataLocalization;
import com.sputnik.data.entities.market.DataMarket;
import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.data.entities.market.DataSubsPlans;
import com.sputnik.data.entities.market.service.DataService;
import com.sputnik.data.entities.market.subscription.DataSubscription;
import com.sputnik.data.entities.market.subscription.DataSubscriptionInfo;
import com.sputnik.data.entities.notifications.DataNotification;
import com.sputnik.data.entities.popups.DataPopupStoryStructure;
import com.sputnik.data.entities.service_payments.DataPaymentHistory;
import com.sputnik.data.entities.stories.DataStoriesButton;
import com.sputnik.data.entities.stories.DataStory;
import com.sputnik.data.entities.subscriptions.items.DataMarketItem;
import com.sputnik.data.entities.subscriptions.services.DataOuterService;
import com.sputnik.data.entities.subscriptions.subscriptions.DataBaseSubscription;
import com.sputnik.data.entities.survey.DataSurvey;
import com.sputnik.data.local.PrefManager;
import com.sputnik.data.mappers.address.DataCustomAddressToDomainCustomAddressMapper;
import com.sputnik.data.mappers.alerts.DataAlertToDomainAlertMapper;
import com.sputnik.data.mappers.archive.DataArchiveItemToDomainArchiveItemMapper;
import com.sputnik.data.mappers.archive.DataArchiveToDomainArchiveMapper;
import com.sputnik.data.mappers.archive.DataFlussonicToDomainFlussonicMapper;
import com.sputnik.data.mappers.call.DataCallToDomainCallMapper;
import com.sputnik.data.mappers.call.DataSipCallToDomainSipCallMapper;
import com.sputnik.data.mappers.call_history.DataCallHistoryToDomainCallHistoryMapper;
import com.sputnik.data.mappers.cameras.DataCameraObjectToDomainCameraObjectMapper;
import com.sputnik.data.mappers.cameras.DataCameraToDomainCameraMapper;
import com.sputnik.data.mappers.cameras.DataCamerasOrderToDomainCamerasOrderMapper;
import com.sputnik.data.mappers.cameras.DomainCameraObjectToDataCameraObjectMapper;
import com.sputnik.data.mappers.cameras.DomainCamerasOrderToDataCamerasOrderMapper;
import com.sputnik.data.mappers.card.DataConfirmationToDomainConfirmationMapper;
import com.sputnik.data.mappers.card.DataPaymentStateToDomainPaymentStateMapper;
import com.sputnik.data.mappers.company.DataCompanyToDomainCompanyMapper;
import com.sputnik.data.mappers.country_code.DataCountryCodeToDomainCountryCodeMapper;
import com.sputnik.data.mappers.digital_keys.DataDigitalKeyToDomainDigitalKeyMapper;
import com.sputnik.data.mappers.family.DataFamilyToDomainFamilyMapper;
import com.sputnik.data.mappers.faq.DataFaqToDomainFaqMapper;
import com.sputnik.data.mappers.gorserv.DataGorservCatalogToDomainGorservCatalogMapper;
import com.sputnik.data.mappers.gorserv.DataGorservCreateTicketToDomainGorservCreateTicketMapper;
import com.sputnik.data.mappers.invites.DataFamilyInvitesToDomainFamilyInvitesMapper;
import com.sputnik.data.mappers.invites.DataInviteToDomainInviteMapper;
import com.sputnik.data.mappers.keys.DataPhysicalKeyToDomainPhysicalKeyMapper;
import com.sputnik.data.mappers.localization.DataLocalizationToDomainLocalizationMapper;
import com.sputnik.data.mappers.market.DataAppearancePlansToDomainAppearancePlansMapper;
import com.sputnik.data.mappers.market.DataDetailedLayoutToDomainDetailedLayoutMapper;
import com.sputnik.data.mappers.market.DataIncludedServiceToDomainIncludedServiceMapper;
import com.sputnik.data.mappers.market.DataMarketToDomainMarketMapper;
import com.sputnik.data.mappers.market.DataOriginSubToDomainOriginSubMapper;
import com.sputnik.data.mappers.market.DataPlanAppearanceToDomainPlanAppearanceMapper;
import com.sputnik.data.mappers.market.DataPlansToDomainPlansMapper;
import com.sputnik.data.mappers.market.DataServiceAppearanceToDomainServiceAppearanceMapper;
import com.sputnik.data.mappers.market.DataServiceToDomainServiceMapper;
import com.sputnik.data.mappers.market.DataSmallServiceToDomainSmallServiceMapper;
import com.sputnik.data.mappers.market.DataSubsPlansToDomainSubsPlansMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionDetailsToDomainSubscriptionDetailsMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionInfoToDomainSubscriptionInfoMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionStartToDomainSubscriptionStartMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionToDomainSubscriptionMapper;
import com.sputnik.data.mappers.notifications.DataNotificationtToDomainNotificationMapper;
import com.sputnik.data.mappers.popups.DataPopupStoryToDomainPopupStoryMapper;
import com.sputnik.data.mappers.profile.DataProfileCardInfoToDomainProfileCardInfoMapper;
import com.sputnik.data.mappers.profile.DataProfileToDomainProfileMapper;
import com.sputnik.data.mappers.service_payments.DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentHistoryToDomainPaymentHistoryMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentItemToDomainPaymentItemMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentReceiptToDomainPaymentReceiptMapper;
import com.sputnik.data.mappers.service_payments.DataPromisePaymentToDomainPromisePaymentMapper;
import com.sputnik.data.mappers.service_payments.DataServiceAccountInfoToDomainServiceAccountInfoMapper;
import com.sputnik.data.mappers.stories.DataStoriesButtonToDomainStoriesButtonMapper;
import com.sputnik.data.mappers.stories.DataStoryToDomainStoryMapper;
import com.sputnik.data.mappers.subscriptions.DataBaseAppearanceToDomainAppearanceMapper;
import com.sputnik.data.mappers.subscriptions.DataBaseSubscriptionToDomainBaseSubscriptionMapper;
import com.sputnik.data.mappers.subscriptions.DataMarketItemToDomainMarketItemMapper;
import com.sputnik.data.mappers.subscriptions.DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper;
import com.sputnik.data.mappers.subscriptions.DataOuterServiceToDomainOuterServiceMapper;
import com.sputnik.data.mappers.survey.DataSurveyResultToDomainSurveyResultMapper;
import com.sputnik.data.mappers.survey.DataSurveyToDomainSurveyMapper;
import com.sputnik.data.repositories.address.AddressRepository;
import com.sputnik.data.repositories.alerts.AlertsRepository;
import com.sputnik.data.repositories.archive.ArchiveRepository;
import com.sputnik.data.repositories.call.CallRepository;
import com.sputnik.data.repositories.call_history.CallHistoryPageSource;
import com.sputnik.data.repositories.call_history.CallHistoryRepository;
import com.sputnik.data.repositories.cameras.CamerasRepository;
import com.sputnik.data.repositories.card.CardRepository;
import com.sputnik.data.repositories.country_code.CountryCodeRepository;
import com.sputnik.data.repositories.country_code.CountryCodeSource;
import com.sputnik.data.repositories.digital_keys.DigitalKeysRepository;
import com.sputnik.data.repositories.event.EventRepository;
import com.sputnik.data.repositories.family.FamilyRepository;
import com.sputnik.data.repositories.faq.SupportRepository;
import com.sputnik.data.repositories.fr_service.FrServiceRepository;
import com.sputnik.data.repositories.gorserv.GorservRepository;
import com.sputnik.data.repositories.help.HelpRepository;
import com.sputnik.data.repositories.invites.InvitesRepository;
import com.sputnik.data.repositories.keys.PhysicalKeysRepository;
import com.sputnik.data.repositories.localization.LocalizationRepository;
import com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository;
import com.sputnik.data.repositories.market.MarketRepository;
import com.sputnik.data.repositories.notifications.NotificationsRepository;
import com.sputnik.data.repositories.popups.PopupStoriesRepository;
import com.sputnik.data.repositories.profile.ProfileRepository;
import com.sputnik.data.repositories.service_payments.ServicePaymentsRepository;
import com.sputnik.data.repositories.stories.StoriesRepository;
import com.sputnik.data.repositories.subscription.SubscriptionRepository;
import com.sputnik.data.repositories.survey.SurveyRepository;
import com.sputnik.data.repositories.tiles.TilesRepository;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import com.sputnik.domain.entities.alers.DomainAlert;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import com.sputnik.domain.entities.archive.DomainFlussonic;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import com.sputnik.domain.entities.company.DomainCompany;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import com.sputnik.domain.entities.digital_keys.DomainDigitalKey;
import com.sputnik.domain.entities.family.DomainFamily;
import com.sputnik.domain.entities.faq.DomainFaq;
import com.sputnik.domain.entities.gorserv.DomainGorservCatalog;
import com.sputnik.domain.entities.invites.DomainInvite;
import com.sputnik.domain.entities.localization.DomainLocalization;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.DomainSubsPlans;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionInfo;
import com.sputnik.domain.entities.notifications.DomainNotification;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import com.sputnik.domain.entities.stories.DomainStory;
import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import com.sputnik.domain.entities.subscriptions.services.DomainOuterService;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import com.sputnik.domain.entities.survey.DomainSurvey;
import com.sputnik.domain.usecases.address.DeleteCustomAddressUseCase;
import com.sputnik.domain.usecases.address.GetCustomAddressUseCase;
import com.sputnik.domain.usecases.address.SetCustomAddressUseCase;
import com.sputnik.domain.usecases.address.UpdateCustomAddressUseCase;
import com.sputnik.domain.usecases.alerts.GetAlertsUseCase;
import com.sputnik.domain.usecases.archive.GetArchiveSdkUrlUseCase;
import com.sputnik.domain.usecases.archive.GetArchiveUrlsUseCase;
import com.sputnik.domain.usecases.call.AcceptCallUseCase;
import com.sputnik.domain.usecases.call.GetCallUseCase;
import com.sputnik.domain.usecases.call.GetSipAccountUseCase;
import com.sputnik.domain.usecases.cameras.GetAllCamerasUseCase;
import com.sputnik.domain.usecases.cameras.GetCameraByIntercomUUIDUseCase;
import com.sputnik.domain.usecases.cameras.GetCamerasDemoUseCase;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import com.sputnik.domain.usecases.cameras.OpenSecondDoorUseCase;
import com.sputnik.domain.usecases.card.AddNewCardUseCase;
import com.sputnik.domain.usecases.card.GetLastCardPaymentUseCase;
import com.sputnik.domain.usecases.card.RemoveCardUseCase;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
import com.sputnik.domain.usecases.digital_keys.DeleteDigitalKeyForAddressUseCase;
import com.sputnik.domain.usecases.digital_keys.GetDigitalKeysForAddressUseCase;
import com.sputnik.domain.usecases.digital_keys.SetDigitalKeyForAddressUseCase;
import com.sputnik.domain.usecases.event.ReportCustomUseCase;
import com.sputnik.domain.usecases.event.ReportFlatInsuranceUseCase;
import com.sputnik.domain.usecases.event.ReportNoCameraUseCase;
import com.sputnik.domain.usecases.family.DeleteFromFamilyUseCase;
import com.sputnik.domain.usecases.family.GetFamilyUseCase;
import com.sputnik.domain.usecases.family.MakeAdminUseCase;
import com.sputnik.domain.usecases.fr_service.UpdateFrUseCase;
import com.sputnik.domain.usecases.gorserv.CreateGorservTicketUseCase;
import com.sputnik.domain.usecases.gorserv.GetGorservCatalogsUseCase;
import com.sputnik.domain.usecases.help.GetCompaniesUseCase;
import com.sputnik.domain.usecases.issues.ReportIssueUseCase;
import com.sputnik.domain.usecases.localization.GetLocalizationUseCase;
import com.sputnik.domain.usecases.manage_cameras.ClearCamerasPreferencesUseCase;
import com.sputnik.domain.usecases.manage_cameras.GetCamerasOrderUseCase;
import com.sputnik.domain.usecases.manage_cameras.GetCamerasPreferencesUseCase;
import com.sputnik.domain.usecases.manage_cameras.SetCameraParamsUseCase;
import com.sputnik.domain.usecases.manage_cameras.SetCamerasOrderUseCase;
import com.sputnik.domain.usecases.market.GetMarketUseCase;
import com.sputnik.domain.usecases.market.GetMarketV2UseCase;
import com.sputnik.domain.usecases.market.GetServicesUseCase;
import com.sputnik.domain.usecases.market.GetSubscriptionUseCase;
import com.sputnik.domain.usecases.notifications.GetNotificationUseCase;
import com.sputnik.domain.usecases.notifications.GetNotificationsUseCase;
import com.sputnik.domain.usecases.notifications.GetUnviewedNotificationsUseCase;
import com.sputnik.domain.usecases.notifications.UpdateNotificationUseCase;
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
import com.sputnik.domain.usecases.profile.ResetAddressUseCase;
import com.sputnik.domain.usecases.profile.SendCallEnabledUseCase;
import com.sputnik.domain.usecases.profile.SendPushTokenUseCase;
import com.sputnik.domain.usecases.profile.SendTimezoneUseCase;
import com.sputnik.domain.usecases.profile.SetLocalizationUseCase;
import com.sputnik.domain.usecases.profile.UnlinkAddressUseCase;
import com.sputnik.domain.usecases.profile.UpdateUseNameUseCase;
import com.sputnik.domain.usecases.profile.VerifyAddressUseCase;
import com.sputnik.domain.usecases.service_payments.GetPaymentStatusUseCase;
import com.sputnik.domain.usecases.service_payments.GetReceiptByAccrualUseCase;
import com.sputnik.domain.usecases.service_payments.GetServiceAccountInfoUseCase;
import com.sputnik.domain.usecases.service_payments.GetServicePaymentsUseCase;
import com.sputnik.domain.usecases.service_payments.PayIntercomUseCase;
import com.sputnik.domain.usecases.service_payments.PromisePaymentUseCase;
import com.sputnik.domain.usecases.stories.GetOnBoardingStoriesUseCase;
import com.sputnik.domain.usecases.stories.GetStoriesUseCase;
import com.sputnik.domain.usecases.subscription.StartSubscriptionUseCase;
import com.sputnik.domain.usecases.subscription.StopSubscriptionUseCase;
import com.sputnik.domain.usecases.support.GetAnnounceUseCase;
import com.sputnik.domain.usecases.support.GetCompanyContactsUseCase;
import com.sputnik.domain.usecases.support.GetFaq2UseCase;
import com.sputnik.domain.usecases.support.GetFaqUseCase;
import com.sputnik.domain.usecases.survey.GetSurveyUseCase;
import com.sputnik.domain.usecases.survey.GetSurveysUseCase;
import com.sputnik.domain.usecases.survey.SendFeedbackUseCase;
import com.sputnik.domain.usecases.survey.SendResultUseCase;
import com.sputnik.domain.usecases.tiles.GetTilesUseCase;
import com.sputnik.service_payments.di.use_cases.account.GetAccountInfoUseCaseModule;
import com.sputnik.service_payments.di.use_cases.account.GetAccountInfoUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvideGetReceiptByAccrualUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvideGetServicePaymentsUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvidePayIntercomUseCaseFactory;
import com.sputnik.service_payments.di.use_cases.payments.PaymentsUseCaseModule_ProvidePromisePaymentUseCaseFactory;
import com.sputnik.service_payments.mappers.DomainPaymentHistoryToPaymentHistoryMapper;
import com.sputnik.service_payments.mappers.DomainPromisedPaymentToPromisedPaymentMapper;
import com.sputnik.service_payments.mappers.DomainServiceAccountInfoToServiceAccountInfoMapper;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import com.sputnik.service_payments.viewmodel.PaymentsViewModel;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import sputnik.axmor.com.sputnik.Config;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImpl;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew_MembersInjector;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImpl_MembersInjector;
import sputnik.axmor.com.sputnik.core.push.PushIntentService;
import sputnik.axmor.com.sputnik.core.push.PushIntentService_MembersInjector;
import sputnik.axmor.com.sputnik.di.AppComponent;
import sputnik.axmor.com.sputnik.di.use_cases.address.AddressUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.address.AddressUseCaseModule_ProvideDeleteCustomAddressUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.address.AddressUseCaseModule_ProvideGetCustomAddressUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.address.AddressUseCaseModule_ProvideSetCustomAddressUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.address.AddressUseCaseModule_ProvideUpdateCustomAddressUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.call.CallUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.call.CallUseCaseModule_ProvideAcceptCallUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.call.CallUseCaseModule_ProvideGetCallUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.call.CallUseCaseModule_ProvideGetSipAccountUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.call_history.CallHistoryUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.call_history.CallHistoryUseCaseModule_ProvideDeleteCallFromHistoryUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.call_history.CallHistoryUseCaseModule_ProvideGetCallHistoryByPagingUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.call_history.DeleteCallHistoryUseCase;
import sputnik.axmor.com.sputnik.di.use_cases.call_history.GetCallHistoryUseCase;
import sputnik.axmor.com.sputnik.di.use_cases.card.CardUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.card.CardUseCaseModule_ProvideAddNewCardUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.card.CardUseCaseModule_ProvideGetLastCardPaymentUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.card.CardUseCaseModule_ProvideRemoveCardUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.digital_keys.DigitalKeysUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.digital_keys.DigitalKeysUseCaseModule_ProvideDeleteDigitalForAddressKeyUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.digital_keys.DigitalKeysUseCaseModule_ProvideGetDigitalKeysForAddressUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.digital_keys.DigitalKeysUseCaseModule_ProvideSetDigitalKeyForAddressUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.event.EventUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.event.EventUseCaseModule_ProvideCreateIssueUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.event.EventUseCaseModule_ProvideReportCustomUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.event.EventUseCaseModule_ProvideReportFlatInsuranceUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.event.EventUseCaseModule_ProvideReportNoCameraUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.family.FamilyUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.family.FamilyUseCaseModule_ProvideDeleteFromFamilyUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.family.FamilyUseCaseModule_ProvideGetFamilyUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.family.FamilyUseCaseModule_ProvideMakeAdminUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.manage_cameras.ManageCamerasUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.manage_cameras.ManageCamerasUseCaseModule_ProvideClearCamerasPreferencesUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.manage_cameras.ManageCamerasUseCaseModule_ProvideGetCamerasOrderUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.manage_cameras.ManageCamerasUseCaseModule_ProvideGetCamerasPreferencesUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.manage_cameras.ManageCamerasUseCaseModule_ProvideSetCameraParamsUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.manage_cameras.ManageCamerasUseCaseModule_ProvideSetCamerasOrderUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.market.MarketUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.market.MarketUseCaseModule_ProvideGetMarketUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.market.MarketUseCaseModule_ProvideGetServicesUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.market.MarketUseCaseModule_ProvideGetSubscriptionUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.single_use_cases.SingleUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.single_use_cases.SingleUseCaseModule_ProvideGetArchiveSdkUrlUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.single_use_cases.SingleUseCaseModule_ProvideGetArchiveUrlsUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.single_use_cases.SingleUseCaseModule_ProvideGetCompaniesUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.single_use_cases.SingleUseCaseModule_ProvideSendFeedbackUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.single_use_cases.SingleUseCaseModule_ProvideSendResultUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.single_use_cases.SingleUseCaseModule_ProvideUpdateFrUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.subscription.SubscriptionUseCaseModule;
import sputnik.axmor.com.sputnik.di.use_cases.subscription.SubscriptionUseCaseModule_ProvideGetLastCardPaymentUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.subscription.SubscriptionUseCaseModule_ProvideStartSubscriptionUseCaseFactory;
import sputnik.axmor.com.sputnik.di.use_cases.subscription.SubscriptionUseCaseModule_ProvideStopSubscriptionUseCaseFactory;
import sputnik.axmor.com.sputnik.entities.company.Company;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.mappers.call.DomainCallToCallMapper;
import sputnik.axmor.com.sputnik.mappers.call.DomainSipAccountToSipAccountMapper;
import sputnik.axmor.com.sputnik.mappers.call_history.DomainCallHistoryToCallHistoryMapper;
import sputnik.axmor.com.sputnik.mappers.cameras.CameraObjectToDomainCameraObjectMapper;
import sputnik.axmor.com.sputnik.mappers.cameras.CamerasOrderToDomainCamerasOrderMapper;
import sputnik.axmor.com.sputnik.mappers.cameras.DomainCameraObjectToCameraObjectMapper;
import sputnik.axmor.com.sputnik.mappers.company.DomainCompanyToCompanyMapper;
import sputnik.axmor.com.sputnik.mappers.digital_keys.DomainDigitalKeyToDigitalKeyMapper;
import sputnik.axmor.com.sputnik.mappers.family.DomainFamilyToFamilyMapper;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainMarketToMarketMapper;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainSmallServicesToSmallServicesMapper;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainSubsPlansToSubsPlansMapper;
import sputnik.axmor.com.sputnik.mappers.market.service.DomainOriginToOriginMapper;
import sputnik.axmor.com.sputnik.mappers.market.service.DomainServiceToServiceMapper;
import sputnik.axmor.com.sputnik.mappers.market.subscription.DomainSubscriptionToSubscriptionMapper;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager_MembersInjector;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconTrackingService;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconTrackingService_MembersInjector;
import sputnik.axmor.com.sputnik.services.ble_service.RebootBroadcastReceiver;
import sputnik.axmor.com.sputnik.services.ble_service.RebootBroadcastReceiver_MembersInjector;
import sputnik.axmor.com.sputnik.services.call_service.CallNotificationService;
import sputnik.axmor.com.sputnik.services.call_service.CallNotificationService_MembersInjector;
import sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService;
import sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService_MembersInjector;
import sputnik.axmor.com.sputnik.services.download_service.C2638DownloadService_Factory;
import sputnik.axmor.com.sputnik.services.download_service.DownloadService;
import sputnik.axmor.com.sputnik.services.download_service.DownloadService_MembersInjector;
import sputnik.axmor.com.sputnik.services.notification_service.PushProcessorImpl;
import sputnik.axmor.com.sputnik.services.notification_service.PushProcessorImpl_MembersInjector;
import sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired;
import sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired_MembersInjector;
import sputnik.axmor.com.sputnik.ui.alerts.FragmentUpdateRequired;
import sputnik.axmor.com.sputnik.ui.alerts.FragmentUpdateRequired_MembersInjector;
import sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView;
import sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView_MembersInjector;
import sputnik.axmor.com.sputnik.ui.beta.BottomSheetAboutBetaProgram;
import sputnik.axmor.com.sputnik.ui.beta.BottomSheetAboutBetaProgram_MembersInjector;
import sputnik.axmor.com.sputnik.ui.block.BlockedFragment;
import sputnik.axmor.com.sputnik.ui.block.BlockedFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment;
import sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.call.CallActivity;
import sputnik.axmor.com.sputnik.ui.call.CallActivity_MembersInjector;
import sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment;
import sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel;
import sputnik.axmor.com.sputnik.ui.dialogs.InfoDialog;
import sputnik.axmor.com.sputnik.ui.dialogs.InfoDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet;
import sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet_MembersInjector;
import sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel;
import sputnik.axmor.com.sputnik.ui.experimental.ExperimentalFunctionsFragment;
import sputnik.axmor.com.sputnik.ui.experimental.ExperimentalFunctionsFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment;
import sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.faq.FaqFragment;
import sputnik.axmor.com.sputnik.ui.faq.FaqFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment;
import sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.gorserv.BottomSheetGorservRequestSent;
import sputnik.axmor.com.sputnik.ui.gorserv.BottomSheetGorservRequestSent_MembersInjector;
import sputnik.axmor.com.sputnik.ui.gorserv.ChangeGorservUserPhoneDialog;
import sputnik.axmor.com.sputnik.ui.gorserv.ChangeGorservUserPhoneDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.gorserv.GorservErrorDialog;
import sputnik.axmor.com.sputnik.ui.gorserv.GorservErrorDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment;
import sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment;
import sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.install_sputnik.SendInstallSputnikRequestFragment;
import sputnik.axmor.com.sputnik.ui.install_sputnik.SendInstallSputnikRequestFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.MainHostFragment;
import sputnik.axmor.com.sputnik.ui.main.MainHostFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.NoCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.NoCamerasFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.BottomSheetAboutCallHistory;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.BottomSheetAboutCallHistory_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.BottomSheetNoArchive;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.BottomSheetNoArchive_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel;
import sputnik.axmor.com.sputnik.ui.main.cameras.rate_us.RateUsDialog;
import sputnik.axmor.com.sputnik.ui.main.cameras.rate_us.RateUsDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFinishFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFinishFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewModel;
import sputnik.axmor.com.sputnik.ui.main.help.AboutAppFragment;
import sputnik.axmor.com.sputnik.ui.main.help.AboutAppFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment;
import sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.help.HelpFragment;
import sputnik.axmor.com.sputnik.ui.main.help.HelpFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment;
import sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment;
import sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.dialogs.ErrorArchiveDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.dialogs.ErrorArchiveDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel.ArchiveViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.NoPermissionsDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.NoPermissionsDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.DeleteCodeDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.DeleteCodeDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.UpdatePermCodeDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.UpdatePermCodeDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.UpdateTempCodeDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.UpdateTempCodeDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrErrorFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrErrorFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrStartScanFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrStartScanFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrSuccessFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrSuccessFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.dialogs.FrRemoveDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.dialogs.FrRemoveDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.viewmodel.FrServiceViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.services.partner_dialog.PartnerServiceDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.partner_dialog.PartnerServiceDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.success_dialog.SuccessSubscriptionDialog;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.success_dialog.SuccessSubscriptionDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel;
import sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment;
import sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetNoBlePermissions;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetNoBlePermissions_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment;
import sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment;
import sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.card.DeletePaymentMethodDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.card.DeletePaymentMethodDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily;
import sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.family.LeaveFromFamilyDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.family.LeaveFromFamilyDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.family.ResendFamilyInviteDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.family.ResendFamilyInviteDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.family.SendFamilyInviteErrorDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.family.SendFamilyInviteErrorDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetNeedSubscriptionToAddKey;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetNeedSubscriptionToAddKey_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.DeleteKeyDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.DeleteKeyDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationListFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationListFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ClearCameraPreferencesDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ClearCameraPreferencesDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSubscriptionNeededForCalls;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSubscriptionNeededForCalls_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.DeleteAddressDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.DeleteAddressDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.DeleteAccountDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.DeleteAccountDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.LogOutDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.LogOutDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.multi_address.BottomSheetMultiAddressAnnounce;
import sputnik.axmor.com.sputnik.ui.multi_address.BottomSheetMultiAddressAnnounce_MembersInjector;
import sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom;
import sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom_MembersInjector;
import sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom;
import sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom_MembersInjector;
import sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress;
import sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress_MembersInjector;
import sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel;
import sputnik.axmor.com.sputnik.ui.our_home.AboutOurHomeDialog;
import sputnik.axmor.com.sputnik.ui.our_home.AboutOurHomeDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.our_home.OurHomeUpdateFragment;
import sputnik.axmor.com.sputnik.ui.our_home.OurHomeUpdateFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.polls.BottomSheetPollSuccess;
import sputnik.axmor.com.sputnik.ui.polls.BottomSheetPollSuccess_MembersInjector;
import sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll;
import sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll_MembersInjector;
import sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment;
import sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment;
import sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity_MembersInjector;
import sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity;
import sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity_MembersInjector;
import sputnik.axmor.com.sputnik.ui.settings.SettingsActivity;
import sputnik.axmor.com.sputnik.ui.settings.SettingsActivity_MembersInjector;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity;
import sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity_MembersInjector;
import sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity;
import sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity_MembersInjector;
import sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment;
import sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.splash.viewmodel.SplashViewModel;
import sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription;
import sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription_MembersInjector;
import sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment;
import sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment_MembersInjector;
import sputnik.axmor.com.sputnik.ui.vpn.AboutVpnDialog;
import sputnik.axmor.com.sputnik.ui.vpn.AboutVpnDialog_MembersInjector;
import sputnik.axmor.com.sputnik.ui.yandex.BottomSheetNeedSubscriptionToAddDeviceForYandexAlice;
import sputnik.axmor.com.sputnik.ui.yandex.BottomSheetNeedSubscriptionToAddDeviceForYandexAlice_MembersInjector;
import sputnik.axmor.com.sputnik.ui.yandex.YandexHomeFragment;
import sputnik.axmor.com.sputnik.ui.yandex.YandexHomeFragment_MembersInjector;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget_MembersInjector;

/* loaded from: classes5.dex */
public final class DaggerAppComponent {
    public static AppComponent.Builder builder() {
        return new Builder();
    }

    private static final class Builder implements AppComponent.Builder {
        private Application applicationContext;

        private Builder() {
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent.Builder
        public Builder applicationContext(Application application) {
            this.applicationContext = (Application) Preconditions.checkNotNull(application);
            return this;
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent.Builder
        public AppComponent build() {
            Preconditions.checkBuilderRequirement(this.applicationContext, Application.class);
            return new AppComponentImpl(new AddressUseCaseModule(), new CallUseCaseModule(), new CallHistoryUseCaseModule(), new CardUseCaseModule(), new DigitalKeysUseCaseModule(), new EventUseCaseModule(), new FamilyUseCaseModule(), new ManageCamerasUseCaseModule(), new MarketUseCaseModule(), new SubscriptionUseCaseModule(), new SingleUseCaseModule(), new AlertsUseCaseModule(), new SurveysUseCaseModule(), new NotificationsUseCaseModule(), new SupportUseCaseModule(), new GorservUseCaseModule(), new TilesUseCaseModule(), new NetworkModule(), new ListMappersModule(), new LocalizationStorageModule(), new PaymentsUseCaseModule(), new GetAccountInfoUseCaseModule(), new DomainListMapperModule(), new DomainCommonListMapperModule(), new OnBoardingListMapperModule(), new LocalizationUseCaseModule(), new CountryCodeUseCaseModule(), new CamerasUseCaseModule(), new ProfileUseCaseModule(), new StoriesUseCaseModule(), new PopupStoriesUseCaseModule(), new InvitesUseCaseModule(), new SubscriptionsUseCaseModule(), new PhysicalKeysUseCaseModule(), this.applicationContext);
        }
    }

    private static final class AppComponentImpl implements AppComponent {
        private final AddressUseCaseModule addressUseCaseModule;
        private Provider<AddressViewModel> addressViewModelProvider;
        private final AlertsUseCaseModule alertsUseCaseModule;
        private Provider<AlertsViewModel> alertsViewModelProvider;
        private Provider<Analytics> analyticsProvider;
        private final AppComponentImpl appComponentImpl;
        private final Application applicationContext;
        private Provider<ArchiveViewModel> archiveViewModelProvider;
        private Provider<CallViewModel.Factory.AssistFactory> assistFactoryProvider;
        private Provider<AllCamerasViewModel.Factory.AssistFactory> assistFactoryProvider2;
        private Provider<CallHistoryViewModel.Factory.AssistFactory> assistFactoryProvider3;
        private Provider<SettingsProfileViewModel.Factory.AssistFactory> assistFactoryProvider4;
        private Provider<ManageCamerasViewModel.Factory.AssistFactory> assistFactoryProvider5;
        private final CallHistoryUseCaseModule callHistoryUseCaseModule;
        private final CallUseCaseModule callUseCaseModule;
        private final CamerasUseCaseModule camerasUseCaseModule;
        private final CardUseCaseModule cardUseCaseModule;
        private Provider<CardViewModel> cardViewModelProvider;
        private final CountryCodeUseCaseModule countryCodeUseCaseModule;
        private final DigitalKeysUseCaseModule digitalKeysUseCaseModule;
        private Provider<DigitalKeysViewModel> digitalKeysViewModelProvider;
        private final DomainCommonListMapperModule domainCommonListMapperModule;
        private final DomainListMapperModule domainListMapperModule;
        private final EventUseCaseModule eventUseCaseModule;
        private Provider<EventViewModel> eventViewModelProvider;
        private Provider<DownloadService.Factory> factoryProvider;
        private final FamilyUseCaseModule familyUseCaseModule;
        private Provider<FamilyViewModel> familyViewModelProvider;
        private Provider<FaqViewModel> faqViewModelProvider;
        private Provider<FrServiceViewModel> frServiceViewModelProvider;
        private final GetAccountInfoUseCaseModule getAccountInfoUseCaseModule;
        private final GorservUseCaseModule gorservUseCaseModule;
        private Provider<GorservViewModel> gorservViewModelProvider;
        private Provider<HelpViewModel> helpViewModelProvider;
        private Provider<InstructionsViewModel> instructionsViewModelProvider;
        private final InvitesUseCaseModule invitesUseCaseModule;
        private Provider<InvitesViewModel> invitesViewModelProvider;
        private Provider<KeysViewModel> keysViewModelProvider;
        private final ListMappersModule listMappersModule;
        private final LocalizationStorageModule localizationStorageModule;
        private final LocalizationUseCaseModule localizationUseCaseModule;
        private Provider<LocalizationViewModel> localizationViewModelProvider;
        private final ManageCamerasUseCaseModule manageCamerasUseCaseModule;
        private final MarketUseCaseModule marketUseCaseModule;
        private Provider<MarketViewModel> marketViewModelProvider;
        private Provider<MultiViewModelFactory> multiViewModelFactoryProvider;
        private Provider<NavigationViewModel> navigationViewModelProvider;
        private final NetworkModule networkModule;
        private final NotificationsUseCaseModule notificationsUseCaseModule;
        private Provider<NotificationsViewModel> notificationsViewModelProvider;
        private final OnBoardingListMapperModule onBoardingListMapperModule;
        private Provider<OnboardingViewModel> onboardingViewModelProvider;
        private final PaymentsUseCaseModule paymentsUseCaseModule;
        private Provider<PaymentsViewModel> paymentsViewModelProvider;
        private final PhysicalKeysUseCaseModule physicalKeysUseCaseModule;
        private final PopupStoriesUseCaseModule popupStoriesUseCaseModule;
        private Provider<PopupStoriesViewModel> popupStoriesViewModelProvider;
        private Provider<PrefManager> prefManagerProvider;
        private Provider<ProfileRepository> profileRepositoryProvider;
        private final ProfileUseCaseModule profileUseCaseModule;
        private Provider<ProfileViewModel> profileViewModelProvider;
        private Provider<AddressApi> provideAddressApiProvider;
        private Provider<AlertsApi> provideAlertsApiProvider;
        private Provider<OkHttpClient.Builder> provideBaseOkHttpProvider;
        private Provider<Retrofit> provideBaseProdRetrofitProvider;
        private Provider<CallApi> provideCallApiProvider;
        private Provider<CamerasApi> provideCamerasApiProvider;
        private Provider<CardApi> provideCardApiProvider;
        private Provider<DigitalKeysApi> provideDigitalKeysApiProvider;
        private Provider<EventApi> provideEventApiProvider;
        private Provider<FamilyApi> provideFamilyApiProvider;
        private Provider<SupportApi> provideFaqApiProvider;
        private Provider<GorservApi> provideGorservApiProvider;
        private Provider<HelpApi> provideHelpApiProvider;
        private Provider<InvitesApi> provideInvitesApiProvider;
        private Provider<LocalizationApi> provideLocalizationApiProvider;
        private Provider<LocalizationStorage> provideLocalizationStorageProvider;
        private Provider<MarketApi> provideMarketApiProvider;
        private Provider<NotificationsApi> provideNotificationsApiProvider;
        private Provider<OkHttpClient> provideOkHttpNoJwtProvider;
        private Provider<OkHttpClient> provideOkHttpProvider;
        private Provider<PhysicalKeysApi> providePhysicalKeysApiProvider;
        private Provider<PopupStoriesApi> providePopupStoriesApiProvider;
        private Provider<Retrofit> provideProdRetrofitProvider;
        private Provider<ProfileApi> provideProfileApiProvider;
        private Provider<ServicePaymentsApi> provideServicePaymentsApiProvider;
        private Provider<ServicesApi> provideServicesApiProvider;
        private Provider<StoriesApi> provideStoriesApiProvider;
        private Provider<SubscriptionApi> provideSubscriptionApiProvider;
        private Provider<SurveyApi> provideSurveyApiProvider;
        private Provider<TilesApi> provideTilesApiProvider;
        private Provider<ServicePaymentsViewModel> servicePaymentsViewModelProvider;
        private Provider<SettingsViewModel> settingsViewModelProvider;
        private final SingleUseCaseModule singleUseCaseModule;
        private Provider<SplashViewModel> splashViewModelProvider;
        private Provider<StateViewModel> stateViewModelProvider;
        private final StoriesUseCaseModule storiesUseCaseModule;
        private Provider<StoriesViewModel> storiesViewModelProvider;
        private final SubscriptionUseCaseModule subscriptionUseCaseModule;
        private Provider<SubscriptionViewModel> subscriptionViewModelProvider;
        private final SubscriptionsUseCaseModule subscriptionsUseCaseModule;
        private Provider<SubscriptionsViewModel> subscriptionsViewModelProvider;
        private final SupportUseCaseModule supportUseCaseModule;
        private Provider<SurveyViewModel> surveyViewModelProvider;
        private final SurveysUseCaseModule surveysUseCaseModule;
        private Provider<SurveysViewModel> surveysViewModelProvider;
        private final TilesUseCaseModule tilesUseCaseModule;
        private Provider<TilesViewModel> tilesViewModelProvider;

        private AppComponentImpl(AddressUseCaseModule addressUseCaseModule, CallUseCaseModule callUseCaseModule, CallHistoryUseCaseModule callHistoryUseCaseModule, CardUseCaseModule cardUseCaseModule, DigitalKeysUseCaseModule digitalKeysUseCaseModule, EventUseCaseModule eventUseCaseModule, FamilyUseCaseModule familyUseCaseModule, ManageCamerasUseCaseModule manageCamerasUseCaseModule, MarketUseCaseModule marketUseCaseModule, SubscriptionUseCaseModule subscriptionUseCaseModule, SingleUseCaseModule singleUseCaseModule, AlertsUseCaseModule alertsUseCaseModule, SurveysUseCaseModule surveysUseCaseModule, NotificationsUseCaseModule notificationsUseCaseModule, SupportUseCaseModule supportUseCaseModule, GorservUseCaseModule gorservUseCaseModule, TilesUseCaseModule tilesUseCaseModule, NetworkModule networkModule, ListMappersModule listMappersModule, LocalizationStorageModule localizationStorageModule, PaymentsUseCaseModule paymentsUseCaseModule, GetAccountInfoUseCaseModule getAccountInfoUseCaseModule, DomainListMapperModule domainListMapperModule, DomainCommonListMapperModule domainCommonListMapperModule, OnBoardingListMapperModule onBoardingListMapperModule, LocalizationUseCaseModule localizationUseCaseModule, CountryCodeUseCaseModule countryCodeUseCaseModule, CamerasUseCaseModule camerasUseCaseModule, ProfileUseCaseModule profileUseCaseModule, StoriesUseCaseModule storiesUseCaseModule, PopupStoriesUseCaseModule popupStoriesUseCaseModule, InvitesUseCaseModule invitesUseCaseModule, SubscriptionsUseCaseModule subscriptionsUseCaseModule, PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Application application) {
            this.appComponentImpl = this;
            this.applicationContext = application;
            this.localizationStorageModule = localizationStorageModule;
            this.familyUseCaseModule = familyUseCaseModule;
            this.networkModule = networkModule;
            this.listMappersModule = listMappersModule;
            this.domainListMapperModule = domainListMapperModule;
            this.profileUseCaseModule = profileUseCaseModule;
            this.addressUseCaseModule = addressUseCaseModule;
            this.singleUseCaseModule = singleUseCaseModule;
            this.cardUseCaseModule = cardUseCaseModule;
            this.digitalKeysUseCaseModule = digitalKeysUseCaseModule;
            this.eventUseCaseModule = eventUseCaseModule;
            this.supportUseCaseModule = supportUseCaseModule;
            this.marketUseCaseModule = marketUseCaseModule;
            this.subscriptionUseCaseModule = subscriptionUseCaseModule;
            this.notificationsUseCaseModule = notificationsUseCaseModule;
            this.gorservUseCaseModule = gorservUseCaseModule;
            this.paymentsUseCaseModule = paymentsUseCaseModule;
            this.getAccountInfoUseCaseModule = getAccountInfoUseCaseModule;
            this.surveysUseCaseModule = surveysUseCaseModule;
            this.tilesUseCaseModule = tilesUseCaseModule;
            this.localizationUseCaseModule = localizationUseCaseModule;
            this.domainCommonListMapperModule = domainCommonListMapperModule;
            this.storiesUseCaseModule = storiesUseCaseModule;
            this.onBoardingListMapperModule = onBoardingListMapperModule;
            this.alertsUseCaseModule = alertsUseCaseModule;
            this.invitesUseCaseModule = invitesUseCaseModule;
            this.countryCodeUseCaseModule = countryCodeUseCaseModule;
            this.popupStoriesUseCaseModule = popupStoriesUseCaseModule;
            this.subscriptionsUseCaseModule = subscriptionsUseCaseModule;
            this.physicalKeysUseCaseModule = physicalKeysUseCaseModule;
            this.callUseCaseModule = callUseCaseModule;
            this.camerasUseCaseModule = camerasUseCaseModule;
            this.callHistoryUseCaseModule = callHistoryUseCaseModule;
            this.manageCamerasUseCaseModule = manageCamerasUseCaseModule;
            initialize(addressUseCaseModule, callUseCaseModule, callHistoryUseCaseModule, cardUseCaseModule, digitalKeysUseCaseModule, eventUseCaseModule, familyUseCaseModule, manageCamerasUseCaseModule, marketUseCaseModule, subscriptionUseCaseModule, singleUseCaseModule, alertsUseCaseModule, surveysUseCaseModule, notificationsUseCaseModule, supportUseCaseModule, gorservUseCaseModule, tilesUseCaseModule, networkModule, listMappersModule, localizationStorageModule, paymentsUseCaseModule, getAccountInfoUseCaseModule, domainListMapperModule, domainCommonListMapperModule, onBoardingListMapperModule, localizationUseCaseModule, countryCodeUseCaseModule, camerasUseCaseModule, profileUseCaseModule, storiesUseCaseModule, popupStoriesUseCaseModule, invitesUseCaseModule, subscriptionsUseCaseModule, physicalKeysUseCaseModule, application);
        }

        private AppMetricaAnalyticsTracker appMetricaAnalyticsTracker() {
            return new AppMetricaAnalyticsTracker(this.applicationContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Set<AnalyticsTracker> setOfAnalyticsTracker() {
            return ImmutableSet.of((AppMetricaAnalyticsTracker) new FirebaseAnalyticsTracker(), appMetricaAnalyticsTracker());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CoroutineScope coroutineScope() {
            LocalizationStorageModule localizationStorageModule = this.localizationStorageModule;
            return LocalizationStorageModule_ProvideCoroutineScopeFactory.provideCoroutineScope(localizationStorageModule, LocalizationStorageModule_ProvidesErrorHandlerFactory.providesErrorHandler(localizationStorageModule));
        }

        private SupportManager supportManager() {
            return new SupportManager(this.applicationContext);
        }

        private ListMapper<DataFamily, DomainFamily> listMapperOfDataFamilyAndDomainFamily() {
            return ListMappersModule_ProvideDataFamilyToDomainFamilyFactory.provideDataFamilyToDomainFamily(this.listMappersModule, new DataFamilyToDomainFamilyMapper());
        }

        private FamilyRepository familyRepository() {
            return new FamilyRepository(this.provideFamilyApiProvider.get(), listMapperOfDataFamilyAndDomainFamily());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetFamilyUseCase getFamilyUseCase() {
            return FamilyUseCaseModule_ProvideGetFamilyUseCaseFactory.provideGetFamilyUseCase(this.familyUseCaseModule, familyRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeleteFromFamilyUseCase deleteFromFamilyUseCase() {
            return FamilyUseCaseModule_ProvideDeleteFromFamilyUseCaseFactory.provideDeleteFromFamilyUseCase(this.familyUseCaseModule, familyRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MakeAdminUseCase makeAdminUseCase() {
            return FamilyUseCaseModule_ProvideMakeAdminUseCaseFactory.provideMakeAdminUseCase(this.familyUseCaseModule, familyRepository());
        }

        private DomainFamilyToFamilyMapper domainFamilyToFamilyMapper() {
            return new DomainFamilyToFamilyMapper(this.prefManagerProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainFamily, Family> listMapperOfDomainFamilyAndFamily() {
            return DomainListMapperModule_ProvideDomainFamilyToFamilyFactory.provideDomainFamilyToFamily(this.domainListMapperModule, domainFamilyToFamilyMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DataProfileToDomainProfileMapper dataProfileToDomainProfileMapper() {
            return new DataProfileToDomainProfileMapper(new DataProfileCardInfoToDomainProfileCardInfoMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ResetAddressUseCase resetAddressUseCase() {
            return ProfileUseCaseModule_ProvideResetAddressUseCaseFactory.provideResetAddressUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        private ListMapper<DataCustomAddress, DomainCustomAddress> listMapperOfDataCustomAddressAndDomainCustomAddress() {
            return ListMappersModule_ProvideDataCustomAddressToDomainCustomAddressFactory.provideDataCustomAddressToDomainCustomAddress(this.listMappersModule, new DataCustomAddressToDomainCustomAddressMapper());
        }

        private AddressRepository addressRepository() {
            return new AddressRepository(this.provideAddressApiProvider.get(), listMapperOfDataCustomAddressAndDomainCustomAddress(), new DataCustomAddressToDomainCustomAddressMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCustomAddressUseCase getCustomAddressUseCase() {
            return AddressUseCaseModule_ProvideGetCustomAddressUseCaseFactory.provideGetCustomAddressUseCase(this.addressUseCaseModule, addressRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeleteCustomAddressUseCase deleteCustomAddressUseCase() {
            return AddressUseCaseModule_ProvideDeleteCustomAddressUseCaseFactory.provideDeleteCustomAddressUseCase(this.addressUseCaseModule, addressRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SetCustomAddressUseCase setCustomAddressUseCase() {
            return AddressUseCaseModule_ProvideSetCustomAddressUseCaseFactory.provideSetCustomAddressUseCase(this.addressUseCaseModule, addressRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UpdateCustomAddressUseCase updateCustomAddressUseCase() {
            return AddressUseCaseModule_ProvideUpdateCustomAddressUseCaseFactory.provideUpdateCustomAddressUseCase(this.addressUseCaseModule, addressRepository());
        }

        private ListMapper<DataFlussonic, DomainFlussonic> listMapperOfDataFlussonicAndDomainFlussonic() {
            return ListMappersModule_ProvideDataFlussonicToDomainFlussonicFactory.provideDataFlussonicToDomainFlussonic(this.listMappersModule, new DataFlussonicToDomainFlussonicMapper());
        }

        private DataArchiveToDomainArchiveMapper dataArchiveToDomainArchiveMapper() {
            return new DataArchiveToDomainArchiveMapper(new DataArchiveItemToDomainArchiveItemMapper());
        }

        private Mapper<DataArchiveResponse, DomainArchiveUrls> mapperOfDataArchiveResponseAndDomainArchiveUrls() {
            return ListMappersModule_ProvideDataArchiveToDomainArchiveFactory.provideDataArchiveToDomainArchive(this.listMappersModule, dataArchiveToDomainArchiveMapper());
        }

        private ArchiveRepository archiveRepository() {
            return new ArchiveRepository(this.provideServicesApiProvider.get(), listMapperOfDataFlussonicAndDomainFlussonic(), mapperOfDataArchiveResponseAndDomainArchiveUrls(), this.prefManagerProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetArchiveSdkUrlUseCase getArchiveSdkUrlUseCase() {
            return SingleUseCaseModule_ProvideGetArchiveSdkUrlUseCaseFactory.provideGetArchiveSdkUrlUseCase(this.singleUseCaseModule, archiveRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainFlussonic, Flussonic> listMapperOfDomainFlussonicAndFlussonic() {
            return DomainListMapperModule_ProvideDomainFlussonicToFlussonicFactory.provideDomainFlussonicToFlussonic(this.domainListMapperModule, new DomainFlussonicToFlussonicMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetArchiveUrlsUseCase getArchiveUrlsUseCase() {
            return SingleUseCaseModule_ProvideGetArchiveUrlsUseCaseFactory.provideGetArchiveUrlsUseCase(this.singleUseCaseModule, archiveRepository());
        }

        private CardRepository cardRepository() {
            return new CardRepository(this.provideCardApiProvider.get(), new DataConfirmationToDomainConfirmationMapper(), new DataPaymentStateToDomainPaymentStateMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AddNewCardUseCase addNewCardUseCase() {
            return CardUseCaseModule_ProvideAddNewCardUseCaseFactory.provideAddNewCardUseCase(this.cardUseCaseModule, cardRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RemoveCardUseCase removeCardUseCase() {
            return CardUseCaseModule_ProvideRemoveCardUseCaseFactory.provideRemoveCardUseCase(this.cardUseCaseModule, cardRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetLastCardPaymentUseCase getLastCardPaymentUseCase() {
            return CardUseCaseModule_ProvideGetLastCardPaymentUseCaseFactory.provideGetLastCardPaymentUseCase(this.cardUseCaseModule, cardRepository());
        }

        private ListMapper<DataDigitalKey, DomainDigitalKey> listMapperOfDataDigitalKeyAndDomainDigitalKey() {
            return ListMappersModule_ProvideDataDigitalKeyToDomainDigitalKeyFactory.provideDataDigitalKeyToDomainDigitalKey(this.listMappersModule, new DataDigitalKeyToDomainDigitalKeyMapper());
        }

        private DigitalKeysRepository digitalKeysRepository() {
            return new DigitalKeysRepository(this.provideDigitalKeysApiProvider.get(), listMapperOfDataDigitalKeyAndDomainDigitalKey(), new DataDigitalKeyToDomainDigitalKeyMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetDigitalKeysForAddressUseCase getDigitalKeysForAddressUseCase() {
            return DigitalKeysUseCaseModule_ProvideGetDigitalKeysForAddressUseCaseFactory.provideGetDigitalKeysForAddressUseCase(this.digitalKeysUseCaseModule, digitalKeysRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SetDigitalKeyForAddressUseCase setDigitalKeyForAddressUseCase() {
            return DigitalKeysUseCaseModule_ProvideSetDigitalKeyForAddressUseCaseFactory.provideSetDigitalKeyForAddressUseCase(this.digitalKeysUseCaseModule, digitalKeysRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeleteDigitalKeyForAddressUseCase deleteDigitalKeyForAddressUseCase() {
            return DigitalKeysUseCaseModule_ProvideDeleteDigitalForAddressKeyUseCaseFactory.provideDeleteDigitalForAddressKeyUseCase(this.digitalKeysUseCaseModule, digitalKeysRepository());
        }

        private EventRepository eventRepository() {
            return new EventRepository(this.provideEventApiProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ReportCustomUseCase reportCustomUseCase() {
            return EventUseCaseModule_ProvideReportCustomUseCaseFactory.provideReportCustomUseCase(this.eventUseCaseModule, eventRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ReportFlatInsuranceUseCase reportFlatInsuranceUseCase() {
            return EventUseCaseModule_ProvideReportFlatInsuranceUseCaseFactory.provideReportFlatInsuranceUseCase(this.eventUseCaseModule, eventRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ReportNoCameraUseCase reportNoCameraUseCase() {
            return EventUseCaseModule_ProvideReportNoCameraUseCaseFactory.provideReportNoCameraUseCase(this.eventUseCaseModule, eventRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ReportIssueUseCase reportIssueUseCase() {
            return EventUseCaseModule_ProvideCreateIssueUseCaseFactory.provideCreateIssueUseCase(this.eventUseCaseModule, eventRepository());
        }

        private FrServiceRepository frServiceRepository() {
            return new FrServiceRepository(this.provideServicesApiProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UpdateFrUseCase<MultipartBody.Part> updateFrUseCaseOfPart() {
            return SingleUseCaseModule_ProvideUpdateFrUseCaseFactory.provideUpdateFrUseCase(this.singleUseCaseModule, frServiceRepository());
        }

        private ListMapper<DataCompany, DomainCompany> listMapperOfDataCompanyAndDomainCompany() {
            return ListMappersModule_ProvideDataCompanyToDomainCompanyFactory.provideDataCompanyToDomainCompany(this.listMappersModule, new DataCompanyToDomainCompanyMapper());
        }

        private HelpRepository helpRepository() {
            return new HelpRepository(this.provideHelpApiProvider.get(), listMapperOfDataCompanyAndDomainCompany());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCompaniesUseCase getCompaniesUseCase() {
            return SingleUseCaseModule_ProvideGetCompaniesUseCaseFactory.provideGetCompaniesUseCase(this.singleUseCaseModule, helpRepository());
        }

        private ListMapper<DataFaq, DomainFaq> listMapperOfDataFaqAndDomainFaq() {
            return ListMappersModule_ProvideDataFaqToDomainFaqFactory.provideDataFaqToDomainFaq(this.listMappersModule, new DataFaqToDomainFaqMapper());
        }

        private SupportRepository supportRepository() {
            return new SupportRepository(this.provideFaqApiProvider.get(), listMapperOfDataFaqAndDomainFaq(), new DataFaqToDomainFaqMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetAnnounceUseCase getAnnounceUseCase() {
            return SupportUseCaseModule_ProvideGetAnnounceUseCaseFactory.provideGetAnnounceUseCase(this.supportUseCaseModule, supportRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCompanyContactsUseCase getCompanyContactsUseCase() {
            return SupportUseCaseModule_ProvideGetCompanyContactsUseCaseFactory.provideGetCompanyContactsUseCase(this.supportUseCaseModule, supportRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainCompany, Company> listMapperOfDomainCompanyAndCompany() {
            return DomainListMapperModule_ProvideDomainCompanyToCompanyFactory.provideDomainCompanyToCompany(this.domainListMapperModule, new DomainCompanyToCompanyMapper());
        }

        private NullableInputListMapper<DataSubsPlans, DomainSubsPlans> nullableInputListMapperOfDataSubsPlansAndDomainSubsPlans() {
            return ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory.provideDataSubsPlansToDomainSubsPlans(this.listMappersModule, new DataSubsPlansToDomainSubsPlansMapper());
        }

        private DataAppearancePlansToDomainAppearancePlansMapper dataAppearancePlansToDomainAppearancePlansMapper() {
            return new DataAppearancePlansToDomainAppearancePlansMapper(nullableInputListMapperOfDataSubsPlansAndDomainSubsPlans());
        }

        private NullableInputListMapper<DataSmallService, DomainSmallServices> nullableInputListMapperOfDataSmallServiceAndDomainSmallServices() {
            return ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory.provideDataSmallServiceToDomainSmallServices(this.listMappersModule, new DataSmallServiceToDomainSmallServiceMapper());
        }

        private DataIncludedServiceToDomainIncludedServiceMapper dataIncludedServiceToDomainIncludedServiceMapper() {
            return new DataIncludedServiceToDomainIncludedServiceMapper(nullableInputListMapperOfDataSmallServiceAndDomainSmallServices());
        }

        private DataDetailedLayoutToDomainDetailedLayoutMapper dataDetailedLayoutToDomainDetailedLayoutMapper() {
            return new DataDetailedLayoutToDomainDetailedLayoutMapper(dataAppearancePlansToDomainAppearancePlansMapper(), dataIncludedServiceToDomainIncludedServiceMapper());
        }

        private DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper() {
            return new DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper(dataDetailedLayoutToDomainDetailedLayoutMapper());
        }

        private DataPlansToDomainPlansMapper dataPlansToDomainPlansMapper() {
            return new DataPlansToDomainPlansMapper(new DataPlanAppearanceToDomainPlanAppearanceMapper());
        }

        private DataSubscriptionToDomainSubscriptionMapper dataSubscriptionToDomainSubscriptionMapper() {
            return new DataSubscriptionToDomainSubscriptionMapper(dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper(), nullableInputListMapperOfDataSmallServiceAndDomainSmallServices(), dataPlansToDomainPlansMapper());
        }

        private ListMapper<DataSubscription, DomainSubscription> listMapperOfDataSubscriptionAndDomainSubscription() {
            return ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory.provideDataSubscriptionToDomainSubscription(this.listMappersModule, dataSubscriptionToDomainSubscriptionMapper());
        }

        private DataSubscriptionDetailsToDomainSubscriptionDetailsMapper dataSubscriptionDetailsToDomainSubscriptionDetailsMapper() {
            return new DataSubscriptionDetailsToDomainSubscriptionDetailsMapper(nullableInputListMapperOfDataSubsPlansAndDomainSubsPlans());
        }

        private DataMarketToDomainMarketMapper dataMarketToDomainMarketMapper() {
            return new DataMarketToDomainMarketMapper(dataSubscriptionDetailsToDomainSubscriptionDetailsMapper(), dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper());
        }

        private ListMapper<DataMarket, DomainMarket> listMapperOfDataMarketAndDomainMarket() {
            return ListMappersModule_ProvideDataMarketToDomainMarketFactory.provideDataMarketToDomainMarket(this.listMappersModule, dataMarketToDomainMarketMapper());
        }

        private DataBaseSubscriptionToDomainBaseSubscriptionMapper dataBaseSubscriptionToDomainBaseSubscriptionMapper() {
            return new DataBaseSubscriptionToDomainBaseSubscriptionMapper(new DataBaseAppearanceToDomainAppearanceMapper());
        }

        private ListMapper<DataBaseSubscription, DomainBaseSubscription> listMapperOfDataBaseSubscriptionAndDomainBaseSubscription() {
            return ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory.provideDataMarketV2ToDomainMarketV2(this.listMappersModule, dataBaseSubscriptionToDomainBaseSubscriptionMapper());
        }

        private DataOuterServiceToDomainOuterServiceMapper dataOuterServiceToDomainOuterServiceMapper() {
            return new DataOuterServiceToDomainOuterServiceMapper(new DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper());
        }

        private ListMapper<DataOuterService, DomainOuterService> listMapperOfDataOuterServiceAndDomainOuterService() {
            return ListMappersModule_ProvideDataOuterServiceToDomainOuterServiceMapperFactory.provideDataOuterServiceToDomainOuterServiceMapper(this.listMappersModule, dataOuterServiceToDomainOuterServiceMapper());
        }

        private ListMapper<DataMarketItem, DomainMarketItem> listMapperOfDataMarketItemAndDomainMarketItem() {
            return ListMappersModule_ProvideDataMarketItemToDomainMarketItemMapperFactory.provideDataMarketItemToDomainMarketItemMapper(this.listMappersModule, new DataMarketItemToDomainMarketItemMapper());
        }

        private DataServiceToDomainServiceMapper dataServiceToDomainServiceMapper() {
            return new DataServiceToDomainServiceMapper(new DataServiceAppearanceToDomainServiceAppearanceMapper(), new DataOriginSubToDomainOriginSubMapper());
        }

        private ListMapper<DataService, DomainService> listMapperOfDataServiceAndDomainService() {
            return ListMappersModule_ProvideDataServiceToDomainServiceFactory.provideDataServiceToDomainService(this.listMappersModule, dataServiceToDomainServiceMapper());
        }

        private MarketRepository marketRepository() {
            return new MarketRepository(this.provideMarketApiProvider.get(), listMapperOfDataSubscriptionAndDomainSubscription(), listMapperOfDataMarketAndDomainMarket(), listMapperOfDataBaseSubscriptionAndDomainBaseSubscription(), listMapperOfDataOuterServiceAndDomainOuterService(), listMapperOfDataMarketItemAndDomainMarketItem(), listMapperOfDataServiceAndDomainService());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetMarketUseCase getMarketUseCase() {
            return MarketUseCaseModule_ProvideGetMarketUseCaseFactory.provideGetMarketUseCase(this.marketUseCaseModule, marketRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetSubscriptionUseCase getSubscriptionUseCase() {
            return MarketUseCaseModule_ProvideGetSubscriptionUseCaseFactory.provideGetSubscriptionUseCase(this.marketUseCaseModule, marketRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetServicesUseCase getServicesUseCase() {
            return MarketUseCaseModule_ProvideGetServicesUseCaseFactory.provideGetServicesUseCase(this.marketUseCaseModule, marketRepository());
        }

        private DomainOriginToOriginMapper domainOriginToOriginMapper() {
            return new DomainOriginToOriginMapper(this.provideLocalizationStorageProvider.get());
        }

        private DomainServiceToServiceMapper domainServiceToServiceMapper() {
            return new DomainServiceToServiceMapper(domainOriginToOriginMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainService, Service> listMapperOfDomainServiceAndService() {
            return DomainListMapperModule_ProvideDomainServiceToServiceFactory.provideDomainServiceToService(this.domainListMapperModule, domainServiceToServiceMapper());
        }

        private NullableInputListMapper<DomainSubsPlans, SubsPlans> nullableInputListMapperOfDomainSubsPlansAndSubsPlans() {
            return DomainListMapperModule_ProvideDomainSubsPlansToSubsPlansFactory.provideDomainSubsPlansToSubsPlans(this.domainListMapperModule, new DomainSubsPlansToSubsPlansMapper());
        }

        private NullableInputListMapper<DomainSmallServices, SmallServices> nullableInputListMapperOfDomainSmallServicesAndSmallServices() {
            return DomainListMapperModule_ProvideDomainSmallServiceToSmallServicesFactory.provideDomainSmallServiceToSmallServices(this.domainListMapperModule, new DomainSmallServicesToSmallServicesMapper());
        }

        private DomainMarketToMarketMapper domainMarketToMarketMapper() {
            return new DomainMarketToMarketMapper(nullableInputListMapperOfDomainSubsPlansAndSubsPlans(), nullableInputListMapperOfDomainSmallServicesAndSmallServices());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainMarket, Market> listMapperOfDomainMarketAndMarket() {
            return DomainListMapperModule_ProvideDomainMarketToMarketFactory.provideDomainMarketToMarket(this.domainListMapperModule, domainMarketToMarketMapper());
        }

        private DomainSubscriptionToSubscriptionMapper domainSubscriptionToSubscriptionMapper() {
            return new DomainSubscriptionToSubscriptionMapper(this.provideLocalizationStorageProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainSubscription, Subscription> listMapperOfDomainSubscriptionAndSubscription() {
            return DomainListMapperModule_ProvideDomainSubscriptionToSubscriptionFactory.provideDomainSubscriptionToSubscription(this.domainListMapperModule, domainSubscriptionToSubscriptionMapper());
        }

        private NullableInputListMapper<DataSubscriptionInfo, DomainSubscriptionInfo> nullableInputListMapperOfDataSubscriptionInfoAndDomainSubscriptionInfo() {
            return ListMappersModule_ProvideDataSubscriptionInfoToDomainSubscriptionInfoFactory.provideDataSubscriptionInfoToDomainSubscriptionInfo(this.listMappersModule, new DataSubscriptionInfoToDomainSubscriptionInfoMapper());
        }

        private DataSubscriptionStartToDomainSubscriptionStartMapper dataSubscriptionStartToDomainSubscriptionStartMapper() {
            return new DataSubscriptionStartToDomainSubscriptionStartMapper(nullableInputListMapperOfDataSubscriptionInfoAndDomainSubscriptionInfo());
        }

        private SubscriptionRepository subscriptionRepository() {
            return new SubscriptionRepository(this.provideSubscriptionApiProvider.get(), new DataPaymentStateToDomainPaymentStateMapper(), dataSubscriptionStartToDomainSubscriptionStartMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public StartSubscriptionUseCase startSubscriptionUseCase() {
            return SubscriptionUseCaseModule_ProvideStartSubscriptionUseCaseFactory.provideStartSubscriptionUseCase(this.subscriptionUseCaseModule, subscriptionRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.sputnik.domain.usecases.subscription.GetLastCardPaymentUseCase getLastCardPaymentUseCase2() {
            return SubscriptionUseCaseModule_ProvideGetLastCardPaymentUseCaseFactory.provideGetLastCardPaymentUseCase(this.subscriptionUseCaseModule, subscriptionRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public StopSubscriptionUseCase stopSubscriptionUseCase() {
            return SubscriptionUseCaseModule_ProvideStopSubscriptionUseCaseFactory.provideStopSubscriptionUseCase(this.subscriptionUseCaseModule, subscriptionRepository());
        }

        private ListMapper<DataSurvey, DomainSurvey> listMapperOfDataSurveyAndDomainSurvey() {
            return ListMappersModule_ProvideDataSurveyToDomainSurveyFactory.provideDataSurveyToDomainSurvey(this.listMappersModule, new DataSurveyToDomainSurveyMapper());
        }

        private SurveyRepository surveyRepository() {
            return new SurveyRepository(this.provideSurveyApiProvider.get(), listMapperOfDataSurveyAndDomainSurvey(), new DataSurveyToDomainSurveyMapper(), new DataSurveyResultToDomainSurveyResultMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SendFeedbackUseCase sendFeedbackUseCase() {
            return SingleUseCaseModule_ProvideSendFeedbackUseCaseFactory.provideSendFeedbackUseCase(this.singleUseCaseModule, surveyRepository());
        }

        private ListMapper<DataNotification, DomainNotification> listMapperOfDataNotificationAndDomainNotification() {
            return ListMappersModule_ProvideDataNotificationToDomainNotificationFactory.provideDataNotificationToDomainNotification(this.listMappersModule, new DataNotificationtToDomainNotificationMapper());
        }

        private NotificationsRepository notificationsRepository() {
            return new NotificationsRepository(this.provideNotificationsApiProvider.get(), listMapperOfDataNotificationAndDomainNotification(), new DataNotificationtToDomainNotificationMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetNotificationsUseCase getNotificationsUseCase() {
            return NotificationsUseCaseModule_ProvideGetNotificationsUseCaseFactory.provideGetNotificationsUseCase(this.notificationsUseCaseModule, notificationsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetUnviewedNotificationsUseCase getUnviewedNotificationsUseCase() {
            return NotificationsUseCaseModule_ProvideGetUnviewedNotificationsUseCaseFactory.provideGetUnviewedNotificationsUseCase(this.notificationsUseCaseModule, notificationsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetNotificationUseCase getNotificationUseCase() {
            return NotificationsUseCaseModule_ProvideGetNotificationUseCaseFactory.provideGetNotificationUseCase(this.notificationsUseCaseModule, notificationsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UpdateNotificationUseCase updateNotificationUseCase() {
            return NotificationsUseCaseModule_ProvideUpdateNotificationUseCaseFactory.provideUpdateNotificationUseCase(this.notificationsUseCaseModule, notificationsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetFaqUseCase getFaqUseCase() {
            return SupportUseCaseModule_ProvideGetFaqUseCaseFactory.provideGetFaqUseCase(this.supportUseCaseModule, supportRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetFaq2UseCase getFaq2UseCase() {
            return SupportUseCaseModule_ProvideGetFaq2UseCaseFactory.provideGetFaq2UseCase(this.supportUseCaseModule, supportRepository());
        }

        private ListMapper<DataGorservCatalog, DomainGorservCatalog> listMapperOfDataGorservCatalogAndDomainGorservCatalog() {
            return ListMappersModule_ProvideDataGorservCatalogToDomainGorservCatalogFactory.provideDataGorservCatalogToDomainGorservCatalog(this.listMappersModule, new DataGorservCatalogToDomainGorservCatalogMapper());
        }

        private GorservRepository gorservRepository() {
            return new GorservRepository(this.provideGorservApiProvider.get(), listMapperOfDataGorservCatalogAndDomainGorservCatalog(), new DataGorservCreateTicketToDomainGorservCreateTicketMapper(), new DataGorservCatalogToDomainGorservCatalogMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetGorservCatalogsUseCase getGorservCatalogsUseCase() {
            return GorservUseCaseModule_ProvideGetGorservCatalogsUseCaseFactory.provideGetGorservCatalogsUseCase(this.gorservUseCaseModule, gorservRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CreateGorservTicketUseCase createGorservTicketUseCase() {
            return GorservUseCaseModule_ProvideCreateGorservTicketUseCaseFactory.provideCreateGorservTicketUseCase(this.gorservUseCaseModule, gorservRepository());
        }

        private ListMapper<DataPaymentHistory, DomainPaymentHistory> listMapperOfDataPaymentHistoryAndDomainPaymentHistory() {
            return ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory.provideDataPaymentHistoryToDomainPaymentHistory(this.listMappersModule, new DataPaymentHistoryToDomainPaymentHistoryMapper());
        }

        private ServicePaymentsRepository servicePaymentsRepository() {
            return new ServicePaymentsRepository(this.provideServicePaymentsApiProvider.get(), listMapperOfDataPaymentHistoryAndDomainPaymentHistory(), new DataPaymentHistoryToDomainPaymentHistoryMapper(), new DataPaymentItemToDomainPaymentItemMapper(), new DataPromisePaymentToDomainPromisePaymentMapper(), new DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper(), new DataServiceAccountInfoToDomainServiceAccountInfoMapper(), new DataPaymentReceiptToDomainPaymentReceiptMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetServicePaymentsUseCase getServicePaymentsUseCase() {
            return PaymentsUseCaseModule_ProvideGetServicePaymentsUseCaseFactory.provideGetServicePaymentsUseCase(this.paymentsUseCaseModule, servicePaymentsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetServiceAccountInfoUseCase getServiceAccountInfoUseCase() {
            return GetAccountInfoUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory.provideGetIntercomCodeForRegUseCase(this.getAccountInfoUseCaseModule, servicePaymentsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetReceiptByAccrualUseCase getReceiptByAccrualUseCase() {
            return PaymentsUseCaseModule_ProvideGetReceiptByAccrualUseCaseFactory.provideGetReceiptByAccrualUseCase(this.paymentsUseCaseModule, servicePaymentsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PromisePaymentUseCase promisePaymentUseCase() {
            return PaymentsUseCaseModule_ProvidePromisePaymentUseCaseFactory.providePromisePaymentUseCase(this.paymentsUseCaseModule, servicePaymentsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DomainPaymentHistoryToPaymentHistoryMapper domainPaymentHistoryToPaymentHistoryMapper() {
            return new DomainPaymentHistoryToPaymentHistoryMapper(this.provideLocalizationStorageProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PayIntercomUseCase payIntercomUseCase() {
            return PaymentsUseCaseModule_ProvidePayIntercomUseCaseFactory.providePayIntercomUseCase(this.paymentsUseCaseModule, servicePaymentsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetPaymentStatusUseCase getPaymentStatusUseCase() {
            return PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory.provideGetPaymentStatusUseCase(this.paymentsUseCaseModule, servicePaymentsRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetSurveysUseCase getSurveysUseCase() {
            return SurveysUseCaseModule_ProvideGetSurveysUseCaseFactory.provideGetSurveysUseCase(this.surveysUseCaseModule, surveyRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetSurveyUseCase getSurveyUseCase() {
            return SurveysUseCaseModule_ProvideGetSurveyUseCaseFactory.provideGetSurveyUseCase(this.surveysUseCaseModule, surveyRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SendResultUseCase sendResultUseCase() {
            return SingleUseCaseModule_ProvideSendResultUseCaseFactory.provideSendResultUseCase(this.singleUseCaseModule, surveyRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainSurvey, Survey> listMapperOfDomainSurveyAndSurvey() {
            return DomainListMapperModule_ProvideDomainSurveyToSurveyFactory.provideDomainSurveyToSurvey(this.domainListMapperModule, new DomainSurveyToSurveyMapper());
        }

        private TilesRepository tilesRepository() {
            return new TilesRepository(this.provideTilesApiProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetTilesUseCase getTilesUseCase() {
            return TilesUseCaseModule_ProvideGetTilesUseCaseFactory.provideGetTilesUseCase(this.tilesUseCaseModule, tilesRepository());
        }

        private ListMapper<DataLocalization, DomainLocalization> listMapperOfDataLocalizationAndDomainLocalization() {
            return ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory.provideDataLocalizationToDomainLocalization(this.listMappersModule, new DataLocalizationToDomainLocalizationMapper());
        }

        private LocalizationRepository localizationRepository() {
            return new LocalizationRepository(this.provideLocalizationApiProvider.get(), listMapperOfDataLocalizationAndDomainLocalization());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetLocalizationUseCase getLocalizationUseCase() {
            return LocalizationUseCaseModule_ProvideGetLocalizationUseCaseFactory.provideGetLocalizationUseCase(this.localizationUseCaseModule, localizationRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainLocalization, Localization> listMapperOfDomainLocalizationAndLocalization() {
            return DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory.provideDomainLocalizationToLocalization(this.domainCommonListMapperModule, new DomainLocalizationToLocalizationMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeleteFrUseCase deleteFrUseCase() {
            return ProfileUseCaseModule_ProvideDeleteFrUseCaseFactory.provideDeleteFrUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SetLocalizationUseCase setLocalizationUseCase() {
            return ProfileUseCaseModule_ProvideSetLocalizationUseCaseFactory.provideSetLocalizationUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ChangeAvatarUseCase changeAvatarUseCase() {
            return ProfileUseCaseModule_ProvideChangeAvatarUseCaseFactory.provideChangeAvatarUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetProfileUseCase getProfileUseCase() {
            return ProfileUseCaseModule_ProvideGetProfileUseCaseFactory.provideGetProfileUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public LogoutUseCase logoutUseCase() {
            return ProfileUseCaseModule_ProvideLogoutUseCaseFactory.provideLogoutUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeleteAccountUseCase deleteAccountUseCase() {
            return ProfileUseCaseModule_ProvideDeleteAccountUseCaseFactory.provideDeleteAccountUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public VerifyAddressUseCase verifyAddressUseCase() {
            return ProfileUseCaseModule_ProvideVerifyAddressUseCaseFactory.provideVerifyAddressUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeactivateAddressUseCase deactivateAddressUseCase() {
            return ProfileUseCaseModule_ProvideDeactivateAddressUseCaseFactory.provideDeactivateAddressUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UnlinkAddressUseCase unlinkAddressUseCase() {
            return ProfileUseCaseModule_ProvideUnlinkAddressUseCaseFactory.provideUnlinkAddressUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeactivateAccountUseCase deactivateAccountUseCase() {
            return ProfileUseCaseModule_ProvideDeactivateAccountUseCaseFactory.provideDeactivateAccountUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SendPushTokenUseCase sendPushTokenUseCase() {
            return ProfileUseCaseModule_ProvideSendPushTokenUseCaseFactory.provideSendPushTokenUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SendTimezoneUseCase sendTimezoneUseCase() {
            return ProfileUseCaseModule_ProvideSendTimezoneUseCaseFactory.provideSendTimezoneUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SendCallEnabledUseCase sendCallEnabledUseCase() {
            return ProfileUseCaseModule_ProvideSendCallEnabledUseCaseFactory.provideSendCallEnabledUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BindToFlatUseCase bindToFlatUseCase() {
            return ProfileUseCaseModule_ProvideBindToFlatUseCaseFactory.provideBindToFlatUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DomainProfileToProfileMapper domainProfileToProfileMapper() {
            return new DomainProfileToProfileMapper(new DomainProfileCardInfoToProfileCardInfoMapper(), this.provideLocalizationStorageProvider.get(), this.prefManagerProvider.get());
        }

        private NullableInputListMapper<DataStoriesButton, DomainStoriesButton> nullableInputListMapperOfDataStoriesButtonAndDomainStoriesButton() {
            return ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory.provideDataStoriesButtonToDomainStories(this.listMappersModule, new DataStoriesButtonToDomainStoriesButtonMapper());
        }

        private DataStoryToDomainStoryMapper dataStoryToDomainStoryMapper() {
            return new DataStoryToDomainStoryMapper(nullableInputListMapperOfDataStoriesButtonAndDomainStoriesButton());
        }

        private NullableInputListMapper<DataStory, DomainStory> nullableInputListMapperOfDataStoryAndDomainStory() {
            return ListMappersModule_ProvideDataStoryToDomainStoryFactory.provideDataStoryToDomainStory(this.listMappersModule, dataStoryToDomainStoryMapper());
        }

        private StoriesRepository storiesRepository() {
            return new StoriesRepository(this.provideStoriesApiProvider.get(), nullableInputListMapperOfDataStoryAndDomainStory());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetOnBoardingStoriesUseCase getOnBoardingStoriesUseCase() {
            return StoriesUseCaseModule_ProvideGetOnboardingStoriesUseCaseFactory.provideGetOnboardingStoriesUseCase(this.storiesUseCaseModule, storiesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetStoriesUseCase getStoriesUseCase() {
            return StoriesUseCaseModule_ProvideGetStoriesUseCaseFactory.provideGetStoriesUseCase(this.storiesUseCaseModule, storiesRepository());
        }

        private NullableInputListMapper<DomainStoriesButton, StoryButton> nullableInputListMapperOfDomainStoriesButtonAndStoryButton() {
            return OnBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactory.provideDomainStoryButtonToStoryButton(this.onBoardingListMapperModule, new DomainStoryButtonToStoryButtonMapper());
        }

        private DomainStoryToStoryMapper domainStoryToStoryMapper() {
            return new DomainStoryToStoryMapper(nullableInputListMapperOfDomainStoriesButtonAndStoryButton());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public NullableInputListMapper<DomainStory, Story> nullableInputListMapperOfDomainStoryAndStory() {
            return OnBoardingListMapperModule_ProvideDomainStoryToStoryFactory.provideDomainStoryToStory(this.onBoardingListMapperModule, domainStoryToStoryMapper());
        }

        private ListMapper<DataAlert, DomainAlert> listMapperOfDataAlertAndDomainAlert() {
            return ListMappersModule_ProvideDataAlertToDomainAlertFactory.provideDataAlertToDomainAlert(this.listMappersModule, new DataAlertToDomainAlertMapper());
        }

        private AlertsRepository alertsRepository() {
            return new AlertsRepository(this.provideAlertsApiProvider.get(), listMapperOfDataAlertAndDomainAlert());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetAlertsUseCase getAlertsUseCase() {
            return AlertsUseCaseModule_ProvideGetCamerasOrderUseCaseFactory.provideGetCamerasOrderUseCase(this.alertsUseCaseModule, alertsRepository());
        }

        private ListMapper<DataInvite, DomainInvite> listMapperOfDataInviteAndDomainInvite() {
            return ListMappersModule_ProvideDataInviteToDomainInviteFactory.provideDataInviteToDomainInvite(this.listMappersModule, new DataInviteToDomainInviteMapper());
        }

        private InvitesRepository invitesRepository() {
            return new InvitesRepository(this.provideInvitesApiProvider.get(), listMapperOfDataInviteAndDomainInvite(), new DataInviteToDomainInviteMapper(), new DataFamilyInvitesToDomainFamilyInvitesMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetInvitesUseCase getInvitesUseCase() {
            return InvitesUseCaseModule_ProvideGetInvitesUseCaseFactory.provideGetInvitesUseCase(this.invitesUseCaseModule, invitesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetFamilyInvitesUseCase getFamilyInvitesUseCase() {
            return InvitesUseCaseModule_ProvideGetFamilyInvitesUseCaseFactory.provideGetFamilyInvitesUseCase(this.invitesUseCaseModule, invitesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SendFamilyInviteUseCase sendFamilyInviteUseCase() {
            return InvitesUseCaseModule_ProvideSendFamilyInviteUseCaseFactory.provideSendFamilyInviteUseCase(this.invitesUseCaseModule, invitesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ResendFamilyInviteUseCase resendFamilyInviteUseCase() {
            return InvitesUseCaseModule_ProvideResendFamilyInviteUseCaseFactory.provideResendFamilyInviteUseCase(this.invitesUseCaseModule, invitesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeleteFamilyInviteUseCase deleteFamilyInviteUseCase() {
            return InvitesUseCaseModule_ProvideDeleteFamilyInviteUseCaseFactory.provideDeleteFamilyInviteUseCase(this.invitesUseCaseModule, invitesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AcceptInviteUseCase acceptInviteUseCase() {
            return InvitesUseCaseModule_ProvideAcceptInviteUseCaseFactory.provideAcceptInviteUseCase(this.invitesUseCaseModule, invitesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeclineInviteUseCase declineInviteUseCase() {
            return InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory.provideDeclineInviteUseCase(this.invitesUseCaseModule, invitesRepository());
        }

        private ListMapper<DataCountryCode, DomainCountryCode> listMapperOfDataCountryCodeAndDomainCountryCode() {
            return ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory.provideDataCountryCodeToDomainCountryCode(this.listMappersModule, new DataCountryCodeToDomainCountryCodeMapper());
        }

        private CountryCodeRepository countryCodeRepository() {
            return new CountryCodeRepository(new CountryCodeSource(), listMapperOfDataCountryCodeAndDomainCountryCode());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCountryCodeUseCase getCountryCodeUseCase() {
            return CountryCodeUseCaseModule_ProvideGetCountryCodeUseCaseFactory.provideGetCountryCodeUseCase(this.countryCodeUseCaseModule, countryCodeRepository());
        }

        private NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure> nullableInputListMapperOfDataPopupStoryStructureAndDomainPopupStoryStructure() {
            return ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory.provideDataPopupStoriesToDomainPopupStoriesCatalog(this.listMappersModule, new DataPopupStoryToDomainPopupStoryMapper());
        }

        private PopupStoriesRepository popupStoriesRepository() {
            return new PopupStoriesRepository(this.providePopupStoriesApiProvider.get(), nullableInputListMapperOfDataPopupStoryStructureAndDomainPopupStoryStructure(), new DataPopupStoryToDomainPopupStoryMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetPopupStoriesUseCase getPopupStoriesUseCase() {
            return PopupStoriesUseCaseModule_ProvideGetPopupStoriesUseCaseFactory.provideGetPopupStoriesUseCase(this.popupStoriesUseCaseModule, popupStoriesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SendPopupStoriesActionUseCase sendPopupStoriesActionUseCase() {
            return PopupStoriesUseCaseModule_ProvideSendPopupStoriesUseCaseFactory.provideSendPopupStoriesUseCase(this.popupStoriesUseCaseModule, popupStoriesRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure> nullableInputListMapperOfDomainPopupStoryStructureAndPopupStoryStructure() {
            return DomainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactory.provideDomainPopupStoriesToPopupStories(this.domainCommonListMapperModule, new DomainPopupStoriesToPopupStoriesMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetMarketV2UseCase getMarketV2UseCase() {
            return SubscriptionsUseCaseModule_ProvideGetMarketV2UseCaseFactory.provideGetMarketV2UseCase(this.subscriptionsUseCaseModule, marketRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DomainBaseSubscriptionToBaseSubscriptionMapper domainBaseSubscriptionToBaseSubscriptionMapper() {
            return new DomainBaseSubscriptionToBaseSubscriptionMapper(new DomainBaseAppearanceToBaseAppearanceMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DomainOuterServiceToOuterServiceMapper domainOuterServiceToOuterServiceMapper() {
            return new DomainOuterServiceToOuterServiceMapper(new DomainOuterServiceAppearanceToOuterServiceAppearanceMapper());
        }

        private PhysicalKeysRepository physicalKeysRepository() {
            return new PhysicalKeysRepository(this.providePhysicalKeysApiProvider.get(), new DataPhysicalKeyToDomainPhysicalKeyMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetPhysicalKeysUseCase getPhysicalKeysUseCase() {
            return PhysicalKeysUseCaseModule_ProvideGetPhysicalKeysUseCaseFactory.provideGetPhysicalKeysUseCase(this.physicalKeysUseCaseModule, physicalKeysRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CreatePhysicalKeyUseCase createPhysicalKeyUseCase() {
            return PhysicalKeysUseCaseModule_ProvideCreatePhysicalKeyUseCaseFactory.provideCreatePhysicalKeyUseCase(this.physicalKeysUseCaseModule, physicalKeysRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BlockPhysicalKeyUseCase blockPhysicalKeyUseCase() {
            return PhysicalKeysUseCaseModule_ProvideBlockPhysicalKeyUseCaseFactory.provideBlockPhysicalKeyUseCase(this.physicalKeysUseCaseModule, physicalKeysRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UnblockPhysicalKeyUseCase unblockPhysicalKeyUseCase() {
            return PhysicalKeysUseCaseModule_ProvideUnblockPhysicalKeyUseCaseFactory.provideUnblockPhysicalKeyUseCase(this.physicalKeysUseCaseModule, physicalKeysRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeletePhysicalKeyUseCase deletePhysicalKeyUseCase() {
            return PhysicalKeysUseCaseModule_ProvideDeletePhysicalKeyUseCaseFactory.provideDeletePhysicalKeyUseCase(this.physicalKeysUseCaseModule, physicalKeysRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UpdatePhysicalKeyCommentUseCase updatePhysicalKeyCommentUseCase() {
            return PhysicalKeysUseCaseModule_ProvideUpdatePhysicalKeyCommentUseCaseFactory.provideUpdatePhysicalKeyCommentUseCase(this.physicalKeysUseCaseModule, physicalKeysRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Class<? extends ViewModel>, Provider<ViewModel>> mapOfClassOfAndProviderOfViewModel() {
            return ImmutableMap.builderWithExpectedSize(32).put(FamilyViewModel.class, this.familyViewModelProvider).put(AddressViewModel.class, this.addressViewModelProvider).put(ArchiveViewModel.class, this.archiveViewModelProvider).put(CardViewModel.class, this.cardViewModelProvider).put(DigitalKeysViewModel.class, this.digitalKeysViewModelProvider).put(EventViewModel.class, this.eventViewModelProvider).put(FrServiceViewModel.class, this.frServiceViewModelProvider).put(HelpViewModel.class, this.helpViewModelProvider).put(MarketViewModel.class, this.marketViewModelProvider).put(SplashViewModel.class, this.splashViewModelProvider).put(SubscriptionViewModel.class, this.subscriptionViewModelProvider).put(SurveyViewModel.class, this.surveyViewModelProvider).put(NotificationsViewModel.class, this.notificationsViewModelProvider).put(FaqViewModel.class, this.faqViewModelProvider).put(GorservViewModel.class, this.gorservViewModelProvider).put(SettingsViewModel.class, this.settingsViewModelProvider).put(ServicePaymentsViewModel.class, this.servicePaymentsViewModelProvider).put(PaymentsViewModel.class, this.paymentsViewModelProvider).put(SurveysViewModel.class, this.surveysViewModelProvider).put(TilesViewModel.class, this.tilesViewModelProvider).put(LocalizationViewModel.class, this.localizationViewModelProvider).put(ProfileViewModel.class, this.profileViewModelProvider).put(StoriesViewModel.class, this.storiesViewModelProvider).put(AlertsViewModel.class, this.alertsViewModelProvider).put(NavigationViewModel.class, this.navigationViewModelProvider).put(StateViewModel.class, this.stateViewModelProvider).put(OnboardingViewModel.class, this.onboardingViewModelProvider).put(InvitesViewModel.class, this.invitesViewModelProvider).put(PopupStoriesViewModel.class, this.popupStoriesViewModelProvider).put(InstructionsViewModel.class, this.instructionsViewModelProvider).put(SubscriptionsViewModel.class, this.subscriptionsViewModelProvider).put(KeysViewModel.class, this.keysViewModelProvider).build();
        }

        private CallRepository callRepository() {
            return new CallRepository(this.provideCallApiProvider.get(), new DataCallToDomainCallMapper(), new DataSipCallToDomainSipCallMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCallUseCase getCallUseCase() {
            return CallUseCaseModule_ProvideGetCallUseCaseFactory.provideGetCallUseCase(this.callUseCaseModule, callRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AcceptCallUseCase acceptCallUseCase() {
            return CallUseCaseModule_ProvideAcceptCallUseCaseFactory.provideAcceptCallUseCase(this.callUseCaseModule, callRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetSipAccountUseCase getSipAccountUseCase() {
            return CallUseCaseModule_ProvideGetSipAccountUseCaseFactory.provideGetSipAccountUseCase(this.callUseCaseModule, callRepository());
        }

        private NullableInputListMapper<DataCamera, DomainCamera> nullableInputListMapperOfDataCameraAndDomainCamera() {
            return ListMappersModule_ProvideDataCameraToDomainCameraFactory.provideDataCameraToDomainCamera(this.listMappersModule, new DataCameraToDomainCameraMapper());
        }

        private CamerasRepository camerasRepository() {
            return new CamerasRepository(this.provideCamerasApiProvider.get(), nullableInputListMapperOfDataCameraAndDomainCamera(), new DataCameraToDomainCameraMapper(), this.prefManagerProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCameraByIntercomUUIDUseCase getCameraByIntercomUUIDUseCase() {
            return CamerasUseCaseModule_ProvideGetCameraByIntercomUUIDUseCaseFactory.provideGetCameraByIntercomUUIDUseCase(this.camerasUseCaseModule, camerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DomainCameraToCameraMapper domainCameraToCameraMapper() {
            return new DomainCameraToCameraMapper(new DomainFlussonicToFlussonicMapper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public OpenDoorUseCase openDoorUseCase() {
            return CamerasUseCaseModule_ProvideOpenDoorUseCaseFactory.provideOpenDoorUseCase(this.camerasUseCaseModule, camerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetAllCamerasUseCase getAllCamerasUseCase() {
            return CamerasUseCaseModule_ProvideGetAllCamerasUseCaseFactory.provideGetAllCamerasUseCase(this.camerasUseCaseModule, camerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCamerasDemoUseCase getCamerasDemoUseCase() {
            return CamerasUseCaseModule_ProvideGetCamerasDemoUseCaseFactory.provideGetCamerasDemoUseCase(this.camerasUseCaseModule, camerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public OpenSecondDoorUseCase openSecondDoorUseCase() {
            return CamerasUseCaseModule_ProvideOpenSecondDoorUseCaseFactory.provideOpenSecondDoorUseCase(this.camerasUseCaseModule, camerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ListMapper<DomainCamera, Camera> listMapperOfDomainCameraAndCamera() {
            return DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory.provideDomainCameraToCamera(this.domainCommonListMapperModule, domainCameraToCameraMapper());
        }

        private CallHistoryPageSource callHistoryPageSource() {
            return new CallHistoryPageSource(this.provideCallApiProvider.get(), this.prefManagerProvider.get());
        }

        private CallHistoryRepository callHistoryRepository() {
            return new CallHistoryRepository(this.provideCallApiProvider.get(), new DataCallToDomainCallMapper(), new DataCallHistoryToDomainCallHistoryMapper(), callHistoryPageSource());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCallHistoryUseCase getCallHistoryUseCase() {
            return CallHistoryUseCaseModule_ProvideGetCallHistoryByPagingUseCaseFactory.provideGetCallHistoryByPagingUseCase(this.callHistoryUseCaseModule, callHistoryRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeleteCallHistoryUseCase deleteCallHistoryUseCase() {
            return CallHistoryUseCaseModule_ProvideDeleteCallFromHistoryUseCaseFactory.provideDeleteCallFromHistoryUseCase(this.callHistoryUseCaseModule, callHistoryRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DomainCallHistoryToCallHistoryMapper domainCallHistoryToCallHistoryMapper() {
            return new DomainCallHistoryToCallHistoryMapper(this.provideLocalizationStorageProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UpdateUseNameUseCase updateUseNameUseCase() {
            return ProfileUseCaseModule_ProvideUpdateUseNameUseCaseFactory.provideUpdateUseNameUseCase(this.profileUseCaseModule, this.profileRepositoryProvider.get());
        }

        private DataCamerasOrderToDomainCamerasOrderMapper dataCamerasOrderToDomainCamerasOrderMapper() {
            return new DataCamerasOrderToDomainCamerasOrderMapper(new DataCameraObjectToDomainCameraObjectMapper());
        }

        private DomainCamerasOrderToDataCamerasOrderMapper domainCamerasOrderToDataCamerasOrderMapper() {
            return new DomainCamerasOrderToDataCamerasOrderMapper(new DomainCameraObjectToDataCameraObjectMapper());
        }

        private NullableInputListMapper<DataCamerasOrder, DomainCamerasOrder> nullableInputListMapperOfDataCamerasOrderAndDomainCamerasOrder() {
            return ListMappersModule_ProvideDataCameraPreferencesToDomainCameraPreferencesFactory.provideDataCameraPreferencesToDomainCameraPreferences(this.listMappersModule, dataCamerasOrderToDomainCamerasOrderMapper());
        }

        private ManageCamerasRepository manageCamerasRepository() {
            return new ManageCamerasRepository(this.provideCamerasApiProvider.get(), dataCamerasOrderToDomainCamerasOrderMapper(), new DataCameraObjectToDomainCameraObjectMapper(), new DomainCameraObjectToDataCameraObjectMapper(), domainCamerasOrderToDataCamerasOrderMapper(), nullableInputListMapperOfDataCamerasOrderAndDomainCamerasOrder());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SetCamerasOrderUseCase setCamerasOrderUseCase() {
            return ManageCamerasUseCaseModule_ProvideSetCamerasOrderUseCaseFactory.provideSetCamerasOrderUseCase(this.manageCamerasUseCaseModule, manageCamerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCamerasOrderUseCase getCamerasOrderUseCase() {
            return ManageCamerasUseCaseModule_ProvideGetCamerasOrderUseCaseFactory.provideGetCamerasOrderUseCase(this.manageCamerasUseCaseModule, manageCamerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SetCameraParamsUseCase setCameraParamsUseCase() {
            return ManageCamerasUseCaseModule_ProvideSetCameraParamsUseCaseFactory.provideSetCameraParamsUseCase(this.manageCamerasUseCaseModule, manageCamerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GetCamerasPreferencesUseCase getCamerasPreferencesUseCase() {
            return ManageCamerasUseCaseModule_ProvideGetCamerasPreferencesUseCaseFactory.provideGetCamerasPreferencesUseCase(this.manageCamerasUseCaseModule, manageCamerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ClearCamerasPreferencesUseCase clearCamerasPreferencesUseCase() {
            return ManageCamerasUseCaseModule_ProvideClearCamerasPreferencesUseCaseFactory.provideClearCamerasPreferencesUseCase(this.manageCamerasUseCaseModule, manageCamerasRepository());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CamerasOrderToDomainCamerasOrderMapper camerasOrderToDomainCamerasOrderMapper() {
            return new CamerasOrderToDomainCamerasOrderMapper(new CameraObjectToDomainCameraObjectMapper());
        }

        private void initialize(AddressUseCaseModule addressUseCaseModule, CallUseCaseModule callUseCaseModule, CallHistoryUseCaseModule callHistoryUseCaseModule, CardUseCaseModule cardUseCaseModule, DigitalKeysUseCaseModule digitalKeysUseCaseModule, EventUseCaseModule eventUseCaseModule, FamilyUseCaseModule familyUseCaseModule, ManageCamerasUseCaseModule manageCamerasUseCaseModule, MarketUseCaseModule marketUseCaseModule, SubscriptionUseCaseModule subscriptionUseCaseModule, SingleUseCaseModule singleUseCaseModule, AlertsUseCaseModule alertsUseCaseModule, SurveysUseCaseModule surveysUseCaseModule, NotificationsUseCaseModule notificationsUseCaseModule, SupportUseCaseModule supportUseCaseModule, GorservUseCaseModule gorservUseCaseModule, TilesUseCaseModule tilesUseCaseModule, NetworkModule networkModule, ListMappersModule listMappersModule, LocalizationStorageModule localizationStorageModule, PaymentsUseCaseModule paymentsUseCaseModule, GetAccountInfoUseCaseModule getAccountInfoUseCaseModule, DomainListMapperModule domainListMapperModule, DomainCommonListMapperModule domainCommonListMapperModule, OnBoardingListMapperModule onBoardingListMapperModule, LocalizationUseCaseModule localizationUseCaseModule, CountryCodeUseCaseModule countryCodeUseCaseModule, CamerasUseCaseModule camerasUseCaseModule, ProfileUseCaseModule profileUseCaseModule, StoriesUseCaseModule storiesUseCaseModule, PopupStoriesUseCaseModule popupStoriesUseCaseModule, InvitesUseCaseModule invitesUseCaseModule, SubscriptionsUseCaseModule subscriptionsUseCaseModule, PhysicalKeysUseCaseModule physicalKeysUseCaseModule, Application application) {
            this.prefManagerProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 0));
            this.analyticsProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 1));
            this.provideLocalizationStorageProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 2));
            this.provideBaseOkHttpProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 8));
            this.provideOkHttpProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 7));
            this.provideProdRetrofitProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 6));
            this.provideFamilyApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 5));
            this.provideProfileApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 10));
            this.profileRepositoryProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 9));
            this.familyViewModelProvider = new SwitchingProvider(this.appComponentImpl, 4);
            this.provideAddressApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 12));
            this.addressViewModelProvider = new SwitchingProvider(this.appComponentImpl, 11);
            this.provideServicesApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 14));
            this.archiveViewModelProvider = new SwitchingProvider(this.appComponentImpl, 13);
            this.provideCardApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 16));
            this.cardViewModelProvider = new SwitchingProvider(this.appComponentImpl, 15);
            this.provideDigitalKeysApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 18));
            this.digitalKeysViewModelProvider = new SwitchingProvider(this.appComponentImpl, 17);
            this.provideEventApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 20));
            this.eventViewModelProvider = new SwitchingProvider(this.appComponentImpl, 19);
            this.frServiceViewModelProvider = new SwitchingProvider(this.appComponentImpl, 21);
            this.provideHelpApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 23));
            this.provideFaqApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 24));
            this.helpViewModelProvider = new SwitchingProvider(this.appComponentImpl, 22);
            this.provideMarketApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 26));
            this.marketViewModelProvider = new SwitchingProvider(this.appComponentImpl, 25);
            this.splashViewModelProvider = new SwitchingProvider(this.appComponentImpl, 27);
            this.provideSubscriptionApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 29));
            this.subscriptionViewModelProvider = new SwitchingProvider(this.appComponentImpl, 28);
            this.provideSurveyApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 31));
            this.surveyViewModelProvider = new SwitchingProvider(this.appComponentImpl, 30);
            this.provideNotificationsApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 33));
            this.notificationsViewModelProvider = new SwitchingProvider(this.appComponentImpl, 32);
            this.faqViewModelProvider = new SwitchingProvider(this.appComponentImpl, 34);
            this.provideGorservApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 36));
            this.gorservViewModelProvider = new SwitchingProvider(this.appComponentImpl, 35);
            this.settingsViewModelProvider = new SwitchingProvider(this.appComponentImpl, 37);
            this.provideServicePaymentsApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 39));
            this.servicePaymentsViewModelProvider = new SwitchingProvider(this.appComponentImpl, 38);
            this.paymentsViewModelProvider = new SwitchingProvider(this.appComponentImpl, 40);
            this.surveysViewModelProvider = new SwitchingProvider(this.appComponentImpl, 41);
            this.provideOkHttpNoJwtProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 45));
            this.provideBaseProdRetrofitProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 44));
            this.provideTilesApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 43));
            this.tilesViewModelProvider = new SwitchingProvider(this.appComponentImpl, 42);
            this.provideLocalizationApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 47));
            this.localizationViewModelProvider = new SwitchingProvider(this.appComponentImpl, 46);
            this.profileViewModelProvider = new SwitchingProvider(this.appComponentImpl, 48);
            this.provideStoriesApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 50));
            this.storiesViewModelProvider = new SwitchingProvider(this.appComponentImpl, 49);
            this.provideAlertsApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 52));
            this.alertsViewModelProvider = new SwitchingProvider(this.appComponentImpl, 51);
            this.navigationViewModelProvider = new SwitchingProvider(this.appComponentImpl, 53);
            this.stateViewModelProvider = new SwitchingProvider(this.appComponentImpl, 54);
            this.onboardingViewModelProvider = new SwitchingProvider(this.appComponentImpl, 55);
            this.provideInvitesApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 57));
            this.invitesViewModelProvider = new SwitchingProvider(this.appComponentImpl, 56);
            this.providePopupStoriesApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 59));
            this.popupStoriesViewModelProvider = new SwitchingProvider(this.appComponentImpl, 58);
            this.instructionsViewModelProvider = new SwitchingProvider(this.appComponentImpl, 60);
            this.subscriptionsViewModelProvider = new SwitchingProvider(this.appComponentImpl, 61);
            this.providePhysicalKeysApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 63));
            this.keysViewModelProvider = new SwitchingProvider(this.appComponentImpl, 62);
            this.multiViewModelFactoryProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 3));
            this.provideCallApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 65));
            this.provideCamerasApiProvider = DoubleCheck.provider(new SwitchingProvider(this.appComponentImpl, 66));
            this.assistFactoryProvider = SingleCheck.provider(new SwitchingProvider(this.appComponentImpl, 64));
            this.assistFactoryProvider2 = SingleCheck.provider(new SwitchingProvider(this.appComponentImpl, 67));
            this.assistFactoryProvider3 = SingleCheck.provider(new SwitchingProvider(this.appComponentImpl, 68));
            this.assistFactoryProvider4 = SingleCheck.provider(new SwitchingProvider(this.appComponentImpl, 69));
            this.assistFactoryProvider5 = SingleCheck.provider(new SwitchingProvider(this.appComponentImpl, 70));
            this.factoryProvider = SingleCheck.provider(new SwitchingProvider(this.appComponentImpl, 71));
        }

        @Override // com.sputnik.oboarding.di.OnBoardingDeps, com.sputnik.service_payments.di.ServicePaymentDeps, com.sputnik.subscriptions.di.SubscriptionsDeps, com.sputnik.common.di.CommonDeps
        public PrefManager getPrefManager() {
            return this.prefManagerProvider.get();
        }

        @Override // com.sputnik.oboarding.di.OnBoardingDeps, com.sputnik.service_payments.di.ServicePaymentDeps, com.sputnik.subscriptions.di.SubscriptionsDeps, com.sputnik.common.di.CommonDeps
        public Application getApplication() {
            return this.applicationContext;
        }

        @Override // com.sputnik.oboarding.di.OnBoardingDeps, com.sputnik.service_payments.di.ServicePaymentDeps, com.sputnik.subscriptions.di.SubscriptionsDeps, com.sputnik.common.di.CommonDeps
        public Analytics getAnalytics() {
            return this.analyticsProvider.get();
        }

        @Override // com.sputnik.oboarding.di.OnBoardingDeps, com.sputnik.service_payments.di.ServicePaymentDeps, com.sputnik.subscriptions.di.SubscriptionsDeps, com.sputnik.common.di.CommonDeps
        public IConfig getConfig() {
            return new Config();
        }

        @Override // com.sputnik.oboarding.di.OnBoardingDeps, com.sputnik.service_payments.di.ServicePaymentDeps, com.sputnik.subscriptions.di.SubscriptionsDeps, com.sputnik.common.di.CommonDeps
        public LocalizationStorage getLocalizationStorage() {
            return this.provideLocalizationStorageProvider.get();
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SputnikRootActivity sputnikRootActivity) {
            injectSputnikRootActivity(sputnikRootActivity);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CallActivity callActivity) {
            injectCallActivity(callActivity);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BaseFragment baseFragment) {
            injectBaseFragment(baseFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CustomEmptySplashActivity customEmptySplashActivity) {
            injectCustomEmptySplashActivity(customEmptySplashActivity);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CallNotificationService callNotificationService) {
            injectCallNotificationService(callNotificationService);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(PushIntentService pushIntentService) {
            injectPushIntentService(pushIntentService);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BaseOpenDoorWidget baseOpenDoorWidget) {
            injectBaseOpenDoorWidget(baseOpenDoorWidget);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ProfileNoIntercom profileNoIntercom) {
            injectProfileNoIntercom(profileNoIntercom);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CustomSplashFragment customSplashFragment) {
            injectCustomSplashFragment(customSplashFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BlockedFragment blockedFragment) {
            injectBlockedFragment(blockedFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(AnswerCallFragment answerCallFragment) {
            injectAnswerCallFragment(answerCallFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ReceivingCallFragment receivingCallFragment) {
            injectReceivingCallFragment(receivingCallFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(MainHostFragment mainHostFragment) {
            injectMainHostFragment(mainHostFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(GlobalCameraFragment globalCameraFragment) {
            injectGlobalCameraFragment(globalCameraFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(GlobalCamerasFragment globalCamerasFragment) {
            injectGlobalCamerasFragment(globalCamerasFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CallHistoryFragment callHistoryFragment) {
            injectCallHistoryFragment(callHistoryFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(NoCamerasFragment noCamerasFragment) {
            injectNoCamerasFragment(noCamerasFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CallHistoryDetails callHistoryDetails) {
            injectCallHistoryDetails(callHistoryDetails);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SurveyCommentFragment surveyCommentFragment) {
            injectSurveyCommentFragment(surveyCommentFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SurveyFinishFragment surveyFinishFragment) {
            injectSurveyFinishFragment(surveyFinishFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SurveyFragment surveyFragment) {
            injectSurveyFragment(surveyFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(AboutAppFragment aboutAppFragment) {
            injectAboutAppFragment(aboutAppFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(AboutCompanyFragment aboutCompanyFragment) {
            injectAboutCompanyFragment(aboutCompanyFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(HelpFragment helpFragment) {
            injectHelpFragment(helpFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ServicesInfoFragment servicesInfoFragment) {
            injectServicesInfoFragment(servicesInfoFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SelectArchiveBottomSheet selectArchiveBottomSheet) {
            injectSelectArchiveBottomSheet(selectArchiveBottomSheet);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FrErrorFragment frErrorFragment) {
            injectFrErrorFragment(frErrorFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FrServiceFragment frServiceFragment) {
            injectFrServiceFragment(frServiceFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FrStartScanFragment frStartScanFragment) {
            injectFrStartScanFragment(frStartScanFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FrSuccessFragment frSuccessFragment) {
            injectFrSuccessFragment(frSuccessFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ShotFragment shotFragment) {
            injectShotFragment(shotFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CancelSubscriptionBottomSheet cancelSubscriptionBottomSheet) {
            injectCancelSubscriptionBottomSheet(cancelSubscriptionBottomSheet);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SubscriptionFragment subscriptionFragment) {
            injectSubscriptionFragment(subscriptionFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SettingsProfileFragment settingsProfileFragment) {
            injectSettingsProfileFragment(settingsProfileFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SettingsAddress settingsAddress) {
            injectSettingsAddress(settingsAddress);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ManageCamerasFragment manageCamerasFragment) {
            injectManageCamerasFragment(manageCamerasFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CamerasPreviewFragment camerasPreviewFragment) {
            injectCamerasPreviewFragment(camerasPreviewFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ManageCamerasDetails manageCamerasDetails) {
            injectManageCamerasDetails(manageCamerasDetails);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(LocalizationSplash localizationSplash) {
            injectLocalizationSplash(localizationSplash);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(LocalizationListFragment localizationListFragment) {
            injectLocalizationListFragment(localizationListFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(LocalizationBottomSheet localizationBottomSheet) {
            injectLocalizationBottomSheet(localizationBottomSheet);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(IntercomSettingsFragment intercomSettingsFragment) {
            injectIntercomSettingsFragment(intercomSettingsFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FamilyListFragment familyListFragment) {
            injectFamilyListFragment(familyListFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FamilyInfoFragment familyInfoFragment) {
            injectFamilyInfoFragment(familyInfoFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(NewCardFragment newCardFragment) {
            injectNewCardFragment(newCardFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CardFragment cardFragment) {
            injectCardFragment(cardFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ProfileFragment profileFragment) {
            injectProfileFragment(profileFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FlussonicActivity flussonicActivity) {
            injectFlussonicActivity(flussonicActivity);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(MainHostNoIntercom mainHostNoIntercom) {
            injectMainHostNoIntercom(mainHostNoIntercom);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(DigitalKeysServiceFragment digitalKeysServiceFragment) {
            injectDigitalKeysServiceFragment(digitalKeysServiceFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ArchiveServiceFragment archiveServiceFragment) {
            injectArchiveServiceFragment(archiveServiceFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(EmergencyCodeBottomSheet emergencyCodeBottomSheet) {
            injectEmergencyCodeBottomSheet(emergencyCodeBottomSheet);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ErrorArchiveDialog errorArchiveDialog) {
            injectErrorArchiveDialog(errorArchiveDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(RateUsDialog rateUsDialog) {
            injectRateUsDialog(rateUsDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(DeleteCodeDialog deleteCodeDialog) {
            injectDeleteCodeDialog(deleteCodeDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(UpdatePermCodeDialog updatePermCodeDialog) {
            injectUpdatePermCodeDialog(updatePermCodeDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(UpdateTempCodeDialog updateTempCodeDialog) {
            injectUpdateTempCodeDialog(updateTempCodeDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FrRemoveDialog frRemoveDialog) {
            injectFrRemoveDialog(frRemoveDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(PartnerServiceDialog partnerServiceDialog) {
            injectPartnerServiceDialog(partnerServiceDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SuccessSubscriptionDialog successSubscriptionDialog) {
            injectSuccessSubscriptionDialog(successSubscriptionDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(LogOutDialog logOutDialog) {
            injectLogOutDialog(logOutDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(DeleteAccountDialog deleteAccountDialog) {
            injectDeleteAccountDialog(deleteAccountDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SettingsActivity settingsActivity) {
            injectSettingsActivity(settingsActivity);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(PushSettingsActivity pushSettingsActivity) {
            injectPushSettingsActivity(pushSettingsActivity);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BleSettingsActivity bleSettingsActivity) {
            injectBleSettingsActivity(bleSettingsActivity);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BeaconTrackingService beaconTrackingService) {
            injectBeaconTrackingService(beaconTrackingService);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(NewMarketFragment newMarketFragment) {
            injectNewMarketFragment(newMarketFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SubscriptionDetailsFragment subscriptionDetailsFragment) {
            injectSubscriptionDetailsFragment(subscriptionDetailsFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetAboutSubscription bottomSheetAboutSubscription) {
            injectBottomSheetAboutSubscription(bottomSheetAboutSubscription);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetUpdateRequired bottomSheetUpdateRequired) {
            injectBottomSheetUpdateRequired(bottomSheetUpdateRequired);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FragmentUpdateRequired fragmentUpdateRequired) {
            injectFragmentUpdateRequired(fragmentUpdateRequired);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetAboutCallHistory bottomSheetAboutCallHistory) {
            injectBottomSheetAboutCallHistory(bottomSheetAboutCallHistory);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetNoArchive bottomSheetNoArchive) {
            injectBottomSheetNoArchive(bottomSheetNoArchive);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SendInstallSputnikRequestFragment sendInstallSputnikRequestFragment) {
            injectSendInstallSputnikRequestFragment(sendInstallSputnikRequestFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(OurHomeUpdateFragment ourHomeUpdateFragment) {
            injectOurHomeUpdateFragment(ourHomeUpdateFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(AboutOurHomeDialog aboutOurHomeDialog) {
            injectAboutOurHomeDialog(aboutOurHomeDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetRatePoll bottomSheetRatePoll) {
            injectBottomSheetRatePoll(bottomSheetRatePoll);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetPollSuccess bottomSheetPollSuccess) {
            injectBottomSheetPollSuccess(bottomSheetPollSuccess);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(PushProcessorImpl pushProcessorImpl) {
            injectPushProcessorImpl(pushProcessorImpl);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ExperimentalFunctionsFragment experimentalFunctionsFragment) {
            injectExperimentalFunctionsFragment(experimentalFunctionsFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(InfoDialog infoDialog) {
            injectInfoDialog(infoDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetAboutBetaProgram bottomSheetAboutBetaProgram) {
            injectBottomSheetAboutBetaProgram(bottomSheetAboutBetaProgram);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(NotificationsFragment notificationsFragment) {
            injectNotificationsFragment(notificationsFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(NotificationsDetailsFragment notificationsDetailsFragment) {
            injectNotificationsDetailsFragment(notificationsDetailsFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FaqFragment faqFragment) {
            injectFaqFragment(faqFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FaqCategoriesFragment faqCategoriesFragment) {
            injectFaqCategoriesFragment(faqCategoriesFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(FaqSubcategoriesFragment faqSubcategoriesFragment) {
            injectFaqSubcategoriesFragment(faqSubcategoriesFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(AboutVpnDialog aboutVpnDialog) {
            injectAboutVpnDialog(aboutVpnDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SelectGorservCategoryFragment selectGorservCategoryFragment) {
            injectSelectGorservCategoryFragment(selectGorservCategoryFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SendGorservRequestFragment sendGorservRequestFragment) {
            injectSendGorservRequestFragment(sendGorservRequestFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetGorservRequestSent bottomSheetGorservRequestSent) {
            injectBottomSheetGorservRequestSent(bottomSheetGorservRequestSent);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ChangeGorservUserPhoneDialog changeGorservUserPhoneDialog) {
            injectChangeGorservUserPhoneDialog(changeGorservUserPhoneDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(GorservErrorDialog gorservErrorDialog) {
            injectGorservErrorDialog(gorservErrorDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(MobilePackFragment mobilePackFragment) {
            injectMobilePackFragment(mobilePackFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ResendFamilyInviteDialog resendFamilyInviteDialog) {
            injectResendFamilyInviteDialog(resendFamilyInviteDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetInviteToFamily bottomSheetInviteToFamily) {
            injectBottomSheetInviteToFamily(bottomSheetInviteToFamily);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(SendFamilyInviteErrorDialog sendFamilyInviteErrorDialog) {
            injectSendFamilyInviteErrorDialog(sendFamilyInviteErrorDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(RemoveFromFamilyDialog removeFromFamilyDialog) {
            injectRemoveFromFamilyDialog(removeFromFamilyDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(LeaveFromFamilyDialog leaveFromFamilyDialog) {
            injectLeaveFromFamilyDialog(leaveFromFamilyDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BleServiceFragment bleServiceFragment) {
            injectBleServiceFragment(bleServiceFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(NoPermissionsDialog noPermissionsDialog) {
            injectNoPermissionsDialog(noPermissionsDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(PermissionsFragment permissionsFragment) {
            injectPermissionsFragment(permissionsFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetPermissionExplaining bottomSheetPermissionExplaining) {
            injectBottomSheetPermissionExplaining(bottomSheetPermissionExplaining);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetSetupRssi bottomSheetSetupRssi) {
            injectBottomSheetSetupRssi(bottomSheetSetupRssi);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetNoBlePermissions bottomSheetNoBlePermissions) {
            injectBottomSheetNoBlePermissions(bottomSheetNoBlePermissions);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(RebootBroadcastReceiver rebootBroadcastReceiver) {
            injectRebootBroadcastReceiver(rebootBroadcastReceiver);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BeaconServiceManager beaconServiceManager) {
            injectBeaconServiceManager(beaconServiceManager);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(WebRtcPlayerImplNew webRtcPlayerImplNew) {
            injectWebRtcPlayerImplNew(webRtcPlayerImplNew);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(WebRtcPlayerImpl webRtcPlayerImpl) {
            injectWebRtcPlayerImpl(webRtcPlayerImpl);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(PopupStoriesFragment popupStoriesFragment) {
            injectPopupStoriesFragment(popupStoriesFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(PopupStoryFragment popupStoryFragment) {
            injectPopupStoryFragment(popupStoryFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetBackgroundWork bottomSheetBackgroundWork) {
            injectBottomSheetBackgroundWork(bottomSheetBackgroundWork);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BackgroundWorkFragment backgroundWorkFragment) {
            injectBackgroundWorkFragment(backgroundWorkFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(InstructionFragment instructionFragment) {
            injectInstructionFragment(instructionFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(KeysFragment keysFragment) {
            injectKeysFragment(keysFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(KeyManageFragment keyManageFragment) {
            injectKeyManageFragment(keyManageFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(KeyRegisterFragment keyRegisterFragment) {
            injectKeyRegisterFragment(keyRegisterFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetKeyAddError bottomSheetKeyAddError) {
            injectBottomSheetKeyAddError(bottomSheetKeyAddError);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(DeleteKeyDialog deleteKeyDialog) {
            injectDeleteKeyDialog(deleteKeyDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ItemDetailsFragment itemDetailsFragment) {
            injectItemDetailsFragment(itemDetailsFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetNeedSubscriptionToAddKey bottomSheetNeedSubscriptionToAddKey) {
            injectBottomSheetNeedSubscriptionToAddKey(bottomSheetNeedSubscriptionToAddKey);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CameraStreamFragment cameraStreamFragment) {
            injectCameraStreamFragment(cameraStreamFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(DeletePaymentMethodDialog deletePaymentMethodDialog) {
            injectDeletePaymentMethodDialog(deletePaymentMethodDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(CheckCallStateService checkCallStateService) {
            injectCheckCallStateService(checkCallStateService);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ClearCameraPreferencesDialog clearCameraPreferencesDialog) {
            injectClearCameraPreferencesDialog(clearCameraPreferencesDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetSelectAddress bottomSheetSelectAddress) {
            injectBottomSheetSelectAddress(bottomSheetSelectAddress);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(DeleteAddressDialog deleteAddressDialog) {
            injectDeleteAddressDialog(deleteAddressDialog);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(YandexHomeFragment yandexHomeFragment) {
            injectYandexHomeFragment(yandexHomeFragment);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetNeedSubscriptionToAddDeviceForYandexAlice bottomSheetNeedSubscriptionToAddDeviceForYandexAlice) {
            injectBottomSheetNeedSubscriptionToAddDeviceForYandexAlice(bottomSheetNeedSubscriptionToAddDeviceForYandexAlice);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetMultiAddressAnnounce bottomSheetMultiAddressAnnounce) {
            injectBottomSheetMultiAddressAnnounce(bottomSheetMultiAddressAnnounce);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(BottomSheetSubscriptionNeededForCalls bottomSheetSubscriptionNeededForCalls) {
            injectBottomSheetSubscriptionNeededForCalls(bottomSheetSubscriptionNeededForCalls);
        }

        @Override // sputnik.axmor.com.sputnik.di.AppComponent
        public void inject(ArchiveWebView archiveWebView) {
            injectArchiveWebView(archiveWebView);
        }

        private SputnikRootActivity injectSputnikRootActivity(SputnikRootActivity sputnikRootActivity) {
            SputnikRootActivity_MembersInjector.injectLocalizationScreen(sputnikRootActivity, this.provideLocalizationStorageProvider.get());
            SputnikRootActivity_MembersInjector.injectFactory(sputnikRootActivity, this.multiViewModelFactoryProvider.get());
            SputnikRootActivity_MembersInjector.injectAnalytics(sputnikRootActivity, this.analyticsProvider.get());
            return sputnikRootActivity;
        }

        private CallActivity injectCallActivity(CallActivity callActivity) {
            CallActivity_MembersInjector.injectCallFactory(callActivity, this.assistFactoryProvider.get());
            return callActivity;
        }

        private BaseFragment injectBaseFragment(BaseFragment baseFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(baseFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(baseFragment, this.prefManagerProvider.get());
            return baseFragment;
        }

        private CustomEmptySplashActivity injectCustomEmptySplashActivity(CustomEmptySplashActivity customEmptySplashActivity) {
            CustomEmptySplashActivity_MembersInjector.injectLocalizationScreen(customEmptySplashActivity, this.provideLocalizationStorageProvider.get());
            CustomEmptySplashActivity_MembersInjector.injectFactory(customEmptySplashActivity, this.multiViewModelFactoryProvider.get());
            CustomEmptySplashActivity_MembersInjector.injectPrefManager(customEmptySplashActivity, this.prefManagerProvider.get());
            CustomEmptySplashActivity_MembersInjector.injectAnalytics(customEmptySplashActivity, this.analyticsProvider.get());
            return customEmptySplashActivity;
        }

        private CallNotificationService injectCallNotificationService(CallNotificationService callNotificationService) {
            CallNotificationService_MembersInjector.injectLocalizationScreen(callNotificationService, this.provideLocalizationStorageProvider.get());
            return callNotificationService;
        }

        private PushIntentService injectPushIntentService(PushIntentService pushIntentService) {
            PushIntentService_MembersInjector.injectPrefManager(pushIntentService, this.prefManagerProvider.get());
            PushIntentService_MembersInjector.injectScope(pushIntentService, coroutineScope());
            PushIntentService_MembersInjector.injectErrHandler(pushIntentService, LocalizationStorageModule_ProvidesErrorHandlerFactory.providesErrorHandler(this.localizationStorageModule));
            PushIntentService_MembersInjector.injectSendPushTokenUseCase(pushIntentService, sendPushTokenUseCase());
            return pushIntentService;
        }

        private BaseOpenDoorWidget injectBaseOpenDoorWidget(BaseOpenDoorWidget baseOpenDoorWidget) {
            BaseOpenDoorWidget_MembersInjector.injectLocalizationScreen(baseOpenDoorWidget, this.provideLocalizationStorageProvider.get());
            BaseOpenDoorWidget_MembersInjector.injectPrefManager(baseOpenDoorWidget, this.prefManagerProvider.get());
            BaseOpenDoorWidget_MembersInjector.injectOpenDoorUseCase(baseOpenDoorWidget, openDoorUseCase());
            BaseOpenDoorWidget_MembersInjector.injectErrHandler(baseOpenDoorWidget, LocalizationStorageModule_ProvidesErrorHandlerFactory.providesErrorHandler(this.localizationStorageModule));
            BaseOpenDoorWidget_MembersInjector.injectAnalytics(baseOpenDoorWidget, this.analyticsProvider.get());
            BaseOpenDoorWidget_MembersInjector.injectScope(baseOpenDoorWidget, coroutineScope());
            return baseOpenDoorWidget;
        }

        private ProfileNoIntercom injectProfileNoIntercom(ProfileNoIntercom profileNoIntercom) {
            ProfileNoIntercom_MembersInjector.injectLocalizationScreen(profileNoIntercom, this.provideLocalizationStorageProvider.get());
            ProfileNoIntercom_MembersInjector.injectFactory(profileNoIntercom, this.multiViewModelFactoryProvider.get());
            ProfileNoIntercom_MembersInjector.injectAllCameraFactory(profileNoIntercom, this.assistFactoryProvider2.get());
            ProfileNoIntercom_MembersInjector.injectPrefManager(profileNoIntercom, this.prefManagerProvider.get());
            ProfileNoIntercom_MembersInjector.injectAnalytics(profileNoIntercom, this.analyticsProvider.get());
            return profileNoIntercom;
        }

        private CustomSplashFragment injectCustomSplashFragment(CustomSplashFragment customSplashFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(customSplashFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(customSplashFragment, this.prefManagerProvider.get());
            CustomSplashFragment_MembersInjector.injectLocalizationScreen(customSplashFragment, this.provideLocalizationStorageProvider.get());
            CustomSplashFragment_MembersInjector.injectCameraViewModelFactory(customSplashFragment, this.assistFactoryProvider2.get());
            CustomSplashFragment_MembersInjector.injectFactory(customSplashFragment, this.multiViewModelFactoryProvider.get());
            CustomSplashFragment_MembersInjector.injectPrefManager(customSplashFragment, this.prefManagerProvider.get());
            CustomSplashFragment_MembersInjector.injectConfig(customSplashFragment, new Config());
            CustomSplashFragment_MembersInjector.injectAnalytics(customSplashFragment, this.analyticsProvider.get());
            return customSplashFragment;
        }

        private BlockedFragment injectBlockedFragment(BlockedFragment blockedFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(blockedFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(blockedFragment, this.prefManagerProvider.get());
            BlockedFragment_MembersInjector.injectLocalizationScreen(blockedFragment, this.provideLocalizationStorageProvider.get());
            BlockedFragment_MembersInjector.injectAnalytics(blockedFragment, this.analyticsProvider.get());
            BlockedFragment_MembersInjector.injectFactory(blockedFragment, this.multiViewModelFactoryProvider.get());
            BlockedFragment_MembersInjector.injectCameraViewModelBuilder(blockedFragment, this.assistFactoryProvider2.get());
            return blockedFragment;
        }

        private AnswerCallFragment injectAnswerCallFragment(AnswerCallFragment answerCallFragment) {
            AnswerCallFragment_MembersInjector.injectLocalizationScreen(answerCallFragment, this.provideLocalizationStorageProvider.get());
            AnswerCallFragment_MembersInjector.injectCamerasFactory(answerCallFragment, this.assistFactoryProvider2.get());
            AnswerCallFragment_MembersInjector.injectCallViewModelFactory(answerCallFragment, this.assistFactoryProvider.get());
            AnswerCallFragment_MembersInjector.injectAnalytics(answerCallFragment, this.analyticsProvider.get());
            AnswerCallFragment_MembersInjector.injectPrefManager(answerCallFragment, this.prefManagerProvider.get());
            AnswerCallFragment_MembersInjector.injectFactory(answerCallFragment, this.multiViewModelFactoryProvider.get());
            return answerCallFragment;
        }

        private ReceivingCallFragment injectReceivingCallFragment(ReceivingCallFragment receivingCallFragment) {
            ReceivingCallFragment_MembersInjector.injectLocalizationScreen(receivingCallFragment, this.provideLocalizationStorageProvider.get());
            ReceivingCallFragment_MembersInjector.injectCamerasFactory(receivingCallFragment, this.assistFactoryProvider2.get());
            ReceivingCallFragment_MembersInjector.injectCallViewModelFactory(receivingCallFragment, this.assistFactoryProvider.get());
            ReceivingCallFragment_MembersInjector.injectAnalytics(receivingCallFragment, this.analyticsProvider.get());
            ReceivingCallFragment_MembersInjector.injectPrefManager(receivingCallFragment, this.prefManagerProvider.get());
            ReceivingCallFragment_MembersInjector.injectFactory(receivingCallFragment, this.multiViewModelFactoryProvider.get());
            return receivingCallFragment;
        }

        private MainHostFragment injectMainHostFragment(MainHostFragment mainHostFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(mainHostFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(mainHostFragment, this.prefManagerProvider.get());
            MainHostFragment_MembersInjector.injectFactory(mainHostFragment, this.multiViewModelFactoryProvider.get());
            MainHostFragment_MembersInjector.injectLocalizationScreen(mainHostFragment, this.provideLocalizationStorageProvider.get());
            MainHostFragment_MembersInjector.injectCameraViewModelBuilder(mainHostFragment, this.assistFactoryProvider2.get());
            MainHostFragment_MembersInjector.injectPrefManager(mainHostFragment, this.prefManagerProvider.get());
            MainHostFragment_MembersInjector.injectAnalytics(mainHostFragment, this.analyticsProvider.get());
            return mainHostFragment;
        }

        private GlobalCameraFragment injectGlobalCameraFragment(GlobalCameraFragment globalCameraFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(globalCameraFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(globalCameraFragment, this.prefManagerProvider.get());
            GlobalCameraFragment_MembersInjector.injectFactory(globalCameraFragment, this.multiViewModelFactoryProvider.get());
            GlobalCameraFragment_MembersInjector.injectCameraViewModelFactory(globalCameraFragment, this.assistFactoryProvider2.get());
            GlobalCameraFragment_MembersInjector.injectLocalizationScreen(globalCameraFragment, this.provideLocalizationStorageProvider.get());
            GlobalCameraFragment_MembersInjector.injectPrefManager(globalCameraFragment, this.prefManagerProvider.get());
            GlobalCameraFragment_MembersInjector.injectAnalytics(globalCameraFragment, this.analyticsProvider.get());
            return globalCameraFragment;
        }

        private GlobalCamerasFragment injectGlobalCamerasFragment(GlobalCamerasFragment globalCamerasFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(globalCamerasFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(globalCamerasFragment, this.prefManagerProvider.get());
            GlobalCamerasFragment_MembersInjector.injectFactory(globalCamerasFragment, this.multiViewModelFactoryProvider.get());
            GlobalCamerasFragment_MembersInjector.injectLocalizationScreen(globalCamerasFragment, this.provideLocalizationStorageProvider.get());
            GlobalCamerasFragment_MembersInjector.injectCameraViewModelFactory(globalCamerasFragment, this.assistFactoryProvider2.get());
            GlobalCamerasFragment_MembersInjector.injectPrefManager(globalCamerasFragment, this.prefManagerProvider.get());
            GlobalCamerasFragment_MembersInjector.injectAnalytics(globalCamerasFragment, this.analyticsProvider.get());
            return globalCamerasFragment;
        }

        private CallHistoryFragment injectCallHistoryFragment(CallHistoryFragment callHistoryFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(callHistoryFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(callHistoryFragment, this.prefManagerProvider.get());
            CallHistoryFragment_MembersInjector.injectLocalizationScreen(callHistoryFragment, this.provideLocalizationStorageProvider.get());
            CallHistoryFragment_MembersInjector.injectCallHistoryFactory(callHistoryFragment, this.assistFactoryProvider3.get());
            CallHistoryFragment_MembersInjector.injectFactory(callHistoryFragment, this.multiViewModelFactoryProvider.get());
            CallHistoryFragment_MembersInjector.injectCamerasFactory(callHistoryFragment, this.assistFactoryProvider2.get());
            CallHistoryFragment_MembersInjector.injectAnalytics(callHistoryFragment, this.analyticsProvider.get());
            return callHistoryFragment;
        }

        private NoCamerasFragment injectNoCamerasFragment(NoCamerasFragment noCamerasFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(noCamerasFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(noCamerasFragment, this.prefManagerProvider.get());
            NoCamerasFragment_MembersInjector.injectLocalizationScreen(noCamerasFragment, this.provideLocalizationStorageProvider.get());
            NoCamerasFragment_MembersInjector.injectSupportManager(noCamerasFragment, supportManager());
            NoCamerasFragment_MembersInjector.injectFactory(noCamerasFragment, this.multiViewModelFactoryProvider.get());
            return noCamerasFragment;
        }

        private CallHistoryDetails injectCallHistoryDetails(CallHistoryDetails callHistoryDetails) {
            BaseFragment_MembersInjector.injectBaseFactory(callHistoryDetails, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(callHistoryDetails, this.prefManagerProvider.get());
            CallHistoryDetails_MembersInjector.injectAnalytics(callHistoryDetails, this.analyticsProvider.get());
            CallHistoryDetails_MembersInjector.injectLocalizationScreen(callHistoryDetails, this.provideLocalizationStorageProvider.get());
            return callHistoryDetails;
        }

        private SurveyCommentFragment injectSurveyCommentFragment(SurveyCommentFragment surveyCommentFragment) {
            SurveyCommentFragment_MembersInjector.injectFactory(surveyCommentFragment, this.multiViewModelFactoryProvider.get());
            SurveyCommentFragment_MembersInjector.injectLocalizationScreen(surveyCommentFragment, this.provideLocalizationStorageProvider.get());
            return surveyCommentFragment;
        }

        private SurveyFinishFragment injectSurveyFinishFragment(SurveyFinishFragment surveyFinishFragment) {
            SurveyFinishFragment_MembersInjector.injectLocalizationScreen(surveyFinishFragment, this.provideLocalizationStorageProvider.get());
            SurveyFinishFragment_MembersInjector.injectFactory(surveyFinishFragment, this.multiViewModelFactoryProvider.get());
            return surveyFinishFragment;
        }

        private SurveyFragment injectSurveyFragment(SurveyFragment surveyFragment) {
            SurveyFragment_MembersInjector.injectLocalizationScreen(surveyFragment, this.provideLocalizationStorageProvider.get());
            SurveyFragment_MembersInjector.injectFactory(surveyFragment, this.multiViewModelFactoryProvider.get());
            return surveyFragment;
        }

        private AboutAppFragment injectAboutAppFragment(AboutAppFragment aboutAppFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(aboutAppFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(aboutAppFragment, this.prefManagerProvider.get());
            AboutAppFragment_MembersInjector.injectLocalizationScreen(aboutAppFragment, this.provideLocalizationStorageProvider.get());
            return aboutAppFragment;
        }

        private AboutCompanyFragment injectAboutCompanyFragment(AboutCompanyFragment aboutCompanyFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(aboutCompanyFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(aboutCompanyFragment, this.prefManagerProvider.get());
            AboutCompanyFragment_MembersInjector.injectLocalizationScreen(aboutCompanyFragment, this.provideLocalizationStorageProvider.get());
            AboutCompanyFragment_MembersInjector.injectFactory(aboutCompanyFragment, this.multiViewModelFactoryProvider.get());
            AboutCompanyFragment_MembersInjector.injectAnalytics(aboutCompanyFragment, this.analyticsProvider.get());
            return aboutCompanyFragment;
        }

        private HelpFragment injectHelpFragment(HelpFragment helpFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(helpFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(helpFragment, this.prefManagerProvider.get());
            HelpFragment_MembersInjector.injectLocalizationScreen(helpFragment, this.provideLocalizationStorageProvider.get());
            HelpFragment_MembersInjector.injectPrefManager(helpFragment, this.prefManagerProvider.get());
            HelpFragment_MembersInjector.injectSupportManager(helpFragment, supportManager());
            HelpFragment_MembersInjector.injectFactory(helpFragment, this.multiViewModelFactoryProvider.get());
            HelpFragment_MembersInjector.injectAnalytics(helpFragment, this.analyticsProvider.get());
            return helpFragment;
        }

        private ServicesInfoFragment injectServicesInfoFragment(ServicesInfoFragment servicesInfoFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(servicesInfoFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(servicesInfoFragment, this.prefManagerProvider.get());
            ServicesInfoFragment_MembersInjector.injectFactory(servicesInfoFragment, this.multiViewModelFactoryProvider.get());
            ServicesInfoFragment_MembersInjector.injectLocalizationScreen(servicesInfoFragment, this.provideLocalizationStorageProvider.get());
            return servicesInfoFragment;
        }

        private SelectArchiveBottomSheet injectSelectArchiveBottomSheet(SelectArchiveBottomSheet selectArchiveBottomSheet) {
            SelectArchiveBottomSheet_MembersInjector.injectLocalizationScreen(selectArchiveBottomSheet, this.provideLocalizationStorageProvider.get());
            SelectArchiveBottomSheet_MembersInjector.injectFactory(selectArchiveBottomSheet, this.multiViewModelFactoryProvider.get());
            SelectArchiveBottomSheet_MembersInjector.injectCamerasFactory(selectArchiveBottomSheet, this.assistFactoryProvider2.get());
            return selectArchiveBottomSheet;
        }

        private FrErrorFragment injectFrErrorFragment(FrErrorFragment frErrorFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(frErrorFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(frErrorFragment, this.prefManagerProvider.get());
            FrErrorFragment_MembersInjector.injectLocalizationScreen(frErrorFragment, this.provideLocalizationStorageProvider.get());
            return frErrorFragment;
        }

        private FrServiceFragment injectFrServiceFragment(FrServiceFragment frServiceFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(frServiceFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(frServiceFragment, this.prefManagerProvider.get());
            FrServiceFragment_MembersInjector.injectFactory(frServiceFragment, this.multiViewModelFactoryProvider.get());
            FrServiceFragment_MembersInjector.injectSupportManager(frServiceFragment, supportManager());
            FrServiceFragment_MembersInjector.injectLocalizationScreen(frServiceFragment, this.provideLocalizationStorageProvider.get());
            return frServiceFragment;
        }

        private FrStartScanFragment injectFrStartScanFragment(FrStartScanFragment frStartScanFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(frStartScanFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(frStartScanFragment, this.prefManagerProvider.get());
            FrStartScanFragment_MembersInjector.injectLocalizationScreen(frStartScanFragment, this.provideLocalizationStorageProvider.get());
            return frStartScanFragment;
        }

        private FrSuccessFragment injectFrSuccessFragment(FrSuccessFragment frSuccessFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(frSuccessFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(frSuccessFragment, this.prefManagerProvider.get());
            FrSuccessFragment_MembersInjector.injectFactory(frSuccessFragment, this.multiViewModelFactoryProvider.get());
            FrSuccessFragment_MembersInjector.injectLocalizationScreen(frSuccessFragment, this.provideLocalizationStorageProvider.get());
            return frSuccessFragment;
        }

        private ShotFragment injectShotFragment(ShotFragment shotFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(shotFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(shotFragment, this.prefManagerProvider.get());
            ShotFragment_MembersInjector.injectFactory(shotFragment, this.multiViewModelFactoryProvider.get());
            ShotFragment_MembersInjector.injectLocalizationScreen(shotFragment, this.provideLocalizationStorageProvider.get());
            return shotFragment;
        }

        private CancelSubscriptionBottomSheet injectCancelSubscriptionBottomSheet(CancelSubscriptionBottomSheet cancelSubscriptionBottomSheet) {
            CancelSubscriptionBottomSheet_MembersInjector.injectFactory(cancelSubscriptionBottomSheet, this.multiViewModelFactoryProvider.get());
            CancelSubscriptionBottomSheet_MembersInjector.injectLocalizationScreen(cancelSubscriptionBottomSheet, this.provideLocalizationStorageProvider.get());
            return cancelSubscriptionBottomSheet;
        }

        private SubscriptionFragment injectSubscriptionFragment(SubscriptionFragment subscriptionFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(subscriptionFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(subscriptionFragment, this.prefManagerProvider.get());
            SubscriptionFragment_MembersInjector.injectFactory(subscriptionFragment, this.multiViewModelFactoryProvider.get());
            SubscriptionFragment_MembersInjector.injectLocalizationScreen(subscriptionFragment, this.provideLocalizationStorageProvider.get());
            return subscriptionFragment;
        }

        private SettingsProfileFragment injectSettingsProfileFragment(SettingsProfileFragment settingsProfileFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(settingsProfileFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(settingsProfileFragment, this.prefManagerProvider.get());
            SettingsProfileFragment_MembersInjector.injectPrefManager(settingsProfileFragment, this.prefManagerProvider.get());
            SettingsProfileFragment_MembersInjector.injectLocalizationScreen(settingsProfileFragment, this.provideLocalizationStorageProvider.get());
            SettingsProfileFragment_MembersInjector.injectSettingsProfileFactoryBuilder(settingsProfileFragment, this.assistFactoryProvider4.get());
            SettingsProfileFragment_MembersInjector.injectFactory(settingsProfileFragment, this.multiViewModelFactoryProvider.get());
            return settingsProfileFragment;
        }

        private SettingsAddress injectSettingsAddress(SettingsAddress settingsAddress) {
            SettingsAddress_MembersInjector.injectFactory(settingsAddress, this.multiViewModelFactoryProvider.get());
            SettingsAddress_MembersInjector.injectLocalizationScreen(settingsAddress, this.provideLocalizationStorageProvider.get());
            return settingsAddress;
        }

        private ManageCamerasFragment injectManageCamerasFragment(ManageCamerasFragment manageCamerasFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(manageCamerasFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(manageCamerasFragment, this.prefManagerProvider.get());
            ManageCamerasFragment_MembersInjector.injectLocalizationScreen(manageCamerasFragment, this.provideLocalizationStorageProvider.get());
            ManageCamerasFragment_MembersInjector.injectManageCameraViewModelFactory(manageCamerasFragment, this.assistFactoryProvider5.get());
            ManageCamerasFragment_MembersInjector.injectFactory(manageCamerasFragment, this.multiViewModelFactoryProvider.get());
            ManageCamerasFragment_MembersInjector.injectAnalytics(manageCamerasFragment, this.analyticsProvider.get());
            ManageCamerasFragment_MembersInjector.injectCameraViewModelFactory(manageCamerasFragment, this.assistFactoryProvider2.get());
            return manageCamerasFragment;
        }

        private CamerasPreviewFragment injectCamerasPreviewFragment(CamerasPreviewFragment camerasPreviewFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(camerasPreviewFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(camerasPreviewFragment, this.prefManagerProvider.get());
            CamerasPreviewFragment_MembersInjector.injectLocalizationScreen(camerasPreviewFragment, this.provideLocalizationStorageProvider.get());
            CamerasPreviewFragment_MembersInjector.injectManageCameraViewModelFactory(camerasPreviewFragment, this.assistFactoryProvider5.get());
            CamerasPreviewFragment_MembersInjector.injectAnalytics(camerasPreviewFragment, this.analyticsProvider.get());
            CamerasPreviewFragment_MembersInjector.injectFactory(camerasPreviewFragment, this.multiViewModelFactoryProvider.get());
            CamerasPreviewFragment_MembersInjector.injectCameraViewModelFactory(camerasPreviewFragment, this.assistFactoryProvider2.get());
            return camerasPreviewFragment;
        }

        private ManageCamerasDetails injectManageCamerasDetails(ManageCamerasDetails manageCamerasDetails) {
            BaseFragment_MembersInjector.injectBaseFactory(manageCamerasDetails, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(manageCamerasDetails, this.prefManagerProvider.get());
            ManageCamerasDetails_MembersInjector.injectManageCameraViewModelFactory(manageCamerasDetails, this.assistFactoryProvider5.get());
            ManageCamerasDetails_MembersInjector.injectLocalizationScreen(manageCamerasDetails, this.provideLocalizationStorageProvider.get());
            return manageCamerasDetails;
        }

        private LocalizationSplash injectLocalizationSplash(LocalizationSplash localizationSplash) {
            BaseFragment_MembersInjector.injectBaseFactory(localizationSplash, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(localizationSplash, this.prefManagerProvider.get());
            LocalizationSplash_MembersInjector.injectFactory(localizationSplash, this.multiViewModelFactoryProvider.get());
            LocalizationSplash_MembersInjector.injectPrefManager(localizationSplash, this.prefManagerProvider.get());
            LocalizationSplash_MembersInjector.injectLocalizationScreen(localizationSplash, this.provideLocalizationStorageProvider.get());
            return localizationSplash;
        }

        private LocalizationListFragment injectLocalizationListFragment(LocalizationListFragment localizationListFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(localizationListFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(localizationListFragment, this.prefManagerProvider.get());
            LocalizationListFragment_MembersInjector.injectLocalizationScreen(localizationListFragment, this.provideLocalizationStorageProvider.get());
            LocalizationListFragment_MembersInjector.injectFactory(localizationListFragment, this.multiViewModelFactoryProvider.get());
            return localizationListFragment;
        }

        private LocalizationBottomSheet injectLocalizationBottomSheet(LocalizationBottomSheet localizationBottomSheet) {
            LocalizationBottomSheet_MembersInjector.injectLocalizationScreen(localizationBottomSheet, this.provideLocalizationStorageProvider.get());
            LocalizationBottomSheet_MembersInjector.injectFactory(localizationBottomSheet, this.multiViewModelFactoryProvider.get());
            return localizationBottomSheet;
        }

        private IntercomSettingsFragment injectIntercomSettingsFragment(IntercomSettingsFragment intercomSettingsFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(intercomSettingsFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(intercomSettingsFragment, this.prefManagerProvider.get());
            IntercomSettingsFragment_MembersInjector.injectFactory(intercomSettingsFragment, this.multiViewModelFactoryProvider.get());
            IntercomSettingsFragment_MembersInjector.injectManageCameraViewModelFactory(intercomSettingsFragment, this.assistFactoryProvider5.get());
            IntercomSettingsFragment_MembersInjector.injectPrefManager(intercomSettingsFragment, this.prefManagerProvider.get());
            IntercomSettingsFragment_MembersInjector.injectAnalytics(intercomSettingsFragment, this.analyticsProvider.get());
            IntercomSettingsFragment_MembersInjector.injectLocalizationScreen(intercomSettingsFragment, this.provideLocalizationStorageProvider.get());
            return intercomSettingsFragment;
        }

        private FamilyListFragment injectFamilyListFragment(FamilyListFragment familyListFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(familyListFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(familyListFragment, this.prefManagerProvider.get());
            FamilyListFragment_MembersInjector.injectLocalizationScreen(familyListFragment, this.provideLocalizationStorageProvider.get());
            FamilyListFragment_MembersInjector.injectAnalytics(familyListFragment, this.analyticsProvider.get());
            FamilyListFragment_MembersInjector.injectFactory(familyListFragment, this.multiViewModelFactoryProvider.get());
            return familyListFragment;
        }

        private FamilyInfoFragment injectFamilyInfoFragment(FamilyInfoFragment familyInfoFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(familyInfoFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(familyInfoFragment, this.prefManagerProvider.get());
            FamilyInfoFragment_MembersInjector.injectFactory(familyInfoFragment, this.multiViewModelFactoryProvider.get());
            FamilyInfoFragment_MembersInjector.injectLocalizationScreen(familyInfoFragment, this.provideLocalizationStorageProvider.get());
            FamilyInfoFragment_MembersInjector.injectAnalytics(familyInfoFragment, this.analyticsProvider.get());
            return familyInfoFragment;
        }

        private NewCardFragment injectNewCardFragment(NewCardFragment newCardFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(newCardFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(newCardFragment, this.prefManagerProvider.get());
            NewCardFragment_MembersInjector.injectFactory(newCardFragment, this.multiViewModelFactoryProvider.get());
            NewCardFragment_MembersInjector.injectLocalizationScreen(newCardFragment, this.provideLocalizationStorageProvider.get());
            return newCardFragment;
        }

        private CardFragment injectCardFragment(CardFragment cardFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(cardFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(cardFragment, this.prefManagerProvider.get());
            CardFragment_MembersInjector.injectFactory(cardFragment, this.multiViewModelFactoryProvider.get());
            CardFragment_MembersInjector.injectLocalizationScreen(cardFragment, this.provideLocalizationStorageProvider.get());
            return cardFragment;
        }

        private ProfileFragment injectProfileFragment(ProfileFragment profileFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(profileFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(profileFragment, this.prefManagerProvider.get());
            ProfileFragment_MembersInjector.injectLocalizationScreen(profileFragment, this.provideLocalizationStorageProvider.get());
            ProfileFragment_MembersInjector.injectPrefManager(profileFragment, DoubleCheck.lazy(this.prefManagerProvider));
            ProfileFragment_MembersInjector.injectFactory(profileFragment, DoubleCheck.lazy(this.multiViewModelFactoryProvider));
            ProfileFragment_MembersInjector.injectCamerasFactoryBuilder(profileFragment, this.assistFactoryProvider2.get());
            ProfileFragment_MembersInjector.injectAnalytics(profileFragment, this.analyticsProvider.get());
            return profileFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DownloadService injectDownloadService(DownloadService downloadService) {
            DownloadService_MembersInjector.injectLocalizationScreen(downloadService, this.provideLocalizationStorageProvider.get());
            return downloadService;
        }

        private FlussonicActivity injectFlussonicActivity(FlussonicActivity flussonicActivity) {
            BaseFragment_MembersInjector.injectBaseFactory(flussonicActivity, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(flussonicActivity, this.prefManagerProvider.get());
            FlussonicActivity_MembersInjector.injectAnalytics(flussonicActivity, this.analyticsProvider.get());
            FlussonicActivity_MembersInjector.injectLocalizationScreen(flussonicActivity, this.provideLocalizationStorageProvider.get());
            FlussonicActivity_MembersInjector.injectDownloadServiceFactory(flussonicActivity, this.factoryProvider.get());
            FlussonicActivity_MembersInjector.injectFactory(flussonicActivity, this.multiViewModelFactoryProvider.get());
            return flussonicActivity;
        }

        private MainHostNoIntercom injectMainHostNoIntercom(MainHostNoIntercom mainHostNoIntercom) {
            MainHostNoIntercom_MembersInjector.injectLocalizationStorage(mainHostNoIntercom, this.provideLocalizationStorageProvider.get());
            MainHostNoIntercom_MembersInjector.injectFactory(mainHostNoIntercom, this.multiViewModelFactoryProvider.get());
            MainHostNoIntercom_MembersInjector.injectPrefManager(mainHostNoIntercom, this.prefManagerProvider.get());
            MainHostNoIntercom_MembersInjector.injectAnalytics(mainHostNoIntercom, this.analyticsProvider.get());
            MainHostNoIntercom_MembersInjector.injectCamerasViewModelFactory(mainHostNoIntercom, this.assistFactoryProvider2.get());
            return mainHostNoIntercom;
        }

        private DigitalKeysServiceFragment injectDigitalKeysServiceFragment(DigitalKeysServiceFragment digitalKeysServiceFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(digitalKeysServiceFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(digitalKeysServiceFragment, this.prefManagerProvider.get());
            DigitalKeysServiceFragment_MembersInjector.injectAnalytics(digitalKeysServiceFragment, this.analyticsProvider.get());
            DigitalKeysServiceFragment_MembersInjector.injectSupportManager(digitalKeysServiceFragment, supportManager());
            DigitalKeysServiceFragment_MembersInjector.injectFactory(digitalKeysServiceFragment, this.multiViewModelFactoryProvider.get());
            DigitalKeysServiceFragment_MembersInjector.injectLocalizationScreen(digitalKeysServiceFragment, this.provideLocalizationStorageProvider.get());
            return digitalKeysServiceFragment;
        }

        private ArchiveServiceFragment injectArchiveServiceFragment(ArchiveServiceFragment archiveServiceFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(archiveServiceFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(archiveServiceFragment, this.prefManagerProvider.get());
            ArchiveServiceFragment_MembersInjector.injectFactory(archiveServiceFragment, DoubleCheck.lazy(this.multiViewModelFactoryProvider));
            ArchiveServiceFragment_MembersInjector.injectSupportManager(archiveServiceFragment, supportManager());
            ArchiveServiceFragment_MembersInjector.injectLocalizationScreen(archiveServiceFragment, this.provideLocalizationStorageProvider.get());
            return archiveServiceFragment;
        }

        private EmergencyCodeBottomSheet injectEmergencyCodeBottomSheet(EmergencyCodeBottomSheet emergencyCodeBottomSheet) {
            EmergencyCodeBottomSheet_MembersInjector.injectLocalizationScreen(emergencyCodeBottomSheet, this.provideLocalizationStorageProvider.get());
            EmergencyCodeBottomSheet_MembersInjector.injectFactory(emergencyCodeBottomSheet, this.multiViewModelFactoryProvider.get());
            return emergencyCodeBottomSheet;
        }

        private ErrorArchiveDialog injectErrorArchiveDialog(ErrorArchiveDialog errorArchiveDialog) {
            ErrorArchiveDialog_MembersInjector.injectLocalizationScreen(errorArchiveDialog, this.provideLocalizationStorageProvider.get());
            return errorArchiveDialog;
        }

        private RateUsDialog injectRateUsDialog(RateUsDialog rateUsDialog) {
            RateUsDialog_MembersInjector.injectLocalizationScreen(rateUsDialog, this.provideLocalizationStorageProvider.get());
            RateUsDialog_MembersInjector.injectFactory(rateUsDialog, this.multiViewModelFactoryProvider.get());
            return rateUsDialog;
        }

        private DeleteCodeDialog injectDeleteCodeDialog(DeleteCodeDialog deleteCodeDialog) {
            DeleteCodeDialog_MembersInjector.injectFactory(deleteCodeDialog, this.multiViewModelFactoryProvider.get());
            DeleteCodeDialog_MembersInjector.injectLocalizationScreen(deleteCodeDialog, this.provideLocalizationStorageProvider.get());
            return deleteCodeDialog;
        }

        private UpdatePermCodeDialog injectUpdatePermCodeDialog(UpdatePermCodeDialog updatePermCodeDialog) {
            UpdatePermCodeDialog_MembersInjector.injectFactory(updatePermCodeDialog, this.multiViewModelFactoryProvider.get());
            UpdatePermCodeDialog_MembersInjector.injectLocalizationScreen(updatePermCodeDialog, this.provideLocalizationStorageProvider.get());
            return updatePermCodeDialog;
        }

        private UpdateTempCodeDialog injectUpdateTempCodeDialog(UpdateTempCodeDialog updateTempCodeDialog) {
            UpdateTempCodeDialog_MembersInjector.injectFactory(updateTempCodeDialog, this.multiViewModelFactoryProvider.get());
            UpdateTempCodeDialog_MembersInjector.injectLocalizationScreen(updateTempCodeDialog, this.provideLocalizationStorageProvider.get());
            return updateTempCodeDialog;
        }

        private FrRemoveDialog injectFrRemoveDialog(FrRemoveDialog frRemoveDialog) {
            FrRemoveDialog_MembersInjector.injectFactory(frRemoveDialog, this.multiViewModelFactoryProvider.get());
            FrRemoveDialog_MembersInjector.injectLocalizationScreen(frRemoveDialog, this.provideLocalizationStorageProvider.get());
            return frRemoveDialog;
        }

        private PartnerServiceDialog injectPartnerServiceDialog(PartnerServiceDialog partnerServiceDialog) {
            PartnerServiceDialog_MembersInjector.injectLocalizationScreen(partnerServiceDialog, this.provideLocalizationStorageProvider.get());
            return partnerServiceDialog;
        }

        private SuccessSubscriptionDialog injectSuccessSubscriptionDialog(SuccessSubscriptionDialog successSubscriptionDialog) {
            SuccessSubscriptionDialog_MembersInjector.injectFactory(successSubscriptionDialog, this.multiViewModelFactoryProvider.get());
            SuccessSubscriptionDialog_MembersInjector.injectLocalizationScreen(successSubscriptionDialog, this.provideLocalizationStorageProvider.get());
            return successSubscriptionDialog;
        }

        private LogOutDialog injectLogOutDialog(LogOutDialog logOutDialog) {
            LogOutDialog_MembersInjector.injectFactory(logOutDialog, this.multiViewModelFactoryProvider.get());
            LogOutDialog_MembersInjector.injectCameraViewModelBuilder(logOutDialog, this.assistFactoryProvider2.get());
            LogOutDialog_MembersInjector.injectLocalizationScreen(logOutDialog, this.provideLocalizationStorageProvider.get());
            return logOutDialog;
        }

        private DeleteAccountDialog injectDeleteAccountDialog(DeleteAccountDialog deleteAccountDialog) {
            DeleteAccountDialog_MembersInjector.injectFactory(deleteAccountDialog, this.multiViewModelFactoryProvider.get());
            DeleteAccountDialog_MembersInjector.injectLocalizationScreen(deleteAccountDialog, this.provideLocalizationStorageProvider.get());
            return deleteAccountDialog;
        }

        private SettingsActivity injectSettingsActivity(SettingsActivity settingsActivity) {
            SettingsActivity_MembersInjector.injectFactory(settingsActivity, this.multiViewModelFactoryProvider.get());
            return settingsActivity;
        }

        private PushSettingsActivity injectPushSettingsActivity(PushSettingsActivity pushSettingsActivity) {
            PushSettingsActivity_MembersInjector.injectFactory(pushSettingsActivity, this.multiViewModelFactoryProvider.get());
            return pushSettingsActivity;
        }

        private BleSettingsActivity injectBleSettingsActivity(BleSettingsActivity bleSettingsActivity) {
            BleSettingsActivity_MembersInjector.injectFactory(bleSettingsActivity, this.multiViewModelFactoryProvider.get());
            return bleSettingsActivity;
        }

        private BeaconTrackingService injectBeaconTrackingService(BeaconTrackingService beaconTrackingService) {
            BeaconTrackingService_MembersInjector.injectCamerasRepository(beaconTrackingService, camerasRepository());
            BeaconTrackingService_MembersInjector.injectPrefs(beaconTrackingService, this.prefManagerProvider.get());
            BeaconTrackingService_MembersInjector.injectAnalytics(beaconTrackingService, this.analyticsProvider.get());
            BeaconTrackingService_MembersInjector.injectLocalizationStorage(beaconTrackingService, this.provideLocalizationStorageProvider.get());
            return beaconTrackingService;
        }

        private NewMarketFragment injectNewMarketFragment(NewMarketFragment newMarketFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(newMarketFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(newMarketFragment, this.prefManagerProvider.get());
            NewMarketFragment_MembersInjector.injectFactory(newMarketFragment, this.multiViewModelFactoryProvider.get());
            NewMarketFragment_MembersInjector.injectLocalizationScreen(newMarketFragment, this.provideLocalizationStorageProvider.get());
            NewMarketFragment_MembersInjector.injectAnalytics(newMarketFragment, this.analyticsProvider.get());
            NewMarketFragment_MembersInjector.injectPrefManager(newMarketFragment, this.prefManagerProvider.get());
            NewMarketFragment_MembersInjector.injectSupportManager(newMarketFragment, supportManager());
            return newMarketFragment;
        }

        private SubscriptionDetailsFragment injectSubscriptionDetailsFragment(SubscriptionDetailsFragment subscriptionDetailsFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(subscriptionDetailsFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(subscriptionDetailsFragment, this.prefManagerProvider.get());
            SubscriptionDetailsFragment_MembersInjector.injectFactory(subscriptionDetailsFragment, this.multiViewModelFactoryProvider.get());
            SubscriptionDetailsFragment_MembersInjector.injectLocalizationScreen(subscriptionDetailsFragment, this.provideLocalizationStorageProvider.get());
            SubscriptionDetailsFragment_MembersInjector.injectAnalytics(subscriptionDetailsFragment, this.analyticsProvider.get());
            return subscriptionDetailsFragment;
        }

        private BottomSheetAboutSubscription injectBottomSheetAboutSubscription(BottomSheetAboutSubscription bottomSheetAboutSubscription) {
            BottomSheetAboutSubscription_MembersInjector.injectLocalizationStorage(bottomSheetAboutSubscription, this.provideLocalizationStorageProvider.get());
            BottomSheetAboutSubscription_MembersInjector.injectFactory(bottomSheetAboutSubscription, this.multiViewModelFactoryProvider.get());
            BottomSheetAboutSubscription_MembersInjector.injectAnalytics(bottomSheetAboutSubscription, this.analyticsProvider.get());
            BottomSheetAboutSubscription_MembersInjector.injectLocalizationScreen(bottomSheetAboutSubscription, this.provideLocalizationStorageProvider.get());
            return bottomSheetAboutSubscription;
        }

        private BottomSheetUpdateRequired injectBottomSheetUpdateRequired(BottomSheetUpdateRequired bottomSheetUpdateRequired) {
            BottomSheetUpdateRequired_MembersInjector.injectLocalizationStorage(bottomSheetUpdateRequired, this.provideLocalizationStorageProvider.get());
            BottomSheetUpdateRequired_MembersInjector.injectFactory(bottomSheetUpdateRequired, this.multiViewModelFactoryProvider.get());
            BottomSheetUpdateRequired_MembersInjector.injectAnalytics(bottomSheetUpdateRequired, this.analyticsProvider.get());
            return bottomSheetUpdateRequired;
        }

        private FragmentUpdateRequired injectFragmentUpdateRequired(FragmentUpdateRequired fragmentUpdateRequired) {
            BaseFragment_MembersInjector.injectBaseFactory(fragmentUpdateRequired, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(fragmentUpdateRequired, this.prefManagerProvider.get());
            FragmentUpdateRequired_MembersInjector.injectLocalizationScreen(fragmentUpdateRequired, this.provideLocalizationStorageProvider.get());
            FragmentUpdateRequired_MembersInjector.injectFactory(fragmentUpdateRequired, this.multiViewModelFactoryProvider.get());
            return fragmentUpdateRequired;
        }

        private BottomSheetAboutCallHistory injectBottomSheetAboutCallHistory(BottomSheetAboutCallHistory bottomSheetAboutCallHistory) {
            BottomSheetAboutCallHistory_MembersInjector.injectLocalizationStorage(bottomSheetAboutCallHistory, this.provideLocalizationStorageProvider.get());
            BottomSheetAboutCallHistory_MembersInjector.injectFactory(bottomSheetAboutCallHistory, this.multiViewModelFactoryProvider.get());
            BottomSheetAboutCallHistory_MembersInjector.injectAnalytics(bottomSheetAboutCallHistory, this.analyticsProvider.get());
            BottomSheetAboutCallHistory_MembersInjector.injectLocalizationScreen(bottomSheetAboutCallHistory, this.provideLocalizationStorageProvider.get());
            return bottomSheetAboutCallHistory;
        }

        private BottomSheetNoArchive injectBottomSheetNoArchive(BottomSheetNoArchive bottomSheetNoArchive) {
            BottomSheetNoArchive_MembersInjector.injectLocalizationStorage(bottomSheetNoArchive, this.provideLocalizationStorageProvider.get());
            BottomSheetNoArchive_MembersInjector.injectFactory(bottomSheetNoArchive, this.multiViewModelFactoryProvider.get());
            BottomSheetNoArchive_MembersInjector.injectAnalytics(bottomSheetNoArchive, this.analyticsProvider.get());
            BottomSheetNoArchive_MembersInjector.injectLocalizationScreen(bottomSheetNoArchive, this.provideLocalizationStorageProvider.get());
            return bottomSheetNoArchive;
        }

        private SendInstallSputnikRequestFragment injectSendInstallSputnikRequestFragment(SendInstallSputnikRequestFragment sendInstallSputnikRequestFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(sendInstallSputnikRequestFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(sendInstallSputnikRequestFragment, this.prefManagerProvider.get());
            SendInstallSputnikRequestFragment_MembersInjector.injectFactory(sendInstallSputnikRequestFragment, this.multiViewModelFactoryProvider.get());
            SendInstallSputnikRequestFragment_MembersInjector.injectLocalizationScreen(sendInstallSputnikRequestFragment, this.provideLocalizationStorageProvider.get());
            SendInstallSputnikRequestFragment_MembersInjector.injectPrefManager(sendInstallSputnikRequestFragment, this.prefManagerProvider.get());
            return sendInstallSputnikRequestFragment;
        }

        private OurHomeUpdateFragment injectOurHomeUpdateFragment(OurHomeUpdateFragment ourHomeUpdateFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(ourHomeUpdateFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(ourHomeUpdateFragment, this.prefManagerProvider.get());
            OurHomeUpdateFragment_MembersInjector.injectFactory(ourHomeUpdateFragment, this.multiViewModelFactoryProvider.get());
            OurHomeUpdateFragment_MembersInjector.injectLocalizationScreen(ourHomeUpdateFragment, this.provideLocalizationStorageProvider.get());
            OurHomeUpdateFragment_MembersInjector.injectAnalytics(ourHomeUpdateFragment, this.analyticsProvider.get());
            OurHomeUpdateFragment_MembersInjector.injectPrefManager(ourHomeUpdateFragment, this.prefManagerProvider.get());
            return ourHomeUpdateFragment;
        }

        private AboutOurHomeDialog injectAboutOurHomeDialog(AboutOurHomeDialog aboutOurHomeDialog) {
            AboutOurHomeDialog_MembersInjector.injectLocalizationStorage(aboutOurHomeDialog, this.provideLocalizationStorageProvider.get());
            AboutOurHomeDialog_MembersInjector.injectFactory(aboutOurHomeDialog, this.multiViewModelFactoryProvider.get());
            AboutOurHomeDialog_MembersInjector.injectAnalytics(aboutOurHomeDialog, this.analyticsProvider.get());
            return aboutOurHomeDialog;
        }

        private BottomSheetRatePoll injectBottomSheetRatePoll(BottomSheetRatePoll bottomSheetRatePoll) {
            BottomSheetRatePoll_MembersInjector.injectLocalizationStorage(bottomSheetRatePoll, this.provideLocalizationStorageProvider.get());
            BottomSheetRatePoll_MembersInjector.injectFactory(bottomSheetRatePoll, this.multiViewModelFactoryProvider.get());
            BottomSheetRatePoll_MembersInjector.injectAnalytics(bottomSheetRatePoll, this.analyticsProvider.get());
            BottomSheetRatePoll_MembersInjector.injectLocalizationScreen(bottomSheetRatePoll, this.provideLocalizationStorageProvider.get());
            return bottomSheetRatePoll;
        }

        private BottomSheetPollSuccess injectBottomSheetPollSuccess(BottomSheetPollSuccess bottomSheetPollSuccess) {
            BottomSheetPollSuccess_MembersInjector.injectLocalizationStorage(bottomSheetPollSuccess, this.provideLocalizationStorageProvider.get());
            BottomSheetPollSuccess_MembersInjector.injectFactory(bottomSheetPollSuccess, this.multiViewModelFactoryProvider.get());
            BottomSheetPollSuccess_MembersInjector.injectAnalytics(bottomSheetPollSuccess, this.analyticsProvider.get());
            return bottomSheetPollSuccess;
        }

        private PushProcessorImpl injectPushProcessorImpl(PushProcessorImpl pushProcessorImpl) {
            PushProcessorImpl_MembersInjector.injectLocalizationScreen(pushProcessorImpl, this.provideLocalizationStorageProvider.get());
            return pushProcessorImpl;
        }

        private ExperimentalFunctionsFragment injectExperimentalFunctionsFragment(ExperimentalFunctionsFragment experimentalFunctionsFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(experimentalFunctionsFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(experimentalFunctionsFragment, this.prefManagerProvider.get());
            ExperimentalFunctionsFragment_MembersInjector.injectFactory(experimentalFunctionsFragment, this.multiViewModelFactoryProvider.get());
            ExperimentalFunctionsFragment_MembersInjector.injectLocalizationScreen(experimentalFunctionsFragment, this.provideLocalizationStorageProvider.get());
            ExperimentalFunctionsFragment_MembersInjector.injectPrefManager(experimentalFunctionsFragment, this.prefManagerProvider.get());
            return experimentalFunctionsFragment;
        }

        private InfoDialog injectInfoDialog(InfoDialog infoDialog) {
            InfoDialog_MembersInjector.injectLocalizationScreen(infoDialog, this.provideLocalizationStorageProvider.get());
            InfoDialog_MembersInjector.injectFactory(infoDialog, this.multiViewModelFactoryProvider.get());
            InfoDialog_MembersInjector.injectCameraViewModelFactory(infoDialog, this.assistFactoryProvider2.get());
            return infoDialog;
        }

        private BottomSheetAboutBetaProgram injectBottomSheetAboutBetaProgram(BottomSheetAboutBetaProgram bottomSheetAboutBetaProgram) {
            BottomSheetAboutBetaProgram_MembersInjector.injectLocalizationStorage(bottomSheetAboutBetaProgram, this.provideLocalizationStorageProvider.get());
            BottomSheetAboutBetaProgram_MembersInjector.injectFactory(bottomSheetAboutBetaProgram, this.multiViewModelFactoryProvider.get());
            BottomSheetAboutBetaProgram_MembersInjector.injectAnalytics(bottomSheetAboutBetaProgram, this.analyticsProvider.get());
            return bottomSheetAboutBetaProgram;
        }

        private NotificationsFragment injectNotificationsFragment(NotificationsFragment notificationsFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(notificationsFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(notificationsFragment, this.prefManagerProvider.get());
            NotificationsFragment_MembersInjector.injectAnalytics(notificationsFragment, this.analyticsProvider.get());
            NotificationsFragment_MembersInjector.injectPrefManager(notificationsFragment, this.prefManagerProvider.get());
            NotificationsFragment_MembersInjector.injectLocalizationScreen(notificationsFragment, this.provideLocalizationStorageProvider.get());
            NotificationsFragment_MembersInjector.injectSettingsProfileFactoryBuilder(notificationsFragment, this.assistFactoryProvider4.get());
            NotificationsFragment_MembersInjector.injectFactory(notificationsFragment, this.multiViewModelFactoryProvider.get());
            return notificationsFragment;
        }

        private NotificationsDetailsFragment injectNotificationsDetailsFragment(NotificationsDetailsFragment notificationsDetailsFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(notificationsDetailsFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(notificationsDetailsFragment, this.prefManagerProvider.get());
            NotificationsDetailsFragment_MembersInjector.injectAnalytics(notificationsDetailsFragment, this.analyticsProvider.get());
            NotificationsDetailsFragment_MembersInjector.injectPrefManager(notificationsDetailsFragment, this.prefManagerProvider.get());
            NotificationsDetailsFragment_MembersInjector.injectLocalizationScreen(notificationsDetailsFragment, this.provideLocalizationStorageProvider.get());
            NotificationsDetailsFragment_MembersInjector.injectSettingsProfileFactoryBuilder(notificationsDetailsFragment, this.assistFactoryProvider4.get());
            NotificationsDetailsFragment_MembersInjector.injectFactory(notificationsDetailsFragment, this.multiViewModelFactoryProvider.get());
            return notificationsDetailsFragment;
        }

        private FaqFragment injectFaqFragment(FaqFragment faqFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(faqFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(faqFragment, this.prefManagerProvider.get());
            FaqFragment_MembersInjector.injectPrefManager(faqFragment, this.prefManagerProvider.get());
            FaqFragment_MembersInjector.injectAnalytics(faqFragment, this.analyticsProvider.get());
            FaqFragment_MembersInjector.injectLocalizationScreen(faqFragment, this.provideLocalizationStorageProvider.get());
            FaqFragment_MembersInjector.injectFactory(faqFragment, this.multiViewModelFactoryProvider.get());
            FaqFragment_MembersInjector.injectSupportManager(faqFragment, supportManager());
            return faqFragment;
        }

        private FaqCategoriesFragment injectFaqCategoriesFragment(FaqCategoriesFragment faqCategoriesFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(faqCategoriesFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(faqCategoriesFragment, this.prefManagerProvider.get());
            FaqCategoriesFragment_MembersInjector.injectPrefManager(faqCategoriesFragment, this.prefManagerProvider.get());
            FaqCategoriesFragment_MembersInjector.injectAnalytics(faqCategoriesFragment, this.analyticsProvider.get());
            FaqCategoriesFragment_MembersInjector.injectLocalizationScreen(faqCategoriesFragment, this.provideLocalizationStorageProvider.get());
            FaqCategoriesFragment_MembersInjector.injectFactory(faqCategoriesFragment, this.multiViewModelFactoryProvider.get());
            FaqCategoriesFragment_MembersInjector.injectSupportManager(faqCategoriesFragment, supportManager());
            return faqCategoriesFragment;
        }

        private FaqSubcategoriesFragment injectFaqSubcategoriesFragment(FaqSubcategoriesFragment faqSubcategoriesFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(faqSubcategoriesFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(faqSubcategoriesFragment, this.prefManagerProvider.get());
            FaqSubcategoriesFragment_MembersInjector.injectPrefManager(faqSubcategoriesFragment, this.prefManagerProvider.get());
            FaqSubcategoriesFragment_MembersInjector.injectAnalytics(faqSubcategoriesFragment, this.analyticsProvider.get());
            FaqSubcategoriesFragment_MembersInjector.injectFactory(faqSubcategoriesFragment, this.multiViewModelFactoryProvider.get());
            FaqSubcategoriesFragment_MembersInjector.injectSupportManager(faqSubcategoriesFragment, supportManager());
            return faqSubcategoriesFragment;
        }

        private AboutVpnDialog injectAboutVpnDialog(AboutVpnDialog aboutVpnDialog) {
            AboutVpnDialog_MembersInjector.injectLocalizationStorage(aboutVpnDialog, this.provideLocalizationStorageProvider.get());
            AboutVpnDialog_MembersInjector.injectFactory(aboutVpnDialog, this.multiViewModelFactoryProvider.get());
            AboutVpnDialog_MembersInjector.injectAnalytics(aboutVpnDialog, this.analyticsProvider.get());
            return aboutVpnDialog;
        }

        private SelectGorservCategoryFragment injectSelectGorservCategoryFragment(SelectGorservCategoryFragment selectGorservCategoryFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(selectGorservCategoryFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(selectGorservCategoryFragment, this.prefManagerProvider.get());
            SelectGorservCategoryFragment_MembersInjector.injectPrefManager(selectGorservCategoryFragment, this.prefManagerProvider.get());
            SelectGorservCategoryFragment_MembersInjector.injectAnalytics(selectGorservCategoryFragment, this.analyticsProvider.get());
            SelectGorservCategoryFragment_MembersInjector.injectLocalizationScreen(selectGorservCategoryFragment, this.provideLocalizationStorageProvider.get());
            SelectGorservCategoryFragment_MembersInjector.injectFactory(selectGorservCategoryFragment, this.multiViewModelFactoryProvider.get());
            return selectGorservCategoryFragment;
        }

        private SendGorservRequestFragment injectSendGorservRequestFragment(SendGorservRequestFragment sendGorservRequestFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(sendGorservRequestFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(sendGorservRequestFragment, this.prefManagerProvider.get());
            SendGorservRequestFragment_MembersInjector.injectPrefManager(sendGorservRequestFragment, this.prefManagerProvider.get());
            SendGorservRequestFragment_MembersInjector.injectAnalytics(sendGorservRequestFragment, this.analyticsProvider.get());
            SendGorservRequestFragment_MembersInjector.injectLocalizationScreen(sendGorservRequestFragment, this.provideLocalizationStorageProvider.get());
            SendGorservRequestFragment_MembersInjector.injectFactory(sendGorservRequestFragment, this.multiViewModelFactoryProvider.get());
            return sendGorservRequestFragment;
        }

        private BottomSheetGorservRequestSent injectBottomSheetGorservRequestSent(BottomSheetGorservRequestSent bottomSheetGorservRequestSent) {
            BottomSheetGorservRequestSent_MembersInjector.injectLocalizationStorage(bottomSheetGorservRequestSent, this.provideLocalizationStorageProvider.get());
            BottomSheetGorservRequestSent_MembersInjector.injectFactory(bottomSheetGorservRequestSent, this.multiViewModelFactoryProvider.get());
            BottomSheetGorservRequestSent_MembersInjector.injectAnalytics(bottomSheetGorservRequestSent, this.analyticsProvider.get());
            return bottomSheetGorservRequestSent;
        }

        private ChangeGorservUserPhoneDialog injectChangeGorservUserPhoneDialog(ChangeGorservUserPhoneDialog changeGorservUserPhoneDialog) {
            ChangeGorservUserPhoneDialog_MembersInjector.injectLocalizationStorage(changeGorservUserPhoneDialog, this.provideLocalizationStorageProvider.get());
            ChangeGorservUserPhoneDialog_MembersInjector.injectFactory(changeGorservUserPhoneDialog, this.multiViewModelFactoryProvider.get());
            ChangeGorservUserPhoneDialog_MembersInjector.injectAnalytics(changeGorservUserPhoneDialog, this.analyticsProvider.get());
            return changeGorservUserPhoneDialog;
        }

        private GorservErrorDialog injectGorservErrorDialog(GorservErrorDialog gorservErrorDialog) {
            GorservErrorDialog_MembersInjector.injectLocalizationStorage(gorservErrorDialog, this.provideLocalizationStorageProvider.get());
            GorservErrorDialog_MembersInjector.injectFactory(gorservErrorDialog, this.multiViewModelFactoryProvider.get());
            GorservErrorDialog_MembersInjector.injectAnalytics(gorservErrorDialog, this.analyticsProvider.get());
            return gorservErrorDialog;
        }

        private MobilePackFragment injectMobilePackFragment(MobilePackFragment mobilePackFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(mobilePackFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(mobilePackFragment, this.prefManagerProvider.get());
            MobilePackFragment_MembersInjector.injectPrefManager(mobilePackFragment, this.prefManagerProvider.get());
            MobilePackFragment_MembersInjector.injectAnalytics(mobilePackFragment, this.analyticsProvider.get());
            MobilePackFragment_MembersInjector.injectLocalizationScreen(mobilePackFragment, this.provideLocalizationStorageProvider.get());
            MobilePackFragment_MembersInjector.injectFactory(mobilePackFragment, this.multiViewModelFactoryProvider.get());
            return mobilePackFragment;
        }

        private ResendFamilyInviteDialog injectResendFamilyInviteDialog(ResendFamilyInviteDialog resendFamilyInviteDialog) {
            ResendFamilyInviteDialog_MembersInjector.injectLocalizationStorage(resendFamilyInviteDialog, this.provideLocalizationStorageProvider.get());
            ResendFamilyInviteDialog_MembersInjector.injectFactory(resendFamilyInviteDialog, this.multiViewModelFactoryProvider.get());
            ResendFamilyInviteDialog_MembersInjector.injectAnalytics(resendFamilyInviteDialog, this.analyticsProvider.get());
            return resendFamilyInviteDialog;
        }

        private BottomSheetInviteToFamily injectBottomSheetInviteToFamily(BottomSheetInviteToFamily bottomSheetInviteToFamily) {
            BottomSheetInviteToFamily_MembersInjector.injectLocalizationStorage(bottomSheetInviteToFamily, this.provideLocalizationStorageProvider.get());
            BottomSheetInviteToFamily_MembersInjector.injectFactory(bottomSheetInviteToFamily, this.multiViewModelFactoryProvider.get());
            BottomSheetInviteToFamily_MembersInjector.injectAnalytics(bottomSheetInviteToFamily, this.analyticsProvider.get());
            return bottomSheetInviteToFamily;
        }

        private SendFamilyInviteErrorDialog injectSendFamilyInviteErrorDialog(SendFamilyInviteErrorDialog sendFamilyInviteErrorDialog) {
            SendFamilyInviteErrorDialog_MembersInjector.injectLocalizationScreen(sendFamilyInviteErrorDialog, this.provideLocalizationStorageProvider.get());
            SendFamilyInviteErrorDialog_MembersInjector.injectAnalytics(sendFamilyInviteErrorDialog, this.analyticsProvider.get());
            return sendFamilyInviteErrorDialog;
        }

        private RemoveFromFamilyDialog injectRemoveFromFamilyDialog(RemoveFromFamilyDialog removeFromFamilyDialog) {
            RemoveFromFamilyDialog_MembersInjector.injectLocalizationStorage(removeFromFamilyDialog, this.provideLocalizationStorageProvider.get());
            RemoveFromFamilyDialog_MembersInjector.injectFactory(removeFromFamilyDialog, this.multiViewModelFactoryProvider.get());
            RemoveFromFamilyDialog_MembersInjector.injectAnalytics(removeFromFamilyDialog, this.analyticsProvider.get());
            return removeFromFamilyDialog;
        }

        private LeaveFromFamilyDialog injectLeaveFromFamilyDialog(LeaveFromFamilyDialog leaveFromFamilyDialog) {
            LeaveFromFamilyDialog_MembersInjector.injectLocalizationStorage(leaveFromFamilyDialog, this.provideLocalizationStorageProvider.get());
            LeaveFromFamilyDialog_MembersInjector.injectFactory(leaveFromFamilyDialog, this.multiViewModelFactoryProvider.get());
            LeaveFromFamilyDialog_MembersInjector.injectCameraViewModelFactory(leaveFromFamilyDialog, this.assistFactoryProvider2.get());
            LeaveFromFamilyDialog_MembersInjector.injectAnalytics(leaveFromFamilyDialog, this.analyticsProvider.get());
            return leaveFromFamilyDialog;
        }

        private BleServiceFragment injectBleServiceFragment(BleServiceFragment bleServiceFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(bleServiceFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(bleServiceFragment, this.prefManagerProvider.get());
            BleServiceFragment_MembersInjector.injectFactory(bleServiceFragment, DoubleCheck.lazy(this.multiViewModelFactoryProvider));
            BleServiceFragment_MembersInjector.injectLocalizationScreen(bleServiceFragment, this.provideLocalizationStorageProvider.get());
            BleServiceFragment_MembersInjector.injectAnalytics(bleServiceFragment, this.analyticsProvider.get());
            return bleServiceFragment;
        }

        private NoPermissionsDialog injectNoPermissionsDialog(NoPermissionsDialog noPermissionsDialog) {
            NoPermissionsDialog_MembersInjector.injectLocalizationScreen(noPermissionsDialog, this.provideLocalizationStorageProvider.get());
            return noPermissionsDialog;
        }

        private PermissionsFragment injectPermissionsFragment(PermissionsFragment permissionsFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(permissionsFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(permissionsFragment, this.prefManagerProvider.get());
            PermissionsFragment_MembersInjector.injectFactory(permissionsFragment, DoubleCheck.lazy(this.multiViewModelFactoryProvider));
            PermissionsFragment_MembersInjector.injectLocalizationScreen(permissionsFragment, this.provideLocalizationStorageProvider.get());
            PermissionsFragment_MembersInjector.injectAnalytics(permissionsFragment, this.analyticsProvider.get());
            return permissionsFragment;
        }

        private BottomSheetPermissionExplaining injectBottomSheetPermissionExplaining(BottomSheetPermissionExplaining bottomSheetPermissionExplaining) {
            BottomSheetPermissionExplaining_MembersInjector.injectLocalizationStorage(bottomSheetPermissionExplaining, this.provideLocalizationStorageProvider.get());
            BottomSheetPermissionExplaining_MembersInjector.injectFactory(bottomSheetPermissionExplaining, this.multiViewModelFactoryProvider.get());
            BottomSheetPermissionExplaining_MembersInjector.injectAnalytics(bottomSheetPermissionExplaining, this.analyticsProvider.get());
            return bottomSheetPermissionExplaining;
        }

        private BottomSheetSetupRssi injectBottomSheetSetupRssi(BottomSheetSetupRssi bottomSheetSetupRssi) {
            BottomSheetSetupRssi_MembersInjector.injectLocalizationStorage(bottomSheetSetupRssi, this.provideLocalizationStorageProvider.get());
            BottomSheetSetupRssi_MembersInjector.injectFactory(bottomSheetSetupRssi, this.multiViewModelFactoryProvider.get());
            BottomSheetSetupRssi_MembersInjector.injectAnalytics(bottomSheetSetupRssi, this.analyticsProvider.get());
            return bottomSheetSetupRssi;
        }

        private BottomSheetNoBlePermissions injectBottomSheetNoBlePermissions(BottomSheetNoBlePermissions bottomSheetNoBlePermissions) {
            BottomSheetNoBlePermissions_MembersInjector.injectLocalizationStorage(bottomSheetNoBlePermissions, this.provideLocalizationStorageProvider.get());
            BottomSheetNoBlePermissions_MembersInjector.injectFactory(bottomSheetNoBlePermissions, this.multiViewModelFactoryProvider.get());
            BottomSheetNoBlePermissions_MembersInjector.injectAnalytics(bottomSheetNoBlePermissions, this.analyticsProvider.get());
            return bottomSheetNoBlePermissions;
        }

        private RebootBroadcastReceiver injectRebootBroadcastReceiver(RebootBroadcastReceiver rebootBroadcastReceiver) {
            RebootBroadcastReceiver_MembersInjector.injectPreferences(rebootBroadcastReceiver, this.prefManagerProvider.get());
            return rebootBroadcastReceiver;
        }

        private BeaconServiceManager injectBeaconServiceManager(BeaconServiceManager beaconServiceManager) {
            BeaconServiceManager_MembersInjector.injectPrefManager(beaconServiceManager, this.prefManagerProvider.get());
            BeaconServiceManager_MembersInjector.injectLocalizationStorage(beaconServiceManager, this.provideLocalizationStorageProvider.get());
            return beaconServiceManager;
        }

        private WebRtcPlayerImplNew injectWebRtcPlayerImplNew(WebRtcPlayerImplNew webRtcPlayerImplNew) {
            WebRtcPlayerImplNew_MembersInjector.injectOkHttpClient(webRtcPlayerImplNew, this.provideOkHttpProvider.get());
            return webRtcPlayerImplNew;
        }

        private WebRtcPlayerImpl injectWebRtcPlayerImpl(WebRtcPlayerImpl webRtcPlayerImpl) {
            WebRtcPlayerImpl_MembersInjector.injectOkHttpClient(webRtcPlayerImpl, this.provideOkHttpProvider.get());
            return webRtcPlayerImpl;
        }

        private PopupStoriesFragment injectPopupStoriesFragment(PopupStoriesFragment popupStoriesFragment) {
            PopupStoriesFragment_MembersInjector.injectLocalizationStorage(popupStoriesFragment, this.provideLocalizationStorageProvider.get());
            PopupStoriesFragment_MembersInjector.injectFactory(popupStoriesFragment, this.multiViewModelFactoryProvider.get());
            PopupStoriesFragment_MembersInjector.injectPrefManager(popupStoriesFragment, this.prefManagerProvider.get());
            PopupStoriesFragment_MembersInjector.injectAnalytics(popupStoriesFragment, this.analyticsProvider.get());
            return popupStoriesFragment;
        }

        private PopupStoryFragment injectPopupStoryFragment(PopupStoryFragment popupStoryFragment) {
            PopupStoryFragment_MembersInjector.injectFactory(popupStoryFragment, this.multiViewModelFactoryProvider.get());
            PopupStoryFragment_MembersInjector.injectAnalytics(popupStoryFragment, this.analyticsProvider.get());
            PopupStoryFragment_MembersInjector.injectPrefManager(popupStoryFragment, this.prefManagerProvider.get());
            return popupStoryFragment;
        }

        private BottomSheetBackgroundWork injectBottomSheetBackgroundWork(BottomSheetBackgroundWork bottomSheetBackgroundWork) {
            BottomSheetBackgroundWork_MembersInjector.injectLocalizationStorage(bottomSheetBackgroundWork, this.provideLocalizationStorageProvider.get());
            BottomSheetBackgroundWork_MembersInjector.injectFactory(bottomSheetBackgroundWork, this.multiViewModelFactoryProvider.get());
            BottomSheetBackgroundWork_MembersInjector.injectAnalytics(bottomSheetBackgroundWork, this.analyticsProvider.get());
            return bottomSheetBackgroundWork;
        }

        private BackgroundWorkFragment injectBackgroundWorkFragment(BackgroundWorkFragment backgroundWorkFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(backgroundWorkFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(backgroundWorkFragment, this.prefManagerProvider.get());
            BackgroundWorkFragment_MembersInjector.injectLocalizationStorage(backgroundWorkFragment, this.provideLocalizationStorageProvider.get());
            BackgroundWorkFragment_MembersInjector.injectFactory(backgroundWorkFragment, this.multiViewModelFactoryProvider.get());
            BackgroundWorkFragment_MembersInjector.injectAnalytics(backgroundWorkFragment, this.analyticsProvider.get());
            return backgroundWorkFragment;
        }

        private InstructionFragment injectInstructionFragment(InstructionFragment instructionFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(instructionFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(instructionFragment, this.prefManagerProvider.get());
            InstructionFragment_MembersInjector.injectFactory(instructionFragment, DoubleCheck.lazy(this.multiViewModelFactoryProvider));
            InstructionFragment_MembersInjector.injectLocalizationScreen(instructionFragment, this.provideLocalizationStorageProvider.get());
            InstructionFragment_MembersInjector.injectAnalytics(instructionFragment, this.analyticsProvider.get());
            return instructionFragment;
        }

        private KeysFragment injectKeysFragment(KeysFragment keysFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(keysFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(keysFragment, this.prefManagerProvider.get());
            KeysFragment_MembersInjector.injectLocalization(keysFragment, this.provideLocalizationStorageProvider.get());
            KeysFragment_MembersInjector.injectAnalytics(keysFragment, this.analyticsProvider.get());
            KeysFragment_MembersInjector.injectFactory(keysFragment, this.multiViewModelFactoryProvider.get());
            return keysFragment;
        }

        private KeyManageFragment injectKeyManageFragment(KeyManageFragment keyManageFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(keyManageFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(keyManageFragment, this.prefManagerProvider.get());
            KeyManageFragment_MembersInjector.injectLocalization(keyManageFragment, this.provideLocalizationStorageProvider.get());
            KeyManageFragment_MembersInjector.injectAnalytics(keyManageFragment, this.analyticsProvider.get());
            KeyManageFragment_MembersInjector.injectFactory(keyManageFragment, this.multiViewModelFactoryProvider.get());
            return keyManageFragment;
        }

        private KeyRegisterFragment injectKeyRegisterFragment(KeyRegisterFragment keyRegisterFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(keyRegisterFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(keyRegisterFragment, this.prefManagerProvider.get());
            KeyRegisterFragment_MembersInjector.injectLocalizationScreen(keyRegisterFragment, this.provideLocalizationStorageProvider.get());
            KeyRegisterFragment_MembersInjector.injectAnalytics(keyRegisterFragment, this.analyticsProvider.get());
            KeyRegisterFragment_MembersInjector.injectFactory(keyRegisterFragment, this.multiViewModelFactoryProvider.get());
            return keyRegisterFragment;
        }

        private BottomSheetKeyAddError injectBottomSheetKeyAddError(BottomSheetKeyAddError bottomSheetKeyAddError) {
            BottomSheetKeyAddError_MembersInjector.injectLocalizationStorage(bottomSheetKeyAddError, this.provideLocalizationStorageProvider.get());
            BottomSheetKeyAddError_MembersInjector.injectFactory(bottomSheetKeyAddError, this.multiViewModelFactoryProvider.get());
            BottomSheetKeyAddError_MembersInjector.injectAnalytics(bottomSheetKeyAddError, this.analyticsProvider.get());
            return bottomSheetKeyAddError;
        }

        private DeleteKeyDialog injectDeleteKeyDialog(DeleteKeyDialog deleteKeyDialog) {
            DeleteKeyDialog_MembersInjector.injectLocalizationStorage(deleteKeyDialog, this.provideLocalizationStorageProvider.get());
            DeleteKeyDialog_MembersInjector.injectFactory(deleteKeyDialog, this.multiViewModelFactoryProvider.get());
            DeleteKeyDialog_MembersInjector.injectAnalytics(deleteKeyDialog, this.analyticsProvider.get());
            return deleteKeyDialog;
        }

        private ItemDetailsFragment injectItemDetailsFragment(ItemDetailsFragment itemDetailsFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(itemDetailsFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(itemDetailsFragment, this.prefManagerProvider.get());
            ItemDetailsFragment_MembersInjector.injectFactory(itemDetailsFragment, this.multiViewModelFactoryProvider.get());
            ItemDetailsFragment_MembersInjector.injectLocalizationScreen(itemDetailsFragment, this.provideLocalizationStorageProvider.get());
            ItemDetailsFragment_MembersInjector.injectAnalytics(itemDetailsFragment, this.analyticsProvider.get());
            return itemDetailsFragment;
        }

        private BottomSheetNeedSubscriptionToAddKey injectBottomSheetNeedSubscriptionToAddKey(BottomSheetNeedSubscriptionToAddKey bottomSheetNeedSubscriptionToAddKey) {
            BottomSheetNeedSubscriptionToAddKey_MembersInjector.injectLocalizationStorage(bottomSheetNeedSubscriptionToAddKey, this.provideLocalizationStorageProvider.get());
            BottomSheetNeedSubscriptionToAddKey_MembersInjector.injectFactory(bottomSheetNeedSubscriptionToAddKey, this.multiViewModelFactoryProvider.get());
            BottomSheetNeedSubscriptionToAddKey_MembersInjector.injectAnalytics(bottomSheetNeedSubscriptionToAddKey, this.analyticsProvider.get());
            return bottomSheetNeedSubscriptionToAddKey;
        }

        private CameraStreamFragment injectCameraStreamFragment(CameraStreamFragment cameraStreamFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(cameraStreamFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(cameraStreamFragment, this.prefManagerProvider.get());
            CameraStreamFragment_MembersInjector.injectLocalizationScreen(cameraStreamFragment, this.provideLocalizationStorageProvider.get());
            CameraStreamFragment_MembersInjector.injectCamerasFactory(cameraStreamFragment, this.assistFactoryProvider2.get());
            CameraStreamFragment_MembersInjector.injectAnalytics(cameraStreamFragment, this.analyticsProvider.get());
            CameraStreamFragment_MembersInjector.injectPrefManager(cameraStreamFragment, this.prefManagerProvider.get());
            CameraStreamFragment_MembersInjector.injectFactory(cameraStreamFragment, this.multiViewModelFactoryProvider.get());
            return cameraStreamFragment;
        }

        private DeletePaymentMethodDialog injectDeletePaymentMethodDialog(DeletePaymentMethodDialog deletePaymentMethodDialog) {
            DeletePaymentMethodDialog_MembersInjector.injectFactory(deletePaymentMethodDialog, this.multiViewModelFactoryProvider.get());
            DeletePaymentMethodDialog_MembersInjector.injectLocalizationScreen(deletePaymentMethodDialog, this.provideLocalizationStorageProvider.get());
            return deletePaymentMethodDialog;
        }

        private CheckCallStateService injectCheckCallStateService(CheckCallStateService checkCallStateService) {
            CheckCallStateService_MembersInjector.injectGetCallUseCase(checkCallStateService, getCallUseCase());
            return checkCallStateService;
        }

        private ClearCameraPreferencesDialog injectClearCameraPreferencesDialog(ClearCameraPreferencesDialog clearCameraPreferencesDialog) {
            ClearCameraPreferencesDialog_MembersInjector.injectLocalizationStorage(clearCameraPreferencesDialog, this.provideLocalizationStorageProvider.get());
            ClearCameraPreferencesDialog_MembersInjector.injectFactory(clearCameraPreferencesDialog, this.multiViewModelFactoryProvider.get());
            ClearCameraPreferencesDialog_MembersInjector.injectCameraViewModelFactory(clearCameraPreferencesDialog, this.assistFactoryProvider2.get());
            ClearCameraPreferencesDialog_MembersInjector.injectManageCameraViewModelFactory(clearCameraPreferencesDialog, this.assistFactoryProvider5.get());
            ClearCameraPreferencesDialog_MembersInjector.injectAnalytics(clearCameraPreferencesDialog, this.analyticsProvider.get());
            return clearCameraPreferencesDialog;
        }

        private BottomSheetSelectAddress injectBottomSheetSelectAddress(BottomSheetSelectAddress bottomSheetSelectAddress) {
            BottomSheetSelectAddress_MembersInjector.injectLocalizationStorage(bottomSheetSelectAddress, this.provideLocalizationStorageProvider.get());
            BottomSheetSelectAddress_MembersInjector.injectFactory(bottomSheetSelectAddress, this.multiViewModelFactoryProvider.get());
            BottomSheetSelectAddress_MembersInjector.injectCameraViewModelFactory(bottomSheetSelectAddress, this.assistFactoryProvider2.get());
            BottomSheetSelectAddress_MembersInjector.injectAnalytics(bottomSheetSelectAddress, this.analyticsProvider.get());
            return bottomSheetSelectAddress;
        }

        private DeleteAddressDialog injectDeleteAddressDialog(DeleteAddressDialog deleteAddressDialog) {
            DeleteAddressDialog_MembersInjector.injectLocalizationStorage(deleteAddressDialog, this.provideLocalizationStorageProvider.get());
            DeleteAddressDialog_MembersInjector.injectFactory(deleteAddressDialog, this.multiViewModelFactoryProvider.get());
            DeleteAddressDialog_MembersInjector.injectAnalytics(deleteAddressDialog, this.analyticsProvider.get());
            return deleteAddressDialog;
        }

        private YandexHomeFragment injectYandexHomeFragment(YandexHomeFragment yandexHomeFragment) {
            BaseFragment_MembersInjector.injectBaseFactory(yandexHomeFragment, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(yandexHomeFragment, this.prefManagerProvider.get());
            YandexHomeFragment_MembersInjector.injectPrefManager(yandexHomeFragment, this.prefManagerProvider.get());
            YandexHomeFragment_MembersInjector.injectAnalytics(yandexHomeFragment, this.analyticsProvider.get());
            YandexHomeFragment_MembersInjector.injectLocalizationScreen(yandexHomeFragment, this.provideLocalizationStorageProvider.get());
            YandexHomeFragment_MembersInjector.injectFactory(yandexHomeFragment, this.multiViewModelFactoryProvider.get());
            return yandexHomeFragment;
        }

        private BottomSheetNeedSubscriptionToAddDeviceForYandexAlice injectBottomSheetNeedSubscriptionToAddDeviceForYandexAlice(BottomSheetNeedSubscriptionToAddDeviceForYandexAlice bottomSheetNeedSubscriptionToAddDeviceForYandexAlice) {
            BottomSheetNeedSubscriptionToAddDeviceForYandexAlice_MembersInjector.injectLocalizationStorage(bottomSheetNeedSubscriptionToAddDeviceForYandexAlice, this.provideLocalizationStorageProvider.get());
            BottomSheetNeedSubscriptionToAddDeviceForYandexAlice_MembersInjector.injectFactory(bottomSheetNeedSubscriptionToAddDeviceForYandexAlice, this.multiViewModelFactoryProvider.get());
            BottomSheetNeedSubscriptionToAddDeviceForYandexAlice_MembersInjector.injectAnalytics(bottomSheetNeedSubscriptionToAddDeviceForYandexAlice, this.analyticsProvider.get());
            return bottomSheetNeedSubscriptionToAddDeviceForYandexAlice;
        }

        private BottomSheetMultiAddressAnnounce injectBottomSheetMultiAddressAnnounce(BottomSheetMultiAddressAnnounce bottomSheetMultiAddressAnnounce) {
            BottomSheetMultiAddressAnnounce_MembersInjector.injectLocalizationStorage(bottomSheetMultiAddressAnnounce, this.provideLocalizationStorageProvider.get());
            BottomSheetMultiAddressAnnounce_MembersInjector.injectFactory(bottomSheetMultiAddressAnnounce, this.multiViewModelFactoryProvider.get());
            BottomSheetMultiAddressAnnounce_MembersInjector.injectAnalytics(bottomSheetMultiAddressAnnounce, this.analyticsProvider.get());
            return bottomSheetMultiAddressAnnounce;
        }

        private BottomSheetSubscriptionNeededForCalls injectBottomSheetSubscriptionNeededForCalls(BottomSheetSubscriptionNeededForCalls bottomSheetSubscriptionNeededForCalls) {
            BottomSheetSubscriptionNeededForCalls_MembersInjector.injectLocalizationStorage(bottomSheetSubscriptionNeededForCalls, this.provideLocalizationStorageProvider.get());
            BottomSheetSubscriptionNeededForCalls_MembersInjector.injectFactory(bottomSheetSubscriptionNeededForCalls, this.multiViewModelFactoryProvider.get());
            BottomSheetSubscriptionNeededForCalls_MembersInjector.injectCameraViewModelFactory(bottomSheetSubscriptionNeededForCalls, this.assistFactoryProvider2.get());
            BottomSheetSubscriptionNeededForCalls_MembersInjector.injectAnalytics(bottomSheetSubscriptionNeededForCalls, this.analyticsProvider.get());
            return bottomSheetSubscriptionNeededForCalls;
        }

        private ArchiveWebView injectArchiveWebView(ArchiveWebView archiveWebView) {
            BaseFragment_MembersInjector.injectBaseFactory(archiveWebView, this.multiViewModelFactoryProvider.get());
            BaseFragment_MembersInjector.inject_prefManager(archiveWebView, this.prefManagerProvider.get());
            ArchiveWebView_MembersInjector.injectFactory(archiveWebView, this.multiViewModelFactoryProvider.get());
            return archiveWebView;
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final AppComponentImpl appComponentImpl;
            private final int id;

            SwitchingProvider(AppComponentImpl appComponentImpl, int i) {
                this.appComponentImpl = appComponentImpl;
                this.id = i;
            }

            @Override // javax.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new PrefManager(this.appComponentImpl.applicationContext, new Config());
                    case 1:
                        return (T) new Analytics(this.appComponentImpl.setOfAnalyticsTracker());
                    case 2:
                        return (T) LocalizationStorageModule_ProvideLocalizationStorageFactory.provideLocalizationStorage(this.appComponentImpl.localizationStorageModule, this.appComponentImpl.applicationContext, (PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.coroutineScope());
                    case 3:
                        return (T) new MultiViewModelFactory(this.appComponentImpl.mapOfClassOfAndProviderOfViewModel());
                    case 4:
                        return (T) new FamilyViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.getFamilyUseCase(), this.appComponentImpl.deleteFromFamilyUseCase(), this.appComponentImpl.makeAdminUseCase(), this.appComponentImpl.listMapperOfDomainFamilyAndFamily(), this.appComponentImpl.resetAddressUseCase());
                    case 5:
                        return (T) NetworkModule_ProvideFamilyApiFactory.provideFamilyApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 6:
                        return (T) NetworkModule_ProvideProdRetrofitFactory.provideProdRetrofit(this.appComponentImpl.networkModule, new Config(), (OkHttpClient) this.appComponentImpl.provideOkHttpProvider.get(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 7:
                        return (T) NetworkModule_ProvideOkHttpFactory.provideOkHttp(this.appComponentImpl.networkModule, (OkHttpClient.Builder) this.appComponentImpl.provideBaseOkHttpProvider.get(), (PrefManager) this.appComponentImpl.prefManagerProvider.get(), new Config());
                    case 8:
                        return (T) NetworkModule_ProvideBaseOkHttpFactory.provideBaseOkHttp(this.appComponentImpl.networkModule, this.appComponentImpl.applicationContext, (PrefManager) this.appComponentImpl.prefManagerProvider.get(), new Config());
                    case 9:
                        return (T) new ProfileRepository((ProfileApi) this.appComponentImpl.provideProfileApiProvider.get(), this.appComponentImpl.dataProfileToDomainProfileMapper());
                    case 10:
                        return (T) NetworkModule_ProvideProfileApiFactory.provideProfileApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 11:
                        return (T) new AddressViewModel(this.appComponentImpl.getCustomAddressUseCase(), this.appComponentImpl.deleteCustomAddressUseCase(), this.appComponentImpl.setCustomAddressUseCase(), this.appComponentImpl.updateCustomAddressUseCase());
                    case 12:
                        return (T) NetworkModule_ProvideAddressApiFactory.provideAddressApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 13:
                        return (T) new ArchiveViewModel(this.appComponentImpl.getArchiveSdkUrlUseCase(), this.appComponentImpl.listMapperOfDomainFlussonicAndFlussonic(), (LocalizationStorage) this.appComponentImpl.provideLocalizationStorageProvider.get(), this.appComponentImpl.getArchiveUrlsUseCase(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 14:
                        return (T) NetworkModule_ProvideServicesApiFactory.provideServicesApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 15:
                        return (T) new CardViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.addNewCardUseCase(), this.appComponentImpl.removeCardUseCase(), this.appComponentImpl.getLastCardPaymentUseCase());
                    case 16:
                        return (T) NetworkModule_ProvideCardApiFactory.provideCardApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 17:
                        return (T) new DigitalKeysViewModel((Analytics) this.appComponentImpl.analyticsProvider.get(), this.appComponentImpl.getDigitalKeysForAddressUseCase(), this.appComponentImpl.setDigitalKeyForAddressUseCase(), this.appComponentImpl.deleteDigitalKeyForAddressUseCase(), new DomainDigitalKeyToDigitalKeyMapper(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 18:
                        return (T) NetworkModule_ProvideDigitalKeysApiFactory.provideDigitalKeysApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 19:
                        return (T) new EventViewModel(this.appComponentImpl.reportCustomUseCase(), this.appComponentImpl.reportFlatInsuranceUseCase(), this.appComponentImpl.reportNoCameraUseCase(), this.appComponentImpl.reportIssueUseCase(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 20:
                        return (T) NetworkModule_ProvideEventApiFactory.provideEventApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 21:
                        return (T) new FrServiceViewModel(this.appComponentImpl.updateFrUseCaseOfPart());
                    case 22:
                        return (T) new HelpViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.getCompaniesUseCase(), this.appComponentImpl.getAnnounceUseCase(), this.appComponentImpl.getCompanyContactsUseCase(), this.appComponentImpl.listMapperOfDomainCompanyAndCompany());
                    case 23:
                        return (T) NetworkModule_ProvideHelpApiFactory.provideHelpApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 24:
                        return (T) NetworkModule_ProvideFaqApiFactory.provideFaqApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 25:
                        return (T) new MarketViewModel(this.appComponentImpl.getMarketUseCase(), this.appComponentImpl.getSubscriptionUseCase(), this.appComponentImpl.getServicesUseCase(), this.appComponentImpl.listMapperOfDomainServiceAndService(), this.appComponentImpl.listMapperOfDomainMarketAndMarket(), this.appComponentImpl.listMapperOfDomainSubscriptionAndSubscription(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 26:
                        return (T) NetworkModule_ProvideMarketApiFactory.provideMarketApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 27:
                        return (T) new SplashViewModel();
                    case 28:
                        return (T) new SubscriptionViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.startSubscriptionUseCase(), this.appComponentImpl.getLastCardPaymentUseCase2(), this.appComponentImpl.stopSubscriptionUseCase(), (LocalizationStorage) this.appComponentImpl.provideLocalizationStorageProvider.get());
                    case 29:
                        return (T) NetworkModule_ProvideSubscriptionApiFactory.provideSubscriptionApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 30:
                        return (T) new SurveyViewModel(this.appComponentImpl.sendFeedbackUseCase());
                    case 31:
                        return (T) NetworkModule_ProvideSurveyApiFactory.provideSurveyApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 32:
                        return (T) new NotificationsViewModel(this.appComponentImpl.getNotificationsUseCase(), this.appComponentImpl.getUnviewedNotificationsUseCase(), this.appComponentImpl.getNotificationUseCase(), this.appComponentImpl.updateNotificationUseCase(), new DomainNotificationToNotificationMapper());
                    case 33:
                        return (T) NetworkModule_ProvideNotificationsApiFactory.provideNotificationsApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 34:
                        return (T) new FaqViewModel(this.appComponentImpl.getFaqUseCase(), this.appComponentImpl.getFaq2UseCase(), new DomainFaqToFaqMapper(), new Config(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 35:
                        return (T) new GorservViewModel(this.appComponentImpl.getGorservCatalogsUseCase(), this.appComponentImpl.createGorservTicketUseCase(), new DomainGorservCatalogToGorservCatalogMapper(), new DomainGorservCreateTicketToGorservCreateTicketMapper(), new Config(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 36:
                        return (T) NetworkModule_ProvideGorservApiFactory.provideGorservApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 37:
                        return (T) new SettingsViewModel(this.appComponentImpl.applicationContext, (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 38:
                        return (T) new ServicePaymentsViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), new Config(), this.appComponentImpl.getServicePaymentsUseCase(), this.appComponentImpl.getServiceAccountInfoUseCase(), this.appComponentImpl.getReceiptByAccrualUseCase(), this.appComponentImpl.promisePaymentUseCase(), this.appComponentImpl.domainPaymentHistoryToPaymentHistoryMapper(), new DomainPromisedPaymentToPromisedPaymentMapper(), new DomainServiceAccountInfoToServiceAccountInfoMapper());
                    case 39:
                        return (T) NetworkModule_ProvideServicePaymentsApiFactory.provideServicePaymentsApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 40:
                        return (T) new PaymentsViewModel(new Config(), (PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.payIntercomUseCase(), this.appComponentImpl.getPaymentStatusUseCase());
                    case 41:
                        return (T) new SurveysViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.getSurveysUseCase(), this.appComponentImpl.getSurveyUseCase(), this.appComponentImpl.sendResultUseCase(), this.appComponentImpl.listMapperOfDomainSurveyAndSurvey(), new DomainSurveyToSurveyMapper());
                    case 42:
                        return (T) new TilesViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.getTilesUseCase());
                    case 43:
                        return (T) NetworkModule_ProvideTilesApiFactory.provideTilesApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideBaseProdRetrofitProvider.get());
                    case 44:
                        return (T) NetworkModule_ProvideBaseProdRetrofitFactory.provideBaseProdRetrofit(this.appComponentImpl.networkModule, new Config(), (OkHttpClient) this.appComponentImpl.provideOkHttpNoJwtProvider.get(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 45:
                        return (T) NetworkModule_ProvideOkHttpNoJwtFactory.provideOkHttpNoJwt(this.appComponentImpl.networkModule, (OkHttpClient.Builder) this.appComponentImpl.provideBaseOkHttpProvider.get());
                    case 46:
                        return (T) new LocalizationViewModel(this.appComponentImpl.getLocalizationUseCase(), (PrefManager) this.appComponentImpl.prefManagerProvider.get(), new Config(), this.appComponentImpl.listMapperOfDomainLocalizationAndLocalization(), (LocalizationStorage) this.appComponentImpl.provideLocalizationStorageProvider.get());
                    case 47:
                        return (T) NetworkModule_ProvideLocalizationApiFactory.provideLocalizationApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 48:
                        return (T) new ProfileViewModel(this.appComponentImpl.applicationContext, this.appComponentImpl.deleteFrUseCase(), this.appComponentImpl.setLocalizationUseCase(), this.appComponentImpl.changeAvatarUseCase(), this.appComponentImpl.getProfileUseCase(), this.appComponentImpl.logoutUseCase(), this.appComponentImpl.deleteAccountUseCase(), this.appComponentImpl.verifyAddressUseCase(), this.appComponentImpl.deactivateAddressUseCase(), this.appComponentImpl.unlinkAddressUseCase(), this.appComponentImpl.deactivateAccountUseCase(), this.appComponentImpl.sendPushTokenUseCase(), this.appComponentImpl.sendTimezoneUseCase(), this.appComponentImpl.sendCallEnabledUseCase(), this.appComponentImpl.bindToFlatUseCase(), (PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.domainProfileToProfileMapper(), (LocalizationStorage) this.appComponentImpl.provideLocalizationStorageProvider.get(), new Config(), (Analytics) this.appComponentImpl.analyticsProvider.get());
                    case 49:
                        return (T) new StoriesViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), new Config(), this.appComponentImpl.getOnBoardingStoriesUseCase(), this.appComponentImpl.getStoriesUseCase(), this.appComponentImpl.nullableInputListMapperOfDomainStoryAndStory());
                    case 50:
                        return (T) NetworkModule_ProvideStoriesApiFactory.provideStoriesApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideBaseProdRetrofitProvider.get());
                    case 51:
                        return (T) new AlertsViewModel(this.appComponentImpl.getAlertsUseCase(), new DomainAlertToAlertMapper(), new Config(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 52:
                        return (T) NetworkModule_ProvideAlertsApiFactory.provideAlertsApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 53:
                        return (T) new NavigationViewModel();
                    case 54:
                        return (T) new StateViewModel();
                    case 55:
                        return (T) new OnboardingViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), this.appComponentImpl.applicationContext);
                    case 56:
                        return (T) new InvitesViewModel(this.appComponentImpl.getInvitesUseCase(), this.appComponentImpl.getFamilyInvitesUseCase(), this.appComponentImpl.sendFamilyInviteUseCase(), this.appComponentImpl.resendFamilyInviteUseCase(), this.appComponentImpl.deleteFamilyInviteUseCase(), this.appComponentImpl.acceptInviteUseCase(), this.appComponentImpl.declineInviteUseCase(), new Config(), (PrefManager) this.appComponentImpl.prefManagerProvider.get(), new DomainInviteToInviteMapper(), new DomainFamilyInvitesToFamilyInvitesMapper(), this.appComponentImpl.getCountryCodeUseCase(), (LocalizationStorage) this.appComponentImpl.provideLocalizationStorageProvider.get());
                    case 57:
                        return (T) NetworkModule_ProvideInvitesApiFactory.provideInvitesApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 58:
                        return (T) new PopupStoriesViewModel((PrefManager) this.appComponentImpl.prefManagerProvider.get(), new Config(), this.appComponentImpl.getPopupStoriesUseCase(), this.appComponentImpl.sendPopupStoriesActionUseCase(), this.appComponentImpl.nullableInputListMapperOfDomainPopupStoryStructureAndPopupStoryStructure());
                    case 59:
                        return (T) NetworkModule_ProvidePopupStoriesApiFactory.providePopupStoriesApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 60:
                        return (T) new InstructionsViewModel(this.appComponentImpl.applicationContext);
                    case 61:
                        return (T) new SubscriptionsViewModel(this.appComponentImpl.getMarketV2UseCase(), this.appComponentImpl.domainBaseSubscriptionToBaseSubscriptionMapper(), this.appComponentImpl.domainOuterServiceToOuterServiceMapper(), new DomainMarketItemToMarketItemMapper(), (PrefManager) this.appComponentImpl.prefManagerProvider.get());
                    case 62:
                        return (T) new KeysViewModel(this.appComponentImpl.getPhysicalKeysUseCase(), this.appComponentImpl.createPhysicalKeyUseCase(), this.appComponentImpl.blockPhysicalKeyUseCase(), this.appComponentImpl.unblockPhysicalKeyUseCase(), this.appComponentImpl.deletePhysicalKeyUseCase(), this.appComponentImpl.updatePhysicalKeyCommentUseCase(), new DomainPhysicalKeyToPhysicalKeyMapper(), new Config(), (PrefManager) this.appComponentImpl.prefManagerProvider.get(), (LocalizationStorage) this.appComponentImpl.provideLocalizationStorageProvider.get(), (Analytics) this.appComponentImpl.analyticsProvider.get());
                    case 63:
                        return (T) NetworkModule_ProvidePhysicalKeysApiFactory.providePhysicalKeysApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 64:
                        return (T) new CallViewModel.Factory.AssistFactory() { // from class: sputnik.axmor.com.sputnik.di.DaggerAppComponent.AppComponentImpl.SwitchingProvider.1
                            @Override // sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel.Factory.AssistFactory
                            public CallViewModel.Factory create(String str, String str2, String str3, boolean z) {
                                return new CallViewModel.Factory(str, str2, str3, z, SwitchingProvider.this.appComponentImpl.getCallUseCase(), SwitchingProvider.this.appComponentImpl.acceptCallUseCase(), SwitchingProvider.this.appComponentImpl.getSipAccountUseCase(), SwitchingProvider.this.appComponentImpl.getCameraByIntercomUUIDUseCase(), new DomainCallToCallMapper(), new DomainSipAccountToSipAccountMapper(), SwitchingProvider.this.appComponentImpl.domainCameraToCameraMapper());
                            }
                        };
                    case 65:
                        return (T) NetworkModule_ProvideCallApiFactory.provideCallApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 66:
                        return (T) NetworkModule_ProvideCamerasApiFactory.provideCamerasApi(this.appComponentImpl.networkModule, (Retrofit) this.appComponentImpl.provideProdRetrofitProvider.get());
                    case 67:
                        return (T) new AllCamerasViewModel.Factory.AssistFactory() { // from class: sputnik.axmor.com.sputnik.di.DaggerAppComponent.AppComponentImpl.SwitchingProvider.2
                            @Override // com.sputnik.common.viewmodels.AllCamerasViewModel.Factory.AssistFactory
                            public AllCamerasViewModel.Factory create(String str) {
                                return new AllCamerasViewModel.Factory(str, SwitchingProvider.this.appComponentImpl.getAllCamerasUseCase(), SwitchingProvider.this.appComponentImpl.getCamerasDemoUseCase(), SwitchingProvider.this.appComponentImpl.openDoorUseCase(), SwitchingProvider.this.appComponentImpl.openSecondDoorUseCase(), SwitchingProvider.this.appComponentImpl.domainCameraToCameraMapper(), SwitchingProvider.this.appComponentImpl.listMapperOfDomainCameraAndCamera(), (PrefManager) SwitchingProvider.this.appComponentImpl.prefManagerProvider.get());
                            }
                        };
                    case 68:
                        return (T) new CallHistoryViewModel.Factory.AssistFactory() { // from class: sputnik.axmor.com.sputnik.di.DaggerAppComponent.AppComponentImpl.SwitchingProvider.3
                            @Override // sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel.Factory.AssistFactory
                            public CallHistoryViewModel.Factory create(String str) {
                                return new CallHistoryViewModel.Factory(str, SwitchingProvider.this.appComponentImpl.getCallHistoryUseCase(), SwitchingProvider.this.appComponentImpl.deleteCallHistoryUseCase(), SwitchingProvider.this.appComponentImpl.domainCallHistoryToCallHistoryMapper(), (PrefManager) SwitchingProvider.this.appComponentImpl.prefManagerProvider.get(), (Analytics) SwitchingProvider.this.appComponentImpl.analyticsProvider.get());
                            }
                        };
                    case 69:
                        return (T) new SettingsProfileViewModel.Factory.AssistFactory() { // from class: sputnik.axmor.com.sputnik.di.DaggerAppComponent.AppComponentImpl.SwitchingProvider.4
                            @Override // com.sputnik.common.viewmodels.SettingsProfileViewModel.Factory.AssistFactory
                            public SettingsProfileViewModel.Factory create(String str, String str2, String str3) {
                                return new SettingsProfileViewModel.Factory(str, str2, str3, SwitchingProvider.this.appComponentImpl.updateUseNameUseCase());
                            }
                        };
                    case 70:
                        return (T) new ManageCamerasViewModel.Factory.AssistFactory() { // from class: sputnik.axmor.com.sputnik.di.DaggerAppComponent.AppComponentImpl.SwitchingProvider.5
                            @Override // sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel.Factory.AssistFactory
                            public ManageCamerasViewModel.Factory create(String str) {
                                return new ManageCamerasViewModel.Factory(str, SwitchingProvider.this.appComponentImpl.setCamerasOrderUseCase(), SwitchingProvider.this.appComponentImpl.getCamerasOrderUseCase(), SwitchingProvider.this.appComponentImpl.setCameraParamsUseCase(), SwitchingProvider.this.appComponentImpl.getCamerasPreferencesUseCase(), SwitchingProvider.this.appComponentImpl.clearCamerasPreferencesUseCase(), SwitchingProvider.this.appComponentImpl.camerasOrderToDomainCamerasOrderMapper(), new CameraObjectToDomainCameraObjectMapper(), new DomainCameraObjectToCameraObjectMapper(), (LocalizationStorage) SwitchingProvider.this.appComponentImpl.provideLocalizationStorageProvider.get(), (PrefManager) SwitchingProvider.this.appComponentImpl.prefManagerProvider.get());
                            }
                        };
                    case 71:
                        return (T) new DownloadService.Factory() { // from class: sputnik.axmor.com.sputnik.di.DaggerAppComponent.AppComponentImpl.SwitchingProvider.6
                            @Override // sputnik.axmor.com.sputnik.services.download_service.DownloadService.Factory
                            public DownloadService create(AppCompatActivity appCompatActivity) {
                                return SwitchingProvider.this.appComponentImpl.injectDownloadService(C2638DownloadService_Factory.newInstance(appCompatActivity));
                            }
                        };
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }
}
