package spay.sdk.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import coil.request.ImageRequest;
import com.facebook.shimmer.ShimmerFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import npi.spay.AbstractC1923sl;
import npi.spay.C1545dg;
import npi.spay.C1561e7;
import npi.spay.C1884r7;
import npi.spay.Qk;
import ru.yoomoney.sdk.kassa.payments.R$dimen;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.response.bnpl.ButtonBnpl;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¨\u0006\u0012"}, d2 = {"Lspay/sdk/view/BnplButtonCompositeView;", "Landroid/widget/FrameLayout;", "", "bnplNewSubTitle", "", "setBnplNewSubTitle", "", "pxMargin", "setTopMargin", "bnplNewTitle", "setBnplTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class BnplButtonCompositeView extends FrameLayout {
    public static boolean c;
    public final C1545dg a;
    public boolean b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Ref$LongRef a;
        public final /* synthetic */ BnplButtonCompositeView b;

        public a(Ref$LongRef ref$LongRef, BnplButtonCompositeView bnplButtonCompositeView) {
            this.a = ref$LongRef;
            this.b = bnplButtonCompositeView;
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
            this.b.performClick();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BnplButtonCompositeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setBnplNewSubTitle(String bnplNewSubTitle) {
        this.a.c.setText(bnplNewSubTitle);
    }

    private final void setTopMargin(int pxMargin) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, pxMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        setLayoutParams(marginLayoutParams);
    }

    public final void a() {
        setVisibility(8);
        this.b = true;
        setTopMargin(0);
    }

    public final void b(ButtonBnpl bnpl) {
        Intrinsics.checkNotNullParameter(bnpl, "bnpl");
        setVisibility(0);
        a(bnpl);
        if (this.b) {
            setTopMargin((int) getResources().getDimension(R$dimen.spay_order_bnpl_btn_margin_top));
            this.b = false;
        }
    }

    public final void setBnplTitle(String bnplNewTitle) {
        Intrinsics.checkNotNullParameter(bnplNewTitle, "bnplNewTitle");
        this.a.d.setText(bnplNewTitle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BnplButtonCompositeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(String numOfPayments, ButtonBnpl bnpl) throws Resources.NotFoundException {
        String string;
        Intrinsics.checkNotNullParameter(numOfPayments, "numOfPayments");
        Intrinsics.checkNotNullParameter(bnpl, "bnpl");
        BnplLogoCompositeView bnplLogoCompositeView = this.a.b;
        String activeButtonLogo = bnpl.getActiveButtonLogo();
        ImageView targetView = bnplLogoCompositeView.b;
        ShimmerFrameLayout shimmerFrame = bnplLogoCompositeView.c;
        Drawable drawable = bnplLogoCompositeView.d;
        Intrinsics.checkNotNullParameter(targetView, "shimmerImageView");
        Intrinsics.checkNotNullParameter(shimmerFrame, "shimmerFrame");
        C1561e7 imageRequestListener = new C1561e7(shimmerFrame, targetView, drawable);
        C1884r7 coilImpl = bnplLogoCompositeView.getCoilImpl();
        Intrinsics.checkNotNullParameter(targetView, "<this>");
        Intrinsics.checkNotNullParameter(imageRequestListener, "imageRequestListener");
        if (coilImpl != null) {
            Qk imageRequestBuilder = new Qk(imageRequestListener);
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            ImageRequest.Builder loadImage = new ImageRequest.Builder(coilImpl.a).data(activeButtonLogo).target(targetView);
            Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
            loadImage.listener(imageRequestListener);
            Unit unit = Unit.INSTANCE;
            coilImpl.b.enqueue(loadImage.build());
        }
        AppCompatImageView appCompatImageView = this.a.f;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.spaySclbbAcivSwitch");
        AbstractC1923sl.a(appCompatImageView, R$drawable.spay_ic_switch_bnpl_on);
        if (c) {
            string = bnpl.getContent();
        } else {
            string = getResources().getString(R$string.spay_bnpl_on_button_subtitle);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                resour…          )\n            }");
        }
        setBnplNewSubTitle(string);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BnplButtonCompositeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        C1545dg c1545dgA = C1545dg.a(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(c1545dgA, "inflate(\n        LayoutI… this,\n        true\n    )");
        this.a = c1545dgA;
        CardView cardView = c1545dgA.e;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.spayCvBnplRoot");
        cardView.setOnClickListener(new a(new Ref$LongRef(), this));
    }

    public /* synthetic */ BnplButtonCompositeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a(ButtonBnpl bnpl) {
        Intrinsics.checkNotNullParameter(bnpl, "bnpl");
        setBnplTitle(bnpl.getHeader());
        setBnplNewSubTitle(bnpl.getContent());
        BnplLogoCompositeView bnplLogoCompositeView = this.a.b;
        String inactiveButtonLogo = bnpl.getInactiveButtonLogo();
        ImageView targetView = bnplLogoCompositeView.b;
        ShimmerFrameLayout shimmerFrame = bnplLogoCompositeView.c;
        Drawable drawable = bnplLogoCompositeView.e;
        Intrinsics.checkNotNullParameter(targetView, "shimmerImageView");
        Intrinsics.checkNotNullParameter(shimmerFrame, "shimmerFrame");
        C1561e7 imageRequestListener = new C1561e7(shimmerFrame, targetView, drawable);
        C1884r7 coilImpl = bnplLogoCompositeView.getCoilImpl();
        Intrinsics.checkNotNullParameter(targetView, "<this>");
        Intrinsics.checkNotNullParameter(imageRequestListener, "imageRequestListener");
        if (coilImpl != null) {
            Qk imageRequestBuilder = new Qk(imageRequestListener);
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            ImageRequest.Builder loadImage = new ImageRequest.Builder(coilImpl.a).data(inactiveButtonLogo).target(targetView);
            Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
            loadImage.listener(imageRequestListener);
            Unit unit = Unit.INSTANCE;
            coilImpl.b.enqueue(loadImage.build());
        }
        AppCompatImageView appCompatImageView = this.a.f;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.spaySclbbAcivSwitch");
        AbstractC1923sl.a(appCompatImageView, R$drawable.spay_ic_switch_bnpl_off);
    }
}
