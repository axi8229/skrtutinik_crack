package sputnik.axmor.com.sputnik.di.use_cases.address;

import com.sputnik.domain.repositories.address.IAddressRepository;
import com.sputnik.domain.usecases.address.GetCustomAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class AddressUseCaseModule_ProvideGetCustomAddressUseCaseFactory implements Factory<GetCustomAddressUseCase> {
    public static GetCustomAddressUseCase provideGetCustomAddressUseCase(AddressUseCaseModule addressUseCaseModule, IAddressRepository iAddressRepository) {
        return (GetCustomAddressUseCase) Preconditions.checkNotNullFromProvides(addressUseCaseModule.provideGetCustomAddressUseCase(iAddressRepository));
    }
}
