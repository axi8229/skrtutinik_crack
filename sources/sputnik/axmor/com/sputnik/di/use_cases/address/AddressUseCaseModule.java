package sputnik.axmor.com.sputnik.di.use_cases.address;

import com.sputnik.domain.repositories.address.IAddressRepository;
import com.sputnik.domain.usecases.address.DeleteCustomAddressUseCase;
import com.sputnik.domain.usecases.address.GetCustomAddressUseCase;
import com.sputnik.domain.usecases.address.SetCustomAddressUseCase;
import com.sputnik.domain.usecases.address.UpdateCustomAddressUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddressUseCaseModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/address/AddressUseCaseModule;", "", "()V", "provideDeleteCustomAddressUseCase", "Lcom/sputnik/domain/usecases/address/DeleteCustomAddressUseCase;", "repository", "Lcom/sputnik/domain/repositories/address/IAddressRepository;", "provideGetCustomAddressUseCase", "Lcom/sputnik/domain/usecases/address/GetCustomAddressUseCase;", "provideSetCustomAddressUseCase", "Lcom/sputnik/domain/usecases/address/SetCustomAddressUseCase;", "provideUpdateCustomAddressUseCase", "Lcom/sputnik/domain/usecases/address/UpdateCustomAddressUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddressUseCaseModule {
    public final GetCustomAddressUseCase provideGetCustomAddressUseCase(IAddressRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCustomAddressUseCase(repository);
    }

    public final DeleteCustomAddressUseCase provideDeleteCustomAddressUseCase(IAddressRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeleteCustomAddressUseCase(repository);
    }

    public final SetCustomAddressUseCase provideSetCustomAddressUseCase(IAddressRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SetCustomAddressUseCase(repository);
    }

    public final UpdateCustomAddressUseCase provideUpdateCustomAddressUseCase(IAddressRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new UpdateCustomAddressUseCase(repository);
    }
}
