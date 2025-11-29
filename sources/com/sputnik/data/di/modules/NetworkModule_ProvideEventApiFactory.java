package com.sputnik.data.di.modules;

import com.sputnik.data.api.EventApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideEventApiFactory implements Factory<EventApi> {
    public static EventApi provideEventApi(NetworkModule networkModule, Retrofit retrofit) {
        return (EventApi) Preconditions.checkNotNullFromProvides(networkModule.provideEventApi(retrofit));
    }
}
