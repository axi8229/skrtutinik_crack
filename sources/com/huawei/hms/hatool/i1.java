package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes3.dex */
public class i1 {
    private String a;
    private String b;
    private String c;
    private String d;
    private long e;

    public i1(String str, String str2, String str3, String str4, long j) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = j;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.c);
        b1Var.d(this.b);
        b1Var.a(this.d);
        b1Var.c(String.valueOf(this.e));
        if ("oper".equals(this.b) && z.i(this.a, "oper")) {
            p0 p0VarA = y.a().a(this.a, this.e);
            String strA = p0VarA.a();
            Boolean boolValueOf = Boolean.valueOf(p0VarA.b());
            b1Var.f(strA);
            b1Var.e(String.valueOf(boolValueOf));
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.a, this.b, q0.g(), arrayList, strReplace).a();
    }
}
