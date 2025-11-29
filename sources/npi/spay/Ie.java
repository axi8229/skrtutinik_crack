package npi.spay;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Ie extends RecyclerView.ViewHolder {
    public final ViewBinding a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ie(ViewBinding itemViewBinding) {
        super(itemViewBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemViewBinding, "itemViewBinding");
        this.a = itemViewBinding;
    }

    public abstract void a(Object obj);
}
