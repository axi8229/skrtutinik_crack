package com.huawei.location.lite.common.util.country;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class CountryConfig {
    private static final List<String> DR1 = Arrays.asList("CN");
    private static final List<String> DR2 = Arrays.asList("AE", "AF", "AG", "AI", "AM", "AO", "AQ", "AR", "AS", "AW", "AZ", "BB", "BD", "BF", "BH", "BI", "BJ", "BL", "BM", "BN", "BO", "BR", "BS", "BT", "BV", "BW", "BY", "BZ", "CC", "CD", "CF", "CG", "CI", "CK", "CL", "CM", "CO", "CR", "CU", "CV", "CX", "DJ", "DM", "DO", "DZ", "EC", "EG", "EH", "ER", "ET", "FJ", "FK", "FM", "GA", "GD", "GE", "GF", "GH", "GM", "GN", "GP", "GQ", "GS", "GT", "GU", "GW", "GY", "HK", "HM", "HN", "HT", "ID", "IN", "IO", "IQ", "JM", "JO", "JP", "KE", "KG", "KH", "KI", "KM", "KN", "KP", "KR", "KW", "KY", "KZ", "LA", "LB", "LC", "LK", "LR", "LS", "LY", "MA", "MG", "MH", "ML", "MM", "MN", "MO", "MP", "MQ", "MR", "MS", "MU", "MV", "MW", "MX", "MY", "MZ", "NA", "NC", "NE", "NF", "NG", "NI", "NP", "NR", "NU", "OM", "PA", "PE", "PF", "PG", "PH", "PK", "PN", "PR", "PS", "PW", "PY", "QA", "RE", "RW", "SA", "SB", "SC", "SD", "SG", "SH", "SL", "SN", "SO", "SR", "SS", "ST", "SV", "SY", "SZ", "TC", "TD", "TF", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO", "TT", "TV", "TW", "TZ", "UG", "UY", "UZ", "VE", "VG", "VI", "VN", "VU", "WF", "WS", "YE", "YT", "ZA", "ZM", "ZW");
    private static final List<String> DR3 = Arrays.asList("AD", "AL", "AN", "AT", "AU", "AX", "BA", "BE", "BG", "BQ", "CA", "CH", "CW", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FO", "FR", "GB", "GG", "GI", "GL", "GR", "HR", "HU", "IE", "IL", "IM", "IS", "IT", "JE", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MF", "MK", "MT", "NL", "NO", "NZ", "PL", "PM", "PT", "RO", "RS", "SE", "SI", "SJ", "SK", "SM", "SX", "TR", "UA", "UM", "US", "VA", "VC", "XK", "YK", "EU");
    private static final List<String> DR4 = Arrays.asList("RU");

    public static boolean isDRCountry(String str) {
        if (!CountryCodeUtil.isCodeValidate(str)) {
            return false;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        return DR1.contains(upperCase) || DR2.contains(upperCase) || DR3.contains(upperCase) || DR4.contains(upperCase);
    }
}
