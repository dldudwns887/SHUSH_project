package com.example.demoproject.Repository;

import com.example.demoproject.entity.FrontEntranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                      //상속할때 <엔티티, 기본키의 타입>
public interface FrontEntranceRepository extends JpaRepository<FrontEntranceEntity, String> {


}
