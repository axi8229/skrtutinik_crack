package sputnik.axmor.com.sputnik.di;

import com.sputnik.common.entities.archive.Flussonic;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.entities.market.market.SmallServices;
import com.sputnik.common.entities.market.market.SubsPlans;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.common.entities.surveys.Survey;
import com.sputnik.common.mappers.archive.DomainFlussonicToFlussonicMapper;
import com.sputnik.common.mappers.surveys.DomainSurveyToSurveyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.ListMapperImpl;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.NullableInputListMapperImpl;
import com.sputnik.domain.entities.archive.DomainFlussonic;
import com.sputnik.domain.entities.company.DomainCompany;
import com.sputnik.domain.entities.family.DomainFamily;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.DomainSubsPlans;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import com.sputnik.domain.entities.survey.DomainSurvey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.company.Company;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.mappers.company.DomainCompanyToCompanyMapper;
import sputnik.axmor.com.sputnik.mappers.family.DomainFamilyToFamilyMapper;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainMarketToMarketMapper;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainSmallServicesToSmallServicesMapper;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainSubsPlansToSubsPlansMapper;
import sputnik.axmor.com.sputnik.mappers.market.service.DomainServiceToServiceMapper;
import sputnik.axmor.com.sputnik.mappers.market.subscription.DomainSubscriptionToSubscriptionMapper;

/* compiled from: DomainListMapperModule.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u0005\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\f2\u0006\u0010\u0005\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\f2\u0006\u0010\u0005\u001a\u00020 H\u0007¢\u0006\u0004\b#\u0010$J#\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0\f2\u0006\u0010\u0005\u001a\u00020%H\u0007¢\u0006\u0004\b(\u0010)J#\u0010-\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0\f2\u0006\u0010\u0005\u001a\u00020*H\u0007¢\u0006\u0004\b-\u0010.J#\u00102\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010\f2\u0006\u0010\u0005\u001a\u00020/H\u0007¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"Lsputnik/axmor/com/sputnik/di/DomainListMapperModule;", "", "<init>", "()V", "Lsputnik/axmor/com/sputnik/mappers/market/market/DomainSubsPlansToSubsPlansMapper;", "mapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/domain/entities/market/DomainSubsPlans;", "Lcom/sputnik/common/entities/market/market/SubsPlans;", "provideDomainSubsPlansToSubsPlans", "(Lsputnik/axmor/com/sputnik/mappers/market/market/DomainSubsPlansToSubsPlansMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/common/mappers/archive/DomainFlussonicToFlussonicMapper;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/archive/DomainFlussonic;", "Lcom/sputnik/common/entities/archive/Flussonic;", "provideDomainFlussonicToFlussonic", "(Lcom/sputnik/common/mappers/archive/DomainFlussonicToFlussonicMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lsputnik/axmor/com/sputnik/mappers/market/market/DomainSmallServicesToSmallServicesMapper;", "Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "Lcom/sputnik/common/entities/market/market/SmallServices;", "provideDomainSmallServiceToSmallServices", "(Lsputnik/axmor/com/sputnik/mappers/market/market/DomainSmallServicesToSmallServicesMapper;)Lcom/sputnik/domain/common/NullableInputListMapper;", "Lsputnik/axmor/com/sputnik/mappers/family/DomainFamilyToFamilyMapper;", "Lcom/sputnik/domain/entities/family/DomainFamily;", "Lsputnik/axmor/com/sputnik/entities/family/Family;", "provideDomainFamilyToFamily", "(Lsputnik/axmor/com/sputnik/mappers/family/DomainFamilyToFamilyMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lsputnik/axmor/com/sputnik/mappers/company/DomainCompanyToCompanyMapper;", "Lcom/sputnik/domain/entities/company/DomainCompany;", "Lsputnik/axmor/com/sputnik/entities/company/Company;", "provideDomainCompanyToCompany", "(Lsputnik/axmor/com/sputnik/mappers/company/DomainCompanyToCompanyMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lsputnik/axmor/com/sputnik/mappers/market/subscription/DomainSubscriptionToSubscriptionMapper;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "Lcom/sputnik/common/entities/market/subscription/Subscription;", "provideDomainSubscriptionToSubscription", "(Lsputnik/axmor/com/sputnik/mappers/market/subscription/DomainSubscriptionToSubscriptionMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lsputnik/axmor/com/sputnik/mappers/market/market/DomainMarketToMarketMapper;", "Lcom/sputnik/domain/entities/market/DomainMarket;", "Lcom/sputnik/common/entities/market/market/Market;", "provideDomainMarketToMarket", "(Lsputnik/axmor/com/sputnik/mappers/market/market/DomainMarketToMarketMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lsputnik/axmor/com/sputnik/mappers/market/service/DomainServiceToServiceMapper;", "Lcom/sputnik/domain/entities/market/services/DomainService;", "Lcom/sputnik/common/entities/market/service/Service;", "provideDomainServiceToService", "(Lsputnik/axmor/com/sputnik/mappers/market/service/DomainServiceToServiceMapper;)Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/common/mappers/surveys/DomainSurveyToSurveyMapper;", "Lcom/sputnik/domain/entities/survey/DomainSurvey;", "Lcom/sputnik/common/entities/surveys/Survey;", "provideDomainSurveyToSurvey", "(Lcom/sputnik/common/mappers/surveys/DomainSurveyToSurveyMapper;)Lcom/sputnik/domain/common/ListMapper;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainListMapperModule {
    public final NullableInputListMapper<DomainSubsPlans, SubsPlans> provideDomainSubsPlansToSubsPlans(DomainSubsPlansToSubsPlansMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final ListMapper<DomainFlussonic, Flussonic> provideDomainFlussonicToFlussonic(DomainFlussonicToFlussonicMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final NullableInputListMapper<DomainSmallServices, SmallServices> provideDomainSmallServiceToSmallServices(DomainSmallServicesToSmallServicesMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new NullableInputListMapperImpl(mapper);
    }

    public final ListMapper<DomainFamily, Family> provideDomainFamilyToFamily(DomainFamilyToFamilyMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DomainCompany, Company> provideDomainCompanyToCompany(DomainCompanyToCompanyMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DomainSubscription, Subscription> provideDomainSubscriptionToSubscription(DomainSubscriptionToSubscriptionMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DomainMarket, Market> provideDomainMarketToMarket(DomainMarketToMarketMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DomainService, Service> provideDomainServiceToService(DomainServiceToServiceMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }

    public final ListMapper<DomainSurvey, Survey> provideDomainSurveyToSurvey(DomainSurveyToSurveyMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ListMapperImpl(mapper);
    }
}
