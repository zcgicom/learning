package com.itcat.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 修改pdf
 * iText是著名的开放源码的站点sourceforge一个项目，是用于生成PDF文档的一个java类库。
 * 通过iText不仅可以生成PDF或rtf的文档，而且可以将XML、Html文件转化为PDF文件。
 *
 * iTextPdf常用类
 * com.itextpdf.text.Document：这是iText库中最常用的类，它代表了一个pdf实例。如果你需要从零开始生成一个PDF文件，你需要使用这个Document类。
 *                             首先创建（new）该实例，然后打开（open）它，并添加（add）内容，最后关闭（close）该实例，即可生成一个pdf文件;
 * com.itextpdf.text.Paragraph：表示一个缩进的文本段落，在段落中，你可以设置对齐方式，缩进，段落前后间隔等;
 * com.itextpdf.text.Chapter：表示PDF的一个章节，他通过一个Paragraph类型的标题和整形章数创建;
 * com.itextpdf.text.Font：这个类包含了所有规范好的字体，包括family of font，大小，样式和颜色，所有这些字体都被声明为静态常量;
 * com.itextpdf.text.List：表示一个列表；
 * com.itextpdf.text.Anchor：表示一个锚，类似于HTML页面的链接;
 * com.itextpdf.text.pdf.PdfWriter：当这个PdfWriter被添加到PdfDocument后，所有添加到Document的内容将会写入到与文件或网络关联的输出流中;
 * com.itextpdf.text.pdf.PdfReader：用于读取PDF文件.
 */
