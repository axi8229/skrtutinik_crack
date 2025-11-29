package sputnik.axmor.com.sputnik.di.use_cases.address;

import com.sputnik.domain.repositories.address.IAddressRepository;
import com.sputnik.domain.usecases.address.DeleteCustomAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class AddressUseCaseModule_ProvideDeleteCustomAddressUseCaseFactory implements Factory<DeleteCustomAddressUseCase> {
    public static DeleteCustomAddressUseCase provideDeleteCustomAddressUseCase(AddressUseCaseModule addressUseCaseModule, IAddressRepository iAddressRepository) {
        return (DeleteCustomAddressUseCase) Preconditions.checkNotNullFromProvides(addressUseCaseModule.provideDeleteCustomAddressUseCase(iAddressRepository));
    }
}
