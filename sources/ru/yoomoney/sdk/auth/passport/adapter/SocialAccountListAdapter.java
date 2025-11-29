package ru.yoomoney.sdk.auth.passport.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.passport.adapter.item.SocialAccountListItem;
import ru.yoomoney.sdk.gui.widgetV2.list.item_tag.ItemImageTagView;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/passport/adapter/SocialAccountListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/yoomoney/sdk/auth/passport/adapter/item/SocialAccountListItem;", "Lru/yoomoney/sdk/auth/passport/adapter/SocialAccountListViewHolder;", "onItemClick", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialAccountListAdapter extends ListAdapter<SocialAccountListItem, SocialAccountListViewHolder> {
    private final Function2<OauthServiceProvider, Boolean, Unit> onItemClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SocialAccountListAdapter(Function2<? super OauthServiceProvider, ? super Boolean, Unit> onItemClick) {
        super(SocialAccountListAdapterKt.diffCallback);
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SocialAccountListViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SocialAccountListItem item = getItem(position);
        Intrinsics.checkNotNull(item);
        holder.bind(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SocialAccountListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ItemImageTagView itemImageTagView = new ItemImageTagView(context, null, 0, 6, null);
        itemImageTagView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        return new SocialAccountListViewHolder(itemImageTagView, this.onItemClick);
    }
}
