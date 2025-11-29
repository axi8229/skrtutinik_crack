package ru.yoomoney.sdk.auth.api.di.account;

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
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.account.AccountApi;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeApi;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeApi;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeApi;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountApi;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_AccountRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_EnrollmentRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_LoginRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.AccountApiModule_PasswordRecoveryRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;
import ru.yoomoney.sdk.auth.api.di.ProfileApiModule;
import ru.yoomoney.sdk.auth.api.di.ProfileApiModule_ChangeEmailRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.ProfileApiModule_ChangePasswordRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.ProfileApiModule_ChangePhoneRepositoryFactory;
import ru.yoomoney.sdk.auth.api.di.ProfileApiModule_SocialAccountRepositoryImplFactory;
import ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentApi;
import ru.yoomoney.sdk.auth.api.login.LoginApi;
import ru.yoomoney.sdk.auth.api.login.LoginEnterFragment;
import ru.yoomoney.sdk.auth.api.login.di.LoginEnterModule;
import ru.yoomoney.sdk.auth.api.login.di.LoginEnterModule_LoginEnterInteractorFactory;
import ru.yoomoney.sdk.auth.api.login.di.LoginEnterModule_ProvideLoginEnterFragmentFactory;
import ru.yoomoney.sdk.auth.api.migration.MigrationApi;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryApi;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelpFragment;
import ru.yoomoney.sdk.auth.confirmationHelp.di.ConfirmationHelpModule;
import ru.yoomoney.sdk.auth.confirmationHelp.di.ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment;
import ru.yoomoney.sdk.auth.email.confirm.di.AccountEmailConfirmModule;
import ru.yoomoney.sdk.auth.email.confirm.di.AccountEmailConfirmModule_AccountEmailConfirmInteractorFactory;
import ru.yoomoney.sdk.auth.email.confirm.di.AccountEmailConfirmModule_ProvideEmailConfirmFragmentFactory;
import ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment;
import ru.yoomoney.sdk.auth.email.enter.di.AccountEmailEnterModule;
import ru.yoomoney.sdk.auth.email.enter.di.AccountEmailEnterModule_AccountEmailEnterInteractorFactory;
import ru.yoomoney.sdk.auth.email.enter.di.AccountEmailEnterModule_ProvideEnterEmailFragmentFactory;
import ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriber;
import ru.yoomoney.sdk.auth.finishing.failure.AuthFinishingFailureFragment;
import ru.yoomoney.sdk.auth.finishing.failure.di.AuthFinishingFailureModule;
import ru.yoomoney.sdk.auth.finishing.failure.di.AuthFinishingFailureModule_ProvideAuthFinishingFailureFragmentFactory;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;
import ru.yoomoney.sdk.auth.nickname.NicknameFragment;
import ru.yoomoney.sdk.auth.nickname.di.NicknameModule;
import ru.yoomoney.sdk.auth.nickname.di.NicknameModule_NicknameInteractorFactory;
import ru.yoomoney.sdk.auth.nickname.di.NicknameModule_ProvideNicknameFragmentFactory;
import ru.yoomoney.sdk.auth.oauth.failure.OauthFailureFragment;
import ru.yoomoney.sdk.auth.oauth.failure.di.OauthFailureModule;
import ru.yoomoney.sdk.auth.oauth.failure.di.OauthFailureModule_ProvideOauthFailureFragmentFactory;
import ru.yoomoney.sdk.auth.passport.PassportProfileFragment;
import ru.yoomoney.sdk.auth.passport.di.PassportProfileModule;
import ru.yoomoney.sdk.auth.passport.di.PassportProfileModule_PassportProfileInteractorFactory;
import ru.yoomoney.sdk.auth.passport.di.PassportProfileModule_ProvideProfileFragmentFactory;
import ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment;
import ru.yoomoney.sdk.auth.password.create.di.AccountPasswordCreateModule;
import ru.yoomoney.sdk.auth.password.create.di.AccountPasswordCreateModule_AccountPasswordCreateInteractorFactory;
import ru.yoomoney.sdk.auth.password.create.di.AccountPasswordCreateModule_ProvidePasswordCreateFragmentFactory;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment;
import ru.yoomoney.sdk.auth.password.enter.di.AccountPasswordEnterModule;
import ru.yoomoney.sdk.auth.password.enter.di.AccountPasswordEnterModule_AccountPasswordEnterInteractorFactory;
import ru.yoomoney.sdk.auth.password.enter.di.AccountPasswordEnterModule_ProvidePasswordEnterFragmentFactory;
import ru.yoomoney.sdk.auth.password.finish.PasswordFinishFragment;
import ru.yoomoney.sdk.auth.password.finish.di.PasswordFinishModule;
import ru.yoomoney.sdk.auth.password.finish.di.PasswordFinishModule_ProvidePasswordFinishFragmentFactory;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment;
import ru.yoomoney.sdk.auth.phone.confirm.di.AccountPhoneConfirmModule;
import ru.yoomoney.sdk.auth.phone.confirm.di.AccountPhoneConfirmModule_AccountPhoneConfirmInteractorFactory;
import ru.yoomoney.sdk.auth.phone.confirm.di.AccountPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment;
import ru.yoomoney.sdk.auth.phone.enter.di.AccountPhoneEnterModule;
import ru.yoomoney.sdk.auth.phone.enter.di.AccountPhoneEnterModule_AccountPasswordEnterInteractorFactory;
import ru.yoomoney.sdk.auth.phone.enter.di.AccountPhoneEnterModule_ProvidePhoneEnterFragmentFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.select.SelectAccountFragment;
import ru.yoomoney.sdk.auth.select.di.SelectAccountModule;
import ru.yoomoney.sdk.auth.select.di.SelectAccountModule_ProvideSelectAccountFragmentFactory;
import ru.yoomoney.sdk.auth.select.di.SelectAccountModule_SelectAccountInteractorFactory;
import ru.yoomoney.sdk.auth.support.TechnicalSupportFragment;
import ru.yoomoney.sdk.auth.support.di.TechnicalSupportModule;
import ru.yoomoney.sdk.auth.support.di.TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class DaggerAccountEntryActivityComponent {

    public static final class a implements AccountEntryActivityComponent {
        public PassportProfileModule_ProvideProfileFragmentFactory A;
        public AccountEmailConfirmModule_ProvideEmailConfirmFragmentFactory B;
        public AccountEmailEnterModule_ProvideEnterEmailFragmentFactory C;
        public AccountPhoneEnterModule_ProvidePhoneEnterFragmentFactory D;
        public AccountPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory E;
        public AccountPasswordEnterModule_ProvidePasswordEnterFragmentFactory F;
        public PasswordFinishModule_ProvidePasswordFinishFragmentFactory G;
        public TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory H;
        public NicknameModule_ProvideNicknameFragmentFactory I;
        public AccountApiModule_LoginRepositoryFactory J;
        public SelectAccountModule_ProvideSelectAccountFragmentFactory K;
        public LoginEnterModule_ProvideLoginEnterFragmentFactory L;
        public ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory M;
        public AuthFinishingFailureModule_ProvideAuthFinishingFailureFragmentFactory N;
        public OauthFailureModule_ProvideOauthFailureFragmentFactory O;
        public final AccountEntryModule a;
        public Factory b;
        public Factory c;
        public Factory d;
        public ProfileApiModule_ChangePasswordRepositoryFactory e;
        public Factory f;
        public Factory g;
        public Factory h;
        public Factory i;
        public AccountApiModule_PasswordRecoveryRepositoryFactory j;
        public AccountPasswordCreateModule_AccountPasswordCreateInteractorFactory k;
        public Provider<Router> l;
        public Provider<ProcessMapper> m;
        public Factory n;
        public AccountEntryModule_ProvideFailureMapperFactory o;
        public Factory p;
        public Factory q;
        public Factory r;
        public AccountPasswordCreateModule_ProvidePasswordCreateFragmentFactory s;
        public AccountApiModule_AccountRepositoryFactory t;
        public ProfileApiModule_ChangeEmailRepositoryFactory u;
        public ProfileApiModule_ChangePhoneRepositoryFactory v;
        public ProfileApiModule_SocialAccountRepositoryImplFactory w;
        public Factory x;
        public PassportProfileModule_PassportProfileInteractorFactory y;
        public Factory z;

        public a(AccountPasswordCreateModule accountPasswordCreateModule, AccountEntryModule accountEntryModule, AccountApiModule accountApiModule, ProfileApiModule profileApiModule, PassportProfileModule passportProfileModule, AccountEmailConfirmModule accountEmailConfirmModule, AccountEmailEnterModule accountEmailEnterModule, AccountPhoneEnterModule accountPhoneEnterModule, AccountPhoneConfirmModule accountPhoneConfirmModule, AccountPasswordEnterModule accountPasswordEnterModule, PasswordFinishModule passwordFinishModule, TechnicalSupportModule technicalSupportModule, NicknameModule nicknameModule, SelectAccountModule selectAccountModule, LoginEnterModule loginEnterModule, ConfirmationHelpModule confirmationHelpModule, AuthFinishingFailureModule authFinishingFailureModule, OauthFailureModule oauthFailureModule, Context context, Lazy lazy, Lazy lazy2, ResultData resultData, YooProfiler yooProfiler, AccountApi accountApi, EmailChangeApi emailChangeApi, PhoneChangeApi phoneChangeApi, PasswordChangeApi passwordChangeApi, SocialAccountApi socialAccountApi, String str, PasswordRecoveryApi passwordRecoveryApi, ClientAppParams clientAppParams, Boolean bool, EnrollmentApi enrollmentApi, LoginApi loginApi, ServerTimeRepository serverTimeRepository, BusinessLogicEventSubscriber businessLogicEventSubscriber, AnalyticsLogger analyticsLogger, LocationHeaderManager locationHeaderManager) {
            this.a = accountEntryModule;
            a(accountPasswordCreateModule, accountEntryModule, accountApiModule, profileApiModule, passportProfileModule, accountEmailConfirmModule, accountEmailEnterModule, accountPhoneEnterModule, accountPhoneConfirmModule, accountPasswordEnterModule, passwordFinishModule, technicalSupportModule, nicknameModule, selectAccountModule, loginEnterModule, confirmationHelpModule, authFinishingFailureModule, oauthFailureModule, context, lazy, lazy2, resultData, yooProfiler, accountApi, emailChangeApi, phoneChangeApi, passwordChangeApi, socialAccountApi, str, passwordRecoveryApi, clientAppParams, bool, enrollmentApi, loginApi, serverTimeRepository, businessLogicEventSubscriber, analyticsLogger, locationHeaderManager);
        }

        public final void a(AccountPasswordCreateModule accountPasswordCreateModule, AccountEntryModule accountEntryModule, AccountApiModule accountApiModule, ProfileApiModule profileApiModule, PassportProfileModule passportProfileModule, AccountEmailConfirmModule accountEmailConfirmModule, AccountEmailEnterModule accountEmailEnterModule, AccountPhoneEnterModule accountPhoneEnterModule, AccountPhoneConfirmModule accountPhoneConfirmModule, AccountPasswordEnterModule accountPasswordEnterModule, PasswordFinishModule passwordFinishModule, TechnicalSupportModule technicalSupportModule, NicknameModule nicknameModule, SelectAccountModule selectAccountModule, LoginEnterModule loginEnterModule, ConfirmationHelpModule confirmationHelpModule, AuthFinishingFailureModule authFinishingFailureModule, OauthFailureModule oauthFailureModule, Context context, Lazy lazy, Lazy lazy2, ResultData resultData, YooProfiler yooProfiler, AccountApi accountApi, EmailChangeApi emailChangeApi, PhoneChangeApi phoneChangeApi, PasswordChangeApi passwordChangeApi, SocialAccountApi socialAccountApi, String str, PasswordRecoveryApi passwordRecoveryApi, ClientAppParams clientAppParams, Boolean bool, EnrollmentApi enrollmentApi, LoginApi loginApi, ServerTimeRepository serverTimeRepository, BusinessLogicEventSubscriber businessLogicEventSubscriber, AnalyticsLogger analyticsLogger, LocationHeaderManager locationHeaderManager) {
            this.b = InstanceFactory.create(passwordChangeApi);
            this.c = InstanceFactory.create(str);
            Factory factoryCreate = InstanceFactory.create(locationHeaderManager);
            this.d = factoryCreate;
            this.e = ProfileApiModule_ChangePasswordRepositoryFactory.create(profileApiModule, this.b, this.c, factoryCreate);
            this.f = InstanceFactory.create(passwordRecoveryApi);
            this.g = InstanceFactory.create(clientAppParams);
            this.h = InstanceFactory.create(serverTimeRepository);
            Factory factoryCreate2 = InstanceFactory.create(bool);
            this.i = factoryCreate2;
            AccountApiModule_PasswordRecoveryRepositoryFactory accountApiModule_PasswordRecoveryRepositoryFactoryCreate = AccountApiModule_PasswordRecoveryRepositoryFactory.create(accountApiModule, this.f, this.g, this.h, factoryCreate2, this.d);
            this.j = accountApiModule_PasswordRecoveryRepositoryFactoryCreate;
            this.k = AccountPasswordCreateModule_AccountPasswordCreateInteractorFactory.create(accountPasswordCreateModule, this.e, accountApiModule_PasswordRecoveryRepositoryFactoryCreate, this.h);
            this.l = DoubleCheck.provider(AccountEntryModule_ProvideRouterFactory.create(accountEntryModule));
            this.m = DoubleCheck.provider(AccountEntryModule_ProvideProcessMapperFactory.create(accountEntryModule));
            Factory factoryCreate3 = InstanceFactory.create(context);
            this.n = factoryCreate3;
            this.o = AccountEntryModule_ProvideFailureMapperFactory.create(accountEntryModule, factoryCreate3);
            this.p = InstanceFactory.create(lazy2);
            this.q = InstanceFactory.create(lazy);
            Factory factoryCreateNullable = InstanceFactory.createNullable(analyticsLogger);
            this.r = factoryCreateNullable;
            this.s = AccountPasswordCreateModule_ProvidePasswordCreateFragmentFactory.create(accountPasswordCreateModule, this.k, this.l, this.m, this.o, this.p, this.q, factoryCreateNullable);
            this.t = AccountApiModule_AccountRepositoryFactory.create(accountApiModule, InstanceFactory.create(accountApi));
            this.u = ProfileApiModule_ChangeEmailRepositoryFactory.create(profileApiModule, InstanceFactory.create(emailChangeApi), this.c);
            this.v = ProfileApiModule_ChangePhoneRepositoryFactory.create(profileApiModule, InstanceFactory.create(phoneChangeApi), this.c, this.d);
            this.w = ProfileApiModule_SocialAccountRepositoryImplFactory.create(profileApiModule, InstanceFactory.create(socialAccountApi), this.c);
            Factory factoryCreate4 = InstanceFactory.create(yooProfiler);
            this.x = factoryCreate4;
            this.y = PassportProfileModule_PassportProfileInteractorFactory.create(passportProfileModule, this.t, this.u, this.v, this.e, this.w, this.h, this.q, factoryCreate4, this.g, this.n);
            Factory factoryCreate5 = InstanceFactory.create(resultData);
            this.z = factoryCreate5;
            this.A = PassportProfileModule_ProvideProfileFragmentFactory.create(passportProfileModule, this.y, factoryCreate5, this.q, this.l, this.m, this.o, this.r, this.p);
            this.B = AccountEmailConfirmModule_ProvideEmailConfirmFragmentFactory.create(accountEmailConfirmModule, AccountEmailConfirmModule_AccountEmailConfirmInteractorFactory.create(accountEmailConfirmModule, this.u, this.e, this.j, this.h), this.l, this.m, this.o, this.q, this.z, this.h);
            this.C = AccountEmailEnterModule_ProvideEnterEmailFragmentFactory.create(accountEmailEnterModule, AccountEmailEnterModule_AccountEmailEnterInteractorFactory.create(accountEmailEnterModule, this.u, this.h), this.l, this.m, this.o, this.z, this.p, this.q);
            this.D = AccountPhoneEnterModule_ProvidePhoneEnterFragmentFactory.create(accountPhoneEnterModule, AccountPhoneEnterModule_AccountPasswordEnterInteractorFactory.create(accountPhoneEnterModule, this.v, this.j, this.h), this.l, this.q, this.m, this.o, this.z, this.r);
            this.E = AccountPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory.create(accountPhoneConfirmModule, AccountPhoneConfirmModule_AccountPhoneConfirmInteractorFactory.create(accountPhoneConfirmModule, this.u, this.v, this.e, this.j, this.h), this.q, this.l, this.m, this.o, this.z, this.h);
            this.F = AccountPasswordEnterModule_ProvidePasswordEnterFragmentFactory.create(accountPasswordEnterModule, this.l, this.m, this.q, this.z, AccountPasswordEnterModule_AccountPasswordEnterInteractorFactory.create(accountPasswordEnterModule, this.j, this.h, this.u, this.e, this.x, this.q), this.o, this.r);
            this.G = PasswordFinishModule_ProvidePasswordFinishFragmentFactory.create(passwordFinishModule, this.q, this.l, this.m, this.o, InstanceFactory.create(businessLogicEventSubscriber), this.r);
            this.H = TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory.create(technicalSupportModule, this.q, this.l, this.m, this.o);
            this.I = NicknameModule_ProvideNicknameFragmentFactory.create(nicknameModule, this.z, this.q, this.l, this.m, this.o, NicknameModule_NicknameInteractorFactory.create(nicknameModule, this.t), this.r);
            this.J = AccountApiModule_LoginRepositoryFactory.create(accountApiModule, InstanceFactory.create(loginApi), this.g, this.h, this.i, this.d);
            this.K = SelectAccountModule_ProvideSelectAccountFragmentFactory.create(selectAccountModule, SelectAccountModule_SelectAccountInteractorFactory.create(selectAccountModule, this.h, this.J, this.j, AccountApiModule_EnrollmentRepositoryFactory.create(accountApiModule, InstanceFactory.create(enrollmentApi), this.g, this.h, this.i)), this.l, this.m, this.o, this.q, this.r);
            this.L = LoginEnterModule_ProvideLoginEnterFragmentFactory.create(loginEnterModule, this.q, LoginEnterModule_LoginEnterInteractorFactory.create(loginEnterModule, this.J, this.h), this.l, this.m, this.o, this.z, this.r);
            this.M = ConfirmationHelpModule_ProvideConfirmationHelpFragmentFactory.create(confirmationHelpModule, this.q, this.l, this.m, this.o);
            this.N = AuthFinishingFailureModule_ProvideAuthFinishingFailureFragmentFactory.create(authFinishingFailureModule, this.q, this.l, this.m, this.o);
            this.O = OauthFailureModule_ProvideOauthFailureFragmentFactory.create(oauthFailureModule, this.l, this.m, this.o);
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent
        public final ActivityFragmentFactory factory() {
            return AccountEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory.providesAuthEntryActivityFragmentFactory(this.a, MapBuilder.newMapBuilder(15).put(PasswordCreateFragment.class, this.s).put(PassportProfileFragment.class, this.A).put(EmailConfirmFragment.class, this.B).put(EmailEnterFragment.class, this.C).put(PhoneEnterFragment.class, this.D).put(PhoneConfirmFragment.class, this.E).put(PasswordEnterFragment.class, this.F).put(PasswordFinishFragment.class, this.G).put(TechnicalSupportFragment.class, this.H).put(NicknameFragment.class, this.I).put(SelectAccountFragment.class, this.K).put(LoginEnterFragment.class, this.L).put(ConfirmationHelpFragment.class, this.M).put(AuthFinishingFailureFragment.class, this.N).put(OauthFailureFragment.class, this.O).build());
        }
    }

    public static final class b implements AccountEntryActivityComponent.Builder {
        public Context a;
        public Lazy<Config> b;
        public Lazy<RemoteConfig> c;
        public ResultData d;
        public YooProfiler e;
        public AccountApi f;
        public EmailChangeApi g;
        public PhoneChangeApi h;
        public PasswordChangeApi i;
        public SocialAccountApi j;
        public String k;
        public PasswordRecoveryApi l;
        public ClientAppParams m;
        public Boolean n;
        public EnrollmentApi o;
        public MigrationApi p;
        public LoginApi q;
        public ServerTimeRepository r;
        public BusinessLogicEventSubscriber s;
        public AnalyticsLogger t;
        public LocationHeaderManager u;

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder accountApi(AccountApi accountApi) {
            this.f = (AccountApi) Preconditions.checkNotNull(accountApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder accountToken(String str) {
            this.k = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder analyticsLogger(AnalyticsLogger analyticsLogger) {
            this.t = analyticsLogger;
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Context.class);
            Preconditions.checkBuilderRequirement(this.b, Lazy.class);
            Preconditions.checkBuilderRequirement(this.c, Lazy.class);
            Preconditions.checkBuilderRequirement(this.d, ResultData.class);
            Preconditions.checkBuilderRequirement(this.e, YooProfiler.class);
            Preconditions.checkBuilderRequirement(this.f, AccountApi.class);
            Preconditions.checkBuilderRequirement(this.g, EmailChangeApi.class);
            Preconditions.checkBuilderRequirement(this.h, PhoneChangeApi.class);
            Preconditions.checkBuilderRequirement(this.i, PasswordChangeApi.class);
            Preconditions.checkBuilderRequirement(this.j, SocialAccountApi.class);
            Preconditions.checkBuilderRequirement(this.k, String.class);
            Preconditions.checkBuilderRequirement(this.l, PasswordRecoveryApi.class);
            Preconditions.checkBuilderRequirement(this.m, ClientAppParams.class);
            Preconditions.checkBuilderRequirement(this.n, Boolean.class);
            Preconditions.checkBuilderRequirement(this.o, EnrollmentApi.class);
            Preconditions.checkBuilderRequirement(this.p, MigrationApi.class);
            Preconditions.checkBuilderRequirement(this.q, LoginApi.class);
            Preconditions.checkBuilderRequirement(this.r, ServerTimeRepository.class);
            Preconditions.checkBuilderRequirement(this.s, BusinessLogicEventSubscriber.class);
            Preconditions.checkBuilderRequirement(this.u, LocationHeaderManager.class);
            return new a(new AccountPasswordCreateModule(), new AccountEntryModule(), new AccountApiModule(), new ProfileApiModule(), new PassportProfileModule(), new AccountEmailConfirmModule(), new AccountEmailEnterModule(), new AccountPhoneEnterModule(), new AccountPhoneConfirmModule(), new AccountPasswordEnterModule(), new PasswordFinishModule(), new TechnicalSupportModule(), new NicknameModule(), new SelectAccountModule(), new LoginEnterModule(), new ConfirmationHelpModule(), new AuthFinishingFailureModule(), new OauthFailureModule(), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.u);
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder businessLogicEventSubscriber(BusinessLogicEventSubscriber businessLogicEventSubscriber) {
            this.s = (BusinessLogicEventSubscriber) Preconditions.checkNotNull(businessLogicEventSubscriber);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder clientIdContainer(ClientAppParams clientAppParams) {
            this.m = (ClientAppParams) Preconditions.checkNotNull(clientAppParams);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder config(Lazy lazy) {
            this.b = (Lazy) Preconditions.checkNotNull(lazy);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder context(Context context) {
            this.a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder emailChangeApi(EmailChangeApi emailChangeApi) {
            this.g = (EmailChangeApi) Preconditions.checkNotNull(emailChangeApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder enrollmentApi(EnrollmentApi enrollmentApi) {
            this.o = (EnrollmentApi) Preconditions.checkNotNull(enrollmentApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder isDebugMode(boolean z) {
            this.n = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder locationHeaderManager(LocationHeaderManager locationHeaderManager) {
            this.u = (LocationHeaderManager) Preconditions.checkNotNull(locationHeaderManager);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder loginApi(LoginApi loginApi) {
            this.q = (LoginApi) Preconditions.checkNotNull(loginApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder migrationApi(MigrationApi migrationApi) {
            this.p = (MigrationApi) Preconditions.checkNotNull(migrationApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder passwordChangeApi(PasswordChangeApi passwordChangeApi) {
            this.i = (PasswordChangeApi) Preconditions.checkNotNull(passwordChangeApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder passwordRecoveryApi(PasswordRecoveryApi passwordRecoveryApi) {
            this.l = (PasswordRecoveryApi) Preconditions.checkNotNull(passwordRecoveryApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder phoneChangeApi(PhoneChangeApi phoneChangeApi) {
            this.h = (PhoneChangeApi) Preconditions.checkNotNull(phoneChangeApi);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder profiler(YooProfiler yooProfiler) {
            this.e = (YooProfiler) Preconditions.checkNotNull(yooProfiler);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder remoteConfig(Lazy lazy) {
            this.c = (Lazy) Preconditions.checkNotNull(lazy);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder resultData(ResultData resultData) {
            this.d = (ResultData) Preconditions.checkNotNull(resultData);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder serverTimeRepository(ServerTimeRepository serverTimeRepository) {
            this.r = (ServerTimeRepository) Preconditions.checkNotNull(serverTimeRepository);
            return this;
        }

        @Override // ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent.Builder
        public final AccountEntryActivityComponent.Builder socialAccountApi(SocialAccountApi socialAccountApi) {
            this.j = (SocialAccountApi) Preconditions.checkNotNull(socialAccountApi);
            return this;
        }
    }

    private DaggerAccountEntryActivityComponent() {
    }

    public static AccountEntryActivityComponent.Builder builder() {
        return new b();
    }
}
