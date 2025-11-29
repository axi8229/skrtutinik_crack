package ru.yoomoney.sdk.auth.finishing.failure;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.model.ProcessError;

/* loaded from: classes4.dex */
public class AuthFinishingFailureFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(ProcessError processError) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (processError == null) {
                throw new IllegalArgumentException("Argument \"processError\" is marked as non-null but was passed a null value.");
            }
            map.put("processError", processError);
        }

        public AuthFinishingFailureFragmentArgs build() {
            return new AuthFinishingFailureFragmentArgs(this.arguments);
        }

        public ProcessError getProcessError() {
            return (ProcessError) this.arguments.get("processError");
        }

        public Builder setProcessError(ProcessError processError) {
            if (processError == null) {
                throw new IllegalArgumentException("Argument \"processError\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("processError", processError);
            return this;
        }

        public Builder(AuthFinishingFailureFragmentArgs authFinishingFailureFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(authFinishingFailureFragmentArgs.arguments);
        }
    }

    private AuthFinishingFailureFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static AuthFinishingFailureFragmentArgs fromBundle(Bundle bundle) {
        AuthFinishingFailureFragmentArgs authFinishingFailureFragmentArgs = new AuthFinishingFailureFragmentArgs();
        if (!a.a(AuthFinishingFailureFragmentArgs.class, bundle, "processError")) {
            throw new IllegalArgumentException("Required argument \"processError\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessError.class) && !Serializable.class.isAssignableFrom(ProcessError.class)) {
            throw new UnsupportedOperationException(ProcessError.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessError processError = (ProcessError) bundle.get("processError");
        if (processError == null) {
            throw new IllegalArgumentException("Argument \"processError\" is marked as non-null but was passed a null value.");
        }
        authFinishingFailureFragmentArgs.arguments.put("processError", processError);
        return authFinishingFailureFragmentArgs;
    }

    public static AuthFinishingFailureFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        AuthFinishingFailureFragmentArgs authFinishingFailureFragmentArgs = new AuthFinishingFailureFragmentArgs();
        if (!savedStateHandle.contains("processError")) {
            throw new IllegalArgumentException("Required argument \"processError\" is missing and does not have an android:defaultValue");
        }
        ProcessError processError = (ProcessError) savedStateHandle.get("processError");
        if (processError == null) {
            throw new IllegalArgumentException("Argument \"processError\" is marked as non-null but was passed a null value.");
        }
        authFinishingFailureFragmentArgs.arguments.put("processError", processError);
        return authFinishingFailureFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AuthFinishingFailureFragmentArgs authFinishingFailureFragmentArgs = (AuthFinishingFailureFragmentArgs) obj;
        if (this.arguments.containsKey("processError") != authFinishingFailureFragmentArgs.arguments.containsKey("processError")) {
            return false;
        }
        return getProcessError() == null ? authFinishingFailureFragmentArgs.getProcessError() == null : getProcessError().equals(authFinishingFailureFragmentArgs.getProcessError());
    }

    public ProcessError getProcessError() {
        return (ProcessError) this.arguments.get("processError");
    }

    public int hashCode() {
        return (getProcessError() != null ? getProcessError().hashCode() : 0) + 31;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
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
        return "AuthFinishingFailureFragmentArgs{processError=" + getProcessError() + "}";
    }

    private AuthFinishingFailureFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
