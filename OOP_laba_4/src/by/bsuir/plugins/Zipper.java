package by.bsuir.plugins;

import by.bsuir.Archivator;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper implements Archivator {
    @Override
    public void zip(File dir) throws IOException {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("archive.zip"));
        if (dir.isDirectory()) {
            String name = dir.getName();
            zipDir(dir, out, name);
        } else {
            zipFile(dir, out);
        }
        out.close();
    }

    private void zipFile(File file, ZipOutputStream out) throws IOException {
        out.putNextEntry(new ZipEntry(file.getName()));
        write(new FileInputStream(file), out);
    }


    private void zipDir(File dir, ZipOutputStream out, String name) throws IOException {
        if (dir.listFiles().length == 0) {
            out.putNextEntry(new ZipEntry(name + "/"));
        } else {
            for (int i = 0; i < dir.listFiles().length; i++) {
                if (dir.listFiles()[i].isDirectory()) {
                    zipDir(dir.listFiles()[i], out, name + "/" + dir.listFiles()[i].getName());
                } else {
                    out.putNextEntry(new ZipEntry(name + "/" + dir.listFiles()[i].getName()));
                    write(new FileInputStream(dir.listFiles()[i]), out);
                }
            }
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }
}
