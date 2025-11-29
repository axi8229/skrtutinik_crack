package com.huawei.location.lite.common.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.location.lite.common.log.LogLocation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class ROMUtil {
    private static AtomicInteger emuiVersionCode;
    private static AtomicBoolean isHuaweiDevice;
    private static AtomicBoolean romHmsGms;
    private static AtomicBoolean romRegionIsCn;
    private static AtomicInteger romType;

    public static String getEmuiVerName() {
        String eMUIVersion = SystemPropertiesUtil.getEMUIVersion();
        LogLocation.d("ROMUtil", "Emui version name: " + eMUIVersion);
        return eMUIVersion;
    }

    public static int getEmuiVersionCode() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        AtomicInteger atomicInteger = emuiVersionCode;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        int versionCodeFromBuild = getVersionCodeFromBuild(0);
        if (versionCodeFromBuild <= 0) {
            try {
                versionCodeFromBuild = Integer.parseInt(SystemPropertiesUtil.get("ro.build.hw_emui_api_level", "0"));
            } catch (NumberFormatException unused) {
                LogLocation.e("ROMUtil", "NumberFormatException: get hw_emui_api_level failed");
            }
        }
        LogLocation.d("ROMUtil", "EMUI_VERSION_CODE: " + versionCodeFromBuild);
        AtomicInteger atomicInteger2 = new AtomicInteger(versionCodeFromBuild);
        emuiVersionCode = atomicInteger2;
        return atomicInteger2.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getHuaweiPlatformROMType() throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            java.util.concurrent.atomic.AtomicInteger r0 = com.huawei.location.lite.common.util.ROMUtil.romType
            if (r0 == 0) goto L9
            int r0 = r0.get()
            return r0
        L9:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            int r1 = getEmuiVersionCode()
            r0.hashCode()
            java.lang.String r2 = "HONOR"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L38
            java.lang.String r2 = "HUAWEI"
            boolean r0 = r0.equals(r2)
            r2 = 27
            if (r0 != 0) goto L31
            if (r1 >= r2) goto L27
            goto L49
        L27:
            boolean r0 = isUseBrandCust()
            if (r0 == 0) goto L2f
            r0 = 4
            goto L4c
        L2f:
            r0 = 5
            goto L4c
        L31:
            if (r1 < r2) goto L35
            r0 = 3
            goto L4c
        L35:
            if (r1 <= 0) goto L49
            goto L3e
        L38:
            if (r1 <= 0) goto L40
            r0 = 25
            if (r1 > r0) goto L40
        L3e:
            r0 = 1
            goto L4c
        L40:
            r0 = 26
            if (r1 == r0) goto L4b
            r0 = 29
            if (r1 < r0) goto L49
            goto L4b
        L49:
            r0 = -1
            goto L4c
        L4b:
            r0 = 2
        L4c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Rom type is "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ROMUtil"
            com.huawei.location.lite.common.log.LogLocation.d(r2, r1)
            java.util.concurrent.atomic.AtomicInteger r1 = new java.util.concurrent.atomic.AtomicInteger
            r1.<init>(r0)
            com.huawei.location.lite.common.util.ROMUtil.romType = r1
            int r0 = r1.get()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.ROMUtil.getHuaweiPlatformROMType():int");
    }

    private static int getVersionCodeFromBuild(int i) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        String str;
        try {
            Class<?> cls = Class.forName(EmuiUtil.BUILDEX_VERSION);
            Field field = cls.getField(EmuiUtil.EMUI_SDK_INT);
            AccessibleObject.setAccessible(new Field[]{field}, true);
            Object obj = field.get(cls);
            return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            str = "getVersionCodeFromBuild ClassCastException";
            LogLocation.e("ROMUtil", str);
            return i;
        } catch (ClassNotFoundException unused2) {
            i = getVersionCodeFromHonorBuild(i);
            str = "getVersionCodeFromBuild ClassNotFoundException";
            LogLocation.e("ROMUtil", str);
            return i;
        } catch (IllegalAccessException unused3) {
            str = "getVersionCodeFromBuild IllegalAccessException";
            LogLocation.e("ROMUtil", str);
            return i;
        } catch (NoSuchFieldException unused4) {
            str = "getVersionCodeFromBuild NoSuchFieldException";
            LogLocation.e("ROMUtil", str);
            return i;
        } catch (Exception unused5) {
            str = "getVersionCodeFromBuild unknown exception";
            LogLocation.e("ROMUtil", str);
            return i;
        }
    }

    private static int getVersionCodeFromHonorBuild(int i) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        String str;
        try {
            Class<?> cls = Class.forName("com.hihonor.android.os.Build$VERSION");
            Field field = cls.getField(EmuiUtil.EMUI_SDK_INT);
            AccessibleObject.setAccessible(new Field[]{field}, true);
            Object obj = field.get(cls);
            return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            str = "getVersionCodeFromHonorBuild ClassCastException";
            LogLocation.e("ROMUtil", str);
            return i;
        } catch (ClassNotFoundException unused2) {
            str = "getVersionCodeFromHonorBuild ClassNotFoundException";
            LogLocation.e("ROMUtil", str);
            return i;
        } catch (IllegalAccessException unused3) {
            str = "getVersionCodeFromHonorBuild IllegalAccessException";
            LogLocation.e("ROMUtil", str);
            return i;
        } catch (NoSuchFieldException unused4) {
            str = "getVersionCodeFromHonorBuild NoSuchFieldException";
            LogLocation.e("ROMUtil", str);
            return i;
        } catch (Exception unused5) {
            str = "getVersionCodeFromHonorBuild unknown exception";
            LogLocation.e("ROMUtil", str);
            return i;
        }
    }

    public static boolean isChineseRom() {
        AtomicBoolean atomicBoolean = romRegionIsCn;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean zEqualsIgnoreCase = "CN".equalsIgnoreCase(SystemPropertiesUtil.getProRegion());
        LogLocation.d("ROMUtil", "isChineseRom is " + zEqualsIgnoreCase);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(zEqualsIgnoreCase);
        romRegionIsCn = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static boolean isGmsRom() {
        AtomicBoolean atomicBoolean = romHmsGms;
        if (atomicBoolean != null) {
            atomicBoolean.get();
        }
        String str = SystemPropertiesUtil.get("ro.com.google.gmsversion", "");
        LogLocation.d("ROMUtil", "isGmsVersion is " + str);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(TextUtils.isEmpty(str) ^ true);
        romHmsGms = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static boolean isHuaweiPlatformDevice() {
        if (isHuaweiDevice != null) {
            LogLocation.d("ROMUtil", "is huawei device:" + isHuaweiDevice.get());
            return isHuaweiDevice.get();
        }
        boolean z = getHuaweiPlatformROMType() != -1;
        LogLocation.d("ROMUtil", "is huawei device:" + z);
        AtomicBoolean atomicBoolean = new AtomicBoolean(z);
        isHuaweiDevice = atomicBoolean;
        return atomicBoolean.get();
    }

    private static boolean isUseBrandCust() {
        return TextUtils.equals(SystemPropertiesUtil.get("hw_sc.product.useBrandCust", ""), "true");
    }
}
