package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import npi.spay.Ti;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lnpi/spay/si;", "Lnpi/spay/Ti;", "VM", "Landroidx/viewbinding/ViewBinding;", "B", "Lnpi/spay/Z7;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.si, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1920si<VM extends Ti, B extends ViewBinding> extends Z7<VM, B> {
    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((Ti) b()).a(C1596fh.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        ((Ti) b()).a(C1621gh.a);
        super.onStop();
    }
}
