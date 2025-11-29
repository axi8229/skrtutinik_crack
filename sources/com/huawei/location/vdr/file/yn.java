package com.huawei.location.vdr.file;

import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileManager;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import com.huawei.location.lite.common.util.filedownload.IDownloadResult;
import com.huawei.location.lite.common.util.filedownload.IDownloadSupport;
import com.huawei.location.lite.common.util.unzip.Un7Z;
import com.huawei.location.vdr.listener.FB;
import com.huawei.secure.android.common.encrypt.hash.FileSHA256;
import java.io.File;

/* loaded from: classes3.dex */
public class yn {
    private FB FB;
    private String Vw;
    private PreferencesHelper yn;

    class Vw implements IDownloadResult {
        Vw() {
        }

        @Override // com.huawei.location.lite.common.util.filedownload.IDownloadResult
        public void onFail(int i, String str) {
            yn ynVar;
            boolean z;
            if (i == 10005) {
                yn.this.yn.saveLong("libVdr_last_time", System.currentTimeMillis());
                ynVar = yn.this;
                z = true;
            } else {
                ynVar = yn.this;
                z = false;
            }
            yn.yn(ynVar, z);
            LogLocation.e("VdrFileManager", "download error errorCode:" + i + " errorDesc:" + str);
        }

        @Override // com.huawei.location.lite.common.util.filedownload.IDownloadResult
        public void onSuccess(DownLoadFileBean downLoadFileBean, File file) {
            if (downLoadFileBean == null) {
                yn.yn(yn.this, false);
            } else {
                LogLocation.i("VdrFileManager", "libVdr download Success");
                yn.yn(yn.this, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
            }
        }
    }

    /* renamed from: com.huawei.location.vdr.file.yn$yn, reason: collision with other inner class name */
    class RunnableC0100yn implements Runnable {
        RunnableC0100yn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("Loc-VDR-CheckPlugin" + hashCode());
            yn.this.yn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn() {
        synchronized (yn.class) {
            try {
                PreferencesHelper preferencesHelper = new PreferencesHelper("sp_libVdrSo_filename");
                this.yn = preferencesHelper;
                long jCurrentTimeMillis = System.currentTimeMillis() - preferencesHelper.getLong("libVdr_last_time");
                this.Vw = this.yn.getString("libVdr_version_num");
                if (!Vw() || jCurrentTimeMillis >= 604800000) {
                    LogLocation.i("VdrFileManager", "libVdr file is not exists or determine whether the libVdr file needs to be updated ");
                    DownloadFileParam downloadFileParam = new DownloadFileParam();
                    downloadFileParam.setFileName("libVdr.7z");
                    downloadFileParam.setSaveFilePath(com.huawei.location.vdr.util.FB.yn);
                    downloadFileParam.setServiceType("Vdr");
                    downloadFileParam.setSubType("libVdr");
                    new DownLoadFileManager(downloadFileParam, new IDownloadSupport() { // from class: com.huawei.location.vdr.file.yn$$ExternalSyntheticLambda0
                        @Override // com.huawei.location.lite.common.util.filedownload.IDownloadSupport
                        public final boolean isSupportDownloadFile(DownLoadFileBean downLoadFileBean) {
                            return this.f$0.yn(downLoadFileBean);
                        }
                    }).startDownloadTask(new Vw());
                } else {
                    LogLocation.i("VdrFileManager", "libVdr file is exists and is not need update");
                    yn(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void yn(yn ynVar, boolean z) {
        FB fb = ynVar.FB;
        if (fb != null) {
            fb.handleLoadResult(z);
        }
    }

    private void yn(boolean z) {
        FB fb = this.FB;
        if (fb != null) {
            fb.handleLoadResult(z);
        }
    }

    private boolean yn(String str) {
        return new File(str).delete();
    }

    public boolean Vw() {
        File file = new File(com.huawei.location.vdr.util.FB.Vw);
        LogLocation.i("VdrFileManager", "the file isFileExist is " + file.exists());
        return file.exists();
    }

    public void yn(FB fb) {
        this.FB = fb;
        ExecutorUtil.getInstance().execute(new RunnableC0100yn());
    }

    static void yn(yn ynVar, File file, String str, String str2) {
        ynVar.getClass();
        synchronized (yn.class) {
            try {
                boolean zValidateFileSHA256 = FileSHA256.validateFileSHA256(file, str);
                StringBuilder sb = new StringBuilder();
                String str3 = com.huawei.location.vdr.util.FB.yn;
                sb.append(str3);
                sb.append(File.separator);
                sb.append("libVdr.7z");
                String string = sb.toString();
                if (!zValidateFileSHA256) {
                    LogLocation.i("VdrFileManager", "file is not integrity");
                    ynVar.yn(string);
                } else if (new Un7Z().doUnzip(string, str3)) {
                    ynVar.yn(true);
                    ynVar.yn.saveString("libVdr_version_num", str2);
                    ynVar.yn.saveLong("libVdr_last_time", System.currentTimeMillis());
                    LogLocation.i("VdrFileManager", "vdr unzip plugin success!");
                    ynVar.yn(string);
                } else {
                    LogLocation.i("VdrFileManager", "unzip file fail!");
                    ynVar.yn(string);
                }
                ynVar.yn(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yn(DownLoadFileBean downLoadFileBean) {
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        if (Vw()) {
            String str = this.Vw;
            LogLocation.i("VdrFileManager", "versionNumFromServer is: " + version + ", versionNumSp is: " + str);
            if (version.compareTo(str) <= 0) {
                return false;
            }
        }
        return true;
    }
}
