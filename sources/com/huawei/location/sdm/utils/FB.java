package com.huawei.location.sdm.utils;

import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.IDownloadResult;
import java.io.File;

/* loaded from: classes3.dex */
class FB implements IDownloadResult {
    final /* synthetic */ yn yn;

    FB(yn ynVar) {
        this.yn = ynVar;
    }

    @Override // com.huawei.location.lite.common.util.filedownload.IDownloadResult
    public void onFail(int i, String str) {
        if (i == 10005) {
            this.yn.yn.saveLong("libSdm_last_time", System.currentTimeMillis());
        }
        LogLocation.e("SdmFileManager", "download error errorCode:" + i + " errorDesc:" + str);
    }

    @Override // com.huawei.location.lite.common.util.filedownload.IDownloadResult
    public void onSuccess(DownLoadFileBean downLoadFileBean, File file) {
        if (downLoadFileBean == null) {
            return;
        }
        yn.yn(this.yn, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
    }
}
