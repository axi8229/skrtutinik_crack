package com.huawei.location.router.dispatch;

import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.RouterTaskHandler;
import com.huawei.location.router.entity.RouterRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DispatchThreadPoolExecutor extends ThreadPoolExecutor {
    public DispatchThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    private void processRequest(DispatchBaseRunnable dispatchBaseRunnable) {
        Thread.setDefaultUncaughtExceptionHandler(new DispatchThreadExceptionHandler(dispatchBaseRunnable));
        RouterRequest routerRequest = dispatchBaseRunnable.getRouterRequest();
        if (routerRequest == null) {
            throw new DispatchException(10002, "TaskApiEntity Object is Empty");
        }
        String str = RouterTaskHandler.getInstance().getApiRequestMap().get(routerRequest.getApiName());
        if (str == null) {
            throw new DispatchException(10001, "api interface not register");
        }
        try {
            dispatchBaseRunnable.setApiRequest((BaseRouterTaskCallImpl) Class.forName(str).newInstance());
        } catch (ClassNotFoundException unused) {
            throw new DispatchException(IDispatchExceptionListener.OTHER_ERROR, "class not found exception");
        } catch (IllegalAccessException unused2) {
            throw new DispatchException(IDispatchExceptionListener.OTHER_ERROR, "IllegalAccessException");
        } catch (InstantiationException unused3) {
            throw new DispatchException(IDispatchExceptionListener.OTHER_ERROR, "InstantiationException");
        } catch (Exception unused4) {
            throw new DispatchException(IDispatchExceptionListener.OTHER_ERROR, "InstantiationException");
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (runnable instanceof DispatchRunnable) {
            processRequest((DispatchRunnable) runnable);
        }
        if (runnable instanceof FutureDispatch) {
            Callable callable = ((FutureDispatch) runnable).getCallable();
            if (callable instanceof DispatchCallable) {
                processRequest((DispatchCallable) callable);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FutureDispatch(callable);
    }
}
