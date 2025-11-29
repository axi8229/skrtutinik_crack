package com.sputnik.data.di.modules;

import com.sputnik.data.api.ServicesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideServicesApiFactory implements Factory<ServicesApi> {
    public static ServicesApi provideServicesApi(NetworkModule networkModule, Retrofit retrofit) {
        return (ServicesApi) Preconditions.checkNotNullFromProvides(networkModule.provideServicesApi(retrofit));
    }
}
