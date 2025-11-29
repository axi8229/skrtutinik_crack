package com.google.firebase.database.android;

import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class AndroidAuthTokenProvider implements TokenProvider {
    private final Deferred<InternalAuthProvider> deferredAuthProvider;
    private final AtomicReference<InternalAuthProvider> internalAuth = new AtomicReference<>();

    public AndroidAuthTokenProvider(Deferred<InternalAuthProvider> deferred) {
        this.deferredAuthProvider = deferred;
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.database.android.AndroidAuthTokenProvider$$ExternalSyntheticLambda0
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                this.f$0.lambda$new$0(provider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.internalAuth.set((InternalAuthProvider) provider.get());
    }
}
