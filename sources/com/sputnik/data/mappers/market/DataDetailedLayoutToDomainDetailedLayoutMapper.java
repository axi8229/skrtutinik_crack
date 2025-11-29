package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.DataAppearancePlans;
import com.sputnik.data.entities.market.DataDetailedLayout;
import com.sputnik.data.entities.market.DataFeatures;
import com.sputnik.data.entities.market.DataHeader;
import com.sputnik.data.entities.market.DataIncludedServices;
import com.sputnik.data.entities.subscriptions.subscriptions.DataNoticeBody;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.appearance.DomainAppearancePlans;
import com.sputnik.domain.entities.market.appearance.DomainDetailedLayout;
import com.sputnik.domain.entities.market.appearance.DomainFeatures;
import com.sputnik.domain.entities.market.appearance.DomainHeader;
import com.sputnik.domain.entities.market.appearance.DomainIncludedServices;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainNoticeBody;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataDetailedLayoutToDomainDetailedLayoutMapper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/sputnik/data/mappers/market/DataDetailedLayoutToDomainDetailedLayoutMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/DataDetailedLayout;", "Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;", "dataAppearancePlansToDomainAppearancePlansMapper", "Lcom/sputnik/data/mappers/market/DataAppearancePlansToDomainAppearancePlansMapper;", "dataIncludedServiceToDomainIncludedServiceMapper", "Lcom/sputnik/data/mappers/market/DataIncludedServiceToDomainIncludedServiceMapper;", "(Lcom/sputnik/data/mappers/market/DataAppearancePlansToDomainAppearancePlansMapper;Lcom/sputnik/data/mappers/market/DataIncludedServiceToDomainIncludedServiceMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataDetailedLayoutToDomainDetailedLayoutMapper implements Mapper<DataDetailedLayout, DomainDetailedLayout> {
    private final DataAppearancePlansToDomainAppearancePlansMapper dataAppearancePlansToDomainAppearancePlansMapper;
    private final DataIncludedServiceToDomainIncludedServiceMapper dataIncludedServiceToDomainIncludedServiceMapper;

    public DataDetailedLayoutToDomainDetailedLayoutMapper(DataAppearancePlansToDomainAppearancePlansMapper dataAppearancePlansToDomainAppearancePlansMapper, DataIncludedServiceToDomainIncludedServiceMapper dataIncludedServiceToDomainIncludedServiceMapper) {
        Intrinsics.checkNotNullParameter(dataAppearancePlansToDomainAppearancePlansMapper, "dataAppearancePlansToDomainAppearancePlansMapper");
        Intrinsics.checkNotNullParameter(dataIncludedServiceToDomainIncludedServiceMapper, "dataIncludedServiceToDomainIncludedServiceMapper");
        this.dataAppearancePlansToDomainAppearancePlansMapper = dataAppearancePlansToDomainAppearancePlansMapper;
        this.dataIncludedServiceToDomainIncludedServiceMapper = dataIncludedServiceToDomainIncludedServiceMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainDetailedLayout map(DataDetailedLayout input) {
        Intrinsics.checkNotNullParameter(input, "input");
        DataHeader header = input.getHeader();
        List<String> title = header != null ? header.getTitle() : null;
        DataHeader header2 = input.getHeader();
        DomainHeader domainHeader = new DomainHeader(title, header2 != null ? header2.getTitleHighlighted() : null);
        DataFeatures features = input.getFeatures();
        String title2 = features != null ? features.getTitle() : null;
        DataFeatures features2 = input.getFeatures();
        DomainFeatures domainFeatures = new DomainFeatures(title2, features2 != null ? features2.getList() : null);
        DataIncludedServices includedServices = input.getIncludedServices();
        DomainIncludedServices domainIncludedServicesMap2 = includedServices != null ? this.dataIncludedServiceToDomainIncludedServiceMapper.map(includedServices) : null;
        DataAppearancePlans plans = input.getPlans();
        DomainAppearancePlans domainAppearancePlansMap2 = plans != null ? this.dataAppearancePlansToDomainAppearancePlansMapper.map(plans) : null;
        DataNoticeBody notice = input.getNotice();
        return new DomainDetailedLayout(domainHeader, domainFeatures, domainIncludedServicesMap2, domainAppearancePlansMap2, new DomainNoticeBody(notice != null ? notice.getBody() : null));
    }
}
