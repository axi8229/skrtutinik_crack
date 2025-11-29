package com.sputnik.data.local.delegates.adapters;

import com.sputnik.domain.entities.prefs.Camera;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: CamerasAdapter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/sputnik/data/local/delegates/adapters/CamerasAdapter;", "Lcom/sputnik/data/local/delegates/adapters/JsonAdapter;", "", "Lcom/sputnik/domain/entities/prefs/Camera;", "()V", "fromJson", "json", "", "toJson", "obj", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CamerasAdapter implements JsonAdapter<List<? extends Camera>> {
    @Override // com.sputnik.data.local.delegates.adapters.JsonAdapter
    public /* bridge */ /* synthetic */ String toJson(List<? extends Camera> list) {
        return toJson2((List<Camera>) list);
    }

    @Override // com.sputnik.data.local.delegates.adapters.JsonAdapter
    public List<? extends Camera> fromJson(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Json.Companion companion = Json.INSTANCE;
        return (List) companion.decodeFromString(SerializersKt.serializer(companion.getSerializersModule(), Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Camera.class)))), json);
    }

    /* renamed from: toJson, reason: avoid collision after fix types in other method */
    public String toJson2(List<Camera> obj) {
        Json.Companion companion = Json.INSTANCE;
        return companion.encodeToString(SerializersKt.serializer(companion.getSerializersModule(), Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Camera.class)))), obj);
    }
}
