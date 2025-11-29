package sputnik.axmor.com.sputnik.mappers.market.service;

import com.sputnik.common.AndroidConstants;
import com.sputnik.common.entities.market.service.Origin;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.services.DomainOriginSub;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.services.DomainServiceAppearance;
import com.sputnik.domain.entities.market.services.OriginType;
import com.sputnik.domain.entities.market.services.ServiceState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;

/* compiled from: DomainServiceToServiceMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/mappers/market/service/DomainServiceToServiceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/market/services/DomainService;", "Lcom/sputnik/common/entities/market/service/Service;", "mapper", "Lsputnik/axmor/com/sputnik/mappers/market/service/DomainOriginToOriginMapper;", "(Lsputnik/axmor/com/sputnik/mappers/market/service/DomainOriginToOriginMapper;)V", "map", "input", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainServiceToServiceMapper implements Mapper<DomainService, Service> {
    private static final Function1<String, Integer> SERVICE_IMAGES = new Function1<String, Integer>() { // from class: sputnik.axmor.com.sputnik.mappers.market.service.DomainServiceToServiceMapper$Companion$SERVICE_IMAGES$1
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(String str) {
            int i;
            AndroidConstants.ServicesNames servicesNames = AndroidConstants.ServicesNames.INSTANCE;
            if (Intrinsics.areEqual(str, servicesNames.getFR_SUBS_IDENTIFIER())) {
                i = R.drawable.ic_face_outline;
            } else {
                i = Intrinsics.areEqual(str, servicesNames.getDIGITAL_KEY_IDENTIFIER()) ? R.drawable.ic_door_opened_outline : R.drawable.ic_archive_outline;
            }
            return Integer.valueOf(i);
        }
    };
    private final DomainOriginToOriginMapper mapper;

    public DomainServiceToServiceMapper(DomainOriginToOriginMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public Service map(DomainService input) {
        DomainServiceAppearance.DomainServiceBadge serviceBadge;
        DomainServiceAppearance.DomainServiceBadge serviceBadge2;
        Intrinsics.checkNotNullParameter(input, "input");
        DomainServiceAppearance appearance = input.getAppearance();
        String color = null;
        String title = appearance != null ? appearance.getTitle() : null;
        DomainServiceAppearance appearance2 = input.getAppearance();
        String description = appearance2 != null ? appearance2.getDescription() : null;
        Integer numInvoke = SERVICE_IMAGES.invoke(input.getServiceConfigIdentifier());
        DomainOriginSub origin = input.getOrigin();
        Boolean boolValueOf = Boolean.valueOf((origin != null ? origin.getType() : null) == OriginType.company);
        DomainOriginSub origin2 = input.getOrigin();
        Boolean boolValueOf2 = Boolean.valueOf((origin2 != null ? origin2.getType() : null) == OriginType.subscription);
        String serviceConfigIdentifier = input.getServiceConfigIdentifier();
        DomainOriginSub origin3 = input.getOrigin();
        Origin originMap2 = origin3 != null ? this.mapper.map(origin3) : null;
        ServiceState state = input.getState();
        String activatedAt = input.getActivatedAt();
        DomainServiceAppearance appearance3 = input.getAppearance();
        String title2 = (appearance3 == null || (serviceBadge2 = appearance3.getServiceBadge()) == null) ? null : serviceBadge2.getTitle();
        DomainServiceAppearance appearance4 = input.getAppearance();
        if (appearance4 != null && (serviceBadge = appearance4.getServiceBadge()) != null) {
            color = serviceBadge.getColor();
        }
        Service.Badge badge = new Service.Badge(title2, color);
        Boolean requiresSubscription = input.getRequiresSubscription();
        return new Service(title, description, numInvoke, boolValueOf, boolValueOf2, serviceConfigIdentifier, originMap2, state, activatedAt, badge, Boolean.valueOf(requiresSubscription != null ? requiresSubscription.booleanValue() : false));
    }
}
