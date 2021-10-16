
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Test 개발용 Controller
 * 
 * @author Administrator
 *
 */
@Controller
public class TestIndexController {
		
	// 데이터를 추출하여 ExcelView에 전달한다. 
	@RequestMapping(value = "/test/excelReport.co") 
	public ExcelView excelReport(Model model) { 
		
		// 차트를 만들기 위한 통계자료 
		List<Map<String, Object>> listStat = new ArrayList<Map<String, Object>>();		
		Map<String, Object> mapStat = null; 		
		
		// 통계자료 공통정보
		String excelTitle = "판매현황";
		String inputYear = "2021";
		String inputMonth = "10";
		
		// 월합계 데이타 저장변수
		int sumCount = 0;
		int sumMember = 0;
		
		// 가상데이타 생성위한 랜덤변수
		Random rnd = new Random();
		
		// 예제를 위해 한달 1일 ~ 30일까지 가상 데이타 생성 및 저장
		// 실제는 DB또는 Json 연동으로 Data를 읽어서 처리한다.
		for(int i=1; i<=30; i++) {
			
			mapStat = new HashMap<String, Object>();
			mapStat.put("date", (i < 10 ? "0"+i : i)); 
			mapStat.put("count", rnd.nextInt(100)); 
			mapStat.put("member", rnd.nextInt(50)); 	
			listStat.add(mapStat); 
			
			sumCount += Integer.parseInt(mapStat.get("count").toString());
			sumMember += Integer.parseInt(mapStat.get("member").toString());
		}
		
		// 통계정보
		model.addAttribute("title", excelTitle); 
		model.addAttribute("year", inputYear); 
		model.addAttribute("month", inputMonth);		
			
		// 합계
		Map<String, Object> mapSum = new HashMap<String, Object>(); 
		mapSum.put("count", sumCount); 
		mapSum.put("member", sumMember); 
		model.addAttribute("sum", mapSum);  
		
		// 일평균
		Map<String, Object> mapAvg = new HashMap<String, Object>(); 
		mapAvg.put("count", new Double (sumCount/30)); 
		mapAvg.put("member", new Double(sumMember/30)); 
		model.addAttribute("avg", mapAvg); 		
		
		// 데이터 저장 
		model.addAttribute("stat", listStat); 
		
		// 엑셀 출력
		return new ExcelView(excelTitle+"_"+inputYear+inputMonth+"_리포트", "excel_template_test.xls");		
	}	
		
}
