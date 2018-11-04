package nuc.bsd.report;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.AreaBreakType;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.druid.DruidPlugin;

import nuc.bsd.util.JFinalUtil;



public class PdfReportTest {
	
	public static void insertPage() throws IOException {
		String FILE_DIR = "D:\\ky\\";
		
		PdfDocument pdfDoc = new PdfDocument(new PdfReader(FILE_DIR+"wtxw.pdf"), new PdfWriter(FILE_DIR+"out.pdf"));
		
		
		InputStream inputStream = PdfReportTest.class.getResource("/ddyy.ttf").openStream();
		PdfFont font = PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);
		
		PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
		Map<String, PdfFormField> fields = form.getFormFields();
		PdfFormField field;
		field = fields.get("code");
		field.setJustification(PdfFormField.ALIGN_LEFT);
		field.setFont(font);
		field.setValue("1001001");
		field = fields.get("name");
		field.setFont(font);
		field.setValue("张志强");
		
field = fields.get("age");
field.setFont(font);
		field.setValue("27");
field = fields.get("sex");
field.setFont(font);
		field.setValue("男");
field = fields.get("cls");
field.setFont(font);
		field.setValue("六年一班");
field = fields.get("date");
field.setFont(font);
		field.setValue("2017-08-09");
field = fields.get("r1");
field.setFont(font);
		field.setValue("5%");
field = fields.get("r2");
field.setFont(font);
		field.setValue("15%");
field = fields.get("r3");
field.setFont(font);
		field.setValue("25%");
field = fields.get("r4");
field.setFont(font);
		field.setValue("35%");
field = fields.get("r5");
field.setFont(font);
		field.setValue("45%");
		/*field =  fields.get("r6");
		field.setFont(font);
		field.setValue("\t人际问题处于潜在风险状态，有时候不能与别人保持融洽的关系，\r\n较少主动与别人沟通并真诚地对待他人。");
*/		/*field =  fields.get("r6");
		
		field.setImage(FILE_DIR+"my.jpg");*/
		/*PdfPage currentPage = pdfDoc.getPage(5);
		PdfCanvas  canvas = new PdfCanvas(currentPage);

		
		
		canvas.addImage(ImageDataFactory.create(1, 1, 3, 8, new byte[]{(byte) 255, (byte) 0, (byte) 0}, null), new Rectangle(10,100,30,30), false);
 */   /*InputStream imginputStream = new FileInputStream(FILE_DIR+"my.jpg");
		Image image = new Image(ImageDataFactory.create(IOUtils.toByteArray(imginputStream)));
		image.scaleToFit(50, 50);
		image.setFixedPosition(450, 10);*/
		PdfPage currentPage = pdfDoc.getPage(5);
		
		PdfCanvas  canvas = new PdfCanvas(currentPage);
		canvas.addImage(ImageDataFactory.create(FILE_DIR+"p200.png"),100,400,100,true);
		Paragraph paragraph1 = new Paragraph("人际问题处于潜在风险状态,有时候不能与别人保持融洽的关系.较少主动与别人沟通并真诚地对待他人。");
		paragraph1.setFirstLineIndent(20);
		paragraph1.setMargin(60);
		paragraph1.setFont(font);
		/*canvas.beginText();
		canvas.setFontAndSize(font, 14);
		canvas.moveText(100, 100);
		canvas.showText("人际问题处于潜在风险状态，有时候不能与别人保持融洽的关系，较少主动与别人沟通并真诚地对待他人。");
		canvas.endText();*/
		Document doc = new Document(pdfDoc, pdfDoc.getDefaultPageSize().A4);
		doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
		doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
		doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
		doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
		
		doc.add(paragraph1);
		doc.close();
		pdfDoc.close();
	}
	
	public static void main(String[] args) throws IOException {
		//insertPage();
		//new genReport().insertPage();
		//PdfReport rep = new PdfReport();
		/*Map<String,Object> paras = new HashMap<String,Object>();
		List<Object> p1Data = new ArrayList<Object>(Arrays.asList(62,51,63,68,69,59,53,71,51,59,63,41,52,46,62,63,55,49,60,53,64,58));;
		paras.put("p1", p1Data);
		for(int i=20; i<32; i++) {
		paras.put("p"+i, 1+i);
		}*/
		//rep.generateCharts(paras);
		//rep.createProblemBehaviorReport(paras, "pbTest1");
		/*String jsonStr = rep.getChartTemplate("p5.json").toString();
		jsonStr = jsonStr.replaceAll("\"", "'");
		System.out.println(jsonStr);
		EChartsUtil.generateEChartsImage(jsonStr, "d:\\p1.jpg");*/
		//rep.getChartTemplate("p1.json");
		JFinalUtil.init();
 		StringBuffer sb = new StringBuffer();
		sb.append("select b.id as recId,b.content as stem,b.question_code as code,b.option_number as optionNumber from eva_com_code_table a left join question_bank b on a.question_code = b.question_code where a.EC_code = ? and a.part='1'");	
		List<Record> records = Db.find(sb.toString(), "123");
		System.out.println(records.size());
		JFinalUtil.destroy();
		
	}
}
