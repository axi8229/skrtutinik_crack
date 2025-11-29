package com.sputnik.data.mappers.profile;

import com.sputnik.data.entities.profile.DataProfileCardInfo;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.profile.DomainProfileCardInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataProfileCardInfoToDomainProfileCardInfoMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/profile/DataProfileCardInfoToDomainProfileCardInfoMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/profile/DataProfileCardInfo;", "Lcom/sputnik/domain/entities/profile/DomainProfileCardInfo;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataProfileCardInfoToDomainProfileCardInfoMapper implements Mapper<DataProfileCardInfo, DomainProfileCardInfo> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainProfileCardInfo map(DataProfileCardInfo input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String first6 = input.getFirst6();
        String last4 = input.getLast4();
        String expiryMonth = input.getExpiryMonth();
        String expiryYear = input.getExpiryYear();
        String cardType = input.getCardType();
        String issuerCountry = input.getIssuerCountry();
        if (issuerCountry == null) {
            issuerCountry = "";
        }
        return new DomainProfileCardInfo(first6, last4, expiryMonth, expiryYear, cardType, issuerCountry, input.getIssuerName());
    }
}
