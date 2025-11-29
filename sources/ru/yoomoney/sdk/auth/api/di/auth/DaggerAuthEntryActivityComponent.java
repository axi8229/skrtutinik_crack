package ru.yoomoney.sdk.auth.api.di.auth;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.about.di.IdentificationModule;
import ru.yoomoney.sdk.auth.about.di.IdentificationModule_ProvideIdentificationInfoFragmentFactory;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTermsFragment;
import ru.yoomoney.sdk.auth.acceptTerms.di.AcceptTermsModule;
import ru.yoomoney.sdk.auth.acceptTerms.di.AcceptTermsModule_AcceptTermsInteractorFactory;
import ru.yoomoney.sdk.auth.acceptTerms.di.AcceptTermsModule_ProvidesAcceptTermsFragmentFactory;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.account.AccountApi;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_AccountRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_EnrollmentRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_LoginRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_MigrationRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_PasswordRecoveryRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_RegistrationV2RepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;
import ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentApi;
import ru.yoomoney.sdk.auth.api.login.LoginApi;
import ru.yoomoney.sdk.auth.api.login.LoginEnterFragment;
import ru.yoomoney.sdk.auth.api.login.di.LoginEnterModule;
import ru.yoomoney.sdk.auth.api.login.di.LoginEnterModule_LoginEnterInteractorFactory;
import ru.yoomoney.sdk.auth.api.login.di.LoginEnterModule_ProvideLoginEnterFragmentFactory;
import ru.yoomoney.sdk.auth.api.migration.MigrationApi;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigrationFragment;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.di.HardMigrationModule;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.di.HardMigrationModule_ProvideHardMigrationFragmentFactory;
import ru.yoomoney.sdk.auth.api.migration.softMigration.SoftMigrationFragment;
import ru.yoomoney.sdk.auth.api.migration.softMigration.di.SoftMigrationModule;
import ru.yoomoney.sdk.auth.api.migration.softMigration.di.SoftMigrationModule_ProvideSoftMigrationFragmentFactory;
import ru.yoomoney.sdk.auth.api.oauth.OauthV2Api;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryApi;
import ru.yoomoney.sdk.auth.api.registrationV2.api.RegistrationV2Api;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelpFragment;
import ru.yoomoney.sdk.auth.confirmationHelp.di.ConfirmationHelpModule;
import ru.yoomoney.sdk.auth.confirmationHelp.di.ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment;
import ru.yoomoney.sdk.auth.email.confirm.di.AuthEmailConfirmModule;
import ru.yoomoney.sdk.auth.email.confirm.di.AuthEmailConfirmModule_AuthEmailConfirmInteractorFactory;
import ru.yoomoney.sdk.auth.email.confirm.di.AuthEmailConfirmModule_ProvideEmailConfirmFragmentFactory;
import ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment;
import ru.yoomoney.sdk.auth.email.enter.di.AuthEmailEnterModule;
import ru.yoomoney.sdk.auth.email.enter.di.AuthEmailEnterModule_AuthEmailEnterInteractorFactory;
import ru.yoomoney.sdk.auth.email.enter.di.AuthEmailEnterModule_ProvideEnterEmailFragmentFactory;
import ru.yoomoney.sdk.auth.email.select.EmailSelectFragment;
import ru.yoomoney.sdk.auth.email.select.di.EmailSelectModule;
import ru.yoomoney.sdk.auth.email.select.di.EmailSelectModule_ProvideEmailSelectInteractorFactory;
import ru.yoomoney.sdk.auth.email.select.di.EmailSelectModule_ProvideEnterEmailFragmentFactory;
import ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriber;
import ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailureFragment;
import ru.yoomoney.sdk.auth.finishing.failure.di.AuthFinishingFailureModule;
import ru.yoomoney.sdk.auth.finishing.failure.di.AuthFinishingFailureModule_ProvideAuthFinishingFailureFragmentFactory;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment;
import ru.yoomoney.sdk.auth.finishing.success.di.AuthFinishingSuccessModule;
import ru.yoomoney.sdk.auth.finishing.success.di.AuthFinishingSuccessModule_AuthFinishingSuccessInteractorFactory;
import ru.yoomoney.sdk.auth.finishing.success.di.AuthFinishingSuccessModule_ProvidesAuthLoadingFragmentFactory;
import ru.yoomoney.sdk.auth.identification.info.IdentificationInfoFragment;
import ru.yoomoney.sdk.auth.loading.AuthLoadingFragment;
import ru.yoomoney.sdk.auth.loading.di.AuthLoadingModule;
import ru.yoomoney.sdk.auth.loading.di.AuthLoadingModule_AuthAuthLoadingInteractorFactory;
import ru.yoomoney.sdk.auth.loading.di.AuthLoadingModule_ProvidesAuthLoadingFragmentFactory;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;
import ru.yoomoney.sdk.auth.oauth.failure.OauthFailureFragment;
import ru.yoomoney.sdk.auth.oauth.failure.di.OauthFailureModule;
import ru.yoomoney.sdk.auth.oauth.failure.di.OauthFailureModule_ProvideOauthFailureFragmentFactory;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment;
import ru.yoomoney.sdk.auth.oauth.notFound.di.OauthNotFoundModule;
import ru.yoomoney.sdk.auth.oauth.notFound.di.OauthNotFoundModule_ProvideOauthNotFoundFragmentFactory;
import ru.yoomoney.sdk.auth.oauth.notFound.di.OauthNotFoundModule_ProvideOauthNotFoundInteractorFactory;
import ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment;
import ru.yoomoney.sdk.auth.password.create.di.AuthPasswordCreateModule;
import ru.yoomoney.sdk.auth.password.create.di.AuthPasswordCreateModule_AuthPasswordCreateInteractorFactory;
import ru.yoomoney.sdk.auth.password.create.di.AuthPasswordCreateModule_ProvidePasswordCreateFragmentFactory;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment;
import ru.yoomoney.sdk.auth.password.enter.di.AuthPasswordEnterModule;
import ru.yoomoney.sdk.auth.password.enter.di.AuthPasswordEnterModule_AuthPasswordEnterInteractorFactory;
import ru.yoomoney.sdk.auth.password.enter.di.AuthPasswordEnterModule_ProvidePasswordEnterFragmentFactory;
import ru.yoomoney.sdk.auth.password.finish.PasswordFinishFragment;
import ru.yoomoney.sdk.auth.password.finish.di.PasswordFinishModule;
import ru.yoomoney.sdk.auth.password.finish.di.PasswordFinishModule_ProvidePasswordFinishFragmentFactory;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment;
import ru.yoomoney.sdk.auth.phone.confirm.di.AuthPhoneConfirmModule;
import ru.yoomoney.sdk.auth.phone.confirm.di.AuthPhoneConfirmModule_AuthPhoneConfirmInteractorFactory;
import ru.yoomoney.sdk.auth.phone.confirm.di.AuthPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment;
import ru.yoomoney.sdk.auth.phone.enter.di.AuthPhoneEnterModule;
import ru.yoomoney.sdk.auth.phone.enter.di.AuthPhoneEnterModule_AuthPasswordEnterInteractorFactory;
import ru.yoomoney.sdk.auth.phone.enter.di.AuthPhoneEnterModule_ProvidePhoneEnterFragmentFactory;
import ru.yoomoney.sdk.auth.phone.select.PhoneSelectFragment;
import ru.yoomoney.sdk.auth.phone.select.di.PhoneSelectModule;
import ru.yoomoney.sdk.auth.phone.select.di.PhoneSelectModule_PhoneSelectInteractorFactory;
import ru.yoomoney.sdk.auth.phone.select.di.PhoneSelectModule_ProvidePhoneSelectFragmentFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.select.SelectAccountFragment;
import ru.yoomoney.sdk.auth.select.di.SelectAccountModule;
import ru.yoomoney.sdk.auth.select.di.SelectAccountModule_ProvideSelectAccountFragmentFactory;
import ru.yoomoney.sdk.auth.select.di.SelectAccountModule_SelectAccountInteractorFactory;
import ru.yoomoney.sdk.auth.support.TechnicalSupportFragment;
import ru.yoomoney.sdk.auth.support.di.TechnicalSupportModule;
import ru.yoomoney.sdk.auth.support.di.TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory;
import ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLoginFragment;
import ru.yoomoney.sdk.auth.yandexAcquire.login.di.YandexAcquireLoginModule;
import ru.yoomoney.sdk.auth.yandexAcquire.login.di.YandexAcquireLoginModule_ProvideYandexAcquireLoginFragmentFactory;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.di.YandexAcquireRegistrationModule;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.di.YandexAcquireRegistrationModule_ProvideYandexAcquireEnrollmentFragmentFactory;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebViewFragment;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.di.YandexAcquireWebViewModule;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.di.YandexAcquireWebViewModule_ProvideYandexAcquireWebViewFragmentFactory;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class DaggerAuthEntryActivityComponent {

    public static final class a implements AuthEntryActivityComponent {
        public AuthPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory A;
        public AuthPasswordCreateModule_ProvidePasswordCreateFragmentFactory B;
        public LoginEnterModule_ProvideLoginEnterFragmentFactory C;
        public SelectAccountModule_ProvideSelectAccountFragmentFactory D;
        public AuthPhoneEnterModule_ProvidePhoneEnterFragmentFactory E;
        public AuthPasswordEnterModule_ProvidePasswordEnterFragmentFactory F;
        public PhoneSelectModule_ProvidePhoneSelectFragmentFactory G;
        public EmailSelectModule_ProvideEnterEmailFragmentFactory H;
        public YandexAcquireRegistrationModule_ProvideYandexAcquireEnrollmentFragmentFactory I;
        public YandexAcquireLoginModule_ProvideYandexAcquireLoginFragmentFactory J;
        public HardMigrationModule_ProvideHardMigrationFragmentFactory K;
        public YandexAcquireWebViewModule_ProvideYandexAcquireWebViewFragmentFactory L;
        public AuthFinishingSuccessModule_ProvidesAuthLoadingFragmentFactory M;
        public AuthFinishingFailureModule_ProvideAuthFinishingFailureFragmentFactory N;
        public SoftMigrationModule_ProvideSoftMigrationFragmentFactory O;
        public TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory P;
        public ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory Q;
        public IdentificationModule_ProvideIdentificationInfoFragmentFactory R;
        public OauthNotFoundModule_ProvideOauthNotFoundFragmentFactory S;
        public OauthFailureModule_ProvideOauthFailureFragmentFactory T;
        public PasswordFinishModule_ProvidePasswordFinishFragmentFactory U;
        public AcceptTermsModule_ProvidesAcceptTermsFragmentFactory V;
        public final AuthEntryModule a;
        public Factory b;
        public Factory c;
        public Factory d;
        public Factory e;
        public AccountApiModule_EnrollmentRepositoryFactory f;
        public Factory g;
        public Factory h;
        public Factory i;
        public AccountApiModule_RegistrationV2RepositoryFactory j;
        public AccountApiModule_LoginRepositoryFactory k;
        public AccountApiModule_MigrationRepositoryFactory l;
        public Factory m;
        public Factory n;
        public Factory o;
        public AuthLoadingModule_AuthAuthLoadingInteractorFactory p;
        public Provider<Router> q;
        public Provider<ProcessMapper> r;
        public AuthEntryModule_ProvideFailureMapperFactory s;
        public Factory t;
        public AuthLoadingModule_ProvidesAuthLoadingFragmentFactory u;
        public AuthEmailEnterModule_AuthEmailEnterInteractorFactory v;
        public Factory w;
        public AuthEmailEnterModule_ProvideEnterEmailFragmentFactory x;
        public AccountApiModule_PasswordRecoveryRepositoryFactory y;
        public AuthEmailConfirmModule_ProvideEmailConfirmFragmentFactory z;

        public a(AuthEntryModule authEntryModule, AuthLoadingModule authLoadingModule, AccountApiModule accountApiModule, AuthEmailEnterModule authEmailEnterModule, AuthEmailConfirmModule authEmailConfirmModule, AuthPhoneConfirmModule authPhoneConfirmModule, AuthPasswordCreateModule authPasswordCreateModule, LoginEnterModule loginEnterModule, SelectAccountModule selectAccountModule, AuthPhoneEnterModule authPhoneEnterModule, AuthPasswordEnterModule authPasswordEnterModule, PhoneSelectModule phoneSelectModule, EmailSelectModule emailSelectModule, YandexAcquireRegistrationModule yandexAcquireRegistrationModule, YandexAcquireLoginModule yandexAcquireLoginModule, HardMigrationModule hardMigrationModule, YandexAcquireWebViewModule yandexAcquireWebViewModule, AuthFinishingSuccessModule authFinishingSuccessModule, AuthFinishingFailureModule authFinishingFailureModule, SoftMigrationModule softMigrationModule, TechnicalSupportModule technicalSupportModule, ConfirmationHelpModule confirmationHelpModule, IdentificationModule identificationModule, OauthNotFoundModule oauthNotFoundModule, OauthFailureModule oauthFailureModule, PasswordFinishModule passwordFinishModule, AcceptTermsModule acceptTermsModule, Context context, Lazy lazy, Lazy lazy2, ResultData resultData, EnrollmentApi enrollmentApi, RegistrationV2Api registrationV2Api, LoginApi loginApi, MigrationApi migrationApi, AccountApi accountApi, PasswordRecoveryApi passwordRecoveryApi, YooProfiler yooProfiler, ServerTimeRepository serverTimeRepository, AnalyticsLogger analyticsLogger, ClientAppParams clientAppParams, Boolean bool, BusinessLogicEventSubscriber businessLogicEventSubscriber, LocationHeaderManager locationHeaderManager) {
            this.a = authEntryModule;
            a(authEntryModule, authLoadingModule, accountApiModule, authEmailEnterModule, authEmailConfirmModule, authPhoneConfirmModule, authPasswordCreateModule, loginEnterModule, selectAccountModule, authPhoneEnterModule, authPasswordEnterModule, phoneSelectModule, emailSelectModule, yandexAcquireRegistrationModule, yandexAcquireLoginModule, hardMigrationModule, yandexAcquireWebViewModule, authFinishingSuccessModule, authFinishingFailureModule, softMigrationModule, technicalSupportModule, confirmationHelpModule, identificationModule, oauthNotFoundModule, oauthFailureModule, passwordFinishModule, acceptTermsModule, context, lazy, lazy2, resultData, enrollmentApi, registrationV2Api, loginApi, migrationApi, accountApi, passwordRecoveryApi, yooProfiler, serverTimeRepository, analyticsLogger, clientAppParams, bool, businessLogicEventSubscriber, locationHeaderManager);
        }

        public final void a(AuthEntryModule authEntryModule, AuthLoadingModule authLoadingModule, AccountApiModule accountApiModule, AuthEmailEnterModule authEmailEnterModule, AuthEmailConfirmModule authEmailConfirmModule, AuthPhoneConfirmModule authPhoneConfirmModule, AuthPasswordCreateModule authPasswordCreateModule, LoginEnterModule loginEnterModule, SelectAccountModule selectAccountModule, AuthPhoneEnterModule authPhoneEnterModule, AuthPasswordEnterModule authPasswordEnterModule, PhoneSelectModule phoneSelectModule, EmailSelectModule emailSelectModule, YandexAcquireRegistrationModule yandexAcquireRegistrationModule, YandexAcquireLoginModule yandexAcquireLoginModule, HardMigrationModule hardMigrationModule, YandexAcquireWebViewModule yandexAcquireWebViewModule, AuthFinishingSuccessModule authFinishingSuccessModule, AuthFinishingFailureModule authFinishingFailureModule, SoftMigrationModule softMigrationModule, TechnicalSupportModule technicalSupportModule, ConfirmationHelpModule confirmationHelpModule, IdentificationModule identificationModule, OauthNotFoundModule oauthNotFoundModule, OauthFailureModule oauthFailureModule, PasswordFinishModule passwordFinishModule, AcceptTermsModule acceptTermsModule, Context context, Lazy lazy, Lazy lazy2, ResultData resultData, EnrollmentApi enrollmentApi, RegistrationV2Api registrationV2Api, LoginApi loginApi, MigrationApi migrationApi, AccountApi accountApi, PasswordRecoveryApi passwordRecoveryApi, YooProfiler yooProfiler, ServerTimeRepository serverTimeRepository, AnalyticsLogger analyticsLogger, ClientAppParams clientAppParams, Boolean bool, BusinessLogicEventSubscriber businessLogicEventSubscriber, LocationHeaderManager locationHeaderManager) {
            this.b = InstanceFactory.create(enrollmentApi);
            this.c = InstanceFactory.create(clientAppParams);
            this.d = InstanceFactory.create(serverTimeRepository);
            Factory factoryCreate = InstanceFactory.create(bool);
            this.e = factoryCreate;
            this.f = AccountApiModule_EnrollmentRepositoryFactory.create(accountApiModule, this.b, this.c, this.d, factoryCreate);
            this.g = InstanceFactory.create(registrationV2Api);
            this.h = InstanceFactory.create(lazy);
            Factory factoryCreate2 = InstanceFactory.create(locationHeaderManager);
            this.i = factoryCreate2;
            this.j = AccountApiModule_RegistrationV2RepositoryFactory.create(accountApiModule, this.g, this.h, factoryCreate2);
            this.k = AccountApiModule_LoginRepositoryFactory.create(accountApiModule, InstanceFactory.create(loginApi), this.c, this.d, this.e, this.i);
            this.l = AccountApiModule_MigrationRepositoryFactory.create(accountApiModule, InstanceFactory.create(migrationApi), this.c, this.d, this.e, this.i);
            this.m = InstanceFactory.create(yooProfiler);
            this.n = InstanceFactory.create(resultData);
            Factory factoryCreate3 = InstanceFactory.create(context);
            this.o = factoryCreate3;
            this.p = AuthLoadingModule_AuthAuthLoadingInteractorFactory.create(authLoadingModule, this.f, this.j, this.k, this.l, this.d, this.m, this.h, this.n, factoryCreate3);
            this.q = DoubleCheck.provider(AuthEntryModule_ProvideRouterFactory.create(authEntryModule, this.h));
            this.r = DoubleCheck.provider(AuthEntryModule_ProvideProcessMapperFactory.create(authEntryModule));
            this.s = AuthEntryModule_ProvideFailureMapperFactory.create(authEntryModule, this.o);
            Factory factoryCreate4 = InstanceFactory.create(lazy2);
            this.t = factoryCreate4;
            this.u = AuthLoadingModule_ProvidesAuthLoadingFragmentFactory.create(authLoadingModule, this.p, this.n, this.h, this.q, this.r, this.s, factoryCreate4);
            this.v = AuthEmailEnterModule_AuthEmailEnterInteractorFactory.create(authEmailEnterModule, this.f, this.j, this.l, this.d);
            Factory factoryCreateNullable = InstanceFactory.createNullable(analyticsLogger);
            this.w = factoryCreateNullable;
            this.x = AuthEmailEnterModule_ProvideEnterEmailFragmentFactory.create(authEmailEnterModule, this.v, this.q, this.r, this.s, this.n, this.t, factoryCreateNullable, this.h);
            AccountApiModule_PasswordRecoveryRepositoryFactory accountApiModule_PasswordRecoveryRepositoryFactoryCreate = AccountApiModule_PasswordRecoveryRepositoryFactory.create(accountApiModule, InstanceFactory.create(passwordRecoveryApi), this.c, this.d, this.e, this.i);
            this.y = accountApiModule_PasswordRecoveryRepositoryFactoryCreate;
            this.z = AuthEmailConfirmModule_ProvideEmailConfirmFragmentFactory.create(authEmailConfirmModule, AuthEmailConfirmModule_AuthEmailConfirmInteractorFactory.create(authEmailConfirmModule, this.f, this.k, this.l, accountApiModule_PasswordRecoveryRepositoryFactoryCreate, this.d), this.q, this.r, this.s, this.h, this.n, this.d, this.w);
            this.A = AuthPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory.create(authPhoneConfirmModule, AuthPhoneConfirmModule_AuthPhoneConfirmInteractorFactory.create(authPhoneConfirmModule, this.f, this.k, this.l, this.y, this.d), this.h, this.q, this.r, this.s, this.n, this.d, this.w);
            this.B = AuthPasswordCreateModule_ProvidePasswordCreateFragmentFactory.create(authPasswordCreateModule, AuthPasswordCreateModule_AuthPasswordCreateInteractorFactory.create(authPasswordCreateModule, this.f, this.j, this.l, this.y, this.d), this.q, this.r, this.s, this.h, this.t, this.w);
            this.C = LoginEnterModule_ProvideLoginEnterFragmentFactory.create(loginEnterModule, this.h, LoginEnterModule_LoginEnterInteractorFactory.create(loginEnterModule, this.k, this.d), this.q, this.r, this.s, this.n, this.w);
            this.D = SelectAccountModule_ProvideSelectAccountFragmentFactory.create(selectAccountModule, SelectAccountModule_SelectAccountInteractorFactory.create(selectAccountModule, this.d, this.k, this.y, this.f), this.q, this.r, this.s, this.h, this.w);
            this.E = AuthPhoneEnterModule_ProvidePhoneEnterFragmentFactory.create(authPhoneEnterModule, AuthPhoneEnterModule_AuthPasswordEnterInteractorFactory.create(authPhoneEnterModule, this.f, this.j, this.l, this.y, this.d), this.q, this.h, this.r, this.s, this.n, this.w);
            this.F = AuthPasswordEnterModule_ProvidePasswordEnterFragmentFactory.create(authPasswordEnterModule, this.q, this.r, this.h, this.n, AuthPasswordEnterModule_AuthPasswordEnterInteractorFactory.create(authPasswordEnterModule, this.k, this.y, this.d, this.m, this.h), this.s, this.w);
            this.G = PhoneSelectModule_ProvidePhoneSelectFragmentFactory.create(phoneSelectModule, PhoneSelectModule_PhoneSelectInteractorFactory.create(phoneSelectModule, this.l, this.d), this.q, this.r, this.s, this.w);
            this.H = EmailSelectModule_ProvideEnterEmailFragmentFactory.create(emailSelectModule, EmailSelectModule_ProvideEmailSelectInteractorFactory.create(emailSelectModule, this.l, this.d), this.q, this.r, this.s, this.n, this.w);
            this.I = YandexAcquireRegistrationModule_ProvideYandexAcquireEnrollmentFragmentFactory.create(yandexAcquireRegistrationModule, this.h, this.j, this.m, this.q, this.r, this.s);
            this.J = YandexAcquireLoginModule_ProvideYandexAcquireLoginFragmentFactory.create(yandexAcquireLoginModule, this.h, this.k, this.m, this.q, this.r, this.s);
            this.K = HardMigrationModule_ProvideHardMigrationFragmentFactory.create(hardMigrationModule, this.l, this.q, this.r, this.s, this.t, this.m, this.n, this.d, this.w);
            this.L = YandexAcquireWebViewModule_ProvideYandexAcquireWebViewFragmentFactory.create(yandexAcquireWebViewModule, this.l, this.q, this.r, this.h, this.s, this.d, this.w);
            this.M = AuthFinishingSuccessModule_ProvidesAuthLoadingFragmentFactory.create(authFinishingSuccessModule, AuthFinishingSuccessModule_AuthFinishingSuccessInteractorFactory.create(authFinishingSuccessModule, this.f, this.k, this.j, this.l, AccountApiModule_AccountRepositoryFactory.create(accountApiModule, InstanceFactory.create(accountApi)), this.h, this.n), this.q, this.r, this.s, this.w);
            this.N = AuthFinishingFailureModule_ProvideAuthFinishingFailureFragmentFactory.create(authFinishingFailureModule, this.h, this.q, this.r, this.s);
            this.O = SoftMigrationModule_ProvideSoftMigrationFragmentFactory.create(softMigrationModule, this.h, this.l, this.q, this.r, this.s, this.t, this.m, this.n, this.w);
            this.P = TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory.create(technicalSupportModule, this.h, this.q, this.r, this.s);
            this.Q = ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory.create(confirmationHelpModule, this.h, this.q, this.r, this.s);
            this.R = IdentificationModule_ProvideIdentificationInfoFragmentFactory.create(identificationModule, this.q, this.r, this.s);
            this.S = OauthNotFoundModule_ProvideOauthNotFoundFragmentFactory.create(oauthNotFoundModule, OauthNotFoundModule_ProvideOauthNotFoundInteractorFactory.create(oauthNotFoundModule, this.f, this.j, this.k, this.d, this.m, this.n, this.h), this.q, this.r, this.s, this.t, this.h);
            this.T = OauthFailureModule_ProvideOauthFailureFragmentFactory.create(oauthFailureModule, this.q, this.r, this.s);
            this.U = PasswordFinishModule_ProvidePasswordFinishFragmentFactory.create(passwordFinishModule, this.h, this.q, this.r, this.s, InstanceFactory.create(businessLogicEventSubscriber), this.w);
            this.V = AcceptTermsModule_ProvidesAcceptTermsFragmentFactory.create(acceptTermsModule, AcceptTermsModule_AcceptTermsInteractorFactory.create(acceptTermsModule, this.f), this.q, this.r, this.s, this.w, this.h);
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent
        public final ActivityFragmentFactory factory() {
            return AuthEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory.providesAuthEntryActivityFragmentFactory(this.a, MapBuilder.newMapBuilder(25).put(AuthLoadingFragment.class, this.u).put(EmailEnterFragment.class, this.x).put(EmailConfirmFragment.class, this.z).put(PhoneConfirmFragment.class, this.A).put(PasswordCreateFragment.class, this.B).put(LoginEnterFragment.class, this.C).put(SelectAccountFragment.class, this.D).put(PhoneEnterFragment.class, this.E).put(PasswordEnterFragment.class, this.F).put(PhoneSelectFragment.class, this.G).put(EmailSelectFragment.class, this.H).put(YandexAcquireRegistrationFragment.class, this.I).put(YandexAcquireLoginFragment.class, this.J).put(HardMigrationFragment.class, this.K).put(YandexAcquireWebViewFragment.class, this.L).put(AuthFinishingSuccessFragment.class, this.M).put(AuthFinishingFailureFragment.class, this.N).put(SoftMigrationFragment.class, this.O).put(TechnicalSupportFragment.class, this.P).put(ConfirmationHelpFragment.class, this.Q).put(IdentificationInfoFragment.class, this.R).put(OauthNotFoundFragment.class, this.S).put(OauthFailureFragment.class, this.T).put(PasswordFinishFragment.class, this.U).put(AcceptTermsFragment.class, this.V).build());
        }
    }

    public static final class b implements AuthEntryActivityComponent.Builder {
        public Context a;
        public Lazy<Config> b;
        public Lazy<RemoteConfig> c;
        public ResultData d;
        public EnrollmentApi e;
        public RegistrationV2Api f;
        public OauthV2Api g;
        public LoginApi h;
        public MigrationApi i;
        public AccountApi j;
        public PasswordRecoveryApi k;
        public YooProfiler l;
        public ServerTimeRepository m;
        public AnalyticsLogger n;
        public ClientAppParams o;
        public Boolean p;
        public BusinessLogicEventSubscriber q;
        public LocationHeaderManager r;

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder accountApi(AccountApi accountApi) {
            this.j = (AccountApi) Preconditions.checkNotNull(accountApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder analyticsLogger(AnalyticsLogger analyticsLogger) {
            this.n = analyticsLogger;
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Context.class);
            Preconditions.checkBuilderRequirement(this.b, Lazy.class);
            Preconditions.checkBuilderRequirement(this.c, Lazy.class);
            Preconditions.checkBuilderRequirement(this.d, ResultData.class);
            Preconditions.checkBuilderRequirement(this.e, EnrollmentApi.class);
            Preconditions.checkBuilderRequirement(this.f, RegistrationV2Api.class);
            Preconditions.checkBuilderRequirement(this.g, OauthV2Api.class);
            Preconditions.checkBuilderRequirement(this.h, LoginApi.class);
            Preconditions.checkBuilderRequirement(this.i, MigrationApi.class);
            Preconditions.checkBuilderRequirement(this.j, AccountApi.class);
            Preconditions.checkBuilderRequirement(this.k, PasswordRecoveryApi.class);
            Preconditions.checkBuilderRequirement(this.l, YooProfiler.class);
            Preconditions.checkBuilderRequirement(this.m, ServerTimeRepository.class);
            Preconditions.checkBuilderRequirement(this.o, ClientAppParams.class);
            Preconditions.checkBuilderRequirement(this.p, Boolean.class);
            Preconditions.checkBuilderRequirement(this.q, BusinessLogicEventSubscriber.class);
            Preconditions.checkBuilderRequirement(this.r, LocationHeaderManager.class);
            return new a(new AuthEntryModule(), new AuthLoadingModule(), new AccountApiModule(), new AuthEmailEnterModule(), new AuthEmailConfirmModule(), new AuthPhoneConfirmModule(), new AuthPasswordCreateModule(), new LoginEnterModule(), new SelectAccountModule(), new AuthPhoneEnterModule(), new AuthPasswordEnterModule(), new PhoneSelectModule(), new EmailSelectModule(), new YandexAcquireRegistrationModule(), new YandexAcquireLoginModule(), new HardMigrationModule(), new YandexAcquireWebViewModule(), new AuthFinishingSuccessModule(), new AuthFinishingFailureModule(), new SoftMigrationModule(), new TechnicalSupportModule(), new ConfirmationHelpModule(), new IdentificationModule(), new OauthNotFoundModule(), new OauthFailureModule(), new PasswordFinishModule(), new AcceptTermsModule(), this.a, this.b, this.c, this.d, this.e, this.f, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r);
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder businessLogicEventSubscriber(BusinessLogicEventSubscriber businessLogicEventSubscriber) {
            this.q = (BusinessLogicEventSubscriber) Preconditions.checkNotNull(businessLogicEventSubscriber);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder clientIdContainer(ClientAppParams clientAppParams) {
            this.o = (ClientAppParams) Preconditions.checkNotNull(clientAppParams);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder config(Lazy lazy) {
            this.b = (Lazy) Preconditions.checkNotNull(lazy);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder context(Context context) {
            this.a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder enrollmentApi(EnrollmentApi enrollmentApi) {
            this.e = (EnrollmentApi) Preconditions.checkNotNull(enrollmentApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder isDebugMode(boolean z) {
            this.p = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder locationHeaderManager(LocationHeaderManager locationHeaderManager) {
            this.r = (LocationHeaderManager) Preconditions.checkNotNull(locationHeaderManager);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder loginApi(LoginApi loginApi) {
            this.h = (LoginApi) Preconditions.checkNotNull(loginApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder migrationApi(MigrationApi migrationApi) {
            this.i = (MigrationApi) Preconditions.checkNotNull(migrationApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder oauthV2Api(OauthV2Api oauthV2Api) {
            this.g = (OauthV2Api) Preconditions.checkNotNull(oauthV2Api);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder passwordRecoveryApi(PasswordRecoveryApi passwordRecoveryApi) {
            this.k = (PasswordRecoveryApi) Preconditions.checkNotNull(passwordRecoveryApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder profiler(YooProfiler yooProfiler) {
            this.l = (YooProfiler) Preconditions.checkNotNull(yooProfiler);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder registrationV2Api(RegistrationV2Api registrationV2Api) {
            this.f = (RegistrationV2Api) Preconditions.checkNotNull(registrationV2Api);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder remoteConfig(Lazy lazy) {
            this.c = (Lazy) Preconditions.checkNotNull(lazy);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder resultData(ResultData resultData) {
            this.d = (ResultData) Preconditions.checkNotNull(resultData);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent.Builder
        public final AuthEntryActivityComponent.Builder serverTimeRepository(ServerTimeRepository serverTimeRepository) {
            this.m = (ServerTimeRepository) Preconditions.checkNotNull(serverTimeRepository);
            return this;
        }
    }

    private DaggerAuthEntryActivityComponent() {
    }

    public static AuthEntryActivityComponent.Builder builder() {
        return new b();
    }
}
