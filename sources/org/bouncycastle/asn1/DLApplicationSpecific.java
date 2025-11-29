package org.bouncycastle.asn1;

/* loaded from: classes4.dex */
public class DLApplicationSpecific extends ASN1ApplicationSpecific {
    DLApplicationSpecific(ASN1TaggedObject aSN1TaggedObject) {
        super(aSN1TaggedObject);
    }

    @Override // org.bouncycastle.asn1.ASN1ApplicationSpecific, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
