package sputnik.axmor.com.sputnik.mappers.company;

import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.company.DomainCompany;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.company.Company;

/* compiled from: DomainCompanyToCompanyMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/mappers/company/DomainCompanyToCompanyMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/company/DomainCompany;", "Lsputnik/axmor/com/sputnik/entities/company/Company;", "()V", "map", "input", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainCompanyToCompanyMapper implements Mapper<DomainCompany, Company> {
    @Override // com.sputnik.domain.common.Mapper
    public Company map(DomainCompany input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new Company(input.getTitle(), input.getDescription(), input.getPhone(), input.getWebsite(), input.getImg());
    }
}
