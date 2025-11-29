package ru.yoomoney.sdk.auth.passport.adapter;

import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.passport.adapter.item.SocialAccountListItem;
import ru.yoomoney.sdk.auth.utils.PaddingItemDecoration;
import ru.yoomoney.sdk.gui.widgetV2.list.item_tag.ItemImageTagView;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/passport/adapter/SocialAccountListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/yoomoney/sdk/auth/utils/PaddingItemDecoration$Separated;", "view", "Lru/yoomoney/sdk/gui/widgetV2/list/item_tag/ItemImageTagView;", "onItemClick", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "", "", "(Lru/yoomoney/sdk/gui/widgetV2/list/item_tag/ItemImageTagView;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "Lru/yoomoney/sdk/auth/passport/adapter/item/SocialAccountListItem;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialAccountListViewHolder extends RecyclerView.ViewHolder implements PaddingItemDecoration.Separated {
    private final Function2<OauthServiceProvider, Boolean, Unit> onItemClick;
    private final ItemImageTagView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SocialAccountListViewHolder(ItemImageTagView view, Function2<? super OauthServiceProvider, ? super Boolean, Unit> onItemClick) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.view = view;
        this.onItemClick = onItemClick;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(SocialAccountListViewHolder this$0, SocialAccountListItem item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onItemClick.invoke(item.getOauthService(), Boolean.valueOf(item.getOauthServiceLinked()));
    }

    public final void bind(final SocialAccountListItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemImageTagView itemImageTagView = this.view;
        itemImageTagView.setLeftImage(AppCompatResources.getDrawable(itemImageTagView.getContext(), item.getIcon()));
        itemImageTagView.setTitle(itemImageTagView.getResources().getString(item.getTitle()));
        itemImageTagView.setTag((CharSequence) itemImageTagView.getResources().getString(item.getTag()));
        itemImageTagView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.passport.adapter.SocialAccountListViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SocialAccountListViewHolder.bind$lambda$1$lambda$0(this.f$0, item, view);
            }
        });
    }
}
