package com.sputnik.domain.repositories.country_code;

import com.sputnik.domain.entities.county_code.DomainCountryCode;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ICountryCodeRepository.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/repositories/country_code/ICountryCodeRepository;", "", "getCodes", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICountryCodeRepository {
    Flow<List<DomainCountryCode>> getCodes();
}
