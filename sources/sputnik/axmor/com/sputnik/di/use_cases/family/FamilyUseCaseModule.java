package sputnik.axmor.com.sputnik.di.use_cases.family;

import com.sputnik.domain.repositories.family.IFamilyRepository;
import com.sputnik.domain.usecases.family.DeleteFromFamilyUseCase;
import com.sputnik.domain.usecases.family.GetFamilyUseCase;
import com.sputnik.domain.usecases.family.MakeAdminUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FamilyUseCaseModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/family/FamilyUseCaseModule;", "", "()V", "provideDeleteFromFamilyUseCase", "Lcom/sputnik/domain/usecases/family/DeleteFromFamilyUseCase;", "repository", "Lcom/sputnik/domain/repositories/family/IFamilyRepository;", "provideGetFamilyUseCase", "Lcom/sputnik/domain/usecases/family/GetFamilyUseCase;", "provideMakeAdminUseCase", "Lcom/sputnik/domain/usecases/family/MakeAdminUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyUseCaseModule {
    public final DeleteFromFamilyUseCase provideDeleteFromFamilyUseCase(IFamilyRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeleteFromFamilyUseCase(repository);
    }

    public final GetFamilyUseCase provideGetFamilyUseCase(IFamilyRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetFamilyUseCase(repository);
    }

    public final MakeAdminUseCase provideMakeAdminUseCase(IFamilyRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new MakeAdminUseCase(repository);
    }
}
