package ru.yoomoney.sdk.auth.email.confirm;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import com.google.android.gms.common.Scopes;
import java.io.Serializable;
import java.util.HashMap;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class EmailConfirmFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, OffsetDateTime offsetDateTime, String str2, OffsetDateTime offsetDateTime2, ProcessType processType) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
            }
            map.put("expireAt", offsetDateTime);
            if (str2 == null) {
                throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
            }
            map.put(Scopes.EMAIL, str2);
            if (offsetDateTime2 == null) {
                throw new IllegalArgumentException("Argument \"nextResendFrom\" is marked as non-null but was passed a null value.");
            }
            map.put("nextResendFrom", offsetDateTime2);
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            map.put("processType", processType);
        }

        public EmailConfirmFragmentArgs build() {
            return new EmailConfirmFragmentArgs(this.arguments);
        }

        public ApplicationInfo getApplicationInfo() {
            return (ApplicationInfo) this.arguments.get("applicationInfo");
        }

        public String getEmail() {
            return (String) this.arguments.get(Scopes.EMAIL);
        }

        public OffsetDateTime getExpireAt() {
            return (OffsetDateTime) this.arguments.get("expireAt");
        }

        public boolean getIsCurrentUserAccountEmail() {
            return ((Boolean) this.arguments.get("isCurrentUserAccountEmail")).booleanValue();
        }

        public OffsetDateTime getNextResendFrom() {
            return (OffsetDateTime) this.arguments.get("nextResendFrom");
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

        public Builder setApplicationInfo(ApplicationInfo applicationInfo) {
            this.arguments.put("applicationInfo", applicationInfo);
            return this;
        }

        public Builder setEmail(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(Scopes.EMAIL, str);
            return this;
        }

        public Builder setExpireAt(OffsetDateTime offsetDateTime) {
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("expireAt", offsetDateTime);
            return this;
        }

        public Builder setIsCurrentUserAccountEmail(boolean z) {
            this.arguments.put("isCurrentUserAccountEmail", Boolean.valueOf(z));
            return this;
        }

        public Builder setNextResendFrom(OffsetDateTime offsetDateTime) {
            if (offsetDateTime == null) {
                throw new IllegalArgumentException("Argument \"nextResendFrom\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("nextResendFrom", offsetDateTime);
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

        public Builder(EmailConfirmFragmentArgs emailConfirmFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(emailConfirmFragmentArgs.arguments);
        }
    }

    private EmailConfirmFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static EmailConfirmFragmentArgs fromBundle(Bundle bundle) {
        EmailConfirmFragmentArgs emailConfirmFragmentArgs = new EmailConfirmFragmentArgs();
        if (!a.a(EmailConfirmFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        emailConfirmFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
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
        emailConfirmFragmentArgs.arguments.put("expireAt", offsetDateTime);
        if (!bundle.containsKey(Scopes.EMAIL)) {
            throw new IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue");
        }
        String string2 = bundle.getString(Scopes.EMAIL);
        if (string2 == null) {
            throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
        }
        emailConfirmFragmentArgs.arguments.put(Scopes.EMAIL, string2);
        if (bundle.containsKey("secretLength")) {
            emailConfirmFragmentArgs.arguments.put("secretLength", Integer.valueOf(bundle.getInt("secretLength")));
        } else {
            emailConfirmFragmentArgs.arguments.put("secretLength", 6);
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
        emailConfirmFragmentArgs.arguments.put("nextResendFrom", offsetDateTime2);
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
        emailConfirmFragmentArgs.arguments.put("processType", processType);
        if (bundle.containsKey("isCurrentUserAccountEmail")) {
            emailConfirmFragmentArgs.arguments.put("isCurrentUserAccountEmail", Boolean.valueOf(bundle.getBoolean("isCurrentUserAccountEmail")));
        } else {
            emailConfirmFragmentArgs.arguments.put("isCurrentUserAccountEmail", Boolean.FALSE);
        }
        if (!bundle.containsKey("applicationInfo")) {
            emailConfirmFragmentArgs.arguments.put("applicationInfo", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(ApplicationInfo.class) && !Serializable.class.isAssignableFrom(ApplicationInfo.class)) {
                throw new UnsupportedOperationException(ApplicationInfo.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            emailConfirmFragmentArgs.arguments.put("applicationInfo", (ApplicationInfo) bundle.get("applicationInfo"));
        }
        return emailConfirmFragmentArgs;
    }

    public static EmailConfirmFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        EmailConfirmFragmentArgs emailConfirmFragmentArgs = new EmailConfirmFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        emailConfirmFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (!savedStateHandle.contains("expireAt")) {
            throw new IllegalArgumentException("Required argument \"expireAt\" is missing and does not have an android:defaultValue");
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) savedStateHandle.get("expireAt");
        if (offsetDateTime == null) {
            throw new IllegalArgumentException("Argument \"expireAt\" is marked as non-null but was passed a null value.");
        }
        emailConfirmFragmentArgs.arguments.put("expireAt", offsetDateTime);
        if (!savedStateHandle.contains(Scopes.EMAIL)) {
            throw new IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue");
        }
        String str2 = (String) savedStateHandle.get(Scopes.EMAIL);
        if (str2 == null) {
            throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
        }
        emailConfirmFragmentArgs.arguments.put(Scopes.EMAIL, str2);
        if (savedStateHandle.contains("secretLength")) {
            Integer num = (Integer) savedStateHandle.get("secretLength");
            num.intValue();
            emailConfirmFragmentArgs.arguments.put("secretLength", num);
        } else {
            emailConfirmFragmentArgs.arguments.put("secretLength", 6);
        }
        if (!savedStateHandle.contains("nextResendFrom")) {
            throw new IllegalArgumentException("Required argument \"nextResendFrom\" is missing and does not have an android:defaultValue");
        }
        OffsetDateTime offsetDateTime2 = (OffsetDateTime) savedStateHandle.get("nextResendFrom");
        if (offsetDateTime2 == null) {
            throw new IllegalArgumentException("Argument \"nextResendFrom\" is marked as non-null but was passed a null value.");
        }
        emailConfirmFragmentArgs.arguments.put("nextResendFrom", offsetDateTime2);
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        emailConfirmFragmentArgs.arguments.put("processType", processType);
        if (savedStateHandle.contains("isCurrentUserAccountEmail")) {
            Boolean bool = (Boolean) savedStateHandle.get("isCurrentUserAccountEmail");
            bool.booleanValue();
            emailConfirmFragmentArgs.arguments.put("isCurrentUserAccountEmail", bool);
        } else {
            emailConfirmFragmentArgs.arguments.put("isCurrentUserAccountEmail", Boolean.FALSE);
        }
        if (savedStateHandle.contains("applicationInfo")) {
            emailConfirmFragmentArgs.arguments.put("applicationInfo", (ApplicationInfo) savedStateHandle.get("applicationInfo"));
        } else {
            emailConfirmFragmentArgs.arguments.put("applicationInfo", null);
        }
        return emailConfirmFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmailConfirmFragmentArgs emailConfirmFragmentArgs = (EmailConfirmFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != emailConfirmFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? emailConfirmFragmentArgs.getProcessId() != null : !getProcessId().equals(emailConfirmFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != emailConfirmFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        if (getExpireAt() == null ? emailConfirmFragmentArgs.getExpireAt() != null : !getExpireAt().equals(emailConfirmFragmentArgs.getExpireAt())) {
            return false;
        }
        if (this.arguments.containsKey(Scopes.EMAIL) != emailConfirmFragmentArgs.arguments.containsKey(Scopes.EMAIL)) {
            return false;
        }
        if (getEmail() == null ? emailConfirmFragmentArgs.getEmail() != null : !getEmail().equals(emailConfirmFragmentArgs.getEmail())) {
            return false;
        }
        if (this.arguments.containsKey("secretLength") != emailConfirmFragmentArgs.arguments.containsKey("secretLength") || getSecretLength() != emailConfirmFragmentArgs.getSecretLength() || this.arguments.containsKey("nextResendFrom") != emailConfirmFragmentArgs.arguments.containsKey("nextResendFrom")) {
            return false;
        }
        if (getNextResendFrom() == null ? emailConfirmFragmentArgs.getNextResendFrom() != null : !getNextResendFrom().equals(emailConfirmFragmentArgs.getNextResendFrom())) {
            return false;
        }
        if (this.arguments.containsKey("processType") != emailConfirmFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? emailConfirmFragmentArgs.getProcessType() != null : !getProcessType().equals(emailConfirmFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey("isCurrentUserAccountEmail") == emailConfirmFragmentArgs.arguments.containsKey("isCurrentUserAccountEmail") && getIsCurrentUserAccountEmail() == emailConfirmFragmentArgs.getIsCurrentUserAccountEmail() && this.arguments.containsKey("applicationInfo") == emailConfirmFragmentArgs.arguments.containsKey("applicationInfo")) {
            return getApplicationInfo() == null ? emailConfirmFragmentArgs.getApplicationInfo() == null : getApplicationInfo().equals(emailConfirmFragmentArgs.getApplicationInfo());
        }
        return false;
    }

    public ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo) this.arguments.get("applicationInfo");
    }

    public String getEmail() {
        return (String) this.arguments.get(Scopes.EMAIL);
    }

    public OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.arguments.get("expireAt");
    }

    public boolean getIsCurrentUserAccountEmail() {
        return ((Boolean) this.arguments.get("isCurrentUserAccountEmail")).booleanValue();
    }

    public OffsetDateTime getNextResendFrom() {
        return (OffsetDateTime) this.arguments.get("nextResendFrom");
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
        return (((getIsCurrentUserAccountEmail() ? 1 : 0) + ((((((getSecretLength() + (((((((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0)) * 31) + (getEmail() != null ? getEmail().hashCode() : 0)) * 31)) * 31) + (getNextResendFrom() != null ? getNextResendFrom().hashCode() : 0)) * 31) + (getProcessType() != null ? getProcessType().hashCode() : 0)) * 31)) * 31) + (getApplicationInfo() != null ? getApplicationInfo().hashCode() : 0);
    }

    public Bundle toBundle() {
        Serializable serializable;
        Bundle bundle = new Bundle();
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
        if (this.arguments.containsKey(Scopes.EMAIL)) {
            bundle.putString(Scopes.EMAIL, (String) this.arguments.get(Scopes.EMAIL));
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
        bundle.putBoolean("isCurrentUserAccountEmail", this.arguments.containsKey("isCurrentUserAccountEmail") ? ((Boolean) this.arguments.get("isCurrentUserAccountEmail")).booleanValue() : false);
        if (this.arguments.containsKey("applicationInfo")) {
            ApplicationInfo applicationInfo = (ApplicationInfo) this.arguments.get("applicationInfo");
            if (Parcelable.class.isAssignableFrom(ApplicationInfo.class) || applicationInfo == null) {
                bundle.putParcelable("applicationInfo", (Parcelable) Parcelable.class.cast(applicationInfo));
                return bundle;
            }
            if (!Serializable.class.isAssignableFrom(ApplicationInfo.class)) {
                throw new UnsupportedOperationException(ApplicationInfo.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            serializable = (Serializable) Serializable.class.cast(applicationInfo);
        } else {
            serializable = null;
        }
        bundle.putSerializable("applicationInfo", serializable);
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Integer num;
        Boolean bool;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("expireAt")) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) this.arguments.get("expireAt");
            if (Parcelable.class.isAssignableFrom(OffsetDateTime.class) || offsetDateTime == null) {
                obj4 = (Parcelable) Parcelable.class.cast(offsetDateTime);
            } else {
                if (!Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                    throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj4 = (Serializable) Serializable.class.cast(offsetDateTime);
            }
            savedStateHandle.set("expireAt", obj4);
        }
        if (this.arguments.containsKey(Scopes.EMAIL)) {
            savedStateHandle.set(Scopes.EMAIL, (String) this.arguments.get(Scopes.EMAIL));
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
                obj3 = (Parcelable) Parcelable.class.cast(offsetDateTime2);
            } else {
                if (!Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                    throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj3 = (Serializable) Serializable.class.cast(offsetDateTime2);
            }
            savedStateHandle.set("nextResendFrom", obj3);
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
        if (this.arguments.containsKey("isCurrentUserAccountEmail")) {
            bool = (Boolean) this.arguments.get("isCurrentUserAccountEmail");
            bool.booleanValue();
        } else {
            bool = Boolean.FALSE;
        }
        savedStateHandle.set("isCurrentUserAccountEmail", bool);
        if (this.arguments.containsKey("applicationInfo")) {
            ApplicationInfo applicationInfo = (ApplicationInfo) this.arguments.get("applicationInfo");
            if (Parcelable.class.isAssignableFrom(ApplicationInfo.class) || applicationInfo == null) {
                obj = (Parcelable) Parcelable.class.cast(applicationInfo);
            } else {
                if (!Serializable.class.isAssignableFrom(ApplicationInfo.class)) {
                    throw new UnsupportedOperationException(ApplicationInfo.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(applicationInfo);
            }
        } else {
            obj = null;
        }
        savedStateHandle.set("applicationInfo", obj);
        return savedStateHandle;
    }

    public String toString() {
        return "EmailConfirmFragmentArgs{processId=" + getProcessId() + ", expireAt=" + getExpireAt() + ", email=" + getEmail() + ", secretLength=" + getSecretLength() + ", nextResendFrom=" + getNextResendFrom() + ", processType=" + getProcessType() + ", isCurrentUserAccountEmail=" + getIsCurrentUserAccountEmail() + ", applicationInfo=" + getApplicationInfo() + "}";
    }

    private EmailConfirmFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
