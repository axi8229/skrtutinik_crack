package ru.yoomoney.sdk.guiCompose.theme;

import android.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* compiled from: Colors.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"getTintFade", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "getTintFade-8_81llA", "(J)J", "getTintSelection", "getTintSelection-8_81llA", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ColorsKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getTintFade-8_81llA, reason: not valid java name */
    public static final long m3379getTintFade8_81llA(long j) {
        float[] fArr = new float[3];
        Color.colorToHSV(ColorKt.m996toArgb8_81llA(j), fArr);
        fArr[1] = fArr[1] * 0.5f;
        fArr[2] = fArr[2] * 0.9f;
        return ColorKt.Color(Color.HSVToColor(fArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getTintSelection-8_81llA, reason: not valid java name */
    public static final long m3380getTintSelection8_81llA(long j) {
        float[] fArr = new float[3];
        Color.colorToHSV(ColorKt.m996toArgb8_81llA(j), fArr);
        fArr[1] = fArr[1] * 0.6f;
        fArr[2] = fArr[2] * 1.15f;
        return ColorKt.Color(Color.HSVToColor(fArr));
    }
}
