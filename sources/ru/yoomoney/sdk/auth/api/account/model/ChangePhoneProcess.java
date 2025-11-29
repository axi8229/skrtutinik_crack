package ru.yoomoney.sdk.auth.api.account.model;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.account.phoneChange.deserializer.ChangePhoneProcessDeserializer;

@JsonAdapter(ChangePhoneProcessDeserializer.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneProcess;", "Lru/yoomoney/sdk/auth/api/Process;", "()V", "Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneConfirmPhone;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneFailure;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneSetPhone;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePhoneSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ChangePhoneProcess implements Process {
    private ChangePhoneProcess() {
    }

    public /* synthetic */ ChangePhoneProcess(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
