package com.sputnik.domain.repositories.support;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.faq.DomainFaqObject;
import com.sputnik.domain.entities.support.DomainAnnounce;
import com.sputnik.domain.entities.support.DomainCompanyContacts;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ISupportRepository.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/sputnik/domain/repositories/support/ISupportRepository;", "", "", "locale", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/faq/DomainFaqObject;", "getFaq", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "addressId", "Lcom/sputnik/domain/entities/support/DomainCompanyContacts;", "getCompanyContacts", "(I)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/entities/support/DomainAnnounce;", "getAnnounce", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ISupportRepository {
    Flow<Resource<DomainAnnounce>> getAnnounce(String locale);

    Flow<Resource<DomainCompanyContacts>> getCompanyContacts(int addressId);

    Flow<Resource<List<DomainFaqObject>>> getFaq(String locale);
}
