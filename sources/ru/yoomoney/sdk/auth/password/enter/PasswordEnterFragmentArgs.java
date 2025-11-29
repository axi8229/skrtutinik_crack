package ru.yoomoney.sdk.auth.password.enter;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class PasswordEnterFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, ProcessType processType, Account account, OffsetDateTime offsetDateTime) {
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
            map.put("account", account);
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
            }
            map.put("expireAt", offsetDateTime);
        }

        public PasswordEnterFragmentArgs build() {
            return new PasswordEnterFragmentArgs(this.arguments);
        }

        public Account getAccount() {
            return (Account) this.arguments.get("account");
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

        public Builder setAccount(Account account) {
            this.arguments.put("account", account);
            return this;
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

        public Builder(PasswordEnterFragmentArgs passwordEnterFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(passwordEnterFragmentArgs.arguments);
        }
    }

    private PasswordEnterFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static PasswordEnterFragmentArgs fromBundle(Bundle bundle) {
        PasswordEnterFragmentArgs passwordEnterFragmentArgs = new PasswordEnterFragmentArgs();
        if (!a.a(PasswordEnterFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        passwordEnterFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
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
        passwordEnterFragmentArgs.arguments.put("processType", processType);
        if (!bundle.containsKey("account")) {
            throw new IllegalArgumentException("Required argument \"account\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(Account.class) && !Serializable.class.isAssignableFrom(Account.class)) {
            throw new UnsupportedOperationException(Account.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        passwordEnterFragmentArgs.arguments.put("account", (Account) bundle.get("account"));
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
        passwordEnterFragmentArgs.arguments.put("expireAt", offsetDateTime);
        return passwordEnterFragmentArgs;
    }

    public static PasswordEnterFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        PasswordEnterFragmentArgs passwordEnterFragmentArgs = new PasswordEnterFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        passwordEnterFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        passwordEnterFragmentArgs.arguments.put("processType", processType);
        if (!savedStateHandle.contains("account")) {
            throw new IllegalArgumentException("Required argument \"account\" is missing and does not have an android:defaultValue");
        }
        passwordEnterFragmentArgs.arguments.put("account", (Account) savedStateHandle.get("account"));
        if (!savedStateHandle.contains("expireAt")) {
            throw new IllegalArgumentException("Required argument \"expireAt\" is missing and does not have an android:defaultValue");
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) savedStateHandle.get("expireAt");
        if (offsetDateTime == null) {
            throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
        }
        passwordEnterFragmentArgs.arguments.put("expireAt", offsetDateTime);
        return passwordEnterFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PasswordEnterFragmentArgs passwordEnterFragmentArgs = (PasswordEnterFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != passwordEnterFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? passwordEnterFragmentArgs.getProcessId() != null : !getProcessId().equals(passwordEnterFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("processType") != passwordEnterFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? passwordEnterFragmentArgs.getProcessType() != null : !getProcessType().equals(passwordEnterFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey("account") != passwordEnterFragmentArgs.arguments.containsKey("account")) {
            return false;
        }
        if (getAccount() == null ? passwordEnterFragmentArgs.getAccount() != null : !getAccount().equals(passwordEnterFragmentArgs.getAccount())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != passwordEnterFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        return getExpireAt() == null ? passwordEnterFragmentArgs.getExpireAt() == null : getExpireAt().equals(passwordEnterFragmentArgs.getExpireAt());
    }

    public Account getAccount() {
        return (Account) this.arguments.get("account");
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

    public int hashCode() {
        return (((((((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31) + (getProcessType() != null ? getProcessType().hashCode() : 0)) * 31) + (getAccount() != null ? getAccount().hashCode() : 0)) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0);
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
        if (this.arguments.containsKey("account")) {
            Account account = (Account) this.arguments.get("account");
            if (Parcelable.class.isAssignableFrom(Account.class) || account == null) {
                bundle.putParcelable("account", (Parcelable) Parcelable.class.cast(account));
            } else {
                if (!Serializable.class.isAssignableFrom(Account.class)) {
                    throw new UnsupportedOperationException(Account.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("account", (Serializable) Serializable.class.cast(account));
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
        Object obj3;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("processType")) {
            ProcessType processType = (ProcessType) this.arguments.get("processType");
            if (Parcelable.class.isAssignableFrom(ProcessType.class) || processType == null) {
                obj3 = (Parcelable) Parcelable.class.cast(processType);
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessType.class)) {
                    throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj3 = (Serializable) Serializable.class.cast(processType);
            }
            savedStateHandle.set("processType", obj3);
        }
        if (this.arguments.containsKey("account")) {
            Account account = (Account) this.arguments.get("account");
            if (Parcelable.class.isAssignableFrom(Account.class) || account == null) {
                obj2 = (Parcelable) Parcelable.class.cast(account);
            } else {
                if (!Serializable.class.isAssignableFrom(Account.class)) {
                    throw new UnsupportedOperationException(Account.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj2 = (Serializable) Serializable.class.cast(account);
            }
            savedStateHandle.set("account", obj2);
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
        return "PasswordEnterFragmentArgs{processId=" + getProcessId() + ", processType=" + getProcessType() + ", account=" + getAccount() + ", expireAt=" + getExpireAt() + "}";
    }

    private PasswordEnterFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
