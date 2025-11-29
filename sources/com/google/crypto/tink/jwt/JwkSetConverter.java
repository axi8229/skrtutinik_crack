package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaPublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Optional;

/* loaded from: classes2.dex */
public final class JwkSetConverter {
    private static final String JWT_ECDSA_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    private static final String JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    private static final String JWT_RSA_SSA_PSS_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";

    public static String fromPublicKeysetHandle(KeysetHandle handle) throws GeneralSecurityException, IOException {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < handle.size(); i++) {
            KeysetHandle.Entry at = handle.getAt(i);
            if (at.getStatus() == KeyStatus.ENABLED) {
                Key key = at.getKey();
                if (!(key instanceof LegacyProtoKey)) {
                    throw new GeneralSecurityException("only LegacyProtoKey is currently supported");
                }
                ProtoKeySerialization serialization = ((LegacyProtoKey) key).getSerialization(null);
                if (serialization.getOutputPrefixType() != OutputPrefixType.RAW && serialization.getOutputPrefixType() != OutputPrefixType.TINK) {
                    throw new GeneralSecurityException("only OutputPrefixType RAW and TINK are supported");
                }
                if (serialization.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    throw new GeneralSecurityException("only public keys can be converted");
                }
                String typeUrl = serialization.getTypeUrl();
                typeUrl.hashCode();
                switch (typeUrl) {
                    case "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey":
                        jsonArray.add(convertJwtEcdsaKey(serialization));
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey":
                        jsonArray.add(convertJwtRsaSsaPkcs1(serialization));
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey":
                        jsonArray.add(convertJwtRsaSsaPss(serialization));
                        break;
                    default:
                        throw new GeneralSecurityException(String.format("key type %s is not supported", serialization.getTypeUrl()));
                }
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keys", jsonArray);
        return jsonObject.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0072 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.crypto.tink.KeysetHandle toPublicKeysetHandle(java.lang.String r8) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r0 = 2
            r1 = 0
            com.google.gson.stream.JsonReader r2 = new com.google.gson.stream.JsonReader     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            java.io.StringReader r3 = new java.io.StringReader     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            r3.<init>(r8)     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            r2.<init>(r3)     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            r2.setLenient(r1)     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            com.google.gson.JsonElement r8 = com.google.gson.internal.Streams.parse(r2)     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            com.google.gson.JsonObject r8 = r8.getAsJsonObject()     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            com.google.crypto.tink.KeysetHandle$Builder r2 = com.google.crypto.tink.KeysetHandle.newBuilder()
            java.lang.String r3 = "keys"
            com.google.gson.JsonElement r8 = r8.get(r3)
            com.google.gson.JsonArray r8 = r8.getAsJsonArray()
            java.util.Iterator r8 = r8.iterator()
        L29:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Lae
            java.lang.Object r3 = r8.next()
            com.google.gson.JsonElement r3 = (com.google.gson.JsonElement) r3
            com.google.gson.JsonObject r3 = r3.getAsJsonObject()
            java.lang.String r4 = "alg"
            java.lang.String r5 = getStringItem(r3, r4)
            java.lang.String r5 = r5.substring(r1, r0)
            r5.hashCode()
            r6 = -1
            int r7 = r5.hashCode()
            switch(r7) {
                case 2222: goto L65;
                case 2563: goto L5a;
                case 2625: goto L4f;
                default: goto L4e;
            }
        L4e:
            goto L6f
        L4f:
            java.lang.String r7 = "RS"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L58
            goto L6f
        L58:
            r6 = r0
            goto L6f
        L5a:
            java.lang.String r7 = "PS"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L63
            goto L6f
        L63:
            r6 = 1
            goto L6f
        L65:
            java.lang.String r7 = "ES"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L6e
            goto L6f
        L6e:
            r6 = r1
        L6f:
            switch(r6) {
                case 0: goto L97;
                case 1: goto L92;
                case 2: goto L8d;
                default: goto L72;
            }
        L72:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unexpected alg value: "
            r0.append(r1)
            java.lang.String r1 = getStringItem(r3, r4)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L8d:
            com.google.crypto.tink.internal.ProtoKeySerialization r3 = convertToRsaSsaPkcs1Key(r3)
            goto L9b
        L92:
            com.google.crypto.tink.internal.ProtoKeySerialization r3 = convertToRsaSsaPssKey(r3)
            goto L9b
        L97:
            com.google.crypto.tink.internal.ProtoKeySerialization r3 = convertToEcdsaKey(r3)
        L9b:
            com.google.crypto.tink.internal.LegacyProtoKey r4 = new com.google.crypto.tink.internal.LegacyProtoKey
            r5 = 0
            r4.<init>(r3, r5)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r3 = com.google.crypto.tink.KeysetHandle.importKey(r4)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r3 = r3.withRandomId()
            r2.addEntry(r3)
            goto L29
        Lae:
            int r8 = r2.size()
            if (r8 <= 0) goto Lc0
            com.google.crypto.tink.KeysetHandle$Builder$Entry r8 = r2.getAt(r1)
            r8.makePrimary()
            com.google.crypto.tink.KeysetHandle r8 = r2.build()
            return r8
        Lc0:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.String r0 = "empty keyset"
            r8.<init>(r0)
            throw r8
        Lc8:
            r8 = move-exception
            goto Lcd
        Lca:
            r8 = move-exception
            goto Lcd
        Lcc:
            r8 = move-exception
        Lcd:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r1 = "JWK set is invalid JSON"
            r0.<init>(r1, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwkSetConverter.toPublicKeysetHandle(java.lang.String):com.google.crypto.tink.KeysetHandle");
    }

    private static Optional<String> getKid(Integer idRequirement) {
        if (idRequirement == null) {
            return Optional.empty();
        }
        return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(idRequirement.intValue()).array()));
    }

