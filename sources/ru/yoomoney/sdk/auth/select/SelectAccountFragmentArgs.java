package ru.yoomoney.sdk.auth.select;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class SelectAccountFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, Account[] accountArr, ProcessType processType) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            if (accountArr == null) {
                throw new IllegalArgumentException("Argument \"accounts\" is marked as non-null but was passed a null value.");
            }
            map.put("accounts", accountArr);
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            map.put("processType", processType);
        }

        public SelectAccountFragmentArgs build() {
            return new SelectAccountFragmentArgs(this.arguments);
        }

        public Account[] getAccounts() {
            return (Account[]) this.arguments.get("accounts");
        }

        public OffsetDateTime getExpireAt() {
            return (OffsetDateTime) this.arguments.get("expireAt");
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

        public boolean getShouldRegistrationBeAddedToBackstack() {
            return ((Boolean) this.arguments.get("shouldRegistrationBeAddedToBackstack")).booleanValue();
        }

        public Builder setAccounts(Account[] accountArr) {
            if (accountArr == null) {
                throw new IllegalArgumentException("Argument \"accounts\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("accounts", accountArr);
            return this;
        }

        public Builder setExpireAt(OffsetDateTime offsetDateTime) {
            this.arguments.put("expireAt", offsetDateTime);
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

        public Builder setShouldRegistrationBeAddedToBackstack(boolean z) {
            this.arguments.put("shouldRegistrationBeAddedToBackstack", Boolean.valueOf(z));
            return this;
        }

        public Builder(SelectAccountFragmentArgs selectAccountFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(selectAccountFragmentArgs.arguments);
        }
    }

    private SelectAccountFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static SelectAccountFragmentArgs fromBundle(Bundle bundle) {
        Account[] accountArr;
        SelectAccountFragmentArgs selectAccountFragmentArgs = new SelectAccountFragmentArgs();
        if (!ru.yoomoney.sdk.auth.acceptTerms.a.a(SelectAccountFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        selectAccountFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("accounts")) {
            throw new IllegalArgumentException("Required argument \"accounts\" is missing and does not have an android:defaultValue");
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("accounts");
        if (parcelableArray != null) {
            accountArr = new Account[parcelableArray.length];
            System.arraycopy(parcelableArray, 0, accountArr, 0, parcelableArray.length);
        } else {
            accountArr = null;
        }
        if (accountArr == null) {
            throw new IllegalArgumentException("Argument \"accounts\" is marked as non-null but was passed a null value.");
        }
        selectAccountFragmentArgs.arguments.put("accounts", accountArr);
        if (bundle.containsKey("prefilledEmail")) {
            selectAccountFragmentArgs.arguments.put("prefilledEmail", bundle.getString("prefilledEmail"));
        } else {
            selectAccountFragmentArgs.arguments.put("prefilledEmail", null);
        }
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
        selectAccountFragmentArgs.arguments.put("processType", processType);
        if (!bundle.containsKey("expireAt")) {
            selectAccountFragmentArgs.arguments.put("expireAt", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(OffsetDateTime.class) && !Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            selectAccountFragmentArgs.arguments.put("expireAt", (OffsetDateTime) bundle.get("expireAt"));
        }
        if (bundle.containsKey("shouldRegistrationBeAddedToBackstack")) {
            selectAccountFragmentArgs.arguments.put("shouldRegistrationBeAddedToBackstack", Boolean.valueOf(bundle.getBoolean("shouldRegistrationBeAddedToBackstack")));
        } else {
            selectAccountFragmentArgs.arguments.put("shouldRegistrationBeAddedToBackstack", Boolean.TRUE);
        }
        return selectAccountFragmentArgs;
    }

    public static SelectAccountFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        SelectAccountFragmentArgs selectAccountFragmentArgs = new SelectAccountFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        selectAccountFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("accounts")) {
            throw new IllegalArgumentException("Required argument \"accounts\" is missing and does not have an android:defaultValue");
        }
        Account[] accountArr = (Account[]) savedStateHandle.get("accounts");
        if (accountArr == null) {
            throw new IllegalArgumentException("Argument \"accounts\" is marked as non-null but was passed a null value.");
        }
        selectAccountFragmentArgs.arguments.put("accounts", accountArr);
        if (savedStateHandle.contains("prefilledEmail")) {
            selectAccountFragmentArgs.arguments.put("prefilledEmail", (String) savedStateHandle.get("prefilledEmail"));
        } else {
            selectAccountFragmentArgs.arguments.put("prefilledEmail", null);
        }
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        selectAccountFragmentArgs.arguments.put("processType", processType);
        if (savedStateHandle.contains("expireAt")) {
            selectAccountFragmentArgs.arguments.put("expireAt", (OffsetDateTime) savedStateHandle.get("expireAt"));
        } else {
            selectAccountFragmentArgs.arguments.put("expireAt", null);
        }
        if (savedStateHandle.contains("shouldRegistrationBeAddedToBackstack")) {
            Boolean bool = (Boolean) savedStateHandle.get("shouldRegistrationBeAddedToBackstack");
            bool.booleanValue();
            selectAccountFragmentArgs.arguments.put("shouldRegistrationBeAddedToBackstack", bool);
        } else {
            selectAccountFragmentArgs.arguments.put("shouldRegistrationBeAddedToBackstack", Boolean.TRUE);
        }
        return selectAccountFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SelectAccountFragmentArgs selectAccountFragmentArgs = (SelectAccountFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != selectAccountFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? selectAccountFragmentArgs.getProcessId() != null : !getProcessId().equals(selectAccountFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("accounts") != selectAccountFragmentArgs.arguments.containsKey("accounts")) {
            return false;
        }
        if (getAccounts() == null ? selectAccountFragmentArgs.getAccounts() != null : !getAccounts().equals(selectAccountFragmentArgs.getAccounts())) {
            return false;
        }
        if (this.arguments.containsKey("prefilledEmail") != selectAccountFragmentArgs.arguments.containsKey("prefilledEmail")) {
            return false;
        }
        if (getPrefilledEmail() == null ? selectAccountFragmentArgs.getPrefilledEmail() != null : !getPrefilledEmail().equals(selectAccountFragmentArgs.getPrefilledEmail())) {
            return false;
        }
        if (this.arguments.containsKey("processType") != selectAccountFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? selectAccountFragmentArgs.getProcessType() != null : !getProcessType().equals(selectAccountFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != selectAccountFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        if (getExpireAt() == null ? selectAccountFragmentArgs.getExpireAt() == null : getExpireAt().equals(selectAccountFragmentArgs.getExpireAt())) {
            return this.arguments.containsKey("shouldRegistrationBeAddedToBackstack") == selectAccountFragmentArgs.arguments.containsKey("shouldRegistrationBeAddedToBackstack") && getShouldRegistrationBeAddedToBackstack() == selectAccountFragmentArgs.getShouldRegistrationBeAddedToBackstack();
        }
        return false;
    }

    public Account[] getAccounts() {
        return (Account[]) this.arguments.get("accounts");
    }

    public OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.arguments.get("expireAt");
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

    public boolean getShouldRegistrationBeAddedToBackstack() {
        return ((Boolean) this.arguments.get("shouldRegistrationBeAddedToBackstack")).booleanValue();
    }

    public int hashCode() {
        return (getShouldRegistrationBeAddedToBackstack() ? 1 : 0) + ((((((((Arrays.hashCode(getAccounts()) + (((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31)) * 31) + (getPrefilledEmail() != null ? getPrefilledEmail().hashCode() : 0)) * 31) + (getProcessType() != null ? getProcessType().hashCode() : 0)) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0)) * 31);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            bundle.putString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("accounts")) {
            bundle.putParcelableArray("accounts", (Account[]) this.arguments.get("accounts"));
        }
        if (this.arguments.containsKey("prefilledEmail")) {
            bundle.putString("prefilledEmail", (String) this.arguments.get("prefilledEmail"));
        } else {
            bundle.putString("prefilledEmail", null);
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
        } else {
            bundle.putSerializable("expireAt", null);
        }
        bundle.putBoolean("shouldRegistrationBeAddedToBackstack", this.arguments.containsKey("shouldRegistrationBeAddedToBackstack") ? ((Boolean) this.arguments.get("shouldRegistrationBeAddedToBackstack")).booleanValue() : true);
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Boolean bool;
        Object obj;
        Object obj2;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("accounts")) {
            savedStateHandle.set("accounts", (Account[]) this.arguments.get("accounts"));
        }
        if (this.arguments.containsKey("prefilledEmail")) {
            savedStateHandle.set("prefilledEmail", (String) this.arguments.get("prefilledEmail"));
        } else {
            savedStateHandle.set("prefilledEmail", null);
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
        } else {
            savedStateHandle.set("expireAt", null);
        }
        if (this.arguments.containsKey("shouldRegistrationBeAddedToBackstack")) {
            bool = (Boolean) this.arguments.get("shouldRegistrationBeAddedToBackstack");
            bool.booleanValue();
        } else {
            bool = Boolean.TRUE;
        }
        savedStateHandle.set("shouldRegistrationBeAddedToBackstack", bool);
        return savedStateHandle;
    }

    public String toString() {
        return "SelectAccountFragmentArgs{processId=" + getProcessId() + ", accounts=" + getAccounts() + ", prefilledEmail=" + getPrefilledEmail() + ", processType=" + getProcessType() + ", expireAt=" + getExpireAt() + ", shouldRegistrationBeAddedToBackstack=" + getShouldRegistrationBeAddedToBackstack() + "}";
    }

    private SelectAccountFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
