package spay.sdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1977v0;
import npi.spay.C1462a8;
import npi.spay.C1835p7;
import npi.spay.C2060y8;
import npi.spay.Ug;
import npi.spay.Ze;
import ru.yoomoney.sdk.kassa.payments.R$dimen;
import ru.yoomoney.sdk.kassa.payments.R$styleable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lspay/sdk/view/SpayBnplGraphCompositeView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lnpi/spay/Ug;", "a", "Lnpi/spay/Ug;", "getBinding", "()Lnpi/spay/Ug;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class SpayBnplGraphCompositeView extends LinearLayoutCompat {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a, reason: from kotlin metadata */
    public final Ug binding;
    public final C1835p7 b;
    public final ArrayList c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpayBnplGraphCompositeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(int i, int i2) {
        if (i <= 0 || i > 8) {
            return;
        }
        this.c.clear();
        int i3 = 0;
        while (i3 < i) {
            this.c.add(new C1462a8(i3 == i2));
            i3++;
        }
        this.b.submitList(this.c);
        this.b.notifyDataSetChanged();
    }

    public final Ug getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpayBnplGraphCompositeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayBnplGraphCompositeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Ug ugA = Ug.a(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(ugA, "inflate(\n        LayoutI… this,\n        true\n    )");
        this.binding = ugA;
        C1835p7 c1835p7 = new C1835p7(new C2060y8());
        this.b = c1835p7;
        this.c = new ArrayList();
        RecyclerView recyclerView = ugA.b;
        recyclerView.setAdapter(c1835p7);
        recyclerView.addItemDecoration(new Ze(AbstractC1977v0.b(context, R$dimen.spay_6dp)));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SpayBnplGraphCompositeView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…GraphCompositeView, 0, 0)");
            a(typedArrayObtainStyledAttributes.getInt(R$styleable.SpayBnplGraphCompositeView_spay_graph_size, 4), 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ SpayBnplGraphCompositeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
