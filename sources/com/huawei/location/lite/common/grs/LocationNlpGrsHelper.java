package com.huawei.location.lite.common.grs;

import android.text.TextUtils;
import com.huawei.hms.commonkit.config.Config;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.location.BuildConfig;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import com.huawei.location.lite.common.util.TelephonyUtil;
import com.huawei.location.lite.common.util.country.CountryCodeUtil;
import com.huawei.location.lite.common.util.country.CountryConfig;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class LocationNlpGrsHelper {
    private static String finallyRetry(String str, String str2, String str3) {
        if (CountryConfig.isDRCountry(str)) {
            return null;
        }
        if (TextUtils.equals(str2, BuildConfig.LIBRARY_PACKAGE_NAME)) {
            return getGrsHostRel("SG", str2, str3);
        }
        if (!TextUtils.equals("UNKNOWN", str) && (TextUtils.equals(str3, "LOGSERVERROUTE") || TextUtils.equals(str2, "LOGSERVERROUTE"))) {
            return getGrsHostRel("SG", str2, str3);
        }
        if (TextUtils.equals(str2, "com.huawei.tsms") && SDKComponentType.getComponentType() == 100) {
            return getGrsHostRel("SG", str2, str3);
        }
        return null;
    }

    private static String getGrsHost(String str, String str2, String str3) {
        String grsHostRel = getGrsHostRel(str, str2, str3);
        return !TextUtils.isEmpty(grsHostRel) ? grsHostRel : finallyRetry(str, str2, str3);
    }

    public static String getGrsHostAddress(String str) {
        return getGrsHostAddress(CountryCodeUtil.getLocationCountryCode(), str, "ROOT");
    }

    public static String getGrsHostAddress(String str, String str2) {
        return getGrsHostAddress(str, str2, "ROOT");
    }

    public static String getGrsHostAddress(final String str, final String str2, final String str3) {
        String str4;
        String str5;
        FutureTask futureTask = new FutureTask(new Callable() { // from class: com.huawei.location.lite.common.grs.LocationNlpGrsHelper$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocationNlpGrsHelper.lambda$getGrsHostAddress$0(str2, str, str3);
            }
        });
        try {
            futureTask.run();
            str5 = (String) futureTask.get(5L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            str4 = "getGrsHostAddress future interr error";
            LogLocation.e("LocationNlpGrsHelper", str4);
            str5 = null;
            LogLocation.d("LocationNlpGrsHelper", "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str5);
            return str5;
        } catch (ExecutionException unused2) {
            str4 = "getGrsHostAddress future exec error";
            LogLocation.e("LocationNlpGrsHelper", str4);
            str5 = null;
            LogLocation.d("LocationNlpGrsHelper", "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str5);
            return str5;
        } catch (TimeoutException unused3) {
            str4 = "getGrsHostAddress future timeOut error";
            LogLocation.e("LocationNlpGrsHelper", str4);
            str5 = null;
            LogLocation.d("LocationNlpGrsHelper", "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str5);
            return str5;
        }
        LogLocation.d("LocationNlpGrsHelper", "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str5);
        return str5;
    }

    private static String getGrsHostRel(String str, String str2, String str3) {
        String string;
        if (SDKComponentType.getComponentType() == 100) {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            if (TextUtils.equals(str2, "SITEROUTE") || TextUtils.equals(str2, "HIANALYTICROUTE")) {
                grsBaseInfo.setIssueCountry(str.toUpperCase(Locale.ROOT));
            } else {
                grsBaseInfo.setSerCountry(str.toUpperCase(Locale.ROOT));
            }
            string = new GrsClient(ContextUtil.getContext(), grsBaseInfo).synGetGrsUrl(str2, str3);
        } else {
            string = Config.getString("GRS", String.format(Locale.ENGLISH, "grs://%s/%s?serCountry=%s", str2, str3, str));
        }
        LogLocation.i("LocationNlpGrsHelper", "getGrsHostAddress serviceName:" + str2 + ", host:" + string + ", addressesKey:" + str3 + ", countryCode:" + str);
        return string;
    }

    public static String getLocationIPAddress() {
        return getGrsHostRel("UNKNOWN", BuildConfig.LIBRARY_PACKAGE_NAME, "ROOT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getGrsHostAddress$0(String str, String str2, String str3) throws Exception {
        String grsHost;
        str.hashCode();
        switch (str) {
            case "SITEROUTE":
            case "HIGEOROUTE":
                grsHost = getGrsHost(str2, BuildConfig.LIBRARY_PACKAGE_NAME, str);
                break;
            case "HIANALYTICROUTE":
            case "LOGSERVERROUTE":
            case "MAPROUTE":
            case "AGREEMENTROUTE":
                grsHost = getGrsHost(str2, "com.huawei.location.extService", str);
                break;
            case "com.huawei.hms.oobe":
                grsHost = Config.getString("GRS", String.format(Locale.ENGLISH, "grs://%s/%s", str, "ROOT"));
                break;
            default:
                grsHost = getGrsHost(str2, str, str3);
                break;
        }
        if (!TextUtils.isEmpty(grsHost) || !str.equals("LOGSERVERROUTE") || DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext()) != 8) {
            return grsHost;
        }
        LogLocation.d("LocationNlpGrsHelper", "host is null,device is car, getMcc()");
        return "460".equals(TelephonyUtil.getMcc()) ? getGrsHost("CN", "com.huawei.location.extService", str) : grsHost;
    }
}
