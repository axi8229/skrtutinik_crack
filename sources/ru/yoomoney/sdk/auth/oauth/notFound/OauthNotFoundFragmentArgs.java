package ru.yoomoney.sdk.auth.oauth.notFound;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class OauthNotFoundFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, ProcessError processError) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            if (processError == null) {
                throw new IllegalArgumentException("Argument \"processError\" is marked as non-null but was passed a null value.");
            }
            map.put("processError", processError);
        }

        public OauthNotFoundFragmentArgs build() {
            return new OauthNotFoundFragmentArgs(this.arguments);
        }

        public ProcessError getProcessError() {
            return (ProcessError) this.arguments.get("processError");
        }

        public String getProcessId() {
            return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        }

        public Builder setProcessError(ProcessError processError) {
            if (processError == null) {
                throw new IllegalArgumentException("Argument \"processError\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("processError", processError);
            return this;
        }

        public Builder setProcessId(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            return this;
        }

        public Builder(OauthNotFoundFragmentArgs oauthNotFoundFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(oauthNotFoundFragmentArgs.arguments);
        }
    }

    private OauthNotFoundFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static OauthNotFoundFragmentArgs fromBundle(Bundle bundle) {
        OauthNotFoundFragmentArgs oauthNotFoundFragmentArgs = new OauthNotFoundFragmentArgs();
        if (!a.a(OauthNotFoundFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        oauthNotFoundFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("processError")) {
            throw new IllegalArgumentException("Required argument \"processError\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessError.class) && !Serializable.class.isAssignableFrom(ProcessError.class)) {
            throw new UnsupportedOperationException(ProcessError.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessError processError = (ProcessError) bundle.get("processError");
        if (processError == null) {
            throw new IllegalArgumentException("Argument \"processError\" is marked as non-null but was passed a null value.");
        }
        oauthNotFoundFragmentArgs.arguments.put("processError", processError);
        return oauthNotFoundFragmentArgs;
    }

    public static OauthNotFoundFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        OauthNotFoundFragmentArgs oauthNotFoundFragmentArgs = new OauthNotFoundFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        oauthNotFoundFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("processError")) {
            throw new IllegalArgumentException("Required argument \"processError\" is missing and does not have an android:defaultValue");
        }
        ProcessError processError = (ProcessError) savedStateHandle.get("processError");
        if (processError == null) {
            throw new IllegalArgumentException("Argument \"processError\" is marked as non-null but was passed a null value.");
        }
        oauthNotFoundFragmentArgs.arguments.put("processError", processError);
        return oauthNotFoundFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OauthNotFoundFragmentArgs oauthNotFoundFragmentArgs = (OauthNotFoundFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != oauthNotFoundFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? oauthNotFoundFragmentArgs.getProcessId() != null : !getProcessId().equals(oauthNotFoundFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("processError") != oauthNotFoundFragmentArgs.arguments.containsKey("processError")) {
            return false;
        }
        return getProcessError() == null ? oauthNotFoundFragmentArgs.getProcessError() == null : getProcessError().equals(oauthNotFoundFragmentArgs.getProcessError());
    }

    public ProcessError getProcessError() {
        return (ProcessError) this.arguments.get("processError");
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public int hashCode() {
        return (((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31) + (getProcessError() != null ? getProcessError().hashCode() : 0);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            bundle.putString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("processError")) {
            ProcessError processError = (ProcessError) this.arguments.get("processError");
            if (Parcelable.class.isAssignableFrom(ProcessError.class) || processError == null) {
                bundle.putParcelable("processError", (Parcelable) Parcelable.class.cast(processError));
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessError.class)) {
                    throw new UnsupportedOperationException(ProcessError.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("processError", (Serializable) Serializable.class.cast(processError));
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
        if (this.arguments.containsKey("processError")) {
            ProcessError processError = (ProcessError) this.arguments.get("processError");
            if (Parcelable.class.isAssignableFrom(ProcessError.class) || processError == null) {
                obj = (Parcelable) Parcelable.class.cast(processError);
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessError.class)) {
                    throw new UnsupportedOperationException(ProcessError.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(processError);
            }
            savedStateHandle.set("processError", obj);
        }
        return savedStateHandle;
    }

    public String toString() {
        return "OauthNotFoundFragmentArgs{processId=" + getProcessId() + ", processError=" + getProcessError() + "}";
    }

    private OauthNotFoundFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
