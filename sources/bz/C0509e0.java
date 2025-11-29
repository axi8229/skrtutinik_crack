package bz;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.Serializable;
import java.util.Objects;

/* renamed from: bz.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0509e0 extends Z0 {
    public final SharedPreferences a;

    public C0509e0(Context context, String str) {
        this.a = context.getSharedPreferences(str, 0);
    }

    @Override // bz.Z0
    public final C0572z0 a(zone.bi.mobile.fingerprint.api.f fVar) {
        Serializable serializableValueOf;
        Class cls = fVar.a;
        if (!this.a.contains(fVar.a())) {
            return null;
        }
        if (cls == String.class) {
            serializableValueOf = this.a.getString(fVar.a(), null);
        } else if (cls == Integer.class) {
            serializableValueOf = Integer.valueOf(this.a.getInt(fVar.a(), -1));
        } else if (cls == Long.class) {
            serializableValueOf = Long.valueOf(this.a.getLong(fVar.a(), -1L));
        } else if (cls == Boolean.class) {
            serializableValueOf = Boolean.valueOf(this.a.getBoolean(fVar.a(), false));
        } else {
            if (cls != Float.class) {
                throw new zone.bi.mobile.fingerprint.api.a("unknown value class for SharedPreferencesCacheStore: " + cls.getCanonicalName());
            }
            serializableValueOf = Float.valueOf(this.a.getFloat(fVar.a(), -1.0f));
        }
        long j = this.a.getLong(fVar.a() + "_time", 0L);
        Objects.requireNonNull(serializableValueOf);
        return new C0572z0(serializableValueOf, j);
    }

    @Override // bz.Z0
    public final void a(zone.bi.mobile.fingerprint.api.f fVar, C0572z0 c0572z0) {
        if (c0572z0 == null) {
            this.a.edit().remove(fVar.a()).apply();
            return;
        }
        Class cls = fVar.a;
        if (cls == String.class) {
            this.a.edit().putString(fVar.a(), (String) c0572z0.a).apply();
        } else if (cls == Integer.class) {
            this.a.edit().putInt(fVar.a(), ((Integer) c0572z0.a).intValue()).apply();
        } else if (cls == Long.class) {
            this.a.edit().putLong(fVar.a(), ((Long) c0572z0.a).longValue()).apply();
        } else if (cls == Boolean.class) {
            this.a.edit().putBoolean(fVar.a(), ((Boolean) c0572z0.a).booleanValue()).apply();
        } else if (cls == Float.class) {
            this.a.edit().putFloat(fVar.a(), ((Float) c0572z0.a).floatValue()).apply();
        }
        this.a.edit().putLong(fVar.a() + "_time", c0572z0.b).apply();
    }
}
