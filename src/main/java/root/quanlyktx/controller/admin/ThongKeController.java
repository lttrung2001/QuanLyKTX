package root.quanlyktx.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import root.quanlyktx.service.HopDongKTXService;
import root.quanlyktx.service.PhongKTXService;
import root.quanlyktx.service.ThongKeService;

@RestController
@RequestMapping("api/analysis")
public class ThongKeController {
    @Autowired
    ThongKeService thongKeService;


    @GetMapping("/studentInTerm")
    public ResponseEntity<?> getAmountStudentInTerm(){
        return thongKeService.getAmountStudentInTerm();
    }
//    @GetMapping("/gender")
//    public ResponseEntity<?> gender(){ return thongKeService.getAmountGender();}
    @GetMapping("/room")
    public ResponseEntity<?> roomStatistics(){
        return thongKeService.getRoomStatistics();
    }

    @GetMapping("/money")
    public ResponseEntity<?> totalMoneyInCurTerm(){
        return thongKeService.getTotalMoneyInCurTerm();
    }

    @GetMapping("/loaiKTX")
    public ResponseEntity<?> studentRoomType(){
        return thongKeService.getStudentsOfRoomTypes();
    }
//    @GetMapping("/totalMoneyIn")
}
