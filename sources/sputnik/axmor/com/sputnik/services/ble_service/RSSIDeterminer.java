package sputnik.axmor.com.sputnik.services.ble_service;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.utils.LogUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager;

/* compiled from: RSSIDeterminer.kt */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0010\u0018\u0000 \"2\u00020\u0001:\u0005\"#$%&B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001b\u001a\u00020\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u001fR \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer;", "", "context", "Landroid/content/Context;", "analyseTimeInSeconds", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$Listener;", "(Landroid/content/Context;ILsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$Listener;)V", "allReadsMap", "", "", "", "beaconScanningManager", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager;", "cancelAnalysysTask", "sputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$cancelAnalysysTask$1", "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$cancelAnalysysTask$1;", "estimatesMap", "initialEstimateError", "", "kalmanMedianFilter", "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$KalmanMedianFilter;", "measurementNoise", "processNoise", "readsMap", "windowSize", "analyzeAll", "checkPermissions", "", "doStartAnalyze", "", "startAnalyzing", "stopAnalyzing", "Companion", "KalmanFilter", "KalmanMedianFilter", "Listener", "MedianFilter", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RSSIDeterminer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, List<Integer>> allReadsMap;
    private int analyseTimeInSeconds;
    private final BeaconScanningManager beaconScanningManager;
    private final RSSIDeterminer$cancelAnalysysTask$1 cancelAnalysysTask;
    private final Context context;
    private final Map<String, List<Integer>> estimatesMap;
    private final float initialEstimateError;
    private KalmanMedianFilter kalmanMedianFilter;
    private Listener listener;
    private final float measurementNoise;
    private final float processNoise;
    private final Map<String, List<Integer>> readsMap;
    private final int windowSize;

    /* compiled from: RSSIDeterminer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$Listener;", "", "", "optimalRssi", "", "onAnalyzingCompleted", "(I)V", "left", "onTick", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {

        /* compiled from: RSSIDeterminer.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onTick(Listener listener, int i) {
            }
        }

        void onAnalyzingCompleted(int optimalRssi);

        void onTick(int left);
    }

    private final boolean checkPermissions() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer$cancelAnalysysTask$1] */
    public RSSIDeterminer(Context context, int i, Listener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.analyseTimeInSeconds = i;
        this.listener = listener;
        this.initialEstimateError = 1.0f;
        this.processNoise = 0.1f;
        this.measurementNoise = 1.0f;
        this.windowSize = 5;
        this.kalmanMedianFilter = new KalmanMedianFilter(1.0f, 0.1f, 1.0f, 5);
        this.readsMap = new LinkedHashMap();
        this.allReadsMap = new LinkedHashMap();
        this.estimatesMap = new LinkedHashMap();
        this.cancelAnalysysTask = new Runnable() { // from class: sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer$cancelAnalysysTask$1
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                List list;
                this.this$0.beaconScanningManager.stopTracking();
                Iterator it = this.this$0.estimatesMap.entrySet().iterator();
                if (it.hasNext()) {
                    Object next = it.next();
                    if (it.hasNext()) {
                        int size = ((List) ((Map.Entry) next).getValue()).size();
                        do {
                            Object next2 = it.next();
                            int size2 = ((List) ((Map.Entry) next2).getValue()).size();
                            if (size < size2) {
                                next = next2;
                                size = size2;
                            }
                        } while (it.hasNext());
                    }
                    obj = next;
                } else {
                    obj = null;
                }
                Map.Entry entry = (Map.Entry) obj;
                LogUtilsKt.writeLog("Got optimal rssi: " + ((entry == null || (list = (List) entry.getValue()) == null) ? -1 : ((Number) CollectionsKt.last(list)).intValue()));
            }
        };
        this.beaconScanningManager = new BeaconScanningManager(context, new BeaconScanningManager.ScanResultsListener() { // from class: sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer$beaconScanningManager$1
            @Override // sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager.ScanResultsListener
            public void onBluetoothStateChanged(boolean isEnabled) {
            }

            @Override // sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager.ScanResultsListener
            public void onScanError(int errorCode) {
            }

            @Override // sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager.ScanResultsListener
            public void onIntercomFound(String serial, int rssi) {
                Intrinsics.checkNotNullParameter(serial, "serial");
                if (rssi == 127) {
                    return;
                }
                int iUpdate = (int) this.this$0.kalmanMedianFilter.update(rssi);
                LogUtilsKt.writeLog("readed: rssi=" + rssi + " | filtered=" + iUpdate);
                if (this.this$0.readsMap.get(serial) == null) {
                    this.this$0.readsMap.put(serial, new ArrayList());
                }
                if (this.this$0.estimatesMap.get(serial) == null) {
                    this.this$0.estimatesMap.put(serial, new ArrayList());
                }
                if (this.this$0.allReadsMap.get(serial) == null) {
                    this.this$0.allReadsMap.put(serial, new ArrayList());
                }
                List list = (List) this.this$0.readsMap.get(serial);
                if (list != null) {
                    list.add(Integer.valueOf(rssi));
                }
                List list2 = (List) this.this$0.estimatesMap.get(serial);
                if (list2 != null) {
                    list2.add(Integer.valueOf(iUpdate));
                }
                List list3 = (List) this.this$0.allReadsMap.get(serial);
                if (list3 != null) {
                    list3.add(Integer.valueOf(rssi));
                }
            }
        }, CollectionsKt.emptyList());
    }

    public /* synthetic */ RSSIDeterminer(Context context, int i, Listener listener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 10 : i, listener);
    }

    public final void startAnalyzing() {
        if (checkPermissions()) {
            doStartAnalyze();
        }
    }

    public final void startAnalyzing(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (checkPermissions()) {
            this.listener = listener;
            doStartAnalyze();
        }
    }

    public final int analyzeAll() {
        Object next;
        Float f;
        List list;
        this.kalmanMedianFilter = new KalmanMedianFilter(this.initialEstimateError, this.processNoise, this.measurementNoise, this.windowSize);
        Iterator<T> it = this.allReadsMap.entrySet().iterator();
        ArrayList arrayList = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int size = ((List) ((Map.Entry) next).getValue()).size();
                do {
                    Object next2 = it.next();
                    int size2 = ((List) ((Map.Entry) next2).getValue()).size();
                    if (size < size2) {
                        next = next2;
                        size = size2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null && (list = (List) entry.getValue()) != null) {
            List list2 = list;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(Float.valueOf(this.kalmanMedianFilter.update(((Number) it2.next()).intValue())));
            }
        }
        if (arrayList == null || (f = (Float) CollectionsKt.lastOrNull((List) arrayList)) == null) {
            return -1;
        }
        return (int) f.floatValue();
    }

    private final void doStartAnalyze() {
        this.kalmanMedianFilter = new KalmanMedianFilter(this.initialEstimateError, this.processNoise, this.measurementNoise, this.windowSize);
        this.readsMap.clear();
        this.estimatesMap.clear();
        this.beaconScanningManager.startTracking();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* compiled from: RSSIDeterminer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer$doStartAnalyze$1", f = "RSSIDeterminer.kt", l = {105}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer$doStartAnalyze$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RSSIDeterminer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0039 -> B:13:0x003c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = -1
                r3 = 1
                if (r1 == 0) goto L1a
                if (r1 != r3) goto L12
                int r1 = r13.I$0
                kotlin.ResultKt.throwOnFailure(r14)
                goto L3c
            L12:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1a:
                kotlin.ResultKt.throwOnFailure(r14)
                sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.this
                int r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.access$getAnalyseTimeInSeconds$p(r14)
                r1 = r14
            L24:
                if (r1 <= 0) goto L3e
                sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.this
                sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer$Listener r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.access$getListener$p(r14)
                r14.onTick(r1)
                r13.I$0 = r1
                r13.label = r3
                r4 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r4, r13)
                if (r14 != r0) goto L3c
                return r0
            L3c:
                int r1 = r1 + r2
                goto L24
            L3e:
                sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.this
                sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.access$getBeaconScanningManager$p(r14)
                r14.stopTracking()
                sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.this
                java.util.Map r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.access$getEstimatesMap$p(r14)
                java.util.Set r14 = r14.entrySet()
                java.lang.Iterable r14 = (java.lang.Iterable) r14
                java.util.Iterator r14 = r14.iterator()
                boolean r0 = r14.hasNext()
                if (r0 != 0) goto L5f
                r14 = 0
                goto L94
            L5f:
                java.lang.Object r0 = r14.next()
                boolean r1 = r14.hasNext()
                if (r1 != 0) goto L6b
            L69:
                r14 = r0
                goto L94
            L6b:
                r1 = r0
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r1 = r1.getValue()
                java.util.List r1 = (java.util.List) r1
                int r1 = r1.size()
            L78:
                java.lang.Object r3 = r14.next()
                r4 = r3
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r4 = r4.getValue()
                java.util.List r4 = (java.util.List) r4
                int r4 = r4.size()
                if (r1 >= r4) goto L8d
                r0 = r3
                r1 = r4
            L8d:
                boolean r3 = r14.hasNext()
                if (r3 != 0) goto L78
                goto L69
            L94:
                java.util.Map$Entry r14 = (java.util.Map.Entry) r14
                if (r14 == 0) goto Laa
                java.lang.Object r14 = r14.getValue()
                java.util.List r14 = (java.util.List) r14
                if (r14 == 0) goto Laa
                java.lang.Object r14 = kotlin.collections.CollectionsKt.last(r14)
                java.lang.Number r14 = (java.lang.Number) r14
                int r2 = r14.intValue()
            Laa:
                r0 = 4608533498688228557(0x3ff4cccccccccccd, double:1.3)
                double r3 = (double) r2
                double r6 = r3 * r0
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r0 = "GGGG: OPTIMAL="
                r14.append(r0)
                r14.append(r2)
                java.lang.String r0 = " | "
                r14.append(r0)
                r14.append(r6)
                java.lang.String r14 = r14.toString()
                com.sputnik.common.utils.LogUtilsKt.writeLog(r14)
                sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer$Companion r5 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.INSTANCE
                r11 = 14
                r12 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                int r14 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.Companion.round$default(r5, r6, r8, r9, r10, r11, r12)
                sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer r0 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.this
                sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer$Listener r0 = sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.access$getListener$p(r0)
                r0.onAnalyzingCompleted(r14)
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.services.ble_service.RSSIDeterminer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void stopAnalyzing() {
        new Handler(Looper.getMainLooper()).removeCallbacks(this.cancelAnalysysTask);
        this.beaconScanningManager.stopTracking();
    }

    /* compiled from: RSSIDeterminer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$KalmanMedianFilter;", "", "initialEstimateError", "", "processNoise", "measurementNoise", "windowSize", "", "(FFFI)V", "kalmanFilter", "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$KalmanFilter;", "medianFilter", "Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$MedianFilter;", "update", "currentRSSI", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KalmanMedianFilter {
        private final KalmanFilter kalmanFilter;
        private final MedianFilter medianFilter;

        public KalmanMedianFilter(float f, float f2, float f3, int i) {
            this.medianFilter = new MedianFilter(i);
            this.kalmanFilter = new KalmanFilter(f, f2, f3);
        }

        public final float update(float currentRSSI) {
            return this.kalmanFilter.update(this.medianFilter.update(currentRSSI));
        }
    }

    /* compiled from: RSSIDeterminer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$MedianFilter;", "", "windowSize", "", "(I)V", "measurements", "", "", "update", "currentRSSI", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MedianFilter {
        private final List<Float> measurements = new ArrayList();
        private final int windowSize;

        public MedianFilter(int i) {
            this.windowSize = i;
        }

        public final float update(float currentRSSI) {
            this.measurements.add(Float.valueOf(currentRSSI));
            if (this.measurements.size() > this.windowSize) {
                this.measurements.remove(0);
            }
            List listSorted = CollectionsKt.sorted(this.measurements);
            int size = listSorted.size() / 2;
            if (listSorted.size() % 2 == 0) {
                return (((Number) listSorted.get(size - 1)).floatValue() + ((Number) listSorted.get(size)).floatValue()) / 2;
            }
            return ((Number) listSorted.get(size)).floatValue();
        }
    }

    /* compiled from: RSSIDeterminer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$KalmanFilter;", "", "initialEstimateError", "", "processNoise", "measurementNoise", "(FFF)V", "estimate", "estimateError", "update", "measurement", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KalmanFilter {
        private float estimate;
        private float estimateError;
        private final float initialEstimateError;
        private final float measurementNoise;
        private final float processNoise;

        public KalmanFilter(float f, float f2, float f3) {
            this.initialEstimateError = f;
            this.processNoise = f2;
            this.measurementNoise = f3;
            this.estimateError = f;
        }

        public final float update(float measurement) {
            float f = this.estimate;
            float f2 = this.estimateError + this.processNoise;
            float f3 = f2 / (this.measurementNoise + f2);
            float f4 = f + ((measurement - f) * f3);
            this.estimate = f4;
            this.estimateError = (1 - f3) * f2;
            return f4;
        }
    }

    /* compiled from: RSSIDeterminer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/RSSIDeterminer$Companion;", "", "()V", "round", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "nearest", "minValue", "maxValue", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ int round$default(Companion companion, double d, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i = 5;
            }
            int i5 = i;
            if ((i4 & 4) != 0) {
                i2 = -150;
            }
            int i6 = i2;
            if ((i4 & 8) != 0) {
                i3 = -60;
            }
            return companion.round(d, i5, i6, i3);
        }

        public final int round(double value, int nearest, int minValue, int maxValue) {
            return value < ((double) minValue) ? minValue : value > ((double) maxValue) ? maxValue : ((int) Math.round(value / nearest)) * nearest;
        }
    }
}
