package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: SettingsCache.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000f\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010%J\u001d\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010+R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache;", "", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore", "<init>", "(Landroidx/datastore/core/DataStore;)V", "preferences", "", "updateSessionConfigs", "(Landroidx/datastore/preferences/core/Preferences;)V", "T", "Landroidx/datastore/preferences/core/Preferences$Key;", "key", AppMeasurementSdk.ConditionalUserProperty.VALUE, "updateConfigValue", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "hasCacheExpired$com_google_firebase_firebase_sessions", "()Z", "hasCacheExpired", "sessionsEnabled", "()Ljava/lang/Boolean;", "", "sessionSamplingRate", "()Ljava/lang/Double;", "", "sessionRestartTimeout", "()Ljava/lang/Integer;", "enabled", "updateSettingsEnabled", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rate", "updateSamplingRate", "(Ljava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeoutInSeconds", "updateSessionRestartTimeout", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheDurationInSeconds", "updateSessionCacheDuration", "", "cacheUpdatedTime", "updateSessionCacheUpdatedTime", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/core/DataStore;", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "sessionConfigs", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsCache {
    private final DataStore<Preferences> dataStore;
    private SessionConfigs sessionConfigs;
    private static final Companion Companion = new Companion(null);
    private static final Preferences.Key<Boolean> SESSIONS_ENABLED = PreferencesKeys.booleanKey("firebase_sessions_enabled");
    private static final Preferences.Key<Double> SAMPLING_RATE = PreferencesKeys.doubleKey("firebase_sessions_sampling_rate");
    private static final Preferences.Key<Integer> RESTART_TIMEOUT_SECONDS = PreferencesKeys.intKey("firebase_sessions_restart_timeout");
    private static final Preferences.Key<Integer> CACHE_DURATION_SECONDS = PreferencesKeys.intKey("firebase_sessions_cache_duration");
    private static final Preferences.Key<Long> CACHE_UPDATED_TIME = PreferencesKeys.longKey("firebase_sessions_cache_updated_time");

    /* compiled from: SettingsCache.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {119}, m = "updateConfigValue")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1, reason: invalid class name and case insensitive filesystem */
    static final class C05841<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C05841(Continuation<? super C05841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SettingsCache.this.updateConfigValue(null, null, this);
        }
    }

    public SettingsCache(DataStore<Preferences> dataStore) throws InterruptedException {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.dataStore = dataStore;
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    /* compiled from: SettingsCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsCache.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SettingsCache settingsCache;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                Flow data = settingsCache2.dataStore.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object objFirst = FlowKt.first(data, this);
                if (objFirst == coroutine_suspended) {
                    return coroutine_suspended;
                }
                settingsCache = settingsCache2;
                obj = objFirst;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = (SettingsCache) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            settingsCache.updateSessionConfigs(((Preferences) obj).toPreferences());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSessionConfigs(Preferences preferences) {
        this.sessionConfigs = new SessionConfigs((Boolean) preferences.get(SESSIONS_ENABLED), (Double) preferences.get(SAMPLING_RATE), (Integer) preferences.get(RESTART_TIMEOUT_SECONDS), (Integer) preferences.get(CACHE_DURATION_SECONDS), (Long) preferences.get(CACHE_UPDATED_TIME));
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        SessionConfigs sessionConfigs2 = null;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        Long cacheUpdatedTime = sessionConfigs.getCacheUpdatedTime();
        SessionConfigs sessionConfigs3 = this.sessionConfigs;
        if (sessionConfigs3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
        } else {
            sessionConfigs2 = sessionConfigs3;
        }
        Integer cacheDuration = sessionConfigs2.getCacheDuration();
        return cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) 1000) >= ((long) cacheDuration.intValue());
    }

    public final Boolean sessionsEnabled() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionEnabled();
    }

    public final Double sessionSamplingRate() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionSamplingRate();
    }

    public final Integer sessionRestartTimeout() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionRestartTimeout();
    }

    public final Object updateSettingsEnabled(Boolean bool, Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(SESSIONS_ENABLED, bool, continuation);
        return objUpdateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSamplingRate(Double d, Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(SAMPLING_RATE, d, continuation);
        return objUpdateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionRestartTimeout(Integer num, Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(RESTART_TIMEOUT_SECONDS, num, continuation);
        return objUpdateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionCacheDuration(Integer num, Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(CACHE_DURATION_SECONDS, num, continuation);
        return objUpdateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionCacheUpdatedTime(Long l, Continuation<? super Unit> continuation) {
        Object objUpdateConfigValue = updateConfigValue(CACHE_UPDATED_TIME, l, continuation);
        return objUpdateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigValue : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object updateConfigValue(androidx.datastore.preferences.core.Preferences.Key<T> r6, T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache.C05841
            if (r0 == 0) goto L13
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache.C05841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.io.IOException -> L29
            goto L5d
        L29:
            r6 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> r8 = r5.dataStore     // Catch: java.io.IOException -> L29
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch: java.io.IOException -> L29
            r0.label = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.edit(r8, r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5d
            return r1
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L5d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.updateConfigValue(androidx.datastore.preferences.core.Preferences$Key, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: SettingsCache.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ Preferences.Key<T> $key;
        final /* synthetic */ T $value;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SettingsCache this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(T t, Preferences.Key<T> key, SettingsCache settingsCache, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$value = t;
            this.$key = key;
            this.this$0 = settingsCache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$value, this.$key, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            T t = this.$value;
            if (t != 0) {
                mutablePreferences.set(this.$key, t);
            } else {
                mutablePreferences.remove(this.$key);
            }
            this.this$0.updateSessionConfigs(mutablePreferences);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: SettingsCache.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache$Companion;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
