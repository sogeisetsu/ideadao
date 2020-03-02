package afterxml;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;
class Bbb {

}
public class XPathDemo {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = XPathDemo.class.getResource("../xmlstudy/nn.xml").getPath();
        System.out.println(path);
        Document document = Jsoup.parse(new File(path), "utf-8");
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodeList=jxDocument.selN("//students");
        jxNodeList.forEach(System.out::println);
        System.out.println(">-------------------------");
        jxNodeList=jxDocument.selN("//students/student[@number='s001']");
        jxNodeList.forEach(System.out::println);
    }

}
