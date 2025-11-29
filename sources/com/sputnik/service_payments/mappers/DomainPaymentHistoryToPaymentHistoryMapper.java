package com.sputnik.service_payments.mappers;

import com.sputnik.common.AndroidConstants;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import com.sputnik.domain.entities.service_payments.ServicePaymentState;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import com.sputnik.domain.utils.DateUtilsKt;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import java.text.ParseException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPaymentHistoryToPaymentHistoryMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/service_payments/mappers/DomainPaymentHistoryToPaymentHistoryMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "map", "input", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainPaymentHistoryToPaymentHistoryMapper implements Mapper<DomainPaymentHistory, PaymentHistory> {
    private final LocalizationStorage localizationStorage;

    public DomainPaymentHistoryToPaymentHistoryMapper(LocalizationStorage localizationStorage) {
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        this.localizationStorage = localizationStorage;
    }

    @Override // com.sputnik.domain.common.Mapper
    public PaymentHistory map(DomainPaymentHistory input) throws ParseException {
        String dMMYFormat;
        String phoneLocale;
        Intrinsics.checkNotNullParameter(input, "input");
        String id = input.getId();
        ServicePaymentType type = input.getType();
        String paymentDate = input.getPaymentDate();
        if (paymentDate != null) {
            LocalizationLocalModel data = this.localizationStorage.getData();
            if (data == null || (phoneLocale = data.getTag()) == null) {
                phoneLocale = AndroidConstants.INSTANCE.getPhoneLocale();
            }
            dMMYFormat = DateUtilsKt.toDMMYFormat(paymentDate, phoneLocale);
        } else {
            dMMYFormat = null;
        }
        String str = dMMYFormat;
        String amount = input.getAmount();
        ServicePaymentState state = input.getState();
        String payUntil = input.getPayUntil();
        String paymentDate2 = input.getPaymentDate();
        return new PaymentHistory(id, type, amount, state, str, payUntil, paymentDate2 != null ? DateUtilsKt.toNanoFormat(paymentDate2) : 0L);
    }
}
