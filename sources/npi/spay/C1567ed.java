package npi.spay;

import android.content.res.Resources;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.domain.model.response.bnpl.ButtonBnpl;
import spay.sdk.view.BnplButtonCompositeView;
import spay.sdk.view.SpayBnplGraphCompositeView;

/* renamed from: npi.spay.ed, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1567ed implements FlowCollector {
    public final /* synthetic */ C1790nc a;

    public C1567ed(C1790nc c1790nc) {
        this.a = c1790nc;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) throws Resources.NotFoundException {
        C2092zf c2092zf = (C2092zf) obj;
        ButtonBnpl buttonBnpl = c2092zf.e;
        if (buttonBnpl != null) {
            this.a.c.b(buttonBnpl);
        }
        if (Intrinsics.areEqual(c2092zf.c, Boxing.boxBoolean(true))) {
            ButtonBnpl buttonBnpl2 = c2092zf.e;
            if (buttonBnpl2 != null) {
                BnplButtonCompositeView bnplButtonCompositeView = this.a.c;
                String str = c2092zf.a;
                if (str == null) {
                    str = "";
                }
                bnplButtonCompositeView.a(str, buttonBnpl2);
            }
        } else if (Intrinsics.areEqual(c2092zf.c, Boxing.boxBoolean(false))) {
            ButtonBnpl buttonBnpl3 = c2092zf.e;
            if (buttonBnpl3 != null) {
                this.a.c.a(buttonBnpl3);
            }
        } else if (!c2092zf.d) {
            this.a.c.a();
            SpayBnplGraphCompositeView spaySloSbgcvGraph = this.a.j;
            Intrinsics.checkNotNullExpressionValue(spaySloSbgcvGraph, "spaySloSbgcvGraph");
            spaySloSbgcvGraph.setVisibility(8);
        }
        return Unit.INSTANCE;
    }
}
