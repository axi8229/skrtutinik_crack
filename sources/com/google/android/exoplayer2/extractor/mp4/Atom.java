package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
abstract class Atom {
    public final int type;

    public static int parseFullAtomFlags(int fullAtomInt) {
        return fullAtomInt & 16777215;
    }

    public static int parseFullAtomVersion(int fullAtomInt) {
        return (fullAtomInt >> 24) & KotlinVersion.MAX_COMPONENT_VALUE;
    }

    public Atom(int type) {
        this.type = type;
    }

    public String toString() {
        return getAtomTypeString(this.type);
    }

    static final class LeafAtom extends Atom {
        public final ParsableByteArray data;

        public LeafAtom(int type, ParsableByteArray data) {
            super(type);
            this.data = data;
        }
    }

    static final class ContainerAtom extends Atom {
        public final List<ContainerAtom> containerChildren;
        public final long endPosition;
        public final List<LeafAtom> leafChildren;

        public ContainerAtom(int type, long endPosition) {
            super(type);
            this.endPosition = endPosition;
            this.leafChildren = new ArrayList();
            this.containerChildren = new ArrayList();
        }

        public void add(LeafAtom atom) {
            this.leafChildren.add(atom);
        }

        public void add(ContainerAtom atom) {
            this.containerChildren.add(atom);
        }

        public LeafAtom getLeafAtomOfType(int type) {
            int size = this.leafChildren.size();
            for (int i = 0; i < size; i++) {
                LeafAtom leafAtom = this.leafChildren.get(i);
                if (leafAtom.type == type) {
                    return leafAtom;
                }
            }
            return null;
        }

        public ContainerAtom getContainerAtomOfType(int type) {
            int size = this.containerChildren.size();
            for (int i = 0; i < size; i++) {
                ContainerAtom containerAtom = this.containerChildren.get(i);
                if (containerAtom.type == type) {
                    return containerAtom;
                }
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.Atom
        public String toString() {
            return Atom.getAtomTypeString(this.type) + " leaves: " + Arrays.toString(this.leafChildren.toArray()) + " containers: " + Arrays.toString(this.containerChildren.toArray());
        }
    }

    public static String getAtomTypeString(int type) {
        return "" + ((char) ((type >> 24) & KotlinVersion.MAX_COMPONENT_VALUE)) + ((char) ((type >> 16) & KotlinVersion.MAX_COMPONENT_VALUE)) + ((char) ((type >> 8) & KotlinVersion.MAX_COMPONENT_VALUE)) + ((char) (type & KotlinVersion.MAX_COMPONENT_VALUE));
    }
}
