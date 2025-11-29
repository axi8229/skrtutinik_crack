package ru.yoomoney.sdk.auth.api.migration.method;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.migration.model.InputType;
import ru.yoomoney.sdk.auth.api.migration.serializer.MigrationSetPhoneRequestSerializer;

@JsonAdapter(MigrationSetPhoneRequestSerializer.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneRequest;", "", "type", "Lru/yoomoney/sdk/auth/api/migration/model/InputType;", "(Lru/yoomoney/sdk/auth/api/migration/model/InputType;)V", "getType", "()Lru/yoomoney/sdk/auth/api/migration/model/InputType;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneRawRequest;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneSuggestionRequest;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class MigrationSetPhoneRequest {

    @SerializedName("type")
    private final InputType type;

    private MigrationSetPhoneRequest(InputType inputType) {
        this.type = inputType;
    }

    public final InputType getType() {
        return this.type;
    }

    public /* synthetic */ MigrationSetPhoneRequest(InputType inputType, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputType);
    }
}
