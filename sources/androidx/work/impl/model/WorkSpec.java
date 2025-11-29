package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* compiled from: WorkSpec.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b'\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0003MNOBé\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010%B\u0019\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010(J\u0015\u0010*\u001a\u00020)2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b*\u0010+J\u001d\u0010*\u001a\u00020)2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b*\u0010,J\r\u0010-\u001a\u00020\u000b¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u0019¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u00102Jö\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0003\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00107\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b7\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u00109R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010:R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u00109R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u00109R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010;R\u0016\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010;R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010<R\u0016\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010<R\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010<R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010=R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010>R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010?R\u0016\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010<R\u0016\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010<R\u0016\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010<R\u0016\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010<R\u0016\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010@R\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010AR\"\u0010\u001d\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010>\u001a\u0004\bB\u00106\"\u0004\bC\u0010DR\u001a\u0010\u001e\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010>\u001a\u0004\bE\u00106R\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010<\u001a\u0004\bF\u0010.\"\u0004\bG\u0010+R\"\u0010 \u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010>\u001a\u0004\bH\u00106\"\u0004\bI\u0010DR\u001a\u0010!\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010>\u001a\u0004\bJ\u00106R\u0011\u0010K\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\bK\u00100R\u0011\u0010L\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\bL\u00100¨\u0006P"}, d2 = {"Landroidx/work/impl/model/WorkSpec;", "", "", "id", "Landroidx/work/WorkInfo$State;", "state", "workerClassName", "inputMergerClassName", "Landroidx/work/Data;", "input", "output", "", "initialDelay", "intervalDuration", "flexDuration", "Landroidx/work/Constraints;", "constraints", "", "runAttemptCount", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "", "expedited", "Landroidx/work/OutOfQuotaPolicy;", "outOfQuotaPolicy", "periodCount", "generation", "nextScheduleTimeOverride", "nextScheduleTimeOverrideGeneration", "stopReason", "<init>", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;IIJII)V", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "other", "(Ljava/lang/String;Landroidx/work/impl/model/WorkSpec;)V", "", "setPeriodic", "(J)V", "(JJ)V", "calculateNextRunTime", "()J", "hasConstraints", "()Z", "toString", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;IIJII)Landroidx/work/impl/model/WorkSpec;", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "Landroidx/work/WorkInfo$State;", "Landroidx/work/Data;", "J", "Landroidx/work/Constraints;", "I", "Landroidx/work/BackoffPolicy;", "Z", "Landroidx/work/OutOfQuotaPolicy;", "getPeriodCount", "setPeriodCount", "(I)V", "getGeneration", "getNextScheduleTimeOverride", "setNextScheduleTimeOverride", "getNextScheduleTimeOverrideGeneration", "setNextScheduleTimeOverrideGeneration", "getStopReason", "isPeriodic", "isBackedOff", "Companion", "IdAndState", "WorkInfoPojo", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WorkSpec {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER;
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    private final int generation;
    public final String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long lastEnqueueTime;
    public long minimumRetentionDuration;
    private long nextScheduleTimeOverride;
    private int nextScheduleTimeOverrideGeneration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    private int periodCount;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public WorkInfo.State state;
    private final int stopReason;
    public String workerClassName;

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j4, long j5, long j6, long j7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i3, long j8, int i4, int i5, int i6, Object obj) {
        String str4 = (i6 & 1) != 0 ? workSpec.id : str;
        WorkInfo.State state2 = (i6 & 2) != 0 ? workSpec.state : state;
        String str5 = (i6 & 4) != 0 ? workSpec.workerClassName : str2;
        String str6 = (i6 & 8) != 0 ? workSpec.inputMergerClassName : str3;
        Data data3 = (i6 & 16) != 0 ? workSpec.input : data;
        Data data4 = (i6 & 32) != 0 ? workSpec.output : data2;
        long j9 = (i6 & 64) != 0 ? workSpec.initialDelay : j;
        long j10 = (i6 & 128) != 0 ? workSpec.intervalDuration : j2;
        long j11 = (i6 & 256) != 0 ? workSpec.flexDuration : j3;
        Constraints constraints2 = (i6 & 512) != 0 ? workSpec.constraints : constraints;
        return workSpec.copy(str4, state2, str5, str6, data3, data4, j9, j10, j11, constraints2, (i6 & 1024) != 0 ? workSpec.runAttemptCount : i, (i6 & 2048) != 0 ? workSpec.backoffPolicy : backoffPolicy, (i6 & 4096) != 0 ? workSpec.backoffDelayDuration : j4, (i6 & 8192) != 0 ? workSpec.lastEnqueueTime : j5, (i6 & 16384) != 0 ? workSpec.minimumRetentionDuration : j6, (i6 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? workSpec.scheduleRequestedAt : j7, (i6 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? workSpec.expedited : z, (131072 & i6) != 0 ? workSpec.outOfQuotaPolicy : outOfQuotaPolicy, (i6 & 262144) != 0 ? workSpec.periodCount : i2, (i6 & 524288) != 0 ? workSpec.generation : i3, (i6 & 1048576) != 0 ? workSpec.nextScheduleTimeOverride : j8, (i6 & 2097152) != 0 ? workSpec.nextScheduleTimeOverrideGeneration : i4, (i6 & 4194304) != 0 ? workSpec.stopReason : i5);
    }

    public final WorkSpec copy(String id, WorkInfo.State state, String workerClassName, String inputMergerClassName, Data input, Data output, long initialDelay, long intervalDuration, long flexDuration, Constraints constraints, int runAttemptCount, BackoffPolicy backoffPolicy, long backoffDelayDuration, long lastEnqueueTime, long minimumRetentionDuration, long scheduleRequestedAt, boolean expedited, OutOfQuotaPolicy outOfQuotaPolicy, int periodCount, int generation, long nextScheduleTimeOverride, int nextScheduleTimeOverrideGeneration, int stopReason) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new WorkSpec(id, state, workerClassName, inputMergerClassName, input, output, initialDelay, intervalDuration, flexDuration, constraints, runAttemptCount, backoffPolicy, backoffDelayDuration, lastEnqueueTime, minimumRetentionDuration, scheduleRequestedAt, expedited, outOfQuotaPolicy, periodCount, generation, nextScheduleTimeOverride, nextScheduleTimeOverrideGeneration, stopReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) other;
        return Intrinsics.areEqual(this.id, workSpec.id) && this.state == workSpec.state && Intrinsics.areEqual(this.workerClassName, workSpec.workerClassName) && Intrinsics.areEqual(this.inputMergerClassName, workSpec.inputMergerClassName) && Intrinsics.areEqual(this.input, workSpec.input) && Intrinsics.areEqual(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && Intrinsics.areEqual(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31) + this.inputMergerClassName.hashCode()) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + Long.hashCode(this.initialDelay)) * 31) + Long.hashCode(this.intervalDuration)) * 31) + Long.hashCode(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + Integer.hashCode(this.runAttemptCount)) * 31) + this.backoffPolicy.hashCode()) * 31) + Long.hashCode(this.backoffDelayDuration)) * 31) + Long.hashCode(this.lastEnqueueTime)) * 31) + Long.hashCode(this.minimumRetentionDuration)) * 31) + Long.hashCode(this.scheduleRequestedAt)) * 31;
        boolean z = this.expedited;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((((((((((iHashCode + i) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + Integer.hashCode(this.periodCount)) * 31) + Integer.hashCode(this.generation)) * 31) + Long.hashCode(this.nextScheduleTimeOverride)) * 31) + Integer.hashCode(this.nextScheduleTimeOverrideGeneration)) * 31) + Integer.hashCode(this.stopReason);
    }

    public WorkSpec(String id, WorkInfo.State state, String workerClassName, String inputMergerClassName, Data input, Data output, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j4, long j5, long j6, long j7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i3, long j8, int i4, int i5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.id = id;
        this.state = state;
        this.workerClassName = workerClassName;
        this.inputMergerClassName = inputMergerClassName;
        this.input = input;
        this.output = output;
        this.initialDelay = j;
        this.intervalDuration = j2;
        this.flexDuration = j3;
        this.constraints = constraints;
        this.runAttemptCount = i;
        this.backoffPolicy = backoffPolicy;
        this.backoffDelayDuration = j4;
        this.lastEnqueueTime = j5;
        this.minimumRetentionDuration = j6;
        this.scheduleRequestedAt = j7;
        this.expedited = z;
        this.outOfQuotaPolicy = outOfQuotaPolicy;
        this.periodCount = i2;
        this.generation = i3;
        this.nextScheduleTimeOverride = j8;
        this.nextScheduleTimeOverrideGeneration = i4;
        this.stopReason = i5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j4, long j5, long j6, long j7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i3, long j8, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        String str4;
        Data data3;
        Data data4;
        WorkInfo.State state2 = (i6 & 2) != 0 ? WorkInfo.State.ENQUEUED : state;
        if ((i6 & 8) != 0) {
            String name = OverwritingInputMerger.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "OverwritingInputMerger::class.java.name");
            str4 = name;
        } else {
            str4 = str3;
        }
        if ((i6 & 16) != 0) {
            Data EMPTY = Data.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            data3 = EMPTY;
        } else {
            data3 = data;
        }
        if ((i6 & 32) != 0) {
            Data EMPTY2 = Data.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
            data4 = EMPTY2;
        } else {
            data4 = data2;
        }
        this(str, state2, str2, str4, data3, data4, (i6 & 64) != 0 ? 0L : j, (i6 & 128) != 0 ? 0L : j2, (i6 & 256) != 0 ? 0L : j3, (i6 & 512) != 0 ? Constraints.NONE : constraints, (i6 & 1024) != 0 ? 0 : i, (i6 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i6 & 4096) != 0 ? UtilsKt.UPDATE_INTERVAL : j4, (i6 & 8192) != 0 ? -1L : j5, (i6 & 16384) != 0 ? 0L : j6, (32768 & i6) != 0 ? -1L : j7, (65536 & i6) != 0 ? false : z, (131072 & i6) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i6) != 0 ? 0 : i2, (524288 & i6) != 0 ? 0 : i3, (1048576 & i6) != 0 ? Long.MAX_VALUE : j8, (2097152 & i6) != 0 ? 0 : i4, (i6 & 4194304) != 0 ? -256 : i5);
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final void setNextScheduleTimeOverride(long j) {
        this.nextScheduleTimeOverride = j;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final void setNextScheduleTimeOverrideGeneration(int i) {
        this.nextScheduleTimeOverrideGeneration = i;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String id, String workerClassName_) {
        this(id, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388602, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(workerClassName_, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String newId, WorkSpec other) {
        this(newId, other.state, other.workerClassName, other.inputMergerClassName, new Data(other.input), new Data(other.output), other.initialDelay, other.intervalDuration, other.flexDuration, new Constraints(other.constraints), other.runAttemptCount, other.backoffPolicy, other.backoffDelayDuration, other.lastEnqueueTime, other.minimumRetentionDuration, other.scheduleRequestedAt, other.expedited, other.outOfQuotaPolicy, other.periodCount, 0, other.nextScheduleTimeOverride, other.nextScheduleTimeOverrideGeneration, other.stopReason, 524288, null);
        Intrinsics.checkNotNullParameter(newId, "newId");
        Intrinsics.checkNotNullParameter(other, "other");
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public final void setPeriodic(long intervalDuration) {
        if (intervalDuration < 900000) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        setPeriodic(RangesKt.coerceAtLeast(intervalDuration, 900000L), RangesKt.coerceAtLeast(intervalDuration, 900000L));
    }

    public final void setPeriodic(long intervalDuration, long flexDuration) {
        if (intervalDuration < 900000) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = RangesKt.coerceAtLeast(intervalDuration, 900000L);
        if (flexDuration < 300000) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (flexDuration > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + intervalDuration);
        }
        this.flexDuration = RangesKt.coerceIn(flexDuration, 300000L, this.intervalDuration);
    }

    public final long calculateNextRunTime() {
        return INSTANCE.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    public final boolean hasConstraints() {
        return !Intrinsics.areEqual(Constraints.NONE, this.constraints);
    }

    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }

    /* compiled from: WorkSpec.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/work/impl/model/WorkSpec$IdAndState;", "", "", "id", "Landroidx/work/WorkInfo$State;", "state", "<init>", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "Landroidx/work/WorkInfo$State;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class IdAndState {
        public String id;
        public WorkInfo.State state;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) other;
            return Intrinsics.areEqual(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }

        public IdAndState(String id, WorkInfo.State state) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            this.id = id;
            this.state = state;
        }
    }

    /* compiled from: WorkSpec.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u001a\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010\u0007R\u001a\u0010'\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010\u0007R\u001a\u0010*\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0010R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010#\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010;R\"\u0010<\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010#\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010;R\"\u0010?\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010/\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010/\u001a\u0004\bD\u0010\u0010R\u001a\u0010E\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010#\u001a\u0004\bF\u0010\u0007R\u001a\u0010G\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010/\u001a\u0004\bH\u0010\u0010R \u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0I8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR \u0010N\u001a\b\u0012\u0004\u0012\u00020\u001d0I8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010K\u001a\u0004\bO\u0010MR\u0011\u0010P\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010R\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bR\u0010Q¨\u0006S"}, d2 = {"Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "", "Landroidx/work/WorkInfo$PeriodicityInfo;", "getPeriodicityOrNull", "()Landroidx/work/WorkInfo$PeriodicityInfo;", "", "calculateNextRunTimeMillis", "()J", "Landroidx/work/WorkInfo;", "toWorkInfo", "()Landroidx/work/WorkInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "id", "Ljava/lang/String;", "getId", "Landroidx/work/WorkInfo$State;", "state", "Landroidx/work/WorkInfo$State;", "getState", "()Landroidx/work/WorkInfo$State;", "Landroidx/work/Data;", "output", "Landroidx/work/Data;", "getOutput", "()Landroidx/work/Data;", "initialDelay", "J", "getInitialDelay", "intervalDuration", "getIntervalDuration", "flexDuration", "getFlexDuration", "Landroidx/work/Constraints;", "constraints", "Landroidx/work/Constraints;", "getConstraints", "()Landroidx/work/Constraints;", "runAttemptCount", "I", "getRunAttemptCount", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "getBackoffPolicy", "()Landroidx/work/BackoffPolicy;", "setBackoffPolicy", "(Landroidx/work/BackoffPolicy;)V", "backoffDelayDuration", "getBackoffDelayDuration", "setBackoffDelayDuration", "(J)V", "lastEnqueueTime", "getLastEnqueueTime", "setLastEnqueueTime", "periodCount", "getPeriodCount", "setPeriodCount", "(I)V", "generation", "getGeneration", "nextScheduleTimeOverride", "getNextScheduleTimeOverride", "stopReason", "getStopReason", "", "tags", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "progress", "getProgress", "isPeriodic", "()Z", "isBackedOff", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class WorkInfoPojo {
        private long backoffDelayDuration;
        private BackoffPolicy backoffPolicy;
        private final Constraints constraints;
        private final long flexDuration;
        private final int generation;
        private final String id;
        private final long initialDelay;
        private final long intervalDuration;
        private long lastEnqueueTime;
        private final long nextScheduleTimeOverride;
        private final Data output;
        private int periodCount;
        private final List<Data> progress;
        private final int runAttemptCount;
        private final WorkInfo.State state;
        private final int stopReason;
        private final List<String> tags;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) other;
            return Intrinsics.areEqual(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && Intrinsics.areEqual(this.output, workInfoPojo.output) && this.initialDelay == workInfoPojo.initialDelay && this.intervalDuration == workInfoPojo.intervalDuration && this.flexDuration == workInfoPojo.flexDuration && Intrinsics.areEqual(this.constraints, workInfoPojo.constraints) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.backoffPolicy == workInfoPojo.backoffPolicy && this.backoffDelayDuration == workInfoPojo.backoffDelayDuration && this.lastEnqueueTime == workInfoPojo.lastEnqueueTime && this.periodCount == workInfoPojo.periodCount && this.generation == workInfoPojo.generation && this.nextScheduleTimeOverride == workInfoPojo.nextScheduleTimeOverride && this.stopReason == workInfoPojo.stopReason && Intrinsics.areEqual(this.tags, workInfoPojo.tags) && Intrinsics.areEqual(this.progress, workInfoPojo.progress);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + Long.hashCode(this.initialDelay)) * 31) + Long.hashCode(this.intervalDuration)) * 31) + Long.hashCode(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + Integer.hashCode(this.runAttemptCount)) * 31) + this.backoffPolicy.hashCode()) * 31) + Long.hashCode(this.backoffDelayDuration)) * 31) + Long.hashCode(this.lastEnqueueTime)) * 31) + Integer.hashCode(this.periodCount)) * 31) + Integer.hashCode(this.generation)) * 31) + Long.hashCode(this.nextScheduleTimeOverride)) * 31) + Integer.hashCode(this.stopReason)) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", initialDelay=" + this.initialDelay + ", intervalDuration=" + this.intervalDuration + ", flexDuration=" + this.flexDuration + ", constraints=" + this.constraints + ", runAttemptCount=" + this.runAttemptCount + ", backoffPolicy=" + this.backoffPolicy + ", backoffDelayDuration=" + this.backoffDelayDuration + ", lastEnqueueTime=" + this.lastEnqueueTime + ", periodCount=" + this.periodCount + ", generation=" + this.generation + ", nextScheduleTimeOverride=" + this.nextScheduleTimeOverride + ", stopReason=" + this.stopReason + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public final boolean isPeriodic() {
            return this.intervalDuration != 0;
        }

        public final boolean isBackedOff() {
            return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
        }

        public final WorkInfo toWorkInfo() {
            Data progress = !this.progress.isEmpty() ? this.progress.get(0) : Data.EMPTY;
            UUID uuidFromString = UUID.fromString(this.id);
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(id)");
            WorkInfo.State state = this.state;
            HashSet hashSet = new HashSet(this.tags);
            Data data = this.output;
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            return new WorkInfo(uuidFromString, state, hashSet, data, progress, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, getPeriodicityOrNull(), calculateNextRunTimeMillis(), this.stopReason);
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            long j = this.intervalDuration;
            if (j != 0) {
                return new WorkInfo.PeriodicityInfo(j, this.flexDuration);
            }
            return null;
        }

        private final long calculateNextRunTimeMillis() {
            if (this.state == WorkInfo.State.ENQUEUED) {
                return WorkSpec.INSTANCE.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
            }
            return Long.MAX_VALUE;
        }
    }

    /* compiled from: WorkSpec.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/work/impl/model/WorkSpec$Companion;", "", "()V", "SCHEDULE_NOT_REQUESTED_YET", "", "TAG", "", "WORK_INFO_MAPPER", "Landroidx/arch/core/util/Function;", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "Landroidx/work/WorkInfo;", "calculateNextRunTime", "isBackedOff", "", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "isPeriodic", "initialDelay", "flexDuration", "intervalDuration", "nextScheduleTimeOverride", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long calculateNextRunTime(boolean isBackedOff, int runAttemptCount, BackoffPolicy backoffPolicy, long backoffDelayDuration, long lastEnqueueTime, int periodCount, boolean isPeriodic, long initialDelay, long flexDuration, long intervalDuration, long nextScheduleTimeOverride) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            if (nextScheduleTimeOverride != Long.MAX_VALUE && isPeriodic) {
                return periodCount == 0 ? nextScheduleTimeOverride : RangesKt.coerceAtLeast(nextScheduleTimeOverride, 900000 + lastEnqueueTime);
            }
            if (isBackedOff) {
                return lastEnqueueTime + RangesKt.coerceAtMost(backoffPolicy == BackoffPolicy.LINEAR ? runAttemptCount * backoffDelayDuration : (long) Math.scalb(backoffDelayDuration, runAttemptCount - 1), 18000000L);
            }
            if (!isPeriodic) {
                if (lastEnqueueTime == -1) {
                    return Long.MAX_VALUE;
                }
                return lastEnqueueTime + initialDelay;
            }
            long j = periodCount == 0 ? lastEnqueueTime + initialDelay : lastEnqueueTime + intervalDuration;
            if (flexDuration != intervalDuration && periodCount == 0) {
                j += intervalDuration - flexDuration;
            }
            return j;
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        TAG = strTagWithPrefix;
        WORK_INFO_MAPPER = new Function() { // from class: androidx.work.impl.model.WorkSpec$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkInfoPojo) it.next()).toWorkInfo());
        }
        return arrayList;
    }
}
