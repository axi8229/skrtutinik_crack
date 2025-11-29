package com.huawei.location.lite.common.plug;

import com.huawei.location.lite.common.log.LogLocation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class PluginServiceLoader<S> {
    private final Class<S> service;
    private LinkedHashMap<String, S> providers = new LinkedHashMap<>();
    private LinkedHashMap<Integer, List<String>> plugins = new LinkedHashMap<>();

    private PluginServiceLoader(Class<S> cls) {
        Objects.requireNonNull(cls, "Service interface cannot be null");
        this.service = cls;
        reload();
    }

    public static <S> PluginServiceLoader<S> load(Class<S> cls) {
        return new PluginServiceLoader<>(cls);
    }

    private S loaderServiceProvider(String str) throws ClassNotFoundException {
        Class<?> cls;
        StringBuilder sb;
        String str2;
        S s = this.providers.get(str);
        if (s != null) {
            return s;
        }
        S sCast = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
            LogLocation.e("PluginServiceLoader", "Provider " + str + " not found");
            cls = null;
        }
        if (!this.service.isAssignableFrom(cls)) {
            LogLocation.e("PluginServiceLoader", "Provider " + str + " not a subtype");
        }
        if (cls != null) {
            try {
                sCast = this.service.cast(cls.newInstance());
            } catch (IllegalAccessException unused2) {
                sb = new StringBuilder();
                sb.append("Provider");
                sb.append(str);
                str2 = " IllegalAccessException ";
                sb.append(str2);
                LogLocation.e("PluginServiceLoader", sb.toString());
                this.providers.put(str, sCast);
                return sCast;
            } catch (InstantiationException unused3) {
                sb = new StringBuilder();
                sb.append("Provider");
                sb.append(str);
                str2 = " InstantiationException ";
                sb.append(str2);
                LogLocation.e("PluginServiceLoader", sb.toString());
                this.providers.put(str, sCast);
                return sCast;
            }
        }
        this.providers.put(str, sCast);
        return sCast;
    }

    private List<S> loaderServiceProvider(int i) {
        ArrayList arrayList = new ArrayList();
        List<String> list = this.plugins.get(Integer.valueOf(i));
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(loaderServiceProvider(it.next()));
            }
        }
        return arrayList;
    }

    private void parserProductId() {
        String[] strArrPaths;
        if (this.plugins.isEmpty()) {
            try {
                for (Field field : ProductId.class.getDeclaredFields()) {
                    ProductPlugPath productPlugPath = (ProductPlugPath) field.getAnnotation(ProductPlugPath.class);
                    String name = field.getName();
                    if ((field.get(name) instanceof Integer) && productPlugPath != null && (strArrPaths = productPlugPath.paths()) != null && strArrPaths.length != 0) {
                        if (field.get(name) instanceof Integer) {
                            this.plugins.put((Integer) field.get(name), Arrays.asList(strArrPaths));
                        }
                    }
                    return;
                }
            } catch (IllegalAccessException unused) {
                LogLocation.e("PluginServiceLoader", "parserProductId");
            }
        }
    }

    public List<S> loadService(int i) {
        parserProductId();
        return loaderServiceProvider(i);
    }

    public final void reload() {
        this.providers.clear();
        this.plugins.clear();
    }
}
