package ru.yoomoney.sdk.auth.api.enrollment.model;

import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.enrollment.deserializer.EnrollmentProcessDeserializer;

@JsonAdapter(EnrollmentProcessDeserializer.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "Lru/yoomoney/sdk/auth/api/Process;", "Landroid/os/Parcelable;", "()V", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessAcceptTerms;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessAcquireAuthorization;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessConfirmEmail;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessConfirmPhone;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessFailure;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessForceLogin;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessSetEmail;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessSetPassword;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessSetPhone;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessSuccess;", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcessSuggestAccount;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class EnrollmentProcess implements Process, Parcelable {
    private EnrollmentProcess() {
    }

    public /* synthetic */ EnrollmentProcess(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
