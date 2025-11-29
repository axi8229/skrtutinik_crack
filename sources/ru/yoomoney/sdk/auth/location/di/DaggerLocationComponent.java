package ru.yoomoney.sdk.auth.location.di;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import ru.yoomoney.sdk.auth.location.GoogleLocationService;
import ru.yoomoney.sdk.auth.location.GoogleLocationService_MembersInjector;
import ru.yoomoney.sdk.auth.location.HuaweiLocationService;
import ru.yoomoney.sdk.auth.location.HuaweiLocationService_MembersInjector;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;
import ru.yoomoney.sdk.auth.location.di.LocationComponent;

/* loaded from: classes4.dex */
public final class DaggerLocationComponent {

    public static final class a implements LocationComponent.Builder {
        public Context a;

        @Override // ru.yoomoney.sdk.auth.location.di.LocationComponent.Builder
        public final LocationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Context.class);
            return new b(this.a);
        }

        @Override // ru.yoomoney.sdk.auth.location.di.LocationComponent.Builder
        public final LocationComponent.Builder context(Context context) {
            this.a = (Context) Preconditions.checkNotNull(context);
            return this;
        }
    }

    public static final class b implements LocationComponent {
        public Factory a;
        public Provider<FusedLocationProviderClient> b;
        public Provider<LocationHeaderManager> c;
        public Provider<com.huawei.hms.location.FusedLocationProviderClient> d;

        public b(Context context) {
            a(context);
        }

        public final void a(Context context) {
            Factory factoryCreate = InstanceFactory.create(context);
            this.a = factoryCreate;
            this.b = DoubleCheck.provider(LocationModule_ProvideGoogleFusedLocationProviderClientFactory.create(factoryCreate));
            this.c = DoubleCheck.provider(LocationModule_ProvideLocationHeaderManagerFactory.create());
            this.d = DoubleCheck.provider(LocationModule_ProvideHuaweiFusedLocationProviderClientFactory.create(this.a));
        }

        @Override // ru.yoomoney.sdk.auth.location.di.LocationComponent
        public final void inject(GoogleLocationService googleLocationService) {
            GoogleLocationService_MembersInjector.injectFusedLocationClient(googleLocationService, this.b.get());
            GoogleLocationService_MembersInjector.injectLocationHeaderManager(googleLocationService, this.c.get());
        }

        @Override // ru.yoomoney.sdk.auth.location.di.LocationComponent
        public final LocationHeaderManager locationHeaderManager() {
            return this.c.get();
        }

        @Override // ru.yoomoney.sdk.auth.location.di.LocationComponent
        public final void inject(HuaweiLocationService huaweiLocationService) {
            HuaweiLocationService_MembersInjector.injectFusedLocationClient(huaweiLocationService, this.d.get());
            HuaweiLocationService_MembersInjector.injectLocationHeaderManager(huaweiLocationService, this.c.get());
        }
    }

    private DaggerLocationComponent() {
    }

    public static LocationComponent.Builder builder() {
        return new a();
    }
}
