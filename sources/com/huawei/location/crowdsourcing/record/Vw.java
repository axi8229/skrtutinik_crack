package com.huawei.location.crowdsourcing.record;

import android.os.Build;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthNr;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline1;
import com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline15;
import com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline3;
import com.huawei.hms.framework.common.NetworkUtil$$ExternalSyntheticApiModelOutline1;
import com.huawei.hms.support.api.location.common.OfflineLocationUtil$$ExternalSyntheticApiModelOutline0;
import com.huawei.hms.support.api.location.common.OfflineLocationUtil$$ExternalSyntheticApiModelOutline1;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class Vw {

    @SerializedName("RAT")
    private int E5;

    @SerializedName("LAC")
    private int FB;

    @SerializedName("CELLID")
    private long LW;

    @SerializedName("MNC")
    private int Vw;

    @SerializedName("CHANNELNUM")
    private int d2;

    @SerializedName("SIGNALSTRENGTH")
    private int dC;

    @SerializedName("BOOTTIME")
    private long ut;

    @SerializedName("MCC")
    private int yn;

    @SerializedName("PHYSICAL_IDENTITY")
    private int zp;

    Vw() {
    }

    public static void Vw(Vw vw, List<Vw> list) {
        vw.E5 = 9;
        for (Vw vw2 : list) {
            int i = vw2.E5;
            if (i == 4 || i == 3) {
                vw2.E5 = 9;
            }
        }
    }

    static boolean yn(Vw vw, List<Vw> list) {
        if (vw.E5 == 3) {
            Iterator<Vw> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().E5 == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    void Vw(com.huawei.location.crowdsourcing.common.entity.yn ynVar) {
        long j;
        if (!yn(ynVar)) {
            LogLocation.d("LocCellInfo", "set cell param failed");
            return;
        }
        int i = this.FB;
        if (i == Integer.MAX_VALUE) {
            i = -1;
        }
        this.FB = i;
        if (Build.VERSION.SDK_INT < 29 || !w0$$ExternalSyntheticApiModelOutline1.m(ynVar.Vw())) {
            int i2 = (int) this.LW;
            j = i2 != Integer.MAX_VALUE ? i2 : -1;
        } else {
            j = this.LW;
            if (j == Long.MAX_VALUE) {
                j = -1;
            }
        }
        this.LW = j;
    }

    public String toString() {
        return "LocCellInfo{mcc=" + this.yn + ", mnc=" + this.Vw + ", lac=" + this.FB + ", signalStrength=" + this.dC + ", bootTime=" + this.ut + ", Rat=" + this.E5 + ", channelNum=" + this.d2 + '}';
    }

    boolean yn(com.huawei.location.crowdsourcing.common.entity.yn ynVar) {
        CellInfo cellInfoVw = ynVar.Vw();
        if (cellInfoVw instanceof CellInfoGsm) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfoVw;
            if (cellInfoGsm != null) {
                this.yn = cellInfoGsm.getCellIdentity().getMcc();
                this.Vw = cellInfoGsm.getCellIdentity().getMnc();
                this.FB = cellInfoGsm.getCellIdentity().getLac();
                this.LW = cellInfoGsm.getCellIdentity().getCid();
                this.dC = cellInfoGsm.getCellSignalStrength().getDbm();
                this.d2 = cellInfoGsm.getCellIdentity().getArfcn();
                this.zp = cellInfoGsm.getCellIdentity().getBsic();
                this.E5 = 1;
            }
        } else if (cellInfoVw instanceof CellInfoWcdma) {
            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfoVw;
            if (cellInfoWcdma != null) {
                this.yn = cellInfoWcdma.getCellIdentity().getMcc();
                this.Vw = cellInfoWcdma.getCellIdentity().getMnc();
                this.FB = cellInfoWcdma.getCellIdentity().getLac();
                this.LW = cellInfoWcdma.getCellIdentity().getCid();
                this.dC = cellInfoWcdma.getCellSignalStrength().getDbm();
                this.d2 = cellInfoWcdma.getCellIdentity().getUarfcn();
                this.zp = cellInfoWcdma.getCellIdentity().getPsc();
                this.E5 = 2;
            }
        } else if (cellInfoVw instanceof CellInfoLte) {
            CellInfoLte cellInfoLte = (CellInfoLte) cellInfoVw;
            if (cellInfoLte != null) {
                this.yn = cellInfoLte.getCellIdentity().getMcc();
                this.Vw = cellInfoLte.getCellIdentity().getMnc();
                this.FB = cellInfoLte.getCellIdentity().getTac();
                this.LW = cellInfoLte.getCellIdentity().getCi();
                this.dC = cellInfoLte.getCellSignalStrength().getDbm();
                this.d2 = cellInfoLte.getCellIdentity().getEarfcn();
                this.zp = cellInfoLte.getCellIdentity().getPci();
                this.E5 = 3;
            }
        } else {
            if (Build.VERSION.SDK_INT < 29 || !w0$$ExternalSyntheticApiModelOutline1.m(cellInfoVw)) {
                LogLocation.e("LocCellInfo", "unknown cellInfo");
                return false;
            }
            CellInfoNr cellInfoNrM = w0$$ExternalSyntheticApiModelOutline3.m(cellInfoVw);
            if (cellInfoNrM != null) {
                CellIdentity cellIdentity = cellInfoNrM.getCellIdentity();
                if (OfflineLocationUtil$$ExternalSyntheticApiModelOutline1.m(cellIdentity)) {
                    CellIdentityNr cellIdentityNrM = w0$$ExternalSyntheticApiModelOutline15.m(cellIdentity);
                    String mccString = cellIdentityNrM.getMccString();
                    String mncString = cellIdentityNrM.getMncString();
                    this.dC = Integer.MAX_VALUE;
                    int dbm = cellInfoNrM.getCellSignalStrength().getDbm();
                    this.dC = dbm;
                    if (dbm == Integer.MAX_VALUE) {
                        CellSignalStrength cellSignalStrength = cellInfoNrM.getCellSignalStrength();
                        if (OfflineLocationUtil$$ExternalSyntheticApiModelOutline0.m(cellSignalStrength)) {
                            CellSignalStrengthNr cellSignalStrengthNrM = NetworkUtil$$ExternalSyntheticApiModelOutline1.m(cellSignalStrength);
                            int ssRsrp = cellSignalStrengthNrM.getSsRsrp();
                            int ssRsrq = cellSignalStrengthNrM.getSsRsrq();
                            int ssSinr = cellSignalStrengthNrM.getSsSinr();
                            int csiRsrp = cellSignalStrengthNrM.getCsiRsrp();
                            int csiRsrq = cellSignalStrengthNrM.getCsiRsrq();
                            int csiSinr = cellSignalStrengthNrM.getCsiSinr();
                            if (ssRsrp != Integer.MAX_VALUE && ssRsrq != Integer.MAX_VALUE && ssSinr != Integer.MAX_VALUE) {
                                if (ssRsrp > 0) {
                                    ssRsrp = -ssRsrp;
                                }
                                this.dC = ssRsrp;
                            } else if (csiRsrp != Integer.MAX_VALUE && csiRsrq != Integer.MAX_VALUE && csiSinr != Integer.MAX_VALUE) {
                                if (csiRsrp > 0) {
                                    csiRsrp = -csiRsrp;
                                }
                                this.dC = csiRsrp;
                            }
                        }
                    }
                    if (this.dC != Integer.MAX_VALUE) {
                        if (!TextUtils.isEmpty(mccString)) {
                            this.yn = Integer.parseInt(mccString);
                        }
                        if (!TextUtils.isEmpty(mncString)) {
                            this.Vw = Integer.parseInt(mncString);
                        }
                        this.LW = cellIdentityNrM.getNci();
                        this.FB = cellIdentityNrM.getTac();
                        this.d2 = cellIdentityNrM.getNrarfcn();
                        this.zp = cellIdentityNrM.getPci();
                        this.E5 = 4;
                    }
                }
            }
        }
        this.ut = ynVar.yn() / 1000000;
        return true;
    }

    public boolean yn(Vw vw) {
        return vw != null && this.yn == vw.yn && this.Vw == vw.Vw;
    }
}
