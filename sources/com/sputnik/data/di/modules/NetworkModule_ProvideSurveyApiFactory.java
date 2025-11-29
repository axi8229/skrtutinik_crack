package com.sputnik.data.di.modules;

import com.sputnik.data.api.SurveyApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideSurveyApiFactory implements Factory<SurveyApi> {
    public static SurveyApi provideSurveyApi(NetworkModule networkModule, Retrofit retrofit) {
        return (SurveyApi) Preconditions.checkNotNullFromProvides(networkModule.provideSurveyApi(retrofit));
    }
}
