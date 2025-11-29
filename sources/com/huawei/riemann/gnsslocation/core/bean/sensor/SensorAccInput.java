package com.huawei.riemann.gnsslocation.core.bean.sensor;

/* loaded from: classes3.dex */
public class SensorAccInput {
    public double mAx;
    public double mAy;
    public double mAz;
    public long mBootTime;

    public static final class Builder {
        public double ax;
        public double ay;
        public double az;
        public long bootTime;

        public static Builder aSensorAccInput() {
            return new Builder();
        }

        public SensorAccInput build() {
            SensorAccInput sensorAccInput = new SensorAccInput();
            sensorAccInput.mBootTime = this.bootTime;
            sensorAccInput.mAx = this.ax;
            sensorAccInput.mAy = this.ay;
            sensorAccInput.mAz = this.az;
            return sensorAccInput;
        }

        public Builder but() {
            return aSensorAccInput().withBootTime(this.bootTime).withAx(this.ax).withAy(this.ay).withAz(this.az);
        }

        public Builder withAx(double d) {
            this.ax = d;
            return this;
        }

        public Builder withAy(double d) {
            this.ay = d;
            return this;
        }

        public Builder withAz(double d) {
            this.az = d;
            return this;
        }

        public Builder withBootTime(long j) {
            this.bootTime = j;
            return this;
        }
    }

    public double getAx() {
        return this.mAx;
    }

    public double getAy() {
        return this.mAy;
    }

    public double getAz() {
        return this.mAz;
    }

    public long getBootTime() {
        return this.mBootTime;
    }
}
