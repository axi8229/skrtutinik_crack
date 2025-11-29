package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FilePathComponents.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "getRootLength$FilesKt__FilePathComponentsKt", "(Ljava/lang/String;)I", "getRootLength", "Ljava/io/File;", "", "isRooted", "(Ljava/io/File;)Z", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
class FilesKt__FilePathComponentsKt {
    private static final int getRootLength$FilesKt__FilePathComponentsKt(String str) {
        int iIndexOf$default;
        char c = File.separatorChar;
        int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 4, (Object) null);
        if (iIndexOf$default2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c || (iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int iIndexOf$default3 = StringsKt.indexOf$default((CharSequence) str, c, iIndexOf$default + 1, false, 4, (Object) null);
            return iIndexOf$default3 >= 0 ? iIndexOf$default3 + 1 : str.length();
        }
        if (iIndexOf$default2 > 0 && str.charAt(iIndexOf$default2 - 1) == ':') {
            return iIndexOf$default2 + 1;
        }
        if (iIndexOf$default2 == -1 && StringsKt.endsWith$default((CharSequence) str, ':', false, 2, (Object) null)) {
            return str.length();
        }
        return 0;
    }

    public static final boolean isRooted(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return getRootLength$FilesKt__FilePathComponentsKt(path) > 0;
    }
}
