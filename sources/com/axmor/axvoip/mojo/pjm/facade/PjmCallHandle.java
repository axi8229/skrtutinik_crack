package com.axmor.axvoip.mojo.pjm.facade;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class PjmCallHandle {
    private final int callId;
    private final PjmCallType callType;
    private final String remoteContact;
    private final int state;
    private final long timestamp = SystemClock.elapsedRealtime();

    public static class PjmCallHandleBuilder {
        private int callId;
        private PjmCallType callType;
        private String remoteContact;
        private int state;

        PjmCallHandleBuilder() {
        }

        public PjmCallHandle build() {
            return new PjmCallHandle(this.callId, this.callType, this.state, this.remoteContact);
        }

        public PjmCallHandleBuilder callId(int i) {
            this.callId = i;
            return this;
        }

        public PjmCallHandleBuilder callType(PjmCallType pjmCallType) {
            this.callType = pjmCallType;
            return this;
        }

        public PjmCallHandleBuilder remoteContact(String str) {
            this.remoteContact = str;
            return this;
        }

        public PjmCallHandleBuilder state(int i) {
            this.state = i;
            return this;
        }

        public String toString() {
            return "PjmCallHandle.PjmCallHandleBuilder(callId=" + this.callId + ", callType=" + this.callType + ", state=" + this.state + ", remoteContact=" + this.remoteContact + ")";
        }
    }

    PjmCallHandle(int i, PjmCallType pjmCallType, int i2, String str) {
        this.callId = i;
        this.callType = pjmCallType;
        this.state = i2;
        this.remoteContact = str;
    }

    public static PjmCallHandleBuilder builder() {
        return new PjmCallHandleBuilder();
    }

    public boolean isAlive() {
        int i = this.state;
        return (i == 0 || 6 == i) ? false : true;
    }

    public PjmCallHandle makeDeadCallHandle() {
        return new PjmCallHandle(this.callId, this.callType, 0, this.remoteContact);
    }

    public int getCallId() {
        return this.callId;
    }

    public PjmCallType getCallType() {
        return this.callType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && PjmCallHandle.class == obj.getClass() && this.callId == ((PjmCallHandle) obj).callId;
    }

    public int hashCode() {
        return this.callId;
    }
}
