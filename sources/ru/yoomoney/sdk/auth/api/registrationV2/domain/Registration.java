package ru.yoomoney.sdk.auth.api.registrationV2.domain;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Origin;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration;", "", "type", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$Type;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$Type;)V", "getType", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$Type;", "Identifier", "LoginOauth", "Type", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$Identifier;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$LoginOauth;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Registration {
    private final Type type;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$Identifier;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "(Lru/yoomoney/sdk/auth/api/Origin;)V", "getOrigin", "()Lru/yoomoney/sdk/auth/api/Origin;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Identifier extends Registration {
        private final Origin origin;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Identifier(Origin origin) {
            super(Type.IDENTIFIER, null);
            Intrinsics.checkNotNullParameter(origin, "origin");
            this.origin = origin;
        }

        public static /* synthetic */ Identifier copy$default(Identifier identifier, Origin origin, int i, Object obj) {
            if ((i & 1) != 0) {
                origin = identifier.origin;
            }
            return identifier.copy(origin);
        }

        /* renamed from: component1, reason: from getter */
        public final Origin getOrigin() {
            return this.origin;
        }

        public final Identifier copy(Origin origin) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            return new Identifier(origin);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Identifier) && this.origin == ((Identifier) other).origin;
        }

        public final Origin getOrigin() {
            return this.origin;
        }

        public int hashCode() {
            return this.origin.hashCode();
        }

        public String toString() {
            return "Identifier(origin=" + this.origin + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$LoginOauth;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration;", "loginOauthProcessId", "", "(Ljava/lang/String;)V", "getLoginOauthProcessId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class LoginOauth extends Registration {
        private final String loginOauthProcessId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoginOauth(String loginOauthProcessId) {
            super(Type.LOGIN_OAUTH, null);
            Intrinsics.checkNotNullParameter(loginOauthProcessId, "loginOauthProcessId");
            this.loginOauthProcessId = loginOauthProcessId;
        }

        public static /* synthetic */ LoginOauth copy$default(LoginOauth loginOauth, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loginOauth.loginOauthProcessId;
            }
            return loginOauth.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLoginOauthProcessId() {
            return this.loginOauthProcessId;
        }

        public final LoginOauth copy(String loginOauthProcessId) {
            Intrinsics.checkNotNullParameter(loginOauthProcessId, "loginOauthProcessId");
            return new LoginOauth(loginOauthProcessId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LoginOauth) && Intrinsics.areEqual(this.loginOauthProcessId, ((LoginOauth) other).loginOauthProcessId);
        }

        public final String getLoginOauthProcessId() {
            return this.loginOauthProcessId;
        }

        public int hashCode() {
            return this.loginOauthProcessId.hashCode();
        }

        public String toString() {
            return "LoginOauth(loginOauthProcessId=" + this.loginOauthProcessId + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration$Type;", "", "(Ljava/lang/String;I)V", "IDENTIFIER", "LOGIN_OAUTH", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type IDENTIFIER = new Type("IDENTIFIER", 0);
        public static final Type LOGIN_OAUTH = new Type("LOGIN_OAUTH", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{IDENTIFIER, LOGIN_OAUTH};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    private Registration(Type type) {
        this.type = type;
    }

    public final Type getType() {
        return this.type;
    }

    public /* synthetic */ Registration(Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(type);
    }
}
