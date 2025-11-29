package ru.yoomoney.sdk.auth.loading;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.acceptTerms.a;

/* loaded from: classes4.dex */
public class AuthLoadingFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder() {
            this.arguments = new HashMap();
        }

        public AuthLoadingFragmentArgs build() {
            return new AuthLoadingFragmentArgs(this.arguments);
        }

        public boolean getIsForcedRegistration() {
            return ((Boolean) this.arguments.get("isForcedRegistration")).booleanValue();
        }

        public Builder setIsForcedRegistration(boolean z) {
            this.arguments.put("isForcedRegistration", Boolean.valueOf(z));
            return this;
        }

        public Builder(AuthLoadingFragmentArgs authLoadingFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(authLoadingFragmentArgs.arguments);
        }
    }

    private AuthLoadingFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static AuthLoadingFragmentArgs fromBundle(Bundle bundle) {
        AuthLoadingFragmentArgs authLoadingFragmentArgs = new AuthLoadingFragmentArgs();
        if (a.a(AuthLoadingFragmentArgs.class, bundle, "isForcedRegistration")) {
            authLoadingFragmentArgs.arguments.put("isForcedRegistration", Boolean.valueOf(bundle.getBoolean("isForcedRegistration")));
        } else {
            authLoadingFragmentArgs.arguments.put("isForcedRegistration", Boolean.FALSE);
        }
        return authLoadingFragmentArgs;
    }

    public static AuthLoadingFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        AuthLoadingFragmentArgs authLoadingFragmentArgs = new AuthLoadingFragmentArgs();
        if (savedStateHandle.contains("isForcedRegistration")) {
            Boolean bool = (Boolean) savedStateHandle.get("isForcedRegistration");
            bool.booleanValue();
            authLoadingFragmentArgs.arguments.put("isForcedRegistration", bool);
        } else {
            authLoadingFragmentArgs.arguments.put("isForcedRegistration", Boolean.FALSE);
        }
        return authLoadingFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AuthLoadingFragmentArgs authLoadingFragmentArgs = (AuthLoadingFragmentArgs) obj;
        return this.arguments.containsKey("isForcedRegistration") == authLoadingFragmentArgs.arguments.containsKey("isForcedRegistration") && getIsForcedRegistration() == authLoadingFragmentArgs.getIsForcedRegistration();
    }

    public boolean getIsForcedRegistration() {
        return ((Boolean) this.arguments.get("isForcedRegistration")).booleanValue();
    }

    public int hashCode() {
        return (getIsForcedRegistration() ? 1 : 0) + 31;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isForcedRegistration", this.arguments.containsKey("isForcedRegistration") ? ((Boolean) this.arguments.get("isForcedRegistration")).booleanValue() : false);
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Boolean bool;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey("isForcedRegistration")) {
            bool = (Boolean) this.arguments.get("isForcedRegistration");
            bool.booleanValue();
        } else {
            bool = Boolean.FALSE;
        }
        savedStateHandle.set("isForcedRegistration", bool);
        return savedStateHandle;
    }

    public String toString() {
        return "AuthLoadingFragmentArgs{isForcedRegistration=" + getIsForcedRegistration() + "}";
    }

    private AuthLoadingFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
