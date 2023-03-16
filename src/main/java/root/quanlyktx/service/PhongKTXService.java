package root.quanlyktx.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.quanlyktx.dto.PhongKTXDTO;
import root.quanlyktx.dto.StudentDto;
import root.quanlyktx.entity.Student;
import root.quanlyktx.model.ViewInforRoom;
import root.quanlyktx.entity.LoaiKTX;
import root.quanlyktx.entity.PhongKTX;
import root.quanlyktx.repository.LoaiKTXRepository;
import root.quanlyktx.repository.PhongKTXRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhongKTXService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    PhongKTXRepository phongKTXRepository;
    @Autowired
    MapperToDTOService mapperToDTOService;
    @Autowired
    HopDongKTXService hopDongKTXService;
    @Autowired
    LoaiKTXRepository loaiKTXRepository;
    @Autowired
    StudentService studentService;

    public String addPhongKTX(PhongKTXDTO phongKTXDTO){

        try{
            phongKTXRepository.save(modelMapper.map(phongKTXDTO, PhongKTX.class));
            return "success";
        }catch (Exception e){
            e.getStackTrace();
            return "error";
        }
    }


    public boolean deletePhongKTX(Integer id){
        PhongKTX phongKTX=phongKTXRepository.findById(id).get();
        if(phongKTXRepository.findById(id).isPresent()){
            phongKTXRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public PhongKTXDTO updatePhongKTX(Integer id, PhongKTXDTO phongKTXDTO){
        if(phongKTXRepository.existsById(id)){
            try{
                PhongKTX phongKTX_root= phongKTXRepository.findById(id).get();
                phongKTX_root.setIdLoaiKTX(phongKTXDTO.getIdLoaiKTX());
           //     phongKTX_root.setHinhAnh(phongKTX.getHinhAnh());
                phongKTXRepository.save(phongKTX_root);
                return modelMapper.map(phongKTX_root, PhongKTXDTO.class);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        return null;
    }


    public List<PhongKTXDTO> getALL(){
        List<PhongKTX> phongKTXList = phongKTXRepository.findAll();
        return phongKTXList.stream().map(phongKTX -> modelMapper.map(phongKTX, PhongKTXDTO.class)).collect(Collectors.toList());
    }

    public PhongKTXDTO getById(Integer id){
        PhongKTX phongKTX = phongKTXRepository.findById(id).get();
        return modelMapper.map(phongKTX, PhongKTXDTO.class);
    }
    public List<PhongKTXDTO> getAllByLoaiPhong(Integer id){
        List<PhongKTX>phongKTXList=phongKTXRepository.findAllByIdLoaiKTX(id);
        return phongKTXList.stream()
                .map(phongKTX -> modelMapper.map(phongKTX, PhongKTXDTO.class))
                .collect(Collectors.toList());
    }


//    public ViewInforRoom getViewInforRoom(Integer idPhongKTX){
//        PhongKTXDTO phongKTXDTO = findPhongKTXById(idPhongKTX);
//        LoaiKTX loaiKTX = phongKTXDTO.getLoaiKTX();
//        return new ViewInforRoom(phongKTXDTO.getId(),loaiKTX,hopDongKTXService.numBedEmpty(idPhongKTX));
//    }
}
