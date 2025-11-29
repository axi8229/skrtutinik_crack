package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.Dn;
import com.yandex.metrica.impl.ob.Xe;

/* loaded from: classes3.dex */
public class NotificationsEnabledAttribute extends BooleanAttribute {
    NotificationsEnabledAttribute() {
        super("appmetrica_notifications_enabled", new Dn(), new Xe());
    }
}
