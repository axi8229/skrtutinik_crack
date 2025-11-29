package flussonic.watcher.sdk.presentation.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;
import flussonic.watcher.sdk.R$attr;
import flussonic.watcher.sdk.R$color;
import flussonic.watcher.sdk.R$dimen;
import flussonic.watcher.sdk.R$drawable;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.R$string;
import flussonic.watcher.sdk.domain.pojo.PlaybackSpeed;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.domain.utils.CalendarUtils;
import flussonic.watcher.sdk.presentation.watcher.FlussonicColorTheme;

/* loaded from: classes3.dex */
class FlussonicBottomBar extends LinearLayout {
    private Drawable backgroundDrawable;
    private View bottombarDivider;
    private ImageView cameraStatusImageView;
    private int colorGradient2;
    private View cutBackground1;
    private View cutBackground2;
    private ViewGroup cutBar;
    private AppCompatImageButton cutButton;
    private TextView cutLabelEnd;
    private TextView cutLabelStart;
    private TextView cutRangeEnd;
    private TextView cutRangeStart;
    private View dashView;
    private ViewGroup dateTimeContainer;
    private ImageView dateTimeImageView;
    private TextView dateTimeTextView;
    private AppCompatImageButton mediaButton;
    private boolean mute;
    private AppCompatImageButton muteButton;
    private OnCutBarClickListener onCutBarClickListener;
    private OnDateTimeClickListener onDateTimeClickListener;
    private OnMuteClickListener onMuteClickListener;
    private OnPlaybackSpeedChangedListener onPlaybackSpeedChangedListener;
    private OnPlaybackSpeedClickListener onPlaybackSpeedClickListener;
    private OnQualityChangedListener onQualityChangedListener;
    private OnQualityClickListener onQualityClickListener;
    private OnSaveVideoClickListener onSaveVideoClickListener;
    private PopupMenu playBackSpeedMenu;
    private PopupMenu playQualityMenu;
    private AppCompatImageButton playbackSpeedButton;
    private Quality quality;
    private AppCompatImageButton saveVideoButton;

    interface OnCutBarClickListener {
        void onHide();

        void onShow();
    }

    interface OnDateTimeClickListener {
        void onDateTimeClick();
    }

    interface OnMuteClickListener {
        void onMuteClick();

        void onUnmuteClick();
    }

    interface OnPlaybackSpeedChangedListener {
        void onPlaybackSpeedChanged(PlaybackSpeed speed);
    }

    interface OnPlaybackSpeedClickListener {
        void onPlaybackSpeedClick();
    }

    interface OnQualityChangedListener {
        void onQualityChanged(Quality quality);
    }

    interface OnQualityClickListener {
        void onQualityClick(Quality quality);
    }

    interface OnSaveVideoClickListener {
        void onSaveVideoClick();
    }

    public FlussonicBottomBar(Context context, AttributeSet attrs) throws Resources.NotFoundException {
        super(context, attrs);
        this.mute = false;
        this.quality = null;
        init(attrs);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) throws Resources.NotFoundException {
        super.onLayout(changed, l, t, r, b);
        setupColors();
    }

