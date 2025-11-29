package com.sputnik.data;

import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: DataConstants.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/sputnik/data/DataConstants;", "", "<init>", "()V", "", "getPhoneLocale", "()Ljava/lang/String;", "phoneLocale", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataConstants {
    public static final DataConstants INSTANCE = new DataConstants();

    private DataConstants() {
    }

    public final String getPhoneLocale() {
        Locale locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        return String.valueOf(locale != null ? locale.getLanguage() : null);
    }
}
