package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.coreutils.io.FileUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class B0 {
    public File a(Context context, String str) {
        File storageDirectory = FileUtils.getStorageDirectory(context);
        if (storageDirectory == null) {
            return null;
        }
        return new File(storageDirectory, str);
    }

    public String b(Context context, String str) {
        File storageDirectory = FileUtils.getStorageDirectory(context);
        if (storageDirectory == null) {
            return null;
        }
        return storageDirectory.getAbsolutePath() + "/" + str;
    }

    public File c(Context context) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties", true, Context.class.getClassLoader());
            Object objInvoke = cls.getMethod("get", String.class).invoke(cls, "persist.yndx.metrica.db.dir");
            if (!(objInvoke instanceof String)) {
                objInvoke = null;
            }
            str = (String) objInvoke;
        } catch (Exception unused) {
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str, context.getPackageName());
        try {
            file.mkdirs();
            return file;
        } catch (Exception unused2) {
            return null;
        }
    }

    public File a(File file, String str) {
        if (file == null) {
            return null;
        }
        return b(file.getAbsoluteFile(), str);
    }

    public File b(Context context) {
        return a(context, "YandexMetricaNativeCrashes");
    }

    public File a(Context context) {
        File parentFile;
        if (A2.a(24)) {
            parentFile = context.getDataDir();
        } else {
            File filesDir = context.getFilesDir();
            parentFile = filesDir == null ? null : filesDir.getParentFile();
        }
        if (parentFile == null) {
            return null;
        }
        File file = new File(parentFile, "lib");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public File b(File file, String str) {
        if (file == null) {
            return null;
        }
        return new File(file, str);
    }
}
