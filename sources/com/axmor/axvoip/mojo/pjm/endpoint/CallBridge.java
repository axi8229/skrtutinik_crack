package com.axmor.axvoip.mojo.pjm.endpoint;

import com.axmor.ash.toolset.utils.AshAssert;
import com.axmor.ash.toolset.utils.Lambda$Code0;
import com.axmor.ash.toolset.utils.Lambda$Code1;
import com.axmor.ash.toolset.utils.Lambda$Code1Ex;
import com.axmor.axvoip.mojo.pjm.common.PjmException;
import com.axmor.axvoip.mojo.pjm.endpoint.Bridge;
import com.axmor.axvoip.mojo.pjm.facade.PjmCall;
import com.axmor.axvoip.mojo.pjm.facade.PjmCallHandle;
import com.axmor.axvoip.mojo.pjm.facade.PjmCallType;
import java.util.Objects;
import lombok.NonNull;
import org.pjsip.pjsua2.Account;
import org.pjsip.pjsua2.AudDevManager;
import org.pjsip.pjsua2.AudioMedia;
import org.pjsip.pjsua2.CallInfo;
import org.pjsip.pjsua2.CallMediaInfo;
import org.pjsip.pjsua2.CallMediaInfoVector;
import org.pjsip.pjsua2.CallOpParam;
import org.pjsip.pjsua2.OnCallMediaStateParam;
import org.pjsip.pjsua2.OnCallStateParam;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes.dex */
final class CallBridge implements Bridge.Entity, PjmCall {
    private final Bridge bridge;
    private final int bridgedId;
    private final Call call;
    private final Lambda$Code1<CallBridge> callCompletedHandler;
    private PjmCallHandle callHandle;
    private boolean waitNextCallState;
    private final Object $lock = new Object[0];
    private PjmCall.CallListener callListener = null;
    private boolean declined = false;

    static final class Config {

        @NonNull
        private final Account account;
        private final int bridgedId;

        @NonNull
        private final Lambda$Code1<CallBridge> callCompletedHandler;

        @NonNull
        private final PjmCallType callType;

        @NonNull
        private final Lambda$Code1<Bridge> deletedHandler;

        @NonNull
        private final EndpointServices endpointServices;
        private final int sipCallId;

        public Config(int i, @NonNull EndpointServices endpointServices, @NonNull Lambda$Code1<Bridge> lambda$Code1, @NonNull Lambda$Code1<CallBridge> lambda$Code12, @NonNull Account account, @NonNull PjmCallType pjmCallType, int i2) {
            if (endpointServices == null) {
                throw new NullPointerException("endpointServices is marked non-null but is null");
            }
            if (lambda$Code1 == null) {
                throw new NullPointerException("deletedHandler is marked non-null but is null");
            }
            if (lambda$Code12 == null) {
                throw new NullPointerException("callCompletedHandler is marked non-null but is null");
            }
            if (account == null) {
                throw new NullPointerException("account is marked non-null but is null");
            }
            if (pjmCallType == null) {
                throw new NullPointerException("callType is marked non-null but is null");
            }
            this.bridgedId = i;
            this.endpointServices = endpointServices;
            this.deletedHandler = lambda$Code1;
            this.callCompletedHandler = lambda$Code12;
            this.account = account;
            this.callType = pjmCallType;
            this.sipCallId = i2;
        }

        public int getBridgedId() {
            return this.bridgedId;
        }

        @NonNull
        public EndpointServices getEndpointServices() {
            return this.endpointServices;
        }

        @NonNull
        public Lambda$Code1<Bridge> getDeletedHandler() {
            return this.deletedHandler;
        }

        @NonNull
        public Lambda$Code1<CallBridge> getCallCompletedHandler() {
            return this.callCompletedHandler;
        }

        @NonNull
        public Account getAccount() {
            return this.account;
        }

        public int getSipCallId() {
            return this.sipCallId;
        }

        PjmCallHandle makeInitHandle() {
            PjmCallHandle.PjmCallHandleBuilder pjmCallHandleBuilderCallType = PjmCallHandle.builder().callId(this.bridgedId).callType(this.callType);
            int i = AnonymousClass1.$SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmCallType[this.callType.ordinal()];
            if (i == 1) {
                pjmCallHandleBuilderCallType.state(2);
            } else if (i == 2) {
                pjmCallHandleBuilderCallType.state(1);
            } else {
                throw new RuntimeException("Unhandled call type.");
            }
            return pjmCallHandleBuilderCallType.build();
        }
    }

