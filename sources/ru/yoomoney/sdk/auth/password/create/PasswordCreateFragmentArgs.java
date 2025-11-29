package ru.yoomoney.sdk.auth.password.create;

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
public class PasswordCreateFragmentArgs {
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

        public PasswordCreateFragmentArgs build() {
            return new PasswordCreateFragmentArgs(this.arguments);
        }

        public OffsetDateTime getExpireAt() {
            return (OffsetDateTime) this.arguments.get("expireAt");
        }

        public boolean getIsEmailSet() {
            return ((Boolean) this.arguments.get("isEmailSet")).booleanValue();
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

        public Builder setIsEmailSet(boolean z) {
            this.arguments.put("isEmailSet", Boolean.valueOf(z));
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

        public Builder(PasswordCreateFragmentArgs passwordCreateFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(passwordCreateFragmentArgs.arguments);
        }
    }

    private PasswordCreateFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static PasswordCreateFragmentArgs fromBundle(Bundle bundle) {
        PasswordCreateFragmentArgs passwordCreateFragmentArgs = new PasswordCreateFragmentArgs();
        if (!a.a(PasswordCreateFragmentArgs.class, bundle, "processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessType.class) && !Serializable.class.isAssignableFrom(ProcessType.class)) {
            throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessType processType = (ProcessType) bundle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        passwordCreateFragmentArgs.arguments.put("processType", processType);
        if (!bundle.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        passwordCreateFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("expireAt")) {
            passwordCreateFragmentArgs.arguments.put("expireAt", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(OffsetDateTime.class) && !Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            passwordCreateFragmentArgs.arguments.put("expireAt", (OffsetDateTime) bundle.get("expireAt"));
        }
        if (bundle.containsKey("isEmailSet")) {
            passwordCreateFragmentArgs.arguments.put("isEmailSet", Boolean.valueOf(bundle.getBoolean("isEmailSet")));
        } else {
            passwordCreateFragmentArgs.arguments.put("isEmailSet", Boolean.FALSE);
        }
        return passwordCreateFragmentArgs;
    }

    public static PasswordCreateFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        PasswordCreateFragmentArgs passwordCreateFragmentArgs = new PasswordCreateFragmentArgs();
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        passwordCreateFragmentArgs.arguments.put("processType", processType);
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        passwordCreateFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (savedStateHandle.contains("expireAt")) {
            passwordCreateFragmentArgs.arguments.put("expireAt", (OffsetDateTime) savedStateHandle.get("expireAt"));
        } else {
            passwordCreateFragmentArgs.arguments.put("expireAt", null);
        }
        if (savedStateHandle.contains("isEmailSet")) {
            Boolean bool = (Boolean) savedStateHandle.get("isEmailSet");
            bool.booleanValue();
            passwordCreateFragmentArgs.arguments.put("isEmailSet", bool);
        } else {
            passwordCreateFragmentArgs.arguments.put("isEmailSet", Boolean.FALSE);
        }
        return passwordCreateFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PasswordCreateFragmentArgs passwordCreateFragmentArgs = (PasswordCreateFragmentArgs) obj;
        if (this.arguments.containsKey("processType") != passwordCreateFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? passwordCreateFragmentArgs.getProcessType() != null : !getProcessType().equals(passwordCreateFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != passwordCreateFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? passwordCreateFragmentArgs.getProcessId() != null : !getProcessId().equals(passwordCreateFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != passwordCreateFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        if (getExpireAt() == null ? passwordCreateFragmentArgs.getExpireAt() == null : getExpireAt().equals(passwordCreateFragmentArgs.getExpireAt())) {
            return this.arguments.containsKey("isEmailSet") == passwordCreateFragmentArgs.arguments.containsKey("isEmailSet") && getIsEmailSet() == passwordCreateFragmentArgs.getIsEmailSet();
        }
        return false;
    }

    public OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.arguments.get("expireAt");
    }

    public boolean getIsEmailSet() {
        return ((Boolean) this.arguments.get("isEmailSet")).booleanValue();
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public ProcessType getProcessType() {
        return (ProcessType) this.arguments.get("processType");
    }

    public int hashCode() {
        return (getIsEmailSet() ? 1 : 0) + (((((((getProcessType() != null ? getProcessType().hashCode() : 0) + 31) * 31) + (getProcessId() != null ? getProcessId().hashCode() : 0)) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0)) * 31);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Bundle toBundle() {
        /*
            r8 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.util.HashMap r1 = r8.arguments
            java.lang.String r2 = "processType"
            boolean r1 = r1.containsKey(r2)
            java.lang.String r3 = " must implement Parcelable or Serializable or must be an Enum."
            java.lang.Class<java.io.Serializable> r4 = java.io.Serializable.class
            java.lang.Class<android.os.Parcelable> r5 = android.os.Parcelable.class
            if (r1 == 0) goto L4f
            java.util.HashMap r1 = r8.arguments
            java.lang.Object r1 = r1.get(r2)
            ru.yoomoney.sdk.auth.api.ProcessType r1 = (ru.yoomoney.sdk.auth.api.ProcessType) r1
            java.lang.Class<ru.yoomoney.sdk.auth.api.ProcessType> r6 = ru.yoomoney.sdk.auth.api.ProcessType.class
            boolean r7 = r5.isAssignableFrom(r6)
            if (r7 != 0) goto L46
            if (r1 != 0) goto L28
            goto L46
        L28:
            boolean r7 = r4.isAssignableFrom(r6)
            if (r7 == 0) goto L38
            java.lang.Object r1 = r4.cast(r1)
            java.io.Serializable r1 = (java.io.Serializable) r1
            r0.putSerializable(r2, r1)
            goto L4f
        L38:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = r6.getName()
            java.lang.String r1 = r1.concat(r3)
            r0.<init>(r1)
            throw r0
        L46:
            java.lang.Object r1 = r5.cast(r1)
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            r0.putParcelable(r2, r1)
        L4f:
            java.util.HashMap r1 = r8.arguments
            java.lang.String r2 = "processId"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L64
            java.util.HashMap r1 = r8.arguments
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r0.putString(r2, r1)
        L64:
            java.util.HashMap r1 = r8.arguments
            java.lang.String r2 = "expireAt"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto La9
            java.util.HashMap r1 = r8.arguments
            java.lang.Object r1 = r1.get(r2)
            org.threeten.bp.OffsetDateTime r1 = (org.threeten.bp.OffsetDateTime) r1
            java.lang.Class<org.threeten.bp.OffsetDateTime> r6 = org.threeten.bp.OffsetDateTime.class
            boolean r7 = r5.isAssignableFrom(r6)
            if (r7 != 0) goto L9f
            if (r1 != 0) goto L81
            goto L9f
        L81:
            boolean r5 = r4.isAssignableFrom(r6)
            if (r5 == 0) goto L91
            java.lang.Object r1 = r4.cast(r1)
            java.io.Serializable r1 = (java.io.Serializable) r1
        L8d:
            r0.putSerializable(r2, r1)
            goto Lab
        L91:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = r6.getName()
            java.lang.String r1 = r1.concat(r3)
            r0.<init>(r1)
            throw r0
        L9f:
            java.lang.Object r1 = r5.cast(r1)
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            r0.putParcelable(r2, r1)
            goto Lab
        La9:
            r1 = 0
            goto L8d
        Lab:
            java.util.HashMap r1 = r8.arguments
            java.lang.String r2 = "isEmailSet"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto Lc5
            java.util.HashMap r1 = r8.arguments
            java.lang.Object r1 = r1.get(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
        Lc1:
            r0.putBoolean(r2, r1)
            goto Lc7
        Lc5:
            r1 = 0
            goto Lc1
        Lc7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragmentArgs.toBundle():android.os.Bundle");
    }

    public SavedStateHandle toSavedStateHandle() {
        Object obj;
        Boolean bool;
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
        } else {
            obj = null;
        }
        savedStateHandle.set("expireAt", obj);
        if (this.arguments.containsKey("isEmailSet")) {
            bool = (Boolean) this.arguments.get("isEmailSet");
            bool.booleanValue();
        } else {
            bool = Boolean.FALSE;
        }
        savedStateHandle.set("isEmailSet", bool);
        return savedStateHandle;
    }

    public String toString() {
        return "PasswordCreateFragmentArgs{processType=" + getProcessType() + ", processId=" + getProcessId() + ", expireAt=" + getExpireAt() + ", isEmailSet=" + getIsEmailSet() + "}";
    }

    private PasswordCreateFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
