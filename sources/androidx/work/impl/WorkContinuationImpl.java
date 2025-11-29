package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class WorkContinuationImpl extends WorkContinuation {
    private static final String TAG = Logger.tagWithPrefix("WorkContinuationImpl");
    private final List<String> mAllIds;
    private boolean mEnqueued;
    private final ExistingWorkPolicy mExistingWorkPolicy;
    private final List<String> mIds;
    private final String mName;
    private Operation mOperation;
    private final List<WorkContinuationImpl> mParents;
    private final List<? extends WorkRequest> mWork;
    private final WorkManagerImpl mWorkManagerImpl;

    public WorkManagerImpl getWorkManagerImpl() {
        return this.mWorkManagerImpl;
    }

    public String getName() {
        return this.mName;
    }

    public ExistingWorkPolicy getExistingWorkPolicy() {
        return this.mExistingWorkPolicy;
    }

    public List<? extends WorkRequest> getWork() {
        return this.mWork;
    }

    public List<String> getIds() {
        return this.mIds;
    }

    public boolean isEnqueued() {
        return this.mEnqueued;
    }

    public void markEnqueued() {
        this.mEnqueued = true;
    }

    public List<WorkContinuationImpl> getParents() {
        return this.mParents;
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> work) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, work, null);
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String name, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> work) {
        this(workManagerImpl, name, existingWorkPolicy, work, null);
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String name, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> work, List<WorkContinuationImpl> parents) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mName = name;
        this.mExistingWorkPolicy = existingWorkPolicy;
        this.mWork = work;
        this.mParents = parents;
        this.mIds = new ArrayList(work.size());
        this.mAllIds = new ArrayList();
        if (parents != null) {
            Iterator<WorkContinuationImpl> it = parents.iterator();
            while (it.hasNext()) {
                this.mAllIds.addAll(it.next().mAllIds);
            }
        }
        for (int i = 0; i < work.size(); i++) {
            if (existingWorkPolicy == ExistingWorkPolicy.REPLACE && work.get(i).getWorkSpec().getNextScheduleTimeOverride() != Long.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String stringId = work.get(i).getStringId();
            this.mIds.add(stringId);
            this.mAllIds.add(stringId);
        }
    }

    public Operation enqueue() {
        if (!this.mEnqueued) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(enqueueRunnable);
            this.mOperation = enqueueRunnable.getOperation();
        } else {
            Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", this.mIds) + ")");
        }
        return this.mOperation;
    }

    public boolean hasCycles() {
        return hasCycles(this, new HashSet());
    }

    private static boolean hasCycles(WorkContinuationImpl continuation, Set<String> visited) {
        visited.addAll(continuation.getIds());
        Set<String> setPrerequisitesFor = prerequisitesFor(continuation);
        Iterator<String> it = visited.iterator();
        while (it.hasNext()) {
            if (setPrerequisitesFor.contains(it.next())) {
                return true;
            }
        }
        List<WorkContinuationImpl> parents = continuation.getParents();
        if (parents != null && !parents.isEmpty()) {
            Iterator<WorkContinuationImpl> it2 = parents.iterator();
            while (it2.hasNext()) {
                if (hasCycles(it2.next(), visited)) {
                    return true;
                }
            }
        }
        visited.removeAll(continuation.getIds());
        return false;
    }

    public static Set<String> prerequisitesFor(WorkContinuationImpl continuation) {
        HashSet hashSet = new HashSet();
        List<WorkContinuationImpl> parents = continuation.getParents();
        if (parents != null && !parents.isEmpty()) {
            Iterator<WorkContinuationImpl> it = parents.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().getIds());
            }
        }
        return hashSet;
    }
}
