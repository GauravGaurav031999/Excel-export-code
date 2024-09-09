package Com.gaurav;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ResponseDto dto;




	public void generateExcel(HttpServletResponse response) throws Exception {

		List<Course> courses = courseRepo.findAll();
//workbook ,sheet  ,row  present in Apache poi(poor obfuscation Implementation -it functions for excel and PowerPoint) maven poi dependency
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Courses Info");
		//1st row is the oth position present in excel sheet
		HSSFRow row = sheet.createRow(0);
//1st row in 0th position headers present in excel sheet
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Price");
		row.createCell(3).setCellValue("Brand");
		//2nd row where we are entering data in 1st position of excel sheet
		int dataRowIndex = 1;
//using foreach loop for getting list  from entity course
		for (Course course : courses) {
			//based on index we create data row
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(course.getCid());
			dataRow.createCell(1).setCellValue(course.getName());
			dataRow.createCell(2).setCellValue(course.getPrice());
			dataRow.createCell(3).setCellValue(course.getBrand());
			//To enter into next row we are using increment operations
			dataRowIndex++;
		}
     //to get output response winding with workbook and closing it
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();

	}

	public ResponseDto Create(Model m) {
		Course c =new Course();
		c.setCid(m.getCid());
		c.setName(m.getName());
		c.setPrice(m.getPrice());
		c.setBrand(m.getBrand());
		courseRepo.save(c);
       dto.setMsg("data inserted"+" "+courseRepo.save(c));
		return dto;
	}
}
