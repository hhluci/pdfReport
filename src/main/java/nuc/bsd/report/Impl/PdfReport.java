package nuc.bsd.report.Impl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.forms.fields.PdfTextFormField;
import com.itextpdf.layout.element.Table;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
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
import com.itextpdf.layout.property.TextAlignment;


import nuc.bsd.report.IReport;
import nuc.bsd.report.domain.ClsProBlmRep;
import nuc.bsd.report.domain.ClsPsyRep;
import nuc.bsd.report.domain.ProblemBehavRep;
import nuc.bsd.report.domain.PsyQualityRep;
import nuc.bsd.util.EChartsUtil;

public class PdfReport implements IReport{

	private  String problemBehaviorReportTemplate = "pb_template.pdf";
	private  String psyQualityReportTemplate = "psy_template.pdf";
	private String problemBehaviorReport = "pbReport.pdf";
	private String psyQualityReport = "psyReport.pdf";
	private  String clsProblemBehaviorReportTemplate = "cls_pb_template.pdf";
	private  String clsPsyQualityReportTemplate = "cls_psy_template.pdf";
	private String clsProblemBehaviorReport = "cls_pbReport.pdf";
	private String clsPsyQualityReport = "cls_psyReport.pdf";
	private String pdfFontFile = "/DENG.ttf";
	private String ROOT_PATH = "c:\\out\\";
	private String OUT_DIR = null;
	private static final Logger logger = LoggerFactory.getLogger(PdfReport.class);
	