    /* renamed from: com.axmor.axvoip.mojo.pjm.endpoint.CallBridge$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmCallType;

        static {
            int[] iArr = new int[PjmCallType.values().length];
            $SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmCallType = iArr;
            try {
                iArr[PjmCallType.INCOMING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$axmor$axvoip$mojo$pjm$facade$PjmCallType[PjmCallType.OUTGOING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    CallBridge(@NonNull Config config) {
        this.callHandle = null;
        this.waitNextCallState = true;
        if (config == null) {
            throw new NullPointerException("config is marked non-null but is null");
        }
        this.bridgedId = config.getBridgedId();
        Bridge bridge = new Bridge(config.getEndpointServices(), new Lambda$Code0() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.CallBridge$$ExternalSyntheticLambda2
            @Override // com.axmor.ash.toolset.utils.Lambda$Code0
            public final void invoke() {
                this.f$0.doShutdown();
            }
        }, new Lambda$Code0() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.CallBridge$$ExternalSyntheticLambda3
            @Override // com.axmor.ash.toolset.utils.Lambda$Code0
            public final void invoke() {
                this.f$0.doDelete();
            }
        }, config.getDeletedHandler());
        this.bridge = bridge;
        bridge.enableLogging(CallBridge.class.getSimpleName());
        this.callCompletedHandler = config.getCallCompletedHandler();
        this.call = new Call(config.getAccount(), config.getSipCallId());
        this.callHandle = config.makeInitHandle();
        this.waitNextCallState = config.getSipCallId() < 0;
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmCall
    public int getCallId() {
        int i;
        synchronized (this.$lock) {
            i = this.bridgedId;
        }
        return i;
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmCall
    public boolean isAlive() {
        boolean z;
        synchronized (this.$lock) {
            try {
                z = (this.declined || this.bridge.isDestroyed() || !this.callHandle.isAlive()) ? false : true;
            } finally {
            }
        }
        return z;
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmCall
    public PjmCallHandle getHandle() {
        PjmCallHandle pjmCallHandle;
        synchronized (this.$lock) {
            pjmCallHandle = this.callHandle;
        }
        return pjmCallHandle;
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmCall
    public void accept() {
        synchronized (this.$lock) {
            try {
                AshAssert.aTrue(isAlive());
                if (isAlive()) {
                    this.bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.CallBridge$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.doAccept();
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAccept() {
        synchronized (this.$lock) {
            if (isAlive()) {
                try {
                    final Call call = this.call;
                    Objects.requireNonNull(call);
                    call.runControlOp(200, new Lambda$Code1Ex() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.CallBridge$$ExternalSyntheticLambda5
                        @Override // com.axmor.ash.toolset.utils.Lambda$Code1Ex
                        public final void invoke(Object obj) throws Exception {
                            call.answer((CallOpParam) obj);
                        }
                    });
                } catch (PjmException e) {
                    this.bridge.log("doAccept::failed", e);
                    shutdown();
                }
            }
        }
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmCall
    public synchronized void decline() {
        synchronized (this.$lock) {
            AshAssert.aTrue(isAlive());
            if (isAlive()) {
                this.bridge.execute(new Runnable() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.CallBridge$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.doDecline();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDecline() {
        synchronized (this.$lock) {
            try {
                if (isAlive()) {
                    this.declined = true;
                    try {
                        final Call call = this.call;
                        Objects.requireNonNull(call);
                        call.runControlOp(pjsip_status_code.PJSIP_SC_DECLINE, new Lambda$Code1Ex() { // from class: com.axmor.axvoip.mojo.pjm.endpoint.CallBridge$$ExternalSyntheticLambda4
                            @Override // com.axmor.ash.toolset.utils.Lambda$Code1Ex
                            public final void invoke(Object obj) throws Exception {
                                call.hangup((CallOpParam) obj);
                            }
                        });
                    } catch (PjmException e) {
                        this.bridge.log("decline::failed", e);
                        this.bridge.shutdown();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmCall
    public void shutdown() {
        synchronized (this.$lock) {
            this.bridge.shutdown();
            this.callListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doShutdown() {
        synchronized (this.$lock) {
            doDecline();
            this.callCompletedHandler.invoke(this);
            this.bridge.shutdownCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDelete() {
        synchronized (this.$lock) {
            this.call.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlockNextCallState() {
        synchronized (this.$lock) {
            this.waitNextCallState = false;
        }
    }

    private void updateHandle() {
        synchronized (this.$lock) {
            try {
                if (this.waitNextCallState) {
                    return;
                }
                this.callHandle = this.call.makeHandle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateState() {
        synchronized (this.$lock) {
            try {
                updateHandle();
                if (this.bridge.isDestroyed()) {
                    return;
                }
                PjmCall.CallListener callListener = this.callListener;
                if (callListener != null) {
                    callListener.onCallStateUpdated(this);
                }
                if (!this.callHandle.isAlive()) {
                    complete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void complete() {
        synchronized (this.$lock) {
            this.bridge.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class Call extends org.pjsip.pjsua2.Call {
        private void logDump() {
        }

        private Call(Account account, int i) {
            super(account, i);
        }

        PjmCallHandle makeHandle() {
            if (CallBridge.this.bridge.isDestroyed()) {
                return CallBridge.this.callHandle.makeDeadCallHandle();
            }
            try {
                CallInfo info = getInfo();
                PjmCallHandle pjmCallHandleBuild = PjmCallHandle.builder().callId(CallBridge.this.bridgedId).callType(CallBridge.this.callHandle.getCallType()).state(info.getState()).remoteContact(info.getRemoteUri()).build();
                info.delete();
                return pjmCallHandleBuild;
            } catch (Exception e) {
                CallBridge.this.bridge.log("CallImpl::makeHandle::failed", e);
                return CallBridge.this.callHandle.makeDeadCallHandle();
            }
        }

        @Override // org.pjsip.pjsua2.Call
        public void onCallState(OnCallStateParam onCallStateParam) {
            CallBridge.this.bridge.log("CallImpl::onCallState");
            logDump();
            CallBridge.this.unlockNextCallState();
            CallBridge.this.bridge.execute(new CallBridge$Call$$ExternalSyntheticLambda0(CallBridge.this));
        }

        @Override // org.pjsip.pjsua2.Call
        public void onCallMediaState(OnCallMediaStateParam onCallMediaStateParam) {
            CallBridge.this.bridge.log("CallImpl::onCallMediaState");
            logDump();
            try {
                CallMediaInfoVector media = getInfo().getMedia();
                for (int i = 0; i < media.size(); i++) {
                    CallMediaInfo callMediaInfo = media.get(i);
                    boolean z = true;
                    if (1 == callMediaInfo.getType()) {
                        int status = callMediaInfo.getStatus();
                        boolean z2 = 1 == status;
                        if (3 != status) {
                            z = false;
                        }
                        if (z2 || z) {
                            AudioMedia audioMediaTypecastFromMedia = AudioMedia.typecastFromMedia(getMedia(i));
                            AudDevManager audioManager = CallBridge.this.bridge.getEndpointServices().getAudioManager();
                            audioManager.getCaptureDevMedia().startTransmit(audioMediaTypecastFromMedia);
                            audioMediaTypecastFromMedia.startTransmit(audioManager.getPlaybackDevMedia());
                        }
                    }
                }
            } catch (Exception e) {
                CallBridge.this.bridge.log("CallImpl::onCallMediaState", e);
                e.printStackTrace();
            }
            CallBridge.this.bridge.execute(new CallBridge$Call$$ExternalSyntheticLambda0(CallBridge.this));
        }

        void runControlOp(int i, Lambda$Code1Ex<CallOpParam> lambda$Code1Ex) throws PjmException {
            try {
                try {
                    CallOpParam callOpParam = new CallOpParam(true);
                    callOpParam.setStatusCode(i);
                    lambda$Code1Ex.invoke(callOpParam);
                } catch (Exception e) {
                    throw new PjmException(e);
                }
            } finally {
                CallBridge.this.doUpdateState();
            }
        }
    }

    @Override // com.axmor.axvoip.mojo.pjm.facade.PjmCall
    public void setCallListener(PjmCall.CallListener callListener) {
        synchronized (this.$lock) {
            this.callListener = callListener;
        }
    }

    @Override // com.axmor.axvoip.mojo.pjm.endpoint.Bridge.Entity
    public Bridge getBridge() {
        return this.bridge;
    }
}
