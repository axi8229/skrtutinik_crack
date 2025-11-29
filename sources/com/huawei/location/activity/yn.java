package com.huawei.location.activity;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LoadSoUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileManager;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import com.huawei.location.lite.common.util.filedownload.IDownloadResult;
import com.huawei.location.lite.common.util.filedownload.IDownloadSupport;
import com.huawei.location.lite.common.util.unzip.Un7Z;
import com.huawei.secure.android.common.encrypt.hash.FileSHA256;
import java.io.File;

/* loaded from: classes3.dex */
public class yn {
    private static boolean yn = false;
    private PreferencesHelper FB;
    private com.huawei.location.activity.callback.yn LW;
    private int Vw = 0;

    class Vw implements IDownloadResult {
        final /* synthetic */ String Vw;
        final /* synthetic */ String yn;

        Vw(String str, String str2) {
            this.yn = str;
            this.Vw = str2;
        }

        @Override // com.huawei.location.lite.common.util.filedownload.IDownloadResult
        public void onFail(int i, String str) {
            LogLocation.e("ModelFileManager", "download error errorCode:" + i + " errorDesc:" + str);
            if (i == 10005) {
                LogLocation.i("ModelFileManager", "download fail update the request time");
                yn.this.FB.saveLong(this.Vw, System.currentTimeMillis());
            }
            yn.yn(yn.this, this.yn);
        }

        @Override // com.huawei.location.lite.common.util.filedownload.IDownloadResult
        public void onSuccess(com.huawei.location.lite.common.util.filedownload.DownLoadFileBean downLoadFileBean, File file) {
            LogLocation.i("ModelFileManager", "download success:");
            if (downLoadFileBean == null || file == null) {
                LogLocation.e("ModelFileManager", "file or downLoadFileBean is null");
                yn.yn(yn.this, this.yn);
            } else {
                LogLocation.i("ModelFileManager", "file and downLoadFileBean is not null begin downLoadSuccessDeal");
                yn.yn(yn.this, this.yn, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
            }
        }
    }

    /* renamed from: com.huawei.location.activity.yn$yn, reason: collision with other inner class name */
    class C0082yn implements IDownloadSupport {
        final /* synthetic */ String Vw;
        final /* synthetic */ String yn;

        C0082yn(String str, String str2) {
            this.yn = str;
            this.Vw = str2;
        }

        @Override // com.huawei.location.lite.common.util.filedownload.IDownloadSupport
        public boolean isSupportDownloadFile(com.huawei.location.lite.common.util.filedownload.DownLoadFileBean downLoadFileBean) {
            LogLocation.i("ModelFileManager", "is Support DownloadFile");
            return !yn.this.yn(ContextUtil.getContext(), this.Vw) || yn.yn(yn.this, downLoadFileBean.getFileAccessInfo().getVersion(), yn.this.FB.getString(this.yn));
        }
    }

