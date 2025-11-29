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
public final class S9 extends Dk {
    public final C1967uf b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S9(C1967uf helpersItemClickActionListener) {
        super(C1935t8.a);
        Intrinsics.checkNotNullParameter(helpersItemClickActionListener, "helpersItemClickActionListener");
        this.b = helpersItemClickActionListener;
    }

    @Override // npi.spay.Dk
    public final void a(ViewBinding viewBinding, Object obj) {
        C1611g7 c1611g7 = (C1611g7) viewBinding;
        Ma item = (Ma) obj;
        Intrinsics.checkNotNullParameter(c1611g7, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Im sdkComponent = SPaySdkApp.INSTANCE.getInstance().getSdkComponent();
        if (sdkComponent != null) {
            C1884r7 c1884r7A = ((Ik) sdkComponent).a();
            String str = item.d;
            AppCompatImageView targetView = c1611g7.b;
            Intrinsics.checkNotNullExpressionValue(targetView, "spaySrishAcivHelperIcon");
            A6 imageRequestBuilder = A6.a;
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            ImageRequest.Builder builderTarget = new ImageRequest.Builder(c1884r7A.a).data(str).target(targetView);
            imageRequestBuilder.getClass();
            Intrinsics.checkNotNullParameter(builderTarget, "$this$null");
            Unit unit = Unit.INSTANCE;
            c1884r7A.b.enqueue(builderTarget.build());
        }
        c1611g7.d.setText(item.a);
        c1611g7.c.setText(item.b);
        ConstraintLayout spaySrishClRoot = c1611g7.e;
        Intrinsics.checkNotNullExpressionValue(spaySrishClRoot, "spaySrishClRoot");
        spaySrishClRoot.setOnClickListener(new ViewOnClickListenerC1886r9(new Ref$LongRef(), this, item));
    }

    @Override // npi.spay.Dk
    public final boolean b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof Ma;
    }

    @Override // npi.spay.Dk
    public final Integer a(Object obj) {
        Ma ma = (Ma) obj;
        Intrinsics.checkNotNullParameter(ma, "<this>");
        return Integer.valueOf(ma.hashCode());
    }
}
