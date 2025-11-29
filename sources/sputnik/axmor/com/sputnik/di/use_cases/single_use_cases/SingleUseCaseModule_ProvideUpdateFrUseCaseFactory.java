package sputnik.axmor.com.sputnik.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.fr_service.IFrServiceRepository;
import com.sputnik.domain.usecases.fr_service.UpdateFrUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.MultipartBody;

/* loaded from: classes5.dex */
public final class SingleUseCaseModule_ProvideUpdateFrUseCaseFactory implements Factory<UpdateFrUseCase<MultipartBody.Part>> {
    public static UpdateFrUseCase<MultipartBody.Part> provideUpdateFrUseCase(SingleUseCaseModule singleUseCaseModule, IFrServiceRepository<MultipartBody.Part> iFrServiceRepository) {
        return (UpdateFrUseCase) Preconditions.checkNotNullFromProvides(singleUseCaseModule.provideUpdateFrUseCase(iFrServiceRepository));
    }
}
