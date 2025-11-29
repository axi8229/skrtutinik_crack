package sputnik.axmor.com.sputnik.di.use_cases.digital_keys;

import com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository;
import com.sputnik.domain.usecases.digital_keys.GetDigitalKeysForAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class DigitalKeysUseCaseModule_ProvideGetDigitalKeysForAddressUseCaseFactory implements Factory<GetDigitalKeysForAddressUseCase> {
    public static GetDigitalKeysForAddressUseCase provideGetDigitalKeysForAddressUseCase(DigitalKeysUseCaseModule digitalKeysUseCaseModule, IDigitalKeysRepository iDigitalKeysRepository) {
        return (GetDigitalKeysForAddressUseCase) Preconditions.checkNotNullFromProvides(digitalKeysUseCaseModule.provideGetDigitalKeysForAddressUseCase(iDigitalKeysRepository));
    }
}
