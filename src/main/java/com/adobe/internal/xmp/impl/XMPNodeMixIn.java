package com.adobe.internal.xmp.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

abstract public class XMPNodeMixIn {
    public static void addMixin(ObjectMapper om) {
        om.addMixIn(XMPNode.class, XMPNodeMixIn.class);
    }

    @JsonIgnore
    abstract XMPNode getParent();
}
