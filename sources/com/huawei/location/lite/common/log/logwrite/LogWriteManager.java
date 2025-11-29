package com.huawei.location.lite.common.log.logwrite;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class LogWriteManager {
    private static final Object OBJECT_LOCK = new Object();
    private static LogWriteManager mInstance = new LogWriteManager();
    private volatile String logPath;
    private LogWrite logWrite;
    private int perFileSize = -1;
    private int fileMaxNum = -1;
    private int fileExpiredTime = -1;
    private final BlockingQueue<AppLog> blockingQueue = new ArrayBlockingQueue(256);
    private WriteWorker worker = new WriteWorker();
    private boolean isStarted = false;
    private boolean isInit = false;

    class WriteWorker extends Thread {
        WriteWorker() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                java.lang.Object r1 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$000()
                monitor-enter(r1)
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r2 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this     // Catch: java.lang.Throwable -> L76
                com.huawei.location.lite.common.log.logwrite.LogWrite r2 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$500(r2)     // Catch: java.lang.Throwable -> L76
                int r3 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$100(r0)     // Catch: java.lang.Throwable -> L76
                java.lang.String r4 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$200(r0)     // Catch: java.lang.Throwable -> L76
                int r5 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$300(r0)     // Catch: java.lang.Throwable -> L76
                int r6 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$400(r0)     // Catch: java.lang.Throwable -> L76
                r2.init(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L76
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L76
            L21:
                boolean r1 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$600(r0)
                if (r1 == 0) goto L3f
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r1 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this     // Catch: java.lang.Error -> L2d java.lang.Exception -> L35 java.lang.InterruptedException -> L3a
                com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$700(r1, r0)     // Catch: java.lang.Error -> L2d java.lang.Exception -> L35 java.lang.InterruptedException -> L3a
                goto L21
            L2d:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker Error"
            L31:
                android.util.Log.i(r0, r1)
                goto L3f
            L35:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker IllegalMonitorStateException"
                goto L31
            L3a:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker InterruptedException"
                goto L31
            L3f:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker end."
                android.util.Log.i(r0, r1)
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                com.huawei.location.lite.common.log.logwrite.LogWrite r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$500(r0)
                if (r0 == 0) goto L6f
                com.huawei.location.lite.common.log.logwrite.AppLog r0 = new com.huawei.location.lite.common.log.logwrite.AppLog
                java.lang.String r2 = "I"
                java.lang.String r3 = "LogWriteManager"
                java.lang.String r4 = "PrintWoker end."
                java.lang.String r5 = "log"
                r6 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6)
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r1 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                com.huawei.location.lite.common.log.logwrite.LogWrite r1 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$500(r1)
                r1.writeToFile(r0)
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                com.huawei.location.lite.common.log.logwrite.LogWrite r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$500(r0)
                r0.shutdown()
            L6f:
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                r1 = 0
                com.huawei.location.lite.common.log.logwrite.LogWriteManager.access$602(r0, r1)
                return
            L76:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L76
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.log.logwrite.LogWriteManager.WriteWorker.run():void");
        }
    }

    private LogWriteManager() {
        Log.i("LogWriteManager", "LogWriteManager onCreate");
    }

    public static LogWriteManager getInstance() {
        return mInstance;
    }

    private void start() {
        String str;
        try {
            if (this.isStarted) {
                return;
            }
            this.isStarted = true;
            this.worker.setName("LogWriteThread");
            this.worker.start();
        } catch (IllegalThreadStateException unused) {
            str = "worker IllegalThreadStateException";
            Log.i("LogWriteManager", str);
            this.isStarted = false;
            this.isInit = false;
        } catch (Exception unused2) {
            str = "worker Exception";
            Log.i("LogWriteManager", str);
            this.isStarted = false;
            this.isInit = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void write(LogWriteManager logWriteManager) throws InterruptedException {
        AppLog appLogPoll = logWriteManager.blockingQueue.poll(60L, TimeUnit.SECONDS);
        LogWrite logWrite = this.logWrite;
        if (logWrite != null) {
            if (appLogPoll != null) {
                logWrite.writeToFile(appLogPoll);
                return;
            }
            logWrite.shutdown();
            this.logWrite.writeToFile(logWriteManager.blockingQueue.take());
        }
    }

    public boolean appendLog(AppLog appLog) {
        return this.blockingQueue.offer(appLog);
    }

    public void init(LogWriteParam logWriteParam) {
        synchronized (OBJECT_LOCK) {
            try {
                if (this.isInit) {
                    Log.i("LogWriteManager", "already init");
                } else {
                    Log.i("LogWriteManager", "first init");
                    if (TextUtils.isEmpty(logWriteParam.getLogPath())) {
                        Log.i("LogWriteManager", "logPath is empty");
                        return;
                    }
                    this.logPath = logWriteParam.getLogPath();
                    this.perFileSize = logWriteParam.getFileSize();
                    this.fileMaxNum = logWriteParam.getFileNum();
                    this.fileExpiredTime = logWriteParam.getFileExpiredTime();
                    this.logWrite = new LogWrite();
                    start();
                    this.isInit = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
