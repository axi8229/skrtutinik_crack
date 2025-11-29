package npi.spay;

import android.view.View;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class L4 extends ListAdapter {
    public final Function1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L4(Function1 function1, AbstractC2035x8 diffUtilCallback) {
        super(diffUtilCallback);
        Intrinsics.checkNotNullParameter(diffUtilCallback, "diffUtilCallback");
        this.a = function1;
    }

    public static final void a(L4 this$0, Object item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1 function1 = this$0.a;
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(item, "item");
            function1.invoke(item);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(Ie holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "item");
        holder.a(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.L4$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                L4.a(this.f$0, item, view);
            }
        });
    }
}
