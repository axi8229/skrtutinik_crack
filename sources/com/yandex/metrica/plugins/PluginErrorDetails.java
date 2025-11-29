package com.yandex.metrica.plugins;

import com.yandex.metrica.impl.ob.A2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class PluginErrorDetails {
    private final String a;
    private final String b;
    private final List<StackTraceItem> c;
    private final String d;
    private final String e;
    private final Map<String, String> f;

    public static class Builder {
        private String a;
        private String b;
        private List<StackTraceItem> c;
        private String d;
        private String e;
        private Map<String, String> f;

        public PluginErrorDetails build() {
            String str = this.a;
            String str2 = this.b;
            List<StackTraceItem> list = this.c;
            List<StackTraceItem> arrayList = new ArrayList<>();
            if (list != null) {
                arrayList = list;
            }
            String str3 = this.d;
            String str4 = this.e;
            Map<String, String> map = this.f;
            Map<String, String> map2 = new HashMap<>();
            if (map != null) {
                map2 = map;
            }
            return new PluginErrorDetails(str, str2, arrayList, str3, str4, map2);
        }

        public Builder withExceptionClass(String str) {
            this.a = str;
            return this;
        }

        public Builder withMessage(String str) {
            this.b = str;
            return this;
        }

        public Builder withPlatform(String str) {
            this.d = str;
            return this;
        }

        public Builder withPluginEnvironment(Map<String, String> map) {
            this.f = map;
            return this;
        }

        public Builder withStacktrace(List<StackTraceItem> list) {
            this.c = list;
            return this;
        }

        public Builder withVirtualMachineVersion(String str) {
            this.e = str;
            return this;
        }
    }

    public static final class Platform {
        public static final String CORDOVA = "cordova";
        public static final String FLUTTER = "flutter";
        public static final String NATIVE = "native";
        public static final String REACT_NATIVE = "react_native";
        public static final String UNITY = "unity";
        public static final String XAMARIN = "xamarin";
    }

    public String getExceptionClass() {
        return this.a;
    }

    public String getMessage() {
        return this.b;
    }

    public String getPlatform() {
        return this.d;
    }

    public Map<String, String> getPluginEnvironment() {
        return this.f;
    }

    public List<StackTraceItem> getStacktrace() {
        return this.c;
    }

    public String getVirtualMachineVersion() {
        return this.e;
    }

    private PluginErrorDetails(String str, String str2, List<StackTraceItem> list, String str3, String str4, Map<String, String> map) {
        this.a = str;
        this.b = str2;
        this.c = new ArrayList(list);
        this.d = str3;
        this.e = str4;
        this.f = A2.a(A2.a((Map) map));
    }
}
