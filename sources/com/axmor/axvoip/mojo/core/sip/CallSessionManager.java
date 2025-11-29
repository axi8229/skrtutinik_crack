package com.axmor.axvoip.mojo.core.sip;

import com.axmor.ash.toolset.service.CompositeContext;
import com.axmor.axvoip.mojo.core.sip.CallSession;
import com.axmor.axvoip.mojo.pjm.facade.PjmCall;
import com.axmor.axvoip.mojo.pjm.facade.PjmCallHandle;
import lombok.NonNull;

/* loaded from: classes.dex */
final class CallSessionManager implements CallSession {
    private final PjmCall call;
    private final PjmCall.CallListener callListener;
    private final CompositeContext context;

    public CallSessionManager(@NonNull CompositeContext compositeContext, @NonNull PjmCall pjmCall) {
        PjmCall.CallListener callListener = new PjmCall.CallListener() { // from class: com.axmor.axvoip.mojo.core.sip.CallSessionManager.1
            @Override // com.axmor.axvoip.mojo.pjm.facade.PjmCall.CallListener
            public void onCallStateUpdated(@NonNull PjmCall pjmCall2) {
                if (pjmCall2 == null) {
                    throw new NullPointerException("call is marked non-null but is null");
                }
                CallSessionManager.this.context.eventBus().post(new CallSession.CallStateUpdatedEvent(pjmCall2.getHandle()));
            }
        };
        this.callListener = callListener;
        if (compositeContext == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (pjmCall == null) {
            throw new NullPointerException("call is marked non-null but is null");
        }
        this.context = compositeContext;
        this.call = pjmCall;
        pjmCall.setCallListener(callListener);
    }

    @Override // com.axmor.axvoip.mojo.core.sip.CallSession
    public boolean isAlive() {
        return this.call.isAlive();
    }

    public PjmCallHandle getHandle() {
        return this.call.getHandle();
    }

    @Override // com.axmor.axvoip.mojo.core.sip.CallSession
    public void accept() {
        this.call.accept();
    }

    @Override // com.axmor.axvoip.mojo.core.sip.CallSession
    public void decline() {
        this.call.decline();
    }

    public void destroy() {
        this.call.shutdown();
    }
}
