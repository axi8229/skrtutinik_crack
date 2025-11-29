package ru.yoomoney.sdk.auth.qrAuth.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;
import ru.yoomoney.sdk.auth.api.signIn.SignInApi;
import ru.yoomoney.sdk.auth.qrAuth.di.QrAuthActivityComponent;
import ru.yoomoney.sdk.auth.qrAuth.failure.QrAuthFailureFragment;
import ru.yoomoney.sdk.auth.qrAuth.failure.di.QrAuthFailureModule;
import ru.yoomoney.sdk.auth.qrAuth.failure.di.QrAuthFailureModule_ProvideQrAuthFailureFragmentFactory;
import ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment;
import ru.yoomoney.sdk.auth.qrAuth.info.di.QrAuthInfoModule;
import ru.yoomoney.sdk.auth.qrAuth.info.di.QrAuthInfoModule_ProvideQrAuthInfoFragmentFactory;
import ru.yoomoney.sdk.auth.qrAuth.info.di.QrAuthInfoModule_ProvideQrAuthInfoInteractorFactory;
import ru.yoomoney.sdk.auth.qrAuth.info.di.QrAuthInfoModule_ProvideSignInRepositoryFactory;
import ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccessFragment;
import ru.yoomoney.sdk.auth.qrAuth.success.di.QrAuthSuccessModule;
import ru.yoomoney.sdk.auth.qrAuth.success.di.QrAuthSuccessModule_ProvideQrAuthSuccessFragmentFactory;

/* loaded from: classes4.dex */
public final class DaggerQrAuthActivityComponent {

    public static final class a implements QrAuthActivityComponent.Builder {
        public Context a;
        public String b;
        public SignInApi c;

        @Override // ru.yoomoney.sdk.auth.qrAuth.di.QrAuthActivityComponent.Builder
        public final QrAuthActivityComponent.Builder accountToken(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.qrAuth.di.QrAuthActivityComponent.Builder
        public final QrAuthActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Context.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, SignInApi.class);
            return new b(new QrAuthModule(), new QrAuthInfoModule(), new QrAuthFailureModule(), new QrAuthSuccessModule(), this.a, this.b, this.c);
        }

        @Override // ru.yoomoney.sdk.auth.qrAuth.di.QrAuthActivityComponent.Builder
        public final QrAuthActivityComponent.Builder context(Context context) {
            this.a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.qrAuth.di.QrAuthActivityComponent.Builder
        public final QrAuthActivityComponent.Builder signInApi(SignInApi signInApi) {
            this.c = (SignInApi) Preconditions.checkNotNull(signInApi);
            return this;
        }
    }

    public static final class b implements QrAuthActivityComponent {
        public final QrAuthModule a;
        public Factory b;
        public QrAuthInfoModule_ProvideQrAuthInfoInteractorFactory c;
        public QrAuthInfoModule_ProvideQrAuthInfoFragmentFactory d;
        public QrAuthFailureModule_ProvideQrAuthFailureFragmentFactory e;
        public QrAuthSuccessModule_ProvideQrAuthSuccessFragmentFactory f;

        public b(QrAuthModule qrAuthModule, QrAuthInfoModule qrAuthInfoModule, QrAuthFailureModule qrAuthFailureModule, QrAuthSuccessModule qrAuthSuccessModule, Context context, String str, SignInApi signInApi) {
            this.a = qrAuthModule;
            a(qrAuthModule, qrAuthInfoModule, qrAuthFailureModule, qrAuthSuccessModule, context, str, signInApi);
        }

        public final void a(QrAuthModule qrAuthModule, QrAuthInfoModule qrAuthInfoModule, QrAuthFailureModule qrAuthFailureModule, QrAuthSuccessModule qrAuthSuccessModule, Context context, String str, SignInApi signInApi) {
            this.b = InstanceFactory.create(signInApi);
            this.c = QrAuthInfoModule_ProvideQrAuthInfoInteractorFactory.create(qrAuthInfoModule, QrAuthInfoModule_ProvideSignInRepositoryFactory.create(qrAuthInfoModule, this.b, InstanceFactory.create(str)));
            this.d = QrAuthInfoModule_ProvideQrAuthInfoFragmentFactory.create(qrAuthInfoModule, this.c, QrAuthModule_ProvideFailureMapperFactory.create(qrAuthModule, InstanceFactory.create(context)));
            this.e = QrAuthFailureModule_ProvideQrAuthFailureFragmentFactory.create(qrAuthFailureModule);
            this.f = QrAuthSuccessModule_ProvideQrAuthSuccessFragmentFactory.create(qrAuthSuccessModule);
        }

        @Override // ru.yoomoney.sdk.auth.qrAuth.di.QrAuthActivityComponent
        public final ActivityFragmentFactory factory() {
            return QrAuthModule_ProvidesQrAuthActivityFragmentFactoryFactory.providesQrAuthActivityFragmentFactory(this.a, MapBuilder.newMapBuilder(3).put(QrAuthInfoFragment.class, this.d).put(QrAuthFailureFragment.class, this.e).put(QrAuthSuccessFragment.class, this.f).build());
        }
    }

    private DaggerQrAuthActivityComponent() {
    }

    public static QrAuthActivityComponent.Builder builder() {
        return new a();
    }
}
