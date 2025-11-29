package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.LayoutTextViewWithImageNewBinding;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewWithImageNew.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\b\b\u0001\u0010\u0016\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/sputnik/common/ui/view/TextViewWithImageNew;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/sputnik/common/databinding/LayoutTextViewWithImageNewBinding;", "getBinding", "()Lcom/sputnik/common/databinding/LayoutTextViewWithImageNewBinding;", "setBinding", "(Lcom/sputnik/common/databinding/LayoutTextViewWithImageNewBinding;)V", "getImageView", "Landroid/widget/ImageView;", "setImage", "", "bitmap", "Landroid/graphics/Bitmap;", "setImageColor", RemoteMessageConst.Notification.COLOR, "setTitle", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextViewWithImageNew extends ConstraintLayout {
    private LayoutTextViewWithImageNewBinding binding;

    public /* synthetic */ TextViewWithImageNew(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewWithImageNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutTextViewWithImageNewBinding layoutTextViewWithImageNewBindingInflate = LayoutTextViewWithImageNewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(layoutTextViewWithImageNewBindingInflate, "inflate(...)");
        this.binding = layoutTextViewWithImageNewBindingInflate;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.TextViewWithImage, 0, 0);
        try {
            this.binding.tvNumber.setText(typedArrayObtainStyledAttributes.getString(R$styleable.TextViewWithImage_android_text));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final LayoutTextViewWithImageNewBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(LayoutTextViewWithImageNewBinding layoutTextViewWithImageNewBinding) {
        Intrinsics.checkNotNullParameter(layoutTextViewWithImageNewBinding, "<set-?>");
        this.binding = layoutTextViewWithImageNewBinding;
    }

    public final void setTitle(String title) {
        this.binding.tvNumber.setText(title);
    }

    public final ImageView getImageView() {
        ImageView ivIcon = this.binding.ivIcon;
        Intrinsics.checkNotNullExpressionValue(ivIcon, "ivIcon");
        return ivIcon;
    }

    public final void setImage(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.binding.ivIcon.setImageBitmap(bitmap);
    }

    public final void setImageColor(int color) {
        this.binding.ivIcon.setColorFilter(color);
    }
}
