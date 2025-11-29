package androidx.work.impl.model;

import android.annotation.SuppressLint;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WorkSpecDao.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0018\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0019\u0010\nJ\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\"\u0010\u0018J\u0017\u0010#\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b#\u0010\u0018J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0014H'¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b)\u0010\u0011J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010*\u001a\u00020\u0007H'¢\u0006\u0004\b+\u0010\u0011J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b,\u0010\u0011J\u000f\u0010.\u001a\u00020-H'¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001eH'¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0014H'¢\u0006\u0004\b3\u00104J\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u00105\u001a\u00020\u0014H'¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\b8\u00109J\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010:\u001a\u00020\u0014H'¢\u0006\u0004\b;\u00107J\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\b<\u00109J\u0015\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\b=\u00109J\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010>\u001a\u00020\u001eH'¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\bA\u0010\u0006J\u000f\u0010B\u001a\u00020\u0014H'¢\u0006\u0004\bB\u00104J\u001f\u0010D\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0014H'¢\u0006\u0004\bD\u0010&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006EÀ\u0006\u0001"}, d2 = {"Landroidx/work/impl/model/WorkSpecDao;", "", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "", "insertWorkSpec", "(Landroidx/work/impl/model/WorkSpec;)V", "", "id", "delete", "(Ljava/lang/String;)V", "getWorkSpec", "(Ljava/lang/String;)Landroidx/work/impl/model/WorkSpec;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "Landroidx/work/impl/model/WorkSpec$IdAndState;", "getWorkSpecIdAndStatesForName", "(Ljava/lang/String;)Ljava/util/List;", "Landroidx/work/WorkInfo$State;", "state", "", "setState", "(Landroidx/work/WorkInfo$State;Ljava/lang/String;)I", "setCancelledState", "(Ljava/lang/String;)I", "incrementPeriodCount", "Landroidx/work/Data;", "output", "setOutput", "(Ljava/lang/String;Landroidx/work/Data;)V", "", "enqueueTime", "setLastEnqueueTime", "(Ljava/lang/String;J)V", "incrementWorkSpecRunAttemptCount", "resetWorkSpecRunAttemptCount", "overrideGeneration", "resetWorkSpecNextScheduleTimeOverride", "(Ljava/lang/String;I)V", "getState", "(Ljava/lang/String;)Landroidx/work/WorkInfo$State;", "getInputsFromPrerequisites", RemoteMessageConst.Notification.TAG, "getUnfinishedWorkWithTag", "getUnfinishedWorkWithName", "", "hasUnfinishedWork", "()Z", "startTime", "markWorkSpecScheduled", "(Ljava/lang/String;J)I", "resetScheduledState", "()I", "schedulerLimit", "getEligibleWorkForScheduling", "(I)Ljava/util/List;", "getEligibleWorkForSchedulingWithContentUris", "()Ljava/util/List;", "maxLimit", "getAllEligibleWorkSpecsForScheduling", "getScheduledWork", "getRunningWork", "startingAt", "getRecentlyCompletedWork", "(J)Ljava/util/List;", "updateWorkSpec", "countNonFinishedContentUriTriggerWorkers", "stopReason", "setStopReason", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public interface WorkSpecDao {
    int countNonFinishedContentUriTriggerWorkers();

    void delete(String id);

    List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int maxLimit);

    List<WorkSpec> getEligibleWorkForScheduling(int schedulerLimit);

    List<WorkSpec> getEligibleWorkForSchedulingWithContentUris();

    List<Data> getInputsFromPrerequisites(String id);

    List<WorkSpec> getRecentlyCompletedWork(long startingAt);

    List<WorkSpec> getRunningWork();

    List<WorkSpec> getScheduledWork();

    WorkInfo.State getState(String id);

    List<String> getUnfinishedWorkWithName(String name);

    List<String> getUnfinishedWorkWithTag(String tag);

    WorkSpec getWorkSpec(String id);

    List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String name);

    boolean hasUnfinishedWork();

    void incrementPeriodCount(String id);

    int incrementWorkSpecRunAttemptCount(String id);

    void insertWorkSpec(WorkSpec workSpec);

    int markWorkSpecScheduled(String id, long startTime);

    int resetScheduledState();

    void resetWorkSpecNextScheduleTimeOverride(String id, int overrideGeneration);

    int resetWorkSpecRunAttemptCount(String id);

    int setCancelledState(String id);

    void setLastEnqueueTime(String id, long enqueueTime);

    void setOutput(String id, Data output);

    int setState(WorkInfo.State state, String id);

    void setStopReason(String id, int stopReason);

    void updateWorkSpec(WorkSpec workSpec);
}
