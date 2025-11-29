package coil.content;

import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import coil.content.C0578Contexts;
import coil.content.Logger;
import coil.content.Logs;
import coil.content.NetworkObserver;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: NetworkObserver.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "Lcoil/network/NetworkObserver$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcoil/util/Logger;", "logger", "Lcoil/network/NetworkObserver;", "NetworkObserver", "(Landroid/content/Context;Lcoil/network/NetworkObserver$Listener;Lcoil/util/Logger;)Lcoil/network/NetworkObserver;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.network.NetworkObserverKt, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class Context {
    public static final NetworkObserver NetworkObserver(android.content.Context context, NetworkObserver.Listener listener, Logger logger) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
        if (connectivityManager == null || !C0578Contexts.isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (logger != null && logger.getLevel() <= 5) {
                logger.log("NetworkObserver", 5, "Unable to register network observer.", null);
            }
            return new EmptyNetworkObserver();
        }
        try {
            return new RealNetworkObserver(connectivityManager, listener);
        } catch (Exception e) {
            if (logger != null) {
                Logs.log(logger, "NetworkObserver", new RuntimeException("Failed to register network observer.", e));
            }
            return new EmptyNetworkObserver();
        }
    }
}
