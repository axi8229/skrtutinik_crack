package com.huawei.location.lite.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class NetworkUtil {
    @SuppressLint({"MissingPermission", "NewApi"})
    private static int getHwNetworkType(Context context) {
        TelephonyManager telephonyManager;
        String str;
        ServiceState serviceState;
        if (ReflectionUtils.checkCompatible(EmuiUtil.BUILDEX_VERSION) && context != null && (telephonyManager = (TelephonyManager) getSystemService(context, "phone")) != null) {
            try {
                if (BuildEx.VERSION.EMUI_SDK_INT >= 21 && (serviceState = telephonyManager.getServiceState()) != null) {
                    return ServiceStateEx.getConfigRadioTechnology(serviceState);
                }
            } catch (NoClassDefFoundError unused) {
                str = "NoClassDefFoundError occur in method getHwNetworkType.";
                LogLocation.d("NetworkUtil", str);
                return 0;
            } catch (NoSuchMethodError unused2) {
                str = "NoSuchMethodError occur in method getHwNetworkType.";
                LogLocation.d("NetworkUtil", str);
                return 0;
            } catch (SecurityException unused3) {
                str = "requires permission maybe missing.";
                LogLocation.d("NetworkUtil", str);
                return 0;
            }
        }
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    private static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) getSystemService(context, "connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (RuntimeException unused) {
            LogLocation.d("NetworkUtil", "getActiveNetworkInfo failed, exception");
            return null;
        }
    }

    public static String getNetworkState() {
        int networkType = getNetworkType(ContextUtil.getContext());
        return networkType != 1 ? networkType != 2 ? networkType != 3 ? networkType != 4 ? networkType != 5 ? "" : "5G" : "4G" : "3G" : "2G" : "wifi";
    }

    public static int getNetworkType() {
        return getNetworkType(ContextUtil.getContext()) != 1 ? 0 : 1;
    }

    public static int getNetworkType(Context context) {
        int i = -1;
        try {
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return -1;
            }
            int type = networkInfo.getType();
            int i2 = 1;
            if (1 != type && 13 != type && (DeviceInfoUtil.getDeviceFeature(context) != 8 || 9 != type)) {
                i2 = 0;
                if (type == 0) {
                    int hwNetworkType = getHwNetworkType(context);
                    LogLocation.d("NetworkUtil", "getHwNetworkType return is: " + hwNetworkType);
                    if (hwNetworkType == 0) {
                        hwNetworkType = networkInfo.getSubtype();
                    }
                    if (hwNetworkType != 20) {
                        switch (hwNetworkType) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                i = 2;
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                i = 3;
                                break;
                            case 13:
                                i = 4;
                                break;
                            default:
                                i = 0;
                                break;
                        }
                    } else {
                        i = 5;
                    }
                    if (i != 0) {
                        return i;
                    }
                    if (Build.VERSION.SDK_INT < 25) {
                        return i;
                    }
                    if (hwNetworkType == 16) {
                        return 2;
                    }
                    if (hwNetworkType == 17) {
                        return 3;
                    }
                }
            }
            return i2;
        } catch (Exception unused) {
            LogLocation.e("NetworkUtil", "getNetworkType exception");
            return i;
        }
    }

    private static Object getSystemService(Context context, String str) {
        if (context == null) {
            LogLocation.d("NetworkUtil", "context is null");
            return null;
        }
        try {
            return context.getSystemService(str);
        } catch (RuntimeException e) {
            LogLocation.e("NetworkUtil", "SystemServer error:", e);
            return null;
        }
    }

    public static boolean isCurActiveNetInfoValid(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(context, "connectivity");
            if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
                return networkCapabilities.hasCapability(16);
            }
        } catch (Exception unused) {
            LogLocation.e("NetworkUtil", "isNetValida exception");
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo networkInfo;
        return PermissionUtil.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (networkInfo = getNetworkInfo(context)) != null && networkInfo.isConnected();
    }
}
