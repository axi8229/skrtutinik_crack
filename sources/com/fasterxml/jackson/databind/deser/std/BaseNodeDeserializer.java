package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: JsonNodeDeserializer.java */
/* loaded from: classes2.dex */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    protected final Boolean _supportsUpdates;

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return true;
    }

    public BaseNodeDeserializer(Class<T> cls, Boolean bool) {
        super((Class<?>) cls);
        this._supportsUpdates = bool;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._supportsUpdates;
    }

    protected void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws IOException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            deserializationContext.reportInputMismatch(JsonNode.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str);
        }
        if (deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)) {
            if (jsonNode.isArray()) {
                ((ArrayNode) jsonNode).add(jsonNode2);
                objectNode.replace(str, jsonNode);
            } else {
                ArrayNode arrayNode = jsonNodeFactory.arrayNode();
                arrayNode.add(jsonNode);
                arrayNode.add(jsonNode2);
                objectNode.replace(str, arrayNode);
            }
        }
    }

    protected final ObjectNode _deserializeObjectAtName(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, ContainerStack containerStack) throws IOException {
        JsonNode jsonNode_deserializeContainerNoRecursion;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        String strCurrentName = jsonParser.currentName();
        while (strCurrentName != null) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            if (jsonTokenNextToken == null) {
                jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
            }
            int iId = jsonTokenNextToken.id();
            if (iId == 1) {
                jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, jsonNodeFactory, containerStack, jsonNodeFactory.objectNode());
            } else if (iId == 3) {
                jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, jsonNodeFactory, containerStack, jsonNodeFactory.arrayNode());
            } else {
                jsonNode_deserializeContainerNoRecursion = _deserializeAnyScalar(jsonParser, deserializationContext);
            }
            JsonNode jsonNode = jsonNode_deserializeContainerNoRecursion;
            JsonNode jsonNodeReplace = objectNode.replace(strCurrentName, jsonNode);
            if (jsonNodeReplace != null) {
                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strCurrentName, objectNode, jsonNodeReplace, jsonNode);
            }
            strCurrentName = jsonParser.nextFieldName();
        }
        return objectNode;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.fasterxml.jackson.databind.JsonNode updateObject(com.fasterxml.jackson.core.JsonParser r9, com.fasterxml.jackson.databind.DeserializationContext r10, com.fasterxml.jackson.databind.node.ObjectNode r11, com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer.ContainerStack r12) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r9.isExpectedStartObjectToken()
            if (r0 == 0) goto Lb
            java.lang.String r0 = r9.nextFieldName()
            goto L1e
        Lb:
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            boolean r0 = r9.hasToken(r0)
            if (r0 != 0) goto L1a
            java.lang.Object r9 = r8.deserialize(r9, r10)
            com.fasterxml.jackson.databind.JsonNode r9 = (com.fasterxml.jackson.databind.JsonNode) r9
            return r9
        L1a:
            java.lang.String r0 = r9.currentName()
        L1e:
            com.fasterxml.jackson.databind.node.JsonNodeFactory r7 = r10.getNodeFactory()
        L22:
            if (r0 == 0) goto Lb7
            com.fasterxml.jackson.core.JsonToken r1 = r9.nextToken()
            com.fasterxml.jackson.databind.JsonNode r2 = r11.get(r0)
            if (r2 == 0) goto L59
            boolean r3 = r2 instanceof com.fasterxml.jackson.databind.node.ObjectNode
            if (r3 == 0) goto L44
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            if (r1 != r3) goto L59
            r1 = r2
            com.fasterxml.jackson.databind.node.ObjectNode r1 = (com.fasterxml.jackson.databind.node.ObjectNode) r1
            com.fasterxml.jackson.databind.JsonNode r1 = r8.updateObject(r9, r10, r1, r12)
            if (r1 == r2) goto Lb1
            r11.set(r0, r1)
            goto Lb1
        L44:
            boolean r3 = r2 instanceof com.fasterxml.jackson.databind.node.ArrayNode
            if (r3 == 0) goto L59
            com.fasterxml.jackson.core.JsonToken r3 = com.fasterxml.jackson.core.JsonToken.START_ARRAY
            if (r1 != r3) goto L59
            r6 = r2
            com.fasterxml.jackson.databind.node.ArrayNode r6 = (com.fasterxml.jackson.databind.node.ArrayNode) r6
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r7
            r5 = r12
            r1._deserializeContainerNoRecursion(r2, r3, r4, r5, r6)
            goto Lb1
        L59:
            if (r1 != 0) goto L5d
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.NOT_AVAILABLE
        L5d:
            int r1 = r1.id()
            r2 = 1
            if (r1 == r2) goto La1
            r3 = 3
            if (r1 == r3) goto L93
            r3 = 6
            if (r1 == r3) goto L8a
            r3 = 7
            if (r1 == r3) goto L85
            switch(r1) {
                case 9: goto L80;
                case 10: goto L7a;
                case 11: goto L75;
                default: goto L70;
            }
        L70:
            com.fasterxml.jackson.databind.JsonNode r1 = r8._deserializeRareScalar(r9, r10)
            goto Lae
        L75:
            com.fasterxml.jackson.databind.node.NullNode r1 = r7.nullNode()
            goto Lae
        L7a:
            r1 = 0
            com.fasterxml.jackson.databind.node.BooleanNode r1 = r7.booleanNode(r1)
            goto Lae
        L80:
            com.fasterxml.jackson.databind.node.BooleanNode r1 = r7.booleanNode(r2)
            goto Lae
        L85:
            com.fasterxml.jackson.databind.JsonNode r1 = r8._fromInt(r9, r10, r7)
            goto Lae
        L8a:
            java.lang.String r1 = r9.getText()
            com.fasterxml.jackson.databind.node.TextNode r1 = r7.textNode(r1)
            goto Lae
        L93:
            com.fasterxml.jackson.databind.node.ArrayNode r6 = r7.arrayNode()
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r7
            r5 = r12
            com.fasterxml.jackson.databind.node.ContainerNode r1 = r1._deserializeContainerNoRecursion(r2, r3, r4, r5, r6)
            goto Lae
        La1:
            com.fasterxml.jackson.databind.node.ObjectNode r6 = r7.objectNode()
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r7
            r5 = r12
            com.fasterxml.jackson.databind.node.ContainerNode r1 = r1._deserializeContainerNoRecursion(r2, r3, r4, r5, r6)
        Lae:
            r11.set(r0, r1)
        Lb1:
            java.lang.String r0 = r9.nextFieldName()
            goto L22
        Lb7:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer.updateObject(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.node.ObjectNode, com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer$ContainerStack):com.fasterxml.jackson.databind.JsonNode");
    }

    protected final ContainerNode<?> _deserializeContainerNoRecursion(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, ContainerStack containerStack, ContainerNode<?> containerNode) throws IOException {
        ObjectNode objectNode;
        JsonNode jsonNodeTextNode;
        ObjectNode objectNode2;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures() & StdDeserializer.F_MASK_INT_COERCIONS;
        ContainerNode<?> containerNodeObjectNode = containerNode;
        do {
            boolean z = true;
            if (containerNodeObjectNode instanceof ObjectNode) {
                ContainerNode<?> containerNode2 = containerNodeObjectNode;
                ObjectNode objectNode3 = (ObjectNode) containerNodeObjectNode;
                String strNextFieldName = jsonParser.nextFieldName();
                while (strNextFieldName != null) {
                    JsonToken jsonTokenNextToken = jsonParser.nextToken();
                    if (jsonTokenNextToken == null) {
                        jsonTokenNextToken = JsonToken.NOT_AVAILABLE;
                    }
                    int iId = jsonTokenNextToken.id();
                    if (iId == z) {
                        ObjectNode objectNode4 = objectNode3;
                        ObjectNode objectNode5 = jsonNodeFactory.objectNode();
                        JsonNode jsonNodeReplace = objectNode4.replace(strNextFieldName, objectNode5);
                        if (jsonNodeReplace != null) {
                            objectNode = objectNode5;
                            _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strNextFieldName, objectNode4, jsonNodeReplace, objectNode5);
                        } else {
                            objectNode = objectNode5;
                        }
                        containerStack.push(containerNode2);
                        objectNode3 = objectNode;
                        containerNode2 = objectNode3;
                    } else if (iId == 3) {
                        ObjectNode objectNode6 = objectNode3;
                        ArrayNode arrayNode = jsonNodeFactory.arrayNode();
                        JsonNode jsonNodeReplace2 = objectNode6.replace(strNextFieldName, arrayNode);
                        if (jsonNodeReplace2 != null) {
                            _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strNextFieldName, objectNode6, jsonNodeReplace2, arrayNode);
                        }
                        containerStack.push(containerNode2);
                        containerNodeObjectNode = arrayNode;
                    } else {
                        switch (iId) {
                            case 6:
                                jsonNodeTextNode = jsonNodeFactory.textNode(jsonParser.getText());
                                break;
                            case 7:
                                jsonNodeTextNode = _fromInt(jsonParser, deserializationFeatures, jsonNodeFactory);
                                break;
                            case 8:
                                jsonNodeTextNode = _fromFloat(jsonParser, deserializationContext, jsonNodeFactory);
                                break;
                            case 9:
                                jsonNodeTextNode = jsonNodeFactory.booleanNode(z);
                                break;
                            case 10:
                                jsonNodeTextNode = jsonNodeFactory.booleanNode(false);
                                break;
                            case 11:
                                jsonNodeTextNode = jsonNodeFactory.nullNode();
                                break;
                            default:
                                jsonNodeTextNode = _deserializeRareScalar(jsonParser, deserializationContext);
                                break;
                        }
                        JsonNode jsonNode = jsonNodeTextNode;
                        JsonNode jsonNodeReplace3 = objectNode3.replace(strNextFieldName, jsonNode);
                        if (jsonNodeReplace3 != null) {
                            objectNode2 = objectNode3;
                            _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strNextFieldName, objectNode3, jsonNodeReplace3, jsonNode);
                        } else {
                            objectNode2 = objectNode3;
                        }
                        objectNode3 = objectNode2;
                    }
                    strNextFieldName = jsonParser.nextFieldName();
                    z = true;
                }
                containerNodeObjectNode = containerStack.popOrNull();
            } else {
                ArrayNode arrayNode2 = (ArrayNode) containerNodeObjectNode;
                while (true) {
                    JsonToken jsonTokenNextToken2 = jsonParser.nextToken();
                    if (jsonTokenNextToken2 == null) {
                        jsonTokenNextToken2 = JsonToken.NOT_AVAILABLE;
                    }
                    switch (jsonTokenNextToken2.id()) {
                        case 1:
                            containerStack.push(containerNodeObjectNode);
                            containerNodeObjectNode = jsonNodeFactory.objectNode();
                            arrayNode2.add(containerNodeObjectNode);
                            break;
                        case 2:
                        case 5:
                        default:
                            arrayNode2.add(_deserializeRareScalar(jsonParser, deserializationContext));
                        case 3:
                            containerStack.push(containerNodeObjectNode);
                            containerNodeObjectNode = jsonNodeFactory.arrayNode();
                            arrayNode2.add(containerNodeObjectNode);
                            break;
                        case 4:
                            break;
                        case 6:
                            arrayNode2.add(jsonNodeFactory.textNode(jsonParser.getText()));
                        case 7:
                            arrayNode2.add(_fromInt(jsonParser, deserializationFeatures, jsonNodeFactory));
                        case 8:
                            arrayNode2.add(_fromFloat(jsonParser, deserializationContext, jsonNodeFactory));
                        case 9:
                            arrayNode2.add(jsonNodeFactory.booleanNode(true));
                        case 10:
                            arrayNode2.add(jsonNodeFactory.booleanNode(false));
                        case 11:
                            arrayNode2.add(jsonNodeFactory.nullNode());
                    }
                }
            }
        } while (containerNodeObjectNode != null);
        return containerNode;
    }

    protected final JsonNode _deserializeAnyScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        int iCurrentTokenId = jsonParser.currentTokenId();
        if (iCurrentTokenId == 2) {
            return nodeFactory.objectNode();
        }
        switch (iCurrentTokenId) {
            case 6:
                return nodeFactory.textNode(jsonParser.getText());
            case 7:
                return _fromInt(jsonParser, deserializationContext, nodeFactory);
            case 8:
                return _fromFloat(jsonParser, deserializationContext, nodeFactory);
            case 9:
                return nodeFactory.booleanNode(true);
            case 10:
                return nodeFactory.booleanNode(false);
            case 11:
                return nodeFactory.nullNode();
            case 12:
                return _fromEmbedded(jsonParser, deserializationContext);
            default:
                return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
    }

    protected final JsonNode _deserializeRareScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int iCurrentTokenId = jsonParser.currentTokenId();
        if (iCurrentTokenId == 2) {
            return deserializationContext.getNodeFactory().objectNode();
        }
        if (iCurrentTokenId == 8) {
            return _fromFloat(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
        }
        if (iCurrentTokenId == 12) {
            return _fromEmbedded(jsonParser, deserializationContext);
        }
        return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
    }

    protected final JsonNode _fromInt(JsonParser jsonParser, int i, JsonNodeFactory jsonNodeFactory) throws IOException {
        if (i != 0) {
            if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(i)) {
                return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
            }
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
        JsonParser.NumberType numberType = jsonParser.getNumberType();
        if (numberType == JsonParser.NumberType.INT) {
            return jsonNodeFactory.numberNode(jsonParser.getIntValue());
        }
        if (numberType == JsonParser.NumberType.LONG) {
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
        return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
    }

    protected final JsonNode _fromInt(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberType;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        if ((StdDeserializer.F_MASK_INT_COERCIONS & deserializationFeatures) != 0) {
            if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures)) {
                numberType = JsonParser.NumberType.BIG_INTEGER;
            } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures)) {
                numberType = JsonParser.NumberType.LONG;
            } else {
                numberType = jsonParser.getNumberType();
            }
        } else {
            numberType = jsonParser.getNumberType();
        }
        if (numberType == JsonParser.NumberType.INT) {
            return jsonNodeFactory.numberNode(jsonParser.getIntValue());
        }
        if (numberType == JsonParser.NumberType.LONG) {
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
        return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
    }

    protected final JsonNode _fromFloat(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberType = jsonParser.getNumberType();
        if (numberType == JsonParser.NumberType.BIG_DECIMAL) {
            return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
        }
        if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            if (jsonParser.isNaN()) {
                return jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
            }
            return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
        }
        if (numberType == JsonParser.NumberType.FLOAT) {
            return jsonNodeFactory.numberNode(jsonParser.getFloatValue());
        }
        return jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
    }

    protected final JsonNode _fromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        Object embeddedObject = jsonParser.getEmbeddedObject();
        if (embeddedObject == null) {
            return nodeFactory.nullNode();
        }
        if (embeddedObject.getClass() == byte[].class) {
            return nodeFactory.binaryNode((byte[]) embeddedObject);
        }
        if (embeddedObject instanceof RawValue) {
            return nodeFactory.rawValueNode((RawValue) embeddedObject);
        }
        if (embeddedObject instanceof JsonNode) {
            return (JsonNode) embeddedObject;
        }
        return nodeFactory.pojoNode(embeddedObject);
    }

    /* compiled from: JsonNodeDeserializer.java */
    static final class ContainerStack {
        private int _end;
        private ContainerNode[] _stack;
        private int _top;

        public int size() {
            return this._top;
        }

        public void push(ContainerNode containerNode) {
            int i = this._top;
            int i2 = this._end;
            if (i < i2) {
                ContainerNode[] containerNodeArr = this._stack;
                this._top = i + 1;
                containerNodeArr[i] = containerNode;
                return;
            }
            if (this._stack == null) {
                this._end = 10;
                this._stack = new ContainerNode[10];
            } else {
                int iMin = i2 + Math.min(4000, Math.max(20, i2 >> 1));
                this._end = iMin;
                this._stack = (ContainerNode[]) Arrays.copyOf(this._stack, iMin);
            }
            ContainerNode[] containerNodeArr2 = this._stack;
            int i3 = this._top;
            this._top = i3 + 1;
            containerNodeArr2[i3] = containerNode;
        }

        public ContainerNode popOrNull() {
            int i = this._top;
            if (i == 0) {
                return null;
            }
            ContainerNode[] containerNodeArr = this._stack;
            int i2 = i - 1;
            this._top = i2;
            return containerNodeArr[i2];
        }
    }
}
