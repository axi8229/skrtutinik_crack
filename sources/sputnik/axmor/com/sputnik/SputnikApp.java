package sputnik.axmor.com.sputnik;

import android.util.Log;
import androidx.multidex.MultiDexApplication;
import com.axmor.axvoip.mojo.pjm.endpoint.PjmAccessPoint;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.common.di.CommonDepsStore;
import com.sputnik.oboarding.di.OnBoardingDepsStore;
import com.sputnik.service_payments.di.ServicePaymentDepsStore;
import com.sputnik.subscriptions.di.SubscriptionsDepsStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.di.AppComponent;
import sputnik.axmor.com.sputnik.di.DaggerAppComponent;

/* compiled from: SputnikApp.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003R\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/SputnikApp;", "Landroidx/multidex/MultiDexApplication;", "<init>", "()V", "", "onCreate", "Lsputnik/axmor/com/sputnik/di/AppComponent;", "appComponent$delegate", "Lkotlin/Lazy;", "getAppComponent", "()Lsputnik/axmor/com/sputnik/di/AppComponent;", "appComponent", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SputnikApp extends MultiDexApplication {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<AnalyticsService> analyticsService$delegate = LazyKt.lazy(new Function0<AnalyticsService>() { // from class: sputnik.axmor.com.sputnik.SputnikApp$Companion$analyticsService$2
        @Override // kotlin.jvm.functions.Function0
        public final AnalyticsService invoke() {
            return new AnalyticsService(SputnikApp.INSTANCE.applicationContext());
        }
    });
    private static Companion.CallState callState = new Companion.CallState(false, null, null, null, 15, null);
    private static SputnikApp instance;

    /* renamed from: appComponent$delegate, reason: from kotlin metadata */
    private final Lazy appComponent = LazyKt.lazy(new Function0<AppComponent>() { // from class: sputnik.axmor.com.sputnik.SputnikApp$appComponent$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final AppComponent invoke() {
            return DaggerAppComponent.builder().applicationContext(this.this$0).build();
        }
    });

    public SputnikApp() {
        instance = this;
        Log.e("DAGGER", "Application");
    }

    public final AppComponent getAppComponent() {
        return (AppComponent) this.appComponent.getValue();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        OnBoardingDepsStore.INSTANCE.setDeps(getAppComponent());
        ServicePaymentDepsStore.INSTANCE.setDeps(getAppComponent());
        SubscriptionsDepsStore.INSTANCE.setDeps(getAppComponent());
        CommonDepsStore.INSTANCE.setDeps(getAppComponent());
        FirebaseApp.initializeApp(this);
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        PjmAccessPoint.loadLibraries();
        INSTANCE.getAnalyticsService().initialize();
    }

    /* compiled from: SputnikApp.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lsputnik/axmor/com/sputnik/SputnikApp$Companion;", "", "()V", "analyticsService", "Lsputnik/axmor/com/sputnik/core/analytics/AnalyticsService;", "getAnalyticsService", "()Lsputnik/axmor/com/sputnik/core/analytics/AnalyticsService;", "analyticsService$delegate", "Lkotlin/Lazy;", "callState", "Lsputnik/axmor/com/sputnik/SputnikApp$Companion$CallState;", "getCallState", "()Lsputnik/axmor/com/sputnik/SputnikApp$Companion$CallState;", "setCallState", "(Lsputnik/axmor/com/sputnik/SputnikApp$Companion$CallState;)V", "instance", "Lsputnik/axmor/com/sputnik/SputnikApp;", "applicationContext", "changeCallState", "", "newState", "CallState", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SputnikApp applicationContext() {
            SputnikApp sputnikApp = SputnikApp.instance;
            Intrinsics.checkNotNull(sputnikApp, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.SputnikApp");
            return sputnikApp;
        }

        public final AnalyticsService getAnalyticsService() {
            return (AnalyticsService) SputnikApp.analyticsService$delegate.getValue();
        }

        public final CallState getCallState() {
            return SputnikApp.callState;
        }

        public final void setCallState(CallState callState) {
            Intrinsics.checkNotNullParameter(callState, "<set-?>");
            SputnikApp.callState = callState;
        }

        public final void changeCallState(CallState newState) {
            Intrinsics.checkNotNullParameter(newState, "newState");
            setCallState(newState);
        }

        /* compiled from: SputnikApp.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\u001aR$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\u001aR$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\u001a¨\u0006\u001f"}, d2 = {"Lsputnik/axmor/com/sputnik/SputnikApp$Companion$CallState;", "", "", "inCallStateNow", "", FailedBinderCallBack.CALLER_ID, "callUuid", "flatUuid", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getInCallStateNow", "()Z", "setInCallStateNow", "(Z)V", "Ljava/lang/String;", "getCallId", "setCallId", "(Ljava/lang/String;)V", "getCallUuid", "setCallUuid", "getFlatUuid", "setFlatUuid", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CallState {
            private String callId;
            private String callUuid;
            private String flatUuid;
            private boolean inCallStateNow;

            public CallState() {
                this(false, null, null, null, 15, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CallState)) {
                    return false;
                }
                CallState callState = (CallState) other;
                return this.inCallStateNow == callState.inCallStateNow && Intrinsics.areEqual(this.callId, callState.callId) && Intrinsics.areEqual(this.callUuid, callState.callUuid) && Intrinsics.areEqual(this.flatUuid, callState.flatUuid);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            public int hashCode() {
                boolean z = this.inCallStateNow;
                ?? r0 = z;
                if (z) {
                    r0 = 1;
                }
                int i = r0 * 31;
                String str = this.callId;
                int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.callUuid;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.flatUuid;
                return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "CallState(inCallStateNow=" + this.inCallStateNow + ", callId=" + this.callId + ", callUuid=" + this.callUuid + ", flatUuid=" + this.flatUuid + ")";
            }

            public CallState(boolean z, String str, String str2, String str3) {
                this.inCallStateNow = z;
                this.callId = str;
                this.callUuid = str2;
                this.flatUuid = str3;
            }

            public /* synthetic */ CallState(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
            }

            public final boolean getInCallStateNow() {
                return this.inCallStateNow;
            }

            public final String getCallId() {
                return this.callId;
            }

            public final String getCallUuid() {
                return this.callUuid;
            }

            public final String getFlatUuid() {
                return this.flatUuid;
            }
        }
    }
}
