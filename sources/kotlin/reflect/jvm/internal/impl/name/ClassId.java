package kotlin.reflect.jvm.internal.impl.name;

import com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes4.dex */
public final class ClassId {
    private final boolean local;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        /*
            r0 = 9
            r1 = 7
            r2 = 6
            r3 = 5
            if (r10 == r3) goto L13
            if (r10 == r2) goto L13
            if (r10 == r1) goto L13
            if (r10 == r0) goto L13
            switch(r10) {
                case 13: goto L13;
                case 14: goto L13;
                case 15: goto L13;
                case 16: goto L13;
                default: goto L10;
            }
        L10:
            java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L15
        L13:
            java.lang.String r4 = "@NotNull method %s.%s must not return null"
        L15:
            r5 = 2
            if (r10 == r3) goto L23
            if (r10 == r2) goto L23
            if (r10 == r1) goto L23
            if (r10 == r0) goto L23
            switch(r10) {
                case 13: goto L23;
                case 14: goto L23;
                case 15: goto L23;
                case 16: goto L23;
                default: goto L21;
            }
        L21:
            r6 = 3
            goto L24
        L23:
            r6 = r5
        L24:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/name/ClassId"
            r8 = 0
            switch(r10) {
                case 1: goto L4f;
                case 2: goto L4a;
                case 3: goto L4f;
                case 4: goto L44;
                case 5: goto L41;
                case 6: goto L41;
                case 7: goto L41;
                case 8: goto L3c;
                case 9: goto L41;
                case 10: goto L37;
                case 11: goto L32;
                case 12: goto L32;
                case 13: goto L41;
                case 14: goto L41;
                case 15: goto L41;
                case 16: goto L41;
                default: goto L2c;
            }
        L2c:
            java.lang.String r9 = "topLevelFqName"
            r6[r8] = r9
            goto L53
        L32:
            java.lang.String r9 = "string"
            r6[r8] = r9
            goto L53
        L37:
            java.lang.String r9 = "segment"
            r6[r8] = r9
            goto L53
        L3c:
            java.lang.String r9 = "name"
            r6[r8] = r9
            goto L53
        L41:
            r6[r8] = r7
            goto L53
        L44:
            java.lang.String r9 = "topLevelName"
            r6[r8] = r9
            goto L53
        L4a:
            java.lang.String r9 = "relativeClassName"
            r6[r8] = r9
            goto L53
        L4f:
            java.lang.String r9 = "packageFqName"
            r6[r8] = r9
        L53:
            r8 = 1
            if (r10 == r3) goto L7b
            if (r10 == r2) goto L76
            if (r10 == r1) goto L71
            if (r10 == r0) goto L6c
            switch(r10) {
                case 13: goto L67;
                case 14: goto L67;
                case 15: goto L62;
                case 16: goto L62;
                default: goto L5f;
            }
        L5f:
            r6[r8] = r7
            goto L7f
        L62:
            java.lang.String r7 = "asFqNameString"
            r6[r8] = r7
            goto L7f
        L67:
            java.lang.String r7 = "asString"
            r6[r8] = r7
            goto L7f
        L6c:
            java.lang.String r7 = "asSingleFqName"
            r6[r8] = r7
            goto L7f
        L71:
            java.lang.String r7 = "getShortClassName"
            r6[r8] = r7
            goto L7f
        L76:
            java.lang.String r7 = "getRelativeClassName"
            r6[r8] = r7
            goto L7f
        L7b:
            java.lang.String r7 = "getPackageFqName"
            r6[r8] = r7
        L7f:
            switch(r10) {
                case 1: goto L97;
                case 2: goto L97;
                case 3: goto L97;
                case 4: goto L97;
                case 5: goto L9b;
                case 6: goto L9b;
                case 7: goto L9b;
                case 8: goto L92;
                case 9: goto L9b;
                case 10: goto L8d;
                case 11: goto L88;
                case 12: goto L88;
                case 13: goto L9b;
                case 14: goto L9b;
                case 15: goto L9b;
                case 16: goto L9b;
                default: goto L82;
            }
        L82:
            java.lang.String r7 = "topLevel"
            r6[r5] = r7
            goto L9b
        L88:
            java.lang.String r7 = "fromString"
            r6[r5] = r7
            goto L9b
        L8d:
            java.lang.String r7 = "startsWith"
            r6[r5] = r7
            goto L9b
        L92:
            java.lang.String r7 = "createNestedClassId"
            r6[r5] = r7
            goto L9b
        L97:
            java.lang.String r7 = "<init>"
            r6[r5] = r7
        L9b:
            java.lang.String r4 = java.lang.String.format(r4, r6)
            if (r10 == r3) goto Lb0
            if (r10 == r2) goto Lb0
            if (r10 == r1) goto Lb0
            if (r10 == r0) goto Lb0
            switch(r10) {
                case 13: goto Lb0;
                case 14: goto Lb0;
                case 15: goto Lb0;
                case 16: goto Lb0;
                default: goto Laa;
            }
        Laa:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>(r4)
            goto Lb5
        Lb0:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>(r4)
        Lb5:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.name.ClassId.$$$reportNull$$$0(int):void");
    }

    public static ClassId topLevel(FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(0);
        }
        return new ClassId(fqName.parent(), fqName.shortName());
    }

    public ClassId(FqName fqName, FqName fqName2, boolean z) {
        if (fqName == null) {
            $$$reportNull$$$0(1);
        }
        if (fqName2 == null) {
            $$$reportNull$$$0(2);
        }
        this.packageFqName = fqName;
        this.relativeClassName = fqName2;
        this.local = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(FqName fqName, Name name) {
        this(fqName, FqName.topLevel(name), false);
        if (fqName == null) {
            $$$reportNull$$$0(3);
        }
        if (name == null) {
            $$$reportNull$$$0(4);
        }
    }

    public FqName getPackageFqName() {
        FqName fqName = this.packageFqName;
        if (fqName == null) {
            $$$reportNull$$$0(5);
        }
        return fqName;
    }

    public FqName getRelativeClassName() {
        FqName fqName = this.relativeClassName;
        if (fqName == null) {
            $$$reportNull$$$0(6);
        }
        return fqName;
    }

    public Name getShortClassName() {
        Name nameShortName = this.relativeClassName.shortName();
        if (nameShortName == null) {
            $$$reportNull$$$0(7);
        }
        return nameShortName;
    }

    public boolean isLocal() {
        return this.local;
    }

    public ClassId createNestedClassId(Name name) {
        if (name == null) {
            $$$reportNull$$$0(8);
        }
        return new ClassId(getPackageFqName(), this.relativeClassName.child(name), this.local);
    }

    public ClassId getOuterClassId() {
        FqName fqNameParent = this.relativeClassName.parent();
        if (fqNameParent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), fqNameParent, this.local);
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            FqName fqName = this.relativeClassName;
            if (fqName == null) {
                $$$reportNull$$$0(9);
            }
            return fqName;
        }
        return new FqName(this.packageFqName.asString() + "." + this.relativeClassName.asString());
    }

    public static ClassId fromString(String str) {
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        return fromString(str, false);
    }

    public static ClassId fromString(String str, boolean z) {
        String str2;
        if (str == null) {
            $$$reportNull$$$0(12);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf == -1) {
            str2 = "";
        } else {
            String strReplace = str.substring(0, iLastIndexOf).replace(JsonPointer.SEPARATOR, '.');
            str = str.substring(iLastIndexOf + 1);
            str2 = strReplace;
        }
        return new ClassId(new FqName(str2), new FqName(str), z);
    }

    public String asString() {
        if (this.packageFqName.isRoot()) {
            String strAsString = this.relativeClassName.asString();
            if (strAsString == null) {
                $$$reportNull$$$0(13);
            }
            return strAsString;
        }
        String str = this.packageFqName.asString().replace('.', JsonPointer.SEPARATOR) + "/" + this.relativeClassName.asString();
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClassId.class != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        return this.packageFqName.equals(classId.packageFqName) && this.relativeClassName.equals(classId.relativeClassName) && this.local == classId.local;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + Boolean.valueOf(this.local).hashCode();
    }

    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        return "/" + asString();
    }
}
