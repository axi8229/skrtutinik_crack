package com.sputnik.data.di.modules;

import com.sputnik.data.api.NotificationsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideNotificationsApiFactory implements Factory<NotificationsApi> {
    public static NotificationsApi provideNotificationsApi(NetworkModule networkModule, Retrofit retrofit) {
        return (NotificationsApi) Preconditions.checkNotNullFromProvides(networkModule.provideNotificationsApi(retrofit));
    }
}
