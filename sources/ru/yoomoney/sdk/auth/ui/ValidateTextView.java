package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/ui/ValidateTextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disableColor", "enableColor", "enableIconColor", RemoteMessageConst.Notification.ICON, "Landroid/graphics/drawable/Drawable;", "iconView", "Landroid/widget/ImageView;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "setEnabled", "", "enabled", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidateTextView extends LinearLayout {
    private final int disableColor;
    private final int enableColor;
    private final int enableIconColor;
    private final Drawable icon;
    private final ImageView iconView;
    private final TextBodyView titleView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ValidateTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final CharSequence getTitle() {
        return this.titleView.getText();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        Drawable drawable;
        int i;
        super.setEnabled(enabled);
        this.titleView.setTextColor(enabled ? this.enableColor : this.disableColor);
        if (enabled) {
            drawable = this.icon;
            i = this.enableIconColor;
        } else {
            drawable = this.icon;
            i = this.disableColor;
        }
        this.iconView.setImageDrawable(DrawableExtensions.tint(drawable, i));
    }

    public final void setTitle(CharSequence charSequence) {
        this.titleView.setText(charSequence);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ValidateTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValidateTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.enableColor = ContextCompat.getColor(context, R.color.color_type_primary);
        this.enableIconColor = ColorScheme.INSTANCE.getAccentColor(context);
        int color = ContextCompat.getColor(context, R.color.color_type_secondary);
        this.disableColor = color;
        Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.ic_apply_m);
        if (drawable == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        this.icon = drawable;
        setOrientation(0);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(DrawableExtensions.tint(drawable, color));
        addView(imageView);
        this.iconView = imageView;
        TextBodyView textBodyView = new TextBodyView(context, null, 0, 6, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMarginStart(textBodyView.getResources().getDimensionPixelSize(R.dimen.ym_spaceXS));
        layoutParams.gravity = 16;
        Unit unit = Unit.INSTANCE;
        addView(textBodyView, layoutParams);
        this.titleView = textBodyView;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ym_ListItem, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setTitle(typedArrayObtainStyledAttributes.getText(R.styleable.ym_ListItem_ym_title));
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.ym_ListItem_ym_item_enabled, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ ValidateTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
