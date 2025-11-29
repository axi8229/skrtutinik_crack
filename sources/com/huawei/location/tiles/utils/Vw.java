package com.huawei.location.tiles.utils;

import com.yandex.varioqub.config.model.ConfigValue;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Vw {
    private String yn = "XXX-XXX-XXX";
    private List<d2> Vw = new ArrayList();

    public boolean Vw(double d, double d2) {
        if (this.Vw.size() < 3) {
            return false;
        }
        for (int i = 0; i < this.Vw.size(); i++) {
            if (i != this.Vw.size() - 1) {
                double d3 = this.Vw.get(i).Vw;
                double d4 = this.Vw.get(i).yn;
                int i2 = i + 1;
                if ((d - d3) * (d4 - this.Vw.get(i2).yn) == (d3 - this.Vw.get(i2).Vw) * (d2 - d4)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String yn() {
        return this.yn;
    }

    public void yn(d2 d2Var) {
        this.Vw.add(d2Var);
    }

    public void yn(String str) {
        this.yn = str;
    }

    public boolean yn(double d, double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        if (this.Vw.size() < 3) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.Vw.size(); i2++) {
            if (i2 != this.Vw.size() - 1) {
                if (i2 == this.Vw.size() - 2) {
                    d3 = this.Vw.get(i2).Vw;
                    d4 = this.Vw.get(i2).yn;
                    d5 = this.Vw.get(0).Vw;
                    d6 = this.Vw.get(0).yn;
                } else {
                    d3 = this.Vw.get(i2).Vw;
                    d4 = this.Vw.get(i2).yn;
                    int i3 = i2 + 1;
                    d5 = this.Vw.get(i3).Vw;
                    d6 = this.Vw.get(i3).yn;
                }
                if ((d2 >= d4 && d2 < d6) || (d2 >= d6 && d2 < d4)) {
                    double d7 = d4 - d6;
                    if (Math.abs(d7) > ConfigValue.DOUBLE_DEFAULT_VALUE && d3 - (((d3 - d5) * (d4 - d2)) / d7) < d) {
                        i++;
                    }
                }
            }
        }
        return i % 2 != 0;
    }
}
