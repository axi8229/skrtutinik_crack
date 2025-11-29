package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.migration.deserializer.MigrationProcessDeserializer;

@JsonAdapter(MigrationProcessDeserializer.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "Lru/yoomoney/sdk/auth/api/Process;", "()V", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessAcquireAuthorization;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessConfirmEmail;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessConfirmPhone;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessFailure;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSetEmail;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSetPassword;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSetPhone;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSetYandexToken;", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcessSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class MigrationProcess implements Process {
    private MigrationProcess() {
    }

    public /* synthetic */ MigrationProcess(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
