package com.group_ib.sdk;

import com.yandex.varioqub.config.model.ConfigValue;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class A {
    public double a = -1.7976931348623157E308d;
    public double b = Double.MAX_VALUE;
    public double c = -1.7976931348623157E308d;
    public double d = -1.7976931348623157E308d;
    public double e = ConfigValue.DOUBLE_DEFAULT_VALUE;
    public double f = ConfigValue.DOUBLE_DEFAULT_VALUE;
    public int g = 0;
    public final double[] h;
    public final double[] i;

    public A() {
        double[] dArr = new double[5];
        this.h = dArr;
        double[] dArr2 = new double[6];
        this.i = dArr2;
        Arrays.fill(dArr, -1.7976931348623157E308d);
        Arrays.fill(dArr2, ConfigValue.DOUBLE_DEFAULT_VALUE);
    }

    public JSONObject a() throws JSONException {
        if (this.g == 0) {
            return null;
        }
        double d = -1.7976931348623157E308d;
        for (double d2 : this.h) {
            if (d2 > d) {
                d = d2;
            }
        }
        JSONObject jSONObjectPut = new JSONObject().put("max", B.a(this.a)).put("max_start", B.a(this.c));
        double[] dArr = this.i;
        return jSONObjectPut.put("max_drift", B.a(dArr[this.g % dArr.length])).put("max_stop", B.a(d)).put("min", B.a(this.b)).put("mean", B.a(this.e)).put("std", B.a(Math.sqrt(Math.abs(this.f))));
    }

    public final String toString() {
        if (this.g == 0) {
            return null;
        }
        double d = -1.7976931348623157E308d;
        for (double d2 : this.h) {
            if (d2 > d) {
                d = d2;
            }
        }
        StringBuilder sb = new StringBuilder("max:");
        sb.append(this.a);
        sb.append(",max_start:");
        sb.append(this.c);
        sb.append(",max_drift:");
        double[] dArr = this.i;
        sb.append(dArr[this.g % dArr.length]);
        sb.append(",max_stop:");
        sb.append(d);
        sb.append(",min:");
        sb.append(this.b);
        sb.append(",mean:");
        sb.append(this.e);
        sb.append(",std:");
        sb.append(Math.sqrt(this.f));
        return sb.toString();
    }

    public void a(double d) {
        int i = this.g;
        int i2 = i + 1;
        this.g = i2;
        if (d > this.a) {
            this.a = d;
        }
        if (d < this.b) {
            this.b = d;
        }
        if (i2 <= 5 && d > this.c) {
            this.c = d;
        }
        double[] dArr = this.h;
        dArr[i % dArr.length] = d;
        if (i2 > 5) {
            if (d > this.d) {
                this.d = d;
            }
            double[] dArr2 = this.i;
            dArr2[i % dArr2.length] = this.d;
        }
        double d2 = this.e;
        double d3 = i;
        double d4 = i2;
        double d5 = ((d2 * d3) + d) / d4;
        double d6 = (((d * d) + (((d2 * d2) + this.f) * d3)) / d4) - (d5 * d5);
        this.e = d5;
        this.f = d6;
    }
}
