package ru.yoomoney.sdk.two_fa.exception;

import java.io.InterruptedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseExceptionResolver.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/BaseExceptionResolver;", "Lru/yoomoney/sdk/two_fa/exception/ExceptionResolver;", "()V", "resolve", "Lru/yoomoney/sdk/two_fa/exception/Failure;", "e", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BaseExceptionResolver implements ExceptionResolver {
    public static final int $stable = 0;

    @Override // ru.yoomoney.sdk.two_fa.exception.ExceptionResolver
    public Failure resolve(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (e instanceof SocketException ? true : e instanceof SocketTimeoutException ? true : e instanceof UnknownHostException) {
            return new NetworkConnectionFailure(e.getMessage());
        }
        if (e instanceof InterruptedIOException) {
            return new ProcessingRequestFailure(e.getMessage(), null, 2, null);
        }
        if (!(e instanceof UndeclaredThrowableException)) {
            return new TechnicalFailure(e.getMessage());
        }
        Throwable undeclaredThrowable = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
        Intrinsics.checkNotNullExpressionValue(undeclaredThrowable, "getUndeclaredThrowable(...)");
        return resolve(undeclaredThrowable);
    }
}