    private static JsonObject convertJwtEcdsaKey(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        String str2;
        try {
            JwtEcdsaPublicKey from = JwtEcdsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "ES256";
                str2 = "P-256";
            } else if (i == 2) {
                str = "ES384";
                str2 = "P-384";
            } else if (i == 3) {
                str = "ES512";
                str2 = "P-521";
            } else {
                throw new GeneralSecurityException("unknown algorithm");
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "EC");
            jsonObject.addProperty("crv", str2);
            jsonObject.addProperty("x", Base64.urlSafeEncode(from.getX().toByteArray()));
            jsonObject.addProperty("y", Base64.urlSafeEncode(from.getY().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jsonObject.addProperty("kid", kid.get());
            } else if (from.hasCustomKid()) {
                jsonObject.addProperty("kid", from.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtEcdsaPublicKey proto", e);
        }
    }

    private static JsonObject convertJwtRsaSsaPkcs1(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPkcs1PublicKey from = JwtRsaSsaPkcs1PublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "RS256";
            } else if (i == 2) {
                str = "RS384";
            } else if (i == 3) {
                str = "RS512";
            } else {
                throw new GeneralSecurityException("unknown algorithm");
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "RSA");
            jsonObject.addProperty("n", Base64.urlSafeEncode(from.getN().toByteArray()));
            jsonObject.addProperty("e", Base64.urlSafeEncode(from.getE().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jsonObject.addProperty("kid", kid.get());
            } else if (from.hasCustomKid()) {
                jsonObject.addProperty("kid", from.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPkcs1PublicKey proto", e);
        }
    }

    private static JsonObject convertJwtRsaSsaPss(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPssPublicKey from = JwtRsaSsaPssPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "PS256";
            } else if (i == 2) {
                str = "PS384";
            } else if (i == 3) {
                str = "PS512";
            } else {
                throw new GeneralSecurityException("unknown algorithm");
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "RSA");
            jsonObject.addProperty("n", Base64.urlSafeEncode(from.getN().toByteArray()));
            jsonObject.addProperty("e", Base64.urlSafeEncode(from.getE().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jsonObject.addProperty("kid", kid.get());
            } else if (from.hasCustomKid()) {
                jsonObject.addProperty("kid", from.getCustomKid().getValue());
            }
            return jsonObject;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPssPublicKey proto", e);
        }
    }

    /* renamed from: com.google.crypto.tink.jwt.JwkSetConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm;

        static {
            int[] iArr = new int[JwtRsaSsaPssAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm = iArr;
            try {
                iArr[JwtRsaSsaPssAlgorithm.PS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[JwtRsaSsaPkcs1Algorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm = iArr2;
            try {
                iArr2[JwtRsaSsaPkcs1Algorithm.RS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr3;
            try {
                iArr3[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private static String getStringItem(JsonObject obj, String name) throws GeneralSecurityException {
        if (!obj.has(name)) {
            throw new GeneralSecurityException(name + " not found");
        }
        if (!obj.get(name).isJsonPrimitive() || !obj.get(name).getAsJsonPrimitive().isString()) {
            throw new GeneralSecurityException(name + " is not a string");
        }
        return obj.get(name).getAsString();
    }

    private static void expectStringItem(JsonObject obj, String name, String expectedValue) throws GeneralSecurityException {
        String stringItem = getStringItem(obj, name);
        if (stringItem.equals(expectedValue)) {
            return;
        }
        throw new GeneralSecurityException("unexpected " + name + " value: " + stringItem);
    }

    private static void validateUseIsSig(JsonObject jsonKey) throws GeneralSecurityException {
        if (jsonKey.has("use")) {
            expectStringItem(jsonKey, "use", "sig");
        }
    }

    private static void validateKeyOpsIsVerify(JsonObject jsonKey) throws GeneralSecurityException {
        if (jsonKey.has("key_ops")) {
            if (!jsonKey.get("key_ops").isJsonArray()) {
                throw new GeneralSecurityException("key_ops is not an array");
            }
            JsonArray asJsonArray = jsonKey.get("key_ops").getAsJsonArray();
            if (asJsonArray.size() != 1) {
                throw new GeneralSecurityException("key_ops must contain exactly one element");
            }
            if (!asJsonArray.get(0).isJsonPrimitive() || !asJsonArray.get(0).getAsJsonPrimitive().isString()) {
                throw new GeneralSecurityException("key_ops is not a string");
            }
            if (asJsonArray.get(0).getAsString().equals("verify")) {
                return;
            }
            throw new GeneralSecurityException("unexpected keyOps value: " + asJsonArray.get(0).getAsString());
        }
    }

    private static ProtoKeySerialization convertToRsaSsaPkcs1Key(JsonObject jsonKey) throws GeneralSecurityException {
        JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "RS256":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS256;
                break;
            case "RS384":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS384;
                break;
            case "RS512":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("p") || jsonKey.has("q") || jsonKey.has("dp") || jsonKey.has("dq") || jsonKey.has("d") || jsonKey.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "RSA");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        JwtRsaSsaPkcs1PublicKey.Builder n = JwtRsaSsaPkcs1PublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPkcs1Algorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "n"))));
        if (jsonKey.has("kid")) {
            n.setCustomKid(JwtRsaSsaPkcs1PublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonKey, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL, n.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToRsaSsaPssKey(JsonObject jsonKey) throws GeneralSecurityException {
        JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "PS256":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS256;
                break;
            case "PS384":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS384;
                break;
            case "PS512":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("p") || jsonKey.has("q") || jsonKey.has("dq") || jsonKey.has("dq") || jsonKey.has("d") || jsonKey.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "RSA");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        JwtRsaSsaPssPublicKey.Builder n = JwtRsaSsaPssPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPssAlgorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "n"))));
        if (jsonKey.has("kid")) {
            n.setCustomKid(JwtRsaSsaPssPublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonKey, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PSS_PUBLIC_KEY_URL, n.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToEcdsaKey(JsonObject jsonKey) throws GeneralSecurityException {
        JwtEcdsaAlgorithm jwtEcdsaAlgorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "ES256":
                expectStringItem(jsonKey, "crv", "P-256");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES256;
                break;
            case "ES384":
                expectStringItem(jsonKey, "crv", "P-384");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES384;
                break;
            case "ES512":
                expectStringItem(jsonKey, "crv", "P-521");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("d")) {
            throw new UnsupportedOperationException("importing ECDSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "EC");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        JwtEcdsaPublicKey.Builder y = JwtEcdsaPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtEcdsaAlgorithm).setX(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "x")))).setY(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonKey, "y"))));
        if (jsonKey.has("kid")) {
            y.setCustomKid(JwtEcdsaPublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonKey, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_ECDSA_PUBLIC_KEY_URL, y.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle handle, KeyAccess keyAccess) throws GeneralSecurityException, IOException {
        return fromPublicKeysetHandle(handle);
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String jwkSet, KeyAccess keyAccess) throws GeneralSecurityException, IOException {
        return toPublicKeysetHandle(jwkSet);
    }

    private JwkSetConverter() {
    }
}
