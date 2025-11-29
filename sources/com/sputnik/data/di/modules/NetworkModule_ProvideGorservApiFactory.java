package com.sputnik.data.di.modules;

import com.sputnik.data.api.GorservApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideGorservApiFactory implements Factory<GorservApi> {
    public static GorservApi provideGorservApi(NetworkModule networkModule, Retrofit retrofit) {
        return (GorservApi) Preconditions.checkNotNullFromProvides(networkModule.provideGorservApi(retrofit));
    }
}
