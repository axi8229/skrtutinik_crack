package ru.yoomoney.sdk.two_fa.entryPoint;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.two_fa.domain.AuthContext;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.exception.Failure;

/* compiled from: Contract.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint;", "", "()V", "Action", "Effect", "State", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EntryPoint {
    public static final int $stable = 0;
    public static final EntryPoint INSTANCE = new EntryPoint();

    private EntryPoint() {
    }

    /* compiled from: Contract.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State;", "", "Init", "InitialError", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State$Init;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State$InitialError;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface State {

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State$Init;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State$InitialError;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/exception/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "getProcessId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

            public final Failure getFailure() {
                return this.failure;
            }

            public final String getProcessId() {
                return this.processId;
            }
        }
    }

    /* compiled from: Contract.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", "", "LoadingContext", "LoadingContextFailed", "LoadingContextSuccess", "RestartLoadingContext", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action$LoadingContext;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action$LoadingContextFailed;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action$LoadingContextSuccess;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action$RestartLoadingContext;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Action {

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action$RestartLoadingContext;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class RestartLoadingContext implements Action {
            public static final int $stable = 0;
            public static final RestartLoadingContext INSTANCE = new RestartLoadingContext();

            private RestartLoadingContext() {
            }

            public String toString() {
                String simpleName = RestartLoadingContext.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action$LoadingContext;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class LoadingContext implements Action {
            public static final int $stable = 0;
            public static final LoadingContext INSTANCE = new LoadingContext();

            private LoadingContext() {
            }

            public String toString() {
                String simpleName = LoadingContext.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action$LoadingContextSuccess;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", "context", "Lru/yoomoney/sdk/two_fa/domain/AuthContext;", "(Lru/yoomoney/sdk/two_fa/domain/AuthContext;)V", "getContext", "()Lru/yoomoney/sdk/two_fa/domain/AuthContext;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadingContextSuccess implements Action {
            public static final int $stable = 8;
            private final AuthContext context;

            public static /* synthetic */ LoadingContextSuccess copy$default(LoadingContextSuccess loadingContextSuccess, AuthContext authContext, int i, Object obj) {
                if ((i & 1) != 0) {
                    authContext = loadingContextSuccess.context;
                }
                return loadingContextSuccess.copy(authContext);
            }

            /* renamed from: component1, reason: from getter */
            public final AuthContext getContext() {
                return this.context;
            }

            public final LoadingContextSuccess copy(AuthContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new LoadingContextSuccess(context);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadingContextSuccess) && Intrinsics.areEqual(this.context, ((LoadingContextSuccess) other).context);
            }

            public int hashCode() {
                return this.context.hashCode();
            }

            public String toString() {
                return "LoadingContextSuccess(context=" + this.context + ")";
            }

            public LoadingContextSuccess(AuthContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.context = context;
            }

            public final AuthContext getContext() {
                return this.context;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action$LoadingContextFailed;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "(Lru/yoomoney/sdk/two_fa/exception/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadingContextFailed implements Action {
            public static final int $stable = 0;
            private final Failure failure;

            public static /* synthetic */ LoadingContextFailed copy$default(LoadingContextFailed loadingContextFailed, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = loadingContextFailed.failure;
                }
                return loadingContextFailed.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final LoadingContextFailed copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new LoadingContextFailed(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadingContextFailed) && Intrinsics.areEqual(this.failure, ((LoadingContextFailed) other).failure);
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "LoadingContextFailed(failure=" + this.failure + ")";
            }

            public LoadingContextFailed(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public final Failure getFailure() {
                return this.failure;
            }
        }
    }

    /* compiled from: Contract.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect;", "", "NavigateToConfirmation", "ShowFailure", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect$NavigateToConfirmation;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect$ShowFailure;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Effect {

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect$NavigateToConfirmation;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect;", "availableSessionOptions", "", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "(Ljava/util/List;)V", "getAvailableSessionOptions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NavigateToConfirmation implements Effect {
            public static final int $stable = 8;
            private final List<SessionType> availableSessionOptions;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ NavigateToConfirmation copy$default(NavigateToConfirmation navigateToConfirmation, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = navigateToConfirmation.availableSessionOptions;
                }
                return navigateToConfirmation.copy(list);
            }

            public final List<SessionType> component1() {
                return this.availableSessionOptions;
            }

            public final NavigateToConfirmation copy(List<? extends SessionType> availableSessionOptions) {
                Intrinsics.checkNotNullParameter(availableSessionOptions, "availableSessionOptions");
                return new NavigateToConfirmation(availableSessionOptions);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToConfirmation) && Intrinsics.areEqual(this.availableSessionOptions, ((NavigateToConfirmation) other).availableSessionOptions);
            }

            public int hashCode() {
                return this.availableSessionOptions.hashCode();
            }

            public String toString() {
                return "NavigateToConfirmation(availableSessionOptions=" + this.availableSessionOptions + ")";
            }

            /* JADX WARN: Multi-variable type inference failed */
            public NavigateToConfirmation(List<? extends SessionType> availableSessionOptions) {
                Intrinsics.checkNotNullParameter(availableSessionOptions, "availableSessionOptions");
                this.availableSessionOptions = availableSessionOptions;
            }

            public final List<SessionType> getAvailableSessionOptions() {
                return this.availableSessionOptions;
            }
        }

        /* compiled from: Contract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect$ShowFailure;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "(Lru/yoomoney/sdk/two_fa/exception/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/two_fa/exception/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    }
}
