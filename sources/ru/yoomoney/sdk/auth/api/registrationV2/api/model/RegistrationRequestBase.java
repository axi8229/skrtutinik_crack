package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@JsonSubTypes({@JsonSubTypes.Type(name = "Identifier", value = RegistrationRequestIdentifier.class), @JsonSubTypes.Type(name = "LoginOauth", value = RegistrationRequestLoginOauth.class)})
@JsonTypeInfo(defaultImpl = RegistrationRequestBaseDefaultType.class, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", use = JsonTypeInfo.Id.NAME, visible = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase;", "", "()V", "type", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "getType", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "Type", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBaseDefaultType;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestIdentifier;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestLoginOauth;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RegistrationRequestBase {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "", "(Ljava/lang/String;I)V", "IDENTIFIER", "LOGIN_OAUTH", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        @JsonProperty("Identifier")
        public static final Type IDENTIFIER = new Type("IDENTIFIER", 0);

        @JsonProperty("LoginOauth")
        public static final Type LOGIN_OAUTH = new Type("LOGIN_OAUTH", 1);

        @JsonEnumDefaultValue
        public static final Type UNKNOWN_ENUM = new Type("UNKNOWN_ENUM", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{IDENTIFIER, LOGIN_OAUTH, UNKNOWN_ENUM};
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

    private RegistrationRequestBase() {
    }

    public /* synthetic */ RegistrationRequestBase(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Type getType();
}
