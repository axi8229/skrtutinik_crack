package sputnik.axmor.com.sputnik.ui.root;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SputnikRootActivity.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"sputnik/axmor/com/sputnik/ui/root/SputnikRootActivity$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SputnikRootActivity$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ SputnikRootActivity this$0;

    SputnikRootActivity$networkCallback$1(SputnikRootActivity sputnikRootActivity) {
        this.this$0 = sputnikRootActivity;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        this.this$0.isInternetConnected = true;
        Log.e("has internet", "true");
        this.this$0.setNormalState();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        this.this$0.isInternetConnected = false;
        Log.e("has internet", "false");
        this.this$0.setNoInternetState();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        ConnectivityManager connectivityManager = this.this$0.getConnectivityManager();
        NetworkCapabilities networkCapabilities2 = connectivityManager != null ? connectivityManager.getNetworkCapabilities(network) : null;
        final boolean zHasTransport = networkCapabilities2 != null ? networkCapabilities2.hasTransport(4) : false;
        final SputnikRootActivity sputnikRootActivity = this.this$0;
        sputnikRootActivity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity$networkCallback$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SputnikRootActivity$networkCallback$1.onCapabilitiesChanged$lambda$0(sputnikRootActivity, zHasTransport);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCapabilitiesChanged$lambda$0(SputnikRootActivity this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getStateViewModel().updateIsVpnEnabled(z);
    }
}
