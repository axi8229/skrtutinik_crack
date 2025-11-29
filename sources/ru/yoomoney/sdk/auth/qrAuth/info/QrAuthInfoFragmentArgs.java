package ru.yoomoney.sdk.auth.qrAuth.info;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class QrAuthInfoFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, Config config) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            if (config == null) {
                throw new IllegalArgumentException("Argument \"config\" is marked as non-null but was passed a null value.");
            }
            map.put("config", config);
        }

        public QrAuthInfoFragmentArgs build() {
            return new QrAuthInfoFragmentArgs(this.arguments);
        }

        public Config getConfig() {
            return (Config) this.arguments.get("config");
        }

        public String getProcessId() {
            return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        }

        public Builder setConfig(Config config) {
            if (config == null) {
                throw new IllegalArgumentException("Argument \"config\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("config", config);
            return this;
        }

        public Builder setProcessId(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            return this;
        }

        public Builder(QrAuthInfoFragmentArgs qrAuthInfoFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(qrAuthInfoFragmentArgs.arguments);
        }
    }

    private QrAuthInfoFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static QrAuthInfoFragmentArgs fromBundle(Bundle bundle) {
        QrAuthInfoFragmentArgs qrAuthInfoFragmentArgs = new QrAuthInfoFragmentArgs();
        if (!a.a(QrAuthInfoFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        qrAuthInfoFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("config")) {
            throw new IllegalArgumentException("Required argument \"config\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(Config.class) && !Serializable.class.isAssignableFrom(Config.class)) {
            throw new UnsupportedOperationException(Config.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        Config config = (Config) bundle.get("config");
        if (config == null) {
            throw new IllegalArgumentException("Argument \"config\" is marked as non-null but was passed a null value.");
        }
        qrAuthInfoFragmentArgs.arguments.put("config", config);
        return qrAuthInfoFragmentArgs;
    }

    public static QrAuthInfoFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        QrAuthInfoFragmentArgs qrAuthInfoFragmentArgs = new QrAuthInfoFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        qrAuthInfoFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("config")) {
            throw new IllegalArgumentException("Required argument \"config\" is missing and does not have an android:defaultValue");
        }
        Config config = (Config) savedStateHandle.get("config");
        if (config == null) {
            throw new IllegalArgumentException("Argument \"config\" is marked as non-null but was passed a null value.");
        }
        qrAuthInfoFragmentArgs.arguments.put("config", config);
        return qrAuthInfoFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QrAuthInfoFragmentArgs qrAuthInfoFragmentArgs = (QrAuthInfoFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != qrAuthInfoFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? qrAuthInfoFragmentArgs.getProcessId() != null : !getProcessId().equals(qrAuthInfoFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("config") != qrAuthInfoFragmentArgs.arguments.containsKey("config")) {
            return false;
        }
        return getConfig() == null ? qrAuthInfoFragmentArgs.getConfig() == null : getConfig().equals(qrAuthInfoFragmentArgs.getConfig());
    }

    public Config getConfig() {
        return (Config) this.arguments.get("config");
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public int hashCode() {
        return (((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31) + (getConfig() != null ? getConfig().hashCode() : 0);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            bundle.putString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
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
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
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
        return "QrAuthInfoFragmentArgs{processId=" + getProcessId() + ", config=" + getConfig() + "}";
    }

    private QrAuthInfoFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
