package com.sputnik.data.repositories.address;

import com.sputnik.data.api.AddressApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.address.DataCustomAddress;
import com.sputnik.data.mappers.address.DataCustomAddressToDomainCustomAddressMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import com.sputnik.domain.repositories.address.IAddressRepository;
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

/* compiled from: AddressRepository.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JK\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r2\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/sputnik/data/repositories/address/AddressRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/address/IAddressRepository;", "Lcom/sputnik/data/api/AddressApi;", "addressApi", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/address/DataCustomAddress;", "Lcom/sputnik/domain/entities/address/DomainCustomAddress;", "listMapper", "Lcom/sputnik/data/mappers/address/DataCustomAddressToDomainCustomAddressMapper;", "mapper", "<init>", "(Lcom/sputnik/data/api/AddressApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/mappers/address/DataCustomAddressToDomainCustomAddressMapper;)V", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "getCustomAddress", "()Lkotlinx/coroutines/flow/Flow;", "", "city", "street", "house", "flat", "setCustomAddress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "uuid", "updateCustomAddress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/data/api/AddressApi;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/address/DataCustomAddressToDomainCustomAddressMapper;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AddressRepository extends BaseApiResponse implements IAddressRepository {
    private final AddressApi addressApi;
    private final ListMapper<DataCustomAddress, DomainCustomAddress> listMapper;
    private final DataCustomAddressToDomainCustomAddressMapper mapper;

    public AddressRepository(AddressApi addressApi, ListMapper<DataCustomAddress, DomainCustomAddress> listMapper, DataCustomAddressToDomainCustomAddressMapper mapper) {
        Intrinsics.checkNotNullParameter(addressApi, "addressApi");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.addressApi = addressApi;
        this.listMapper = listMapper;
        this.mapper = mapper;
    }

    /* compiled from: AddressRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/address/DataCustomAddress;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.address.AddressRepository$getCustomAddress$1", f = "AddressRepository.kt", l = {26, 26}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.address.AddressRepository$getCustomAddress$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataCustomAddress>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = AddressRepository.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataCustomAddress>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataCustomAddress>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataCustomAddress>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AddressRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/address/DataCustomAddress;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.address.AddressRepository$getCustomAddress$1$1", f = "AddressRepository.kt", l = {27}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.address.AddressRepository$getCustomAddress$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01181 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataCustomAddress>>>, Object> {
            int label;
            final /* synthetic */ AddressRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01181(AddressRepository addressRepository, Continuation<? super C01181> continuation) {
                super(1, continuation);
                this.this$0 = addressRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01181(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataCustomAddress>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataCustomAddress>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataCustomAddress>>> continuation) {
                return ((C01181) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AddressApi addressApi = this.this$0.addressApi;
                    this.label = 1;
                    obj = addressApi.getCustomAddresses(this);
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
                AddressRepository addressRepository = AddressRepository.this;
                C01181 c01181 = new C01181(addressRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = addressRepository.safeApiCall(c01181, this);
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

    @Override // com.sputnik.domain.repositories.address.IAddressRepository
    public Flow<Resource<List<DomainCustomAddress>>> getCustomAddress() {
        return FlowKt.flow(new AddressRepository$getCustomAddress$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: AddressRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/address/DataCustomAddress;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.address.AddressRepository$setCustomAddress$1", f = "AddressRepository.kt", l = {41, 41}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.address.AddressRepository$setCustomAddress$1, reason: invalid class name and case insensitive filesystem */
    static final class C06801 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCustomAddress>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $city;
        final /* synthetic */ String $flat;
        final /* synthetic */ String $house;
        final /* synthetic */ String $street;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06801(String str, String str2, String str3, String str4, Continuation<? super C06801> continuation) {
            super(2, continuation);
            this.$city = str;
            this.$street = str2;
            this.$house = str3;
            this.$flat = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06801 c06801 = AddressRepository.this.new C06801(this.$city, this.$street, this.$house, this.$flat, continuation);
            c06801.L$0 = obj;
            return c06801;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCustomAddress>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCustomAddress>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCustomAddress>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06801) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AddressRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/address/DataCustomAddress;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.address.AddressRepository$setCustomAddress$1$1", f = "AddressRepository.kt", l = {42}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.address.AddressRepository$setCustomAddress$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01191 extends SuspendLambda implements Function1<Continuation<? super Response<DataCustomAddress>>, Object> {
            final /* synthetic */ String $city;
            final /* synthetic */ String $flat;
            final /* synthetic */ String $house;
            final /* synthetic */ String $street;
            int label;
            final /* synthetic */ AddressRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01191(AddressRepository addressRepository, String str, String str2, String str3, String str4, Continuation<? super C01191> continuation) {
                super(1, continuation);
                this.this$0 = addressRepository;
                this.$city = str;
                this.$street = str2;
                this.$house = str3;
                this.$flat = str4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01191(this.this$0, this.$city, this.$street, this.$house, this.$flat, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCustomAddress>> continuation) {
                return ((C01191) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AddressApi addressApi = this.this$0.addressApi;
                    String str = this.$city;
                    String str2 = this.$street;
                    String str3 = this.$house;
                    String str4 = this.$flat;
                    this.label = 1;
                    obj = addressApi.setCustomAddress(str, str2, str3, str4, this);
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
                AddressRepository addressRepository = AddressRepository.this;
                C01191 c01191 = new C01191(addressRepository, this.$city, this.$street, this.$house, this.$flat, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = addressRepository.safeApiCall(c01191, this);
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

    @Override // com.sputnik.domain.repositories.address.IAddressRepository
    public Flow<Resource<DomainCustomAddress>> setCustomAddress(String city, String street, String house, String flat) {
        return FlowKt.flow(new AddressRepository$setCustomAddress$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06801(city, street, house, flat, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: AddressRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/address/DataCustomAddress;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.address.AddressRepository$updateCustomAddress$1", f = "AddressRepository.kt", l = {57, 57}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.address.AddressRepository$updateCustomAddress$1, reason: invalid class name and case insensitive filesystem */
    static final class C06811 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCustomAddress>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $city;
        final /* synthetic */ String $flat;
        final /* synthetic */ String $house;
        final /* synthetic */ String $street;
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06811(String str, String str2, String str3, String str4, String str5, Continuation<? super C06811> continuation) {
            super(2, continuation);
            this.$uuid = str;
            this.$city = str2;
            this.$street = str3;
            this.$house = str4;
            this.$flat = str5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06811 c06811 = AddressRepository.this.new C06811(this.$uuid, this.$city, this.$street, this.$house, this.$flat, continuation);
            c06811.L$0 = obj;
            return c06811;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCustomAddress>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCustomAddress>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCustomAddress>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06811) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AddressRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/address/DataCustomAddress;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.address.AddressRepository$updateCustomAddress$1$1", f = "AddressRepository.kt", l = {58}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.address.AddressRepository$updateCustomAddress$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01201 extends SuspendLambda implements Function1<Continuation<? super Response<DataCustomAddress>>, Object> {
            final /* synthetic */ String $city;
            final /* synthetic */ String $flat;
            final /* synthetic */ String $house;
            final /* synthetic */ String $street;
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ AddressRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01201(AddressRepository addressRepository, String str, String str2, String str3, String str4, String str5, Continuation<? super C01201> continuation) {
                super(1, continuation);
                this.this$0 = addressRepository;
                this.$uuid = str;
                this.$city = str2;
                this.$street = str3;
                this.$house = str4;
                this.$flat = str5;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01201(this.this$0, this.$uuid, this.$city, this.$street, this.$house, this.$flat, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCustomAddress>> continuation) {
                return ((C01201) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AddressApi addressApi = this.this$0.addressApi;
                    String str = this.$uuid;
                    String str2 = this.$city;
                    String str3 = this.$street;
                    String str4 = this.$house;
                    String str5 = this.$flat;
                    this.label = 1;
                    obj = addressApi.updateCustomAddress(str, str2, str3, str4, str5, this);
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
                AddressRepository addressRepository = AddressRepository.this;
                C01201 c01201 = new C01201(addressRepository, this.$uuid, this.$city, this.$street, this.$house, this.$flat, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = addressRepository.safeApiCall(c01201, this);
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

    @Override // com.sputnik.domain.repositories.address.IAddressRepository
    public Flow<Resource<DomainCustomAddress>> updateCustomAddress(String uuid, String city, String street, String house, String flat) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flow(new AddressRepository$updateCustomAddress$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06811(uuid, city, street, house, flat, null)), Dispatchers.getIO()), null, this));
    }
}
