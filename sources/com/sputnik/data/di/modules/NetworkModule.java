package com.sputnik.data.di.modules;

import android.app.Application;
import android.util.Log;
import com.mocklets.pluto.PlutoInterceptor;
import com.sputnik.data.IConfig;
import com.sputnik.data.api.AddressApi;
import com.sputnik.data.api.AlertsApi;
import com.sputnik.data.api.AuthApi;
import com.sputnik.data.api.CallApi;
import com.sputnik.data.api.CamerasApi;
import com.sputnik.data.api.CardApi;
import com.sputnik.data.api.ConnectIntercomApi;
import com.sputnik.data.api.DigitalKeysApi;
import com.sputnik.data.api.EventApi;
import com.sputnik.data.api.FamilyApi;
import com.sputnik.data.api.GorservApi;
import com.sputnik.data.api.HelpApi;
import com.sputnik.data.api.InvitesApi;
import com.sputnik.data.api.LocalizationApi;
import com.sputnik.data.api.MarketApi;
import com.sputnik.data.api.NotificationsApi;
import com.sputnik.data.api.PhysicalKeysApi;
import com.sputnik.data.api.PopupStoriesApi;
import com.sputnik.data.api.ProfileApi;
import com.sputnik.data.api.ServicePaymentsApi;
import com.sputnik.data.api.ServicesApi;
import com.sputnik.data.api.StoriesApi;
import com.sputnik.data.api.SubscriptionApi;
import com.sputnik.data.api.SupportApi;
import com.sputnik.data.api.SurveyApi;
import com.sputnik.data.api.TilesApi;
import com.sputnik.data.local.PrefManager;
import com.sputnik.data.processors.SecurityInterceptor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: NetworkModule.kt */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u001f2\b\b\u0001\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u0002072\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020:2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020@2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020C2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020F2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020I2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\u00020L2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020O2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001a\u00020R2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020U2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bV\u0010WJ\u0019\u0010Y\u001a\u00020X2\b\b\u0001\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020[2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\\\u0010]J\u0017\u0010_\u001a\u00020^2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b_\u0010`J\u0017\u0010b\u001a\u00020a2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\bb\u0010cJ\u0019\u0010e\u001a\u00020d2\b\b\u0001\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\be\u0010f¨\u0006g"}, d2 = {"Lcom/sputnik/data/di/modules/NetworkModule;", "", "<init>", "()V", "Landroid/app/Application;", "application", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/IConfig;", "config", "Lokhttp3/OkHttpClient$Builder;", "provideBaseOkHttp", "(Landroid/app/Application;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/data/IConfig;)Lokhttp3/OkHttpClient$Builder;", "okHttpClientBuilder", "Lokhttp3/OkHttpClient;", "provideOkHttpNoJwt", "(Lokhttp3/OkHttpClient$Builder;)Lokhttp3/OkHttpClient;", "provideOkHttp", "(Lokhttp3/OkHttpClient$Builder;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/data/IConfig;)Lokhttp3/OkHttpClient;", "okHttpClient", "Lretrofit2/Retrofit;", "provideProdRetrofit", "(Lcom/sputnik/data/IConfig;Lokhttp3/OkHttpClient;Lcom/sputnik/data/local/PrefManager;)Lretrofit2/Retrofit;", "provideBaseProdRetrofit", "retrofit", "Lcom/sputnik/data/api/ProfileApi;", "provideProfileApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/ProfileApi;", "Lcom/sputnik/data/api/AddressApi;", "provideAddressApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/AddressApi;", "Lcom/sputnik/data/api/AuthApi;", "provideAuthApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/AuthApi;", "Lcom/sputnik/data/api/CallApi;", "provideCallApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/CallApi;", "Lcom/sputnik/data/api/CamerasApi;", "provideCamerasApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/CamerasApi;", "Lcom/sputnik/data/api/CardApi;", "provideCardApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/CardApi;", "Lcom/sputnik/data/api/ConnectIntercomApi;", "provideConnectIntercomApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/ConnectIntercomApi;", "Lcom/sputnik/data/api/DigitalKeysApi;", "provideDigitalKeysApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/DigitalKeysApi;", "Lcom/sputnik/data/api/EventApi;", "provideEventApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/EventApi;", "Lcom/sputnik/data/api/FamilyApi;", "provideFamilyApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/FamilyApi;", "Lcom/sputnik/data/api/HelpApi;", "provideHelpApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/HelpApi;", "Lcom/sputnik/data/api/LocalizationApi;", "provideLocalizationApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/LocalizationApi;", "Lcom/sputnik/data/api/MarketApi;", "provideMarketApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/MarketApi;", "Lcom/sputnik/data/api/SubscriptionApi;", "provideSubscriptionApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/SubscriptionApi;", "Lcom/sputnik/data/api/SurveyApi;", "provideSurveyApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/SurveyApi;", "Lcom/sputnik/data/api/NotificationsApi;", "provideNotificationsApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/NotificationsApi;", "Lcom/sputnik/data/api/SupportApi;", "provideFaqApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/SupportApi;", "Lcom/sputnik/data/api/InvitesApi;", "provideInvitesApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/InvitesApi;", "Lcom/sputnik/data/api/PhysicalKeysApi;", "providePhysicalKeysApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/PhysicalKeysApi;", "Lcom/sputnik/data/api/ServicesApi;", "provideServicesApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/ServicesApi;", "Lcom/sputnik/data/api/GorservApi;", "provideGorservApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/GorservApi;", "Lcom/sputnik/data/api/StoriesApi;", "provideStoriesApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/StoriesApi;", "Lcom/sputnik/data/api/ServicePaymentsApi;", "provideServicePaymentsApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/ServicePaymentsApi;", "Lcom/sputnik/data/api/AlertsApi;", "provideAlertsApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/AlertsApi;", "Lcom/sputnik/data/api/PopupStoriesApi;", "providePopupStoriesApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/PopupStoriesApi;", "Lcom/sputnik/data/api/TilesApi;", "provideTilesApi", "(Lretrofit2/Retrofit;)Lcom/sputnik/data/api/TilesApi;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkModule {
    public final OkHttpClient.Builder provideBaseOkHttp(Application application, final PrefManager prefManager, final IConfig config) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(config, "config");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        return builder.connectTimeout(1L, timeUnit).readTimeout(1L, timeUnit).writeTimeout(1L, timeUnit).addInterceptor(SecurityInterceptor.INSTANCE).addInterceptor(new Interceptor() { // from class: com.sputnik.data.di.modules.NetworkModule$provideBaseOkHttp$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                return chain.proceed(chain.request().newBuilder().header("jwt", prefManager.getJwtToken()).header("X-App-Version", config.getVersionName() + "(" + config.getVersionCode() + ")").header("X-App-Name", config.getPlatformKeyName()).build());
            }
        }).addInterceptor(new PlutoInterceptor());
    }

    public final OkHttpClient provideOkHttpNoJwt(OkHttpClient.Builder okHttpClientBuilder) {
        Intrinsics.checkNotNullParameter(okHttpClientBuilder, "okHttpClientBuilder");
        return okHttpClientBuilder.build();
    }

    public final OkHttpClient provideOkHttp(OkHttpClient.Builder okHttpClientBuilder, PrefManager prefManager, IConfig config) {
        Intrinsics.checkNotNullParameter(okHttpClientBuilder, "okHttpClientBuilder");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(config, "config");
        return okHttpClientBuilder.build();
    }

    public final Retrofit provideProdRetrofit(IConfig config, OkHttpClient okHttpClient, PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl("https://api-mobile-gorod.sputnik.systems/api/mobile/v2/").client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        Log.e("DAGGER", "ProdRetrofit");
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "also(...)");
        return retrofitBuild;
    }

    public final Retrofit provideBaseProdRetrofit(IConfig config, OkHttpClient okHttpClient, PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(prefManager.getBaseUrl()).baseUrl("https://api-mobile-gorod.sputnik.systems/api/mobile/v2/").client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        Log.e("DAGGER", "ProdRetrofitNoJwt");
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "also(...)");
        return retrofitBuild;
    }

    public final ProfileApi provideProfileApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(ProfileApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ProfileApi) objCreate;
    }

    public final AddressApi provideAddressApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(AddressApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (AddressApi) objCreate;
    }

    public final AuthApi provideAuthApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(AuthApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (AuthApi) objCreate;
    }

    public final CallApi provideCallApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(CallApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (CallApi) objCreate;
    }

    public final CamerasApi provideCamerasApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(CamerasApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (CamerasApi) objCreate;
    }

    public final CardApi provideCardApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(CardApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (CardApi) objCreate;
    }

    public final ConnectIntercomApi provideConnectIntercomApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(ConnectIntercomApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ConnectIntercomApi) objCreate;
    }

    public final DigitalKeysApi provideDigitalKeysApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(DigitalKeysApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (DigitalKeysApi) objCreate;
    }

    public final EventApi provideEventApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(EventApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (EventApi) objCreate;
    }

    public final FamilyApi provideFamilyApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(FamilyApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (FamilyApi) objCreate;
    }

    public final HelpApi provideHelpApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(HelpApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (HelpApi) objCreate;
    }

    public final LocalizationApi provideLocalizationApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(LocalizationApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (LocalizationApi) objCreate;
    }

    public final MarketApi provideMarketApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(MarketApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (MarketApi) objCreate;
    }

    public final SubscriptionApi provideSubscriptionApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(SubscriptionApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (SubscriptionApi) objCreate;
    }

    public final SurveyApi provideSurveyApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(SurveyApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (SurveyApi) objCreate;
    }

    public final NotificationsApi provideNotificationsApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(NotificationsApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (NotificationsApi) objCreate;
    }

    public final SupportApi provideFaqApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(SupportApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (SupportApi) objCreate;
    }

    public final InvitesApi provideInvitesApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(InvitesApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (InvitesApi) objCreate;
    }

    public final PhysicalKeysApi providePhysicalKeysApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(PhysicalKeysApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (PhysicalKeysApi) objCreate;
    }

    public final ServicesApi provideServicesApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(ServicesApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ServicesApi) objCreate;
    }

    public final GorservApi provideGorservApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(GorservApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (GorservApi) objCreate;
    }

    public final StoriesApi provideStoriesApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(StoriesApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (StoriesApi) objCreate;
    }

    public final ServicePaymentsApi provideServicePaymentsApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(ServicePaymentsApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ServicePaymentsApi) objCreate;
    }

    public final AlertsApi provideAlertsApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(AlertsApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (AlertsApi) objCreate;
    }

    public final PopupStoriesApi providePopupStoriesApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(PopupStoriesApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (PopupStoriesApi) objCreate;
    }

    public final TilesApi provideTilesApi(Retrofit retrofit) throws SecurityException {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(TilesApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (TilesApi) objCreate;
    }
}
