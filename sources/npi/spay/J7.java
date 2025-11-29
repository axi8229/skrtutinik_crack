package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* loaded from: classes4.dex */
public final class J7 extends Lambda implements Function0 {
    public final /* synthetic */ C2081z4 a;
    public final /* synthetic */ Xd b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J7(C2081z4 c2081z4, Xd xd) {
        super(0);
        this.a = c2081z4;
        this.b = xd;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.a), null, null, new V6(this.a, this.b, null), 3, null);
        return Unit.INSTANCE;
    }
}