    void setupGradientBackground(int colorGradient1, int colorGradient2) {
        this.colorGradient2 = colorGradient2;
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, colorGradient1, colorGradient2}));
        this.backgroundDrawable = getBackground();
    }

    private void setupColors() throws Resources.NotFoundException {
        setupColors(false);
    }

    private void setupColors(boolean shouldUpdate) throws Resources.NotFoundException {
        FlussonicColorTheme flussonicColorTheme = FlussonicColorTheme.getInstance();
        int color = FlussonicColorTheme.getInstance().getColor("fs_bottom_bar_gradient1");
        int color2 = FlussonicColorTheme.getInstance().getColor("fs_bottom_bar_gradient2");
        if (flussonicColorTheme.themeChanged || shouldUpdate || this.colorGradient2 != color2) {
            TypedValue typedValue = new TypedValue();
            getResources().getValue(R$dimen.fs_text_shadow_radius, typedValue, true);
            float f = typedValue.getFloat();
            setupGradientBackground(color, color2);
            this.saveVideoButton.getBackground().setColorFilter(flussonicColorTheme.getColor("fs_range"), PorterDuff.Mode.SRC);
            this.dateTimeTextView.setTextColor(flussonicColorTheme.getColor("fs_bottom_bar_date_text"));
            this.dateTimeTextView.setShadowLayer(f, 0.0f, 2.0f, color2);
            this.dateTimeImageView.setColorFilter(flussonicColorTheme.getColor("fs_bottom_bar_icon"));
            this.dashView.setBackgroundColor(flussonicColorTheme.getColor("fs_dash"));
            this.bottombarDivider.setBackgroundColor(flussonicColorTheme.getColor("fs_bottom_bar_divider"));
            this.cutLabelStart.setTextColor(flussonicColorTheme.getColor("fs_cut_label"));
            this.cutLabelEnd.setTextColor(flussonicColorTheme.getColor("fs_cut_label"));
            Drawable background = this.cutBackground1.getBackground();
            int color3 = flussonicColorTheme.getColor("fs_cut_timestamp_background");
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            background.setColorFilter(color3, mode);
            this.cutBackground2.getBackground().setColorFilter(flussonicColorTheme.getColor("fs_cut_timestamp_background"), mode);
            this.cutRangeStart.setTextColor(flussonicColorTheme.getColor("fs_cut_value"));
            this.cutRangeEnd.setTextColor(flussonicColorTheme.getColor("fs_cut_value"));
            this.muteButton.setColorFilter(flussonicColorTheme.getColor("fs_bottom_bar_icon"));
            this.mediaButton.setColorFilter(flussonicColorTheme.getColor("fs_bottom_bar_icon"));
            this.playbackSpeedButton.setColorFilter(flussonicColorTheme.getColor("fs_bottom_bar_icon"));
            this.cutButton.setColorFilter(flussonicColorTheme.getColor("fs_bottom_bar_icon"));
        }
    }

    /* renamed from: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality;

        static {
            int[] iArr = new int[Quality.values().length];
            $SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality = iArr;
            try {
                iArr[Quality.HD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[Quality.SD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[Quality.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static int getQualityIcon(Quality quality) {
        if (quality == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[quality.ordinal()];
        if (i == 1) {
            return R$drawable.fs_hd;
        }
        if (i == 2) {
            return R$drawable.fs_sd;
        }
        if (i != 3) {
            return 0;
        }
        return R$drawable.fs_auto;
    }

    private void init(AttributeSet attrs) throws Resources.NotFoundException {
        View.inflate(getContext(), R$layout.fs_view_flussonic_bottom_bar, this);
        this.colorGradient2 = ContextCompat.getColor(getContext(), R$color.fs_bottom_bar_gradient2);
        this.backgroundDrawable = getBackground();
        setOrientation(1);
        setup();
    }

    private void setup() throws Resources.NotFoundException {
        this.dateTimeContainer = (ViewGroup) findViewById(R$id.fs_date_time_container);
        this.dateTimeTextView = (TextView) findViewById(R$id.fs_bottom_bar_date_text_view);
        this.dateTimeImageView = (ImageView) findViewById(R$id.fs_date_time_image_view);
        this.cameraStatusImageView = (ImageView) findViewById(R$id.fs_camera_status);
        this.muteButton = (AppCompatImageButton) findViewById(R$id.fs_mute_btn);
        this.mediaButton = (AppCompatImageButton) findViewById(R$id.fs_playback_media_btn);
        this.playbackSpeedButton = (AppCompatImageButton) findViewById(R$id.fs_playback_speed_btn);
        this.cutButton = (AppCompatImageButton) findViewById(R$id.fs_cut_bar_btn);
        this.cutBar = (ViewGroup) findViewById(R$id.fs_cut_bar);
        this.cutRangeStart = (TextView) findViewById(R$id.fs_cut_range_start);
        this.cutRangeEnd = (TextView) findViewById(R$id.fs_cut_range_end);
        this.saveVideoButton = (AppCompatImageButton) findViewById(R$id.fs_save_video);
        this.cutBackground1 = findViewById(R$id.fs_cut_timestamp_background1);
        this.dashView = findViewById(R$id.fs_cut_dash);
        this.bottombarDivider = findViewById(R$id.fs_bottom_bar_divider);
        this.cutLabelStart = (TextView) findViewById(R$id.fs_cut_label_start);
        this.cutLabelEnd = (TextView) findViewById(R$id.fs_cut_label_end);
        this.cutBackground2 = findViewById(R$id.fs_cut_timestamp_background2);
        setupColors(true);
        setupListeners();
        createPlaybackSpeedMenu();
        createQualityMenu();
    }

    private void setupListeners() {
        this.muteButton.setOnClickListener(new View.OnClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$0(view);
            }
        });
        this.mediaButton.setOnClickListener(new View.OnClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$1(view);
            }
        });
        this.playbackSpeedButton.setOnClickListener(new View.OnClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$2(view);
            }
        });
        this.cutButton.setOnClickListener(new View.OnClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$3(view);
            }
        });
        this.saveVideoButton.setOnClickListener(new View.OnClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupListeners$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$0(View view) {
        OnMuteClickListener onMuteClickListener = this.onMuteClickListener;
        if (onMuteClickListener != null) {
            if (this.mute) {
                onMuteClickListener.onUnmuteClick();
            } else {
                onMuteClickListener.onMuteClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$1(View view) {
        Quality quality;
        OnQualityClickListener onQualityClickListener = this.onQualityClickListener;
        if (onQualityClickListener == null || (quality = this.quality) == null) {
            return;
        }
        onQualityClickListener.onQualityClick(quality);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$2(View ignored) {
        OnPlaybackSpeedClickListener onPlaybackSpeedClickListener = this.onPlaybackSpeedClickListener;
        if (onPlaybackSpeedClickListener != null) {
            onPlaybackSpeedClickListener.onPlaybackSpeedClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$3(View ignored) {
        if (this.onCutBarClickListener != null) {
            if (this.cutBar.getVisibility() == 0) {
                this.onCutBarClickListener.onHide();
            } else {
                this.onCutBarClickListener.onShow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$4(View ignored) {
        OnSaveVideoClickListener onSaveVideoClickListener = this.onSaveVideoClickListener;
        if (onSaveVideoClickListener != null) {
            onSaveVideoClickListener.onSaveVideoClick();
        }
    }

    private void createPlaybackSpeedMenu() throws Resources.NotFoundException {
        PopupMenu popupMenu = new PopupMenu(getContext(), this.playbackSpeedButton);
        this.playBackSpeedMenu = popupMenu;
        Menu menu = popupMenu.getMenu();
        for (PlaybackSpeed playbackSpeed : PlaybackSpeed.values()) {
            menu.add(1, playbackSpeed.ordinal(), playbackSpeed.ordinal(), getResources().getString(R$string.fs_playback_speed_x, playbackSpeed.toStringPretty()));
        }
        menu.setGroupCheckable(1, true, true);
        this.playBackSpeedMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$$ExternalSyntheticLambda6
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.onPlaybackSpeedChosen(menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onPlaybackSpeedChosen(MenuItem item) {
        PlaybackSpeed playbackSpeed = PlaybackSpeed.values()[item.getItemId()];
        OnPlaybackSpeedChangedListener onPlaybackSpeedChangedListener = this.onPlaybackSpeedChangedListener;
        if (onPlaybackSpeedChangedListener == null) {
            return false;
        }
        onPlaybackSpeedChangedListener.onPlaybackSpeedChanged(playbackSpeed);
        return true;
    }

    private void createQualityMenu() throws Resources.NotFoundException {
        PopupMenu popupMenu = new PopupMenu(getContext(), this.mediaButton);
        this.playQualityMenu = popupMenu;
        Menu menu = popupMenu.getMenu();
        for (Quality quality : Quality.values()) {
            menu.add(1, quality.ordinal(), quality.ordinal(), getResources().getString(getQualityString(quality)));
        }
        menu.setGroupCheckable(1, true, true);
        this.playQualityMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$$ExternalSyntheticLambda0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.onQualityChosen(menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onQualityChosen(MenuItem menuItem) {
        Quality quality = Quality.values()[menuItem.getItemId()];
        OnQualityChangedListener onQualityChangedListener = this.onQualityChangedListener;
        if (onQualityChangedListener == null) {
            return false;
        }
        onQualityChangedListener.onQualityChanged(quality);
        return true;
    }

    private static int getQualityString(Quality quality) {
        int i = AnonymousClass1.$SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[quality.ordinal()];
        if (i == 1) {
            return R$string.fs_quality_hd;
        }
        if (i == 2) {
            return R$string.fs_quality_sd;
        }
        if (i != 3) {
            return 0;
        }
        return R$string.fs_quality_auto;
    }

    public void hideCameraStatusAndDateTime() {
        this.dateTimeTextView.setText("");
        this.dateTimeContainer.setVisibility(8);
        this.cameraStatusImageView.setVisibility(8);
    }

    public void setCameraStatus(boolean isActive) {
        this.dateTimeContainer.setVisibility(0);
        this.cameraStatusImageView.setVisibility(0);
        this.cameraStatusImageView.setImageResource(R$drawable.fs_ic_circle);
        this.cameraStatusImageView.setColorFilter(FlussonicColorTheme.getInstance().getColor(isActive ? "fs_camera_status_icon_active" : "fs_camera_status_icon_inactive"), PorterDuff.Mode.SRC_ATOP);
    }

    public void setCalendarClickable(boolean clickable) {
        this.dateTimeContainer.setOnClickListener(clickable ? new View.OnClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setCalendarClickable$5(view);
            }
        } : null);
        if (clickable) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R$attr.selectableItemBackgroundBorderless});
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            this.dateTimeContainer.setBackgroundResource(resourceId);
        } else {
            this.dateTimeContainer.setBackground(null);
        }
        this.dateTimeContainer.setClickable(clickable);
        this.dateTimeContainer.setFocusable(clickable);
        this.dateTimeImageView.setVisibility(clickable ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCalendarClickable$5(View view) {
        OnDateTimeClickListener onDateTimeClickListener = this.onDateTimeClickListener;
        if (onDateTimeClickListener != null) {
            onDateTimeClickListener.onDateTimeClick();
        }
    }

    public void setDateTime(long dateTimeInSecs) {
        this.dateTimeContainer.setVisibility(0);
        this.dateTimeTextView.setText(CalendarUtils.toString(dateTimeInSecs, "dd.MM.yyyy HH:mm:ss"));
    }

    public void setOnDateTimeClickListener(OnDateTimeClickListener listener) {
        this.onDateTimeClickListener = listener;
    }

    public void setOnMuteClickListener(OnMuteClickListener listener) {
        this.onMuteClickListener = listener;
    }

    public void setOnQualityClickListener(OnQualityClickListener listener) {
        this.onQualityClickListener = listener;
    }

    public void setOnQualityChangedListener(OnQualityChangedListener listener) {
        this.onQualityChangedListener = listener;
    }

    public void setOnPlaybackSpeedClickListener(OnPlaybackSpeedClickListener listener) {
        this.onPlaybackSpeedClickListener = listener;
    }

    public void setOnPlaybackSpeedChangedListener(OnPlaybackSpeedChangedListener listener) {
        this.onPlaybackSpeedChangedListener = listener;
    }

    public void setOnCutBarClickListener(OnCutBarClickListener listener) {
        this.onCutBarClickListener = listener;
    }

    public void setOnSaveVideoClickListener(OnSaveVideoClickListener listener) {
        this.onSaveVideoClickListener = listener;
    }

    public void setTransparentFactor(float factor) {
        this.backgroundDrawable.setAlpha(Math.round(factor * 255.0f));
        invalidate();
    }

    public void setMute(boolean mute) {
        this.mute = mute;
        this.muteButton.setImageResource(mute ? R$drawable.fs_ic_mute : R$drawable.fs_ic_unmute);
    }

    public void setMuteVisibility(boolean visible) {
        this.muteButton.setVisibility(visible ? 0 : 8);
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
        this.mediaButton.setVisibility(quality == null ? 8 : 0);
        this.mediaButton.setImageResource(getQualityIcon(quality));
    }

    public void showPlayBackSpeedMenu(PlaybackSpeed checkedSpeed) {
        this.playBackSpeedMenu.getMenu().getItem(checkedSpeed.ordinal()).setChecked(true);
        this.playBackSpeedMenu.show();
    }

    public void showQualityMenu(Quality quality) {
        this.playQualityMenu.getMenu().getItem(quality.ordinal()).setChecked(true);
        this.playQualityMenu.show();
    }

    public void hidePlaybackSpeedMenu() {
        this.playBackSpeedMenu.dismiss();
    }

    public void setPlaybackSpeedVisibility(boolean visible) {
        this.playbackSpeedButton.setVisibility(visible ? 0 : 8);
    }

    public void setCutBarVisibility(boolean visible) {
        this.cutBar.setVisibility(visible ? 0 : 8);
        this.cutButton.setColorFilter(FlussonicColorTheme.getInstance().getColor(visible ? "fs_range" : "fs_bottom_bar_icon"));
    }

    public boolean isCutBarVisible() {
        return this.cutBar.getVisibility() == 0;
    }

    public void setCutRangeStart(long seconds) {
        this.cutRangeStart.setText(CalendarUtils.toString(seconds, "HH:mm:ss"));
    }

    public void setCutRangeEnd(long seconds) {
        this.cutRangeEnd.setText(CalendarUtils.toString(seconds, "HH:mm:ss"));
    }

    public void setCutButtonVisibility(boolean allow) {
        this.cutButton.setVisibility(allow ? 0 : 8);
    }
}
