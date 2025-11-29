package sputnik.axmor.com.sputnik.services.call_service;

import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.axmor.ash.toolset.service.impl.CompositeService$$ExternalSyntheticApiModelOutline3;
import com.google.android.exoplayer2.AudioFocusManager$$ExternalSyntheticApiModelOutline6;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.l$$ExternalSyntheticApiModelOutline1;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.sputnik.common.entities.call.CallActions;
import com.sputnik.common.entities.localization.CallNotificationLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.LogUtilsKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.webrtc.MediaStreamTrack;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: CallNotificationService.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J)\u0010\u0019\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106¨\u00068"}, d2 = {"Lsputnik/axmor/com/sputnik/services/call_service/CallNotificationService;", "Landroid/app/Service;", "<init>", "()V", "", "hangUp", "createChannel", "setVibrationMode", "Landroid/media/AudioManager;", "audioManager", "setNormalMode", "(Landroid/media/AudioManager;)V", "startMediaPlayerNormal_O", "startMediaPlayerNormal", "releaseVibration", "releaseMediaPlayer", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "", "onBind", "(Landroid/content/Intent;)Ljava/lang/Void;", "onCreate", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "Landroid/media/MediaPlayer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "Landroid/os/Vibrator;", "mvibrator", "Landroid/os/Vibrator;", "Landroid/media/AudioManager;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "afChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "getAfChangeListener", "()Landroid/media/AudioManager$OnAudioFocusChangeListener;", "setAfChangeListener", "(Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "CHANNEL_ID", "Ljava/lang/String;", "CHANNEL_NAME", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallNotificationService extends Service {
    private final String CHANNEL_ID;
    private final String CHANNEL_NAME;
    private AudioManager.OnAudioFocusChangeListener afChangeListener;
    private AudioManager audioManager;
    private Handler handler;
    public LocalizationStorage localizationScreen;
    private MediaPlayer mediaPlayer;
    private Vibrator mvibrator;

    @Override // android.app.Service
    public Void onBind(Intent intent) {
        return null;
    }

    public CallNotificationService() {
        SputnikApp.Companion companion = SputnikApp.INSTANCE;
        this.CHANNEL_ID = companion.applicationContext().getString(R.string.app_name) + "CallId";
        this.CHANNEL_NAME = companion.applicationContext().getString(R.string.app_name) + " Smart Home";
    }

    @Override // android.app.Service
    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return (IBinder) onBind(intent);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        ContextKt.getAppComponent(this).inject(this);
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) throws IllegalStateException {
        CallNotificationLocale callNotification;
        List<String> actions;
        CallNotificationLocale callNotification2;
        List<String> actions2;
        CallNotificationLocale callNotification3;
        CallNotificationLocale callNotification4;
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        Object systemService = getSystemService(RemoteMessageConst.NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Intrinsics.areEqual((intent == null || (extras3 = intent.getExtras()) == null) ? null : extras3.getString("call_action"), CallActions.hang_up.toString())) {
            hangUp();
            return 1;
        }
        try {
            this.audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.handler = new Handler(getMainLooper());
            AudioManager audioManager = this.audioManager;
            if (audioManager != null) {
                Intrinsics.checkNotNull(audioManager);
                int ringerMode = audioManager.getRingerMode();
                if (ringerMode != 0) {
                    if (ringerMode == 1) {
                        setVibrationMode();
                    } else if (ringerMode == 2) {
                        AudioManager audioManager2 = this.audioManager;
                        Intrinsics.checkNotNull(audioManager2);
                        setNormalMode(audioManager2);
                        setVibrationMode();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = (intent == null || (extras2 = intent.getExtras()) == null) ? null : extras2.getString("sputnik.axmor.com.sputnik.global.call_id");
        String string2 = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("sputnik.axmor.com.sputnik.global.uuid");
        try {
            SputnikApp.Companion companion = SputnikApp.INSTANCE;
            Intent intent2 = new Intent(companion.applicationContext(), (Class<?>) CallNotificationActionReceiver.class);
            intent2.putExtra("ConstantApp.CALL_RESPONSE_ACTION_KEY", "ConstantApp.CALL_RECEIVE_ACTION");
            intent2.putExtra("ACTION_TYPE", "RECEIVE_CALL");
            intent2.putExtra("NOTIFICATION_ID", 128);
            intent2.putExtra("sputnik.axmor.com.sputnik.global.is_accepted", true);
            intent2.putExtra("sputnik.axmor.com.sputnik.global.call_id", string);
            intent2.putExtra("sputnik.axmor.com.sputnik.global.uuid", string2);
            intent2.setAction("RECEIVE_CALL");
            Intent intent3 = new Intent(companion.applicationContext(), (Class<?>) CallNotificationActionReceiver.class);
            intent3.putExtra("ConstantApp.CALL_RESPONSE_ACTION_KEY", "ConstantApp.CALL_CANCEL_ACTION");
            intent3.putExtra("ACTION_TYPE", "CANCEL_CALL");
            intent3.putExtra("NOTIFICATION_ID", 128);
            intent3.setAction("CANCEL_CALL");
            Intent intent4 = new Intent(companion.applicationContext(), (Class<?>) CallNotificationActionReceiver.class);
            intent4.putExtra("ACTION_TYPE", "DIALOG_CALL");
            intent4.putExtra("NOTIFICATION_ID", 128);
            intent4.putExtra("sputnik.axmor.com.sputnik.global.call_id", string);
            intent4.putExtra("sputnik.axmor.com.sputnik.global.uuid", string2);
            intent4.setAction("DIALOG_CALL");
            PendingIntent broadcast = PendingIntent.getBroadcast(companion.applicationContext(), 1200, intent2, 201326592);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(companion.applicationContext(), 1201, intent3, 201326592);
            PendingIntent broadcast3 = PendingIntent.getBroadcast(companion.applicationContext(), 1202, intent4, 201326592);
            createChannel();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, this.CHANNEL_ID);
            LocalizationLocalModel data = getLocalizationScreen().getData();
            NotificationCompat.Builder contentTitle = builder.setContentTitle((data == null || (callNotification4 = data.getCallNotification()) == null) ? null : callNotification4.getTitle());
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            NotificationCompat.Builder category = contentTitle.setContentText((data2 == null || (callNotification3 = data2.getCallNotification()) == null) ? null : callNotification3.getSubtitle()).setSmallIcon(R.drawable.ourhome).setPriority(2).setCategory("call");
            LocalizationLocalModel data3 = getLocalizationScreen().getData();
            NotificationCompat.Builder builderAddAction = category.addAction(android.R.drawable.ic_delete, (data3 == null || (callNotification2 = data3.getCallNotification()) == null || (actions2 = callNotification2.getActions()) == null) ? null : (String) CollectionsKt.last((List) actions2), broadcast2);
            LocalizationLocalModel data4 = getLocalizationScreen().getData();
            NotificationCompat.Builder autoCancel = builderAddAction.addAction(android.R.drawable.sym_action_call, (data4 == null || (callNotification = data4.getCallNotification()) == null || (actions = callNotification.getActions()) == null) ? null : (String) CollectionsKt.first((List) actions), broadcast).setAutoCancel(true);
            Intrinsics.checkNotNullExpressionValue(autoCancel, "setAutoCancel(...)");
            if (Build.VERSION.SDK_INT > 34 && notificationManager.canUseFullScreenIntent()) {
                autoCancel.setFullScreenIntent(broadcast3, true);
            }
            Handler handler = this.handler;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.services.call_service.CallNotificationService$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    CallNotificationService.onStartCommand$lambda$2(this.f$0);
                }
            }, UtilsKt.UPDATE_INTERVAL);
            startForeground(128, autoCancel.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStartCommand$lambda$2(CallNotificationService this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                this$0.stopForeground(true);
                this$0.stopService(new Intent(this$0, (Class<?>) CallNotificationService.class));
                this$0.stopSelf();
            } else {
                try {
                    this$0.stopService(new Intent(this$0, (Class<?>) CallNotificationService.class));
                    this$0.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void hangUp() throws IllegalStateException {
        MediaPlayer mediaPlayer;
        if (Build.VERSION.SDK_INT >= 31) {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null && mediaPlayer2 != null && mediaPlayer2.isPlaying() && (mediaPlayer = this.mediaPlayer) != null) {
                mediaPlayer.stop();
            }
            stopForeground(true);
            stopService(new Intent(this, (Class<?>) CallNotificationService.class));
            stopSelf();
            return;
        }
        try {
            sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void createChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                l$$ExternalSyntheticApiModelOutline1.m();
                NotificationChannel notificationChannelM = CompositeService$$ExternalSyntheticApiModelOutline3.m(this.CHANNEL_ID, this.CHANNEL_NAME, 4);
                new AudioAttributes.Builder().setUsage(5).build();
                notificationChannelM.setDescription("Call Notifications");
                notificationChannelM.setLockscreenVisibility(1);
                notificationChannelM.enableVibration(true);
                Object systemService = SputnikApp.INSTANCE.applicationContext().getSystemService((Class<Object>) NotificationManager.class);
                Objects.requireNonNull(systemService);
                ((NotificationManager) systemService).createNotificationChannel(notificationChannelM);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final void setVibrationMode() {
        Object systemService = getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator vibrator = (Vibrator) systemService;
        this.mvibrator = vibrator;
        Intrinsics.checkNotNull(vibrator);
        vibrator.vibrate(new long[]{0, 250, 200, 250, 150, 150, 75, 150, 75, 150}, 0);
        Log.e("Service!!", "vibrate mode start");
    }

    private final void setNormalMode(AudioManager audioManager) throws IllegalStateException {
        this.afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: sputnik.axmor.com.sputnik.services.call_service.CallNotificationService$$ExternalSyntheticLambda5
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) throws IllegalStateException {
                CallNotificationService.setNormalMode$lambda$4(this.f$0, i);
            }
        };
        MediaPlayer mediaPlayerCreate = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        this.mediaPlayer = mediaPlayerCreate;
        Intrinsics.checkNotNull(mediaPlayerCreate);
        mediaPlayerCreate.setLooping(true);
        LogUtilsKt.writeLog("DD: PLAY RINGTONE");
        if (Build.VERSION.SDK_INT >= 26) {
            startMediaPlayerNormal_O(audioManager);
        } else {
            startMediaPlayerNormal(audioManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNormalMode$lambda$4(CallNotificationService this$0, int i) throws IllegalStateException {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != -1 || (mediaPlayer = this$0.mediaPlayer) == null || mediaPlayer == null || !mediaPlayer.isPlaying() || (mediaPlayer2 = this$0.mediaPlayer) == null) {
            return;
        }
        mediaPlayer2.pause();
    }

    private final void startMediaPlayerNormal_O(AudioManager audioManager) throws IllegalStateException {
        Object systemService = getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        AudioFocusRequest.Builder acceptsDelayedFocusGain = AudioFocusManager$$ExternalSyntheticApiModelOutline6.m(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).setAcceptsDelayedFocusGain(true);
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.afChangeListener;
        Intrinsics.checkNotNull(onAudioFocusChangeListener);
        Handler handler = this.handler;
        Intrinsics.checkNotNull(handler);
        AudioFocusRequest audioFocusRequestBuild = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        Intrinsics.checkNotNullExpressionValue(audioFocusRequestBuild, "build(...)");
        if (audioManager.requestAudioFocus(audioFocusRequestBuild) != 1 || keyguardManager.isDeviceLocked()) {
            return;
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.start();
    }

    private final void startMediaPlayerNormal(AudioManager audioManager) throws IllegalStateException {
        Object systemService = getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (audioManager.requestAudioFocus(this.afChangeListener, 5, 2) != 1 || keyguardManager.isDeviceLocked()) {
            return;
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.start();
    }

    @Override // android.app.Service
    public void onDestroy() throws IllegalStateException {
        super.onDestroy();
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.afChangeListener);
        }
        this.handler = null;
        releaseMediaPlayer();
        releaseVibration();
    }

    private final void releaseVibration() {
        try {
            Vibrator vibrator = this.mvibrator;
            if (vibrator != null) {
                Intrinsics.checkNotNull(vibrator);
                if (vibrator.hasVibrator()) {
                    Vibrator vibrator2 = this.mvibrator;
                    Intrinsics.checkNotNull(vibrator2);
                    vibrator2.cancel();
                }
                this.mvibrator = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void releaseMediaPlayer() throws IllegalStateException {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                }
                this.mediaPlayer = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
