package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSetEmail;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", RemoteMessageConst.INPUT_TYPE, "Lru/yoomoney/sdk/auth/api/migration/model/EmailInputType;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLru/yoomoney/sdk/auth/api/migration/model/EmailInputType;)V", "getAddToBackStack", "()Z", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "getInputType", "()Lru/yoomoney/sdk/auth/api/migration/model/EmailInputType;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MigrationProcessSetEmail extends MigrationProcess {

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    @SerializedName(RemoteMessageConst.INPUT_TYPE)
    private final EmailInputType inputType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationProcessSetEmail(String id, OffsetDateTime expireAt, boolean z, EmailInputType inputType) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.inputType = inputType;
    }

    public static /* synthetic */ MigrationProcessSetEmail copy$default(MigrationProcessSetEmail migrationProcessSetEmail, String str, OffsetDateTime offsetDateTime, boolean z, EmailInputType emailInputType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = migrationProcessSetEmail.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = migrationProcessSetEmail.expireAt;
        }
        if ((i & 4) != 0) {
            z = migrationProcessSetEmail.addToBackStack;
        }
        if ((i & 8) != 0) {
            emailInputType = migrationProcessSetEmail.inputType;
        }
        return migrationProcessSetEmail.copy(str, offsetDateTime, z, emailInputType);
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
    public final EmailInputType getInputType() {
        return this.inputType;
    }

    public final MigrationProcessSetEmail copy(String id, OffsetDateTime expireAt, boolean addToBackStack, EmailInputType inputType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        return new MigrationProcessSetEmail(id, expireAt, addToBackStack, inputType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationProcessSetEmail)) {
            return false;
        }
        MigrationProcessSetEmail migrationProcessSetEmail = (MigrationProcessSetEmail) other;
        return Intrinsics.areEqual(this.id, migrationProcessSetEmail.id) && Intrinsics.areEqual(this.expireAt, migrationProcessSetEmail.expireAt) && this.addToBackStack == migrationProcessSetEmail.addToBackStack && Intrinsics.areEqual(this.inputType, migrationProcessSetEmail.inputType);
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public String getId() {
        return this.id;
    }

    public final EmailInputType getInputType() {
        return this.inputType;
    }

    public int hashCode() {
        return this.inputType.hashCode() + b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31);
    }

    public String toString() {
        return "MigrationProcessSetEmail(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", inputType=" + this.inputType + ")";
    }
}
