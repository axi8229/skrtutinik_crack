package ru.yoomoney.sdk.auth.select.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.utils.PaddingItemDecoration;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemImageRoundDetailView;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/select/adapter/NewAccountHolder;", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountViewHolder;", "Lru/yoomoney/sdk/auth/select/adapter/NewAccountItem;", "Lru/yoomoney/sdk/auth/utils/PaddingItemDecoration$Separated;", "view", "Lru/yoomoney/sdk/gui/widgetV2/list/item_detail/ItemImageRoundDetailView;", "(Lru/yoomoney/sdk/gui/widgetV2/list/item_detail/ItemImageRoundDetailView;)V", "bind", "", "item", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewAccountHolder extends SelectAccountViewHolder<NewAccountItem> implements PaddingItemDecoration.Separated {
    private final ItemImageRoundDetailView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewAccountHolder(ItemImageRoundDetailView view) {
        super(view, null);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // ru.yoomoney.sdk.auth.select.adapter.SelectAccountViewHolder
    public void bind(NewAccountItem item) {
        Drawable drawableTint;
        Intrinsics.checkNotNullParameter(item, "item");
        Context context = this.view.getContext();
        Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.ic_round_mask);
        View viewFindViewById = this.view.findViewById(R.id.left_image_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View view = (View) SequencesKt.first(ViewGroupKt.getChildren((ViewGroup) viewFindViewById));
        Drawable drawableTint2 = null;
        if (drawable != null) {
            ColorScheme colorScheme = ColorScheme.INSTANCE;
            Intrinsics.checkNotNull(context);
            drawableTint = DrawableExtensions.tint(drawable, colorScheme.backgroundStateList(context));
        } else {
            drawableTint = null;
        }
        view.setBackground(drawableTint);
        Drawable drawable2 = AppCompatResources.getDrawable(context, R.drawable.auth_ic_socialnetworks_l);
        if (drawable2 != null) {
            Integer thirdAccentColor = ColorScheme.INSTANCE.getThirdAccentColor();
            drawableTint2 = DrawableExtensions.tint(drawable2, thirdAccentColor != null ? thirdAccentColor.intValue() : ContextCompat.getColor(context, R.color.color_type_primary_inverse));
        }
        this.view.setLeftImage(drawableTint2);
        this.view.setTitle(context.getText(R.string.auth_select_account_create_new_account));
    }
}
