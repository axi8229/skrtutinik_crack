package sputnik.axmor.com.sputnik.ui.main.cameras.history;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.transition.TransitionSet;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.ImageViewerLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.VisitsBody;
import com.sputnik.common.entities.localization.VisitsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentVisitDetailsBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.views.ZoomOnDoubleTapListener;

/* compiled from: CallHistoryDetails.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u001d\u0010(\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001d\u0010+\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006?"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/CallHistoryDetails;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "showErrorVisit", "showNormalVisit", "loadVideo", "loadSnapshot", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentVisitDetailsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentVisitDetailsBinding;", "binding", "", "imageUrl$delegate", "Lkotlin/Lazy;", "getImageUrl", "()Ljava/lang/String;", "imageUrl", "videoUrl$delegate", "getVideoUrl", "videoUrl", "date$delegate", "getDate", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "time$delegate", "getTime", CrashHianalyticsData.TIME, "", "callDeclined$delegate", "getCallDeclined", "()Z", "callDeclined", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallHistoryDetails extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CallHistoryDetails.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentVisitDetailsBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: callDeclined$delegate, reason: from kotlin metadata */
    private final Lazy callDeclined;

    /* renamed from: date$delegate, reason: from kotlin metadata */
    private final Lazy date;

    /* renamed from: imageUrl$delegate, reason: from kotlin metadata */
    private final Lazy imageUrl;
    public LocalizationStorage localizationScreen;

    /* renamed from: time$delegate, reason: from kotlin metadata */
    private final Lazy time;

    /* renamed from: videoUrl$delegate, reason: from kotlin metadata */
    private final Lazy videoUrl;

    public CallHistoryDetails() {
        super(R.layout.fragment_visit_details);
        this.binding = new ViewBindingFragmentDelegate(this, CallHistoryDetails$binding$2.INSTANCE);
        this.imageUrl = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails$imageUrl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("image") : null);
            }
        });
        this.videoUrl = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails$videoUrl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("video_url") : null);
            }
        });
        this.date = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails$date$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE) : null);
            }
        });
        this.time = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails$time$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get(CrashHianalyticsData.TIME) : null);
            }
        });
        this.callDeclined = LazyKt.lazy(new Function0<Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails$callDeclined$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = this.this$0.getArguments();
                Boolean bool = (Boolean) (arguments != null ? arguments.get("call_declined") : null);
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentVisitDetailsBinding getBinding() {
        return (FragmentVisitDetailsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getImageUrl() {
        return (String) this.imageUrl.getValue();
    }

    private final String getVideoUrl() {
        return (String) this.videoUrl.getValue();
    }

    private final String getDate() {
        return (String) this.date.getValue();
    }

    private final String getTime() {
        return (String) this.time.getValue();
    }

    private final boolean getCallDeclined() {
        return ((Boolean) this.callDeclined.getValue()).booleanValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorVisit() {
        VisitsLocale visits;
        VisitsBody body;
        FragmentVisitDetailsBinding binding = getBinding();
        ProgressBar pbVisits = binding.pbVisits;
        Intrinsics.checkNotNullExpressionValue(pbVisits, "pbVisits");
        ViewKt.gone(pbVisits);
        TextView tvError = binding.tvError;
        Intrinsics.checkNotNullExpressionValue(tvError, "tvError");
        ViewKt.visible(tvError);
        TextView textView = binding.tvError;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        textView.setText((data == null || (visits = data.getVisits()) == null || (body = visits.getBody()) == null) ? null : body.getViewError());
        LinearLayout errorLayout = binding.errorLayout;
        Intrinsics.checkNotNullExpressionValue(errorLayout, "errorLayout");
        ViewKt.visible(errorLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNormalVisit() {
        FragmentVisitDetailsBinding binding = getBinding();
        LinearLayout errorLayout = binding.errorLayout;
        Intrinsics.checkNotNullExpressionValue(errorLayout, "errorLayout");
        ViewKt.gone(errorLayout);
        int color = ContextCompat.getColor(requireContext(), R.color.white);
        binding.visitorDetailTime.setTextColor(color);
        binding.visitorDetailDate.setTextColor(color);
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.visible(toolbar);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        super.onCreate(savedInstanceState);
        TransitionSet transitionSetAddTransition = new TransitionSet().addTransition(new ChangeImageTransform()).addTransition(new ChangeBounds());
        Intrinsics.checkNotNullExpressionValue(transitionSetAddTransition, "addTransition(...)");
        Transition transitionInflateTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move);
        if (transitionInflateTransition != null) {
            transitionSetAddTransition.addTransition(transitionInflateTransition);
        }
        setSharedElementEnterTransition(transitionSetAddTransition);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        ImageView ivCallDeclined = getBinding().ivCallDeclined;
        Intrinsics.checkNotNullExpressionValue(ivCallDeclined, "ivCallDeclined");
        ViewBindingUtilsKt.visibilityBasedOn(ivCallDeclined, Boolean.valueOf(getCallDeclined()));
        postponeEnterTransition();
        getBinding().visitorDetailDate.setText(getDate());
        getBinding().visitorDetailTime.setText(getTime());
        Toolbar toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        startPostponedEnterTransition();
        String videoUrl = getVideoUrl();
        if (videoUrl == null || StringsKt.isBlank(videoUrl)) {
            String imageUrl = getImageUrl();
            if (imageUrl == null || StringsKt.isBlank(imageUrl)) {
                showErrorVisit();
                return;
            } else {
                loadSnapshot();
                return;
            }
        }
        loadVideo();
    }

    private final void loadVideo() {
        ZoomLayout layoutZoomVideo = getBinding().layoutZoomVideo;
        Intrinsics.checkNotNullExpressionValue(layoutZoomVideo, "layoutZoomVideo");
        ViewKt.visible(layoutZoomVideo);
        ZoomLayout layoutZoom = getBinding().layoutZoom;
        Intrinsics.checkNotNullExpressionValue(layoutZoom, "layoutZoom");
        ViewKt.gone(layoutZoom);
        VideoView videoView = getBinding().videoView;
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails$$ExternalSyntheticLambda1
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return CallHistoryDetails.loadVideo$lambda$6$lambda$4(this.f$0, mediaPlayer, i, i2);
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return CallHistoryDetails.loadVideo$lambda$6$lambda$5(this.f$0, mediaPlayer, i, i2);
            }
        });
        videoView.setVideoPath(getVideoUrl());
        videoView.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadVideo$lambda$6$lambda$4(CallHistoryDetails this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 3) {
            return true;
        }
        ProgressBar pbVisits = this$0.getBinding().pbVisits;
        Intrinsics.checkNotNullExpressionValue(pbVisits, "pbVisits");
        ViewKt.gone(pbVisits);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadVideo$lambda$6$lambda$5(CallHistoryDetails this$0, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadSnapshot();
        return true;
    }

    private final void loadSnapshot() {
        ZoomLayout layoutZoomVideo = getBinding().layoutZoomVideo;
        Intrinsics.checkNotNullExpressionValue(layoutZoomVideo, "layoutZoomVideo");
        ViewKt.gone(layoutZoomVideo);
        ZoomLayout layoutZoom = getBinding().layoutZoom;
        Intrinsics.checkNotNullExpressionValue(layoutZoom, "layoutZoom");
        ViewKt.visible(layoutZoom);
        Glide.with(this).load(getImageUrl()).dontTransform().dontAnimate().placeholder(R.drawable.ic_plus_special).into((RequestBuilder) new CustomTarget<Drawable>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails.loadSnapshot.1
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, com.bumptech.glide.request.transition.Transition transition) {
                onResourceReady((Drawable) obj, (com.bumptech.glide.request.transition.Transition<? super Drawable>) transition);
            }

            public void onResourceReady(Drawable resource, com.bumptech.glide.request.transition.Transition<? super Drawable> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                CallHistoryDetails.this.getBinding().picture.setImageDrawable(resource);
                ProgressBar pbVisits = CallHistoryDetails.this.getBinding().pbVisits;
                Intrinsics.checkNotNullExpressionValue(pbVisits, "pbVisits");
                ViewKt.gone(pbVisits);
                CallHistoryDetails.this.showNormalVisit();
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                ProgressBar pbVisits = CallHistoryDetails.this.getBinding().pbVisits;
                Intrinsics.checkNotNullExpressionValue(pbVisits, "pbVisits");
                ViewKt.gone(pbVisits);
                CallHistoryDetails.this.showErrorVisit();
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentVisitDetailsBinding binding = getBinding();
        binding.layoutZoom.setMaxScale(30.0f);
        binding.layoutZoomVideo.setMaxScale(30.0f);
        binding.layoutZoom.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.15f));
        binding.layoutZoomVideo.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.15f));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        ImageViewerLocale visitor;
        TextTitle navigation;
        FragmentVisitDetailsBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (visitor = data.getVisitor()) == null || (navigation = visitor.getNavigation()) == null) {
            return;
        }
        binding.toolbar.setTitle(navigation.getTitle());
    }
}
