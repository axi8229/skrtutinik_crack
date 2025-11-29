package ru.yoomoney.sdk.gui.widgetV2.image;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import ru.yoomoney.sdk.gui.drawable.ShapedDrawable;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.TypedArrayExtensions;

/* compiled from: AbstractIconImageView.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b!\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001a\u0010\u0012J\u001f\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010%\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u001fH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0014¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b.\u0010/J\u0013\u00101\u001a\u00020\u0007*\u000200H\u0005¢\u0006\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u0016\u00106\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00107R\u0016\u00109\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010:\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00107R\u0016\u0010;\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00107R\u001c\u0010<\u001a\u0004\u0018\u0001008\u0014X\u0094\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u0001008\u0014X\u0094\u0004¢\u0006\f\n\u0004\b@\u0010=\u001a\u0004\bA\u0010?R$\u0010C\u001a\u0004\u0018\u00010B8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR/\u0010O\u001a\u0004\u0018\u00010\u00132\b\u0010I\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010/\"\u0004\bM\u0010NR.\u0010Q\u001a\u0004\u0018\u0001002\b\u0010P\u001a\u0004\u0018\u0001008F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010=\u001a\u0004\bR\u0010?\"\u0004\bS\u0010TR.\u0010U\u001a\u0004\u0018\u0001002\b\u0010P\u001a\u0004\u0018\u0001008F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010=\u001a\u0004\bV\u0010?\"\u0004\bW\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010DR/\u0010\\\u001a\u0004\u0018\u00010\u00132\b\u0010I\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010K\u001a\u0004\bZ\u0010/\"\u0004\b[\u0010NR\u0018\u0010]\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010DR/\u0010a\u001a\u0004\u0018\u00010\u00132\b\u0010I\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010K\u001a\u0004\b_\u0010/\"\u0004\b`\u0010N¨\u0006c"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "Landroid/view/ViewGroup;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "view", "size", "", "measureIconView", "(Landroid/view/View;I)V", "resolveIconShape", "()V", "Landroid/graphics/drawable/Drawable;", RemoteMessageConst.Notification.ICON, "cutBadgeIfNeeded", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "bg", "cutBackground", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "onImageViewResolved", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "enabled", "setEnabled", "(Z)V", "Landroid/content/res/TypedArray;", "a", "obtainAttrs", "(Landroid/content/res/TypedArray;)V", "resolveTintImage", "()Landroid/graphics/drawable/Drawable;", "Landroid/content/res/ColorStateList;", "getColorByState", "(Landroid/content/res/ColorStateList;)I", "imageSize", "I", "badgeSize", "imageShape", "Landroid/graphics/drawable/Drawable;", "imageShapeWithBrBadge", "imageShapeWithTrBadge", "imageShapeWithTrBrBadge", "imageBackground", "imageColor", "Landroid/content/res/ColorStateList;", "getImageColor", "()Landroid/content/res/ColorStateList;", "backgroundColor", "getBackgroundColor", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "<set-?>", "image$delegate", "Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView$ImageViewProperty;", "getImage", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "image", AppMeasurementSdk.ConditionalUserProperty.VALUE, "imageTintColor", "getImageTintColor", "setImageTintColor", "(Landroid/content/res/ColorStateList;)V", "backgroundTintColor", "getBackgroundTintColor", "setBackgroundTintColor", "badgeIconView", "badge$delegate", "getBadge", "setBadge", "badge", "notifyBadgeIconView", "notifyBadge$delegate", "getNotifyBadge", "setNotifyBadge", "notifyBadge", "ImageViewProperty", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractIconImageView extends ViewGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(AbstractIconImageView.class, "image", "getImage()Landroid/graphics/drawable/Drawable;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(AbstractIconImageView.class, "badge", "getBadge()Landroid/graphics/drawable/Drawable;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(AbstractIconImageView.class, "notifyBadge", "getNotifyBadge()Landroid/graphics/drawable/Drawable;", 0))};
    private final ColorStateList backgroundColor;
    private ColorStateList backgroundTintColor;

    /* renamed from: badge$delegate, reason: from kotlin metadata */
    private final ImageViewProperty badge;
    private ImageView badgeIconView;
    private final int badgeSize;

    /* renamed from: image$delegate, reason: from kotlin metadata */
    private final ImageViewProperty image;
    private final Drawable imageBackground;
    private final ColorStateList imageColor;
    private final Drawable imageShape;
    private final Drawable imageShapeWithBrBadge;
    private final Drawable imageShapeWithTrBadge;
    private final Drawable imageShapeWithTrBrBadge;
    private final int imageSize;
    private ColorStateList imageTintColor;
    private ImageView imageView;

    /* renamed from: notifyBadge$delegate, reason: from kotlin metadata */
    private final ImageViewProperty notifyBadge;
    private ImageView notifyBadgeIconView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractIconImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
    }

    protected void onImageViewResolved() {
    }

    public /* synthetic */ AbstractIconImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.image = new ImageViewProperty(R$id.left_icon, new Function2<ImageView, Drawable, Unit>() { // from class: ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView$image$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, Drawable drawable) {
                invoke2(imageView, drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageView view, Drawable drawable) {
                Intrinsics.checkNotNullParameter(view, "view");
                AbstractIconImageView abstractIconImageView = this.this$0;
                if (drawable == null) {
                    view = null;
                }
                abstractIconImageView.setImageView(view);
                this.this$0.onImageViewResolved();
                this.this$0.resolveIconShape();
            }
        });
        this.badge = new ImageViewProperty(R$id.badge, new Function2<ImageView, Drawable, Unit>() { // from class: ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView$badge$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, Drawable drawable) {
                invoke2(imageView, drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageView view, Drawable drawable) {
                Intrinsics.checkNotNullParameter(view, "view");
                AbstractIconImageView abstractIconImageView = this.this$0;
                if (drawable == null) {
                    view = null;
                }
                abstractIconImageView.badgeIconView = view;
                this.this$0.resolveIconShape();
            }
        });
        this.notifyBadge = new ImageViewProperty(R$id.notify_badge, new Function2<ImageView, Drawable, Unit>() { // from class: ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView$notifyBadge$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, Drawable drawable) {
                invoke2(imageView, drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageView view, Drawable drawable) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (drawable == null) {
                    this.this$0.notifyBadgeIconView = null;
                } else {
                    this.this$0.notifyBadgeIconView = view;
                }
                this.this$0.resolveIconShape();
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_ListImageView, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.imageSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ym_ListImageView_ym_imageSize, 0);
        this.badgeSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ym_ListImageView_ym_imageBadgeSize, 0);
        this.imageShape = TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_imageShape);
        this.imageShapeWithBrBadge = TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_imageShapeWith_BR_Badge);
        this.imageShapeWithTrBadge = TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_imageShapeWith_TR_Badge);
        this.imageShapeWithTrBrBadge = TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_imageShapeWith_TR_BR_Badge);
        Drawable styleableDrawable = TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_imageBackground);
        if (styleableDrawable != null) {
            ColorStateList backgroundColor = getBackgroundColor();
            if (backgroundColor == null || DrawableExtensions.tint(styleableDrawable, backgroundColor) == null) {
                DrawableExtensions.tint(styleableDrawable, 0);
            }
        } else {
            styleableDrawable = null;
        }
        this.imageBackground = styleableDrawable;
        setImageTintColor(typedArrayObtainStyledAttributes.getColorStateList(R$styleable.ym_ListImageView_ym_imageTintColor));
        setImage(TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_image));
        setBadge(TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_imageBadge));
        setNotifyBadge(TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_ListImageView_ym_imageNotifyBadge));
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_ListImageView_ym_image_enabled, true));
        obtainAttrs(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        setClipToPadding(false);
    }

    protected ColorStateList getImageColor() {
        return this.imageColor;
    }

    protected ColorStateList getBackgroundColor() {
        return this.backgroundColor;
    }

    protected final ImageView getImageView() {
        return this.imageView;
    }

    protected final void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Drawable getImage() {
        return this.image.getValue(this, $$delegatedProperties[0]);
    }

    public void setImage(Drawable drawable) {
        this.image.setValue2(this, $$delegatedProperties[0], drawable);
    }

    public final ColorStateList getImageTintColor() {
        ColorStateList colorStateList = this.imageTintColor;
        return colorStateList == null ? getImageColor() : colorStateList;
    }

    public final void setImageTintColor(ColorStateList colorStateList) {
        this.imageTintColor = colorStateList;
        onImageViewResolved();
        resolveIconShape();
    }

    public final ColorStateList getBackgroundTintColor() {
        ColorStateList colorStateList = this.backgroundTintColor;
        return colorStateList == null ? getBackgroundColor() : colorStateList;
    }

    public final void setBackgroundTintColor(ColorStateList colorStateList) {
        this.backgroundTintColor = colorStateList;
        onImageViewResolved();
        resolveIconShape();
    }

    public final Drawable getBadge() {
        return this.badge.getValue(this, $$delegatedProperties[1]);
    }

    public final void setBadge(Drawable drawable) {
        this.badge.setValue2(this, $$delegatedProperties[1], drawable);
    }

    public final Drawable getNotifyBadge() {
        return this.notifyBadge.getValue(this, $$delegatedProperties[2]);
    }

    public final void setNotifyBadge(Drawable drawable) {
        this.notifyBadge.setValue2(this, $$delegatedProperties[2], drawable);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ImageView imageView = this.imageView;
        if (imageView != null) {
            measureIconView(imageView, this.imageSize);
        }
        ImageView imageView2 = this.badgeIconView;
        if (imageView2 != null) {
            measureIconView(imageView2, this.badgeSize);
        }
        ImageView imageView3 = this.notifyBadgeIconView;
        if (imageView3 != null) {
            measureIconView(imageView3, this.badgeSize);
        }
        setMeasuredDimension(View.resolveSize(Math.max(getPaddingStart() + getPaddingEnd() + this.imageSize, getMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max(getPaddingTop() + getPaddingBottom() + this.imageSize, getMinimumHeight()), heightMeasureSpec));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int paddingStart = getPaddingStart() + this.imageSize;
        int paddingTop = getPaddingTop() + this.imageSize;
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.layout(getPaddingStart(), getPaddingTop(), paddingStart, paddingTop);
        }
        ImageView imageView2 = this.badgeIconView;
        if (imageView2 != null) {
            int i = this.badgeSize;
            imageView2.layout(paddingStart - i, paddingTop - i, paddingStart, paddingTop);
        }
        ImageView imageView3 = this.notifyBadgeIconView;
        if (imageView3 != null) {
            imageView3.layout(paddingStart - this.badgeSize, getPaddingTop(), paddingStart, getPaddingTop() + this.badgeSize);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        resolveIconShape();
    }

    private final void measureIconView(View view, int size) {
        view.measure(View.MeasureSpec.makeMeasureSpec(size, pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH), View.MeasureSpec.makeMeasureSpec(size, pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void resolveIconShape() {
        /*
            r3 = this;
            android.graphics.drawable.Drawable r0 = r3.imageBackground
            android.content.res.ColorStateList r1 = r3.getBackgroundTintColor()
            if (r1 == 0) goto L9
            goto La
        L9:
            r0 = 0
        La:
            if (r0 == 0) goto L1e
            android.content.res.ColorStateList r1 = r3.getBackgroundTintColor()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r3.getColorByState(r1)
            android.graphics.drawable.Drawable r0 = ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions.tint(r0, r1)
            if (r0 == 0) goto L1e
            goto L20
        L1e:
            android.graphics.drawable.Drawable r0 = r3.imageBackground
        L20:
            android.widget.ImageView r1 = r3.imageView
            if (r1 == 0) goto L36
            android.graphics.drawable.Drawable r2 = r3.resolveTintImage()
            android.graphics.drawable.Drawable r2 = r3.cutBadgeIfNeeded(r2)
            r1.setImageDrawable(r2)
            android.graphics.drawable.Drawable r0 = r3.cutBadgeIfNeeded(r0)
            r1.setBackground(r0)
        L36:
            android.widget.ImageView r0 = r3.badgeIconView
            if (r0 == 0) goto L41
            android.graphics.drawable.Drawable r1 = r3.getBadge()
            r0.setImageDrawable(r1)
        L41:
            android.widget.ImageView r0 = r3.notifyBadgeIconView
            if (r0 == 0) goto L4c
            android.graphics.drawable.Drawable r1 = r3.getNotifyBadge()
            r0.setImageDrawable(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView.resolveIconShape():void");
    }

    protected Drawable resolveTintImage() {
        Drawable image = getImage();
        if (getImageTintColor() == null) {
            image = null;
        }
        if (image != null) {
            ColorStateList imageTintColor = getImageTintColor();
            Intrinsics.checkNotNull(imageTintColor);
            Drawable drawableTint = DrawableExtensions.tint(image, getColorByState(imageTintColor));
            if (drawableTint != null) {
                return drawableTint;
            }
        }
        return getImage();
    }

    private final Drawable cutBadgeIfNeeded(Drawable icon) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        if (icon == null) {
            return null;
        }
        if (getBadge() != null && getNotifyBadge() == null && (drawable4 = this.imageShapeWithBrBadge) != null) {
            return cutBackground(icon, drawable4);
        }
        if (getBadge() == null && getNotifyBadge() != null && (drawable3 = this.imageShapeWithTrBadge) != null) {
            return cutBackground(icon, drawable3);
        }
        if (getBadge() == null || getNotifyBadge() == null || (drawable2 = this.imageShapeWithTrBrBadge) == null) {
            return (getBadge() == null && getNotifyBadge() == null && (drawable = this.imageShape) != null) ? cutBackground(icon, drawable) : icon;
        }
        return cutBackground(icon, drawable2);
    }

    private final Drawable cutBackground(Drawable icon, final Drawable bg) {
        return new ShapedDrawable(icon, new Function1<Canvas, Unit>() { // from class: ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView.cutBackground.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                int iAbs = Math.abs(canvas.getWidth() - canvas.getHeight()) / 2;
                if (canvas.getWidth() > canvas.getHeight()) {
                    bg.setBounds(0, 0 - iAbs, canvas.getWidth(), canvas.getHeight() + iAbs);
                } else {
                    bg.setBounds(0 - iAbs, 0, canvas.getWidth() + iAbs, canvas.getHeight());
                }
                bg.draw(canvas);
            }
        });
    }

    /* compiled from: AbstractIconImageView.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B/\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR+\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView$ImageViewProperty;", "Lkotlin/properties/ReadWriteProperty;", "Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "Landroid/graphics/drawable/Drawable;", "", "viewId", "Lkotlin/Function2;", "Landroid/widget/ImageView;", "", "onUpdateView", "<init>", "(ILkotlin/jvm/functions/Function2;)V", "Landroid/content/Context;", "context", "onCreateView", "(Landroid/content/Context;)Landroid/widget/ImageView;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;Lkotlin/reflect/KProperty;)Landroid/graphics/drawable/Drawable;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setValue", "(Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;Lkotlin/reflect/KProperty;Landroid/graphics/drawable/Drawable;)V", "I", "getViewId", "()I", "Lkotlin/jvm/functions/Function2;", "getOnUpdateView", "()Lkotlin/jvm/functions/Function2;", "image", "Landroid/graphics/drawable/Drawable;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class ImageViewProperty implements ReadWriteProperty<AbstractIconImageView, Drawable> {
        private Drawable image;
        private final Function2<ImageView, Drawable, Unit> onUpdateView;
        private final int viewId;

        /* JADX WARN: Multi-variable type inference failed */
        public ImageViewProperty(int i, Function2<? super ImageView, ? super Drawable, Unit> onUpdateView) {
            Intrinsics.checkNotNullParameter(onUpdateView, "onUpdateView");
            this.viewId = i;
            this.onUpdateView = onUpdateView;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
            return getValue((AbstractIconImageView) obj, (KProperty<?>) kProperty);
        }

        @Override // kotlin.properties.ReadWriteProperty
        public /* bridge */ /* synthetic */ void setValue(AbstractIconImageView abstractIconImageView, KProperty kProperty, Drawable drawable) {
            setValue2(abstractIconImageView, (KProperty<?>) kProperty, drawable);
        }

        public Drawable getValue(AbstractIconImageView thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            return this.image;
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(AbstractIconImageView thisRef, KProperty<?> property, Drawable value) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            this.image = value;
            if (value == null) {
                View viewFindViewById = thisRef.findViewById(this.viewId);
                if (viewFindViewById != null) {
                    thisRef.removeView(viewFindViewById);
                    this.onUpdateView.invoke((ImageView) viewFindViewById, this.image);
                    return;
                }
                return;
            }
            ImageView imageViewOnCreateView = (ImageView) thisRef.findViewById(this.viewId);
            if (imageViewOnCreateView == null) {
                Context context = thisRef.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                imageViewOnCreateView = onCreateView(context);
                imageViewOnCreateView.setId(this.viewId);
                thisRef.addView(imageViewOnCreateView, new ViewGroup.LayoutParams(-2, -2));
            }
            this.onUpdateView.invoke(imageViewOnCreateView, this.image);
        }

        private final ImageView onCreateView(Context context) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            return imageView;
        }
    }

    protected final int getColorByState(ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "<this>");
        return colorStateList.getColorForState(new int[]{isEnabled() ? R.attr.state_enabled : -16842910}, 0);
    }
}
