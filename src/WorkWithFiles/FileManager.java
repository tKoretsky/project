package WorkWithFiles;

import java.io.*;

public class FileManager<T> implements ReadWriteAble<T>{

    @Override
    public void writeFile(String fileName, T list ){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);

            oos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public T readFile(String fileName, T list){
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (T) ois.readObject();
            ois.close();
            return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
