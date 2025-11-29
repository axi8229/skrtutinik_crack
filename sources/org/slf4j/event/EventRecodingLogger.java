package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* loaded from: classes4.dex */
public class EventRecodingLogger implements Logger {
    Queue<SubstituteLoggingEvent> eventQueue;
    SubstituteLogger logger;
    String name;

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled() {
        return true;
    }

    public EventRecodingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.logger = substituteLogger;
        this.name = substituteLogger.getName();
        this.eventQueue = queue;
    }

    @Override // org.slf4j.Logger
    public String getName() {
        return this.name;
    }

    private void recordEvent(Level level, String str, Object[] objArr, Throwable th) {
        recordEvent(level, null, str, objArr, th);
    }

    private void recordEvent(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        substituteLoggingEvent.setTimeStamp(System.currentTimeMillis());
        substituteLoggingEvent.setLevel(level);
        substituteLoggingEvent.setLogger(this.logger);
        substituteLoggingEvent.setLoggerName(this.name);
        substituteLoggingEvent.setMessage(str);
        substituteLoggingEvent.setArgumentArray(objArr);
        substituteLoggingEvent.setThrowable(th);
        substituteLoggingEvent.setThreadName(Thread.currentThread().getName());
        this.eventQueue.add(substituteLoggingEvent);
    }

    @Override // org.slf4j.Logger
    public void debug(String str) {
        recordEvent(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj) {
        recordEvent(Level.DEBUG, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj, Object obj2) {
        recordEvent(Level.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object... objArr) {
        recordEvent(Level.DEBUG, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Throwable th) {
        recordEvent(Level.DEBUG, str, null, th);
    }
}
