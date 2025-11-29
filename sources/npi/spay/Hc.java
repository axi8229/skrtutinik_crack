package npi.spay;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* loaded from: classes4.dex */
public final class Hc extends Ie {
    public final C1907s5 b;
    public final Function1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hc(C1907s5 viewBinding, Function1 hintCloseActionListener) {
        super(viewBinding);
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        Intrinsics.checkNotNullParameter(hintCloseActionListener, "hintCloseActionListener");
        this.b = viewBinding;
        this.c = hintCloseActionListener;
    }

    @Override // npi.spay.Ie
    public final void a(Object obj) {
        C2012wa item = (C2012wa) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        C1907s5 c1907s5 = this.b;
        AppCompatTextView appCompatTextView = c1907s5.c;
        Bk bk = item.b;
        Context context = this.a.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemViewBinding.root.context");
        appCompatTextView.setText(AbstractC1550dl.a(bk, context));
        AppCompatImageView spaySrihhAcivDismissHint = c1907s5.b;
        Intrinsics.checkNotNullExpressionValue(spaySrihhAcivDismissHint, "spaySrihhAcivDismissHint");
        spaySrihhAcivDismissHint.setOnClickListener(new Sb(new Ref$LongRef(), this, item));
    }
}
