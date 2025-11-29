package sputnik.axmor.com.sputnik.ui.main.profile;

import com.sputnik.common.viewmodels.MarketViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ProfileFragment$onViewCreated$1$1$1 extends FunctionReferenceImpl implements Function1<MarketViewState, Unit> {
    ProfileFragment$onViewCreated$1$1$1(Object obj) {
        super(1, obj, ProfileFragment.class, "renderMarketUi", "renderMarketUi(Lcom/sputnik/common/viewmodels/MarketViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MarketViewState marketViewState) {
        invoke2(marketViewState);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MarketViewState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((ProfileFragment) this.receiver).renderMarketUi(p0);
    }
}
