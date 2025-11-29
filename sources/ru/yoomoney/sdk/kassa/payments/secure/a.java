package ru.yoomoney.sdk.kassa.payments.secure;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.KeyStore;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.r;

/* loaded from: classes5.dex */
public final class a {
    public final Context a;
    public final char[] b;
    public final KeyStore c;

    public a(Context context, String password, r errorReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter("bc.keystore", "path");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        this.a = context;
        char[] charArray = password.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        this.b = charArray;
        this.c = b.a(context, charArray, errorReporter);
    }

    public final void a() throws FileNotFoundException {
        FileOutputStream fileOutputStreamOpenFileOutput = this.a.openFileOutput("bc.keystore", 0);
        try {
            this.c.store(fileOutputStreamOpenFileOutput, this.b);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStreamOpenFileOutput, null);
        } finally {
        }
    }
}
