package com.huawei.location.lite.common.report;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import com.huawei.location.lite.common.util.TelephonyUtil;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ReportBuilder {
    protected static final String CLOUD_FENCE_TYPE = "3";
    protected static final String CP_SDK_TYPE = "1";
    protected static final String FULL_SDK_TYPE = "4";
    protected static final String OPEN_SDK_TYPE = "2";
    private static final String ROM_CN_HW = "1003";
    private static final String ROM_G_ABROAD = "1002";
    private static final String ROM_HW_PAD = "1100";
    private static final String ROM_HW_WATCH = "1200";
    private static final String ROM_NOG_ABROAD = "1001";
    private static final String ROM_NO_HW = "2001";
    private long callTime;
    private String eventId;
    protected LinkedHashMap<String, String> linkedHashMap = new SyncLinkedHashMap();

    private static class SyncLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static final Object SYNC_LOCK = new Object();

        private SyncLinkedHashMap() {
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            synchronized (SYNC_LOCK) {
                super.clear();
            }
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> setEntrySet;
            synchronized (SYNC_LOCK) {
                setEntrySet = super.entrySet();
            }
            return setEntrySet;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            V v;
            synchronized (SYNC_LOCK) {
                v = (V) super.get(obj);
            }
            return v;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public V getOrDefault(Object obj, V v) {
            V v2;
            synchronized (SYNC_LOCK) {
                v2 = (V) super.getOrDefault(obj, v);
            }
            return v2;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            V v2;
            synchronized (SYNC_LOCK) {
                v2 = (V) super.put(k, v);
            }
            return v2;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (SYNC_LOCK) {
                super.putAll(map);
            }
        }

        @Override // java.util.HashMap, java.util.Map
        public V putIfAbsent(K k, V v) {
            V v2;
            synchronized (SYNC_LOCK) {
                v2 = (V) super.putIfAbsent(k, v);
            }
            return v2;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            V v;
            synchronized (SYNC_LOCK) {
                v = (V) super.remove(obj);
            }
            return v;
        }

        @Override // java.util.HashMap, java.util.Map
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (SYNC_LOCK) {
                zRemove = super.remove(obj, obj2);
            }
            return zRemove;
        }

        @Override // java.util.AbstractMap
        public String toString() {
            String string;
            synchronized (SYNC_LOCK) {
                string = super.toString();
            }
            return string;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collectionValues;
            synchronized (SYNC_LOCK) {
                collectionValues = super.values();
            }
            return collectionValues;
        }
    }

    public ReportBuilder() {
        setBrand();
        setManufacturer();
        setCallTime();
        setWifiEnable();
        setService("hwLocation");
        setNetworkType(NetworkUtil.getNetworkState());
        setNetworkValid(NetworkUtil.isCurActiveNetInfoValid(ContextUtil.getContext()));
        setMCC(TelephonyUtil.getMcc());
        setLocationSdkType("4");
        setLBSVersionCode(APKUtil.getLBSVersionCode());
        setRomType(getRomType());
        setPackage(ContextUtil.getContext().getPackageName());
        setVersion(String.valueOf(212000300));
        if (SDKComponentType.getComponentType() == 100) {
            setAppID(AGCManager.getInstance().getAppId());
        }
    }

    public LinkedHashMap<String, String> build() {
        return this.linkedHashMap;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getMcc() {
        LinkedHashMap<String, String> linkedHashMap = this.linkedHashMap;
        return linkedHashMap == null ? "" : linkedHashMap.get("MCC");
    }

    public final String getRomType() {
        return ROMUtil.isHuaweiPlatformDevice() ? DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext()) == 1 ? ROM_HW_PAD : DeviceInfoUtil.isHuaweiWatch() ? ROM_HW_WATCH : ROMUtil.isChineseRom() ? ROM_CN_HW : ROMUtil.isGmsRom() ? ROM_G_ABROAD : ROM_NOG_ABROAD : ROM_NO_HW;
    }

    public final ReportBuilder setApiName(String str) {
        this.linkedHashMap.put("apiName", str);
        this.eventId = str;
        return this;
    }

    public final ReportBuilder setAppID(String str) {
        this.linkedHashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, str);
        return this;
    }

    public final ReportBuilder setBrand() {
        this.linkedHashMap.put("brand", DeviceInfoUtil.getBrand());
        return this;
    }

    public final ReportBuilder setCallTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.linkedHashMap.put("callTime", String.valueOf(jCurrentTimeMillis));
        this.callTime = jCurrentTimeMillis;
        return this;
    }

    public final ReportBuilder setCostTime() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.callTime;
        if (jCurrentTimeMillis <= 0) {
            jCurrentTimeMillis = 0;
        }
        this.linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(jCurrentTimeMillis));
        return this;
    }

    public final ReportBuilder setCpAppVersion(String str) {
        this.linkedHashMap.put(WiseOpenHianalyticsData.UNION_APP_VERSION, str);
        return this;
    }

    public final ReportBuilder setErrorCode(String str) {
        this.linkedHashMap.put("errorCode", str);
        return this;
    }

    public final ReportBuilder setErrorMessage(String str) {
        this.linkedHashMap.put("errorMessage", str);
        return this;
    }

    public final ReportBuilder setExt(String str) {
        this.linkedHashMap.put("ext", str);
        return this;
    }

    public final ReportBuilder setExtParam(String str, String str2) {
        this.linkedHashMap.put(str, str2);
        return this;
    }

    protected final ReportBuilder setLBSVersionCode(long j) {
        this.linkedHashMap.put("lbs_version", j + "");
        return this;
    }

    public final ReportBuilder setLocationEnable(boolean z) {
        if (!z) {
            this.linkedHashMap.put("locEnable", "false");
        }
        return this;
    }

    public final ReportBuilder setLocationSdkType(String str) {
        this.linkedHashMap.put("lcSdkType", str);
        return this;
    }

    public final ReportBuilder setMCC(String str) {
        this.linkedHashMap.put("MCC", str);
        return this;
    }

    public final ReportBuilder setManufacturer() {
        this.linkedHashMap.put("pub_mfc", DeviceInfoUtil.getManufacturer());
        return this;
    }

    public final ReportBuilder setModuleName(String str) {
        this.linkedHashMap.put("module", str);
        return this;
    }

    public final ReportBuilder setNetworkType(String str) {
        this.linkedHashMap.put("networkType", str);
        return this;
    }

    public ReportBuilder setNetworkValid(boolean z) {
        this.linkedHashMap.put("netWorkValid", "" + z);
        return this;
    }

    public final ReportBuilder setOperator(String str) {
        this.linkedHashMap.put("operator", str);
        return this;
    }

    public final ReportBuilder setPackage(String str) {
        this.linkedHashMap.put("package", str);
        return this;
    }

    public final ReportBuilder setRequestUrl(String str) {
        this.linkedHashMap.put("requestUrl", str);
        return this;
    }

    public final ReportBuilder setResult(String str) {
        this.linkedHashMap.put("result", str);
        return this;
    }

    public final ReportBuilder setRomType(String str) {
        this.linkedHashMap.put("rom_type", str);
        return this;
    }

    public final ReportBuilder setService(String str) {
        this.linkedHashMap.put("service", str);
        return this;
    }

    public final ReportBuilder setSrc(String str) {
        this.linkedHashMap.put("src", str);
        return this;
    }

    public final ReportBuilder setTag(String str) {
        this.linkedHashMap.put(RemoteMessageConst.Notification.TAG, str);
        return this;
    }

    public final ReportBuilder setTransactionID(String str) {
        this.linkedHashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, str);
        return this;
    }

    public final ReportBuilder setVersion(String str) {
        this.linkedHashMap.put("version", str);
        return this;
    }

    public final ReportBuilder setWLANScan() {
        if (!TelephonyUtil.checkWLANScan(ContextUtil.getContext())) {
            this.linkedHashMap.put("WLANScan", "false");
        }
        return this;
    }

    public final ReportBuilder setWifiEnable() {
        if (!TelephonyUtil.checkWifiIsEnable(ContextUtil.getContext())) {
            this.linkedHashMap.put("wifiEnable", "false");
        }
        return this;
    }
}
