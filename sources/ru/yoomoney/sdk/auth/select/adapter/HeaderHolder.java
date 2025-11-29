package ru.yoomoney.sdk.auth.select.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.widget.headline.HeadlinePrimaryLargeView;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/select/adapter/HeaderHolder;", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountViewHolder;", "Lru/yoomoney/sdk/auth/select/adapter/HeaderItem;", "view", "Lru/yoomoney/sdk/gui/widget/headline/HeadlinePrimaryLargeView;", "(Lru/yoomoney/sdk/gui/widget/headline/HeadlinePrimaryLargeView;)V", "bind", "", "item", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HeaderHolder extends SelectAccountViewHolder<HeaderItem> {
    private final HeadlinePrimaryLargeView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderHolder(HeadlinePrimaryLargeView view) {
        super(view, null);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // ru.yoomoney.sdk.auth.select.adapter.SelectAccountViewHolder
    public void bind(HeaderItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.view.setText(item.getTitle());
    }
}
