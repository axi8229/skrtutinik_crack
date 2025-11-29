package com.sputnik.data.di.modules;

import com.sputnik.data.api.TilesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideTilesApiFactory implements Factory<TilesApi> {
    public static TilesApi provideTilesApi(NetworkModule networkModule, Retrofit retrofit) {
        return (TilesApi) Preconditions.checkNotNullFromProvides(networkModule.provideTilesApi(retrofit));
    }
}
