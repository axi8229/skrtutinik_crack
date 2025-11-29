package ru.roadar.facerecog;

import android.os.Handler;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import ru.roadar.facerecog.FaceProcessNative;
import ru.roadar.facerecog.Yuv;

/* compiled from: FaceAnalyzer.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R*\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR?\u0010#\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 0\u001fj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 `\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lru/roadar/facerecog/FaceAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "Lru/roadar/facerecog/FaceProcessNative;", "faceProcess", "Lkotlin/Function2;", "", "Lru/roadar/facerecog/FaceProcessNative$ProcessState;", "", "Lru/roadar/facerecog/FaceListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/os/Handler;", "handler", "<init>", "(Lru/roadar/facerecog/FaceProcessNative;Lkotlin/jvm/functions/Function2;Landroid/os/Handler;)V", "Landroidx/camera/core/ImageProxy;", "image", "analyze", "(Landroidx/camera/core/ImageProxy;)V", "stop", "()V", "Lru/roadar/facerecog/FaceProcessNative;", "Lkotlin/jvm/functions/Function2;", "Landroid/os/Handler;", "", "TAG", "Ljava/lang/String;", "stopped", "Z", "Ljava/nio/ByteBuffer;", "buffer", "Ljava/nio/ByteBuffer;", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "list", "Ljava/util/ArrayList;", "getList", "()Ljava/util/ArrayList;", "facerecog_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FaceAnalyzer implements ImageAnalysis.Analyzer {
    private final String TAG;
    private ByteBuffer buffer;
    private final FaceProcessNative faceProcess;
    private final Handler handler;
    private final ArrayList<Pair<Long, Long>> list;
    private final Function2<Boolean, FaceProcessNative.ProcessState, Unit> listener;
    private boolean stopped;

    /* compiled from: FaceAnalyzer.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Yuv.Type.values().length];
            try {
                iArr[Yuv.Type.YUV_420.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Yuv.Type.YUV_NV21.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FaceAnalyzer(FaceProcessNative faceProcess, Function2<? super Boolean, ? super FaceProcessNative.ProcessState, Unit> listener, Handler handler) {
        Intrinsics.checkNotNullParameter(faceProcess, "faceProcess");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.faceProcess = faceProcess;
        this.listener = listener;
        this.handler = handler;
        this.TAG = "FaceAnalyzer";
        this.list = new ArrayList<>();
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(ImageProxy image) {
        int i;
        Intrinsics.checkNotNullParameter(image, "image");
        if (this.stopped || this.faceProcess.isReleased()) {
            return;
        }
        Yuv.Converted buffer = Yuv.toBuffer(image, this.buffer);
        Yuv.Type type = buffer.type;
        int i2 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i2 == 1) {
            i = 100;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 92;
        }
        Mat mat = new Mat(image.getHeight() + (image.getHeight() / 2), image.getWidth(), CvType.CV_8UC1, buffer.buffer);
        Mat mat2 = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
        Imgproc.cvtColor(mat, mat2, i);
        final boolean zProcessFrame = this.faceProcess.processFrame(mat2, image.getImageInfo().getRotationDegrees());
        final FaceProcessNative.ProcessState state = this.faceProcess.getState();
        this.handler.post(new Runnable() { // from class: ru.roadar.facerecog.FaceAnalyzer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FaceAnalyzer.analyze$lambda$0(this.f$0, zProcessFrame, state);
            }
        });
        image.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$0(FaceAnalyzer this$0, boolean z, FaceProcessNative.ProcessState processState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<Boolean, FaceProcessNative.ProcessState, Unit> function2 = this$0.listener;
        Boolean boolValueOf = Boolean.valueOf(z);
        Intrinsics.checkNotNull(processState);
        function2.invoke(boolValueOf, processState);
    }

    public final void stop() {
        this.stopped = true;
    }
}
