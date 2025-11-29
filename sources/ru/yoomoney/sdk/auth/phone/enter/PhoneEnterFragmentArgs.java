package ru.yoomoney.sdk.auth.phone.enter;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class PhoneEnterFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, CountryCallingCode[] countryCallingCodeArr, ProcessType processType) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            if (countryCallingCodeArr == null) {
                throw new IllegalArgumentException("Argument \"countryCodes\" is marked as non-null but was passed a null value.");
            }
            map.put("countryCodes", countryCallingCodeArr);
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            map.put("processType", processType);
        }

        public PhoneEnterFragmentArgs build() {
            return new PhoneEnterFragmentArgs(this.arguments);
        }

        public CountryCallingCode[] getCountryCodes() {
            return (CountryCallingCode[]) this.arguments.get("countryCodes");
        }

        public OffsetDateTime getExpireAt() {
            return (OffsetDateTime) this.arguments.get("expireAt");
        }

        public boolean getIsAddedToBackStack() {
            return ((Boolean) this.arguments.get("isAddedToBackStack")).booleanValue();
        }

        public CountryCallingCode getPrefilledCountryCallingCode() {
            return (CountryCallingCode) this.arguments.get("prefilledCountryCallingCode");
        }

        public String getPrefilledPhone() {
            return (String) this.arguments.get("prefilledPhone");
        }

        public String getProcessId() {
            return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        }

        public ProcessType getProcessType() {
            return (ProcessType) this.arguments.get("processType");
        }

        public Builder setCountryCodes(CountryCallingCode[] countryCallingCodeArr) {
            if (countryCallingCodeArr == null) {
                throw new IllegalArgumentException("Argument \"countryCodes\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("countryCodes", countryCallingCodeArr);
            return this;
        }

        public Builder setExpireAt(OffsetDateTime offsetDateTime) {
            this.arguments.put("expireAt", offsetDateTime);
            return this;
        }

        public Builder setIsAddedToBackStack(boolean z) {
            this.arguments.put("isAddedToBackStack", Boolean.valueOf(z));
            return this;
        }

        public Builder setPrefilledCountryCallingCode(CountryCallingCode countryCallingCode) {
            this.arguments.put("prefilledCountryCallingCode", countryCallingCode);
            return this;
        }

        public Builder setPrefilledPhone(String str) {
            this.arguments.put("prefilledPhone", str);
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

        public Builder(PhoneEnterFragmentArgs phoneEnterFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(phoneEnterFragmentArgs.arguments);
        }
    }

    private PhoneEnterFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static PhoneEnterFragmentArgs fromBundle(Bundle bundle) {
        CountryCallingCode[] countryCallingCodeArr;
        PhoneEnterFragmentArgs phoneEnterFragmentArgs = new PhoneEnterFragmentArgs();
        if (!a.a(PhoneEnterFragmentArgs.class, bundle, QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        phoneEnterFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string);
        if (!bundle.containsKey("expireAt")) {
            phoneEnterFragmentArgs.arguments.put("expireAt", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(OffsetDateTime.class) && !Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            phoneEnterFragmentArgs.arguments.put("expireAt", (OffsetDateTime) bundle.get("expireAt"));
        }
        if (!bundle.containsKey("countryCodes")) {
            throw new IllegalArgumentException("Required argument \"countryCodes\" is missing and does not have an android:defaultValue");
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("countryCodes");
        if (parcelableArray != null) {
            countryCallingCodeArr = new CountryCallingCode[parcelableArray.length];
            System.arraycopy(parcelableArray, 0, countryCallingCodeArr, 0, parcelableArray.length);
        } else {
            countryCallingCodeArr = null;
        }
        if (countryCallingCodeArr == null) {
            throw new IllegalArgumentException("Argument \"countryCodes\" is marked as non-null but was passed a null value.");
        }
        phoneEnterFragmentArgs.arguments.put("countryCodes", countryCallingCodeArr);
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
        phoneEnterFragmentArgs.arguments.put("processType", processType);
        if (bundle.containsKey("prefilledPhone")) {
            phoneEnterFragmentArgs.arguments.put("prefilledPhone", bundle.getString("prefilledPhone"));
        } else {
            phoneEnterFragmentArgs.arguments.put("prefilledPhone", null);
        }
        if (!bundle.containsKey("prefilledCountryCallingCode")) {
            phoneEnterFragmentArgs.arguments.put("prefilledCountryCallingCode", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(CountryCallingCode.class) && !Serializable.class.isAssignableFrom(CountryCallingCode.class)) {
                throw new UnsupportedOperationException(CountryCallingCode.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            phoneEnterFragmentArgs.arguments.put("prefilledCountryCallingCode", (CountryCallingCode) bundle.get("prefilledCountryCallingCode"));
        }
        if (bundle.containsKey("isAddedToBackStack")) {
            phoneEnterFragmentArgs.arguments.put("isAddedToBackStack", Boolean.valueOf(bundle.getBoolean("isAddedToBackStack")));
        } else {
            phoneEnterFragmentArgs.arguments.put("isAddedToBackStack", Boolean.TRUE);
        }
        return phoneEnterFragmentArgs;
    }

    public static PhoneEnterFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        PhoneEnterFragmentArgs phoneEnterFragmentArgs = new PhoneEnterFragmentArgs();
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        phoneEnterFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
        if (savedStateHandle.contains("expireAt")) {
            phoneEnterFragmentArgs.arguments.put("expireAt", (OffsetDateTime) savedStateHandle.get("expireAt"));
        } else {
            phoneEnterFragmentArgs.arguments.put("expireAt", null);
        }
        if (!savedStateHandle.contains("countryCodes")) {
            throw new IllegalArgumentException("Required argument \"countryCodes\" is missing and does not have an android:defaultValue");
        }
        CountryCallingCode[] countryCallingCodeArr = (CountryCallingCode[]) savedStateHandle.get("countryCodes");
        if (countryCallingCodeArr == null) {
            throw new IllegalArgumentException("Argument \"countryCodes\" is marked as non-null but was passed a null value.");
        }
        phoneEnterFragmentArgs.arguments.put("countryCodes", countryCallingCodeArr);
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        phoneEnterFragmentArgs.arguments.put("processType", processType);
        if (savedStateHandle.contains("prefilledPhone")) {
            phoneEnterFragmentArgs.arguments.put("prefilledPhone", (String) savedStateHandle.get("prefilledPhone"));
        } else {
            phoneEnterFragmentArgs.arguments.put("prefilledPhone", null);
        }
        if (savedStateHandle.contains("prefilledCountryCallingCode")) {
            phoneEnterFragmentArgs.arguments.put("prefilledCountryCallingCode", (CountryCallingCode) savedStateHandle.get("prefilledCountryCallingCode"));
        } else {
            phoneEnterFragmentArgs.arguments.put("prefilledCountryCallingCode", null);
        }
        if (savedStateHandle.contains("isAddedToBackStack")) {
            Boolean bool = (Boolean) savedStateHandle.get("isAddedToBackStack");
            bool.booleanValue();
            phoneEnterFragmentArgs.arguments.put("isAddedToBackStack", bool);
        } else {
            phoneEnterFragmentArgs.arguments.put("isAddedToBackStack", Boolean.TRUE);
        }
        return phoneEnterFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhoneEnterFragmentArgs phoneEnterFragmentArgs = (PhoneEnterFragmentArgs) obj;
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != phoneEnterFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? phoneEnterFragmentArgs.getProcessId() != null : !getProcessId().equals(phoneEnterFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("expireAt") != phoneEnterFragmentArgs.arguments.containsKey("expireAt")) {
            return false;
        }
        if (getExpireAt() == null ? phoneEnterFragmentArgs.getExpireAt() != null : !getExpireAt().equals(phoneEnterFragmentArgs.getExpireAt())) {
            return false;
        }
        if (this.arguments.containsKey("countryCodes") != phoneEnterFragmentArgs.arguments.containsKey("countryCodes")) {
            return false;
        }
        if (getCountryCodes() == null ? phoneEnterFragmentArgs.getCountryCodes() != null : !getCountryCodes().equals(phoneEnterFragmentArgs.getCountryCodes())) {
            return false;
        }
        if (this.arguments.containsKey("processType") != phoneEnterFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? phoneEnterFragmentArgs.getProcessType() != null : !getProcessType().equals(phoneEnterFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey("prefilledPhone") != phoneEnterFragmentArgs.arguments.containsKey("prefilledPhone")) {
            return false;
        }
        if (getPrefilledPhone() == null ? phoneEnterFragmentArgs.getPrefilledPhone() != null : !getPrefilledPhone().equals(phoneEnterFragmentArgs.getPrefilledPhone())) {
            return false;
        }
        if (this.arguments.containsKey("prefilledCountryCallingCode") != phoneEnterFragmentArgs.arguments.containsKey("prefilledCountryCallingCode")) {
            return false;
        }
        if (getPrefilledCountryCallingCode() == null ? phoneEnterFragmentArgs.getPrefilledCountryCallingCode() == null : getPrefilledCountryCallingCode().equals(phoneEnterFragmentArgs.getPrefilledCountryCallingCode())) {
            return this.arguments.containsKey("isAddedToBackStack") == phoneEnterFragmentArgs.arguments.containsKey("isAddedToBackStack") && getIsAddedToBackStack() == phoneEnterFragmentArgs.getIsAddedToBackStack();
        }
        return false;
    }

    public CountryCallingCode[] getCountryCodes() {
        return (CountryCallingCode[]) this.arguments.get("countryCodes");
    }

    public OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.arguments.get("expireAt");
    }

    public boolean getIsAddedToBackStack() {
        return ((Boolean) this.arguments.get("isAddedToBackStack")).booleanValue();
    }

    public CountryCallingCode getPrefilledCountryCallingCode() {
        return (CountryCallingCode) this.arguments.get("prefilledCountryCallingCode");
    }

    public String getPrefilledPhone() {
        return (String) this.arguments.get("prefilledPhone");
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public ProcessType getProcessType() {
        return (ProcessType) this.arguments.get("processType");
    }

    public int hashCode() {
        return (getIsAddedToBackStack() ? 1 : 0) + ((((((((Arrays.hashCode(getCountryCodes()) + (((((getProcessId() != null ? getProcessId().hashCode() : 0) + 31) * 31) + (getExpireAt() != null ? getExpireAt().hashCode() : 0)) * 31)) * 31) + (getProcessType() != null ? getProcessType().hashCode() : 0)) * 31) + (getPrefilledPhone() != null ? getPrefilledPhone().hashCode() : 0)) * 31) + (getPrefilledCountryCallingCode() != null ? getPrefilledCountryCallingCode().hashCode() : 0)) * 31);
    }

    public Bundle toBundle() {
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
        } else {
            bundle.putSerializable("expireAt", null);
        }
        if (this.arguments.containsKey("countryCodes")) {
            bundle.putParcelableArray("countryCodes", (CountryCallingCode[]) this.arguments.get("countryCodes"));
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
        if (this.arguments.containsKey("prefilledPhone")) {
            bundle.putString("prefilledPhone", (String) this.arguments.get("prefilledPhone"));
        } else {
            bundle.putString("prefilledPhone", null);
        }
        if (this.arguments.containsKey("prefilledCountryCallingCode")) {
            CountryCallingCode countryCallingCode = (CountryCallingCode) this.arguments.get("prefilledCountryCallingCode");
            if (Parcelable.class.isAssignableFrom(CountryCallingCode.class) || countryCallingCode == null) {
                bundle.putParcelable("prefilledCountryCallingCode", (Parcelable) Parcelable.class.cast(countryCallingCode));
            } else {
                if (!Serializable.class.isAssignableFrom(CountryCallingCode.class)) {
                    throw new UnsupportedOperationException(CountryCallingCode.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("prefilledCountryCallingCode", (Serializable) Serializable.class.cast(countryCallingCode));
            }
        } else {
            bundle.putSerializable("prefilledCountryCallingCode", null);
        }
        bundle.putBoolean("isAddedToBackStack", this.arguments.containsKey("isAddedToBackStack") ? ((Boolean) this.arguments.get("isAddedToBackStack")).booleanValue() : true);
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Boolean bool;
        Object obj;
        Object obj2;
        Object obj3;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("expireAt")) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) this.arguments.get("expireAt");
            if (Parcelable.class.isAssignableFrom(OffsetDateTime.class) || offsetDateTime == null) {
                obj3 = (Parcelable) Parcelable.class.cast(offsetDateTime);
            } else {
                if (!Serializable.class.isAssignableFrom(OffsetDateTime.class)) {
                    throw new UnsupportedOperationException(OffsetDateTime.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj3 = (Serializable) Serializable.class.cast(offsetDateTime);
            }
            savedStateHandle.set("expireAt", obj3);
        } else {
            savedStateHandle.set("expireAt", null);
        }
        if (this.arguments.containsKey("countryCodes")) {
            savedStateHandle.set("countryCodes", (CountryCallingCode[]) this.arguments.get("countryCodes"));
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
        if (this.arguments.containsKey("prefilledPhone")) {
            savedStateHandle.set("prefilledPhone", (String) this.arguments.get("prefilledPhone"));
        } else {
            savedStateHandle.set("prefilledPhone", null);
        }
        if (this.arguments.containsKey("prefilledCountryCallingCode")) {
            CountryCallingCode countryCallingCode = (CountryCallingCode) this.arguments.get("prefilledCountryCallingCode");
            if (Parcelable.class.isAssignableFrom(CountryCallingCode.class) || countryCallingCode == null) {
                obj = (Parcelable) Parcelable.class.cast(countryCallingCode);
            } else {
                if (!Serializable.class.isAssignableFrom(CountryCallingCode.class)) {
                    throw new UnsupportedOperationException(CountryCallingCode.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(countryCallingCode);
            }
            savedStateHandle.set("prefilledCountryCallingCode", obj);
        } else {
            savedStateHandle.set("prefilledCountryCallingCode", null);
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
        return "PhoneEnterFragmentArgs{processId=" + getProcessId() + ", expireAt=" + getExpireAt() + ", countryCodes=" + getCountryCodes() + ", processType=" + getProcessType() + ", prefilledPhone=" + getPrefilledPhone() + ", prefilledCountryCallingCode=" + getPrefilledCountryCallingCode() + ", isAddedToBackStack=" + getIsAddedToBackStack() + "}";
    }

    private PhoneEnterFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
