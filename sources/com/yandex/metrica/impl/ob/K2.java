package com.yandex.metrica.impl.ob;

import android.location.Location;

/* loaded from: classes3.dex */
public final class K2 extends Location {
    private final String a;

    private K2(Location location, String str) {
        super(location);
        this.a = str;
    }

    public static K2 b(Location location) {
        return new K2(new Location(location), "");
    }

    public String a() {
        return this.a;
    }

    public static K2 a(Location location) {
        Location location2 = new Location(location);
        String provider = location2.getProvider();
        location2.setProvider("");
        return new K2(location2, provider);
    }
}
