package com.sputnik.data.repositories.notifications;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.data.api.NotificationsApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.notifications.DataNotification;
import com.sputnik.data.mappers.notifications.DataNotificationtToDomainNotificationMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.notifications.DomainNotification;
import com.sputnik.domain.repositories.notifications.INotificationsRepository;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* compiled from: NotificationsRepository.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e0\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/sputnik/data/repositories/notifications/NotificationsRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/notifications/INotificationsRepository;", "Lcom/sputnik/data/api/NotificationsApi;", "api", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/notifications/DataNotification;", "Lcom/sputnik/domain/entities/notifications/DomainNotification;", "listMapper", "Lcom/sputnik/data/mappers/notifications/DataNotificationtToDomainNotificationMapper;", "mapper", "<init>", "(Lcom/sputnik/data/api/NotificationsApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/mappers/notifications/DataNotificationtToDomainNotificationMapper;)V", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "getNotifications", "()Lkotlinx/coroutines/flow/Flow;", "getUnviewedNotifications", RemoteMessageConst.NOTIFICATION, "updateNotification", "(Lcom/sputnik/domain/entities/notifications/DomainNotification;)Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/data/api/NotificationsApi;", "getApi", "()Lcom/sputnik/data/api/NotificationsApi;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/mappers/notifications/DataNotificationtToDomainNotificationMapper;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotificationsRepository extends BaseApiResponse implements INotificationsRepository {
    private final NotificationsApi api;
    private final ListMapper<DataNotification, DomainNotification> listMapper;
    private final DataNotificationtToDomainNotificationMapper mapper;

    public final NotificationsApi getApi() {
        return this.api;
    }

    /* compiled from: NotificationsRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/notifications/DataNotification;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.notifications.NotificationsRepository$getNotifications$1", f = "NotificationsRepository.kt", l = {24, 24}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.notifications.NotificationsRepository$getNotifications$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataNotification>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = NotificationsRepository.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataNotification>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataNotification>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataNotification>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: NotificationsRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/notifications/DataNotification;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.notifications.NotificationsRepository$getNotifications$1$1", f = "NotificationsRepository.kt", l = {24}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.notifications.NotificationsRepository$getNotifications$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02191 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataNotification>>>, Object> {
            int label;
            final /* synthetic */ NotificationsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02191(NotificationsRepository notificationsRepository, Continuation<? super C02191> continuation) {
                super(1, continuation);
                this.this$0 = notificationsRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02191(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataNotification>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataNotification>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataNotification>>> continuation) {
                return ((C02191) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    NotificationsApi api = this.this$0.getApi();
                    this.label = 1;
                    obj = api.getNotifications(this);
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
                NotificationsRepository notificationsRepository = NotificationsRepository.this;
                C02191 c02191 = new C02191(notificationsRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = notificationsRepository.safeApiCall(c02191, this);
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

    public NotificationsRepository(NotificationsApi api, ListMapper<DataNotification, DomainNotification> listMapper, DataNotificationtToDomainNotificationMapper mapper) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.api = api;
        this.listMapper = listMapper;
        this.mapper = mapper;
    }

    @Override // com.sputnik.domain.repositories.notifications.INotificationsRepository
    public Flow<Resource<List<DomainNotification>>> getNotifications() {
        return FlowKt.flow(new NotificationsRepository$getNotifications$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: NotificationsRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/notifications/DataNotification;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.notifications.NotificationsRepository$getUnviewedNotifications$1", f = "NotificationsRepository.kt", l = {31, 31}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.notifications.NotificationsRepository$getUnviewedNotifications$1, reason: invalid class name and case insensitive filesystem */
    static final class C07171 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataNotification>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07171(Continuation<? super C07171> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07171 c07171 = NotificationsRepository.this.new C07171(continuation);
            c07171.L$0 = obj;
            return c07171;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataNotification>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataNotification>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataNotification>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07171) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: NotificationsRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/notifications/DataNotification;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.notifications.NotificationsRepository$getUnviewedNotifications$1$1", f = "NotificationsRepository.kt", l = {31}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.notifications.NotificationsRepository$getUnviewedNotifications$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02201 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataNotification>>>, Object> {
            int label;
            final /* synthetic */ NotificationsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02201(NotificationsRepository notificationsRepository, Continuation<? super C02201> continuation) {
                super(1, continuation);
                this.this$0 = notificationsRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02201(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataNotification>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataNotification>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataNotification>>> continuation) {
                return ((C02201) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    NotificationsApi api = this.this$0.getApi();
                    this.label = 1;
                    obj = api.getUnviewedNotifications(this);
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
                NotificationsRepository notificationsRepository = NotificationsRepository.this;
                C02201 c02201 = new C02201(notificationsRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = notificationsRepository.safeApiCall(c02201, this);
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

    @Override // com.sputnik.domain.repositories.notifications.INotificationsRepository
    public Flow<Resource<List<DomainNotification>>> getUnviewedNotifications() {
        return FlowKt.flow(new NotificationsRepository$getUnviewedNotifications$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07171(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: NotificationsRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/notifications/DataNotification;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.notifications.NotificationsRepository$updateNotification$1", f = "NotificationsRepository.kt", l = {46, 46}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.notifications.NotificationsRepository$updateNotification$1, reason: invalid class name and case insensitive filesystem */
    static final class C07181 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataNotification>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ DomainNotification $notification;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07181(DomainNotification domainNotification, Continuation<? super C07181> continuation) {
            super(2, continuation);
            this.$notification = domainNotification;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07181 c07181 = NotificationsRepository.this.new C07181(this.$notification, continuation);
            c07181.L$0 = obj;
            return c07181;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataNotification>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataNotification>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataNotification>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07181) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: NotificationsRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/notifications/DataNotification;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.notifications.NotificationsRepository$updateNotification$1$1", f = "NotificationsRepository.kt", l = {47}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.notifications.NotificationsRepository$updateNotification$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02211 extends SuspendLambda implements Function1<Continuation<? super Response<DataNotification>>, Object> {
            final /* synthetic */ DomainNotification $notification;
            int label;
            final /* synthetic */ NotificationsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02211(NotificationsRepository notificationsRepository, DomainNotification domainNotification, Continuation<? super C02211> continuation) {
                super(1, continuation);
                this.this$0 = notificationsRepository;
                this.$notification = domainNotification;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02211(this.this$0, this.$notification, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataNotification>> continuation) {
                return ((C02211) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                DomainNotification domainNotification;
                List<DomainNotification.DomainButton> buttons;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                NotificationsApi api = this.this$0.getApi();
                String strValueOf = String.valueOf(this.$notification.getId());
                Integer id = this.$notification.getId();
                String identifier = this.$notification.getIdentifier();
                String identifierHuman = this.$notification.getIdentifierHuman();
                String title = this.$notification.getTitle();
                String deeplink = this.$notification.getDeeplink();
                String message = this.$notification.getMessage();
                Boolean viewed = this.$notification.getViewed();
                String createdAt = this.$notification.getCreatedAt();
                DomainNotification domainNotification2 = this.$notification;
                ArrayList arrayList = null;
                if ((domainNotification2 != null ? domainNotification2.getButtons() : null) != null && (domainNotification = this.$notification) != null && (buttons = domainNotification.getButtons()) != null) {
                    List<DomainNotification.DomainButton> list = buttons;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (DomainNotification.DomainButton domainButton : list) {
                        arrayList.add(new DataNotification.DataButton(domainButton.getType(), domainButton.getColor(), domainButton.getDeeplink(), domainButton.getTitle(), domainButton.getLink()));
                    }
                }
                DataNotification dataNotification = new DataNotification(id, identifier, identifierHuman, title, deeplink, message, viewed, createdAt, arrayList);
                this.label = 1;
                Object objUpdateNotification = api.updateNotification(strValueOf, dataNotification, this);
                return objUpdateNotification == coroutine_suspended ? coroutine_suspended : objUpdateNotification;
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
                NotificationsRepository notificationsRepository = NotificationsRepository.this;
                C02211 c02211 = new C02211(notificationsRepository, this.$notification, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = notificationsRepository.safeApiCall(c02211, this);
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

    @Override // com.sputnik.domain.repositories.notifications.INotificationsRepository
    public Flow<Resource<DomainNotification>> updateNotification(DomainNotification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        return FlowKt.flow(new NotificationsRepository$updateNotification$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07181(notification, null)), Dispatchers.getIO()), null, this));
    }
}
