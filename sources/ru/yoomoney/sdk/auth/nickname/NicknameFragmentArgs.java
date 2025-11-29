package ru.yoomoney.sdk.auth.nickname;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.acceptTerms.a;

/* loaded from: classes4.dex */
public class NicknameFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder() {
            this.arguments = new HashMap();
        }

        public NicknameFragmentArgs build() {
            return new NicknameFragmentArgs(this.arguments);
        }

        public String getNickname() {
            return (String) this.arguments.get("nickname");
        }

        public Builder setNickname(String str) {
            this.arguments.put("nickname", str);
            return this;
        }

        public Builder(NicknameFragmentArgs nicknameFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(nicknameFragmentArgs.arguments);
        }
    }

    private NicknameFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static NicknameFragmentArgs fromBundle(Bundle bundle) {
        NicknameFragmentArgs nicknameFragmentArgs = new NicknameFragmentArgs();
        if (a.a(NicknameFragmentArgs.class, bundle, "nickname")) {
            nicknameFragmentArgs.arguments.put("nickname", bundle.getString("nickname"));
        } else {
            nicknameFragmentArgs.arguments.put("nickname", null);
        }
        return nicknameFragmentArgs;
    }

    public static NicknameFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        NicknameFragmentArgs nicknameFragmentArgs = new NicknameFragmentArgs();
        if (savedStateHandle.contains("nickname")) {
            nicknameFragmentArgs.arguments.put("nickname", (String) savedStateHandle.get("nickname"));
        } else {
            nicknameFragmentArgs.arguments.put("nickname", null);
        }
        return nicknameFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NicknameFragmentArgs nicknameFragmentArgs = (NicknameFragmentArgs) obj;
        if (this.arguments.containsKey("nickname") != nicknameFragmentArgs.arguments.containsKey("nickname")) {
            return false;
        }
        return getNickname() == null ? nicknameFragmentArgs.getNickname() == null : getNickname().equals(nicknameFragmentArgs.getNickname());
    }

    public String getNickname() {
        return (String) this.arguments.get("nickname");
    }

    public int hashCode() {
        return (getNickname() != null ? getNickname().hashCode() : 0) + 31;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("nickname", this.arguments.containsKey("nickname") ? (String) this.arguments.get("nickname") : null);
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("nickname", this.arguments.containsKey("nickname") ? (String) this.arguments.get("nickname") : null);
        return savedStateHandle;
    }

    public String toString() {
        return "NicknameFragmentArgs{nickname=" + getNickname() + "}";
    }

    private NicknameFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
