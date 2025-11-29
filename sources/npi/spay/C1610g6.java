package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* renamed from: npi.spay.g6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1610g6 extends Lambda implements Function0 {
    public final /* synthetic */ C2081z4 a;
    public final /* synthetic */ C1674il b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1610g6(C2081z4 c2081z4, C1674il c1674il) {
        super(0);
        this.a = c2081z4;
        this.b = c1674il;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.a), Dispatchers.getIO(), null, new C1584f5(this.a, this.b, null), 2, null);
        return Unit.INSTANCE;
    }
}
