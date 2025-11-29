package sputnik.axmor.com.sputnik.di.use_cases.call_history;

import androidx.paging.PagingData;
import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.DomainCall;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import com.sputnik.domain.repositories.call_history.ICallHistoryRepository;
import com.sputnik.domain.usecases.call_history.DeleteCallFromHistoryUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DeleteCallHistoryUseCase.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/call_history/DeleteCallHistoryUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;", "Landroidx/paging/PagingData;", "Lcom/sputnik/domain/entities/call_history/DomainCallHistory;", "(Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;)V", "useCase", "Lcom/sputnik/domain/usecases/call_history/DeleteCallFromHistoryUseCase;", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/call/DomainCall;", FailedBinderCallBack.CALLER_ID, "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteCallHistoryUseCase {
    private final DeleteCallFromHistoryUseCase<PagingData<DomainCallHistory>> useCase;

    public DeleteCallHistoryUseCase(ICallHistoryRepository<PagingData<DomainCallHistory>> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.useCase = new DeleteCallFromHistoryUseCase<>(repository);
    }

    public final Flow<Resource<DomainCall>> invoke(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        return this.useCase.invoke(callId);
    }
}
