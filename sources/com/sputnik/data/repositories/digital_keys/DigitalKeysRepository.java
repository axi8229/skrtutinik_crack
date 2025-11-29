package com.sputnik.data.repositories.digital_keys;

import com.sputnik.data.api.DigitalKeysApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.digital_keys.DataDigitalKey;
import com.sputnik.data.mappers.digital_keys.DataDigitalKeyToDomainDigitalKeyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.digital_keys.DomainDigitalKey;
import com.sputnik.domain.entities.digital_keys.TypeDigitalKey;
import com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository;
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

/* compiled from: DigitalKeysRepository.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/sputnik/data/repositories/digital_keys/DigitalKeysRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/digital_keys/IDigitalKeysRepository;", "Lcom/sputnik/data/api/DigitalKeysApi;", "digitalKeysApi", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;", "Lcom/sputnik/domain/entities/digital_keys/DomainDigitalKey;", "listMapper", "Lcom/sputnik/data/mappers/digital_keys/DataDigitalKeyToDomainDigitalKeyMapper;", "dataDigitalKeyToDomainDigitalKeyMapper", "<init>", "(Lcom/sputnik/data/api/DigitalKeysApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/mappers/digital_keys/DataDigitalKeyToDomainDigitalKeyMapper;)V", "", "addressId", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "getDigitalKeys", "(I)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "type", "setDigitalKey", "(ILcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;)Lkotlinx/coroutines/flow/Flow;", "", "uuid", "deleteDigitalKey", "(ILjava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/data/api/DigitalKeysApi;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/digital_keys/DataDigitalKeyToDomainDigitalKeyMapper;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DigitalKeysRepository extends BaseApiResponse implements IDigitalKeysRepository {
    private final DataDigitalKeyToDomainDigitalKeyMapper dataDigitalKeyToDomainDigitalKeyMapper;
    private final DigitalKeysApi digitalKeysApi;
    private final ListMapper<DataDigitalKey, DomainDigitalKey> listMapper;

    public DigitalKeysRepository(DigitalKeysApi digitalKeysApi, ListMapper<DataDigitalKey, DomainDigitalKey> listMapper, DataDigitalKeyToDomainDigitalKeyMapper dataDigitalKeyToDomainDigitalKeyMapper) {
        Intrinsics.checkNotNullParameter(digitalKeysApi, "digitalKeysApi");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        Intrinsics.checkNotNullParameter(dataDigitalKeyToDomainDigitalKeyMapper, "dataDigitalKeyToDomainDigitalKeyMapper");
        this.digitalKeysApi = digitalKeysApi;
        this.listMapper = listMapper;
        this.dataDigitalKeyToDomainDigitalKeyMapper = dataDigitalKeyToDomainDigitalKeyMapper;
    }

    /* compiled from: DigitalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$getDigitalKeys$3", f = "DigitalKeysRepository.kt", l = {34, 34}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$getDigitalKeys$3, reason: invalid class name and case insensitive filesystem */
    static final class C06933 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataDigitalKey>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06933(int i, Continuation<? super C06933> continuation) {
            super(2, continuation);
            this.$addressId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06933 c06933 = DigitalKeysRepository.this.new C06933(this.$addressId, continuation);
            c06933.L$0 = obj;
            return c06933;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataDigitalKey>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataDigitalKey>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataDigitalKey>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06933) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: DigitalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$getDigitalKeys$3$1", f = "DigitalKeysRepository.kt", l = {34}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$getDigitalKeys$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataDigitalKey>>>, Object> {
            final /* synthetic */ int $addressId;
            int label;
            final /* synthetic */ DigitalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DigitalKeysRepository digitalKeysRepository, int i, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = digitalKeysRepository;
                this.$addressId = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$addressId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataDigitalKey>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataDigitalKey>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataDigitalKey>>> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DigitalKeysApi digitalKeysApi = this.this$0.digitalKeysApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    this.label = 1;
                    obj = digitalKeysApi.getDigitalKeysForAddress(strValueOf, this);
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
                DigitalKeysRepository digitalKeysRepository = DigitalKeysRepository.this;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(digitalKeysRepository, this.$addressId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = digitalKeysRepository.safeApiCall(anonymousClass1, this);
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

    @Override // com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository
    public Flow<Resource<List<DomainDigitalKey>>> getDigitalKeys(int addressId) {
        return FlowKt.flow(new DigitalKeysRepository$getDigitalKeys$$inlined$transform$2(FlowKt.flowOn(FlowKt.flow(new C06933(addressId, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: DigitalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$setDigitalKey$3", f = "DigitalKeysRepository.kt", l = {54, 55, 55}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$setDigitalKey$3, reason: invalid class name and case insensitive filesystem */
    static final class C06943 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataDigitalKey>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ TypeDigitalKey $type;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06943(int i, TypeDigitalKey typeDigitalKey, Continuation<? super C06943> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$type = typeDigitalKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06943 c06943 = DigitalKeysRepository.this.new C06943(this.$addressId, this.$type, continuation);
            c06943.L$0 = obj;
            return c06943;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataDigitalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataDigitalKey>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataDigitalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06943) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r9)
                goto L68
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1e:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L5d
            L26:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r8.L$0 = r9
                r8.label = r5
                java.lang.Object r1 = r9.emit(r1, r8)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r9
            L47:
                com.sputnik.data.repositories.digital_keys.DigitalKeysRepository r9 = com.sputnik.data.repositories.digital_keys.DigitalKeysRepository.this
                com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$setDigitalKey$3$1 r5 = new com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$setDigitalKey$3$1
                int r6 = r8.$addressId
                com.sputnik.domain.entities.digital_keys.TypeDigitalKey r7 = r8.$type
                r5.<init>(r9, r6, r7, r2)
                r8.L$0 = r1
                r8.label = r4
                java.lang.Object r9 = r9.safeApiCall(r5, r8)
                if (r9 != r0) goto L5d
                return r0
            L5d:
                r8.L$0 = r2
                r8.label = r3
                java.lang.Object r9 = r1.emit(r9, r8)
                if (r9 != r0) goto L68
                return r0
            L68:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.digital_keys.DigitalKeysRepository.C06943.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: DigitalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$setDigitalKey$3$1", f = "DigitalKeysRepository.kt", l = {55}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$setDigitalKey$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Response<DataDigitalKey>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ TypeDigitalKey $type;
            int label;
            final /* synthetic */ DigitalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DigitalKeysRepository digitalKeysRepository, int i, TypeDigitalKey typeDigitalKey, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = digitalKeysRepository;
                this.$addressId = i;
                this.$type = typeDigitalKey;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$addressId, this.$type, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataDigitalKey>> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DigitalKeysApi digitalKeysApi = this.this$0.digitalKeysApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    TypeDigitalKey typeDigitalKey = this.$type;
                    this.label = 1;
                    obj = digitalKeysApi.setDigitalKeyForAddress(strValueOf, typeDigitalKey, this);
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
    }

    @Override // com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository
    public Flow<Resource<DomainDigitalKey>> setDigitalKey(int addressId, TypeDigitalKey type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return FlowKt.flow(new DigitalKeysRepository$setDigitalKey$$inlined$transform$2(FlowKt.flowOn(FlowKt.flow(new C06943(addressId, type, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: DigitalKeysRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$deleteDigitalKey$3", f = "DigitalKeysRepository.kt", l = {74, 74}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$deleteDigitalKey$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataDigitalKey>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(int i, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = DigitalKeysRepository.this.new AnonymousClass3(this.$addressId, this.$uuid, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataDigitalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataDigitalKey>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataDigitalKey>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: DigitalKeysRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$deleteDigitalKey$3$1", f = "DigitalKeysRepository.kt", l = {74}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.digital_keys.DigitalKeysRepository$deleteDigitalKey$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Response<DataDigitalKey>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ DigitalKeysRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DigitalKeysRepository digitalKeysRepository, int i, String str, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = digitalKeysRepository;
                this.$addressId = i;
                this.$uuid = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$addressId, this.$uuid, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataDigitalKey>> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DigitalKeysApi digitalKeysApi = this.this$0.digitalKeysApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    String str = this.$uuid;
                    this.label = 1;
                    obj = digitalKeysApi.deleteDigitalKey(strValueOf, str, this);
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
                DigitalKeysRepository digitalKeysRepository = DigitalKeysRepository.this;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(digitalKeysRepository, this.$addressId, this.$uuid, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = digitalKeysRepository.safeApiCall(anonymousClass1, this);
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

    @Override // com.sputnik.domain.repositories.digital_keys.IDigitalKeysRepository
    public Flow<Resource<DomainDigitalKey>> deleteDigitalKey(int addressId, String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new DigitalKeysRepository$deleteDigitalKey$$inlined$transform$2(FlowKt.flowOn(FlowKt.flow(new AnonymousClass3(addressId, uuid, null)), Dispatchers.getIO()), null, this));
    }
}
