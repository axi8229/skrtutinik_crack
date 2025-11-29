package ru.yoomoney.sdk.gui.widget.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.drawable.TagDrawable;
import ru.yoomoney.sdk.gui.gui.R$attr;

/* compiled from: TagButtonView.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0004¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/gui/widget/button/TagButtonView;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAttrBackground", "Landroid/graphics/drawable/Drawable;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class TagButtonView extends AppCompatButton {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TagButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TagButtonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_TagButton_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        if (getAttrBackground(attributeSet) == null) {
            setBackground(ButtonUtilsKt.getTagButtonBackground$default(context, new Function1<Integer, Drawable>() { // from class: ru.yoomoney.sdk.gui.widget.button.TagButtonView.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Drawable invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Drawable invoke(int i2) {
                    return new TagDrawable(i2);
                }
            }, 0, null, 12, null));
        }
    }

    protected final Drawable getAttrBackground(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, new int[]{R.attr.background});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }
}
