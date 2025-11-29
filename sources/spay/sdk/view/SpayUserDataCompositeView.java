package spay.sdk.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.request.ImageRequest;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.imageview.ShapeableImageView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import npi.spay.C1561e7;
import npi.spay.C1872qj;
import npi.spay.C1884r7;
import npi.spay.Ik;
import npi.spay.Im;
import npi.spay.O4;
import npi.spay.Qk;
import spay.sdk.SPaySdkApp;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lspay/sdk/view/SpayUserDataCompositeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lnpi/spay/O4;", RemoteMessageConst.DATA, "", "setClientData", "(Lnpi/spay/O4;)V", "Lkotlin/Function1;", "Landroid/view/View;", "callback", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "merchantLogo", "Ljava/lang/String;", "setMerchantLogo", "(Ljava/lang/String;)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class SpayUserDataCompositeView extends ConstraintLayout {
    public final C1872qj a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Ref$LongRef a;
        public final /* synthetic */ Function1 b;

        public a(Ref$LongRef ref$LongRef, Function1 function1) {
            this.a = ref$LongRef;
            this.b = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Ref$LongRef ref$LongRef = this.a;
            if (jElapsedRealtime - ref$LongRef.element < 400) {
                return;
            }
            ref$LongRef.element = SystemClock.elapsedRealtime();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.b.invoke(it);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpayUserDataCompositeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setMerchantLogo(String str) {
        MerchantLogoCompositeView merchantLogoCompositeView = this.a.b;
        ImageView targetView = merchantLogoCompositeView.b;
        ShimmerFrameLayout shimmerFrame = merchantLogoCompositeView.c;
        Drawable drawable = merchantLogoCompositeView.d;
        Intrinsics.checkNotNullParameter(targetView, "shimmerImageView");
        Intrinsics.checkNotNullParameter(shimmerFrame, "shimmerFrame");
        C1561e7 imageRequestListener = new C1561e7(shimmerFrame, targetView, drawable);
        C1884r7 coilImpl = merchantLogoCompositeView.getCoilImpl();
        Intrinsics.checkNotNullParameter(targetView, "<this>");
        Intrinsics.checkNotNullParameter(imageRequestListener, "imageRequestListener");
        if (coilImpl != null) {
            Qk imageRequestBuilder = new Qk(imageRequestListener);
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            ImageRequest.Builder loadImage = new ImageRequest.Builder(coilImpl.a).data(str).target(targetView);
            Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
            loadImage.listener(imageRequestListener);
            Unit unit = Unit.INSTANCE;
            coilImpl.b.enqueue(loadImage.build());
        }
    }

    public final void setClientData(O4 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        setMerchantLogo(data.a);
    }

    public final void setOnClickListener(Function1<? super View, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ShapeableImageView shapeableImageView = this.a.c;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "binding.spayScludIvUserIcon");
        shapeableImageView.setOnClickListener(new a(new Ref$LongRef(), callback));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpayUserDataCompositeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayUserDataCompositeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Im sdkComponent = SPaySdkApp.INSTANCE.getInstance().getSdkComponent();
        if (sdkComponent != null) {
            ((Ik) sdkComponent).a();
        }
        C1872qj c1872qjA = C1872qj.a(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(c1872qjA, "inflate(\n        LayoutI… this,\n        true\n    )");
        this.a = c1872qjA;
    }

    public /* synthetic */ SpayUserDataCompositeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
