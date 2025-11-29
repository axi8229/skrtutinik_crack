package sputnik.axmor.com.sputnik.di.use_cases.digital_keys;

import com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository;
import com.sputnik.domain.usecases.digital_keys.DeleteDigitalKeyForAddressUseCase;
import com.sputnik.domain.usecases.digital_keys.GetDigitalKeysForAddressUseCase;
import com.sputnik.domain.usecases.digital_keys.SetDigitalKeyForAddressUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalKeysUseCaseModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/digital_keys/DigitalKeysUseCaseModule;", "", "<init>", "()V", "Lcom/sputnik/domain/repositories/digital_keys/IDigitalKeysRepository;", "repository", "Lcom/sputnik/domain/usecases/digital_keys/DeleteDigitalKeyForAddressUseCase;", "provideDeleteDigitalForAddressKeyUseCase", "(Lcom/sputnik/domain/repositories/digital_keys/IDigitalKeysRepository;)Lcom/sputnik/domain/usecases/digital_keys/DeleteDigitalKeyForAddressUseCase;", "Lcom/sputnik/domain/usecases/digital_keys/GetDigitalKeysForAddressUseCase;", "provideGetDigitalKeysForAddressUseCase", "(Lcom/sputnik/domain/repositories/digital_keys/IDigitalKeysRepository;)Lcom/sputnik/domain/usecases/digital_keys/GetDigitalKeysForAddressUseCase;", "Lcom/sputnik/domain/usecases/digital_keys/SetDigitalKeyForAddressUseCase;", "provideSetDigitalKeyForAddressUseCase", "(Lcom/sputnik/domain/repositories/digital_keys/IDigitalKeysRepository;)Lcom/sputnik/domain/usecases/digital_keys/SetDigitalKeyForAddressUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DigitalKeysUseCaseModule {
    public final DeleteDigitalKeyForAddressUseCase provideDeleteDigitalForAddressKeyUseCase(IDigitalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeleteDigitalKeyForAddressUseCase(repository);
    }

    public final GetDigitalKeysForAddressUseCase provideGetDigitalKeysForAddressUseCase(IDigitalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetDigitalKeysForAddressUseCase(repository);
    }

    public final SetDigitalKeyForAddressUseCase provideSetDigitalKeyForAddressUseCase(IDigitalKeysRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SetDigitalKeyForAddressUseCase(repository);
    }
}
