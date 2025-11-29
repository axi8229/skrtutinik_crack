package com.sputnik.data.mappers.service_payments;

import com.sputnik.data.entities.service_payments.DataPartnerInfo;
import com.sputnik.data.entities.service_payments.DataServiceAccountInfo;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.service_payments.DomainPartnerInfo;
import com.sputnik.domain.entities.service_payments.DomainServiceAccountInfo;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataServiceAccountInfoToDomainServiceAccountInfoMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/service_payments/DataServiceAccountInfoToDomainServiceAccountInfoMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/service_payments/DataServiceAccountInfo;", "Lcom/sputnik/domain/entities/service_payments/DomainServiceAccountInfo;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataServiceAccountInfoToDomainServiceAccountInfoMapper implements Mapper<DataServiceAccountInfo, DomainServiceAccountInfo> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainServiceAccountInfo map(DataServiceAccountInfo input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String uuid = input.getUuid();
        ServicePaymentType type = input.getType();
        String number = input.getNumber();
        String fullAddress = input.getFullAddress();
        String currentDebt = input.getCurrentDebt();
        String accrualUuid = input.getAccrualUuid();
        Boolean promiseAvailable = input.getPromiseAvailable();
        String promiseExpiresAt = input.getPromiseExpiresAt();
        DataPartnerInfo partner = input.getPartner();
        String organisation = partner != null ? partner.getOrganisation() : null;
        DataPartnerInfo partner2 = input.getPartner();
        String contactPhone = partner2 != null ? partner2.getContactPhone() : null;
        DataPartnerInfo partner3 = input.getPartner();
        String address = partner3 != null ? partner3.getAddress() : null;
        DataPartnerInfo partner4 = input.getPartner();
        List<Integer> workingDays = partner4 != null ? partner4.getWorkingDays() : null;
        DataPartnerInfo partner5 = input.getPartner();
        String firstWorkingHour = partner5 != null ? partner5.getFirstWorkingHour() : null;
        DataPartnerInfo partner6 = input.getPartner();
        String lastWorkingHour = partner6 != null ? partner6.getLastWorkingHour() : null;
        DataPartnerInfo partner7 = input.getPartner();
        String weekendFirstWorkingHour = partner7 != null ? partner7.getWeekendFirstWorkingHour() : null;
        DataPartnerInfo partner8 = input.getPartner();
        return new DomainServiceAccountInfo(uuid, type, number, fullAddress, currentDebt, accrualUuid, promiseAvailable, promiseExpiresAt, new DomainPartnerInfo(organisation, contactPhone, address, workingDays, firstWorkingHour, lastWorkingHour, weekendFirstWorkingHour, partner8 != null ? partner8.getWeekendLastWorkingHour() : null), input.getLastAccruedAt(), input.getOfferAccepted());
    }
}
