package com.huawei.riemann.gnsslocation.core.bean.sensor;

/* loaded from: classes3.dex */
public class SensorGyroInput {
    public long mBootTime;
    public double mGx;
    public double mGy;
    public double mGz;

    public static final class Builder {
        public long bootTime;
        public double gx;
        public double gy;
        public double gz;

        public static Builder aSensorGyroInput() {
            return new Builder();
        }

        public SensorGyroInput build() {
            SensorGyroInput sensorGyroInput = new SensorGyroInput();
            sensorGyroInput.mBootTime = this.bootTime;
            sensorGyroInput.mGx = this.gx;
            sensorGyroInput.mGy = this.gy;
            sensorGyroInput.mGz = this.gz;
            return sensorGyroInput;
        }

        public Builder but() {
            return aSensorGyroInput().withBootTime(this.bootTime).withGx(this.gx).withGy(this.gy).withGz(this.gz);
        }

        public Builder withBootTime(long j) {
            this.bootTime = j;
            return this;
        }

        public Builder withGx(double d) {
            this.gx = d;
            return this;
        }

        public Builder withGy(double d) {
            this.gy = d;
            return this;
        }

        public Builder withGz(double d) {
            this.gz = d;
            return this;
        }
    }

    public long getBootTime() {
        return this.mBootTime;
    }

    public double getGx() {
        return this.mGx;
    }

    public double getGy() {
        return this.mGy;
    }

    public double getGz() {
        return this.mGz;
    }
}
