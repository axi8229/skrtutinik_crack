package ru.yoomoney.sdk.auth.passport;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.passport.domain.OauthServiceProviderType;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\n"}, d2 = {"createOpenSocialAccountDialog", "Lru/yoomoney/sdk/auth/ui/AlertDialog;", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "oauthServiceProviderType", "Lru/yoomoney/sdk/auth/passport/domain/OauthServiceProviderType;", "toSocialAccountName", "", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PresentationExtensionKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OauthServiceProviderType.values().length];
            try {
                iArr[OauthServiceProviderType.SBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OauthServiceProviderType.VK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OauthServiceProviderType.ESIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final AlertDialog createOpenSocialAccountDialog(Context context, FragmentManager fragmentManager, OauthServiceProviderType oauthServiceProviderType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(oauthServiceProviderType, "oauthServiceProviderType");
        return AlertDialog.INSTANCE.create(fragmentManager, new YmAlertDialog.DialogContent(null, context.getString(R.string.auth_social_account_dialog_title, toSocialAccountName(oauthServiceProviderType, context)), context.getString(R.string.auth_social_account_dialog_positive_button), context.getString(R.string.auth_social_account_dialog_negative_button), false, true, 17, null));
    }

    private static final String toSocialAccountName(OauthServiceProviderType oauthServiceProviderType, Context context) {
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[oauthServiceProviderType.ordinal()];
        if (i2 == 1) {
            i = R.string.auth_social_account_sber;
        } else if (i2 == 2) {
            i = R.string.auth_social_account_vk;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.auth_social_account_esia;
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
