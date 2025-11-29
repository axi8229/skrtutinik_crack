package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class ASN1ApplicationSpecific extends ASN1Primitive implements ASN1Encodable, InMemoryRepresentable {
    final ASN1TaggedObject taggedObject;

    ASN1ApplicationSpecific(ASN1TaggedObject aSN1TaggedObject) {
        checkTagClass(aSN1TaggedObject.getTagClass());
        this.taggedObject = aSN1TaggedObject;
    }

    private static int checkTagClass(int i) {
        if (64 == i) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        ASN1TaggedObject aSN1TaggedObject;
        if (aSN1Primitive instanceof ASN1ApplicationSpecific) {
            aSN1TaggedObject = ((ASN1ApplicationSpecific) aSN1Primitive).taggedObject;
        } else {
            if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
                return false;
            }
            aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
        }
        return this.taggedObject.equals((ASN1Primitive) aSN1TaggedObject);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        this.taggedObject.encode(aSN1OutputStream, z);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return this.taggedObject.encodeConstructed();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean z) throws IOException {
        return this.taggedObject.encodedLength(z);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final ASN1Primitive getLoadedObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.taggedObject.hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERApplicationSpecific((ASN1TaggedObject) this.taggedObject.toDERObject());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLApplicationSpecific((ASN1TaggedObject) this.taggedObject.toDLObject());
    }
}
