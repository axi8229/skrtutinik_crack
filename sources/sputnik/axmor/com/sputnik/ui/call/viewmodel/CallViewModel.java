package sputnik.axmor.com.sputnik.ui.call.viewmodel;

import android.util.Log;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.axmor.axvoip.mojo.core.sip.SipSession;
import com.huawei.hms.api.FailedBinderCallBack;
import com.mocklets.pluto.PlutoLog;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.CallState;
import com.sputnik.domain.entities.call.DomainCall;
import com.sputnik.domain.entities.call.DomainSipAccount;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.usecases.call.AcceptCallUseCase;
import com.sputnik.domain.usecases.call.GetCallUseCase;
import com.sputnik.domain.usecases.call.GetSipAccountUseCase;
import com.sputnik.domain.usecases.cameras.GetCameraByIntercomUUIDUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.entities.call.SipAccount;
import sputnik.axmor.com.sputnik.mappers.call.DomainCallToCallMapper;
import sputnik.axmor.com.sputnik.mappers.call.DomainSipAccountToSipAccountMapper;

/* compiled from: CallViewModel.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001ABg\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001b0\u001aH\u0002¢\u0006\u0004\b \u0010\u001eJ\u001b\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u001b0\u001aH\u0002¢\u0006\u0004\b\"\u0010\u001eJ+\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001b0\u001a2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001fH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001fH\u0016¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u001fH\u0016¢\u0006\u0004\b+\u0010)J\u0019\u0010.\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u001fH\u0016¢\u0006\u0004\b0\u0010)J\u000f\u00101\u001a\u00020\u001fH\u0016¢\u0006\u0004\b1\u0010)J\u000f\u00102\u001a\u00020\u001fH\u0016¢\u0006\u0004\b2\u0010)J\u000f\u00103\u001a\u00020\u001fH\u0016¢\u0006\u0004\b3\u0010)J\u001f\u00104\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u00105R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00106R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00107R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00108R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00109R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010:R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010;R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010<R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewState;", "", "", FailedBinderCallBack.CALLER_ID, "callUuid", "flatUuid", "", "navigateToAnswerCall", "Lcom/sputnik/domain/usecases/call/GetCallUseCase;", "getCallUseCase", "Lcom/sputnik/domain/usecases/call/AcceptCallUseCase;", "acceptCallUseCase", "Lcom/sputnik/domain/usecases/call/GetSipAccountUseCase;", "getSipAccountUseCase", "Lcom/sputnik/domain/usecases/cameras/GetCameraByIntercomUUIDUseCase;", "getCameraByIntercomUUIDUseCase", "Lsputnik/axmor/com/sputnik/mappers/call/DomainCallToCallMapper;", "domainCallToCallMapper", "Lsputnik/axmor/com/sputnik/mappers/call/DomainSipAccountToSipAccountMapper;", "domainSipAccountToSipAccountMapper", "Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;", "domainCameraToCameraMapper", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/domain/usecases/call/GetCallUseCase;Lcom/sputnik/domain/usecases/call/AcceptCallUseCase;Lcom/sputnik/domain/usecases/call/GetSipAccountUseCase;Lcom/sputnik/domain/usecases/cameras/GetCameraByIntercomUUIDUseCase;Lsputnik/axmor/com/sputnik/mappers/call/DomainCallToCallMapper;Lsputnik/axmor/com/sputnik/mappers/call/DomainSipAccountToSipAccountMapper;Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/call/DomainCall;", "getCallFromServer", "()Landroidx/lifecycle/LiveData;", "", "acceptCallServer", "Lcom/sputnik/domain/entities/call/DomainSipAccount;", "getSipAccountFromServer", "uuid", "flatUUID", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "getCameraByIntercomUUID", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "getCall", "()V", "acceptCall", "handleCall", "Lcom/axmor/axvoip/mojo/core/sip/SipSession;", "sipSession", "updateSipState", "(Lcom/axmor/axvoip/mojo/core/sip/SipSession;)V", "declineCall", "getSipAccount", "checkCallState", "cancelJobs", "loadCameraByIntercomUUID", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/sputnik/domain/usecases/call/GetCallUseCase;", "Lcom/sputnik/domain/usecases/call/AcceptCallUseCase;", "Lcom/sputnik/domain/usecases/call/GetSipAccountUseCase;", "Lcom/sputnik/domain/usecases/cameras/GetCameraByIntercomUUIDUseCase;", "Lsputnik/axmor/com/sputnik/mappers/call/DomainCallToCallMapper;", "Lsputnik/axmor/com/sputnik/mappers/call/DomainSipAccountToSipAccountMapper;", "Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;", "", "Lkotlinx/coroutines/Job;", "jobs", "Ljava/util/List;", "Factory", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallViewModel extends BaseViewModel<CallViewState> {
    private final AcceptCallUseCase acceptCallUseCase;
    private final DomainCallToCallMapper domainCallToCallMapper;
    private final DomainCameraToCameraMapper domainCameraToCameraMapper;
    private final DomainSipAccountToSipAccountMapper domainSipAccountToSipAccountMapper;
    private final GetCallUseCase getCallUseCase;
    private final GetCameraByIntercomUUIDUseCase getCameraByIntercomUUIDUseCase;
    private final GetSipAccountUseCase getSipAccountUseCase;
    private final List<Job> jobs;

    public /* synthetic */ CallViewModel(String str, String str2, String str3, boolean z, GetCallUseCase getCallUseCase, AcceptCallUseCase acceptCallUseCase, GetSipAccountUseCase getSipAccountUseCase, GetCameraByIntercomUUIDUseCase getCameraByIntercomUUIDUseCase, DomainCallToCallMapper domainCallToCallMapper, DomainSipAccountToSipAccountMapper domainSipAccountToSipAccountMapper, DomainCameraToCameraMapper domainCameraToCameraMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? false : z, getCallUseCase, acceptCallUseCase, getSipAccountUseCase, getCameraByIntercomUUIDUseCase, domainCallToCallMapper, domainSipAccountToSipAccountMapper, domainCameraToCameraMapper);
    }

    public CallViewModel(String str, String str2, String str3, boolean z, GetCallUseCase getCallUseCase, AcceptCallUseCase acceptCallUseCase, GetSipAccountUseCase getSipAccountUseCase, GetCameraByIntercomUUIDUseCase getCameraByIntercomUUIDUseCase, DomainCallToCallMapper domainCallToCallMapper, DomainSipAccountToSipAccountMapper domainSipAccountToSipAccountMapper, DomainCameraToCameraMapper domainCameraToCameraMapper) {
        Intrinsics.checkNotNullParameter(getCallUseCase, "getCallUseCase");
        Intrinsics.checkNotNullParameter(acceptCallUseCase, "acceptCallUseCase");
        Intrinsics.checkNotNullParameter(getSipAccountUseCase, "getSipAccountUseCase");
        Intrinsics.checkNotNullParameter(getCameraByIntercomUUIDUseCase, "getCameraByIntercomUUIDUseCase");
        Intrinsics.checkNotNullParameter(domainCallToCallMapper, "domainCallToCallMapper");
        Intrinsics.checkNotNullParameter(domainSipAccountToSipAccountMapper, "domainSipAccountToSipAccountMapper");
        Intrinsics.checkNotNullParameter(domainCameraToCameraMapper, "domainCameraToCameraMapper");
        CallViewState callViewState = new CallViewState(null, null, null, str, str2, str3, new Event(Boolean.valueOf(z)), null, null, null, false, null, null, null, 16263, null);
        String name = CallViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(callViewState, name);
        this.getCallUseCase = getCallUseCase;
        this.acceptCallUseCase = acceptCallUseCase;
        this.getSipAccountUseCase = getSipAccountUseCase;
        this.getCameraByIntercomUUIDUseCase = getCameraByIntercomUUIDUseCase;
        this.domainCallToCallMapper = domainCallToCallMapper;
        this.domainSipAccountToSipAccountMapper = domainSipAccountToSipAccountMapper;
        this.domainCameraToCameraMapper = domainCameraToCameraMapper;
        getCall();
        this.jobs = new ArrayList();
    }

    /* compiled from: CallViewModel.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001dBm\b\u0007\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u0002H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016¢\u0006\u0002\u0010\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", FailedBinderCallBack.CALLER_ID, "", "callUuid", "flatUuid", "navigateToAnswerCall", "", "getCallUseCase", "Lcom/sputnik/domain/usecases/call/GetCallUseCase;", "acceptCallUseCase", "Lcom/sputnik/domain/usecases/call/AcceptCallUseCase;", "getSipAccountUseCase", "Lcom/sputnik/domain/usecases/call/GetSipAccountUseCase;", "getCameraByIntercomUUIDUseCase", "Lcom/sputnik/domain/usecases/cameras/GetCameraByIntercomUUIDUseCase;", "domainCallToCallMapper", "Lsputnik/axmor/com/sputnik/mappers/call/DomainCallToCallMapper;", "domainSipAccountToSipAccountMapper", "Lsputnik/axmor/com/sputnik/mappers/call/DomainSipAccountToSipAccountMapper;", "domainCameraToCameraMapper", "Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/domain/usecases/call/GetCallUseCase;Lcom/sputnik/domain/usecases/call/AcceptCallUseCase;Lcom/sputnik/domain/usecases/call/GetSipAccountUseCase;Lcom/sputnik/domain/usecases/cameras/GetCameraByIntercomUUIDUseCase;Lsputnik/axmor/com/sputnik/mappers/call/DomainCallToCallMapper;Lsputnik/axmor/com/sputnik/mappers/call/DomainSipAccountToSipAccountMapper;Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AssistFactory", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        private final AcceptCallUseCase acceptCallUseCase;
        private final String callId;
        private final String callUuid;
        private final DomainCallToCallMapper domainCallToCallMapper;
        private final DomainCameraToCameraMapper domainCameraToCameraMapper;
        private final DomainSipAccountToSipAccountMapper domainSipAccountToSipAccountMapper;
        private final String flatUuid;
        private final GetCallUseCase getCallUseCase;
        private final GetCameraByIntercomUUIDUseCase getCameraByIntercomUUIDUseCase;
        private final GetSipAccountUseCase getSipAccountUseCase;
        private final boolean navigateToAnswerCall;

        public Factory(String str, String str2, String str3, boolean z, GetCallUseCase getCallUseCase, AcceptCallUseCase acceptCallUseCase, GetSipAccountUseCase getSipAccountUseCase, GetCameraByIntercomUUIDUseCase getCameraByIntercomUUIDUseCase, DomainCallToCallMapper domainCallToCallMapper, DomainSipAccountToSipAccountMapper domainSipAccountToSipAccountMapper, DomainCameraToCameraMapper domainCameraToCameraMapper) {
            Intrinsics.checkNotNullParameter(getCallUseCase, "getCallUseCase");
            Intrinsics.checkNotNullParameter(acceptCallUseCase, "acceptCallUseCase");
            Intrinsics.checkNotNullParameter(getSipAccountUseCase, "getSipAccountUseCase");
            Intrinsics.checkNotNullParameter(getCameraByIntercomUUIDUseCase, "getCameraByIntercomUUIDUseCase");
            Intrinsics.checkNotNullParameter(domainCallToCallMapper, "domainCallToCallMapper");
            Intrinsics.checkNotNullParameter(domainSipAccountToSipAccountMapper, "domainSipAccountToSipAccountMapper");
            Intrinsics.checkNotNullParameter(domainCameraToCameraMapper, "domainCameraToCameraMapper");
            this.callId = str;
            this.callUuid = str2;
            this.flatUuid = str3;
            this.navigateToAnswerCall = z;
            this.getCallUseCase = getCallUseCase;
            this.acceptCallUseCase = acceptCallUseCase;
            this.getSipAccountUseCase = getSipAccountUseCase;
            this.getCameraByIntercomUUIDUseCase = getCameraByIntercomUUIDUseCase;
            this.domainCallToCallMapper = domainCallToCallMapper;
            this.domainSipAccountToSipAccountMapper = domainSipAccountToSipAccountMapper;
            this.domainCameraToCameraMapper = domainCameraToCameraMapper;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (!Intrinsics.areEqual(modelClass, CallViewModel.class)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            return new CallViewModel(this.callId, this.callUuid, this.flatUuid, this.navigateToAnswerCall, this.getCallUseCase, this.acceptCallUseCase, this.getSipAccountUseCase, this.getCameraByIntercomUUIDUseCase, this.domainCallToCallMapper, this.domainSipAccountToSipAccountMapper, this.domainCameraToCameraMapper);
        }

        /* compiled from: CallViewModel.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "", "create", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory;", FailedBinderCallBack.CALLER_ID, "", "callUuid", "flatUuid", "navigateToAnswerCall", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface AssistFactory {
            Factory create(String callId, String callUuid, String flatUuid, boolean navigateToAnswerCall);

            /* compiled from: CallViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class DefaultImpls {
                public static /* synthetic */ Factory create$default(AssistFactory assistFactory, String str, String str2, String str3, boolean z, int i, Object obj) {
                    if (obj != null) {
                        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
                    }
                    if ((i & 1) != 0) {
                        str = null;
                    }
                    if ((i & 2) != 0) {
                        str2 = null;
                    }
                    if ((i & 4) != 0) {
                        str3 = null;
                    }
                    if ((i & 8) != 0) {
                        z = false;
                    }
                    return assistFactory.create(str, str2, str3, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveData<Resource<DomainCall>> getCallFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getCallUseCase.invoke(getCurrentState().getCallId()), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> acceptCallServer() {
        return FlowLiveDataConversions.asLiveData$default(this.acceptCallUseCase.invoke(getCurrentState().getCallId()), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainSipAccount>> getSipAccountFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getSipAccountUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainCamera>> getCameraByIntercomUUID(String uuid, String flatUUID) {
        return FlowLiveDataConversions.asLiveData$default(this.getCameraByIntercomUUIDUseCase.invoke(uuid, flatUUID), null, 0L, 3, null);
    }

    public void getCall() {
        PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Get call started", null, 4, null);
        subscribeOnDataSource(getCallFromServer(), new Function2<Resource<? extends DomainCall>, CallViewState, CallViewState>() { // from class: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel.getCall.1

            /* compiled from: CallViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel$getCall$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CallViewState invoke(Resource<? extends DomainCall> resource, CallViewState callViewState) {
                return invoke2((Resource<DomainCall>) resource, callViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CallViewState invoke2(Resource<DomainCall> serverData, CallViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((15102 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
                }
                Unit unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    PlutoLog plutoLog = PlutoLog.INSTANCE;
                    DomainCall data = serverData.getData();
                    PlutoLog.i$default(plutoLog, "Call", "Get call success: " + (data != null ? data.getState() : null), null, 4, null);
                    DomainCall data2 = serverData.getData();
                    if ((data2 != null ? data2.getState() : null) != CallState.started && !CallViewModel.this.getCurrentState().getAcceptedByMe()) {
                        CallViewModel.this.declineCall();
                        return null;
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    DomainCall data3 = serverData.getData();
                    return state.copy((15102 & 1) != 0 ? state.serverState : status, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : data3 != null ? CallViewModel.this.domainCallToCallMapper.map(data3) : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
                }
                PlutoLog plutoLog2 = PlutoLog.INSTANCE;
                Exception error = serverData.getError();
                PlutoLog.i$default(plutoLog2, "Call", "Get call error: " + (error != null ? error.getMessage() : null), null, 4, null);
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    CallViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    CallViewModel callViewModel = CallViewModel.this;
                    Exception error2 = serverData.getError();
                    Intrinsics.checkNotNull(error2);
                    callViewModel.notifySimpleError(error2);
                }
                CallViewModel.this.declineCall();
                return state.copy((15102 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
            }
        });
    }

    public void handleCall() {
        CallViewState currentState = getCurrentState();
        CallViewState callViewStateCopy = currentState.copy((15102 & 1) != 0 ? currentState.serverState : null, (15102 & 2) != 0 ? currentState.loadCameraState : null, (15102 & 4) != 0 ? currentState.currentCamera : null, (15102 & 8) != 0 ? currentState.callId : null, (15102 & 16) != 0 ? currentState.callUuid : null, (15102 & 32) != 0 ? currentState.flatUuid : null, (15102 & 64) != 0 ? currentState.navigateToAnswerCall : null, (15102 & 128) != 0 ? currentState.callResponse : null, (15102 & 256) != 0 ? currentState.callIsAccepted : null, (15102 & 512) != 0 ? currentState.callIsDeclined : null, (15102 & 1024) != 0 ? currentState.acceptedByMe : false, (15102 & 2048) != 0 ? currentState.sipIsLoaded : null, (15102 & 4096) != 0 ? currentState.callLoaded : new Event(Boolean.TRUE), (15102 & 8192) != 0 ? currentState.sipAccount : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallViewModel$handleCall$$inlined$updateState$1(callViewStateCopy, this, null), 3, null);
        getState().setValue(callViewStateCopy);
    }

    public void loadCameraByIntercomUUID(String uuid, String flatUUID) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(flatUUID, "flatUUID");
        CallViewState currentState = getCurrentState();
        CallViewState callViewStateCopy = currentState.copy((15102 & 1) != 0 ? currentState.serverState : null, (15102 & 2) != 0 ? currentState.loadCameraState : Resource.Status.LOADING, (15102 & 4) != 0 ? currentState.currentCamera : null, (15102 & 8) != 0 ? currentState.callId : null, (15102 & 16) != 0 ? currentState.callUuid : null, (15102 & 32) != 0 ? currentState.flatUuid : null, (15102 & 64) != 0 ? currentState.navigateToAnswerCall : null, (15102 & 128) != 0 ? currentState.callResponse : null, (15102 & 256) != 0 ? currentState.callIsAccepted : null, (15102 & 512) != 0 ? currentState.callIsDeclined : null, (15102 & 1024) != 0 ? currentState.acceptedByMe : false, (15102 & 2048) != 0 ? currentState.sipIsLoaded : null, (15102 & 4096) != 0 ? currentState.callLoaded : null, (15102 & 8192) != 0 ? currentState.sipAccount : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallViewModel$loadCameraByIntercomUUID$$inlined$updateState$1(callViewStateCopy, this, null), 3, null);
        getState().setValue(callViewStateCopy);
        subscribeOnDataSource(getCameraByIntercomUUID(uuid, flatUUID), new Function2<Resource<? extends DomainCamera>, CallViewState, CallViewState>() { // from class: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel.loadCameraByIntercomUUID.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CallViewState invoke(Resource<? extends DomainCamera> resource, CallViewState callViewState) {
                return invoke2((Resource<DomainCamera>) resource, callViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CallViewState invoke2(Resource<DomainCamera> camerasResponse, CallViewState state) {
                Intrinsics.checkNotNullParameter(camerasResponse, "camerasResponse");
                Intrinsics.checkNotNullParameter(state, "state");
                Resource.Status status = camerasResponse.getStatus();
                Resource.Status status2 = Resource.Status.LOADING;
                if (status == status2) {
                    return state.copy((15102 & 1) != 0 ? state.serverState : null, (15102 & 2) != 0 ? state.loadCameraState : status2, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
                }
                Resource.Status status3 = camerasResponse.getStatus();
                Resource.Status status4 = Resource.Status.ERROR;
                if (status3 == status4) {
                    return state.copy((15102 & 1) != 0 ? state.serverState : null, (15102 & 2) != 0 ? state.loadCameraState : status4, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
                }
                Resource.Status status5 = Resource.Status.SUCCESS;
                DomainCamera data = camerasResponse.getData();
                return state.copy((15102 & 1) != 0 ? state.serverState : null, (15102 & 2) != 0 ? state.loadCameraState : status5, (15102 & 4) != 0 ? state.currentCamera : data != null ? CallViewModel.this.domainCameraToCameraMapper.map(data) : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
            }
        });
    }

    public void acceptCall() {
        PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Start accepting call", null, 4, null);
        subscribeOnDataSource(acceptCallServer(), new Function2<Resource<? extends Unit>, CallViewState, CallViewState>() { // from class: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel.acceptCall.1

            /* compiled from: CallViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel$acceptCall$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CallViewState invoke(Resource<? extends Unit> resource, CallViewState callViewState) {
                return invoke2((Resource<Unit>) resource, callViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CallViewState invoke2(Resource<Unit> serverData, CallViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((15102 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Accept successful", null, 4, null);
                    SputnikApp.INSTANCE.getAnalyticsService().send("call", "call_accept", "request_success");
                    return state.copy((15102 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : new Event(Boolean.TRUE), (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : true, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
                }
                PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Accept failed", null, 4, null);
                SputnikApp.INSTANCE.getAnalyticsService().send("call", "call_accept", "error");
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                    unit = null;
                } else {
                    CallViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    CallViewModel callViewModel = CallViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    callViewModel.notifySimpleError(error);
                }
                return state.copy((15102 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
            }
        });
    }

    /* compiled from: CallViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel$updateSipState$1", f = "CallViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel$updateSipState$1, reason: invalid class name and case insensitive filesystem */
    static final class C26471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SipSession $sipSession;
        int label;
        final /* synthetic */ CallViewModel this$0;

        /* compiled from: CallViewModel.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel$updateSipState$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SipSession.SipState.values().length];
                try {
                    iArr[SipSession.SipState.REGISTRATION_IN_PROGRESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SipSession.SipState.REGISTERED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26471(SipSession sipSession, CallViewModel callViewModel, Continuation<? super C26471> continuation) {
            super(2, continuation);
            this.$sipSession = sipSession;
            this.this$0 = callViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C26471(this.$sipSession, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SipSession sipSession = this.$sipSession;
            if (sipSession != null) {
                SipSession.SipState state = sipSession.getState();
                int i = state == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i == 1) {
                    PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "SIP registration in progress", null, 4, null);
                    Log.e("CALLVIEWMODEL", "reg_in_progress");
                } else if (i == 2) {
                    PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "SIP registered", null, 4, null);
                    this.this$0.acceptCall();
                    Log.e("CALLVIEWMODEL", "registred");
                } else {
                    this.this$0.getSipAccount();
                }
            } else {
                this.this$0.getSipAccount();
            }
            return Unit.INSTANCE;
        }
    }

    public void updateSipState(SipSession sipSession) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C26471(sipSession, this, null), 2, null);
    }

    public void declineCall() {
        PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Declining call", null, 4, null);
        SputnikApp.Companion companion = SputnikApp.INSTANCE;
        AnalyticsService.send$default(companion.getAnalyticsService(), "call", "call_decline", null, 4, null);
        companion.changeCallState(new SputnikApp.Companion.CallState(false, null, null, null, 8, null));
        CallViewState currentState = getCurrentState();
        CallViewState callViewStateCopy = currentState.copy((15102 & 1) != 0 ? currentState.serverState : null, (15102 & 2) != 0 ? currentState.loadCameraState : null, (15102 & 4) != 0 ? currentState.currentCamera : null, (15102 & 8) != 0 ? currentState.callId : null, (15102 & 16) != 0 ? currentState.callUuid : null, (15102 & 32) != 0 ? currentState.flatUuid : null, (15102 & 64) != 0 ? currentState.navigateToAnswerCall : null, (15102 & 128) != 0 ? currentState.callResponse : null, (15102 & 256) != 0 ? currentState.callIsAccepted : null, (15102 & 512) != 0 ? currentState.callIsDeclined : new Event(Boolean.TRUE), (15102 & 1024) != 0 ? currentState.acceptedByMe : false, (15102 & 2048) != 0 ? currentState.sipIsLoaded : null, (15102 & 4096) != 0 ? currentState.callLoaded : null, (15102 & 8192) != 0 ? currentState.sipAccount : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallViewModel$declineCall$$inlined$updateState$1(callViewStateCopy, this, null), 3, null);
        getState().setValue(callViewStateCopy);
    }

    public void getSipAccount() {
        PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Getting sip account", null, 4, null);
        subscribeOnDataSource(getSipAccountFromServer(), new Function2<Resource<? extends DomainSipAccount>, CallViewState, CallViewState>() { // from class: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel.getSipAccount.1

            /* compiled from: CallViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel$getSipAccount$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CallViewState invoke(Resource<? extends DomainSipAccount> resource, CallViewState callViewState) {
                return invoke2((Resource<DomainSipAccount>) resource, callViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CallViewState invoke2(Resource<DomainSipAccount> serverData, CallViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((15102 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
                }
                Unit unit = null;
                unit = null;
                if (i == 3) {
                    PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Get SIP account failed", null, 4, null);
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        CallViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        CallViewModel callViewModel = CallViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        callViewModel.notifySimpleError(error);
                    }
                    return state.copy((15102 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : null, (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                DomainSipAccount data = serverData.getData();
                if ((data != null ? data.getDomain() : null) == null) {
                    PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Get SIP account successful, but no sip data", null, 4, null);
                    CallViewModel.this.getSipAccount();
                    return null;
                }
                DomainSipAccount data2 = serverData.getData();
                SipAccount map = data2 != null ? CallViewModel.this.domainSipAccountToSipAccountMapper.map(data2) : null;
                PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Get SIP account successful: " + (map != null ? map.getSipServer() : null) + " | " + (map != null ? map.getSipPort() : null) + " " + (map != null ? map.getDomain() : null) + " | " + (map != null ? map.getLogin() : null) + " | " + (map != null ? map.getAddress() : null), null, 4, null);
                return state.copy((15102 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (15102 & 2) != 0 ? state.loadCameraState : null, (15102 & 4) != 0 ? state.currentCamera : null, (15102 & 8) != 0 ? state.callId : null, (15102 & 16) != 0 ? state.callUuid : null, (15102 & 32) != 0 ? state.flatUuid : null, (15102 & 64) != 0 ? state.navigateToAnswerCall : null, (15102 & 128) != 0 ? state.callResponse : null, (15102 & 256) != 0 ? state.callIsAccepted : null, (15102 & 512) != 0 ? state.callIsDeclined : null, (15102 & 1024) != 0 ? state.acceptedByMe : false, (15102 & 2048) != 0 ? state.sipIsLoaded : new Event(Boolean.TRUE), (15102 & 4096) != 0 ? state.callLoaded : null, (15102 & 8192) != 0 ? state.sipAccount : map);
            }
        });
    }

    public void checkCallState() {
        this.jobs.add(delayRequestWithJob(1000L, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel$checkCallState$checkCallStateJob$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CallViewModel callViewModel = this.this$0;
                LiveData callFromServer = callViewModel.getCallFromServer();
                final CallViewModel callViewModel2 = this.this$0;
                callViewModel.subscribeOnDataSource(callFromServer, new Function2<Resource<? extends DomainCall>, CallViewState, CallViewState>() { // from class: sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel$checkCallState$checkCallStateJob$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ CallViewState invoke(Resource<? extends DomainCall> resource, CallViewState callViewState) {
                        return invoke2((Resource<DomainCall>) resource, callViewState);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final CallViewState invoke2(Resource<DomainCall> serverData, CallViewState state) {
                        Intrinsics.checkNotNullParameter(serverData, "serverData");
                        Intrinsics.checkNotNullParameter(state, "state");
                        if (serverData.getStatus() != Resource.Status.SUCCESS) {
                            return null;
                        }
                        DomainCall data = serverData.getData();
                        Intrinsics.checkNotNull(data);
                        DomainCall domainCall = data;
                        if (domainCall.getState() != CallState.started && !callViewModel2.getCurrentState().getAcceptedByMe()) {
                            callViewModel2.declineCall();
                            SputnikApp.INSTANCE.getAnalyticsService().send("call", "call_accept", "call_busy");
                            return null;
                        }
                        Log.e("call_state", domainCall.toString());
                        callViewModel2.checkCallState();
                        return null;
                    }
                });
            }
        }));
    }

    public void cancelJobs() {
        try {
            Iterator<T> it = this.jobs.iterator();
            while (it.hasNext()) {
                Job.DefaultImpls.cancel$default((Job) it.next(), null, 1, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
