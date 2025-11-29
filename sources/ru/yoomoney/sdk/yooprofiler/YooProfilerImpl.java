package ru.yoomoney.sdk.yooprofiler;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.group_ib.sdk.AbstractC0604j0;
import com.group_ib.sdk.C0595f;
import com.group_ib.sdk.EnumC0589c;
import com.group_ib.sdk.InterfaceC0609m;
import com.group_ib.sdk.T;
import com.group_ib.sdk.X;
import com.group_ib.sdk.c1;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b#\u0010$JG\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J?\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lru/yoomoney/sdk/yooprofiler/YooProfilerImpl;", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "", "sessionId", "Lru/yoomoney/sdk/yooprofiler/ProfileEventType;", "eventType", "uid", "publicCardSynonym", "Lkotlin/Function1;", "", "block", "startGibSdk", "(Ljava/lang/String;Lru/yoomoney/sdk/yooprofiler/ProfileEventType;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "stopGibSdk", "()V", "generateSessionId", "()Ljava/lang/String;", "prepareSessionId", "(Ljava/lang/String;)Ljava/lang/String;", "Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result;", Scopes.PROFILE, "(Lru/yoomoney/sdk/yooprofiler/ProfileEventType;Ljava/lang/String;Ljava/lang/String;)Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result;", "profileWithSessionId", "(Ljava/lang/String;Lru/yoomoney/sdk/yooprofiler/ProfileEventType;Ljava/lang/String;Ljava/lang/String;)Lru/yoomoney/sdk/yooprofiler/YooProfiler$Result;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lru/yoomoney/sdk/yooprofiler/ProfileEventType;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lkotlinx/coroutines/CoroutineDispatcher;", "timerDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lcom/group_ib/sdk/f;", "gibSdk", "Lcom/group_ib/sdk/f;", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Companion", "yooprofiler_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class YooProfilerImpl implements YooProfiler {
    public static final String CUSTOMER_ID = "a-ymoney";
    public static final String EVENT_TYPE_ATTRIBUTE_NAME = "event_type";
    public static final String PUBLIC_CARD_SYNONYM_ATTRIBUTE_NAME = "hashed_sender_card";
    public static final String SESSION_PREFIX = "groupib-";
    public static final String TARGET_URL = "https://fl.yoomoney.ru";
    public static final long TIMER_LIMIT = 2000;
    private final Context context;
    private C0595f gibSdk;
    private final CoroutineDispatcher timerDispatcher;

    public YooProfilerImpl(Context context, CoroutineDispatcher timerDispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timerDispatcher, "timerDispatcher");
        this.context = context;
        this.timerDispatcher = timerDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateSessionId() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareSessionId(String sessionId) {
        return SESSION_PREFIX + sessionId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startGibSdk(String sessionId, ProfileEventType eventType, String uid, String publicCardSynonym, final Function1<? super String, Unit> block) {
        Activity activity;
        C0595f c0595f = C0595f.i;
        T.q = true;
        Context applicationContext = this.context.getApplicationContext();
        synchronized (T.class) {
            String str = T.a;
            if (applicationContext != null) {
                T.g = applicationContext.getPackageName();
            }
        }
        String strA = AbstractC0604j0.a();
        boolean z = strA == null || applicationContext.getPackageName().equals(strA);
        C0595f.j = z;
        C0595f.k = z && AbstractC0604j0.b(applicationContext);
        if (C0595f.j) {
            c1.a(applicationContext.getApplicationContext());
        }
        boolean z2 = X.a;
        X.a = AbstractC0604j0.a(applicationContext);
        if (C0595f.i == null) {
            C0595f c0595f2 = new C0595f(applicationContext);
            C0595f.i = c0595f2;
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else {
                    if (applicationContext instanceof Activity) {
                        activity = (Activity) applicationContext;
                        break;
                    }
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            c0595f2.f = activity;
        }
        T.a(2, "IMSI1");
        T.a(2, "IMSI2");
        T.a(2, "SubscriberID");
        T.a(2, "IMEI");
        T.a(2, "SIM1SerialNumber");
        T.a(2, "MobileEquipID");
        T.a(2, "PhoneSerial");
        T.a(2, "Serial");
        T.a(3, "AndroidID");
        C0595f c0595f3 = C0595f.i;
        c0595f3.getClass();
        c1.a(3, 3, "MobileSdk", "setCustomerId (a-ymoney)");
        T.a = CUSTOMER_ID;
        C0595f c0595fA = c0595f3.c().a(sessionId).a(EnumC0589c.LocationCapability).a(EnumC0589c.MotionCollectionCapability);
        c0595fA.d.a(EVENT_TYPE_ATTRIBUTE_NAME, eventType.getValue());
        T.e = new InterfaceC0609m() { // from class: ru.yoomoney.sdk.yooprofiler.YooProfilerImpl$$ExternalSyntheticLambda0
            @Override // com.group_ib.sdk.InterfaceC0609m
            public final void a(String str2) {
                YooProfilerImpl.startGibSdk$lambda$0(block, this, str2);
            }
        };
        if (uid != null) {
            c1.a(3, 3, "MobileSdk", "setLogin (length " + uid.length() + ")");
            c0595fA.d.a(uid);
        }
        if (publicCardSynonym != null) {
            c0595fA.d.a(PUBLIC_CARD_SYNONYM_ATTRIBUTE_NAME, publicCardSynonym);
        }
        this.gibSdk = c0595fA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGibSdk$lambda$0(Function1 block, YooProfilerImpl this$0, String str) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(str);
        block.invoke(str);
        this$0.stopGibSdk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopGibSdk() {
        try {
            C0595f c0595f = this.gibSdk;
            if (c0595f != null) {
                c0595f.d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // ru.yoomoney.sdk.yooprofiler.YooProfiler
    public synchronized YooProfiler.Result profile(ProfileEventType eventType, String uid, String publicCardSynonym) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return (YooProfiler.Result) BuildersKt__BuildersKt.runBlocking$default(null, new c(this, eventType, uid, publicCardSynonym, null), 1, null);
    }

    @Override // ru.yoomoney.sdk.yooprofiler.YooProfiler
    public synchronized YooProfiler.Result profileWithSessionId(String sessionId, ProfileEventType eventType, String uid, String publicCardSynonym) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return (YooProfiler.Result) BuildersKt__BuildersKt.runBlocking$default(null, new h(this, StringsKt.removePrefix(sessionId, SESSION_PREFIX), eventType, uid, publicCardSynonym, null), 1, null);
    }

    public /* synthetic */ YooProfilerImpl(Context context, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // ru.yoomoney.sdk.yooprofiler.YooProfiler
    public synchronized void profile(ProfileEventType eventType, String uid, String publicCardSynonym, Function1<? super YooProfiler.Result, Unit> listener) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String strGenerateSessionId = generateSessionId();
        try {
            startGibSdk(strGenerateSessionId, eventType, uid, publicCardSynonym, new d(BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.timerDispatcher, null, new e(listener, this, strGenerateSessionId, null), 2, null), listener, this, strGenerateSessionId));
        } catch (Exception e) {
            e.printStackTrace();
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Library error";
            }
            listener.invoke(new YooProfiler.Result.Fail(localizedMessage));
            stopGibSdk();
        }
    }
}