public class RechangePdf {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) throws IOException, DocumentException {
//        Format();       //文件样式设置
//        Permissions();  //权限设置
//        ImageToPdf();   //图片设置
//        ListPdf();      //添加列表
        TableToPdf();   //添加表格
    }
    /**
     * 为pdf文件添加图片
     * @throws IOException
     * @throws DocumentException
     */
    public static void ImageToPdf() throws IOException, DocumentException {
        //读取pdf文件
        PdfReader pdfReader = new PdfReader("C:/Users/28715/Desktop/ce.pdf");

        //修改器
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("C:/Users/28715/Desktop/ceshi01.pdf"));

        //构建添加的图片
        Image image = Image.getInstance("I:/pictures/secreen/demo3.jpg");
        image.scaleAbsolute(100, 100);
        image.setAbsolutePosition(0, 700);

        //遍历pdf页数。每一页都添加图片
        for(int i=1; i<= pdfReader.getNumberOfPages(); i++){
            PdfContentByte content = pdfStamper.getUnderContent(i);
            content.addImage(image);
        }
        //关闭修改器
        pdfStamper.close();
    }

    /**
     * 为PDF文件设置权限
     * @throws DocumentException
     * @throws IOException
     * 必需bcprov-jdk15on.jar包
     *
     * 权限参数
     * PdfWriter.ALLOW_MODIFY_CONTENTS      --  允许打印,编辑，复制，签名       --  加密级别：40-bit-RC4
     * PdfWriter.ALLOW_COPY                 --  允许复制，签名 不允许打印，编辑 --  加密级别：40-bit-RC4
     * PdfWriter.ALLOW_MODIFY_ANNOTATIONS   --  允许打印,编辑，复制，签名       --  加密级别：40-bit-RC4
     * PdfWriter.ALLOW_FILL_IN              --  允许打印,编辑，复制，签名       --  加密级别：40-bit-RC4
     * PdfWriter.ALLOW_SCREENREADERS        --  允许打印,编辑，复制，签名       --  加密级别：40-bit-RC4
     * PdfWriter.ALLOW_ASSEMBLY             --  允许打印,编辑，复制，签名       --  加密级别：40-bit-RC4
     * PdfWriter.EMBEDDED_FILES_ONLY        --  允许打印,编辑，复制，签名       --  加密级别：40-bit-RC4
     * PdfWriter.DO_NOT_ENCRYPT_METADATA    --  允许打印,编辑，复制，签名       --  加密级别：40-bit-RC4
     * PdfWriter.ENCRYPTION_AES_256         --  允许打印,编辑，复制，签名       --  加密级别：256-bit-AES
     * PdfWriter.ENCRYPTION_AES_128         --  允许打印,编辑，复制，签名       --  加密级别：128-bit-AES
     * PdfWriter.STANDARD_ENCRYPTION_128    --  允许打印,编辑，复制，签名       --  加密级别：128-bit-RC4
     * PdfWriter.STANDARD_ENCRYPTION_40     --  允许打印,编辑，复制，签名       --  加密级别：40-bit-RC4
     */
    public static void Permissions() throws DocumentException, IOException {
        // 创建文件，默认A4页面（设置PageSize.A4.rotate()属性为横向显示，否则默认为纵向）
        Document document = new Document();
        // 建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/28715/Desktop/ceshi01.pdf"));
        // 设置用户密码，所有者密码，用户权限，所有者权限
        String userpassword = "userpassword";   //用户密码
        String ownerpassword = "ownerpassword"; //所有者密码
        writer.setEncryption(userpassword.getBytes(), ownerpassword.getBytes(), PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
        // 打开文件
        document.open();
        //创建第一页（若只有一页，则可省略）
//        document.newPage();

        // 添加内容
        document.add(new Paragraph("first demo"));
        // 关闭文档
        document.close();
        // 关闭书写器
        writer.close();
    }

    /**
     * PDF中设置样式/格式化输出，输出中文内容
     * @throws DocumentException
     * @throws IOException
     * 必需itext-asian.jar包
     */
    public static void Format() throws DocumentException, IOException {
        //创建文件
        Document document = new Document();
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/28715/Desktop/ceshi01.pdf"));
        //打开文件
        document.open();

        //添加内容
        document.add(new Paragraph("Some content here"));

        //设置文档属性
        //标题
        document.addTitle("this is a title");
        //作者
        document.addAuthor("itcat");
        //主题
        document.addSubject("this is subject");
        //关键字
        document.addKeywords("Keywords");
        //创建时间
        document.addCreationDate();
        //应用程序
        document.addCreator("hd.com");

        //中文字体,解决中文不能显示问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);

        //蓝色字体
        Font blueFont = new Font(bfChinese);
        blueFont.setColor(BaseColor.BLUE);
        //段落文本
        Paragraph paragraphBlue = new Paragraph("paragraphOne blue front", blueFont);
        document.add(paragraphBlue);

        //绿色字体
        Font greenFont = new Font(bfChinese);
        greenFont.setColor(BaseColor.GREEN);
        //创建章节
        Paragraph chapterTitle = new Paragraph("段落标题xxxx", greenFont);
        Chapter chapter1 = new Chapter(chapterTitle, 1);
        chapter1.setNumberDepth(0);

        Paragraph sectionTitle = new Paragraph("部分标题", greenFont);
        Section section1 = chapter1.addSection(sectionTitle);

        Paragraph sectionContent = new Paragraph("部分内容", blueFont);
        section1.add(sectionContent);

        //将章节添加到文章中
        document.add(chapter1);

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }

    /**
     * 创建列表
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    public static void ListToPdf() throws DocumentException, FileNotFoundException {
        //创建文件
        Document document = new Document();
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/28715/Desktop/ceshi01.pdf"));
        //打开文件
        document.open();
        //添加内容
        document.add(new Paragraph("HD content here"));

        //添加有序列表
        List orderedList = new List(List.ORDERED);
        orderedList.add(new ListItem("Item one"));
        orderedList.add(new ListItem("Item two"));
        orderedList.add(new ListItem("Item three"));
        document.add(orderedList);

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }

    /**
     * 创建表格
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    public static void TableToPdf() throws DocumentException, FileNotFoundException {
        //创建文件
        Document document = new Document();
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/28715/Desktop/ceshi01.pdf"));
        //打开文件
        document.open();
        //添加内容
        document.add(new Paragraph("HD content here"));

        // 3列的表.
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100); // 宽度100%填充
        table.setSpacingBefore(10f);   // 前间距
        table.setSpacingAfter(10f);    // 后间距

        java.util.List<PdfPRow> listRow = table.getRows();
        //设置列宽
        float[] columnWidths = { 1f, 2f, 3f };
        table.setWidths(columnWidths);

        //行1
        PdfPCell cells1[]= new PdfPCell[3];
        PdfPRow row1 = new PdfPRow(cells1);

        //单元格
        cells1[0] = new PdfPCell(new Paragraph("111"));//单元格内容
        cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
        cells1[0].setPaddingLeft(20);//左填充20
        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[1] = new PdfPCell(new Paragraph("222"));
        cells1[2] = new PdfPCell(new Paragraph("333"));

        //行2
        PdfPCell cells2[]= new PdfPCell[3];
        PdfPRow row2 = new PdfPRow(cells2);
        cells2[0] = new PdfPCell(new Paragraph("444"));

        //把第一行添加到集合
        listRow.add(row1);
        listRow.add(row2);
        //把表格添加到文件中
        document.add(table);

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }
}
