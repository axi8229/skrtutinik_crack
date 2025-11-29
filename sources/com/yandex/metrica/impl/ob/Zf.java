package com.yandex.metrica.impl.ob;

import com.yandex.metrica.AdRevenue;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.ValidationException;
import com.yandex.metrica.ecommerce.ECommerceEvent;
import com.yandex.metrica.plugins.IPluginReporter;
import com.yandex.metrica.profile.UserProfile;
import java.util.Map;

/* loaded from: classes3.dex */
public class Zf implements IReporter {
    static final Kn<String> b = new Hn(new Fn("Event name"));
    static final Kn<String> c = new Hn(new Fn("Error message"));
    static final Kn<String> d = new Hn(new Fn("Error identifier"));
    static final Kn<Throwable> e = new Hn(new Gn("Unhandled exception"));
    static final Kn<UserProfile> f = new Hn(new Gn("User profile"));
    static final Kn<Revenue> g = new Hn(new Gn("Revenue"));
    static final Kn<AdRevenue> h = new Hn(new Gn("AdRevenue"));
    static final Kn<ECommerceEvent> i = new Hn(new Gn("ECommerceEvent"));
    private final Yf a;

    public Zf() {
        this(new Yf());
    }

    public Yf a() {
        return this.a;
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
        ((Hn) h).a(adRevenue);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportECommerce(ECommerceEvent eCommerceEvent) {
        ((Hn) i).a(eCommerceEvent);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, Throwable th) throws ValidationException {
        ((Hn) c).a(str);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str) throws ValidationException {
        ((Hn) b).a(str);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(Revenue revenue) throws ValidationException {
        ((Hn) g).a(revenue);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(Throwable th) throws ValidationException {
        ((Hn) e).a(th);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(UserProfile userProfile) throws ValidationException {
        ((Hn) f).a(userProfile);
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(boolean z) {
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(String str) {
    }

    Zf(Yf yf) {
        this.a = yf;
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2) {
        ((Hn) d).a(str);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, String str2) throws ValidationException {
        ((Hn) b).a(str);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2, Throwable th) {
        ((Hn) d).a(str);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, Map<String, Object> map) throws ValidationException {
        ((Hn) b).a(str);
    }
}
