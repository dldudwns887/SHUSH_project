package com.example.demoproject.Controller;

import com.example.demoproject.Repository.AEntranceRepository;
import com.example.demoproject.Entity.AEntranceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(originPatterns = "http://localhost:3000")

@RestController//해당 클래스를 Controller 레이어로 인식하게함//@Controller+@REsponseBody임



@RequestMapping(value= "/*")//()안에 URL패턴이 오고 - request왔을때 request의 url의 패턴을 보고 해당하는 클래스를 실행
public class MainController {
    @Autowired
    private AEntranceRepository frontEntranceRepository;


    @GetMapping("data")
    public List<AEntranceEntity> data(){
        return frontEntranceRepository.findAll();
    }

}