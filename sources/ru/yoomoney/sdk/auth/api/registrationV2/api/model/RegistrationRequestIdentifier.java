package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestBase;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestIdentifier;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase;", "type", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/ApiOrigin;", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/ApiOrigin;)V", "getOrigin", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/ApiOrigin;", "getType", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase$Type;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RegistrationRequestIdentifier extends RegistrationRequestBase {
    private final ApiOrigin origin;
    private final RegistrationRequestBase.Type type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegistrationRequestIdentifier(@JsonProperty("type") RegistrationRequestBase.Type type, @JsonProperty(AppMeasurementSdk.ConditionalUserProperty.ORIGIN) ApiOrigin origin) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.type = type;
        this.origin = origin;
    }

    public static /* synthetic */ RegistrationRequestIdentifier copy$default(RegistrationRequestIdentifier registrationRequestIdentifier, RegistrationRequestBase.Type type, ApiOrigin apiOrigin, int i, Object obj) {
        if ((i & 1) != 0) {
            type = registrationRequestIdentifier.type;
        }
        if ((i & 2) != 0) {
            apiOrigin = registrationRequestIdentifier.origin;
        }
        return registrationRequestIdentifier.copy(type, apiOrigin);
    }

    /* renamed from: component1, reason: from getter */
    public final RegistrationRequestBase.Type getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final ApiOrigin getOrigin() {
        return this.origin;
    }

    public final RegistrationRequestIdentifier copy(@JsonProperty("type") RegistrationRequestBase.Type type, @JsonProperty(AppMeasurementSdk.ConditionalUserProperty.ORIGIN) ApiOrigin origin) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(origin, "origin");
        return new RegistrationRequestIdentifier(type, origin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationRequestIdentifier)) {
            return false;
        }
        RegistrationRequestIdentifier registrationRequestIdentifier = (RegistrationRequestIdentifier) other;
        return this.type == registrationRequestIdentifier.type && this.origin == registrationRequestIdentifier.origin;
    }

    public final ApiOrigin getOrigin() {
        return this.origin;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestBase
    public RegistrationRequestBase.Type getType() {
        return this.type;
    }

    public int hashCode() {
        return this.origin.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        return "RegistrationRequestIdentifier(type=" + this.type + ", origin=" + this.origin + ")";
    }
}
