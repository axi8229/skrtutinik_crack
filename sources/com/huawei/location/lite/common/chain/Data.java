package com.huawei.location.lite.common.chain;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Data {
    public static final Data EMPTY = new Builder().build();
    Map<String, Object> mValues;

    public static final class Builder {
        private Map<String, Object> mValues = new HashMap();

        public Data build() {
            return new Data(this.mValues);
        }

        public Builder put(String str, Object obj) {
            if (obj == null) {
                this.mValues.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls != Integer.class && cls != String.class && !(obj instanceof Serializable) && !(obj instanceof Parcelable)) {
                    throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Key %s has invalid type %s", str, cls));
                }
                this.mValues.put(str, obj);
            }
            return this;
        }

        public Builder putAll(Data data) {
            putAll(data.mValues);
            return this;
        }

        public Builder putAll(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder putInt(String str, int i) {
            this.mValues.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder putParcelable(String str, Parcelable parcelable) {
            this.mValues.put(str, parcelable);
            return this;
        }

        public Builder putString(String str, String str2) {
            this.mValues.put(str, str2);
            return this;
        }
    }

    Data(Map<String, ?> map) {
        this.mValues = new HashMap(map);
    }

    public int getInt(String str, int i) {
        Object obj = this.mValues.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i;
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public Parcelable getParcelable(String str) {
        Object obj = this.mValues.get(str);
        return obj instanceof Parcelable ? (Parcelable) obj : new Parcelable() { // from class: com.huawei.location.lite.common.chain.Data.1
            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
            }
        };
    }

    public String getString(String str) {
        Object obj = this.mValues.get(str);
        return obj instanceof String ? (String) obj : "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String str : this.mValues.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.mValues.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
