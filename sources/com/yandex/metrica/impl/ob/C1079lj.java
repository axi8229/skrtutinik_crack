package com.yandex.metrica.impl.ob;

import com.yandex.metrica.AdRevenue;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.ecommerce.ECommerceEvent;
import com.yandex.metrica.plugins.IPluginReporter;
import com.yandex.metrica.profile.UserProfile;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.lj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1079lj implements M0 {
    private final C1054kj a = new C1054kj();

    C1079lj() {
    }

    public void a(H6 h6) {
    }

    public void a(C1333w6 c1333w6) {
    }

    @Override // com.yandex.metrica.impl.ob.M0
    public void a(String str, JSONObject jSONObject) {
    }

    @Override // com.yandex.metrica.impl.ob.M0
    public void b() {
    }

    @Override // com.yandex.metrica.impl.ob.M0, com.yandex.metrica.d
    public void b(String str, String str2) {
    }

    @Override // com.yandex.metrica.impl.ob.M0, com.yandex.metrica.d
    public void d(String str, String str2) {
    }

    @Override // com.yandex.metrica.IReporter
    public IPluginReporter getPluginExtension() {
        return this.a;
    }

    @Override // com.yandex.metrica.IReporter
    public void pauseSession() {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportAdRevenue(AdRevenue adRevenue) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportECommerce(ECommerceEvent eCommerceEvent) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2, Throwable th) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, Throwable th) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, String str2) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, Map<String, Object> map) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(Revenue revenue) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(Throwable th) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(UserProfile userProfile) {
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
    }

    @Override // com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(boolean z) {
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(String str) {
    }
}
