package com.sputnik.data.repositories.stories;

import com.sputnik.data.api.StoriesApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.stories.DataStory;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.stories.DomainStory;
import com.sputnik.domain.repositories.stories.IStoriesRepository;
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

/* compiled from: StoriesRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ:\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J2\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\f0\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/sputnik/data/repositories/stories/StoriesRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/stories/IStoriesRepository;", "storiesApi", "Lcom/sputnik/data/api/StoriesApi;", "mapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/entities/stories/DataStory;", "Lcom/sputnik/domain/entities/stories/DomainStory;", "(Lcom/sputnik/data/api/StoriesApi;Lcom/sputnik/domain/common/NullableInputListMapper;)V", "loadOnBoardingStories", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "platform", "", "app", "locale", "version", "", "loadStories", "jwt", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StoriesRepository extends BaseApiResponse implements IStoriesRepository {
    private final NullableInputListMapper<DataStory, DomainStory> mapper;
    private final StoriesApi storiesApi;

    public StoriesRepository(StoriesApi storiesApi, NullableInputListMapper<DataStory, DomainStory> mapper) {
        Intrinsics.checkNotNullParameter(storiesApi, "storiesApi");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.storiesApi = storiesApi;
        this.mapper = mapper;
    }

    /* compiled from: StoriesRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/stories/DataStory;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.stories.StoriesRepository$loadOnBoardingStories$1", f = "StoriesRepository.kt", l = {29, 29}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.stories.StoriesRepository$loadOnBoardingStories$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataStory>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $app;
        final /* synthetic */ String $locale;
        final /* synthetic */ String $platform;
        final /* synthetic */ int $version;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$locale = str;
            this.$app = str2;
            this.$platform = str3;
            this.$version = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = StoriesRepository.this.new AnonymousClass1(this.$locale, this.$app, this.$platform, this.$version, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataStory>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataStory>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataStory>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: StoriesRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/stories/DataStory;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.stories.StoriesRepository$loadOnBoardingStories$1$1", f = "StoriesRepository.kt", l = {30}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.stories.StoriesRepository$loadOnBoardingStories$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02611 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataStory>>>, Object> {
            final /* synthetic */ String $app;
            final /* synthetic */ String $locale;
            final /* synthetic */ String $platform;
            final /* synthetic */ int $version;
            int label;
            final /* synthetic */ StoriesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02611(StoriesRepository storiesRepository, String str, String str2, String str3, int i, Continuation<? super C02611> continuation) {
                super(1, continuation);
                this.this$0 = storiesRepository;
                this.$locale = str;
                this.$app = str2;
                this.$platform = str3;
                this.$version = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02611(this.this$0, this.$locale, this.$app, this.$platform, this.$version, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataStory>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataStory>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataStory>>> continuation) {
                return ((C02611) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StoriesApi storiesApi = this.this$0.storiesApi;
                    String str = this.$locale;
                    String str2 = this.$app;
                    String str3 = this.$platform;
                    int i2 = this.$version;
                    this.label = 1;
                    obj = storiesApi.getOnboardingStories(str, str2, str3, i2, this);
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
                StoriesRepository storiesRepository = StoriesRepository.this;
                C02611 c02611 = new C02611(storiesRepository, this.$locale, this.$app, this.$platform, this.$version, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = storiesRepository.safeApiCall(c02611, this);
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

    @Override // com.sputnik.domain.repositories.stories.IStoriesRepository
    public Flow<Resource<List<DomainStory>>> loadOnBoardingStories(String platform, String app, String locale, int version) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return FlowKt.flow(new StoriesRepository$loadOnBoardingStories$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(locale, app, platform, version, null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: StoriesRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/data/entities/stories/DataStory;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.stories.StoriesRepository$loadStories$1", f = "StoriesRepository.kt", l = {50, 50}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.stories.StoriesRepository$loadStories$1, reason: invalid class name and case insensitive filesystem */
    static final class C07411 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends List<? extends DataStory>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $jwt;
        final /* synthetic */ String $locale;
        final /* synthetic */ int $version;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07411(String str, String str2, int i, Continuation<? super C07411> continuation) {
            super(2, continuation);
            this.$jwt = str;
            this.$locale = str2;
            this.$version = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07411 c07411 = StoriesRepository.this.new C07411(this.$jwt, this.$locale, this.$version, continuation);
            c07411.L$0 = obj;
            return c07411;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends List<? extends DataStory>>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<? extends List<DataStory>>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<? extends List<DataStory>>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07411) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: StoriesRepository.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/stories/DataStory;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.stories.StoriesRepository$loadStories$1$1", f = "StoriesRepository.kt", l = {51}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.stories.StoriesRepository$loadStories$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02621 extends SuspendLambda implements Function1<Continuation<? super Response<List<? extends DataStory>>>, Object> {
            final /* synthetic */ String $jwt;
            final /* synthetic */ String $locale;
            final /* synthetic */ int $version;
            int label;
            final /* synthetic */ StoriesRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02621(StoriesRepository storiesRepository, String str, String str2, int i, Continuation<? super C02621> continuation) {
                super(1, continuation);
                this.this$0 = storiesRepository;
                this.$jwt = str;
                this.$locale = str2;
                this.$version = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02621(this.this$0, this.$jwt, this.$locale, this.$version, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Response<List<? extends DataStory>>> continuation) {
                return invoke2((Continuation<? super Response<List<DataStory>>>) continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Response<List<DataStory>>> continuation) {
                return ((C02621) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StoriesApi storiesApi = this.this$0.storiesApi;
                    String str = this.$jwt;
                    String str2 = this.$locale;
                    int i2 = this.$version;
                    this.label = 1;
                    obj = StoriesApi.DefaultImpls.getStories$default(storiesApi, str, str2, null, i2, null, this, 20, null);
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
                StoriesRepository storiesRepository = StoriesRepository.this;
                C02621 c02621 = new C02621(storiesRepository, this.$jwt, this.$locale, this.$version, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = storiesRepository.safeApiCall(c02621, this);
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

    @Override // com.sputnik.domain.repositories.stories.IStoriesRepository
    public Flow<Resource<List<DomainStory>>> loadStories(String jwt, String locale, int version) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return FlowKt.flow(new StoriesRepository$loadStories$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07411(jwt, locale, version, null)), Dispatchers.getIO()), null, this));
    }
}
