package ru.yoomoney.sdk.auth.phone.select;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Suggestion;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class PhoneSelectFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, Suggestion[] suggestionArr, ProcessType processType, OffsetDateTime offsetDateTime) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            if (suggestionArr == null) {
                throw new IllegalArgumentException("Argument \"suggestions\" is marked as non-null but was passed a null value.");
            }
            map.put("suggestions", suggestionArr);
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            map.put("processType", processType);
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
            }
            map.put("expireAt", offsetDateTime);
        }

        public PhoneSelectFragmentArgs build() {
            return new PhoneSelectFragmentArgs(this.arguments);
        }

        public OffsetDateTime getExpireAt() {
            return (OffsetDateTime) this.arguments.get("expireAt");
        }

        public String getProcessId() {
            return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        }

        public ProcessType getProcessType() {
            return (ProcessType) this.arguments.get("processType");
        }

        public Suggestion[] getSuggestions() {
            return (Suggestion[]) this.arguments.get("suggestions");
        }

        public Builder setExpireAt(OffsetDateTime offsetDateTime) {
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("expireAt", offsetDateTime);
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

        public Builder setSuggestions(Suggestion[] suggestionArr) {
            if (suggestionArr == null) {
                throw new IllegalArgumentException("Argument \"suggestions\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("suggestions", suggestionArr);
            return this;
        }

        public Builder(PhoneSelectFragmentArgs phoneSelectFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(phoneSelectFragmentArgs.arguments);
        }
    }

    private PhoneSelectFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static PhoneSelectFragmentArgs fromBundle(Bundle bundle) {
        Suggestion[] suggestionArr;
        PhoneSelectFragmentArgs phoneSelectFragmentArgs = new PhoneSelectFragmentArgs();
        if (!a.a(PhoneSelectFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        phoneSelectFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("suggestions")) {
            throw new IllegalArgumentException("Required argument \"suggestions\" is missing and does not have an android:defaultValue");
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("suggestions");
        if (parcelableArray != null) {
            suggestionArr = new Suggestion[parcelableArray.length];
            System.arraycopy(parcelableArray, 0, suggestionArr, 0, parcelableArray.length);
        } else {
            suggestionArr = null;
        }
        if (suggestionArr == null) {
            throw new IllegalArgumentException("Argument \"suggestions\" is marked as non-null but was passed a null value.");
        }
        phoneSelectFragmentArgs.arguments.put("suggestions", suggestionArr);
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
        phoneSelectFragmentArgs.arguments.put("processType", processType);
        if (!bundle.containsKey("expireAt")) {
            throw new IllegalArgumentException("Required argument \"expireAt\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(OffsetDateTime.class) && !Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
            throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) bundle.get("expireAt");
        if (offsetDateTime == null) {
            throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
        }
        phoneSelectFragmentArgs.arguments.put("expireAt", offsetDateTime);
        return phoneSelectFragmentArgs;
    }

    public static PhoneSelectFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        PhoneSelectFragmentArgs phoneSelectFragmentArgs = new PhoneSelectFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        phoneSelectFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("suggestions")) {
            throw new IllegalArgumentException("Required argument \"suggestions\" is missing and does not have an android:defaultValue");
        }
        Suggestion[] suggestionArr = (Suggestion[]) savedStateHandle.get("suggestions");
        if (suggestionArr == null) {
            throw new IllegalArgumentException("Argument \"suggestions\" is marked as non-null but was passed a null value.");
        }
        phoneSelectFragmentArgs.arguments.put("suggestions", suggestionArr);
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        phoneSelectFragmentArgs.arguments.put("processType", processType);
        if (!savedStateHandle.contains("expireAt")) {
            throw new IllegalArgumentException("Required argument \"expireAt\" is missing and does not have an android:defaultValue");
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) savedStateHandle.get("expireAt");
        if (offsetDateTime == null) {
            throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
        }
        phoneSelectFragmentArgs.arguments.put("expireAt", offsetDateTime);
        return phoneSelectFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhoneSelectFragmentArgs phoneSelectFragmentArgs = (PhoneSelectFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != phoneSelectFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? phoneSelectFragmentArgs.getProcessId() != null : !getProcessId().equals(phoneSelectFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("suggestions") != phoneSelectFragmentArgs.arguments.containsKey("suggestions")) {
            return false;
        }
        if (getSuggestions() == null ? phoneSelectFragmentArgs.getSuggestions() != null : !getSuggestions().equals(phoneSelectFragmentArgs.getSuggestions())) {
            return false;
        }
        if (this.arguments.containsKey("processType") != phoneSelectFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? phoneSelectFragmentArgs.getProcessType() != null : !getProcessType().equals(phoneSelectFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != phoneSelectFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        return getExpireAt() == null ? phoneSelectFragmentArgs.getExpireAt() == null : getExpireAt().equals(phoneSelectFragmentArgs.getExpireAt());
    }

    public OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.arguments.get("expireAt");
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public ProcessType getProcessType() {
        return (ProcessType) this.arguments.get("processType");
    }

    public Suggestion[] getSuggestions() {
        return (Suggestion[]) this.arguments.get("suggestions");
    }

    public int hashCode() {
        return ((((Arrays.hashCode(getSuggestions()) + (((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31)) * 31) + (getProcessType() != null ? getProcessType().hashCode() : 0)) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            bundle.putString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("suggestions")) {
            bundle.putParcelableArray("suggestions", (Suggestion[]) this.arguments.get("suggestions"));
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
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Object obj;
        Object obj2;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("suggestions")) {
            savedStateHandle.set("suggestions", (Suggestion[]) this.arguments.get("suggestions"));
        }
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
        }
        return savedStateHandle;
    }

    public String toString() {
        return "PhoneSelectFragmentArgs{processId=" + getProcessId() + ", suggestions=" + getSuggestions() + ", processType=" + getProcessType() + ", expireAt=" + getExpireAt() + "}";
    }

    private PhoneSelectFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
