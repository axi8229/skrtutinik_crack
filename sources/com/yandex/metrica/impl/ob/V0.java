package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* loaded from: classes3.dex */
public class V0 implements Parcelable {
    public static final Parcelable.Creator<V0> CREATOR = new b();
    private ResultReceiver a;
    private List<String> b;
    private Map<String, String> c;

    class a implements Function0<I> {
        a(V0 v0) {
        }

        @Override // kotlin.jvm.functions.Function0
        public I invoke() {
            return F0.g().d();
        }
    }

    class b implements Parcelable.Creator<V0> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        public V0 createFromParcel(Parcel parcel) {
            return new V0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public V0[] newArray(int i) {
            return new V0[i];
        }
    }

    public V0(List<String> list, Map<String, String> map, ResultReceiver resultReceiver) {
        this.b = list;
        this.a = resultReceiver;
        this.c = map == null ? new HashMap() : new HashMap(map);
    }

    public boolean a(C1178pi c1178pi) {
        return C1128ni.a(c1178pi, this.b, this.c, new a(this));
    }

    public List<String> b() {
        return this.b;
    }

    public ResultReceiver c() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.yandex.metrica.CounterConfiguration.receiver", this.a);
        if (this.b != null) {
            bundle.putStringArrayList("com.yandex.metrica.CounterConfiguration.identifiersList", new ArrayList<>(this.b));
        }
        Map<String, String> map = this.c;
        if (map != null) {
            bundle.putString("com.yandex.metrica.CounterConfiguration.clidsForVerification", Tl.c(map));
        }
        parcel.writeBundle(bundle);
    }

    public Map<String, String> a() {
        return this.c;
    }

    protected V0(Parcel parcel) {
        Bundle bundle = parcel.readBundle(ResultReceiverC0911f0.class.getClassLoader());
        if (bundle != null) {
            this.a = (ResultReceiver) bundle.getParcelable("com.yandex.metrica.CounterConfiguration.receiver");
            this.b = bundle.getStringArrayList("com.yandex.metrica.CounterConfiguration.identifiersList");
            this.c = Tl.a(bundle.getString("com.yandex.metrica.CounterConfiguration.clidsForVerification"));
            return;
        }
        this.c = new HashMap();
    }
}
