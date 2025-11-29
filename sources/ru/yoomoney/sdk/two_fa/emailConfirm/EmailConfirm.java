package ru.yoomoney.sdk.two_fa.emailConfirm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.two_fa.api.ProcessType;
import ru.yoomoney.sdk.two_fa.domain.SessionEmail;
import ru.yoomoney.sdk.two_fa.exception.Failure;

/* compiled from: Contract.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmailConfirm {
    public static final int $stable = 0;
    public static final EmailConfirm INSTANCE = new EmailConfirm();

    /* compiled from: Contract.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", "action", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    private EmailConfirm() {
    }

    /* compiled from: Contract.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", "", "Confirm", "Content", "Error", "Init", "InitialError", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Confirm;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Content;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Error;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Init;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$InitialError;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface State {

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Init;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Init implements State {
            public static final int $stable = 0;
            private final String processId;

            public static /* synthetic */ Init copy$default(Init init, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = init.processId;
                }
                return init.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final Init copy(String processId) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new Init(processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Init) && Intrinsics.areEqual(this.processId, ((Init) other).processId);
            }

            public int hashCode() {
                return this.processId.hashCode();
            }

            public String toString() {
                return "Init(processId=" + this.processId + ")";
            }

            public Init(String processId) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processId = processId;
            }

            public final String getProcessId() {
                return this.processId;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$InitialError;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/exception/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "getProcessId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class InitialError implements State {
            public static final int $stable = 0;
            private final Failure failure;
            private final String processId;

            public static /* synthetic */ InitialError copy$default(InitialError initialError, String str, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = initialError.processId;
                }
                if ((i & 2) != 0) {
                    failure = initialError.failure;
                }
                return initialError.copy(str, failure);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component2, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final InitialError copy(String processId, Failure failure) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new InitialError(processId, failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InitialError)) {
                    return false;
                }
                InitialError initialError = (InitialError) other;
                return Intrinsics.areEqual(this.processId, initialError.processId) && Intrinsics.areEqual(this.failure, initialError.failure);
            }

            public int hashCode() {
                return (this.processId.hashCode() * 31) + this.failure.hashCode();
            }

            public String toString() {
                return "InitialError(processId=" + this.processId + ", failure=" + this.failure + ")";
            }

            public InitialError(String processId, Failure failure) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.processId = processId;
                this.failure = failure;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final Failure getFailure() {
                return this.failure;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Content;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "session", "Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "confirmCode", "enabledConfirmAction", "", "isEnabledProgressIndicator", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/domain/SessionEmail;Ljava/lang/String;ZZ)V", "getConfirmCode", "()Ljava/lang/String;", "getEnabledConfirmAction", "()Z", "getProcessId", "getSession", "()Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content implements State {
            public static final int $stable = 8;
            private final String confirmCode;
            private final boolean enabledConfirmAction;
            private final boolean isEnabledProgressIndicator;
            private final String processId;
            private final SessionEmail session;

            public static /* synthetic */ Content copy$default(Content content, String str, SessionEmail sessionEmail, String str2, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.processId;
                }
                if ((i & 2) != 0) {
                    sessionEmail = content.session;
                }
                SessionEmail sessionEmail2 = sessionEmail;
                if ((i & 4) != 0) {
                    str2 = content.confirmCode;
                }
                String str3 = str2;
                if ((i & 8) != 0) {
                    z = content.enabledConfirmAction;
                }
                boolean z3 = z;
                if ((i & 16) != 0) {
                    z2 = content.isEnabledProgressIndicator;
                }
                return content.copy(str, sessionEmail2, str3, z3, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component2, reason: from getter */
            public final SessionEmail getSession() {
                return this.session;
            }

            /* renamed from: component3, reason: from getter */
            public final String getConfirmCode() {
                return this.confirmCode;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getEnabledConfirmAction() {
                return this.enabledConfirmAction;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsEnabledProgressIndicator() {
                return this.isEnabledProgressIndicator;
            }

            public final Content copy(String processId, SessionEmail session, String confirmCode, boolean enabledConfirmAction, boolean isEnabledProgressIndicator) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                return new Content(processId, session, confirmCode, enabledConfirmAction, isEnabledProgressIndicator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.processId, content.processId) && Intrinsics.areEqual(this.session, content.session) && Intrinsics.areEqual(this.confirmCode, content.confirmCode) && this.enabledConfirmAction == content.enabledConfirmAction && this.isEnabledProgressIndicator == content.isEnabledProgressIndicator;
            }

            public int hashCode() {
                return (((((((this.processId.hashCode() * 31) + this.session.hashCode()) * 31) + this.confirmCode.hashCode()) * 31) + Boolean.hashCode(this.enabledConfirmAction)) * 31) + Boolean.hashCode(this.isEnabledProgressIndicator);
            }

            public String toString() {
                return "Content(processId=" + this.processId + ", session=" + this.session + ", confirmCode=" + this.confirmCode + ", enabledConfirmAction=" + this.enabledConfirmAction + ", isEnabledProgressIndicator=" + this.isEnabledProgressIndicator + ")";
            }

            public Content(String processId, SessionEmail session, String confirmCode, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                this.processId = processId;
                this.session = session;
                this.confirmCode = confirmCode;
                this.enabledConfirmAction = z;
                this.isEnabledProgressIndicator = z2;
            }

            public /* synthetic */ Content(String str, SessionEmail sessionEmail, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, sessionEmail, str2, z, (i & 16) != 0 ? false : z2);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final SessionEmail getSession() {
                return this.session;
            }

            public final String getConfirmCode() {
                return this.confirmCode;
            }

            public final boolean getEnabledConfirmAction() {
                return this.enabledConfirmAction;
            }

            public final boolean isEnabledProgressIndicator() {
                return this.isEnabledProgressIndicator;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Error;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "session", "Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "confirmCode", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "isEnabledProgressIndicator", "", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/domain/SessionEmail;Ljava/lang/String;Lru/yoomoney/sdk/two_fa/exception/Failure;Z)V", "getConfirmCode", "()Ljava/lang/String;", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "()Z", "getProcessId", "getSession", "()Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Error implements State {
            public static final int $stable = 8;
            private final String confirmCode;
            private final Failure failure;
            private final boolean isEnabledProgressIndicator;
            private final String processId;
            private final SessionEmail session;

            public static /* synthetic */ Error copy$default(Error error, String str, SessionEmail sessionEmail, String str2, Failure failure, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.processId;
                }
                if ((i & 2) != 0) {
                    sessionEmail = error.session;
                }
                SessionEmail sessionEmail2 = sessionEmail;
                if ((i & 4) != 0) {
                    str2 = error.confirmCode;
                }
                String str3 = str2;
                if ((i & 8) != 0) {
                    failure = error.failure;
                }
                Failure failure2 = failure;
                if ((i & 16) != 0) {
                    z = error.isEnabledProgressIndicator;
                }
                return error.copy(str, sessionEmail2, str3, failure2, z);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component2, reason: from getter */
            public final SessionEmail getSession() {
                return this.session;
            }

            /* renamed from: component3, reason: from getter */
            public final String getConfirmCode() {
                return this.confirmCode;
            }

            /* renamed from: component4, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsEnabledProgressIndicator() {
                return this.isEnabledProgressIndicator;
            }

            public final Error copy(String processId, SessionEmail session, String confirmCode, Failure failure, boolean isEnabledProgressIndicator) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Error(processId, session, confirmCode, failure, isEnabledProgressIndicator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.processId, error.processId) && Intrinsics.areEqual(this.session, error.session) && Intrinsics.areEqual(this.confirmCode, error.confirmCode) && Intrinsics.areEqual(this.failure, error.failure) && this.isEnabledProgressIndicator == error.isEnabledProgressIndicator;
            }

            public int hashCode() {
                return (((((((this.processId.hashCode() * 31) + this.session.hashCode()) * 31) + this.confirmCode.hashCode()) * 31) + this.failure.hashCode()) * 31) + Boolean.hashCode(this.isEnabledProgressIndicator);
            }

            public String toString() {
                return "Error(processId=" + this.processId + ", session=" + this.session + ", confirmCode=" + this.confirmCode + ", failure=" + this.failure + ", isEnabledProgressIndicator=" + this.isEnabledProgressIndicator + ")";
            }

            public Error(String processId, SessionEmail session, String confirmCode, Failure failure, boolean z) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.processId = processId;
                this.session = session;
                this.confirmCode = confirmCode;
                this.failure = failure;
                this.isEnabledProgressIndicator = z;
            }

            public /* synthetic */ Error(String str, SessionEmail sessionEmail, String str2, Failure failure, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, sessionEmail, str2, failure, (i & 16) != 0 ? false : z);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final SessionEmail getSession() {
                return this.session;
            }

            public final String getConfirmCode() {
                return this.confirmCode;
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public final boolean isEnabledProgressIndicator() {
                return this.isEnabledProgressIndicator;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$Confirm;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "session", "Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "confirmCode", "isEnabledProgressIndicator", "", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/domain/SessionEmail;Ljava/lang/String;Z)V", "getConfirmCode", "()Ljava/lang/String;", "()Z", "getProcessId", "getSession", "()Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Confirm implements State {
            public static final int $stable = 8;
            private final String confirmCode;
            private final boolean isEnabledProgressIndicator;
            private final String processId;
            private final SessionEmail session;

            public static /* synthetic */ Confirm copy$default(Confirm confirm, String str, SessionEmail sessionEmail, String str2, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = confirm.processId;
                }
                if ((i & 2) != 0) {
                    sessionEmail = confirm.session;
                }
                if ((i & 4) != 0) {
                    str2 = confirm.confirmCode;
                }
                if ((i & 8) != 0) {
                    z = confirm.isEnabledProgressIndicator;
                }
                return confirm.copy(str, sessionEmail, str2, z);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component2, reason: from getter */
            public final SessionEmail getSession() {
                return this.session;
            }

            /* renamed from: component3, reason: from getter */
            public final String getConfirmCode() {
                return this.confirmCode;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsEnabledProgressIndicator() {
                return this.isEnabledProgressIndicator;
            }

            public final Confirm copy(String processId, SessionEmail session, String confirmCode, boolean isEnabledProgressIndicator) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                return new Confirm(processId, session, confirmCode, isEnabledProgressIndicator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Confirm)) {
                    return false;
                }
                Confirm confirm = (Confirm) other;
                return Intrinsics.areEqual(this.processId, confirm.processId) && Intrinsics.areEqual(this.session, confirm.session) && Intrinsics.areEqual(this.confirmCode, confirm.confirmCode) && this.isEnabledProgressIndicator == confirm.isEnabledProgressIndicator;
            }

            public int hashCode() {
                return (((((this.processId.hashCode() * 31) + this.session.hashCode()) * 31) + this.confirmCode.hashCode()) * 31) + Boolean.hashCode(this.isEnabledProgressIndicator);
            }

            public String toString() {
                return "Confirm(processId=" + this.processId + ", session=" + this.session + ", confirmCode=" + this.confirmCode + ", isEnabledProgressIndicator=" + this.isEnabledProgressIndicator + ")";
            }

            public Confirm(String processId, SessionEmail session, String confirmCode, boolean z) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(session, "session");
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                this.processId = processId;
                this.session = session;
                this.confirmCode = confirmCode;
                this.isEnabledProgressIndicator = z;
            }

            public /* synthetic */ Confirm(String str, SessionEmail sessionEmail, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, sessionEmail, str2, (i & 8) != 0 ? true : z);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final SessionEmail getSession() {
                return this.session;
            }

            public final String getConfirmCode() {
                return this.confirmCode;
            }

            public final boolean isEnabledProgressIndicator() {
                return this.isEnabledProgressIndicator;
            }
        }
    }

    /* compiled from: Contract.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\u0082\u0001\u000b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "", "CodeChanged", "ConfirmCode", "ConfirmFail", "ConfirmSuccess", "RestartSession", "SendAnalyticsForScreen", "SessionStartFail", "SessionStartSuccess", "ShowHelp", "TechnicalFailure", "UpdateCode", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$CodeChanged;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$ConfirmCode;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$ConfirmFail;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$ConfirmSuccess;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$RestartSession;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$SessionStartFail;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$SessionStartSuccess;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$ShowHelp;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$TechnicalFailure;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$UpdateCode;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Action {

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$SessionStartSuccess;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "session", "Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "(Lru/yoomoney/sdk/two_fa/domain/SessionEmail;)V", "getSession", "()Lru/yoomoney/sdk/two_fa/domain/SessionEmail;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SessionStartSuccess implements Action {
            public static final int $stable = 8;
            private final SessionEmail session;

            public static /* synthetic */ SessionStartSuccess copy$default(SessionStartSuccess sessionStartSuccess, SessionEmail sessionEmail, int i, Object obj) {
                if ((i & 1) != 0) {
                    sessionEmail = sessionStartSuccess.session;
                }
                return sessionStartSuccess.copy(sessionEmail);
            }

            /* renamed from: component1, reason: from getter */
            public final SessionEmail getSession() {
                return this.session;
            }

            public final SessionStartSuccess copy(SessionEmail session) {
                Intrinsics.checkNotNullParameter(session, "session");
                return new SessionStartSuccess(session);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SessionStartSuccess) && Intrinsics.areEqual(this.session, ((SessionStartSuccess) other).session);
            }

            public int hashCode() {
                return this.session.hashCode();
            }

            public String toString() {
                return "SessionStartSuccess(session=" + this.session + ")";
            }

            public SessionStartSuccess(SessionEmail session) {
                Intrinsics.checkNotNullParameter(session, "session");
                this.session = session;
            }

            public final SessionEmail getSession() {
                return this.session;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$SessionStartFail;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "(Lru/yoomoney/sdk/two_fa/exception/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SessionStartFail implements Action {
            public static final int $stable = 0;
            private final Failure failure;

            public static /* synthetic */ SessionStartFail copy$default(SessionStartFail sessionStartFail, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = sessionStartFail.failure;
                }
                return sessionStartFail.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final SessionStartFail copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new SessionStartFail(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SessionStartFail) && Intrinsics.areEqual(this.failure, ((SessionStartFail) other).failure);
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "SessionStartFail(failure=" + this.failure + ")";
            }

            public SessionStartFail(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public final Failure getFailure() {
                return this.failure;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$RestartSession;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class RestartSession implements Action {
            public static final int $stable = 0;
            public static final RestartSession INSTANCE = new RestartSession();

            private RestartSession() {
            }

            public String toString() {
                String simpleName = RestartSession.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$CodeChanged;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "confirmCode", "", "(Ljava/lang/String;)V", "getConfirmCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CodeChanged implements Action {
            public static final int $stable = 0;
            private final String confirmCode;

            public static /* synthetic */ CodeChanged copy$default(CodeChanged codeChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = codeChanged.confirmCode;
                }
                return codeChanged.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getConfirmCode() {
                return this.confirmCode;
            }

            public final CodeChanged copy(String confirmCode) {
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                return new CodeChanged(confirmCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CodeChanged) && Intrinsics.areEqual(this.confirmCode, ((CodeChanged) other).confirmCode);
            }

            public int hashCode() {
                return this.confirmCode.hashCode();
            }

            public String toString() {
                return "CodeChanged(confirmCode=" + this.confirmCode + ")";
            }

            public CodeChanged(String confirmCode) {
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                this.confirmCode = confirmCode;
            }

            public final String getConfirmCode() {
                return this.confirmCode;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$UpdateCode;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "confirmCode", "", "enableConfirmAction", "", "(Ljava/lang/String;Z)V", "getConfirmCode", "()Ljava/lang/String;", "getEnableConfirmAction", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateCode implements Action {
            public static final int $stable = 0;
            private final String confirmCode;
            private final boolean enableConfirmAction;

            public static /* synthetic */ UpdateCode copy$default(UpdateCode updateCode, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updateCode.confirmCode;
                }
                if ((i & 2) != 0) {
                    z = updateCode.enableConfirmAction;
                }
                return updateCode.copy(str, z);
            }

            /* renamed from: component1, reason: from getter */
            public final String getConfirmCode() {
                return this.confirmCode;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getEnableConfirmAction() {
                return this.enableConfirmAction;
            }

            public final UpdateCode copy(String confirmCode, boolean enableConfirmAction) {
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                return new UpdateCode(confirmCode, enableConfirmAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateCode)) {
                    return false;
                }
                UpdateCode updateCode = (UpdateCode) other;
                return Intrinsics.areEqual(this.confirmCode, updateCode.confirmCode) && this.enableConfirmAction == updateCode.enableConfirmAction;
            }

            public int hashCode() {
                return (this.confirmCode.hashCode() * 31) + Boolean.hashCode(this.enableConfirmAction);
            }

            public String toString() {
                return "UpdateCode(confirmCode=" + this.confirmCode + ", enableConfirmAction=" + this.enableConfirmAction + ")";
            }

            public UpdateCode(String confirmCode, boolean z) {
                Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
                this.confirmCode = confirmCode;
                this.enableConfirmAction = z;
            }

            public final String getConfirmCode() {
                return this.confirmCode;
            }

            public final boolean getEnableConfirmAction() {
                return this.enableConfirmAction;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$ShowHelp;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowHelp implements Action {
            public static final int $stable = 0;
            public static final ShowHelp INSTANCE = new ShowHelp();

            private ShowHelp() {
            }

            public String toString() {
                String simpleName = ShowHelp.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$ConfirmCode;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ConfirmCode implements Action {
            public static final int $stable = 0;
            public static final ConfirmCode INSTANCE = new ConfirmCode();

            private ConfirmCode() {
            }

            public String toString() {
                String simpleName = ConfirmCode.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$ConfirmSuccess;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ConfirmSuccess implements Action {
            public static final int $stable = 0;
            public static final ConfirmSuccess INSTANCE = new ConfirmSuccess();

            private ConfirmSuccess() {
            }

            public String toString() {
                String simpleName = ConfirmSuccess.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$ConfirmFail;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "attemptsLeft", "", "(Lru/yoomoney/sdk/two_fa/exception/Failure;I)V", "getAttemptsLeft", "()I", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmFail implements Action {
            public static final int $stable = 0;
            private final int attemptsLeft;
            private final Failure failure;

            public static /* synthetic */ ConfirmFail copy$default(ConfirmFail confirmFail, Failure failure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    failure = confirmFail.failure;
                }
                if ((i2 & 2) != 0) {
                    i = confirmFail.attemptsLeft;
                }
                return confirmFail.copy(failure, i);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            /* renamed from: component2, reason: from getter */
            public final int getAttemptsLeft() {
                return this.attemptsLeft;
            }

            public final ConfirmFail copy(Failure failure, int attemptsLeft) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ConfirmFail(failure, attemptsLeft);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ConfirmFail)) {
                    return false;
                }
                ConfirmFail confirmFail = (ConfirmFail) other;
                return Intrinsics.areEqual(this.failure, confirmFail.failure) && this.attemptsLeft == confirmFail.attemptsLeft;
            }

            public int hashCode() {
                return (this.failure.hashCode() * 31) + Integer.hashCode(this.attemptsLeft);
            }

            public String toString() {
                return "ConfirmFail(failure=" + this.failure + ", attemptsLeft=" + this.attemptsLeft + ")";
            }

            public ConfirmFail(Failure failure, int i) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
                this.attemptsLeft = i;
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public final int getAttemptsLeft() {
                return this.attemptsLeft;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$TechnicalFailure;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "(Lru/yoomoney/sdk/two_fa/exception/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class TechnicalFailure implements Action {
            public static final int $stable = 0;
            private final Failure failure;

            public static /* synthetic */ TechnicalFailure copy$default(TechnicalFailure technicalFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = technicalFailure.failure;
                }
                return technicalFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final TechnicalFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new TechnicalFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TechnicalFailure) && Intrinsics.areEqual(this.failure, ((TechnicalFailure) other).failure);
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "TechnicalFailure(failure=" + this.failure + ")";
            }

            public TechnicalFailure(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public final Failure getFailure() {
                return this.failure;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action$SendAnalyticsForScreen;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", "processType", "Lru/yoomoney/sdk/two_fa/api/ProcessType;", "(Lru/yoomoney/sdk/two_fa/api/ProcessType;)V", "getProcessType", "()Lru/yoomoney/sdk/two_fa/api/ProcessType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendAnalyticsForScreen implements Action {
            public static final int $stable = 0;
            private final ProcessType processType;

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

            public int hashCode() {
                return this.processType.hashCode();
            }

            public String toString() {
                return "SendAnalyticsForScreen(processType=" + this.processType + ")";
            }

            public SendAnalyticsForScreen(ProcessType processType) {
                Intrinsics.checkNotNullParameter(processType, "processType");
                this.processType = processType;
            }

            public final ProcessType getProcessType() {
                return this.processType;
            }
        }
    }

    /* compiled from: Contract.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect;", "", "FinishWithSuccess", "NavigateToHelp", "ShowFailure", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect$FinishWithSuccess;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect$NavigateToHelp;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect$ShowFailure;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Effect {

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect$ShowFailure;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "(Lru/yoomoney/sdk/two_fa/exception/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure implements Effect {
            public static final int $stable = 0;
            private final Failure failure;

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

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowFailure(failure=" + this.failure + ")";
            }

            public ShowFailure(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public final Failure getFailure() {
                return this.failure;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect$NavigateToHelp;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class NavigateToHelp implements Effect {
            public static final int $stable = 0;
            public static final NavigateToHelp INSTANCE = new NavigateToHelp();

            private NavigateToHelp() {
            }

            public String toString() {
                String simpleName = NavigateToHelp.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect$FinishWithSuccess;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Effect;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class FinishWithSuccess implements Effect {
            public static final int $stable = 0;
            public static final FinishWithSuccess INSTANCE = new FinishWithSuccess();

            private FinishWithSuccess() {
            }

            public String toString() {
                String simpleName = FinishWithSuccess.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }
    }
}
