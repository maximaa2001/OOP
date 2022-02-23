package by.bsuir.interfaces;

import java.io.File;
import java.io.IOException;

public interface UserArchivator {
    void createZip(File file) throws IOException;
}
