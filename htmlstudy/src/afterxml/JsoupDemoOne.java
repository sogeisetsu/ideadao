package afterxml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemoOne {
    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();
        //找到xml文件路径
        String path = JsoupDemoOne.class.getResource("../xmlstudy/nn.xml").getPath();
        System.out.println(path);
        //导入文件，获取Document对象
        Document document= Jsoup.parse(new File(path),"utf-8");
        //获取Elements对象
        Elements elements = document.getElementsByTag("name");
        Element idOneElements = document.getElementById("s001");
        System.out.println(idOneElements);

        //获取Elements的长度
        System.out.println(elements.size());
        //获取Element
        System.out.println(elements.get(0));
        //Elements 的本质是ArrayList(Element)
        System.out.println("<--------------------");
        elements.forEach(System.out::println);
        System.out.println(">--------------------");
        Element elementOfNmae = elements.get(1);
        //获取Element内容
        System.out.println(elementOfNmae.text());
        Document dDocument = Jsoup.parse(new java.net.URL("https://www.bilibili.com/video/av83154194?p=673"),5000);
        Element eElement = dDocument.body();
        Elements ss=dDocument.getElementsByAttribute("type");
        System.out.println("<------------------------");
        System.out.println("bilibili里面有type属性的element的个数："+ss.size());
        ss.forEach(System.out::println);
        System.out.println("bilibil里面属性为type，属性值为application/ld+json 的个数和数量"+"\n"+
                "个数:");
        System.out.print(dDocument.getElementsByAttributeValue("type", "application/ld+json").size()+"\n");
        System.out.println("\n"+"内容"+(dDocument.getElementsByAttributeValue("type", "application/ld+json").get(0).toString()));
        System.out.println(">-------------------------");
        System.out.println(ss.get(0).attr("type"));
        System.out.println(eElement.getClass().getName());
//        System.out.println(eElement);
        //
        System.out.println("");
        System.out.println("");
        System.out.println("快速查询");
        System.out.println(eElement.select("a").get(15));
        System.out.println(eElement.select("a.href").size());
//        System.out.println(dDocument.html());
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
