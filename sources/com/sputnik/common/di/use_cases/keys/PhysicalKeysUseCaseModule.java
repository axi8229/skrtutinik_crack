package com.sputnik.common.di.use_cases.keys;

import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhysicalKeysUseCaseModule.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0011"}, d2 = {"Lcom/sputnik/common/di/use_cases/keys/PhysicalKeysUseCaseModule;", "", "()V", "provideBlockPhysicalKeyUseCase", "Lcom/sputnik/common/di/use_cases/keys/BlockPhysicalKeyUseCase;", "repository", "Lcom/sputnik/domain/repositories/keys/IPhysicalKeysRepository;", "provideCreatePhysicalKeyUseCase", "Lcom/sputnik/common/di/use_cases/keys/CreatePhysicalKeyUseCase;", "provideDeletePhysicalKeyUseCase", "Lcom/sputnik/common/di/use_cases/keys/DeletePhysicalKeyUseCase;", "provideGetPhysicalKeysUseCase", "Lcom/sputnik/common/di/use_cases/keys/GetPhysicalKeysUseCase;", "provideUnblockPhysicalKeyUseCase", "Lcom/sputnik/common/di/use_cases/keys/UnblockPhysicalKeyUseCase;", "provideUpdatePhysicalKeyCommentUseCase", "Lcom/sputnik/common/di/use_cases/keys/UpdatePhysicalKeyCommentUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PhysicalKeysUseCaseModule {
    public final GetPhysicalKeysUseCase provideGetPhysicalKeysUseCase(IPhysicalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetPhysicalKeysUseCase(repository);
    }

    public final CreatePhysicalKeyUseCase provideCreatePhysicalKeyUseCase(IPhysicalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new CreatePhysicalKeyUseCase(repository);
    }

    public final BlockPhysicalKeyUseCase provideBlockPhysicalKeyUseCase(IPhysicalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new BlockPhysicalKeyUseCase(repository);
    }

    public final UnblockPhysicalKeyUseCase provideUnblockPhysicalKeyUseCase(IPhysicalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new UnblockPhysicalKeyUseCase(repository);
    }

    public final DeletePhysicalKeyUseCase provideDeletePhysicalKeyUseCase(IPhysicalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeletePhysicalKeyUseCase(repository);
    }

    public final UpdatePhysicalKeyCommentUseCase provideUpdatePhysicalKeyCommentUseCase(IPhysicalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new UpdatePhysicalKeyCommentUseCase(repository);
    }
}
