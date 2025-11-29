package com.sputnik.domain.repositories.registration;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.connect_intercom.DomainActivationCode;
import com.sputnik.domain.entities.entry.DomainEntry;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IConnectIntercomRepository.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001e\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/sputnik/domain/repositories/registration/IConnectIntercomRepository;", "", "connectToIntercom", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/connect_intercom/DomainActivationCode;", "loadEntry", "Lcom/sputnik/domain/entities/entry/DomainEntry;", "entryUUID", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IConnectIntercomRepository {
    Flow<Resource<DomainActivationCode>> connectToIntercom();

    Flow<Resource<DomainEntry>> loadEntry(String entryUUID);
}
