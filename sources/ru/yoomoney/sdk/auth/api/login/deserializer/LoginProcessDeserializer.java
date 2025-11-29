package ru.yoomoney.sdk.auth.api.login.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.UpdateRequiredException;
import ru.yoomoney.sdk.auth.api.account.emailChange.deserializer.a;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessAcquireAuthorization;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessChooseAccount;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterIdentifier;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterOauthCode;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterPassword;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessFailure;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessSuccess;
import ru.yoomoney.sdk.auth.api.login.model.Step;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/deserializer/LoginProcessDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginProcessDeserializer implements JsonDeserializer<LoginProcess> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Step.values().length];
            try {
                iArr[Step.ENTER_IDENTIFIER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Step.CONFIRM_PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Step.CONFIRM_EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Step.CHOOSE_ACCOUNT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Step.ENTER_PASSWORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Step.ACQUIRE_AUTHORIZATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Step.LOGIN_FAILURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Step.LOGIN_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Step.ENTER_OAUTH_CODE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    public LoginProcess deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException, UpdateRequiredException {
        Type type;
        Intrinsics.checkNotNullParameter(json, "json");
        Step step = (Step) context.deserialize(a.a(typeOfT, "typeOfT", context, "context", json).get("step"), Step.class);
        switch (step == null ? -1 : WhenMappings.$EnumSwitchMapping$0[step.ordinal()]) {
            case 1:
                type = LoginProcessEnterIdentifier.class;
                break;
            case 2:
                type = LoginProcessConfirmPhone.class;
                break;
            case 3:
                type = LoginProcessConfirmEmail.class;
                break;
            case 4:
                type = LoginProcessChooseAccount.class;
                break;
            case 5:
                type = LoginProcessEnterPassword.class;
                break;
            case 6:
                type = LoginProcessAcquireAuthorization.class;
                break;
            case 7:
                type = LoginProcessFailure.class;
                break;
            case 8:
                type = LoginProcessSuccess.class;
                break;
            case 9:
                type = LoginProcessEnterOauthCode.class;
                break;
            default:
                throw new UpdateRequiredException();
        }
        Object objDeserialize = context.deserialize(json, type);
        Intrinsics.checkNotNullExpressionValue(objDeserialize, "deserialize(...)");
        return (LoginProcess) objDeserialize;
    }
}
