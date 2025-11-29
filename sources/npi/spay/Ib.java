package npi.spay;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.PluginExceptionsKt;

/* loaded from: classes4.dex */
public final class Ib {
    public final String a;
    public final String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public final String i;
    public final String j;
    public final List k;
    public final String l;

    public /* synthetic */ Ib(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list, String str11) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, Hb.a.getDescriptor());
        }
        this.a = str;
        if ((i & 2) == 0) {
            this.b = "";
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = "";
        } else {
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = "";
        } else {
            this.d = str4;
        }
        if ((i & 16) == 0) {
            this.e = "";
        } else {
            this.e = str5;
        }
        if ((i & 32) == 0) {
            this.f = "";
        } else {
            this.f = str6;
        }
        if ((i & 64) == 0) {
            this.g = "";
        } else {
            this.g = str7;
        }
        if ((i & 128) == 0) {
            this.h = "";
        } else {
            this.h = str8;
        }
        if ((i & 256) == 0) {
            this.i = "";
        } else {
            this.i = str9;
        }
        if ((i & 512) == 0) {
            this.j = "";
        } else {
            this.j = str10;
        }
        if ((i & 1024) == 0) {
            this.k = CollectionsKt.emptyList();
        } else {
            this.k = list;
        }
        if ((i & 2048) == 0) {
            this.l = E2.a();
        } else {
            this.l = str11;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ib)) {
            return false;
        }
        Ib ib = (Ib) obj;
        return Intrinsics.areEqual(this.a, ib.a) && Intrinsics.areEqual(this.b, ib.b) && Intrinsics.areEqual(this.c, ib.c) && Intrinsics.areEqual(this.d, ib.d) && Intrinsics.areEqual(this.e, ib.e) && Intrinsics.areEqual(this.f, ib.f) && Intrinsics.areEqual(this.g, ib.g) && Intrinsics.areEqual(this.h, ib.h) && Intrinsics.areEqual(this.i, ib.i) && Intrinsics.areEqual(this.j, ib.j) && Intrinsics.areEqual(this.k, ib.k) && Intrinsics.areEqual(this.l, ib.l);
    }

    public final int hashCode() {
        return this.l.hashCode() + ((this.k.hashCode() + AbstractC1553e.a(this.j, AbstractC1553e.a(this.i, AbstractC1553e.a(this.h, AbstractC1553e.a(this.g, AbstractC1553e.a(this.f, AbstractC1553e.a(this.e, AbstractC1553e.a(this.d, AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31)) * 31);
    }

    public final String toString() {
        return "Event(eventAction=" + this.a + ", eventType=" + this.b + ", geoLatitude=" + this.c + ", geoLongitude=" + this.d + ", cellularProvider=" + this.e + ", batteryLevel=" + this.f + ", connectionType=" + this.g + ", internalIP=" + this.h + ", eventCategory=" + this.i + ", value=" + this.j + ", properties=" + this.k + ", timeStamp=" + this.l + ')';
    }

    public Ib(String eventAction, String eventType, String geoLatitude, String geoLongitude, String cellularProvider, String batteryLevel, String connectionType, String internalIP, String eventCategory, String value, List properties, String timeStamp) {
        Intrinsics.checkNotNullParameter(eventAction, "eventAction");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(geoLatitude, "geoLatitude");
        Intrinsics.checkNotNullParameter(geoLongitude, "geoLongitude");
        Intrinsics.checkNotNullParameter(cellularProvider, "cellularProvider");
        Intrinsics.checkNotNullParameter(batteryLevel, "batteryLevel");
        Intrinsics.checkNotNullParameter(connectionType, "connectionType");
        Intrinsics.checkNotNullParameter(internalIP, "internalIP");
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(timeStamp, "timeStamp");
        this.a = eventAction;
        this.b = eventType;
        this.c = geoLatitude;
        this.d = geoLongitude;
        this.e = cellularProvider;
        this.f = batteryLevel;
        this.g = connectionType;
        this.h = internalIP;
        this.i = eventCategory;
        this.j = value;
        this.k = properties;
        this.l = timeStamp;
    }
}
