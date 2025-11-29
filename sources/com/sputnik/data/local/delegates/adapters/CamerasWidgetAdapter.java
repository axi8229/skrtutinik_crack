package com.sputnik.data.local.delegates.adapters;

import com.sputnik.domain.entities.prefs.CamerasWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: CamerasWidgetAdapter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/sputnik/data/local/delegates/adapters/CamerasWidgetAdapter;", "Lcom/sputnik/data/local/delegates/adapters/JsonAdapter;", "", "Lcom/sputnik/domain/entities/prefs/CamerasWidget;", "()V", "fromJson", "json", "", "toJson", "obj", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CamerasWidgetAdapter implements JsonAdapter<List<? extends CamerasWidget>> {
    @Override // com.sputnik.data.local.delegates.adapters.JsonAdapter
    public /* bridge */ /* synthetic */ String toJson(List<? extends CamerasWidget> list) {
        return toJson2((List<CamerasWidget>) list);
    }

    @Override // com.sputnik.data.local.delegates.adapters.JsonAdapter
    public List<? extends CamerasWidget> fromJson(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Json jsonJson$default = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.sputnik.data.local.delegates.adapters.CamerasWidgetAdapter.fromJson.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setIgnoreUnknownKeys(true);
            }
        }, 1, null);
        return (List) jsonJson$default.decodeFromString(SerializersKt.serializer(jsonJson$default.getSerializersModule(), Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(CamerasWidget.class)))), json);
    }

    /* renamed from: toJson, reason: avoid collision after fix types in other method */
    public String toJson2(List<CamerasWidget> obj) {
        Json jsonJson$default = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.sputnik.data.local.delegates.adapters.CamerasWidgetAdapter.toJson.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setIgnoreUnknownKeys(true);
            }
        }, 1, null);
        return jsonJson$default.encodeToString(SerializersKt.serializer(jsonJson$default.getSerializersModule(), Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(CamerasWidget.class)))), obj);
    }
}
