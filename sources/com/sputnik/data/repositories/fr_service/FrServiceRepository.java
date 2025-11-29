package com.sputnik.data.repositories.fr_service;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.data.api.ServicesApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.repositories.fr_service.IFrServiceRepository;
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
import okhttp3.MultipartBody;
import retrofit2.Response;

/* compiled from: FrServiceRepository.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/data/repositories/fr_service/FrServiceRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/fr_service/IFrServiceRepository;", "Lokhttp3/MultipartBody$Part;", "servicesApi", "Lcom/sputnik/data/api/ServicesApi;", "(Lcom/sputnik/data/api/ServicesApi;)V", "updateFr", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", RemoteMessageConst.DATA, "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FrServiceRepository extends BaseApiResponse implements IFrServiceRepository<MultipartBody.Part> {
    private final ServicesApi servicesApi;

    public FrServiceRepository(ServicesApi servicesApi) {
        Intrinsics.checkNotNullParameter(servicesApi, "servicesApi");
        this.servicesApi = servicesApi;
    }

    /* compiled from: FrServiceRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.fr_service.FrServiceRepository$updateFr$1", f = "FrServiceRepository.kt", l = {20, 20}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.fr_service.FrServiceRepository$updateFr$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ MultipartBody.Part $data;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MultipartBody.Part part, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$data = part;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = FrServiceRepository.this.new AnonymousClass1(this.$data, continuation);
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

        /* compiled from: FrServiceRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.fr_service.FrServiceRepository$updateFr$1$1", f = "FrServiceRepository.kt", l = {20}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.fr_service.FrServiceRepository$updateFr$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01661 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ MultipartBody.Part $data;
            int label;
            final /* synthetic */ FrServiceRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01661(FrServiceRepository frServiceRepository, MultipartBody.Part part, Continuation<? super C01661> continuation) {
                super(1, continuation);
                this.this$0 = frServiceRepository;
                this.$data = part;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01661(this.this$0, this.$data, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C01661) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ServicesApi servicesApi = this.this$0.servicesApi;
                    MultipartBody.Part part = this.$data;
                    this.label = 1;
                    obj = servicesApi.sendFrData(part, this);
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
                FrServiceRepository frServiceRepository = FrServiceRepository.this;
                C01661 c01661 = new C01661(frServiceRepository, this.$data, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = frServiceRepository.safeApiCall(c01661, this);
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

    @Override // com.sputnik.domain.repositories.fr_service.IFrServiceRepository
    public Flow<Resource<Unit>> updateFr(MultipartBody.Part data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(data, null)), Dispatchers.getIO());
    }
}
