package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class i<TResult> extends Task<TResult> {
    private boolean b;
    private volatile boolean c;
    private TResult d;
    private Exception e;
    private final Object a = new Object();
    private List<ExecuteResult<TResult>> f = new ArrayList();

    private Task<TResult> a(ExecuteResult<TResult> executeResult) {
        boolean zIsComplete;
        synchronized (this.a) {
            try {
                zIsComplete = isComplete();
                if (!zIsComplete) {
                    this.f.add(executeResult);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsComplete) {
            executeResult.onComplete(this);
        }
        return this;
    }

    private void b() {
        synchronized (this.a) {
            Iterator<ExecuteResult<TResult>> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onComplete(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f = null;
        }
    }

    public final void a(Exception exc) {
        synchronized (this.a) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                this.e = exc;
                this.a.notifyAll();
                b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(TResult tresult) {
        synchronized (this.a) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                this.d = tresult;
                this.a.notifyAll();
                b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean a() {
        synchronized (this.a) {
            try {
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.c = true;
                this.a.notifyAll();
                b();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.uiThread(), onCompleteListener);
    }

    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        return a((ExecuteResult) new d(executor, onCompleteListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.uiThread(), onFailureListener);
    }

    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return a((ExecuteResult) new f(executor, onFailureListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.uiThread(), onSuccessListener);
    }

    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        return a((ExecuteResult) new h(executor, onSuccessListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.a) {
            exc = this.e;
        }
        return exc;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.a) {
            try {
                if (this.e != null) {
                    throw new RuntimeException(this.e);
                }
                tresult = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isCanceled() {
        return this.c;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.b && !isCanceled() && this.e == null;
            } finally {
            }
        }
        return z;
    }
}
