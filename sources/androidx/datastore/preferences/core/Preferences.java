package androidx.datastore.preferences.core;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Preferences.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H¦\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "", "<init>", "()V", "T", "Landroidx/datastore/preferences/core/Preferences$Key;", "key", "get", "(Landroidx/datastore/preferences/core/Preferences$Key;)Ljava/lang/Object;", "", "asMap", "()Ljava/util/Map;", "Landroidx/datastore/preferences/core/MutablePreferences;", "toMutablePreferences", "()Landroidx/datastore/preferences/core/MutablePreferences;", "toPreferences", "()Landroidx/datastore/preferences/core/Preferences;", "Key", "Pair", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class Preferences {
    public abstract Map<Key<?>, Object> asMap();

    public abstract <T> T get(Key<T> key);

    /* compiled from: Preferences.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/datastore/preferences/core/Preferences$Key;", "T", "", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "<init>", "(Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getName", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Key<T> {
        private final String name;

        public Key(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            if (other instanceof Key) {
                return Intrinsics.areEqual(this.name, ((Key) other).name);
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return this.name;
        }
    }

    /* compiled from: Preferences.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00028\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/preferences/core/Preferences$Pair;", "T", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "getKey$datastore_preferences_core", "()Landroidx/datastore/preferences/core/Preferences$Key;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Ljava/lang/Object;", "getValue$datastore_preferences_core", "()Ljava/lang/Object;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Pair<T> {
        private final Key<T> key;
        private final T value;

        public final Key<T> getKey$datastore_preferences_core() {
            return this.key;
        }

        public final T getValue$datastore_preferences_core() {
            return this.value;
        }
    }

    public final MutablePreferences toMutablePreferences() {
        return new MutablePreferences(MapsKt.toMutableMap(asMap()), false);
    }

    public final Preferences toPreferences() {
        return new MutablePreferences(MapsKt.toMutableMap(asMap()), true);
    }
}
