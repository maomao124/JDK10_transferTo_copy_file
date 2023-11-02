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
