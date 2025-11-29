package com.yandex.varioqub.appmetricaadapter;

import android.content.Context;
import com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback;
import com.yandex.varioqub.analyticadapter.VarioqubConfigAdapter;
import com.yandex.varioqub.analyticadapter.data.ConfigData;
import com.yandex.varioqub.appmetricaadapter.impl.d;
import com.yandex.varioqub.appmetricaadapter.impl.e;
import com.yandex.varioqub.appmetricaadapter.impl.k;
import com.yandex.varioqub.protobuf.nano.MessageNano;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\f8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/yandex/varioqub/appmetricaadapter/AppMetricaAdapter;", "Lcom/yandex/varioqub/analyticadapter/VarioqubConfigAdapter;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/yandex/varioqub/analyticadapter/AdapterIdentifiersCallback;", "callback", "", "requestDeviceId", "(Lcom/yandex/varioqub/analyticadapter/AdapterIdentifiersCallback;)V", "requestUserId", "", "experiments", "setExperiments", "(Ljava/lang/String;)V", "", "", "triggeredTestIds", "setTriggeredTestIds", "(Ljava/util/Set;)V", "Lcom/yandex/varioqub/analyticadapter/data/ConfigData;", "configData", "reportConfigChanged", "(Lcom/yandex/varioqub/analyticadapter/data/ConfigData;)V", "e", "Ljava/lang/String;", "getAdapterName", "()Ljava/lang/String;", "adapterName", "Companion", "appmetrica-adapter_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class AppMetricaAdapter implements VarioqubConfigAdapter {
    private final Context a;
    private final d b = e.a();
    private String c = "";
    private Set d = SetsKt.emptySet();

    /* renamed from: e, reason: from kotlin metadata */
    private final String adapterName = "AppMetricaAdapter";

    public AppMetricaAdapter(Context context) {
        this.a = context;
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigAdapter
    public String getAdapterName() {
        return this.adapterName;
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigReporter
    public void reportConfigChanged(ConfigData configData) {
        d dVar = this.b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("old_config", configData.getOldConfigVersion());
        linkedHashMap.put("new_config", configData.getNewConfigVersion());
        linkedHashMap.put("timestamp", Long.valueOf(configData.getConfigLoadTimestamp()));
        dVar.a(linkedHashMap);
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigClientIdentifiersProvider
    public void requestDeviceId(AdapterIdentifiersCallback callback) {
        this.b.a(this.a, callback);
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigClientIdentifiersProvider
    public void requestUserId(AdapterIdentifiersCallback callback) {
        this.b.b(this.a, callback);
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigReporter
    public void setExperiments(String experiments) {
        this.c = experiments;
        Objects.toString(this.d);
        d dVar = this.b;
        k kVar = new k();
        kVar.a = this.c;
        kVar.b = CollectionsKt.toLongArray(this.d);
        dVar.a(MessageNano.toByteArray(kVar));
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigReporter
    public void setTriggeredTestIds(Set<Long> triggeredTestIds) {
        Objects.toString(triggeredTestIds);
        Set set = CollectionsKt.toSet(triggeredTestIds);
        this.d = set;
        Objects.toString(set);
        d dVar = this.b;
        k kVar = new k();
        kVar.a = this.c;
        kVar.b = CollectionsKt.toLongArray(this.d);
        dVar.a(MessageNano.toByteArray(kVar));
    }
}
