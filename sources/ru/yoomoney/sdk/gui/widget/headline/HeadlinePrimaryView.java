package ru.yoomoney.sdk.gui.widget.headline;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$styleable;

/* compiled from: HeadlinePrimaryView.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/gui/widget/headline/HeadlinePrimaryView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class HeadlinePrimaryView extends AppCompatTextView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadlinePrimaryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HeadlinePrimaryView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_HeadlinePrimary_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadlinePrimaryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(80);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_HeadLine, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ym_HeadLine_ym_HeadlineHeight, 0);
        if (dimensionPixelSize > 0) {
            setMinHeight(dimensionPixelSize);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.ym_HeadLine_ym_HeadlineAppearance, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this, resourceId);
        }
        setMaxLines(typedArrayObtainStyledAttributes.getInteger(R$styleable.ym_HeadLine_ym_HeadlineTitleMaxLines, Integer.MAX_VALUE));
    }
}
