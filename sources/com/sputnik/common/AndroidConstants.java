package com.sputnik.common;

import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import com.redmadrobot.inputmask.helper.Mask;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: AndroidConstants.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/sputnik/common/AndroidConstants;", "", "<init>", "()V", "Lcom/redmadrobot/inputmask/helper/Mask;", "mask", "Lcom/redmadrobot/inputmask/helper/Mask;", "getMask", "()Lcom/redmadrobot/inputmask/helper/Mask;", "familyMask", "getFamilyMask", "", "", "", "languageFlags", "Ljava/util/Map;", "getLanguageFlags", "()Ljava/util/Map;", "getPhoneLocale", "()Ljava/lang/String;", "phoneLocale", "getPhoneCountry", "phoneCountry", "ServicesNames", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidConstants {
    public static final AndroidConstants INSTANCE = new AndroidConstants();
    private static final Mask mask = new Mask("+[0] ([000]) [000]-[00]-[00999999]");
    private static final Mask familyMask = new Mask("[0] ([000]) *** [00] [00999999]");
    private static final Map<String, Integer> languageFlags = MapsKt.mapOf(TuplesKt.to("uk", Integer.valueOf(R$drawable.ic_ukraine)), TuplesKt.to("uz", Integer.valueOf(R$drawable.ic_uzbekistan)), TuplesKt.to("tr", Integer.valueOf(R$drawable.ic_turkey)), TuplesKt.to("ru", Integer.valueOf(R$drawable.ic_russia)), TuplesKt.to("pl", Integer.valueOf(R$drawable.ic_poland)), TuplesKt.to("de", Integer.valueOf(R$drawable.ic_germany)), TuplesKt.to("md", Integer.valueOf(R$drawable.ic_moldova)), TuplesKt.to("ky", Integer.valueOf(R$drawable.ic_kyrgyzstan)), TuplesKt.to("kk", Integer.valueOf(R$drawable.ic_kazakhstan)), TuplesKt.to("be", Integer.valueOf(R$drawable.ic_belarus)), TuplesKt.to("en", Integer.valueOf(R$drawable.ic_usa)), TuplesKt.to("hy", Integer.valueOf(R$drawable.ic_armenia)), TuplesKt.to("az", Integer.valueOf(R$drawable.ic_azerbaijan)), TuplesKt.to("bg", Integer.valueOf(R$drawable.ic_bulgaria)), TuplesKt.to("ro", Integer.valueOf(R$drawable.ic_romania)));

    private AndroidConstants() {
    }

    public final Mask getMask() {
        return mask;
    }

    public final Mask getFamilyMask() {
        return familyMask;
    }

    public final Map<String, Integer> getLanguageFlags() {
        return languageFlags;
    }

    public final String getPhoneLocale() {
        Locale locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        return String.valueOf(locale != null ? locale.getLanguage() : null);
    }

    public final String getPhoneCountry() {
        Locale locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        return String.valueOf(locale != null ? locale.getCountry() : null);
    }

    /* compiled from: AndroidConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\bR\u001a\u0010\u001f\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/sputnik/common/AndroidConstants$ServicesNames;", "", "<init>", "()V", "", "FR_SUBS_IDENTIFIER", "Ljava/lang/String;", "getFR_SUBS_IDENTIFIER", "()Ljava/lang/String;", "BLE_IDENTIFIER", "getBLE_IDENTIFIER", "VIDEO_ARCHIVE_3d_IDENTIFIER", "getVIDEO_ARCHIVE_3d_IDENTIFIER", "VIDEO_ARCHIVE_5d_IDENTIFIER", "getVIDEO_ARCHIVE_5d_IDENTIFIER", "VIDEO_ARCHIVE_7d_IDENTIFIER", "getVIDEO_ARCHIVE_7d_IDENTIFIER", "DIGITAL_KEY_IDENTIFIER", "getDIGITAL_KEY_IDENTIFIER", "ALICE_IDENTIFIER", "getALICE_IDENTIFIER", "MOBILE_PACK", "getMOBILE_PACK", "EXTRA_CAMERAS", "getEXTRA_CAMERAS", "HISTORY", "getHISTORY", "MULTI_ADDRESS", "getMULTI_ADDRESS", "INSTALL_SPUTNIK_IDENTIFIER", "getINSTALL_SPUTNIK_IDENTIFIER", "INSURANCE_FLAT_IDENTIFIER", "getINSURANCE_FLAT_IDENTIFIER", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ServicesNames {
        public static final ServicesNames INSTANCE = new ServicesNames();
        private static final String FR_SUBS_IDENTIFIER = "face_rec";
        private static final String BLE_IDENTIFIER = "ble";
        private static final String VIDEO_ARCHIVE_3d_IDENTIFIER = "archive_3";
        private static final String VIDEO_ARCHIVE_5d_IDENTIFIER = "archive_5";
        private static final String VIDEO_ARCHIVE_7d_IDENTIFIER = "archive_7";
        private static final String DIGITAL_KEY_IDENTIFIER = "digital_keys";
        private static final String ALICE_IDENTIFIER = "alice";
        private static final String MOBILE_PACK = "mobile_pack";
        private static final String EXTRA_CAMERAS = "extra_cameras";
        private static final String HISTORY = "history";
        private static final String MULTI_ADDRESS = "multi_address";
        private static final String INSTALL_SPUTNIK_IDENTIFIER = "install_sputnik";
        private static final String INSURANCE_FLAT_IDENTIFIER = "flat_insurance";

        private ServicesNames() {
        }

        public final String getFR_SUBS_IDENTIFIER() {
            return FR_SUBS_IDENTIFIER;
        }

        public final String getBLE_IDENTIFIER() {
            return BLE_IDENTIFIER;
        }

        public final String getVIDEO_ARCHIVE_3d_IDENTIFIER() {
            return VIDEO_ARCHIVE_3d_IDENTIFIER;
        }

        public final String getVIDEO_ARCHIVE_5d_IDENTIFIER() {
            return VIDEO_ARCHIVE_5d_IDENTIFIER;
        }

        public final String getVIDEO_ARCHIVE_7d_IDENTIFIER() {
            return VIDEO_ARCHIVE_7d_IDENTIFIER;
        }

        public final String getDIGITAL_KEY_IDENTIFIER() {
            return DIGITAL_KEY_IDENTIFIER;
        }

        public final String getALICE_IDENTIFIER() {
            return ALICE_IDENTIFIER;
        }

        public final String getMOBILE_PACK() {
            return MOBILE_PACK;
        }

        public final String getHISTORY() {
            return HISTORY;
        }

        public final String getINSTALL_SPUTNIK_IDENTIFIER() {
            return INSTALL_SPUTNIK_IDENTIFIER;
        }
    }
}
