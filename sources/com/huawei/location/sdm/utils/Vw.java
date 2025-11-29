package com.huawei.location.sdm.utils;

import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.IDownloadSupport;

/* loaded from: classes3.dex */
class Vw implements IDownloadSupport {
    final /* synthetic */ yn yn;

    Vw(yn ynVar) {
        this.yn = ynVar;
    }

    @Override // com.huawei.location.lite.common.util.filedownload.IDownloadSupport
    public boolean isSupportDownloadFile(DownLoadFileBean downLoadFileBean) {
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        if (this.yn.Vw()) {
            yn ynVar = this.yn;
            if (!yn.yn(ynVar, version, ynVar.Vw)) {
                return false;
            }
        }
        return true;
    }
}
