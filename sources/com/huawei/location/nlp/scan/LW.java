package com.huawei.location.nlp.scan;

import android.os.Build;
import android.os.SystemClock;
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
import android.util.Pair;
import com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline1;
import com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline15;
import com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline3;
import com.huawei.hms.framework.common.NetworkUtil$$ExternalSyntheticApiModelOutline1;
import com.huawei.hms.support.api.location.common.OfflineLocationUtil$$ExternalSyntheticApiModelOutline0;
import com.huawei.hms.support.api.location.common.OfflineLocationUtil$$ExternalSyntheticApiModelOutline1;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ReflectionUtils;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.cell.CurrentCell;
import com.huawei.location.nlp.network.request.cell.HwCellInfo;
import com.huawei.location.nlp.network.request.cell.HwNeighborCellInfo;
import com.huawei.location.nlp.network.request.cell.NeighborCell;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes3.dex */
public class LW {
    private boolean FB;
    protected long Vw = UtilsKt.UPDATE_INTERVAL;
    protected com.huawei.location.nlp.api.Vw yn;

    public LW(com.huawei.location.nlp.api.Vw vw) {
        this.yn = vw;
        this.FB = Build.VERSION.SDK_INT >= 29 ? ReflectionUtils.isSupportClass("android.telephony.CellInfoNr") : false;
    }

    private void yn(long j, long j2, long j3, HwCellInfo hwCellInfo) {
        if (j3 <= 5000000000L) {
            return;
        }
        long boottime = hwCellInfo.getBoottime();
        if (Math.abs(j - boottime) <= 30000000000L && Math.abs(j2 - boottime) >= 30000000000L) {
            hwCellInfo.setBoottime(boottime + j3);
            LogLocation.i("ScanBase", "amendCellTimeStamp bootTime is " + hwCellInfo.getBoottime());
        }
    }

    private boolean yn(HwCellInfo hwCellInfo) {
        if (hwCellInfo.getMcc() < 1 || hwCellInfo.getMcc() >= Integer.MAX_VALUE) {
            LogLocation.w("ScanBase", "hwCellInfo is invalid, mcc error");
            return false;
        }
        if (hwCellInfo.getMnc() < 0 || hwCellInfo.getMnc() >= Integer.MAX_VALUE) {
            LogLocation.w("ScanBase", "hwCellInfo is invalid, mnc error");
            return false;
        }
        if (hwCellInfo.getRssi() < -139 || hwCellInfo.getRssi() > -1) {
            LogLocation.w("ScanBase", "hwCellInfo is invalid, rssi error");
            return false;
        }
        int rat = hwCellInfo.getRat();
        long cellId = hwCellInfo.getCellId();
        if (rat != 4 ? cellId < 1 || hwCellInfo.getCellId() >= 2147483647L : cellId < 1 || hwCellInfo.getCellId() >= Long.MAX_VALUE) {
            LogLocation.w("ScanBase", "hwCellInfo is invalid, cellId error");
            return false;
        }
        if (hwCellInfo.getRat() != 4 ? hwCellInfo.getLac() < 0 || hwCellInfo.getLac() > 65535 : hwCellInfo.getLac() < 0 || hwCellInfo.getLac() > 16777215) {
            LogLocation.w("ScanBase", "hwCellInfo is invalid, lac error");
            return false;
        }
        if (hwCellInfo.getChannelNumber() >= 1 && hwCellInfo.getChannelNumber() < Integer.MAX_VALUE) {
            return true;
        }
        LogLocation.w("ScanBase", "hwCellInfo is invalid, channelNumber error");
        return false;
    }

    public static boolean yn(List<WifiInfo> list, List<WifiInfo> list2) {
        if (list2 == null || list2.isEmpty() || list.isEmpty()) {
            LogLocation.e("ScanBase", "wifi cache is null");
            return false;
        }
        if (list.size() != list2.size()) {
            return false;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < list2.size(); i++) {
            WifiInfo wifiInfo = list2.get(i);
            map.put(String.valueOf(wifiInfo.getMac()), String.valueOf(wifiInfo.getRssi()));
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            WifiInfo wifiInfo2 = list.get(i2);
            String strValueOf = String.valueOf(wifiInfo2.getMac());
            if (!map.containsKey(strValueOf) || !TextUtils.equals((CharSequence) map.get(strValueOf), String.valueOf(wifiInfo2.getRssi()))) {
                return false;
            }
        }
        return true;
    }

