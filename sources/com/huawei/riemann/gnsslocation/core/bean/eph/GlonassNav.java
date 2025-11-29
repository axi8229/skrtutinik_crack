package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes3.dex */
public class GlonassNav {
    public double mDeltaTau;
    public int mEn;
    public double mGamma;
    public int mHealth;
    public int mIod;
    public int mM;
    public int mP1;
    public int mP2;
    public int mSvid;
    public double mTaun;
    public double mX;
    public double mXDot;
    public double mXDotDot;
    public double mY;
    public double mYDot;
    public double mYDotDot;
    public double mZ;
    public double mZDot;
    public double mZDotDot;

    public static final class Builder {
        public double deltaTau;
        public int en;
        public double gamma;
        public int health;
        public int iod;
        public int m;
        public int p1;
        public int p2;
        public int svid;
        public double taun;
        public double x;
        public double xDot;
        public double xDotDot;
        public double y;
        public double yDot;
        public double yDotDot;
        public double z;
        public double zDot;
        public double zDotDot;

        public static Builder aGlonassNav() {
            return new Builder();
        }

        public GlonassNav build() {
            GlonassNav glonassNav = new GlonassNav();
            glonassNav.mTaun = this.taun;
            glonassNav.mZDotDot = this.zDotDot;
            glonassNav.mSvid = this.svid;
            glonassNav.mM = this.m;
            glonassNav.mYDot = this.yDot;
            glonassNav.mP1 = this.p1;
            glonassNav.mXDot = this.xDot;
            glonassNav.mXDotDot = this.xDotDot;
            glonassNav.mYDotDot = this.yDotDot;
            glonassNav.mZ = this.z;
            glonassNav.mIod = this.iod;
            glonassNav.mGamma = this.gamma;
            glonassNav.mDeltaTau = this.deltaTau;
            glonassNav.mX = this.x;
            glonassNav.mP2 = this.p2;
            glonassNav.mEn = this.en;
            glonassNav.mZDot = this.zDot;
            glonassNav.mY = this.y;
            glonassNav.mHealth = this.health;
            return glonassNav;
        }

        public Builder but() {
            return aGlonassNav().withSvid(this.svid).withHealth(this.health).withIod(this.iod).withTaun(this.taun).withGamma(this.gamma).withDeltaTau(this.deltaTau).withEn(this.en).withP1(this.p1).withP2(this.p2).withM(this.m).withX(this.x).withY(this.y).withZ(this.z).withXDot(this.xDot).withYDot(this.yDot).withZDot(this.zDot).withXDotDot(this.xDotDot).withYDotDot(this.yDotDot).withZDotDot(this.zDotDot);
        }

        public Builder withDeltaTau(double d) {
            this.deltaTau = d;
            return this;
        }

        public Builder withEn(int i) {
            this.en = i;
            return this;
        }

        public Builder withGamma(double d) {
            this.gamma = d;
            return this;
        }

        public Builder withHealth(int i) {
            this.health = i;
            return this;
        }

        public Builder withIod(int i) {
            this.iod = i;
            return this;
        }

        public Builder withM(int i) {
            this.m = i;
            return this;
        }

        public Builder withP1(int i) {
            this.p1 = i;
            return this;
        }

        public Builder withP2(int i) {
            this.p2 = i;
            return this;
        }

        public Builder withSvid(int i) {
            this.svid = i;
            return this;
        }

        public Builder withTaun(double d) {
            this.taun = d;
            return this;
        }

        public Builder withX(double d) {
            this.x = d;
            return this;
        }

        public Builder withXDot(double d) {
            this.xDot = d;
            return this;
        }

        public Builder withXDotDot(double d) {
            this.xDotDot = d;
            return this;
        }

        public Builder withY(double d) {
            this.y = d;
            return this;
        }

        public Builder withYDot(double d) {
            this.yDot = d;
            return this;
        }

        public Builder withYDotDot(double d) {
            this.yDotDot = d;
            return this;
        }

        public Builder withZ(double d) {
            this.z = d;
            return this;
        }

        public Builder withZDot(double d) {
            this.zDot = d;
            return this;
        }

        public Builder withZDotDot(double d) {
            this.zDotDot = d;
            return this;
        }
    }

    public double getDeltaTau() {
        return this.mDeltaTau;
    }

    public int getEn() {
        return this.mEn;
    }

    public double getGamma() {
        return this.mGamma;
    }

    public int getHealth() {
        return this.mHealth;
    }

    public int getIod() {
        return this.mIod;
    }

    public int getM() {
        return this.mM;
    }

    public int getP1() {
        return this.mP1;
    }

    public int getP2() {
        return this.mP2;
    }

    public int getSvid() {
        return this.mSvid;
    }

    public double getTaun() {
        return this.mTaun;
    }

    public double getX() {
        return this.mX;
    }

    public double getY() {
        return this.mY;
    }

    public double getZ() {
        return this.mZ;
    }

    public double getxDot() {
        return this.mXDot;
    }

    public double getxDotDot() {
        return this.mXDotDot;
    }

    public double getyDot() {
        return this.mYDot;
    }

    public double getyDotDot() {
        return this.mYDotDot;
    }

    public double getzDot() {
        return this.mZDot;
    }

    public double getzDotDot() {
        return this.mZDotDot;
    }
}
