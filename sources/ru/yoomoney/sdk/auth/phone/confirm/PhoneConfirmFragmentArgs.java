package ru.yoomoney.sdk.auth.phone.confirm;

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
public class PhoneConfirmFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(ProcessType processType, String str, OffsetDateTime offsetDateTime, String str2, OffsetDateTime offsetDateTime2) {
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
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
            }
            map.put("expireAt", offsetDateTime);
            if (str2 == null) {
                throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
            }
            map.put("phone", str2);
            if (offsetDateTime2 == null) {
                throw new IllegalArgumentException("Argument \"nextResendFrom\" is marked as non-null but was passed a null value.");
            }
            map.put("nextResendFrom", offsetDateTime2);
        }

        public PhoneConfirmFragmentArgs build() {
            return new PhoneConfirmFragmentArgs(this.arguments);
        }

        public OffsetDateTime getExpireAt() {
            return (OffsetDateTime) this.arguments.get("expireAt");
        }

        public OffsetDateTime getNextResendFrom() {
            return (OffsetDateTime) this.arguments.get("nextResendFrom");
        }

        public String getPhone() {
            return (String) this.arguments.get("phone");
        }

        public String getProcessId() {
            return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        }

        public ProcessType getProcessType() {
            return (ProcessType) this.arguments.get("processType");
        }

        public int getSecretLength() {
            return ((Integer) this.arguments.get("secretLength")).intValue();
        }

        public Builder setExpireAt(OffsetDateTime offsetDateTime) {
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("expireAt", offsetDateTime);
            return this;
        }

        public Builder setNextResendFrom(OffsetDateTime offsetDateTime) {
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"nextResendFrom\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("nextResendFrom", offsetDateTime);
            return this;
        }

        public Builder setPhone(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("phone", str);
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

        public Builder setSecretLength(int i) {
            this.arguments.put("secretLength", Integer.valueOf(i));
            return this;
        }

        public Builder(PhoneConfirmFragmentArgs phoneConfirmFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(phoneConfirmFragmentArgs.arguments);
        }
    }

    private PhoneConfirmFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static PhoneConfirmFragmentArgs fromBundle(Bundle bundle) {
        PhoneConfirmFragmentArgs phoneConfirmFragmentArgs = new PhoneConfirmFragmentArgs();
        if (!a.a(PhoneConfirmFragmentArgs.class, bundle, "processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessType.class) && !Serializable.class.isAssignableFrom(ProcessType.class)) {
            throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessType processType = (ProcessType) bundle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put("processType", processType);
        if (!bundle.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
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
        phoneConfirmFragmentArgs.arguments.put("expireAt", offsetDateTime);
        if (!bundle.containsKey("phone")) {
            throw new IllegalArgumentException("Required argument \"phone\" is missing and does not have an android:defaultValue");
        }
        String string2 = bundle.getString("phone");
        if (string2 == null) {
            throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put("phone", string2);
        if (bundle.containsKey("secretLength")) {
            phoneConfirmFragmentArgs.arguments.put("secretLength", Integer.valueOf(bundle.getInt("secretLength")));
        } else {
            phoneConfirmFragmentArgs.arguments.put("secretLength", 6);
        }
        if (!bundle.containsKey("nextResendFrom")) {
            throw new IllegalArgumentException("Required argument \"nextResendFrom\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(OffsetDateTime.class) && !Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
            throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        OffsetDateTime offsetDateTime2 = (OffsetDateTime) bundle.get("nextResendFrom");
        if (offsetDateTime2 == null) {
            throw new IllegalArgumentException("Argument \"nextResendFrom\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put("nextResendFrom", offsetDateTime2);
        return phoneConfirmFragmentArgs;
    }

    public static PhoneConfirmFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        PhoneConfirmFragmentArgs phoneConfirmFragmentArgs = new PhoneConfirmFragmentArgs();
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put("processType", processType);
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("expireAt")) {
            throw new IllegalArgumentException("Required argument \"expireAt\" is missing and does not have an android:defaultValue");
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) savedStateHandle.get("expireAt");
        if (offsetDateTime == null) {
            throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put("expireAt", offsetDateTime);
        if (!savedStateHandle.contains("phone")) {
            throw new IllegalArgumentException("Required argument \"phone\" is missing and does not have an android:defaultValue");
        }
        String str2 = (String) savedStateHandle.get("phone");
        if (str2 == null) {
            throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put("phone", str2);
        if (savedStateHandle.contains("secretLength")) {
            Integer num = (Integer) savedStateHandle.get("secretLength");
            num.intValue();
            phoneConfirmFragmentArgs.arguments.put("secretLength", num);
        } else {
            phoneConfirmFragmentArgs.arguments.put("secretLength", 6);
        }
        if (!savedStateHandle.contains("nextResendFrom")) {
            throw new IllegalArgumentException("Required argument \"nextResendFrom\" is missing and does not have an android:defaultValue");
        }
        OffsetDateTime offsetDateTime2 = (OffsetDateTime) savedStateHandle.get("nextResendFrom");
        if (offsetDateTime2 == null) {
            throw new IllegalArgumentException("Argument \"nextResendFrom\" is marked as non-null but was passed a null value.");
        }
        phoneConfirmFragmentArgs.arguments.put("nextResendFrom", offsetDateTime2);
        return phoneConfirmFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhoneConfirmFragmentArgs phoneConfirmFragmentArgs = (PhoneConfirmFragmentArgs) obj;
        if (this.arguments.containsKey("processType") != phoneConfirmFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? phoneConfirmFragmentArgs.getProcessType() != null : !getProcessType().equals(phoneConfirmFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != phoneConfirmFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? phoneConfirmFragmentArgs.getProcessId() != null : !getProcessId().equals(phoneConfirmFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != phoneConfirmFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        if (getExpireAt() == null ? phoneConfirmFragmentArgs.getExpireAt() != null : !getExpireAt().equals(phoneConfirmFragmentArgs.getExpireAt())) {
            return false;
        }
        if (this.arguments.containsKey("phone") != phoneConfirmFragmentArgs.arguments.containsKey("phone")) {
            return false;
        }
        if (getPhone() == null ? phoneConfirmFragmentArgs.getPhone() != null : !getPhone().equals(phoneConfirmFragmentArgs.getPhone())) {
            return false;
        }
        if (this.arguments.containsKey("secretLength") == phoneConfirmFragmentArgs.arguments.containsKey("secretLength") && getSecretLength() == phoneConfirmFragmentArgs.getSecretLength() && this.arguments.containsKey("nextResendFrom") == phoneConfirmFragmentArgs.arguments.containsKey("nextResendFrom")) {
            return getNextResendFrom() == null ? phoneConfirmFragmentArgs.getNextResendFrom() == null : getNextResendFrom().equals(phoneConfirmFragmentArgs.getNextResendFrom());
        }
        return false;
    }

    public OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.arguments.get("expireAt");
    }

    public OffsetDateTime getNextResendFrom() {
        return (OffsetDateTime) this.arguments.get("nextResendFrom");
    }

    public String getPhone() {
        return (String) this.arguments.get("phone");
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public ProcessType getProcessType() {
        return (ProcessType) this.arguments.get("processType");
    }

    public int getSecretLength() {
        return ((Integer) this.arguments.get("secretLength")).intValue();
    }

    public int hashCode() {
        return ((getSecretLength() + (((((((((getProcessType() != null ? getProcessType().hashCode() : 0) + 31) * 31) + (getProcessId() != null ? getProcessId().hashCode() : 0)) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0)) * 31) + (getPhone() != null ? getPhone().hashCode() : 0)) * 31)) * 31) + (getNextResendFrom() != null ? getNextResendFrom().hashCode() : 0);
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
        }
        if (this.arguments.containsKey("phone")) {
            bundle.putString("phone", (String) this.arguments.get("phone"));
        }
        bundle.putInt("secretLength", this.arguments.containsKey("secretLength") ? ((Integer) this.arguments.get("secretLength")).intValue() : 6);
        if (this.arguments.containsKey("nextResendFrom")) {
            OffsetDateTime offsetDateTime2 = (OffsetDateTime) this.arguments.get("nextResendFrom");
            if (Parcelable.class.isAssignableFrom(OffsetDateTime.class) || offsetDateTime2 == null) {
                bundle.putParcelable("nextResendFrom", (Parcelable) Parcelable.class.cast(offsetDateTime2));
            } else {
                if (!Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                    throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("nextResendFrom", (Serializable) Serializable.class.cast(offsetDateTime2));
            }
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Integer num;
        Object obj;
        Object obj2;
        Object obj3;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
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
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("expireAt")) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) this.arguments.get("expireAt");
            if (Parcelable.class.isAssignableFrom(OffsetDateTime.class) || offsetDateTime == null) {
                obj2 = (Parcelable) Parcelable.class.cast(offsetDateTime);
            } else {
                if (!Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                    throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj2 = (Serializable) Serializable.class.cast(offsetDateTime);
            }
            savedStateHandle.set("expireAt", obj2);
        }
        if (this.arguments.containsKey("phone")) {
            savedStateHandle.set("phone", (String) this.arguments.get("phone"));
        }
        if (this.arguments.containsKey("secretLength")) {
            num = (Integer) this.arguments.get("secretLength");
            num.intValue();
        } else {
            num = 6;
        }
        savedStateHandle.set("secretLength", num);
        if (this.arguments.containsKey("nextResendFrom")) {
            OffsetDateTime offsetDateTime2 = (OffsetDateTime) this.arguments.get("nextResendFrom");
            if (Parcelable.class.isAssignableFrom(OffsetDateTime.class) || offsetDateTime2 == null) {
                obj = (Parcelable) Parcelable.class.cast(offsetDateTime2);
            } else {
                if (!Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                    throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(offsetDateTime2);
            }
            savedStateHandle.set("nextResendFrom", obj);
        }
        return savedStateHandle;
    }

    public String toString() {
        return "PhoneConfirmFragmentArgs{processType=" + getProcessType() + ", processId=" + getProcessId() + ", expireAt=" + getExpireAt() + ", phone=" + getPhone() + ", secretLength=" + getSecretLength() + ", nextResendFrom=" + getNextResendFrom() + "}";
    }

    private PhoneConfirmFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
