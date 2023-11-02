package mao;

import java.io.*;

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
