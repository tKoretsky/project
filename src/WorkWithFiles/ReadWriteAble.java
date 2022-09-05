package WorkWithFiles;

public interface ReadWriteAble<T> {
    public void writeFile(String fileName, T list );
    public T readFile(String fileName, T list);
}
