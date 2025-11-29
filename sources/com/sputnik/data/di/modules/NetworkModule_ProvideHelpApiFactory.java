package com.sputnik.data.di.modules;

import com.sputnik.data.api.HelpApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideHelpApiFactory implements Factory<HelpApi> {
    public static HelpApi provideHelpApi(NetworkModule networkModule, Retrofit retrofit) {
        return (HelpApi) Preconditions.checkNotNullFromProvides(networkModule.provideHelpApi(retrofit));
    }
}
