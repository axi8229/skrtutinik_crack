package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes2.dex */
public final class Api<O extends ApiOptions> {
    private final AbstractClientBuilder zaa;
    private final ClientKey zab;
    private final String zac;

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @KeepForSdk
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @KeepForSdk
        @Deprecated
        public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return (T) buildClient(context, looper, clientSettings, (ClientSettings) o, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        }

        @KeepForSdk
        public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @KeepForSdk
    public interface AnyClient {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @KeepForSdk
    public static class AnyClientKey<C extends AnyClient> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    public interface ApiOptions {
        public static final NoOptions NO_OPTIONS = new NoOptions(null);

        /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
        public interface HasOptions extends ApiOptions {
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }

            /* synthetic */ NoOptions(zaa zaaVar) {
            }
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @KeepForSdk
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {

        @KeepForSdk
        public static final int API_PRIORITY_GAMES = 1;

        @KeepForSdk
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;

        @KeepForSdk
        public static final int API_PRIORITY_PLUS = 2;

        @KeepForSdk
        public List<Scope> getImpliedScopes(O o) {
            return Collections.emptyList();
        }

        @KeepForSdk
        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @KeepForSdk
    public interface Client extends AnyClient {
        @KeepForSdk
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        @KeepForSdk
        void disconnect();

        @KeepForSdk
        void disconnect(String str);

        @KeepForSdk
        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        @KeepForSdk
        Feature[] getAvailableFeatures();

        @KeepForSdk
        String getEndpointPackageName();

        @KeepForSdk
        String getLastDisconnectMessage();

        @KeepForSdk
        int getMinApkVersion();

        @KeepForSdk
        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        @KeepForSdk
        Feature[] getRequiredFeatures();

        @KeepForSdk
        Set<Scope> getScopesForConnectionlessNonSignIn();

        @KeepForSdk
        IBinder getServiceBrokerBinder();

        @KeepForSdk
        Intent getSignInIntent();

        @KeepForSdk
        boolean isConnected();

        @KeepForSdk
        boolean isConnecting();

        @KeepForSdk
        void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        @KeepForSdk
        boolean providesSignIn();

        @KeepForSdk
        boolean requiresAccount();

        @KeepForSdk
        boolean requiresGooglePlayServices();

        @KeepForSdk
        boolean requiresSignIn();
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @KeepForSdk
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    @KeepForSdk
    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        Preconditions.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.zac = str;
        this.zaa = abstractClientBuilder;
        this.zab = clientKey;
    }

    public final AbstractClientBuilder zaa() {
        return this.zaa;
    }

    public final AnyClientKey zab() {
        return this.zab;
    }

    public final BaseClientBuilder zac() {
        return this.zaa;
    }

    public final String zad() {
        return this.zac;
    }
}
