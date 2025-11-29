package com.huawei.riemann.location.bean.eph;

/* loaded from: classes3.dex */
public class GalileoTim {
    public double mA0;
    public double mA1;
    public long mT0;

    public static final class Builder {
        public double a0;
        public double a1;
        public long t0;

        public static Builder aGalileoTim() {
            return new Builder();
        }

        public GalileoTim build() {
            GalileoTim galileoTim = new GalileoTim();
            galileoTim.mA0 = this.a0;
            galileoTim.mA1 = this.a1;
            galileoTim.mT0 = this.t0;
            return galileoTim;
        }

        public Builder but() {
            return aGalileoTim().withA0(this.a0).withA1(this.a1).withT0(this.t0);
        }

        public Builder withA0(double d) {
            this.a0 = d;
            return this;
        }

        public Builder withA1(double d) {
            this.a1 = d;
            return this;
        }

        public Builder withT0(long j) {
            this.t0 = j;
            return this;
        }
    }

    public double getA0() {
        return this.mA0;
    }

    public double getA1() {
        return this.mA1;
    }

    public long getT0() {
        return this.mT0;
    }
}
