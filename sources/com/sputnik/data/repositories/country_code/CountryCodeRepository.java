package com.sputnik.data.repositories.country_code;

import com.sputnik.data.entities.country_code.DataCountryCode;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import com.sputnik.domain.repositories.country_code.ICountryCodeRepository;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: CountryCodeRepository.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/data/repositories/country_code/CountryCodeRepository;", "Lcom/sputnik/domain/repositories/country_code/ICountryCodeRepository;", "source", "Lcom/sputnik/data/repositories/country_code/CountryCodeSource;", "dataCountryCodeToDomainCountryCodeMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/entities/country_code/DataCountryCode;", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", "(Lcom/sputnik/data/repositories/country_code/CountryCodeSource;Lcom/sputnik/domain/common/ListMapper;)V", "getCodes", "Lkotlinx/coroutines/flow/Flow;", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CountryCodeRepository implements ICountryCodeRepository {
    private final ListMapper<DataCountryCode, DomainCountryCode> dataCountryCodeToDomainCountryCodeMapper;
    private final CountryCodeSource source;

    public CountryCodeRepository(CountryCodeSource source, ListMapper<DataCountryCode, DomainCountryCode> dataCountryCodeToDomainCountryCodeMapper) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dataCountryCodeToDomainCountryCodeMapper, "dataCountryCodeToDomainCountryCodeMapper");
        this.source = source;
        this.dataCountryCodeToDomainCountryCodeMapper = dataCountryCodeToDomainCountryCodeMapper;
    }

    /* compiled from: CountryCodeRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.country_code.CountryCodeRepository$getCodes$1", f = "CountryCodeRepository.kt", l = {19}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.repositories.country_code.CountryCodeRepository$getCodes$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends DomainCountryCode>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = CountryCodeRepository.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends DomainCountryCode>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<DomainCountryCode>>) flowCollector, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<DomainCountryCode>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Collection map = CountryCodeRepository.this.dataCountryCodeToDomainCountryCodeMapper.map(CountryCodeRepository.this.source.loadCodes());
                this.label = 1;
                if (flowCollector.emit(map, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.sputnik.domain.repositories.country_code.ICountryCodeRepository
    public Flow<List<DomainCountryCode>> getCodes() {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO());
    }
}
