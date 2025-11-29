package com.huawei.riemann.location.bean.eph;

/* loaded from: classes3.dex */
public class BdsTim {
    public double mA0;
    public double mA1;
    public double mA2;
    public int mDeltaT;
    public int mGnssToId;
    public int mWeekNumber;
    public int mWeekSecond;

    public static final class Builder {
        public double a0;
        public double a1;
        public double a2;
        public int deltaT;
        public int gnssToId;
        public int weekNumber;
        public int weekSecond;

        public static Builder aBdsTim() {
            return new Builder();
        }

        public BdsTim build() {
            BdsTim bdsTim = new BdsTim();
            bdsTim.mA0 = this.a0;
            bdsTim.mWeekSecond = this.weekSecond;
            bdsTim.mA2 = this.a2;
            bdsTim.mGnssToId = this.gnssToId;
            bdsTim.mWeekNumber = this.weekNumber;
            bdsTim.mDeltaT = this.deltaT;
            bdsTim.mA1 = this.a1;
            return bdsTim;
        }

        public Builder but() {
            return aBdsTim().withWeekSecond(this.weekSecond).withWeekNumber(this.weekNumber).withA0(this.a0).withA1(this.a1).withA2(this.a2).withGnssToId(this.gnssToId).withDeltaT(this.deltaT);
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

        public Builder withDeltaT(int i) {
            this.deltaT = i;
            return this;
        }

        public Builder withGnssToId(int i) {
            this.gnssToId = i;
            return this;
        }

        public Builder withWeekNumber(int i) {
            this.weekNumber = i;
            return this;
        }

        public Builder withWeekSecond(int i) {
            this.weekSecond = i;
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

    public int getDeltaT() {
        return this.mDeltaT;
    }

    public int getGnssToId() {
        return this.mGnssToId;
    }

    public int getWeekNumber() {
        return this.mWeekNumber;
    }

    public int getWeekSecond() {
        return this.mWeekSecond;
    }
}
