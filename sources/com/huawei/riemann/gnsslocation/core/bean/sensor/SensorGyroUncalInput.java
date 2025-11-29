package com.huawei.riemann.gnsslocation.core.bean.sensor;

/* loaded from: classes3.dex */
public class SensorGyroUncalInput {
    public double mBiasx;
    public double mBiasy;
    public double mBiasz;
    public long mBootTime;
    public double mUgx;
    public double mUgy;
    public double mUgz;

    public static final class Builder {
        public double biasx;
        public double biasy;
        public double biasz;
        public long bootTime;
        public double ugx;
        public double ugy;
        public double ugz;

        public static Builder aSensorGyroUncalInput() {
            return new Builder();
        }

        public SensorGyroUncalInput build() {
            SensorGyroUncalInput sensorGyroUncalInput = new SensorGyroUncalInput();
            sensorGyroUncalInput.mBootTime = this.bootTime;
            sensorGyroUncalInput.mUgx = this.ugx;
            sensorGyroUncalInput.mUgy = this.ugy;
            sensorGyroUncalInput.mUgz = this.ugz;
            sensorGyroUncalInput.mBiasx = this.biasx;
            sensorGyroUncalInput.mBiasy = this.biasy;
            sensorGyroUncalInput.mBiasz = this.biasz;
            return sensorGyroUncalInput;
        }

        public Builder but() {
            return aSensorGyroUncalInput().withBt(this.bootTime).withUgx(this.ugx).withUgy(this.ugy).withUgz(this.ugz).withBiasx(this.biasx).withBiasy(this.biasy).withBiasz(this.biasz);
        }

        public Builder withBiasx(double d) {
            this.biasx = d;
            return this;
        }

        public Builder withBiasy(double d) {
            this.biasy = d;
            return this;
        }

        public Builder withBiasz(double d) {
            this.biasz = d;
            return this;
        }

        public Builder withBt(long j) {
            this.bootTime = j;
            return this;
        }

        public Builder withUgx(double d) {
            this.ugx = d;
            return this;
        }

        public Builder withUgy(double d) {
            this.ugy = d;
            return this;
        }

        public Builder withUgz(double d) {
            this.ugz = d;
            return this;
        }
    }

    public double getBiasx() {
        return this.mBiasx;
    }

    public double getBiasy() {
        return this.mBiasy;
    }

    public double getBiasz() {
        return this.mBiasz;
    }

    public long getBootTime() {
        return this.mBootTime;
    }

    public double getUgx() {
        return this.mUgx;
    }

    public double getUgy() {
        return this.mUgy;
    }

    public double getUgz() {
        return this.mUgz;
    }
}
