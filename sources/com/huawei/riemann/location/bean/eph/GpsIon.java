package com.huawei.riemann.location.bean.eph;

/* loaded from: classes3.dex */
public class GpsIon {
    public double mA0;
    public double mA1;
    public double mA2;
    public double mA3;
    public int mB0;
    public int mB1;
    public int mB2;
    public int mB3;
    public boolean mValid;

    public static final class Builder {
        public double a0;
        public double a1;
        public double a2;
        public double a3;
        public int b0;
        public int b1;
        public int b2;
        public int b3;
        public boolean valid;

        public static Builder aGpsIon() {
            return new Builder();
        }

        public GpsIon build() {
            GpsIon gpsIon = new GpsIon();
            gpsIon.mB3 = this.b3;
            gpsIon.mA2 = this.a2;
            gpsIon.mA3 = this.a3;
            gpsIon.mA1 = this.a1;
            gpsIon.mA0 = this.a0;
            gpsIon.mB1 = this.b1;
            gpsIon.mB2 = this.b2;
            gpsIon.mB0 = this.b0;
            gpsIon.mValid = this.valid;
            return gpsIon;
        }

        public Builder but() {
            return aGpsIon().withA0(this.a0).withA1(this.a1).withA2(this.a2).withA3(this.a3).withB0(this.b0).withB1(this.b1).withB2(this.b2).withB3(this.b3).withValid(this.valid);
        }

        public Builder withA0(double d) {
            this.a0 = d;
            return this;
        }

        public Builder withA1(double d) {
            this.a1 = d;
            return this;
        }

        public Builder withA2(double d) {
            this.a2 = d;
            return this;
        }

        public Builder withA3(double d) {
            this.a3 = d;
            return this;
        }

        public Builder withB0(int i) {
            this.b0 = i;
            return this;
        }

        public Builder withB1(int i) {
            this.b1 = i;
            return this;
        }

        public Builder withB2(int i) {
            this.b2 = i;
            return this;
        }

        public Builder withB3(int i) {
            this.b3 = i;
            return this;
        }

        public Builder withValid(boolean z) {
            this.valid = z;
            return this;
        }
    }

    public double getA0() {
        return this.mA0;
    }

    public double getA1() {
        return this.mA1;
    }

    public double getA2() {
        return this.mA2;
    }

    public double getA3() {
        return this.mA3;
    }

    public int getB0() {
        return this.mB0;
    }

    public int getB1() {
        return this.mB1;
    }

    public int getB2() {
        return this.mB2;
    }

    public int getB3() {
        return this.mB3;
    }

    public boolean getValid() {
        return this.mValid;
    }
}
