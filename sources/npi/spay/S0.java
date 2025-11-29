package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class S0 implements HttpLoggingInterceptor.Logger {
    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public final void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Timber.INSTANCE.i(message, new Object[0]);
    }
}
