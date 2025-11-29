package com.axmor.axvoip.mojo.core.sip;

import com.axmor.ash.toolset.data.result.error.AshError;
import com.axmor.axvoip.mojo.pjm.common.PjmEndpointConfig;
import lombok.NonNull;
import org.pjsip.pjsua2.AccountConfig;

/* loaded from: classes.dex */
public interface SipSession {

    public enum SipState {
        UNREGISTERED,
        REGISTRATION_IN_PROGRESS,
        REGISTERED
    }

    void activate(PjmEndpointConfig pjmEndpointConfig, AccountConfig accountConfig);

    AccountSession getAccountSession();

    SipState getState();

    public static final class SipStateUpdate {

        @NonNull
        private final SipState state;

        public SipStateUpdate(@NonNull SipState sipState) {
            if (sipState == null) {
                throw new NullPointerException("state is marked non-null but is null");
            }
            this.state = sipState;
        }
    }

    public static abstract class SipRegFailedEvent {

        @NonNull
        private final AshError error;

        public SipRegFailedEvent(@NonNull AshError ashError) {
            if (ashError == null) {
                throw new NullPointerException("error is marked non-null but is null");
            }
            this.error = ashError;
        }
    }
}
