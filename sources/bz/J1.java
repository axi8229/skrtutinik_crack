package bz;

/* loaded from: classes.dex */
public abstract /* synthetic */ class J1 {
    public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7};

    public static /* synthetic */ boolean a(int i, int i2) {
        if (i != 0) {
            return i == i2;
        }
        throw null;
    }

    public static /* synthetic */ int[] b(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, 0, iArr, 0, i);
        return iArr;
    }

    public static /* synthetic */ int a(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }
}
