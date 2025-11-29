package com.axmor.ash.toolset.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class GsonEnumFallbackTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
    private final T fallbackValue;
    private final HashMap<String, T> namesToValues;
    private boolean serializeFallbackValue;
    private final EnumMap<T, String> valuesToNames;

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T read2(JsonReader jsonReader) {
        T t = this.namesToValues.get(jsonReader.nextString());
        return t == null ? this.fallbackValue : t;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (t == null || (t == this.fallbackValue && !this.serializeFallbackValue)) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(this.valuesToNames.get(t));
        }
    }
}
