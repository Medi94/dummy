package org.example;

import com.drew.metadata.Directory;
import com.fasterxml.jackson.annotation.JsonIgnore;

abstract public class DirectoryMixIn {
    @JsonIgnore
    abstract Directory getParent();
}
