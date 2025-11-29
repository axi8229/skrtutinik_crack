package ru.yoomoney.sdk.auth.api.passwordRecovery.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.UpdateRequiredException;
import ru.yoomoney.sdk.auth.api.account.emailChange.deserializer.a;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessChooseAccount;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessEnterPhone;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessFailure;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSetPassword;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessSuccess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.Step;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/passwordRecovery/deserializer/PasswordRecoveryProcessDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordRecoveryProcessDeserializer implements JsonDeserializer<PasswordRecoveryProcess> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Step.values().length];
            try {
                iArr[Step.ENTER_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Step.CHOOSE_ACCOUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Step.CONFIRM_PHONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Step.CONFIRM_EMAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Step.SET_PASSWORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Step.FAILURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Step.SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    public PasswordRecoveryProcess deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException, UpdateRequiredException {
        Type type;
        Intrinsics.checkNotNullParameter(json, "json");
        Step step = (Step) context.deserialize(a.a(typeOfT, "typeOfT", context, "context", json).get("step"), Step.class);
        switch (step == null ? -1 : WhenMappings.$EnumSwitchMapping$0[step.ordinal()]) {
            case 1:
                type = PasswordRecoveryProcessEnterPhone.class;
                break;
            case 2:
                type = PasswordRecoveryProcessChooseAccount.class;
                break;
            case 3:
                type = PasswordRecoveryProcessConfirmPhone.class;
                break;
            case 4:
                type = PasswordRecoveryProcessConfirmEmail.class;
                break;
            case 5:
                type = PasswordRecoveryProcessSetPassword.class;
                break;
            case 6:
                type = PasswordRecoveryProcessFailure.class;
                break;
            case 7:
                type = PasswordRecoveryProcessSuccess.class;
                break;
            default:
                throw new UpdateRequiredException();
        }
        Object objDeserialize = context.deserialize(json, type);
        Intrinsics.checkNotNullExpressionValue(objDeserialize, "deserialize(...)");
        return (PasswordRecoveryProcess) objDeserialize;
    }
}
