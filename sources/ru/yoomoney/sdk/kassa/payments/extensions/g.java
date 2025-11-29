package ru.yoomoney.sdk.kassa.payments.extensions;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.provider.Settings;
import android.util.Base64;
import com.huawei.hms.android.SystemUtils;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import ru.yoomoney.sdk.kassa.payments.R$bool;

/* loaded from: classes5.dex */
public abstract class g {
    public static final ActivityInfo a(Context context, Intent intent) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        List<ResolveInfo> listQueryIntentActivities = applicationContext.getPackageManager().queryIntentActivities(intent, 128);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        Iterator it = SequencesKt.map(CollectionsKt.asSequence(listQueryIntentActivities), f.a).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(packageName, ((ActivityInfo) next).packageName)) {
                break;
            }
        }
        return (ActivityInfo) next;
    }

    public static final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(context, "<this>");
        Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        if (signatureArr == null) {
            signatureArr = new Signature[0];
        }
        ArrayList arrayList = new ArrayList(signatureArr.length);
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("Check failed.");
        }
        Iterator it = arrayList.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) it.next()).length;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            byteBufferAllocate = byteBufferAllocate.put((byte[]) it2.next());
        }
        byte[] data = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(data, "array(...)");
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(data);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        if (bArrDigest.length == 0) {
            bArrDigest = null;
        }
        String strEncodeToString = bArrDigest != null ? Base64.encodeToString(bArrDigest, 0) : null;
        return strEncodeToString == null ? SystemUtils.UNKNOWN : strEncodeToString;
    }

    public static final boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getBoolean(R$bool.ym_isTablet);
    }

    public static final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
