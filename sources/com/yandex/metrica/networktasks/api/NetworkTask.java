package com.yandex.metrica.networktasks.api;

import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class NetworkTask {
    private d a = d.EMPTY;
    private final Executor b;
    private final IExecutionPolicy c;
    private final ExponentialBackoffPolicy d;
    private final UnderlyingNetworkTask e;
    private final List f;
    private final String g;

    public enum Method {
        GET,
        POST
    }

    public interface ShouldTryNextHostCondition {
        boolean shouldTryNextHost(int i);
    }

    public NetworkTask(Executor executor, IExecutionPolicy iExecutionPolicy, ExponentialBackoffPolicy exponentialBackoffPolicy, UnderlyingNetworkTask underlyingNetworkTask, List list, String str) {
        this.b = executor;
        this.c = iExecutionPolicy;
        this.d = exponentialBackoffPolicy;
        this.e = underlyingNetworkTask;
        this.f = list;
        this.g = str;
    }

    private synchronized boolean a(d dVar) {
        if (!a(dVar)) {
            return false;
        }
        this.a = dVar;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean a(com.yandex.metrica.networktasks.api.d... r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L27
            com.yandex.metrica.networktasks.api.d r1 = r7.a     // Catch: java.lang.Throwable -> L27
            int r2 = r8.length     // Catch: java.lang.Throwable -> L27
            r3 = 0
            r4 = r3
        L8:
            if (r4 >= r2) goto L87
            r5 = r8[r4]     // Catch: java.lang.Throwable -> L27
            int r5 = r5.ordinal()     // Catch: java.lang.Throwable -> L27
            r6 = 1
            switch(r5) {
                case 0: goto L79;
                case 1: goto L72;
                case 2: goto L64;
                case 3: goto L52;
                case 4: goto L48;
                case 5: goto L48;
                case 6: goto L64;
                case 7: goto L2a;
                case 8: goto L16;
                default: goto L14;
            }     // Catch: java.lang.Throwable -> L27
        L14:
            goto L6f
        L16:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.EMPTY     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L1c
            goto L79
        L1c:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.REMOVED     // Catch: java.lang.Throwable -> L27
            if (r1 == r5) goto L21
            goto L22
        L21:
            r6 = r3
        L22:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Throwable -> L27
            goto L7a
        L27:
            r8 = move-exception
            goto L92
        L2a:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.SUCCESS     // Catch: java.lang.Throwable -> L27
            if (r1 == r5) goto L68
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.FAILED     // Catch: java.lang.Throwable -> L27
            if (r1 == r5) goto L68
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.SHOULD_NOT_EXECUTE     // Catch: java.lang.Throwable -> L27
            if (r1 == r5) goto L68
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.PENDING     // Catch: java.lang.Throwable -> L27
            if (r1 == r5) goto L68
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.PREPARING     // Catch: java.lang.Throwable -> L27
            if (r1 == r5) goto L68
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.EXECUTING     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L43
            goto L68
        L43:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.REMOVED     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L79
            goto L6f
        L48:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.EXECUTING     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L4d
            goto L68
        L4d:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.REMOVED     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L79
            goto L6f
        L52:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.PREPARING     // Catch: java.lang.Throwable -> L27
            if (r1 == r5) goto L68
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.SUCCESS     // Catch: java.lang.Throwable -> L27
            if (r1 == r5) goto L68
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.FAILED     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L5f
            goto L68
        L5f:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.REMOVED     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L79
            goto L6f
        L64:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.PENDING     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L6b
        L68:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L27
            goto L7a
        L6b:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.REMOVED     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L79
        L6f:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L27
            goto L7a
        L72:
            com.yandex.metrica.networktasks.api.d r5 = com.yandex.metrica.networktasks.api.d.EMPTY     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L77
            goto L22
        L77:
            r6 = r3
            goto L22
        L79:
            r5 = 0
        L7a:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L27
            boolean r6 = r6.equals(r5)     // Catch: java.lang.Throwable -> L27
            if (r6 != 0) goto L84
            r0 = r5
            goto L87
        L84:
            int r4 = r4 + 1
            goto L8
        L87:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L27
            r8.equals(r0)     // Catch: java.lang.Throwable -> L27
            boolean r8 = r8.equals(r0)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r7)
            return r8
        L92:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L27
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.networktasks.api.NetworkTask.a(com.yandex.metrica.networktasks.api.d[]):boolean");
    }

    public String description() {
        return this.e.description();
    }

    public IExecutionPolicy getConnectionExecutionPolicy() {
        return this.c;
    }

    public Executor getExecutor() {
        return this.b;
    }

    public ExponentialBackoffPolicy getExponentialBackoffPolicy() {
        return this.d;
    }

    public RequestDataHolder getRequestDataHolder() {
        return this.e.getRequestDataHolder();
    }

    public ResponseDataHolder getResponseDataHolder() {
        return this.e.getResponseDataHolder();
    }

    public RetryPolicyConfig getRetryPolicyConfig() {
        return this.e.getRetryPolicyConfig();
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.e.getSslSocketFactory();
    }

    public UnderlyingNetworkTask getUnderlyingTask() {
        return this.e;
    }

    public String getUrl() {
        return this.e.getFullUrlFormer().getUrl();
    }

    public String getUserAgent() {
        return this.g;
    }

    public boolean onCreateNetworkTask() {
        if (a(d.PREPARING)) {
            return this.e.onCreateTask();
        }
        return false;
    }

    public boolean onPerformRequest() {
        boolean zA = a(d.EXECUTING);
        if (zA) {
            this.e.getFullUrlFormer().incrementAttemptNumber();
            this.e.getFullUrlFormer().buildAndSetFullHostUrl();
            this.e.onPerformRequest();
        }
        return zA;
    }

    public boolean onRequestComplete() {
        boolean zOnRequestComplete;
        boolean z;
        synchronized (this) {
            try {
                d dVar = d.SUCCESS;
                d dVar2 = d.FAILED;
                if (a(dVar, dVar2)) {
                    zOnRequestComplete = this.e.onRequestComplete();
                    if (zOnRequestComplete) {
                        this.a = dVar;
                    } else {
                        this.a = dVar2;
                    }
                    z = true;
                } else {
                    zOnRequestComplete = false;
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            this.e.onPostRequestComplete(zOnRequestComplete);
        }
        return zOnRequestComplete;
    }

    public void onRequestError(Throwable th) {
        if (a(d.FAILED)) {
            this.e.onRequestError(th);
        }
    }

    public void onShouldNotExecute() {
        if (a(d.SHOULD_NOT_EXECUTE)) {
            this.e.onShouldNotExecute();
        }
    }

    public boolean onTaskAdded() {
        boolean zA = a(d.PENDING);
        if (zA) {
            this.e.onTaskAdded();
        }
        return zA;
    }

    public void onTaskFinished() {
        d dVar;
        boolean zA;
        synchronized (this) {
            dVar = this.a;
            zA = a(d.FINISHED);
        }
        if (zA) {
            this.e.onTaskFinished();
            if (dVar == d.SUCCESS) {
                this.e.onSuccessfulTaskFinished();
            } else if (dVar == d.FAILED || dVar == d.SHOULD_NOT_EXECUTE) {
                this.e.onUnsuccessfulTaskFinished();
            }
        }
    }

    public void onTaskRemoved() {
        if (a(d.REMOVED)) {
            this.e.onTaskRemoved();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean shouldTryNextHost() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.yandex.metrica.networktasks.api.UnderlyingNetworkTask r0 = r6.e     // Catch: java.lang.Throwable -> L31
            com.yandex.metrica.networktasks.api.FullUrlFormer r0 = r0.getFullUrlFormer()     // Catch: java.lang.Throwable -> L31
            boolean r0 = r0.hasMoreHosts()     // Catch: java.lang.Throwable -> L31
            com.yandex.metrica.networktasks.api.UnderlyingNetworkTask r1 = r6.e     // Catch: java.lang.Throwable -> L31
            com.yandex.metrica.networktasks.api.ResponseDataHolder r1 = r1.getResponseDataHolder()     // Catch: java.lang.Throwable -> L31
            int r1 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L31
            java.util.List r2 = r6.f     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L31
        L1b:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L31
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L33
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L31
            com.yandex.metrica.networktasks.api.NetworkTask$ShouldTryNextHostCondition r3 = (com.yandex.metrica.networktasks.api.NetworkTask.ShouldTryNextHostCondition) r3     // Catch: java.lang.Throwable -> L31
            boolean r3 = r3.shouldTryNextHost(r1)     // Catch: java.lang.Throwable -> L31
            if (r3 != 0) goto L1b
            r1 = r5
            goto L34
        L31:
            r0 = move-exception
            goto L46
        L33:
            r1 = r4
        L34:
            com.yandex.metrica.networktasks.api.d r2 = r6.a     // Catch: java.lang.Throwable -> L31
            com.yandex.metrica.networktasks.api.d r3 = com.yandex.metrica.networktasks.api.d.REMOVED     // Catch: java.lang.Throwable -> L31
            if (r2 == r3) goto L43
            com.yandex.metrica.networktasks.api.d r3 = com.yandex.metrica.networktasks.api.d.FINISHED     // Catch: java.lang.Throwable -> L31
            if (r2 == r3) goto L43
            if (r0 == 0) goto L43
            if (r1 == 0) goto L43
            goto L44
        L43:
            r4 = r5
        L44:
            monitor-exit(r6)
            return r4
        L46:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L31
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.networktasks.api.NetworkTask.shouldTryNextHost():boolean");
    }
}
