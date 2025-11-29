package com.sputnik.domain.usecases.gorserv;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.gorserv.DomainGorservTicket;
import com.sputnik.domain.repositories.gorserv.IGorservRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CreateGorservTicketUseCase.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J3\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/sputnik/domain/usecases/gorserv/CreateGorservTicketUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/gorserv/IGorservRepository;", "(Lcom/sputnik/domain/repositories/gorserv/IGorservRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/gorserv/DomainGorservTicket;", "category", "", CrashHianalyticsData.MESSAGE, "phones", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CreateGorservTicketUseCase {
    private final IGorservRepository repository;

    public CreateGorservTicketUseCase(IGorservRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainGorservTicket>> invoke(String category, String message, List<String> phones) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(phones, "phones");
        return this.repository.createTicket(category, message, phones);
    }
}
