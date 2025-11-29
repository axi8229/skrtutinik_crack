package npi.spay;

import android.content.Intent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.RedirectActivity;
import spay.sdk.domain.model.FakeBankAuthData;

/* loaded from: classes4.dex */
public final class Jb implements FlowCollector {
    public final /* synthetic */ Mb a;

    public Jb(Mb mb) {
        this.a = mb;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.requireActivity().startActivity(new Intent(this.a.getContext(), (Class<?>) RedirectActivity.class).putExtra("FAKE_BANK_AUTH_INTENT_KEY", (FakeBankAuthData) obj));
        return Unit.INSTANCE;
    }
}
