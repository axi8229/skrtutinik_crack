package ru.yoomoney.sdk.auth.yandexAcquire.webView;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView;", "", "()V", "Action", "AnalyticsLogger", "BusinessLogic", "CommandProcessor", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireWebView {
    public static final YandexAcquireWebView INSTANCE = new YandexAcquireWebView();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "", "()V", "AcquireFail", "AcquireSuccess", "PageLoaded", "RestartProcess", "SetYandexToken", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$AcquireFail;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$AcquireSuccess;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$PageLoaded;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$SetYandexToken;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$AcquireFail;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AcquireFail extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AcquireFail(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ AcquireFail copy$default(AcquireFail acquireFail, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = acquireFail.failure;
                }
                return acquireFail.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final AcquireFail copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new AcquireFail(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AcquireFail) && Intrinsics.areEqual(this.failure, ((AcquireFail) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "AcquireFail(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$AcquireSuccess;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AcquireSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AcquireSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ AcquireSuccess copy$default(AcquireSuccess acquireSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = acquireSuccess.process;
                }
                return acquireSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final AcquireSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new AcquireSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AcquireSuccess) && Intrinsics.areEqual(this.process, ((AcquireSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "AcquireSuccess(process=" + this.process + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$PageLoaded;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class PageLoaded extends Action {
            public static final PageLoaded INSTANCE = new PageLoaded();

            private PageLoaded() {
                super(null);
            }

            public String toString() {
                return "PageLoaded";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class RestartProcess extends Action {
            public static final RestartProcess INSTANCE = new RestartProcess();

            private RestartProcess() {
                super(null);
            }

            public String toString() {
                return "RestartProcess";
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action$SetYandexToken;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "token", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getToken", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetYandexToken extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final String token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetYandexToken(String processId, String token, OffsetDateTime expireAt) {
                super(null);
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                this.processId = processId;
                this.token = token;
                this.expireAt = expireAt;
            }

            public static /* synthetic */ SetYandexToken copy$default(SetYandexToken setYandexToken, String str, String str2, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = setYandexToken.processId;
                }
                if ((i & 2) != 0) {
                    str2 = setYandexToken.token;
                }
                if ((i & 4) != 0) {
                    offsetDateTime = setYandexToken.expireAt;
                }
                return setYandexToken.copy(str, str2, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            /* renamed from: component3, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final SetYandexToken copy(String processId, String token, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                return new SetYandexToken(processId, token, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SetYandexToken)) {
                    return false;
                }
                SetYandexToken setYandexToken = (SetYandexToken) other;
                return Intrinsics.areEqual(this.processId, setYandexToken.processId) && Intrinsics.areEqual(this.token, setYandexToken.token) && Intrinsics.areEqual(this.expireAt, setYandexToken.expireAt);
            }

            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                return this.expireAt.hashCode() + a.a(this.token, this.processId.hashCode() * 31, 31);
            }

            public String toString() {
                return "SetYandexToken(processId=" + this.processId + ", token=" + this.token + ", expireAt=" + this.expireAt + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "action", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u000024\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0001J9\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H¦\u0002¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$BusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "Lkotlin/Triple;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect;", "invoke", "state", "action", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BusinessLogic extends Function2<State, Action, Triple<? extends State, ? extends Command<?, ? extends Action>, ? extends Effect>> {
        @Override // kotlin.jvm.functions.Function2
        /* synthetic */ Triple<? extends State, ? extends Command<?, ? extends Action>, ? extends Effect> invoke(State state, Action action);

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        Triple<State, Command<?, Action>, Effect> invoke2(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u0005H¦B¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$CommandProcessor;", "", "invoke", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "command", "Lru/yoomoney/sdk/march/Command;", "(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface CommandProcessor {
        Object invoke(Command<?, ? extends Action> command, Continuation<? super Action> continuation);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect;", "", "()V", "ResetProcess", "ShowExpireDialog", "ShowNextStep", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ResetProcess extends Effect {
            public static final ResetProcess INSTANCE = new ResetProcess();

            private ResetProcess() {
                super(null);
            }

            public String toString() {
                return "ResetProcess";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowExpireDialog extends Effect {
            public static final ShowExpireDialog INSTANCE = new ShowExpireDialog();

            private ShowExpireDialog() {
                super(null);
            }

            public String toString() {
                return "ShowExpireDialog";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "", "()V", "Content", "Error", "Init", "Loading", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Content;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Error;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Init;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Loading;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Content;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Content extends State {
            public static final Content INSTANCE = new Content();

            private Content() {
                super(null);
            }

            public String toString() {
                return "Content";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Error;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "token", "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "getToken", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Error extends State {
            private final Failure failure;
            private final String token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String token, Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.token = token;
                this.failure = failure;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.token;
                }
                if ((i & 2) != 0) {
                    failure = error.failure;
                }
                return error.copy(str, failure);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            /* renamed from: component2, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final Error copy(String token, Failure failure) {
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Error(token, failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.token, error.token) && Intrinsics.areEqual(this.failure, error.failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                return this.failure.hashCode() + (this.token.hashCode() * 31);
            }

            public String toString() {
                return "Error(token=" + this.token + ", failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Init;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "clientId", "", "(Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Init extends State {
            private final String clientId;

            public Init() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Init copy$default(Init init, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = init.clientId;
                }
                return init.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getClientId() {
                return this.clientId;
            }

            public final Init copy(String clientId) {
                return new Init(clientId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Init) && Intrinsics.areEqual(this.clientId, ((Init) other).clientId);
            }

            public final String getClientId() {
                return this.clientId;
            }

            public int hashCode() {
                String str = this.clientId;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Init(clientId=" + this.clientId + ")";
            }

            public Init(String str) {
                super(null);
                this.clientId = str;
            }

            public /* synthetic */ Init(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Loading;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "token", "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Loading extends State {
            private final String token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(String token) {
                super(null);
                Intrinsics.checkNotNullParameter(token, "token");
                this.token = token;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loading.token;
                }
                return loading.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            public final Loading copy(String token) {
                Intrinsics.checkNotNullParameter(token, "token");
                return new Loading(token);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.token, ((Loading) other).token);
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                return this.token.hashCode();
            }

            public String toString() {
                return "Loading(token=" + this.token + ")";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private YandexAcquireWebView() {
    }
}
