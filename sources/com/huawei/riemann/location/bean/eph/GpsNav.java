package com.huawei.riemann.location.bean.eph;

/* loaded from: classes3.dex */
public class GpsNav {
    public int mAcc;
    public double mAf0;
    public double mAf1;
    public double mAf2;
    public int mAodo;
    public double mCic;
    public double mCis;
    public double mCrc;
    public double mCrs;
    public double mCuc;
    public double mCus;
    public double mDeltaN;
    public double mEcc;
    public double mGpsTow23b;
    public double mGroupDelay;
    public int mHealth;
    public double mI0;
    public double mIDot;
    public int mIodc;
    public int mIode;
    public double mM0;
    public double mOmega;
    public double mOmega0;
    public double mOmegaDot;
    public double mSqrtA;
    public int mSvid;
    public int mToc;
    public int mToe;
    public int mWeekNumber;

    public static final class Builder {
        public int acc;
        public double af0;
        public double af1;
        public double af2;
        public int aodo;
        public double cic;
        public double cis;
        public double crc;
        public double crs;
        public double cuc;
        public double cus;
        public double deltaN;
        public double ecc;
        public double gpsTow23b;
        public double groupDelay;
        public int health;
        public double i0;
        public double idot;
        public int iodc;
        public int iode;
        public double m0;
        public double omega;
        public double omega0;
        public double omegaDot;
        public double sqrtA;
        public int svid;
        public int toc;
        public int toe;
        public int weekNumber;

        public static Builder aGpsNav() {
            return new Builder();
        }

        public GpsNav build() {
            GpsNav gpsNav = new GpsNav();
            gpsNav.mGroupDelay = this.groupDelay;
            gpsNav.mAf0 = this.af0;
            gpsNav.mAcc = this.acc;
            gpsNav.mIode = this.iode;
            gpsNav.mCrs = this.crs;
            gpsNav.mCis = this.cis;
            gpsNav.mEcc = this.ecc;
            gpsNav.mOmega = this.omega;
            gpsNav.mCus = this.cus;
            gpsNav.mGpsTow23b = this.gpsTow23b;
            gpsNav.mAf2 = this.af2;
            gpsNav.mWeekNumber = this.weekNumber;
            gpsNav.mIDot = this.idot;
            gpsNav.mHealth = this.health;
            gpsNav.mToe = this.toe;
            gpsNav.mSqrtA = this.sqrtA;
            gpsNav.mM0 = this.m0;
            gpsNav.mCuc = this.cuc;
            gpsNav.mI0 = this.i0;
            gpsNav.mOmegaDot = this.omegaDot;
            gpsNav.mAodo = this.aodo;
            gpsNav.mAf1 = this.af1;
            gpsNav.mIodc = this.iodc;
            gpsNav.mToc = this.toc;
            gpsNav.mSvid = this.svid;
            gpsNav.mDeltaN = this.deltaN;
            gpsNav.mOmega0 = this.omega0;
            gpsNav.mCic = this.cic;
            gpsNav.mCrc = this.crc;
            return gpsNav;
        }

        public Builder but() {
            return aGpsNav().withSvid(this.svid).withAcc(this.acc).withIodc(this.iodc).withIode(this.iode).withAodo(this.aodo).withM0(this.m0).withDeltaN(this.deltaN).withEcc(this.ecc).withSqrtA(this.sqrtA).withOmega0(this.omega0).withI0(this.i0).withOmega(this.omega).withOmegaDot(this.omegaDot).withIdot(this.idot).withCuc(this.cuc).withCus(this.cus).withCrc(this.crc).withCrs(this.crs).withCic(this.cic).withCis(this.cis).withGroupDelay(this.groupDelay).withAf0(this.af0).withAf1(this.af1).withAf2(this.af2).withHealth(this.health).withToc(this.toc).withToe(this.toe).withGpsTow23b(this.gpsTow23b).withWeekNumber(this.weekNumber);
        }

        public Builder withAcc(int i) {
            this.acc = i;
            return this;
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

        public Builder withAodo(int i) {
            this.aodo = i;
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

        public Builder withGpsTow23b(double d) {
            this.gpsTow23b = d;
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

        public Builder withIdot(double d) {
            this.idot = d;
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

        public Builder withWeekNumber(int i) {
            this.weekNumber = i;
            return this;
        }
    }

    public int getAcc() {
        return this.mAcc;
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

    public int getAodo() {
        return this.mAodo;
    }

    public double getCic() {
        return this.mCic;
    }

    public double getCis() {
        return this.mCis;
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

    public double getGpsTow23b() {
        return this.mGpsTow23b;
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

    public double getIDot() {
        return this.mIDot;
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

    public int getWeekNumber() {
        return this.mWeekNumber;
    }
}
