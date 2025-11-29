package npi.spay;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import coil.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import spay.sdk.SPaySdkApp;

/* renamed from: npi.spay.jm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1700jm extends Dk {
    public final C1917sf b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1700jm(C1917sf helpersItemClickActionListener) {
        super(Rk.a);
        Intrinsics.checkNotNullParameter(helpersItemClickActionListener, "helpersItemClickActionListener");
        this.b = helpersItemClickActionListener;
    }

    @Override // npi.spay.Dk
    public final void a(ViewBinding viewBinding, Object obj) {
        C1828p0 c1828p0 = (C1828p0) viewBinding;
        Zj item = (Zj) obj;
        Intrinsics.checkNotNullParameter(c1828p0, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Im sdkComponent = SPaySdkApp.INSTANCE.getInstance().getSdkComponent();
        if (sdkComponent != null) {
            C1884r7 c1884r7A = ((Ik) sdkComponent).a();
            String str = item.d;
            AppCompatImageView targetView = c1828p0.b;
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
        c1828p0.d.setText(item.a);
        c1828p0.c.setText(item.b);
        ConstraintLayout spaySrihClRoot = c1828p0.e;
        Intrinsics.checkNotNullExpressionValue(spaySrihClRoot, "spaySrihClRoot");
        spaySrihClRoot.setOnClickListener(new ViewOnClickListenerC1948tl(new Ref$LongRef(), this, item));
    }

    @Override // npi.spay.Dk
    public final boolean b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof Zj;
    }

    @Override // npi.spay.Dk
    public final Integer a(Object obj) {
        Zj zj = (Zj) obj;
        Intrinsics.checkNotNullParameter(zj, "<this>");
        return Integer.valueOf(zj.hashCode());
    }
}
