package ru.yoomoney.sdk.auth.api.login.method;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.login.serializer.LoginRequestSerializer;

@JsonAdapter(LoginRequestSerializer.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0001\u0007B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;", "", "type", "Lru/yoomoney/sdk/auth/api/login/method/LoginRequest$Type;", "(Lru/yoomoney/sdk/auth/api/login/method/LoginRequest$Type;)V", "getType", "()Lru/yoomoney/sdk/auth/api/login/method/LoginRequest$Type;", "Type", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnrollmentRequest;", "Lru/yoomoney/sdk/auth/api/login/method/LoginIdentifierRequest;", "Lru/yoomoney/sdk/auth/api/login/method/LoginOauthRequest;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class LoginRequest {

    @SerializedName("type")
    private final Type type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/method/LoginRequest$Type;", "", "(Ljava/lang/String;I)V", "IDENTIFIER", "ENROLLMENT", "OAUTH", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        @SerializedName("Identifier")
        public static final Type IDENTIFIER = new Type("IDENTIFIER", 0);

        @SerializedName("Enrollment")
        public static final Type ENROLLMENT = new Type("ENROLLMENT", 1);

        @SerializedName("Oauth")
        public static final Type OAUTH = new Type("OAUTH", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{IDENTIFIER, ENROLLMENT, OAUTH};
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

    private LoginRequest(Type type) {
        this.type = type;
    }

    public final Type getType() {
        return this.type;
    }

    public /* synthetic */ LoginRequest(Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(type);
    }
}
