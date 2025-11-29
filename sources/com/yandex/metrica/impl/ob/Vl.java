package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.coreutils.logger.BaseLogger;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class Vl extends BaseLogger {
    private static String b = "";
    private final String a;

    public Vl(String str) {
        super(false);
        this.a = "[" + A2.a(str) + "] ";
    }

    public static void a(Context context) {
        b = "[" + context.getPackageName() + "] : ";
    }

    @Override // com.yandex.metrica.coreutils.logger.BaseLogger
    protected String formatMessage(String str, Object[] objArr) {
        return String.format(Locale.US, str, objArr);
    }

    @Override // com.yandex.metrica.coreutils.logger.BaseLogger
    public String getPrefix() {
        String str = b;
        if (str == null) {
            str = "";
        }
        String str2 = this.a;
        return str + (str2 != null ? str2 : "");
    }
}
