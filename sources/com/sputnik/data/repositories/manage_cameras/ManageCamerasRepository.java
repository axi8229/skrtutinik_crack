package com.sputnik.data.repositories.manage_cameras;

import com.sputnik.data.api.CamerasApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.cameras.DataCameraObject;
import com.sputnik.data.entities.cameras.DataCameraPatchObject;
import com.sputnik.data.entities.cameras.DataCamerasOrder;
import com.sputnik.data.mappers.cameras.DataCameraObjectToDomainCameraObjectMapper;
import com.sputnik.data.mappers.cameras.DataCamerasOrderToDomainCamerasOrderMapper;
import com.sputnik.data.mappers.cameras.DomainCameraObjectToDataCameraObjectMapper;
import com.sputnik.data.mappers.cameras.DomainCamerasOrderToDataCamerasOrderMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.cameras.DomainCameraObject;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository;
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

/* compiled from: ManageCamerasRepository.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002BE\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00170\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00170\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00170\u00162\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0#0\u00170\u0016H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010&R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010'R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010(R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010)R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010*R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010+¨\u0006,"}, d2 = {"Lcom/sputnik/data/repositories/manage_cameras/ManageCamerasRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/manage_cameras/IManageCamerasRepository;", "Lcom/sputnik/data/api/CamerasApi;", "camerasApi", "Lcom/sputnik/data/mappers/cameras/DataCamerasOrderToDomainCamerasOrderMapper;", "dataCamerasOrderToDomainCamerasOrderMapper", "Lcom/sputnik/data/mappers/cameras/DataCameraObjectToDomainCameraObjectMapper;", "dataCameraObjectToDomainCameraObjectMapper", "Lcom/sputnik/data/mappers/cameras/DomainCameraObjectToDataCameraObjectMapper;", "domainCameraObjectToDataCameraObjectMapper", "Lcom/sputnik/data/mappers/cameras/DomainCamerasOrderToDataCamerasOrderMapper;", "domainCamerasOrderToDataCamerasOrderMapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;", "Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "camerasPreferencesMapper", "<init>", "(Lcom/sputnik/data/api/CamerasApi;Lcom/sputnik/data/mappers/cameras/DataCamerasOrderToDomainCamerasOrderMapper;Lcom/sputnik/data/mappers/cameras/DataCameraObjectToDomainCameraObjectMapper;Lcom/sputnik/data/mappers/cameras/DomainCameraObjectToDataCameraObjectMapper;Lcom/sputnik/data/mappers/cameras/DomainCamerasOrderToDataCamerasOrderMapper;Lcom/sputnik/domain/common/NullableInputListMapper;)V", "", "addressId", "camerasOrder", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "setCamerasOrder", "(ILcom/sputnik/domain/entities/cameras/DomainCamerasOrder;)Lkotlinx/coroutines/flow/Flow;", "", "cameraUuid", "Lcom/sputnik/domain/entities/cameras/DomainCameraObject;", "camera", "setCameraParams", "(ILjava/lang/String;Lcom/sputnik/domain/entities/cameras/DomainCameraObject;)Lkotlinx/coroutines/flow/Flow;", "", "clearCamerasPreferences", "(I)Lkotlinx/coroutines/flow/Flow;", "", "getCamerasPreferences", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/data/api/CamerasApi;", "Lcom/sputnik/data/mappers/cameras/DataCamerasOrderToDomainCamerasOrderMapper;", "Lcom/sputnik/data/mappers/cameras/DataCameraObjectToDomainCameraObjectMapper;", "Lcom/sputnik/data/mappers/cameras/DomainCameraObjectToDataCameraObjectMapper;", "Lcom/sputnik/data/mappers/cameras/DomainCamerasOrderToDataCamerasOrderMapper;", "Lcom/sputnik/domain/common/NullableInputListMapper;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ManageCamerasRepository extends BaseApiResponse implements IManageCamerasRepository {
    private final CamerasApi camerasApi;
    private final NullableInputListMapper<DataCamerasOrder, DomainCamerasOrder> camerasPreferencesMapper;
    private final DataCameraObjectToDomainCameraObjectMapper dataCameraObjectToDomainCameraObjectMapper;
    private final DataCamerasOrderToDomainCamerasOrderMapper dataCamerasOrderToDomainCamerasOrderMapper;
    private final DomainCameraObjectToDataCameraObjectMapper domainCameraObjectToDataCameraObjectMapper;
    private final DomainCamerasOrderToDataCamerasOrderMapper domainCamerasOrderToDataCamerasOrderMapper;

    public ManageCamerasRepository(CamerasApi camerasApi, DataCamerasOrderToDomainCamerasOrderMapper dataCamerasOrderToDomainCamerasOrderMapper, DataCameraObjectToDomainCameraObjectMapper dataCameraObjectToDomainCameraObjectMapper, DomainCameraObjectToDataCameraObjectMapper domainCameraObjectToDataCameraObjectMapper, DomainCamerasOrderToDataCamerasOrderMapper domainCamerasOrderToDataCamerasOrderMapper, NullableInputListMapper<DataCamerasOrder, DomainCamerasOrder> camerasPreferencesMapper) {
        Intrinsics.checkNotNullParameter(camerasApi, "camerasApi");
        Intrinsics.checkNotNullParameter(dataCamerasOrderToDomainCamerasOrderMapper, "dataCamerasOrderToDomainCamerasOrderMapper");
        Intrinsics.checkNotNullParameter(dataCameraObjectToDomainCameraObjectMapper, "dataCameraObjectToDomainCameraObjectMapper");
        Intrinsics.checkNotNullParameter(domainCameraObjectToDataCameraObjectMapper, "domainCameraObjectToDataCameraObjectMapper");
        Intrinsics.checkNotNullParameter(domainCamerasOrderToDataCamerasOrderMapper, "domainCamerasOrderToDataCamerasOrderMapper");
        Intrinsics.checkNotNullParameter(camerasPreferencesMapper, "camerasPreferencesMapper");
        this.camerasApi = camerasApi;
        this.dataCamerasOrderToDomainCamerasOrderMapper = dataCamerasOrderToDomainCamerasOrderMapper;
        this.dataCameraObjectToDomainCameraObjectMapper = dataCameraObjectToDomainCameraObjectMapper;
        this.domainCameraObjectToDataCameraObjectMapper = domainCameraObjectToDataCameraObjectMapper;
        this.domainCamerasOrderToDataCamerasOrderMapper = domainCamerasOrderToDataCamerasOrderMapper;
        this.camerasPreferencesMapper = camerasPreferencesMapper;
    }

    /* compiled from: ManageCamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$setCamerasOrder$1", f = "ManageCamerasRepository.kt", l = {43, 43}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$setCamerasOrder$1, reason: invalid class name and case insensitive filesystem */
    static final class C07131 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCamerasOrder>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ DomainCamerasOrder $camerasOrder;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07131(int i, DomainCamerasOrder domainCamerasOrder, Continuation<? super C07131> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$camerasOrder = domainCamerasOrder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07131 c07131 = ManageCamerasRepository.this.new C07131(this.$addressId, this.$camerasOrder, continuation);
            c07131.L$0 = obj;
            return c07131;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCamerasOrder>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCamerasOrder>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCamerasOrder>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07131) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ManageCamerasRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$setCamerasOrder$1$1", f = "ManageCamerasRepository.kt", l = {44}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$setCamerasOrder$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02071 extends SuspendLambda implements Function1<Continuation<? super Response<DataCamerasOrder>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ DomainCamerasOrder $camerasOrder;
            int label;
            final /* synthetic */ ManageCamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02071(ManageCamerasRepository manageCamerasRepository, int i, DomainCamerasOrder domainCamerasOrder, Continuation<? super C02071> continuation) {
                super(1, continuation);
                this.this$0 = manageCamerasRepository;
                this.$addressId = i;
                this.$camerasOrder = domainCamerasOrder;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02071(this.this$0, this.$addressId, this.$camerasOrder, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCamerasOrder>> continuation) {
                return ((C02071) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    DataCamerasOrder map = this.this$0.domainCamerasOrderToDataCamerasOrderMapper.map(this.$camerasOrder);
                    this.label = 1;
                    obj = camerasApi.setCamerasOrder(strValueOf, map, this);
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
                ManageCamerasRepository manageCamerasRepository = ManageCamerasRepository.this;
                C02071 c02071 = new C02071(manageCamerasRepository, this.$addressId, this.$camerasOrder, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = manageCamerasRepository.safeApiCall(c02071, this);
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

    @Override // com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository
    public Flow<Resource<DomainCamerasOrder>> setCamerasOrder(int addressId, DomainCamerasOrder camerasOrder) {
        Intrinsics.checkNotNullParameter(camerasOrder, "camerasOrder");
        return FlowKt.flow(new ManageCamerasRepository$setCamerasOrder$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07131(addressId, camerasOrder, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ManageCamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/cameras/DataCameraObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$setCameraParams$1", f = "ManageCamerasRepository.kt", l = {62, 62}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$setCameraParams$1, reason: invalid class name and case insensitive filesystem */
    static final class C07121 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCameraObject>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ DomainCameraObject $camera;
        final /* synthetic */ String $cameraUuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07121(int i, String str, DomainCameraObject domainCameraObject, Continuation<? super C07121> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$cameraUuid = str;
            this.$camera = domainCameraObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07121 c07121 = ManageCamerasRepository.this.new C07121(this.$addressId, this.$cameraUuid, this.$camera, continuation);
            c07121.L$0 = obj;
            return c07121;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCameraObject>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCameraObject>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCameraObject>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07121) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ManageCamerasRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/cameras/DataCameraObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$setCameraParams$1$1", f = "ManageCamerasRepository.kt", l = {63}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$setCameraParams$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02061 extends SuspendLambda implements Function1<Continuation<? super Response<DataCameraObject>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ DomainCameraObject $camera;
            final /* synthetic */ String $cameraUuid;
            int label;
            final /* synthetic */ ManageCamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02061(ManageCamerasRepository manageCamerasRepository, int i, String str, DomainCameraObject domainCameraObject, Continuation<? super C02061> continuation) {
                super(1, continuation);
                this.this$0 = manageCamerasRepository;
                this.$addressId = i;
                this.$cameraUuid = str;
                this.$camera = domainCameraObject;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02061(this.this$0, this.$addressId, this.$cameraUuid, this.$camera, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCameraObject>> continuation) {
                return ((C02061) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    String str = this.$cameraUuid;
                    DataCameraPatchObject map = this.this$0.domainCameraObjectToDataCameraObjectMapper.map(this.$camera);
                    this.label = 1;
                    obj = camerasApi.setCameraParams(strValueOf, str, map, this);
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
                ManageCamerasRepository manageCamerasRepository = ManageCamerasRepository.this;
                C02061 c02061 = new C02061(manageCamerasRepository, this.$addressId, this.$cameraUuid, this.$camera, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = manageCamerasRepository.safeApiCall(c02061, this);
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

    @Override // com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository
    public Flow<Resource<DomainCameraObject>> setCameraParams(int addressId, String cameraUuid, DomainCameraObject camera) {
        Intrinsics.checkNotNullParameter(cameraUuid, "cameraUuid");
        Intrinsics.checkNotNullParameter(camera, "camera");
        return FlowKt.flow(new ManageCamerasRepository$setCameraParams$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07121(addressId, cameraUuid, camera, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ManageCamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$clearCamerasPreferences$1", f = "ManageCamerasRepository.kt", l = {76, 76}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$clearCamerasPreferences$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$addressId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ManageCamerasRepository.this.new AnonymousClass1(this.$addressId, continuation);
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

        /* compiled from: ManageCamerasRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$clearCamerasPreferences$1$1", f = "ManageCamerasRepository.kt", l = {77}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$clearCamerasPreferences$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02041 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ int $addressId;
            int label;
            final /* synthetic */ ManageCamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02041(ManageCamerasRepository manageCamerasRepository, int i, Continuation<? super C02041> continuation) {
                super(1, continuation);
                this.this$0 = manageCamerasRepository;
                this.$addressId = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02041(this.this$0, this.$addressId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02041) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    this.label = 1;
                    obj = camerasApi.clearCamerasPreferences(strValueOf, this);
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
                ManageCamerasRepository manageCamerasRepository = ManageCamerasRepository.this;
                C02041 c02041 = new C02041(manageCamerasRepository, this.$addressId, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = manageCamerasRepository.safeApiCall(c02041, this);
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

    @Override // com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository
    public Flow<Resource<Unit>> clearCamerasPreferences(int addressId) {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(addressId, null)), Dispatchers.getIO());
    }

    /* compiled from: ManageCamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$getCamerasPreferences$1", f = "ManageCamerasRepository.kt", l = {84, 84}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$getCamerasPreferences$1, reason: invalid class name and case insensitive filesystem */
    static final class C07111 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataCamerasOrder>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07111(Continuation<? super C07111> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07111 c07111 = ManageCamerasRepository.this.new C07111(continuation);
            c07111.L$0 = obj;
            return c07111;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataCamerasOrder>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataCamerasOrder>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataCamerasOrder>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07111) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ManageCamerasRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$getCamerasPreferences$1$1", f = "ManageCamerasRepository.kt", l = {84}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.manage_cameras.ManageCamerasRepository$getCamerasPreferences$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02051 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataCamerasOrder>>>, Object> {
            int label;
            final /* synthetic */ ManageCamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02051(ManageCamerasRepository manageCamerasRepository, Continuation<? super C02051> continuation) {
                super(1, continuation);
                this.this$0 = manageCamerasRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02051(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataCamerasOrder>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataCamerasOrder>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataCamerasOrder>>> continuation) {
                return ((C02051) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    this.label = 1;
                    obj = camerasApi.getCamerasPreferences(this);
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
                ManageCamerasRepository manageCamerasRepository = ManageCamerasRepository.this;
                C02051 c02051 = new C02051(manageCamerasRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = manageCamerasRepository.safeApiCall(c02051, this);
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

    @Override // com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository
    public Flow<Resource<List<DomainCamerasOrder>>> getCamerasPreferences() {
        return FlowKt.flow(new ManageCamerasRepository$getCamerasPreferences$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07111(null)), Dispatchers.getIO()), null, this));
    }
}
