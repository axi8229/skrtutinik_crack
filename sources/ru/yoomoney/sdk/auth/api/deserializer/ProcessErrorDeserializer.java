package ru.yoomoney.sdk.auth.api.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.UpdateRequiredException;
import ru.yoomoney.sdk.auth.api.account.emailChange.deserializer.a;
import ru.yoomoney.sdk.auth.api.model.ErrorAccountForRecoveryNotFound;
import ru.yoomoney.sdk.auth.api.model.ErrorAccountNotFound;
import ru.yoomoney.sdk.auth.api.model.ErrorCodeExpired;
import ru.yoomoney.sdk.auth.api.model.ErrorContactTechnicalSupport;
import ru.yoomoney.sdk.auth.api.model.ErrorEmailAlreadyTaken;
import ru.yoomoney.sdk.auth.api.model.ErrorEmailQuarantined;
import ru.yoomoney.sdk.auth.api.model.ErrorFraudSuspected;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidCode;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidOauthSecret;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidPassword;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidPasswordOrAccount;
import ru.yoomoney.sdk.auth.api.model.ErrorMaxSucceededPasswordAttemptsReached;
import ru.yoomoney.sdk.auth.api.model.ErrorMaxWrongPasswordAttemptsReached;
import ru.yoomoney.sdk.auth.api.model.ErrorOauthAccountNotConnected;
import ru.yoomoney.sdk.auth.api.model.ErrorPasswordRequirementsViolated;
import ru.yoomoney.sdk.auth.api.model.ErrorPhoneIsAlreadyAssignedToAccountWithoutEmail;
import ru.yoomoney.sdk.auth.api.model.ErrorPhoneIsSameAsCurrent;
import ru.yoomoney.sdk.auth.api.model.ErrorProcessingRequest;
import ru.yoomoney.sdk.auth.api.model.ErrorSocialAccountAlreadyBound;
import ru.yoomoney.sdk.auth.api.model.ErrorTooFrequentlyResend;
import ru.yoomoney.sdk.auth.api.model.ErrorTooManyLinkedAccountsToPhone;
import ru.yoomoney.sdk.auth.api.model.ErrorType;
import ru.yoomoney.sdk.auth.api.model.ErrorUserTemporaryBanned;
import ru.yoomoney.sdk.auth.api.model.NotNeedMigration;
import ru.yoomoney.sdk.auth.api.model.NotRegistered;
import ru.yoomoney.sdk.auth.api.model.ProcessError;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/deserializer/ProcessErrorDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProcessErrorDeserializer implements JsonDeserializer<ProcessError> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ErrorType.values().length];
            try {
                iArr[ErrorType.PASSWORD_REQUIREMENTS_VIOLATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ErrorType.TOO_FREQUENTLY_RESEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ErrorType.FRAUD_SUSPECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ErrorType.EMAIL_QUARANTINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ErrorType.EMAIL_ALREADY_TAKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ErrorType.CODE_EXPIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ErrorType.INVALID_CODE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ErrorType.INVALID_PASSWORD_OR_ACCOUNT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ErrorType.TEMPORARY_BANNED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ErrorType.TOO_MANY_ACCOUNTS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ErrorType.PROCESSING_REQUEST.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ErrorType.NOT_NEED_MIGRATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ErrorType.NOT_REGISTERED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ErrorType.CONTACT_TECHNICAL_SUPPORT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ErrorType.INVALID_PASSWORD.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ErrorType.ACCOUNT_NOT_FOUND.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ErrorType.MAX_WRONG_PASSWORD_ATTEMPTS_REACHED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ErrorType.MAX_SUCCEEDED_PASSWORD_ATTEMPTS_REACHED.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ErrorType.PHONE_IS_SAME_AS_CURRENT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ErrorType.PHONE_IS_ALREADY_ASSIGNED_TO_ACCOUNT_WITHOUT_EMAIL.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ErrorType.ACCOUNT_FOR_RECOVERY_NOT_FOUND.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ErrorType.OAUTH_ACCOUNT_NOT_CONNECTED.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ErrorType.INVALID_OAUTH_SECRET.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ErrorType.SOCIAL_ACCOUNT_ALREADY_BOUND.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    public ProcessError deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException, UpdateRequiredException {
        Type type;
        Intrinsics.checkNotNullParameter(json, "json");
        ErrorType errorType = (ErrorType) context.deserialize(a.a(typeOfT, "typeOfT", context, "context", json).get("type"), ErrorType.class);
        switch (errorType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[errorType.ordinal()]) {
            case 1:
                type = ErrorPasswordRequirementsViolated.class;
                break;
            case 2:
                type = ErrorTooFrequentlyResend.class;
                break;
            case 3:
                return ErrorFraudSuspected.INSTANCE;
            case 4:
                return ErrorEmailQuarantined.INSTANCE;
            case 5:
                return ErrorEmailAlreadyTaken.INSTANCE;
            case 6:
                type = ErrorCodeExpired.class;
                break;
            case 7:
                type = ErrorInvalidCode.class;
                break;
            case 8:
                type = ErrorInvalidPasswordOrAccount.class;
                break;
            case 9:
                type = ErrorUserTemporaryBanned.class;
                break;
            case 10:
                type = ErrorTooManyLinkedAccountsToPhone.class;
                break;
            case 11:
                type = ErrorProcessingRequest.class;
                break;
            case 12:
                return NotNeedMigration.INSTANCE;
            case 13:
                return NotRegistered.INSTANCE;
            case 14:
                return ErrorContactTechnicalSupport.INSTANCE;
            case 15:
                type = ErrorInvalidPassword.class;
                break;
            case 16:
                return ErrorAccountNotFound.INSTANCE;
            case 17:
                type = ErrorMaxWrongPasswordAttemptsReached.class;
                break;
            case 18:
                type = ErrorMaxSucceededPasswordAttemptsReached.class;
                break;
            case 19:
                return ErrorPhoneIsSameAsCurrent.INSTANCE;
            case 20:
                return ErrorPhoneIsAlreadyAssignedToAccountWithoutEmail.INSTANCE;
            case 21:
                return ErrorAccountForRecoveryNotFound.INSTANCE;
            case 22:
                type = ErrorOauthAccountNotConnected.class;
                break;
            case 23:
                return ErrorInvalidOauthSecret.INSTANCE;
            case 24:
                return ErrorSocialAccountAlreadyBound.INSTANCE;
            default:
                throw new UpdateRequiredException();
        }
        Object objDeserialize = context.deserialize(json, type);
        Intrinsics.checkNotNullExpressionValue(objDeserialize, "deserialize(...)");
        return (ProcessError) objDeserialize;
    }
}
