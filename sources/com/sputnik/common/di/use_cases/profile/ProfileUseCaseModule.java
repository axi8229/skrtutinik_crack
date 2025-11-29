package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.BindToFlatUseCase;
import com.sputnik.domain.usecases.profile.ChangeAvatarUseCase;
import com.sputnik.domain.usecases.profile.DeactivateAccountUseCase;
import com.sputnik.domain.usecases.profile.DeactivateAddressUseCase;
import com.sputnik.domain.usecases.profile.DeleteAccountUseCase;
import com.sputnik.domain.usecases.profile.DeleteFrUseCase;
import com.sputnik.domain.usecases.profile.GetProfileUseCase;
import com.sputnik.domain.usecases.profile.LogoutUseCase;
import com.sputnik.domain.usecases.profile.ResetAddressUseCase;
import com.sputnik.domain.usecases.profile.SendCallEnabledUseCase;
import com.sputnik.domain.usecases.profile.SendPushTokenUseCase;
import com.sputnik.domain.usecases.profile.SendTimezoneUseCase;
import com.sputnik.domain.usecases.profile.SetLocalizationUseCase;
import com.sputnik.domain.usecases.profile.UnlinkAddressUseCase;
import com.sputnik.domain.usecases.profile.UpdateUseNameUseCase;
import com.sputnik.domain.usecases.profile.VerifyAddressUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileUseCaseModule.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006%"}, d2 = {"Lcom/sputnik/common/di/use_cases/profile/ProfileUseCaseModule;", "", "()V", "provideBindToFlatUseCase", "Lcom/sputnik/domain/usecases/profile/BindToFlatUseCase;", "repository", "Lcom/sputnik/domain/repositories/profile/IProfileRepository;", "provideChangeAvatarUseCase", "Lcom/sputnik/domain/usecases/profile/ChangeAvatarUseCase;", "provideDeactivateAccountUseCase", "Lcom/sputnik/domain/usecases/profile/DeactivateAccountUseCase;", "provideDeactivateAddressUseCase", "Lcom/sputnik/domain/usecases/profile/DeactivateAddressUseCase;", "provideDeleteAccountUseCase", "Lcom/sputnik/domain/usecases/profile/DeleteAccountUseCase;", "provideDeleteFrUseCase", "Lcom/sputnik/domain/usecases/profile/DeleteFrUseCase;", "provideGetProfileUseCase", "Lcom/sputnik/domain/usecases/profile/GetProfileUseCase;", "provideLogoutUseCase", "Lcom/sputnik/domain/usecases/profile/LogoutUseCase;", "provideResetAddressUseCase", "Lcom/sputnik/domain/usecases/profile/ResetAddressUseCase;", "provideSendCallEnabledUseCase", "Lcom/sputnik/domain/usecases/profile/SendCallEnabledUseCase;", "provideSendPushTokenUseCase", "Lcom/sputnik/domain/usecases/profile/SendPushTokenUseCase;", "provideSendTimezoneUseCase", "Lcom/sputnik/domain/usecases/profile/SendTimezoneUseCase;", "provideSetLocalizationUseCase", "Lcom/sputnik/domain/usecases/profile/SetLocalizationUseCase;", "provideUnlinkAddressUseCase", "Lcom/sputnik/domain/usecases/profile/UnlinkAddressUseCase;", "provideUpdateUseNameUseCase", "Lcom/sputnik/domain/usecases/profile/UpdateUseNameUseCase;", "provideVerifyAddressUseCase", "Lcom/sputnik/domain/usecases/profile/VerifyAddressUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProfileUseCaseModule {
    public final VerifyAddressUseCase provideVerifyAddressUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new VerifyAddressUseCase(repository);
    }

    public final DeactivateAddressUseCase provideDeactivateAddressUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeactivateAddressUseCase(repository);
    }

    public final UnlinkAddressUseCase provideUnlinkAddressUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new UnlinkAddressUseCase(repository);
    }

    public final BindToFlatUseCase provideBindToFlatUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new BindToFlatUseCase(repository);
    }

    public final ChangeAvatarUseCase provideChangeAvatarUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ChangeAvatarUseCase(repository);
    }

    public final DeactivateAccountUseCase provideDeactivateAccountUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeactivateAccountUseCase(repository);
    }

    public final DeleteAccountUseCase provideDeleteAccountUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeleteAccountUseCase(repository);
    }

    public final DeleteFrUseCase provideDeleteFrUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new DeleteFrUseCase(repository);
    }

    public final GetProfileUseCase provideGetProfileUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetProfileUseCase(repository);
    }

    public final LogoutUseCase provideLogoutUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new LogoutUseCase(repository);
    }

    public final SendCallEnabledUseCase provideSendCallEnabledUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SendCallEnabledUseCase(repository);
    }

    public final SendPushTokenUseCase provideSendPushTokenUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SendPushTokenUseCase(repository);
    }

    public final SendTimezoneUseCase provideSendTimezoneUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SendTimezoneUseCase(repository);
    }

    public final SetLocalizationUseCase provideSetLocalizationUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SetLocalizationUseCase(repository);
    }

    public final UpdateUseNameUseCase provideUpdateUseNameUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new UpdateUseNameUseCase(repository);
    }

    public final ResetAddressUseCase provideResetAddressUseCase(IProfileRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new ResetAddressUseCase(repository);
    }
}
