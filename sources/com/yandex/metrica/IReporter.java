package com.yandex.metrica;

import com.yandex.metrica.ecommerce.ECommerceEvent;
import com.yandex.metrica.plugins.IPluginReporter;
import com.yandex.metrica.profile.UserProfile;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IReporter {
    IPluginReporter getPluginExtension();

    void pauseSession();

    void reportAdRevenue(AdRevenue adRevenue);

    void reportECommerce(ECommerceEvent eCommerceEvent);

    void reportError(String str, String str2);

    void reportError(String str, String str2, Throwable th);

    void reportError(String str, Throwable th);

    void reportEvent(String str);

    void reportEvent(String str, String str2);

    void reportEvent(String str, Map<String, Object> map);

    void reportRevenue(Revenue revenue);

    void reportUnhandledException(Throwable th);

    void reportUserProfile(UserProfile userProfile);

    void resumeSession();

    void sendEventsBuffer();

    void setStatisticsSending(boolean z);

    void setUserProfileID(String str);
}
