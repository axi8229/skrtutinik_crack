package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessAcquireAuthorization;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "applicationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLru/yoomoney/sdk/auth/api/model/ApplicationInfo;)V", "getAddToBackStack", "()Z", "getApplicationInfo", "()Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MigrationProcessAcquireAuthorization extends MigrationProcess {

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("applicationInfo")
    private final ApplicationInfo applicationInfo;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationProcessAcquireAuthorization(String id, OffsetDateTime expireAt, boolean z, ApplicationInfo applicationInfo) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.applicationInfo = applicationInfo;
    }

    public static /* synthetic */ MigrationProcessAcquireAuthorization copy$default(MigrationProcessAcquireAuthorization migrationProcessAcquireAuthorization, String str, OffsetDateTime offsetDateTime, boolean z, ApplicationInfo applicationInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = migrationProcessAcquireAuthorization.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = migrationProcessAcquireAuthorization.expireAt;
        }
        if ((i & 4) != 0) {
            z = migrationProcessAcquireAuthorization.addToBackStack;
        }
        if ((i & 8) != 0) {
            applicationInfo = migrationProcessAcquireAuthorization.applicationInfo;
        }
        return migrationProcessAcquireAuthorization.copy(str, offsetDateTime, z, applicationInfo);
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
    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    public final MigrationProcessAcquireAuthorization copy(String id, OffsetDateTime expireAt, boolean addToBackStack, ApplicationInfo applicationInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        return new MigrationProcessAcquireAuthorization(id, expireAt, addToBackStack, applicationInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationProcessAcquireAuthorization)) {
            return false;
        }
        MigrationProcessAcquireAuthorization migrationProcessAcquireAuthorization = (MigrationProcessAcquireAuthorization) other;
        return Intrinsics.areEqual(this.id, migrationProcessAcquireAuthorization.id) && Intrinsics.areEqual(this.expireAt, migrationProcessAcquireAuthorization.expireAt) && this.addToBackStack == migrationProcessAcquireAuthorization.addToBackStack && Intrinsics.areEqual(this.applicationInfo, migrationProcessAcquireAuthorization.applicationInfo);
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
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
        int iA = b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31);
        ApplicationInfo applicationInfo = this.applicationInfo;
        return iA + (applicationInfo == null ? 0 : applicationInfo.hashCode());
    }

    public String toString() {
        return "MigrationProcessAcquireAuthorization(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", applicationInfo=" + this.applicationInfo + ")";
    }
}
