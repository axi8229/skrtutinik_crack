package com.yandex.varioqub.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.varioqub.analyticadapter.VarioqubConfigAdapter;
import com.yandex.varioqub.analyticadapter.data.ConfigData;
import com.yandex.varioqub.config.FetchError;
import com.yandex.varioqub.config.OnFetchCompleteListener;
import com.yandex.varioqub.config.VarioqubApi;
import com.yandex.varioqub.config.VarioqubSettings;
import com.yandex.varioqub.config.model.ConfigValue;
import com.yandex.varioqub.protobuf.nano.MessageNano;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public final class B implements VarioqubApi {
    public C1422a a;
    public C1424c b;
    public t c;
    public Executor d;
    public g e;
    public VarioqubSettings f;
    public final AtomicBoolean g = new AtomicBoolean(false);

    public static final void a(B b, OnFetchCompleteListener onFetchCompleteListener) throws JSONException {
        Map mutableMap;
        Object wVar;
        C1424c c1424c;
        boolean z;
        C1424c c1424c2 = b.b;
        if (c1424c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configFetcher");
            c1424c2 = null;
        }
        VarioqubSettings varioqubSettings = b.f;
        if (varioqubSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settings");
            varioqubSettings = null;
        }
        g gVar = b.e;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("identifierProvider");
            gVar = null;
        }
        c1424c2.a();
        h hVar = gVar.b.await(10L, TimeUnit.SECONDS) ? new h(gVar.c, gVar.d) : null;
        if (hVar == null) {
            if (onFetchCompleteListener != null) {
                onFetchCompleteListener.onError("identifiers is null", FetchError.IDENTIFIERS_NULL);
                return;
            }
            return;
        }
        c1424c2.e.getClass();
        if (System.currentTimeMillis() - c1424c2.f <= c1424c2.b) {
            if (C.a) {
                Log.d("Varioqub/ConfigFetcher", "fetch request was throttled");
            }
            if (onFetchCompleteListener != null) {
                onFetchCompleteListener.onError("fetch request was throttled", FetchError.REQUEST_THROTTLED);
                return;
            }
            return;
        }
        l.b(1);
        i iVar = c1424c2.a;
        String strA = D.a(varioqubSettings.getClientId());
        String str = c1424c2.i;
        String str2 = hVar.a;
        String str3 = hVar.b;
        Map<String, String> clientFeatures$config_release = varioqubSettings.getClientFeatures$config_release();
        String adapterName = c1424c2.d.a.getAdapterName();
        p pVar = new p();
        pVar.a = str;
        pVar.b = str2;
        pVar.f = AbstractC1423b.c().versionName;
        pVar.g = AbstractC1423b.d();
        pVar.d = "0.7.0";
        pVar.e = "android";
        pVar.h = AbstractC1423b.b();
        pVar.i = str3;
        ArrayList arrayList = new ArrayList(clientFeatures$config_release.size());
        for (Map.Entry<String, String> entry : clientFeatures$config_release.entrySet()) {
            n nVar = new n();
            nVar.a = entry.getKey();
            nVar.b = entry.getValue();
            arrayList.add(nVar);
        }
        Object[] array = arrayList.toArray(new n[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        pVar.c = (n[]) array;
        synchronized (l.c) {
            mutableMap = MapsKt.toMutableMap(l.b);
        }
        int size = mutableMap.size();
        o[] oVarArr = new o[size];
        for (int i = 0; i < size; i++) {
            oVarArr[i] = new o();
        }
        int i2 = 0;
        for (Object obj : mutableMap.entrySet()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            o oVar = new o();
            oVar.a = (String) ((Map.Entry) obj).getKey();
            oVar.b = ((Number) r12.getValue()).longValue();
            Unit unit = Unit.INSTANCE;
            oVarArr[i2] = oVar;
            i2 = i3;
            c1424c2 = c1424c2;
        }
        C1424c c1424c3 = c1424c2;
        pVar.j = oVarArr;
        pVar.k = String.valueOf(AbstractC1423b.a());
        pVar.l = Build.VERSION.RELEASE;
        pVar.m = adapterName;
        pVar.n = adapterName;
        String str4 = "Varioqub request formed - " + pVar;
        if (C.a) {
            Log.d("Varioqub/RequestBodyFormer", str4);
        }
        byte[] byteArray = MessageNano.toByteArray(pVar);
        if (iVar.b.compareAndSet(false, true)) {
            Context context = AbstractC1425d.a;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appContext");
                context = null;
            }
            String string = context.getSharedPreferences(context.getPackageName() + "_varioqub_pref", 0).getString("etag", "");
            if (string == null) {
                string = "";
            }
            iVar.c = string;
        }
        String str5 = "Network request to: " + strA + ". Content length - " + byteArray.length;
        if (C.a) {
            Log.d("Varioqub/NetworkClient", str5);
        }
        try {
            Response responseExecute = iVar.a.newCall(new Request.Builder().post(RequestBody.create(MediaType.parse("application/x-protobuf"), byteArray)).url(strA).header("If-None-Match", iVar.c).build()).execute();
            try {
                String strHeader = responseExecute.header("ETag");
                if (strHeader == null) {
                    strHeader = "";
                }
                iVar.c = strHeader;
                m.b(strHeader);
                if (responseExecute.isSuccessful()) {
                    ResponseBody responseBodyBody = responseExecute.body();
                    byte[] bArrBytes = responseBodyBody != null ? responseBodyBody.bytes() : null;
                    if (bArrBytes == null) {
                        bArrBytes = new byte[0];
                    }
                    wVar = new y(bArrBytes);
                } else {
                    wVar = responseExecute.code() == 304 ? v.a : new x(responseExecute.code());
                }
                CloseableKt.closeFinally(responseExecute, null);
            } finally {
                try {
                    throw th;
                } catch (Throwable th) {
                    CloseableKt.closeFinally(responseExecute, th);
                }
            }
        } catch (Throwable th2) {
            String str6 = "request for " + strA + " failed : ";
            if (C.a) {
                Log.e("Varioqub/NetworkClient", str6, th2);
            }
            wVar = new w(th2);
        }
        if (wVar instanceof v) {
            if (C.a) {
                Log.d("Varioqub/ConfigFetcher", "fetch response from cache");
            }
            if (onFetchCompleteListener != null) {
                onFetchCompleteListener.onSuccess();
            }
        } else if (wVar instanceof w) {
            String str7 = "fetch failed with exception " + ((w) wVar).a;
            if (C.a) {
                Log.d("Varioqub/ConfigFetcher", str7);
            }
            if (onFetchCompleteListener != null) {
                onFetchCompleteListener.onError(str7, FetchError.INTERNAL_ERROR);
            }
        } else {
            if (!(wVar instanceof x)) {
                if (wVar instanceof y) {
                    y yVar = (y) wVar;
                    c1424c = c1424c3;
                    c1424c.h.clear();
                    if (yVar.a.length == 0) {
                        boolean z2 = C.a;
                        if (z2 && z2) {
                            Log.e("Varioqub/Varioqub/ConfigFetcher", "fetch failed with empty body", null);
                        }
                        if (onFetchCompleteListener != null) {
                            onFetchCompleteListener.onError("fetch failed with empty body", FetchError.EMPTY_RESULT);
                        }
                    }
                    try {
                        r rVar = (r) MessageNano.mergeFrom(new r(), yVar.a);
                        String str8 = "fetched config - " + rVar;
                        if (C.a) {
                            Log.d("Varioqub/ConfigFetcher", str8);
                        }
                        c1424c.m = !Intrinsics.areEqual(c1424c.j, rVar.b);
                        c1424c.j = rVar.b;
                        c1424c.i = rVar.a;
                        c1424c.k = rVar.d;
                        for (q qVar : rVar.c) {
                            String str9 = qVar.a;
                            long j = ((s) ArraysKt.last(qVar.b)).b;
                            s sVar = (s) ArraysKt.last(qVar.b);
                            c1424c.h.put(str9, new ConfigValue(sVar.c ? null : sVar.a, 2, j));
                        }
                        if (onFetchCompleteListener != null) {
                            onFetchCompleteListener.onSuccess();
                        }
                        c1424c.e.getClass();
                        c1424c.g = System.currentTimeMillis();
                    } catch (Throwable th3) {
                        if (C.a) {
                            Log.e("Varioqub/ConfigFetcher", "exception while fetch ", th3);
                        }
                        if (onFetchCompleteListener != null) {
                            onFetchCompleteListener.onError("exception while fetch ", FetchError.RESPONSE_PARSE_ERROR);
                        }
                    }
                }
                c1424c.e.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                c1424c.f = jCurrentTimeMillis;
                m.a(jCurrentTimeMillis);
                m.b(c1424c.g);
                if (!m.a().edit().putString("experiments", c1424c.j).commit() && (z = C.a) && z) {
                    Log.e("Varioqub/Varioqub/PreferenceManager", "save experiments failed", null);
                }
                m.c(c1424c.i);
                m.b(c1424c.h);
                m.a(c1424c.m);
                l.a(1);
            }
            String str10 = "failed with network code " + ((x) wVar).a;
            if (C.a) {
                Log.d("Varioqub/ConfigFetcher", str10);
            }
            if (onFetchCompleteListener != null) {
                onFetchCompleteListener.onError(str10, FetchError.NETWORK_ERROR);
            }
        }
        c1424c = c1424c3;
        c1424c.e.getClass();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        c1424c.f = jCurrentTimeMillis2;
        m.a(jCurrentTimeMillis2);
        m.b(c1424c.g);
        if (!m.a().edit().putString("experiments", c1424c.j).commit()) {
            Log.e("Varioqub/Varioqub/PreferenceManager", "save experiments failed", null);
        }
        m.c(c1424c.i);
        m.b(c1424c.h);
        m.a(c1424c.m);
        l.a(1);
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final void activateConfig(Function0 function0) throws JSONException {
        a();
        C1424c c1424c = this.b;
        if (c1424c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configFetcher");
            c1424c = null;
        }
        c1424c.a();
        C1422a c1422a = c1424c.d;
        String str = c1424c.k;
        long j = c1424c.g;
        if (!Intrinsics.areEqual(c1422a.e, str) && c1422a.b.getActivateEvent()) {
            c1422a.a.reportConfigChanged(new ConfigData(c1422a.e, str, j));
            m.a(str);
        }
        c1422a.e = str;
        if (c1424c.m) {
            C1422a c1422a2 = c1424c.d;
            Collection collectionValues = c1424c.h.values();
            c1422a2.getClass();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((ConfigValue) it.next()).getTestId()));
            }
            Set<Long> mutableSet = CollectionsKt.toMutableSet(CollectionsKt.intersect(CollectionsKt.toSet(arrayList), c1422a2.c));
            c1422a2.c = mutableSet;
            c1422a2.a.setTriggeredTestIds(mutableSet);
            m.a(c1422a2.c);
            C1422a c1422a3 = c1424c.d;
            String str2 = c1424c.j;
            c1422a3.d = str2;
            c1422a3.a.setExperiments(str2);
            c1424c.m = false;
        }
        t tVar = c1424c.c;
        HashMap map = new HashMap(c1424c.h);
        tVar.a();
        tVar.b = map;
        m.a(map);
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final void clearClientFeatures() {
        Executor executor = this.d;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            executor = null;
        }
        executor.execute(new Runnable() { // from class: com.yandex.varioqub.config.impl.B$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                B.a(this.f$0);
            }
        });
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final void fetchConfig(final OnFetchCompleteListener onFetchCompleteListener) {
        a();
        Executor executor = this.d;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            executor = null;
        }
        executor.execute(new Runnable() { // from class: com.yandex.varioqub.config.impl.B$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                B.a(this.f$0, onFetchCompleteListener);
            }
        });
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final Set getAllKeys() throws JSONException {
        a();
        t tVar = this.c;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            tVar = null;
        }
        tVar.a();
        return CollectionsKt.toSet(CollectionsKt.union(tVar.b.keySet(), tVar.a.keySet()));
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final boolean getBoolean(String str, boolean z) throws JSONException {
        ConfigValue value = getValue(str);
        return value != null ? value.asBoolean() : z;
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final double getDouble(String str, double d) throws JSONException {
        ConfigValue value = getValue(str);
        return value != null ? value.asDouble() : d;
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final String getId() throws JSONException {
        a();
        C1424c c1424c = this.b;
        if (c1424c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configFetcher");
            c1424c = null;
        }
        c1424c.a();
        return c1424c.i;
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final long getLong(String str, long j) throws JSONException {
        ConfigValue value = getValue(str);
        return value != null ? value.asLong() : j;
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final String getString(String str, String str2) throws JSONException {
        String strAsString;
        ConfigValue value = getValue(str);
        return (value == null || (strAsString = value.asString()) == null) ? str2 : strAsString;
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final ConfigValue getValue(String str) throws JSONException {
        a();
        t tVar = this.c;
        t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            tVar = null;
        }
        tVar.a();
        ConfigValue configValue = (ConfigValue) tVar.b.get(str);
        if (configValue == null) {
            tVar.a();
            configValue = (ConfigValue) tVar.a.get(str);
        }
        if (configValue == null || configValue.getTestId() <= 0) {
            return configValue;
        }
        C1422a c1422a = this.a;
        if (c1422a == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticAdapter");
            c1422a = null;
        }
        long testId = configValue.getTestId();
        synchronized (c1422a.f) {
            c1422a.c.add(Long.valueOf(testId));
        }
        c1422a.a.setTriggeredTestIds(c1422a.c);
        m.a(c1422a.c);
        if (configValue.getCom.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.VALUE java.lang.String() != null) {
            return configValue;
        }
        t tVar3 = this.c;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
        } else {
            tVar2 = tVar3;
        }
        tVar2.a();
        return (ConfigValue) tVar2.a.get(str);
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final void init(VarioqubSettings varioqubSettings, VarioqubConfigAdapter varioqubConfigAdapter, Context context) {
        if (this.g.get()) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.g.get()) {
                    l.b(2);
                    C1422a c1422a = new C1422a(varioqubConfigAdapter, varioqubSettings);
                    ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    t tVar = new t();
                    a(varioqubSettings, c1422a, executorServiceNewSingleThreadExecutor, context, tVar, new C1424c(new i(), TimeUnit.SECONDS.toMillis(varioqubSettings.getFetchThrottleIntervalSec()), tVar, c1422a, new u()), new g(c1422a));
                    l.a(2);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final void putClientFeature(final String str, final String str2) {
        Executor executor = this.d;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            executor = null;
        }
        executor.execute(new Runnable() { // from class: com.yandex.varioqub.config.impl.B$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                B.a(this.f$0, str, str2);
            }
        });
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final void setDefaults(Map map) {
        a();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            map2.put(entry.getKey(), ConfigValue.INSTANCE.createInappDefault$config_release(entry.getValue().toString()));
        }
        t tVar = this.c;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            tVar = null;
        }
        tVar.a = map2;
    }

    @Override // com.yandex.varioqub.config.VarioqubApi
    public final void setDefaults(final int i, final Function0 function0) {
        a();
        Executor executor = this.d;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            executor = null;
        }
        executor.execute(new Runnable() { // from class: com.yandex.varioqub.config.impl.B$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws XmlPullParserException, Resources.NotFoundException {
                B.a(this.f$0, i, function0);
            }
        });
    }

    public static final void a(B b, int i, Function0 function0) throws XmlPullParserException, Resources.NotFoundException {
        t tVar = b.c;
        Context context = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            tVar = null;
        }
        if (i != -1) {
            Context context2 = AbstractC1425d.a;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appContext");
            } else {
                context = context2;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (context != null && context.getResources() != null) {
                XmlResourceParser xml = context.getResources().getXml(i);
                String text = "";
                String name = text;
                String text2 = name;
                while (xml.next() != 1) {
                    int eventType = xml.getEventType();
                    if (eventType == 2) {
                        name = xml.getName();
                    } else if (eventType == 3) {
                        if (Intrinsics.areEqual(xml.getName(), "entry") && text.length() > 0 && text2.length() > 0) {
                            linkedHashMap.put(text, ConfigValue.INSTANCE.createInappDefault$config_release(text2));
                        }
                        name = "";
                    } else if (eventType == 4) {
                        if (Intrinsics.areEqual(name, "key")) {
                            text = xml.getText();
                        } else if (Intrinsics.areEqual(name, AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                            text2 = xml.getText();
                        }
                    }
                }
            }
            tVar.a = linkedHashMap;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid resId: " + i);
    }

    public static final void a(B b, String str, String str2) {
        VarioqubSettings varioqubSettings = b.f;
        if (varioqubSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settings");
            varioqubSettings = null;
        }
        varioqubSettings.putClientFeature$config_release(str, str2);
    }

    public static final void a(B b) {
        VarioqubSettings varioqubSettings = b.f;
        if (varioqubSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settings");
            varioqubSettings = null;
        }
        varioqubSettings.clearClientFeatures$config_release();
    }

    public final void a() {
        if (!this.g.get()) {
            throw new IllegalStateException("VarioqubConfig is not inited. Please call init() method first");
        }
    }

    public final void a(VarioqubSettings varioqubSettings, C1422a c1422a, ExecutorService executorService, Context context, t tVar, C1424c c1424c, final g gVar) {
        this.f = varioqubSettings;
        this.a = c1422a;
        this.c = tVar;
        this.b = c1424c;
        this.d = executorService;
        this.e = gVar;
        AbstractC1425d.a = context.getApplicationContext();
        D.a = varioqubSettings.getUrl();
        C.a = varioqubSettings.getLogs();
        String string = m.a().getString("experiments", "");
        if (string == null) {
            string = "";
        }
        c1422a.d = string;
        c1422a.c = m.b();
        String string2 = m.a().getString("config_version", "");
        c1422a.e = string2 != null ? string2 : "";
        c1422a.a.setExperiments(c1422a.d);
        c1422a.a.setTriggeredTestIds(c1422a.c);
        this.g.set(true);
        executorService.execute(new Runnable() { // from class: com.yandex.varioqub.config.impl.B$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                B.a(gVar);
            }
        });
    }

    public static final void a(g gVar) {
        gVar.getClass();
        l.b(3);
        C1422a c1422a = gVar.a;
        c1422a.a.requestDeviceId(new e(gVar));
        C1422a c1422a2 = gVar.a;
        c1422a2.a.requestUserId(new f(gVar));
    }
}
