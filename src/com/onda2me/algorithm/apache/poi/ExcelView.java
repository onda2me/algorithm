import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import net.sf.jxls.transformer.XLSTransformer;


/**
 * 
 * 데이타를 Excel파일로 변환하기 위한 Class
 * 
 * @author Administrator
 *
 */
public class ExcelView extends AbstractExcelView { 
		
	
	//private Logger logger = LoggerFactory.getLogger(ExcelView.class);
	
	private String fileName = null;
	private String templateName = null;
	
	public ExcelView (String _fileName, String _templateName) {
		
		this.fileName = _fileName;
		this.templateName = _templateName;
		
	}
	

	@Override 
	protected void buildExcelDocument(Map<String, Object> data, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception { 
			
		response.setHeader("Content-Type", "application/octet-stream"); 
		response.setHeader("Content-Disposition", "attachment; filename="+java.net.URLEncoder.encode(fileName, "UTF-8")+DateUtil.getDate("mmss")+".xls");
		
		OutputStream os = null; 
		InputStream is = null; 
		try { 
			
			// 엑셀 템플릿 파일이 존재하는 위치  		
			// E:\eclipse\workspace\project\src\main\webapp\statics\template
			String templatePath = ConfigUtil.getString("template-dir");

			// template 파일을 읽는다.
			is = new FileInputStream(templatePath + templateName);
			os = response.getOutputStream();
			
			// XLSTransformer를 이용하여 Controller의 data를 읽어 template파일에 맵핑시킨다.
			XLSTransformer transformer = new XLSTransformer(); 
			Workbook excel = transformer.transformXLS(is, data); 
			
			os.flush();
			excel.write(os); 
			os.flush();
			
			
		} catch (IOException e) { 
			e.printStackTrace(); 
			
			throw new RuntimeException(e.getMessage()); 
		} finally {
			
			if(os != null) try { os.close(); } catch (IOException e) { } 
			if(is != null) try { is.close(); } catch (IOException e) { } 
		} 
	}

	public ExcelView() {
		super();
		// TODO Auto-generated constructor stub
	}
}	
