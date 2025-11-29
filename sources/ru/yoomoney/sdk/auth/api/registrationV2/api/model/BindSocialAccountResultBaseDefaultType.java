package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBaseDefaultType;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase;", UpdateKey.STATUS, "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "service", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;)V", "getService", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/OauthServiceProvider;", "getStatus", "()Lru/yoomoney/sdk/auth/api/registrationV2/api/model/BindSocialAccountResultBase$Status;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BindSocialAccountResultBaseDefaultType extends BindSocialAccountResultBase {
    private final OauthServiceProvider service;
    private final BindSocialAccountResultBase.Status status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindSocialAccountResultBaseDefaultType(@JsonProperty(UpdateKey.STATUS) BindSocialAccountResultBase.Status status, @JsonProperty("service") OauthServiceProvider service) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(service, "service");
        this.status = status;
        this.service = service;
    }

    public static /* synthetic */ BindSocialAccountResultBaseDefaultType copy$default(BindSocialAccountResultBaseDefaultType bindSocialAccountResultBaseDefaultType, BindSocialAccountResultBase.Status status, OauthServiceProvider oauthServiceProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            status = bindSocialAccountResultBaseDefaultType.status;
        }
        if ((i & 2) != 0) {
            oauthServiceProvider = bindSocialAccountResultBaseDefaultType.service;
        }
        return bindSocialAccountResultBaseDefaultType.copy(status, oauthServiceProvider);
    }

    /* renamed from: component1, reason: from getter */
    public final BindSocialAccountResultBase.Status getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final OauthServiceProvider getService() {
        return this.service;
    }

    public final BindSocialAccountResultBaseDefaultType copy(@JsonProperty(UpdateKey.STATUS) BindSocialAccountResultBase.Status status, @JsonProperty("service") OauthServiceProvider service) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(service, "service");
        return new BindSocialAccountResultBaseDefaultType(status, service);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindSocialAccountResultBaseDefaultType)) {
            return false;
        }
        BindSocialAccountResultBaseDefaultType bindSocialAccountResultBaseDefaultType = (BindSocialAccountResultBaseDefaultType) other;
        return this.status == bindSocialAccountResultBaseDefaultType.status && this.service == bindSocialAccountResultBaseDefaultType.service;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase
    public OauthServiceProvider getService() {
        return this.service;
    }

    @Override // ru.yoomoney.sdk.auth.api.registrationV2.api.model.BindSocialAccountResultBase
    public BindSocialAccountResultBase.Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.service.hashCode() + (this.status.hashCode() * 31);
    }

    public String toString() {
        return "BindSocialAccountResultBaseDefaultType(status=" + this.status + ", service=" + this.service + ")";
    }
}
