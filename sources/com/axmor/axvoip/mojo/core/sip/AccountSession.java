package com.axmor.axvoip.mojo.core.sip;

import com.axmor.axvoip.mojo.pjm.facade.PjmCallHandle;
import java.util.List;

/* loaded from: classes.dex */
public interface AccountSession {
    List<PjmCallHandle> getActiveCalls();

    CallSession getCallSession(PjmCallHandle pjmCallHandle);

    public static final class CallCreatedEvent {
        private final PjmCallHandle call;

        public CallCreatedEvent(PjmCallHandle pjmCallHandle) {
            this.call = pjmCallHandle;
        }
    }

    public static final class CallCompletedEvent {
        private final PjmCallHandle call;

        public CallCompletedEvent(PjmCallHandle pjmCallHandle) {
            this.call = pjmCallHandle;
        }
    }
}
