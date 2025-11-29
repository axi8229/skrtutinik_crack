package com.sputnik.domain.repositories.gorserv;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.gorserv.DomainGorservCatalog;
import com.sputnik.domain.entities.gorserv.DomainGorservTicket;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IGorservRepository.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH&J:\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n0\u00040\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H&¨\u0006\u0012"}, d2 = {"Lcom/sputnik/domain/repositories/gorserv/IGorservRepository;", "", "createTicket", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/gorserv/DomainGorservTicket;", "category", "", CrashHianalyticsData.MESSAGE, "phones", "", "getGorservCatalog", "Lcom/sputnik/domain/entities/gorserv/DomainGorservCatalog;", "version", "", "platform", "app", "locale", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IGorservRepository {
    Flow<Resource<DomainGorservTicket>> createTicket(String category, String message, List<String> phones);

    Flow<Resource<List<DomainGorservCatalog>>> getGorservCatalog(int version, String platform, String app, String locale);
}
