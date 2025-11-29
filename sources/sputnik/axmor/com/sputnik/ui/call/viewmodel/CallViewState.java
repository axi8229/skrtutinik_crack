package sputnik.axmor.com.sputnik.ui.call.viewmodel;

import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.call.Call;
import sputnik.axmor.com.sputnik.entities.call.SipAccount;

/* compiled from: CallViewModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018JÆ\u0001\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b'\u0010&R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b,\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b-\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b.\u0010\u001cR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00102\u001a\u0004\b3\u00104R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\b5\u00101R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b6\u00101R\u0017\u0010\u0012\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\b8\u00109R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010/\u001a\u0004\b:\u00101R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010/\u001a\u0004\b;\u00101R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010<\u001a\u0004\b=\u0010>¨\u0006?"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "loadCameraState", "Lcom/sputnik/common/entities/camera/Camera;", "currentCamera", "", FailedBinderCallBack.CALLER_ID, "callUuid", "flatUuid", "Lcom/sputnik/domain/common/Event;", "", "navigateToAnswerCall", "Lsputnik/axmor/com/sputnik/entities/call/Call;", "callResponse", "callIsAccepted", "callIsDeclined", "acceptedByMe", "sipIsLoaded", "callLoaded", "Lsputnik/axmor/com/sputnik/entities/call/SipAccount;", "sipAccount", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/common/entities/camera/Camera;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/common/Event;Lsputnik/axmor/com/sputnik/entities/call/Call;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lsputnik/axmor/com/sputnik/entities/call/SipAccount;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/common/entities/camera/Camera;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/common/Event;Lsputnik/axmor/com/sputnik/entities/call/Call;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;ZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lsputnik/axmor/com/sputnik/entities/call/SipAccount;)Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getLoadCameraState", "Lcom/sputnik/common/entities/camera/Camera;", "getCurrentCamera", "()Lcom/sputnik/common/entities/camera/Camera;", "Ljava/lang/String;", "getCallId", "getCallUuid", "getFlatUuid", "Lcom/sputnik/domain/common/Event;", "getNavigateToAnswerCall", "()Lcom/sputnik/domain/common/Event;", "Lsputnik/axmor/com/sputnik/entities/call/Call;", "getCallResponse", "()Lsputnik/axmor/com/sputnik/entities/call/Call;", "getCallIsAccepted", "getCallIsDeclined", "Z", "getAcceptedByMe", "()Z", "getSipIsLoaded", "getCallLoaded", "Lsputnik/axmor/com/sputnik/entities/call/SipAccount;", "getSipAccount", "()Lsputnik/axmor/com/sputnik/entities/call/SipAccount;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CallViewState implements VMState {
    private final boolean acceptedByMe;
    private final String callId;
    private final Event<Boolean> callIsAccepted;
    private final Event<Boolean> callIsDeclined;
    private final Event<Boolean> callLoaded;
    private final Call callResponse;
    private final String callUuid;
    private final Camera currentCamera;
    private final String flatUuid;
    private final Resource.Status loadCameraState;
    private final Event<Boolean> navigateToAnswerCall;
    private final Resource.Status serverState;
    private final SipAccount sipAccount;
    private final Event<Boolean> sipIsLoaded;

    public final CallViewState copy(Resource.Status serverState, Resource.Status loadCameraState, Camera currentCamera, String callId, String callUuid, String flatUuid, Event<Boolean> navigateToAnswerCall, Call callResponse, Event<Boolean> callIsAccepted, Event<Boolean> callIsDeclined, boolean acceptedByMe, Event<Boolean> sipIsLoaded, Event<Boolean> callLoaded, SipAccount sipAccount) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(loadCameraState, "loadCameraState");
        Intrinsics.checkNotNullParameter(navigateToAnswerCall, "navigateToAnswerCall");
        Intrinsics.checkNotNullParameter(callIsAccepted, "callIsAccepted");
        Intrinsics.checkNotNullParameter(callIsDeclined, "callIsDeclined");
        Intrinsics.checkNotNullParameter(sipIsLoaded, "sipIsLoaded");
        Intrinsics.checkNotNullParameter(callLoaded, "callLoaded");
        return new CallViewState(serverState, loadCameraState, currentCamera, callId, callUuid, flatUuid, navigateToAnswerCall, callResponse, callIsAccepted, callIsDeclined, acceptedByMe, sipIsLoaded, callLoaded, sipAccount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallViewState)) {
            return false;
        }
        CallViewState callViewState = (CallViewState) other;
        return this.serverState == callViewState.serverState && this.loadCameraState == callViewState.loadCameraState && Intrinsics.areEqual(this.currentCamera, callViewState.currentCamera) && Intrinsics.areEqual(this.callId, callViewState.callId) && Intrinsics.areEqual(this.callUuid, callViewState.callUuid) && Intrinsics.areEqual(this.flatUuid, callViewState.flatUuid) && Intrinsics.areEqual(this.navigateToAnswerCall, callViewState.navigateToAnswerCall) && Intrinsics.areEqual(this.callResponse, callViewState.callResponse) && Intrinsics.areEqual(this.callIsAccepted, callViewState.callIsAccepted) && Intrinsics.areEqual(this.callIsDeclined, callViewState.callIsDeclined) && this.acceptedByMe == callViewState.acceptedByMe && Intrinsics.areEqual(this.sipIsLoaded, callViewState.sipIsLoaded) && Intrinsics.areEqual(this.callLoaded, callViewState.callLoaded) && Intrinsics.areEqual(this.sipAccount, callViewState.sipAccount);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.serverState.hashCode() * 31) + this.loadCameraState.hashCode()) * 31;
        Camera camera = this.currentCamera;
        int iHashCode2 = (iHashCode + (camera == null ? 0 : camera.hashCode())) * 31;
        String str = this.callId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.callUuid;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.flatUuid;
        int iHashCode5 = (((iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.navigateToAnswerCall.hashCode()) * 31;
        Call call = this.callResponse;
        int iHashCode6 = (((((iHashCode5 + (call == null ? 0 : call.hashCode())) * 31) + this.callIsAccepted.hashCode()) * 31) + this.callIsDeclined.hashCode()) * 31;
        boolean z = this.acceptedByMe;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int iHashCode7 = (((((iHashCode6 + i) * 31) + this.sipIsLoaded.hashCode()) * 31) + this.callLoaded.hashCode()) * 31;
        SipAccount sipAccount = this.sipAccount;
        return iHashCode7 + (sipAccount != null ? sipAccount.hashCode() : 0);
    }

    public String toString() {
        return "CallViewState(serverState=" + this.serverState + ", loadCameraState=" + this.loadCameraState + ", currentCamera=" + this.currentCamera + ", callId=" + this.callId + ", callUuid=" + this.callUuid + ", flatUuid=" + this.flatUuid + ", navigateToAnswerCall=" + this.navigateToAnswerCall + ", callResponse=" + this.callResponse + ", callIsAccepted=" + this.callIsAccepted + ", callIsDeclined=" + this.callIsDeclined + ", acceptedByMe=" + this.acceptedByMe + ", sipIsLoaded=" + this.sipIsLoaded + ", callLoaded=" + this.callLoaded + ", sipAccount=" + this.sipAccount + ")";
    }

    public CallViewState(Resource.Status serverState, Resource.Status loadCameraState, Camera camera, String str, String str2, String str3, Event<Boolean> navigateToAnswerCall, Call call, Event<Boolean> callIsAccepted, Event<Boolean> callIsDeclined, boolean z, Event<Boolean> sipIsLoaded, Event<Boolean> callLoaded, SipAccount sipAccount) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(loadCameraState, "loadCameraState");
        Intrinsics.checkNotNullParameter(navigateToAnswerCall, "navigateToAnswerCall");
        Intrinsics.checkNotNullParameter(callIsAccepted, "callIsAccepted");
        Intrinsics.checkNotNullParameter(callIsDeclined, "callIsDeclined");
        Intrinsics.checkNotNullParameter(sipIsLoaded, "sipIsLoaded");
        Intrinsics.checkNotNullParameter(callLoaded, "callLoaded");
        this.serverState = serverState;
        this.loadCameraState = loadCameraState;
        this.currentCamera = camera;
        this.callId = str;
        this.callUuid = str2;
        this.flatUuid = str3;
        this.navigateToAnswerCall = navigateToAnswerCall;
        this.callResponse = call;
        this.callIsAccepted = callIsAccepted;
        this.callIsDeclined = callIsDeclined;
        this.acceptedByMe = z;
        this.sipIsLoaded = sipIsLoaded;
        this.callLoaded = callLoaded;
        this.sipAccount = sipAccount;
    }

    public /* synthetic */ CallViewState(Resource.Status status, Resource.Status status2, Camera camera, String str, String str2, String str3, Event event, Call call, Event event2, Event event3, boolean z, Event event4, Event event5, SipAccount sipAccount, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? null : camera, str, str2, str3, (i & 64) != 0 ? new Event(Boolean.FALSE) : event, (i & 128) != 0 ? null : call, (i & 256) != 0 ? new Event(Boolean.FALSE) : event2, (i & 512) != 0 ? new Event(Boolean.FALSE) : event3, (i & 1024) != 0 ? false : z, (i & 2048) != 0 ? new Event(Boolean.FALSE) : event4, (i & 4096) != 0 ? new Event(Boolean.FALSE) : event5, (i & 8192) != 0 ? null : sipAccount);
    }

    public final Resource.Status getLoadCameraState() {
        return this.loadCameraState;
    }

    public final Camera getCurrentCamera() {
        return this.currentCamera;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final String getCallUuid() {
        return this.callUuid;
    }

    public final String getFlatUuid() {
        return this.flatUuid;
    }

    public final Event<Boolean> getCallIsAccepted() {
        return this.callIsAccepted;
    }

    public final Event<Boolean> getCallIsDeclined() {
        return this.callIsDeclined;
    }

    public final boolean getAcceptedByMe() {
        return this.acceptedByMe;
    }

    public final Event<Boolean> getSipIsLoaded() {
        return this.sipIsLoaded;
    }

    public final Event<Boolean> getCallLoaded() {
        return this.callLoaded;
    }

    public final SipAccount getSipAccount() {
        return this.sipAccount;
    }
}
