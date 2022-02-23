package by.bsuir.interfaces;

import java.io.File;
import java.io.IOException;

public interface Archivator {
    void zip(File file) throws IOException;
}
