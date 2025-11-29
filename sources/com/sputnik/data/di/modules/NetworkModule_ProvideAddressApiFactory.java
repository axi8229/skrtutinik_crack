package com.sputnik.data.di.modules;

import com.sputnik.data.api.AddressApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideAddressApiFactory implements Factory<AddressApi> {
    public static AddressApi provideAddressApi(NetworkModule networkModule, Retrofit retrofit) {
        return (AddressApi) Preconditions.checkNotNullFromProvides(networkModule.provideAddressApi(retrofit));
    }
}
