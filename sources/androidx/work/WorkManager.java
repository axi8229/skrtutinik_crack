package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
/* loaded from: classes.dex */
public abstract class WorkManager {

    public enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN
    }

    public abstract Operation cancelAllWorkByTag(String tag);

    public abstract Operation enqueue(List<? extends WorkRequest> requests);

    public abstract Operation enqueueUniquePeriodicWork(String uniqueWorkName, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWork);

    public static WorkManager getInstance(Context context) {
        return WorkManagerImpl.getInstance(context);
    }

    public static void initialize(Context context, Configuration configuration) {
        WorkManagerImpl.initialize(context, configuration);
    }

    public final Operation enqueue(WorkRequest workRequest) {
        return enqueue(Collections.singletonList(workRequest));
    }

    protected WorkManager() {
    }
}
