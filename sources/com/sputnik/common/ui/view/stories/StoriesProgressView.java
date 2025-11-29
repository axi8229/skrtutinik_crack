package com.sputnik.common.ui.view.stories;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$styleable;
import com.sputnik.common.ui.view.stories.PausableProgressBar;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoriesProgressView.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 D2\u00020\u0001:\u0003DEFB\u001d\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u000bJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\u000bJ\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u001b\u0010+\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0012¢\u0006\u0004\b.\u0010\u0019J\r\u0010/\u001a\u00020\b¢\u0006\u0004\b/\u0010\u000bJ\r\u00100\u001a\u00020\b¢\u0006\u0004\b0\u0010\u000bJ\r\u00101\u001a\u00020\b¢\u0006\u0004\b1\u0010\u000bR\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\f068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00109R\u0016\u0010:\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b=\u0010?\"\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010>R\u0016\u0010C\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010>¨\u0006G"}, d2 = {"Lcom/sputnik/common/ui/view/stories/StoriesProgressView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "init", "bindViews", "()V", "Lcom/sputnik/common/ui/view/stories/PausableProgressBar;", "createProgressBar", "()Lcom/sputnik/common/ui/view/stories/PausableProgressBar;", "Landroid/view/View;", "createSpace", "()Landroid/view/View;", "", "index", "Lcom/sputnik/common/ui/view/stories/PausableProgressBar$Callback;", "callback", "(I)Lcom/sputnik/common/ui/view/stories/PausableProgressBar$Callback;", "storiesCount", "setStoriesCount", "(I)V", "Lcom/sputnik/common/ui/view/stories/StoriesProgressView$StoriesListener;", "storiesListener", "setStoriesListener", "(Lcom/sputnik/common/ui/view/stories/StoriesProgressView$StoriesListener;)V", "skip", "reverse", "", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "setStoryDuration", "(J)V", "", "durations", "setStoriesCountWithDurations", "([J)V", "", "Lcom/sputnik/common/ui/view/stories/StoriesProgressView$ProgressBarColor;", "colors", "setStoriesProgressColors", "(Ljava/util/List;)V", RemoteMessageConst.FROM, "startStories", "destroy", "pause", "resume", "Landroid/widget/LinearLayout$LayoutParams;", "PROGRESS_BAR_LAYOUT_PARAM", "Landroid/widget/LinearLayout$LayoutParams;", "SPACE_LAYOUT_PARAM", "", "progressBars", "Ljava/util/List;", "I", "current", "Lcom/sputnik/common/ui/view/stories/StoriesProgressView$StoriesListener;", "", "isComplete", "Z", "()Z", "setComplete", "(Z)V", "isSkipStart", "isReverseStart", "Companion", "ProgressBarColor", "StoriesListener", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StoriesProgressView extends LinearLayout {
    private static final String TAG = StoriesProgressView.class.getSimpleName();
    private final LinearLayout.LayoutParams PROGRESS_BAR_LAYOUT_PARAM;
    private final LinearLayout.LayoutParams SPACE_LAYOUT_PARAM;
    private int current;
    private boolean isComplete;
    private boolean isReverseStart;
    private boolean isSkipStart;
    private final List<PausableProgressBar> progressBars;
    private int storiesCount;
    private StoriesListener storiesListener;

    /* compiled from: StoriesProgressView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/ui/view/stories/StoriesProgressView$StoriesListener;", "", "onComplete", "", "onNext", "onPrev", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface StoriesListener {
        void onComplete();

        void onNext();

        void onPrev();
    }

    public final void setComplete(boolean z) {
        this.isComplete = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoriesProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.PROGRESS_BAR_LAYOUT_PARAM = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.SPACE_LAYOUT_PARAM = new LinearLayout.LayoutParams(5, -2);
        this.progressBars = new ArrayList();
        this.storiesCount = -1;
        this.current = -1;
        init(context, attributeSet);
    }

    private final void init(Context context, AttributeSet attrs) {
        setOrientation(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.StoriesProgressView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.storiesCount = typedArrayObtainStyledAttributes.getInt(R$styleable.StoriesProgressView_progressCount, 0);
        typedArrayObtainStyledAttributes.recycle();
        bindViews();
    }

    private final void bindViews() {
        this.progressBars.clear();
        removeAllViews();
        int i = this.storiesCount;
        int i2 = 0;
        while (i2 < i) {
            PausableProgressBar pausableProgressBarCreateProgressBar = createProgressBar();
            this.progressBars.add(pausableProgressBarCreateProgressBar);
            addView(pausableProgressBarCreateProgressBar);
            i2++;
            if (i2 < this.storiesCount) {
                addView(createSpace());
            }
        }
    }

    private final PausableProgressBar createProgressBar() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PausableProgressBar pausableProgressBar = new PausableProgressBar(context);
        pausableProgressBar.setLayoutParams(this.PROGRESS_BAR_LAYOUT_PARAM);
        return pausableProgressBar;
    }

    private final View createSpace() {
        View view = new View(getContext());
        view.setLayoutParams(this.SPACE_LAYOUT_PARAM);
        return view;
    }

    public final void setStoriesCount(int storiesCount) {
        this.storiesCount = storiesCount;
        bindViews();
    }

    public final void setStoriesListener(StoriesListener storiesListener) {
        this.storiesListener = storiesListener;
    }

    public final void skip() {
        int i;
        if (this.isSkipStart || this.isReverseStart || this.isComplete || (i = this.current) < 0) {
            return;
        }
        PausableProgressBar pausableProgressBar = this.progressBars.get(i);
        this.isSkipStart = true;
        pausableProgressBar.setMax();
    }

    public final void reverse() {
        int i;
        if (this.isSkipStart || this.isReverseStart || this.isComplete || (i = this.current) < 0) {
            return;
        }
        PausableProgressBar pausableProgressBar = this.progressBars.get(i);
        this.isReverseStart = true;
        pausableProgressBar.setMin();
    }

    public final void setStoryDuration(long duration) {
        int size = this.progressBars.size();
        for (int i = 0; i < size; i++) {
            this.progressBars.get(i).setDuration(duration);
            this.progressBars.get(i).setCallback(callback(i));
        }
    }

    public final void setStoriesCountWithDurations(long[] durations) {
        Intrinsics.checkNotNullParameter(durations, "durations");
        this.storiesCount = durations.length;
        bindViews();
        int size = this.progressBars.size();
        for (int i = 0; i < size; i++) {
            this.progressBars.get(i).setDuration(durations[i]);
            this.progressBars.get(i).setCallback(callback(i));
        }
    }

    /* compiled from: StoriesProgressView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/common/ui/view/stories/StoriesProgressView$ProgressBarColor;", "", "", "trackColor", "progressColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTrackColor", "getProgressColor", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ProgressBarColor {
        private final String progressColor;
        private final String trackColor;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProgressBarColor)) {
                return false;
            }
            ProgressBarColor progressBarColor = (ProgressBarColor) other;
            return Intrinsics.areEqual(this.trackColor, progressBarColor.trackColor) && Intrinsics.areEqual(this.progressColor, progressBarColor.progressColor);
        }

        public int hashCode() {
            return (this.trackColor.hashCode() * 31) + this.progressColor.hashCode();
        }

        public String toString() {
            return "ProgressBarColor(trackColor=" + this.trackColor + ", progressColor=" + this.progressColor + ")";
        }

        public ProgressBarColor(String trackColor, String progressColor) {
            Intrinsics.checkNotNullParameter(trackColor, "trackColor");
            Intrinsics.checkNotNullParameter(progressColor, "progressColor");
            this.trackColor = trackColor;
            this.progressColor = progressColor;
        }

        public final String getTrackColor() {
            return this.trackColor;
        }

        public final String getProgressColor() {
            return this.progressColor;
        }
    }

    public final void setStoriesProgressColors(List<ProgressBarColor> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        int i = 0;
        for (Object obj : colors) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProgressBarColor progressBarColor = (ProgressBarColor) obj;
            int color = Color.parseColor(progressBarColor.getProgressColor());
            this.progressBars.get(i).setTrackColor(Color.parseColor(progressBarColor.getTrackColor()));
            this.progressBars.get(i).setProgressColor(color);
            i = i2;
        }
    }

    private final PausableProgressBar.Callback callback(final int index) {
        return new PausableProgressBar.Callback() { // from class: com.sputnik.common.ui.view.stories.StoriesProgressView.callback.1
            @Override // com.sputnik.common.ui.view.stories.PausableProgressBar.Callback
            public void onStartProgress() {
                StoriesProgressView.this.current = index;
            }

            @Override // com.sputnik.common.ui.view.stories.PausableProgressBar.Callback
            public void onFinishProgress() {
                if (StoriesProgressView.this.isReverseStart) {
                    if (StoriesProgressView.this.storiesListener != null) {
                        StoriesListener storiesListener = StoriesProgressView.this.storiesListener;
                        Intrinsics.checkNotNull(storiesListener);
                        storiesListener.onPrev();
                    }
                    if (StoriesProgressView.this.current - 1 < 0) {
                        ((PausableProgressBar) StoriesProgressView.this.progressBars.get(StoriesProgressView.this.current)).startProgress();
                    } else {
                        ((PausableProgressBar) StoriesProgressView.this.progressBars.get(StoriesProgressView.this.current - 1)).setMinWithoutCallback();
                        r2.current--;
                        ((PausableProgressBar) StoriesProgressView.this.progressBars.get(StoriesProgressView.this.current)).startProgress();
                    }
                    StoriesProgressView.this.isReverseStart = false;
                    return;
                }
                int i = StoriesProgressView.this.current + 1;
                if (i <= StoriesProgressView.this.progressBars.size() - 1) {
                    if (StoriesProgressView.this.storiesListener != null) {
                        StoriesListener storiesListener2 = StoriesProgressView.this.storiesListener;
                        Intrinsics.checkNotNull(storiesListener2);
                        storiesListener2.onNext();
                    }
                    ((PausableProgressBar) StoriesProgressView.this.progressBars.get(i)).startProgress();
                } else {
                    StoriesProgressView.this.setComplete(true);
                    if (StoriesProgressView.this.storiesListener != null) {
                        StoriesListener storiesListener3 = StoriesProgressView.this.storiesListener;
                        Intrinsics.checkNotNull(storiesListener3);
                        storiesListener3.onComplete();
                    }
                }
                StoriesProgressView.this.isSkipStart = false;
            }
        };
    }

    public final void startStories(int from) {
        for (int i = 0; i < from; i++) {
            this.progressBars.get(i).setMaxWithoutCallback();
        }
        this.progressBars.get(from).startProgress();
    }

    public final void destroy() {
        Iterator<PausableProgressBar> it = this.progressBars.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public final void pause() {
        int i = this.current;
        if (i < 0) {
            return;
        }
        this.progressBars.get(i).pauseProgress();
    }

    public final void resume() {
        int i = this.current;
        if (i < 0) {
            return;
        }
        this.progressBars.get(i).resumeProgress();
    }
}
