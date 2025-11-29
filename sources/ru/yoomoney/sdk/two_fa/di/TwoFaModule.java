package ru.yoomoney.sdk.two_fa.di;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.api.AuthenticatorServiceFactoryKt;
import ru.yoomoney.sdk.two_fa.api.Class2faApi;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmInteractor;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmInteractorImpl;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractor;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractorImpl;
import ru.yoomoney.sdk.two_fa.net.HttpClientUtilsKt;
import ru.yoomoney.sdk.two_fa.net.interceptor.AuthorizationInterceptor;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmInteractor;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmInteractorImpl;
import ru.yoomoney.sdk.yoopinning.PinningHelper;

/* compiled from: TwoFaModule.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0011H\u0007¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/two_fa/di/TwoFaModule;", "", "()V", "provideAuthenticatorRepository", "Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepository;", "twoFaApi", "Lru/yoomoney/sdk/two_fa/api/Class2faApi;", "provideAuthorizationInterceptor", "Lru/yoomoney/sdk/two_fa/net/interceptor/AuthorizationInterceptor;", "config", "Lru/yoomoney/sdk/two_fa/Config;", "provideEmailConfirmInteractor", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;", "authenticatorRepository", "provideEntryPointInteractor", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;", "provideHttpClient", "Lokhttp3/OkHttpClient;", "context", "Landroid/content/Context;", "interceptor", "providePhoneCallInteractor", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "provideSmsConfirmInteractor", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;", "provideTwoFaApi", "httpClient", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwoFaModule {
    public static final int $stable = 0;

    public final AuthorizationInterceptor provideAuthorizationInterceptor(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        String authToken = config.getAuthToken();
        if (authToken != null) {
            return new AuthorizationInterceptor(authToken);
        }
        return null;
    }

    public final OkHttpClient provideHttpClient(Context context, Config config, AuthorizationInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return HttpClientUtilsKt.createHttpClient(context, PinningHelper.INSTANCE.prepareCertsHostFromBaseUrl(config.getHost()), interceptor);
    }

    public final Class2faApi provideTwoFaApi(Config config, OkHttpClient httpClient) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        return AuthenticatorServiceFactoryKt.create2faApi(config.getHost(), httpClient);
    }

    public final AuthenticatorRepository provideAuthenticatorRepository(Class2faApi twoFaApi) {
        Intrinsics.checkNotNullParameter(twoFaApi, "twoFaApi");
        return new AuthenticatorRepositoryImpl(twoFaApi);
    }

    public final EntryPointInteractor provideEntryPointInteractor(AuthenticatorRepository authenticatorRepository) {
        Intrinsics.checkNotNullParameter(authenticatorRepository, "authenticatorRepository");
        return new EntryPointInteractorImpl(authenticatorRepository);
    }

    public final SmsConfirmInteractor provideSmsConfirmInteractor(AuthenticatorRepository authenticatorRepository) {
        Intrinsics.checkNotNullParameter(authenticatorRepository, "authenticatorRepository");
        return new SmsConfirmInteractorImpl(authenticatorRepository);
    }

    public final EmailConfirmInteractor provideEmailConfirmInteractor(AuthenticatorRepository authenticatorRepository) {
        Intrinsics.checkNotNullParameter(authenticatorRepository, "authenticatorRepository");
        return new EmailConfirmInteractorImpl(authenticatorRepository);
    }

    public final PhoneCallInteractor providePhoneCallInteractor(AuthenticatorRepository authenticatorRepository) {
        Intrinsics.checkNotNullParameter(authenticatorRepository, "authenticatorRepository");
        return new PhoneCallInteractorImpl(authenticatorRepository);
    }
}
