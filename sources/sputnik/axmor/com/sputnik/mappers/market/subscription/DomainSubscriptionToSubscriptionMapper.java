package sputnik.axmor.com.sputnik.mappers.market.subscription;

import com.sputnik.common.AndroidConstants;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.market.market.Badge;
import com.sputnik.common.entities.market.subscription.ActivePlan;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.appearance.DomainBadgeStyle;
import com.sputnik.domain.entities.market.appearance.DomainPlanAppearance;
import com.sputnik.domain.entities.market.services.ServiceState;
import com.sputnik.domain.entities.market.subscription.DomainPlans;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionAppearance;
import com.sputnik.domain.utils.DateUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainSubscriptionToSubscriptionMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/mappers/market/subscription/DomainSubscriptionToSubscriptionMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "Lcom/sputnik/common/entities/market/subscription/Subscription;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "map", "input", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainSubscriptionToSubscriptionMapper implements Mapper<DomainSubscription, Subscription> {
    private final LocalizationStorage localizationStorage;

    public DomainSubscriptionToSubscriptionMapper(LocalizationStorage localizationStorage) {
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        this.localizationStorage = localizationStorage;
    }

    @Override // com.sputnik.domain.common.Mapper
    public Subscription map(DomainSubscription input) {
        String phoneLocale;
        ActivePlan activePlan;
        DomainPlanAppearance appearance;
        DomainPlanAppearance appearance2;
        DomainBadgeStyle badge;
        DomainBadgeStyle badge2;
        DomainPlanAppearance appearance3;
        Intrinsics.checkNotNullParameter(input, "input");
        LocalizationLocalModel data = this.localizationStorage.getData();
        if (data == null || (phoneLocale = data.getTag()) == null) {
            phoneLocale = AndroidConstants.INSTANCE.getPhoneLocale();
        }
        DomainSubscriptionAppearance appearance4 = input.getAppearance();
        String color = null;
        String title = appearance4 != null ? appearance4.getTitle() : null;
        DomainSubscriptionAppearance appearance5 = input.getAppearance();
        String description = appearance5 != null ? appearance5.getDescription() : null;
        Boolean canManage = input.getCanManage();
        ServiceState state = input.getState();
        Boolean primeSubscription = input.getPrimeSubscription();
        String expiresDate = input.getExpiresDate();
        String dMYFormat = expiresDate != null ? DateUtilsKt.toDMYFormat(expiresDate, phoneLocale) : null;
        DomainPlans activePlan2 = input.getActivePlan();
        if (((activePlan2 == null || (appearance3 = activePlan2.getAppearance()) == null) ? null : appearance3.getPlanTitle()) == null) {
            activePlan = null;
        } else {
            DomainPlans activePlan3 = input.getActivePlan();
            String planTitle = (activePlan3 == null || (appearance2 = activePlan3.getAppearance()) == null) ? null : appearance2.getPlanTitle();
            DomainPlans activePlan4 = input.getActivePlan();
            activePlan = new ActivePlan(planTitle, (activePlan4 == null || (appearance = activePlan4.getAppearance()) == null) ? null : appearance.getPriceVerbose());
        }
        Double refund = input.getRefund();
        String string = refund != null ? refund.toString() : null;
        String productId = input.getProductId();
        DomainSubscriptionAppearance appearance6 = input.getAppearance();
        String title2 = (appearance6 == null || (badge2 = appearance6.getBadge()) == null) ? null : badge2.getTitle();
        DomainSubscriptionAppearance appearance7 = input.getAppearance();
        if (appearance7 != null && (badge = appearance7.getBadge()) != null) {
            color = badge.getColor();
        }
        return new Subscription(title, description, canManage, state, primeSubscription, dMYFormat, activePlan, string, productId, new Badge(title2, color), input.getDuration(), input.getAutoRenewStatus());
    }
}
