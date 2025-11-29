package com.sputnik.data.repositories.profile;

import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.data.api.ProfileApi;
import com.sputnik.data.base.BaseApiResponse;
import com.sputnik.data.entities.profile.DataProfile;
import com.sputnik.data.entities.profile.UpdateCallEnabled;
import com.sputnik.data.mappers.profile.DataProfileToDomainProfileMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.profile.DomainProfile;
import com.sputnik.domain.repositories.profile.IProfileRepository;
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
import org.pjsip.pjsua2.pjsip_transport_type_e;
import retrofit2.Response;

/* compiled from: ProfileRepository.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n0\tH\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010!\u001a\u00020\u0011H\u0016J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010#\u001a\u00020\u0011H\u0016J\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u001c\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/sputnik/data/repositories/profile/ProfileRepository;", "Lcom/sputnik/data/base/BaseApiResponse;", "Lcom/sputnik/domain/repositories/profile/IProfileRepository;", "profileApi", "Lcom/sputnik/data/api/ProfileApi;", "dataProfileToDomainProfileMapper", "Lcom/sputnik/data/mappers/profile/DataProfileToDomainProfileMapper;", "(Lcom/sputnik/data/api/ProfileApi;Lcom/sputnik/data/mappers/profile/DataProfileToDomainProfileMapper;)V", "bindToFlat", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "number", "", "addressId", "changeAvatar", "image", "", "deactivateAccount", "deactivateAddress", "id", "deleteAccount", "deleteFr", "getProfile", "Lcom/sputnik/domain/entities/profile/DomainProfile;", "logout", "resetAddress", "sendCallEnabled", "isEnabled", "", "sendPushToken", "token", "sendTimezone", "timezone", "setLocalization", "localization", "unlinkAddress", "updateUserName", AppMeasurementSdk.ConditionalUserProperty.NAME, "verifyAddress", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProfileRepository extends BaseApiResponse implements IProfileRepository {
    private final DataProfileToDomainProfileMapper dataProfileToDomainProfileMapper;
    private final ProfileApi profileApi;

    public ProfileRepository(ProfileApi profileApi, DataProfileToDomainProfileMapper dataProfileToDomainProfileMapper) {
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(dataProfileToDomainProfileMapper, "dataProfileToDomainProfileMapper");
        this.profileApi = profileApi;
        this.dataProfileToDomainProfileMapper = dataProfileToDomainProfileMapper;
        Log.e("DAGGER", "ProfileRepository");
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/data/entities/profile/DataProfile;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$getProfile$1", f = "ProfileRepository.kt", l = {31, 32, 32}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$getProfile$1, reason: invalid class name and case insensitive filesystem */
    static final class C07251 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends DataProfile>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07251(Continuation<? super C07251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07251 c07251 = ProfileRepository.this.new C07251(continuation);
            c07251.L$0 = obj;
            return c07251;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends DataProfile>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<DataProfile>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<DataProfile>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07251) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                com.sputnik.data.repositories.profile.ProfileRepository r7 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$getProfile$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$getProfile$1$1
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
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07251.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/profile/DataProfile;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$getProfile$1$1", f = "ProfileRepository.kt", l = {32}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$getProfile$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02331 extends SuspendLambda implements Function1<Continuation<? super Response<DataProfile>>, Object> {
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02331(ProfileRepository profileRepository, Continuation<? super C02331> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02331(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<DataProfile>> continuation) {
                return ((C02331) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    this.label = 1;
                    obj = profileApi.getProfile(this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<DomainProfile>> getProfile() {
        return FlowKt.flow(new ProfileRepository$getProfile$$inlined$transform$1(FlowKt.flowOn(FlowKt.flow(new C07251(null)), Dispatchers.getIO()), null, this));
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$logout$1", f = "ProfileRepository.kt", l = {40, 41, 41}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$logout$1, reason: invalid class name and case insensitive filesystem */
    static final class C07261 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07261(Continuation<? super C07261> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07261 c07261 = ProfileRepository.this.new C07261(continuation);
            c07261.L$0 = obj;
            return c07261;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07261) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                com.sputnik.data.repositories.profile.ProfileRepository r7 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$logout$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$logout$1$1
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
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07261.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$logout$1$1", f = "ProfileRepository.kt", l = {41}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$logout$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02341 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02341(ProfileRepository profileRepository, Continuation<? super C02341> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02341(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02341) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    this.label = 1;
                    obj = profileApi.logout(this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> logout() {
        return FlowKt.flowOn(FlowKt.flow(new C07261(null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$updateUserName$1", f = "ProfileRepository.kt", l = {47, 48, 48}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$updateUserName$1, reason: invalid class name and case insensitive filesystem */
    static final class C07331 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07331(String str, Continuation<? super C07331> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07331 c07331 = ProfileRepository.this.new C07331(this.$name, continuation);
            c07331.L$0 = obj;
            return c07331;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07331) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5b
            L26:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r7.L$0 = r8
                r7.label = r5
                java.lang.Object r1 = r8.emit(r1, r7)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r8
            L47:
                com.sputnik.data.repositories.profile.ProfileRepository r8 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$updateUserName$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$updateUserName$1$1
                java.lang.String r6 = r7.$name
                r5.<init>(r8, r6, r2)
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = r8.safeApiCall(r5, r7)
                if (r8 != r0) goto L5b
                return r0
            L5b:
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L66
                return r0
            L66:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07331.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$updateUserName$1$1", f = "ProfileRepository.kt", l = {48}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$updateUserName$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02411 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $name;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02411(ProfileRepository profileRepository, String str, Continuation<? super C02411> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$name = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02411(this.this$0, this.$name, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02411) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    String str = this.$name;
                    this.label = 1;
                    obj = ProfileApi.DefaultImpls.updateUserName$default(profileApi, str, null, this, 2, null);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> updateUserName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return FlowKt.flowOn(FlowKt.flow(new C07331(name, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$deleteAccount$1", f = "ProfileRepository.kt", l = {54, 55, 55}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$deleteAccount$1, reason: invalid class name and case insensitive filesystem */
    static final class C07231 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07231(Continuation<? super C07231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07231 c07231 = ProfileRepository.this.new C07231(continuation);
            c07231.L$0 = obj;
            return c07231;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07231) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                com.sputnik.data.repositories.profile.ProfileRepository r7 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$deleteAccount$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$deleteAccount$1$1
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
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07231.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$deleteAccount$1$1", f = "ProfileRepository.kt", l = {55}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$deleteAccount$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02311 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02311(ProfileRepository profileRepository, Continuation<? super C02311> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02311(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02311) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    this.label = 1;
                    obj = profileApi.deleteAccount(this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> deleteAccount() {
        return FlowKt.flowOn(FlowKt.flow(new C07231(null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$verifyAddress$1", f = "ProfileRepository.kt", l = {61, 62, 62}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$verifyAddress$1, reason: invalid class name and case insensitive filesystem */
    static final class C07341 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07341(String str, Continuation<? super C07341> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07341 c07341 = ProfileRepository.this.new C07341(this.$id, continuation);
            c07341.L$0 = obj;
            return c07341;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07341) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5b
            L26:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r7.L$0 = r8
                r7.label = r5
                java.lang.Object r1 = r8.emit(r1, r7)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r8
            L47:
                com.sputnik.data.repositories.profile.ProfileRepository r8 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$verifyAddress$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$verifyAddress$1$1
                java.lang.String r6 = r7.$id
                r5.<init>(r8, r6, r2)
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = r8.safeApiCall(r5, r7)
                if (r8 != r0) goto L5b
                return r0
            L5b:
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L66
                return r0
            L66:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07341.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$verifyAddress$1$1", f = "ProfileRepository.kt", l = {62}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$verifyAddress$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02421 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $id;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02421(ProfileRepository profileRepository, String str, Continuation<? super C02421> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$id = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02421(this.this$0, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02421) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    String str = this.$id;
                    this.label = 1;
                    obj = profileApi.verifyAddress(str, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> verifyAddress(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.flowOn(FlowKt.flow(new C07341(id, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$deactivateAddress$1", f = "ProfileRepository.kt", l = {68, 69, 69}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$deactivateAddress$1, reason: invalid class name and case insensitive filesystem */
    static final class C07221 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07221(String str, Continuation<? super C07221> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07221 c07221 = ProfileRepository.this.new C07221(this.$id, continuation);
            c07221.L$0 = obj;
            return c07221;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07221) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5b
            L26:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r7.L$0 = r8
                r7.label = r5
                java.lang.Object r1 = r8.emit(r1, r7)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r8
            L47:
                com.sputnik.data.repositories.profile.ProfileRepository r8 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$deactivateAddress$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$deactivateAddress$1$1
                java.lang.String r6 = r7.$id
                r5.<init>(r8, r6, r2)
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = r8.safeApiCall(r5, r7)
                if (r8 != r0) goto L5b
                return r0
            L5b:
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L66
                return r0
            L66:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07221.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$deactivateAddress$1$1", f = "ProfileRepository.kt", l = {69}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$deactivateAddress$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02301 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $id;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02301(ProfileRepository profileRepository, String str, Continuation<? super C02301> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$id = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02301(this.this$0, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02301) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    String str = this.$id;
                    this.label = 1;
                    obj = profileApi.deactivateAddress(str, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> deactivateAddress(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.flowOn(FlowKt.flow(new C07221(id, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$unlinkAddress$1", f = "ProfileRepository.kt", l = {75, 76, 76}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$unlinkAddress$1, reason: invalid class name and case insensitive filesystem */
    static final class C07321 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07321(String str, Continuation<? super C07321> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07321 c07321 = ProfileRepository.this.new C07321(this.$id, continuation);
            c07321.L$0 = obj;
            return c07321;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07321) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5b
            L26:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r7.L$0 = r8
                r7.label = r5
                java.lang.Object r1 = r8.emit(r1, r7)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r8
            L47:
                com.sputnik.data.repositories.profile.ProfileRepository r8 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$unlinkAddress$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$unlinkAddress$1$1
                java.lang.String r6 = r7.$id
                r5.<init>(r8, r6, r2)
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = r8.safeApiCall(r5, r7)
                if (r8 != r0) goto L5b
                return r0
            L5b:
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L66
                return r0
            L66:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07321.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$unlinkAddress$1$1", f = "ProfileRepository.kt", l = {76}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$unlinkAddress$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02401 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $id;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02401(ProfileRepository profileRepository, String str, Continuation<? super C02401> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$id = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02401(this.this$0, this.$id, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02401) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    String str = this.$id;
                    this.label = 1;
                    obj = profileApi.unlinkAddress(str, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> unlinkAddress(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.flowOn(FlowKt.flow(new C07321(id, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$deactivateAccount$1", f = "ProfileRepository.kt", l = {82, 83, 83}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$deactivateAccount$1, reason: invalid class name and case insensitive filesystem */
    static final class C07211 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07211(Continuation<? super C07211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07211 c07211 = ProfileRepository.this.new C07211(continuation);
            c07211.L$0 = obj;
            return c07211;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07211) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                com.sputnik.data.repositories.profile.ProfileRepository r7 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$deactivateAccount$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$deactivateAccount$1$1
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
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07211.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$deactivateAccount$1$1", f = "ProfileRepository.kt", l = {83}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$deactivateAccount$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02291 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02291(ProfileRepository profileRepository, Continuation<? super C02291> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02291(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02291) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    this.label = 1;
                    obj = profileApi.deactivateAccount(this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> deactivateAccount() {
        return FlowKt.flowOn(FlowKt.flow(new C07211(null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$bindToFlat$1", f = "ProfileRepository.kt", l = {89, 90, 90}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$bindToFlat$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $addressId;
        final /* synthetic */ int $number;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$number = i;
            this.$addressId = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ProfileRepository.this.new AnonymousClass1(this.$number, this.$addressId, continuation);
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
                com.sputnik.data.repositories.profile.ProfileRepository r9 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$bindToFlat$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$bindToFlat$1$1
                int r6 = r8.$number
                int r7 = r8.$addressId
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
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$bindToFlat$1$1", f = "ProfileRepository.kt", l = {90}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$bindToFlat$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02271 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ int $addressId;
            final /* synthetic */ int $number;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02271(ProfileRepository profileRepository, int i, int i2, Continuation<? super C02271> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$number = i;
                this.$addressId = i2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02271(this.this$0, this.$number, this.$addressId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02271) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    int i2 = this.$number;
                    int i3 = this.$addressId;
                    this.label = 1;
                    obj = profileApi.bindToFlat(i2, i3, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> bindToFlat(int number, int addressId) {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(number, addressId, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$sendPushToken$1", f = "ProfileRepository.kt", l = {96, 96}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$sendPushToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C07291 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $token;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07291(String str, Continuation<? super C07291> continuation) {
            super(2, continuation);
            this.$token = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07291 c07291 = ProfileRepository.this.new C07291(this.$token, continuation);
            c07291.L$0 = obj;
            return c07291;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07291) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$sendPushToken$1$1", f = "ProfileRepository.kt", l = {96}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$sendPushToken$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02371 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $token;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02371(ProfileRepository profileRepository, String str, Continuation<? super C02371> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$token = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02371(this.this$0, this.$token, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02371) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    String str = this.$token;
                    this.label = 1;
                    obj = profileApi.sendPushToken(str, this);
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
                ProfileRepository profileRepository = ProfileRepository.this;
                C02371 c02371 = new C02371(profileRepository, this.$token, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = profileRepository.safeApiCall(c02371, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> sendPushToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return FlowKt.flowOn(FlowKt.flow(new C07291(token, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$sendTimezone$1", f = "ProfileRepository.kt", l = {102, 102}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$sendTimezone$1, reason: invalid class name and case insensitive filesystem */
    static final class C07301 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $timezone;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07301(String str, Continuation<? super C07301> continuation) {
            super(2, continuation);
            this.$timezone = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07301 c07301 = ProfileRepository.this.new C07301(this.$timezone, continuation);
            c07301.L$0 = obj;
            return c07301;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07301) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$sendTimezone$1$1", f = "ProfileRepository.kt", l = {102}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$sendTimezone$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02381 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $timezone;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02381(ProfileRepository profileRepository, String str, Continuation<? super C02381> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$timezone = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02381(this.this$0, this.$timezone, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02381) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    String str = this.$timezone;
                    this.label = 1;
                    obj = profileApi.sendTimezone(str, this);
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
                ProfileRepository profileRepository = ProfileRepository.this;
                C02381 c02381 = new C02381(profileRepository, this.$timezone, null);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = profileRepository.safeApiCall(c02381, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> sendTimezone(String timezone) {
        Intrinsics.checkNotNullParameter(timezone, "timezone");
        return FlowKt.flowOn(FlowKt.flow(new C07301(timezone, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$sendCallEnabled$1", f = "ProfileRepository.kt", l = {108, 109, 109}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$sendCallEnabled$1, reason: invalid class name and case insensitive filesystem */
    static final class C07281 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07281(boolean z, Continuation<? super C07281> continuation) {
            super(2, continuation);
            this.$isEnabled = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07281 c07281 = ProfileRepository.this.new C07281(this.$isEnabled, continuation);
            c07281.L$0 = obj;
            return c07281;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07281) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5b
            L26:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r7.L$0 = r8
                r7.label = r5
                java.lang.Object r1 = r8.emit(r1, r7)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r8
            L47:
                com.sputnik.data.repositories.profile.ProfileRepository r8 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$sendCallEnabled$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$sendCallEnabled$1$1
                boolean r6 = r7.$isEnabled
                r5.<init>(r8, r6, r2)
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = r8.safeApiCall(r5, r7)
                if (r8 != r0) goto L5b
                return r0
            L5b:
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L66
                return r0
            L66:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07281.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$sendCallEnabled$1$1", f = "ProfileRepository.kt", l = {109}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$sendCallEnabled$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02361 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ boolean $isEnabled;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02361(ProfileRepository profileRepository, boolean z, Continuation<? super C02361> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$isEnabled = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02361(this.this$0, this.$isEnabled, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02361) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    UpdateCallEnabled updateCallEnabled = new UpdateCallEnabled(this.$isEnabled);
                    this.label = 1;
                    obj = profileApi.sendCallEnabled(updateCallEnabled, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> sendCallEnabled(boolean isEnabled) {
        return FlowKt.flowOn(FlowKt.flow(new C07281(isEnabled, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$setLocalization$1", f = "ProfileRepository.kt", l = {115, 116, 116}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$setLocalization$1, reason: invalid class name and case insensitive filesystem */
    static final class C07311 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $localization;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07311(String str, Continuation<? super C07311> continuation) {
            super(2, continuation);
            this.$localization = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07311 c07311 = ProfileRepository.this.new C07311(this.$localization, continuation);
            c07311.L$0 = obj;
            return c07311;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07311) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5b
            L26:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r7.L$0 = r8
                r7.label = r5
                java.lang.Object r1 = r8.emit(r1, r7)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r8
            L47:
                com.sputnik.data.repositories.profile.ProfileRepository r8 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$setLocalization$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$setLocalization$1$1
                java.lang.String r6 = r7.$localization
                r5.<init>(r8, r6, r2)
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = r8.safeApiCall(r5, r7)
                if (r8 != r0) goto L5b
                return r0
            L5b:
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L66
                return r0
            L66:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07311.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$setLocalization$1$1", f = "ProfileRepository.kt", l = {116}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$setLocalization$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02391 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $localization;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02391(ProfileRepository profileRepository, String str, Continuation<? super C02391> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$localization = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02391(this.this$0, this.$localization, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02391) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    String str = this.$localization;
                    this.label = 1;
                    obj = profileApi.updateUserLocalization(str, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> setLocalization(String localization) {
        Intrinsics.checkNotNullParameter(localization, "localization");
        return FlowKt.flowOn(FlowKt.flow(new C07311(localization, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$deleteFr$1", f = "ProfileRepository.kt", l = {122, 123, 123}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$deleteFr$1, reason: invalid class name and case insensitive filesystem */
    static final class C07241 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07241(Continuation<? super C07241> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07241 c07241 = ProfileRepository.this.new C07241(continuation);
            c07241.L$0 = obj;
            return c07241;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07241) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                com.sputnik.data.repositories.profile.ProfileRepository r7 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$deleteFr$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$deleteFr$1$1
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
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07241.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$deleteFr$1$1", f = "ProfileRepository.kt", l = {123}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$deleteFr$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02321 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02321(ProfileRepository profileRepository, Continuation<? super C02321> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02321(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02321) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    this.label = 1;
                    obj = profileApi.deleteFr(this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> deleteFr() {
        return FlowKt.flowOn(FlowKt.flow(new C07241(null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$changeAvatar$1", f = "ProfileRepository.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6, pjsip_transport_type_e.PJSIP_TRANSPORT_TCP6, pjsip_transport_type_e.PJSIP_TRANSPORT_TCP6}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$changeAvatar$1, reason: invalid class name and case insensitive filesystem */
    static final class C07201 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $image;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07201(String str, Continuation<? super C07201> continuation) {
            super(2, continuation);
            this.$image = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07201 c07201 = ProfileRepository.this.new C07201(this.$image, continuation);
            c07201.L$0 = obj;
            return c07201;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07201) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L66
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5b
            L26:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L47
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                com.sputnik.domain.common.Resource$Companion r1 = com.sputnik.domain.common.Resource.INSTANCE
                com.sputnik.domain.common.Resource r1 = r1.loading()
                r7.L$0 = r8
                r7.label = r5
                java.lang.Object r1 = r8.emit(r1, r7)
                if (r1 != r0) goto L46
                return r0
            L46:
                r1 = r8
            L47:
                com.sputnik.data.repositories.profile.ProfileRepository r8 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$changeAvatar$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$changeAvatar$1$1
                java.lang.String r6 = r7.$image
                r5.<init>(r8, r6, r2)
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = r8.safeApiCall(r5, r7)
                if (r8 != r0) goto L5b
                return r0
            L5b:
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r1.emit(r8, r7)
                if (r8 != r0) goto L66
                return r0
            L66:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07201.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$changeAvatar$1$1", f = "ProfileRepository.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_TCP6}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$changeAvatar$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02281 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            final /* synthetic */ String $image;
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02281(ProfileRepository profileRepository, String str, Continuation<? super C02281> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
                this.$image = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02281(this.this$0, this.$image, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02281) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    String str = this.$image;
                    this.label = 1;
                    obj = profileApi.changeAvatar(str, this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> changeAvatar(String image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return FlowKt.flowOn(FlowKt.flow(new C07201(image, null)), Dispatchers.getIO());
    }

    /* compiled from: ProfileRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$resetAddress$1", f = "ProfileRepository.kt", l = {136, 137, 137}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$resetAddress$1, reason: invalid class name and case insensitive filesystem */
    static final class C07271 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Unit>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07271(Continuation<? super C07271> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07271 c07271 = ProfileRepository.this.new C07271(continuation);
            c07271.L$0 = obj;
            return c07271;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Resource<? extends Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Resource<Unit>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Resource<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C07271) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                com.sputnik.data.repositories.profile.ProfileRepository r7 = com.sputnik.data.repositories.profile.ProfileRepository.this
                com.sputnik.data.repositories.profile.ProfileRepository$resetAddress$1$1 r5 = new com.sputnik.data.repositories.profile.ProfileRepository$resetAddress$1$1
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
            throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.profile.ProfileRepository.C07271.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: ProfileRepository.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lretrofit2/Response;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.repositories.profile.ProfileRepository$resetAddress$1$1", f = "ProfileRepository.kt", l = {137}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.repositories.profile.ProfileRepository$resetAddress$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02351 extends SuspendLambda implements Function1<Continuation<? super Response<Unit>>, Object> {
            int label;
            final /* synthetic */ ProfileRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02351(ProfileRepository profileRepository, Continuation<? super C02351> continuation) {
                super(1, continuation);
                this.this$0 = profileRepository;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02351(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Response<Unit>> continuation) {
                return ((C02351) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileApi profileApi = this.this$0.profileApi;
                    this.label = 1;
                    obj = profileApi.resetAddress(this);
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

    @Override // com.sputnik.domain.repositories.profile.IProfileRepository
    public Flow<Resource<Unit>> resetAddress() {
        return FlowKt.flowOn(FlowKt.flow(new C07271(null)), Dispatchers.getIO());
    }
}
