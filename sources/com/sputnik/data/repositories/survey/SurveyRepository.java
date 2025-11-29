package com.sputnik.data.repositories.survey;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.data.api.SurveyApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.survey.DataSurvey;
import com.sputnik.data.entities.survey.DataSurveyRequest;
import com.sputnik.data.entities.survey.DataSurveyResult;
import com.sputnik.data.mappers.survey.DataSurveyResultToDomainSurveyResultMapper;
import com.sputnik.data.mappers.survey.DataSurveyToDomainSurveyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.survey.DomainSurvey;
import com.sputnik.domain.entities.survey.DomainSurveyResult;
import com.sputnik.domain.repositories.survey.ISurveyRepository;
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

/* compiled from: SurveyRepository.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B3\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u00100\u000fH\u0016J2\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00100\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00142\u0006\u0010\u001b\u001a\u00020\u0012H\u0016JC\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00100\u000f2\u0006\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010!R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/sputnik/data/repositories/survey/SurveyRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/survey/ISurveyRepository;", "surveyApi", "Lcom/sputnik/data/api/SurveyApi;", "dataSurveyToDomainSurveyListMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/survey/DataSurvey;", "Lcom/sputnik/domain/entities/survey/DomainSurvey;", "dataSurveyToDomainSurveyMapper", "Lcom/sputnik/data/mappers/survey/DataSurveyToDomainSurveyMapper;", "dataSurveyResultToDomainSurveyResultMapper", "Lcom/sputnik/data/mappers/survey/DataSurveyResultToDomainSurveyResultMapper;", "(Lcom/sputnik/data/api/SurveyApi;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/mappers/survey/DataSurveyToDomainSurveyMapper;Lcom/sputnik/data/mappers/survey/DataSurveyResultToDomainSurveyResultMapper;)V", "getSurvey", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "getSurveys", "", "sendFeedback", "", "like", "", "issues", "", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "sendResult", "Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", "surveyId", "optionIds", "starsCount", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SurveyRepository extends BaseApiResponse implements ISurveyRepository {
    private final DataSurveyResultToDomainSurveyResultMapper dataSurveyResultToDomainSurveyResultMapper;
    private final ListMapper<DataSurvey, DomainSurvey> dataSurveyToDomainSurveyListMapper;
    private final DataSurveyToDomainSurveyMapper dataSurveyToDomainSurveyMapper;
    private final SurveyApi surveyApi;

    public SurveyRepository(SurveyApi surveyApi, ListMapper<DataSurvey, DomainSurvey> dataSurveyToDomainSurveyListMapper, DataSurveyToDomainSurveyMapper dataSurveyToDomainSurveyMapper, DataSurveyResultToDomainSurveyResultMapper dataSurveyResultToDomainSurveyResultMapper) {
        Intrinsics.checkNotNullParameter(surveyApi, "surveyApi");
        Intrinsics.checkNotNullParameter(dataSurveyToDomainSurveyListMapper, "dataSurveyToDomainSurveyListMapper");
        Intrinsics.checkNotNullParameter(dataSurveyToDomainSurveyMapper, "dataSurveyToDomainSurveyMapper");
        Intrinsics.checkNotNullParameter(dataSurveyResultToDomainSurveyResultMapper, "dataSurveyResultToDomainSurveyResultMapper");
        this.surveyApi = surveyApi;
        this.dataSurveyToDomainSurveyListMapper = dataSurveyToDomainSurveyListMapper;
        this.dataSurveyToDomainSurveyMapper = dataSurveyToDomainSurveyMapper;
        this.dataSurveyResultToDomainSurveyResultMapper = dataSurveyResultToDomainSurveyResultMapper;
    }

    /* compiled from: SurveyRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.survey.SurveyRepository$sendFeedback$1", f = "SurveyRepository.kt", l = {34, 34}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.survey.SurveyRepository$sendFeedback$1, reason: invalid class name and case insensitive filesystem */
    static final class C07451 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $comment;
        final /* synthetic */ List<Integer> $issues;
        final /* synthetic */ boolean $like;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07451(boolean z, List<Integer> list, String str, Continuation<? super C07451> continuation) {
            super(2, continuation);
            this.$like = z;
            this.$issues = list;
            this.$comment = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07451 c07451 = SurveyRepository.this.new C07451(this.$like, this.$issues, this.$comment, continuation);
            c07451.L$0 = obj;
            return c07451;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07451) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SurveyRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.survey.SurveyRepository$sendFeedback$1$1", f = "SurveyRepository.kt", l = {34}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.survey.SurveyRepository$sendFeedback$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02731 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $comment;
            final /* synthetic */ List<Integer> $issues;
            final /* synthetic */ boolean $like;
            int label;
            final /* synthetic */ SurveyRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02731(SurveyRepository surveyRepository, boolean z, List<Integer> list, String str, Continuation<? super C02731> continuation) {
                super(1, continuation);
                this.this$0 = surveyRepository;
                this.$like = z;
                this.$issues = list;
                this.$comment = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02731(this.this$0, this.$like, this.$issues, this.$comment, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02731) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SurveyApi surveyApi = this.this$0.surveyApi;
                    DataSurveyRequest dataSurveyRequest = new DataSurveyRequest(this.$like, this.$issues, this.$comment);
                    this.label = 1;
                    obj = surveyApi.sendFeedback(dataSurveyRequest, this);
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
                SurveyRepository surveyRepository = SurveyRepository.this;
                C02731 c02731 = new C02731(surveyRepository, this.$like, this.$issues, this.$comment, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = surveyRepository.safeApiCall(c02731, this);
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

    @Override // com.sputnik.domain.repositories.survey.ISurveyRepository
    public Flow<Resource<Unit>> sendFeedback(boolean like, List<Integer> issues, String comment) {
        Intrinsics.checkNotNullParameter(issues, "issues");
        Intrinsics.checkNotNullParameter(comment, "comment");
        return FlowKt.flowOn(FlowKt.flow(new C07451(like, issues, comment, null)), Dispatchers.getIO());
    }

    /* compiled from: SurveyRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/survey/DataSurvey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.survey.SurveyRepository$getSurveys$1", f = "SurveyRepository.kt", l = {42, 42}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.survey.SurveyRepository$getSurveys$1, reason: invalid class name and case insensitive filesystem */
    static final class C07441 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataSurvey>>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07441(Continuation<? super C07441> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07441 c07441 = SurveyRepository.this.new C07441(continuation);
            c07441.L$0 = obj;
            return c07441;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataSurvey>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataSurvey>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataSurvey>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07441) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SurveyRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/survey/DataSurvey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.survey.SurveyRepository$getSurveys$1$1", f = "SurveyRepository.kt", l = {42}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.survey.SurveyRepository$getSurveys$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02721 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataSurvey>>>, Object> {
            int label;
            final /* synthetic */ SurveyRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02721(SurveyRepository surveyRepository, Continuation<? super C02721> continuation) {
                super(1, continuation);
                this.this$0 = surveyRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02721(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataSurvey>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataSurvey>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataSurvey>>> continuation) {
                return ((C02721) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SurveyApi surveyApi = this.this$0.surveyApi;
                    this.label = 1;
                    obj = surveyApi.getSurveys(this);
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
                SurveyRepository surveyRepository = SurveyRepository.this;
                C02721 c02721 = new C02721(surveyRepository, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = surveyRepository.safeApiCall(c02721, this);
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

    @Override // com.sputnik.domain.repositories.survey.ISurveyRepository
    public Flow<Resource<List<DomainSurvey>>> getSurveys() {
        return FlowKt.flow(new SurveyRepository$getSurveys$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07441(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: SurveyRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/survey/DataSurvey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.survey.SurveyRepository$getSurvey$1", f = "SurveyRepository.kt", l = {51, 51}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.survey.SurveyRepository$getSurvey$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataSurvey>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SurveyRepository.this.new AnonymousClass1(this.$name, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataSurvey>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataSurvey>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataSurvey>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SurveyRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/survey/DataSurvey;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.survey.SurveyRepository$getSurvey$1$1", f = "SurveyRepository.kt", l = {51}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.survey.SurveyRepository$getSurvey$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02711 extends SuspendLambda implements Function1<Continuation<? super Response<DataSurvey>>, Object> {
            final /* synthetic */ String $name;
            int label;
            final /* synthetic */ SurveyRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02711(SurveyRepository surveyRepository, String str, Continuation<? super C02711> continuation) {
                super(1, continuation);
                this.this$0 = surveyRepository;
                this.$name = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02711(this.this$0, this.$name, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataSurvey>> continuation) {
                return ((C02711) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SurveyApi surveyApi = this.this$0.surveyApi;
                    String str = this.$name;
                    this.label = 1;
                    obj = surveyApi.getSurvey(str, this);
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
                SurveyRepository surveyRepository = SurveyRepository.this;
                C02711 c02711 = new C02711(surveyRepository, this.$name, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = surveyRepository.safeApiCall(c02711, this);
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

    @Override // com.sputnik.domain.repositories.survey.ISurveyRepository
    public Flow<Resource<DomainSurvey>> getSurvey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return FlowKt.flow(new SurveyRepository$getSurvey$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(name, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: SurveyRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/survey/DataSurveyResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.survey.SurveyRepository$sendResult$1", f = "SurveyRepository.kt", l = {65, 65}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.survey.SurveyRepository$sendResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C07461 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataSurveyResult>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $comment;
        final /* synthetic */ List<Integer> $optionIds;
        final /* synthetic */ Integer $starsCount;
        final /* synthetic */ int $surveyId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07461(int i, List<Integer> list, Integer num, String str, Continuation<? super C07461> continuation) {
            super(2, continuation);
            this.$surveyId = i;
            this.$optionIds = list;
            this.$starsCount = num;
            this.$comment = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07461 c07461 = SurveyRepository.this.new C07461(this.$surveyId, this.$optionIds, this.$starsCount, this.$comment, continuation);
            c07461.L$0 = obj;
            return c07461;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataSurveyResult>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataSurveyResult>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataSurveyResult>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07461) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SurveyRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/survey/DataSurveyResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.survey.SurveyRepository$sendResult$1$1", f = "SurveyRepository.kt", l = {66}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.survey.SurveyRepository$sendResult$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02741 extends SuspendLambda implements Function1<Continuation<? super Response<DataSurveyResult>>, Object> {
            final /* synthetic */ String $comment;
            final /* synthetic */ List<Integer> $optionIds;
            final /* synthetic */ Integer $starsCount;
            final /* synthetic */ int $surveyId;
            int label;
            final /* synthetic */ SurveyRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02741(SurveyRepository surveyRepository, int i, List<Integer> list, Integer num, String str, Continuation<? super C02741> continuation) {
                super(1, continuation);
                this.this$0 = surveyRepository;
                this.$surveyId = i;
                this.$optionIds = list;
                this.$starsCount = num;
                this.$comment = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02741(this.this$0, this.$surveyId, this.$optionIds, this.$starsCount, this.$comment, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataSurveyResult>> continuation) {
                return ((C02741) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SurveyApi surveyApi = this.this$0.surveyApi;
                    DataSurveyResult dataSurveyResult = new DataSurveyResult(this.$surveyId, this.$optionIds, this.$starsCount, this.$comment);
                    this.label = 1;
                    obj = surveyApi.sendResult(dataSurveyResult, this);
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
                SurveyRepository surveyRepository = SurveyRepository.this;
                C02741 c02741 = new C02741(surveyRepository, this.$surveyId, this.$optionIds, this.$starsCount, this.$comment, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = surveyRepository.safeApiCall(c02741, this);
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

    @Override // com.sputnik.domain.repositories.survey.ISurveyRepository
    public Flow<Resource<DomainSurveyResult>> sendResult(int surveyId, List<Integer> optionIds, Integer starsCount, String comment) {
        Intrinsics.checkNotNullParameter(optionIds, "optionIds");
        return FlowKt.flow(new SurveyRepository$sendResult$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07461(surveyId, optionIds, starsCount, comment, null)), Dispatchers.getIO()), null, this));
    }
}
