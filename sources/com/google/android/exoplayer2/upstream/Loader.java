package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class Loader implements LoaderErrorThrower {
    public static final LoadErrorAction DONT_RETRY;
    public static final LoadErrorAction DONT_RETRY_FATAL;
    public static final LoadErrorAction RETRY = createRetryAction(false, -9223372036854775807L);
    public static final LoadErrorAction RETRY_RESET_ERROR_COUNT = createRetryAction(true, -9223372036854775807L);
    private LoadTask<? extends Loadable> currentTask;
    private final ExecutorService downloadExecutorService;
    private IOException fatalError;

    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released);

        void onLoadCompleted(T loadable, long elapsedRealtimeMs, long loadDurationMs);

        LoadErrorAction onLoadError(T loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount);
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws IOException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable cause) {
            super("Unexpected " + cause.getClass().getSimpleName() + ": " + cause.getMessage(), cause);
        }
    }

    static {
        long j = -9223372036854775807L;
        DONT_RETRY = new LoadErrorAction(2, j);
        DONT_RETRY_FATAL = new LoadErrorAction(3, j);
    }

    public static final class LoadErrorAction {
        private final long retryDelayMillis;
        private final int type;

        private LoadErrorAction(int type, long retryDelayMillis) {
            this.type = type;
            this.retryDelayMillis = retryDelayMillis;
        }

        public boolean isRetry() {
            int i = this.type;
            return i == 0 || i == 1;
        }
    }

    public Loader(String threadName) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(threadName);
    }

    public static LoadErrorAction createRetryAction(boolean z, long j) {
        return new LoadErrorAction(z ? 1 : 0, j);
    }

    public boolean hasFatalError() {
        return this.fatalError != null;
    }

    public void clearFatalError() {
        this.fatalError = null;
    }

    public <T extends Loadable> long startLoading(T loadable, Callback<T> callback, int defaultMinRetryCount) {
        Looper looper = (Looper) Assertions.checkStateNotNull(Looper.myLooper());
        this.fatalError = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(looper, loadable, callback, defaultMinRetryCount, jElapsedRealtime).start(0L);
        return jElapsedRealtime;
    }

    public boolean isLoading() {
        return this.currentTask != null;
    }

    public void cancelLoading() {
        ((LoadTask) Assertions.checkStateNotNull(this.currentTask)).cancel(false);
    }

    public void release() {
        release(null);
    }

    public void release(ReleaseCallback callback) {
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (callback != null) {
            this.downloadExecutorService.execute(new ReleaseTask(callback));
        }
        this.downloadExecutorService.shutdown();
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public void maybeThrowError(int minRetryCount) throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            if (minRetryCount == Integer.MIN_VALUE) {
                minRetryCount = loadTask.defaultMinRetryCount;
            }
            loadTask.maybeThrowError(minRetryCount);
        }
    }

    @SuppressLint({"HandlerLeak"})
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private Callback<T> callback;
        private volatile boolean canceled;
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private volatile Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T loadable, Callback<T> callback, int defaultMinRetryCount, long startTimeMs) {
            super(looper);
            this.loadable = loadable;
            this.callback = callback;
            this.defaultMinRetryCount = defaultMinRetryCount;
            this.startTimeMs = startTimeMs;
        }

        public void maybeThrowError(int minRetryCount) throws IOException {
            IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > minRetryCount) {
                throw iOException;
            }
        }

        public void start(long delayMillis) {
            Assertions.checkState(Loader.this.currentTask == null);
            Loader.this.currentTask = this;
            if (delayMillis > 0) {
                sendEmptyMessageDelayed(0, delayMillis);
            } else {
                execute();
            }
        }

        public void cancel(boolean released) {
            this.released = released;
            this.currentError = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!released) {
                    sendEmptyMessage(1);
                }
            } else {
                this.canceled = true;
                this.loadable.cancelLoad();
                Thread thread = this.executorThread;
                if (thread != null) {
                    thread.interrupt();
                }
            }
            if (released) {
                finish();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) Assertions.checkNotNull(this.callback)).onLoadCanceled(this.loadable, jElapsedRealtime, jElapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.executorThread = Thread.currentThread();
                if (!this.canceled) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                        TraceUtil.endSection();
                    } catch (Throwable th) {
                        TraceUtil.endSection();
                        throw th;
                    }
                }
                if (this.released) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e) {
                if (this.released) {
                    return;
                }
                obtainMessage(3, e).sendToTarget();
            } catch (Exception e2) {
                Log.e("LoadTask", "Unexpected exception loading stream", e2);
                if (this.released) {
                    return;
                }
                obtainMessage(3, new UnexpectedLoaderException(e2)).sendToTarget();
            } catch (OutOfMemoryError e3) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e3);
                if (this.released) {
                    return;
                }
                obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
            } catch (Error e4) {
                Log.e("LoadTask", "Unexpected error loading stream", e4);
                if (!this.released) {
                    obtainMessage(4, e4).sendToTarget();
                }
                throw e4;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            long retryDelayMillis;
            if (this.released) {
                return;
            }
            int i = msg.what;
            if (i == 0) {
                execute();
                return;
            }
            if (i == 4) {
                throw ((Error) msg.obj);
            }
            finish();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.startTimeMs;
            Callback callback = (Callback) Assertions.checkNotNull(this.callback);
            if (this.canceled) {
                callback.onLoadCanceled(this.loadable, jElapsedRealtime, j, false);
                return;
            }
            int i2 = msg.what;
            if (i2 == 1) {
                callback.onLoadCanceled(this.loadable, jElapsedRealtime, j, false);
                return;
            }
            if (i2 == 2) {
                try {
                    callback.onLoadCompleted(this.loadable, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    Log.e("LoadTask", "Unexpected exception handling load completed", e);
                    Loader.this.fatalError = new UnexpectedLoaderException(e);
                    return;
                }
            }
            if (i2 != 3) {
                return;
            }
            IOException iOException = (IOException) msg.obj;
            this.currentError = iOException;
            int i3 = this.errorCount + 1;
            this.errorCount = i3;
            LoadErrorAction loadErrorActionOnLoadError = callback.onLoadError(this.loadable, jElapsedRealtime, j, iOException, i3);
            if (loadErrorActionOnLoadError.type != 3) {
                if (loadErrorActionOnLoadError.type != 2) {
                    if (loadErrorActionOnLoadError.type == 1) {
                        this.errorCount = 1;
                    }
                    if (loadErrorActionOnLoadError.retryDelayMillis != -9223372036854775807L) {
                        retryDelayMillis = loadErrorActionOnLoadError.retryDelayMillis;
                    } else {
                        retryDelayMillis = getRetryDelayMillis();
                    }
                    start(retryDelayMillis);
                    return;
                }
                return;
            }
            Loader.this.fatalError = this.currentError;
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute((Runnable) Assertions.checkNotNull(Loader.this.currentTask));
        }

        private void finish() {
            Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    private static final class ReleaseTask implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback callback) {
            this.callback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.callback.onLoaderReleased();
        }
    }
}
