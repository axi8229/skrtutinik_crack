package com.sputnik.data.di.modules;

import com.sputnik.data.api.DigitalKeysApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideDigitalKeysApiFactory implements Factory<DigitalKeysApi> {
    public static DigitalKeysApi provideDigitalKeysApi(NetworkModule networkModule, Retrofit retrofit) {
        return (DigitalKeysApi) Preconditions.checkNotNullFromProvides(networkModule.provideDigitalKeysApi(retrofit));
    }
}
