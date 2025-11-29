package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ReceiveChannel;

/* loaded from: classes5.dex */
public final class m extends Lambda implements Function2 {
    public final /* synthetic */ q a;
    public final /* synthetic */ ReceiveChannel b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(q qVar, ReceiveChannel receiveChannel, int i) {
        super(2);
        this.a = qVar;
        this.b = receiveChannel;
        this.c = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        n.a(this.a, this.b, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.c | 1));
        return Unit.INSTANCE;
    }
}
