package org.bouncycastle.asn1;

/* loaded from: classes4.dex */
public class BERApplicationSpecificParser extends BERTaggedObjectParser implements ASN1Encodable, InMemoryRepresentable {
    BERApplicationSpecificParser(int i, ASN1StreamParser aSN1StreamParser) {
        super(64, i, aSN1StreamParser);
    }
}
