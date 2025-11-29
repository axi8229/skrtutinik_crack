package sputnik.axmor.com.sputnik.di.use_cases.address;

import com.sputnik.domain.repositories.address.IAddressRepository;
import com.sputnik.domain.usecases.address.UpdateCustomAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class AddressUseCaseModule_ProvideUpdateCustomAddressUseCaseFactory implements Factory<UpdateCustomAddressUseCase> {
    public static UpdateCustomAddressUseCase provideUpdateCustomAddressUseCase(AddressUseCaseModule addressUseCaseModule, IAddressRepository iAddressRepository) {
        return (UpdateCustomAddressUseCase) Preconditions.checkNotNullFromProvides(addressUseCaseModule.provideUpdateCustomAddressUseCase(iAddressRepository));
    }
}
