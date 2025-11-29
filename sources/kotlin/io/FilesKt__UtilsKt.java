package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a-\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\f\"\u0015\u0010\u000f\u001a\u00020\u000b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Ljava/io/File;", "target", "", "overwrite", "", "bufferSize", "copyTo", "(Ljava/io/File;Ljava/io/File;ZI)Ljava/io/File;", "relative", "resolve", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "extension", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
public class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static String getExtension(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.substringAfterLast(name, '.', "");
    }

    public static File copyTo(File file, File target, boolean z, int i) throws FileSystemException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (!target.mkdirs()) {
                throw new FileSystemException(file, target, "Failed to create target directory.");
            }
        } else {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    ByteStreamsKt.copyTo(fileInputStream, fileOutputStream, i);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        }
        return target;
    }

    public static final File resolve(File file, File relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(relative)) {
            return relative;
        }
        String string = file.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (string.length() != 0) {
            char c = File.separatorChar;
            if (!StringsKt.endsWith$default((CharSequence) string, c, false, 2, (Object) null)) {
                return new File(string + c + relative);
            }
        }
        return new File(string + relative);
    }

    public static File resolve(File file, String relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolve(file, new File(relative));
    }
}
