package ru.yoomoney.sdk.two_fa.di;

import android.content.Context;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.api.Class2faApi;
import ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmInteractor;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractor;
import ru.yoomoney.sdk.two_fa.net.interceptor.AuthorizationInterceptor;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmInteractor;

/* loaded from: classes5.dex */
public final class DaggerTwoFaActivityComponent {
    private DaggerTwoFaActivityComponent() {
    }

    public static TwoFaActivityComponent.Builder builder() {
        return new Builder();
    }

    private static final class Builder implements TwoFaActivityComponent.Builder {
        private Config config;
        private Context context;

        private Builder() {
        }

        @Override // ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent.Builder
        public Builder context(Context context) {
            this.context = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent.Builder
        public Builder config(Config config) {
            this.config = (Config) Preconditions.checkNotNull(config);
            return this;
        }

        @Override // ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent.Builder
        public TwoFaActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.config, Config.class);
            return new TwoFaActivityComponentImpl(new TwoFaModule(), this.context, this.config);
        }
    }

    private static final class TwoFaActivityComponentImpl implements TwoFaActivityComponent {
        private final Config config;
        private final Context context;
        private final TwoFaActivityComponentImpl twoFaActivityComponentImpl;
        private final TwoFaModule twoFaModule;

        private TwoFaActivityComponentImpl(TwoFaModule twoFaModule, Context context, Config config) {
            this.twoFaActivityComponentImpl = this;
            this.twoFaModule = twoFaModule;
            this.config = config;
            this.context = context;
        }

        private AuthorizationInterceptor authorizationInterceptor() {
            return this.twoFaModule.provideAuthorizationInterceptor(this.config);
        }

        private OkHttpClient okHttpClient() {
            return TwoFaModule_ProvideHttpClientFactory.provideHttpClient(this.twoFaModule, this.context, this.config, authorizationInterceptor());
        }

        private Class2faApi class2faApi() {
            return TwoFaModule_ProvideTwoFaApiFactory.provideTwoFaApi(this.twoFaModule, this.config, okHttpClient());
        }

        private AuthenticatorRepository authenticatorRepository() {
            return TwoFaModule_ProvideAuthenticatorRepositoryFactory.provideAuthenticatorRepository(this.twoFaModule, class2faApi());
        }

        @Override // ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent
        public EntryPointInteractor getEntryPointInteractor() {
            return TwoFaModule_ProvideEntryPointInteractorFactory.provideEntryPointInteractor(this.twoFaModule, authenticatorRepository());
        }

        @Override // ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent
        public PhoneCallInteractor getPhoneCallInteractor() {
            return TwoFaModule_ProvidePhoneCallInteractorFactory.providePhoneCallInteractor(this.twoFaModule, authenticatorRepository());
        }

        @Override // ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent
        public SmsConfirmInteractor getSmsConfirmInteractor() {
            return TwoFaModule_ProvideSmsConfirmInteractorFactory.provideSmsConfirmInteractor(this.twoFaModule, authenticatorRepository());
        }

        @Override // ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent
        public EmailConfirmInteractor getEmailConfirmInteractor() {
            return TwoFaModule_ProvideEmailConfirmInteractorFactory.provideEmailConfirmInteractor(this.twoFaModule, authenticatorRepository());
        }
    }
}
