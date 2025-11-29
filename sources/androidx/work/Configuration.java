package androidx.work;

import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Configuration.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0003@?AB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001f\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001f\u0010'\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&R\u0019\u0010*\u001a\u0004\u0018\u00010)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010/\u001a\u00020.8G¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00103\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R\u0017\u00105\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00102R\u0017\u00107\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b7\u00100\u001a\u0004\b8\u00102R\u0017\u00109\u001a\u00020.8G¢\u0006\f\n\u0004\b9\u00100\u001a\u0004\b:\u00102R\u0017\u0010<\u001a\u00020;8G¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b<\u0010>¨\u0006B"}, d2 = {"Landroidx/work/Configuration;", "", "Landroidx/work/Configuration$Builder;", "builder", "<init>", "(Landroidx/work/Configuration$Builder;)V", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "taskExecutor", "getTaskExecutor", "Landroidx/work/Clock;", "clock", "Landroidx/work/Clock;", "getClock", "()Landroidx/work/Clock;", "Landroidx/work/WorkerFactory;", "workerFactory", "Landroidx/work/WorkerFactory;", "getWorkerFactory", "()Landroidx/work/WorkerFactory;", "Landroidx/work/InputMergerFactory;", "inputMergerFactory", "Landroidx/work/InputMergerFactory;", "getInputMergerFactory", "()Landroidx/work/InputMergerFactory;", "Landroidx/work/RunnableScheduler;", "runnableScheduler", "Landroidx/work/RunnableScheduler;", "getRunnableScheduler", "()Landroidx/work/RunnableScheduler;", "Landroidx/core/util/Consumer;", "", "initializationExceptionHandler", "Landroidx/core/util/Consumer;", "getInitializationExceptionHandler", "()Landroidx/core/util/Consumer;", "schedulingExceptionHandler", "getSchedulingExceptionHandler", "", "defaultProcessName", "Ljava/lang/String;", "getDefaultProcessName", "()Ljava/lang/String;", "", "minimumLoggingLevel", "I", "getMinimumLoggingLevel", "()I", "minJobSchedulerId", "getMinJobSchedulerId", "maxJobSchedulerId", "getMaxJobSchedulerId", "contentUriTriggerWorkersLimit", "getContentUriTriggerWorkersLimit", "maxSchedulerLimit", "getMaxSchedulerLimit", "", "isUsingDefaultTaskExecutor", "Z", "()Z", "Companion", "Builder", "Provider", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Configuration {
    private final Clock clock;
    private final int contentUriTriggerWorkersLimit;
    private final String defaultProcessName;
    private final Executor executor;
    private final Consumer<Throwable> initializationExceptionHandler;
    private final InputMergerFactory inputMergerFactory;
    private final boolean isUsingDefaultTaskExecutor;
    private final int maxJobSchedulerId;
    private final int maxSchedulerLimit;
    private final int minJobSchedulerId;
    private final int minimumLoggingLevel;
    private final RunnableScheduler runnableScheduler;
    private final Consumer<Throwable> schedulingExceptionHandler;
    private final Executor taskExecutor;
    private final WorkerFactory workerFactory;

    /* compiled from: Configuration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/work/Configuration$Provider;", "", "workManagerConfiguration", "Landroidx/work/Configuration;", "getWorkManagerConfiguration", "()Landroidx/work/Configuration;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Executor executor = builder.getExecutor();
        this.executor = executor == null ? ConfigurationKt.createDefaultExecutor(false) : executor;
        this.isUsingDefaultTaskExecutor = builder.getTaskExecutor() == null;
        Executor taskExecutor = builder.getTaskExecutor();
        this.taskExecutor = taskExecutor == null ? ConfigurationKt.createDefaultExecutor(true) : taskExecutor;
        Clock clock = builder.getClock();
        this.clock = clock == null ? new SystemClock() : clock;
        WorkerFactory workerFactory = builder.getWorkerFactory();
        if (workerFactory == null) {
            workerFactory = WorkerFactory.getDefaultWorkerFactory();
            Intrinsics.checkNotNullExpressionValue(workerFactory, "getDefaultWorkerFactory()");
        }
        this.workerFactory = workerFactory;
        InputMergerFactory inputMergerFactory = builder.getInputMergerFactory();
        this.inputMergerFactory = inputMergerFactory == null ? NoOpInputMergerFactory.INSTANCE : inputMergerFactory;
        RunnableScheduler runnableScheduler = builder.getRunnableScheduler();
        this.runnableScheduler = runnableScheduler == null ? new DefaultRunnableScheduler() : runnableScheduler;
        this.minimumLoggingLevel = builder.getLoggingLevel();
        this.minJobSchedulerId = builder.getMinJobSchedulerId();
        this.maxJobSchedulerId = builder.getMaxJobSchedulerId();
        this.maxSchedulerLimit = builder.getMaxSchedulerLimit();
        this.initializationExceptionHandler = builder.getInitializationExceptionHandler$work_runtime_release();
        this.schedulingExceptionHandler = builder.getSchedulingExceptionHandler$work_runtime_release();
        this.defaultProcessName = builder.getDefaultProcessName();
        this.contentUriTriggerWorkersLimit = builder.getContentUriTriggerWorkersLimit();
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final WorkerFactory getWorkerFactory() {
        return this.workerFactory;
    }

    public final InputMergerFactory getInputMergerFactory() {
        return this.inputMergerFactory;
    }

    public final RunnableScheduler getRunnableScheduler() {
        return this.runnableScheduler;
    }

    public final Consumer<Throwable> getInitializationExceptionHandler() {
        return this.initializationExceptionHandler;
    }

    public final Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.schedulingExceptionHandler;
    }

    public final String getDefaultProcessName() {
        return this.defaultProcessName;
    }

    public final int getMinimumLoggingLevel() {
        return this.minimumLoggingLevel;
    }

    public final int getMinJobSchedulerId() {
        return this.minJobSchedulerId;
    }

    public final int getMaxJobSchedulerId() {
        return this.maxJobSchedulerId;
    }

    public final int getContentUriTriggerWorkersLimit() {
        return this.contentUriTriggerWorkersLimit;
    }

    public final int getMaxSchedulerLimit() {
        return this.maxSchedulerLimit;
    }

    /* compiled from: Configuration.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u00105\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b7\u00104R$\u00109\u001a\u0004\u0018\u0001088\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010A\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\"\u0010I\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bI\u0010A\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER\"\u0010L\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bL\u0010A\u001a\u0004\bM\u0010C\"\u0004\bN\u0010ER\"\u0010O\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bO\u0010A\u001a\u0004\bP\u0010C\"\u0004\bQ\u0010E¨\u0006R"}, d2 = {"Landroidx/work/Configuration$Builder;", "", "<init>", "()V", "Landroidx/work/Configuration;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Landroidx/work/Configuration;", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor$work_runtime_release", "()Ljava/util/concurrent/Executor;", "setExecutor$work_runtime_release", "(Ljava/util/concurrent/Executor;)V", "Landroidx/work/WorkerFactory;", "workerFactory", "Landroidx/work/WorkerFactory;", "getWorkerFactory$work_runtime_release", "()Landroidx/work/WorkerFactory;", "setWorkerFactory$work_runtime_release", "(Landroidx/work/WorkerFactory;)V", "Landroidx/work/InputMergerFactory;", "inputMergerFactory", "Landroidx/work/InputMergerFactory;", "getInputMergerFactory$work_runtime_release", "()Landroidx/work/InputMergerFactory;", "setInputMergerFactory$work_runtime_release", "(Landroidx/work/InputMergerFactory;)V", "taskExecutor", "getTaskExecutor$work_runtime_release", "setTaskExecutor$work_runtime_release", "Landroidx/work/Clock;", "clock", "Landroidx/work/Clock;", "getClock$work_runtime_release", "()Landroidx/work/Clock;", "setClock$work_runtime_release", "(Landroidx/work/Clock;)V", "Landroidx/work/RunnableScheduler;", "runnableScheduler", "Landroidx/work/RunnableScheduler;", "getRunnableScheduler$work_runtime_release", "()Landroidx/work/RunnableScheduler;", "setRunnableScheduler$work_runtime_release", "(Landroidx/work/RunnableScheduler;)V", "Landroidx/core/util/Consumer;", "", "initializationExceptionHandler", "Landroidx/core/util/Consumer;", "getInitializationExceptionHandler$work_runtime_release", "()Landroidx/core/util/Consumer;", "setInitializationExceptionHandler$work_runtime_release", "(Landroidx/core/util/Consumer;)V", "schedulingExceptionHandler", "getSchedulingExceptionHandler$work_runtime_release", "setSchedulingExceptionHandler$work_runtime_release", "", "defaultProcessName", "Ljava/lang/String;", "getDefaultProcessName$work_runtime_release", "()Ljava/lang/String;", "setDefaultProcessName$work_runtime_release", "(Ljava/lang/String;)V", "", "loggingLevel", "I", "getLoggingLevel$work_runtime_release", "()I", "setLoggingLevel$work_runtime_release", "(I)V", "minJobSchedulerId", "getMinJobSchedulerId$work_runtime_release", "setMinJobSchedulerId$work_runtime_release", "maxJobSchedulerId", "getMaxJobSchedulerId$work_runtime_release", "setMaxJobSchedulerId$work_runtime_release", "maxSchedulerLimit", "getMaxSchedulerLimit$work_runtime_release", "setMaxSchedulerLimit$work_runtime_release", "contentUriTriggerWorkersLimit", "getContentUriTriggerWorkersLimit$work_runtime_release", "setContentUriTriggerWorkersLimit$work_runtime_release", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private Clock clock;
        private String defaultProcessName;
        private Executor executor;
        private Consumer<Throwable> initializationExceptionHandler;
        private InputMergerFactory inputMergerFactory;
        private int minJobSchedulerId;
        private RunnableScheduler runnableScheduler;
        private Consumer<Throwable> schedulingExceptionHandler;
        private Executor taskExecutor;
        private WorkerFactory workerFactory;
        private int loggingLevel = 4;
        private int maxJobSchedulerId = Integer.MAX_VALUE;
        private int maxSchedulerLimit = 20;
        private int contentUriTriggerWorkersLimit = ConfigurationKt.getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT();

        /* renamed from: getExecutor$work_runtime_release, reason: from getter */
        public final Executor getExecutor() {
            return this.executor;
        }

        /* renamed from: getWorkerFactory$work_runtime_release, reason: from getter */
        public final WorkerFactory getWorkerFactory() {
            return this.workerFactory;
        }

        /* renamed from: getInputMergerFactory$work_runtime_release, reason: from getter */
        public final InputMergerFactory getInputMergerFactory() {
            return this.inputMergerFactory;
        }

        /* renamed from: getTaskExecutor$work_runtime_release, reason: from getter */
        public final Executor getTaskExecutor() {
            return this.taskExecutor;
        }

        /* renamed from: getClock$work_runtime_release, reason: from getter */
        public final Clock getClock() {
            return this.clock;
        }

        /* renamed from: getRunnableScheduler$work_runtime_release, reason: from getter */
        public final RunnableScheduler getRunnableScheduler() {
            return this.runnableScheduler;
        }

        public final Consumer<Throwable> getInitializationExceptionHandler$work_runtime_release() {
            return this.initializationExceptionHandler;
        }

        public final Consumer<Throwable> getSchedulingExceptionHandler$work_runtime_release() {
            return this.schedulingExceptionHandler;
        }

        /* renamed from: getDefaultProcessName$work_runtime_release, reason: from getter */
        public final String getDefaultProcessName() {
            return this.defaultProcessName;
        }

        /* renamed from: getLoggingLevel$work_runtime_release, reason: from getter */
        public final int getLoggingLevel() {
            return this.loggingLevel;
        }

        /* renamed from: getMinJobSchedulerId$work_runtime_release, reason: from getter */
        public final int getMinJobSchedulerId() {
            return this.minJobSchedulerId;
        }

        /* renamed from: getMaxJobSchedulerId$work_runtime_release, reason: from getter */
        public final int getMaxJobSchedulerId() {
            return this.maxJobSchedulerId;
        }

        /* renamed from: getMaxSchedulerLimit$work_runtime_release, reason: from getter */
        public final int getMaxSchedulerLimit() {
            return this.maxSchedulerLimit;
        }

        /* renamed from: getContentUriTriggerWorkersLimit$work_runtime_release, reason: from getter */
        public final int getContentUriTriggerWorkersLimit() {
            return this.contentUriTriggerWorkersLimit;
        }

        public final Configuration build() {
            return new Configuration(this);
        }
    }
}
