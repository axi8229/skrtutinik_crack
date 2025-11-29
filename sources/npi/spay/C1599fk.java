package npi.spay;

import android.util.Log;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* renamed from: npi.spay.fk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1599fk extends Timber.DebugTree {
    public static final List a = CollectionsKt.listOf((Object[]) new String[]{"authCode", "clientId", "dynatraceApplicationId", "client_id"});

    @Override // timber.log.Timber.DebugTree, timber.log.Timber.Tree
    public final void log(int i, String str, String message, Throwable th) {
        int iMin;
        Intrinsics.checkNotNullParameter(message, "message");
        for (String str2 : a) {
            message = new Regex("\"?" + str2 + "\"?.*?[&,]").replace(message, "\"" + str2 + "\":\"***\"");
        }
        String str3 = "SPAY_SDK " + str;
        if (message.length() < 4000) {
            if (i == 7) {
                Log.wtf(str3, message);
                return;
            } else {
                Log.println(i, str3, message);
                return;
            }
        }
        int length = message.length();
        int i2 = 0;
        while (i2 < length) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) message, '\n', i2, false, 4, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf$default, i2 + 4000);
                String strSubstring = message.substring(i2, iMin);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                if (i == 7) {
                    Log.wtf(str3, strSubstring);
                } else {
                    Log.println(i, str3, strSubstring);
                }
                if (iMin >= iIndexOf$default) {
                    break;
                } else {
                    i2 = iMin;
                }
            }
            i2 = iMin + 1;
        }
    }
}
