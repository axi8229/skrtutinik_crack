package com.huawei.riemann.location.bean.obs;

import com.yandex.varioqub.config.model.ConfigValue;

/* loaded from: classes3.dex */
public class Pvt {
    public int mErrCode = 0;
    public double mLatitude = ConfigValue.DOUBLE_DEFAULT_VALUE;
    public double mLongitude = ConfigValue.DOUBLE_DEFAULT_VALUE;
    public double mAltitude = ConfigValue.DOUBLE_DEFAULT_VALUE;
    public float mSpeed = 0.0f;
    public float mAccuracy = 0.0f;
    public float mBearing = 0.0f;
    public long mTime = 0;

    public static final class Builder {
        public int mErrCode = 0;
        public double mLatitude = ConfigValue.DOUBLE_DEFAULT_VALUE;
        public double mLongitude = ConfigValue.DOUBLE_DEFAULT_VALUE;
        public double mAltitude = ConfigValue.DOUBLE_DEFAULT_VALUE;
        public float mSpeed = 0.0f;
        public float mAccuracy = 0.0f;
        public float mBearing = 0.0f;
        public long mTime = 0;

        public static Builder aPvt() {
            return new Builder();
        }

        public Pvt build() {
            Pvt pvt = new Pvt();
            pvt.mErrCode = this.mErrCode;
            pvt.mLatitude = this.mLatitude;
            pvt.mLongitude = this.mLongitude;
            pvt.mBearing = this.mBearing;
            pvt.mTime = this.mTime;
            pvt.mAltitude = this.mAltitude;
            pvt.mSpeed = this.mSpeed;
            pvt.mAccuracy = this.mAccuracy;
            return pvt;
        }

        public Builder but() {
            return aPvt().withErrCode(this.mErrCode).withLatitude(this.mLatitude).withLongitude(this.mLongitude).withAltitude(this.mAltitude).withSpeed(this.mSpeed).withAccuracy(this.mAccuracy).withBearing(this.mBearing).withTime(this.mTime);
        }

        public Builder withAccuracy(float f) {
            this.mAccuracy = f;
            return this;
        }

        public Builder withAltitude(double d) {
            this.mAltitude = d;
            return this;
        }

        public Builder withBearing(float f) {
            this.mBearing = f;
            return this;
        }

        public Builder withErrCode(int i) {
            this.mErrCode = i;
            return this;
        }

        public Builder withLatitude(double d) {
            this.mLatitude = d;
            return this;
        }

        public Builder withLongitude(double d) {
            this.mLongitude = d;
            return this;
        }

        public Builder withSpeed(float f) {
            this.mSpeed = f;
            return this;
        }

        public Builder withTime(long j) {
            this.mTime = j;
            return this;
        }
    }

    public float getAccuracy() {
        return this.mAccuracy;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.mBearing;
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public long getTime() {
        return this.mTime;
    }
}
