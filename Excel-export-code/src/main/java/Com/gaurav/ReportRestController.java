package Com.gaurav;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportRestController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/create")
    public ResponseDto Save(@RequestBody Model m) {


        return reportService.Create(m);
    }

    @GetMapping("/excel")
    public void generateExcelReport(HttpServletResponse response) throws Exception {
        //file need to be downloaded
        //file is sent to client
        response.setContentType("application/octet-stream");
        //how do you by key and value
        //`inline' and `attachment'. 'Inline' indicates that the entity should be
        // immediately displayed to the user, whereas `attachment'
        // means that the user should take additional action to view the entity.
        String headerKey = "Content-Disposition";
        //we have attachment aNd excel file name
        String headerValue = "attachment;filename=courses.xls";

        response.setHeader(headerKey, headerValue);

        reportService.generateExcel(response);

        response.flushBuffer();
    }

}
