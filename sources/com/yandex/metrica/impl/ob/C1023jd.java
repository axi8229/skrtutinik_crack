package com.yandex.metrica.impl.ob;

import com.yandex.metrica.modules.api.ModuleEntryPoint;
import com.yandex.metrica.modules.api.RemoteConfigExtensionConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* renamed from: com.yandex.metrica.impl.ob.jd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1023jd implements InterfaceC1048kd, InterfaceC1053ki {
    private final CopyOnWriteArrayList<ModuleEntryPoint> a = new CopyOnWriteArrayList<>();

    @Override // com.yandex.metrica.impl.ob.InterfaceC1048kd
    public Map<String, Integer> a() {
        List listEmptyList;
        Map blocks;
        CopyOnWriteArrayList<ModuleEntryPoint> copyOnWriteArrayList = this.a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = ((ModuleEntryPoint) it.next()).getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration == null || (blocks = remoteConfigExtensionConfiguration.getBlocks()) == null || (listEmptyList = MapsKt.toList(blocks)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, listEmptyList);
        }
        return MapsKt.toMap(arrayList);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public void a(EnumC0954gi enumC0954gi, C1178pi c1178pi) {
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1048kd
    public List<String> b() {
        List listEmptyList;
        CopyOnWriteArrayList<ModuleEntryPoint> copyOnWriteArrayList = this.a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = ((ModuleEntryPoint) it.next()).getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration == null || (listEmptyList = remoteConfigExtensionConfiguration.getFeatures()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, listEmptyList);
        }
        return arrayList;
    }

    public Map<String, C0974hd> c() {
        CopyOnWriteArrayList<ModuleEntryPoint> copyOnWriteArrayList = this.a;
        ArrayList arrayList = new ArrayList();
        for (ModuleEntryPoint moduleEntryPoint : copyOnWriteArrayList) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = moduleEntryPoint.getRemoteConfigExtensionConfiguration();
            Pair pair = remoteConfigExtensionConfiguration != null ? TuplesKt.to(moduleEntryPoint.getIdentifier(), new C0974hd(remoteConfigExtensionConfiguration)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public void a(C1178pi c1178pi) {
        C0999id c0999id = new C0999id(c1178pi);
        for (ModuleEntryPoint moduleEntryPoint : this.a) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = moduleEntryPoint.getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration != null) {
                remoteConfigExtensionConfiguration.getRemoteConfigUpdateListener().onRemoteConfigUpdated(c0999id.a(moduleEntryPoint.getIdentifier()));
            }
        }
    }
}
