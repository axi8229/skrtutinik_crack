package com.sputnik.data.di.modules;

import com.sputnik.data.api.FamilyApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideFamilyApiFactory implements Factory<FamilyApi> {
    public static FamilyApi provideFamilyApi(NetworkModule networkModule, Retrofit retrofit) {
        return (FamilyApi) Preconditions.checkNotNullFromProvides(networkModule.provideFamilyApi(retrofit));
    }
}
