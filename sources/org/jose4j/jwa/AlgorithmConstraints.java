package org.jose4j.jwa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jose4j.lang.InvalidAlgorithmException;

/* loaded from: classes4.dex */
public class AlgorithmConstraints {
    public static final AlgorithmConstraints ALLOW_ONLY_NONE;
    public static final AlgorithmConstraints DISALLOW_NONE;
    public static final AlgorithmConstraints NO_CONSTRAINTS;
    private final Set<String> algorithms;
    private final ConstraintType type;

    public enum ConstraintType {
        WHITELIST,
        BLACKLIST,
        PERMIT,
        BLOCK
    }

    static {
        ConstraintType constraintType = ConstraintType.BLOCK;
        NO_CONSTRAINTS = new AlgorithmConstraints(constraintType, new String[0]);
        DISALLOW_NONE = new AlgorithmConstraints(constraintType, "none");
        ALLOW_ONLY_NONE = new AlgorithmConstraints(ConstraintType.PERMIT, "none");
    }

    public AlgorithmConstraints(ConstraintType constraintType, String... strArr) {
        if (constraintType == null) {
            throw new NullPointerException("ConstraintType cannot be null");
        }
        this.type = constraintType;
        this.algorithms = new HashSet(Arrays.asList(strArr));
    }

    /* renamed from: org.jose4j.jwa.AlgorithmConstraints$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jose4j$jwa$AlgorithmConstraints$ConstraintType;

        static {
            int[] iArr = new int[ConstraintType.values().length];
            $SwitchMap$org$jose4j$jwa$AlgorithmConstraints$ConstraintType = iArr;
            try {
                iArr[ConstraintType.PERMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jose4j$jwa$AlgorithmConstraints$ConstraintType[ConstraintType.WHITELIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jose4j$jwa$AlgorithmConstraints$ConstraintType[ConstraintType.BLOCK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jose4j$jwa$AlgorithmConstraints$ConstraintType[ConstraintType.BLACKLIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void checkConstraint(String str) throws InvalidAlgorithmException {
        int i = AnonymousClass1.$SwitchMap$org$jose4j$jwa$AlgorithmConstraints$ConstraintType[this.type.ordinal()];
        if (i == 1 || i == 2) {
            if (this.algorithms.contains(str)) {
                return;
            }
            throw new InvalidAlgorithmException("'" + str + "' is not a permitted algorithm.");
        }
        if ((i == 3 || i == 4) && this.algorithms.contains(str)) {
            throw new InvalidAlgorithmException("'" + str + "' is a blocked algorithm.");
        }
    }
}
