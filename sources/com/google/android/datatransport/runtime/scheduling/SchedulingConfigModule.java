package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes2.dex */
public abstract class SchedulingConfigModule {
    static SchedulerConfig config(Clock clock) {
        return SchedulerConfig.getDefault(clock);
    }
}
