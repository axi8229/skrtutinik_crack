package sputnik.axmor.com.sputnik.ui.main.profile.family.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeButton.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/adapter/MyButton;", "", "", "id", "Landroid/content/Context;", "context", "", "imageResId", RemoteMessageConst.Notification.COLOR, "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ljava/lang/String;Landroid/content/Context;IILkotlin/jvm/functions/Function1;)V", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/Bitmap;", "drawableToBitmap", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;", "", "x", "y", "", "onClick", "(FF)Z", "Landroid/graphics/Canvas;", "c", "Landroid/graphics/RectF;", "rectF", "pos", "onDraw", "(Landroid/graphics/Canvas;Landroid/graphics/RectF;I)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Landroid/content/Context;", "I", "Lkotlin/jvm/functions/Function1;", "clickRegion", "Landroid/graphics/RectF;", "Landroid/content/res/Resources;", "resources", "Landroid/content/res/Resources;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyButton {
    private RectF clickRegion;
    private final int color;
    private final Context context;
    private final String id;
    private final int imageResId;
    private final Function1<Integer, Unit> listener;
    private int pos;
    private final Resources resources;

    /* JADX WARN: Multi-variable type inference failed */
    public MyButton(String id, Context context, int i, int i2, Function1<? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.id = id;
        this.context = context;
        this.imageResId = i;
        this.color = i2;
        this.listener = listener;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        this.resources = resources;
    }

    public final boolean onClick(float x, float y) {
        RectF rectF = this.clickRegion;
        if (rectF == null) {
            return false;
        }
        Intrinsics.checkNotNull(rectF);
        if (!rectF.contains(x, y)) {
            return false;
        }
        this.listener.invoke(Integer.valueOf(this.pos));
        return true;
    }

    public final void onDraw(Canvas c, RectF rectF, int pos) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        Paint paint = new Paint();
        paint.setColor(this.color);
        c.drawRect(rectF, paint);
        paint.setColor(-1);
        float f = 2;
        c.drawBitmap(drawableToBitmap(ContextCompat.getDrawable(this.context, this.imageResId)), ((rectF.left + rectF.right) / f) - (r1.getWidth() / 2), ((rectF.top + rectF.bottom) / f) - (r1.getHeight() / 2), paint);
        this.clickRegion = rectF;
        this.pos = pos;
    }

    private final Bitmap drawableToBitmap(Drawable d) {
        if (d instanceof BitmapDrawable) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) d).getBitmap(), 160, 160, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
            return bitmapCreateScaledBitmap;
        }
        Intrinsics.checkNotNull(d);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        d.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        d.draw(canvas);
        return bitmapCreateBitmap;
    }
}
