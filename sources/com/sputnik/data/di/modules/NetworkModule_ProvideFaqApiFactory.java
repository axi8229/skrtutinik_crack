package com.sputnik.data.di.modules;

import com.sputnik.data.api.SupportApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideFaqApiFactory implements Factory<SupportApi> {
    public static SupportApi provideFaqApi(NetworkModule networkModule, Retrofit retrofit) {
        return (SupportApi) Preconditions.checkNotNullFromProvides(networkModule.provideFaqApi(retrofit));
    }
}
