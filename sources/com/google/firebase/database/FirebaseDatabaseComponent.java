package com.google.firebase.database;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.android.AndroidAppCheckTokenProvider;
import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class FirebaseDatabaseComponent {
    private final FirebaseApp app;
    private final TokenProvider appCheckProvider;
    private final TokenProvider authProvider;
    private final Map<Object, Object> instances = new HashMap();

    FirebaseDatabaseComponent(FirebaseApp firebaseApp, Deferred<InternalAuthProvider> deferred, Deferred<InternalAppCheckTokenProvider> deferred2) {
        this.app = firebaseApp;
        this.authProvider = new AndroidAuthTokenProvider(deferred);
        this.appCheckProvider = new AndroidAppCheckTokenProvider(deferred2);
    }
}
