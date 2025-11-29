package npi.spay;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import coil.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import spay.sdk.SPaySdkApp;

/* loaded from: classes4.dex */
public final class Q8 extends Dk {
    public final C1942tf b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q8(C1942tf helpersItemClickActionListener) {
        super(F7.a);
        Intrinsics.checkNotNullParameter(helpersItemClickActionListener, "helpersItemClickActionListener");
        this.b = helpersItemClickActionListener;
    }

    @Override // npi.spay.Dk
    public final void a(ViewBinding viewBinding, Object obj) {
        J4 j4 = (J4) viewBinding;
        C1651hm item = (C1651hm) obj;
        Intrinsics.checkNotNullParameter(j4, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Im sdkComponent = SPaySdkApp.INSTANCE.getInstance().getSdkComponent();
        if (sdkComponent != null) {
            C1884r7 c1884r7A = ((Ik) sdkComponent).a();
            String str = item.d;
            AppCompatImageView targetView = j4.b;
            Intrinsics.checkNotNullExpressionValue(targetView, "spaySrihAcivHelperIcon");
            A6 imageRequestBuilder = A6.a;
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            ImageRequest.Builder builderTarget = new ImageRequest.Builder(c1884r7A.a).data(str).target(targetView);
            imageRequestBuilder.getClass();
            Intrinsics.checkNotNullParameter(builderTarget, "$this$null");
            Unit unit = Unit.INSTANCE;
            c1884r7A.b.enqueue(builderTarget.build());
        }
        j4.d.setText(item.a);
        j4.c.setText(item.b);
        ConstraintLayout spaySrihClRoot = j4.e;
        Intrinsics.checkNotNullExpressionValue(spaySrihClRoot, "spaySrihClRoot");
        spaySrihClRoot.setOnClickListener(new ViewOnClickListenerC1711k8(new Ref$LongRef(), this, item));
    }

    @Override // npi.spay.Dk
    public final boolean b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof C1651hm;
    }

    @Override // npi.spay.Dk
    public final Integer a(Object obj) {
        C1651hm c1651hm = (C1651hm) obj;
        Intrinsics.checkNotNullParameter(c1651hm, "<this>");
        return Integer.valueOf(c1651hm.hashCode());
    }
}
