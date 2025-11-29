package sputnik.axmor.com.sputnik.mappers.market.service;

import com.sputnik.common.AndroidConstants;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.market.market.Badge;
import com.sputnik.common.entities.market.service.Origin;
import com.sputnik.common.entities.subscriptions.services.ServiceAppearance;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.services.DomainOriginSub;
import com.sputnik.domain.entities.market.services.OriginType;
import com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBadge;
import com.sputnik.domain.utils.DateUtilsKt;
import java.text.ParseException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainOriginToOriginMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/mappers/market/service/DomainOriginToOriginMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/market/services/DomainOriginSub;", "Lcom/sputnik/common/entities/market/service/Origin;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "map", "input", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainOriginToOriginMapper implements Mapper<DomainOriginSub, Origin> {
    private final LocalizationStorage localizationStorage;

    public DomainOriginToOriginMapper(LocalizationStorage localizationStorage) {
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        this.localizationStorage = localizationStorage;
    }

    @Override // com.sputnik.domain.common.Mapper
    public Origin map(DomainOriginSub input) throws ParseException {
        String dMYFormat;
        DomainBadge badge;
        DomainBadge badge2;
        String phoneLocale;
        Intrinsics.checkNotNullParameter(input, "input");
        String productId = input.getProductId();
        String title = input.getTitle();
        OriginType type = input.getType();
        String fullExpires = input.getFullExpires();
        String color = null;
        if (fullExpires != null) {
            LocalizationLocalModel data = this.localizationStorage.getData();
            if (data == null || (phoneLocale = data.getTag()) == null) {
                phoneLocale = AndroidConstants.INSTANCE.getPhoneLocale();
            }
            dMYFormat = DateUtilsKt.toDMYFormat(fullExpires, phoneLocale);
        } else {
            dMYFormat = null;
        }
        String phone = input.getPhone();
        String website = input.getWebsite();
        DomainServiceAppearance appearance = input.getAppearance();
        String description = appearance != null ? appearance.getDescription() : null;
        DomainServiceAppearance appearance2 = input.getAppearance();
        String description2 = appearance2 != null ? appearance2.getDescription() : null;
        DomainServiceAppearance appearance3 = input.getAppearance();
        String description3 = appearance3 != null ? appearance3.getDescription() : null;
        DomainServiceAppearance appearance4 = input.getAppearance();
        String title2 = appearance4 != null ? appearance4.getTitle() : null;
        DomainServiceAppearance appearance5 = input.getAppearance();
        String title3 = (appearance5 == null || (badge2 = appearance5.getBadge()) == null) ? null : badge2.getTitle();
        DomainServiceAppearance appearance6 = input.getAppearance();
        if (appearance6 != null && (badge = appearance6.getBadge()) != null) {
            color = badge.getColor();
        }
        return new Origin(productId, title, type, dMYFormat, phone, website, new ServiceAppearance(description, description2, description3, title2, new Badge(title3, color)));
    }
}
