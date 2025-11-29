package ru.yoomoney.sdk.two_fa.di;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmInteractor;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractor;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmInteractor;

/* compiled from: TwoFaActivityComponent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/two_fa/di/TwoFaActivityComponent;", "", "getEmailConfirmInteractor", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;", "getEntryPointInteractor", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;", "getPhoneCallInteractor", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "getSmsConfirmInteractor", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;", "Builder", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface TwoFaActivityComponent {

    /* compiled from: TwoFaActivityComponent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/two_fa/di/TwoFaActivityComponent$Builder;", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lru/yoomoney/sdk/two_fa/di/TwoFaActivityComponent;", "config", "Lru/yoomoney/sdk/two_fa/Config;", "context", "Landroid/content/Context;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        TwoFaActivityComponent build();

        Builder config(Config config);

        Builder context(Context context);
    }

    EmailConfirmInteractor getEmailConfirmInteractor();

    EntryPointInteractor getEntryPointInteractor();

    PhoneCallInteractor getPhoneCallInteractor();

    SmsConfirmInteractor getSmsConfirmInteractor();
}
