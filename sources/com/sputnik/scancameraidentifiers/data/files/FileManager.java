package com.sputnik.scancameraidentifiers.data.files;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.activationautomation.data.files.ILogger;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.File;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\nR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\nR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/sputnik/scancameraidentifiers/data/files/FileManager;", "Lcom/sputnik/activationautomation/data/files/ILogger;", "", "baseDirPath", FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", RemoteMessageConst.MessageBody.MSG, "", "write", "(Ljava/lang/String;)V", "clear", "()V", "Ljava/lang/String;", "getBaseDirPath", "()Ljava/lang/String;", "setBaseDirPath", "getFilename", "setFilename", "Ljava/io/File;", "file", "Ljava/io/File;", "", "currentFileCounter", "I", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileManager implements ILogger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ILogger instance;
    private String baseDirPath;
    private int currentFileCounter;
    private File file;
    private String filename;

    public /* synthetic */ FileManager(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    @Override // com.sputnik.activationautomation.data.files.ILogger
    public void write(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    private FileManager(String str, String str2) {
        this.baseDirPath = str;
        this.filename = str2;
        this.currentFileCounter = -1;
    }

    @Override // com.sputnik.activationautomation.data.files.ILogger
    public void clear() {
        this.file = new File(this.baseDirPath, String.valueOf(this.filename));
        PrintWriter printWriter = new PrintWriter(this.file);
        printWriter.print("");
        printWriter.close();
    }

    /* compiled from: FileManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/sputnik/scancameraidentifiers/data/files/FileManager$Companion;", "", "<init>", "()V", "", "baseDirPath", FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME, "Lcom/sputnik/activationautomation/data/files/ILogger;", "getInstance", "(Ljava/lang/String;Ljava/lang/String;)Lcom/sputnik/activationautomation/data/files/ILogger;", "Landroid/content/Context;", "context", "Ljava/io/File;", "getFile", "(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;", "instance", "Lcom/sputnik/activationautomation/data/files/ILogger;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ILogger getInstance$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "logs.csv";
            }
            return companion.getInstance(str, str2);
        }

        @JvmStatic
        public final ILogger getInstance(String baseDirPath, String filename) {
            Intrinsics.checkNotNullParameter(baseDirPath, "baseDirPath");
            Intrinsics.checkNotNullParameter(filename, "filename");
            if (Intrinsics.areEqual(filename, "")) {
                filename = "logs.csv";
            }
            if (FileManager.instance == null) {
                FileManager.instance = new FileManager(baseDirPath, filename, null);
            }
            ILogger iLogger = FileManager.instance;
            Intrinsics.checkNotNull(iLogger);
            return iLogger;
        }

        public static /* synthetic */ File getFile$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "logs.csv";
            }
            return companion.getFile(context, str);
        }

        @JvmStatic
        public final File getFile(Context context, String filename) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(filename, "filename");
            return new File(context.getFilesDir().getPath(), filename);
        }
    }
}
