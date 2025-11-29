package npi.spay;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ck extends RecyclerView.ViewHolder {
    public final ViewBinding a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ck(ViewBinding viewBinding) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.a = viewBinding;
    }
}
