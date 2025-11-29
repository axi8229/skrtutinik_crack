package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.api.account.model.Service;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widgetV2.image.IconImageRoundView;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\r\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0012\u001a\u0004\u0018\u00010\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/auth/ui/ItemImageRoundIconServicesView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "holder", "Landroid/graphics/drawable/Drawable;", "holderBackground", "imageLoaderTarget", "ru/yoomoney/sdk/auth/ui/ItemImageRoundIconServicesView$imageLoaderTarget$1", "Lru/yoomoney/sdk/auth/ui/ItemImageRoundIconServicesView$imageLoaderTarget$1;", "leftIconSize", "leftIconView", "Lru/yoomoney/sdk/gui/widgetV2/image/IconImageRoundView;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "leftImageUrl", "getLeftImageUrl", "()Ljava/lang/String;", "setLeftImageUrl", "(Ljava/lang/String;)V", "", "Lru/yoomoney/sdk/auth/api/account/model/Service;", "services", "getServices", "()Ljava/util/List;", "setServices", "(Ljava/util/List;)V", "servicesView", "Lru/yoomoney/sdk/auth/ui/ServicesAvatarView;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "titleMargins", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ItemImageRoundIconServicesView extends ConstraintLayout {
    private final Drawable holder;
    private final Drawable holderBackground;
    private final ItemImageRoundIconServicesView$imageLoaderTarget$1 imageLoaderTarget;
    private final int leftIconSize;
    private final IconImageRoundView leftIconView;
    private String leftImageUrl;
    private List<Service> services;
    private final ServicesAvatarView servicesView;
    private final int titleMargins;
    private final TextBodyView titleView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemImageRoundIconServicesView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final String getLeftImageUrl() {
        return this.leftImageUrl;
    }

    public final List<Service> getServices() {
        return this.services;
    }

    public final CharSequence getTitle() {
        return this.titleView.getText();
    }

    public final void setLeftImageUrl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Picasso.get().load(Uri.parse(value)).into(this.imageLoaderTarget);
    }

    public final void setServices(List<Service> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.servicesView.setVisibility(!value.isEmpty() ? 0 : 8);
        this.servicesView.setServices(value);
    }

    public final void setTitle(CharSequence charSequence) {
        this.titleView.setText(charSequence);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemImageRoundIconServicesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v12, types: [ru.yoomoney.sdk.auth.ui.ItemImageRoundIconServicesView$imageLoaderTarget$1] */
    public ItemImageRoundIconServicesView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.list_item_icon_size);
        this.leftIconSize = dimensionPixelSize;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ym_spaceM);
        this.titleMargins = dimensionPixelSize2;
        Drawable drawableTint = null;
        TextBodyView textBodyView = new TextBodyView(context, null, 0, 6, null);
        textBodyView.setId(ItemImageRoundIconServicesViewKt.ID_TITLE);
        textBodyView.setLayoutParams(new ConstraintLayout.LayoutParams(0, -2));
        textBodyView.setEllipsize(TextUtils.TruncateAt.END);
        textBodyView.setMaxLines(1);
        this.titleView = textBodyView;
        IconImageRoundView iconImageRoundView = new IconImageRoundView(context, null, 0, 6, null);
        iconImageRoundView.setId(ItemImageRoundIconServicesViewKt.ID_LEFT_ICON);
        iconImageRoundView.setLayoutParams(new ConstraintLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        this.leftIconView = iconImageRoundView;
        ServicesAvatarView servicesAvatarView = new ServicesAvatarView(context, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        servicesAvatarView.setId(ItemImageRoundIconServicesViewKt.ID_SERVICES);
        servicesAvatarView.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.servicesView = servicesAvatarView;
        Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.ic_round_mask);
        this.holderBackground = drawable != null ? DrawableExtensions.tint(drawable, ColorScheme.INSTANCE.getSecondaryGhostColor(context)) : null;
        Drawable drawable2 = AppCompatResources.getDrawable(context, R.drawable.auth_ic_contact_l);
        if (drawable2 != null) {
            ColorScheme colorScheme = ColorScheme.INSTANCE;
            Integer thirdAccentColor = colorScheme.getThirdAccentColor();
            drawableTint = DrawableExtensions.tint(drawable2, thirdAccentColor != null ? thirdAccentColor.intValue() : colorScheme.getAccentFadeColor(context));
        }
        this.holder = drawableTint;
        this.imageLoaderTarget = new Target() { // from class: ru.yoomoney.sdk.auth.ui.ItemImageRoundIconServicesView$imageLoaderTarget$1
            @Override // com.squareup.picasso.Target
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                Intrinsics.checkNotNullParameter(e, "e");
            }

            @Override // com.squareup.picasso.Target
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                Intrinsics.checkNotNullParameter(from, "from");
                IconImageRoundView iconImageRoundView2 = this.this$0.leftIconView;
                iconImageRoundView2.setBackground(null);
                iconImageRoundView2.setImage(new BitmapDrawable(iconImageRoundView2.getResources(), bitmap));
            }

            @Override // com.squareup.picasso.Target
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                IconImageRoundView iconImageRoundView2 = this.this$0.leftIconView;
                ItemImageRoundIconServicesView itemImageRoundIconServicesView = this.this$0;
                iconImageRoundView2.setBackground(itemImageRoundIconServicesView.holderBackground);
                iconImageRoundView2.setImage(itemImageRoundIconServicesView.holder);
            }
        };
        this.leftImageUrl = "";
        this.services = CollectionsKt.emptyList();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackground(AppCompatResources.getDrawable(context, R.drawable.bg_selectable_item));
        addView(textBodyView);
        addView(iconImageRoundView);
        addView(servicesAvatarView);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_LEFT_ICON, 6, 0, 6);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_LEFT_ICON, 3, 0, 3);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_LEFT_ICON, 4, 0, 4);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_TITLE, 3, 0, 3);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_TITLE, 4, 0, 4);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_TITLE, 6, ItemImageRoundIconServicesViewKt.ID_LEFT_ICON, 7, dimensionPixelSize2);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_TITLE, 7, ItemImageRoundIconServicesViewKt.ID_SERVICES, 6, dimensionPixelSize2);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_SERVICES, 3, 0, 3);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_SERVICES, 4, 0, 4);
        constraintSet.connect(ItemImageRoundIconServicesViewKt.ID_SERVICES, 7, 0, 7);
        constraintSet.applyTo(this);
    }

    public /* synthetic */ ItemImageRoundIconServicesView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListItemIcon_Style : i);
    }
}
