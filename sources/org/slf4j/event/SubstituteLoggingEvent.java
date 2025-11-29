package org.slf4j.event;

import org.slf4j.helpers.SubstituteLogger;

/* loaded from: classes4.dex */
public class SubstituteLoggingEvent implements LoggingEvent {
    Object[] argArray;
    Level level;
    SubstituteLogger logger;
    String loggerName;
    String message;
    String threadName;
    Throwable throwable;
    long timeStamp;

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setLoggerName(String str) {
        this.loggerName = str;
    }

    public SubstituteLogger getLogger() {
        return this.logger;
    }

    public void setLogger(SubstituteLogger substituteLogger) {
        this.logger = substituteLogger;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setArgumentArray(Object[] objArr) {
        this.argArray = objArr;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public void setThreadName(String str) {
        this.threadName = str;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }
}
