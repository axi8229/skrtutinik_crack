package ru.yoomoney.sdk.auth.password.create;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.b;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordCreate {
    public static final PasswordCreate INSTANCE = new PasswordCreate();

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0010\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0010\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "", "()V", "DisplayPassword", "Expired", "FirstPasswordChanged", "GeneratePassword", "PasswordCreateFailure", "PasswordsIsInvalid", "RegistrationSetPasswordSuccess", "RestartProcess", "SecondPasswordChanged", "SendAnalyticsForScreen", "SetGeneratedPassword", "SetPasswordFail", "SetPasswordSuccess", "SetValidationResult", "Submit", "ValidateBeforeSubmit", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$DisplayPassword;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$Expired;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$FirstPasswordChanged;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$GeneratePassword;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$PasswordCreateFailure;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$PasswordsIsInvalid;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$RegistrationSetPasswordSuccess;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SecondPasswordChanged;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetGeneratedPassword;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetPasswordFail;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetPasswordSuccess;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetValidationResult;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$Submit;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$ValidateBeforeSubmit;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$DisplayPassword;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class DisplayPassword extends Action {
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DisplayPassword(ProcessType processType) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                this.processType = processType;
            }

            public static /* synthetic */ DisplayPassword copy$default(DisplayPassword displayPassword, ProcessType processType, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = displayPassword.processType;
                }
                return displayPassword.copy(processType);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final DisplayPassword copy(ProcessType processType) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                return new DisplayPassword(processType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DisplayPassword) && this.processType == ((DisplayPassword) other).processType;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.processType.hashCode();
            }

            public String toString() {
                return "DisplayPassword(processType=" + this.processType + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$Expired;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Expired extends Action {
            public static final Expired INSTANCE = new Expired();

            private Expired() {
                super(null);
            }

            public String toString() {
                return Expired.class.getSimpleName();
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$FirstPasswordChanged;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FirstPasswordChanged extends Action {
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FirstPasswordChanged(String value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public static /* synthetic */ FirstPasswordChanged copy$default(FirstPasswordChanged firstPasswordChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = firstPasswordChanged.value;
                }
                return firstPasswordChanged.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final FirstPasswordChanged copy(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new FirstPasswordChanged(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FirstPasswordChanged) && Intrinsics.areEqual(this.value, ((FirstPasswordChanged) other).value);
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "FirstPasswordChanged(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$GeneratePassword;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class GeneratePassword extends Action {
            public static final GeneratePassword INSTANCE = new GeneratePassword();

            private GeneratePassword() {
                super(null);
            }

            public String toString() {
                return GeneratePassword.class.getSimpleName();
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$PasswordCreateFailure;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PasswordCreateFailure extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PasswordCreateFailure(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ PasswordCreateFailure copy$default(PasswordCreateFailure passwordCreateFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = passwordCreateFailure.failure;
                }
                return passwordCreateFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final PasswordCreateFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new PasswordCreateFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PasswordCreateFailure) && Intrinsics.areEqual(this.failure, ((PasswordCreateFailure) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "PasswordCreateFailure(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$PasswordsIsInvalid;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "isValidFirstPassword", "", "isValidSecondPassword", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PasswordsIsInvalid extends Action {
            private final boolean isValidFirstPassword;
            private final boolean isValidSecondPassword;

            public PasswordsIsInvalid(boolean z, boolean z2) {
                super(null);
                this.isValidFirstPassword = z;
                this.isValidSecondPassword = z2;
            }

            public static /* synthetic */ PasswordsIsInvalid copy$default(PasswordsIsInvalid passwordsIsInvalid, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = passwordsIsInvalid.isValidFirstPassword;
                }
                if ((i & 2) != 0) {
                    z2 = passwordsIsInvalid.isValidSecondPassword;
                }
                return passwordsIsInvalid.copy(z, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsValidFirstPassword() {
                return this.isValidFirstPassword;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsValidSecondPassword() {
                return this.isValidSecondPassword;
            }

            public final PasswordsIsInvalid copy(boolean isValidFirstPassword, boolean isValidSecondPassword) {
                return new PasswordsIsInvalid(isValidFirstPassword, isValidSecondPassword);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PasswordsIsInvalid)) {
                    return false;
                }
                PasswordsIsInvalid passwordsIsInvalid = (PasswordsIsInvalid) other;
                return this.isValidFirstPassword == passwordsIsInvalid.isValidFirstPassword && this.isValidSecondPassword == passwordsIsInvalid.isValidSecondPassword;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isValidSecondPassword) + (Boolean.hashCode(this.isValidFirstPassword) * 31);
            }

            public final boolean isValidFirstPassword() {
                return this.isValidFirstPassword;
            }

            public final boolean isValidSecondPassword() {
                return this.isValidSecondPassword;
            }

            public String toString() {
                return "PasswordsIsInvalid(isValidFirstPassword=" + this.isValidFirstPassword + ", isValidSecondPassword=" + this.isValidSecondPassword + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$RegistrationSetPasswordSuccess;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RegistrationSetPasswordSuccess extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RegistrationSetPasswordSuccess(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ RegistrationSetPasswordSuccess copy$default(RegistrationSetPasswordSuccess registrationSetPasswordSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = registrationSetPasswordSuccess.process;
                }
                return registrationSetPasswordSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final RegistrationSetPasswordSuccess copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new RegistrationSetPasswordSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RegistrationSetPasswordSuccess) && Intrinsics.areEqual(this.process, ((RegistrationSetPasswordSuccess) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "RegistrationSetPasswordSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class RestartProcess extends Action {
            public static final RestartProcess INSTANCE = new RestartProcess();

            private RestartProcess() {
                super(null);
            }

            public String toString() {
                return RestartProcess.class.getSimpleName();
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SecondPasswordChanged;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SecondPasswordChanged extends Action {
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SecondPasswordChanged(String value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public static /* synthetic */ SecondPasswordChanged copy$default(SecondPasswordChanged secondPasswordChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = secondPasswordChanged.value;
                }
                return secondPasswordChanged.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public final SecondPasswordChanged copy(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new SecondPasswordChanged(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SecondPasswordChanged) && Intrinsics.areEqual(this.value, ((SecondPasswordChanged) other).value);
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "SecondPasswordChanged(value=" + this.value + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Lru/yoomoney/sdk/auth/api/ProcessType;)V", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendAnalyticsForScreen extends Action {
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendAnalyticsForScreen(ProcessType processType) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                this.processType = processType;
            }

            public static /* synthetic */ SendAnalyticsForScreen copy$default(SendAnalyticsForScreen sendAnalyticsForScreen, ProcessType processType, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = sendAnalyticsForScreen.processType;
                }
                return sendAnalyticsForScreen.copy(processType);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            public final SendAnalyticsForScreen copy(ProcessType processType) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                return new SendAnalyticsForScreen(processType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendAnalyticsForScreen) && this.processType == ((SendAnalyticsForScreen) other).processType;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.processType.hashCode();
            }

            public String toString() {
                return "SendAnalyticsForScreen(processType=" + this.processType + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetGeneratedPassword;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "password", "", "(Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetGeneratedPassword extends Action {
            private final String password;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetGeneratedPassword(String password) {
                super(null);
                Intrinsics.checkNotNullParameter(password, "password");
                this.password = password;
            }

            public static /* synthetic */ SetGeneratedPassword copy$default(SetGeneratedPassword setGeneratedPassword, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = setGeneratedPassword.password;
                }
                return setGeneratedPassword.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getPassword() {
                return this.password;
            }

            public final SetGeneratedPassword copy(String password) {
                Intrinsics.checkNotNullParameter(password, "password");
                return new SetGeneratedPassword(password);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetGeneratedPassword) && Intrinsics.areEqual(this.password, ((SetGeneratedPassword) other).password);
            }

            public final String getPassword() {
                return this.password;
            }

            public int hashCode() {
                return this.password.hashCode();
            }

            public String toString() {
                return "SetGeneratedPassword(password=" + this.password + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetPasswordFail;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "(Lru/yoomoney/sdk/auth/api/model/ProcessError;)V", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetPasswordFail extends Action {
            private final ProcessError error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetPasswordFail(ProcessError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ SetPasswordFail copy$default(SetPasswordFail setPasswordFail, ProcessError processError, int i, Object obj) {
                if ((i & 1) != 0) {
                    processError = setPasswordFail.error;
                }
                return setPasswordFail.copy(processError);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessError getError() {
                return this.error;
            }

            public final SetPasswordFail copy(ProcessError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new SetPasswordFail(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetPasswordFail) && Intrinsics.areEqual(this.error, ((SetPasswordFail) other).error);
            }

            public final ProcessError getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "SetPasswordFail(error=" + this.error + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetPasswordSuccess;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetPasswordSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetPasswordSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ SetPasswordSuccess copy$default(SetPasswordSuccess setPasswordSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = setPasswordSuccess.process;
                }
                return setPasswordSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final SetPasswordSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new SetPasswordSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetPasswordSuccess) && Intrinsics.areEqual(this.process, ((SetPasswordSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "SetPasswordSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$SetValidationResult;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "isValidLetters", "", "isValidLength", "isValidNumbersContains", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetValidationResult extends Action {
            private final boolean isValidLength;
            private final boolean isValidLetters;
            private final boolean isValidNumbersContains;

            public SetValidationResult(boolean z, boolean z2, boolean z3) {
                super(null);
                this.isValidLetters = z;
                this.isValidLength = z2;
                this.isValidNumbersContains = z3;
            }

            public static /* synthetic */ SetValidationResult copy$default(SetValidationResult setValidationResult, boolean z, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = setValidationResult.isValidLetters;
                }
                if ((i & 2) != 0) {
                    z2 = setValidationResult.isValidLength;
                }
                if ((i & 4) != 0) {
                    z3 = setValidationResult.isValidNumbersContains;
                }
                return setValidationResult.copy(z, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsValidLetters() {
                return this.isValidLetters;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsValidLength() {
                return this.isValidLength;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsValidNumbersContains() {
                return this.isValidNumbersContains;
            }

            public final SetValidationResult copy(boolean isValidLetters, boolean isValidLength, boolean isValidNumbersContains) {
                return new SetValidationResult(isValidLetters, isValidLength, isValidNumbersContains);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SetValidationResult)) {
                    return false;
                }
                SetValidationResult setValidationResult = (SetValidationResult) other;
                return this.isValidLetters == setValidationResult.isValidLetters && this.isValidLength == setValidationResult.isValidLength && this.isValidNumbersContains == setValidationResult.isValidNumbersContains;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isValidNumbersContains) + b.a(this.isValidLength, Boolean.hashCode(this.isValidLetters) * 31, 31);
            }

            public final boolean isValidLength() {
                return this.isValidLength;
            }

            public final boolean isValidLetters() {
                return this.isValidLetters;
            }

            public final boolean isValidNumbersContains() {
                return this.isValidNumbersContains;
            }

            public String toString() {
                return "SetValidationResult(isValidLetters=" + this.isValidLetters + ", isValidLength=" + this.isValidLength + ", isValidNumbersContains=" + this.isValidNumbersContains + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$Submit;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Submit extends Action {
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Submit(ProcessType processType, String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processType = processType;
                this.processId = processId;
            }

            public static /* synthetic */ Submit copy$default(Submit submit, ProcessType processType, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = submit.processType;
                }
                if ((i & 2) != 0) {
                    str = submit.processId;
                }
                return submit.copy(processType, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final Submit copy(ProcessType processType, String processId) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new Submit(processType, processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Submit)) {
                    return false;
                }
                Submit submit = (Submit) other;
                return this.processType == submit.processType && Intrinsics.areEqual(this.processId, submit.processId);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                return this.processId.hashCode() + (this.processType.hashCode() * 31);
            }

            public String toString() {
                return "Submit(processType=" + this.processType + ", processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$ValidateBeforeSubmit;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ValidateBeforeSubmit extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final ProcessType processType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ValidateBeforeSubmit(ProcessType processType, String processId, OffsetDateTime offsetDateTime) {
                super(null);
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processType = processType;
                this.processId = processId;
                this.expireAt = offsetDateTime;
            }

            public static /* synthetic */ ValidateBeforeSubmit copy$default(ValidateBeforeSubmit validateBeforeSubmit, ProcessType processType, String str, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    processType = validateBeforeSubmit.processType;
                }
                if ((i & 2) != 0) {
                    str = validateBeforeSubmit.processId;
                }
                if ((i & 4) != 0) {
                    offsetDateTime = validateBeforeSubmit.expireAt;
                }
                return validateBeforeSubmit.copy(processType, str, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component3, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final ValidateBeforeSubmit copy(ProcessType processType, String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new ValidateBeforeSubmit(processType, processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ValidateBeforeSubmit)) {
                    return false;
                }
                ValidateBeforeSubmit validateBeforeSubmit = (ValidateBeforeSubmit) other;
                return this.processType == validateBeforeSubmit.processType && Intrinsics.areEqual(this.processId, validateBeforeSubmit.processId) && Intrinsics.areEqual(this.expireAt, validateBeforeSubmit.expireAt);
            }

            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }

            public int hashCode() {
                int iA = a.a(this.processId, this.processType.hashCode() * 31, 31);
                OffsetDateTime offsetDateTime = this.expireAt;
                return iA + (offsetDateTime == null ? 0 : offsetDateTime.hashCode());
            }

            public String toString() {
                return "ValidateBeforeSubmit(processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;", "action", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "", "()V", "ResetProcess", "ShowError", "ShowExpireDialog", "ShowFailure", "ShowGeneratedPassword", "ShowNextStep", "ShowRegistrationNextStep", "ShowValidations", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowError;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowGeneratedPassword;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowRegistrationNextStep;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowValidations;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ResetProcess extends Effect {
            public static final ResetProcess INSTANCE = new ResetProcess();

            private ResetProcess() {
                super(null);
            }

            public String toString() {
                return ResetProcess.class.getSimpleName();
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowError;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "(Lru/yoomoney/sdk/auth/api/model/ProcessError;)V", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowError extends Effect {
            private final ProcessError error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowError(ProcessError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ ShowError copy$default(ShowError showError, ProcessError processError, int i, Object obj) {
                if ((i & 1) != 0) {
                    processError = showError.error;
                }
                return showError.copy(processError);
            }

            /* renamed from: component1, reason: from getter */
            public final ProcessError getError() {
                return this.error;
            }

            public final ShowError copy(ProcessError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new ShowError(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowError) && Intrinsics.areEqual(this.error, ((ShowError) other).error);
            }

            public final ProcessError getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ShowError(error=" + this.error + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowExpireDialog extends Effect {
            public static final ShowExpireDialog INSTANCE = new ShowExpireDialog();

            private ShowExpireDialog() {
                super(null);
            }

            public String toString() {
                return ShowExpireDialog.class.getSimpleName();
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure extends Effect {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFailure(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ShowFailure copy$default(ShowFailure showFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showFailure.failure;
                }
                return showFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ShowFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ShowFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowFailure) && Intrinsics.areEqual(this.failure, ((ShowFailure) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowFailure(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowGeneratedPassword;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "password", "", "(Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowGeneratedPassword extends Effect {
            private final String password;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowGeneratedPassword(String password) {
                super(null);
                Intrinsics.checkNotNullParameter(password, "password");
                this.password = password;
            }

            public static /* synthetic */ ShowGeneratedPassword copy$default(ShowGeneratedPassword showGeneratedPassword, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showGeneratedPassword.password;
                }
                return showGeneratedPassword.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getPassword() {
                return this.password;
            }

            public final ShowGeneratedPassword copy(String password) {
                Intrinsics.checkNotNullParameter(password, "password");
                return new ShowGeneratedPassword(password);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowGeneratedPassword) && Intrinsics.areEqual(this.password, ((ShowGeneratedPassword) other).password);
            }

            public final String getPassword() {
                return this.password;
            }

            public int hashCode() {
                return this.password.hashCode();
            }

            public String toString() {
                return "ShowGeneratedPassword(password=" + this.password + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextStep extends Effect {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextStep(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowNextStep copy$default(ShowNextStep showNextStep, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = showNextStep.process;
                }
                return showNextStep.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final ShowNextStep copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowNextStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextStep) && Intrinsics.areEqual(this.process, ((ShowNextStep) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowNextStep(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowRegistrationNextStep;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowRegistrationNextStep extends Effect {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowRegistrationNextStep(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowRegistrationNextStep copy$default(ShowRegistrationNextStep showRegistrationNextStep, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = showRegistrationNextStep.process;
                }
                return showRegistrationNextStep.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final ShowRegistrationNextStep copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowRegistrationNextStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowRegistrationNextStep) && Intrinsics.areEqual(this.process, ((ShowRegistrationNextStep) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowRegistrationNextStep(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect$ShowValidations;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "isValidFirstPassword", "", "isValidSecondPassword", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowValidations extends Effect {
            private final boolean isValidFirstPassword;
            private final boolean isValidSecondPassword;

            public ShowValidations(boolean z, boolean z2) {
                super(null);
                this.isValidFirstPassword = z;
                this.isValidSecondPassword = z2;
            }

            public static /* synthetic */ ShowValidations copy$default(ShowValidations showValidations, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = showValidations.isValidFirstPassword;
                }
                if ((i & 2) != 0) {
                    z2 = showValidations.isValidSecondPassword;
                }
                return showValidations.copy(z, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsValidFirstPassword() {
                return this.isValidFirstPassword;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsValidSecondPassword() {
                return this.isValidSecondPassword;
            }

            public final ShowValidations copy(boolean isValidFirstPassword, boolean isValidSecondPassword) {
                return new ShowValidations(isValidFirstPassword, isValidSecondPassword);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowValidations)) {
                    return false;
                }
                ShowValidations showValidations = (ShowValidations) other;
                return this.isValidFirstPassword == showValidations.isValidFirstPassword && this.isValidSecondPassword == showValidations.isValidSecondPassword;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isValidSecondPassword) + (Boolean.hashCode(this.isValidFirstPassword) * 31);
            }

            public final boolean isValidFirstPassword() {
                return this.isValidFirstPassword;
            }

            public final boolean isValidSecondPassword() {
                return this.isValidSecondPassword;
            }

            public String toString() {
                return "ShowValidations(isValidFirstPassword=" + this.isValidFirstPassword + ", isValidSecondPassword=" + this.isValidSecondPassword + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;", "", "()V", "Content", "Progress", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Progress;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J;\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;", "firstPassword", "", "secondPassword", "isValidLetters", "", "isValidLength", "isValidNumbersContains", "(Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getFirstPassword", "()Ljava/lang/String;", "()Z", "getSecondPassword", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final String firstPassword;
            private final boolean isValidLength;
            private final boolean isValidLetters;
            private final boolean isValidNumbersContains;
            private final String secondPassword;

            public Content() {
                this(null, null, false, false, false, 31, null);
            }

            public static /* synthetic */ Content copy$default(Content content, String str, String str2, boolean z, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.firstPassword;
                }
                if ((i & 2) != 0) {
                    str2 = content.secondPassword;
                }
                String str3 = str2;
                if ((i & 4) != 0) {
                    z = content.isValidLetters;
                }
                boolean z4 = z;
                if ((i & 8) != 0) {
                    z2 = content.isValidLength;
                }
                boolean z5 = z2;
                if ((i & 16) != 0) {
                    z3 = content.isValidNumbersContains;
                }
                return content.copy(str, str3, z4, z5, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final String getFirstPassword() {
                return this.firstPassword;
            }

            /* renamed from: component2, reason: from getter */
            public final String getSecondPassword() {
                return this.secondPassword;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsValidLetters() {
                return this.isValidLetters;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsValidLength() {
                return this.isValidLength;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsValidNumbersContains() {
                return this.isValidNumbersContains;
            }

            public final Content copy(String firstPassword, String secondPassword, boolean isValidLetters, boolean isValidLength, boolean isValidNumbersContains) {
                Intrinsics.checkNotNullParameter(firstPassword, "firstPassword");
                Intrinsics.checkNotNullParameter(secondPassword, "secondPassword");
                return new Content(firstPassword, secondPassword, isValidLetters, isValidLength, isValidNumbersContains);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.firstPassword, content.firstPassword) && Intrinsics.areEqual(this.secondPassword, content.secondPassword) && this.isValidLetters == content.isValidLetters && this.isValidLength == content.isValidLength && this.isValidNumbersContains == content.isValidNumbersContains;
            }

            public final String getFirstPassword() {
                return this.firstPassword;
            }

            public final String getSecondPassword() {
                return this.secondPassword;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isValidNumbersContains) + b.a(this.isValidLength, b.a(this.isValidLetters, a.a(this.secondPassword, this.firstPassword.hashCode() * 31, 31), 31), 31);
            }

            public final boolean isValidLength() {
                return this.isValidLength;
            }

            public final boolean isValidLetters() {
                return this.isValidLetters;
            }

            public final boolean isValidNumbersContains() {
                return this.isValidNumbersContains;
            }

            public String toString() {
                return "Content(firstPassword=" + this.firstPassword + ", secondPassword=" + this.secondPassword + ", isValidLetters=" + this.isValidLetters + ", isValidLength=" + this.isValidLength + ", isValidNumbersContains=" + this.isValidNumbersContains + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(String firstPassword, String secondPassword, boolean z, boolean z2, boolean z3) {
                super(null);
                Intrinsics.checkNotNullParameter(firstPassword, "firstPassword");
                Intrinsics.checkNotNullParameter(secondPassword, "secondPassword");
                this.firstPassword = firstPassword;
                this.secondPassword = secondPassword;
                this.isValidLetters = z;
                this.isValidLength = z2;
                this.isValidNumbersContains = z3;
            }

            public /* synthetic */ Content(String str, String str2, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Progress;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;", "firstPassword", "", "secondPassword", "(Ljava/lang/String;Ljava/lang/String;)V", "getFirstPassword", "()Ljava/lang/String;", "getSecondPassword", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Progress extends State {
            private final String firstPassword;
            private final String secondPassword;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Progress(String firstPassword, String secondPassword) {
                super(null);
                Intrinsics.checkNotNullParameter(firstPassword, "firstPassword");
                Intrinsics.checkNotNullParameter(secondPassword, "secondPassword");
                this.firstPassword = firstPassword;
                this.secondPassword = secondPassword;
            }

            public static /* synthetic */ Progress copy$default(Progress progress, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = progress.firstPassword;
                }
                if ((i & 2) != 0) {
                    str2 = progress.secondPassword;
                }
                return progress.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getFirstPassword() {
                return this.firstPassword;
            }

            /* renamed from: component2, reason: from getter */
            public final String getSecondPassword() {
                return this.secondPassword;
            }

            public final Progress copy(String firstPassword, String secondPassword) {
                Intrinsics.checkNotNullParameter(firstPassword, "firstPassword");
                Intrinsics.checkNotNullParameter(secondPassword, "secondPassword");
                return new Progress(firstPassword, secondPassword);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Progress)) {
                    return false;
                }
                Progress progress = (Progress) other;
                return Intrinsics.areEqual(this.firstPassword, progress.firstPassword) && Intrinsics.areEqual(this.secondPassword, progress.secondPassword);
            }

            public final String getFirstPassword() {
                return this.firstPassword;
            }

            public final String getSecondPassword() {
                return this.secondPassword;
            }

            public int hashCode() {
                return this.secondPassword.hashCode() + (this.firstPassword.hashCode() * 31);
            }

            public String toString() {
                return "Progress(firstPassword=" + this.firstPassword + ", secondPassword=" + this.secondPassword + ")";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private PasswordCreate() {
    }
}
