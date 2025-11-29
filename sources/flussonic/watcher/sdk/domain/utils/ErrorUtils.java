package flussonic.watcher.sdk.domain.utils;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import retrofit2.HttpException;

/* loaded from: classes3.dex */
public class ErrorUtils {
    public static boolean isNoInternetError(Throwable throwable) {
        return (throwable instanceof SocketException) || (throwable instanceof SocketTimeoutException) || (throwable instanceof UnknownHostException) || (throwable instanceof HttpException) || (throwable != null && isNoInternetError(throwable.getCause()));
    }
}
