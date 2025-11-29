package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseCrashlytics.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/ktx/Firebase;", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "getCrashlytics", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "crashlytics", "com.google.firebase-firebase-crashlytics"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FirebaseCrashlyticsKt {
    public static final FirebaseCrashlytics getCrashlytics(Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "<this>");
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseCrashlytics, "getInstance()");
        return firebaseCrashlytics;
    }
}
