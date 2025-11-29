package sputnik.axmor.com.sputnik.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewBindingUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\b\u0010\u0007\u001a'\u0010\t\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroid/widget/ImageView;", "", "imageUrl", "Landroid/graphics/drawable/Drawable;", "placeholder", "", "setCircleImageUrlWithPlaceHolder", "(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "setCircleImageUrlSquareWithPlaceHolder", "setRectangleImageUrlWithPlaceHolder", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewBindingUtilsKt {
    public static final void setCircleImageUrlWithPlaceHolder(ImageView imageView, String str, Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str != null) {
            Glide.with(imageView).load(str).dontAnimate().dontTransform().circleCrop().placeholder(drawable).into(imageView);
        } else if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static final void setCircleImageUrlSquareWithPlaceHolder(ImageView imageView, String str, Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str != null) {
            Glide.with(imageView).load(str).dontAnimate().dontTransform().transform(new CenterCrop(), new RoundedCorners(16)).placeholder(drawable).into(imageView);
        } else if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static final void setRectangleImageUrlWithPlaceHolder(final ImageView imageView, String str, Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str != null) {
            Glide.with(imageView).load(str).dontAnimate().transform(new RoundedCorners(40)).placeholder(drawable).addListener(new RequestListener<Drawable>() { // from class: sputnik.axmor.com.sputnik.utils.ViewBindingUtilsKt.setRectangleImageUrlWithPlaceHolder.1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    return false;
                }
            }).into(imageView);
        } else if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }
}
