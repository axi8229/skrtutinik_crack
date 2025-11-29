package ru.yoomoney.sdk.auth.phone.countries.adapter;

import android.content.Context;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.utils.PaddingItemDecoration;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/adapter/PhoneCountriesHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/yoomoney/sdk/auth/utils/PaddingItemDecoration$Separated;", "view", "Lru/yoomoney/sdk/gui/widgetV2/list/item_icon/ItemIconView;", "(Lru/yoomoney/sdk/gui/widgetV2/list/item_icon/ItemIconView;)V", "bind", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "isSelected", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneCountriesHolder extends RecyclerView.ViewHolder implements PaddingItemDecoration.Separated {
    private final ItemIconView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneCountriesHolder(ItemIconView view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    public final void bind(String title, boolean isSelected) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.view.setTitle(title);
        ItemIconView itemIconView = this.view;
        itemIconView.setIcon(isSelected ? AppCompatResources.getDrawable(itemIconView.getContext(), R.drawable.ic_apply_m) : null);
        ItemIconView itemIconView2 = this.view;
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Context context = itemIconView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        itemIconView2.setRightIconTint(colorScheme.typeColorStateList(context));
    }
}
