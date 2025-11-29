package ru.yoomoney.sdk.auth.auxToken.di;

import android.content.Context;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
import ru.yoomoney.sdk.auth.api.account.AccountApi;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationApi;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_AccountRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;
import ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment;
import ru.yoomoney.sdk.auth.auxToken.di.AuxTokenIssueActivityComponent;

/* loaded from: classes4.dex */
public final class DaggerAuxTokenIssueActivityComponent {

    public static final class a implements AuxTokenIssueActivityComponent {
        public final AuxTokenIssueModule a;
        public AuxTokenIssueModule_ProvideAuxAuthorizationRepositoryFactory b;
        public AuxTokenIssueModule_ProvideAuxTokenIssueInteractorFactory c;
        public AuxTokenIssueModule_ProvidePasswordCreateFragmentFactory d;

        public a(AuxTokenIssueModule auxTokenIssueModule, AccountApiModule accountApiModule, Context context, AuxAuthorizationApi auxAuthorizationApi, AccountApi accountApi) {
            this.a = auxTokenIssueModule;
            a(auxTokenIssueModule, accountApiModule, context, auxAuthorizationApi, accountApi);
        }

        public final void a(AuxTokenIssueModule auxTokenIssueModule, AccountApiModule accountApiModule, Context context, AuxAuthorizationApi auxAuthorizationApi, AccountApi accountApi) {
            this.b = AuxTokenIssueModule_ProvideAuxAuthorizationRepositoryFactory.create(auxTokenIssueModule, InstanceFactory.create(auxAuthorizationApi));
            this.c = AuxTokenIssueModule_ProvideAuxTokenIssueInteractorFactory.create(auxTokenIssueModule, this.b, AccountApiModule_AccountRepositoryFactory.create(accountApiModule, InstanceFactory.create(accountApi)));
            this.d = AuxTokenIssueModule_ProvidePasswordCreateFragmentFactory.create(auxTokenIssueModule, this.c, AuxTokenIssueModule_ProvideFailureMapperFactory.create(auxTokenIssueModule, InstanceFactory.create(context)));
        }

        @Override // ru.yoomoney.sdk.auth.auxToken.di.AuxTokenIssueActivityComponent
        public final ActivityFragmentFactory factory() {
            return AuxTokenIssueModule_ProvidesAuxTokenIssueActivityFragmentFactoryFactory.providesAuxTokenIssueActivityFragmentFactory(this.a, Collections.singletonMap(AuxTokenIssueFragment.class, this.d));
        }
    }

    public static final class b implements AuxTokenIssueActivityComponent.Builder {
        public Context a;
        public AuxAuthorizationApi b;
        public AccountApi c;

        @Override // ru.yoomoney.sdk.auth.auxToken.di.AuxTokenIssueActivityComponent.Builder
        public final AuxTokenIssueActivityComponent.Builder accountApi(AccountApi accountApi) {
            this.c = (AccountApi) Preconditions.checkNotNull(accountApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.auxToken.di.AuxTokenIssueActivityComponent.Builder
        public final AuxTokenIssueActivityComponent.Builder auxAuthorizationApi(AuxAuthorizationApi auxAuthorizationApi) {
            this.b = (AuxAuthorizationApi) Preconditions.checkNotNull(auxAuthorizationApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.auxToken.di.AuxTokenIssueActivityComponent.Builder
        public final AuxTokenIssueActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Context.class);
            Preconditions.checkBuilderRequirement(this.b, AuxAuthorizationApi.class);
            Preconditions.checkBuilderRequirement(this.c, AccountApi.class);
            return new a(new AuxTokenIssueModule(), new AccountApiModule(), this.a, this.b, this.c);
        }

        @Override // ru.yoomoney.sdk.auth.auxToken.di.AuxTokenIssueActivityComponent.Builder
        public final AuxTokenIssueActivityComponent.Builder context(Context context) {
            this.a = (Context) Preconditions.checkNotNull(context);
            return this;
        }
    }

    private DaggerAuxTokenIssueActivityComponent() {
    }

    public static AuxTokenIssueActivityComponent.Builder builder() {
        return new b();
    }
}
