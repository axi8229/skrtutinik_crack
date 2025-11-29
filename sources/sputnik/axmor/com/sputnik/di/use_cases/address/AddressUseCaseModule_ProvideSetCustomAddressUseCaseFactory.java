package sputnik.axmor.com.sputnik.di.use_cases.address;

import com.sputnik.domain.repositories.address.IAddressRepository;
import com.sputnik.domain.usecases.address.SetCustomAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class AddressUseCaseModule_ProvideSetCustomAddressUseCaseFactory implements Factory<SetCustomAddressUseCase> {
    public static SetCustomAddressUseCase provideSetCustomAddressUseCase(AddressUseCaseModule addressUseCaseModule, IAddressRepository iAddressRepository) {
        return (SetCustomAddressUseCase) Preconditions.checkNotNullFromProvides(addressUseCaseModule.provideSetCustomAddressUseCase(iAddressRepository));
    }
}
