package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes3.dex */
public class GlonassTim {
    public double mA0;
    public double mA1;
    public double mA2;
    public int mGnssToId;
    public int mWeekNumber;
    public int mWeekSecond;

    public static final class Builder {
        public double a0;
        public double a1;
        public double a2;
        public int gnssToId;
        public int weekNumber;
        public int weekSecond;

        public static Builder aGlonassTim() {
            return new Builder();
        }

        public GlonassTim build() {
            GlonassTim glonassTim = new GlonassTim();
            glonassTim.mWeekSecond = this.weekSecond;
            glonassTim.mWeekNumber = this.weekNumber;
            glonassTim.mGnssToId = this.gnssToId;
            glonassTim.mA1 = this.a1;
            glonassTim.mA0 = this.a0;
            glonassTim.mA2 = this.a2;
            return glonassTim;
        }

        public Builder but() {
            return aGlonassTim().withWeekSecond(this.weekSecond).withWeekNumber(this.weekNumber).withA0(this.a0).withA1(this.a1).withA2(this.a2).withGnssToId(this.gnssToId);
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
