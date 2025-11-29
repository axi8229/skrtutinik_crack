package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.A2;
import com.yandex.metrica.impl.ob.InterfaceC0826bf;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class UserProfile {
    private final List<UserProfileUpdate<? extends InterfaceC0826bf>> a;

    public static class Builder {
        private final LinkedList<UserProfileUpdate<? extends InterfaceC0826bf>> a = new LinkedList<>();

        Builder() {
        }

        public Builder apply(UserProfileUpdate<? extends InterfaceC0826bf> userProfileUpdate) {
            this.a.add(userProfileUpdate);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this.a);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<UserProfileUpdate<? extends InterfaceC0826bf>> getUserProfileUpdates() {
        return this.a;
    }

    private UserProfile(List<UserProfileUpdate<? extends InterfaceC0826bf>> list) {
        this.a = A2.c(list);
    }
}
