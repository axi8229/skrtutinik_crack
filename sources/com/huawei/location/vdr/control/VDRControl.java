package com.huawei.location.vdr.control;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.SystemPropertiesUtil;
import com.huawei.location.vdr.util.Vw;
import com.huawei.location.vdr.util.yn;

/* loaded from: classes3.dex */
public class VDRControl {
    private static final String TAG = "VDRControl";
    private static final String VDR_ENABLE = "1";
    public static final String VDR_GNSS_OPTION = "vdrEnable";
    private VDRConfig config;

    public VDRControl() {
        this.config = null;
        VDRConfig vDRConfig = new VDRConfig();
        this.config = vDRConfig;
        vDRConfig.Vw();
    }

    public boolean isSpeedSupport(int i) {
        VDRConfig vDRConfig = this.config;
        return vDRConfig != null && vDRConfig.yn(i);
    }

    public boolean isSupport(String str) {
        if (this.config == null) {
            this.config = new VDRConfig();
        }
        return this.config.yn() && this.config.yn(str) && this.config.yn(yn.yn(SystemPropertiesUtil.getPlatform()), Vw.yn(Build.VERSION.SDK_INT));
    }

    public boolean isVdrRequest(String str) {
        LogLocation.i(TAG, "isVdrRequest:" + str);
        return TextUtils.equals(VDR_ENABLE, str);
    }
}
