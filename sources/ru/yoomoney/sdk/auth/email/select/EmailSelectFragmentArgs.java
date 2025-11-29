package ru.yoomoney.sdk.auth.email.select;

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
public class EmailSelectFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, ProcessType processType, OffsetDateTime offsetDateTime, Suggestion[] suggestionArr) {
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
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
            }
            map.put("expireAt", offsetDateTime);
            if (suggestionArr == null) {
                throw new IllegalArgumentException("Argument \"suggestions\" is marked as non-null but was passed a null value.");
            }
            map.put("suggestions", suggestionArr);
        }

        public EmailSelectFragmentArgs build() {
            return new EmailSelectFragmentArgs(this.arguments);
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

        public Builder(EmailSelectFragmentArgs emailSelectFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(emailSelectFragmentArgs.arguments);
        }
    }

    private EmailSelectFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static EmailSelectFragmentArgs fromBundle(Bundle bundle) {
        Suggestion[] suggestionArr;
        EmailSelectFragmentArgs emailSelectFragmentArgs = new EmailSelectFragmentArgs();
        if (!a.a(EmailSelectFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        emailSelectFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
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
        emailSelectFragmentArgs.arguments.put("processType", processType);
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
        emailSelectFragmentArgs.arguments.put("expireAt", offsetDateTime);
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
        emailSelectFragmentArgs.arguments.put("suggestions", suggestionArr);
        return emailSelectFragmentArgs;
    }

    public static EmailSelectFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        EmailSelectFragmentArgs emailSelectFragmentArgs = new EmailSelectFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        emailSelectFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        emailSelectFragmentArgs.arguments.put("processType", processType);
        if (!savedStateHandle.contains("expireAt")) {
            throw new IllegalArgumentException("Required argument \"expireAt\" is missing and does not have an android:defaultValue");
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) savedStateHandle.get("expireAt");
        if (offsetDateTime == null) {
            throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
        }
        emailSelectFragmentArgs.arguments.put("expireAt", offsetDateTime);
        if (!savedStateHandle.contains("suggestions")) {
            throw new IllegalArgumentException("Required argument \"suggestions\" is missing and does not have an android:defaultValue");
        }
        Suggestion[] suggestionArr = (Suggestion[]) savedStateHandle.get("suggestions");
        if (suggestionArr == null) {
            throw new IllegalArgumentException("Argument \"suggestions\" is marked as non-null but was passed a null value.");
        }
        emailSelectFragmentArgs.arguments.put("suggestions", suggestionArr);
        return emailSelectFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmailSelectFragmentArgs emailSelectFragmentArgs = (EmailSelectFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != emailSelectFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? emailSelectFragmentArgs.getProcessId() != null : !getProcessId().equals(emailSelectFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("processType") != emailSelectFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? emailSelectFragmentArgs.getProcessType() != null : !getProcessType().equals(emailSelectFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != emailSelectFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        if (getExpireAt() == null ? emailSelectFragmentArgs.getExpireAt() != null : !getExpireAt().equals(emailSelectFragmentArgs.getExpireAt())) {
            return false;
        }
        if (this.arguments.containsKey("suggestions") != emailSelectFragmentArgs.arguments.containsKey("suggestions")) {
            return false;
        }
        return getSuggestions() == null ? emailSelectFragmentArgs.getSuggestions() == null : getSuggestions().equals(emailSelectFragmentArgs.getSuggestions());
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
        return Arrays.hashCode(getSuggestions()) + (((((((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31) + (getProcessType() != null ? getProcessType().hashCode() : 0)) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0)) * 31);
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
        if (this.arguments.containsKey("suggestions")) {
            bundle.putParcelableArray("suggestions", (Suggestion[]) this.arguments.get("suggestions"));
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
        if (this.arguments.containsKey("suggestions")) {
            savedStateHandle.set("suggestions", (Suggestion[]) this.arguments.get("suggestions"));
        }
        return savedStateHandle;
    }

    public String toString() {
        return "EmailSelectFragmentArgs{processId=" + getProcessId() + ", processType=" + getProcessType() + ", expireAt=" + getExpireAt() + ", suggestions=" + getSuggestions() + "}";
    }

    private EmailSelectFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
