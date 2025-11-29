package com.sputnik.data.di.modules;

import com.sputnik.data.api.CallApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideCallApiFactory implements Factory<CallApi> {
    public static CallApi provideCallApi(NetworkModule networkModule, Retrofit retrofit) {
        return (CallApi) Preconditions.checkNotNullFromProvides(networkModule.provideCallApi(retrofit));
    }
}
