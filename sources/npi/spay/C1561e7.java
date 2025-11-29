package npi.spay;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import com.facebook.shimmer.ShimmerFrameLayout;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* renamed from: npi.spay.e7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1561e7 implements ImageRequest.Listener {
    public final /* synthetic */ ShimmerFrameLayout a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ Drawable c;

    public C1561e7(ShimmerFrameLayout shimmerFrameLayout, ImageView imageView, Drawable drawable) {
        this.a = shimmerFrameLayout;
        this.b = imageView;
        this.c = drawable;
    }

    @Override // coil.request.ImageRequest.Listener
    public final void onError(ImageRequest request, ErrorResult result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        Timber.INSTANCE.e(result.getThrowable());
        ShimmerFrameLayout shimmerFrameLayout = this.a;
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(8);
        this.b.setImageDrawable(this.c);
        this.b.setVisibility(0);
        super.onError(request, result);
    }

    @Override // coil.request.ImageRequest.Listener
    public final void onStart(ImageRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ShimmerFrameLayout shimmerFrameLayout = this.a;
        shimmerFrameLayout.startShimmer();
        shimmerFrameLayout.setVisibility(0);
        super.onStart(request);
    }

    @Override // coil.request.ImageRequest.Listener
    public final void onSuccess(ImageRequest request, SuccessResult result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        ShimmerFrameLayout shimmerFrameLayout = this.a;
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(8);
        this.b.setVisibility(0);
        super.onSuccess(request, result);
    }
}
