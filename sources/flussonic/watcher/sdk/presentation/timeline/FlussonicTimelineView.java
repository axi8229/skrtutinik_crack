package flussonic.watcher.sdk.presentation.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.google.android.gms.location.DeviceOrientationRequest;
import flussonic.watcher.sdk.R$dimen;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.domain.pojo.PlaybackSpeed;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;
import flussonic.watcher.sdk.presentation.core.FlussonicTimeline;
import flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar;
import flussonic.watcher.sdk.presentation.timeline.FlussonicChartBar;
import flussonic.watcher.sdk.presentation.timeline.FlussonicCutRange;
import flussonic.watcher.sdk.presentation.timeline.FlussonicLiveButton;

/* loaded from: classes3.dex */
public class FlussonicTimelineView extends LinearLayout implements FlussonicTimeline {
    private final Runnable backToResumeCallback;
    private FlussonicBottomBar bottomBar;
    private FlussonicChartBar chartBar;
    private FlussonicCutRange cutRange;
    private long lastPosition;
    private FlussonicLiveButton liveButton;
    private FlussonicTimeline.TimelineListener timelineListener;
    private float timelineTransparentFactor;
    private boolean updateProgress;

    public FlussonicTimelineView(Context context, AttributeSet attrs) throws Resources.NotFoundException {
        super(context, attrs);
        this.backToResumeCallback = new Runnable() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView.1
            @Override // java.lang.Runnable
            public void run() {
                FlussonicTimelineView.this.liveButton.setLiveState(true);
                FlussonicTimelineView.this.updateProgress = true;
                if (FlussonicTimelineView.this.lastPosition > 0) {
                    FlussonicTimelineView flussonicTimelineView = FlussonicTimelineView.this;
                    flussonicTimelineView.updateProgress(flussonicTimelineView.lastPosition);
                }
            }
        };
        init(context);
    }

    private void init(Context context) throws Resources.NotFoundException {
        View.inflate(context, R$layout.fs_view_flussonic_timeline, this);
        setOrientation(1);
        setup();
    }

    private void setup() throws Resources.NotFoundException {
        this.chartBar = (FlussonicChartBar) findViewById(R$id.fs_chart_bar);
        this.liveButton = (FlussonicLiveButton) findViewById(R$id.fs_live_slider);
        this.bottomBar = (FlussonicBottomBar) findViewById(R$id.fs_bottom_bar);
        this.cutRange = (FlussonicCutRange) findViewById(R$id.fs_cut_range);
        this.liveButton.setLiveState(true);
        this.updateProgress = true;
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R$dimen.fs_timeline_transparent_factor, typedValue, true);
        this.timelineTransparentFactor = typedValue.getFloat();
        setListeners();
    }

    private void setListeners() {
        this.chartBar.setOnScrollChangedListener(new FlussonicChartBar.OnScrollChanged() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda1
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicChartBar.OnScrollChanged
            public final void onScroll(long j) {
                this.f$0.lambda$setListeners$0(j);
            }
        });
        this.chartBar.setOnVisibleIntervalChangedListener(new FlussonicChartBar.OnVisibleIntervalChanged() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda2
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicChartBar.OnVisibleIntervalChanged
            public final void onChanged(VisibleRangeChangedEvent visibleRangeChangedEvent) {
                this.f$0.lambda$setListeners$1(visibleRangeChangedEvent);
            }
        });
        this.chartBar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView.2
            private final int[] outLocation = new int[2];

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FlussonicTimelineView.this.timelineListener != null) {
                    FlussonicTimelineView.this.chartBar.getLocationInWindow(this.outLocation);
                    FlussonicTimelineView.this.timelineListener.onChartBarYChanged(this.outLocation[1]);
                }
            }
        });
        this.liveButton.setOnPlayClickListener(new FlussonicLiveButton.OnPlayClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView.3
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicLiveButton.OnPlayClickListener
            public void onPlayClick() {
                long actualPosition = FlussonicTimelineView.this.chartBar.getActualPosition();
                long borderTo = FlussonicTimelineView.this.chartBar.getBorderTo();
                if (Math.abs(borderTo - actualPosition) <= ((long) (FlussonicTimelineView.this.chartBar.getScaleFactor() * 300.0d))) {
                    FlussonicTimelineView.this.playLive();
                } else {
                    FlussonicTimelineView.this.playFrom(actualPosition);
                }
            }

            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicLiveButton.OnPlayClickListener
            public void onLiveClick() {
                FlussonicTimelineView.this.playLive();
            }
        });
        this.bottomBar.setOnDateTimeClickListener(new FlussonicBottomBar.OnDateTimeClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda3
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnDateTimeClickListener
            public final void onDateTimeClick() {
                this.f$0.showDateTimePicker();
            }
        });
        this.bottomBar.setOnMuteClickListener(new FlussonicBottomBar.OnMuteClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView.4
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnMuteClickListener
            public void onMuteClick() {
                if (FlussonicTimelineView.this.timelineListener != null) {
                    FlussonicTimelineView.this.timelineListener.onMuteClick();
                }
            }

            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnMuteClickListener
            public void onUnmuteClick() {
                if (FlussonicTimelineView.this.timelineListener != null) {
                    FlussonicTimelineView.this.timelineListener.onUnmuteClick();
                }
            }
        });
        this.bottomBar.setOnQualityClickListener(new FlussonicBottomBar.OnQualityClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda4
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnQualityClickListener
            public final void onQualityClick(Quality quality) {
                this.f$0.lambda$setListeners$2(quality);
            }
        });
        this.bottomBar.setOnQualityChangedListener(new FlussonicBottomBar.OnQualityChangedListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda5
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnQualityChangedListener
            public final void onQualityChanged(Quality quality) {
                this.f$0.lambda$setListeners$3(quality);
            }
        });
        this.bottomBar.setOnPlaybackSpeedClickListener(new FlussonicBottomBar.OnPlaybackSpeedClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda6
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnPlaybackSpeedClickListener
            public final void onPlaybackSpeedClick() {
                this.f$0.lambda$setListeners$4();
            }
        });
        this.bottomBar.setOnPlaybackSpeedChangedListener(new FlussonicBottomBar.OnPlaybackSpeedChangedListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda7
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnPlaybackSpeedChangedListener
            public final void onPlaybackSpeedChanged(PlaybackSpeed playbackSpeed) {
                this.f$0.lambda$setListeners$5(playbackSpeed);
            }
        });
        this.bottomBar.setOnCutBarClickListener(new FlussonicBottomBar.OnCutBarClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView.5
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnCutBarClickListener
            public void onShow() {
                FlussonicTimelineView.this.updateProgress = false;
                FlussonicTimelineView.this.bottomBar.setCutBarVisibility(true);
                FlussonicTimelineView.this.liveButton.setVisibility(8);
                FlussonicTimelineView.this.cutRange.setVisibility(0);
                FlussonicTimelineView.this.bottomBar.setCutRangeStart(FlussonicTimelineView.this.chartBar.getTimeAtPosition(FlussonicTimelineView.this.cutRange.getSliderOnePosition()));
                FlussonicTimelineView.this.bottomBar.setCutRangeEnd(FlussonicTimelineView.this.chartBar.getTimeAtPosition(FlussonicTimelineView.this.cutRange.getSliderTwoPosition()));
                FlussonicTimelineView flussonicTimelineView = FlussonicTimelineView.this;
                flussonicTimelineView.removeCallbacks(flussonicTimelineView.backToResumeCallback);
            }

            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnCutBarClickListener
            public void onHide() {
                FlussonicTimelineView.this.updateProgress = true;
                FlussonicTimelineView.this.bottomBar.setCutBarVisibility(false);
                FlussonicTimelineView.this.liveButton.setVisibility(0);
                FlussonicTimelineView.this.cutRange.setVisibility(8);
                FlussonicTimelineView flussonicTimelineView = FlussonicTimelineView.this;
                flussonicTimelineView.postDelayed(flussonicTimelineView.backToResumeCallback, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
            }
        });
        this.cutRange.setOnCutRangeChangeListener(new FlussonicCutRange.OnCutRangeChangeListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda8
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicCutRange.OnCutRangeChangeListener
            public final void onCutRangeChanged(float f, float f2) {
                this.f$0.lambda$setListeners$6(f, f2);
            }
        });
        this.bottomBar.setOnSaveVideoClickListener(new FlussonicBottomBar.OnSaveVideoClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda9
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicBottomBar.OnSaveVideoClickListener
            public final void onSaveVideoClick() {
                this.f$0.lambda$setListeners$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$0(long position) {
        if (!this.updateProgress) {
            this.bottomBar.setDateTime(position);
            removeCallbacks(this.backToResumeCallback);
            if (!this.bottomBar.isCutBarVisible()) {
                postDelayed(this.backToResumeCallback, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
            }
        }
        if (this.bottomBar.isCutBarVisible()) {
            this.bottomBar.setCutRangeStart(this.chartBar.getTimeAtPosition(this.cutRange.getSliderOnePosition()));
            this.bottomBar.setCutRangeEnd(this.chartBar.getTimeAtPosition(this.cutRange.getSliderTwoPosition()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$1(VisibleRangeChangedEvent event) {
        FlussonicTimeline.TimelineListener timelineListener = this.timelineListener;
        if (timelineListener != null) {
            timelineListener.onVisibleIntervalChanged(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$2(Quality quality) {
        FlussonicTimeline.TimelineListener timelineListener = this.timelineListener;
        if (timelineListener != null) {
            timelineListener.onQualityClick(quality);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$3(Quality quality) {
        FlussonicTimeline.TimelineListener timelineListener = this.timelineListener;
        if (timelineListener != null) {
            timelineListener.onQualityChanged(quality);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$4() {
        FlussonicTimeline.TimelineListener timelineListener = this.timelineListener;
        if (timelineListener != null) {
            timelineListener.onPlaybackSpeedClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$5(PlaybackSpeed speed) {
        FlussonicTimeline.TimelineListener timelineListener = this.timelineListener;
        if (timelineListener != null) {
            timelineListener.onPlaybackSpeedChanged(speed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$6(float sliderOnePosition, float sliderTwoPosition) {
        this.bottomBar.setCutRangeStart(this.chartBar.getTimeAtPosition(sliderOnePosition));
        this.bottomBar.setCutRangeEnd(this.chartBar.getTimeAtPosition(sliderTwoPosition));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListeners$7() {
        if (this.timelineListener != null) {
            this.timelineListener.onDownloadRequest(this.chartBar.getTimeAtPosition(this.cutRange.getSliderOnePosition()), this.chartBar.getTimeAtPosition(this.cutRange.getSliderTwoPosition()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.backToResumeCallback);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void updateProgress(long position) {
        this.chartBar.increaseWidthIfNecessary(position);
        this.lastPosition = position;
        if (this.updateProgress) {
            this.liveButton.setLiveState(true);
            this.chartBar.scrollToPosition(position);
            this.bottomBar.setDateTime(position);
        }
    }

    public void fixScroll() {
        if (this.updateProgress && this.chartBar.isBordersInitialized()) {
            this.liveButton.setLiveState(true);
            this.chartBar.scrollToPosition(this.lastPosition);
            this.bottomBar.setDateTime(this.lastPosition);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void moveToPosition(long position) {
        this.chartBar.increaseWidthIfNecessary(position);
        this.chartBar.scrollToPosition(position);
        this.bottomBar.setDateTime(position);
        this.lastPosition = position;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void clearPosition() {
        this.lastPosition = 0L;
        this.bottomBar.hideCameraStatusAndDateTime();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setBorders(Range range) {
        this.chartBar.setBorders(range);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setRanges(Ranges ranges) {
        this.chartBar.setRanges(ranges);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setCameraStatus(boolean isActive) {
        this.bottomBar.setCameraStatus(isActive);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setCalendarClickable(boolean clickable) {
        this.chartBar.setOnUserScrollListener(clickable ? new FlussonicChartBar.OnUserScrollListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView$$ExternalSyntheticLambda0
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicChartBar.OnUserScrollListener
            public final void onScroll() {
                this.f$0.lambda$setCalendarClickable$8();
            }
        } : null);
        this.bottomBar.setCalendarClickable(clickable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCalendarClickable$8() {
        this.liveButton.setLiveState(false);
        this.updateProgress = false;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setTimelineListener(FlussonicTimeline.TimelineListener listener) {
        this.timelineListener = listener;
    }

    public void setTransparent(boolean transparent) {
        float f = transparent ? this.timelineTransparentFactor : 1.0f;
        this.chartBar.setTransparentFactor(f);
        this.bottomBar.setTransparentFactor(f);
    }

    public boolean isCollapsed() {
        return this.chartBar.isCollapsed();
    }

    public void collapse() {
        this.chartBar.collapse();
        this.bottomBar.setVisibility(8);
        this.liveButton.setVisibility(8);
        this.cutRange.setVisibility(8);
        this.bottomBar.hidePlaybackSpeedMenu();
    }

    public void expand() {
        this.chartBar.expand();
        this.bottomBar.setVisibility(0);
        if (this.bottomBar.isCutBarVisible()) {
            this.cutRange.setVisibility(0);
            this.liveButton.setVisibility(8);
        } else {
            this.liveButton.setVisibility(0);
            this.cutRange.setVisibility(8);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setMute(boolean mute) {
        this.bottomBar.setMute(mute);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setMuteVisibility(boolean visible) {
        this.bottomBar.setMuteVisibility(visible);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setQuality(Quality quality) {
        this.bottomBar.setQuality(quality);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void showQualityMenu(Quality quality) {
        this.bottomBar.showQualityMenu(quality);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void showPlaybackSpeedMenu(PlaybackSpeed checkedSpeed) {
        this.bottomBar.showPlayBackSpeedMenu(checkedSpeed);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setPlaybackSpeedVisibility(boolean visible) {
        this.bottomBar.setPlaybackSpeedVisibility(visible);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline
    public void setAllowDownload(boolean allowDownload) {
        this.bottomBar.setCutButtonVisibility(allowDownload);
        if (allowDownload) {
            return;
        }
        this.bottomBar.setCutBarVisibility(false);
        this.cutRange.setVisibility(8);
        if (this.chartBar.isCollapsed()) {
            return;
        }
        this.liveButton.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDateTimePicker() {
        FlussonicTimeline.TimelineListener timelineListener = this.timelineListener;
        if (timelineListener != null) {
            timelineListener.showDatePicker(this.chartBar.getBorderFrom(), this.chartBar.getBorderTo(), this.chartBar.getActualPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playFrom(long position) {
        this.liveButton.setLiveState(true);
        this.updateProgress = true;
        FlussonicTimeline.TimelineListener timelineListener = this.timelineListener;
        if (timelineListener != null) {
            timelineListener.onPlayClick(position);
        }
        removeCallbacks(this.backToResumeCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playLive() {
        this.liveButton.setLiveState(true);
        this.updateProgress = true;
        FlussonicTimeline.TimelineListener timelineListener = this.timelineListener;
        if (timelineListener != null) {
            timelineListener.onLiveClick();
        }
        removeCallbacks(this.backToResumeCallback);
    }
}
