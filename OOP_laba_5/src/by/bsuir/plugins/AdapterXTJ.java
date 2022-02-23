package by.bsuir.plugins;

import by.bsuir.XTJ;
import by.bsuir.interfaces.UserXTJ;

import java.io.File;
import java.io.IOException;

public class AdapterXTJ extends XTJ implements UserXTJ {
    private static AdapterXTJ instance;

    private AdapterXTJ(){}

    public static AdapterXTJ getInstance(){
        if(instance == null){
            instance = new AdapterXTJ();
        }
        return instance;
    }

    @Override
    public void transformXmlToJson(File file) throws IOException {
        xtj(file);
    }
}
