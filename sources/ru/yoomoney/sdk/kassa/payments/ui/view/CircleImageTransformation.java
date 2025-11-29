package ru.yoomoney.sdk.kassa.payments.ui.view;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.utils.icon.Bitmaps;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/view/CircleImageTransformation;", "Lcom/squareup/picasso/Transformation;", "()V", "key", "", "transform", "Landroid/graphics/Bitmap;", "source", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CircleImageTransformation implements Transformation {
    public static final int $stable = 0;

    @Override // com.squareup.picasso.Transformation
    public String key() {
        return "circleImageTransformation";
    }

    @Override // com.squareup.picasso.Transformation
    public Bitmap transform(Bitmap source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Bitmap bitmapCropToCircle = Bitmaps.cropToCircle(source);
        Intrinsics.checkNotNullExpressionValue(bitmapCropToCircle, "cropToCircle(...)");
        source.recycle();
        return bitmapCropToCircle;
    }
}
