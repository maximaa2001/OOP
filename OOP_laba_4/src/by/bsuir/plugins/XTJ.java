package by.bsuir.plugins;

import by.bsuir.XmlToJson;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class XTJ implements XmlToJson {
    @Override
    public void xtj(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        Reader reader = new InputStreamReader(in);
        JSONObject obj = XML.toJSONObject(reader);
        FileOutputStream out = new FileOutputStream(new File("XmlTOJson.json"));
        Writer writer = new OutputStreamWriter(out);
       // System.out.println(obj.toString());
        obj.write(writer);
        writer.flush();
        in.close();
        out.close();
    }
}
