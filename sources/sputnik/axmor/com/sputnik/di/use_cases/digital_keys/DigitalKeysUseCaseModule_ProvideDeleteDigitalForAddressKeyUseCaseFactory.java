package sputnik.axmor.com.sputnik.di.use_cases.digital_keys;

import com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository;
import com.sputnik.domain.usecases.digital_keys.DeleteDigitalKeyForAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class DigitalKeysUseCaseModule_ProvideDeleteDigitalForAddressKeyUseCaseFactory implements Factory<DeleteDigitalKeyForAddressUseCase> {
    public static DeleteDigitalKeyForAddressUseCase provideDeleteDigitalForAddressKeyUseCase(DigitalKeysUseCaseModule digitalKeysUseCaseModule, IDigitalKeysRepository iDigitalKeysRepository) {
        return (DeleteDigitalKeyForAddressUseCase) Preconditions.checkNotNullFromProvides(digitalKeysUseCaseModule.provideDeleteDigitalForAddressKeyUseCase(iDigitalKeysRepository));
    }
}
