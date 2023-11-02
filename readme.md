



## transferTo方法复制文件

### 概述

以前IO流复制文件：

```java
package mao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Project name(项目名称)：JDK10_transferTo_copy_file
 * Package(包名): mao
 * Class(类名): Test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/2
 * Time(创建时间)： 15:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test1
{
    public static void main(String[] args) throws IOException
    {
        // 字符流复制文本文件
        FileReader fis = new FileReader("./a.txt");
        FileWriter fos = new FileWriter("./b.txt");
        char[] chs = new char[1024 * 8];
        int len;
        while ((len = fis.read(chs)) != -1)
        {
            fos.write(chs, 0, len);
        }
        fis.close();
        fos.close();

    }
}
```



JDK10 给 InputStream 和 Reader 类中新增了 transferTo 方法， transferTo 方法的作用是将输入流读取的数据使用字符输出流写出。可用于复制文件等操作

```java
/**
 * Reads all characters from this reader and writes the characters to the
 * given writer in the order that they are read. On return, this reader
 * will be at end of the stream. This method does not close either reader
 * or writer.
 * <p>
 * This method may block indefinitely reading from the reader, or
 * writing to the writer. The behavior for the case where the reader
 * and/or writer is <i>asynchronously closed</i>, or the thread
 * interrupted during the transfer, is highly reader and writer
 * specific, and therefore not specified.
 * <p>
 * If an I/O error occurs reading from the reader or writing to the
 * writer, then it may do so after some characters have been read or
 * written. Consequently the reader may not be at end of the stream and
 * one, or both, streams may be in an inconsistent state. It is strongly
 * recommended that both streams be promptly closed if an I/O error occurs.
 *
 * @param  out the writer, non-null
 * @return the number of characters transferred
 * @throws IOException if an I/O error occurs when reading or writing
 * @throws NullPointerException if {@code out} is {@code null}
 *
 * @since 10
 */
public long transferTo(Writer out) throws IOException {
    Objects.requireNonNull(out, "out");
    long transferred = 0;
    char[] buffer = new char[TRANSFER_BUFFER_SIZE];
    int nRead;
    while ((nRead = read(buffer, 0, TRANSFER_BUFFER_SIZE)) >= 0) {
        out.write(buffer, 0, nRead);
        transferred += nRead;
    }
    return transferred;
}
```





### 使用

```java
package mao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Project name(项目名称)：JDK10_transferTo_copy_file
 * Package(包名): mao
 * Class(类名): Test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/2
 * Time(创建时间)： 15:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test2
{
    public static void main(String[] args) throws IOException
    {
        FileReader fis = new FileReader("./a.txt");
        FileWriter fos = new FileWriter("./c.txt");
        fis.transferTo(fos);
        fis.close();
        fos.close();
    }
}
```



