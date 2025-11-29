package ru.yoomoney.sdk.auth.passport.adapter.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.api.account.model.SocialAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u00020\r2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/adapter/item/SocialAccountResourceManager;", "", "()V", "createList", "", "Lru/yoomoney/sdk/auth/passport/adapter/item/SocialAccountListItem;", "socialAccounts", "Lru/yoomoney/sdk/auth/api/account/model/SocialAccount;", "availableSocialAccounts", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "getActionResId", "", "serviceLinked", "", "isServiceLinked", "service", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialAccountResourceManager {
    public static final SocialAccountResourceManager INSTANCE = new SocialAccountResourceManager();

    private SocialAccountResourceManager() {
    }

    private final int getActionResId(boolean serviceLinked) {
        return serviceLinked ? R.string.auth_passport_profile_social_account_unlink_action : R.string.auth_passport_profile_social_account_link_action;
    }

    private final boolean isServiceLinked(List<SocialAccount> socialAccounts, OauthServiceProvider service) {
        Object obj = null;
        if (socialAccounts != null) {
            Iterator<T> it = socialAccounts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SocialAccount) next).getService() == service) {
                    obj = next;
                    break;
                }
            }
            obj = (SocialAccount) obj;
        }
        return obj != null;
    }

    public final List<SocialAccountListItem> createList(List<SocialAccount> socialAccounts, List<? extends OauthServiceProvider> availableSocialAccounts) {
        ArrayList arrayList = new ArrayList();
        OauthServiceProvider oauthServiceProvider = OauthServiceProvider.SBER;
        boolean zIsServiceLinked = isServiceLinked(socialAccounts, oauthServiceProvider);
        OauthServiceProvider oauthServiceProvider2 = OauthServiceProvider.VK;
        boolean zIsServiceLinked2 = isServiceLinked(socialAccounts, oauthServiceProvider2);
        OauthServiceProvider oauthServiceProvider3 = OauthServiceProvider.ESIA;
        boolean zIsServiceLinked3 = isServiceLinked(socialAccounts, oauthServiceProvider3);
        arrayList.add(new SocialAccountListItem(oauthServiceProvider, zIsServiceLinked, R.drawable.ic_sber_logo, R.string.auth_social_account_name_sber_id, getActionResId(zIsServiceLinked)));
        arrayList.add(new SocialAccountListItem(oauthServiceProvider2, zIsServiceLinked2, R.drawable.ic_vk_logo, R.string.auth_social_account_name_vk_id, getActionResId(zIsServiceLinked2)));
        arrayList.add(new SocialAccountListItem(oauthServiceProvider3, zIsServiceLinked3, R.drawable.ic_esia_logo, R.string.auth_social_account_name_esia, getActionResId(zIsServiceLinked3)));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            SocialAccountListItem socialAccountListItem = (SocialAccountListItem) obj;
            if (availableSocialAccounts != null && availableSocialAccounts.contains(socialAccountListItem.getOauthService())) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
