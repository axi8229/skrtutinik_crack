package com.sputnik.data.di.modules;

import com.sputnik.data.api.SubscriptionApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideSubscriptionApiFactory implements Factory<SubscriptionApi> {
    public static SubscriptionApi provideSubscriptionApi(NetworkModule networkModule, Retrofit retrofit) {
        return (SubscriptionApi) Preconditions.checkNotNullFromProvides(networkModule.provideSubscriptionApi(retrofit));
    }
}
