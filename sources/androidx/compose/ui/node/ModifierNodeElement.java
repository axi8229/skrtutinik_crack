package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;

/* compiled from: ModifierNodeElement.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/Modifier$Node;", "N", "Landroidx/compose/ui/Modifier$Element;", "", "<init>", "()V", "create", "()Landroidx/compose/ui/Modifier$Node;", "node", "", "update", "(Landroidx/compose/ui/Modifier$Node;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ModifierNodeElement<N extends Modifier.Node> implements Modifier.Element {
    public abstract N create();

    public abstract void update(N node);
}
