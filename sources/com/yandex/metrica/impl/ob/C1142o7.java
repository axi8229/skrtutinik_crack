package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ac.NativeCrashesHelper;

@Deprecated
/* renamed from: com.yandex.metrica.impl.ob.o7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1142o7 implements InterfaceC1042k7 {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public String a() {
        return "YandexMetricaNativeCrashes";
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public void a(String str) {
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public void a(String str, String str2, String str3) {
        NativeCrashesHelper.setUpNativeUncaughtExceptionHandler(str2);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public void b() {
        NativeCrashesHelper.cancelSetUpNativeUncaughtExceptionHandler();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public String c() {
        return "YandexMetricaNativeModule";
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public void a(boolean z) {
        NativeCrashesHelper.logsEnabled(z);
    }
}
