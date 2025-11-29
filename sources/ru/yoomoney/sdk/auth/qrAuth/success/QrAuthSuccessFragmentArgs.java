package ru.yoomoney.sdk.auth.qrAuth.success;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.acceptTerms.a;

/* loaded from: classes4.dex */
public class QrAuthSuccessFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(Config config) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (config == null) {
                throw new IllegalArgumentException("Argument \"config\" is marked as non-null but was passed a null value.");
            }
            map.put("config", config);
        }

        public QrAuthSuccessFragmentArgs build() {
            return new QrAuthSuccessFragmentArgs(this.arguments);
        }

        public Config getConfig() {
            return (Config) this.arguments.get("config");
        }

        public Builder setConfig(Config config) {
            if (config == null) {
                throw new IllegalArgumentException("Argument \"config\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("config", config);
            return this;
        }

        public Builder(QrAuthSuccessFragmentArgs qrAuthSuccessFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(qrAuthSuccessFragmentArgs.arguments);
        }
    }

    private QrAuthSuccessFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static QrAuthSuccessFragmentArgs fromBundle(Bundle bundle) {
        QrAuthSuccessFragmentArgs qrAuthSuccessFragmentArgs = new QrAuthSuccessFragmentArgs();
        if (!a.a(QrAuthSuccessFragmentArgs.class, bundle, "config")) {
            throw new IllegalArgumentException("Required argument \"config\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(Config.class) && !Serializable.class.isAssignableFrom(Config.class)) {
            throw new UnsupportedOperationException(Config.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        Config config = (Config) bundle.get("config");
        if (config == null) {
            throw new IllegalArgumentException("Argument \"config\" is marked as non-null but was passed a null value.");
        }
        qrAuthSuccessFragmentArgs.arguments.put("config", config);
        return qrAuthSuccessFragmentArgs;
    }

    public static QrAuthSuccessFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        QrAuthSuccessFragmentArgs qrAuthSuccessFragmentArgs = new QrAuthSuccessFragmentArgs();
        if (!savedStateHandle.contains("config")) {
            throw new IllegalArgumentException("Required argument \"config\" is missing and does not have an android:defaultValue");
        }
        Config config = (Config) savedStateHandle.get("config");
        if (config == null) {
            throw new IllegalArgumentException("Argument \"config\" is marked as non-null but was passed a null value.");
        }
        qrAuthSuccessFragmentArgs.arguments.put("config", config);
        return qrAuthSuccessFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QrAuthSuccessFragmentArgs qrAuthSuccessFragmentArgs = (QrAuthSuccessFragmentArgs) obj;
        if (this.arguments.containsKey("config") != qrAuthSuccessFragmentArgs.arguments.containsKey("config")) {
            return false;
        }
        return getConfig() == null ? qrAuthSuccessFragmentArgs.getConfig() == null : getConfig().equals(qrAuthSuccessFragmentArgs.getConfig());
    }

    public Config getConfig() {
        return (Config) this.arguments.get("config");
    }

    public int hashCode() {
        return (getConfig() != null ? getConfig().hashCode() : 0) + 31;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("config")) {
            Config config = (Config) this.arguments.get("config");
            if (Parcelable.class.isAssignableFrom(Config.class) || config == null) {
                bundle.putParcelable("config", (Parcelable) Parcelable.class.cast(config));
            } else {
                if (!Serializable.class.isAssignableFrom(Config.class)) {
                    throw new UnsupportedOperationException(Config.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("config", (Serializable) Serializable.class.cast(config));
            }
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Object obj;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("config")) {
            Config config = (Config) this.arguments.get("config");
            if (Parcelable.class.isAssignableFrom(Config.class) || config == null) {
                obj = (Parcelable) Parcelable.class.cast(config);
            } else {
                if (!Serializable.class.isAssignableFrom(Config.class)) {
                    throw new UnsupportedOperationException(Config.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(config);
            }
            savedStateHandle.set("config", obj);
        }
        return savedStateHandle;
    }

    public String toString() {
        return "QrAuthSuccessFragmentArgs{config=" + getConfig() + "}";
    }

    private QrAuthSuccessFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
