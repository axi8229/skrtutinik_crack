package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class CallInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CallInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CallInfo callInfo) {
        if (callInfo == null) {
            return 0L;
        }
        return callInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_CallInfo(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setId(int i) {
        pjsua2JNI.CallInfo_id_set(this.swigCPtr, this, i);
    }

    public int getId() {
        return pjsua2JNI.CallInfo_id_get(this.swigCPtr, this);
    }

    public void setRole(int i) {
        pjsua2JNI.CallInfo_role_set(this.swigCPtr, this, i);
    }

    public int getRole() {
        return pjsua2JNI.CallInfo_role_get(this.swigCPtr, this);
    }

    public void setAccId(int i) {
        pjsua2JNI.CallInfo_accId_set(this.swigCPtr, this, i);
    }

    public int getAccId() {
        return pjsua2JNI.CallInfo_accId_get(this.swigCPtr, this);
    }

    public void setLocalUri(String str) {
        pjsua2JNI.CallInfo_localUri_set(this.swigCPtr, this, str);
    }

    public String getLocalUri() {
        return pjsua2JNI.CallInfo_localUri_get(this.swigCPtr, this);
    }

    public void setLocalContact(String str) {
        pjsua2JNI.CallInfo_localContact_set(this.swigCPtr, this, str);
    }

    public String getLocalContact() {
        return pjsua2JNI.CallInfo_localContact_get(this.swigCPtr, this);
    }

    public void setRemoteUri(String str) {
        pjsua2JNI.CallInfo_remoteUri_set(this.swigCPtr, this, str);
    }

    public String getRemoteUri() {
        return pjsua2JNI.CallInfo_remoteUri_get(this.swigCPtr, this);
    }

    public void setRemoteContact(String str) {
        pjsua2JNI.CallInfo_remoteContact_set(this.swigCPtr, this, str);
    }

    public String getRemoteContact() {
        return pjsua2JNI.CallInfo_remoteContact_get(this.swigCPtr, this);
    }

    public void setCallIdString(String str) {
        pjsua2JNI.CallInfo_callIdString_set(this.swigCPtr, this, str);
    }

    public String getCallIdString() {
        return pjsua2JNI.CallInfo_callIdString_get(this.swigCPtr, this);
    }

    public void setSetting(CallSetting callSetting) {
        pjsua2JNI.CallInfo_setting_set(this.swigCPtr, this, CallSetting.getCPtr(callSetting), callSetting);
    }

    public CallSetting getSetting() {
        long jCallInfo_setting_get = pjsua2JNI.CallInfo_setting_get(this.swigCPtr, this);
        if (jCallInfo_setting_get == 0) {
            return null;
        }
        return new CallSetting(jCallInfo_setting_get, false);
    }

    public void setState(int i) {
        pjsua2JNI.CallInfo_state_set(this.swigCPtr, this, i);
    }

    public int getState() {
        return pjsua2JNI.CallInfo_state_get(this.swigCPtr, this);
    }

    public void setStateText(String str) {
        pjsua2JNI.CallInfo_stateText_set(this.swigCPtr, this, str);
    }

    public String getStateText() {
        return pjsua2JNI.CallInfo_stateText_get(this.swigCPtr, this);
    }

    public void setLastStatusCode(int i) {
        pjsua2JNI.CallInfo_lastStatusCode_set(this.swigCPtr, this, i);
    }

    public int getLastStatusCode() {
        return pjsua2JNI.CallInfo_lastStatusCode_get(this.swigCPtr, this);
    }

    public void setLastReason(String str) {
        pjsua2JNI.CallInfo_lastReason_set(this.swigCPtr, this, str);
    }

    public String getLastReason() {
        return pjsua2JNI.CallInfo_lastReason_get(this.swigCPtr, this);
    }

    public void setMedia(CallMediaInfoVector callMediaInfoVector) {
        pjsua2JNI.CallInfo_media_set(this.swigCPtr, this, CallMediaInfoVector.getCPtr(callMediaInfoVector), callMediaInfoVector);
    }

    public CallMediaInfoVector getMedia() {
        long jCallInfo_media_get = pjsua2JNI.CallInfo_media_get(this.swigCPtr, this);
        if (jCallInfo_media_get == 0) {
            return null;
        }
        return new CallMediaInfoVector(jCallInfo_media_get, false);
    }

    public void setProvMedia(CallMediaInfoVector callMediaInfoVector) {
        pjsua2JNI.CallInfo_provMedia_set(this.swigCPtr, this, CallMediaInfoVector.getCPtr(callMediaInfoVector), callMediaInfoVector);
    }

    public CallMediaInfoVector getProvMedia() {
        long jCallInfo_provMedia_get = pjsua2JNI.CallInfo_provMedia_get(this.swigCPtr, this);
        if (jCallInfo_provMedia_get == 0) {
            return null;
        }
        return new CallMediaInfoVector(jCallInfo_provMedia_get, false);
    }

    public void setConnectDuration(TimeVal timeVal) {
        pjsua2JNI.CallInfo_connectDuration_set(this.swigCPtr, this, TimeVal.getCPtr(timeVal), timeVal);
    }

    public TimeVal getConnectDuration() {
        long jCallInfo_connectDuration_get = pjsua2JNI.CallInfo_connectDuration_get(this.swigCPtr, this);
        if (jCallInfo_connectDuration_get == 0) {
            return null;
        }
        return new TimeVal(jCallInfo_connectDuration_get, false);
    }

    public void setTotalDuration(TimeVal timeVal) {
        pjsua2JNI.CallInfo_totalDuration_set(this.swigCPtr, this, TimeVal.getCPtr(timeVal), timeVal);
    }

    public TimeVal getTotalDuration() {
        long jCallInfo_totalDuration_get = pjsua2JNI.CallInfo_totalDuration_get(this.swigCPtr, this);
        if (jCallInfo_totalDuration_get == 0) {
            return null;
        }
        return new TimeVal(jCallInfo_totalDuration_get, false);
    }

    public void setRemOfferer(boolean z) {
        pjsua2JNI.CallInfo_remOfferer_set(this.swigCPtr, this, z);
    }

    public boolean getRemOfferer() {
        return pjsua2JNI.CallInfo_remOfferer_get(this.swigCPtr, this);
    }

    public void setRemAudioCount(long j) {
        pjsua2JNI.CallInfo_remAudioCount_set(this.swigCPtr, this, j);
    }

    public long getRemAudioCount() {
        return pjsua2JNI.CallInfo_remAudioCount_get(this.swigCPtr, this);
    }

    public void setRemVideoCount(long j) {
        pjsua2JNI.CallInfo_remVideoCount_set(this.swigCPtr, this, j);
    }

    public long getRemVideoCount() {
        return pjsua2JNI.CallInfo_remVideoCount_get(this.swigCPtr, this);
    }

    public CallInfo() {
        this(pjsua2JNI.new_CallInfo(), true);
    }
}
