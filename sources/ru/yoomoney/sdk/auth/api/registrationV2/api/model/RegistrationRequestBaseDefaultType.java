package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestBase;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBaseDefaultType;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase;", "type", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;)V", "getType", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationRequestBaseDefaultType extends RegistrationRequestBase {
    private final RegistrationRequestBase.Type type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationRequestBaseDefaultType(@JsonProperty("type") RegistrationRequestBase.Type type) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    public static /* synthetic */ RegistrationRequestBaseDefaultType copy$default(RegistrationRequestBaseDefaultType registrationRequestBaseDefaultType, RegistrationRequestBase.Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            type = registrationRequestBaseDefaultType.type;
        }
        return registrationRequestBaseDefaultType.copy(type);
    }

    /* renamed from: component1, reason: from getter */
    public final RegistrationRequestBase.Type getType() {
        return this.type;
    }

    public final RegistrationRequestBaseDefaultType copy(@JsonProperty("type") RegistrationRequestBase.Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new RegistrationRequestBaseDefaultType(type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RegistrationRequestBaseDefaultType) && this.type == ((RegistrationRequestBaseDefaultType) other).type;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestBase
    public RegistrationRequestBase.Type getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "RegistrationRequestBaseDefaultType(type=" + this.type + ")";
    }
}
