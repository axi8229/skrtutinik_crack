package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$color;
import com.sputnik.common.R$styleable;
import com.sputnik.common.databinding.LayoutTextViewWithPointBinding;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.DpUtilsKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewWithPoint.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\rJ\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\rJ\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/common/ui/view/TextViewWithPoint;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", RemoteMessageConst.Notification.COLOR, "", "setPointColor", "(I)V", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "setTitle", "(Ljava/lang/String;)V", "", "enabled", "setPointEnabled", "(Z)V", "resId", "setSpecialIcon", "setTextColor", "", "p", "setImagePadding", "(F)V", "Lcom/sputnik/common/databinding/LayoutTextViewWithPointBinding;", "binding", "Lcom/sputnik/common/databinding/LayoutTextViewWithPointBinding;", "getBinding", "()Lcom/sputnik/common/databinding/LayoutTextViewWithPointBinding;", "setBinding", "(Lcom/sputnik/common/databinding/LayoutTextViewWithPointBinding;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextViewWithPoint extends ConstraintLayout {
    private LayoutTextViewWithPointBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextViewWithPoint(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TextViewWithPoint(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewWithPoint(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutTextViewWithPointBinding layoutTextViewWithPointBindingInflate = LayoutTextViewWithPointBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(layoutTextViewWithPointBindingInflate, "inflate(...)");
        this.binding = layoutTextViewWithPointBindingInflate;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.TextViewWithPoint, 0, 0);
        try {
            this.binding.ivIcon.setBackgroundTintList(ColorStateList.valueOf(typedArrayObtainStyledAttributes.getColor(R$styleable.TextViewWithPoint_pointColor, ContextCompat.getColor(context, R$color.sputnik_pink))));
            if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextViewWithPoint_pointEnabled, false)) {
                ImageView imageView = this.binding.ivIcon;
                Intrinsics.checkNotNull(imageView);
                ViewKt.visible(imageView);
            } else {
                ImageView ivIcon = this.binding.ivIcon;
                Intrinsics.checkNotNullExpressionValue(ivIcon, "ivIcon");
                ViewKt.gone(ivIcon);
            }
            this.binding.tvNumber.setText(typedArrayObtainStyledAttributes.getString(R$styleable.TextViewWithPoint_android_text));
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final LayoutTextViewWithPointBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(LayoutTextViewWithPointBinding layoutTextViewWithPointBinding) {
        Intrinsics.checkNotNullParameter(layoutTextViewWithPointBinding, "<set-?>");
        this.binding = layoutTextViewWithPointBinding;
    }

    public final void setPointColor(int color) {
        this.binding.ivIcon.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), color)));
    }

    public final void setTitle(String title) {
        this.binding.tvNumber.setText(title);
    }

    public final void setPointEnabled(boolean enabled) {
        if (enabled) {
            ImageView imageView = this.binding.ivIcon;
            Intrinsics.checkNotNull(imageView);
            ViewKt.visible(imageView);
        } else {
            ImageView ivIcon = this.binding.ivIcon;
            Intrinsics.checkNotNullExpressionValue(ivIcon, "ivIcon");
            ViewKt.gone(ivIcon);
        }
    }

    public final void setSpecialIcon(int resId) {
        this.binding.ivSpecialIcon.setImageResource(resId);
    }

    public final void setTextColor(int color) {
        this.binding.tvNumber.setTextColor(color);
    }

    public final void setImagePadding(float p) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        int iConvertPxToDb = DpUtilsKt.convertPxToDb(p, resources);
        this.binding.ivIcon.setPadding(iConvertPxToDb, iConvertPxToDb, iConvertPxToDb, iConvertPxToDb);
    }
}
