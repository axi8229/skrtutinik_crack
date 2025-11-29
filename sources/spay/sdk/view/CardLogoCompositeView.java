package spay.sdk.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import coil.request.ImageRequest;
import com.facebook.shimmer.ShimmerFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.C1561e7;
import npi.spay.C1884r7;
import npi.spay.Ik;
import npi.spay.Im;
import npi.spay.Qk;
import npi.spay.U7;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.SPaySdkApp;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lspay/sdk/view/CardLogoCompositeView;", "Landroid/widget/FrameLayout;", "Lnpi/spay/U7;", "Lnpi/spay/r7;", "a", "Lnpi/spay/r7;", "getCoilImpl", "()Lnpi/spay/r7;", "coilImpl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class CardLogoCompositeView extends FrameLayout implements U7 {

    /* renamed from: a, reason: from kotlin metadata */
    public final C1884r7 coilImpl;
    public final ImageView b;
    public final ShimmerFrameLayout c;
    public final Drawable d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardLogoCompositeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(String str) {
        ImageView targetView = this.b;
        ShimmerFrameLayout shimmerFrame = this.c;
        Drawable drawable = this.d;
        Intrinsics.checkNotNullParameter(targetView, "shimmerImageView");
        Intrinsics.checkNotNullParameter(shimmerFrame, "shimmerFrame");
        C1561e7 imageRequestListener = new C1561e7(shimmerFrame, targetView, drawable);
        C1884r7 coilImpl = getCoilImpl();
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

    @Override // npi.spay.U7
    public C1884r7 getCoilImpl() {
        return this.coilImpl;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardLogoCompositeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardLogoCompositeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Im sdkComponent$SPaySDK_release = SPaySdkApp.INSTANCE.getInstance().getSdkComponent();
        this.coilImpl = sdkComponent$SPaySDK_release != null ? ((Ik) sdkComponent$SPaySDK_release).a() : null;
        LayoutInflater.from(context).inflate(R$layout.spay_composite_layout_card_logo, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.spay_iv_card_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<ImageView>(R.id.spay_iv_card_icon)");
        this.b = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.spay_shimmer_fl_card_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<ShimmerFram…er_fl_card_icon\n        )");
        this.c = (ShimmerFrameLayout) viewFindViewById2;
        this.d = ResourcesCompat.getDrawable(getResources(), R$drawable.spay_ic_card_preview, null);
    }

    public /* synthetic */ CardLogoCompositeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
