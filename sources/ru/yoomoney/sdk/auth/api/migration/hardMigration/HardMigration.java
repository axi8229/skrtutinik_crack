package ru.yoomoney.sdk.auth.api.migration.hardMigration;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration;", "", "()V", "Action", "AnalyticsLogger", "BusinessLogic", "CommandProcessor", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HardMigration {
    public static final HardMigration INSTANCE = new HardMigration();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "", "()V", "Confirm", "MigrationSuccess", "RestartProcess", "ShowFailure", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$Confirm;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$MigrationSuccess;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$ShowFailure;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$Confirm;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "uid", "", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "getUid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Confirm extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;
            private final ProcessType processType;
            private final String uid;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Confirm(String uid, ProcessType processType, String processId, OffsetDateTime offsetDateTime) {
                super(null);
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.uid = uid;
                this.processType = processType;
                this.processId = processId;
                this.expireAt = offsetDateTime;
            }

            public static /* synthetic */ Confirm copy$default(Confirm confirm, String str, ProcessType processType, String str2, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = confirm.uid;
                }
                if ((i & 2) != 0) {
                    processType = confirm.processType;
                }
                if ((i & 4) != 0) {
                    str2 = confirm.processId;
                }
                if ((i & 8) != 0) {
                    offsetDateTime = confirm.expireAt;
                }
                return confirm.copy(str, processType, str2, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUid() {
                return this.uid;
            }

            /* renamed from: component2, reason: from getter */
            public final ProcessType getProcessType() {
                return this.processType;
            }

            /* renamed from: component3, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component4, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final Confirm copy(String uid, ProcessType processType, String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(processType, "processType");
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new Confirm(uid, processType, processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Confirm)) {
                    return false;
                }
                Confirm confirm = (Confirm) other;
                return Intrinsics.areEqual(this.uid, confirm.uid) && this.processType == confirm.processType && Intrinsics.areEqual(this.processId, confirm.processId) && Intrinsics.areEqual(this.expireAt, confirm.expireAt);
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

            public final String getUid() {
                return this.uid;
            }

            public int hashCode() {
                int iA = a.a(this.processId, (this.processType.hashCode() + (this.uid.hashCode() * 31)) * 31, 31);
                OffsetDateTime offsetDateTime = this.expireAt;
                return iA + (offsetDateTime == null ? 0 : offsetDateTime.hashCode());
            }

            public String toString() {
                return "Confirm(uid=" + this.uid + ", processType=" + this.processType + ", processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$MigrationSuccess;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "migrationProcess", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "(Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;)V", "getMigrationProcess", "()Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class MigrationSuccess extends Action {
            private final MigrationProcess migrationProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MigrationSuccess(MigrationProcess migrationProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(migrationProcess, "migrationProcess");
                this.migrationProcess = migrationProcess;
            }

            public static /* synthetic */ MigrationSuccess copy$default(MigrationSuccess migrationSuccess, MigrationProcess migrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    migrationProcess = migrationSuccess.migrationProcess;
                }
                return migrationSuccess.copy(migrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final MigrationProcess getMigrationProcess() {
                return this.migrationProcess;
            }

            public final MigrationSuccess copy(MigrationProcess migrationProcess) {
                Intrinsics.checkNotNullParameter(migrationProcess, "migrationProcess");
                return new MigrationSuccess(migrationProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MigrationSuccess) && Intrinsics.areEqual(this.migrationProcess, ((MigrationSuccess) other).migrationProcess);
            }

            public final MigrationProcess getMigrationProcess() {
                return this.migrationProcess;
            }

            public int hashCode() {
                return this.migrationProcess.hashCode();
            }

            public String toString() {
                return "MigrationSuccess(migrationProcess=" + this.migrationProcess + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class RestartProcess extends Action {
            public static final RestartProcess INSTANCE = new RestartProcess();

            private RestartProcess() {
                super(null);
            }

            public String toString() {
                return "RestartProcess";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$ShowFailure;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure extends Action {
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

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State;", "action", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u000024\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0001J9\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H¦\u0002¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$BusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "Lkotlin/Triple;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect;", "invoke", "state", "action", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BusinessLogic extends Function2<State, Action, Triple<? extends State, ? extends Command<?, ? extends Action>, ? extends Effect>> {
        @Override // kotlin.jvm.functions.Function2
        /* synthetic */ Triple<? extends State, ? extends Command<?, ? extends Action>, ? extends Effect> invoke(State state, Action action);

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        Triple<State, Command<?, Action>, Effect> invoke2(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u0005H¦B¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$CommandProcessor;", "", "invoke", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "command", "Lru/yoomoney/sdk/march/Command;", "(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface CommandProcessor {
        Object invoke(Command<?, ? extends Action> command, Continuation<? super Action> continuation);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect;", "", "()V", "ResetProcess", "ShowExpireDialog", "ShowFailure", "ShowNextStep", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ResetProcess extends Effect {
            public static final ResetProcess INSTANCE = new ResetProcess();

            private ResetProcess() {
                super(null);
            }

            public String toString() {
                return "ResetProcess";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowExpireDialog extends Effect {
            public static final ShowExpireDialog INSTANCE = new ShowExpireDialog();

            private ShowExpireDialog() {
                super(null);
            }

            public String toString() {
                return "ShowExpireDialog";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect;", "migrationProcess", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "(Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;)V", "getMigrationProcess", "()Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextStep extends Effect {
            private final MigrationProcess migrationProcess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextStep(MigrationProcess migrationProcess) {
                super(null);
                Intrinsics.checkNotNullParameter(migrationProcess, "migrationProcess");
                this.migrationProcess = migrationProcess;
            }

            public static /* synthetic */ ShowNextStep copy$default(ShowNextStep showNextStep, MigrationProcess migrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    migrationProcess = showNextStep.migrationProcess;
                }
                return showNextStep.copy(migrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final MigrationProcess getMigrationProcess() {
                return this.migrationProcess;
            }

            public final ShowNextStep copy(MigrationProcess migrationProcess) {
                Intrinsics.checkNotNullParameter(migrationProcess, "migrationProcess");
                return new ShowNextStep(migrationProcess);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextStep) && Intrinsics.areEqual(this.migrationProcess, ((ShowNextStep) other).migrationProcess);
            }

            public final MigrationProcess getMigrationProcess() {
                return this.migrationProcess;
            }

            public int hashCode() {
                return this.migrationProcess.hashCode();
            }

            public String toString() {
                return "ShowNextStep(migrationProcess=" + this.migrationProcess + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State;", "", "()V", "Content", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State$Content;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State$Content;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State;", "isLoading", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final boolean isLoading;

            public Content() {
                this(false, 1, null);
            }

            public static /* synthetic */ Content copy$default(Content content, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = content.isLoading;
                }
                return content.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsLoading() {
                return this.isLoading;
            }

            public final Content copy(boolean isLoading) {
                return new Content(isLoading);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Content) && this.isLoading == ((Content) other).isLoading;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isLoading);
            }

            public final boolean isLoading() {
                return this.isLoading;
            }

            public String toString() {
                return "Content(isLoading=" + this.isLoading + ")";
            }

            public Content(boolean z) {
                super(null);
                this.isLoading = z;
            }

            public /* synthetic */ Content(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private HardMigration() {
    }
}
