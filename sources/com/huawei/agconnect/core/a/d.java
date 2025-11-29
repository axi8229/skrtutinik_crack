package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d {
    private static Map<Class<?>, Service> a = new HashMap();
    private static Map<Class<?>, Object> b = new HashMap();
    private Map<Class<?>, Service> c = new HashMap();
    private Map<Class<?>, Object> d = new HashMap();

    d(List<Service> list, Context context) throws SecurityException {
        a(list, context);
    }

    private static Constructor a(Class cls, Class... clsArr) throws SecurityException {
        boolean z = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    z = parameterTypes[i] == clsArr[i];
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private void a(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        StringBuilder sb = new StringBuilder();
        sb.append("cause message:");
        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        Log.e("AGC_ServiceRepository", sb.toString());
    }

    public void a(List<Service> list, Context context) throws SecurityException {
        Map<Class<?>, Service> map;
        String str;
        Log.d("AGC_ServiceRepository", "addService start");
        if (list == null) {
            return;
        }
        for (Service service : list) {
            if (service.isSharedInstance()) {
                if (!a.containsKey(service.getInterface())) {
                    map = a;
                }
                if (!service.isAutoCreated() && service.getType() != null && !b.containsKey(service.getInterface())) {
                    try {
                        Constructor constructorA = a(service.getType(), Context.class);
                        b.put(service.getInterface(), constructorA != null ? constructorA.newInstance(context) : service.getType().newInstance());
                    } catch (IllegalAccessException e) {
                        e = e;
                        str = "AccessException";
                        a(str, e);
                    } catch (InstantiationException e2) {
                        e = e2;
                        str = "InstantiationException";
                        a(str, e);
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        str = "TargetException";
                        a(str, e);
                    }
                }
            } else {
                map = this.c;
            }
            map.put(service.getInterface(), service);
            if (!service.isAutoCreated()) {
            }
        }
        Log.d("AGC_ServiceRepository", "addService end");
    }
}
