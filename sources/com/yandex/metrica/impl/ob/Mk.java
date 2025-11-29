package com.yandex.metrica.impl.ob;

import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextClock;
import android.widget.TextView;
import com.yandex.metrica.impl.ob.C1228rl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class Mk implements InterfaceC0857cl {
    private final Set<Class> a;

    public Mk() {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add(EditText.class);
        hashSet.add(Chronometer.class);
        hashSet.add(DigitalClock.class);
        hashSet.add(TextClock.class);
        hashSet.add(RadioButton.class);
        hashSet.add(CheckBox.class);
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public boolean a(TextView textView) {
        TextView textView2 = textView;
        Iterator<Class> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(textView2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public C1228rl.b a() {
        return C1228rl.b.IRRELEVANT_CLASS;
    }
}
