package sputnik.axmor.com.sputnik.services.vibration;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VibrationManager.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lsputnik/axmor/com/sputnik/services/vibration/VibrationManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "pattern", "", "vibrator", "Landroid/os/Vibrator;", "vibratorS", "Landroid/os/VibratorManager;", "cancel", "", "vibrate", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VibrationManager {
    private final Context context;
    private final long[] pattern;
    private Vibrator vibrator;
    private VibratorManager vibratorS;

    public VibrationManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.pattern = new long[]{0, 250, 200, 250, 150, 150, 75, 150, 75, 150};
        if (Build.VERSION.SDK_INT >= 31) {
            VibratorManager vibratorManagerM = VibrationManager$$ExternalSyntheticApiModelOutline1.m(context.getSystemService("vibrator_manager"));
            this.vibratorS = vibratorManagerM;
            this.vibrator = vibratorManagerM != null ? vibratorManagerM.getDefaultVibrator() : null;
            return;
        }
        this.vibrator = (Vibrator) context.getSystemService("vibrator");
    }

    public final void vibrate() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            Vibrator vibrator = this.vibrator;
            if (vibrator != null) {
                vibrator.vibrate(VibrationEffect.createWaveform(this.pattern, 0), new AudioAttributes.Builder().setContentType(4).setUsage(6).build());
                return;
            }
            return;
        }
        if (i >= 26) {
            Vibrator vibrator2 = this.vibrator;
            if (vibrator2 != null) {
                vibrator2.vibrate(VibrationEffect.createWaveform(this.pattern, 0));
                return;
            }
            return;
        }
        Vibrator vibrator3 = this.vibrator;
        if (vibrator3 != null) {
            vibrator3.vibrate(this.pattern, 0);
        }
    }

    public final void cancel() {
        if (Build.VERSION.SDK_INT >= 31) {
            VibratorManager vibratorManager = this.vibratorS;
            if (vibratorManager != null) {
                vibratorManager.cancel();
                return;
            }
            return;
        }
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }
}
