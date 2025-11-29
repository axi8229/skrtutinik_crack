package com.sputnik.oboarding.ui.registration.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.entry.DomainEntry;
import com.sputnik.domain.usecases.entry.GetEntryUseCase;
import com.sputnik.oboarding.mappers.entry.DomainEntryToEntryMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EntryViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/viewmodel/EntryViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/oboarding/ui/registration/viewmodel/EntryViewState;", "", "Lcom/sputnik/domain/usecases/entry/GetEntryUseCase;", "getEntryUseCase", "Lcom/sputnik/oboarding/mappers/entry/DomainEntryToEntryMapper;", "domainEntryToEntryMapper", "<init>", "(Lcom/sputnik/domain/usecases/entry/GetEntryUseCase;Lcom/sputnik/oboarding/mappers/entry/DomainEntryToEntryMapper;)V", "", "entryUUID", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/entry/DomainEntry;", "getEntryFromServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "loadEntry", "(Ljava/lang/String;)V", "Lcom/sputnik/domain/usecases/entry/GetEntryUseCase;", "Lcom/sputnik/oboarding/mappers/entry/DomainEntryToEntryMapper;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EntryViewModel extends BaseViewModel<EntryViewState> {
    private final DomainEntryToEntryMapper domainEntryToEntryMapper;
    private final GetEntryUseCase getEntryUseCase;

    public EntryViewModel(GetEntryUseCase getEntryUseCase, DomainEntryToEntryMapper domainEntryToEntryMapper) {
        Intrinsics.checkNotNullParameter(getEntryUseCase, "getEntryUseCase");
        Intrinsics.checkNotNullParameter(domainEntryToEntryMapper, "domainEntryToEntryMapper");
        EntryViewState entryViewState = new EntryViewState(null, null, 3, null);
        String name = EntryViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(entryViewState, name);
        this.getEntryUseCase = getEntryUseCase;
        this.domainEntryToEntryMapper = domainEntryToEntryMapper;
    }

    private final LiveData<Resource<DomainEntry>> getEntryFromServer(String entryUUID) {
        return FlowLiveDataConversions.asLiveData$default(this.getEntryUseCase.invoke(entryUUID), null, 0L, 3, null);
    }

    public void loadEntry(String entryUUID) {
        subscribeOnDataSource(getEntryFromServer(entryUUID), new Function2<Resource<? extends DomainEntry>, EntryViewState, EntryViewState>() { // from class: com.sputnik.oboarding.ui.registration.viewmodel.EntryViewModel.loadEntry.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ EntryViewState invoke(Resource<? extends DomainEntry> resource, EntryViewState entryViewState) {
                return invoke2((Resource<DomainEntry>) resource, entryViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final EntryViewState invoke2(Resource<DomainEntry> serverData, EntryViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                Resource.Status status = serverData.getStatus();
                Resource.Status status2 = Resource.Status.SUCCESS;
                if (status != status2) {
                    return null;
                }
                DomainEntryToEntryMapper domainEntryToEntryMapper = EntryViewModel.this.domainEntryToEntryMapper;
                DomainEntry data = serverData.getData();
                Intrinsics.checkNotNull(data);
                return state.copy(status2, domainEntryToEntryMapper.map(data));
            }
        });
    }
}
