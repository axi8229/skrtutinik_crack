package npi.spay;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import spay.sdk.RedirectActivity;

/* loaded from: classes4.dex */
public final class L0 extends Lambda implements Function1 {
    public final /* synthetic */ RedirectActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L0(RedirectActivity redirectActivity) {
        super(1);
        this.a = redirectActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        if (((Z2) obj) instanceof T2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new C1758m5(this.a, null), 3, null);
        }
        return Unit.INSTANCE;
    }
}
