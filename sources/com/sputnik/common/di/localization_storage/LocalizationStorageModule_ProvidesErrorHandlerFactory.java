package com.sputnik.common.di.localization_storage;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes3.dex */
public final class LocalizationStorageModule_ProvidesErrorHandlerFactory implements Factory<CoroutineExceptionHandler> {
    public static CoroutineExceptionHandler providesErrorHandler(LocalizationStorageModule localizationStorageModule) {
        return (CoroutineExceptionHandler) Preconditions.checkNotNullFromProvides(localizationStorageModule.providesErrorHandler());
    }
}
