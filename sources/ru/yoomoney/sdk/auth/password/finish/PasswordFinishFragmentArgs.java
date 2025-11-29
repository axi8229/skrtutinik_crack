package ru.yoomoney.sdk.auth.password.finish;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.ProcessType;

/* loaded from: classes4.dex */
public class PasswordFinishFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(ProcessType processType) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            map.put("processType", processType);
        }

        public PasswordFinishFragmentArgs build() {
            return new PasswordFinishFragmentArgs(this.arguments);
        }

        public ProcessType getProcessType() {
            return (ProcessType) this.arguments.get("processType");
        }

        public Builder setProcessType(ProcessType processType) {
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("processType", processType);
            return this;
        }

        public Builder(PasswordFinishFragmentArgs passwordFinishFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(passwordFinishFragmentArgs.arguments);
        }
    }

    private PasswordFinishFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static PasswordFinishFragmentArgs fromBundle(Bundle bundle) {
        PasswordFinishFragmentArgs passwordFinishFragmentArgs = new PasswordFinishFragmentArgs();
        if (!a.a(PasswordFinishFragmentArgs.class, bundle, "processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessType.class) && !Serializable.class.isAssignableFrom(ProcessType.class)) {
            throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessType processType = (ProcessType) bundle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        passwordFinishFragmentArgs.arguments.put("processType", processType);
        return passwordFinishFragmentArgs;
    }

    public static PasswordFinishFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        PasswordFinishFragmentArgs passwordFinishFragmentArgs = new PasswordFinishFragmentArgs();
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        passwordFinishFragmentArgs.arguments.put("processType", processType);
        return passwordFinishFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PasswordFinishFragmentArgs passwordFinishFragmentArgs = (PasswordFinishFragmentArgs) obj;
        if (this.arguments.containsKey("processType") != passwordFinishFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        return getProcessType() == null ? passwordFinishFragmentArgs.getProcessType() == null : getProcessType().equals(passwordFinishFragmentArgs.getProcessType());
    }

    public ProcessType getProcessType() {
        return (ProcessType) this.arguments.get("processType");
    }

    public int hashCode() {
        return (getProcessType() != null ? getProcessType().hashCode() : 0) + 31;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("processType")) {
            ProcessType processType = (ProcessType) this.arguments.get("processType");
            if (Parcelable.class.isAssignableFrom(ProcessType.class) || processType == null) {
                bundle.putParcelable("processType", (Parcelable) Parcelable.class.cast(processType));
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessType.class)) {
                    throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("processType", (Serializable) Serializable.class.cast(processType));
            }
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Object obj;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("processType")) {
            ProcessType processType = (ProcessType) this.arguments.get("processType");
            if (Parcelable.class.isAssignableFrom(ProcessType.class) || processType == null) {
                obj = (Parcelable) Parcelable.class.cast(processType);
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessType.class)) {
                    throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(processType);
            }
            savedStateHandle.set("processType", obj);
        }
        return savedStateHandle;
    }

    public String toString() {
        return "PasswordFinishFragmentArgs{processType=" + getProcessType() + "}";
    }

    private PasswordFinishFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
