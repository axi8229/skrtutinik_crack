package com.sputnik.common.di.localization_storage;

import android.app.Application;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes3.dex */
public final class LocalizationStorageModule_ProvideLocalizationStorageFactory implements Factory<LocalizationStorage> {
    public static LocalizationStorage provideLocalizationStorage(LocalizationStorageModule localizationStorageModule, Application application, PrefManager prefManager, CoroutineScope coroutineScope) {
        return (LocalizationStorage) Preconditions.checkNotNullFromProvides(localizationStorageModule.provideLocalizationStorage(application, prefManager, coroutineScope));
    }
}
