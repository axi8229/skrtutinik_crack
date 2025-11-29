package com.yandex.metrica.networktasks.api;

/* loaded from: classes3.dex */
class c {
    final NetworkTask a;
    private final String b;

    private c(NetworkTask networkTask) {
        this.a = networkTask;
        this.b = networkTask.description();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.b.equals(((c) obj).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
