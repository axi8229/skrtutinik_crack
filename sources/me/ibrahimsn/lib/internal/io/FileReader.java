package me.ibrahimsn.lib.internal.io;

import android.content.Context;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: FileReader.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lme/ibrahimsn/lib/internal/io/FileReader;", "", "()V", "readAssetFile", "", "context", "Landroid/content/Context;", AppMeasurementSdk.ConditionalUserProperty.NAME, "lib_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class FileReader {
    public static final FileReader INSTANCE = new FileReader();

    private FileReader() {
    }

    public final String readAssetFile(Context context, String name) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            InputStream inputStreamOpen = context.getAssets().open(name);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "context.assets.open(name)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.UTF_8), 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return text;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
