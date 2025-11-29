package com.huawei.location.gnss.api;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class Vw {
    private LocationManager yn;

    public Vw() {
        Object systemService = ContextUtil.getContext().getSystemService("location");
        if (systemService instanceof LocationManager) {
            this.yn = (LocationManager) systemService;
        }
    }

    private void yn(LocationListener locationListener, LocationRequest locationRequest, String str, long j, float f) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        LogLocation.i("NativeNetworkProvider", "requestLocationByNative begin: " + locationRequest.toString());
        Class<?> cls = Class.forName("android.location.LocationRequest");
        Object objNewInstance = cls.newInstance();
        Class cls2 = Long.TYPE;
        Method method = cls.getMethod("createFromDeprecatedProvider", String.class, cls2, Float.TYPE, Boolean.TYPE);
        Method method2 = cls.getMethod("setFastestInterval", cls2);
        Method method3 = cls.getMethod("setExpireAt", cls2);
        Class cls3 = Integer.TYPE;
        LocationManager.class.getMethod("requestLocationUpdates", cls, LocationListener.class, Looper.class).invoke(this.yn, cls.getMethod("setQuality", cls3).invoke(cls.getMethod("setProvider", String.class).invoke(method2.invoke(cls.getMethod("setNumUpdates", cls3).invoke(method3.invoke(method.invoke(objNewInstance, str, Long.valueOf(j), Float.valueOf(f), Boolean.FALSE), Long.valueOf(locationRequest.getExpirationTime())), Integer.valueOf(locationRequest.getNumUpdates())), Long.valueOf(locationRequest.getFastestInterval())), str), Integer.valueOf(locationRequest.getPriority())), locationListener, Looper.getMainLooper());
    }

    private void yn(String str, long j, float f, LocationListener locationListener) {
        String str2;
        LogLocation.i("NativeNetworkProvider", "requestLocationByAPI: provider: " + str + ", minTime: " + j + ", minDistance: " + f);
        try {
            this.yn.requestLocationUpdates(str, j, f, locationListener, Looper.getMainLooper());
        } catch (IllegalArgumentException unused) {
            str2 = "deratedRequest IllegalArgumentException";
            LogLocation.e("LocationManagerAdapter", str2);
        } catch (SecurityException unused2) {
            str2 = "deratedRequest SecurityException";
            LogLocation.e("LocationManagerAdapter", str2);
        } catch (Exception unused3) {
            str2 = "deratedRequest other exception";
            LogLocation.e("LocationManagerAdapter", str2);
        }
    }

    public synchronized void yn(LocationListener locationListener) {
        String str;
        String str2;
        try {
            this.yn.removeUpdates(locationListener);
        } catch (IllegalArgumentException unused) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, IllegalArgumentException";
            LogLocation.e(str, str2);
        } catch (SecurityException unused2) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, SecurityException";
            LogLocation.e(str, str2);
        } catch (Exception unused3) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, other exception";
            LogLocation.e(str, str2);
        }
    }

    public synchronized void yn(RequestLocationUpdatesRequest requestLocationUpdatesRequest, LocationListener locationListener) {
        String str;
        String str2;
        if (requestLocationUpdatesRequest == null || locationListener == null) {
            LogLocation.e("NativeNetworkProvider", "requestLocationFromNative, illegal argument");
            return;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequest.getLocationRequest();
        if (locationRequest == null) {
            LogLocation.e("NativeNetworkProvider", "requestLocationFromNative, illegal argument");
            return;
        }
        int priority = locationRequest.getPriority();
        String str3 = (priority == 100 || priority == 102 || priority == 104 || priority == 300) ? "network" : "";
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        long jMin = Math.min(locationRequest.getInterval(), Long.MAX_VALUE);
        float fMin = Math.min(locationRequest.getSmallestDisplacement(), Float.MAX_VALUE);
        try {
            try {
                try {
                    try {
                        try {
                            yn(locationListener, locationRequest, str3, jMin, fMin);
                        } catch (InstantiationException unused) {
                            LogLocation.e("NativeNetworkProvider", "requestLocationByNative InstantiationException");
                            yn(str3, jMin, fMin, locationListener);
                        } catch (Exception unused2) {
                            str = "NativeNetworkProvider";
                            str2 = "requestLocationByNative other exception";
                            LogLocation.e(str, str2);
                        }
                    } catch (NoSuchMethodException unused3) {
                        LogLocation.e("NativeNetworkProvider", "requestLocationByNative NoSuchMethodException");
                        yn(str3, jMin, fMin, locationListener);
                    } catch (SecurityException unused4) {
                        str = "NativeNetworkProvider";
                        str2 = "requestLocationByNative SecurityException";
                        LogLocation.e(str, str2);
                    }
                } catch (IllegalAccessException unused5) {
                    LogLocation.e("NativeNetworkProvider", "requestLocationByNative IllegalAccessException");
                    yn(str3, jMin, fMin, locationListener);
                }
            } catch (InvocationTargetException unused6) {
                LogLocation.e("NativeNetworkProvider", "requestLocationByNative InvocationTargetException");
                yn(str3, jMin, fMin, locationListener);
            }
        } catch (ClassNotFoundException unused7) {
            LogLocation.e("NativeNetworkProvider", "requestLocationByNative ClassNotFoundException");
            yn(str3, jMin, fMin, locationListener);
        }
    }
}
