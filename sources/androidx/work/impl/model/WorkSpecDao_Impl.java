package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetCancelledState;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueueTime;
    private final SharedSQLiteStatement __preparedStmtOfSetNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final SharedSQLiteStatement __preparedStmtOfSetStopReason;
    private final EntityDeletionOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
                String str = workSpec.id;
                if (str == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, str);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                String str2 = workSpec.workerClassName;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, str2);
                }
                String str3 = workSpec.inputMergerClassName;
                if (str3 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, str3);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, workSpec.getStopReason());
                Constraints constraints = workSpec.constraints;
                if (constraints != null) {
                    supportSQLiteStatement.bindLong(23, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(24, constraints.getRequiresCharging() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(25, constraints.getRequiresDeviceIdle() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(26, constraints.getRequiresBatteryNotLow() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(27, constraints.getRequiresStorageNotLow() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(28, constraints.getContentTriggerUpdateDelayMillis());
                    supportSQLiteStatement.bindLong(29, constraints.getContentTriggerMaxDelayMillis());
                    byte[] ofTriggersToByteArray = WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers());
                    if (ofTriggersToByteArray == null) {
                        supportSQLiteStatement.bindNull(30);
                        return;
                    } else {
                        supportSQLiteStatement.bindBlob(30, ofTriggersToByteArray);
                        return;
                    }
                }
                supportSQLiteStatement.bindNull(23);
                supportSQLiteStatement.bindNull(24);
                supportSQLiteStatement.bindNull(25);
                supportSQLiteStatement.bindNull(26);
                supportSQLiteStatement.bindNull(27);
                supportSQLiteStatement.bindNull(28);
                supportSQLiteStatement.bindNull(29);
                supportSQLiteStatement.bindNull(30);
            }
        };
        this.__updateAdapterOfWorkSpec = new EntityDeletionOrUpdateAdapter<WorkSpec>(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
                String str = workSpec.id;
                if (str == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, str);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                String str2 = workSpec.workerClassName;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, str2);
                }
                String str3 = workSpec.inputMergerClassName;
                if (str3 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, str3);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, workSpec.getStopReason());
                Constraints constraints = workSpec.constraints;
                if (constraints != null) {
                    supportSQLiteStatement.bindLong(23, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(24, constraints.getRequiresCharging() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(25, constraints.getRequiresDeviceIdle() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(26, constraints.getRequiresBatteryNotLow() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(27, constraints.getRequiresStorageNotLow() ? 1L : 0L);
                    supportSQLiteStatement.bindLong(28, constraints.getContentTriggerUpdateDelayMillis());
                    supportSQLiteStatement.bindLong(29, constraints.getContentTriggerMaxDelayMillis());
                    byte[] ofTriggersToByteArray = WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers());
                    if (ofTriggersToByteArray == null) {
                        supportSQLiteStatement.bindNull(30);
                    } else {
                        supportSQLiteStatement.bindBlob(30, ofTriggersToByteArray);
                    }
                } else {
                    supportSQLiteStatement.bindNull(23);
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                    supportSQLiteStatement.bindNull(26);
                    supportSQLiteStatement.bindNull(27);
                    supportSQLiteStatement.bindNull(28);
                    supportSQLiteStatement.bindNull(29);
                    supportSQLiteStatement.bindNull(30);
                }
                String str4 = workSpec.id;
                if (str4 == null) {
                    supportSQLiteStatement.bindNull(31);
                } else {
                    supportSQLiteStatement.bindString(31, str4);
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetState = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetCancelledState = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementPeriodCount = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetLastEnqueueTime = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetNextScheduleTimeOverride = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.__preparedStmtOfIncrementGeneration = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetStopReason = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            }
        };
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(final WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void updateWorkSpec(final WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWorkSpec.handle(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(final WorkInfo.State state, final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetState.acquire();
        supportSQLiteStatementAcquire.bindLong(1, WorkTypeConverters.stateToInt(state));
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetState.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setCancelledState(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetCancelledState.acquire();
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetCancelledState.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementPeriodCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfIncrementPeriodCount.acquire();
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementPeriodCount.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(final String id, final Data output) throws Throwable {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetOutput.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(output);
        if (byteArrayInternal == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindBlob(1, byteArrayInternal);
        }
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setLastEnqueueTime(final String id, final long enqueueTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetLastEnqueueTime.acquire();
        supportSQLiteStatementAcquire.bindLong(1, enqueueTime);
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetLastEnqueueTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void resetWorkSpecNextScheduleTimeOverride(final String id, final int overrideGeneration) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.acquire();
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, id);
        }
        supportSQLiteStatementAcquire.bindLong(2, overrideGeneration);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(final String id, final long startTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        supportSQLiteStatementAcquire.bindLong(1, startTime);
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setStopReason(final String id, final int stopReason) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetStopReason.acquire();
        supportSQLiteStatementAcquire.bindLong(1, stopReason);
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetStopReason.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(final String id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        WorkSpec workSpec;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j = cursorQuery.getLong(columnIndexOrThrow7);
                long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                int i6 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                long j6 = cursorQuery.getLong(columnIndexOrThrow14);
                long j7 = cursorQuery.getLong(columnIndexOrThrow15);
                if (cursorQuery.getInt(columnIndexOrThrow16) != 0) {
                    i = columnIndexOrThrow17;
                    z = true;
                } else {
                    i = columnIndexOrThrow17;
                    z = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i));
                int i7 = cursorQuery.getInt(columnIndexOrThrow18);
                int i8 = cursorQuery.getInt(columnIndexOrThrow19);
                long j8 = cursorQuery.getLong(columnIndexOrThrow20);
                int i9 = cursorQuery.getInt(columnIndexOrThrow21);
                int i10 = cursorQuery.getInt(columnIndexOrThrow22);
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow23));
                if (cursorQuery.getInt(columnIndexOrThrow24) != 0) {
                    i2 = columnIndexOrThrow25;
                    z2 = true;
                } else {
                    i2 = columnIndexOrThrow25;
                    z2 = false;
                }
                if (cursorQuery.getInt(i2) != 0) {
                    i3 = columnIndexOrThrow26;
                    z3 = true;
                } else {
                    i3 = columnIndexOrThrow26;
                    z3 = false;
                }
                if (cursorQuery.getInt(i3) != 0) {
                    i4 = columnIndexOrThrow27;
                    z4 = true;
                } else {
                    i4 = columnIndexOrThrow27;
                    z4 = false;
                }
                if (cursorQuery.getInt(i4) != 0) {
                    i5 = columnIndexOrThrow28;
                    z5 = true;
                } else {
                    i5 = columnIndexOrThrow28;
                    z5 = false;
                }
                workSpec = new WorkSpec(string, stateIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(networkTypeIntToNetworkType, z2, z3, z4, z5, cursorQuery.getLong(i5), cursorQuery.getLong(columnIndexOrThrow29), WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getBlob(columnIndexOrThrow30))), i6, backoffPolicyIntToBackoffPolicy, j4, j5, j6, j7, z, outOfQuotaPolicyIntToOutOfQuotaPolicy, i7, i8, j8, i9, i10);
            } else {
                workSpec = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return workSpec;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(final String name) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, name);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new WorkSpec.IdAndState(cursorQuery.isNull(0) ? null : cursorQuery.getString(0), WorkTypeConverters.intToState(cursorQuery.getInt(1))));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(final String id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        WorkInfo.State stateIntToState = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                Integer numValueOf = cursorQuery.isNull(0) ? null : Integer.valueOf(cursorQuery.getInt(0));
                if (numValueOf != null) {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    stateIntToState = WorkTypeConverters.intToState(numValueOf.intValue());
                }
            }
            return stateIntToState;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(final String id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(Data.fromByteArray(cursorQuery.isNull(0) ? null : cursorQuery.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithTag(final String tag) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (tag == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, tag);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(final String name) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, name);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public boolean hasUnfinishedWork() {
        boolean z = false;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                if (cursorQuery.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(final int schedulerLimit) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", 1);
        roomSQLiteQueryAcquire.bindLong(1, schedulerLimit);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i6 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j = cursorQuery.getLong(columnIndexOrThrow7);
                long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                int i7 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                int i8 = i6;
                long j6 = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow;
                int i10 = columnIndexOrThrow15;
                long j7 = cursorQuery.getLong(i10);
                columnIndexOrThrow15 = i10;
                int i11 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = true;
                } else {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i));
                columnIndexOrThrow17 = i;
                int i12 = columnIndexOrThrow18;
                int i13 = cursorQuery.getInt(i12);
                columnIndexOrThrow18 = i12;
                int i14 = columnIndexOrThrow19;
                int i15 = cursorQuery.getInt(i14);
                columnIndexOrThrow19 = i14;
                int i16 = columnIndexOrThrow20;
                long j8 = cursorQuery.getLong(i16);
                columnIndexOrThrow20 = i16;
                int i17 = columnIndexOrThrow21;
                int i18 = cursorQuery.getInt(i17);
                columnIndexOrThrow21 = i17;
                int i19 = columnIndexOrThrow22;
                int i20 = cursorQuery.getInt(i19);
                columnIndexOrThrow22 = i19;
                int i21 = columnIndexOrThrow23;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i21));
                columnIndexOrThrow23 = i21;
                int i22 = columnIndexOrThrow24;
                if (cursorQuery.getInt(i22) != 0) {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = true;
                } else {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = false;
                }
                if (cursorQuery.getInt(i2) != 0) {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = true;
                } else {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = false;
                }
                if (cursorQuery.getInt(i3) != 0) {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = true;
                } else {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = false;
                }
                if (cursorQuery.getInt(i4) != 0) {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = true;
                } else {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = false;
                }
                long j9 = cursorQuery.getLong(i5);
                columnIndexOrThrow28 = i5;
                int i23 = columnIndexOrThrow29;
                long j10 = cursorQuery.getLong(i23);
                columnIndexOrThrow29 = i23;
                int i24 = columnIndexOrThrow30;
                columnIndexOrThrow30 = i24;
                arrayList.add(new WorkSpec(string, stateIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(networkTypeIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i24) ? null : cursorQuery.getBlob(i24))), i7, backoffPolicyIntToBackoffPolicy, j4, j5, j6, j7, z, outOfQuotaPolicyIntToOutOfQuotaPolicy, i13, i15, j8, i18, i20));
                columnIndexOrThrow = i9;
                i6 = i8;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForSchedulingWithContentUris() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i6 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j = cursorQuery.getLong(columnIndexOrThrow7);
                long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                int i7 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                int i8 = i6;
                long j6 = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow;
                int i10 = columnIndexOrThrow15;
                long j7 = cursorQuery.getLong(i10);
                columnIndexOrThrow15 = i10;
                int i11 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = true;
                } else {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i));
                columnIndexOrThrow17 = i;
                int i12 = columnIndexOrThrow18;
                int i13 = cursorQuery.getInt(i12);
                columnIndexOrThrow18 = i12;
                int i14 = columnIndexOrThrow19;
                int i15 = cursorQuery.getInt(i14);
                columnIndexOrThrow19 = i14;
                int i16 = columnIndexOrThrow20;
                long j8 = cursorQuery.getLong(i16);
                columnIndexOrThrow20 = i16;
                int i17 = columnIndexOrThrow21;
                int i18 = cursorQuery.getInt(i17);
                columnIndexOrThrow21 = i17;
                int i19 = columnIndexOrThrow22;
                int i20 = cursorQuery.getInt(i19);
                columnIndexOrThrow22 = i19;
                int i21 = columnIndexOrThrow23;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i21));
                columnIndexOrThrow23 = i21;
                int i22 = columnIndexOrThrow24;
                if (cursorQuery.getInt(i22) != 0) {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = true;
                } else {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = false;
                }
                if (cursorQuery.getInt(i2) != 0) {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = true;
                } else {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = false;
                }
                if (cursorQuery.getInt(i3) != 0) {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = true;
                } else {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = false;
                }
                if (cursorQuery.getInt(i4) != 0) {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = true;
                } else {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = false;
                }
                long j9 = cursorQuery.getLong(i5);
                columnIndexOrThrow28 = i5;
                int i23 = columnIndexOrThrow29;
                long j10 = cursorQuery.getLong(i23);
                columnIndexOrThrow29 = i23;
                int i24 = columnIndexOrThrow30;
                columnIndexOrThrow30 = i24;
                arrayList.add(new WorkSpec(string, stateIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(networkTypeIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i24) ? null : cursorQuery.getBlob(i24))), i7, backoffPolicyIntToBackoffPolicy, j4, j5, j6, j7, z, outOfQuotaPolicyIntToOutOfQuotaPolicy, i13, i15, j8, i18, i20));
                columnIndexOrThrow = i9;
                i6 = i8;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(final int maxLimit) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, maxLimit);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i6 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j = cursorQuery.getLong(columnIndexOrThrow7);
                long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                int i7 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                int i8 = i6;
                long j6 = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow;
                int i10 = columnIndexOrThrow15;
                long j7 = cursorQuery.getLong(i10);
                columnIndexOrThrow15 = i10;
                int i11 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = true;
                } else {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i));
                columnIndexOrThrow17 = i;
                int i12 = columnIndexOrThrow18;
                int i13 = cursorQuery.getInt(i12);
                columnIndexOrThrow18 = i12;
                int i14 = columnIndexOrThrow19;
                int i15 = cursorQuery.getInt(i14);
                columnIndexOrThrow19 = i14;
                int i16 = columnIndexOrThrow20;
                long j8 = cursorQuery.getLong(i16);
                columnIndexOrThrow20 = i16;
                int i17 = columnIndexOrThrow21;
                int i18 = cursorQuery.getInt(i17);
                columnIndexOrThrow21 = i17;
                int i19 = columnIndexOrThrow22;
                int i20 = cursorQuery.getInt(i19);
                columnIndexOrThrow22 = i19;
                int i21 = columnIndexOrThrow23;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i21));
                columnIndexOrThrow23 = i21;
                int i22 = columnIndexOrThrow24;
                if (cursorQuery.getInt(i22) != 0) {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = true;
                } else {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = false;
                }
                if (cursorQuery.getInt(i2) != 0) {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = true;
                } else {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = false;
                }
                if (cursorQuery.getInt(i3) != 0) {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = true;
                } else {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = false;
                }
                if (cursorQuery.getInt(i4) != 0) {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = true;
                } else {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = false;
                }
                long j9 = cursorQuery.getLong(i5);
                columnIndexOrThrow28 = i5;
                int i23 = columnIndexOrThrow29;
                long j10 = cursorQuery.getLong(i23);
                columnIndexOrThrow29 = i23;
                int i24 = columnIndexOrThrow30;
                columnIndexOrThrow30 = i24;
                arrayList.add(new WorkSpec(string, stateIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(networkTypeIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i24) ? null : cursorQuery.getBlob(i24))), i7, backoffPolicyIntToBackoffPolicy, j4, j5, j6, j7, z, outOfQuotaPolicyIntToOutOfQuotaPolicy, i13, i15, j8, i18, i20));
                columnIndexOrThrow = i9;
                i6 = i8;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i6 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j = cursorQuery.getLong(columnIndexOrThrow7);
                long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                int i7 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                int i8 = i6;
                long j6 = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow;
                int i10 = columnIndexOrThrow15;
                long j7 = cursorQuery.getLong(i10);
                columnIndexOrThrow15 = i10;
                int i11 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = true;
                } else {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i));
                columnIndexOrThrow17 = i;
                int i12 = columnIndexOrThrow18;
                int i13 = cursorQuery.getInt(i12);
                columnIndexOrThrow18 = i12;
                int i14 = columnIndexOrThrow19;
                int i15 = cursorQuery.getInt(i14);
                columnIndexOrThrow19 = i14;
                int i16 = columnIndexOrThrow20;
                long j8 = cursorQuery.getLong(i16);
                columnIndexOrThrow20 = i16;
                int i17 = columnIndexOrThrow21;
                int i18 = cursorQuery.getInt(i17);
                columnIndexOrThrow21 = i17;
                int i19 = columnIndexOrThrow22;
                int i20 = cursorQuery.getInt(i19);
                columnIndexOrThrow22 = i19;
                int i21 = columnIndexOrThrow23;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i21));
                columnIndexOrThrow23 = i21;
                int i22 = columnIndexOrThrow24;
                if (cursorQuery.getInt(i22) != 0) {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = true;
                } else {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = false;
                }
                if (cursorQuery.getInt(i2) != 0) {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = true;
                } else {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = false;
                }
                if (cursorQuery.getInt(i3) != 0) {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = true;
                } else {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = false;
                }
                if (cursorQuery.getInt(i4) != 0) {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = true;
                } else {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = false;
                }
                long j9 = cursorQuery.getLong(i5);
                columnIndexOrThrow28 = i5;
                int i23 = columnIndexOrThrow29;
                long j10 = cursorQuery.getLong(i23);
                columnIndexOrThrow29 = i23;
                int i24 = columnIndexOrThrow30;
                columnIndexOrThrow30 = i24;
                arrayList.add(new WorkSpec(string, stateIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(networkTypeIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i24) ? null : cursorQuery.getBlob(i24))), i7, backoffPolicyIntToBackoffPolicy, j4, j5, j6, j7, z, outOfQuotaPolicyIntToOutOfQuotaPolicy, i13, i15, j8, i18, i20));
                columnIndexOrThrow = i9;
                i6 = i8;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRunningWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i6 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j = cursorQuery.getLong(columnIndexOrThrow7);
                long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                int i7 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                int i8 = i6;
                long j6 = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow;
                int i10 = columnIndexOrThrow15;
                long j7 = cursorQuery.getLong(i10);
                columnIndexOrThrow15 = i10;
                int i11 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = true;
                } else {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i));
                columnIndexOrThrow17 = i;
                int i12 = columnIndexOrThrow18;
                int i13 = cursorQuery.getInt(i12);
                columnIndexOrThrow18 = i12;
                int i14 = columnIndexOrThrow19;
                int i15 = cursorQuery.getInt(i14);
                columnIndexOrThrow19 = i14;
                int i16 = columnIndexOrThrow20;
                long j8 = cursorQuery.getLong(i16);
                columnIndexOrThrow20 = i16;
                int i17 = columnIndexOrThrow21;
                int i18 = cursorQuery.getInt(i17);
                columnIndexOrThrow21 = i17;
                int i19 = columnIndexOrThrow22;
                int i20 = cursorQuery.getInt(i19);
                columnIndexOrThrow22 = i19;
                int i21 = columnIndexOrThrow23;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i21));
                columnIndexOrThrow23 = i21;
                int i22 = columnIndexOrThrow24;
                if (cursorQuery.getInt(i22) != 0) {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = true;
                } else {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = false;
                }
                if (cursorQuery.getInt(i2) != 0) {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = true;
                } else {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = false;
                }
                if (cursorQuery.getInt(i3) != 0) {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = true;
                } else {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = false;
                }
                if (cursorQuery.getInt(i4) != 0) {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = true;
                } else {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = false;
                }
                long j9 = cursorQuery.getLong(i5);
                columnIndexOrThrow28 = i5;
                int i23 = columnIndexOrThrow29;
                long j10 = cursorQuery.getLong(i23);
                columnIndexOrThrow29 = i23;
                int i24 = columnIndexOrThrow30;
                columnIndexOrThrow30 = i24;
                arrayList.add(new WorkSpec(string, stateIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(networkTypeIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i24) ? null : cursorQuery.getBlob(i24))), i7, backoffPolicyIntToBackoffPolicy, j4, j5, j6, j7, z, outOfQuotaPolicyIntToOutOfQuotaPolicy, i13, i15, j8, i18, i20));
                columnIndexOrThrow = i9;
                i6 = i8;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRecentlyCompletedWork(final long startingAt) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, startingAt);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i6 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo.State stateIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j = cursorQuery.getLong(columnIndexOrThrow7);
                long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                int i7 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                int i8 = i6;
                long j6 = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow;
                int i10 = columnIndexOrThrow15;
                long j7 = cursorQuery.getLong(i10);
                columnIndexOrThrow15 = i10;
                int i11 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = true;
                } else {
                    columnIndexOrThrow16 = i11;
                    i = columnIndexOrThrow17;
                    z = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i));
                columnIndexOrThrow17 = i;
                int i12 = columnIndexOrThrow18;
                int i13 = cursorQuery.getInt(i12);
                columnIndexOrThrow18 = i12;
                int i14 = columnIndexOrThrow19;
                int i15 = cursorQuery.getInt(i14);
                columnIndexOrThrow19 = i14;
                int i16 = columnIndexOrThrow20;
                long j8 = cursorQuery.getLong(i16);
                columnIndexOrThrow20 = i16;
                int i17 = columnIndexOrThrow21;
                int i18 = cursorQuery.getInt(i17);
                columnIndexOrThrow21 = i17;
                int i19 = columnIndexOrThrow22;
                int i20 = cursorQuery.getInt(i19);
                columnIndexOrThrow22 = i19;
                int i21 = columnIndexOrThrow23;
                NetworkType networkTypeIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i21));
                columnIndexOrThrow23 = i21;
                int i22 = columnIndexOrThrow24;
                if (cursorQuery.getInt(i22) != 0) {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = true;
                } else {
                    columnIndexOrThrow24 = i22;
                    i2 = columnIndexOrThrow25;
                    z2 = false;
                }
                if (cursorQuery.getInt(i2) != 0) {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = true;
                } else {
                    columnIndexOrThrow25 = i2;
                    i3 = columnIndexOrThrow26;
                    z3 = false;
                }
                if (cursorQuery.getInt(i3) != 0) {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = true;
                } else {
                    columnIndexOrThrow26 = i3;
                    i4 = columnIndexOrThrow27;
                    z4 = false;
                }
                if (cursorQuery.getInt(i4) != 0) {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = true;
                } else {
                    columnIndexOrThrow27 = i4;
                    i5 = columnIndexOrThrow28;
                    z5 = false;
                }
                long j9 = cursorQuery.getLong(i5);
                columnIndexOrThrow28 = i5;
                int i23 = columnIndexOrThrow29;
                long j10 = cursorQuery.getLong(i23);
                columnIndexOrThrow29 = i23;
                int i24 = columnIndexOrThrow30;
                columnIndexOrThrow30 = i24;
                arrayList.add(new WorkSpec(string, stateIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(networkTypeIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i24) ? null : cursorQuery.getBlob(i24))), i7, backoffPolicyIntToBackoffPolicy, j4, j5, j6, j7, z, outOfQuotaPolicyIntToOutOfQuotaPolicy, i13, i15, j8, i18, i20));
                columnIndexOrThrow = i9;
                i6 = i8;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int countNonFinishedContentUriTriggerWorkers() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