    public Pair<Long, List<CellSourceInfo>> Vw(List<CellInfo> list) {
        List<CellSourceInfo> arrayList = new ArrayList<>();
        if (list.isEmpty()) {
            return new Pair<>(0L, arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (CellInfo cellInfo : list) {
            if (cellInfo.isRegistered()) {
                if (cellInfo instanceof CellInfoGsm) {
                    HwCellInfo hwCellInfo = new HwCellInfo();
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    hwCellInfo.setBoottime(cellInfo.getTimeStamp());
                    hwCellInfo.setMcc(cellInfoGsm.getCellIdentity().getMcc());
                    hwCellInfo.setMnc(cellInfoGsm.getCellIdentity().getMnc());
                    hwCellInfo.setLac(cellInfoGsm.getCellIdentity().getLac());
                    hwCellInfo.setCellId(cellInfoGsm.getCellIdentity().getCid());
                    hwCellInfo.setRssi((short) cellInfoGsm.getCellSignalStrength().getDbm());
                    hwCellInfo.setRat(1);
                    hwCellInfo.setChannelNumber(cellInfoGsm.getCellIdentity().getArfcn());
                    if (yn(hwCellInfo)) {
                        arrayList2.add(hwCellInfo);
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    HwCellInfo hwCellInfo2 = new HwCellInfo();
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    hwCellInfo2.setBoottime(cellInfo.getTimeStamp());
                    hwCellInfo2.setMcc(cellInfoWcdma.getCellIdentity().getMcc());
                    hwCellInfo2.setMnc(cellInfoWcdma.getCellIdentity().getMnc());
                    hwCellInfo2.setLac(cellInfoWcdma.getCellIdentity().getLac());
                    hwCellInfo2.setCellId(cellInfoWcdma.getCellIdentity().getCid());
                    hwCellInfo2.setRssi((short) cellInfoWcdma.getCellSignalStrength().getDbm());
                    hwCellInfo2.setRat(2);
                    hwCellInfo2.setChannelNumber(cellInfoWcdma.getCellIdentity().getUarfcn());
                    if (yn(hwCellInfo2)) {
                        arrayList2.add(hwCellInfo2);
                    }
                } else if (cellInfo instanceof CellInfoLte) {
                    HwCellInfo hwCellInfo3 = new HwCellInfo();
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    hwCellInfo3.setBoottime(cellInfo.getTimeStamp());
                    hwCellInfo3.setMcc(cellInfoLte.getCellIdentity().getMcc());
                    hwCellInfo3.setMnc(cellInfoLte.getCellIdentity().getMnc());
                    hwCellInfo3.setLac(cellInfoLte.getCellIdentity().getTac());
                    hwCellInfo3.setCellId(cellInfoLte.getCellIdentity().getCi());
                    hwCellInfo3.setRssi((short) cellInfoLte.getCellSignalStrength().getDbm());
                    hwCellInfo3.setRat(3);
                    hwCellInfo3.setChannelNumber(cellInfoLte.getCellIdentity().getEarfcn());
                    if (yn(hwCellInfo3)) {
                        arrayList2.add(hwCellInfo3);
                    }
                } else if (!this.FB) {
                    LogLocation.i("ScanBase", "getCurrentCellList fail");
                } else if (Build.VERSION.SDK_INT >= 29 && w0$$ExternalSyntheticApiModelOutline1.m(cellInfo)) {
                    CellInfoNr cellInfoNrM = w0$$ExternalSyntheticApiModelOutline3.m(cellInfo);
                    CellIdentity cellIdentity = cellInfoNrM.getCellIdentity();
                    if (OfflineLocationUtil$$ExternalSyntheticApiModelOutline1.m(cellIdentity)) {
                        CellIdentityNr cellIdentityNrM = w0$$ExternalSyntheticApiModelOutline15.m(cellIdentity);
                        String mccString = cellIdentityNrM.getMccString();
                        String mncString = cellIdentityNrM.getMncString();
                        if (mccString != null && mncString != null) {
                            HwCellInfo hwCellInfo4 = new HwCellInfo();
                            hwCellInfo4.setBoottime(cellInfo.getTimeStamp());
                            hwCellInfo4.setMcc(Integer.parseInt(mccString));
                            hwCellInfo4.setMnc(Integer.parseInt(mncString));
                            hwCellInfo4.setLac(cellIdentityNrM.getTac());
                            hwCellInfo4.setCellId(cellIdentityNrM.getNci());
                            hwCellInfo4.setRssi((short) yn(cellInfoNrM));
                            hwCellInfo4.setRat(4);
                            hwCellInfo4.setChannelNumber(cellIdentityNrM.getNrarfcn());
                            if (yn(hwCellInfo4)) {
                                arrayList2.add(hwCellInfo4);
                            }
                        }
                    }
                }
            } else if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm2 = (CellInfoGsm) cellInfo;
                HwNeighborCellInfo hwNeighborCellInfo = new HwNeighborCellInfo();
                hwNeighborCellInfo.setMcc(cellInfoGsm2.getCellIdentity().getMcc());
                hwNeighborCellInfo.setMnc(cellInfoGsm2.getCellIdentity().getMnc());
                hwNeighborCellInfo.setRssi((short) cellInfoGsm2.getCellSignalStrength().getDbm());
                hwNeighborCellInfo.setRat(1);
                hwNeighborCellInfo.setChannelNumber(cellInfoGsm2.getCellIdentity().getArfcn());
                hwNeighborCellInfo.setPhysicalIdentity(cellInfoGsm2.getCellIdentity().getBsic());
                arrayList3.add(hwNeighborCellInfo);
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma2 = (CellInfoWcdma) cellInfo;
                HwNeighborCellInfo hwNeighborCellInfo2 = new HwNeighborCellInfo();
                hwNeighborCellInfo2.setMcc(cellInfoWcdma2.getCellIdentity().getMcc());
                hwNeighborCellInfo2.setMnc(cellInfoWcdma2.getCellIdentity().getMnc());
                hwNeighborCellInfo2.setPhysicalIdentity(cellInfoWcdma2.getCellIdentity().getPsc());
                hwNeighborCellInfo2.setRssi((short) cellInfoWcdma2.getCellSignalStrength().getDbm());
                hwNeighborCellInfo2.setRat(2);
                hwNeighborCellInfo2.setChannelNumber(cellInfoWcdma2.getCellIdentity().getUarfcn());
                arrayList3.add(hwNeighborCellInfo2);
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte2 = (CellInfoLte) cellInfo;
                HwNeighborCellInfo hwNeighborCellInfo3 = new HwNeighborCellInfo();
                hwNeighborCellInfo3.setMcc(cellInfoLte2.getCellIdentity().getMcc());
                hwNeighborCellInfo3.setMnc(cellInfoLte2.getCellIdentity().getMnc());
                hwNeighborCellInfo3.setPhysicalIdentity(cellInfoLte2.getCellIdentity().getPci());
                hwNeighborCellInfo3.setRssi((short) cellInfoLte2.getCellSignalStrength().getDbm());
                hwNeighborCellInfo3.setRat(3);
                hwNeighborCellInfo3.setChannelNumber(cellInfoLte2.getCellIdentity().getEarfcn());
                arrayList3.add(hwNeighborCellInfo3);
            } else if (!this.FB) {
                LogLocation.e("ScanBase", "getNeighborCellInfoList fail");
            } else if (Build.VERSION.SDK_INT >= 29 && w0$$ExternalSyntheticApiModelOutline1.m(cellInfo)) {
                CellInfoNr cellInfoNrM2 = w0$$ExternalSyntheticApiModelOutline3.m(cellInfo);
                CellIdentity cellIdentity2 = cellInfoNrM2.getCellIdentity();
                if (OfflineLocationUtil$$ExternalSyntheticApiModelOutline1.m(cellIdentity2)) {
                    CellIdentityNr cellIdentityNrM2 = w0$$ExternalSyntheticApiModelOutline15.m(cellIdentity2);
                    String mccString2 = cellIdentityNrM2.getMccString();
                    String mncString2 = cellIdentityNrM2.getMncString();
                    if (mccString2 != null && mncString2 != null) {
                        HwNeighborCellInfo hwNeighborCellInfo4 = new HwNeighborCellInfo();
                        hwNeighborCellInfo4.setMcc(Integer.parseInt(mccString2));
                        hwNeighborCellInfo4.setMnc(Integer.parseInt(mncString2));
                        hwNeighborCellInfo4.setPhysicalIdentity(cellIdentityNrM2.getPci());
                        hwNeighborCellInfo4.setRssi((short) yn(cellInfoNrM2));
                        hwNeighborCellInfo4.setRat(4);
                        hwNeighborCellInfo4.setChannelNumber(cellIdentityNrM2.getNrarfcn());
                        arrayList3.add(hwNeighborCellInfo4);
                    }
                }
            }
        }
        int size = arrayList2.size();
        long jNanoTime = System.nanoTime();
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long j = jElapsedRealtimeNanos < jNanoTime ? 0L : jElapsedRealtimeNanos - jNanoTime;
        LogLocation.i("ScanBase", "current cell is " + size + ", neighbor Cell size is " + arrayList3.size());
        if (size == 2 && ((HwCellInfo) arrayList2.get(0)).getMcc() == ((HwCellInfo) arrayList2.get(1)).getMcc() && ((HwCellInfo) arrayList2.get(0)).getMnc() == ((HwCellInfo) arrayList2.get(1)).getMnc() && ((HwCellInfo) arrayList2.get(0)).getRat() == ((HwCellInfo) arrayList2.get(1)).getRat()) {
            yn((HwCellInfo) arrayList2.get(1), arrayList3, arrayList);
            yn(jNanoTime, jElapsedRealtimeNanos, j, (HwCellInfo) arrayList2.get(1));
            return new Pair<>(Long.valueOf(((HwCellInfo) arrayList2.get(1)).getBoottime()), arrayList);
        }
        long boottime = -1;
        for (int i = 0; i < size; i++) {
            HwCellInfo hwCellInfo5 = (HwCellInfo) arrayList2.get(i);
            yn(hwCellInfo5, arrayList3, arrayList);
            if (hwCellInfo5.getBoottime() >= boottime) {
                yn(jNanoTime, jElapsedRealtimeNanos, j, hwCellInfo5);
                boottime = hwCellInfo5.getBoottime();
            }
        }
        return new Pair<>(Long.valueOf(boottime), arrayList);
    }

    public int yn(CellInfoNr cellInfoNr) {
        int dbm = cellInfoNr.getCellSignalStrength().getDbm();
        if (dbm != Integer.MAX_VALUE) {
            return dbm;
        }
        CellSignalStrength cellSignalStrength = cellInfoNr.getCellSignalStrength();
        if (!OfflineLocationUtil$$ExternalSyntheticApiModelOutline0.m(cellSignalStrength)) {
            return Integer.MAX_VALUE;
        }
        CellSignalStrengthNr cellSignalStrengthNrM = NetworkUtil$$ExternalSyntheticApiModelOutline1.m(cellSignalStrength);
        int ssRsrp = cellSignalStrengthNrM.getSsRsrp();
        int ssRsrq = cellSignalStrengthNrM.getSsRsrq();
        int ssSinr = cellSignalStrengthNrM.getSsSinr();
        int csiRsrp = cellSignalStrengthNrM.getCsiRsrp();
        int csiRsrq = cellSignalStrengthNrM.getCsiRsrq();
        int csiSinr = cellSignalStrengthNrM.getCsiSinr();
        if (ssRsrp != Integer.MAX_VALUE && ssRsrq != Integer.MAX_VALUE && ssSinr != Integer.MAX_VALUE) {
            return ssRsrp > 0 ? -ssRsrp : ssRsrp;
        }
        if (csiRsrp != Integer.MAX_VALUE && csiRsrq != Integer.MAX_VALUE && csiSinr != Integer.MAX_VALUE) {
            return csiRsrp > 0 ? -csiRsrp : csiRsrp;
        }
        LogLocation.d("ScanBase", "getCellSignalStrength error");
        return dbm;
    }

    public void yn(HwCellInfo hwCellInfo, List<HwNeighborCellInfo> list, List<CellSourceInfo> list2) {
        boolean z;
        String str = hwCellInfo.getMcc() + "_" + hwCellInfo.getMnc();
        if (hwCellInfo.getRat() == 2 || hwCellInfo.getRat() == 3) {
            str = str + "_" + hwCellInfo.getChannelNumber();
            z = true;
        } else {
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                HwNeighborCellInfo hwNeighborCellInfo = list.get(i);
                String str2 = hwNeighborCellInfo.getMcc() + "_" + hwNeighborCellInfo.getMnc();
                if (z) {
                    str2 = str2 + "_" + hwNeighborCellInfo.getChannelNumber();
                }
                if (str2.equals(str)) {
                    arrayList.add(new NeighborCell(hwNeighborCellInfo.getChannelNumber(), hwNeighborCellInfo.getPhysicalIdentity(), hwNeighborCellInfo.getRssi()));
                }
                if (arrayList.size() == 8) {
                    break;
                }
            }
        }
        CurrentCell currentCell = new CurrentCell();
        currentCell.setBoottime(hwCellInfo.getBoottime());
        currentCell.setMcc(hwCellInfo.getMcc());
        currentCell.setMnc(hwCellInfo.getMnc());
        currentCell.setLac(hwCellInfo.getLac());
        currentCell.setCellId(hwCellInfo.getCellId());
        currentCell.setRat(hwCellInfo.getRat());
        currentCell.setRssi(hwCellInfo.getRssi());
        list2.add(new CellSourceInfo(currentCell, arrayList));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0150 A[EDGE_INSN: B:78:0x0150->B:58:0x0150 BREAK  A[LOOP:1: B:44:0x0105->B:79:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<java.lang.Long, java.util.List<com.huawei.location.nlp.network.request.wifi.WifiInfo>> yn(java.util.List<android.net.wifi.ScanResult> r19) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.nlp.scan.LW.yn(java.util.List):android.util.Pair");
    }
}
