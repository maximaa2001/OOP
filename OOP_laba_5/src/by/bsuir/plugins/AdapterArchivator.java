package by.bsuir.plugins;

import by.bsuir.Zipper;
import by.bsuir.interfaces.UserArchivator;

import java.io.File;
import java.io.IOException;

public class AdapterArchivator extends Zipper implements UserArchivator {

    private static AdapterArchivator instance;

    private AdapterArchivator(){}

    public static AdapterArchivator getInstance(){
        if(instance == null){
            instance = new AdapterArchivator();
        }
        return instance;
    }
    @Override
    public void createZip(File file) throws IOException {
        zip(file);
    }
}
