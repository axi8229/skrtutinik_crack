package sputnik.axmor.com.sputnik.services.call_service;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.CallState;
import com.sputnik.domain.entities.call.DomainCall;
import com.sputnik.domain.usecases.call.GetCallUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: CheckCallStateService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lsputnik/axmor/com/sputnik/services/call_service/CheckCallStateService;", "", "Landroid/content/Context;", "context", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V", "", FailedBinderCallBack.CALLER_ID, "Lkotlin/Function0;", "", "onNeedCancelPush", "startCheckingCallState", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", "Landroidx/lifecycle/Lifecycle;", "Lcom/sputnik/domain/usecases/call/GetCallUseCase;", "getCallUseCase", "Lcom/sputnik/domain/usecases/call/GetCallUseCase;", "getGetCallUseCase", "()Lcom/sputnik/domain/usecases/call/GetCallUseCase;", "setGetCallUseCase", "(Lcom/sputnik/domain/usecases/call/GetCallUseCase;)V", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "checkCallStateJob", "Lkotlinx/coroutines/Job;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckCallStateService {
    private Job checkCallStateJob;
    private final Context context;
    private final CoroutineScope coroutineContext;
    public GetCallUseCase getCallUseCase;
    private final Lifecycle lifecycle;

    public CheckCallStateService(Context context, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.lifecycle = lifecycle;
        this.coroutineContext = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        ContextKt.getAppComponent(context).inject(this);
        if (lifecycle != null) {
            lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService.1
                @Override // androidx.lifecycle.DefaultLifecycleObserver
                public void onDestroy(LifecycleOwner owner) {
                    Intrinsics.checkNotNullParameter(owner, "owner");
                    super.onDestroy(owner);
                    Job job = CheckCallStateService.this.checkCallStateJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, null, 1, null);
                    }
                }
            });
        }
    }

    public final GetCallUseCase getGetCallUseCase() {
        GetCallUseCase getCallUseCase = this.getCallUseCase;
        if (getCallUseCase != null) {
            return getCallUseCase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getCallUseCase");
        return null;
    }

    /* compiled from: CheckCallStateService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService$startCheckingCallState$1", f = "CheckCallStateService.kt", l = {41}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService$startCheckingCallState$1, reason: invalid class name and case insensitive filesystem */
    static final class C26371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $callId;
        final /* synthetic */ Function0<Unit> $onNeedCancelPush;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26371(String str, Function0<Unit> function0, Continuation<? super C26371> continuation) {
            super(2, continuation);
            this.$callId = str;
            this.$onNeedCancelPush = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CheckCallStateService.this.new C26371(this.$callId, this.$onNeedCancelPush, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CheckCallStateService.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/call/DomainCall;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService$startCheckingCallState$1$1", f = "CheckCallStateService.kt", l = {46}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService$startCheckingCallState$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03611 extends SuspendLambda implements Function2<Resource<? extends DomainCall>, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $callId;
            final /* synthetic */ Function0<Unit> $onNeedCancelPush;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CheckCallStateService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03611(Function0<Unit> function0, CheckCallStateService checkCallStateService, String str, Continuation<? super C03611> continuation) {
                super(2, continuation);
                this.$onNeedCancelPush = function0;
                this.this$0 = checkCallStateService;
                this.$callId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C03611 c03611 = new C03611(this.$onNeedCancelPush, this.this$0, this.$callId, continuation);
                c03611.L$0 = obj;
                return c03611;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Resource<DomainCall> resource, Continuation<? super Unit> continuation) {
                return ((C03611) create(resource, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Resource<? extends DomainCall> resource, Continuation<? super Unit> continuation) {
                return invoke2((Resource<DomainCall>) resource, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Resource resource = (Resource) this.L$0;
                    if (resource.getStatus() == Resource.Status.SUCCESS) {
                        DomainCall domainCall = (DomainCall) resource.getData();
                        if ((domainCall != null ? domainCall.getState() : null) != CallState.accepted) {
                            DomainCall domainCall2 = (DomainCall) resource.getData();
                            if ((domainCall2 != null ? domainCall2.getState() : null) != CallState.declined) {
                                this.label = 1;
                                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        this.$onNeedCancelPush.invoke();
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.startCheckingCallState(this.$callId, this.$onNeedCancelPush);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Resource<DomainCall>> flowInvoke = CheckCallStateService.this.getGetCallUseCase().invoke(this.$callId);
                C03611 c03611 = new C03611(this.$onNeedCancelPush, CheckCallStateService.this, this.$callId, null);
                this.label = 1;
                if (FlowKt.collectLatest(flowInvoke, c03611, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void startCheckingCallState(String callId, Function0<Unit> onNeedCancelPush) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(onNeedCancelPush, "onNeedCancelPush");
        this.checkCallStateJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineContext, null, null, new C26371(callId, onNeedCancelPush, null), 3, null);
    }
}
