package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

/* compiled from: ConstraintTrackingWorker.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR8\u0010 \u001a&\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\r0\r \u001f*\u0012\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\r0\r\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R(\u0010#\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00018G@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/ListenableWorker;", "Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "", "setupAndRunConstraintTrackingWork", "()V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ListenableWorker$Result;", "startWork", "()Lcom/google/common/util/concurrent/ListenableFuture;", "onStopped", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "Landroidx/work/impl/constraints/ConstraintsState;", "state", "onConstraintsStateChanged", "(Landroidx/work/impl/model/WorkSpec;Landroidx/work/impl/constraints/ConstraintsState;)V", "Landroidx/work/WorkerParameters;", "", "lock", "Ljava/lang/Object;", "", "areConstraintsUnmet", "Z", "Landroidx/work/impl/utils/futures/SettableFuture;", "kotlin.jvm.PlatformType", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "<set-?>", "delegate", "Landroidx/work/ListenableWorker;", "getDelegate", "()Landroidx/work/ListenableWorker;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {
    private volatile boolean areConstraintsUnmet;
    private ListenableWorker delegate;
    private final SettableFuture<ListenableWorker.Result> future;
    private final Object lock;
    private final WorkerParameters workerParameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context appContext, WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.workerParameters = workerParameters;
        this.lock = new Object();
        this.future = SettableFuture.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWork$lambda$0(ConstraintTrackingWorker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setupAndRunConstraintTrackingWork();
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConstraintTrackingWorker.startWork$lambda$0(this.f$0);
            }
        });
        SettableFuture<ListenableWorker.Result> future = this.future;
        Intrinsics.checkNotNullExpressionValue(future, "future");
        return future;
    }

    private final void setupAndRunConstraintTrackingWork() {
        if (this.future.isCancelled()) {
            return;
        }
        String string = getInputData().getString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        Logger logger = Logger.get();
        Intrinsics.checkNotNullExpressionValue(logger, "get()");
        if (string == null || string.length() == 0) {
            logger.error(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
            SettableFuture<ListenableWorker.Result> future = this.future;
            Intrinsics.checkNotNullExpressionValue(future, "future");
            ConstraintTrackingWorkerKt.setFailed(future);
            return;
        }
        ListenableWorker listenableWorkerCreateWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), string, this.workerParameters);
        this.delegate = listenableWorkerCreateWorkerWithDefaultFallback;
        if (listenableWorkerCreateWorkerWithDefaultFallback == null) {
            logger.debug(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
            SettableFuture<ListenableWorker.Result> future2 = this.future;
            Intrinsics.checkNotNullExpressionValue(future2, "future");
            ConstraintTrackingWorkerKt.setFailed(future2);
            return;
        }
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(workManagerImpl, "getInstance(applicationContext)");
        WorkSpecDao workSpecDao = workManagerImpl.getWorkDatabase().workSpecDao();
        String string2 = getId().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "id.toString()");
        WorkSpec workSpec = workSpecDao.getWorkSpec(string2);
        if (workSpec == null) {
            SettableFuture<ListenableWorker.Result> future3 = this.future;
            Intrinsics.checkNotNullExpressionValue(future3, "future");
            ConstraintTrackingWorkerKt.setFailed(future3);
            return;
        }
        Trackers trackers = workManagerImpl.getTrackers();
        Intrinsics.checkNotNullExpressionValue(trackers, "workManagerImpl.trackers");
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(trackers);
        CoroutineDispatcher taskCoroutineDispatcher = workManagerImpl.getWorkTaskExecutor().getTaskCoroutineDispatcher();
        Intrinsics.checkNotNullExpressionValue(taskCoroutineDispatcher, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
        final Job jobListen = WorkConstraintsTrackerKt.listen(workConstraintsTracker, workSpec, taskCoroutineDispatcher, this);
        this.future.addListener(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$1(jobListen);
            }
        }, new SynchronousExecutor());
        if (workConstraintsTracker.areAllConstraintsMet(workSpec)) {
            logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints met for delegate " + string);
            try {
                ListenableWorker listenableWorker = this.delegate;
                Intrinsics.checkNotNull(listenableWorker);
                final ListenableFuture<ListenableWorker.Result> listenableFutureStartWork = listenableWorker.startWork();
                Intrinsics.checkNotNullExpressionValue(listenableFutureStartWork, "delegate!!.startWork()");
                listenableFutureStartWork.addListener(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$3(this.f$0, listenableFutureStartWork);
                    }
                }, getBackgroundExecutor());
                return;
            } catch (Throwable th) {
                logger.debug(ConstraintTrackingWorkerKt.TAG, "Delegated worker " + string + " threw exception in startWork.", th);
                synchronized (this.lock) {
                    try {
                        if (this.areConstraintsUnmet) {
                            logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints were unmet, Retrying.");
                            SettableFuture<ListenableWorker.Result> future4 = this.future;
                            Intrinsics.checkNotNullExpressionValue(future4, "future");
                            ConstraintTrackingWorkerKt.setRetry(future4);
                            return;
                        }
                        SettableFuture<ListenableWorker.Result> future5 = this.future;
                        Intrinsics.checkNotNullExpressionValue(future5, "future");
                        ConstraintTrackingWorkerKt.setFailed(future5);
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
        logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints not met for delegate " + string + ". Requesting retry.");
        SettableFuture<ListenableWorker.Result> future6 = this.future;
        Intrinsics.checkNotNullExpressionValue(future6, "future");
        ConstraintTrackingWorkerKt.setRetry(future6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$1(Job job) {
        Intrinsics.checkNotNullParameter(job, "$job");
        job.cancel(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$3(ConstraintTrackingWorker this$0, ListenableFuture innerFuture) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(innerFuture, "$innerFuture");
        synchronized (this$0.lock) {
            try {
                if (this$0.areConstraintsUnmet) {
                    SettableFuture<ListenableWorker.Result> future = this$0.future;
                    Intrinsics.checkNotNullExpressionValue(future, "future");
                    ConstraintTrackingWorkerKt.setRetry(future);
                } else {
                    this$0.future.setFuture(innerFuture);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.delegate;
        if (listenableWorker == null || listenableWorker.isStopped()) {
            return;
        }
        listenableWorker.stop(Build.VERSION.SDK_INT >= 31 ? getStopReason() : 0);
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState state) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(state, "state");
        Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Constraints changed for " + workSpec);
        if (state instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.lock) {
                this.areConstraintsUnmet = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
