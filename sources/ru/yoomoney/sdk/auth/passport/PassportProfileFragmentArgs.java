package ru.yoomoney.sdk.auth.passport;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.model.ProcessError;

/* loaded from: classes4.dex */
public class PassportProfileFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder() {
            this.arguments = new HashMap();
        }

        public PassportProfileFragmentArgs build() {
            return new PassportProfileFragmentArgs(this.arguments);
        }

        public UserAccount getAccount() {
            return (UserAccount) this.arguments.get("account");
        }

        public ProcessError getProcessError() {
            return (ProcessError) this.arguments.get("processError");
        }

        public int getProcessTypeCode() {
            return ((Integer) this.arguments.get("processTypeCode")).intValue();
        }

        public String getSuccessMessage() {
            return (String) this.arguments.get("successMessage");
        }

        public Builder setAccount(UserAccount userAccount) {
            this.arguments.put("account", userAccount);
            return this;
        }

        public Builder setProcessError(ProcessError processError) {
            this.arguments.put("processError", processError);
            return this;
        }

        public Builder setProcessTypeCode(int i) {
            this.arguments.put("processTypeCode", Integer.valueOf(i));
            return this;
        }

        public Builder setSuccessMessage(String str) {
            this.arguments.put("successMessage", str);
            return this;
        }

        public Builder(PassportProfileFragmentArgs passportProfileFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(passportProfileFragmentArgs.arguments);
        }
    }

    private PassportProfileFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static PassportProfileFragmentArgs fromBundle(Bundle bundle) {
        PassportProfileFragmentArgs passportProfileFragmentArgs = new PassportProfileFragmentArgs();
        if (!a.a(PassportProfileFragmentArgs.class, bundle, "account")) {
            passportProfileFragmentArgs.arguments.put("account", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(UserAccount.class) && !Serializable.class.isAssignableFrom(UserAccount.class)) {
                throw new UnsupportedOperationException(UserAccount.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            passportProfileFragmentArgs.arguments.put("account", (UserAccount) bundle.get("account"));
        }
        if (!bundle.containsKey("processError")) {
            passportProfileFragmentArgs.arguments.put("processError", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(ProcessError.class) && !Serializable.class.isAssignableFrom(ProcessError.class)) {
                throw new UnsupportedOperationException(ProcessError.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            passportProfileFragmentArgs.arguments.put("processError", (ProcessError) bundle.get("processError"));
        }
        if (bundle.containsKey("processTypeCode")) {
            passportProfileFragmentArgs.arguments.put("processTypeCode", Integer.valueOf(bundle.getInt("processTypeCode")));
        } else {
            passportProfileFragmentArgs.arguments.put("processTypeCode", -1);
        }
        if (bundle.containsKey("successMessage")) {
            passportProfileFragmentArgs.arguments.put("successMessage", bundle.getString("successMessage"));
        } else {
            passportProfileFragmentArgs.arguments.put("successMessage", null);
        }
        return passportProfileFragmentArgs;
    }

    public static PassportProfileFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        PassportProfileFragmentArgs passportProfileFragmentArgs = new PassportProfileFragmentArgs();
        if (savedStateHandle.contains("account")) {
            passportProfileFragmentArgs.arguments.put("account", (UserAccount) savedStateHandle.get("account"));
        } else {
            passportProfileFragmentArgs.arguments.put("account", null);
        }
        if (savedStateHandle.contains("processError")) {
            passportProfileFragmentArgs.arguments.put("processError", (ProcessError) savedStateHandle.get("processError"));
        } else {
            passportProfileFragmentArgs.arguments.put("processError", null);
        }
        if (savedStateHandle.contains("processTypeCode")) {
            Integer num = (Integer) savedStateHandle.get("processTypeCode");
            num.intValue();
            passportProfileFragmentArgs.arguments.put("processTypeCode", num);
        } else {
            passportProfileFragmentArgs.arguments.put("processTypeCode", -1);
        }
        if (savedStateHandle.contains("successMessage")) {
            passportProfileFragmentArgs.arguments.put("successMessage", (String) savedStateHandle.get("successMessage"));
        } else {
            passportProfileFragmentArgs.arguments.put("successMessage", null);
        }
        return passportProfileFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PassportProfileFragmentArgs passportProfileFragmentArgs = (PassportProfileFragmentArgs) obj;
        if (this.arguments.containsKey("account") != passportProfileFragmentArgs.arguments.containsKey("account")) {
            return false;
        }
        if (getAccount() == null ? passportProfileFragmentArgs.getAccount() != null : !getAccount().equals(passportProfileFragmentArgs.getAccount())) {
            return false;
        }
        if (this.arguments.containsKey("processError") != passportProfileFragmentArgs.arguments.containsKey("processError")) {
            return false;
        }
        if (getProcessError() == null ? passportProfileFragmentArgs.getProcessError() != null : !getProcessError().equals(passportProfileFragmentArgs.getProcessError())) {
            return false;
        }
        if (this.arguments.containsKey("processTypeCode") == passportProfileFragmentArgs.arguments.containsKey("processTypeCode") && getProcessTypeCode() == passportProfileFragmentArgs.getProcessTypeCode() && this.arguments.containsKey("successMessage") == passportProfileFragmentArgs.arguments.containsKey("successMessage")) {
            return getSuccessMessage() == null ? passportProfileFragmentArgs.getSuccessMessage() == null : getSuccessMessage().equals(passportProfileFragmentArgs.getSuccessMessage());
        }
        return false;
    }

    public UserAccount getAccount() {
        return (UserAccount) this.arguments.get("account");
    }

    public ProcessError getProcessError() {
        return (ProcessError) this.arguments.get("processError");
    }

    public int getProcessTypeCode() {
        return ((Integer) this.arguments.get("processTypeCode")).intValue();
    }

    public String getSuccessMessage() {
        return (String) this.arguments.get("successMessage");
    }

    public int hashCode() {
        return ((getProcessTypeCode() + (((((getAccount() != null ? getAccount().hashCode() : 0) + 31) * 31) + (getProcessError() != null ? getProcessError().hashCode() : 0)) * 31)) * 31) + (getSuccessMessage() != null ? getSuccessMessage().hashCode() : 0);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("account")) {
            UserAccount userAccount = (UserAccount) this.arguments.get("account");
            if (Parcelable.class.isAssignableFrom(UserAccount.class) || userAccount == null) {
                bundle.putParcelable("account", (Parcelable) Parcelable.class.cast(userAccount));
            } else {
                if (!Serializable.class.isAssignableFrom(UserAccount.class)) {
                    throw new UnsupportedOperationException(UserAccount.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("account", (Serializable) Serializable.class.cast(userAccount));
            }
        } else {
            bundle.putSerializable("account", null);
        }
        if (this.arguments.containsKey("processError")) {
            ProcessError processError = (ProcessError) this.arguments.get("processError");
            if (Parcelable.class.isAssignableFrom(ProcessError.class) || processError == null) {
                bundle.putParcelable("processError", (Parcelable) Parcelable.class.cast(processError));
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessError.class)) {
                    throw new UnsupportedOperationException(ProcessError.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("processError", (Serializable) Serializable.class.cast(processError));
            }
        } else {
            bundle.putSerializable("processError", null);
        }
        bundle.putInt("processTypeCode", this.arguments.containsKey("processTypeCode") ? ((Integer) this.arguments.get("processTypeCode")).intValue() : -1);
        if (this.arguments.containsKey("successMessage")) {
            bundle.putString("successMessage", (String) this.arguments.get("successMessage"));
        } else {
            bundle.putString("successMessage", null);
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Integer num;
        Object obj;
        Object obj2;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("account")) {
            UserAccount userAccount = (UserAccount) this.arguments.get("account");
            if (Parcelable.class.isAssignableFrom(UserAccount.class) || userAccount == null) {
                obj2 = (Parcelable) Parcelable.class.cast(userAccount);
            } else {
                if (!Serializable.class.isAssignableFrom(UserAccount.class)) {
                    throw new UnsupportedOperationException(UserAccount.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj2 = (Serializable) Serializable.class.cast(userAccount);
            }
            savedStateHandle.set("account", obj2);
        } else {
            savedStateHandle.set("account", null);
        }
        if (this.arguments.containsKey("processError")) {
            ProcessError processError = (ProcessError) this.arguments.get("processError");
            if (Parcelable.class.isAssignableFrom(ProcessError.class) || processError == null) {
                obj = (Parcelable) Parcelable.class.cast(processError);
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessError.class)) {
                    throw new UnsupportedOperationException(ProcessError.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(processError);
            }
            savedStateHandle.set("processError", obj);
        } else {
            savedStateHandle.set("processError", null);
        }
        if (this.arguments.containsKey("processTypeCode")) {
            num = (Integer) this.arguments.get("processTypeCode");
            num.intValue();
        } else {
            num = -1;
        }
        savedStateHandle.set("processTypeCode", num);
        if (this.arguments.containsKey("successMessage")) {
            savedStateHandle.set("successMessage", (String) this.arguments.get("successMessage"));
        } else {
            savedStateHandle.set("successMessage", null);
        }
        return savedStateHandle;
    }

    public String toString() {
        return "PassportProfileFragmentArgs{account=" + getAccount() + ", processError=" + getProcessError() + ", processTypeCode=" + getProcessTypeCode() + ", successMessage=" + getSuccessMessage() + "}";
    }

    private PassportProfileFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
