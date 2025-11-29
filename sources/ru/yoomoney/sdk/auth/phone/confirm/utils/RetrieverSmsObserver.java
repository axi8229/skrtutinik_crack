package ru.yoomoney.sdk.auth.phone.confirm.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.phone.confirm.utils.SmsObserver;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/utils/RetrieverSmsObserver;", "Landroid/content/BroadcastReceiver;", "Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver$Listener;", "getListener", "()Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver$Listener;", "setListener", "(Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver$Listener;)V", "registered", "", "smsParser", "Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsParser;", "init", "", "parser", "onReceive", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "startObserver", "stopObserver", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RetrieverSmsObserver extends BroadcastReceiver implements SmsObserver {
    private final Context context;
    private SmsObserver.Listener listener;
    private boolean registered;
    private SmsParser smsParser;

    public RetrieverSmsObserver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.utils.SmsObserver
    public SmsObserver.Listener getListener() {
        return this.listener;
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.utils.SmsObserver
    public void init(SmsParser parser) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.smsParser = parser;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SmsObserver.Listener listener;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(SmsRetriever.SMS_RETRIEVED_ACTION, intent.getAction())) {
            SmsParser smsParser = this.smsParser;
            if (smsParser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smsParser");
                smsParser = null;
            }
            String str = smsParser.parse(intent.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE));
            if (str == null || (listener = getListener()) == null) {
                return;
            }
            listener.onSmsAnswer(str);
        }
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.utils.SmsObserver
    public void setListener(SmsObserver.Listener listener) {
        this.listener = listener;
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.utils.SmsObserver
    public void startObserver() {
        ContextCompat.registerReceiver(this.context, this, new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION), 4);
        this.registered = true;
        SmsRetriever.getClient(this.context).startSmsRetriever();
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.utils.SmsObserver
    public void stopObserver() {
        if (this.registered) {
            this.context.unregisterReceiver(this);
            this.registered = false;
        }
    }
}
