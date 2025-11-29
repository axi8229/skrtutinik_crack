package com.axmor.axvoip.mojo.core.sip;

import com.axmor.axvoip.mojo.core.sip.SipSession;
import com.axmor.axvoip.mojo.pjm.common.PjmEndpointConfig;
import org.pjsip.pjsua2.AccountConfig;

/* loaded from: classes.dex */
final class SipSessionDummy implements SipSessionInternal {
    @Override // com.axmor.axvoip.mojo.core.sip.SipSession
    public void activate(PjmEndpointConfig pjmEndpointConfig, AccountConfig accountConfig) {
    }

    @Override // com.axmor.axvoip.mojo.core.sip.SipSessionInternal
    public void destroy() {
    }

    @Override // com.axmor.axvoip.mojo.core.sip.SipSession
    public AccountSession getAccountSession() {
        return null;
    }

    SipSessionDummy() {
    }

    @Override // com.axmor.axvoip.mojo.core.sip.SipSession
    public SipSession.SipState getState() {
        return SipSession.SipState.UNREGISTERED;
    }
}
