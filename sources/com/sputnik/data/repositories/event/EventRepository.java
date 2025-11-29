package com.sputnik.data.repositories.event;

import com.sputnik.data.api.EventApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.event.DataEvent;
import com.sputnik.data.entities.event.DataPayload;
import com.sputnik.data.entities.issues.DataIssue;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.event.EventsType;
import com.sputnik.domain.repositories.event.IEventRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import retrofit2.Response;

/* compiled from: EventRepository.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ?\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/sputnik/data/repositories/event/EventRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/event/IEventRepository;", "Lcom/sputnik/data/api/EventApi;", "eventApi", "<init>", "(Lcom/sputnik/data/api/EventApi;)V", "", "identifier", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "reportNoVideoEvent", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "addressId", "errorCode", "cameraUUID", "intercomUUID", "reportIssue", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/data/api/EventApi;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EventRepository extends BaseApiResponse implements IEventRepository {
    private final EventApi eventApi;

    public EventRepository(EventApi eventApi) {
        Intrinsics.checkNotNullParameter(eventApi, "eventApi");
        this.eventApi = eventApi;
    }

    /* compiled from: EventRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.event.EventRepository$reportNoVideoEvent$1", f = "EventRepository.kt", l = {28, 28}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.event.EventRepository$reportNoVideoEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C06951 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $identifier;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06951(String str, Continuation<? super C06951> continuation) {
            super(2, continuation);
            this.$identifier = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06951 c06951 = EventRepository.this.new C06951(this.$identifier, continuation);
            c06951.L$0 = obj;
            return c06951;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06951) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: EventRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.event.EventRepository$reportNoVideoEvent$1$1", f = "EventRepository.kt", l = {29}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.event.EventRepository$reportNoVideoEvent$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01561 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $identifier;
            int label;
            final /* synthetic */ EventRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01561(EventRepository eventRepository, String str, Continuation<? super C01561> continuation) {
                super(1, continuation);
                this.this$0 = eventRepository;
                this.$identifier = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01561(this.this$0, this.$identifier, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01561) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    EventApi eventApi = this.this$0.eventApi;
                    DataEvent dataEvent = new DataEvent(EventsType.no_video_on_stream, new DataPayload(this.$identifier));
                    this.label = 1;
                    obj = eventApi.eventNoVideo(dataEvent, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                EventRepository eventRepository = EventRepository.this;
                C01561 c01561 = new C01561(eventRepository, this.$identifier, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = eventRepository.safeApiCall(c01561, this);
                if (obj == coroutine_suspended) {
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
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.sputnik.domain.repositories.event.IEventRepository
    public Flow<Resource<Unit>> reportNoVideoEvent(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return FlowKt.flowOn(FlowKt.flow(new C06951(identifier, null)), Dispatchers.getIO());
    }

    /* compiled from: EventRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.event.EventRepository$reportIssue$1", f = "EventRepository.kt", l = {59, 59}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.event.EventRepository$reportIssue$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ String $cameraUUID;
        final /* synthetic */ String $errorCode;
        final /* synthetic */ String $intercomUUID;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, String str, String str2, String str3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$errorCode = str;
            this.$cameraUUID = str2;
            this.$intercomUUID = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = EventRepository.this.new AnonymousClass1(this.$addressId, this.$errorCode, this.$cameraUUID, this.$intercomUUID, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: EventRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.event.EventRepository$reportIssue$1$1", f = "EventRepository.kt", l = {60}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.event.EventRepository$reportIssue$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01551 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ String $cameraUUID;
            final /* synthetic */ String $errorCode;
            final /* synthetic */ String $intercomUUID;
            int label;
            final /* synthetic */ EventRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01551(EventRepository eventRepository, int i, String str, String str2, String str3, Continuation<? super C01551> continuation) {
                super(1, continuation);
                this.this$0 = eventRepository;
                this.$addressId = i;
                this.$errorCode = str;
                this.$cameraUUID = str2;
                this.$intercomUUID = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01551(this.this$0, this.$addressId, this.$errorCode, this.$cameraUUID, this.$intercomUUID, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01551) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    EventApi eventApi = this.this$0.eventApi;
                    DataIssue dataIssue = new DataIssue(this.$addressId, this.$errorCode, this.$cameraUUID, this.$intercomUUID);
                    this.label = 1;
                    obj = eventApi.createIssue(dataIssue, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                EventRepository eventRepository = EventRepository.this;
                C01551 c01551 = new C01551(eventRepository, this.$addressId, this.$errorCode, this.$cameraUUID, this.$intercomUUID, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = eventRepository.safeApiCall(c01551, this);
                if (obj == coroutine_suspended) {
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
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.sputnik.domain.repositories.event.IEventRepository
    public Flow<Resource<Unit>> reportIssue(int addressId, String errorCode, String cameraUUID, String intercomUUID) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(addressId, errorCode, cameraUUID, intercomUUID, null)), Dispatchers.getIO());
    }
}
