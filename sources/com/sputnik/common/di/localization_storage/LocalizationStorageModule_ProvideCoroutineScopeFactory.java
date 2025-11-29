package com.sputnik.common.di.localization_storage;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes3.dex */
public final class LocalizationStorageModule_ProvideCoroutineScopeFactory implements Factory<CoroutineScope> {
    public static CoroutineScope provideCoroutineScope(LocalizationStorageModule localizationStorageModule, CoroutineExceptionHandler coroutineExceptionHandler) {
        return (CoroutineScope) Preconditions.checkNotNullFromProvides(localizationStorageModule.provideCoroutineScope(coroutineExceptionHandler));
    }
}
