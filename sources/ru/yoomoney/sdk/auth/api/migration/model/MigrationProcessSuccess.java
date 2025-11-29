package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSuccess;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", YooMoneyAuth.KEY_ACCESS_TOKEN, "bindSocialAccountResult", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLjava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;)V", "getAccessToken", "()Ljava/lang/String;", "getAddToBackStack", "()Z", "getBindSocialAccountResult", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MigrationProcessSuccess extends MigrationProcess {

    @SerializedName(YooMoneyAuth.KEY_ACCESS_TOKEN)
    private final String accessToken;

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("bindSocialAccountResult")
    private final BindSocialAccountResult bindSocialAccountResult;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationProcessSuccess(String id, OffsetDateTime expireAt, boolean z, String accessToken, BindSocialAccountResult bindSocialAccountResult) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.accessToken = accessToken;
        this.bindSocialAccountResult = bindSocialAccountResult;
    }

    public static /* synthetic */ MigrationProcessSuccess copy$default(MigrationProcessSuccess migrationProcessSuccess, String str, OffsetDateTime offsetDateTime, boolean z, String str2, BindSocialAccountResult bindSocialAccountResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = migrationProcessSuccess.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = migrationProcessSuccess.expireAt;
        }
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if ((i & 4) != 0) {
            z = migrationProcessSuccess.addToBackStack;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str2 = migrationProcessSuccess.accessToken;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            bindSocialAccountResult = migrationProcessSuccess.bindSocialAccountResult;
        }
        return migrationProcessSuccess.copy(str, offsetDateTime2, z2, str3, bindSocialAccountResult);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component5, reason: from getter */
    public final BindSocialAccountResult getBindSocialAccountResult() {
        return this.bindSocialAccountResult;
    }

    public final MigrationProcessSuccess copy(String id, OffsetDateTime expireAt, boolean addToBackStack, String accessToken, BindSocialAccountResult bindSocialAccountResult) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return new MigrationProcessSuccess(id, expireAt, addToBackStack, accessToken, bindSocialAccountResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationProcessSuccess)) {
            return false;
        }
        MigrationProcessSuccess migrationProcessSuccess = (MigrationProcessSuccess) other;
        return Intrinsics.areEqual(this.id, migrationProcessSuccess.id) && Intrinsics.areEqual(this.expireAt, migrationProcessSuccess.expireAt) && this.addToBackStack == migrationProcessSuccess.addToBackStack && Intrinsics.areEqual(this.accessToken, migrationProcessSuccess.accessToken) && Intrinsics.areEqual(this.bindSocialAccountResult, migrationProcessSuccess.bindSocialAccountResult);
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final BindSocialAccountResult getBindSocialAccountResult() {
        return this.bindSocialAccountResult;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public String getId() {
        return this.id;
    }

    public int hashCode() {
        int iA = a.a(this.accessToken, b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31), 31);
        BindSocialAccountResult bindSocialAccountResult = this.bindSocialAccountResult;
        return iA + (bindSocialAccountResult == null ? 0 : bindSocialAccountResult.hashCode());
    }

    public String toString() {
        return "MigrationProcessSuccess(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", accessToken=" + this.accessToken + ", bindSocialAccountResult=" + this.bindSocialAccountResult + ")";
    }
}
