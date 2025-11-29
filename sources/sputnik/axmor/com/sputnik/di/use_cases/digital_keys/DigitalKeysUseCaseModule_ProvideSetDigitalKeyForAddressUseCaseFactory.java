package sputnik.axmor.com.sputnik.di.use_cases.digital_keys;

import com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository;
import com.sputnik.domain.usecases.digital_keys.SetDigitalKeyForAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class DigitalKeysUseCaseModule_ProvideSetDigitalKeyForAddressUseCaseFactory implements Factory<SetDigitalKeyForAddressUseCase> {
    public static SetDigitalKeyForAddressUseCase provideSetDigitalKeyForAddressUseCase(DigitalKeysUseCaseModule digitalKeysUseCaseModule, IDigitalKeysRepository iDigitalKeysRepository) {
        return (SetDigitalKeyForAddressUseCase) Preconditions.checkNotNullFromProvides(digitalKeysUseCaseModule.provideSetDigitalKeyForAddressUseCase(iDigitalKeysRepository));
    }
}
