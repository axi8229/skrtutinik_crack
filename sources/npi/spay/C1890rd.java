package npi.spay;

import androidx.viewbinding.ViewBinding;
import spay.sdk.view.SpayBnplGraphCompositeView;

/* renamed from: npi.spay.rd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1890rd implements Vj {
    public final /* synthetic */ C1940td a;

    public C1890rd(C1940td c1940td) {
        this.a = c1940td;
    }

    @Override // npi.spay.Vj
    public final void a(int i) {
        C1940td c1940td = this.a;
        int i2 = C1940td.$r8$clinit;
        ViewBinding viewBinding = c1940td.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        SpayBnplGraphCompositeView spayBnplGraphCompositeView = ((C1790nc) viewBinding).j;
        spayBnplGraphCompositeView.a(spayBnplGraphCompositeView.c.size(), i);
    }
}
