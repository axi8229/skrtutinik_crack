package com.huawei.location.lite.common.log.logwrite;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class LogWrite {
    private static boolean enableWriteLog = false;
    private Map<String, FileParam> fileInfoMap = new ConcurrentHashMap();
    private String logDirPath = null;
    private long maxFileExpired;
    private int maxFileNum;
    private int maxFileSize;

    private static class FileComparator implements Comparator<File>, Serializable {
        private FileComparator() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    private void beforeWriteCheck(FileParam fileParam, String str) throws IOException {
        String fileName = fileParam.getFileName();
        String fileDirPath = fileParam.getFileDirPath();
        if (!TextUtils.isEmpty(fileName)) {
            if (new File(fileDirPath, fileName).exists()) {
                return;
            } else {
                Log.i("LogWrite", "writeToFile file is not exit");
            }
        }
        File file = new File(fileDirPath);
        if (file.exists()) {
            pathExistsDeal(file, fileParam, str);
            return;
        }
        Log.i("LogWrite", "beforeWriteCheck None of the paths exist--Create a path--Create a file");
        fileParam.setNeedCheck(false);
        creatFolder(fileDirPath);
        createNewLogFile(fileParam, makeLogFileName(str), str);
    }

    private void creatFolder(String str) {
        boolean zMkdirs;
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        try {
            zMkdirs = file.mkdirs();
        } catch (SecurityException unused) {
            Log.e("LogWrite", "createFolder SecurityException:");
            zMkdirs = false;
        }
        if (zMkdirs) {
            Log.i("LogWrite", "createFolder success");
        } else {
            Log.e("LogWrite", "createFolder fail");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[Catch: all -> 0x002a, TryCatch #0 {, blocks: (B:10:0x0026, B:15:0x0033, B:17:0x0048, B:18:0x004b, B:20:0x0058, B:22:0x0062, B:24:0x0076, B:25:0x008a, B:14:0x002c), top: B:31:0x0024, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void createNewLogFile(com.huawei.location.lite.common.log.logwrite.FileParam r8, java.lang.String r9, java.lang.String r10) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = r8.getFileDirPath()
            java.io.BufferedWriter r1 = r8.getWriter()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L8e
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 == 0) goto L16
            goto L8e
        L16:
            java.io.File r2 = new java.io.File
            r2.<init>(r0, r9)
            java.io.FileOutputStream r3 = new java.io.FileOutputStream
            r4 = 1
            r3.<init>(r2, r4)
            java.lang.Class<com.huawei.location.lite.common.log.logwrite.LogWrite> r5 = com.huawei.location.lite.common.log.logwrite.LogWrite.class
            monitor-enter(r5)
            if (r1 == 0) goto L33
            r1.close()     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            goto L33
        L2a:
            r8 = move-exception
            goto L8c
        L2c:
            java.lang.String r1 = "LogWrite"
            java.lang.String r6 = "createNewLogFile IOException"
            android.util.Log.e(r1, r6)     // Catch: java.lang.Throwable -> L2a
        L33:
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> L2a
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L2a
            r1.<init>(r3, r6)     // Catch: java.lang.Throwable -> L2a
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L2a
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L2a
            r8.setWriter(r3)     // Catch: java.lang.Throwable -> L2a
            boolean r1 = r8.isNeedCheck()     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L4b
            r7.filesNumAndUsefulCheck(r0, r10)     // Catch: java.lang.Throwable -> L2a
        L4b:
            r8.setFileName(r9)     // Catch: java.lang.Throwable -> L2a
            com.huawei.location.lite.common.log.logwrite.LogWrite.enableWriteLog = r4     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = "location"
            boolean r10 = r10.equals(r0)     // Catch: java.lang.Throwable -> L2a
            if (r10 == 0) goto L74
            long r0 = r2.length()     // Catch: java.lang.Throwable -> L2a
            r2 = 0
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 != 0) goto L74
            java.io.BufferedWriter r10 = r8.getWriter()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = getCSVFileHeader()     // Catch: java.lang.Throwable -> L2a
            r10.append(r0)     // Catch: java.lang.Throwable -> L2a
            java.io.BufferedWriter r8 = r8.getWriter()     // Catch: java.lang.Throwable -> L2a
            r8.flush()     // Catch: java.lang.Throwable -> L2a
        L74:
            java.lang.String r8 = "LogWrite"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r10.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = "createNewLogFile:File creation complete logFileName:"
            r10.append(r0)     // Catch: java.lang.Throwable -> L2a
            r10.append(r9)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Throwable -> L2a
            android.util.Log.i(r8, r9)     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2a
            return
        L8c:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2a
            throw r8
        L8e:
            java.lang.String r8 = "LogWrite"
            java.lang.String r9 = "createNewLogFile Exception"
            android.util.Log.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.log.logwrite.LogWrite.createNewLogFile(com.huawei.location.lite.common.log.logwrite.FileParam, java.lang.String, java.lang.String):void");
    }

    private boolean deleteFiles(File[] fileArr, int i) {
        if (fileArr != null && fileArr.length > 0) {
            try {
                if (i == -1) {
                    for (int length = fileArr.length - 1; length >= 0; length--) {
                        if (!fileArr[length].delete()) {
                            Log.e("LogWrite", "deleteFiles result false");
                            return false;
                        }
                    }
                } else {
                    for (int i2 = i - 1; i2 >= 0; i2--) {
                        if (!fileArr[i2].delete()) {
                            Log.e("LogWrite", "deleteFiles result false");
                            return false;
                        }
                    }
                }
                return true;
            } catch (SecurityException unused) {
                Log.e("LogWrite", "deleteFiles SecurityException");
            }
        }
        return false;
    }

    private void doWrite(AppLog appLog, FileParam fileParam) throws IOException {
        String msgByFileType = getMsgByFileType(appLog);
        BufferedWriter writer = fileParam.getWriter();
        if (writer != null) {
            writer.append((CharSequence) msgByFileType);
            writer.flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void filesNumAndUsefulCheck(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "LogWrite"
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            java.io.File[] r6 = r5.getExistedFiles(r1, r7)
            if (r6 == 0) goto L95
            int r7 = r6.length
            if (r7 <= 0) goto L95
            com.huawei.location.lite.common.log.logwrite.LogWrite$FileComparator r7 = new com.huawei.location.lite.common.log.logwrite.LogWrite$FileComparator     // Catch: java.lang.IllegalArgumentException -> L1a
            r1 = 0
            r7.<init>()     // Catch: java.lang.IllegalArgumentException -> L1a
            java.util.Arrays.sort(r6, r7)     // Catch: java.lang.IllegalArgumentException -> L1a
            goto L1f
        L1a:
            java.lang.String r7 = "Arrays sort IllegalArgumentException"
            android.util.Log.e(r0, r7)
        L1f:
            int r7 = r6.length     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            int r7 = r7 + (-1)
            r7 = r6[r7]     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r1 = r5.getFileSavaTimeMill(r7)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r3 = r3 - r1
            long r1 = r5.maxFileExpired     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            int r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r7 <= 0) goto L3d
            java.lang.String r7 = "filesNumAndUsefulCheck:The latest saved files are more than maxFileExpired delete all files"
            android.util.Log.i(r0, r7)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r7 = -1
            r5.deleteFiles(r6, r7)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            goto L86
        L3d:
            int r7 = r6.length     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            int r7 = r7 + (-1)
        L40:
            if (r7 < 0) goto L86
            r1 = r6[r7]     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r1 = r5.getFileSavaTimeMill(r1)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r3 = r3 - r1
            long r1 = r5.maxFileExpired     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 <= 0) goto L7a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r1.<init>()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            java.lang.String r2 = "filesNumAndUsefulCheck:delete the exceed file:"
            r1.append(r2)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r2 = r6[r7]     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r1.append(r2)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            android.util.Log.i(r0, r1)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r1 = r6[r7]     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            boolean r1 = r1.delete()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            if (r1 != 0) goto L7a
            java.lang.String r1 = "filesNumAndUsefulCheck:delete the exceed file result false"
            android.util.Log.e(r0, r1)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
        L7a:
            int r7 = r7 + (-1)
            goto L40
        L7d:
            java.lang.String r7 = "filesNumAndUsefulCheck:Exception"
        L7f:
            android.util.Log.i(r0, r7)
            goto L86
        L83:
            java.lang.String r7 = "filesNumAndUsefulCheck:SecurityException"
            goto L7f
        L86:
            int r7 = r6.length
            int r1 = r5.maxFileNum
            if (r7 < r1) goto L95
            int r7 = r6.length
            int r7 = r7 - r1
            java.lang.String r1 = "createNewLogFile Exceeded the maximum number of files--Delete the earliest file."
            android.util.Log.i(r0, r1)
            r5.deleteFiles(r6, r7)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.log.logwrite.LogWrite.filesNumAndUsefulCheck(java.lang.String, java.lang.String):void");
    }

    private static String getCSVFileHeader() {
        return "writeTime," + HiAnalyticsConstant.HaKey.BI_KEY_TRANSID + ",provider,latitude,longitude,accuracy,locationTime,speed,sessionId,sourceType,locateType,vendorType,src,switchHd,floor,floorAcc,buildingId" + System.lineSeparator();
    }

    private File[] getExistedFiles(File file, String str) {
        return file.listFiles(str.equals("location") ? new FilenameFilter() { // from class: com.huawei.location.lite.common.log.logwrite.LogWrite$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                return LogWrite.lambda$getExistedFiles$0(file2, str2);
            }
        } : new FilenameFilter() { // from class: com.huawei.location.lite.common.log.logwrite.LogWrite$$ExternalSyntheticLambda1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                return LogWrite.lambda$getExistedFiles$1(file2, str2);
            }
        });
    }

    private FileParam getFileInfo(String str) {
        if (this.fileInfoMap.containsKey(str)) {
            return this.fileInfoMap.get(str);
        }
        FileParam fileParam = new FileParam();
        String str2 = this.logDirPath;
        if (!str.equals("log") && str.equals("location")) {
            str2 = this.logDirPath + LogWriteConstants.DEBUG_PATH + LogWriteConstants.LOCATION_PATH;
        }
        fileParam.setFileDirPath(str2);
        this.fileInfoMap.put(str, fileParam);
        return fileParam;
    }

    private long getFileSavaTimeMill(File file) throws SecurityException {
        return file.lastModified();
    }

    private String getMsgByFileType(AppLog appLog) {
        if (appLog.getFileType().equals("location")) {
            return String.format(Locale.ENGLISH, "%s", appLog.getMsg() + System.lineSeparator());
        }
        return String.format(Locale.ENGLISH, "%s: %s/%s: %s", getNow(), appLog.getLevel(), appLog.getTag(), appLog.getMsg() + System.lineSeparator() + Log.getStackTraceString(appLog.getTr()));
    }

    private String getNow() {
        return DateUtil.formate(Calendar.getInstance().getTime(), "yy-MM-dd HH:mm:ss.SSS");
    }

    public static boolean isEnableWriteLog() {
        return enableWriteLog;
    }

    private boolean isFileFull(String str, String str2, String str3) {
        File file = new File(str2, str3);
        boolean zEquals = str.equals("location");
        long length = file.length();
        return zEquals ? length > ((long) 1048576) : length > ((long) this.maxFileSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getExistedFiles$0(File file, String str) {
        return str.startsWith("Location") && str.endsWith(".csv") && str.length() == 28 && "_".equals(String.valueOf(str.charAt(17)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getExistedFiles$1(File file, String str) {
        return str.startsWith("Location") && str.endsWith(".log") && str.length() == 28 && "_".equals(String.valueOf(str.charAt(17)));
    }

    private String makeLogFileName(String str) {
        String str2 = str.equals("location") ? ".csv" : ".log";
        return "Location." + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Calendar.getInstance().getTime()) + str2;
    }

    private void openLogFile(FileParam fileParam) throws IOException {
        BufferedWriter writer = fileParam.getWriter();
        String fileDirPath = fileParam.getFileDirPath();
        String fileName = fileParam.getFileName();
        if (writer == null) {
            if (TextUtils.isEmpty(fileDirPath) || TextUtils.isEmpty(fileName)) {
                Log.e("LogWrite", "openLogFile Exception");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileDirPath, fileName), true);
            synchronized (LogWrite.class) {
                fileParam.setWriter(new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8)));
            }
        }
    }

    private void pathExistsDeal(File file, FileParam fileParam, String str) throws IOException {
        boolean zIsFirstWrite = fileParam.isFirstWrite();
        String fileDirPath = fileParam.getFileDirPath();
        if (zIsFirstWrite) {
            filesNumAndUsefulCheck(fileDirPath, str);
            fileParam.setNeedCheck(false);
        }
        File[] existedFiles = getExistedFiles(file, str);
        if (existedFiles == null) {
            Log.e("LogWrite", "beforeWriteCheck  existedFiles is null");
            return;
        }
        if (existedFiles.length == 0) {
            Log.i("LogWrite", "beforeWriteCheck  Path Exist -- No File -- Create File");
            fileParam.setNeedCheck(false);
            createNewLogFile(fileParam, makeLogFileName(str), str);
        } else {
            try {
                Arrays.sort(existedFiles, new FileComparator());
            } catch (IllegalArgumentException unused) {
                Log.e("LogWrite", "beforeWriteCheck Arrays sort IllegalArgumentException");
            }
            fileParam.setFileName(existedFiles[existedFiles.length - 1].getName());
        }
    }

    public static void setEnableWriteLog(boolean z) {
        enableWriteLog = z;
    }

    public void init(int i, String str, int i2, int i3) {
        boolean z;
        this.maxFileSize = i > 0 ? Math.min(i, 2) * 1048576 : 2097152;
        this.maxFileNum = i2 > 0 ? Math.min(i2, 20) : 20;
        this.maxFileExpired = i3 > 0 ? Math.min(i3, 5) * 86400000 : 432000000L;
        if (str != null) {
            this.logDirPath = str;
            z = true;
        } else {
            z = false;
        }
        setEnableWriteLog(z);
        Log.i("LogWrite", "LogWrite init complete");
    }

    public boolean permissionCheck(String str) {
        String str2;
        if (str.startsWith("/data/user/") || str.startsWith("/data/data/") || str.startsWith("data/data/") || str.startsWith("data/user/")) {
            return true;
        }
        if (!PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
            str2 = "READ_EXTERNAL_PERMISSION Permission check unPass";
        } else {
            if (PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
            str2 = "WRITE_EXTERNAL_PERMISSION Permission check unPass";
        }
        Log.e("LogWrite", str2);
        return false;
    }

    public void shutdown() {
        synchronized (LogWrite.class) {
            Iterator<Map.Entry<String, FileParam>> it = this.fileInfoMap.entrySet().iterator();
            while (it.hasNext()) {
                FileParam value = it.next().getValue();
                if (value != null && value.getWriter() != null) {
                    try {
                        value.getWriter().close();
                    } catch (IOException unused) {
                        Log.e("LogWrite", "shutdown IOException");
                    }
                    value.setWriter(null);
                }
            }
        }
    }

    public void writeToFile(AppLog appLog) {
        FileParam fileInfo;
        if (enableWriteLog) {
            String fileType = appLog.getFileType();
            synchronized (LogWrite.class) {
                try {
                    fileInfo = getFileInfo(fileType);
                } catch (IOException unused) {
                    Log.e("LogWrite", "writeToFile IOException");
                }
                if (SDKComponentType.getComponentType() != 100 || permissionCheck(this.logDirPath)) {
                    beforeWriteCheck(fileInfo, fileType);
                    if (TextUtils.isEmpty(fileInfo.getFileName())) {
                        return;
                    }
                    if (isFileFull(fileType, fileInfo.getFileDirPath(), fileInfo.getFileName())) {
                        fileInfo.setNeedCheck(true);
                        createNewLogFile(fileInfo, makeLogFileName(fileType), fileType);
                    } else {
                        openLogFile(fileInfo);
                    }
                    doWrite(appLog, fileInfo);
                }
            }
        }
    }
}
