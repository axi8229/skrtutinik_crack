package ru.yoomoney.sdk.auth.acceptTerms;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class AcceptTermsFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, ProcessType processType) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            map.put("processType", processType);
        }

        public AcceptTermsFragmentArgs build() {
            return new AcceptTermsFragmentArgs(this.arguments);
        }

        public String getProcessId() {
            return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        }

        public ProcessType getProcessType() {
            return (ProcessType) this.arguments.get("processType");
        }

        public Builder setProcessId(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            return this;
        }

        public Builder setProcessType(ProcessType processType) {
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("processType", processType);
            return this;
        }

        public Builder(AcceptTermsFragmentArgs acceptTermsFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(acceptTermsFragmentArgs.arguments);
        }
    }

    private AcceptTermsFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static AcceptTermsFragmentArgs fromBundle(Bundle bundle) {
        AcceptTermsFragmentArgs acceptTermsFragmentArgs = new AcceptTermsFragmentArgs();
        if (!a.a(AcceptTermsFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        acceptTermsFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessType.class) && !Serializable.class.isAssignableFrom(ProcessType.class)) {
            throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessType processType = (ProcessType) bundle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        acceptTermsFragmentArgs.arguments.put("processType", processType);
        return acceptTermsFragmentArgs;
    }

    public static AcceptTermsFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        AcceptTermsFragmentArgs acceptTermsFragmentArgs = new AcceptTermsFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        acceptTermsFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        acceptTermsFragmentArgs.arguments.put("processType", processType);
        return acceptTermsFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AcceptTermsFragmentArgs acceptTermsFragmentArgs = (AcceptTermsFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != acceptTermsFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? acceptTermsFragmentArgs.getProcessId() != null : !getProcessId().equals(acceptTermsFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("processType") != acceptTermsFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        return getProcessType() == null ? acceptTermsFragmentArgs.getProcessType() == null : getProcessType().equals(acceptTermsFragmentArgs.getProcessType());
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public ProcessType getProcessType() {
        return (ProcessType) this.arguments.get("processType");
    }

    public int hashCode() {
        return (((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31) + (getProcessType() != null ? getProcessType().hashCode() : 0);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            bundle.putString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
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
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
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
        return "AcceptTermsFragmentArgs{processId=" + getProcessId() + ", processType=" + getProcessType() + "}";
    }

    private AcceptTermsFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
