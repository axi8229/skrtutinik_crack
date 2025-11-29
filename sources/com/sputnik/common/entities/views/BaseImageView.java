package com.sputnik.common.entities.views;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sputnik.common.R$drawable;
import com.sputnik.common.entities.views.BaseView;
import com.sputnik.common.utils.DpUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseImageView.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/sputnik/common/entities/views/BaseImageView;", "Lcom/sputnik/common/entities/views/BaseView;", "imageResource", "", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getView", "Landroid/view/View;", "layoutInflater", "Landroid/view/LayoutInflater;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseImageView extends BaseView {
    private final Integer imageResource;

    public BaseImageView(Integer num) {
        super(BaseView.Types.image);
        this.imageResource = num;
    }

    @Override // com.sputnik.common.entities.views.BaseView
    public View getView(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        ImageView imageView = new ImageView(layoutInflater.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAdjustViewBounds(true);
        imageView.setBackgroundResource(R$drawable.background_image_round);
        imageView.setClipToOutline(true);
        Integer num = this.imageResource;
        if (num != null) {
            imageView.setImageResource(num.intValue());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        Resources resources = imageView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        int iConvertPxToDb = DpUtilsKt.convertPxToDb(16.0f, resources);
        Resources resources2 = imageView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        int iConvertPxToDb2 = DpUtilsKt.convertPxToDb(20.0f, resources2);
        layoutParams.setMargins(iConvertPxToDb2, iConvertPxToDb, iConvertPxToDb2, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
