package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes3.dex */
public class GalileoNav {
    public double mAf0;
    public double mAf1;
    public double mAf2;
    public double mCic;
    public double mCis;
    public int mClockModelId;
    public double mCrc;
    public double mCrs;
    public double mCuc;
    public double mCus;
    public double mDeltaN;
    public double mEcc;
    public double mGroupDelay;
    public int mHealth;
    public double mI0;
    public double mIDot;
    public int mIodc;
    public int mIode;
    public double mM0;
    public int mNumClockModel;
    public double mOmega;
    public double mOmega0;
    public double mOmegaDot;
    public double mSqrtA;
    public int mSvid;
    public int mToc;
    public int mToe;

    public static final class Builder {
        public double af0;
        public double af1;
        public double af2;
        public double cic;
        public double cis;
        public int clockModelId;
        public double crc;
        public double crs;
        public double cuc;
        public double cus;
        public double deltaN;
        public double ecc;
        public double groupDelay;
        public int health;
        public double i0;
        public double iDot;
        public int iodc;
        public int iode;
        public double m0;
        public int numClockModel;
        public double omega;
        public double omega0;
        public double omegaDot;
        public double sqrtA;
        public int svid;
        public int toc;
        public int toe;

        public static Builder aGalileoNav() {
            return new Builder();
        }

        public GalileoNav build() {
            GalileoNav galileoNav = new GalileoNav();
            galileoNav.mAf0 = this.af0;
            galileoNav.mGroupDelay = this.groupDelay;
            galileoNav.mEcc = this.ecc;
            galileoNav.mOmegaDot = this.omegaDot;
            galileoNav.mCrc = this.crc;
            galileoNav.mCuc = this.cuc;
            galileoNav.mCic = this.cic;
            galileoNav.mIDot = this.iDot;
            galileoNav.mOmega = this.omega;
            galileoNav.mCis = this.cis;
            galileoNav.mHealth = this.health;
            galileoNav.mSqrtA = this.sqrtA;
            galileoNav.mOmega0 = this.omega0;
            galileoNav.mCrs = this.crs;
            galileoNav.mDeltaN = this.deltaN;
            galileoNav.mM0 = this.m0;
            galileoNav.mToc = this.toc;
            galileoNav.mI0 = this.i0;
            galileoNav.mCus = this.cus;
            galileoNav.mSvid = this.svid;
            galileoNav.mIodc = this.iodc;
            galileoNav.mAf1 = this.af1;
            galileoNav.mToe = this.toe;
            galileoNav.mAf2 = this.af2;
            galileoNav.mIode = this.iode;
            galileoNav.mClockModelId = this.clockModelId;
            galileoNav.mNumClockModel = this.numClockModel;
            return galileoNav;
        }

        public Builder but() {
            return aGalileoNav().withSvid(this.svid).withIodc(this.iodc).withIode(this.iode).withM0(this.m0).withDeltaN(this.deltaN).withEcc(this.ecc).withSqrtA(this.sqrtA).withOmega0(this.omega0).withI0(this.i0).withOmega(this.omega).withOmegaDot(this.omegaDot).withIDot(this.iDot).withCuc(this.cuc).withCus(this.cus).withCrc(this.crc).withCrs(this.crs).withCic(this.cic).withCis(this.cis).withGroupDelay(this.groupDelay).withAf0(this.af0).withAf1(this.af1).withAf2(this.af2).withHealth(this.health).withToc(this.toc).withToe(this.toe).withClockModelId(this.clockModelId).withNumClockModel(this.numClockModel);
        }

        public Builder withAf0(double d) {
            this.af0 = d;
            return this;
        }

        public Builder withAf1(double d) {
            this.af1 = d;
            return this;
        }

        public Builder withAf2(double d) {
            this.af2 = d;
            return this;
        }

        public Builder withCic(double d) {
            this.cic = d;
            return this;
        }

        public Builder withCis(double d) {
            this.cis = d;
            return this;
        }

        public Builder withClockModelId(int i) {
            this.clockModelId = i;
            return this;
        }

        public Builder withCrc(double d) {
            this.crc = d;
            return this;
        }

        public Builder withCrs(double d) {
            this.crs = d;
            return this;
        }

        public Builder withCuc(double d) {
            this.cuc = d;
            return this;
        }

        public Builder withCus(double d) {
            this.cus = d;
            return this;
        }

        public Builder withDeltaN(double d) {
            this.deltaN = d;
            return this;
        }

        public Builder withEcc(double d) {
            this.ecc = d;
            return this;
        }

        public Builder withGroupDelay(double d) {
            this.groupDelay = d;
            return this;
        }

        public Builder withHealth(int i) {
            this.health = i;
            return this;
        }

        public Builder withI0(double d) {
            this.i0 = d;
            return this;
        }

        public Builder withIDot(double d) {
            this.iDot = d;
            return this;
        }

        public Builder withIodc(int i) {
            this.iodc = i;
            return this;
        }

        public Builder withIode(int i) {
            this.iode = i;
            return this;
        }

        public Builder withM0(double d) {
            this.m0 = d;
            return this;
        }

        public Builder withNumClockModel(int i) {
            this.numClockModel = i;
            return this;
        }

        public Builder withOmega(double d) {
            this.omega = d;
            return this;
        }

        public Builder withOmega0(double d) {
            this.omega0 = d;
            return this;
        }

        public Builder withOmegaDot(double d) {
            this.omegaDot = d;
            return this;
        }

        public Builder withSqrtA(double d) {
            this.sqrtA = d;
            return this;
        }

        public Builder withSvid(int i) {
            this.svid = i;
            return this;
        }

        public Builder withToc(int i) {
            this.toc = i;
            return this;
        }

        public Builder withToe(int i) {
            this.toe = i;
            return this;
        }
    }

    public double getAf0() {
        return this.mAf0;
    }

    public double getAf1() {
        return this.mAf1;
    }

    public double getAf2() {
        return this.mAf2;
    }

    public double getCic() {
        return this.mCic;
    }

    public double getCis() {
        return this.mCis;
    }

    public int getClockModelId() {
        return this.mClockModelId;
    }

    public double getCrc() {
        return this.mCrc;
    }

    public double getCrs() {
        return this.mCrs;
    }

    public double getCuc() {
        return this.mCuc;
    }

    public double getCus() {
        return this.mCus;
    }

    public double getDeltaN() {
        return this.mDeltaN;
    }

    public double getEcc() {
        return this.mEcc;
    }

    public double getGroupDelay() {
        return this.mGroupDelay;
    }

    public int getHealth() {
        return this.mHealth;
    }

    public double getI0() {
        return this.mI0;
    }

    public int getIodc() {
        return this.mIodc;
    }

    public int getIode() {
        return this.mIode;
    }

    public double getM0() {
        return this.mM0;
    }

    public int getNumClockModel() {
        return this.mNumClockModel;
    }

    public double getOmega() {
        return this.mOmega;
    }

    public double getOmega0() {
        return this.mOmega0;
    }

    public double getOmegaDot() {
        return this.mOmegaDot;
    }

    public double getSqrtA() {
        return this.mSqrtA;
    }

    public int getSvid() {
        return this.mSvid;
    }

    public int getToc() {
        return this.mToc;
    }

    public int getToe() {
        return this.mToe;
    }

    public double getiDot() {
        return this.mIDot;
    }
}
