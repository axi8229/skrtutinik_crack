package com.sputnik.common.di.localization_storage;

import android.app.Application;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: LocalizationStorageModule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/di/localization_storage/LocalizationStorageModule;", "", "()V", "provideCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "errorHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "provideLocalizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "context", "Landroid/app/Application;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "scope", "providesErrorHandler", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalizationStorageModule {
    public final CoroutineScope provideCoroutineScope(CoroutineExceptionHandler errorHandler) {
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(errorHandler));
    }

    public final LocalizationStorage provideLocalizationStorage(Application context, PrefManager prefManager, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new LocalizationStorage(context, prefManager, scope);
    }

    public final CoroutineExceptionHandler providesErrorHandler() {
        return new LocalizationStorageModule$providesErrorHandler$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
    }
}
