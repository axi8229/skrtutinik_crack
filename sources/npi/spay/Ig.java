package npi.spay;

import android.content.Intent;
import android.net.Uri;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Ig extends Lambda implements Function1 {
    public final /* synthetic */ C2017wf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ig(C2017wf c2017wf) {
        super(1);
        this.a = c2017wf;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.a.requireActivity().startActivity(new Intent("android.intent.action.VIEW", (Uri) obj));
        return Unit.INSTANCE;
    }
}