    private void FB() {
        throw new LocationServiceException(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }

    private void Vw() {
        if (this.Vw >= 3) {
            LogLocation.e("ModelFileManager", "maxTryTime failed, LoadSo is false");
            FB();
            throw null;
        }
        if (!yn) {
            yn = LoadSoUtil.loadSo("libml.so", com.huawei.location.activity.Vw.Vw);
            LogLocation.i("ModelFileManager", "loadLocalSo result:" + yn);
        }
        if (!yn) {
            LogLocation.e("ModelFileManager", "hasLoadSo is false");
            this.Vw++;
            Vw();
            return;
        }
        LogLocation.i("ModelFileManager", "hasLoadSo is true prepareLoadModelFile:");
        PreferencesHelper preferencesHelper = new PreferencesHelper("spModelFileName");
        this.FB = preferencesHelper;
        long j = preferencesHelper.getLong("spModelLastTime");
        LogLocation.i("ModelFileManager", "sp--lastTimeMillis:" + j);
        if (System.currentTimeMillis() - j >= 604800000 || !yn(ContextUtil.getContext(), "Ml_Location.net")) {
            LogLocation.i("ModelFileManager", "model file is not exists or determine whether the model file needs to be updated ");
            yn("Ml_Location.net", "activitityRecognition", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "spModelVersionNum", "spModelLastTime");
        } else {
            LogLocation.i("ModelFileManager", "model file is exists and is not need update");
            yn();
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private void yn() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.huawei.location.activity.Vw.yn
            r0.append(r1)
            java.lang.String r1 = "Ml_Location.net"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.content.Context r1 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch: java.lang.Throwable -> L6e
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L6e
            int r0 = com.huawei.location.activity.util.JniUtils.loadModelByAssets(r1, r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = "ModelFileManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            if (r0 != 0) goto L3f
            r2.<init>()
            java.lang.String r3 = "Load ModelFile success resultCode:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.huawei.location.lite.common.log.LogLocation.i(r1, r0)
            com.huawei.location.activity.callback.yn r0 = r5.LW
            if (r0 == 0) goto L3e
            r0.modelFileLoadSuccess()
        L3e:
            return
        L3f:
            r2.<init>()
            java.lang.String r3 = "Load ModelFile fail resultCode:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.huawei.location.lite.common.log.LogLocation.i(r1, r0)
            com.huawei.location.lite.common.util.PreferencesHelper r0 = r5.FB
            java.lang.String r1 = "spModelVersionNum"
            java.lang.String r2 = "-1"
            r0.saveString(r1, r2)
            com.huawei.location.lite.common.util.PreferencesHelper r0 = r5.FB
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 604800000(0x240c8400, double:2.988109026E-315)
            long r1 = r1 - r3
            java.lang.String r3 = "spModelLastTime"
            r0.saveLong(r3, r1)
            r5.FB()
            r0 = 0
            throw r0
        L6e:
            com.huawei.location.lite.common.exception.LocationServiceException r0 = new com.huawei.location.lite.common.exception.LocationServiceException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 10301(0x283d, float:1.4435E-41)
            java.lang.String r3 = com.huawei.location.base.activity.constant.ActivityErrorCode.getErrorCodeMessage(r2)
            r1.append(r3)
            java.lang.String r3 = ":end request."
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.yn.yn():void");
    }

    private void yn(String str, String str2, String str3, String str4, String str5) {
        DownloadFileParam downloadFileParam = new DownloadFileParam();
        downloadFileParam.setFileName(str);
        downloadFileParam.setSaveFilePath(com.huawei.location.activity.Vw.yn);
        downloadFileParam.setServiceType(str2);
        downloadFileParam.setSubType(str3);
        new DownLoadFileManager(downloadFileParam, new C0082yn(str4, str)).startDownloadTask(new Vw(str, str5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yn(Context context, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            LogLocation.e("ModelFileManager", "file is empty");
            return false;
        }
        LogLocation.d("ModelFileManager", "judgement the file exists");
        if (str.equals("activity.7z")) {
            file = new File(com.huawei.location.activity.Vw.Vw + File.separator + "libml.so");
        } else {
            file = new File(LocationUtil.getFilePath(context) + File.separator + str);
        }
        LogLocation.i("ModelFileManager", "file is not empty");
        return file.exists();
    }

    static boolean yn(yn ynVar, String str, String str2) {
        ynVar.getClass();
        LogLocation.i("ModelFileManager", "versionNumFromServer is: " + str + ", versionNumSp is: " + str2);
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.compareTo(str2) <= 0) ? false : true;
    }

    private boolean yn(String str) {
        return new File(str).delete();
    }

    static void yn(yn ynVar, String str) {
        ynVar.getClass();
        if (str.equals("activity.7z") && ynVar.yn(ContextUtil.getContext(), str)) {
            LogLocation.i("ModelFileManager", "so file is exists");
            ynVar.Vw();
        } else if (str.equals("Ml_Location.net") && ynVar.yn(ContextUtil.getContext(), "Ml_Location.net")) {
            LogLocation.i("ModelFileManager", "model file is exists");
            ynVar.yn();
        } else {
            LogLocation.e("ModelFileManager", "model or so file is not exists");
            ynVar.FB();
            throw null;
        }
    }

    static void yn(yn ynVar, String str, File file, String str2, String str3) {
        ynVar.getClass();
        boolean zValidateFileSHA256 = FileSHA256.validateFileSHA256(file, str2);
        StringBuilder sb = new StringBuilder();
        String str4 = com.huawei.location.activity.Vw.yn;
        sb.append(str4);
        sb.append(str);
        String string = sb.toString();
        if (!str.equals("activity.7z")) {
            if (!zValidateFileSHA256) {
                LogLocation.e("ModelFileManager", "model file is not integrity");
                ynVar.FB.saveString("spModelVersionNum", "-1");
                ynVar.FB.saveLong("spModelLastTime", System.currentTimeMillis() - 604800000);
                ynVar.FB();
                throw null;
            }
            LogLocation.i("ModelFileManager", "file is integrity");
            LogLocation.i("ModelFileManager", "save file success");
            ynVar.FB.saveString("spModelVersionNum", str3);
            ynVar.FB.saveLong("spModelLastTime", System.currentTimeMillis());
            ynVar.yn();
            return;
        }
        if (!zValidateFileSHA256) {
            LogLocation.e("ModelFileManager", "so file is not integrity");
            ynVar.FB.saveString("spSoVersionNum", "-1");
            ynVar.FB.saveLong("spSoLastTime", System.currentTimeMillis() - 604800000);
            ynVar.FB();
            throw null;
        }
        if (!new Un7Z().doUnzip(string, str4)) {
            LogLocation.i("ModelFileManager", "unzip file fail!");
            ynVar.FB();
            throw null;
        }
        ynVar.FB.saveString("spSoVersionNum", str3);
        ynVar.FB.saveLong("spSoLastTime", System.currentTimeMillis());
        LogLocation.i("ModelFileManager", "unzip file success!");
        ynVar.yn(string);
        ynVar.Vw();
    }

    public void yn(com.huawei.location.activity.callback.yn ynVar) {
        this.LW = ynVar;
        PreferencesHelper preferencesHelper = new PreferencesHelper("spSoFileName");
        this.FB = preferencesHelper;
        long j = preferencesHelper.getLong("spSoLastTime");
        LogLocation.i("ModelFileManager", "sp--lastTimeMillis:" + j);
        if (System.currentTimeMillis() - j >= 604800000 || !yn(ContextUtil.getContext(), "activity.7z")) {
            LogLocation.i("ModelFileManager", "so file is not exists or determine whether the model file needs to be updated ");
            yn("activity.7z", "activityRecognitionSo", "mlso", "spSoVersionNum", "spSoLastTime");
        } else {
            LogLocation.i("ModelFileManager", "so file is exists and is not need update");
            Vw();
        }
    }
}
