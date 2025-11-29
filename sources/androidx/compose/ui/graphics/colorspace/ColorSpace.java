package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorSpace.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000 >2\u00020\u0001:\u0001>B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\rJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0016J'\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ=\u0010)\u001a\u00020&2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0000H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J'\u0010*\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0007¢\u0006\u0004\b*\u0010\u0014J\u0019\u0010*\u001a\u00020\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0012H'¢\u0006\u0004\b*\u0010\u0016J\u000f\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010,R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0005\u00105\u001a\u0004\b6\u00107R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u00108\u001a\u0004\b9\u00102R\u0011\u0010;\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b:\u00102R\u0014\u0010<\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "model", "", "id", "<init>", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "component", "", "getMinValue", "(I)F", "getMaxValue", "r", "g", "b", "", "toXyz", "(FFF)[F", "v", "([F)[F", "v0", "v1", "v2", "", "toXy$ui_graphics_release", "(FFF)J", "toXy", "toZ$ui_graphics_release", "(FFF)F", "toZ", "x", "y", "z", "a", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "xyzaToColor", "fromXyz", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getName", "J", "getModel-xdoWZVw", "()J", "I", "getId$ui_graphics_release", "getComponentCount", "componentCount", "isSrgb", "()Z", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ColorSpace {
    private final int id;
    private final long model;
    private final String name;

    public /* synthetic */ ColorSpace(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, i);
    }

    public abstract float[] fromXyz(float[] v);

    public abstract float getMaxValue(int component);

    public abstract float getMinValue(int component);

    public boolean isSrgb() {
        return false;
    }

    public abstract float[] toXyz(float[] v);

    private ColorSpace(String str, long j, int i) {
        this.name = str;
        this.model = j;
        this.id = i;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i < -1 || i > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public final String getName() {
        return this.name;
    }

    /* renamed from: getModel-xdoWZVw, reason: not valid java name and from getter */
    public final long getModel() {
        return this.model;
    }

    /* renamed from: getId$ui_graphics_release, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final int getComponentCount() {
        return ColorModel.m1113getComponentCountimpl(this.model);
    }

    public final float[] toXyz(float r, float g, float b) {
        return toXyz(new float[]{r, g, b});
    }

    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        float[] xyz = toXyz(v0, v1, v2);
        float f = xyz[0];
        float f2 = xyz[1];
        return (Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L);
    }

    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        return toXyz(v0, v1, v2)[2];
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release, reason: not valid java name */
    public long mo1120xyzaToColorJlNiLsg$ui_graphics_release(float x, float y, float z, float a, ColorSpace colorSpace) {
        float[] fArrFromXyz = fromXyz(x, y, z);
        return ColorKt.Color(fArrFromXyz[0], fArrFromXyz[1], fArrFromXyz[2], a, colorSpace);
    }

    public final float[] fromXyz(float x, float y, float z) {
        float[] fArr = new float[ColorModel.m1113getComponentCountimpl(this.model)];
        fArr[0] = x;
        fArr[1] = y;
        fArr[2] = z;
        return fromXyz(fArr);
    }

    public String toString() {
        return this.name + " (id=" + this.id + ", model=" + ((Object) ColorModel.m1115toStringimpl(this.model)) + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) other;
        if (this.id == colorSpace.id && Intrinsics.areEqual(this.name, colorSpace.name)) {
            return ColorModel.m1112equalsimpl0(this.model, colorSpace.model);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + ColorModel.m1114hashCodeimpl(this.model)) * 31) + this.id;
    }
}
