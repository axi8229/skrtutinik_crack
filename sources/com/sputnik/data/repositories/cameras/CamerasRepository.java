package com.sputnik.data.repositories.cameras;

import com.sputnik.data.api.CamerasApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.data.local.PrefManager;
import com.sputnik.data.mappers.cameras.DataCameraToDomainCameraMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.entities.door.OpenDoorProducers;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.repositories.cameras.ICamerasRepository;
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

/* compiled from: CamerasRepository.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J6\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00100\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00100\u000fH\u0016J6\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00100\u000f2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00100\u000f2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/sputnik/data/repositories/cameras/CamerasRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;", "camerasApi", "Lcom/sputnik/data/api/CamerasApi;", "mapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/entities/cameras/DataCamera;", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "cameraMapper", "Lcom/sputnik/data/mappers/cameras/DataCameraToDomainCameraMapper;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "(Lcom/sputnik/data/api/CamerasApi;Lcom/sputnik/domain/common/NullableInputListMapper;Lcom/sputnik/data/mappers/cameras/DataCameraToDomainCameraMapper;Lcom/sputnik/data/local/PrefManager;)V", "getCameraByIntercomUUID", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "intercomUUID", "", "flatUUID", "getCameras", "", "addressId", "", "list", "order", "getCamerasDemo", "openDoor", "", "uuid", "isWidget", "", "producer", "Lcom/sputnik/domain/entities/door/OpenDoorProducers;", "openSecondDoor", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CamerasRepository extends BaseApiResponse implements ICamerasRepository {
    private final DataCameraToDomainCameraMapper cameraMapper;
    private final CamerasApi camerasApi;
    private final NullableInputListMapper<DataCamera, DomainCamera> mapper;
    private final PrefManager prefManager;

    public CamerasRepository(CamerasApi camerasApi, NullableInputListMapper<DataCamera, DomainCamera> mapper, DataCameraToDomainCameraMapper cameraMapper, PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(camerasApi, "camerasApi");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(cameraMapper, "cameraMapper");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.camerasApi = camerasApi;
        this.mapper = mapper;
        this.cameraMapper = cameraMapper;
        this.prefManager = prefManager;
    }

    /* compiled from: CamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/cameras/DataCamera;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$getCameras$1", f = "CamerasRepository.kt", l = {32, 33, 33}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$getCameras$1, reason: invalid class name and case insensitive filesystem */
    static final class C06871 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataCamera>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ String $list;
        final /* synthetic */ String $order;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06871(int i, String str, String str2, Continuation<? super C06871> continuation) {
            super(2, continuation);
            this.$addressId = i;
            this.$list = str;
            this.$order = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06871 c06871 = CamerasRepository.this.new C06871(this.$addressId, this.$list, this.$order, continuation);
            c06871.L$0 = obj;
            return c06871;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataCamera>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataCamera>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataCamera>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06871) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x006c A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2d
                if (r1 == r4) goto L25
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r12)
                goto L6d
            L15:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1d:
                java.lang.Object r1 = r11.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r12)
                goto L61
            L25:
                java.lang.Object r1 = r11.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r12)
                goto L46
            L2d:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                kotlinx.coroutines.flow.FlowCollector r12 = (kotlinx.coroutines.flow.FlowCollector) r12
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r11.L$0 = r12
                r11.label = r4
                java.lang.Object r1 = r12.emit(r1, r11)
                if (r1 != r0) goto L45
                return r0
            L45:
                r1 = r12
            L46:
                com.sputnik.data.repositories.cameras.CamerasRepository r12 = com.sputnik.data.repositories.cameras.CamerasRepository.this
                com.sputnik.data.repositories.cameras.CamerasRepository$getCameras$1$1 r10 = new com.sputnik.data.repositories.cameras.CamerasRepository$getCameras$1$1
                int r6 = r11.$addressId
                java.lang.String r7 = r11.$list
                java.lang.String r8 = r11.$order
                r9 = 0
                r4 = r10
                r5 = r12
                r4.<init>(r5, r6, r7, r8, r9)
                r11.L$0 = r1
                r11.label = r3
                java.lang.Object r12 = r12.safeApiCall(r10, r11)
                if (r12 != r0) goto L61
                return r0
            L61:
                r3 = 0
                r11.L$0 = r3
                r11.label = r2
                java.lang.Object r12 = r1.emit(r12, r11)
                if (r12 != r0) goto L6d
                return r0
            L6d:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.cameras.CamerasRepository.C06871.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: CamerasRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/cameras/DataCamera;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$getCameras$1$1", f = "CamerasRepository.kt", l = {34}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$getCameras$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01431 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataCamera>>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ String $list;
            final /* synthetic */ String $order;
            int label;
            final /* synthetic */ CamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01431(CamerasRepository camerasRepository, int i, String str, String str2, Continuation<? super C01431> continuation) {
                super(1, continuation);
                this.this$0 = camerasRepository;
                this.$addressId = i;
                this.$list = str;
                this.$order = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01431(this.this$0, this.$addressId, this.$list, this.$order, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataCamera>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataCamera>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataCamera>>> continuation) {
                return ((C01431) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    String strValueOf = String.valueOf(this.$addressId);
                    String str = this.$list;
                    String str2 = this.$order;
                    this.label = 1;
                    obj = camerasApi.getCameras(strValueOf, str, str2, this);
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

    @Override // com.sputnik.domain.repositories.cameras.ICamerasRepository
    public Flow<Resource<List<DomainCamera>>> getCameras(int addressId, String list, String order) {
        return FlowKt.flow(new CamerasRepository$getCameras$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06871(addressId, list, order, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: CamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/cameras/DataCamera;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$getCameraByIntercomUUID$1", f = "CamerasRepository.kt", l = {49, 50, 50}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$getCameraByIntercomUUID$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataCamera>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $flatUUID;
        final /* synthetic */ String $intercomUUID;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$intercomUUID = str;
            this.$flatUUID = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = CamerasRepository.this.new AnonymousClass1(this.$intercomUUID, this.$flatUUID, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataCamera>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataCamera>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataCamera>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                com.sputnik.data.repositories.cameras.CamerasRepository r9 = com.sputnik.data.repositories.cameras.CamerasRepository.this
                com.sputnik.data.repositories.cameras.CamerasRepository$getCameraByIntercomUUID$1$1 r5 = new com.sputnik.data.repositories.cameras.CamerasRepository$getCameraByIntercomUUID$1$1
                java.lang.String r6 = r8.$intercomUUID
                java.lang.String r7 = r8.$flatUUID
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
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.cameras.CamerasRepository.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: CamerasRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/cameras/DataCamera;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$getCameraByIntercomUUID$1$1", f = "CamerasRepository.kt", l = {51}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$getCameraByIntercomUUID$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01421 extends SuspendLambda implements Function1<Continuation<? super Response<DataCamera>>, Object> {
            final /* synthetic */ String $flatUUID;
            final /* synthetic */ String $intercomUUID;
            int label;
            final /* synthetic */ CamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01421(CamerasRepository camerasRepository, String str, String str2, Continuation<? super C01421> continuation) {
                super(1, continuation);
                this.this$0 = camerasRepository;
                this.$intercomUUID = str;
                this.$flatUUID = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01421(this.this$0, this.$intercomUUID, this.$flatUUID, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataCamera>> continuation) {
                return ((C01421) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    String str = this.$intercomUUID;
                    String str2 = this.$flatUUID;
                    this.label = 1;
                    obj = camerasApi.getCameraByIntercomUUID(str, str2, this);
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

    @Override // com.sputnik.domain.repositories.cameras.ICamerasRepository
    public Flow<Resource<DomainCamera>> getCameraByIntercomUUID(String intercomUUID, String flatUUID) {
        Intrinsics.checkNotNullParameter(intercomUUID, "intercomUUID");
        Intrinsics.checkNotNullParameter(flatUUID, "flatUUID");
        return FlowKt.flow(new CamerasRepository$getCameraByIntercomUUID$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(intercomUUID, flatUUID, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: CamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/cameras/DataCamera;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$getCamerasDemo$1", f = "CamerasRepository.kt", l = {63, 64, 64}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$getCamerasDemo$1, reason: invalid class name and case insensitive filesystem */
    static final class C06881 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataCamera>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C06881(Continuation<? super C06881> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06881 c06881 = CamerasRepository.this.new C06881(continuation);
            c06881.L$0 = obj;
            return c06881;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataCamera>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataCamera>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataCamera>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06881) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto L64
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L59
            L26:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r6.L$0 = r7
                r6.label = r5
                java.lang.Object r1 = r7.emit(r1, r6)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r7
            L47:
                com.sputnik.data.repositories.cameras.CamerasRepository r7 = com.sputnik.data.repositories.cameras.CamerasRepository.this
                com.sputnik.data.repositories.cameras.CamerasRepository$getCamerasDemo$1$1 r5 = new com.sputnik.data.repositories.cameras.CamerasRepository$getCamerasDemo$1$1
                r5.<init>(r7, r2)
                r6.L$0 = r1
                r6.label = r4
                java.lang.Object r7 = r7.safeApiCall(r5, r6)
                if (r7 != r0) goto L59
                return r0
            L59:
                r6.L$0 = r2
                r6.label = r3
                java.lang.Object r7 = r1.emit(r7, r6)
                if (r7 != r0) goto L64
                return r0
            L64:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.cameras.CamerasRepository.C06881.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: CamerasRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/cameras/DataCamera;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$getCamerasDemo$1$1", f = "CamerasRepository.kt", l = {65}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$getCamerasDemo$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01441 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataCamera>>>, Object> {
            int label;
            final /* synthetic */ CamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01441(CamerasRepository camerasRepository, Continuation<? super C01441> continuation) {
                super(1, continuation);
                this.this$0 = camerasRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01441(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataCamera>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataCamera>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataCamera>>> continuation) {
                return ((C01441) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    this.label = 1;
                    obj = camerasApi.getCamerasDemo(this);
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

    @Override // com.sputnik.domain.repositories.cameras.ICamerasRepository
    public Flow<Resource<List<DomainCamera>>> getCamerasDemo() {
        return FlowKt.flow(new CamerasRepository$getCamerasDemo$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C06881(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: CamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$openDoor$1", f = "CamerasRepository.kt", l = {79, 79}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$openDoor$1, reason: invalid class name and case insensitive filesystem */
    static final class C06891 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $addressId;
        final /* synthetic */ boolean $isWidget;
        final /* synthetic */ OpenDoorProducers $producer;
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06891(String str, String str2, boolean z, OpenDoorProducers openDoorProducers, Continuation<? super C06891> continuation) {
            super(2, continuation);
            this.$addressId = str;
            this.$uuid = str2;
            this.$isWidget = z;
            this.$producer = openDoorProducers;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06891 c06891 = CamerasRepository.this.new C06891(this.$addressId, this.$uuid, this.$isWidget, this.$producer, continuation);
            c06891.L$0 = obj;
            return c06891;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06891) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CamerasRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$openDoor$1$1", f = "CamerasRepository.kt", l = {79}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$openDoor$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01451 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $addressId;
            final /* synthetic */ boolean $isWidget;
            final /* synthetic */ OpenDoorProducers $producer;
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ CamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01451(CamerasRepository camerasRepository, String str, String str2, boolean z, OpenDoorProducers openDoorProducers, Continuation<? super C01451> continuation) {
                super(1, continuation);
                this.this$0 = camerasRepository;
                this.$addressId = str;
                this.$uuid = str2;
                this.$isWidget = z;
                this.$producer = openDoorProducers;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01451(this.this$0, this.$addressId, this.$uuid, this.$isWidget, this.$producer, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01451) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    String strValueOf = this.$addressId;
                    if (strValueOf == null) {
                        LoginState.Session.Address currentAddress = this.this$0.prefManager.getCurrentAddress();
                        strValueOf = String.valueOf(currentAddress != null ? currentAddress.getId() : null);
                    }
                    String str = this.$uuid;
                    boolean z = this.$isWidget;
                    OpenDoorProducers openDoorProducers = this.$producer;
                    this.label = 1;
                    obj = camerasApi.openDoor(strValueOf, str, z, openDoorProducers, this);
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
                CamerasRepository camerasRepository = CamerasRepository.this;
                C01451 c01451 = new C01451(camerasRepository, this.$addressId, this.$uuid, this.$isWidget, this.$producer, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = camerasRepository.safeApiCall(c01451, this);
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

    @Override // com.sputnik.domain.repositories.cameras.ICamerasRepository
    public Flow<Resource<Unit>> openDoor(String uuid, boolean isWidget, OpenDoorProducers producer, String addressId) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(producer, "producer");
        return FlowKt.flowOn(FlowKt.flow(new C06891(addressId, uuid, isWidget, producer, null)), Dispatchers.getIO());
    }

    /* compiled from: CamerasRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$openSecondDoor$1", f = "CamerasRepository.kt", l = {88, 88}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$openSecondDoor$1, reason: invalid class name and case insensitive filesystem */
    static final class C06901 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isWidget;
        final /* synthetic */ String $uuid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06901(String str, boolean z, Continuation<? super C06901> continuation) {
            super(2, continuation);
            this.$uuid = str;
            this.$isWidget = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06901 c06901 = CamerasRepository.this.new C06901(this.$uuid, this.$isWidget, continuation);
            c06901.L$0 = obj;
            return c06901;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C06901) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: CamerasRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.cameras.CamerasRepository$openSecondDoor$1$1", f = "CamerasRepository.kt", l = {88}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.cameras.CamerasRepository$openSecondDoor$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01461 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ boolean $isWidget;
            final /* synthetic */ String $uuid;
            int label;
            final /* synthetic */ CamerasRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01461(CamerasRepository camerasRepository, String str, boolean z, Continuation<? super C01461> continuation) {
                super(1, continuation);
                this.this$0 = camerasRepository;
                this.$uuid = str;
                this.$isWidget = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01461(this.this$0, this.$uuid, this.$isWidget, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01461) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CamerasApi camerasApi = this.this$0.camerasApi;
                    LoginState.Session.Address currentAddress = this.this$0.prefManager.getCurrentAddress();
                    String strValueOf = String.valueOf(currentAddress != null ? currentAddress.getId() : null);
                    String str = this.$uuid;
                    boolean z = this.$isWidget;
                    this.label = 1;
                    obj = camerasApi.openSecondDoor(strValueOf, str, z, this);
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
                CamerasRepository camerasRepository = CamerasRepository.this;
                C01461 c01461 = new C01461(camerasRepository, this.$uuid, this.$isWidget, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = camerasRepository.safeApiCall(c01461, this);
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

    @Override // com.sputnik.domain.repositories.cameras.ICamerasRepository
    public Flow<Resource<Unit>> openSecondDoor(String uuid, boolean isWidget) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return FlowKt.flowOn(FlowKt.flow(new C06901(uuid, isWidget, null)), Dispatchers.getIO());
    }
}
