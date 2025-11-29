package com.sputnik.common.entities.instructions;

import com.sputnik.common.entities.views.BaseView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Instruction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/instructions/Instruction;", "", "", "id", "", "Lcom/sputnik/common/entities/views/BaseView;", "views", "toolbarTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Ljava/util/List;", "getViews", "()Ljava/util/List;", "getToolbarTitle", "setToolbarTitle", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Instruction {
    private final String id;
    private String toolbarTitle;
    private final List<BaseView> views;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Instruction)) {
            return false;
        }
        Instruction instruction = (Instruction) other;
        return Intrinsics.areEqual(this.id, instruction.id) && Intrinsics.areEqual(this.views, instruction.views) && Intrinsics.areEqual(this.toolbarTitle, instruction.toolbarTitle);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.views.hashCode()) * 31) + this.toolbarTitle.hashCode();
    }

    public String toString() {
        return "Instruction(id=" + this.id + ", views=" + this.views + ", toolbarTitle=" + this.toolbarTitle + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Instruction(String id, List<? extends BaseView> views, String toolbarTitle) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(views, "views");
        Intrinsics.checkNotNullParameter(toolbarTitle, "toolbarTitle");
        this.id = id;
        this.views = views;
        this.toolbarTitle = toolbarTitle;
    }

    public final String getId() {
        return this.id;
    }

    public final List<BaseView> getViews() {
        return this.views;
    }

    public final String getToolbarTitle() {
        return this.toolbarTitle;
    }

    public final void setToolbarTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toolbarTitle = str;
    }
}
