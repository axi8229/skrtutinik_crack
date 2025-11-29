package npi.spay;

import androidx.core.util.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import spay.sdk.RedirectActivity;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class V0 extends Lambda implements Function1 {
    public final /* synthetic */ RedirectActivity a;
    public final /* synthetic */ Consumer b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V0(RedirectActivity redirectActivity, Consumer consumer) {
        super(1);
        this.a = redirectActivity;
        this.b = consumer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Timber.INSTANCE.i("INTENT_LISTENER_CANCELED", new Object[0]);
        this.a.removeOnNewIntentListener(this.b);
        return Unit.INSTANCE;
    }
}
