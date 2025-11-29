package com.huawei.location.sdm.utils;

import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileManager;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import com.huawei.location.lite.common.util.unzip.Un7Z;
import com.huawei.secure.android.common.encrypt.hash.FileSHA256;
import java.io.File;

/* loaded from: classes3.dex */
public class yn {
    private String Vw;
    private PreferencesHelper yn;

    /* renamed from: com.huawei.location.sdm.utils.yn$yn, reason: collision with other inner class name */
    class RunnableC0096yn implements Runnable {
        RunnableC0096yn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("Loc-SDM-CheckPlugin" + hashCode());
            yn.yn(yn.this);
        }
    }

    static void yn(yn ynVar) {
        ynVar.getClass();
        synchronized (yn.class) {
            try {
                PreferencesHelper preferencesHelper = new PreferencesHelper("sp_libSdmSo_filename");
                ynVar.yn = preferencesHelper;
                long jCurrentTimeMillis = System.currentTimeMillis() - preferencesHelper.getLong("libSdm_last_time");
                ynVar.Vw = ynVar.yn.getString("libSdm_version_num");
                if (!ynVar.Vw() || jCurrentTimeMillis >= 604800000) {
                    LogLocation.i("SdmFileManager", "libSdm file is not exists or determine whether the libSdm file needs to be updated ");
                    DownloadFileParam downloadFileParam = new DownloadFileParam();
                    downloadFileParam.setFileName("libSdm.7z");
                    downloadFileParam.setSaveFilePath(com.huawei.location.sdm.constant.FB.yn);
                    downloadFileParam.setServiceType("Sdm");
                    downloadFileParam.setSubType("libSdm");
                    new DownLoadFileManager(downloadFileParam, new Vw(ynVar)).startDownloadTask(new FB(ynVar));
                } else {
                    LogLocation.i("SdmFileManager", "libSdm file is exists and is not need update");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean yn(String str) {
        return new File(str).delete();
    }

    public boolean Vw() {
        File file = new File(com.huawei.location.sdm.constant.FB.Vw);
        LogLocation.i("SdmFileManager", "the file isFileExist is " + file.exists());
        return file.exists();
    }

    public void yn() {
        ExecutorUtil.getInstance().execute(new RunnableC0096yn());
    }

    static boolean yn(yn ynVar, String str, String str2) {
        ynVar.getClass();
        LogLocation.i("SdmFileManager", "versionNumFromServer is: " + str + ", versionNumSp is: " + str2);
        return str.compareTo(str2) > 0;
    }

    static void yn(yn ynVar, File file, String str, String str2) {
        ynVar.getClass();
        synchronized (yn.class) {
            try {
                boolean zValidateFileSHA256 = FileSHA256.validateFileSHA256(file, str);
                StringBuilder sb = new StringBuilder();
                String str3 = com.huawei.location.sdm.constant.FB.yn;
                sb.append(str3);
                sb.append(File.separator);
                sb.append("libSdm.7z");
                String string = sb.toString();
                if (!zValidateFileSHA256) {
                    LogLocation.i("SdmFileManager", "file is not integrity");
                } else if (new Un7Z().doUnzip(string, str3)) {
                    ynVar.yn.saveString("libSdm_version_num", str2);
                    ynVar.yn.saveLong("libSdm_last_time", System.currentTimeMillis());
                    LogLocation.i("SdmFileManager", "unzip plugin success!");
                } else {
                    LogLocation.i("SdmFileManager", "unzip file fail!");
                }
                ynVar.yn(string);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
