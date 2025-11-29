package com.sputnik.data.di.modules;

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
import com.sputnik.data.mappers.address.DataCustomAddressToDomainCustomAddressMapper;
import com.sputnik.data.mappers.alerts.DataAlertToDomainAlertMapper;
import com.sputnik.data.mappers.archive.DataArchiveToDomainArchiveMapper;
import com.sputnik.data.mappers.archive.DataFlussonicToDomainFlussonicMapper;
import com.sputnik.data.mappers.cameras.DataCameraToDomainCameraMapper;
import com.sputnik.data.mappers.cameras.DataCamerasOrderToDomainCamerasOrderMapper;
import com.sputnik.data.mappers.company.DataCompanyToDomainCompanyMapper;
import com.sputnik.data.mappers.country_code.DataCountryCodeToDomainCountryCodeMapper;
import com.sputnik.data.mappers.digital_keys.DataDigitalKeyToDomainDigitalKeyMapper;
import com.sputnik.data.mappers.family.DataFamilyToDomainFamilyMapper;
import com.sputnik.data.mappers.faq.DataFaqToDomainFaqMapper;
import com.sputnik.data.mappers.gorserv.DataGorservCatalogToDomainGorservCatalogMapper;
import com.sputnik.data.mappers.invites.DataInviteToDomainInviteMapper;
import com.sputnik.data.mappers.localization.DataLocalizationToDomainLocalizationMapper;
import com.sputnik.data.mappers.market.DataMarketToDomainMarketMapper;
import com.sputnik.data.mappers.market.DataServiceToDomainServiceMapper;
import com.sputnik.data.mappers.market.DataSmallServiceToDomainSmallServiceMapper;
import com.sputnik.data.mappers.market.DataSubsPlansToDomainSubsPlansMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionInfoToDomainSubscriptionInfoMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionToDomainSubscriptionMapper;
import com.sputnik.data.mappers.notifications.DataNotificationtToDomainNotificationMapper;
import com.sputnik.data.mappers.popups.DataPopupStoryToDomainPopupStoryMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentHistoryToDomainPaymentHistoryMapper;
import com.sputnik.data.mappers.stories.DataStoriesButtonToDomainStoriesButtonMapper;
import com.sputnik.data.mappers.stories.DataStoryToDomainStoryMapper;
import com.sputnik.data.mappers.subscriptions.DataBaseSubscriptionToDomainBaseSubscriptionMapper;
import com.sputnik.data.mappers.subscriptions.DataMarketItemToDomainMarketItemMapper;
import com.sputnik.data.mappers.subscriptions.DataOuterServiceToDomainOuterServiceMapper;
import com.sputnik.data.mappers.survey.DataSurveyToDomainSurveyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.ListMapperImpl;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.NullableInputListMapperImpl;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListMappersModule.kt */
@Metadata(d1 = {"\u0000ê\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0005\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0005\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u0005\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u0005\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 J#\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010\u0005\u001a\u00020!H\u0007¢\u0006\u0004\b$\u0010%J#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0\u00062\u0006\u0010\u0005\u001a\u00020&H\u0007¢\u0006\u0004\b)\u0010*J#\u0010.\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0\u00112\u0006\u0010\u0005\u001a\u00020+H\u0007¢\u0006\u0004\b.\u0010/J#\u00103\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u00062\u0006\u0010\u0005\u001a\u000200H\u0007¢\u0006\u0004\b3\u00104J#\u00108\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002070\u00112\u0006\u0010\u0005\u001a\u000205H\u0007¢\u0006\u0004\b8\u00109J#\u0010=\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0\u00112\u0006\u0010\u0005\u001a\u00020:H\u0007¢\u0006\u0004\b=\u0010>J#\u0010B\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0\u00112\u0006\u0010\u0005\u001a\u00020?H\u0007¢\u0006\u0004\bB\u0010CJ#\u0010G\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0\u00112\u0006\u0010\u0005\u001a\u00020DH\u0007¢\u0006\u0004\bG\u0010HJ#\u0010L\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K0\u00112\u0006\u0010\u0005\u001a\u00020IH\u0007¢\u0006\u0004\bL\u0010MJ#\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0\u00112\u0006\u0010\u0005\u001a\u00020NH\u0007¢\u0006\u0004\bQ\u0010RJ#\u0010V\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0\u00112\u0006\u0010\u0005\u001a\u00020SH\u0007¢\u0006\u0004\bV\u0010WJ#\u0010[\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Z0\u00112\u0006\u0010\u0005\u001a\u00020XH\u0007¢\u0006\u0004\b[\u0010\\J#\u0010`\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020_0\u00112\u0006\u0010\u0005\u001a\u00020]H\u0007¢\u0006\u0004\b`\u0010aJ#\u0010e\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d0\u00112\u0006\u0010\u0005\u001a\u00020bH\u0007¢\u0006\u0004\be\u0010fJ#\u0010j\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020i0\u00112\u0006\u0010\u0005\u001a\u00020gH\u0007¢\u0006\u0004\bj\u0010kJ#\u0010o\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020n0\u00112\u0006\u0010\u0005\u001a\u00020lH\u0007¢\u0006\u0004\bo\u0010pJ#\u0010t\u001a\u000e\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020s0\u00112\u0006\u0010\u0005\u001a\u00020qH\u0007¢\u0006\u0004\bt\u0010uJ#\u0010y\u001a\u000e\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020x0\u00112\u0006\u0010\u0005\u001a\u00020vH\u0007¢\u0006\u0004\by\u0010zJ#\u0010~\u001a\u000e\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020}0\u00112\u0006\u0010\u0005\u001a\u00020{H\u0007¢\u0006\u0004\b~\u0010\u007fJ)\u0010\u0083\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0005\u0012\u00030\u0082\u00010\u00112\u0007\u0010\u0005\u001a\u00030\u0080\u0001H\u0007¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J)\u0010\u0088\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0005\u0012\u00030\u0087\u00010\u00112\u0007\u0010\u0005\u001a\u00030\u0085\u0001H\u0007¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J)\u0010\u008d\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008b\u0001\u0012\u0005\u0012\u00030\u008c\u00010\u00112\u0007\u0010\u0005\u001a\u00030\u008a\u0001H\u0007¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J)\u0010\u0092\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0005\u0012\u00030\u0091\u00010\u00062\u0007\u0010\u0005\u001a\u00030\u008f\u0001H\u0007¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J)\u0010\u0097\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0095\u0001\u0012\u0005\u0012\u00030\u0096\u00010\u00062\u0007\u0010\u0005\u001a\u00030\u0094\u0001H\u0007¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006\u0099\u0001"}, d2 = {"Lcom/sputnik/data/di/modules/ListMappersModule;", "", "<init>", "()V", "Lcom/sputnik/data/mappers/stories/DataStoriesButtonToDomainStoriesButtonMapper;", "mapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/entities/stories/DataStoriesButton;", "Lcom/sputnik/domain/entities/stories/DomainStoriesButton;", "provideDataStoriesButtonToDomainStories", "(Lcom/sputnik/data/mappers/stories/DataStoriesButtonToDomainStoriesButtonMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/mappers/stories/DataStoryToDomainStoryMapper;", "Lcom/sputnik/data/entities/stories/DataStory;", "Lcom/sputnik/domain/entities/stories/DomainStory;", "provideDataStoryToDomainStory", "(Lcom/sputnik/data/mappers/stories/DataStoryToDomainStoryMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/mappers/archive/DataFlussonicToDomainFlussonicMapper;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/archive/DataFlussonic;", "Lcom/sputnik/domain/entities/archive/DomainFlussonic;", "provideDataFlussonicToDomainFlussonic", "(Lcom/sputnik/data/mappers/archive/DataFlussonicToDomainFlussonicMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/archive/DataArchiveToDomainArchiveMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/archive/DataArchiveResponse;", "Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;", "provideDataArchiveToDomainArchive", "(Lcom/sputnik/data/mappers/archive/DataArchiveToDomainArchiveMapper;)Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/mappers/market/DataSubsPlansToDomainSubsPlansMapper;", "Lcom/sputnik/data/entities/market/DataSubsPlans;", "Lcom/sputnik/domain/entities/market/DomainSubsPlans;", "provideDataSubsPlansToDomainSubsPlans", "(Lcom/sputnik/data/mappers/market/DataSubsPlansToDomainSubsPlansMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionInfoToDomainSubscriptionInfoMapper;", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionInfo;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionInfo;", "provideDataSubscriptionInfoToDomainSubscriptionInfo", "(Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionInfoToDomainSubscriptionInfoMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/mappers/market/DataSmallServiceToDomainSmallServiceMapper;", "Lcom/sputnik/data/entities/market/DataSmallService;", "Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "provideDataSmallServiceToDomainSmallServices", "(Lcom/sputnik/data/mappers/market/DataSmallServiceToDomainSmallServiceMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/mappers/address/DataCustomAddressToDomainCustomAddressMapper;", "Lcom/sputnik/data/entities/address/DataCustomAddress;", "Lcom/sputnik/domain/entities/address/DomainCustomAddress;", "provideDataCustomAddressToDomainCustomAddress", "(Lcom/sputnik/data/mappers/address/DataCustomAddressToDomainCustomAddressMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/cameras/DataCameraToDomainCameraMapper;", "Lcom/sputnik/data/entities/cameras/DataCamera;", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "provideDataCameraToDomainCamera", "(Lcom/sputnik/data/mappers/cameras/DataCameraToDomainCameraMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/mappers/country_code/DataCountryCodeToDomainCountryCodeMapper;", "Lcom/sputnik/data/entities/country_code/DataCountryCode;", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "provideDataCountryCodeToDomainCountryCode", "(Lcom/sputnik/data/mappers/country_code/DataCountryCodeToDomainCountryCodeMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/digital_keys/DataDigitalKeyToDomainDigitalKeyMapper;", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;", "Lcom/sputnik/domain/entities/digital_keys/DomainDigitalKey;", "provideDataDigitalKeyToDomainDigitalKey", "(Lcom/sputnik/data/mappers/digital_keys/DataDigitalKeyToDomainDigitalKeyMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/family/DataFamilyToDomainFamilyMapper;", "Lcom/sputnik/data/entities/family/DataFamily;", "Lcom/sputnik/domain/entities/family/DomainFamily;", "provideDataFamilyToDomainFamily", "(Lcom/sputnik/data/mappers/family/DataFamilyToDomainFamilyMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/company/DataCompanyToDomainCompanyMapper;", "Lcom/sputnik/data/entities/company/DataCompany;", "Lcom/sputnik/domain/entities/company/DomainCompany;", "provideDataCompanyToDomainCompany", "(Lcom/sputnik/data/mappers/company/DataCompanyToDomainCompanyMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/localization/DataLocalizationToDomainLocalizationMapper;", "Lcom/sputnik/data/entities/localization/DataLocalization;", "Lcom/sputnik/domain/entities/localization/DomainLocalization;", "provideDataLocalizationToDomainLocalization", "(Lcom/sputnik/data/mappers/localization/DataLocalizationToDomainLocalizationMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionToDomainSubscriptionMapper;", "Lcom/sputnik/data/entities/market/subscription/DataSubscription;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "provideDataSubscriptionToDomainSubscription", "(Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionToDomainSubscriptionMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/market/DataMarketToDomainMarketMapper;", "Lcom/sputnik/data/entities/market/DataMarket;", "Lcom/sputnik/domain/entities/market/DomainMarket;", "provideDataMarketToDomainMarket", "(Lcom/sputnik/data/mappers/market/DataMarketToDomainMarketMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/subscriptions/DataBaseSubscriptionToDomainBaseSubscriptionMapper;", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBaseSubscription;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "provideDataMarketV2ToDomainMarketV2", "(Lcom/sputnik/data/mappers/subscriptions/DataBaseSubscriptionToDomainBaseSubscriptionMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/subscriptions/DataOuterServiceToDomainOuterServiceMapper;", "Lcom/sputnik/data/entities/subscriptions/services/DataOuterService;", "Lcom/sputnik/domain/entities/subscriptions/services/DomainOuterService;", "provideDataOuterServiceToDomainOuterServiceMapper", "(Lcom/sputnik/data/mappers/subscriptions/DataOuterServiceToDomainOuterServiceMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/subscriptions/DataMarketItemToDomainMarketItemMapper;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem;", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem;", "provideDataMarketItemToDomainMarketItemMapper", "(Lcom/sputnik/data/mappers/subscriptions/DataMarketItemToDomainMarketItemMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/market/DataServiceToDomainServiceMapper;", "Lcom/sputnik/data/entities/market/service/DataService;", "Lcom/sputnik/domain/entities/market/services/DomainService;", "provideDataServiceToDomainService", "(Lcom/sputnik/data/mappers/market/DataServiceToDomainServiceMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/service_payments/DataPaymentHistoryToDomainPaymentHistoryMapper;", "Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "provideDataPaymentHistoryToDomainPaymentHistory", "(Lcom/sputnik/data/mappers/service_payments/DataPaymentHistoryToDomainPaymentHistoryMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/alerts/DataAlertToDomainAlertMapper;", "Lcom/sputnik/data/entities/alerts/DataAlert;", "Lcom/sputnik/domain/entities/alers/DomainAlert;", "provideDataAlertToDomainAlert", "(Lcom/sputnik/data/mappers/alerts/DataAlertToDomainAlertMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/survey/DataSurveyToDomainSurveyMapper;", "Lcom/sputnik/data/entities/survey/DataSurvey;", "Lcom/sputnik/domain/entities/survey/DomainSurvey;", "provideDataSurveyToDomainSurvey", "(Lcom/sputnik/data/mappers/survey/DataSurveyToDomainSurveyMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/notifications/DataNotificationtToDomainNotificationMapper;", "Lcom/sputnik/data/entities/notifications/DataNotification;", "Lcom/sputnik/domain/entities/notifications/DomainNotification;", "provideDataNotificationToDomainNotification", "(Lcom/sputnik/data/mappers/notifications/DataNotificationtToDomainNotificationMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/faq/DataFaqToDomainFaqMapper;", "Lcom/sputnik/data/entities/faq/DataFaq;", "Lcom/sputnik/domain/entities/faq/DomainFaq;", "provideDataFaqToDomainFaq", "(Lcom/sputnik/data/mappers/faq/DataFaqToDomainFaqMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/invites/DataInviteToDomainInviteMapper;", "Lcom/sputnik/data/entities/invites/DataInvite;", "Lcom/sputnik/domain/entities/invites/DomainInvite;", "provideDataInviteToDomainInvite", "(Lcom/sputnik/data/mappers/invites/DataInviteToDomainInviteMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/gorserv/DataGorservCatalogToDomainGorservCatalogMapper;", "Lcom/sputnik/data/entities/gorserv/DataGorservCatalog;", "Lcom/sputnik/domain/entities/gorserv/DomainGorservCatalog;", "provideDataGorservCatalogToDomainGorservCatalog", "(Lcom/sputnik/data/mappers/gorserv/DataGorservCatalogToDomainGorservCatalogMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/popups/DataPopupStoryToDomainPopupStoryMapper;", "Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;", "Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "provideDataPopupStoriesToDomainPopupStoriesCatalog", "(Lcom/sputnik/data/mappers/popups/DataPopupStoryToDomainPopupStoryMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/mappers/cameras/DataCamerasOrderToDomainCamerasOrderMapper;", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;", "Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "provideDataCameraPreferencesToDomainCameraPreferences", "(Lcom/sputnik/data/mappers/cameras/DataCamerasOrderToDomainCamerasOrderMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListMappersModule {
    public final Mapper<DataArchiveResponse, DomainArchiveUrls> provideDataArchiveToDomainArchive(DataArchiveToDomainArchiveMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper;
    }

    public final NullableInputListMapper<DataStoriesButton, DomainStoriesButton> provideDataStoriesButtonToDomainStories(DataStoriesButtonToDomainStoriesButtonMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DataStory, DomainStory> provideDataStoryToDomainStory(DataStoryToDomainStoryMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final ListMapper<DataFlussonic, DomainFlussonic> provideDataFlussonicToDomainFlussonic(DataFlussonicToDomainFlussonicMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DataSubsPlans, DomainSubsPlans> provideDataSubsPlansToDomainSubsPlans(DataSubsPlansToDomainSubsPlansMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DataSubscriptionInfo, DomainSubscriptionInfo> provideDataSubscriptionInfoToDomainSubscriptionInfo(DataSubscriptionInfoToDomainSubscriptionInfoMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DataSmallService, DomainSmallServices> provideDataSmallServiceToDomainSmallServices(DataSmallServiceToDomainSmallServiceMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final ListMapper<DataCustomAddress, DomainCustomAddress> provideDataCustomAddressToDomainCustomAddress(DataCustomAddressToDomainCustomAddressMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DataCamera, DomainCamera> provideDataCameraToDomainCamera(DataCameraToDomainCameraMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final ListMapper<DataCountryCode, DomainCountryCode> provideDataCountryCodeToDomainCountryCode(DataCountryCodeToDomainCountryCodeMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataDigitalKey, DomainDigitalKey> provideDataDigitalKeyToDomainDigitalKey(DataDigitalKeyToDomainDigitalKeyMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataFamily, DomainFamily> provideDataFamilyToDomainFamily(DataFamilyToDomainFamilyMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataCompany, DomainCompany> provideDataCompanyToDomainCompany(DataCompanyToDomainCompanyMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataLocalization, DomainLocalization> provideDataLocalizationToDomainLocalization(DataLocalizationToDomainLocalizationMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataSubscription, DomainSubscription> provideDataSubscriptionToDomainSubscription(DataSubscriptionToDomainSubscriptionMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataMarket, DomainMarket> provideDataMarketToDomainMarket(DataMarketToDomainMarketMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataBaseSubscription, DomainBaseSubscription> provideDataMarketV2ToDomainMarketV2(DataBaseSubscriptionToDomainBaseSubscriptionMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataOuterService, DomainOuterService> provideDataOuterServiceToDomainOuterServiceMapper(DataOuterServiceToDomainOuterServiceMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataMarketItem, DomainMarketItem> provideDataMarketItemToDomainMarketItemMapper(DataMarketItemToDomainMarketItemMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataService, DomainService> provideDataServiceToDomainService(DataServiceToDomainServiceMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataPaymentHistory, DomainPaymentHistory> provideDataPaymentHistoryToDomainPaymentHistory(DataPaymentHistoryToDomainPaymentHistoryMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataAlert, DomainAlert> provideDataAlertToDomainAlert(DataAlertToDomainAlertMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataSurvey, DomainSurvey> provideDataSurveyToDomainSurvey(DataSurveyToDomainSurveyMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataNotification, DomainNotification> provideDataNotificationToDomainNotification(DataNotificationtToDomainNotificationMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataFaq, DomainFaq> provideDataFaqToDomainFaq(DataFaqToDomainFaqMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataInvite, DomainInvite> provideDataInviteToDomainInvite(DataInviteToDomainInviteMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DataGorservCatalog, DomainGorservCatalog> provideDataGorservCatalogToDomainGorservCatalog(DataGorservCatalogToDomainGorservCatalogMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure> provideDataPopupStoriesToDomainPopupStoriesCatalog(DataPopupStoryToDomainPopupStoryMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DataCamerasOrder, DomainCamerasOrder> provideDataCameraPreferencesToDomainCameraPreferences(DataCamerasOrderToDomainCamerasOrderMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }
}
