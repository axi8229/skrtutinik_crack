package ru.yoomoney.sdk.auth.passport.adapter;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.passport.adapter.item.SocialAccountListItem;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"diffCallback", "ru/yoomoney/sdk/auth/passport/adapter/SocialAccountListAdapterKt$diffCallback$1", "Lru/yoomoney/sdk/auth/passport/adapter/SocialAccountListAdapterKt$diffCallback$1;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialAccountListAdapterKt {
    private static final SocialAccountListAdapterKt$diffCallback$1 diffCallback = new DiffUtil.ItemCallback<SocialAccountListItem>() { // from class: ru.yoomoney.sdk.auth.passport.adapter.SocialAccountListAdapterKt$diffCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(SocialAccountListItem oldItem, SocialAccountListItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(SocialAccountListItem oldItem, SocialAccountListItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getOauthService() == newItem.getOauthService() && oldItem.getTitle() == newItem.getTitle();
        }
    };
}
