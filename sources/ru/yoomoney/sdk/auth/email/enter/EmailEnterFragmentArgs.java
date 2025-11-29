package ru.yoomoney.sdk.auth.email.enter;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class EmailEnterFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(ProcessType processType, String str) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            map.put("processType", processType);
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        }

        public EmailEnterFragmentArgs build() {
            return new EmailEnterFragmentArgs(this.arguments);
        }

        public OffsetDateTime getExpireAt() {
            return (OffsetDateTime) this.arguments.get("expireAt");
        }

        public boolean getIsAddedToBackStack() {
            return ((Boolean) this.arguments.get("isAddedToBackStack")).booleanValue();
        }

        public String getPrefilledEmail() {
            return (String) this.arguments.get("prefilledEmail");
        }

        public String getProcessId() {
            return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        }

        public ProcessType getProcessType() {
            return (ProcessType) this.arguments.get("processType");
        }

        public Builder setExpireAt(OffsetDateTime offsetDateTime) {
            this.arguments.put("expireAt", offsetDateTime);
            return this;
        }

        public Builder setIsAddedToBackStack(boolean z) {
            this.arguments.put("isAddedToBackStack", Boolean.valueOf(z));
            return this;
        }

        public Builder setPrefilledEmail(String str) {
            this.arguments.put("prefilledEmail", str);
            return this;
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

        public Builder(EmailEnterFragmentArgs emailEnterFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(emailEnterFragmentArgs.arguments);
        }
    }

    private EmailEnterFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static EmailEnterFragmentArgs fromBundle(Bundle bundle) {
        EmailEnterFragmentArgs emailEnterFragmentArgs = new EmailEnterFragmentArgs();
        if (!a.a(EmailEnterFragmentArgs.class, bundle, "processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessType.class) && !Serializable.class.isAssignableFrom(ProcessType.class)) {
            throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessType processType = (ProcessType) bundle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        emailEnterFragmentArgs.arguments.put("processType", processType);
        if (!bundle.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        emailEnterFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("expireAt")) {
            emailEnterFragmentArgs.arguments.put("expireAt", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(OffsetDateTime.class) && !Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            emailEnterFragmentArgs.arguments.put("expireAt", (OffsetDateTime) bundle.get("expireAt"));
        }
        if (bundle.containsKey("prefilledEmail")) {
            emailEnterFragmentArgs.arguments.put("prefilledEmail", bundle.getString("prefilledEmail"));
        } else {
            emailEnterFragmentArgs.arguments.put("prefilledEmail", null);
        }
        if (bundle.containsKey("isAddedToBackStack")) {
            emailEnterFragmentArgs.arguments.put("isAddedToBackStack", Boolean.valueOf(bundle.getBoolean("isAddedToBackStack")));
        } else {
            emailEnterFragmentArgs.arguments.put("isAddedToBackStack", Boolean.TRUE);
        }
        return emailEnterFragmentArgs;
    }

    public static EmailEnterFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        EmailEnterFragmentArgs emailEnterFragmentArgs = new EmailEnterFragmentArgs();
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        emailEnterFragmentArgs.arguments.put("processType", processType);
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        emailEnterFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (savedStateHandle.contains("expireAt")) {
            emailEnterFragmentArgs.arguments.put("expireAt", (OffsetDateTime) savedStateHandle.get("expireAt"));
        } else {
            emailEnterFragmentArgs.arguments.put("expireAt", null);
        }
        if (savedStateHandle.contains("prefilledEmail")) {
            emailEnterFragmentArgs.arguments.put("prefilledEmail", (String) savedStateHandle.get("prefilledEmail"));
        } else {
            emailEnterFragmentArgs.arguments.put("prefilledEmail", null);
        }
        if (savedStateHandle.contains("isAddedToBackStack")) {
            Boolean bool = (Boolean) savedStateHandle.get("isAddedToBackStack");
            bool.booleanValue();
            emailEnterFragmentArgs.arguments.put("isAddedToBackStack", bool);
        } else {
            emailEnterFragmentArgs.arguments.put("isAddedToBackStack", Boolean.TRUE);
        }
        return emailEnterFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmailEnterFragmentArgs emailEnterFragmentArgs = (EmailEnterFragmentArgs) obj;
        if (this.arguments.containsKey("processType") != emailEnterFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? emailEnterFragmentArgs.getProcessType() != null : !getProcessType().equals(emailEnterFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != emailEnterFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? emailEnterFragmentArgs.getProcessId() != null : !getProcessId().equals(emailEnterFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != emailEnterFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        if (getExpireAt() == null ? emailEnterFragmentArgs.getExpireAt() != null : !getExpireAt().equals(emailEnterFragmentArgs.getExpireAt())) {
            return false;
        }
        if (this.arguments.containsKey("prefilledEmail") != emailEnterFragmentArgs.arguments.containsKey("prefilledEmail")) {
            return false;
        }
        if (getPrefilledEmail() == null ? emailEnterFragmentArgs.getPrefilledEmail() == null : getPrefilledEmail().equals(emailEnterFragmentArgs.getPrefilledEmail())) {
            return this.arguments.containsKey("isAddedToBackStack") == emailEnterFragmentArgs.arguments.containsKey("isAddedToBackStack") && getIsAddedToBackStack() == emailEnterFragmentArgs.getIsAddedToBackStack();
        }
        return false;
    }

    public OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.arguments.get("expireAt");
    }

    public boolean getIsAddedToBackStack() {
        return ((Boolean) this.arguments.get("isAddedToBackStack")).booleanValue();
    }

    public String getPrefilledEmail() {
        return (String) this.arguments.get("prefilledEmail");
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public ProcessType getProcessType() {
        return (ProcessType) this.arguments.get("processType");
    }

    public int hashCode() {
        return (getIsAddedToBackStack() ? 1 : 0) + (((((((((getProcessType() != null ? getProcessType().hashCode() : 0) + 31) * 31) + (getProcessId() != null ? getProcessId().hashCode() : 0)) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0)) * 31) + (getPrefilledEmail() != null ? getPrefilledEmail().hashCode() : 0)) * 31);
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
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            bundle.putString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("expireAt")) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) this.arguments.get("expireAt");
            if (Parcelable.class.isAssignableFrom(OffsetDateTime.class) || offsetDateTime == null) {
                bundle.putParcelable("expireAt", (Parcelable) Parcelable.class.cast(offsetDateTime));
            } else {
                if (!Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                    throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("expireAt", (Serializable) Serializable.class.cast(offsetDateTime));
            }
        } else {
            bundle.putSerializable("expireAt", null);
        }
        if (this.arguments.containsKey("prefilledEmail")) {
            bundle.putString("prefilledEmail", (String) this.arguments.get("prefilledEmail"));
        } else {
            bundle.putString("prefilledEmail", null);
        }
        bundle.putBoolean("isAddedToBackStack", this.arguments.containsKey("isAddedToBackStack") ? ((Boolean) this.arguments.get("isAddedToBackStack")).booleanValue() : true);
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Boolean bool;
        Object obj;
        Object obj2;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("processType")) {
            ProcessType processType = (ProcessType) this.arguments.get("processType");
            if (Parcelable.class.isAssignableFrom(ProcessType.class) || processType == null) {
                obj2 = (Parcelable) Parcelable.class.cast(processType);
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessType.class)) {
                    throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj2 = (Serializable) Serializable.class.cast(processType);
            }
            savedStateHandle.set("processType", obj2);
        }
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("expireAt")) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) this.arguments.get("expireAt");
            if (Parcelable.class.isAssignableFrom(OffsetDateTime.class) || offsetDateTime == null) {
                obj = (Parcelable) Parcelable.class.cast(offsetDateTime);
            } else {
                if (!Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                    throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(offsetDateTime);
            }
            savedStateHandle.set("expireAt", obj);
        } else {
            savedStateHandle.set("expireAt", null);
        }
        if (this.arguments.containsKey("prefilledEmail")) {
            savedStateHandle.set("prefilledEmail", (String) this.arguments.get("prefilledEmail"));
        } else {
            savedStateHandle.set("prefilledEmail", null);
        }
        if (this.arguments.containsKey("isAddedToBackStack")) {
            bool = (Boolean) this.arguments.get("isAddedToBackStack");
            bool.booleanValue();
        } else {
            bool = Boolean.TRUE;
        }
        savedStateHandle.set("isAddedToBackStack", bool);
        return savedStateHandle;
    }

    public String toString() {
        return "EmailEnterFragmentArgs{processType=" + getProcessType() + ", processId=" + getProcessId() + ", expireAt=" + getExpireAt() + ", prefilledEmail=" + getPrefilledEmail() + ", isAddedToBackStack=" + getIsAddedToBackStack() + "}";
    }

    private EmailEnterFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
