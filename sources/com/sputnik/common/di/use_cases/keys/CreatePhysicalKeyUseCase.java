package com.sputnik.common.di.use_cases.keys;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.keys.DomainPhysicalKey;
import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CreatePhysicalKeyUseCase.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/sputnik/common/di/use_cases/keys/CreatePhysicalKeyUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/keys/IPhysicalKeysRepository;", "(Lcom/sputnik/domain/repositories/keys/IPhysicalKeysRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/keys/DomainPhysicalKey;", "addressId", "", "hex", "", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CreatePhysicalKeyUseCase {
    private final IPhysicalKeysRepository repository;

    public CreatePhysicalKeyUseCase(IPhysicalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainPhysicalKey>> invoke(int addressId, String hex, String comment) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        Intrinsics.checkNotNullParameter(comment, "comment");
        return this.repository.createKey(addressId, hex, comment);
    }
}
