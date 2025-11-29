package spay.sdk.utils.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lspay/sdk/utils/receiver/OtpReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "a", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class OtpReceiver extends BroadcastReceiver {
    public a a;

    public interface a {
        void a();

        void a(Intent intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Object parcelable;
        Status status;
        a aVar;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getAction() == SmsRetriever.SMS_RETRIEVED_ACTION) {
            Bundle extras = intent.getExtras();
            if (Build.VERSION.SDK_INT >= 33) {
                if (extras != null) {
                    parcelable = extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_STATUS", Status.class);
                    status = (Status) parcelable;
                }
                status = null;
            } else {
                if (extras != null) {
                    parcelable = extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                    status = (Status) parcelable;
                }
                status = null;
            }
            Integer numValueOf = status != null ? Integer.valueOf(status.getStatusCode()) : null;
            if (numValueOf != null && numValueOf.intValue() == 0) {
                Intent intent2 = extras != null ? (Intent) extras.getParcelable(SmsRetriever.EXTRA_CONSENT_INTENT) : null;
                a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.a(intent2);
                    return;
                }
                return;
            }
            if (numValueOf == null || numValueOf.intValue() != 15 || (aVar = this.a) == null) {
                return;
            }
            aVar.a();
        }
    }
}
