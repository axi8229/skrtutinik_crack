package com.sputnik.data.di.modules;

import com.sputnik.data.api.CardApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideCardApiFactory implements Factory<CardApi> {
    public static CardApi provideCardApi(NetworkModule networkModule, Retrofit retrofit) {
        return (CardApi) Preconditions.checkNotNullFromProvides(networkModule.provideCardApi(retrofit));
    }
}
