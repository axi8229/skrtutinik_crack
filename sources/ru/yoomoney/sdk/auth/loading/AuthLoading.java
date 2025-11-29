package ru.yoomoney.sdk.auth.loading;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.PhoneIdentifier;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterOauthCode;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading;", "", "()V", "Action", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthLoading {
    public static final AuthLoading INSTANCE = new AuthLoading();

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0012\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0012\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&¨\u0006'"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "", "()V", "EnrollmentSetPhoneSuccess", "EnrollmentSuccess", "EnterIdentifierSuccess", "ExecuteEnrollmentSetPhone", "ExecuteEnterIdentifier", "ExecuteRegistrationSetPhone", "Fail", "Finish", "HandleEsiaResponse", "HandleSberIdResponse", "HandleVkIdResponse", "Load", "LoginDefault", "LoginSocialAccount", "LoginSuccess", "MigrationSuccess", "RegistrationSetPhoneSuccess", "RegistrationSuccess", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$EnrollmentSetPhoneSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$EnrollmentSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$EnterIdentifierSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$ExecuteEnrollmentSetPhone;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$ExecuteEnterIdentifier;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$ExecuteRegistrationSetPhone;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$Fail;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$Finish;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$HandleEsiaResponse;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$HandleSberIdResponse;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$HandleVkIdResponse;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$Load;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginDefault;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginSocialAccount;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$MigrationSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$RegistrationSetPhoneSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$RegistrationSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$EnrollmentSetPhoneSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "(Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class EnrollmentSetPhoneSuccess extends Action {
            private final EnrollmentProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnrollmentSetPhoneSuccess(EnrollmentProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ EnrollmentSetPhoneSuccess copy$default(EnrollmentSetPhoneSuccess enrollmentSetPhoneSuccess, EnrollmentProcess enrollmentProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    enrollmentProcess = enrollmentSetPhoneSuccess.process;
                }
                return enrollmentSetPhoneSuccess.copy(enrollmentProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final EnrollmentProcess getProcess() {
                return this.process;
            }

            public final EnrollmentSetPhoneSuccess copy(EnrollmentProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new EnrollmentSetPhoneSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EnrollmentSetPhoneSuccess) && Intrinsics.areEqual(this.process, ((EnrollmentSetPhoneSuccess) other).process);
            }

            public final EnrollmentProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "EnrollmentSetPhoneSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$EnrollmentSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "(Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class EnrollmentSuccess extends Action {
            private final EnrollmentProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnrollmentSuccess(EnrollmentProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ EnrollmentSuccess copy$default(EnrollmentSuccess enrollmentSuccess, EnrollmentProcess enrollmentProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    enrollmentProcess = enrollmentSuccess.process;
                }
                return enrollmentSuccess.copy(enrollmentProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final EnrollmentProcess getProcess() {
                return this.process;
            }

            public final EnrollmentSuccess copy(EnrollmentProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new EnrollmentSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EnrollmentSuccess) && Intrinsics.areEqual(this.process, ((EnrollmentSuccess) other).process);
            }

            public final EnrollmentProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "EnrollmentSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$EnterIdentifierSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class EnterIdentifierSuccess extends Action {
            private final LoginProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnterIdentifierSuccess(LoginProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ EnterIdentifierSuccess copy$default(EnterIdentifierSuccess enterIdentifierSuccess, LoginProcess loginProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcess = enterIdentifierSuccess.process;
                }
                return enterIdentifierSuccess.copy(loginProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcess getProcess() {
                return this.process;
            }

            public final EnterIdentifierSuccess copy(LoginProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new EnterIdentifierSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EnterIdentifierSuccess) && Intrinsics.areEqual(this.process, ((EnterIdentifierSuccess) other).process);
            }

            public final LoginProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "EnterIdentifierSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$ExecuteEnrollmentSetPhone;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "phoneIdentifier", "Lru/yoomoney/sdk/auth/PhoneIdentifier;", "process", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "(Lru/yoomoney/sdk/auth/PhoneIdentifier;Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;)V", "getPhoneIdentifier", "()Lru/yoomoney/sdk/auth/PhoneIdentifier;", "getProcess", "()Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ExecuteEnrollmentSetPhone extends Action {
            private final PhoneIdentifier phoneIdentifier;
            private final EnrollmentProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExecuteEnrollmentSetPhone(PhoneIdentifier phoneIdentifier, EnrollmentProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(phoneIdentifier, "phoneIdentifier");
                Intrinsics.checkNotNullParameter(process, "process");
                this.phoneIdentifier = phoneIdentifier;
                this.process = process;
            }

            public static /* synthetic */ ExecuteEnrollmentSetPhone copy$default(ExecuteEnrollmentSetPhone executeEnrollmentSetPhone, PhoneIdentifier phoneIdentifier, EnrollmentProcess enrollmentProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    phoneIdentifier = executeEnrollmentSetPhone.phoneIdentifier;
                }
                if ((i & 2) != 0) {
                    enrollmentProcess = executeEnrollmentSetPhone.process;
                }
                return executeEnrollmentSetPhone.copy(phoneIdentifier, enrollmentProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final PhoneIdentifier getPhoneIdentifier() {
                return this.phoneIdentifier;
            }

            /* renamed from: component2, reason: from getter */
            public final EnrollmentProcess getProcess() {
                return this.process;
            }

            public final ExecuteEnrollmentSetPhone copy(PhoneIdentifier phoneIdentifier, EnrollmentProcess process) {
                Intrinsics.checkNotNullParameter(phoneIdentifier, "phoneIdentifier");
                Intrinsics.checkNotNullParameter(process, "process");
                return new ExecuteEnrollmentSetPhone(phoneIdentifier, process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExecuteEnrollmentSetPhone)) {
                    return false;
                }
                ExecuteEnrollmentSetPhone executeEnrollmentSetPhone = (ExecuteEnrollmentSetPhone) other;
                return Intrinsics.areEqual(this.phoneIdentifier, executeEnrollmentSetPhone.phoneIdentifier) && Intrinsics.areEqual(this.process, executeEnrollmentSetPhone.process);
            }

            public final PhoneIdentifier getPhoneIdentifier() {
                return this.phoneIdentifier;
            }

            public final EnrollmentProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode() + (this.phoneIdentifier.hashCode() * 31);
            }

            public String toString() {
                return "ExecuteEnrollmentSetPhone(phoneIdentifier=" + this.phoneIdentifier + ", process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$ExecuteEnterIdentifier;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "phoneIdentifier", "Lru/yoomoney/sdk/auth/PhoneIdentifier;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "(Lru/yoomoney/sdk/auth/PhoneIdentifier;Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;)V", "getPhoneIdentifier", "()Lru/yoomoney/sdk/auth/PhoneIdentifier;", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ExecuteEnterIdentifier extends Action {
            private final PhoneIdentifier phoneIdentifier;
            private final LoginProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExecuteEnterIdentifier(PhoneIdentifier phoneIdentifier, LoginProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(phoneIdentifier, "phoneIdentifier");
                Intrinsics.checkNotNullParameter(process, "process");
                this.phoneIdentifier = phoneIdentifier;
                this.process = process;
            }

            public static /* synthetic */ ExecuteEnterIdentifier copy$default(ExecuteEnterIdentifier executeEnterIdentifier, PhoneIdentifier phoneIdentifier, LoginProcess loginProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    phoneIdentifier = executeEnterIdentifier.phoneIdentifier;
                }
                if ((i & 2) != 0) {
                    loginProcess = executeEnterIdentifier.process;
                }
                return executeEnterIdentifier.copy(phoneIdentifier, loginProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final PhoneIdentifier getPhoneIdentifier() {
                return this.phoneIdentifier;
            }

            /* renamed from: component2, reason: from getter */
            public final LoginProcess getProcess() {
                return this.process;
            }

            public final ExecuteEnterIdentifier copy(PhoneIdentifier phoneIdentifier, LoginProcess process) {
                Intrinsics.checkNotNullParameter(phoneIdentifier, "phoneIdentifier");
                Intrinsics.checkNotNullParameter(process, "process");
                return new ExecuteEnterIdentifier(phoneIdentifier, process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExecuteEnterIdentifier)) {
                    return false;
                }
                ExecuteEnterIdentifier executeEnterIdentifier = (ExecuteEnterIdentifier) other;
                return Intrinsics.areEqual(this.phoneIdentifier, executeEnterIdentifier.phoneIdentifier) && Intrinsics.areEqual(this.process, executeEnterIdentifier.process);
            }

            public final PhoneIdentifier getPhoneIdentifier() {
                return this.phoneIdentifier;
            }

            public final LoginProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode() + (this.phoneIdentifier.hashCode() * 31);
            }

            public String toString() {
                return "ExecuteEnterIdentifier(phoneIdentifier=" + this.phoneIdentifier + ", process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$ExecuteRegistrationSetPhone;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "phoneIdentifier", "Lru/yoomoney/sdk/auth/PhoneIdentifier;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/PhoneIdentifier;Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getPhoneIdentifier", "()Lru/yoomoney/sdk/auth/PhoneIdentifier;", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ExecuteRegistrationSetPhone extends Action {
            private final PhoneIdentifier phoneIdentifier;
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExecuteRegistrationSetPhone(PhoneIdentifier phoneIdentifier, RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(phoneIdentifier, "phoneIdentifier");
                Intrinsics.checkNotNullParameter(process, "process");
                this.phoneIdentifier = phoneIdentifier;
                this.process = process;
            }

            public static /* synthetic */ ExecuteRegistrationSetPhone copy$default(ExecuteRegistrationSetPhone executeRegistrationSetPhone, PhoneIdentifier phoneIdentifier, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    phoneIdentifier = executeRegistrationSetPhone.phoneIdentifier;
                }
                if ((i & 2) != 0) {
                    registrationProcess = executeRegistrationSetPhone.process;
                }
                return executeRegistrationSetPhone.copy(phoneIdentifier, registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final PhoneIdentifier getPhoneIdentifier() {
                return this.phoneIdentifier;
            }

            /* renamed from: component2, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final ExecuteRegistrationSetPhone copy(PhoneIdentifier phoneIdentifier, RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(phoneIdentifier, "phoneIdentifier");
                Intrinsics.checkNotNullParameter(process, "process");
                return new ExecuteRegistrationSetPhone(phoneIdentifier, process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExecuteRegistrationSetPhone)) {
                    return false;
                }
                ExecuteRegistrationSetPhone executeRegistrationSetPhone = (ExecuteRegistrationSetPhone) other;
                return Intrinsics.areEqual(this.phoneIdentifier, executeRegistrationSetPhone.phoneIdentifier) && Intrinsics.areEqual(this.process, executeRegistrationSetPhone.process);
            }

            public final PhoneIdentifier getPhoneIdentifier() {
                return this.phoneIdentifier;
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode() + (this.phoneIdentifier.hashCode() * 31);
            }

            public String toString() {
                return "ExecuteRegistrationSetPhone(phoneIdentifier=" + this.phoneIdentifier + ", process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$Fail;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Fail extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Fail(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ Fail copy$default(Fail fail, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = fail.failure;
                }
                return fail.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final Fail copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Fail(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Fail) && Intrinsics.areEqual(this.failure, ((Fail) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Fail(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$Finish;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Finish extends Action {
            public static final Finish INSTANCE = new Finish();

            private Finish() {
                super(null);
            }

            public String toString() {
                String simpleName = Finish.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$HandleEsiaResponse;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "uri", "Landroid/net/Uri;", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;Landroid/net/Uri;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class HandleEsiaResponse extends Action {
            private final LoginProcessEnterOauthCode process;
            private final Uri uri;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandleEsiaResponse(LoginProcessEnterOauthCode process, Uri uri) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.process = process;
                this.uri = uri;
            }

            public static /* synthetic */ HandleEsiaResponse copy$default(HandleEsiaResponse handleEsiaResponse, LoginProcessEnterOauthCode loginProcessEnterOauthCode, Uri uri, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcessEnterOauthCode = handleEsiaResponse.process;
                }
                if ((i & 2) != 0) {
                    uri = handleEsiaResponse.uri;
                }
                return handleEsiaResponse.copy(loginProcessEnterOauthCode, uri);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            /* renamed from: component2, reason: from getter */
            public final Uri getUri() {
                return this.uri;
            }

            public final HandleEsiaResponse copy(LoginProcessEnterOauthCode process, Uri uri) {
                Intrinsics.checkNotNullParameter(process, "process");
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new HandleEsiaResponse(process, uri);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandleEsiaResponse)) {
                    return false;
                }
                HandleEsiaResponse handleEsiaResponse = (HandleEsiaResponse) other;
                return Intrinsics.areEqual(this.process, handleEsiaResponse.process) && Intrinsics.areEqual(this.uri, handleEsiaResponse.uri);
            }

            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            public final Uri getUri() {
                return this.uri;
            }

            public int hashCode() {
                return this.uri.hashCode() + (this.process.hashCode() * 31);
            }

            public String toString() {
                return "HandleEsiaResponse(process=" + this.process + ", uri=" + this.uri + ")";
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$HandleSberIdResponse;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "uri", "Landroid/net/Uri;", "returnUrl", "", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;Landroid/net/Uri;Ljava/lang/String;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "getReturnUrl", "()Ljava/lang/String;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class HandleSberIdResponse extends Action {
            private final LoginProcessEnterOauthCode process;
            private final String returnUrl;
            private final Uri uri;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandleSberIdResponse(LoginProcessEnterOauthCode process, Uri uri, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.process = process;
                this.uri = uri;
                this.returnUrl = str;
            }

            public static /* synthetic */ HandleSberIdResponse copy$default(HandleSberIdResponse handleSberIdResponse, LoginProcessEnterOauthCode loginProcessEnterOauthCode, Uri uri, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcessEnterOauthCode = handleSberIdResponse.process;
                }
                if ((i & 2) != 0) {
                    uri = handleSberIdResponse.uri;
                }
                if ((i & 4) != 0) {
                    str = handleSberIdResponse.returnUrl;
                }
                return handleSberIdResponse.copy(loginProcessEnterOauthCode, uri, str);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            /* renamed from: component2, reason: from getter */
            public final Uri getUri() {
                return this.uri;
            }

            /* renamed from: component3, reason: from getter */
            public final String getReturnUrl() {
                return this.returnUrl;
            }

            public final HandleSberIdResponse copy(LoginProcessEnterOauthCode process, Uri uri, String returnUrl) {
                Intrinsics.checkNotNullParameter(process, "process");
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new HandleSberIdResponse(process, uri, returnUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandleSberIdResponse)) {
                    return false;
                }
                HandleSberIdResponse handleSberIdResponse = (HandleSberIdResponse) other;
                return Intrinsics.areEqual(this.process, handleSberIdResponse.process) && Intrinsics.areEqual(this.uri, handleSberIdResponse.uri) && Intrinsics.areEqual(this.returnUrl, handleSberIdResponse.returnUrl);
            }

            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            public final String getReturnUrl() {
                return this.returnUrl;
            }

            public final Uri getUri() {
                return this.uri;
            }

            public int hashCode() {
                int iHashCode = (this.uri.hashCode() + (this.process.hashCode() * 31)) * 31;
                String str = this.returnUrl;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "HandleSberIdResponse(process=" + this.process + ", uri=" + this.uri + ", returnUrl=" + this.returnUrl + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$HandleVkIdResponse;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "token", "", "uuid", "redirectUrl", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "getRedirectUrl", "()Ljava/lang/String;", "getToken", "getUuid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class HandleVkIdResponse extends Action {
            private final LoginProcessEnterOauthCode process;
            private final String redirectUrl;
            private final String token;
            private final String uuid;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandleVkIdResponse(LoginProcessEnterOauthCode process, String str, String str2, String str3) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
                this.token = str;
                this.uuid = str2;
                this.redirectUrl = str3;
            }

            public static /* synthetic */ HandleVkIdResponse copy$default(HandleVkIdResponse handleVkIdResponse, LoginProcessEnterOauthCode loginProcessEnterOauthCode, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcessEnterOauthCode = handleVkIdResponse.process;
                }
                if ((i & 2) != 0) {
                    str = handleVkIdResponse.token;
                }
                if ((i & 4) != 0) {
                    str2 = handleVkIdResponse.uuid;
                }
                if ((i & 8) != 0) {
                    str3 = handleVkIdResponse.redirectUrl;
                }
                return handleVkIdResponse.copy(loginProcessEnterOauthCode, str, str2, str3);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            /* renamed from: component2, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            /* renamed from: component3, reason: from getter */
            public final String getUuid() {
                return this.uuid;
            }

            /* renamed from: component4, reason: from getter */
            public final String getRedirectUrl() {
                return this.redirectUrl;
            }

            public final HandleVkIdResponse copy(LoginProcessEnterOauthCode process, String token, String uuid, String redirectUrl) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new HandleVkIdResponse(process, token, uuid, redirectUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HandleVkIdResponse)) {
                    return false;
                }
                HandleVkIdResponse handleVkIdResponse = (HandleVkIdResponse) other;
                return Intrinsics.areEqual(this.process, handleVkIdResponse.process) && Intrinsics.areEqual(this.token, handleVkIdResponse.token) && Intrinsics.areEqual(this.uuid, handleVkIdResponse.uuid) && Intrinsics.areEqual(this.redirectUrl, handleVkIdResponse.redirectUrl);
            }

            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            public final String getRedirectUrl() {
                return this.redirectUrl;
            }

            public final String getToken() {
                return this.token;
            }

            public final String getUuid() {
                return this.uuid;
            }

            public int hashCode() {
                int iHashCode = this.process.hashCode() * 31;
                String str = this.token;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.uuid;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.redirectUrl;
                return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "HandleVkIdResponse(process=" + this.process + ", token=" + this.token + ", uuid=" + this.uuid + ", redirectUrl=" + this.redirectUrl + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$Load;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "isForcedRegistration", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Load extends Action {
            private final boolean isForcedRegistration;

            public Load() {
                this(false, 1, null);
            }

            public static /* synthetic */ Load copy$default(Load load, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = load.isForcedRegistration;
                }
                return load.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsForcedRegistration() {
                return this.isForcedRegistration;
            }

            public final Load copy(boolean isForcedRegistration) {
                return new Load(isForcedRegistration);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Load) && this.isForcedRegistration == ((Load) other).isForcedRegistration;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isForcedRegistration);
            }

            public final boolean isForcedRegistration() {
                return this.isForcedRegistration;
            }

            public String toString() {
                return "Load(isForcedRegistration=" + this.isForcedRegistration + ")";
            }

            public Load(boolean z) {
                super(null);
                this.isForcedRegistration = z;
            }

            public /* synthetic */ Load(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginDefault;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "isForceLogin", "", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;Z)V", "()Z", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoginDefault extends Action {
            private final boolean isForceLogin;
            private final LoginProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoginDefault(LoginProcess process, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
                this.isForceLogin = z;
            }

            public static /* synthetic */ LoginDefault copy$default(LoginDefault loginDefault, LoginProcess loginProcess, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcess = loginDefault.process;
                }
                if ((i & 2) != 0) {
                    z = loginDefault.isForceLogin;
                }
                return loginDefault.copy(loginProcess, z);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcess getProcess() {
                return this.process;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsForceLogin() {
                return this.isForceLogin;
            }

            public final LoginDefault copy(LoginProcess process, boolean isForceLogin) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new LoginDefault(process, isForceLogin);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoginDefault)) {
                    return false;
                }
                LoginDefault loginDefault = (LoginDefault) other;
                return Intrinsics.areEqual(this.process, loginDefault.process) && this.isForceLogin == loginDefault.isForceLogin;
            }

            public final LoginProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isForceLogin) + (this.process.hashCode() * 31);
            }

            public final boolean isForceLogin() {
                return this.isForceLogin;
            }

            public String toString() {
                return "LoginDefault(process=" + this.process + ", isForceLogin=" + this.isForceLogin + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginSocialAccount;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoginSocialAccount extends Action {
            private final LoginProcessEnterOauthCode process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoginSocialAccount(LoginProcessEnterOauthCode process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ LoginSocialAccount copy$default(LoginSocialAccount loginSocialAccount, LoginProcessEnterOauthCode loginProcessEnterOauthCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcessEnterOauthCode = loginSocialAccount.process;
                }
                return loginSocialAccount.copy(loginProcessEnterOauthCode);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            public final LoginSocialAccount copy(LoginProcessEnterOauthCode process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new LoginSocialAccount(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoginSocialAccount) && Intrinsics.areEqual(this.process, ((LoginSocialAccount) other).process);
            }

            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "LoginSocialAccount(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "isForceLogin", "", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;Z)V", "()Z", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoginSuccess extends Action {
            private final boolean isForceLogin;
            private final LoginProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoginSuccess(LoginProcess process, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
                this.isForceLogin = z;
            }

            public static /* synthetic */ LoginSuccess copy$default(LoginSuccess loginSuccess, LoginProcess loginProcess, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcess = loginSuccess.process;
                }
                if ((i & 2) != 0) {
                    z = loginSuccess.isForceLogin;
                }
                return loginSuccess.copy(loginProcess, z);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcess getProcess() {
                return this.process;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsForceLogin() {
                return this.isForceLogin;
            }

            public final LoginSuccess copy(LoginProcess process, boolean isForceLogin) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new LoginSuccess(process, isForceLogin);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoginSuccess)) {
                    return false;
                }
                LoginSuccess loginSuccess = (LoginSuccess) other;
                return Intrinsics.areEqual(this.process, loginSuccess.process) && this.isForceLogin == loginSuccess.isForceLogin;
            }

            public final LoginProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isForceLogin) + (this.process.hashCode() * 31);
            }

            public final boolean isForceLogin() {
                return this.isForceLogin;
            }

            public String toString() {
                return "LoginSuccess(process=" + this.process + ", isForceLogin=" + this.isForceLogin + ")";
            }

            public /* synthetic */ LoginSuccess(LoginProcess loginProcess, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(loginProcess, (i & 2) != 0 ? false : z);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$MigrationSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "(Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class MigrationSuccess extends Action {
            private final MigrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MigrationSuccess(MigrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ MigrationSuccess copy$default(MigrationSuccess migrationSuccess, MigrationProcess migrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    migrationProcess = migrationSuccess.process;
                }
                return migrationSuccess.copy(migrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final MigrationProcess getProcess() {
                return this.process;
            }

            public final MigrationSuccess copy(MigrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new MigrationSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MigrationSuccess) && Intrinsics.areEqual(this.process, ((MigrationSuccess) other).process);
            }

            public final MigrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "MigrationSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$RegistrationSetPhoneSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RegistrationSetPhoneSuccess extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RegistrationSetPhoneSuccess(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ RegistrationSetPhoneSuccess copy$default(RegistrationSetPhoneSuccess registrationSetPhoneSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = registrationSetPhoneSuccess.process;
                }
                return registrationSetPhoneSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final RegistrationSetPhoneSuccess copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new RegistrationSetPhoneSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RegistrationSetPhoneSuccess) && Intrinsics.areEqual(this.process, ((RegistrationSetPhoneSuccess) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "RegistrationSetPhoneSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$RegistrationSuccess;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RegistrationSuccess extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RegistrationSuccess(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ RegistrationSuccess copy$default(RegistrationSuccess registrationSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = registrationSuccess.process;
                }
                return registrationSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final RegistrationSuccess copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new RegistrationSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RegistrationSuccess) && Intrinsics.areEqual(this.process, ((RegistrationSuccess) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "RegistrationSuccess(process=" + this.process + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;", "", "()V", "Close", "ShowEnrollment", "ShowLogin", "ShowMigration", "ShowRegistration", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$Close;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$ShowEnrollment;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$ShowLogin;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$ShowMigration;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$ShowRegistration;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$Close;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Close extends Effect {
            public static final Close INSTANCE = new Close();

            private Close() {
                super(null);
            }

            public String toString() {
                String simpleName = Close.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$ShowEnrollment;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;", "process", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "(Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowEnrollment extends Effect {
            private final EnrollmentProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowEnrollment(EnrollmentProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowEnrollment copy$default(ShowEnrollment showEnrollment, EnrollmentProcess enrollmentProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    enrollmentProcess = showEnrollment.process;
                }
                return showEnrollment.copy(enrollmentProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final EnrollmentProcess getProcess() {
                return this.process;
            }

            public final ShowEnrollment copy(EnrollmentProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowEnrollment(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowEnrollment) && Intrinsics.areEqual(this.process, ((ShowEnrollment) other).process);
            }

            public final EnrollmentProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowEnrollment(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$ShowLogin;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "isForceLogin", "", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;Z)V", "()Z", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowLogin extends Effect {
            private final boolean isForceLogin;
            private final LoginProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowLogin(LoginProcess process, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
                this.isForceLogin = z;
            }

            public static /* synthetic */ ShowLogin copy$default(ShowLogin showLogin, LoginProcess loginProcess, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcess = showLogin.process;
                }
                if ((i & 2) != 0) {
                    z = showLogin.isForceLogin;
                }
                return showLogin.copy(loginProcess, z);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcess getProcess() {
                return this.process;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsForceLogin() {
                return this.isForceLogin;
            }

            public final ShowLogin copy(LoginProcess process, boolean isForceLogin) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowLogin(process, isForceLogin);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowLogin)) {
                    return false;
                }
                ShowLogin showLogin = (ShowLogin) other;
                return Intrinsics.areEqual(this.process, showLogin.process) && this.isForceLogin == showLogin.isForceLogin;
            }

            public final LoginProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isForceLogin) + (this.process.hashCode() * 31);
            }

            public final boolean isForceLogin() {
                return this.isForceLogin;
            }

            public String toString() {
                return "ShowLogin(process=" + this.process + ", isForceLogin=" + this.isForceLogin + ")";
            }

            public /* synthetic */ ShowLogin(LoginProcess loginProcess, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(loginProcess, (i & 2) != 0 ? false : z);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$ShowMigration;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;", "process", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "(Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowMigration extends Effect {
            private final MigrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowMigration(MigrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowMigration copy$default(ShowMigration showMigration, MigrationProcess migrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    migrationProcess = showMigration.process;
                }
                return showMigration.copy(migrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final MigrationProcess getProcess() {
                return this.process;
            }

            public final ShowMigration copy(MigrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowMigration(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowMigration) && Intrinsics.areEqual(this.process, ((ShowMigration) other).process);
            }

            public final MigrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowMigration(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect$ShowRegistration;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowRegistration extends Effect {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowRegistration(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowRegistration copy$default(ShowRegistration showRegistration, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = showRegistration.process;
                }
                return showRegistration.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final ShowRegistration copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowRegistration(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowRegistration) && Intrinsics.areEqual(this.process, ((ShowRegistration) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowRegistration(process=" + this.process + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$State;", "", "()V", "Error", "Progress", "SocialAccountAuth", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State$Error;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State$Progress;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State$SocialAccountAuth;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$State$Error;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Error extends State {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ Error copy$default(Error error, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = error.failure;
                }
                return error.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final Error copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Error(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.failure, ((Error) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Error(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$State$Progress;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Progress extends State {
            public static final Progress INSTANCE = new Progress();

            private Progress() {
                super(null);
            }

            public String toString() {
                String simpleName = Progress.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoading$State$SocialAccountAuth;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State;", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "(Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SocialAccountAuth extends State {
            private final LoginProcessEnterOauthCode process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SocialAccountAuth(LoginProcessEnterOauthCode process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ SocialAccountAuth copy$default(SocialAccountAuth socialAccountAuth, LoginProcessEnterOauthCode loginProcessEnterOauthCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    loginProcessEnterOauthCode = socialAccountAuth.process;
                }
                return socialAccountAuth.copy(loginProcessEnterOauthCode);
            }

            /* renamed from: component1, reason: from getter */
            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            public final SocialAccountAuth copy(LoginProcessEnterOauthCode process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new SocialAccountAuth(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SocialAccountAuth) && Intrinsics.areEqual(this.process, ((SocialAccountAuth) other).process);
            }

            public final LoginProcessEnterOauthCode getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "SocialAccountAuth(process=" + this.process + ")";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private AuthLoading() {
    }
}
