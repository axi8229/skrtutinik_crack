package ru.yoomoney.sdk.auth.api.migration.hardMigration;

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
public class HardMigrationFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(ProcessType processType, String str, String str2) {
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
            if (str2 == null) {
                throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
            }
            map.put("uid", str2);
        }

        public HardMigrationFragmentArgs build() {
            return new HardMigrationFragmentArgs(this.arguments);
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

        public String getUid() {
            return (String) this.arguments.get("uid");
        }

        public Builder setExpireAt(OffsetDateTime offsetDateTime) {
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

        public Builder setUid(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("uid", str);
            return this;
        }

        public Builder(HardMigrationFragmentArgs hardMigrationFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(hardMigrationFragmentArgs.arguments);
        }
    }

    private HardMigrationFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static HardMigrationFragmentArgs fromBundle(Bundle bundle) {
        HardMigrationFragmentArgs hardMigrationFragmentArgs = new HardMigrationFragmentArgs();
        if (!a.a(HardMigrationFragmentArgs.class, bundle, "processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessType.class) && !Serializable.class.isAssignableFrom(ProcessType.class)) {
            throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessType processType = (ProcessType) bundle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        hardMigrationFragmentArgs.arguments.put("processType", processType);
        if (!bundle.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        hardMigrationFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("expireAt")) {
            hardMigrationFragmentArgs.arguments.put("expireAt", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(OffsetDateTime.class) && !Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            hardMigrationFragmentArgs.arguments.put("expireAt", (OffsetDateTime) bundle.get("expireAt"));
        }
        if (!bundle.containsKey("uid")) {
            throw new IllegalArgumentException("Required argument \"uid\" is missing and does not have an android:defaultValue");
        }
        String string2 = bundle.getString("uid");
        if (string2 == null) {
            throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
        }
        hardMigrationFragmentArgs.arguments.put("uid", string2);
        return hardMigrationFragmentArgs;
    }

    public static HardMigrationFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        HardMigrationFragmentArgs hardMigrationFragmentArgs = new HardMigrationFragmentArgs();
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        hardMigrationFragmentArgs.arguments.put("processType", processType);
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        hardMigrationFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (savedStateHandle.contains("expireAt")) {
            hardMigrationFragmentArgs.arguments.put("expireAt", (OffsetDateTime) savedStateHandle.get("expireAt"));
        } else {
            hardMigrationFragmentArgs.arguments.put("expireAt", null);
        }
        if (!savedStateHandle.contains("uid")) {
            throw new IllegalArgumentException("Required argument \"uid\" is missing and does not have an android:defaultValue");
        }
        String str2 = (String) savedStateHandle.get("uid");
        if (str2 == null) {
            throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
        }
        hardMigrationFragmentArgs.arguments.put("uid", str2);
        return hardMigrationFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HardMigrationFragmentArgs hardMigrationFragmentArgs = (HardMigrationFragmentArgs) obj;
        if (this.arguments.containsKey("processType") != hardMigrationFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? hardMigrationFragmentArgs.getProcessType() != null : !getProcessType().equals(hardMigrationFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != hardMigrationFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? hardMigrationFragmentArgs.getProcessId() != null : !getProcessId().equals(hardMigrationFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != hardMigrationFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        if (getExpireAt() == null ? hardMigrationFragmentArgs.getExpireAt() != null : !getExpireAt().equals(hardMigrationFragmentArgs.getExpireAt())) {
            return false;
        }
        if (this.arguments.containsKey("uid") != hardMigrationFragmentArgs.arguments.containsKey("uid")) {
            return false;
        }
        return getUid() == null ? hardMigrationFragmentArgs.getUid() == null : getUid().equals(hardMigrationFragmentArgs.getUid());
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

    public String getUid() {
        return (String) this.arguments.get("uid");
    }

    public int hashCode() {
        return (((((((getProcessType() != null ? getProcessType().hashCode() : 0) + 31) * 31) + (getProcessId() != null ? getProcessId().hashCode() : 0)) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0)) * 31) + (getUid() != null ? getUid().hashCode() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
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
            java.lang.String r2 = "uid"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto Lc1
            java.util.HashMap r1 = r8.arguments
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r0.putString(r2, r1)
        Lc1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigrationFragmentArgs.toBundle():android.os.Bundle");
    }

    public SavedStateHandle toSavedStateHandle() {
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
        } else {
            obj = null;
        }
        savedStateHandle.set("expireAt", obj);
        if (this.arguments.containsKey("uid")) {
            savedStateHandle.set("uid", (String) this.arguments.get("uid"));
        }
        return savedStateHandle;
    }

    public String toString() {
        return "HardMigrationFragmentArgs{processType=" + getProcessType() + ", processId=" + getProcessId() + ", expireAt=" + getExpireAt() + ", uid=" + getUid() + "}";
    }

    private HardMigrationFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
