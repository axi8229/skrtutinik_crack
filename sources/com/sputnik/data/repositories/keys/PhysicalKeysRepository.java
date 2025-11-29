package com.sputnik.data.repositories.keys;

import com.sputnik.data.api.PhysicalKeysApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.keys.DataPhysicalKey;
import com.sputnik.data.mappers.keys.DataPhysicalKeyToDomainPhysicalKeyMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.keys.DomainPhysicalKey;
import com.sputnik.domain.repositories.keys.IPhysicalKeysRepository;
import flussonic.media.FFmpegMediaMetadataRetriever;
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

/* compiled from: PhysicalKeysRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J,\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00170\f0\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/sputnik/data/repositories/keys/PhysicalKeysRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/keys/IPhysicalKeysRepository;", "api", "Lcom/sputnik/data/api/PhysicalKeysApi;", "mapper", "Lcom/sputnik/data/mappers/keys/DataPhysicalKeyToDomainPhysicalKeyMapper;", "(Lcom/sputnik/data/api/PhysicalKeysApi;Lcom/sputnik/data/mappers/keys/DataPhysicalKeyToDomainPhysicalKeyMapper;)V", "getApi", "()Lcom/sputnik/data/api/PhysicalKeysApi;", "blockKey", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/keys/DomainPhysicalKey;", "uuid", "", "createKey", "addressId", "", "hex", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "deleteKey", "getKeys", "", "unblockKey", "updateComment", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PhysicalKeysRepository extends BaseApiResponse implements IPhysicalKeysRepository {
    private final PhysicalKeysApi api;
    private final DataPhysicalKeyToDomainPhysicalKeyMapper mapper;

    public final PhysicalKeysApi getApi() {
        return this.api;
    }

    public PhysicalKeysRepository(PhysicalKeysApi api, DataPhysicalKeyToDomainPhysicalKeyMapper mapper) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.api = api;
        this.mapper = mapper;
    }

    /* compiled from: PhysicalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$getKeys$1", f = "PhysicalKeysRepository.kt", l = {25, 25}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$getKeys$1, reason: invalid class name and case insensitive filesystem */
    static final class C07081 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataPhysicalKey>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07081(int i, Continuation<? super C07081> continuation) {
            super(2, continuation);
            this.$addressId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07081 c07081 = PhysicalKeysRepository.this.new C07081(this.$addressId, continuation);
            c07081.L$0 = obj;
            return c07081;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataPhysicalKey>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataPhysicalKey>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataPhysicalKey>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07081) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PhysicalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$getKeys$1$1", f = "PhysicalKeysRepository.kt", l = {26}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$getKeys$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01961 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataPhysicalKey>>>, Object> {
            final /* synthetic */ int $addressId;
            int label;
            final /* synthetic */ PhysicalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01961(PhysicalKeysRepository physicalKeysRepository, int i, Continuation<? super C01961> continuation) {
                super(1, continuation);
                this.this$0 = physicalKeysRepository;
                this.$addressId = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01961(this.this$0, this.$addressId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataPhysicalKey>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataPhysicalKey>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataPhysicalKey>>> continuation) {
                return ((C01961) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PhysicalKeysApi api = this.this$0.getApi();
                    String strValueOf = String.valueOf(this.$addressId);
                    this.label = 1;
                    obj = api.getKeys(strValueOf, this);
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
                PhysicalKeysRepository physicalKeysRepository = PhysicalKeysRepository.this;
                C01961 c01961 = new C01961(physicalKeysRepository, this.$addressId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = physicalKeysRepository.safeApiCall(c01961, this);
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

    @Override // com.sputnik.domain.repositories.keys.IPhysicalKeysRepository
    public Flow<Resource<List<DomainPhysicalKey>>> getKeys(int addressId) {
        return FlowKt.flow(new PhysicalKeysRepository$getKeys$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07081(addressId, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: PhysicalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$createKey$1", f = "PhysicalKeysRepository.kt", l = {38, 38}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$createKey$1, reason: invalid class name and case insensitive filesystem */
    static final class C07061 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPhysicalKey>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ String $comment;
        final /* synthetic */ String $hex;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07061(int i, String str, String str2, Continuation<? super C07061> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$hex = str;
            this.$comment = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07061 c07061 = PhysicalKeysRepository.this.new C07061(this.$addressId, this.$hex, this.$comment, continuation);
            c07061.L$0 = obj;
            return c07061;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPhysicalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPhysicalKey>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPhysicalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07061) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PhysicalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$createKey$1$1", f = "PhysicalKeysRepository.kt", l = {39}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$createKey$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01941 extends SuspendLambda implements Function1<Continuation<? super Response<DataPhysicalKey>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ String $comment;
            final /* synthetic */ String $hex;
            int label;
            final /* synthetic */ PhysicalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01941(PhysicalKeysRepository physicalKeysRepository, int i, String str, String str2, Continuation<? super C01941> continuation) {
                super(1, continuation);
                this.this$0 = physicalKeysRepository;
                this.$addressId = i;
                this.$hex = str;
                this.$comment = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01941(this.this$0, this.$addressId, this.$hex, this.$comment, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPhysicalKey>> continuation) {
                return ((C01941) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PhysicalKeysApi api = this.this$0.getApi();
                    String strValueOf = String.valueOf(this.$addressId);
                    DataPhysicalKey dataPhysicalKey = new DataPhysicalKey(null, this.$hex, null, this.$comment, null);
                    this.label = 1;
                    obj = api.createKey(strValueOf, dataPhysicalKey, this);
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
                PhysicalKeysRepository physicalKeysRepository = PhysicalKeysRepository.this;
                C01941 c01941 = new C01941(physicalKeysRepository, this.$addressId, this.$hex, this.$comment, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = physicalKeysRepository.safeApiCall(c01941, this);
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

    @Override // com.sputnik.domain.repositories.keys.IPhysicalKeysRepository
    public Flow<Resource<DomainPhysicalKey>> createKey(int addressId, String hex, String comment) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        Intrinsics.checkNotNullParameter(comment, "comment");
        return FlowKt.flow(new PhysicalKeysRepository$createKey$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07061(addressId, hex, comment, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: PhysicalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$blockKey$1", f = "PhysicalKeysRepository.kt", l = {55, 55}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$blockKey$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPhysicalKey>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = PhysicalKeysRepository.this.new AnonymousClass1(this.$uuid, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPhysicalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPhysicalKey>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPhysicalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PhysicalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$blockKey$1$1", f = "PhysicalKeysRepository.kt", l = {56}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$blockKey$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01931 extends SuspendLambda implements Function1<Continuation<? super Response<DataPhysicalKey>>, Object> {
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ PhysicalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01931(PhysicalKeysRepository physicalKeysRepository, String str, Continuation<? super C01931> continuation) {
                super(1, continuation);
                this.this$0 = physicalKeysRepository;
                this.$uuid = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01931(this.this$0, this.$uuid, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPhysicalKey>> continuation) {
                return ((C01931) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PhysicalKeysApi api = this.this$0.getApi();
                    String str = this.$uuid;
                    this.label = 1;
                    obj = api.blockKey(str, this);
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
                PhysicalKeysRepository physicalKeysRepository = PhysicalKeysRepository.this;
                C01931 c01931 = new C01931(physicalKeysRepository, this.$uuid, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = physicalKeysRepository.safeApiCall(c01931, this);
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

    @Override // com.sputnik.domain.repositories.keys.IPhysicalKeysRepository
    public Flow<Resource<DomainPhysicalKey>> blockKey(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new PhysicalKeysRepository$blockKey$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(uuid, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: PhysicalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$unblockKey$1", f = "PhysicalKeysRepository.kt", l = {63, 63}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$unblockKey$1, reason: invalid class name and case insensitive filesystem */
    static final class C07091 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPhysicalKey>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07091(String str, Continuation<? super C07091> continuation) {
            super(2, continuation);
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07091 c07091 = PhysicalKeysRepository.this.new C07091(this.$uuid, continuation);
            c07091.L$0 = obj;
            return c07091;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPhysicalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPhysicalKey>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPhysicalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07091) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PhysicalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$unblockKey$1$1", f = "PhysicalKeysRepository.kt", l = {64}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$unblockKey$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01971 extends SuspendLambda implements Function1<Continuation<? super Response<DataPhysicalKey>>, Object> {
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ PhysicalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01971(PhysicalKeysRepository physicalKeysRepository, String str, Continuation<? super C01971> continuation) {
                super(1, continuation);
                this.this$0 = physicalKeysRepository;
                this.$uuid = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01971(this.this$0, this.$uuid, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPhysicalKey>> continuation) {
                return ((C01971) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PhysicalKeysApi api = this.this$0.getApi();
                    String str = this.$uuid;
                    this.label = 1;
                    obj = api.unblockKey(str, this);
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
                PhysicalKeysRepository physicalKeysRepository = PhysicalKeysRepository.this;
                C01971 c01971 = new C01971(physicalKeysRepository, this.$uuid, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = physicalKeysRepository.safeApiCall(c01971, this);
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

    @Override // com.sputnik.domain.repositories.keys.IPhysicalKeysRepository
    public Flow<Resource<DomainPhysicalKey>> unblockKey(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new PhysicalKeysRepository$unblockKey$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07091(uuid, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: PhysicalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$deleteKey$1", f = "PhysicalKeysRepository.kt", l = {71, 71}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$deleteKey$1, reason: invalid class name and case insensitive filesystem */
    static final class C07071 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07071(String str, Continuation<? super C07071> continuation) {
            super(2, continuation);
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07071 c07071 = PhysicalKeysRepository.this.new C07071(this.$uuid, continuation);
            c07071.L$0 = obj;
            return c07071;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07071) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PhysicalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$deleteKey$1$1", f = "PhysicalKeysRepository.kt", l = {72}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$deleteKey$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01951 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ PhysicalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01951(PhysicalKeysRepository physicalKeysRepository, String str, Continuation<? super C01951> continuation) {
                super(1, continuation);
                this.this$0 = physicalKeysRepository;
                this.$uuid = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01951(this.this$0, this.$uuid, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01951) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PhysicalKeysApi api = this.this$0.getApi();
                    String str = this.$uuid;
                    this.label = 1;
                    obj = api.deleteKey(str, this);
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
                PhysicalKeysRepository physicalKeysRepository = PhysicalKeysRepository.this;
                C01951 c01951 = new C01951(physicalKeysRepository, this.$uuid, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = physicalKeysRepository.safeApiCall(c01951, this);
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

    @Override // com.sputnik.domain.repositories.keys.IPhysicalKeysRepository
    public Flow<Resource<DomainPhysicalKey>> deleteKey(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new PhysicalKeysRepository$deleteKey$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07071(uuid, null)), Dispatchers.getIO()), null, uuid));
    }

    /* compiled from: PhysicalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$updateComment$1", f = "PhysicalKeysRepository.kt", l = {90, 90}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$updateComment$1, reason: invalid class name and case insensitive filesystem */
    static final class C07101 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataPhysicalKey>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $comment;
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07101(String str, String str2, Continuation<? super C07101> continuation) {
            super(2, continuation);
            this.$uuid = str;
            this.$comment = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07101 c07101 = PhysicalKeysRepository.this.new C07101(this.$uuid, this.$comment, continuation);
            c07101.L$0 = obj;
            return c07101;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataPhysicalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataPhysicalKey>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataPhysicalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07101) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PhysicalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.keys.PhysicalKeysRepository$updateComment$1$1", f = "PhysicalKeysRepository.kt", l = {91}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.keys.PhysicalKeysRepository$updateComment$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01981 extends SuspendLambda implements Function1<Continuation<? super Response<DataPhysicalKey>>, Object> {
            final /* synthetic */ String $comment;
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ PhysicalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01981(PhysicalKeysRepository physicalKeysRepository, String str, String str2, Continuation<? super C01981> continuation) {
                super(1, continuation);
                this.this$0 = physicalKeysRepository;
                this.$uuid = str;
                this.$comment = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01981(this.this$0, this.$uuid, this.$comment, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataPhysicalKey>> continuation) {
                return ((C01981) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PhysicalKeysApi api = this.this$0.getApi();
                    String str = this.$uuid;
                    DataPhysicalKey dataPhysicalKey = new DataPhysicalKey(this.$uuid, null, null, this.$comment, null);
                    this.label = 1;
                    obj = api.updateComment(str, dataPhysicalKey, this);
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
                PhysicalKeysRepository physicalKeysRepository = PhysicalKeysRepository.this;
                C01981 c01981 = new C01981(physicalKeysRepository, this.$uuid, this.$comment, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = physicalKeysRepository.safeApiCall(c01981, this);
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

    @Override // com.sputnik.domain.repositories.keys.IPhysicalKeysRepository
    public Flow<Resource<DomainPhysicalKey>> updateComment(String uuid, String comment) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(comment, "comment");
        return FlowKt.flow(new PhysicalKeysRepository$updateComment$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07101(uuid, comment, null)), Dispatchers.getIO()), null, this));
    }
}
