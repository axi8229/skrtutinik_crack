package ru.yoomoney.sdk.gui.widgetV2.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.color.ColorStateSetKt;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.TypedArrayExtensions;

/* compiled from: IconVectorSmallView.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R.\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/image/IconVectorSmallView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "imageSize", "I", "Landroid/graphics/drawable/Drawable;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "image", "Landroid/graphics/drawable/Drawable;", "getImage", "()Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/content/res/ColorStateList;", "getImageTintColor", "()Landroid/content/res/ColorStateList;", "imageTintColor", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class IconVectorSmallView extends AppCompatImageView {
    private Drawable image;
    private final int imageSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IconVectorSmallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ IconVectorSmallView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListVectorSmallView_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconVectorSmallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_ListImageView, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.imageSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ym_ListImageView_ym_imageSize, 0);
        setImage(TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_image));
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_ListImageView_ym_image_enabled, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    public Drawable getImage() {
        return this.image;
    }

    public void setImage(Drawable drawable) {
        this.image = drawable;
        if (drawable != null) {
            DrawableExtensions.tint(drawable, getImageTintColor());
        }
        setImageDrawable(drawable);
    }

    protected ColorStateList getImageTintColor() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ColorStateSetKt.getLinkTextColorState(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.imageSize, pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH);
        setMeasuredDimension(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
