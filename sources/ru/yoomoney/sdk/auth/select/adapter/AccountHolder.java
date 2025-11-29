package ru.yoomoney.sdk.auth.select.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.ui.ItemImageRoundIconServicesView;
import ru.yoomoney.sdk.auth.utils.PaddingItemDecoration;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/select/adapter/AccountHolder;", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountViewHolder;", "Lru/yoomoney/sdk/auth/select/adapter/AccountItem;", "Lru/yoomoney/sdk/auth/utils/PaddingItemDecoration$Separated;", "view", "Lru/yoomoney/sdk/auth/ui/ItemImageRoundIconServicesView;", "(Lru/yoomoney/sdk/auth/ui/ItemImageRoundIconServicesView;)V", "bind", "", "item", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountHolder extends SelectAccountViewHolder<AccountItem> implements PaddingItemDecoration.Separated {
    private final ItemImageRoundIconServicesView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountHolder(ItemImageRoundIconServicesView view) {
        super(view, null);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // ru.yoomoney.sdk.auth.select.adapter.SelectAccountViewHolder
    public void bind(AccountItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Account account = item.getAccount();
        this.view.setTitle(account.getTitle());
        ItemImageRoundIconServicesView itemImageRoundIconServicesView = this.view;
        String logoUrl = account.getLogoUrl();
        if (logoUrl == null) {
            logoUrl = "";
        }
        itemImageRoundIconServicesView.setLeftImageUrl(logoUrl);
        if (item.getShowServices()) {
            this.view.setServices(account.getServices());
        }
    }
}
