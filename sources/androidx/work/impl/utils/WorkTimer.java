package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");
    final RunnableScheduler mRunnableScheduler;
    final Map<WorkGenerationalId, WorkTimerRunnable> mTimerMap = new HashMap();
    final Map<WorkGenerationalId, TimeLimitExceededListener> mListeners = new HashMap();
    final Object mLock = new Object();

    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(WorkGenerationalId id);
    }

    public WorkTimer(RunnableScheduler scheduler) {
        this.mRunnableScheduler = scheduler;
    }

    public void startTimer(final WorkGenerationalId id, long processingTimeMillis, TimeLimitExceededListener listener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Starting timer for " + id);
            stopTimer(id);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, id);
            this.mTimerMap.put(id, workTimerRunnable);
            this.mListeners.put(id, listener);
            this.mRunnableScheduler.scheduleWithDelay(processingTimeMillis, workTimerRunnable);
        }
    }

    public void stopTimer(final WorkGenerationalId id) {
        synchronized (this.mLock) {
            try {
                if (this.mTimerMap.remove(id) != null) {
                    Logger.get().debug(TAG, "Stopping timer for " + id);
                    this.mListeners.remove(id);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static class WorkTimerRunnable implements Runnable {
        private final WorkGenerationalId mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId id) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = id;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.mWorkTimer.mLock) {
                try {
                    if (this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId) != null) {
                        TimeLimitExceededListener timeLimitExceededListenerRemove = this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);
                        if (timeLimitExceededListenerRemove != null) {
                            timeLimitExceededListenerRemove.onTimeLimitExceeded(this.mWorkGenerationalId);
                        }
                    } else {
                        Logger.get().debug("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.mWorkGenerationalId));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
