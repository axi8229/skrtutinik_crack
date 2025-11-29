package ru.yoomoney.sdk.auth.api.registrationV2.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.api.model.RegistrationProcessError;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\t\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\b\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "", "step", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Step;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Step;)V", "addToBackStack", "", "getAddToBackStack", "()Z", "id", "", "getId", "()Ljava/lang/String;", "getStep", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Step;", "AcquireAuthorization", "Failure", "Require2faEmail", "Require2faPhone", "SetEmail", "SetPassword", "SetPhone", "Step", "Success", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$AcquireAuthorization;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Failure;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Require2faEmail;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Require2faPhone;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$SetEmail;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$SetPassword;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$SetPhone;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Success;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RegistrationProcess {
    private final Step step;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$AcquireAuthorization;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "id", "", "addToBackStack", "", "(Ljava/lang/String;Z)V", "getAddToBackStack", "()Z", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AcquireAuthorization extends RegistrationProcess {
        private final boolean addToBackStack;
        private final String id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AcquireAuthorization(String id, boolean z) {
            super(Step.ACQUIRE_AUTHORIZATION, null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.addToBackStack = z;
        }

        public static /* synthetic */ AcquireAuthorization copy$default(AcquireAuthorization acquireAuthorization, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = acquireAuthorization.id;
            }
            if ((i & 2) != 0) {
                z = acquireAuthorization.addToBackStack;
            }
            return acquireAuthorization.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        public final AcquireAuthorization copy(String id, boolean addToBackStack) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new AcquireAuthorization(id, addToBackStack);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AcquireAuthorization)) {
                return false;
            }
            AcquireAuthorization acquireAuthorization = (AcquireAuthorization) other;
            return Intrinsics.areEqual(this.id, acquireAuthorization.id) && this.addToBackStack == acquireAuthorization.addToBackStack;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            return Boolean.hashCode(this.addToBackStack) + (this.id.hashCode() * 31);
        }

        public String toString() {
            return "AcquireAuthorization(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Failure;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "id", "", "addToBackStack", "", "error", "Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "(Ljava/lang/String;ZLru/yoomoney/sdk/auth/api/model/RegistrationProcessError;)V", "getAddToBackStack", "()Z", "getError", "()Lru/yoomoney/sdk/auth/api/model/RegistrationProcessError;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Failure extends RegistrationProcess {
        private final boolean addToBackStack;
        private final RegistrationProcessError error;
        private final String id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String id, boolean z, RegistrationProcessError error) {
            super(Step.FAILURE, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(error, "error");
            this.id = id;
            this.addToBackStack = z;
            this.error = error;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, String str, boolean z, RegistrationProcessError registrationProcessError, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.id;
            }
            if ((i & 2) != 0) {
                z = failure.addToBackStack;
            }
            if ((i & 4) != 0) {
                registrationProcessError = failure.error;
            }
            return failure.copy(str, z, registrationProcessError);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        /* renamed from: component3, reason: from getter */
        public final RegistrationProcessError getError() {
            return this.error;
        }

        public final Failure copy(String id, boolean addToBackStack, RegistrationProcessError error) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(error, "error");
            return new Failure(id, addToBackStack, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return Intrinsics.areEqual(this.id, failure.id) && this.addToBackStack == failure.addToBackStack && Intrinsics.areEqual(this.error, failure.error);
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        public final RegistrationProcessError getError() {
            return this.error;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            return this.error.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31);
        }

        public String toString() {
            return "Failure(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", error=" + this.error + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Require2faEmail;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "id", "", "addToBackStack", "", "authProcessId", "(Ljava/lang/String;ZLjava/lang/String;)V", "getAddToBackStack", "()Z", "getAuthProcessId", "()Ljava/lang/String;", "getId", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Require2faEmail extends RegistrationProcess {
        private final boolean addToBackStack;
        private final String authProcessId;
        private final String id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Require2faEmail(String id, boolean z, String authProcessId) {
            super(Step.REQUIRE_2FA_EMAIL, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
            this.id = id;
            this.addToBackStack = z;
            this.authProcessId = authProcessId;
        }

        public static /* synthetic */ Require2faEmail copy$default(Require2faEmail require2faEmail, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = require2faEmail.id;
            }
            if ((i & 2) != 0) {
                z = require2faEmail.addToBackStack;
            }
            if ((i & 4) != 0) {
                str2 = require2faEmail.authProcessId;
            }
            return require2faEmail.copy(str, z, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAuthProcessId() {
            return this.authProcessId;
        }

        public final Require2faEmail copy(String id, boolean addToBackStack, String authProcessId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
            return new Require2faEmail(id, addToBackStack, authProcessId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Require2faEmail)) {
                return false;
            }
            Require2faEmail require2faEmail = (Require2faEmail) other;
            return Intrinsics.areEqual(this.id, require2faEmail.id) && this.addToBackStack == require2faEmail.addToBackStack && Intrinsics.areEqual(this.authProcessId, require2faEmail.authProcessId);
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        public final String getAuthProcessId() {
            return this.authProcessId;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            return this.authProcessId.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31);
        }

        public String toString() {
            return "Require2faEmail(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", authProcessId=" + this.authProcessId + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Require2faPhone;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "id", "", "addToBackStack", "", "authProcessId", "(Ljava/lang/String;ZLjava/lang/String;)V", "getAddToBackStack", "()Z", "getAuthProcessId", "()Ljava/lang/String;", "getId", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Require2faPhone extends RegistrationProcess {
        private final boolean addToBackStack;
        private final String authProcessId;
        private final String id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Require2faPhone(String id, boolean z, String authProcessId) {
            super(Step.REQUIRE_2FA_PHONE, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
            this.id = id;
            this.addToBackStack = z;
            this.authProcessId = authProcessId;
        }

        public static /* synthetic */ Require2faPhone copy$default(Require2faPhone require2faPhone, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = require2faPhone.id;
            }
            if ((i & 2) != 0) {
                z = require2faPhone.addToBackStack;
            }
            if ((i & 4) != 0) {
                str2 = require2faPhone.authProcessId;
            }
            return require2faPhone.copy(str, z, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAuthProcessId() {
            return this.authProcessId;
        }

        public final Require2faPhone copy(String id, boolean addToBackStack, String authProcessId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(authProcessId, "authProcessId");
            return new Require2faPhone(id, addToBackStack, authProcessId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Require2faPhone)) {
                return false;
            }
            Require2faPhone require2faPhone = (Require2faPhone) other;
            return Intrinsics.areEqual(this.id, require2faPhone.id) && this.addToBackStack == require2faPhone.addToBackStack && Intrinsics.areEqual(this.authProcessId, require2faPhone.authProcessId);
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        public final String getAuthProcessId() {
            return this.authProcessId;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            return this.authProcessId.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31);
        }

        public String toString() {
            return "Require2faPhone(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", authProcessId=" + this.authProcessId + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$SetEmail;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "id", "", "addToBackStack", "", "prefilledEmail", "accounts", "", "Lru/yoomoney/sdk/auth/api/model/Account;", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getAccounts", "()Ljava/util/List;", "getAddToBackStack", "()Z", "getId", "()Ljava/lang/String;", "getPrefilledEmail", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SetEmail extends RegistrationProcess {
        private final List<Account> accounts;
        private final boolean addToBackStack;
        private final String id;
        private final String prefilledEmail;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetEmail(String id, boolean z, String str, List<Account> list) {
            super(Step.SET_EMAIL, null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.addToBackStack = z;
            this.prefilledEmail = str;
            this.accounts = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SetEmail copy$default(SetEmail setEmail, String str, boolean z, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setEmail.id;
            }
            if ((i & 2) != 0) {
                z = setEmail.addToBackStack;
            }
            if ((i & 4) != 0) {
                str2 = setEmail.prefilledEmail;
            }
            if ((i & 8) != 0) {
                list = setEmail.accounts;
            }
            return setEmail.copy(str, z, str2, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPrefilledEmail() {
            return this.prefilledEmail;
        }

        public final List<Account> component4() {
            return this.accounts;
        }

        public final SetEmail copy(String id, boolean addToBackStack, String prefilledEmail, List<Account> accounts) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new SetEmail(id, addToBackStack, prefilledEmail, accounts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetEmail)) {
                return false;
            }
            SetEmail setEmail = (SetEmail) other;
            return Intrinsics.areEqual(this.id, setEmail.id) && this.addToBackStack == setEmail.addToBackStack && Intrinsics.areEqual(this.prefilledEmail, setEmail.prefilledEmail) && Intrinsics.areEqual(this.accounts, setEmail.accounts);
        }

        public final List<Account> getAccounts() {
            return this.accounts;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public String getId() {
            return this.id;
        }

        public final String getPrefilledEmail() {
            return this.prefilledEmail;
        }

        public int hashCode() {
            int iA = b.a(this.addToBackStack, this.id.hashCode() * 31, 31);
            String str = this.prefilledEmail;
            int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
            List<Account> list = this.accounts;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "SetEmail(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", prefilledEmail=" + this.prefilledEmail + ", accounts=" + this.accounts + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$SetPassword;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "id", "", "addToBackStack", "", "(Ljava/lang/String;Z)V", "getAddToBackStack", "()Z", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SetPassword extends RegistrationProcess {
        private final boolean addToBackStack;
        private final String id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetPassword(String id, boolean z) {
            super(Step.SET_PASSWORD, null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.addToBackStack = z;
        }

        public static /* synthetic */ SetPassword copy$default(SetPassword setPassword, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setPassword.id;
            }
            if ((i & 2) != 0) {
                z = setPassword.addToBackStack;
            }
            return setPassword.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        public final SetPassword copy(String id, boolean addToBackStack) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new SetPassword(id, addToBackStack);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetPassword)) {
                return false;
            }
            SetPassword setPassword = (SetPassword) other;
            return Intrinsics.areEqual(this.id, setPassword.id) && this.addToBackStack == setPassword.addToBackStack;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            return Boolean.hashCode(this.addToBackStack) + (this.id.hashCode() * 31);
        }

        public String toString() {
            return "SetPassword(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ")";
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$SetPhone;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "id", "", "addToBackStack", "", "countryCallingCodes", "", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "prefilledPhone", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/PrefilledPhone;", "(Ljava/lang/String;ZLjava/util/List;Lru/yoomoney/sdk/auth/api/registrationV2/domain/PrefilledPhone;)V", "getAddToBackStack", "()Z", "getCountryCallingCodes", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getPrefilledPhone", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/PrefilledPhone;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SetPhone extends RegistrationProcess {
        private final boolean addToBackStack;
        private final List<CountryCallingCode> countryCallingCodes;
        private final String id;
        private final PrefilledPhone prefilledPhone;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetPhone(String id, boolean z, List<CountryCallingCode> countryCallingCodes, PrefilledPhone prefilledPhone) {
            super(Step.SET_PHONE, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(countryCallingCodes, "countryCallingCodes");
            this.id = id;
            this.addToBackStack = z;
            this.countryCallingCodes = countryCallingCodes;
            this.prefilledPhone = prefilledPhone;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SetPhone copy$default(SetPhone setPhone, String str, boolean z, List list, PrefilledPhone prefilledPhone, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setPhone.id;
            }
            if ((i & 2) != 0) {
                z = setPhone.addToBackStack;
            }
            if ((i & 4) != 0) {
                list = setPhone.countryCallingCodes;
            }
            if ((i & 8) != 0) {
                prefilledPhone = setPhone.prefilledPhone;
            }
            return setPhone.copy(str, z, list, prefilledPhone);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        public final List<CountryCallingCode> component3() {
            return this.countryCallingCodes;
        }

        /* renamed from: component4, reason: from getter */
        public final PrefilledPhone getPrefilledPhone() {
            return this.prefilledPhone;
        }

        public final SetPhone copy(String id, boolean addToBackStack, List<CountryCallingCode> countryCallingCodes, PrefilledPhone prefilledPhone) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(countryCallingCodes, "countryCallingCodes");
            return new SetPhone(id, addToBackStack, countryCallingCodes, prefilledPhone);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetPhone)) {
                return false;
            }
            SetPhone setPhone = (SetPhone) other;
            return Intrinsics.areEqual(this.id, setPhone.id) && this.addToBackStack == setPhone.addToBackStack && Intrinsics.areEqual(this.countryCallingCodes, setPhone.countryCallingCodes) && Intrinsics.areEqual(this.prefilledPhone, setPhone.prefilledPhone);
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        public final List<CountryCallingCode> getCountryCallingCodes() {
            return this.countryCallingCodes;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public String getId() {
            return this.id;
        }

        public final PrefilledPhone getPrefilledPhone() {
            return this.prefilledPhone;
        }

        public int hashCode() {
            int iHashCode = (this.countryCallingCodes.hashCode() + b.a(this.addToBackStack, this.id.hashCode() * 31, 31)) * 31;
            PrefilledPhone prefilledPhone = this.prefilledPhone;
            return iHashCode + (prefilledPhone == null ? 0 : prefilledPhone.hashCode());
        }

        public String toString() {
            return "SetPhone(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", countryCallingCodes=" + this.countryCallingCodes + ", prefilledPhone=" + this.prefilledPhone + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Step;", "", "(Ljava/lang/String;I)V", "SET_PHONE", "REQUIRE_2FA_PHONE", "SET_PASSWORD", "SET_EMAIL", "REQUIRE_2FA_EMAIL", "ACQUIRE_AUTHORIZATION", "SUCCESS", "FAILURE", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Step {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Step[] $VALUES;
        public static final Step SET_PHONE = new Step("SET_PHONE", 0);
        public static final Step REQUIRE_2FA_PHONE = new Step("REQUIRE_2FA_PHONE", 1);
        public static final Step SET_PASSWORD = new Step("SET_PASSWORD", 2);
        public static final Step SET_EMAIL = new Step("SET_EMAIL", 3);
        public static final Step REQUIRE_2FA_EMAIL = new Step("REQUIRE_2FA_EMAIL", 4);
        public static final Step ACQUIRE_AUTHORIZATION = new Step("ACQUIRE_AUTHORIZATION", 5);
        public static final Step SUCCESS = new Step("SUCCESS", 6);
        public static final Step FAILURE = new Step("FAILURE", 7);

        private static final /* synthetic */ Step[] $values() {
            return new Step[]{SET_PHONE, REQUIRE_2FA_PHONE, SET_PASSWORD, SET_EMAIL, REQUIRE_2FA_EMAIL, ACQUIRE_AUTHORIZATION, SUCCESS, FAILURE};
        }

        static {
            Step[] stepArr$values = $values();
            $VALUES = stepArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stepArr$values);
        }

        private Step(String str, int i) {
        }

        public static EnumEntries<Step> getEntries() {
            return $ENTRIES;
        }

        public static Step valueOf(String str) {
            return (Step) Enum.valueOf(Step.class, str);
        }

        public static Step[] values() {
            return (Step[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess$Success;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "id", "", "addToBackStack", "", YooMoneyAuth.KEY_ACCESS_TOKEN, "bindSocialAccount", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "(Ljava/lang/String;ZLjava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;)V", "getAccessToken", "()Ljava/lang/String;", "getAddToBackStack", "()Z", "getBindSocialAccount", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Success extends RegistrationProcess {
        private final String accessToken;
        private final boolean addToBackStack;
        private final BindSocialAccountResult bindSocialAccount;
        private final String id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String id, boolean z, String accessToken, BindSocialAccountResult bindSocialAccountResult) {
            super(Step.SUCCESS, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            this.id = id;
            this.addToBackStack = z;
            this.accessToken = accessToken;
            this.bindSocialAccount = bindSocialAccountResult;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, boolean z, String str2, BindSocialAccountResult bindSocialAccountResult, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.id;
            }
            if ((i & 2) != 0) {
                z = success.addToBackStack;
            }
            if ((i & 4) != 0) {
                str2 = success.accessToken;
            }
            if ((i & 8) != 0) {
                bindSocialAccountResult = success.bindSocialAccount;
            }
            return success.copy(str, z, str2, bindSocialAccountResult);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAccessToken() {
            return this.accessToken;
        }

        /* renamed from: component4, reason: from getter */
        public final BindSocialAccountResult getBindSocialAccount() {
            return this.bindSocialAccount;
        }

        public final Success copy(String id, boolean addToBackStack, String accessToken, BindSocialAccountResult bindSocialAccount) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            return new Success(id, addToBackStack, accessToken, bindSocialAccount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.id, success.id) && this.addToBackStack == success.addToBackStack && Intrinsics.areEqual(this.accessToken, success.accessToken) && Intrinsics.areEqual(this.bindSocialAccount, success.bindSocialAccount);
        }

        public final String getAccessToken() {
            return this.accessToken;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public boolean getAddToBackStack() {
            return this.addToBackStack;
        }

        public final BindSocialAccountResult getBindSocialAccount() {
            return this.bindSocialAccount;
        }

        @Override // ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess
        public String getId() {
            return this.id;
        }

        public int hashCode() {
            int iA = a.a(this.accessToken, b.a(this.addToBackStack, this.id.hashCode() * 31, 31), 31);
            BindSocialAccountResult bindSocialAccountResult = this.bindSocialAccount;
            return iA + (bindSocialAccountResult == null ? 0 : bindSocialAccountResult.hashCode());
        }

        public String toString() {
            return "Success(id=" + this.id + ", addToBackStack=" + this.addToBackStack + ", accessToken=" + this.accessToken + ", bindSocialAccount=" + this.bindSocialAccount + ")";
        }
    }

    private RegistrationProcess(Step step) {
        this.step = step;
    }

    public abstract boolean getAddToBackStack();

    public abstract String getId();

    public final Step getStep() {
        return this.step;
    }

    public /* synthetic */ RegistrationProcess(Step step, DefaultConstructorMarker defaultConstructorMarker) {
        this(step);
    }
}
