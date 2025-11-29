package com.sputnik.data.repositories.popups;

import com.sputnik.data.api.PopupStoriesApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.popups.DataPopupStoryStructure;
import com.sputnik.data.entities.popups.DataSendActionRequest;
import com.sputnik.data.mappers.popups.DataPopupStoryToDomainPopupStoryMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import com.sputnik.domain.repositories.popups.IPopupStoriesRepository;
import java.util.List;
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

/* compiled from: PopupStoriesRepository.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B+\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J,\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/sputnik/data/repositories/popups/PopupStoriesRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/popups/IPopupStoriesRepository;", "popupStoriesApi", "Lcom/sputnik/data/api/PopupStoriesApi;", "mapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;", "Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "objectMapper", "Lcom/sputnik/data/mappers/popups/DataPopupStoryToDomainPopupStoryMapper;", "(Lcom/sputnik/data/api/PopupStoriesApi;Lcom/sputnik/domain/common/NullableInputListMapper;Lcom/sputnik/data/mappers/popups/DataPopupStoryToDomainPopupStoryMapper;)V", "loadPopupStories", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "version", "", "sendAction", "popupId", "", "popupStoryId", "action", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PopupStoriesRepository extends BaseApiResponse implements IPopupStoriesRepository {
    private final NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure> mapper;
    private final DataPopupStoryToDomainPopupStoryMapper objectMapper;
    private final PopupStoriesApi popupStoriesApi;

    public PopupStoriesRepository(PopupStoriesApi popupStoriesApi, NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure> mapper, DataPopupStoryToDomainPopupStoryMapper objectMapper) {
        Intrinsics.checkNotNullParameter(popupStoriesApi, "popupStoriesApi");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(objectMapper, "objectMapper");
        this.popupStoriesApi = popupStoriesApi;
        this.mapper = mapper;
        this.objectMapper = objectMapper;
    }

    /* compiled from: PopupStoriesRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.popups.PopupStoriesRepository$loadPopupStories$1", f = "PopupStoriesRepository.kt", l = {27, 27}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.popups.PopupStoriesRepository$loadPopupStories$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataPopupStoryStructure>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $version;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$version = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = PopupStoriesRepository.this.new AnonymousClass1(this.$version, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataPopupStoryStructure>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataPopupStoryStructure>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataPopupStoryStructure>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PopupStoriesRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.popups.PopupStoriesRepository$loadPopupStories$1$1", f = "PopupStoriesRepository.kt", l = {28}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.popups.PopupStoriesRepository$loadPopupStories$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02241 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataPopupStoryStructure>>>, Object> {
            final /* synthetic */ int $version;
            int label;
            final /* synthetic */ PopupStoriesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02241(PopupStoriesRepository popupStoriesRepository, int i, Continuation<? super C02241> continuation) {
                super(1, continuation);
                this.this$0 = popupStoriesRepository;
                this.$version = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02241(this.this$0, this.$version, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataPopupStoryStructure>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataPopupStoryStructure>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataPopupStoryStructure>>> continuation) {
                return ((C02241) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PopupStoriesApi popupStoriesApi = this.this$0.popupStoriesApi;
                    int i2 = this.$version;
                    this.label = 1;
                    obj = popupStoriesApi.getPopups(i2, this);
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
                PopupStoriesRepository popupStoriesRepository = PopupStoriesRepository.this;
                C02241 c02241 = new C02241(popupStoriesRepository, this.$version, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = popupStoriesRepository.safeApiCall(c02241, this);
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

    @Override // com.sputnik.domain.repositories.popups.IPopupStoriesRepository
    public Flow<Resource<List<DomainPopupStoryStructure>>> loadPopupStories(int version) {
        return FlowKt.flow(new PopupStoriesRepository$loadPopupStories$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(version, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: PopupStoriesRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.popups.PopupStoriesRepository$sendAction$1", f = "PopupStoriesRepository.kt", l = {45, 45}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.popups.PopupStoriesRepository$sendAction$1, reason: invalid class name and case insensitive filesystem */
    static final class C07191 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPopupStoryStructure>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $action;
        final /* synthetic */ String $popupId;
        final /* synthetic */ String $popupStoryId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07191(String str, String str2, String str3, Continuation<? super C07191> continuation) {
            super(2, continuation);
            this.$popupId = str;
            this.$popupStoryId = str2;
            this.$action = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07191 c07191 = PopupStoriesRepository.this.new C07191(this.$popupId, this.$popupStoryId, this.$action, continuation);
            c07191.L$0 = obj;
            return c07191;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPopupStoryStructure>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPopupStoryStructure>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPopupStoryStructure>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07191) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PopupStoriesRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.popups.PopupStoriesRepository$sendAction$1$1", f = "PopupStoriesRepository.kt", l = {46}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.popups.PopupStoriesRepository$sendAction$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02251 extends SuspendLambda implements Function1<Continuation<? super Response<DataPopupStoryStructure>>, Object> {
            final /* synthetic */ String $action;
            final /* synthetic */ String $popupId;
            final /* synthetic */ String $popupStoryId;
            int label;
            final /* synthetic */ PopupStoriesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02251(PopupStoriesRepository popupStoriesRepository, String str, String str2, String str3, Continuation<? super C02251> continuation) {
                super(1, continuation);
                this.this$0 = popupStoriesRepository;
                this.$popupId = str;
                this.$popupStoryId = str2;
                this.$action = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02251(this.this$0, this.$popupId, this.$popupStoryId, this.$action, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPopupStoryStructure>> continuation) {
                return ((C02251) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PopupStoriesApi popupStoriesApi = this.this$0.popupStoriesApi;
                    String str = this.$popupId;
                    String str2 = this.$popupStoryId;
                    DataSendActionRequest dataSendActionRequest = new DataSendActionRequest(this.$action);
                    this.label = 1;
                    obj = popupStoriesApi.sendAction(str, str2, dataSendActionRequest, this);
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
                PopupStoriesRepository popupStoriesRepository = PopupStoriesRepository.this;
                C02251 c02251 = new C02251(popupStoriesRepository, this.$popupId, this.$popupStoryId, this.$action, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = popupStoriesRepository.safeApiCall(c02251, this);
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

    @Override // com.sputnik.domain.repositories.popups.IPopupStoriesRepository
    public Flow<Resource<DomainPopupStoryStructure>> sendAction(String popupId, String popupStoryId, String action) {
        Intrinsics.checkNotNullParameter(popupId, "popupId");
        Intrinsics.checkNotNullParameter(popupStoryId, "popupStoryId");
        Intrinsics.checkNotNullParameter(action, "action");
        return FlowKt.flow(new PopupStoriesRepository$sendAction$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07191(popupId, popupStoryId, action, null)), Dispatchers.getIO()), null, this));
    }
}
