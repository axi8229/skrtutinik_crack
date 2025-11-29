package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* loaded from: classes4.dex */
public final class E8 extends Lambda implements Function0 {
    public final /* synthetic */ G8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E8(G8 g8) {
        super(0);
        this.a = g8;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        G8 g8 = this.a;
        g8.getClass();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(g8), null, null, new C9(g8, null), 3, null);
        return Unit.INSTANCE;
    }
}
