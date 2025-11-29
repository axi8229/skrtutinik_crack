package bz;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.core.util.Pair;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class W1 implements InterfaceC0531l1 {
    public final DisplayManager a;

    public W1(Context context) {
        this.a = (DisplayManager) context.getSystemService("display");
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList(1);
        DisplayManager displayManager = this.a;
        if (displayManager != null) {
            for (Display display : displayManager.getDisplays()) {
                int displayId = display.getDisplayId();
                if (displayId != 0 && displayId != -1) {
                    arrayList.add(new Pair(Integer.valueOf(displayId), display.getName()));
                }
            }
        }
        return arrayList;
    }

    public final boolean b() {
        DisplayManager displayManager = this.a;
        return displayManager != null && displayManager.getDisplays().length > 1;
    }
}
