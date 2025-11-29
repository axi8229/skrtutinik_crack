package com.google.firebase.database.android;

import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class AndroidAppCheckTokenProvider implements TokenProvider {
    private final Deferred<InternalAppCheckTokenProvider> deferredAppCheckProvider;
    private final AtomicReference<InternalAppCheckTokenProvider> internalAppCheck = new AtomicReference<>();

    public AndroidAppCheckTokenProvider(Deferred<InternalAppCheckTokenProvider> deferred) {
        this.deferredAppCheckProvider = deferred;
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.database.android.AndroidAppCheckTokenProvider$$ExternalSyntheticLambda0
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                this.f$0.lambda$new$0(provider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.internalAppCheck.set((InternalAppCheckTokenProvider) provider.get());
    }
}
