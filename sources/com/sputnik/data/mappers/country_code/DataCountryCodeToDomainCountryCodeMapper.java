package com.sputnik.data.mappers.country_code;

import com.sputnik.data.entities.country_code.DataCountryCode;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCountryCodeToDomainCountryCodeMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/country_code/DataCountryCodeToDomainCountryCodeMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/country_code/DataCountryCode;", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCountryCodeToDomainCountryCodeMapper implements Mapper<DataCountryCode, DomainCountryCode> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainCountryCode map(DataCountryCode input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new DomainCountryCode(input.getName(), input.getCode(), input.getIsoCode());
    }
}
