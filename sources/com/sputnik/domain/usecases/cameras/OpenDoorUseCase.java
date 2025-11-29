package com.sputnik.domain.usecases.cameras;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.door.OpenDoorProducers;
import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: OpenDoorUseCase.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J;\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;", "(Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "uuid", "", "isWidget", "", "producer", "Lcom/sputnik/domain/entities/door/OpenDoorProducers;", "addressId", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OpenDoorUseCase {
    private final ICamerasRepository repository;

    public OpenDoorUseCase(ICamerasRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public static /* synthetic */ Flow invoke$default(OpenDoorUseCase openDoorUseCase, String str, boolean z, OpenDoorProducers openDoorProducers, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return openDoorUseCase.invoke(str, z, openDoorProducers, str2);
    }

    public final Flow<Resource<Unit>> invoke(String uuid, boolean isWidget, OpenDoorProducers producer, String addressId) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(producer, "producer");
        return this.repository.openDoor(uuid, isWidget, producer, addressId);
    }
}
