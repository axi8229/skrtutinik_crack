package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class Schedulers {
    static final Scheduler SINGLE = RxJavaPlugins.initSingleScheduler(new SingleTask());
    static final Scheduler COMPUTATION = RxJavaPlugins.initComputationScheduler(new ComputationTask());
    static final Scheduler IO = RxJavaPlugins.initIoScheduler(new IOTask());
    static final Scheduler TRAMPOLINE = TrampolineScheduler.instance();
    static final Scheduler NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());

    static final class ComputationHolder {
        static final Scheduler DEFAULT = new ComputationScheduler();
    }

    static final class IoHolder {
        static final Scheduler DEFAULT = new IoScheduler();
    }

    static final class NewThreadHolder {
        static final Scheduler DEFAULT = new NewThreadScheduler();
    }

    static final class SingleHolder {
        static final Scheduler DEFAULT = new SingleScheduler();
    }

    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(COMPUTATION);
    }

    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(IO);
    }

    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return IoHolder.DEFAULT;
        }
    }

    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return NewThreadHolder.DEFAULT;
        }
    }

    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return SingleHolder.DEFAULT;
        }
    }

    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return ComputationHolder.DEFAULT;
        }
    }
}
