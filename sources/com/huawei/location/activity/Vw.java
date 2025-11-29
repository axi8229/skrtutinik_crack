package com.huawei.location.activity;

import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.util.LoadSoUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import java.io.File;

/* loaded from: classes3.dex */
public class Vw {
    public static final String Vw;
    public static final String yn;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(LocationUtil.getFilePath(ContextUtil.getContext()));
        String str = File.separator;
        sb.append(str);
        yn = sb.toString();
        Vw = LocationUtil.getFilePath(ContextUtil.getContext()) + str + LoadSoUtil.getCurrentCpuAbi(ContextUtil.getContext());
    }
}
