package com.sputnik.data.repositories.alerts;

import com.sputnik.data.api.AlertsApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.alerts.DataAlert;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.alers.DomainAlert;
import com.sputnik.domain.repositories.alerts.IAlertsRepository;
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

/* compiled from: AlertsRepository.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ:\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/sputnik/data/repositories/alerts/AlertsRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/alerts/IAlertsRepository;", "api", "Lcom/sputnik/data/api/AlertsApi;", "alertMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/alerts/DataAlert;", "Lcom/sputnik/domain/entities/alers/DomainAlert;", "(Lcom/sputnik/data/api/AlertsApi;Lcom/sputnik/domain/common/ListMapper;)V", "getAlerts", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "version", "", "platform", "", "app", "locale", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlertsRepository extends BaseApiResponse implements IAlertsRepository {
    private final ListMapper<DataAlert, DomainAlert> alertMapper;
    private final AlertsApi api;

    public AlertsRepository(AlertsApi api, ListMapper<DataAlert, DomainAlert> alertMapper) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(alertMapper, "alertMapper");
        this.api = api;
        this.alertMapper = alertMapper;
    }

    /* compiled from: AlertsRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/alerts/DataAlert;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.alerts.AlertsRepository$getAlerts$1", f = "AlertsRepository.kt", l = {34, 34}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.alerts.AlertsRepository$getAlerts$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataAlert>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $app;
        final /* synthetic */ String $locale;
        final /* synthetic */ String $platform;
        final /* synthetic */ int $version;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, String str, String str2, String str3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$version = i;
            this.$platform = str;
            this.$app = str2;
            this.$locale = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = AlertsRepository.this.new AnonymousClass1(this.$version, this.$platform, this.$app, this.$locale, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataAlert>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataAlert>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataAlert>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AlertsRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/alerts/DataAlert;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.alerts.AlertsRepository$getAlerts$1$1", f = "AlertsRepository.kt", l = {34}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.alerts.AlertsRepository$getAlerts$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01221 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataAlert>>>, Object> {
            final /* synthetic */ String $app;
            final /* synthetic */ String $locale;
            final /* synthetic */ String $platform;
            final /* synthetic */ int $version;
            int label;
            final /* synthetic */ AlertsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01221(AlertsRepository alertsRepository, int i, String str, String str2, String str3, Continuation<? super C01221> continuation) {
                super(1, continuation);
                this.this$0 = alertsRepository;
                this.$version = i;
                this.$platform = str;
                this.$app = str2;
                this.$locale = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C01221(this.this$0, this.$version, this.$platform, this.$app, this.$locale, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataAlert>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataAlert>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataAlert>>> continuation) {
                return ((C01221) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AlertsApi alertsApi = this.this$0.api;
                    int i2 = this.$version;
                    String str = this.$platform;
                    String str2 = this.$app;
                    String str3 = this.$locale;
                    this.label = 1;
                    obj = alertsApi.getAlerts(i2, str, str2, str3, this);
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
                AlertsRepository alertsRepository = AlertsRepository.this;
                C01221 c01221 = new C01221(alertsRepository, this.$version, this.$platform, this.$app, this.$locale, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = alertsRepository.safeApiCall(c01221, this);
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

    @Override // com.sputnik.domain.repositories.alerts.IAlertsRepository
    public Flow<Resource<List<DomainAlert>>> getAlerts(int version, String platform, String app, String locale) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return FlowKt.flow(new AlertsRepository$getAlerts$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(version, platform, app, locale, null)), Dispatchers.getIO()), null, this));
    }
}
