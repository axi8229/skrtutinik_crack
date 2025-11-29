package com.sputnik.data.repositories.family;

import com.sputnik.data.api.FamilyApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.family.DataFamily;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.family.DomainFamily;
import com.sputnik.domain.repositories.family.IFamilyRepository;
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

/* compiled from: FamilyRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\"\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/sputnik/data/repositories/family/FamilyRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/family/IFamilyRepository;", "familyApi", "Lcom/sputnik/data/api/FamilyApi;", "listMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/family/DataFamily;", "Lcom/sputnik/domain/entities/family/DomainFamily;", "(Lcom/sputnik/data/api/FamilyApi;Lcom/sputnik/domain/common/ListMapper;)V", "deleteFromFamily", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "addressId", "", "id", "getFamily", "", "makeAdmin", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FamilyRepository extends BaseApiResponse implements IFamilyRepository {
    private final FamilyApi familyApi;
    private final ListMapper<DataFamily, DomainFamily> listMapper;

    public FamilyRepository(FamilyApi familyApi, ListMapper<DataFamily, DomainFamily> listMapper) {
        Intrinsics.checkNotNullParameter(familyApi, "familyApi");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        this.familyApi = familyApi;
        this.listMapper = listMapper;
    }

    /* compiled from: FamilyRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/family/DataFamily;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.family.FamilyRepository$getFamily$1", f = "FamilyRepository.kt", l = {23, 23}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.family.FamilyRepository$getFamily$1, reason: invalid class name and case insensitive filesystem */
    static final class C06961 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataFamily>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06961(int i, Continuation<? super C06961> continuation) {
            super(2, continuation);
            this.$addressId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06961 c06961 = FamilyRepository.this.new C06961(this.$addressId, continuation);
            c06961.L$0 = obj;
            return c06961;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataFamily>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataFamily>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataFamily>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06961) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: FamilyRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/family/DataFamily;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.family.FamilyRepository$getFamily$1$1", f = "FamilyRepository.kt", l = {23}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.family.FamilyRepository$getFamily$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01591 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataFamily>>>, Object> {
            final /* synthetic */ int $addressId;
            int label;
            final /* synthetic */ FamilyRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01591(FamilyRepository familyRepository, int i, Continuation<? super C01591> continuation) {
                super(1, continuation);
                this.this$0 = familyRepository;
                this.$addressId = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01591(this.this$0, this.$addressId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataFamily>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataFamily>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataFamily>>> continuation) {
                return ((C01591) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FamilyApi familyApi = this.this$0.familyApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    this.label = 1;
                    obj = familyApi.getFamily(strValueOf, this);
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
                FamilyRepository familyRepository = FamilyRepository.this;
                C01591 c01591 = new C01591(familyRepository, this.$addressId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = familyRepository.safeApiCall(c01591, this);
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

    @Override // com.sputnik.domain.repositories.family.IFamilyRepository
    public Flow<Resource<List<DomainFamily>>> getFamily(int addressId) {
        return FlowKt.flow(new FamilyRepository$getFamily$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06961(addressId, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: FamilyRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.family.FamilyRepository$deleteFromFamily$1", f = "FamilyRepository.kt", l = {31, 31}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.family.FamilyRepository$deleteFromFamily$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ int $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$id = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = FamilyRepository.this.new AnonymousClass1(this.$addressId, this.$id, continuation);
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

        /* compiled from: FamilyRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.family.FamilyRepository$deleteFromFamily$1$1", f = "FamilyRepository.kt", l = {31}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.family.FamilyRepository$deleteFromFamily$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01581 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ int $id;
            int label;
            final /* synthetic */ FamilyRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01581(FamilyRepository familyRepository, int i, int i2, Continuation<? super C01581> continuation) {
                super(1, continuation);
                this.this$0 = familyRepository;
                this.$addressId = i;
                this.$id = i2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01581(this.this$0, this.$addressId, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01581) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FamilyApi familyApi = this.this$0.familyApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    int i2 = this.$id;
                    this.label = 1;
                    obj = familyApi.deleteFromFamily(strValueOf, i2, this);
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
                FamilyRepository familyRepository = FamilyRepository.this;
                C01581 c01581 = new C01581(familyRepository, this.$addressId, this.$id, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = familyRepository.safeApiCall(c01581, this);
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

    @Override // com.sputnik.domain.repositories.family.IFamilyRepository
    public Flow<Resource<Unit>> deleteFromFamily(int addressId, int id) {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(addressId, id, null)), Dispatchers.getIO());
    }

    /* compiled from: FamilyRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.family.FamilyRepository$makeAdmin$1", f = "FamilyRepository.kt", l = {37, 37}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.family.FamilyRepository$makeAdmin$1, reason: invalid class name and case insensitive filesystem */
    static final class C06971 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ int $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06971(int i, int i2, Continuation<? super C06971> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$id = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06971 c06971 = FamilyRepository.this.new C06971(this.$addressId, this.$id, continuation);
            c06971.L$0 = obj;
            return c06971;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06971) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: FamilyRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.family.FamilyRepository$makeAdmin$1$1", f = "FamilyRepository.kt", l = {37}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.family.FamilyRepository$makeAdmin$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01601 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ int $id;
            int label;
            final /* synthetic */ FamilyRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01601(FamilyRepository familyRepository, int i, int i2, Continuation<? super C01601> continuation) {
                super(1, continuation);
                this.this$0 = familyRepository;
                this.$addressId = i;
                this.$id = i2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01601(this.this$0, this.$addressId, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01601) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FamilyApi familyApi = this.this$0.familyApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    int i2 = this.$id;
                    this.label = 1;
                    obj = familyApi.makeAdmin(strValueOf, i2, this);
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
                FamilyRepository familyRepository = FamilyRepository.this;
                C01601 c01601 = new C01601(familyRepository, this.$addressId, this.$id, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = familyRepository.safeApiCall(c01601, this);
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

    @Override // com.sputnik.domain.repositories.family.IFamilyRepository
    public Flow<Resource<Unit>> makeAdmin(int addressId, int id) {
        return FlowKt.flowOn(FlowKt.flow(new C06971(addressId, id, null)), Dispatchers.getIO());
    }
}
