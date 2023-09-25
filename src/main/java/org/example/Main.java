package org.example;

import com.adobe.internal.xmp.impl.XMPNodeMixIn;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        File f = new File("C:\\Users\\Sebastian\\Desktop\\Bilder_Uhrzeit");
        ObjectMapper om = new ObjectMapper();
        om.addMixIn(Directory.class, DirectoryMixIn.class);
        XMPNodeMixIn.addMixin(om);

        AtomicInteger i = new AtomicInteger(0);

        Arrays.stream(f.listFiles())
                .filter(File::isFile)
                .forEach(file -> {
                    try {
                        Metadata md = ImageMetadataReader.readMetadata(file);
                        om.writeValue(new File("exifExport " + file.getName().replace("JPG", "json")), md);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                });
        System.out.println();
    }
}