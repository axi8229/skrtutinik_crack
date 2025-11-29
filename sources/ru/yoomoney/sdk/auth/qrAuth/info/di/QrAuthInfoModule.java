package ru.yoomoney.sdk.auth.qrAuth.info.di;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.signIn.SignInApi;
import ru.yoomoney.sdk.auth.api.signIn.SignInRepository;
import ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl;
import ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment;
import ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractor;
import ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl;
import ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoViewModelFactory;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/info/di/QrAuthInfoModule;", "", "()V", "provideQrAuthInfoFragment", "Landroidx/fragment/app/Fragment;", "interactor", "Lru/yoomoney/sdk/auth/qrAuth/info/impl/QrAuthInfoInteractor;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "provideQrAuthInfoInteractor", "signInRepository", "Lru/yoomoney/sdk/auth/api/signIn/SignInRepository;", "provideSignInRepository", "signInApi", "Lru/yoomoney/sdk/auth/api/signIn/SignInApi;", "accountToken", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthInfoModule {
    public final Fragment provideQrAuthInfoFragment(QrAuthInfoInteractor interactor, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        return new QrAuthInfoFragment(new QrAuthInfoViewModelFactory(interactor), resourceMapper);
    }

    public final QrAuthInfoInteractor provideQrAuthInfoInteractor(SignInRepository signInRepository) {
        Intrinsics.checkNotNullParameter(signInRepository, "signInRepository");
        return new QrAuthInfoInteractorImpl(signInRepository);
    }

    public final SignInRepository provideSignInRepository(SignInApi signInApi, String accountToken) {
        Intrinsics.checkNotNullParameter(signInApi, "signInApi");
        Intrinsics.checkNotNullParameter(accountToken, "accountToken");
        return new SignInRepositoryImpl(signInApi, accountToken);
    }
}
