package com.sputnik.data.local.delegates.adapters;

import com.sputnik.domain.entities.prefs.AppSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: AppSettingsAdapter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/sputnik/data/local/delegates/adapters/AppSettingsAdapter;", "Lcom/sputnik/data/local/delegates/adapters/JsonAdapter;", "Lcom/sputnik/domain/entities/prefs/AppSettings;", "()V", "fromJson", "json", "", "toJson", "obj", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppSettingsAdapter implements JsonAdapter<AppSettings> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sputnik.data.local.delegates.adapters.JsonAdapter
    public AppSettings fromJson(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.length() == 0) {
            return AppSettings.INSTANCE.m2542default();
        }
        Json.Companion companion = Json.INSTANCE;
        return (AppSettings) companion.decodeFromString(SerializersKt.serializer(companion.getSerializersModule(), Reflection.typeOf(AppSettings.class)), json);
    }

    @Override // com.sputnik.data.local.delegates.adapters.JsonAdapter
    public String toJson(AppSettings obj) {
        Json.Companion companion = Json.INSTANCE;
        return companion.encodeToString(SerializersKt.serializer(companion.getSerializersModule(), Reflection.nullableTypeOf(AppSettings.class)), obj);
    }
}
