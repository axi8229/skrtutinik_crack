package com.axmor.axvoip.mojo.core.sip;

import com.axmor.axvoip.mojo.pjm.facade.PjmCallHandle;

/* loaded from: classes.dex */
public interface CallSession {
    void accept();

    void decline() throws AssertionError;

    boolean isAlive();

    public static final class CallStateUpdatedEvent {
        private final PjmCallHandle call;

        public CallStateUpdatedEvent(PjmCallHandle pjmCallHandle) {
            this.call = pjmCallHandle;
        }
    }
}
