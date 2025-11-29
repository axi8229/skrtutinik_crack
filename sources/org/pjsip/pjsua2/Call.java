package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class Call {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected Call(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Call call) {
        if (call == null) {
            return 0L;
        }
        return call.swigCPtr;
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
                    pjsua2JNI.delete_Call(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        pjsua2JNI.Call_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        pjsua2JNI.Call_change_ownership(this, this.swigCPtr, true);
    }

    public Call(Account account, int i) {
        this(pjsua2JNI.new_Call__SWIG_0(Account.getCPtr(account), account, i), true);
        pjsua2JNI.Call_director_connect(this, this.swigCPtr, true, true);
    }

    public Call(Account account) {
        this(pjsua2JNI.new_Call__SWIG_1(Account.getCPtr(account), account), true);
        pjsua2JNI.Call_director_connect(this, this.swigCPtr, true, true);
    }

    public CallInfo getInfo() throws Exception {
        return new CallInfo(pjsua2JNI.Call_getInfo(this.swigCPtr, this), true);
    }

    public boolean isActive() {
        return pjsua2JNI.Call_isActive(this.swigCPtr, this);
    }

    public int getId() {
        return pjsua2JNI.Call_getId(this.swigCPtr, this);
    }

    public static Call lookup(int i) {
        long jCall_lookup = pjsua2JNI.Call_lookup(i);
        if (jCall_lookup == 0) {
            return null;
        }
        return new Call(jCall_lookup, false);
    }

    public boolean hasMedia() {
        return pjsua2JNI.Call_hasMedia(this.swigCPtr, this);
    }

    public Media getMedia(long j) {
        long jCall_getMedia = pjsua2JNI.Call_getMedia(this.swigCPtr, this, j);
        if (jCall_getMedia == 0) {
            return null;
        }
        return new Media(jCall_getMedia, false);
    }

    public AudioMedia getAudioMedia(int i) throws Exception {
        return new AudioMedia(pjsua2JNI.Call_getAudioMedia(this.swigCPtr, this, i), true);
    }

    public VideoMedia getEncodingVideoMedia(int i) throws Exception {
        return new VideoMedia(pjsua2JNI.Call_getEncodingVideoMedia(this.swigCPtr, this, i), true);
    }

    public VideoMedia getDecodingVideoMedia(int i) throws Exception {
        return new VideoMedia(pjsua2JNI.Call_getDecodingVideoMedia(this.swigCPtr, this, i), true);
    }

    public int remoteHasCap(int i, String str, String str2) {
        return pjsua2JNI.Call_remoteHasCap(this.swigCPtr, this, i, str, str2);
    }

    public void setUserData(SWIGTYPE_p_void sWIGTYPE_p_void) {
        pjsua2JNI.Call_setUserData(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getUserData() {
        long jCall_getUserData = pjsua2JNI.Call_getUserData(this.swigCPtr, this);
        if (jCall_getUserData == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(jCall_getUserData, false);
    }

    public int getRemNatType() throws Exception {
        return pjsua2JNI.Call_getRemNatType(this.swigCPtr, this);
    }

    public void makeCall(String str, CallOpParam callOpParam) throws Exception {
        pjsua2JNI.Call_makeCall(this.swigCPtr, this, str, CallOpParam.getCPtr(callOpParam), callOpParam);
    }

    public void answer(CallOpParam callOpParam) throws Exception {
        pjsua2JNI.Call_answer(this.swigCPtr, this, CallOpParam.getCPtr(callOpParam), callOpParam);
    }

    public void hangup(CallOpParam callOpParam) throws Exception {
        pjsua2JNI.Call_hangup(this.swigCPtr, this, CallOpParam.getCPtr(callOpParam), callOpParam);
    }

    public void setHold(CallOpParam callOpParam) throws Exception {
        pjsua2JNI.Call_setHold(this.swigCPtr, this, CallOpParam.getCPtr(callOpParam), callOpParam);
    }

    public void reinvite(CallOpParam callOpParam) throws Exception {
        pjsua2JNI.Call_reinvite(this.swigCPtr, this, CallOpParam.getCPtr(callOpParam), callOpParam);
    }

    public void update(CallOpParam callOpParam) throws Exception {
        pjsua2JNI.Call_update(this.swigCPtr, this, CallOpParam.getCPtr(callOpParam), callOpParam);
    }

    public void xfer(String str, CallOpParam callOpParam) throws Exception {
        pjsua2JNI.Call_xfer(this.swigCPtr, this, str, CallOpParam.getCPtr(callOpParam), callOpParam);
    }

    public void xferReplaces(Call call, CallOpParam callOpParam) throws Exception {
        pjsua2JNI.Call_xferReplaces(this.swigCPtr, this, getCPtr(call), call, CallOpParam.getCPtr(callOpParam), callOpParam);
    }

    public void processRedirect(int i) throws Exception {
        pjsua2JNI.Call_processRedirect(this.swigCPtr, this, i);
    }

    public void dialDtmf(String str) throws Exception {
        pjsua2JNI.Call_dialDtmf(this.swigCPtr, this, str);
    }

    public void sendDtmf(CallSendDtmfParam callSendDtmfParam) throws Exception {
        pjsua2JNI.Call_sendDtmf(this.swigCPtr, this, CallSendDtmfParam.getCPtr(callSendDtmfParam), callSendDtmfParam);
    }

    public void sendInstantMessage(SendInstantMessageParam sendInstantMessageParam) throws Exception {
        pjsua2JNI.Call_sendInstantMessage(this.swigCPtr, this, SendInstantMessageParam.getCPtr(sendInstantMessageParam), sendInstantMessageParam);
    }

    public void sendTypingIndication(SendTypingIndicationParam sendTypingIndicationParam) throws Exception {
        pjsua2JNI.Call_sendTypingIndication(this.swigCPtr, this, SendTypingIndicationParam.getCPtr(sendTypingIndicationParam), sendTypingIndicationParam);
    }

    public void sendRequest(CallSendRequestParam callSendRequestParam) throws Exception {
        pjsua2JNI.Call_sendRequest(this.swigCPtr, this, CallSendRequestParam.getCPtr(callSendRequestParam), callSendRequestParam);
    }

    public String dump(boolean z, String str) throws Exception {
        return pjsua2JNI.Call_dump(this.swigCPtr, this, z, str);
    }

    public int vidGetStreamIdx() {
        return pjsua2JNI.Call_vidGetStreamIdx(this.swigCPtr, this);
    }

    public boolean vidStreamIsRunning(int i, int i2) {
        return pjsua2JNI.Call_vidStreamIsRunning(this.swigCPtr, this, i, i2);
    }

    public void vidSetStream(int i, CallVidSetStreamParam callVidSetStreamParam) throws Exception {
        pjsua2JNI.Call_vidSetStream(this.swigCPtr, this, i, CallVidSetStreamParam.getCPtr(callVidSetStreamParam), callVidSetStreamParam);
    }

    public void audStreamModifyCodecParam(int i, CodecParam codecParam) throws Exception {
        pjsua2JNI.Call_audStreamModifyCodecParam(this.swigCPtr, this, i, CodecParam.getCPtr(codecParam), codecParam);
    }

    public StreamInfo getStreamInfo(long j) throws Exception {
        return new StreamInfo(pjsua2JNI.Call_getStreamInfo(this.swigCPtr, this, j), true);
    }

    public StreamStat getStreamStat(long j) throws Exception {
        return new StreamStat(pjsua2JNI.Call_getStreamStat(this.swigCPtr, this, j), true);
    }

    public MediaTransportInfo getMedTransportInfo(long j) throws Exception {
        return new MediaTransportInfo(pjsua2JNI.Call_getMedTransportInfo(this.swigCPtr, this, j), true);
    }

    public void processMediaUpdate(OnCallMediaStateParam onCallMediaStateParam) {
        pjsua2JNI.Call_processMediaUpdate(this.swigCPtr, this, OnCallMediaStateParam.getCPtr(onCallMediaStateParam), onCallMediaStateParam);
    }

    public void processStateChange(OnCallStateParam onCallStateParam) {
        pjsua2JNI.Call_processStateChange(this.swigCPtr, this, OnCallStateParam.getCPtr(onCallStateParam), onCallStateParam);
    }

    public void onCallState(OnCallStateParam onCallStateParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallState(this.swigCPtr, this, OnCallStateParam.getCPtr(onCallStateParam), onCallStateParam);
        } else {
            pjsua2JNI.Call_onCallStateSwigExplicitCall(this.swigCPtr, this, OnCallStateParam.getCPtr(onCallStateParam), onCallStateParam);
        }
    }

    public void onCallTsxState(OnCallTsxStateParam onCallTsxStateParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallTsxState(this.swigCPtr, this, OnCallTsxStateParam.getCPtr(onCallTsxStateParam), onCallTsxStateParam);
        } else {
            pjsua2JNI.Call_onCallTsxStateSwigExplicitCall(this.swigCPtr, this, OnCallTsxStateParam.getCPtr(onCallTsxStateParam), onCallTsxStateParam);
        }
    }

    public void onCallMediaState(OnCallMediaStateParam onCallMediaStateParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallMediaState(this.swigCPtr, this, OnCallMediaStateParam.getCPtr(onCallMediaStateParam), onCallMediaStateParam);
        } else {
            pjsua2JNI.Call_onCallMediaStateSwigExplicitCall(this.swigCPtr, this, OnCallMediaStateParam.getCPtr(onCallMediaStateParam), onCallMediaStateParam);
        }
    }

    public void onCallSdpCreated(OnCallSdpCreatedParam onCallSdpCreatedParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallSdpCreated(this.swigCPtr, this, OnCallSdpCreatedParam.getCPtr(onCallSdpCreatedParam), onCallSdpCreatedParam);
        } else {
            pjsua2JNI.Call_onCallSdpCreatedSwigExplicitCall(this.swigCPtr, this, OnCallSdpCreatedParam.getCPtr(onCallSdpCreatedParam), onCallSdpCreatedParam);
        }
    }

    public void onStreamPreCreate(OnStreamPreCreateParam onStreamPreCreateParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onStreamPreCreate(this.swigCPtr, this, OnStreamPreCreateParam.getCPtr(onStreamPreCreateParam), onStreamPreCreateParam);
        } else {
            pjsua2JNI.Call_onStreamPreCreateSwigExplicitCall(this.swigCPtr, this, OnStreamPreCreateParam.getCPtr(onStreamPreCreateParam), onStreamPreCreateParam);
        }
    }

    public void onStreamCreated(OnStreamCreatedParam onStreamCreatedParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onStreamCreated(this.swigCPtr, this, OnStreamCreatedParam.getCPtr(onStreamCreatedParam), onStreamCreatedParam);
        } else {
            pjsua2JNI.Call_onStreamCreatedSwigExplicitCall(this.swigCPtr, this, OnStreamCreatedParam.getCPtr(onStreamCreatedParam), onStreamCreatedParam);
        }
    }

    public void onStreamDestroyed(OnStreamDestroyedParam onStreamDestroyedParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onStreamDestroyed(this.swigCPtr, this, OnStreamDestroyedParam.getCPtr(onStreamDestroyedParam), onStreamDestroyedParam);
        } else {
            pjsua2JNI.Call_onStreamDestroyedSwigExplicitCall(this.swigCPtr, this, OnStreamDestroyedParam.getCPtr(onStreamDestroyedParam), onStreamDestroyedParam);
        }
    }

    public void onDtmfDigit(OnDtmfDigitParam onDtmfDigitParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onDtmfDigit(this.swigCPtr, this, OnDtmfDigitParam.getCPtr(onDtmfDigitParam), onDtmfDigitParam);
        } else {
            pjsua2JNI.Call_onDtmfDigitSwigExplicitCall(this.swigCPtr, this, OnDtmfDigitParam.getCPtr(onDtmfDigitParam), onDtmfDigitParam);
        }
    }

    public void onDtmfEvent(OnDtmfEventParam onDtmfEventParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onDtmfEvent(this.swigCPtr, this, OnDtmfEventParam.getCPtr(onDtmfEventParam), onDtmfEventParam);
        } else {
            pjsua2JNI.Call_onDtmfEventSwigExplicitCall(this.swigCPtr, this, OnDtmfEventParam.getCPtr(onDtmfEventParam), onDtmfEventParam);
        }
    }

    public void onCallTransferRequest(OnCallTransferRequestParam onCallTransferRequestParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallTransferRequest(this.swigCPtr, this, OnCallTransferRequestParam.getCPtr(onCallTransferRequestParam), onCallTransferRequestParam);
        } else {
            pjsua2JNI.Call_onCallTransferRequestSwigExplicitCall(this.swigCPtr, this, OnCallTransferRequestParam.getCPtr(onCallTransferRequestParam), onCallTransferRequestParam);
        }
    }

    public void onCallTransferStatus(OnCallTransferStatusParam onCallTransferStatusParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallTransferStatus(this.swigCPtr, this, OnCallTransferStatusParam.getCPtr(onCallTransferStatusParam), onCallTransferStatusParam);
        } else {
            pjsua2JNI.Call_onCallTransferStatusSwigExplicitCall(this.swigCPtr, this, OnCallTransferStatusParam.getCPtr(onCallTransferStatusParam), onCallTransferStatusParam);
        }
    }

    public void onCallReplaceRequest(OnCallReplaceRequestParam onCallReplaceRequestParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallReplaceRequest(this.swigCPtr, this, OnCallReplaceRequestParam.getCPtr(onCallReplaceRequestParam), onCallReplaceRequestParam);
        } else {
            pjsua2JNI.Call_onCallReplaceRequestSwigExplicitCall(this.swigCPtr, this, OnCallReplaceRequestParam.getCPtr(onCallReplaceRequestParam), onCallReplaceRequestParam);
        }
    }

    public void onCallReplaced(OnCallReplacedParam onCallReplacedParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallReplaced(this.swigCPtr, this, OnCallReplacedParam.getCPtr(onCallReplacedParam), onCallReplacedParam);
        } else {
            pjsua2JNI.Call_onCallReplacedSwigExplicitCall(this.swigCPtr, this, OnCallReplacedParam.getCPtr(onCallReplacedParam), onCallReplacedParam);
        }
    }

    public void onCallRxOffer(OnCallRxOfferParam onCallRxOfferParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallRxOffer(this.swigCPtr, this, OnCallRxOfferParam.getCPtr(onCallRxOfferParam), onCallRxOfferParam);
        } else {
            pjsua2JNI.Call_onCallRxOfferSwigExplicitCall(this.swigCPtr, this, OnCallRxOfferParam.getCPtr(onCallRxOfferParam), onCallRxOfferParam);
        }
    }

    public void onCallRxReinvite(OnCallRxReinviteParam onCallRxReinviteParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallRxReinvite(this.swigCPtr, this, OnCallRxReinviteParam.getCPtr(onCallRxReinviteParam), onCallRxReinviteParam);
        } else {
            pjsua2JNI.Call_onCallRxReinviteSwigExplicitCall(this.swigCPtr, this, OnCallRxReinviteParam.getCPtr(onCallRxReinviteParam), onCallRxReinviteParam);
        }
    }

    public void onCallTxOffer(OnCallTxOfferParam onCallTxOfferParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallTxOffer(this.swigCPtr, this, OnCallTxOfferParam.getCPtr(onCallTxOfferParam), onCallTxOfferParam);
        } else {
            pjsua2JNI.Call_onCallTxOfferSwigExplicitCall(this.swigCPtr, this, OnCallTxOfferParam.getCPtr(onCallTxOfferParam), onCallTxOfferParam);
        }
    }

    public void onInstantMessage(OnInstantMessageParam onInstantMessageParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onInstantMessage(this.swigCPtr, this, OnInstantMessageParam.getCPtr(onInstantMessageParam), onInstantMessageParam);
        } else {
            pjsua2JNI.Call_onInstantMessageSwigExplicitCall(this.swigCPtr, this, OnInstantMessageParam.getCPtr(onInstantMessageParam), onInstantMessageParam);
        }
    }

    public void onInstantMessageStatus(OnInstantMessageStatusParam onInstantMessageStatusParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onInstantMessageStatus(this.swigCPtr, this, OnInstantMessageStatusParam.getCPtr(onInstantMessageStatusParam), onInstantMessageStatusParam);
        } else {
            pjsua2JNI.Call_onInstantMessageStatusSwigExplicitCall(this.swigCPtr, this, OnInstantMessageStatusParam.getCPtr(onInstantMessageStatusParam), onInstantMessageStatusParam);
        }
    }

    public void onTypingIndication(OnTypingIndicationParam onTypingIndicationParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onTypingIndication(this.swigCPtr, this, OnTypingIndicationParam.getCPtr(onTypingIndicationParam), onTypingIndicationParam);
        } else {
            pjsua2JNI.Call_onTypingIndicationSwigExplicitCall(this.swigCPtr, this, OnTypingIndicationParam.getCPtr(onTypingIndicationParam), onTypingIndicationParam);
        }
    }

    public int onCallRedirected(OnCallRedirectedParam onCallRedirectedParam) {
        return getClass() == Call.class ? pjsua2JNI.Call_onCallRedirected(this.swigCPtr, this, OnCallRedirectedParam.getCPtr(onCallRedirectedParam), onCallRedirectedParam) : pjsua2JNI.Call_onCallRedirectedSwigExplicitCall(this.swigCPtr, this, OnCallRedirectedParam.getCPtr(onCallRedirectedParam), onCallRedirectedParam);
    }

    public void onCallMediaTransportState(OnCallMediaTransportStateParam onCallMediaTransportStateParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallMediaTransportState(this.swigCPtr, this, OnCallMediaTransportStateParam.getCPtr(onCallMediaTransportStateParam), onCallMediaTransportStateParam);
        } else {
            pjsua2JNI.Call_onCallMediaTransportStateSwigExplicitCall(this.swigCPtr, this, OnCallMediaTransportStateParam.getCPtr(onCallMediaTransportStateParam), onCallMediaTransportStateParam);
        }
    }

    public void onCallMediaEvent(OnCallMediaEventParam onCallMediaEventParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCallMediaEvent(this.swigCPtr, this, OnCallMediaEventParam.getCPtr(onCallMediaEventParam), onCallMediaEventParam);
        } else {
            pjsua2JNI.Call_onCallMediaEventSwigExplicitCall(this.swigCPtr, this, OnCallMediaEventParam.getCPtr(onCallMediaEventParam), onCallMediaEventParam);
        }
    }

    public void onCreateMediaTransport(OnCreateMediaTransportParam onCreateMediaTransportParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCreateMediaTransport(this.swigCPtr, this, OnCreateMediaTransportParam.getCPtr(onCreateMediaTransportParam), onCreateMediaTransportParam);
        } else {
            pjsua2JNI.Call_onCreateMediaTransportSwigExplicitCall(this.swigCPtr, this, OnCreateMediaTransportParam.getCPtr(onCreateMediaTransportParam), onCreateMediaTransportParam);
        }
    }

    public void onCreateMediaTransportSrtp(OnCreateMediaTransportSrtpParam onCreateMediaTransportSrtpParam) {
        if (getClass() == Call.class) {
            pjsua2JNI.Call_onCreateMediaTransportSrtp(this.swigCPtr, this, OnCreateMediaTransportSrtpParam.getCPtr(onCreateMediaTransportSrtpParam), onCreateMediaTransportSrtpParam);
        } else {
            pjsua2JNI.Call_onCreateMediaTransportSrtpSwigExplicitCall(this.swigCPtr, this, OnCreateMediaTransportSrtpParam.getCPtr(onCreateMediaTransportSrtpParam), onCreateMediaTransportSrtpParam);
        }
    }
}
