package ru.yoomoney.sdk.kassa.payments.errorFormatter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.model.C2319c;
import ru.yoomoney.sdk.kassa.payments.model.L;

/* loaded from: classes5.dex */
public final class a implements b {
    public final Context a;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.errorFormatter.b
    public final CharSequence a(Throwable e) {
        Context context;
        int i;
        Context context2;
        int i2;
        Intrinsics.checkNotNullParameter(e, "e");
        if (e instanceof L) {
            CharSequence text = this.a.getText(R$string.ym_error_no_internet);
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            return text;
        }
        if (!(e instanceof C2319c)) {
            if (e instanceof ActivityNotFoundException) {
                context = this.a;
                i = R$string.ym_sbp_bank_not_found_message;
            } else {
                context = this.a;
                i = R$string.ym_error_something_went_wrong;
            }
            CharSequence text2 = context.getText(i);
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            return text2;
        }
        int iOrdinal = ((C2319c) e).a().a.ordinal();
        if (iOrdinal == 5) {
            context2 = this.a;
            i2 = R$string.ym_server_error;
        } else if (iOrdinal != 24) {
            context2 = this.a;
            i2 = R$string.ym_error_something_went_wrong;
        } else {
            context2 = this.a;
            i2 = R$string.ym_unknown_error;
        }
        CharSequence text3 = context2.getText(i2);
        Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
        return text3;
    }
}
