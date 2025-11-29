package com.axmor.axvoip.mojo.pjm.facade;

/* loaded from: classes.dex */
public interface PjmCall {

    public interface CallListener {
        void onCallStateUpdated(PjmCall pjmCall);
    }

    void accept();

    void decline();

    int getCallId();

    PjmCallHandle getHandle();

    boolean isAlive();

    void setCallListener(CallListener callListener);

    void shutdown();
}
