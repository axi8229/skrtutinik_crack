package com.google.firebase.messaging;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager$Api33Ext5Impl$$ExternalSyntheticLambda11;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
class GmsRpc {
    private final FirebaseApp app;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<HeartBeatInfo> heartbeatInfo;
    private final Metadata metadata;
    private final Rpc rpc;
    private final Provider<UserAgentPublisher> userAgentPublisher;

    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata, new Rpc(firebaseApp.getApplicationContext()), provider, provider2, firebaseInstallationsApi);
    }

    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Rpc rpc, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.app = firebaseApp;
        this.metadata = metadata;
        this.rpc = rpc;
        this.userAgentPublisher = provider;
        this.heartbeatInfo = provider2;
        this.firebaseInstallations = firebaseInstallationsApi;
    }

    Task<String> getToken() {
        return extractResponseWhenComplete(startRpc(Metadata.getDefaultSenderId(this.app), "*", new Bundle()));
    }

    Task<?> subscribeToTopic(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return extractResponseWhenComplete(startRpc(str, "/topics/" + str2, bundle));
    }

    Task<?> unsubscribeFromTopic(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return extractResponseWhenComplete(startRpc(str, "/topics/" + str2, bundle));
    }

    Task<Void> setRetainProxiedNotifications(boolean z) {
        return this.rpc.setRetainProxiedNotifications(z);
    }

    Task<CloudMessage> getProxyNotificationData() {
        return this.rpc.getProxiedNotificationData();
    }

    private Task<Bundle> startRpc(String str, String str2, Bundle bundle) {
        try {
            setDefaultAttributesToBundle(str, str2, bundle);
            return this.rpc.send(bundle);
        } catch (InterruptedException | ExecutionException e) {
            return Tasks.forException(e);
        }
    }

    private static String base64UrlSafe(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private String getHashedFirebaseAppName() {
        try {
            return base64UrlSafe(MessageDigest.getInstance("SHA-1").digest(this.app.getName().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setDefaultAttributesToBundle(java.lang.String r3, java.lang.String r4, android.os.Bundle r5) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        /*
            r2 = this;
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "scope"
            r5.putString(r1, r4)
            java.lang.String r4 = "sender"
            r5.putString(r4, r3)
            java.lang.String r4 = "subtype"
            r5.putString(r4, r3)
            com.google.firebase.FirebaseApp r3 = r2.app
            com.google.firebase.FirebaseOptions r3 = r3.getOptions()
            java.lang.String r3 = r3.getApplicationId()
            java.lang.String r4 = "gmp_app_id"
            r5.putString(r4, r3)
            com.google.firebase.messaging.Metadata r3 = r2.metadata
            int r3 = r3.getGmsVersionCode()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "gmsv"
            r5.putString(r4, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "osv"
            r5.putString(r4, r3)
            com.google.firebase.messaging.Metadata r3 = r2.metadata
            java.lang.String r3 = r3.getAppVersionCode()
            java.lang.String r4 = "app_ver"
            r5.putString(r4, r3)
            com.google.firebase.messaging.Metadata r3 = r2.metadata
            java.lang.String r3 = r3.getAppVersionName()
            java.lang.String r4 = "app_ver_name"
            r5.putString(r4, r3)
            java.lang.String r3 = "firebase-app-name-hash"
            java.lang.String r4 = r2.getHashedFirebaseAppName()
            r5.putString(r3, r4)
            com.google.firebase.installations.FirebaseInstallationsApi r3 = r2.firebaseInstallations     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            r4 = 0
            com.google.android.gms.tasks.Task r3 = r3.getToken(r4)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.await(r3)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            com.google.firebase.installations.InstallationTokenResult r3 = (com.google.firebase.installations.InstallationTokenResult) r3     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            java.lang.String r3 = r3.getToken()     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            if (r4 != 0) goto L7a
            java.lang.String r4 = "Goog-Firebase-Installations-Auth"
            r5.putString(r4, r3)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            goto L85
        L76:
            r3 = move-exception
            goto L80
        L78:
            r3 = move-exception
            goto L80
        L7a:
            java.lang.String r3 = "FIS auth token is empty"
            android.util.Log.w(r0, r3)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            goto L85
        L80:
            java.lang.String r4 = "Failed to get FIS auth token"
            android.util.Log.e(r0, r4, r3)
        L85:
            com.google.firebase.installations.FirebaseInstallationsApi r3 = r2.firebaseInstallations
            com.google.android.gms.tasks.Task r3 = r3.getId()
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.await(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "appid"
            r5.putString(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fcm-"
            r3.append(r4)
            java.lang.String r4 = "24.0.2"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "cliv"
            r5.putString(r4, r3)
            com.google.firebase.inject.Provider<com.google.firebase.heartbeatinfo.HeartBeatInfo> r3 = r2.heartbeatInfo
            java.lang.Object r3 = r3.get()
            com.google.firebase.heartbeatinfo.HeartBeatInfo r3 = (com.google.firebase.heartbeatinfo.HeartBeatInfo) r3
            com.google.firebase.inject.Provider<com.google.firebase.platforminfo.UserAgentPublisher> r4 = r2.userAgentPublisher
            java.lang.Object r4 = r4.get()
            com.google.firebase.platforminfo.UserAgentPublisher r4 = (com.google.firebase.platforminfo.UserAgentPublisher) r4
            if (r3 == 0) goto Le2
            if (r4 == 0) goto Le2
            java.lang.String r0 = "fire-iid"
            com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat r3 = r3.getHeartBeatCode(r0)
            com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat r0 = com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat.NONE
            if (r3 == r0) goto Le2
            int r3 = r3.getCode()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r0 = "Firebase-Client-Log-Type"
            r5.putString(r0, r3)
            java.lang.String r3 = "Firebase-Client"
            java.lang.String r4 = r4.getUserAgent()
            r5.putString(r3, r4)
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.GmsRpc.setDefaultAttributesToBundle(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    private String handleResponse(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private Task<String> extractResponseWhenComplete(Task<Bundle> task) {
        return task.continueWith(new MeasurementManager$Api33Ext5Impl$$ExternalSyntheticLambda11(), new Continuation() { // from class: com.google.firebase.messaging.GmsRpc$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f$0.lambda$extractResponseWhenComplete$0(task2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$extractResponseWhenComplete$0(Task task) throws Exception {
        return handleResponse((Bundle) task.getResult(IOException.class));
    }

    static boolean isErrorMessageForRetryableError(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }
}
