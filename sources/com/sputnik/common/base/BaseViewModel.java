package com.sputnik.common.base;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.Notify;
import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u001d¢\u0006\u0004\b\u001f\u0010 JC\u0010#\u001a\u00020\f\"\u0004\b\u0001\u0010!2\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u001d¢\u0006\u0004\b#\u0010$J)\u0010&\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0\u001d¢\u0006\u0004\b&\u0010 J?\u0010+\u001a\u00020\f\"\u0004\b\u0001\u0010'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010(2\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000*H\u0004¢\u0006\u0004\b+\u0010,J\u0019\u00100\u001a\u00020\f2\n\u0010/\u001a\u00060-j\u0002`.¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0005¢\u0006\u0004\b5\u00104J\u000f\u00106\u001a\u00020\fH\u0014¢\u0006\u0004\b6\u00107R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00108R0\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t09j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t`:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R,\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170>0=8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b?\u0010@\u0012\u0004\bC\u00107\u001a\u0004\bA\u0010BR&\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000D8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bE\u0010F\u0012\u0004\bI\u00107\u001a\u0004\bG\u0010HR\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000J8\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001a\u0010R\u001a\u00028\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u00107\u001a\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/base/VMState;", "T", "Landroidx/lifecycle/ViewModel;", "initState", "", "KEY", "<init>", "(Lcom/sputnik/common/base/VMState;Ljava/lang/String;)V", "", "milliSeconds", "Lkotlin/Function0;", "", "request", "delayRequest", "(JLkotlin/jvm/functions/Function0;)V", "Lkotlinx/coroutines/Job;", "delayRequestWithJob", "(JLkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", "requestName", "blockDuration", "delayRequestWithBlocking", "(JLjava/lang/String;JLkotlin/jvm/functions/Function0;)V", "Lcom/sputnik/common/base/Notify;", "content", "notify", "(Lcom/sputnik/common/base/Notify;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function1;", "onChanged", "observeState", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;)V", "D", "transform", "observeSubState", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onNotify", "observeNotifications", "S", "Landroidx/lifecycle/LiveData;", "source", "Lkotlin/Function2;", "subscribeOnDataSource", "(Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function2;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "notifySimpleError", "(Ljava/lang/Exception;)V", RemoteMessageConst.MessageBody.MSG, "notifyErrorMessage", "(Ljava/lang/String;)V", "notifySuccessMessage", "onCleared", "()V", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "delayingRequestsHashMap", "Ljava/util/HashMap;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/sputnik/domain/common/Event;", "notifications", "Landroidx/lifecycle/MutableLiveData;", "getNotifications", "()Landroidx/lifecycle/MutableLiveData;", "getNotifications$annotations", "Landroidx/lifecycle/MediatorLiveData;", "state", "Landroidx/lifecycle/MediatorLiveData;", "getState", "()Landroidx/lifecycle/MediatorLiveData;", "getState$annotations", "Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "getCurrentState", "()Lcom/sputnik/common/base/VMState;", "getCurrentState$annotations", "currentState", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseViewModel<T extends VMState> extends ViewModel {
    private final String KEY;
    private final HashMap<String, Long> delayingRequestsHashMap;
    private final MutableLiveData<Event<Notify>> notifications;
    private final MediatorLiveData<T> state;
    private final MutableStateFlow<T> uiState;

    public BaseViewModel(T initState, String KEY) {
        Intrinsics.checkNotNullParameter(initState, "initState");
        Intrinsics.checkNotNullParameter(KEY, "KEY");
        this.KEY = KEY;
        this.delayingRequestsHashMap = new HashMap<>();
        this.notifications = new MutableLiveData<>();
        MediatorLiveData<T> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.setValue(initState);
        this.state = mediatorLiveData;
        this.uiState = StateFlowKt.MutableStateFlow(initState);
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lcom/sputnik/common/base/VMState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.base.BaseViewModel$delayRequest$1", f = "BaseViewModel.kt", l = {43, 44}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.base.BaseViewModel$delayRequest$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $milliSeconds;
        final /* synthetic */ Function0<Unit> $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$milliSeconds = j;
            this.$request = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$milliSeconds, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$milliSeconds;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            C01091 c01091 = new C01091(this.$request, null);
            this.label = 2;
            if (BuildersKt.withContext(main, c01091, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* compiled from: BaseViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lcom/sputnik/common/base/VMState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.common.base.BaseViewModel$delayRequest$1$1", f = "BaseViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sputnik.common.base.BaseViewModel$delayRequest$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $request;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01091(Function0<Unit> function0, Continuation<? super C01091> continuation) {
                super(2, continuation);
                this.$request = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01091(this.$request, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$request.invoke();
                return Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ void delayRequest$default(BaseViewModel baseViewModel, long j, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delayRequest");
        }
        if ((i & 1) != 0) {
            j = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
        }
        baseViewModel.delayRequest(j, function0);
    }

    public final void delayRequest(long milliSeconds, Function0<Unit> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(milliSeconds, request, null), 3, null);
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lcom/sputnik/common/base/VMState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.base.BaseViewModel$delayRequestWithJob$1", f = "BaseViewModel.kt", l = {52, 53}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.base.BaseViewModel$delayRequestWithJob$1, reason: invalid class name and case insensitive filesystem */
    static final class C06351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $milliSeconds;
        final /* synthetic */ Function0<Unit> $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06351(long j, Function0<Unit> function0, Continuation<? super C06351> continuation) {
            super(2, continuation);
            this.$milliSeconds = j;
            this.$request = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06351(this.$milliSeconds, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$milliSeconds;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            C01101 c01101 = new C01101(this.$request, null);
            this.label = 2;
            if (BuildersKt.withContext(main, c01101, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* compiled from: BaseViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lcom/sputnik/common/base/VMState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.common.base.BaseViewModel$delayRequestWithJob$1$1", f = "BaseViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sputnik.common.base.BaseViewModel$delayRequestWithJob$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $request;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01101(Function0<Unit> function0, Continuation<? super C01101> continuation) {
                super(2, continuation);
                this.$request = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01101(this.$request, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$request.invoke();
                return Unit.INSTANCE;
            }
        }
    }

    public final Job delayRequestWithJob(long milliSeconds, Function0<Unit> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C06351(milliSeconds, request, null), 3, null);
    }

    public static /* synthetic */ void delayRequestWithBlocking$default(BaseViewModel baseViewModel, long j, String str, long j2, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delayRequestWithBlocking");
        }
        if ((i & 1) != 0) {
            j = 3000;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i & 4) != 0) {
            long j4 = j3 - 500;
            if (j4 <= 0) {
                j4 = 400;
            }
            j2 = j4;
        }
        baseViewModel.delayRequestWithBlocking(j3, str2, j2, function0);
    }

    public final void delayRequestWithBlocking(long milliSeconds, String requestName, long blockDuration, Function0<Unit> request) {
        Intrinsics.checkNotNullParameter(requestName, "requestName");
        Intrinsics.checkNotNullParameter(request, "request");
        if (StringsKt.isBlank(requestName)) {
            delayRequest(milliSeconds, request);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l = this.delayingRequestsHashMap.get(requestName);
        if (l == null || jCurrentTimeMillis - l.longValue() >= blockDuration) {
            delayRequest(milliSeconds, request);
        }
        this.delayingRequestsHashMap.put(requestName, Long.valueOf(jCurrentTimeMillis));
    }

    public final MediatorLiveData<T> getState() {
        return this.state;
    }

    public final MutableStateFlow<T> getUiState() {
        return this.uiState;
    }

    public final T getCurrentState() {
        T value = this.state.getValue();
        Intrinsics.checkNotNull(value);
        return value;
    }

    public final void notify(Notify content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.notifications.setValue(new Event<>(content));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeState$lambda$1(Function1 onChanged, VMState vMState) {
        Intrinsics.checkNotNullParameter(onChanged, "$onChanged");
        Intrinsics.checkNotNull(vMState);
        onChanged.invoke(vMState);
    }

    public final void observeState(LifecycleOwner owner, final Function1<? super T, Unit> onChanged) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        this.state.observe(owner, new Observer() { // from class: com.sputnik.common.base.BaseViewModel$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseViewModel.observeState$lambda$1(onChanged, (VMState) obj);
            }
        });
    }

    public final <D> void observeSubState(LifecycleOwner owner, Function1<? super T, ? extends D> transform, final Function1<? super D, Unit> onChanged) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        Transformations.distinctUntilChanged(Transformations.map(this.state, transform)).observe(owner, new Observer() { // from class: com.sputnik.common.base.BaseViewModel$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseViewModel.observeSubState$lambda$2(onChanged, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeSubState$lambda$2(Function1 onChanged, Object obj) {
        Intrinsics.checkNotNullParameter(onChanged, "$onChanged");
        onChanged.invoke(obj);
    }

    public final void observeNotifications(LifecycleOwner owner, final Function1<? super Notify, Unit> onNotify) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onNotify, "onNotify");
        this.notifications.observe(owner, new EventObserver(new Function1<Notify, Unit>() { // from class: com.sputnik.common.base.BaseViewModel.observeNotifications.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notify notify) {
                invoke2(notify);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notify it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onNotify.invoke(it);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <S> void subscribeOnDataSource(LiveData<S> source, final Function2<? super S, ? super T, ? extends T> onChanged) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        this.state.addSource(source, new BaseViewModel$sam$androidx_lifecycle_Observer$0(new Function1<S, Unit>(this) { // from class: com.sputnik.common.base.BaseViewModel.subscribeOnDataSource.1
            final /* synthetic */ BaseViewModel<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((C06371<S>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(S s) {
                MediatorLiveData<T> state = this.this$0.getState();
                VMState vMState = (VMState) onChanged.invoke(s, this.this$0.getCurrentState());
                if (vMState == null) {
                    return;
                }
                state.setValue(vMState);
                MutableStateFlow<T> uiState = this.this$0.getUiState();
                VMState vMState2 = (VMState) onChanged.invoke(s, this.this$0.getCurrentState());
                if (vMState2 == null) {
                    return;
                }
                uiState.setValue(vMState2);
            }
        }));
    }

    public final void notifySimpleError(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        notify(new Notify.ErrorMessage("Ошибка: " + e.getMessage(), "Ок", null));
    }

    public final void notifyErrorMessage(String msg) {
        notify(new Notify.ErrorMessage(msg, "Ок", null));
    }

    public final void notifySuccessMessage(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        notify(new Notify.TextMessage(msg));
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.delayingRequestsHashMap.clear();
    }
}
