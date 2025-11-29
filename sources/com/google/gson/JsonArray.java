package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final List<JsonElement> elements;

    public JsonArray() {
        this.elements = new ArrayList();
    }

    public JsonArray(int i) {
        this.elements = new ArrayList(i);
    }

    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        if (!this.elements.isEmpty()) {
            JsonArray jsonArray = new JsonArray(this.elements.size());
            Iterator<JsonElement> it = this.elements.iterator();
            while (it.hasNext()) {
                jsonArray.add(it.next().deepCopy());
            }
            return jsonArray;
        }
        return new JsonArray();
    }

    public void add(String str) {
        this.elements.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement);
    }

    public int size() {
        return this.elements.size();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public JsonElement get(int i) {
        return this.elements.get(i);
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsNumber();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsString();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).elements.equals(this.elements));
    }

    public int hashCode() {
        return this.elements.hashCode();
    }
}
