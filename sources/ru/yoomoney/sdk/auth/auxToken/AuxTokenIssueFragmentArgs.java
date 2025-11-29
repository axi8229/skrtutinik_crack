package ru.yoomoney.sdk.auth.auxToken;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import java.util.Arrays;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.acceptTerms.a;

/* loaded from: classes4.dex */
public class AuxTokenIssueFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, String[] strArr, String str2) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"token\" is marked as non-null but was passed a null value.");
            }
            map.put("token", str);
            if (strArr == null) {
                throw new IllegalArgumentException("Argument \"scopes\" is marked as non-null but was passed a null value.");
            }
            map.put("scopes", strArr);
            if (str2 == null) {
                throw new IllegalArgumentException("Argument \"authCenterClientId\" is marked as non-null but was passed a null value.");
            }
            map.put("authCenterClientId", str2);
        }

        public AuxTokenIssueFragmentArgs build() {
            return new AuxTokenIssueFragmentArgs(this.arguments);
        }

        public String getAuthCenterClientId() {
            return (String) this.arguments.get("authCenterClientId");
        }

        public String[] getScopes() {
            return (String[]) this.arguments.get("scopes");
        }

        public String getToken() {
            return (String) this.arguments.get("token");
        }

        public Builder setAuthCenterClientId(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"authCenterClientId\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("authCenterClientId", str);
            return this;
        }

        public Builder setScopes(String[] strArr) {
            if (strArr == null) {
                throw new IllegalArgumentException("Argument \"scopes\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("scopes", strArr);
            return this;
        }

        public Builder setToken(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"token\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("token", str);
            return this;
        }

        public Builder(AuxTokenIssueFragmentArgs auxTokenIssueFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(auxTokenIssueFragmentArgs.arguments);
        }
    }

    private AuxTokenIssueFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static AuxTokenIssueFragmentArgs fromBundle(Bundle bundle) {
        AuxTokenIssueFragmentArgs auxTokenIssueFragmentArgs = new AuxTokenIssueFragmentArgs();
        if (!a.a(AuxTokenIssueFragmentArgs.class, bundle, "token")) {
            throw new IllegalArgumentException("Required argument \"token\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString("token");
        if (string == null) {
            throw new IllegalArgumentException("Argument \"token\" is marked as non-null but was passed a null value.");
        }
        auxTokenIssueFragmentArgs.arguments.put("token", string);
        if (!bundle.containsKey("scopes")) {
            throw new IllegalArgumentException("Required argument \"scopes\" is missing and does not have an android:defaultValue");
        }
        String[] stringArray = bundle.getStringArray("scopes");
        if (stringArray == null) {
            throw new IllegalArgumentException("Argument \"scopes\" is marked as non-null but was passed a null value.");
        }
        auxTokenIssueFragmentArgs.arguments.put("scopes", stringArray);
        if (!bundle.containsKey("authCenterClientId")) {
            throw new IllegalArgumentException("Required argument \"authCenterClientId\" is missing and does not have an android:defaultValue");
        }
        String string2 = bundle.getString("authCenterClientId");
        if (string2 == null) {
            throw new IllegalArgumentException("Argument \"authCenterClientId\" is marked as non-null but was passed a null value.");
        }
        auxTokenIssueFragmentArgs.arguments.put("authCenterClientId", string2);
        return auxTokenIssueFragmentArgs;
    }

    public static AuxTokenIssueFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        AuxTokenIssueFragmentArgs auxTokenIssueFragmentArgs = new AuxTokenIssueFragmentArgs();
        if (!savedStateHandle.contains("token")) {
            throw new IllegalArgumentException("Required argument \"token\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get("token");
        if (str == null) {
            throw new IllegalArgumentException("Argument \"token\" is marked as non-null but was passed a null value.");
        }
        auxTokenIssueFragmentArgs.arguments.put("token", str);
        if (!savedStateHandle.contains("scopes")) {
            throw new IllegalArgumentException("Required argument \"scopes\" is missing and does not have an android:defaultValue");
        }
        String[] strArr = (String[]) savedStateHandle.get("scopes");
        if (strArr == null) {
            throw new IllegalArgumentException("Argument \"scopes\" is marked as non-null but was passed a null value.");
        }
        auxTokenIssueFragmentArgs.arguments.put("scopes", strArr);
        if (!savedStateHandle.contains("authCenterClientId")) {
            throw new IllegalArgumentException("Required argument \"authCenterClientId\" is missing and does not have an android:defaultValue");
        }
        String str2 = (String) savedStateHandle.get("authCenterClientId");
        if (str2 == null) {
            throw new IllegalArgumentException("Argument \"authCenterClientId\" is marked as non-null but was passed a null value.");
        }
        auxTokenIssueFragmentArgs.arguments.put("authCenterClientId", str2);
        return auxTokenIssueFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AuxTokenIssueFragmentArgs auxTokenIssueFragmentArgs = (AuxTokenIssueFragmentArgs) obj;
        if (this.arguments.containsKey("token") != auxTokenIssueFragmentArgs.arguments.containsKey("token")) {
            return false;
        }
        if (getToken() == null ? auxTokenIssueFragmentArgs.getToken() != null : !getToken().equals(auxTokenIssueFragmentArgs.getToken())) {
            return false;
        }
        if (this.arguments.containsKey("scopes") != auxTokenIssueFragmentArgs.arguments.containsKey("scopes")) {
            return false;
        }
        if (getScopes() == null ? auxTokenIssueFragmentArgs.getScopes() != null : !getScopes().equals(auxTokenIssueFragmentArgs.getScopes())) {
            return false;
        }
        if (this.arguments.containsKey("authCenterClientId") != auxTokenIssueFragmentArgs.arguments.containsKey("authCenterClientId")) {
            return false;
        }
        return getAuthCenterClientId() == null ? auxTokenIssueFragmentArgs.getAuthCenterClientId() == null : getAuthCenterClientId().equals(auxTokenIssueFragmentArgs.getAuthCenterClientId());
    }

    public String getAuthCenterClientId() {
        return (String) this.arguments.get("authCenterClientId");
    }

    public String[] getScopes() {
        return (String[]) this.arguments.get("scopes");
    }

    public String getToken() {
        return (String) this.arguments.get("token");
    }

    public int hashCode() {
        return ((Arrays.hashCode(getScopes()) + (((getToken() != null ? getToken().hashCode() : 0) + 31) * 31)) * 31) + (getAuthCenterClientId() != null ? getAuthCenterClientId().hashCode() : 0);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey("token")) {
            bundle.putString("token", (String) this.arguments.get("token"));
        }
        if (this.arguments.containsKey("scopes")) {
            bundle.putStringArray("scopes", (String[]) this.arguments.get("scopes"));
        }
        if (this.arguments.containsKey("authCenterClientId")) {
            bundle.putString("authCenterClientId", (String) this.arguments.get("authCenterClientId"));
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("token")) {
            savedStateHandle.set("token", (String) this.arguments.get("token"));
        }
        if (this.arguments.containsKey("scopes")) {
            savedStateHandle.set("scopes", (String[]) this.arguments.get("scopes"));
        }
        if (this.arguments.containsKey("authCenterClientId")) {
            savedStateHandle.set("authCenterClientId", (String) this.arguments.get("authCenterClientId"));
        }
        return savedStateHandle;
    }

    public String toString() {
        return "AuxTokenIssueFragmentArgs{token=" + getToken() + ", scopes=" + getScopes() + ", authCenterClientId=" + getAuthCenterClientId() + "}";
    }

    private AuxTokenIssueFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