	public String createProblemBehaviorReport(ProblemBehavRep obj,String outDir) {
		
		    OUT_DIR = ROOT_PATH + outDir +"\\";
		   File file = new File(OUT_DIR);
		    if(!file.exists()) {
		    	file.mkdir();
		    }else {
		    	file.delete();
		    	file.mkdir();
		    }
			try {
				logger.debug("正在准备所需的图表");
				generatePbCharts(obj);
				logger.debug("图表准备完毕");
				PdfDocument pdfDoc = new PdfDocument(new PdfReader(ROOT_PATH+problemBehaviorReportTemplate), new PdfWriter(OUT_DIR+problemBehaviorReport));
				InputStream inputStream = PdfReport.class.getResource(pdfFontFile).openStream();
				PdfFont pdfFont = PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);//PdfFontFactory.createFont("Arial", "UniGB-UCS2-H",true);//PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);
				//填充form
				logger.debug("开始填充模板表单");
				PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
				Map<String, PdfFormField> fields = form.getFormFields();
			//	Set<String> keys = fields.keySet();
				PdfFormField field;
				for(int i=0; i<59; i++) {
					logger.debug("正在填充第"+i+"表单域");
					field = fields.get("r"+i);
					PdfTextFormField txtField = (PdfTextFormField)field;
				
					
				
					/*txtField.setMaxLen(20);*/
					txtField.setFont(pdfFont);
					
					Method method = obj.getClass().getMethod("getR"+i);
					if(i==16 || i==18 || i==53 || i == 56 || i==58 || i==55) {
						continue;
					}
					String value = (String) method.invoke(obj);
					if(i==20 || i==22 || i==24 || i==26 || i==28 || i==30 || i==32 || i==34 || i==36 || i==38 || i==40 || i==42 || i==44
							|| i==46 || i==48 || i==50 || i==52) {
						txtField.setJustification(PdfFormField.ALIGN_LEFT);
						txtField.setMultiline(true);
						StringBuilder sb = new StringBuilder();
						sb.append(value);
						for(int j=22; j<sb.length();j+=24){
							
							sb.insert(j, "\n\n");
							
							}
						value = sb.toString();
					}else {
						txtField.setMultiline(false);
					}
					if(value=="存在风险") {
						txtField.setBackgroundColor(Color.RED);
						txtField.setColor(Color.WHITE);
					}else if(value=="潜在风险") {
						txtField.setBackgroundColor(new DeviceRgb(255, 69, 0));
						txtField.setColor(Color.WHITE);
					}else{
						txtField.setBackgroundColor(Color.WHITE);
						txtField.setColor(Color.BLACK);
					}
					txtField.setValue(value!=null?value:"");
				}
				
				logger.debug("结束填充模板表单");
				
				//依次处理每一页的报告
				
				logger.debug("正在插入图表");
				PdfPage currentPage = pdfDoc.getPage(5);
				PdfCanvas  canvas = new PdfCanvas(currentPage);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p1.png"),80,500,450,true);
				
				currentPage = pdfDoc.getPage(14);
			    canvas = new PdfCanvas(currentPage);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p20.png"),80,330,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p21.png"),200,330,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p22.png"),80,220,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p23.png"),200,220,100,true);
				
				//
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p24.png"),320,330,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p25.png"),440,330,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p26.png"),320,220,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p27.png"),440,220,100,true);
				
				currentPage = pdfDoc.getPage(16);
			    canvas = new PdfCanvas(currentPage);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p28.png"),180,650,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p29.png"),300,650,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p30.png"),180,540,100,true);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p31.png"),300,540,100,true);
				Document doc = new Document(pdfDoc, pdfDoc.getDefaultPageSize().A4);
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); 
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
				//process the fifth page
				List<String> paragraphs = obj.getR18();
				boolean isFlag = true;
				for(String paragraph : paragraphs) {
					Paragraph p = new Paragraph();
					p.setFirstLineIndent(20);
					p.setPaddingLeft(55);
					p.setPaddingRight(55);
					p.setMultipliedLeading(2);
					//p.setMultipliedLeading(1.5);
				   p.add(paragraph);
					p.setFont(pdfFont);
					if(isFlag) {
						p.setMarginTop(410);
						isFlag = false;
					}
					doc.add(p);
				}
			
				
				//process the ninth page
				for(int i=0; i<10; i++) {
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
				}
				paragraphs = obj.getR55();
				isFlag = true;
				for(String paragraph : paragraphs) {
					Paragraph p = new Paragraph();
					p.setTextAlignment(TextAlignment.JUSTIFIED);
					p.setFirstLineIndent(20);
					p.setPaddingLeft(55);
					p.setPaddingRight(55);
					//p.setMultipliedLeading(2);
				   p.add(paragraph);
					p.setFont(pdfFont);
					if(isFlag) {
						p.setMarginTop(70);
						isFlag = false;
					}
					doc.add(p);
				}
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
				paragraphs = obj.getR58();
				isFlag = true;
				for(String paragraph : paragraphs) {
					Paragraph p = new Paragraph();
					p.setTextAlignment(TextAlignment.JUSTIFIED);
					p.setFirstLineIndent(20);
					p.setPaddingLeft(55);
					p.setPaddingRight(55);
					p.setMultipliedLeading(2);
				   p.add(paragraph);
					p.setFont(pdfFont);
					if(isFlag) {
						p.setMarginTop(380);
						isFlag = false;
					}
					doc.add(p);
				}
				doc.close();
				pdfDoc.close();
				
			} catch (FileNotFoundException e) {
				logger.error("未发现模板或字体文件"+e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("模板或字体文件读写错误"+e.getMessage());
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				logger.error("调用的方法不存在"+e.getMessage());
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				logger.error("调用的方法异常"+e.getMessage());
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				logger.error("非法访问"+e.getMessage());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				logger.error("不合法参数"+e.getMessage());
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				logger.error("调用异常"+e.getMessage());
			}
		

		return OUT_DIR+"/"+problemBehaviorReport;
	}

	public void generatePbCharts(ProblemBehavRep obj) throws IOException {
		/*JSONObject jsonObject;
		String jsonString;
		boolean isSuccess;*/
		JSONObject jsonObject = getChartTemplate("p1.json");
		List<Integer> p1Data = obj.getR16();
		String jsonString = parseP1Report(jsonObject,p1Data);
		boolean isSuccess = EChartsUtil.generateEChartsImage(jsonString, OUT_DIR+"p1.png");
		if(isSuccess) {
			logger.info("p1生成成功");
		}else {
			logger.info("p1生成失败");
		}
		List<Float> paras1 = obj.getR53();
		List<Float> paras2 = obj.getR56();
		for(int i=20; i<32; i++) {
			/*if(i!=21) continue;*/
		 jsonObject = getChartTemplate("p"+i+".json");
		 Float data = 0.0f;
		 if(i<28) {
			 data = paras1.get(i-20);
		 }else {
			 data = paras2.get(i-28);
		 }
		 jsonString = parseP2XReport(jsonObject,data);
		 logger.debug("p"+i+":"+jsonString);
		 isSuccess = EChartsUtil.generateEChartsImage(jsonString, OUT_DIR+"p"+i+".png");
		if(isSuccess) {
			logger.info("p"+i+"生成成功");
		}else {
			logger.info("p"+i+"生成成功");
		}
		}
		
		//System.out.println(jsonString);
	}
	private String parseP2XReport(JSONObject jsonObject, Float  data) {
		JSONArray ydatas =(JSONArray)jsonObject.getJSONArray("series").getJSONObject(0).get("data");
	    ydatas.getJSONObject(0).put("value", data);
		return jsonObject.toString().replaceAll("\"", "'");
	}
	private String parseP1Report(JSONObject jsonObject, List<Integer> data) {
		JSONArray ydatas =(JSONArray)jsonObject.getJSONArray("series").getJSONObject(0).get("data");
		for(Object obj: data) {
		ydatas.put(obj);
		}
		return jsonObject.toString().replaceAll("\"", "'");
	}
	public JSONObject getChartTemplate(String tempFile) throws IOException {
		String ROOT_PATH = PdfReport.class.getResource("/").getPath();
		String input = FileUtils.readFileToString(new File(ROOT_PATH+tempFile), "UTF-8");
		JSONObject jsonObject = new JSONObject(input);
		return jsonObject;
	}
	public String getChartTemplateString(String tempFile) throws IOException {
		String ROOT_PATH = PdfReport.class.getResource("/").getPath();
		String input = FileUtils.readFileToString(new File(ROOT_PATH+tempFile), "UTF-8");
		
		return input;
	}
	public String createPsyQualityReport(PsyQualityRep obj,String outDir) {
		 OUT_DIR = ROOT_PATH + outDir +"\\";
		    File file = new File(OUT_DIR);
		    if(!file.exists()) {
		    	file.mkdir();
		    }else {
		    	file.delete();
		    	file.mkdir();
		    }
			try {
				logger.debug("正在准备所需的图表");
				generatePsyCharts(obj);
				logger.debug("图表准备完毕");
				PdfDocument pdfDoc = new PdfDocument(new PdfReader(ROOT_PATH+psyQualityReportTemplate), new PdfWriter(OUT_DIR+psyQualityReport));
				InputStream inputStream = PdfReport.class.getResource(pdfFontFile).openStream();
				PdfFont pdfFont = PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);
				//填充form
				logger.debug("开始填充模板表单");
				PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
				Map<String, PdfFormField> fields = form.getFormFields();
				PdfFormField field;
				for(int i=0; i<50; i++) {
					logger.debug("正在填充第"+i+"表单域");
					
			
						field = fields.get("r"+i);
				
					PdfTextFormField txtField = (PdfTextFormField)field;
				
					
				
					/*txtField.setMaxLen(20);*/
					txtField.setFont(pdfFont);
					
					Method method = obj.getClass().getMethod("getR"+i);
					if(i==14 || i==21 || i==32 || i == 39) {
						continue;
					}
					String value = (String) method.invoke(obj);
					if(i==16 || i==18 || i==20 || i==23 || i==25 || i==27 || i==29 || i==31 || i==34 || i==36 || i==38 || i==41 || i==43 || i==45
							|| i==47 || i==49) {
						txtField.setJustification(PdfFormField.ALIGN_LEFT);
						txtField.setMultiline(true);
						StringBuilder sb = new StringBuilder();
						sb.append(value);
						for(int j=21; j<sb.length();j+=23){
							
							sb.insert(j, "\n\n");
							
							}
						value = sb.toString();
					}else {
						txtField.setMultiline(false);
					}
					if(value=="高分") {
						txtField.setBackgroundColor(new DeviceRgb(0,176,80));
						txtField.setColor(Color.WHITE);
					}else if(value=="低分") {
						txtField.setBackgroundColor(new DeviceRgb(190, 0, 0));
						txtField.setColor(Color.WHITE);
					}else{
						txtField.setBackgroundColor(Color.WHITE);
						txtField.setColor(Color.BLACK);
					}
					txtField.setValue(value!=null?value:"");
				}
				logger.debug("结束填充模板表单");
				
				//依次处理每一页的报告
				
				logger.debug("正在插入图表");
				PdfPage currentPage = pdfDoc.getPage(5);
				PdfCanvas  canvas = new PdfCanvas(currentPage);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p2.png"),80,150,400,true);
				
				currentPage = pdfDoc.getPage(7);
				canvas = new PdfCanvas(currentPage);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p3.png"),80,200,400,true);
				
				currentPage = pdfDoc.getPage(9);
				canvas = new PdfCanvas(currentPage);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p4.png"),80,150,400,true);
				
				currentPage = pdfDoc.getPage(11);
				canvas = new PdfCanvas(currentPage);
				canvas.addImage(ImageDataFactory.create(OUT_DIR+"p5.png"),80,100,400,true);
				/*Document doc = new Document(pdfDoc, pdfDoc.getDefaultPageSize().A4);
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); 
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
				doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
				
				
				doc.close();*/
				pdfDoc.close();
				
			} catch (FileNotFoundException e) {
				logger.error("未发现模板或字体文件"+e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("模板或字体文件读写错误"+e.getMessage());
			}catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				logger.error("调用的方法不存在"+e.getMessage());
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				logger.error("调用的方法异常"+e.getMessage());
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				logger.error("非法访问"+e.getMessage());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				logger.error("不合法参数"+e.getMessage());
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				logger.error("调用异常"+e.getMessage());
			}
		

		return OUT_DIR+ psyQualityReport;
	}
	private String parsePsyReport(JSONObject jsonObject, List<Integer> data) {
		JSONArray ydatas =(JSONArray)jsonObject.getJSONArray("series").getJSONObject(0).get("data");
		for(Object obj: data) {
		ydatas.put(obj);
		}
		return jsonObject.toString().replaceAll("\"", "'");
	}
	public void generatePsyCharts(PsyQualityRep obj) throws IOException {
		JSONObject jsonObject;
		String jsonString="";
		boolean isSuccess;
		 List<Integer> pData1 = obj.getR14();
		 List<Integer> pData2 = obj.getR21();
		 List<Integer> pData3 = obj.getR32();
		 List<Integer> pData4 = obj.getR39();
		for(int i=2; i<6; i++) {
			/*if(i!=21) continue;*/
		 jsonObject = getChartTemplate("p"+i+".json");
		
		 if(i==2) {
			 jsonString = parsePsyReport(jsonObject,pData1);
		 }else if(i==3) {
			 jsonString = parsePsyReport(jsonObject,pData2);
		 }else if(i==4) {
			 jsonString = parsePsyReport(jsonObject,pData3);
		 }else if(i==5) {
			 jsonString = parsePsyReport(jsonObject,pData4);
		 }
		 logger.debug("p"+i+":"+jsonString);
		 isSuccess = EChartsUtil.generateEChartsImage(jsonString, OUT_DIR+"p"+i+".png");
		if(isSuccess) {
			logger.info("p"+i+"生成成功");
		}else {
			logger.info("p"+i+"生成成功");
		}
		}
	
	}
    private void generateClsPbCharts(ClsProBlmRep obj)throws IOException {
    	
    }
    
	public String createClsProBlmReport(ClsProBlmRep obj, String outDir) {
		 OUT_DIR = ROOT_PATH + outDir +"\\";
		   File file = new File(OUT_DIR);
		    if(!file.exists()) {
		    	file.mkdir();
		    }else {
		    	file.delete();
		    	file.mkdir();
		    }
			try {
				logger.debug("正在准备所需的图表");
				generateClsPbCharts(obj);
				logger.debug("图表准备完毕");
				PdfDocument pdfDoc = new PdfDocument(new PdfReader(ROOT_PATH+clsProblemBehaviorReportTemplate), new PdfWriter(OUT_DIR+clsProblemBehaviorReport));
				InputStream inputStream = PdfReport.class.getResource(pdfFontFile).openStream();
				PdfFont pdfFont = PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);//PdfFontFactory.createFont("Arial", "UniGB-UCS2-H",true);//PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);
				//填充form
				logger.debug("开始填充模板表单");
				PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
				Map<String, PdfFormField> fields = form.getFormFields();
			//	Set<String> keys = fields.keySet();
				PdfFormField field;
				for(int i=0; i<78; i++) {
					logger.debug("正在填充第"+i+"表单域");
					field = fields.get("r"+i);
					PdfTextFormField txtField = (PdfTextFormField)field;
				  
					
				
					/*txtField.setMaxLen(20);*/
					txtField.setFont(pdfFont);
					
					Method method = obj.getClass().getMethod("getR"+i);
				
					String value = (String) method.invoke(obj);
					if(i<16) {
						txtField.setMultiline(false);
						
				
					}else {
						txtField.setJustification(PdfFormField.ALIGN_LEFT);
						txtField.setMultiline(true);
					}
				
					txtField.setValue(value!=null?value:"");
			
					
				}
				
				logger.debug("结束填充模板表单");
				
				//依次处理每一页的报告
				
				logger.debug("正在插入图表");
				
				
			
				pdfDoc.close();
				
			} catch (FileNotFoundException e) {
				logger.error("未发现模板或字体文件"+e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("模板或字体文件读写错误"+e.getMessage());
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				logger.error("调用的方法不存在"+e.getMessage());
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				logger.error("调用的方法异常"+e.getMessage());
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				logger.error("非法访问"+e.getMessage());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				logger.error("不合法参数"+e.getMessage());
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				logger.error("调用异常"+e.getMessage());
			}
		

		return OUT_DIR+"/"+clsProblemBehaviorReport;
	}
	private void generateClsPsyCharts(ClsPsyRep obj)throws IOException {
    	
    }
	public String createClsPsyQualityReport(ClsPsyRep obj, String outDir) {
		// TODO Auto-generated method stub
		OUT_DIR = ROOT_PATH + outDir +"\\";
		   File file = new File(OUT_DIR);
		    if(!file.exists()) {
		    	file.mkdir();
		    }else {
		    	file.delete();
		    	file.mkdir();
		    }
			try {
				logger.debug("正在准备所需的图表");
				generateClsPsyCharts(obj);
				logger.debug("图表准备完毕");
				PdfDocument pdfDoc = new PdfDocument(new PdfReader(ROOT_PATH+clsPsyQualityReportTemplate), new PdfWriter(OUT_DIR+clsPsyQualityReport));
				InputStream inputStream = PdfReport.class.getResource(pdfFontFile).openStream();
				PdfFont pdfFont = PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);//PdfFontFactory.createFont("Arial", "UniGB-UCS2-H",true);//PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);
				//填充form
				logger.debug("开始填充模板表单");
				PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
				Map<String, PdfFormField> fields = form.getFormFields();
			//	Set<String> keys = fields.keySet();
				PdfFormField field;
				for(int i=0; i<59; i++) {
					logger.debug("正在填充第"+i+"表单域");
					field = fields.get("r"+i);
					PdfTextFormField txtField = (PdfTextFormField)field;
				
					
				
					/*txtField.setMaxLen(20);*/
					txtField.setFont(pdfFont);
					
					Method method = obj.getClass().getMethod("getR"+i);
					if(i==16 || i==18 || i==53 || i == 56 || i==58 || i==55) {
						continue;
					}
					String value = (String) method.invoke(obj);
					
				}
				
				logger.debug("结束填充模板表单");
				
				//依次处理每一页的报告
				
				logger.debug("正在插入图表");
				
				
			
				pdfDoc.close();
				
			} catch (FileNotFoundException e) {
				logger.error("未发现模板或字体文件"+e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("模板或字体文件读写错误"+e.getMessage());
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				logger.error("调用的方法不存在"+e.getMessage());
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				logger.error("调用的方法异常"+e.getMessage());
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				logger.error("非法访问"+e.getMessage());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				logger.error("不合法参数"+e.getMessage());
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				logger.error("调用异常"+e.getMessage());
			}
		

		return OUT_DIR+"/"+clsPsyQualityReport;
	}
}
