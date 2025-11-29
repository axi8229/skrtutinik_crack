package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.view.MerchantLogoCompositeView;

/* renamed from: npi.spay.qj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1872qj implements ViewBinding {
    public final FrameLayout a;
    public final MerchantLogoCompositeView b;
    public final ShapeableImageView c;

    public C1872qj(FrameLayout frameLayout, MerchantLogoCompositeView merchantLogoCompositeView, ShapeableImageView shapeableImageView) {
        this.a = frameLayout;
        this.b = merchantLogoCompositeView;
        this.c = shapeableImageView;
    }

    public static C1872qj a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R$layout.spay_composite_layout_user_data, viewGroup, false);
        viewGroup.addView(viewInflate);
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        int i = R$id.spay_sclud_iv_logo;
        MerchantLogoCompositeView merchantLogoCompositeView = (MerchantLogoCompositeView) ViewBindings.findChildViewById(viewInflate, i);
        if (merchantLogoCompositeView != null) {
            i = R$id.spay_sclud_iv_user_icon;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(viewInflate, i);
            if (shapeableImageView != null) {
                return new C1872qj(frameLayout, merchantLogoCompositeView, shapeableImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
